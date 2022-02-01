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
  a pfd = null;
  
  protected final void a(a parama)
  {
    a(parama, false);
  }
  
  protected final void a(a parama, boolean paramBoolean)
  {
    this.pfd = parama;
    new CheckIsSupportHCETask(this, paramBoolean).bsM();
  }
  
  static class CheckIsSupportHCETask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR;
    private int errCode;
    private String errMsg;
    private JsApiAppBrandNFCBase pfe;
    private boolean pff;
    
    static
    {
      AppMethodBeat.i(136101);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136101);
    }
    
    public CheckIsSupportHCETask(Parcel paramParcel)
    {
      AppMethodBeat.i(136095);
      this.pfe = null;
      f(paramParcel);
      AppMethodBeat.o(136095);
    }
    
    public CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase, boolean paramBoolean)
    {
      this.pfe = null;
      this.pfe = paramJsApiAppBrandNFCBase;
      this.pff = paramBoolean;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(136096);
      if (!d.bTG())
      {
        this.errCode = 13000;
        this.errMsg = "not support NFC";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(136096);
        return;
        if (!d.bTF())
        {
          this.errCode = 13002;
          this.errMsg = "not support HCE";
        }
        else if ((this.pff) && (!d.bTH()))
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
    
    public final void bsK()
    {
      AppMethodBeat.i(136097);
      super.bsK();
      bPk();
      if (this.pfe != null)
      {
        JsApiAppBrandNFCBase localJsApiAppBrandNFCBase = this.pfe;
        int i = this.errCode;
        String str2 = this.errMsg;
        Log.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
        if (i == 0)
        {
          if (localJsApiAppBrandNFCBase.pfd != null)
          {
            localJsApiAppBrandNFCBase.pfd.B(i, str2);
            AppMethodBeat.o(136097);
          }
        }
        else
        {
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            str1 = "unknown error";
          }
          if (localJsApiAppBrandNFCBase.pfd != null) {
            localJsApiAppBrandNFCBase.pfd.B(i, str1);
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
      boolean bool = true;
      AppMethodBeat.i(136100);
      super.f(paramParcel);
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      if (1 == paramParcel.readInt()) {}
      for (;;)
      {
        this.pff = bool;
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
      if (this.pff) {}
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
    public abstract void B(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */