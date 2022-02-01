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
  public String dsN;
  public String fXl;
  public String hLr;
  public long iTe;
  public boolean jPs;
  public long jPt;
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
    this.dsN = paramParcel.readString();
    this.hLr = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.fXl = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jPs = bool;
      this.iTe = paramParcel.readLong();
      this.jPt = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long bbW()
  {
    return this.iTe;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.dsN;
  }
  
  public final long lastModified()
  {
    return this.jPt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.dsN + '\'' + ", fileFullPath='" + this.hLr + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.fXl + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.dsN);
    paramParcel.writeString(this.hLr);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.fXl);
    if (this.jPs) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.iTe);
      paramParcel.writeLong(this.jPt);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */