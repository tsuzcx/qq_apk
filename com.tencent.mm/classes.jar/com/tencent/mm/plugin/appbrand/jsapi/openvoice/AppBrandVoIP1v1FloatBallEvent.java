package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandVoIP1v1FloatBallEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandVoIP1v1FloatBallEvent> CREATOR;
  public int fKG;
  
  static
  {
    AppMethodBeat.i(271281);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(271281);
  }
  
  public AppBrandVoIP1v1FloatBallEvent()
  {
    this.fKG = 0;
  }
  
  public AppBrandVoIP1v1FloatBallEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(271279);
    this.fKG = 0;
    this.fKG = paramParcel.readInt();
    AppMethodBeat.o(271279);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(271280);
    paramParcel.writeInt(this.fKG);
    AppMethodBeat.o(271280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent
 * JD-Core Version:    0.7.0.1
 */