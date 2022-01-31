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
  public String hMk;
  public int hMl;
  
  static
  {
    AppMethodBeat.i(131093);
    CREATOR = new SendDataToMiniProgramFromH5Event.1();
    AppMethodBeat.o(131093);
  }
  
  public SendDataToMiniProgramFromH5Event() {}
  
  protected SendDataToMiniProgramFromH5Event(Parcel paramParcel)
  {
    AppMethodBeat.i(131092);
    this.hMk = paramParcel.readString();
    this.data = paramParcel.readString();
    this.hMl = paramParcel.readInt();
    AppMethodBeat.o(131092);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131091);
    paramParcel.writeString(this.hMk);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.hMl);
    AppMethodBeat.o(131091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event
 * JD-Core Version:    0.7.0.1
 */