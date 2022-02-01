package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiSetBackgroundFetchToken
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 641;
  public static final String NAME = "setBackgroundFetchToken";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46130);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46130);
      return;
    }
    paramJSONObject = paramJSONObject.optString("token");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46130);
      return;
    }
    if (paramJSONObject.length() > 1024)
    {
      Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is too long");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46130);
      return;
    }
    String str = paramf.getAppId();
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new SetBackgroundFetchTokenParcel(str, paramJSONObject), a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(46130);
  }
  
  static class SetBackgroundFetchTokenParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SetBackgroundFetchTokenParcel> CREATOR;
    String appId;
    String token;
    
    static
    {
      AppMethodBeat.i(46128);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46128);
    }
    
    protected SetBackgroundFetchTokenParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(46126);
      this.appId = paramParcel.readString();
      this.token = paramParcel.readString();
      AppMethodBeat.o(46126);
    }
    
    public SetBackgroundFetchTokenParcel(String paramString1, String paramString2)
    {
      this.appId = paramString1;
      this.token = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46127);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.token);
      AppMethodBeat.o(46127);
    }
  }
  
  @a
  static class a
    implements com.tencent.mm.ipcinvoker.c<JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken
 * JD-Core Version:    0.7.0.1
 */