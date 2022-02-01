package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
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
    ad.d("MicroMsg.Flutter.FlutterCrashReportPlugin", "onMethodCall method", new Object[] { paramj.method });
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
      paramd = (Map)paramj.wd("crashInfo");
      String str = (String)paramj.wd("sessionId");
      boolean bool = ((Boolean)paramj.wd("killSelf")).booleanValue();
      paramj = new StringBuffer();
      paramj.append("\n#deviceParameters=" + paramd.get("deviceParameters"));
      paramj.append("\n#customParameters=" + paramd.get("customParameters"));
      paramj.append("\n#applicationParameters=" + paramd.get("applicationParameters"));
      paramj.append("\n#dateTime=" + paramd.get("dateTime"));
      com.tencent.mm.plugin.flutter.c.a locala = com.tencent.mm.plugin.flutter.c.a.tiD;
      com.tencent.mm.plugin.flutter.c.a.b(paramd, bool);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", new Object[] { "FlutterCrash", str });
      e.ygI.f(17326, new Object[] { Long.valueOf(l), "FlutterCrash", str });
      e.ygI.idkeyStat(1053L, 2L, 1L, false);
      b.P(paramj.toString(), "Flutter\n\tErrorMsg=" + paramd.get("error") + "\n" + paramd.get("stackTrace") + "\nkillSelf" + bool);
      ad.fkv();
      if (bool)
      {
        ad.appenderClose();
        paramj = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramd = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramd, paramj.ahp(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramj.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        paramj = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        paramd = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramd, paramj.ahp(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)paramj.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.a
 * JD-Core Version:    0.7.0.1
 */