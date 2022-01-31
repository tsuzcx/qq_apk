package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameWebViewLaunchParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebViewLaunchParams> CREATOR = new GameWebViewLaunchParams.1();
  public GameFloatLayerInfo kRd;
  
  public GameWebViewLaunchParams() {}
  
  private GameWebViewLaunchParams(Parcel paramParcel)
  {
    this.kRd = ((GameFloatLayerInfo)paramParcel.readParcelable(GameFloatLayerInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.kRd, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.GameWebViewLaunchParams
 * JD-Core Version:    0.7.0.1
 */