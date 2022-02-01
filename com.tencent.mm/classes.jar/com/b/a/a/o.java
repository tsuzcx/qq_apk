package com.b.a.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o
{
  private static String ckb;
  private static final SimpleDateFormat ckc;
  private static final SimpleDateFormat ckd;
  
  static
  {
    AppMethodBeat.i(87919);
    ckc = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    ckd = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
    AppMethodBeat.o(87919);
  }
  
  protected static String Jf()
  {
    AppMethodBeat.i(87921);
    String str = ckd.format(new Date());
    AppMethodBeat.o(87921);
    return str;
  }
  
  protected static boolean t(String paramString1, String paramString2)
  {
    String str = null;
    AppMethodBeat.i(87920);
    if (ckb == null)
    {
      boolean bool1;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(Environment.getExternalStorageDirectory() + "/" + y.cnp);
        boolean bool2 = localFile.exists();
        bool1 = bool2;
        if (!bool2) {
          bool1 = localFile.mkdir();
        }
        if (bool1) {
          str = localFile.toString();
        }
        ckb = str;
      }
      while (!bool1)
      {
        AppMethodBeat.o(87920);
        return false;
        ckb = null;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileWriter(ckb + "/" + paramString1 + ".txt", true);
      paramString1.write("\n" + ckc.format(new Date()) + ',' + paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.o
 * JD-Core Version:    0.7.0.1
 */