package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class JsApiAppBrandNFCBase
  extends a
{
  a kbd = null;
  
  protected final void a(a parama)
  {
    this.kbd = parama;
    parama = new CheckIsSupportHCETask(this);
    parama.aXm();
    AppBrandMainProcessService.a(parama);
  }
  
  static class CheckIsSupportHCETask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR;
    private int errCode;
    private String errMsg;
    private JsApiAppBrandNFCBase kbe;
    
    static
    {
      AppMethodBeat.i(136101);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136101);
    }
    
    public CheckIsSupportHCETask(Parcel paramParcel)
    {
      AppMethodBeat.i(136095);
      this.kbe = null;
      e(paramParcel);
      AppMethodBeat.o(136095);
    }
    
    public CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase)
    {
      this.kbe = null;
      this.kbe = paramJsApiAppBrandNFCBase;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(136097);
      super.aEA();
      aXn();
      if (this.kbe != null)
      {
        JsApiAppBrandNFCBase localJsApiAppBrandNFCBase = this.kbe;
        int i = this.errCode;
        String str2 = this.errMsg;
        ad.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
        if (i == 0)
        {
          if (localJsApiAppBrandNFCBase.kbd != null)
          {
            localJsApiAppBrandNFCBase.kbd.y(i, str2);
            AppMethodBeat.o(136097);
          }
        }
        else
        {
          String str1 = str2;
          if (bt.isNullOrNil(str2)) {
            str1 = "unknown error";
          }
          if (localJsApiAppBrandNFCBase.kbd != null) {
            localJsApiAppBrandNFCBase.kbd.y(i, str1);
          }
        }
      }
      AppMethodBeat.o(136097);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(136096);
      if (!d.bbn())
      {
        this.errCode = 13000;
        this.errMsg = "not support NFC";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(136096);
        return;
        if (!d.bbm())
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
    
    public int describeContents()
    {
      AppMethodBeat.i(136098);
      int i = super.describeContents();
      AppMethodBeat.o(136098);
      return i;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(136100);
      super.e(paramParcel);
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
    public abstract void y(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */