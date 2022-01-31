package com.tencent.mm.ch;

import android.os.Environment;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static boolean uFR = false;
  public static a uFS = null;
  
  public static void FG(int paramInt)
  {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
    for (;;)
    {
      y.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new c.1(bool4, bool3, bool2, bool1));
      return;
      y.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
      System.gc();
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      continue;
      bool1 = false;
      bool2 = true;
      bool3 = false;
      bool4 = true;
      continue;
      bool1 = false;
      bool2 = true;
      bool3 = true;
      bool4 = true;
      continue;
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = true;
      continue;
      bool1 = true;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      continue;
      bool1 = true;
      bool2 = false;
      bool3 = true;
      bool4 = false;
    }
  }
  
  static boolean zF()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        boolean bool3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ch.c
 * JD-Core Version:    0.7.0.1
 */