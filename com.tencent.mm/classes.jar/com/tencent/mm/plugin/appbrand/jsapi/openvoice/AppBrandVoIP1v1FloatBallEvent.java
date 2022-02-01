package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int dRq;
  
  static
  {
    AppMethodBeat.i(226920);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(226920);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.dRq = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(226918);
    this.dRq = 0;
    this.dRq = paramParcel.readInt();
    AppMethodBeat.o(226918);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(226919);
    paramParcel.writeInt(this.dRq);
    AppMethodBeat.o(226919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */