package com.tencent.mm.plugin.appbrand.crash_report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportFullMonitor;", "", "()V", "KEYS_ANR", "", "KEYS_JAVA_CRASH", "KEYS_JNI_CRASH", "TAG", "", "batchReportIDKey", "", "array", "reportANR", "reportActivityCreated", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "reportActivityDestroyed", "reportAppBrandRuntimeCreated", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "reportIDKey", "id", "", "key", "reportJavaCrash", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "ex", "", "reportJniCrash", "message", "setup", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b rcV;
  private static final int[] rcW;
  private static final int[] rcX;
  static final int[] rcY;
  
  static
  {
    AppMethodBeat.i(319273);
    rcV = new b();
    rcW = new int[] { 31, 34, 37 };
    rcX = new int[] { 32, 35, 38 };
    rcY = new int[] { 33, 36, 39 };
    AppMethodBeat.o(319273);
  }
  
  private final void Yb(String paramString)
  {
    AppMethodBeat.i(319263);
    w(rcX);
    AppMethodBeat.o(319263);
  }
  
  public static final void Z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(319269);
    s.u(paramAppBrandRuntime, "rt");
    zJ(28);
    AppMethodBeat.o(319269);
  }
  
  private final void a(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(319258);
    w(rcW);
    AppMethodBeat.o(319258);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(319257);
    MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new b..ExternalSyntheticLambda1(rcV));
    CrashReportFactory.addCrashReportListener(new b..ExternalSyntheticLambda0(rcV));
    new AppBrandCrashReportFullMonitor.setup.3(f.hfK).alive();
    AppMethodBeat.o(319257);
  }
  
  static void w(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(319267);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(365, paramArrayOfInt[0], 1));
    Object localObject = a.rcS;
    int i = a.cln();
    if (i == 4) {
      localArrayList.add(new IDKey(365, paramArrayOfInt[2], 1));
    }
    while (Log.getLogLevel() <= 1)
    {
      paramArrayOfInt = ((Iterable)localArrayList).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (IDKey)paramArrayOfInt.next();
        Log.d("MicroMsg.AppBrandCrashReportFullMonitor", "batchReportIDKey, id:" + ((IDKey)localObject).GetID() + "->key:" + ((IDKey)localObject).GetKey());
      }
      if (i >= 0) {
        localArrayList.add(new IDKey(365, paramArrayOfInt[1], 1));
      }
    }
    h.OAn.b(localArrayList, false);
    AppMethodBeat.o(319267);
  }
  
  public static void zJ(int paramInt)
  {
    AppMethodBeat.i(319272);
    h.OAn.kJ(365, paramInt);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.AppBrandCrashReportFullMonitor", "reportIDKey, id:365->key:" + paramInt);
    }
    AppMethodBeat.o(319272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.crash_report.b
 * JD-Core Version:    0.7.0.1
 */