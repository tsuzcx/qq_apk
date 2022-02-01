package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment
  extends DialogFragment
{
  private static final String DEVICE_SHARE_ENDPOINT = "device/share";
  private static final String EXTRA_ERROR = "error";
  private static final String REQUEST_STATE_KEY = "request_state";
  public static final String TAG = "DeviceShareDialogFragment";
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  private volatile ScheduledFuture codeExpiredFuture;
  private TextView confirmationCode;
  private volatile DeviceShareDialogFragment.RequestState currentRequestState;
  private Dialog dialog;
  private ProgressBar progressBar;
  private ShareContent shareContent;
  
  private void detach()
  {
    AppMethodBeat.i(7991);
    if (isAdded()) {
      getFragmentManager().beginTransaction().a(this).commit();
    }
    AppMethodBeat.o(7991);
  }
  
  private void finishActivity(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(7990);
    if (this.currentRequestState != null) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
    }
    Object localObject = (FacebookRequestError)paramIntent.getParcelableExtra("error");
    if (localObject != null) {
      Toast.makeText(getContext(), ((FacebookRequestError)localObject).getErrorMessage(), 0).show();
    }
    if (isAdded())
    {
      localObject = getActivity();
      ((Activity)localObject).setResult(paramInt, paramIntent);
      ((Activity)localObject).finish();
    }
    AppMethodBeat.o(7990);
  }
  
  private void finishActivityWithError(FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(7994);
    detach();
    Intent localIntent = new Intent();
    localIntent.putExtra("error", paramFacebookRequestError);
    finishActivity(-1, localIntent);
    AppMethodBeat.o(7994);
  }
  
  private static ScheduledThreadPoolExecutor getBackgroundExecutor()
  {
    try
    {
      AppMethodBeat.i(7995);
      if (backgroundExecutor == null) {
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      }
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
      AppMethodBeat.o(7995);
      return localScheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  private Bundle getGraphParametersForShareContent()
  {
    AppMethodBeat.i(7992);
    Object localObject = this.shareContent;
    if (localObject == null)
    {
      AppMethodBeat.o(7992);
      return null;
    }
    if ((localObject instanceof ShareLinkContent))
    {
      localObject = WebDialogParameters.create((ShareLinkContent)localObject);
      AppMethodBeat.o(7992);
      return localObject;
    }
    if ((localObject instanceof ShareOpenGraphContent))
    {
      localObject = WebDialogParameters.create((ShareOpenGraphContent)localObject);
      AppMethodBeat.o(7992);
      return localObject;
    }
    AppMethodBeat.o(7992);
    return null;
  }
  
  private void setCurrentRequestState(DeviceShareDialogFragment.RequestState paramRequestState)
  {
    AppMethodBeat.i(7996);
    this.currentRequestState = paramRequestState;
    this.confirmationCode.setText(paramRequestState.getUserCode());
    this.confirmationCode.setVisibility(0);
    this.progressBar.setVisibility(8);
    this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(7979);
        DeviceShareDialogFragment.this.dialog.dismiss();
        AppMethodBeat.o(7979);
      }
    }, paramRequestState.getExpiresIn(), TimeUnit.SECONDS);
    AppMethodBeat.o(7996);
  }
  
  private void startShare()
  {
    AppMethodBeat.i(7993);
    Bundle localBundle = getGraphParametersForShareContent();
    if ((localBundle == null) || (localBundle.size() == 0)) {
      finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
    }
    localBundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
    localBundle.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
    new GraphRequest(null, "device/share", localBundle, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(7978);
        Object localObject = paramAnonymousGraphResponse.getError();
        if (localObject != null)
        {
          DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, (FacebookRequestError)localObject);
          AppMethodBeat.o(7978);
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        localObject = new DeviceShareDialogFragment.RequestState();
        try
        {
          ((DeviceShareDialogFragment.RequestState)localObject).setUserCode(paramAnonymousGraphResponse.getString("user_code"));
          ((DeviceShareDialogFragment.RequestState)localObject).setExpiresIn(paramAnonymousGraphResponse.getLong("expires_in"));
          DeviceShareDialogFragment.access$200(DeviceShareDialogFragment.this, (DeviceShareDialogFragment.RequestState)localObject);
          AppMethodBeat.o(7978);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceShareDialogFragment.access$100(DeviceShareDialogFragment.this, new FacebookRequestError(0, "", "Malformed server response"));
          AppMethodBeat.o(7978);
        }
      }
    }).executeAsync();
    AppMethodBeat.o(7993);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(7987);
    this.dialog = new Dialog(getActivity(), 2131821743);
    paramBundle = getActivity().getLayoutInflater().inflate(2131493684, null);
    this.progressBar = ((ProgressBar)paramBundle.findViewById(2131306284));
    this.confirmationCode = ((TextView)paramBundle.findViewById(2131299011));
    ((Button)paramBundle.findViewById(2131297964)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7977);
        DeviceShareDialogFragment.this.dialog.dismiss();
        AppMethodBeat.o(7977);
      }
    });
    ((TextView)paramBundle.findViewById(2131298917)).setText(Html.fromHtml(getString(2131757722)));
    this.dialog.setContentView(paramBundle);
    startShare();
    paramBundle = this.dialog;
    AppMethodBeat.o(7987);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(7986);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramBundle != null)
    {
      paramViewGroup = (DeviceShareDialogFragment.RequestState)paramBundle.getParcelable("request_state");
      if (paramViewGroup != null) {
        setCurrentRequestState(paramViewGroup);
      }
    }
    AppMethodBeat.o(7986);
    return paramLayoutInflater;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7988);
    super.onDismiss(paramDialogInterface);
    if (this.codeExpiredFuture != null) {
      this.codeExpiredFuture.cancel(true);
    }
    finishActivity(-1, new Intent());
    AppMethodBeat.o(7988);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(7989);
    super.onSaveInstanceState(paramBundle);
    if (this.currentRequestState != null) {
      paramBundle.putParcelable("request_state", this.currentRequestState);
    }
    AppMethodBeat.o(7989);
  }
  
  public void setShareContent(ShareContent paramShareContent)
  {
    this.shareContent = paramShareContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment
 * JD-Core Version:    0.7.0.1
 */