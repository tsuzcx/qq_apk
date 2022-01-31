package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class JsApiAppBrandNFCBase$CheckIsSupportHCETask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CheckIsSupportHCETask> CREATOR = new JsApiAppBrandNFCBase.CheckIsSupportHCETask.1();
  private String aox;
  private int errCode;
  private JsApiAppBrandNFCBase gxS = null;
  
  public JsApiAppBrandNFCBase$CheckIsSupportHCETask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiAppBrandNFCBase$CheckIsSupportHCETask(JsApiAppBrandNFCBase paramJsApiAppBrandNFCBase)
  {
    this.gxS = paramJsApiAppBrandNFCBase;
  }
  
  public final void Zu()
  {
    if (!d.ajM())
    {
      this.errCode = 13000;
      this.aox = "not support NFC";
    }
    for (;;)
    {
      ahI();
      return;
      if (!d.ajL())
      {
        this.errCode = 13002;
        this.aox = "not support HCE";
      }
      else
      {
        this.errCode = 0;
        this.aox = "support HCE and system NFC switch is opened";
      }
    }
  }
  
  public final void Zv()
  {
    super.Zv();
    i.aa(this);
    JsApiAppBrandNFCBase localJsApiAppBrandNFCBase;
    int i;
    String str2;
    if (this.gxS != null)
    {
      localJsApiAppBrandNFCBase = this.gxS;
      i = this.errCode;
      str2 = this.aox;
      y.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), str2 });
      if (i != 0) {
        break label78;
      }
      if (localJsApiAppBrandNFCBase.gxR != null) {
        localJsApiAppBrandNFCBase.gxR.J(i, str2);
      }
    }
    label78:
    String str1;
    do
    {
      return;
      str1 = str2;
      if (bk.bl(str2)) {
        str1 = "unknown error";
      }
    } while (localJsApiAppBrandNFCBase.gxR == null);
    localJsApiAppBrandNFCBase.gxR.J(i, str1);
  }
  
  public int describeContents()
  {
    return super.describeContents();
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    this.errCode = paramParcel.readInt();
    this.aox = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.aox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.CheckIsSupportHCETask
 * JD-Core Version:    0.7.0.1
 */