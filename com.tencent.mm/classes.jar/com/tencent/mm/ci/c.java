package com.tencent.mm.ci;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static boolean Jmd = false;
  public static a Jme = null;
  
  public static void abW(int paramInt)
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
      ae.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145592);
          if (c.Jmd)
          {
            ae.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
            AppMethodBeat.o(145592);
            return;
          }
          if (this.Jmf) {}
          for (String str = b.aR(true, false);; str = null)
          {
            Process.setThreadPriority(10);
            boolean bool = az.isWifi(ak.getContext());
            if ((bool3) && (!bool))
            {
              ae.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
              AppMethodBeat.o(145592);
              return;
            }
            if ((bool2) && (str != null)) {}
            for (;;)
            {
              c.access$002(true);
              c.GB(str);
              c.access$002(false);
              AppMethodBeat.o(145592);
              return;
              if (bool1) {
                str = b.Jmc;
              } else {
                str = null;
              }
            }
          }
        }
      });
      AppMethodBeat.o(145593);
      return;
      ae.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
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
  
  static boolean abo()
  {
    AppMethodBeat.i(145594);
    try
    {
      if ((Environment.getExternalStorageState().equals("mounted")) && (ak.getContext().getExternalCacheDir() != null) && (ak.getContext().getExternalCacheDir().canWrite()))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ci.c
 * JD-Core Version:    0.7.0.1
 */