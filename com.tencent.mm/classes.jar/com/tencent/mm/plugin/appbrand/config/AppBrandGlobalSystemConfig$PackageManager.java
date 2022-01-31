package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandGlobalSystemConfig$PackageManager
  implements Parcelable
{
  public static final Parcelable.Creator<PackageManager> CREATOR;
  public long hin;
  public long hio;
  public long hip;
  public int hiq;
  
  static
  {
    AppMethodBeat.i(101800);
    CREATOR = new AppBrandGlobalSystemConfig.PackageManager.1();
    AppMethodBeat.o(101800);
  }
  
  public AppBrandGlobalSystemConfig$PackageManager()
  {
    this.hin = 86400L;
    this.hio = 864000L;
    this.hip = 256L;
    this.hiq = 5;
  }
  
  protected AppBrandGlobalSystemConfig$PackageManager(Parcel paramParcel)
  {
    AppMethodBeat.i(101799);
    this.hin = 86400L;
    this.hio = 864000L;
    this.hip = 256L;
    this.hiq = 5;
    this.hin = paramParcel.readLong();
    this.hio = paramParcel.readLong();
    this.hip = paramParcel.readLong();
    this.hiq = paramParcel.readInt();
    AppMethodBeat.o(101799);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101798);
    paramParcel.writeLong(this.hin);
    paramParcel.writeLong(this.hio);
    paramParcel.writeLong(this.hip);
    paramParcel.writeInt(this.hiq);
    AppMethodBeat.o(101798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager
 * JD-Core Version:    0.7.0.1
 */