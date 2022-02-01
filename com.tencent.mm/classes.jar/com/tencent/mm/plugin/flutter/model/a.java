package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.Map;

public final class a
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  private k wJr;
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(240942);
    Log.i("MicroMsg.Flutter.FlutterCrashReportPlugin", "onAttachedToEngine FlutterCrashReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.crashreport" });
    this.wJr = new k(paramb.SOH, "com.tencent.mm.flutter.crashreport");
    this.wJr.a(this);
    AppMethodBeat.o(240942);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148871);
    Log.d("MicroMsg.Flutter.FlutterCrashReportPlugin", "onMethodCall method", new Object[] { paramj.method });
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
      paramd = (Map)paramj.btq("crashInfo");
      String str = (String)paramj.btq("sessionId");
      boolean bool = ((Boolean)paramj.btq("killSelf")).booleanValue();
      paramj = new StringBuffer();
      paramj.append("\n#deviceParameters=" + paramd.get("deviceParameters"));
      paramj.append("\n#customParameters=" + paramd.get("customParameters"));
      paramj.append("\n#applicationParameters=" + paramd.get("applicationParameters"));
      paramj.append("\n#dateTime=" + paramd.get("dateTime"));
      com.tencent.mm.plugin.flutter.c.a locala = com.tencent.mm.plugin.flutter.c.a.wJq;
      com.tencent.mm.plugin.flutter.c.a.b(paramd, bool);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", new Object[] { "FlutterCrash", str });
      e.Cxv.a(17326, new Object[] { Long.valueOf(l), "FlutterCrash", str });
      e.Cxv.idkeyStat(1053L, 2L, 1L, false);
      CrashReportFactory.reportCrashMessage(paramj.toString(), "Flutter\n\tErrorMsg=" + paramd.get("error") + "\n" + paramd.get("stackTrace") + "\nkillSelf" + bool);
      Log.appenderFlushSync();
      if (bool)
      {
        Log.appenderClose();
        paramj = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramd = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramd, paramj.axQ(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramj.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        paramj = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        paramd = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramd, paramj.axQ(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)paramj.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      }
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(240943);
    this.wJr.a(null);
    AppMethodBeat.o(240943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.a
 * JD-Core Version:    0.7.0.1
 */