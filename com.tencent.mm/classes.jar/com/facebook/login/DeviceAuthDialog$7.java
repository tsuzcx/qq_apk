package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAuthDialog$7
  implements GraphRequest.Callback
{
  DeviceAuthDialog$7(DeviceAuthDialog paramDeviceAuthDialog, String paramString, Date paramDate1, Date paramDate2) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96717);
    if (DeviceAuthDialog.access$300(this.this$0).get())
    {
      AppMethodBeat.o(96717);
      return;
    }
    if (paramGraphResponse.getError() != null)
    {
      this.this$0.onError(paramGraphResponse.getError().getException());
      AppMethodBeat.o(96717);
      return;
    }
    Utility.PermissionsPair localPermissionsPair;
    try
    {
      Object localObject = paramGraphResponse.getJSONObject();
      paramGraphResponse = ((JSONObject)localObject).getString("id");
      localPermissionsPair = Utility.handlePermissionResponse((JSONObject)localObject);
      localObject = ((JSONObject)localObject).getString("name");
      DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.access$500(this.this$0).getUserCode());
      if ((FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm)) && (!DeviceAuthDialog.access$1000(this.this$0)))
      {
        DeviceAuthDialog.access$1002(this.this$0, true);
        DeviceAuthDialog.access$1100(this.this$0, paramGraphResponse, localPermissionsPair, this.val$accessToken, (String)localObject, this.val$expirationTime, this.val$dataAccessExpirationTimeDate);
        AppMethodBeat.o(96717);
        return;
      }
    }
    catch (JSONException paramGraphResponse)
    {
      this.this$0.onError(new FacebookException(paramGraphResponse));
      AppMethodBeat.o(96717);
      return;
    }
    DeviceAuthDialog.access$900(this.this$0, paramGraphResponse, localPermissionsPair, this.val$accessToken, this.val$expirationTime, this.val$dataAccessExpirationTimeDate);
    AppMethodBeat.o(96717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.7
 * JD-Core Version:    0.7.0.1
 */