package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameTabData$StatusBar
  implements Parcelable
{
  public static final Parcelable.Creator<StatusBar> CREATOR = new GameTabData.StatusBar.1();
  public int color = 0;
  public String kQS = null;
  
  public GameTabData$StatusBar() {}
  
  public GameTabData$StatusBar(Parcel paramParcel)
  {
    this.kQS = paramParcel.readString();
    this.color = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.kQS);
    paramParcel.writeInt(this.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameTabData.StatusBar
 * JD-Core Version:    0.7.0.1
 */