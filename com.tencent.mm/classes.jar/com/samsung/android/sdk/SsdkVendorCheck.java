package com.samsung.android.sdk;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SsdkVendorCheck
{
  private static String strBrand = Build.BRAND;
  private static String strManufacturer = Build.MANUFACTURER;
  
  public static boolean isSamsungDevice()
  {
    AppMethodBeat.i(88043);
    if ((strBrand == null) || (strManufacturer == null))
    {
      AppMethodBeat.o(88043);
      return false;
    }
    if ((strBrand.compareToIgnoreCase("Samsung") != 0) && (strManufacturer.compareToIgnoreCase("Samsung") != 0))
    {
      AppMethodBeat.o(88043);
      return false;
    }
    AppMethodBeat.o(88043);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.samsung.android.sdk.SsdkVendorCheck
 * JD-Core Version:    0.7.0.1
 */