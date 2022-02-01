package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiSetLabInfo
  extends c
{
  public static final int CTRL_INDEX = 558;
  public static final String NAME = "setLabInfo";
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46372);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46372);
      return;
    }
    String str = paramJSONObject.optString("labId");
    if ((Util.isNullOrNil(str)) || (!paramJSONObject.has("enabled")))
    {
      Log.e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46372);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enabled");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCSetLabInfoRequest(str, bool), a.class, new f() {});
    AppMethodBeat.o(46372);
  }
  
  static final class IPCSetLabInfoRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCSetLabInfoRequest> CREATOR;
    private String appid;
    private boolean enabled;
    
    static
    {
      AppMethodBeat.i(46371);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46371);
    }
    
    public IPCSetLabInfoRequest() {}
    
    protected IPCSetLabInfoRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46370);
      this.appid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.enabled = bool;
        AppMethodBeat.o(46370);
        return;
      }
    }
    
    public IPCSetLabInfoRequest(String paramString, boolean paramBoolean)
    {
      this.appid = paramString;
      this.enabled = paramBoolean;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46369);
      paramParcel.writeString(this.appid);
      if (this.enabled) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(46369);
        return;
      }
    }
  }
  
  static final class a
    implements d<JsApiSetLabInfo.IPCSetLabInfoRequest, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo
 * JD-Core Version:    0.7.0.1
 */