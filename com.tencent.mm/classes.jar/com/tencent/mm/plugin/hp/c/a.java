package com.tencent.mm.plugin.hp.c;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final boolean[] uIO;
  private static final az uIP;
  private static final c<oz> uIQ;
  
  static
  {
    AppMethodBeat.i(218917);
    uIO = new boolean[] { false };
    uIP = new az("TinkerHealthStats", TimeUnit.DAYS.toMillis(1L));
    uIQ = new c() {};
    AppMethodBeat.o(218917);
  }
  
  private static boolean HK()
  {
    synchronized (uIO)
    {
      int i = uIO[0];
      return i;
    }
  }
  
  private static boolean J(File paramFile)
  {
    AppMethodBeat.i(218914);
    File localFile = paramFile.getParentFile();
    paramFile = paramFile.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ".odex");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "arm", "arm64", "x86", "x86_64" }[i];
      if (new File(localFile, "oat/" + str + "/" + paramFile).exists())
      {
        AppMethodBeat.o(218914);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(218914);
    return false;
  }
  
  private static void bq(int paramInt, String paramVarArgs)
  {
    AppMethodBeat.i(218915);
    paramVarArgs = String.format("%s,%s,%s", new Object[] { Integer.valueOf(paramInt), d.cDP, paramVarArgs.replace(",", "##") });
    e.ygI.a(19725, paramVarArgs, true, true);
    ad.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", new Object[] { paramVarArgs });
    AppMethodBeat.o(218915);
  }
  
  public static void dct()
  {
    AppMethodBeat.i(218912);
    if (HK())
    {
      ad.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
      AppMethodBeat.o(218912);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.b(uIQ);
    synchronized (uIO)
    {
      uIO[0] = true;
      ad.i("MicroMsg.TinkerHealthStats", "[+] install done.");
      AppMethodBeat.o(218912);
      return;
    }
  }
  
  public static void k(Throwable paramThrowable)
  {
    AppMethodBeat.i(218913);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(218913);
      return;
    }
    bq(7, Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(218913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */