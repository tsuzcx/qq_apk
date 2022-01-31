package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppIdentity
  implements Parcelable
{
  public static final Parcelable.Creator<AppIdentity> CREATOR = new AppIdentity.1();
  public final int fJy;
  public final String username;
  
  protected AppIdentity(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.fJy = paramParcel.readInt();
  }
  
  public AppIdentity(String paramString, int paramInt)
  {
    this.username = paramString;
    this.fJy = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.fJy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppIdentity
 * JD-Core Version:    0.7.0.1
 */