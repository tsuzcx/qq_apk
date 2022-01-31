package com.facebook.login;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceAuthDialog
  extends DialogFragment
{
  private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
  private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
  private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
  private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
  private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
  private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
  private static final String REQUEST_STATE_KEY = "request_state";
  private AtomicBoolean completed;
  private TextView confirmationCode;
  private volatile GraphRequestAsyncTask currentGraphRequestPoll;
  private volatile DeviceAuthDialog.RequestState currentRequestState;
  private DeviceAuthMethodHandler deviceAuthMethodHandler;
  private Dialog dialog;
  private TextView instructions;
  private boolean isBeingDestroyed;
  private boolean isRetry;
  private LoginClient.Request mRequest;
  private View progressBar;
  private volatile ScheduledFuture scheduledPoll;
  
  public DeviceAuthDialog()
  {
    AppMethodBeat.i(96726);
    this.completed = new AtomicBoolean();
    this.isBeingDestroyed = false;
    this.isRetry = false;
    this.mRequest = null;
    AppMethodBeat.o(96726);
  }
  
  private void completeLogin(String paramString1, Utility.PermissionsPair paramPermissionsPair, String paramString2, Date paramDate1, Date paramDate2)
  {
    AppMethodBeat.i(96740);
    this.deviceAuthMethodHandler.onSuccess(paramString2, FacebookSdk.getApplicationId(), paramString1, paramPermissionsPair.getGrantedPermissions(), paramPermissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, paramDate1, null, paramDate2);
    this.dialog.dismiss();
    AppMethodBeat.o(96740);
  }
  
  private GraphRequest getPollRequest()
  {
    AppMethodBeat.i(96737);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("code", this.currentRequestState.getRequestCode());
    localObject = new GraphRequest(null, "device/login_status", (Bundle)localObject, HttpMethod.POST, new DeviceAuthDialog.4(this));
    AppMethodBeat.o(96737);
    return localObject;
  }
  
  private void onSuccess(String paramString, Long paramLong1, Long paramLong2)
  {
    AppMethodBeat.i(96739);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,permissions,name");
    if (paramLong1.longValue() != 0L)
    {
      paramLong1 = new Date(new Date().getTime() + paramLong1.longValue() * 1000L);
      if ((paramLong2.longValue() == 0L) || (paramLong2 == null)) {
        break label147;
      }
    }
    label147:
    for (paramLong2 = new Date(paramLong2.longValue() * 1000L);; paramLong2 = null)
    {
      new GraphRequest(new AccessToken(paramString, FacebookSdk.getApplicationId(), "0", null, null, null, paramLong1, null, paramLong2), "me", localBundle, HttpMethod.GET, new DeviceAuthDialog.7(this, paramString, paramLong1, paramLong2)).executeAsync();
      AppMethodBeat.o(96739);
      return;
      paramLong1 = null;
      break;
    }
  }
  
  private void poll()
  {
    AppMethodBeat.i(96735);
    this.currentRequestState.setLastPoll(new Date().getTime());
    this.currentGraphRequestPoll = getPollRequest().executeAsync();
    AppMethodBeat.o(96735);
  }
  
  private void presentConfirmation(String paramString1, Utility.PermissionsPair paramPermissionsPair, String paramString2, String paramString3, Date paramDate1, Date paramDate2)
  {
    AppMethodBeat.i(96738);
    String str1 = getResources().getString(2131296326);
    Object localObject = getResources().getString(2131296325);
    String str2 = getResources().getString(2131296324);
    paramString3 = String.format((String)localObject, new Object[] { paramString3 });
    localObject = new AlertDialog.Builder(getContext());
    ((AlertDialog.Builder)localObject).setMessage(str1).setCancelable(true).setNegativeButton(paramString3, new DeviceAuthDialog.6(this, paramString1, paramPermissionsPair, paramString2, paramDate1, paramDate2)).setPositiveButton(str2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(96715);
        paramAnonymousDialogInterface = DeviceAuthDialog.this.initializeContentView(false);
        DeviceAuthDialog.this.dialog.setContentView(paramAnonymousDialogInterface);
        DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
        AppMethodBeat.o(96715);
      }
    });
    ((AlertDialog.Builder)localObject).create().show();
    AppMethodBeat.o(96738);
  }
  
  private void schedulePoll()
  {
    AppMethodBeat.i(96736);
    this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new DeviceAuthDialog.3(this), this.currentRequestState.getInterval(), TimeUnit.SECONDS);
    AppMethodBeat.o(96736);
  }
  
  private void setCurrentRequestState(DeviceAuthDialog.RequestState paramRequestState)
  {
    AppMethodBeat.i(96733);
    this.currentRequestState = paramRequestState;
    this.confirmationCode.setText(paramRequestState.getUserCode());
    Object localObject = DeviceRequestsHelper.generateQRCode(paramRequestState.getAuthorizationUri());
    localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
    this.instructions.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
    this.confirmationCode.setVisibility(0);
    this.progressBar.setVisibility(8);
    if ((!this.isRetry) && (DeviceRequestsHelper.startAdvertisementService(paramRequestState.getUserCode()))) {
      AppEventsLogger.newLogger(getContext()).logSdkEvent("fb_smart_login_service", null, null);
    }
    if (paramRequestState.withinLastRefreshWindow())
    {
      schedulePoll();
      AppMethodBeat.o(96733);
      return;
    }
    poll();
    AppMethodBeat.o(96733);
  }
  
  protected int getLayoutResId(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130969188;
    }
    return 2130969186;
  }
  
  protected View initializeContentView(boolean paramBoolean)
  {
    AppMethodBeat.i(96734);
    View localView = getActivity().getLayoutInflater().inflate(getLayoutResId(paramBoolean), null);
    this.progressBar = localView.findViewById(2131821119);
    this.confirmationCode = ((TextView)localView.findViewById(2131822962));
    ((Button)localView.findViewById(2131822964)).setOnClickListener(new DeviceAuthDialog.2(this));
    this.instructions = ((TextView)localView.findViewById(2131822963));
    this.instructions.setText(Html.fromHtml(getString(2131296305)));
    AppMethodBeat.o(96734);
    return localView;
  }
  
  protected void onCancel()
  {
    AppMethodBeat.i(96742);
    if (!this.completed.compareAndSet(false, true))
    {
      AppMethodBeat.o(96742);
      return;
    }
    if (this.currentRequestState != null) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
    }
    if (this.deviceAuthMethodHandler != null) {
      this.deviceAuthMethodHandler.onCancel();
    }
    this.dialog.dismiss();
    AppMethodBeat.o(96742);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(96728);
    this.dialog = new Dialog(getActivity(), 2131493859);
    if ((DeviceRequestsHelper.isAvailable()) && (!this.isRetry)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle = initializeContentView(bool);
      this.dialog.setContentView(paramBundle);
      paramBundle = this.dialog;
      AppMethodBeat.o(96728);
      return paramBundle;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(96727);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.deviceAuthMethodHandler = ((DeviceAuthMethodHandler)((LoginFragment)((FacebookActivity)getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler());
    if (paramBundle != null)
    {
      paramViewGroup = (DeviceAuthDialog.RequestState)paramBundle.getParcelable("request_state");
      if (paramViewGroup != null) {
        setCurrentRequestState(paramViewGroup);
      }
    }
    AppMethodBeat.o(96727);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(96731);
    this.isBeingDestroyed = true;
    this.completed.set(true);
    super.onDestroy();
    if (this.currentGraphRequestPoll != null) {
      this.currentGraphRequestPoll.cancel(true);
    }
    if (this.scheduledPoll != null) {
      this.scheduledPoll.cancel(true);
    }
    AppMethodBeat.o(96731);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(96729);
    super.onDismiss(paramDialogInterface);
    if (!this.isBeingDestroyed) {
      onCancel();
    }
    AppMethodBeat.o(96729);
  }
  
  protected void onError(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96741);
    if (!this.completed.compareAndSet(false, true))
    {
      AppMethodBeat.o(96741);
      return;
    }
    if (this.currentRequestState != null) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
    }
    this.deviceAuthMethodHandler.onError(paramFacebookException);
    this.dialog.dismiss();
    AppMethodBeat.o(96741);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(96730);
    super.onSaveInstanceState(paramBundle);
    if (this.currentRequestState != null) {
      paramBundle.putParcelable("request_state", this.currentRequestState);
    }
    AppMethodBeat.o(96730);
  }
  
  public void startLogin(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96732);
    this.mRequest = paramRequest;
    Bundle localBundle = new Bundle();
    localBundle.putString("scope", TextUtils.join(",", paramRequest.getPermissions()));
    String str = paramRequest.getDeviceRedirectUriString();
    if (str != null) {
      localBundle.putString("redirect_uri", str);
    }
    paramRequest = paramRequest.getDeviceAuthTargetUserId();
    if (paramRequest != null) {
      localBundle.putString("target_user_id", paramRequest);
    }
    localBundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
    localBundle.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
    new GraphRequest(null, "device/login", localBundle, HttpMethod.POST, new DeviceAuthDialog.1(this)).executeAsync();
    AppMethodBeat.o(96732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog
 * JD-Core Version:    0.7.0.1
 */