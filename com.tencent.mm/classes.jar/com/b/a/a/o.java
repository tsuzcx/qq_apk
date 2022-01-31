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
  private static String bpd;
  private static final SimpleDateFormat bpe;
  private static final SimpleDateFormat bpf;
  
  static
  {
    AppMethodBeat.i(55574);
    bpe = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    bpf = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
    AppMethodBeat.o(55574);
  }
  
  protected static boolean r(String paramString1, String paramString2)
  {
    String str = null;
    AppMethodBeat.i(55575);
    if (bpd == null)
    {
      boolean bool1;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(Environment.getExternalStorageDirectory() + "/" + y.bst);
        boolean bool2 = localFile.exists();
        bool1 = bool2;
        if (!bool2) {
          bool1 = localFile.mkdir();
        }
        if (bool1) {
          str = localFile.toString();
        }
        bpd = str;
      }
      while (!bool1)
      {
        AppMethodBeat.o(55575);
        return false;
        bpd = null;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileWriter(bpd + "/" + paramString1 + ".txt", true);
      paramString1.write("\n" + bpe.format(new Date()) + ',' + paramString2);
      paramString1.flush();
      paramString1.close();
      AppMethodBeat.o(55575);
      return true;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(55575);
    }
    return false;
  }
  
  protected static String tn()
  {
    AppMethodBeat.i(55576);
    String str = bpf.format(new Date());
    AppMethodBeat.o(55576);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a.o
 * JD-Core Version:    0.7.0.1
 */