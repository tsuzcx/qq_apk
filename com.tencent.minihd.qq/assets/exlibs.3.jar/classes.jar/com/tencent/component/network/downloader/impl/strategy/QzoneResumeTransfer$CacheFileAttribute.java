package com.tencent.component.network.downloader.impl.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cup;

public class QzoneResumeTransfer$CacheFileAttribute
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cup();
  public String a;
  public String b;
  
  public QzoneResumeTransfer$CacheFileAttribute(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public QzoneResumeTransfer$CacheFileAttribute(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof CacheFileAttribute))) {
        break;
      }
      paramObject = (CacheFileAttribute)paramObject;
    } while ((TextUtils.equals(this.a, paramObject.a)) && (TextUtils.equals(this.b, paramObject.b)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return "CacheFileAttr --- ContentType:" + this.a + " LastModify:" + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer.CacheFileAttribute
 * JD-Core Version:    0.7.0.1
 */