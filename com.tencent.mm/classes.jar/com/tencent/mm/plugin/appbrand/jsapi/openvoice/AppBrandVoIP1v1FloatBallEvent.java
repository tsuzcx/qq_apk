package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int hQm;
  
  static
  {
    AppMethodBeat.i(326313);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(326313);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.hQm = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(326311);
    this.hQm = 0;
    this.hQm = paramParcel.readInt();
    AppMethodBeat.o(326311);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326319);
    paramParcel.writeInt(this.hQm);
    AppMethodBeat.o(326319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */