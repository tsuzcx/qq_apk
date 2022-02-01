package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, w.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR;
  public long fileLength;
  public String hHB;
  public String lPJ;
  public String mimeType;
  public String onG;
  public boolean qMj;
  public long qMk;
  
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
    this.hHB = paramParcel.readString();
    this.onG = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.lPJ = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qMj = bool;
      this.fileLength = paramParcel.readLong();
      this.qMk = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long cia()
  {
    return this.fileLength;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.hHB;
  }
  
  public final long lastModified()
  {
    return this.qMk;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.hHB + '\'' + ", fileFullPath='" + this.onG + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.lPJ + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.hHB);
    paramParcel.writeString(this.onG);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.lPJ);
    if (this.qMj) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.fileLength);
      paramParcel.writeLong(this.qMk);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */