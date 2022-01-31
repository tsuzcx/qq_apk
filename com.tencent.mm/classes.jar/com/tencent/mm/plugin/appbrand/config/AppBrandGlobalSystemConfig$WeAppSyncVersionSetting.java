package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandGlobalSystemConfig$WeAppSyncVersionSetting
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR;
  public long hir;
  public long hit;
  public int hiu;
  public int hiv;
  
  static
  {
    AppMethodBeat.i(101804);
    CREATOR = new AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.1();
    AppMethodBeat.o(101804);
  }
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting()
  {
    this.hir = 21600L;
    this.hit = 604800L;
    this.hiu = 1000;
    this.hiv = 100;
  }
  
  AppBrandGlobalSystemConfig$WeAppSyncVersionSetting(Parcel paramParcel)
  {
    AppMethodBeat.i(101803);
    this.hir = 21600L;
    this.hit = 604800L;
    this.hiu = 1000;
    this.hiv = 100;
    this.hir = paramParcel.readLong();
    this.hit = paramParcel.readLong();
    this.hiu = paramParcel.readInt();
    this.hiv = paramParcel.readInt();
    AppMethodBeat.o(101803);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101802);
    paramParcel.writeLong(this.hir);
    paramParcel.writeLong(this.hit);
    paramParcel.writeInt(this.hiu);
    paramParcel.writeInt(this.hiv);
    AppMethodBeat.o(101802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting
 * JD-Core Version:    0.7.0.1
 */