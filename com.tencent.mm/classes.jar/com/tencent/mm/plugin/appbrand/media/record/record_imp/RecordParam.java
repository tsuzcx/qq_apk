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
  public String ese;
  public String hCu;
  public int ifH;
  public int ifJ;
  public double ifK;
  public b iqs;
  public f iqt;
  public String processName;
  public int sampleRate;
  public int scene;
  
  static
  {
    AppMethodBeat.i(105663);
    CREATOR = new RecordParam.1();
    AppMethodBeat.o(105663);
  }
  
  public RecordParam()
  {
    this.duration = 0;
    this.sampleRate = 0;
    this.ifH = 0;
    this.ifJ = 0;
    this.scene = 0;
    this.ifK = 0.0D;
    this.processName = "";
    this.appId = "";
    this.iqs = b.ipj;
  }
  
  public RecordParam(Parcel paramParcel)
  {
    AppMethodBeat.i(105661);
    this.duration = 0;
    this.sampleRate = 0;
    this.ifH = 0;
    this.ifJ = 0;
    this.scene = 0;
    this.ifK = 0.0D;
    this.processName = "";
    this.appId = "";
    this.iqs = b.ipj;
    this.duration = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.ifH = paramParcel.readInt();
    this.ifJ = paramParcel.readInt();
    this.hCu = paramParcel.readString();
    this.ese = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.ifK = paramParcel.readDouble();
    this.processName = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iqs = b.values()[paramParcel.readInt()];
    AppMethodBeat.o(105661);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105662);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.sampleRate);
    paramParcel.writeInt(this.ifH);
    paramParcel.writeInt(this.ifJ);
    paramParcel.writeString(this.hCu);
    paramParcel.writeString(this.ese);
    paramParcel.writeInt(this.scene);
    paramParcel.writeDouble(this.ifK);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iqs.ordinal());
    AppMethodBeat.o(105662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam
 * JD-Core Version:    0.7.0.1
 */