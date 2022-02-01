package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiGetLabInfo
  extends c
{
  public static final int CTRL_INDEX = 557;
  public static final String NAME = "getLabInfo";
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46365);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46365);
      return;
    }
    paramJSONObject = paramJSONObject.optString("labId");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46365);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramJSONObject), a.class, new f() {});
    AppMethodBeat.o(46365);
  }
  
  static final class GetLabInfoResult
    implements Parcelable
  {
    public static final Parcelable.Creator<GetLabInfoResult> CREATOR;
    private boolean enabled;
    private boolean fYz;
    
    static
    {
      AppMethodBeat.i(46363);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46363);
    }
    
    public GetLabInfoResult()
    {
      this.fYz = false;
      this.enabled = false;
    }
    
    protected GetLabInfoResult(Parcel paramParcel)
    {
      AppMethodBeat.i(46362);
      this.fYz = false;
      this.enabled = false;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.fYz = bool1;
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
      if (this.fYz)
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
    implements d<IPCString, JsApiGetLabInfo.GetLabInfoResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo
 * JD-Core Version:    0.7.0.1
 */