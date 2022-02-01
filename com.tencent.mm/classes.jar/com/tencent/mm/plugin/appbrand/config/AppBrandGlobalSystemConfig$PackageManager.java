package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandGlobalSystemConfig$PackageManager
  implements Parcelable
{
  public static final Parcelable.Creator<PackageManager> CREATOR;
  public long nXO;
  public long nXP;
  public long nXQ;
  public int nXR;
  
  static
  {
    AppMethodBeat.i(146976);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146976);
  }
  
  public AppBrandGlobalSystemConfig$PackageManager()
  {
    this.nXO = 86400L;
    this.nXP = 864000L;
    this.nXQ = 256L;
    this.nXR = 5;
  }
  
  protected AppBrandGlobalSystemConfig$PackageManager(Parcel paramParcel)
  {
    AppMethodBeat.i(146975);
    this.nXO = 86400L;
    this.nXP = 864000L;
    this.nXQ = 256L;
    this.nXR = 5;
    this.nXO = paramParcel.readLong();
    this.nXP = paramParcel.readLong();
    this.nXQ = paramParcel.readLong();
    this.nXR = paramParcel.readInt();
    AppMethodBeat.o(146975);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146974);
    paramParcel.writeLong(this.nXO);
    paramParcel.writeLong(this.nXP);
    paramParcel.writeLong(this.nXQ);
    paramParcel.writeInt(this.nXR);
    AppMethodBeat.o(146974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager
 * JD-Core Version:    0.7.0.1
 */