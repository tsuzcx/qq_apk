package com.tencent.mm.cj;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static boolean Hef = false;
  public static a Heg = null;
  
  static boolean YD()
  {
    AppMethodBeat.i(145594);
    try
    {
      if ((Environment.getExternalStorageState().equals("mounted")) && (ai.getContext().getExternalCacheDir() != null) && (ai.getContext().getExternalCacheDir().canWrite()))
      {
        AppMethodBeat.o(145594);
        return true;
      }
      AppMethodBeat.o(145594);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(145594);
    }
    return false;
  }
  
  public static void Zf(int paramInt)
  {
    AppMethodBeat.i(145593);
    final boolean bool1;
    final boolean bool2;
    final boolean bool3;
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
      ac.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145592);
          if (c.Hef)
          {
            ac.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
            AppMethodBeat.o(145592);
            return;
          }
          if (this.Heh) {}
          for (String str = b.aL(true, false);; str = null)
          {
            Process.setThreadPriority(10);
            boolean bool = ax.isWifi(ai.getContext());
            if ((bool3) && (!bool))
            {
              ac.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
              AppMethodBeat.o(145592);
              return;
            }
            if ((bool2) && (str != null)) {}
            for (;;)
            {
              c.access$002(true);
              c.CU(str);
              c.access$002(false);
              AppMethodBeat.o(145592);
              return;
              if (bool1) {
                str = b.Hee;
              } else {
                str = null;
              }
            }
          }
        }
      });
      AppMethodBeat.o(145593);
      return;
      ac.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
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
 * Qualified Name:     com.tencent.mm.cj.c
 * JD-Core Version:    0.7.0.1
 */