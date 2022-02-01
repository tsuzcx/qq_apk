package com.tencent.mm.ck;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static boolean FFc = false;
  public static a FFd = null;
  
  public static void WV(int paramInt)
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
      ad.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145592);
          if (c.FFc)
          {
            ad.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
            AppMethodBeat.o(145592);
            return;
          }
          if (this.FFe) {}
          for (String str = b.aH(true, false);; str = null)
          {
            Process.setThreadPriority(10);
            boolean bool = ay.isWifi(aj.getContext());
            if ((bool3) && (!bool))
            {
              ad.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
              AppMethodBeat.o(145592);
              return;
            }
            if ((bool2) && (str != null)) {}
            for (;;)
            {
              c.cz(true);
              c.yP(str);
              c.cz(false);
              AppMethodBeat.o(145592);
              return;
              if (bool1) {
                str = b.FFb;
              } else {
                str = null;
              }
            }
          }
        }
      });
      AppMethodBeat.o(145593);
      return;
      ad.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
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
  
  static boolean XG()
  {
    AppMethodBeat.i(145594);
    try
    {
      if ((Environment.getExternalStorageState().equals("mounted")) && (aj.getContext().getExternalCacheDir() != null) && (aj.getContext().getExternalCacheDir().canWrite()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ck.c
 * JD-Core Version:    0.7.0.1
 */