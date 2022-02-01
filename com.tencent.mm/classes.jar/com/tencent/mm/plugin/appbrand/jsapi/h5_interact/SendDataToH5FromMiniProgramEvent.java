package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public class SendDataToH5FromMiniProgramEvent
  extends IEvent
  implements Parcelable
{
  public static final Parcelable.Creator<SendDataToH5FromMiniProgramEvent> CREATOR;
  public String data;
  public String lWc;
  public int lWd;
  
  static
  {
    AppMethodBeat.i(121068);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(121068);
  }
  
  public SendDataToH5FromMiniProgramEvent() {}
  
  protected SendDataToH5FromMiniProgramEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(121067);
    this.lWc = paramParcel.readString();
    this.data = paramParcel.readString();
    this.lWd = paramParcel.readInt();
    AppMethodBeat.o(121067);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121066);
    paramParcel.writeString(this.lWc);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.lWd);
    AppMethodBeat.o(121066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent
 * JD-Core Version:    0.7.0.1
 */