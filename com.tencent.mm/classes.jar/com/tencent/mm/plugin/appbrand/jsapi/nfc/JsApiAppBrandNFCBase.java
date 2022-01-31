package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class JsApiAppBrandNFCBase
  extends a
{
  JsApiAppBrandNFCBase.a hUr = null;
  
  protected final void a(JsApiAppBrandNFCBase.a parama)
  {
    this.hUr = parama;
    parama = new CheckIsSupportHCETask(this);
    h.bq(parama);
    AppBrandMainProcessService.a(parama);
  }
  
  static class CheckIsSupportHCETask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR;
    private int errCode;
    private String errMsg;
    private JsApiAppBrandNFCBase hUs;
    
    static
    {
      AppMethodBeat.i(137866);
      CREATOR = new JsApiAppBrandNFCBase.CheckIsSupportHCETask.1();
      AppMethodBeat.o(137866);
    }
    
    public CheckIsSupportHCETask(Parcel paramParcel)
    {
      AppMethodBeat.i(137860);
      this.hUs = null;
      f(paramParcel);
      AppMethodBeat.o(137860);
    }
    
    public CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase)
    {
      this.hUs = null;
      this.hUs = paramJsApiAppBrandNFCBase;
    }
    
    public final void ata()
    {
      AppMethodBeat.i(137861);
      if (!d.aEl())
      {
        this.errCode = 13000;
        this.errMsg = "not support NFC";
      }
      for (;;)
      {
        aBp();
        AppMethodBeat.o(137861);
        return;
        if (!d.aEk())
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
    
    public final void atb()
    {
      AppMethodBeat.i(137862);
      super.atb();
      h.ai(this);
      if (this.hUs != null)
      {
        JsApiAppBrandNFCBase localJsApiAppBrandNFCBase = this.hUs;
        int i = this.errCode;
        String str2 = this.errMsg;
        ab.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
        if (i == 0)
        {
          if (localJsApiAppBrandNFCBase.hUr != null)
          {
            localJsApiAppBrandNFCBase.hUr.U(i, str2);
            AppMethodBeat.o(137862);
          }
        }
        else
        {
          String str1 = str2;
          if (bo.isNullOrNil(str2)) {
            str1 = "unknown error";
          }
          if (localJsApiAppBrandNFCBase.hUr != null) {
            localJsApiAppBrandNFCBase.hUr.U(i, str1);
          }
        }
      }
      AppMethodBeat.o(137862);
    }
    
    public int describeContents()
    {
      AppMethodBeat.i(137863);
      int i = super.describeContents();
      AppMethodBeat.o(137863);
      return i;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(137865);
      super.f(paramParcel);
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(137865);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(137864);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(137864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase
 * JD-Core Version:    0.7.0.1
 */