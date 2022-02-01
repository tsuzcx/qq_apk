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
  public String dgl;
  public String fBR;
  public String hqg;
  public long ixc;
  public boolean jsm;
  public long jsn;
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
    this.dgl = paramParcel.readString();
    this.hqg = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.fBR = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jsm = bool;
      this.ixc = paramParcel.readLong();
      this.jsn = paramParcel.readLong();
      AppMethodBeat.o(134302);
      return;
    }
  }
  
  public final long aXW()
  {
    return this.ixc;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.dgl;
  }
  
  public final long lastModified()
  {
    return this.jsn;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134300);
    String str = "AppBrandLocalMediaObject{localId='" + this.dgl + '\'' + ", fileFullPath='" + this.hqg + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.fBR + '\'' + '}';
    AppMethodBeat.o(134300);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134301);
    paramParcel.writeString(this.dgl);
    paramParcel.writeString(this.hqg);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.fBR);
    if (this.jsm) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.ixc);
      paramParcel.writeLong(this.jsn);
      AppMethodBeat.o(134301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */