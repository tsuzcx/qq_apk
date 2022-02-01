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
  public String jvr;
  public String oAc;
  public String processName;
  public int qeK;
  public int qeL;
  public double qeM;
  public b qeN;
  public f qeO;
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
    this.qeK = 0;
    this.qeL = 0;
    this.scene = 0;
    this.qeM = 0.0D;
    this.processName = "";
    this.appId = "";
    this.qeN = b.qdw;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(146358);
    this.duration = 0;
    this.sampleRate = 0;
    this.qeK = 0;
    this.qeL = 0;
    this.scene = 0;
    this.qeM = 0.0D;
    this.processName = "";
    this.appId = "";
    this.qeN = b.qdw;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.qeK = paramParcel.readInt();
    this.qeL = paramParcel.readInt();
    this.oAc = paramParcel.readString();
    this.jvr = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.qeM = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.qeN = b.values()[paramParcel.readInt()];
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
    paramParcel.writeInt(this.qeK);
    paramParcel.writeInt(this.qeL);
    paramParcel.writeString(this.oAc);
    paramParcel.writeString(this.jvr);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.qeM);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.qeN.ordinal());
    AppMethodBeat.o(146359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */