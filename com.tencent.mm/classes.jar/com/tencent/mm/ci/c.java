package com.tencent.mm.ci;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static boolean ySJ = false;
  public static a ySK = null;
  
  static boolean Mi()
  {
    AppMethodBeat.i(76901);
    try
    {
      if ((Environment.getExternalStorageState().equals("mounted")) && (new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite()))
      {
        AppMethodBeat.o(76901);
        return true;
      }
      AppMethodBeat.o(76901);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(76901);
    }
    return false;
  }
  
  public static void NR(int paramInt)
  {
    AppMethodBeat.i(76900);
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
      ab.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new c.1(bool4, bool3, bool2, bool1));
      AppMethodBeat.o(76900);
      return;
      ab.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ci.c
 * JD-Core Version:    0.7.0.1
 */