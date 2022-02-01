package com.tencent.mm.plugin.hp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final boolean[] ync;
  private static final PeriodRecorder ynd;
  private static final IListener<ps> yne;
  
  static
  {
    AppMethodBeat.i(196792);
    ync = new boolean[] { false };
    ynd = new PeriodRecorder("TinkerHealthStats", TimeUnit.DAYS.toMillis(1L), true, true);
    yne = new IListener() {};
    AppMethodBeat.o(196792);
  }
  
  private static boolean K(File paramFile)
  {
    AppMethodBeat.i(196789);
    File localFile = paramFile.getParentFile();
    paramFile = paramFile.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ".odex");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "arm", "arm64", "x86", "x86_64" }[i];
      if (new File(localFile, "oat/" + str + "/" + paramFile).exists())
      {
        AppMethodBeat.o(196789);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(196789);
    return false;
  }
  
  private static void bB(int paramInt, String paramVarArgs)
  {
    AppMethodBeat.i(196790);
    paramVarArgs = String.format("%s,%s,%s", new Object[] { Integer.valueOf(paramInt), d.cQi, paramVarArgs.replace(",", "##") });
    e.Cxv.a(19725, paramVarArgs, true, true);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", new Object[] { paramVarArgs });
    AppMethodBeat.o(196790);
  }
  
  public static void dZf()
  {
    AppMethodBeat.i(196787);
    if (isInstalled())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
      AppMethodBeat.o(196787);
      return;
    }
    EventCenter.instance.add(yne);
    synchronized (ync)
    {
      ync[0] = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] install done.");
      AppMethodBeat.o(196787);
      return;
    }
  }
  
  private static boolean isInstalled()
  {
    synchronized (ync)
    {
      int i = ync[0];
      return i;
    }
  }
  
  public static void m(Throwable paramThrowable)
  {
    AppMethodBeat.i(196788);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(196788);
      return;
    }
    bB(7, android.util.Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(196788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */