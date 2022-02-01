package com.d.a.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o
{
  private static String bZu;
  private static final SimpleDateFormat bZv;
  private static final SimpleDateFormat bZw;
  
  static
  {
    AppMethodBeat.i(87919);
    bZv = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    bZw = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
    AppMethodBeat.o(87919);
  }
  
  protected static String Al()
  {
    AppMethodBeat.i(87921);
    String str = bZw.format(new Date());
    AppMethodBeat.o(87921);
    return str;
  }
  
  protected static boolean t(String paramString1, String paramString2)
  {
    String str = null;
    AppMethodBeat.i(87920);
    if (bZu == null)
    {
      boolean bool1;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(Environment.getExternalStorageDirectory() + "/" + y.ccJ);
        boolean bool2 = localFile.exists();
        bool1 = bool2;
        if (!bool2) {
          bool1 = localFile.mkdir();
        }
        if (bool1) {
          str = localFile.toString();
        }
        bZu = str;
      }
      while (!bool1)
      {
        AppMethodBeat.o(87920);
        return false;
        bZu = null;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileWriter(bZu + "/" + paramString1 + ".txt", true);
      paramString1.write("\n" + bZv.format(new Date()) + ',' + paramString2);
      paramString1.flush();
      paramString1.close();
      AppMethodBeat.o(87920);
      return true;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(87920);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.o
 * JD-Core Version:    0.7.0.1
 */