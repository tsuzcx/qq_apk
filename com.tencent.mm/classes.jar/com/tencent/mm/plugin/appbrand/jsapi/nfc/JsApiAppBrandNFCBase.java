package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class JsApiAppBrandNFCBase
  extends c
{
  a skw = null;
  
  protected final void a(a parama)
  {
    a(parama, false);
  }
  
  protected final void a(a parama, boolean paramBoolean)
  {
    this.skw = parama;
    new CheckIsSupportHCETask(this, paramBoolean).bQt();
  }
  
  static class CheckIsSupportHCETask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR;
    private int errCode;
    private String errMsg;
    private JsApiAppBrandNFCBase skx;
    private boolean sky;
    
    static
    {
      AppMethodBeat.i(136101);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136101);
    }
    
    public CheckIsSupportHCETask(Parcel paramParcel)
    {
      AppMethodBeat.i(136095);
      this.skx = null;
      h(paramParcel);
      AppMethodBeat.o(136095);
    }
    
    public CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase, boolean paramBoolean)
    {
      this.skx = null;
      this.skx = paramJsApiAppBrandNFCBase;
      this.sky = paramBoolean;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(136096);
      if (!d.ctL())
      {
        this.errCode = 13000;
        this.errMsg = "not support NFC";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(136096);
        return;
        if (!d.ctK())
        {
          this.errCode = 13002;
          this.errMsg = "not support HCE";
        }
        else if ((this.sky) && (!d.ctM()))
        {
          this.errCode = 13001;
          this.errMsg = "system NFC switch not opened";
        }
        else
        {
          this.errCode = 0;
          this.errMsg = "support HCE and system NFC switch is opened";
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(136097);
      super.bQr();
      cpx();
      if (this.skx != null)
      {
        JsApiAppBrandNFCBase localJsApiAppBrandNFCBase = this.skx;
        int i = this.errCode;
        String str2 = this.errMsg;
        Log.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
        if (i == 0)
        {
          if (localJsApiAppBrandNFCBase.skw != null)
          {
            localJsApiAppBrandNFCBase.skw.onResult(i, str2);
            AppMethodBeat.o(136097);
          }
        }
        else
        {
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = "unknown error";
          }
          if (localJsApiAppBrandNFCBase.skw != null) {
            localJsApiAppBrandNFCBase.skw.onResult(i, str1);
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
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(136100);
      super.h(paramParcel);
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      if (1 == paramParcel.readInt()) {}
      for (;;)
      {
        this.sky = bool;
        AppMethodBeat.o(136100);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136099);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      if (this.sky) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(136099);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */