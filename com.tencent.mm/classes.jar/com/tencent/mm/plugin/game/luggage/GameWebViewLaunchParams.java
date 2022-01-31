package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameWebViewLaunchParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebViewLaunchParams> CREATOR;
  public GameFloatLayerInfo njg;
  
  static
  {
    AppMethodBeat.i(135805);
    CREATOR = new GameWebViewLaunchParams.1();
    AppMethodBeat.o(135805);
  }
  
  public GameWebViewLaunchParams() {}
  
  private GameWebViewLaunchParams(Parcel paramParcel)
  {
    AppMethodBeat.i(135804);
    this.njg = ((GameFloatLayerInfo)paramParcel.readParcelable(GameFloatLayerInfo.class.getClassLoader()));
    AppMethodBeat.o(135804);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(135803);
    paramParcel.writeParcelable(this.njg, paramInt);
    AppMethodBeat.o(135803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams
 * JD-Core Version:    0.7.0.1
 */