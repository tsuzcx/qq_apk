package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.a.hp;
import com.tencent.mm.h.a.hp.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckBioEnrollment$GetIsEnrolledTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR = new JsApiCheckBioEnrollment.GetIsEnrolledTask.1();
  private int bhx = -1;
  private c gfZ = null;
  private JsApiCheckBioEnrollment gln;
  private int glo = -1;
  private int glp = -1;
  
  protected JsApiCheckBioEnrollment$GetIsEnrolledTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiCheckBioEnrollment$GetIsEnrolledTask(c paramc, int paramInt1, int paramInt2, JsApiCheckBioEnrollment paramJsApiCheckBioEnrollment)
  {
    this.gfZ = paramc;
    this.bhx = paramInt1;
    this.gln = paramJsApiCheckBioEnrollment;
    this.glo = paramInt2;
  }
  
  public final void Zu()
  {
    hp localhp = new hp();
    localhp.bPB.bPD = this.glo;
    a.udP.m(localhp);
    this.glp = localhp.bPC.bPE;
    y.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[] { Integer.valueOf(this.glp) });
    ahI();
  }
  
  public final void Zv()
  {
    boolean bool = false;
    super.Zv();
    y.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[] { Integer.valueOf(this.glp) });
    HashMap localHashMap = new HashMap(2);
    if (this.glp == 1) {
      bool = true;
    }
    localHashMap.put("isEnrolled", Boolean.valueOf(bool));
    if (this.glp == 0) {
      this.gfZ.C(this.bhx, this.gln.h("ok", localHashMap));
    }
    for (;;)
    {
      i.aa(this);
      return;
      if (this.glp == -1) {
        this.gfZ.C(this.bhx, this.gln.h("fail not support", localHashMap));
      } else if (this.glp == 1) {
        this.gfZ.C(this.bhx, this.gln.h("ok", localHashMap));
      } else {
        this.gfZ.C(this.bhx, this.gln.h("fail unknown error", localHashMap));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    this.glp = paramParcel.readInt();
    this.glo = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.glp);
    paramParcel.writeInt(this.glo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment.GetIsEnrolledTask
 * JD-Core Version:    0.7.0.1
 */