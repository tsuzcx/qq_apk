package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameWebViewLaunchParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebViewLaunchParams> CREATOR;
  public GameFloatLayerInfo sWE;
  
  static
  {
    AppMethodBeat.i(82985);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(82985);
  }
  
  public GameWebViewLaunchParams() {}
  
  private GameWebViewLaunchParams(Parcel paramParcel)
  {
    AppMethodBeat.i(82984);
    this.sWE = ((GameFloatLayerInfo)paramParcel.readParcelable(GameFloatLayerInfo.class.getClassLoader()));
    AppMethodBeat.o(82984);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(82983);
    paramParcel.writeParcelable(this.sWE, paramInt);
    AppMethodBeat.o(82983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams
 * JD-Core Version:    0.7.0.1
 */