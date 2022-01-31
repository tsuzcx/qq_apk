package com.tencent.map.lib;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d
{
  public static boolean a = false;
  
  private static String a()
  {
    AppMethodBeat.i(97860);
    String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    AppMethodBeat.o(97860);
    return str;
  }
  
  public static void a(String paramString)
  {
    if ((a) && (paramString == null)) {}
  }
  
  public static void a(String paramString, Throwable paramThrowable) {}
  
  public static void b(String paramString) {}
  
  public static void c(String paramString)
  {
    AppMethodBeat.i(97859);
    if (!a)
    {
      AppMethodBeat.o(97859);
      return;
    }
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "xiaozhi.txt");
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = new FileWriter((File)localObject, true);
      ((FileWriter)localObject).write(a() + " " + paramString + "\n");
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      AppMethodBeat.o(97859);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(97859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.d
 * JD-Core Version:    0.7.0.1
 */