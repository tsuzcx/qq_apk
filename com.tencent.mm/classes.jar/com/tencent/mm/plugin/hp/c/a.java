package com.tencent.mm.plugin.hp.c;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ba;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final boolean[] uUB;
  private static final ba uUC;
  private static final c<pa> uUD;
  
  static
  {
    AppMethodBeat.i(196784);
    uUB = new boolean[] { false };
    uUC = new ba("TinkerHealthStats", TimeUnit.DAYS.toMillis(1L));
    uUD = new c() {};
    AppMethodBeat.o(196784);
  }
  
  private static boolean HS()
  {
    synchronized (uUB)
    {
      int i = uUB[0];
      return i;
    }
  }
  
  private static boolean J(File paramFile)
  {
    AppMethodBeat.i(196781);
    File localFile = paramFile.getParentFile();
    paramFile = paramFile.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ".odex");
    int i = 0;
    while (i < 4)
    {
      String str = new String[] { "arm", "arm64", "x86", "x86_64" }[i];
      if (new File(localFile, "oat/" + str + "/" + paramFile).exists())
      {
        AppMethodBeat.o(196781);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(196781);
    return false;
  }
  
  private static void bp(int paramInt, String paramVarArgs)
  {
    AppMethodBeat.i(196782);
    paramVarArgs = String.format("%s,%s,%s", new Object[] { Integer.valueOf(paramInt), d.cEw, paramVarArgs.replace(",", "##") });
    e.ywz.a(19725, paramVarArgs, true, true);
    ae.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", new Object[] { paramVarArgs });
    AppMethodBeat.o(196782);
  }
  
  public static void dfl()
  {
    AppMethodBeat.i(196779);
    if (HS())
    {
      ae.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
      AppMethodBeat.o(196779);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.b(uUD);
    synchronized (uUB)
    {
      uUB[0] = true;
      ae.i("MicroMsg.TinkerHealthStats", "[+] install done.");
      AppMethodBeat.o(196779);
      return;
    }
  }
  
  public static void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(196780);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(196780);
      return;
    }
    bp(7, Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(196780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a
 * JD-Core Version:    0.7.0.1
 */