package com.tencent.mm.plugin.hld.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.crash.b.b;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/recovery/ImeRecovery;", "Lcom/tencent/mm/crash/WeChatNativeCrash$INativeCrashCallback;", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "()V", "TAG", "", "lastCrashNum", "", "lastCrashTime", "maxCrashNum", "monitorTime", "startMonitorTime", "initRecovery", "", "onNativeCrash", "", "recordCrashInfo", "reset", "startMonitor", "uncaughtException", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "ex", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements b.b, MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  public static final b JwG;
  public static long JwH;
  public static long JwI;
  public static long JwJ;
  public static long JwK;
  public static long JwL;
  
  static
  {
    AppMethodBeat.i(312036);
    JwG = new b();
    JwI = 60000L;
    JwJ = 4L;
    AppMethodBeat.o(312036);
  }
  
  private static void fNn()
  {
    AppMethodBeat.i(312020);
    String str = System.currentTimeMillis() + '_' + (JwL + 1L);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putString("ime_recovery_last_crash_info", str);
    }
    Log.i("WxIme.ImeRecovery", s.X("recordCrashInfo ", str));
    AppMethodBeat.o(312020);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(312029);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putString("ime_recovery_last_crash_info", "");
    }
    AppMethodBeat.o(312029);
  }
  
  public final void aTc()
  {
    AppMethodBeat.i(312044);
    a locala = a.JwD;
    Log.e("WxIme.ImeRecovery", s.X("onNativeCrash ", Boolean.valueOf(a.fNk())));
    locala = a.JwD;
    if (!a.fNk()) {
      fNn();
    }
    AppMethodBeat.o(312044);
  }
  
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(312051);
    Log.e("WxIme.ImeRecovery", "uncaughtException ");
    fNn();
    AppMethodBeat.o(312051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.a.b
 * JD-Core Version:    0.7.0.1
 */