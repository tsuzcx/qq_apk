package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR = new SampleTask1.1();
  public String geE;
  public String geF;
  
  public SampleTask1(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    y.e("SampleTask", this.geE);
    this.geF = "String from Main Process";
    ahI();
  }
  
  public final void Zv()
  {
    y.e("SampleTask", this.geF);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.geE = paramParcel.readString();
    this.geF = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.geE);
    paramParcel.writeString(this.geF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */