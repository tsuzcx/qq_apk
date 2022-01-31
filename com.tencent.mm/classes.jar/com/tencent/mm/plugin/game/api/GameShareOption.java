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
  public boolean niC;
  public String title;
  
  static
  {
    AppMethodBeat.i(141588);
    CREATOR = new GameShareOption.1();
    AppMethodBeat.o(141588);
  }
  
  public GameShareOption(int paramInt, String paramString, boolean paramBoolean)
  {
    this.niC = false;
    this.id = paramInt;
    this.title = paramString;
    this.niC = paramBoolean;
  }
  
  protected GameShareOption(Parcel paramParcel)
  {
    AppMethodBeat.i(141586);
    this.niC = false;
    this.id = paramParcel.readInt();
    this.title = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.niC = bool;
      AppMethodBeat.o(141586);
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
    AppMethodBeat.i(141587);
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.title);
    if (this.niC) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(141587);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.GameShareOption
 * JD-Core Version:    0.7.0.1
 */