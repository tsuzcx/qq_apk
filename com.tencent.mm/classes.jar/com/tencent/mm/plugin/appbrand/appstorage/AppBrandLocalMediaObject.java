package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, q.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR;
  public String dJX;
  public String gCr;
  public String iGf;
  public long jPY;
  public boolean kSa;
  public long kSb;
  public String mimeType;
  
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
    this.dJX = paramParcel.readString();
    this.iGf = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.gCr = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kSa = bool;
      this.jPY = paramParcel.readLong();
      this.kSb = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long bxm()
  {
    return this.jPY;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.dJX;
  }
  
  public final long lastModified()
  {
    return this.kSb;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.dJX + '\'' + ", fileFullPath='" + this.iGf + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.gCr + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.dJX);
    paramParcel.writeString(this.iGf);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.gCr);
    if (this.kSa) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.jPY);
      paramParcel.writeLong(this.kSb);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */