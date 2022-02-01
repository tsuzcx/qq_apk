package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public class SendDataToH5FromMiniProgramEvent
  extends b
  implements Parcelable
{
  public static final Parcelable.Creator<SendDataToH5FromMiniProgramEvent> CREATOR;
  public String data;
  public String kQY;
  public int kQZ;
  
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
    this.kQY = paramParcel.readString();
    this.data = paramParcel.readString();
    this.kQZ = paramParcel.readInt();
    AppMethodBeat.o(121067);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121066);
    paramParcel.writeString(this.kQY);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.kQZ);
    AppMethodBeat.o(121066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent
 * JD-Core Version:    0.7.0.1
 */