package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.f;

public class RecordParam
  implements Parcelable
{
  public static final Parcelable.Creator<RecordParam> CREATOR = new RecordParam.1();
  public String appId = "";
  public int duration = 0;
  public String dzp;
  public int gOG = 0;
  public int gOH = 0;
  public double gOI = 0.0D;
  public b gOJ = b.gNp;
  public f gOK;
  public String gja;
  public String processName = "";
  public int sampleRate = 0;
  public int scene = 0;
  
  public RecordParam() {}
  
  public RecordParam(Parcel paramParcel)
  {
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.gOG = paramParcel.readInt();
    this.gOH = paramParcel.readInt();
    this.gja = paramParcel.readString();
    this.dzp = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.gOI = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.gOJ = b.values()[paramParcel.readInt()];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.sampleRate);
    paramParcel.writeInt(this.gOG);
    paramParcel.writeInt(this.gOH);
    paramParcel.writeString(this.gja);
    paramParcel.writeString(this.dzp);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.gOI);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.gOJ.ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */