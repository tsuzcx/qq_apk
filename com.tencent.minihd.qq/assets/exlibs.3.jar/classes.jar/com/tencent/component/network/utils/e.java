package com.tencent.component.network.utils;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class e
{
  public static long a()
  {
    if (!a()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static String a()
  {
    return Environment.getExternalStorageState();
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  private static String a(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + a(paramInt);
    }
    return a(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static String a(long paramLong)
  {
    return a(0, (float)paramLong);
  }
  
  public static boolean a()
  {
    return a().equals("mounted");
  }
  
  public static long b()
  {
    if (!a()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static String b()
  {
    long l = a();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
  
  public static String c()
  {
    long l = b();
    if (l >= 0L) {
      return a(l);
    }
    return "无SD Card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.e
 * JD-Core Version:    0.7.0.1
 */