package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceShareDialogFragment$2
  implements GraphRequest.Callback
{
  DeviceShareDialogFragment$2(DeviceShareDialogFragment paramDeviceShareDialogFragment) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(96954);
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      DeviceShareDialogFragment.access$100(this.this$0, (FacebookRequestError)localObject);
      AppMethodBeat.o(96954);
      return;
    }
    paramGraphResponse = paramGraphResponse.getJSONObject();
    localObject = new DeviceShareDialogFragment.RequestState();
    try
    {
      ((DeviceShareDialogFragment.RequestState)localObject).setUserCode(paramGraphResponse.getString("user_code"));
      ((DeviceShareDialogFragment.RequestState)localObject).setExpiresIn(paramGraphResponse.getLong("expires_in"));
      DeviceShareDialogFragment.access$200(this.this$0, (DeviceShareDialogFragment.RequestState)localObject);
      AppMethodBeat.o(96954);
      return;
    }
    catch (JSONException paramGraphResponse)
    {
      DeviceShareDialogFragment.access$100(this.this$0, new FacebookRequestError(0, "", "Malformed server response"));
      AppMethodBeat.o(96954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */