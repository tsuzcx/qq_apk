package com.tencent.map.lib;

import android.os.Environment;
import java.io.BufferedWriter;
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
    return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
  }
  
  public static void a(String paramString)
  {
    if ((a) && (paramString == null)) {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a) {
      return;
    }
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory() + "/SOSOMap/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      paramString1 = new File((File)localObject, paramString1);
      if (!paramString1.exists()) {
        paramString1.createNewFile();
      }
      paramString1 = new FileWriter(paramString1, true);
      localObject = new BufferedWriter(paramString1);
      ((BufferedWriter)localObject).write(paramString2);
      ((BufferedWriter)localObject).write("\n");
      ((BufferedWriter)localObject).flush();
      ((BufferedWriter)localObject).close();
      paramString1.close();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void a(String paramString, Throwable paramThrowable) {}
  
  public static void b(String paramString) {}
  
  public static void c(String paramString)
  {
    if (!a) {
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
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.d
 * JD-Core Version:    0.7.0.1
 */