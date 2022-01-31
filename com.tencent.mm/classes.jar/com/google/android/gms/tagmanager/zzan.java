package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

class zzan
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
      str = String.valueOf(Build.VERSION.SDK);
      if (str.length() == 0) {}
    }
    for (String str = "Invalid version number: ".concat(str);; str = new String("Invalid version number: "))
    {
      zzbo.e(str);
      return 0;
    }
  }
  
  @TargetApi(9)
  static boolean zzca(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzan
 * JD-Core Version:    0.7.0.1
 */