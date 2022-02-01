package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int dzC;
  
  static
  {
    AppMethodBeat.i(222611);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(222611);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.dzC = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(222609);
    this.dzC = 0;
    this.dzC = paramParcel.readInt();
    AppMethodBeat.o(222609);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(222610);
    paramParcel.writeInt(this.dzC);
    AppMethodBeat.o(222610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */