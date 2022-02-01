package com.tencent.mm.plugin.game.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameFloatLayerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameFloatLayerInfo> CREATOR;
  public int orientation;
  public boolean tTj;
  public String url;
  
  static
  {
    AppMethodBeat.i(82975);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(82975);
  }
  
  public GameFloatLayerInfo()
  {
    this.tTj = false;
    this.orientation = -1;
  }
  
  private GameFloatLayerInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(82974);
    this.tTj = false;
    this.orientation = -1;
    this.url = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.tTj = bool;
      this.orientation = paramParcel.readInt();
      AppMethodBeat.o(82974);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(82973);
    paramParcel.writeString(this.url);
    if (this.tTj) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.orientation);
      AppMethodBeat.o(82973);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo
 * JD-Core Version:    0.7.0.1
 */