package com.tencent.mm.plugin.hp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final boolean[] DNe;
  private static final PeriodRecorder DNf;
  private static final IListener<qq> DNg;
  
  static
  {
    AppMethodBeat.i(195936);
    DNe = new boolean[] { false };
    DNf = new PeriodRecorder("TinkerHealthStats", TimeUnit.DAYS.toMillis(1L), true, true);
    DNg = new IListener() {};
    AppMethodBeat.o(195936);
  }
  
  private static boolean C(File paramFile)
  {
    AppMethodBeat.i(195923);
    File localFile = paramFile.getParentFile();
    paramFile = paramFile.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ".odex");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "arm", "arm64", "x86", "x86_64" }[i];
      if (new File(localFile, "oat/" + str + "/" + paramFile).exists())
      {
        AppMethodBeat.o(195923);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(195923);
    return false;
  }
  
  private static boolean Vt()
  {
    synchronized (DNe)
    {
      int i = DNe[0];
      return i;
    }
  }
  
  private static void by(int paramInt, String paramVarArgs)
  {
    AppMethodBeat.i(195925);
    paramVarArgs = String.format("%s,%s,%s", new Object[] { Integer.valueOf(paramInt), d.cQP, paramVarArgs.replace(",", "##") });
    f.Iyx.b(19725, paramVarArgs, true, true);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", new Object[] { paramVarArgs });
    AppMethodBeat.o(195925);
  }
  
  public static void eIc()
  {
    AppMethodBeat.i(195916);
    if (Vt())
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
      AppMethodBeat.o(195916);
      return;
    }
    EventCenter.instance.add(DNg);
    synchronized (DNe)
    {
      DNe[0] = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.TinkerHealthStats", "[+] install done.");
      AppMethodBeat.o(195916);
      return;
    }
  }
  
  public static void m(Throwable paramThrowable)
  {
    AppMethodBeat.i(195919);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(195919);
      return;
    }
    by(7, android.util.Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(195919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */