package com.samsung.android.sdk;

import android.os.Build;

public class SsdkVendorCheck
{
  private static String strBrand = Build.BRAND;
  private static String strManufacturer = Build.MANUFACTURER;
  
  public static boolean isSamsungDevice()
  {
    if ((strBrand == null) || (strManufacturer == null)) {}
    while ((strBrand.compareToIgnoreCase("Samsung") != 0) && (strManufacturer.compareToIgnoreCase("Samsung") != 0)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.SsdkVendorCheck
 * JD-Core Version:    0.7.0.1
 */