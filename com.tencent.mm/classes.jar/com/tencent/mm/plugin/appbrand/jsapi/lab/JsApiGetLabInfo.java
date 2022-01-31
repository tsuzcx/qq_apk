package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiGetLabInfo
  extends a
{
  public static final int CTRL_INDEX = 557;
  public static final String NAME = "getLabInfo";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131100);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131100);
      return;
    }
    paramJSONObject = paramJSONObject.optString("labId");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131100);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramJSONObject), JsApiGetLabInfo.a.class, new JsApiGetLabInfo.1(this, paramc, paramInt));
    AppMethodBeat.o(131100);
  }
  
  static final class GetLabInfoResult
    implements Parcelable
  {
    public static final Parcelable.Creator<GetLabInfoResult> CREATOR;
    private boolean cKh;
    private boolean enabled;
    
    static
    {
      AppMethodBeat.i(131098);
      CREATOR = new JsApiGetLabInfo.GetLabInfoResult.1();
      AppMethodBeat.o(131098);
    }
    
    public GetLabInfoResult()
    {
      this.cKh = false;
      this.enabled = false;
    }
    
    protected GetLabInfoResult(Parcel paramParcel)
    {
      AppMethodBeat.i(131097);
      this.cKh = false;
      this.enabled = false;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.cKh = bool1;
        if (paramParcel.readByte() == 0) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.enabled = bool1;
        AppMethodBeat.o(131097);
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
      AppMethodBeat.i(131096);
      if (this.cKh)
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
        AppMethodBeat.o(131096);
        return;
        b1 = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo
 * JD-Core Version:    0.7.0.1
 */