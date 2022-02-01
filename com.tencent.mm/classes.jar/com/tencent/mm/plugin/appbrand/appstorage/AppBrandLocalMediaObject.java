package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, r.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR;
  public String fCM;
  public String jmx;
  public String lwh;
  public long mHi;
  public String mimeType;
  public boolean nMi;
  public long nMj;
  
  static
  {
    AppMethodBeat.i(134303);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134303);
  }
  
  protected AppBrandLocalMediaObject() {}
  
  protected AppBrandLocalMediaObject(Parcel paramParcel)
  {
    AppMethodBeat.i(134302);
    this.fCM = paramParcel.readString();
    this.lwh = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.jmx = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nMi = bool;
      this.mHi = paramParcel.readLong();
      this.nMj = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long bIw()
  {
    return this.mHi;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.fCM;
  }
  
  public final long lastModified()
  {
    return this.nMj;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.fCM + '\'' + ", fileFullPath='" + this.lwh + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.jmx + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.fCM);
    paramParcel.writeString(this.lwh);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.jmx);
    if (this.nMi) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.mHi);
      paramParcel.writeLong(this.nMj);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */