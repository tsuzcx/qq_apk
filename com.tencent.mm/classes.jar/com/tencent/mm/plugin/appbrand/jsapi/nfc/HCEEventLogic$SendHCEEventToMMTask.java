package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;

class HCEEventLogic$SendHCEEventToMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR = new Parcelable.Creator() {};
  private String appId;
  private int gxP;
  private Bundle gxQ;
  
  protected HCEEventLogic$SendHCEEventToMMTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private HCEEventLogic$SendHCEEventToMMTask(String paramString, int paramInt, Bundle paramBundle)
  {
    this.gxP = paramInt;
    this.appId = paramString;
    this.gxQ = paramBundle;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
    b.gyA.a(this.gxP, this.appId, this.gxQ);
    ahI();
  }
  
  public final void Zv()
  {
    super.Zv();
    i.aa(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    super.e(paramParcel);
    this.gxP = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.gxQ = paramParcel.readBundle();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.gxP);
    paramParcel.writeString(this.appId);
    paramParcel.writeBundle(this.gxQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.SendHCEEventToMMTask
 * JD-Core Version:    0.7.0.1
 */