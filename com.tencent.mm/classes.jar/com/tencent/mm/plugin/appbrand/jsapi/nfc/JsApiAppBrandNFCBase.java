package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class JsApiAppBrandNFCBase
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  a mgX = null;
  
  protected final void a(a parama)
  {
    this.mgX = parama;
    parama = new CheckIsSupportHCETask(this);
    parama.bDJ();
    AppBrandMainProcessService.a(parama);
  }
  
  static class CheckIsSupportHCETask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR;
    private int errCode;
    private String errMsg;
    private JsApiAppBrandNFCBase mgY;
    
    static
    {
      AppMethodBeat.i(136101);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136101);
    }
    
    public CheckIsSupportHCETask(Parcel paramParcel)
    {
      AppMethodBeat.i(136095);
      this.mgY = null;
      f(paramParcel);
      AppMethodBeat.o(136095);
    }
    
    public CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase)
    {
      this.mgY = null;
      this.mgY = paramJsApiAppBrandNFCBase;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(136096);
      if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHX())
      {
        this.errCode = 13000;
        this.errMsg = "not support NFC";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(136096);
        return;
        if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHW())
        {
          this.errCode = 13002;
          this.errMsg = "not support HCE";
        }
        else
        {
          this.errCode = 0;
          this.errMsg = "support HCE and system NFC switch is opened";
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(136097);
      super.bjk();
      bDK();
      if (this.mgY != null)
      {
        JsApiAppBrandNFCBase localJsApiAppBrandNFCBase = this.mgY;
        int i = this.errCode;
        String str2 = this.errMsg;
        Log.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
        if (i == 0)
        {
          if (localJsApiAppBrandNFCBase.mgX != null)
          {
            localJsApiAppBrandNFCBase.mgX.A(i, str2);
            AppMethodBeat.o(136097);
          }
        }
        else
        {
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = "unknown error";
          }
          if (localJsApiAppBrandNFCBase.mgX != null) {
            localJsApiAppBrandNFCBase.mgX.A(i, str1);
          }
        }
      }
      AppMethodBeat.o(136097);
    }
    
    public int describeContents()
    {
      AppMethodBeat.i(136098);
      int i = super.describeContents();
      AppMethodBeat.o(136098);
      return i;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(136100);
      super.f(paramParcel);
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(136100);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136099);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(136099);
    }
  }
  
  public static abstract interface a
  {
    public abstract void A(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */