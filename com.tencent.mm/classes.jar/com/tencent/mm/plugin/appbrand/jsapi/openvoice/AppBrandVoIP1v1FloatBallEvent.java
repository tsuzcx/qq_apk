package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int dyx;
  
  static
  {
    AppMethodBeat.i(188461);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(188461);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.dyx = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(188459);
    this.dyx = 0;
    this.dyx = paramParcel.readInt();
    AppMethodBeat.o(188459);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188460);
    paramParcel.writeInt(this.dyx);
    AppMethodBeat.o(188460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */