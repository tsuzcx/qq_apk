package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaPkg$Info
  implements Parcelable
{
  public static final Parcelable.Creator<Info> CREATOR;
  public final String fileName;
  public final int nEy;
  public final int nEz;
  public final String nGF;
  
  static
  {
    AppMethodBeat.i(182981);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182981);
  }
  
  protected WxaPkg$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(182980);
    this.nGF = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.nEy = paramParcel.readInt();
    this.nEz = paramParcel.readInt();
    AppMethodBeat.o(182980);
  }
  
  public WxaPkg$Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.nGF = paramString1;
    this.fileName = paramString2;
    this.nEy = paramInt1;
    this.nEz = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(182979);
    paramParcel.writeString(this.nGF);
    paramParcel.writeString(this.fileName);
    paramParcel.writeInt(this.nEy);
    paramParcel.writeInt(this.nEz);
    AppMethodBeat.o(182979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info
 * JD-Core Version:    0.7.0.1
 */