package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.d;
import com.tencent.mm.protocal.c.agd;

public class GameMenuParcel
  implements Parcelable
{
  public static final Parcelable.Creator<GameMenuParcel> CREATOR = new GameMenuParcel.1();
  public String appId;
  public agd gay;
  
  public GameMenuParcel() {}
  
  private GameMenuParcel(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.gay = ((agd)c.a(d.class.getName(), paramParcel));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    c.a(this.gay, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.cgipkg.GameMenuParcel
 * JD-Core Version:    0.7.0.1
 */