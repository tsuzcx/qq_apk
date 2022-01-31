package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, k.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR = new AppBrandLocalMediaObject.1();
  public String bMB;
  public String dXY;
  public long eUd;
  public String fGv;
  public boolean fGw;
  public long fGx;
  public String mimeType;
  
  protected AppBrandLocalMediaObject() {}
  
  protected AppBrandLocalMediaObject(Parcel paramParcel)
  {
    this.bMB = paramParcel.readString();
    this.dXY = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.fGv = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fGw = bool;
      this.eUd = paramParcel.readLong();
      this.fGx = paramParcel.readLong();
      return;
    }
  }
  
  public final long acG()
  {
    return this.eUd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.bMB;
  }
  
  public final long lastModified()
  {
    return this.fGx;
  }
  
  public String toString()
  {
    return "AppBrandLocalMediaObject{localId='" + this.bMB + '\'' + ", fileFullPath='" + this.dXY + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.fGv + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bMB);
    paramParcel.writeString(this.dXY);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.fGv);
    if (this.fGw) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.eUd);
      paramParcel.writeLong(this.fGx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */