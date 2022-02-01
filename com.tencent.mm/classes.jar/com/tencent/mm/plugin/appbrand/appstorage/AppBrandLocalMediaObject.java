package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, p.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR;
  public String drH;
  public String fVf;
  public String hIy;
  public long iQl;
  public boolean jMg;
  public long jMh;
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
    this.drH = paramParcel.readString();
    this.hIy = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.fVf = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jMg = bool;
      this.iQl = paramParcel.readLong();
      this.jMh = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long bbu()
  {
    return this.iQl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.drH;
  }
  
  public final long lastModified()
  {
    return this.jMh;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.drH + '\'' + ", fileFullPath='" + this.hIy + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.fVf + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.drH);
    paramParcel.writeString(this.hIy);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.fVf);
    if (this.jMg) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.iQl);
      paramParcel.writeLong(this.jMh);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */