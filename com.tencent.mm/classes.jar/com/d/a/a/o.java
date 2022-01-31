package com.d.a.a;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o
{
  private static String aYw;
  private static final SimpleDateFormat aYx = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
  private static final SimpleDateFormat aYy = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
  
  protected static boolean m(String paramString1, String paramString2)
  {
    String str = null;
    if (aYw == null)
    {
      boolean bool1;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(Environment.getExternalStorageDirectory() + "/" + y.bbN);
        boolean bool2 = localFile.exists();
        bool1 = bool2;
        if (!bool2) {
          bool1 = localFile.mkdir();
        }
        if (bool1) {
          str = localFile.toString();
        }
        aYw = str;
      }
      while (!bool1)
      {
        return false;
        aYw = null;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileWriter(aYw + "/" + paramString1 + ".txt", true);
      paramString1.write("\n" + aYx.format(new Date()) + ',' + paramString2);
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected static String ph()
  {
    return aYy.format(new Date());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.o
 * JD-Core Version:    0.7.0.1
 */