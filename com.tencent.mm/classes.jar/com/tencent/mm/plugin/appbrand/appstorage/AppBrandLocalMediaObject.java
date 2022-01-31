package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalMediaObject
  implements Parcelable, o.a
{
  public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR;
  public String ctV;
  public String elt;
  public String fod;
  public boolean gZm;
  public long gZn;
  public long gmb;
  public String mimeType;
  
  static
  {
    AppMethodBeat.i(105341);
    CREATOR = new AppBrandLocalMediaObject.1();
    AppMethodBeat.o(105341);
  }
  
  protected AppBrandLocalMediaObject() {}
  
  protected AppBrandLocalMediaObject(Parcel paramParcel)
  {
    AppMethodBeat.i(105340);
    this.ctV = paramParcel.readString();
    this.fod = paramParcel.readString();
    this.mimeType = paramParcel.readString();
    this.elt = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gZm = bool;
      this.gmb = paramParcel.readLong();
      this.gZn = paramParcel.readLong();
      AppMethodBeat.o(105340);
      return;
    }
  }
  
  public final long awE()
  {
    return this.gmb;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileName()
  {
    return this.ctV;
  }
  
  public final long lastModified()
  {
    return this.gZn;
  }
  
  public String toString()
  {
    AppMethodBeat.i(105338);
    String str = "AppBrandLocalMediaObject{localId='" + this.ctV + '\'' + ", fileFullPath='" + this.fod + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.elt + '\'' + '}';
    AppMethodBeat.o(105338);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105339);
    paramParcel.writeString(this.ctV);
    paramParcel.writeString(this.fod);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.elt);
    if (this.gZm) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.gmb);
      paramParcel.writeLong(this.gZn);
      AppMethodBeat.o(105339);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
 * JD-Core Version:    0.7.0.1
 */