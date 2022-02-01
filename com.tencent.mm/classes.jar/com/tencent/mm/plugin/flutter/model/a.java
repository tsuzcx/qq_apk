package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
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
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(148871);
        return;
        if (paramd.equals("crash_report")) {
          i = 0;
        }
        break;
      }
    }
    paramd = (Map)paramj.qa("crashInfo");
    String str = (String)paramj.qa("sessionId");
    boolean bool = ((Boolean)paramj.qa("killSelf")).booleanValue();
    paramj = new StringBuffer();
    paramj.append("\n#deviceParameters=" + paramd.get("deviceParameters"));
    paramj.append("\n#customParameters=" + paramd.get("customParameters"));
    paramj.append("\n#applicationParameters=" + paramd.get("applicationParameters"));
    paramj.append("\n#dateTime=" + paramd.get("dateTime"));
    ax localax;
    int j;
    long l1;
    long l2;
    if (((Map)paramd.get("customParameters")).containsKey("AppBrandFlutterRenderUI"))
    {
      localax = ax.eGe();
      i = localax.getInt("flutter_current_version", 0);
      if (i > 0)
      {
        j = localax.getInt("flutter_crash_".concat(String.valueOf(i)), 0);
        l1 = localax.getLong("flutter_crash_time_".concat(String.valueOf(i)), 0L);
        l2 = System.currentTimeMillis();
        if (l2 - l1 <= 3600000L) {
          break label517;
        }
        localax.putInt("flutter_crash_".concat(String.valueOf(i)), 1);
      }
    }
    for (;;)
    {
      localax.putLong("flutter_crash_time_".concat(String.valueOf(i)), l2);
      localax.commit();
      l1 = System.currentTimeMillis();
      ad.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", new Object[] { "FlutterCrash", str });
      e.vIY.f(17326, new Object[] { Long.valueOf(l1), "FlutterCrash", str });
      e.vIY.idkeyStat(1053L, 2L, 1L, false);
      b.N(paramj.toString(), "Flutter\n\tErrorMsg=" + paramd.get("error") + "\n" + paramd.get("stackTrace"));
      ad.eFx();
      if (!bool) {
        break;
      }
      ad.appenderClose();
      Process.killProcess(Process.myPid());
      System.exit(0);
      break;
      label517:
      localax.putInt("flutter_crash_".concat(String.valueOf(i)), j + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.a
 * JD-Core Version:    0.7.0.1
 */