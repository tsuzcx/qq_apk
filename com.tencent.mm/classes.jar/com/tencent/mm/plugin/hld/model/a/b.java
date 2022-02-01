package com.tencent.mm.plugin.hld.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.crash.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/recovery/ImeRecovery;", "Lcom/tencent/mm/crash/WeChatNativeCrash$INativeCrashCallback;", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "()V", "TAG", "", "lastCrashNum", "", "lastCrashTime", "maxCrashNum", "monitorTime", "startMonitorTime", "initRecovery", "", "onNativeCrash", "", "recordCrashInfo", "reset", "startMonitor", "uncaughtException", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "ex", "", "plugin-hld_release"})
public final class b
  implements a.b, MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
{
  public static long DEZ;
  public static long DFa;
  public static long DFb;
  public static long DFc;
  public static long DFd;
  public static final b DFe;
  
  static
  {
    AppMethodBeat.i(211549);
    DFe = new b();
    DFa = 60000L;
    DFb = 4L;
    AppMethodBeat.o(211549);
  }
  
  private static void eFv()
  {
    AppMethodBeat.i(211547);
    String str = System.currentTimeMillis() + '_' + (DFd + 1L);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putString("ime_recovery_last_crash_info", str);
    }
    Log.i("WxIme.ImeRecovery", "recordCrashInfo ".concat(String.valueOf(str)));
    AppMethodBeat.o(211547);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(211548);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject != null)
    {
      ((MultiProcessMMKV)localObject).putString("ime_recovery_last_crash_info", "");
      AppMethodBeat.o(211548);
      return;
    }
    AppMethodBeat.o(211548);
  }
  
  public final void ayz()
  {
    AppMethodBeat.i(211543);
    Object localObject = new StringBuilder("onNativeCrash ");
    a locala = a.DEX;
    Log.e("WxIme.ImeRecovery", a.eFt());
    localObject = a.DEX;
    if (!a.eFt()) {
      eFv();
    }
    AppMethodBeat.o(211543);
  }
  
  public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(211545);
    Log.e("WxIme.ImeRecovery", "uncaughtException ");
    eFv();
    AppMethodBeat.o(211545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.a.b
 * JD-Core Version:    0.7.0.1
 */