package com.google.android.gms.internal;

import android.os.Build.VERSION;
import java.io.File;

public class zzsv
{
  public static int version()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zztc.zzf("Invalid version number", Build.VERSION.SDK);
    }
    return 0;
  }
  
  public static boolean zzca(String paramString)
  {
    if (version() < 9) {
      return false;
    }
    paramString = new File(paramString);
    paramString.setReadable(false, false);
    paramString.setWritable(false, false);
    paramString.setReadable(true, true);
    paramString.setWritable(true, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzsv
 * JD-Core Version:    0.7.0.1
 */