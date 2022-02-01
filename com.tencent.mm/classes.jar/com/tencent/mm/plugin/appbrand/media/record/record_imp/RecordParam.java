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
  public String lYI;
  public String processName;
  public String rDV;
  public int sampleRate;
  public int scene;
  public double tjA;
  public b tjB;
  public f tjC;
  public int tjy;
  public int tjz;
  
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
    this.tjy = 0;
    this.tjz = 0;
    this.scene = 0;
    this.tjA = 0.0D;
    this.processName = "";
    this.appId = "";
    this.tjB = b.til;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(146358);
    this.duration = 0;
    this.sampleRate = 0;
    this.tjy = 0;
    this.tjz = 0;
    this.scene = 0;
    this.tjA = 0.0D;
    this.processName = "";
    this.appId = "";
    this.tjB = b.til;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.tjy = paramParcel.readInt();
    this.tjz = paramParcel.readInt();
    this.rDV = paramParcel.readString();
    this.lYI = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.tjA = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.tjB = b.values()[paramParcel.readInt()];
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
    paramParcel.writeInt(this.tjy);
    paramParcel.writeInt(this.tjz);
    paramParcel.writeString(this.rDV);
    paramParcel.writeString(this.lYI);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.tjA);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.tjB.ordinal());
    AppMethodBeat.o(146359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */