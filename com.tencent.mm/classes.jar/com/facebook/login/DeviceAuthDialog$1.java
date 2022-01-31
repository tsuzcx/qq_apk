package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceAuthDialog$1
  implements GraphRequest.Callback
{
  DeviceAuthDialog$1(DeviceAuthDialog paramDeviceAuthDialog) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96711);
    if (DeviceAuthDialog.access$000(this.this$0))
    {
      AppMethodBeat.o(96711);
      return;
    }
    if (paramGraphResponse.getError() != null)
    {
      this.this$0.onError(paramGraphResponse.getError().getException());
      AppMethodBeat.o(96711);
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    DeviceAuthDialog.RequestState localRequestState = new DeviceAuthDialog.RequestState();
    try
    {
      localRequestState.setUserCode(paramGraphResponse.getString("user_code"));
      localRequestState.setRequestCode(paramGraphResponse.getString("code"));
      localRequestState.setInterval(paramGraphResponse.getLong("interval"));
      DeviceAuthDialog.access$100(this.this$0, localRequestState);
      AppMethodBeat.o(96711);
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      this.this$0.onError(new FacebookException(paramGraphResponse));
      AppMethodBeat.o(96711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.1
 * JD-Core Version:    0.7.0.1
 */