package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameFloatLayerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameFloatLayerInfo> CREATOR = new GameFloatLayerInfo.1();
  public boolean kOO = false;
  public int orientation = -1;
  public String url;
  
  public GameFloatLayerInfo() {}
  
  private GameFloatLayerInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.kOO = bool;
      this.orientation = paramParcel.readInt();
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
    paramParcel.writeString(this.url);
    if (this.kOO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.orientation);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameFloatLayerInfo
 * JD-Core Version:    0.7.0.1
 */