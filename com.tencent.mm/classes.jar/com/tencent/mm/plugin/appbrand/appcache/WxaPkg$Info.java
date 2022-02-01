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
  public final int jFO;
  public final int jFP;
  public final String jHK;
  
  static
  {
    AppMethodBeat.i(182981);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182981);
  }
  
  protected WxaPkg$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(182980);
    this.jHK = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.jFO = paramParcel.readInt();
    this.jFP = paramParcel.readInt();
    AppMethodBeat.o(182980);
  }
  
  public WxaPkg$Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jHK = paramString1;
    this.fileName = paramString2;
    this.jFO = paramInt1;
    this.jFP = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(182979);
    paramParcel.writeString(this.jHK);
    paramParcel.writeString(this.fileName);
    paramParcel.writeInt(this.jFO);
    paramParcel.writeInt(this.jFP);
    AppMethodBeat.o(182979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info
 * JD-Core Version:    0.7.0.1
 */