package com.tencent.mm.plugin.crashfix.d.e;

import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean Fh(int paramInt)
  {
    AppMethodBeat.i(145639);
    if ((paramInt == 24) || (paramInt == 25))
    {
      Log.i("MicroMsg.WeakGlobalRefFix", "api ".concat(String.valueOf(paramInt)));
      paramInt = ((b)g.af(b.class)).a(b.a.seQ, 1);
      Log.i("MicroMsg.WeakGlobalRefFix", "Expt : ".concat(String.valueOf(paramInt)));
      if (paramInt == 0)
      {
        AppMethodBeat.o(145639);
        return false;
      }
      if (paramInt == 2)
      {
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("weakglobal_fix");
        localMultiProcessMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
        localMultiProcessMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
        localMultiProcessMMKV.commit();
      }
      AppMethodBeat.o(145639);
      return true;
    }
    AppMethodBeat.o(145639);
    return false;
  }
  
  public final void cAM()
  {
    AppMethodBeat.i(145637);
    MultiProcessMMKV.getSingleMMKV("weakglobal_fix").putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", true).commit();
    AppMethodBeat.o(145637);
  }
  
  public final boolean cAN()
  {
    AppMethodBeat.i(145638);
    boolean bool1 = MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
    boolean bool2 = MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    Log.i("MicroMsg.WeakGlobalRefFix", "start ".concat(String.valueOf(bool1)));
    Log.i("MicroMsg.WeakGlobalRefFix", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      if (bool2) {
        h.CyF.idkeyStat(1113L, 2L, 1L, false);
      }
      AppMethodBeat.o(145638);
      return false;
    }
    if (MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0) == -5) {
      h.CyF.idkeyStat(1113L, 0L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(145638);
      return true;
      h.CyF.idkeyStat(1113L, 1L, 1L, false);
    }
  }
  
  public final boolean cAO()
  {
    AppMethodBeat.i(145640);
    JNIEnvNewWeakGlobalRefHook.init();
    try
    {
      JNIEnvNewWeakGlobalRefHook.calculateOffset();
      new View(MMApplicationContext.getContext());
      Log.i("MicroMsg.WeakGlobalRefFix", "init finish");
      Method localMethod1 = Class.forName("android.view.RenderNode").getDeclaredMethod("nCreate", new Class[] { String.class });
      Method localMethod2 = JNIEnvNewWeakGlobalRefHook.class.getMethod("calculateOffset", new Class[0]);
      Log.i("MicroMsg.WeakGlobalRefFix", "reflect finish");
      JNIEnvNewWeakGlobalRefHook.hook(localMethod1, localMethod2);
      new View(MMApplicationContext.getContext());
      Log.i("MicroMsg.WeakGlobalRefFix", "succ");
      AppMethodBeat.o(145640);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MultiProcessMMKV.getSingleMMKV("weakglobal_fix").putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", -5).commit();
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(145636);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("weakglobal_fix");
    localMultiProcessMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    localMultiProcessMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", true);
    localMultiProcessMMKV.putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(145636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.e.a
 * JD-Core Version:    0.7.0.1
 */