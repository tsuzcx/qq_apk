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
  public final int iLR;
  public final int iLS;
  public final String iNF;
  
  static
  {
    AppMethodBeat.i(182981);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182981);
  }
  
  protected WxaPkg$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(182980);
    this.iNF = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.iLR = paramParcel.readInt();
    this.iLS = paramParcel.readInt();
    AppMethodBeat.o(182980);
  }
  
  public WxaPkg$Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.iNF = paramString1;
    this.fileName = paramString2;
    this.iLR = paramInt1;
    this.iLS = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(182979);
    paramParcel.writeString(this.iNF);
    paramParcel.writeString(this.fileName);
    paramParcel.writeInt(this.iLR);
    paramParcel.writeInt(this.iLS);
    AppMethodBeat.o(182979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info
 * JD-Core Version:    0.7.0.1
 */