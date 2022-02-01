package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class JsApiSetBackgroundFetchToken
  extends a
{
  public static final int CTRL_INDEX = 641;
  public static final String NAME = "setBackgroundFetchToken";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46130);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46130);
      return;
    }
    paramJSONObject = paramJSONObject.optString("token");
    if (bs.isNullOrNil(paramJSONObject))
    {
      ac.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46130);
      return;
    }
    if (paramJSONObject.length() > 1024)
    {
      ac.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is too long");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46130);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new SetBackgroundFetchTokenParcel(paramc.getAppId(), paramJSONObject), a.class, new d() {});
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
  
  static class a
    implements b<JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken
 * JD-Core Version:    0.7.0.1
 */