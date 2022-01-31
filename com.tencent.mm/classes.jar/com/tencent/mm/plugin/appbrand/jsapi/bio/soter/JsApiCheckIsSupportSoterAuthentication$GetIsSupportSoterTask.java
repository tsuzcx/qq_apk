package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.a.hr;
import com.tencent.mm.h.a.hr.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR = new JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask.1();
  private int bhx = -1;
  private c gfZ = null;
  private JsApiCheckIsSupportSoterAuthentication glr;
  private int gls = 0;
  
  protected JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
  {
    this.gfZ = paramc;
    this.bhx = paramInt;
    this.glr = paramJsApiCheckIsSupportSoterAuthentication;
  }
  
  public final void Zu()
  {
    hr localhr = new hr();
    com.tencent.mm.sdk.b.a.udP.m(localhr);
    this.gls = localhr.bPK.bPL;
    y.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.gls) });
    ahI();
  }
  
  public final void Zv()
  {
    super.Zv();
    y.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.gls) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("supportMode", a.lj(this.gls));
    this.gfZ.C(this.bhx, this.glr.h("ok", localHashMap));
    i.aa(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    this.gls = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.gls);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask
 * JD-Core Version:    0.7.0.1
 */