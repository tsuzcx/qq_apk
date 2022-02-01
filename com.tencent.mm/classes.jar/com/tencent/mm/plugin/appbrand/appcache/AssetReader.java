package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Locale;

public final class AssetReader
  extends AbsReader
{
  public static final Parcelable.Creator<AssetReader> CREATOR;
  public static final AssetReader kKj;
  private final WxaPkgWrappingInfo kKi;
  
  static
  {
    AppMethodBeat.i(139824);
    kKj = new AssetReader();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(139824);
  }
  
  public AssetReader()
  {
    AppMethodBeat.i(139822);
    this.kKi = new WxaPkgWrappingInfo();
    this.kKi.kNY = true;
    this.kKi.kNW = 0;
    this.kKi.pkgVersion = ay.VERSION;
    this.kKi.md5 = "";
    AppMethodBeat.o(139822);
  }
  
  private AssetReader(Parcel paramParcel)
  {
    this();
  }
  
  public final void close() {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139821);
    paramString = ay.openRead(paramString);
    AppMethodBeat.o(139821);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(139823);
    String str = String.format(Locale.ENGLISH, "AssetReader[%d][%s]", new Object[] { Integer.valueOf(bvd()), bvb() });
    AppMethodBeat.o(139823);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.AssetReader
 * JD-Core Version:    0.7.0.1
 */