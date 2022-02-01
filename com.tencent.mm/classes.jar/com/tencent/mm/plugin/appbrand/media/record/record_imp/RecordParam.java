package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.f;

public class RecordParam
  implements Parcelable
{
  public static final Parcelable.Creator<RecordParam> CREATOR;
  public String appId;
  public int duration;
  public String gLc;
  public String lEB;
  public int mFQ;
  public int mFR;
  public double mFS;
  public b neu;
  public f nev;
  public String processName;
  public int sampleRate;
  public int scene;
  
  static
  {
    AppMethodBeat.i(146360);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146360);
  }
  
  public RecordParam()
  {
    this.duration = 0;
    this.sampleRate = 0;
    this.mFQ = 0;
    this.mFR = 0;
    this.scene = 0;
    this.mFS = 0.0D;
    this.processName = "";
    this.appId = "";
    this.neu = b.ndh;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(146358);
    this.duration = 0;
    this.sampleRate = 0;
    this.mFQ = 0;
    this.mFR = 0;
    this.scene = 0;
    this.mFS = 0.0D;
    this.processName = "";
    this.appId = "";
    this.neu = b.ndh;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.mFQ = paramParcel.readInt();
    this.mFR = paramParcel.readInt();
    this.lEB = paramParcel.readString();
    this.gLc = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.mFS = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.neu = b.values()[paramParcel.readInt()];
    AppMethodBeat.o(146358);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146359);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.sampleRate);
    paramParcel.writeInt(this.mFQ);
    paramParcel.writeInt(this.mFR);
    paramParcel.writeString(this.lEB);
    paramParcel.writeString(this.gLc);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.mFS);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.neu.ordinal());
    AppMethodBeat.o(146359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */