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
  public String gfv;
  public String kAi;
  public b lWR;
  public f lWS;
  public int lyO;
  public int lyP;
  public double lyQ;
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
    this.lyO = 0;
    this.lyP = 0;
    this.scene = 0;
    this.lyQ = 0.0D;
    this.processName = "";
    this.appId = "";
    this.lWR = b.lVG;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(146358);
    this.duration = 0;
    this.sampleRate = 0;
    this.lyO = 0;
    this.lyP = 0;
    this.scene = 0;
    this.lyQ = 0.0D;
    this.processName = "";
    this.appId = "";
    this.lWR = b.lVG;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.lyO = paramParcel.readInt();
    this.lyP = paramParcel.readInt();
    this.kAi = paramParcel.readString();
    this.gfv = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.lyQ = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.lWR = b.values()[paramParcel.readInt()];
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
    paramParcel.writeInt(this.lyO);
    paramParcel.writeInt(this.lyP);
    paramParcel.writeString(this.kAi);
    paramParcel.writeString(this.gfv);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.lyQ);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.lWR.ordinal());
    AppMethodBeat.o(146359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */