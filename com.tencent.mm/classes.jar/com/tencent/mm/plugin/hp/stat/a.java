package com.tencent.mm.plugin.hp.stat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.e;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final boolean[] JEs;
  private static final PeriodRecorder JEt;
  private static final IListener<se> JEu;
  
  static
  {
    AppMethodBeat.i(261822);
    JEs = new boolean[] { false };
    JEt = new PeriodRecorder("TinkerHealthStats", TimeUnit.DAYS.toMillis(1L), true, true);
    JEu = new TinkerHealthStats.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(261822);
  }
  
  private static boolean H(File paramFile)
  {
    AppMethodBeat.i(261817);
    File localFile = paramFile.getParentFile();
    paramFile = paramFile.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ".odex");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "arm", "arm64", "x86", "x86_64" }[i];
      if (new File(localFile, "oat/" + str + "/" + paramFile).exists())
      {
        AppMethodBeat.o(261817);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(261817);
    return false;
  }
  
  private static void ce(int paramInt, String paramVarArgs)
  {
    AppMethodBeat.i(261818);
    paramVarArgs = String.format("%s,%s,%s", new Object[] { Integer.valueOf(paramInt), e.eMg, paramVarArgs.replace(",", "##") });
    com.tencent.mm.plugin.report.f.Ozc.b(19725, paramVarArgs, true, true);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", new Object[] { paramVarArgs });
    AppMethodBeat.o(261818);
  }
  
  public static void fPV()
  {
    AppMethodBeat.i(261813);
    if (isInstalled())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
      AppMethodBeat.o(261813);
      return;
    }
    JEu.alive();
    synchronized (JEs)
    {
      JEs[0] = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] install done.");
      AppMethodBeat.o(261813);
      return;
    }
  }
  
  private static boolean isInstalled()
  {
    synchronized (JEs)
    {
      int i = JEs[0];
      return i;
    }
  }
  
  public static void z(Throwable paramThrowable)
  {
    AppMethodBeat.i(261814);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(261814);
      return;
    }
    ce(7, android.util.Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(261814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.stat.a
 * JD-Core Version:    0.7.0.1
 */