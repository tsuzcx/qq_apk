package com.tencent.mm.plugin.game.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameShareOption
  implements Parcelable
{
  public static final Parcelable.Creator<GameShareOption> CREATOR;
  public int id;
  public boolean rNx;
  public String title;
  
  static
  {
    AppMethodBeat.i(89659);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(89659);
  }
  
  public GameShareOption(int paramInt, String paramString, boolean paramBoolean)
  {
    this.rNx = false;
    this.id = paramInt;
    this.title = paramString;
    this.rNx = paramBoolean;
  }
  
  protected GameShareOption(Parcel paramParcel)
  {
    AppMethodBeat.i(89657);
    this.rNx = false;
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.rNx = bool;
      AppMethodBeat.o(89657);
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
    AppMethodBeat.i(89658);
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.title);
    if (this.rNx) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(89658);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.GameShareOption
 * JD-Core Version:    0.7.0.1
 */