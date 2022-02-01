package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SendDataToMiniProgramFromH5Event
  implements Parcelable
{
  public static final Parcelable.Creator<SendDataToMiniProgramFromH5Event> CREATOR;
  public String data;
  public String rZd;
  public int rZe;
  
  static
  {
    AppMethodBeat.i(46358);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46358);
  }
  
  public SendDataToMiniProgramFromH5Event() {}
  
  protected SendDataToMiniProgramFromH5Event(Parcel paramParcel)
  {
    AppMethodBeat.i(46357);
    this.rZd = paramParcel.readString();
    this.data = paramParcel.readString();
    this.rZe = paramParcel.readInt();
    AppMethodBeat.o(46357);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46356);
    paramParcel.writeString(this.rZd);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.rZe);
    AppMethodBeat.o(46356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event
 * JD-Core Version:    0.7.0.1
 */