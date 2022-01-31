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
  public String hMi;
  public int hMj;
  
  static
  {
    AppMethodBeat.i(93754);
    CREATOR = new SendDataToH5FromMiniProgramEvent.1();
    AppMethodBeat.o(93754);
  }
  
  public SendDataToH5FromMiniProgramEvent() {}
  
  protected SendDataToH5FromMiniProgramEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(93753);
    this.hMi = paramParcel.readString();
    this.data = paramParcel.readString();
    this.hMj = paramParcel.readInt();
    AppMethodBeat.o(93753);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(93752);
    paramParcel.writeString(this.hMi);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.hMj);
    AppMethodBeat.o(93752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent
 * JD-Core Version:    0.7.0.1
 */