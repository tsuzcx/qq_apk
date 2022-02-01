package com.tencent.mm.plugin.appbrand.jsapi.lab;

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

public final class JsApiSetLabInfo
  extends a
{
  public static final int CTRL_INDEX = 558;
  public static final String NAME = "setLabInfo";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46372);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46372);
      return;
    }
    String str = paramJSONObject.optString("labId");
    if ((bs.isNullOrNil(str)) || (!paramJSONObject.has("enabled")))
    {
      ac.e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46372);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCSetLabInfoRequest(str, paramJSONObject.optBoolean("enabled")), a.class, new d() {});
    AppMethodBeat.o(46372);
  }
  
  static final class IPCSetLabInfoRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCSetLabInfoRequest> CREATOR;
    private String djj;
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
      this.djj = paramParcel.readString();
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
      this.djj = paramString;
      this.enabled = paramBoolean;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46369);
      paramParcel.writeString(this.djj);
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
    implements b<JsApiSetLabInfo.IPCSetLabInfoRequest, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo
 * JD-Core Version:    0.7.0.1
 */