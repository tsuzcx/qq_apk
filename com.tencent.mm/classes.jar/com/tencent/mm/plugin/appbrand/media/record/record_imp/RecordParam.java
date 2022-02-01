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
  public String fJM;
  public int kXq;
  public int kXr;
  public double kXs;
  public String kcu;
  public b lth;
  public f lti;
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
    this.kXq = 0;
    this.kXr = 0;
    this.scene = 0;
    this.kXs = 0.0D;
    this.processName = "";
    this.appId = "";
    this.lth = b.lrV;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(146358);
    this.duration = 0;
    this.sampleRate = 0;
    this.kXq = 0;
    this.kXr = 0;
    this.scene = 0;
    this.kXs = 0.0D;
    this.processName = "";
    this.appId = "";
    this.lth = b.lrV;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.kXq = paramParcel.readInt();
    this.kXr = paramParcel.readInt();
    this.kcu = paramParcel.readString();
    this.fJM = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.kXs = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.lth = b.values()[paramParcel.readInt()];
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
    paramParcel.writeInt(this.kXq);
    paramParcel.writeInt(this.kXr);
    paramParcel.writeString(this.kcu);
    paramParcel.writeString(this.fJM);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.kXs);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.lth.ordinal());
    AppMethodBeat.o(146359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */