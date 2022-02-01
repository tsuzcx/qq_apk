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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

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
  private volatile RequestState currentRequestState;
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
    AppMethodBeat.i(7750);
    this.completed = new AtomicBoolean();
    this.isBeingDestroyed = false;
    this.isRetry = false;
    this.mRequest = null;
    AppMethodBeat.o(7750);
  }
  
  private void completeLogin(String paramString1, Utility.PermissionsPair paramPermissionsPair, String paramString2, Date paramDate1, Date paramDate2)
  {
    AppMethodBeat.i(7764);
    this.deviceAuthMethodHandler.onSuccess(paramString2, FacebookSdk.getApplicationId(), paramString1, paramPermissionsPair.getGrantedPermissions(), paramPermissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, paramDate1, null, paramDate2);
    this.dialog.dismiss();
    AppMethodBeat.o(7764);
  }
  
  private GraphRequest getPollRequest()
  {
    AppMethodBeat.i(7761);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("code", this.currentRequestState.getRequestCode());
    localObject = new GraphRequest(null, "device/login_status", (Bundle)localObject, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(7738);
        if (DeviceAuthDialog.this.completed.get())
        {
          AppMethodBeat.o(7738);
          return;
        }
        FacebookRequestError localFacebookRequestError = paramAnonymousGraphResponse.getError();
        if (localFacebookRequestError != null)
        {
          switch (localFacebookRequestError.getSubErrorCode())
          {
          default: 
            DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
            AppMethodBeat.o(7738);
            return;
          case 1349172: 
          case 1349174: 
            DeviceAuthDialog.access$400(DeviceAuthDialog.this);
            AppMethodBeat.o(7738);
            return;
          case 1349152: 
            if (DeviceAuthDialog.this.currentRequestState != null) {
              DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
            }
            if (DeviceAuthDialog.this.mRequest != null)
            {
              DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
              AppMethodBeat.o(7738);
              return;
            }
            DeviceAuthDialog.this.onCancel();
            AppMethodBeat.o(7738);
            return;
          }
          DeviceAuthDialog.this.onCancel();
          AppMethodBeat.o(7738);
          return;
        }
        try
        {
          paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
          DeviceAuthDialog.access$700(DeviceAuthDialog.this, paramAnonymousGraphResponse.getString("access_token"), Long.valueOf(paramAnonymousGraphResponse.getLong("expires_in")), Long.valueOf(paramAnonymousGraphResponse.optLong("data_access_expiration_time")));
          AppMethodBeat.o(7738);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
          AppMethodBeat.o(7738);
        }
      }
    });
    AppMethodBeat.o(7761);
    return localObject;
  }
  
  private void onSuccess(final String paramString, final Long paramLong1, final Long paramLong2)
  {
    AppMethodBeat.i(7763);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id,permissions,name");
    if (paramLong1.longValue() != 0L)
    {
      paramLong1 = new Date(new Date().getTime() + paramLong1.longValue() * 1000L);
      if ((paramLong2.longValue() == 0L) || (paramLong2 == null)) {
        break label149;
      }
    }
    label149:
    for (paramLong2 = new Date(paramLong2.longValue() * 1000L);; paramLong2 = null)
    {
      new GraphRequest(new AccessToken(paramString, FacebookSdk.getApplicationId(), "0", null, null, null, paramLong1, null, paramLong2), "me", localBundle, HttpMethod.GET, new GraphRequest.Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          AppMethodBeat.i(7741);
          if (DeviceAuthDialog.this.completed.get())
          {
            AppMethodBeat.o(7741);
            return;
          }
          if (paramAnonymousGraphResponse.getError() != null)
          {
            DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
            AppMethodBeat.o(7741);
            return;
          }
          Utility.PermissionsPair localPermissionsPair;
          try
          {
            Object localObject = paramAnonymousGraphResponse.getJSONObject();
            paramAnonymousGraphResponse = ((JSONObject)localObject).getString("id");
            localPermissionsPair = Utility.handlePermissionResponse((JSONObject)localObject);
            localObject = ((JSONObject)localObject).getString("name");
            DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
            if ((FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm)) && (!DeviceAuthDialog.this.isRetry))
            {
              DeviceAuthDialog.access$1002(DeviceAuthDialog.this, true);
              DeviceAuthDialog.access$1100(DeviceAuthDialog.this, paramAnonymousGraphResponse, localPermissionsPair, paramString, (String)localObject, paramLong1, paramLong2);
              AppMethodBeat.o(7741);
              return;
            }
          }
          catch (JSONException paramAnonymousGraphResponse)
          {
            DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
            AppMethodBeat.o(7741);
            return;
          }
          DeviceAuthDialog.access$900(DeviceAuthDialog.this, paramAnonymousGraphResponse, localPermissionsPair, paramString, paramLong1, paramLong2);
          AppMethodBeat.o(7741);
        }
      }).executeAsync();
      AppMethodBeat.o(7763);
      return;
      paramLong1 = null;
      break;
    }
  }
  
  private void poll()
  {
    AppMethodBeat.i(7759);
    this.currentRequestState.setLastPoll(new Date().getTime());
    this.currentGraphRequestPoll = getPollRequest().executeAsync();
    AppMethodBeat.o(7759);
  }
  
  private void presentConfirmation(final String paramString1, final Utility.PermissionsPair paramPermissionsPair, final String paramString2, String paramString3, final Date paramDate1, final Date paramDate2)
  {
    AppMethodBeat.i(7762);
    String str1 = getResources().getString(2131757743);
    Object localObject = getResources().getString(2131757742);
    String str2 = getResources().getString(2131757741);
    paramString3 = String.format((String)localObject, new Object[] { paramString3 });
    localObject = new AlertDialog.Builder(getContext());
    ((AlertDialog.Builder)localObject).setMessage(str1).setCancelable(true).setNegativeButton(paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(7740);
        DeviceAuthDialog.access$900(DeviceAuthDialog.this, paramString1, paramPermissionsPair, paramString2, paramDate1, paramDate2);
        AppMethodBeat.o(7740);
      }
    }).setPositiveButton(str2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(7739);
        paramAnonymousDialogInterface = DeviceAuthDialog.this.initializeContentView(false);
        DeviceAuthDialog.this.dialog.setContentView(paramAnonymousDialogInterface);
        DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
        AppMethodBeat.o(7739);
      }
    });
    ((AlertDialog.Builder)localObject).create().show();
    AppMethodBeat.o(7762);
  }
  
  private void schedulePoll()
  {
    AppMethodBeat.i(7760);
    this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(7737);
        DeviceAuthDialog.access$200(DeviceAuthDialog.this);
        AppMethodBeat.o(7737);
      }
    }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
    AppMethodBeat.o(7760);
  }
  
  private void setCurrentRequestState(RequestState paramRequestState)
  {
    AppMethodBeat.i(7757);
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
      AppMethodBeat.o(7757);
      return;
    }
    poll();
    AppMethodBeat.o(7757);
  }
  
  protected int getLayoutResId(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131493686;
    }
    return 2131493684;
  }
  
  protected View initializeContentView(boolean paramBoolean)
  {
    AppMethodBeat.i(7758);
    View localView = getActivity().getLayoutInflater().inflate(getLayoutResId(paramBoolean), null);
    this.progressBar = localView.findViewById(2131306284);
    this.confirmationCode = ((TextView)localView.findViewById(2131299011));
    ((Button)localView.findViewById(2131297964)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7736);
        DeviceAuthDialog.this.onCancel();
        AppMethodBeat.o(7736);
      }
    });
    this.instructions = ((TextView)localView.findViewById(2131298917));
    this.instructions.setText(Html.fromHtml(getString(2131757722)));
    AppMethodBeat.o(7758);
    return localView;
  }
  
  protected void onCancel()
  {
    AppMethodBeat.i(7766);
    if (!this.completed.compareAndSet(false, true))
    {
      AppMethodBeat.o(7766);
      return;
    }
    if (this.currentRequestState != null) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
    }
    if (this.deviceAuthMethodHandler != null) {
      this.deviceAuthMethodHandler.onCancel();
    }
    this.dialog.dismiss();
    AppMethodBeat.o(7766);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(7752);
    this.dialog = new Dialog(getActivity(), 2131821743);
    if ((DeviceRequestsHelper.isAvailable()) && (!this.isRetry)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle = initializeContentView(bool);
      this.dialog.setContentView(paramBundle);
      paramBundle = this.dialog;
      AppMethodBeat.o(7752);
      return paramBundle;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(7751);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.deviceAuthMethodHandler = ((DeviceAuthMethodHandler)((LoginFragment)((FacebookActivity)getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler());
    if (paramBundle != null)
    {
      paramViewGroup = (RequestState)paramBundle.getParcelable("request_state");
      if (paramViewGroup != null) {
        setCurrentRequestState(paramViewGroup);
      }
    }
    AppMethodBeat.o(7751);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7755);
    this.isBeingDestroyed = true;
    this.completed.set(true);
    super.onDestroy();
    if (this.currentGraphRequestPoll != null) {
      this.currentGraphRequestPoll.cancel(true);
    }
    if (this.scheduledPoll != null) {
      this.scheduledPoll.cancel(true);
    }
    AppMethodBeat.o(7755);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7753);
    super.onDismiss(paramDialogInterface);
    if (!this.isBeingDestroyed) {
      onCancel();
    }
    AppMethodBeat.o(7753);
  }
  
  protected void onError(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(7765);
    if (!this.completed.compareAndSet(false, true))
    {
      AppMethodBeat.o(7765);
      return;
    }
    if (this.currentRequestState != null) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
    }
    this.deviceAuthMethodHandler.onError(paramFacebookException);
    this.dialog.dismiss();
    AppMethodBeat.o(7765);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(7754);
    super.onSaveInstanceState(paramBundle);
    if (this.currentRequestState != null) {
      paramBundle.putParcelable("request_state", this.currentRequestState);
    }
    AppMethodBeat.o(7754);
  }
  
  public void startLogin(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7756);
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
    new GraphRequest(null, "device/login", localBundle, HttpMethod.POST, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(7735);
        if (DeviceAuthDialog.this.isBeingDestroyed)
        {
          AppMethodBeat.o(7735);
          return;
        }
        if (paramAnonymousGraphResponse.getError() != null)
        {
          DeviceAuthDialog.this.onError(paramAnonymousGraphResponse.getError().getException());
          AppMethodBeat.o(7735);
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        DeviceAuthDialog.RequestState localRequestState = new DeviceAuthDialog.RequestState();
        try
        {
          localRequestState.setUserCode(paramAnonymousGraphResponse.getString("user_code"));
          localRequestState.setRequestCode(paramAnonymousGraphResponse.getString("code"));
          localRequestState.setInterval(paramAnonymousGraphResponse.getLong("interval"));
          DeviceAuthDialog.access$100(DeviceAuthDialog.this, localRequestState);
          AppMethodBeat.o(7735);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          DeviceAuthDialog.this.onError(new FacebookException(paramAnonymousGraphResponse));
          AppMethodBeat.o(7735);
        }
      }
    }).executeAsync();
    AppMethodBeat.o(7756);
  }
  
  static class RequestState
    implements Parcelable
  {
    public static final Parcelable.Creator<RequestState> CREATOR;
    private String authorizationUri;
    private long interval;
    private long lastPoll;
    private String requestCode;
    private String userCode;
    
    static
    {
      AppMethodBeat.i(7749);
      CREATOR = new Parcelable.Creator()
      {
        public final DeviceAuthDialog.RequestState createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(7742);
          paramAnonymousParcel = new DeviceAuthDialog.RequestState(paramAnonymousParcel);
          AppMethodBeat.o(7742);
          return paramAnonymousParcel;
        }
        
        public final DeviceAuthDialog.RequestState[] newArray(int paramAnonymousInt)
        {
          return new DeviceAuthDialog.RequestState[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(7749);
    }
    
    RequestState() {}
    
    protected RequestState(Parcel paramParcel)
    {
      AppMethodBeat.i(7746);
      this.authorizationUri = paramParcel.readString();
      this.userCode = paramParcel.readString();
      this.requestCode = paramParcel.readString();
      this.interval = paramParcel.readLong();
      this.lastPoll = paramParcel.readLong();
      AppMethodBeat.o(7746);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAuthorizationUri()
    {
      return this.authorizationUri;
    }
    
    public long getInterval()
    {
      return this.interval;
    }
    
    public String getRequestCode()
    {
      return this.requestCode;
    }
    
    public String getUserCode()
    {
      return this.userCode;
    }
    
    public void setInterval(long paramLong)
    {
      this.interval = paramLong;
    }
    
    public void setLastPoll(long paramLong)
    {
      this.lastPoll = paramLong;
    }
    
    public void setRequestCode(String paramString)
    {
      this.requestCode = paramString;
    }
    
    public void setUserCode(String paramString)
    {
      AppMethodBeat.i(7745);
      this.userCode = paramString;
      this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[] { paramString });
      AppMethodBeat.o(7745);
    }
    
    public boolean withinLastRefreshWindow()
    {
      AppMethodBeat.i(7747);
      if (this.lastPoll == 0L)
      {
        AppMethodBeat.o(7747);
        return false;
      }
      if (new Date().getTime() - this.lastPoll - this.interval * 1000L < 0L)
      {
        AppMethodBeat.o(7747);
        return true;
      }
      AppMethodBeat.o(7747);
      return false;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(7748);
      paramParcel.writeString(this.authorizationUri);
      paramParcel.writeString(this.userCode);
      paramParcel.writeString(this.requestCode);
      paramParcel.writeLong(this.interval);
      paramParcel.writeLong(this.lastPoll);
      AppMethodBeat.o(7748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog
 * JD-Core Version:    0.7.0.1
 */