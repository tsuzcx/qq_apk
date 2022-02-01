package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class JsApiGetLabInfo
  extends a
{
  public static final int CTRL_INDEX = 557;
  public static final String NAME = "getLabInfo";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46365);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46365);
      return;
    }
    paramJSONObject = paramJSONObject.optString("labId");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46365);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramJSONObject), a.class, new d() {});
    AppMethodBeat.o(46365);
  }
  
  static final class GetLabInfoResult
    implements Parcelable
  {
    public static final Parcelable.Creator<GetLabInfoResult> CREATOR;
    private boolean dLd;
    private boolean enabled;
    
    static
    {
      AppMethodBeat.i(46363);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46363);
    }
    
    public GetLabInfoResult()
    {
      this.dLd = false;
      this.enabled = false;
    }
    
    protected GetLabInfoResult(Parcel paramParcel)
    {
      AppMethodBeat.i(46362);
      this.dLd = false;
      this.enabled = false;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.dLd = bool1;
        if (paramParcel.readByte() == 0) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.enabled = bool1;
        AppMethodBeat.o(46362);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46361);
      if (this.dLd)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.enabled) {
          break label48;
        }
      }
      label48:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46361);
        return;
        b1 = 0;
        break;
      }
    }
  }
  
  static final class a
    implements b<IPCString, JsApiGetLabInfo.GetLabInfoResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo
 * JD-Core Version:    0.7.0.1
 */