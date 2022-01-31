package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@Deprecated
public class AppBrandLocalVideoObject
  extends AppBrandLocalMediaObject
{
  public static final Parcelable.Creator<AppBrandLocalVideoObject> CREATOR = new AppBrandLocalVideoObject.1();
  public int duration;
  public int height;
  public int size;
  public int width;
  
  public AppBrandLocalVideoObject() {}
  
  private AppBrandLocalVideoObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.duration = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject
 * JD-Core Version:    0.7.0.1
 */