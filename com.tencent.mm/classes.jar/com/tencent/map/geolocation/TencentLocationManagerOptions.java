package com.tencent.map.geolocation;

import android.text.TextUtils;

public class TencentLocationManagerOptions
{
  private static boolean a = true;
  private static String b = "";
  
  public static String getKey()
  {
    return b;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return a;
  }
  
  public static boolean setKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    b = paramString;
    return true;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManagerOptions
 * JD-Core Version:    0.7.0.1
 */