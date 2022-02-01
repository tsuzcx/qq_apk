package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.Map;

public final class a
  implements k.c
{
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148871);
    ac.d("MicroMsg.Flutter.FlutterCrashReportPlugin", "onMethodCall method", new Object[] { paramj.method });
    paramd = paramj.method;
    int i = -1;
    switch (paramd.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(148871);
      return;
      if (!paramd.equals("crash_report")) {
        break;
      }
      i = 0;
      break;
      paramd = (Map)paramj.tn("crashInfo");
      String str = (String)paramj.tn("sessionId");
      boolean bool = ((Boolean)paramj.tn("killSelf")).booleanValue();
      paramj = new StringBuffer();
      paramj.append("\n#deviceParameters=" + paramd.get("deviceParameters"));
      paramj.append("\n#customParameters=" + paramd.get("customParameters"));
      paramj.append("\n#applicationParameters=" + paramd.get("applicationParameters"));
      paramj.append("\n#dateTime=" + paramd.get("dateTime"));
      com.tencent.mm.plugin.flutter.e.a locala = com.tencent.mm.plugin.flutter.e.a.wZq;
      com.tencent.mm.plugin.flutter.e.a.b(paramd, bool);
      long l = System.currentTimeMillis();
      ac.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", new Object[] { "FlutterCrash", str });
      e.wTc.f(17326, new Object[] { Long.valueOf(l), "FlutterCrash", str });
      e.wTc.idkeyStat(1053L, 2L, 1L, false);
      b.O(paramj.toString(), "Flutter\n\tErrorMsg=" + paramd.get("error") + "\n" + paramd.get("stackTrace") + "\nkillSelf" + bool);
      ac.eUR();
      if (bool)
      {
        ac.appenderClose();
        Process.killProcess(Process.myPid());
        System.exit(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.a
 * JD-Core Version:    0.7.0.1
 */