package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int dmJ;
  
  static
  {
    AppMethodBeat.i(186717);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(186717);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.dmJ = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(186715);
    this.dmJ = 0;
    this.dmJ = paramParcel.readInt();
    AppMethodBeat.o(186715);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(186716);
    paramParcel.writeInt(this.dmJ);
    AppMethodBeat.o(186716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */