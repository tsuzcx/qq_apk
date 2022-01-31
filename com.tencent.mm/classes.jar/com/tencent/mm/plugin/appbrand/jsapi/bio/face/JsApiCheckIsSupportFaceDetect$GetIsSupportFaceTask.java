package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.a.hq;
import com.tencent.mm.h.a.hq.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR = new JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask.1();
  private String aox = "not returned";
  private int bhx = -1;
  private boolean cbb = false;
  private int errCode = -1;
  private c gfZ = null;
  private JsApiCheckIsSupportFaceDetect gli;
  private int glj = -1;
  
  protected JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(c paramc, int paramInt, JsApiCheckIsSupportFaceDetect paramJsApiCheckIsSupportFaceDetect)
  {
    this.gfZ = paramc;
    this.bhx = paramInt;
    this.gli = paramJsApiCheckIsSupportFaceDetect;
  }
  
  public final void Zu()
  {
    hq localhq = new hq();
    a.udP.m(localhq);
    this.cbb = localhq.bPF.bPG;
    this.errCode = localhq.bPF.bPH;
    this.aox = localhq.bPF.bPI;
    this.glj = localhq.bPF.bPJ;
    y.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[] { Boolean.valueOf(this.cbb), Integer.valueOf(this.errCode), this.aox, Integer.valueOf(this.glj) });
    ahI();
  }
  
  public final void Zv()
  {
    super.Zv();
    y.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[] { Boolean.valueOf(this.cbb), Integer.valueOf(this.errCode), this.aox, Integer.valueOf(this.glj) });
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("errCode", Integer.valueOf(this.errCode));
    localHashMap.put("libVersionCode", Integer.valueOf(this.glj));
    if (this.errCode == 0) {
      this.gfZ.C(this.bhx, this.gli.h("ok", localHashMap));
    }
    for (;;)
    {
      i.aa(this);
      return;
      this.gfZ.C(this.bhx, this.gli.h("fail " + this.aox, localHashMap));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cbb = bool;
      this.errCode = paramParcel.readInt();
      this.aox = paramParcel.readString();
      this.glj = paramParcel.readInt();
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (this.cbb) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.aox);
      paramParcel.writeInt(this.glj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask
 * JD-Core Version:    0.7.0.1
 */