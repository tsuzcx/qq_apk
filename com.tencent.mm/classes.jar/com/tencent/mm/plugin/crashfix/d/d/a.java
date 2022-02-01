package com.tencent.mm.plugin.crashfix.d.d;

import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean Bz(int paramInt)
  {
    AppMethodBeat.i(145639);
    if ((paramInt == 24) || (paramInt == 25))
    {
      ae.i("MicroMsg.WeakGlobalRefFix", "api ".concat(String.valueOf(paramInt)));
      paramInt = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qJp, 1);
      ae.i("MicroMsg.WeakGlobalRefFix", "Expt : ".concat(String.valueOf(paramInt)));
      if (paramInt == 0)
      {
        AppMethodBeat.o(145639);
        return false;
      }
      if (paramInt == 2)
      {
        ay localay = ay.aRX("weakglobal_fix");
        localay.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
        localay.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
        localay.commit();
      }
      AppMethodBeat.o(145639);
      return true;
    }
    AppMethodBeat.o(145639);
    return false;
  }
  
  public final void ccR()
  {
    AppMethodBeat.i(145637);
    ay.aRX("weakglobal_fix").putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", true).commit();
    AppMethodBeat.o(145637);
  }
  
  public final boolean ccS()
  {
    AppMethodBeat.i(145638);
    boolean bool1 = ay.aRX("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
    boolean bool2 = ay.aRX("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    ae.i("MicroMsg.WeakGlobalRefFix", "start ".concat(String.valueOf(bool1)));
    ae.i("MicroMsg.WeakGlobalRefFix", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      if (bool2) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1113L, 2L, 1L, false);
      }
      AppMethodBeat.o(145638);
      return false;
    }
    if (ay.aRX("weakglobal_fix").getInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0) == -5) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1113L, 0L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(145638);
      return true;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1113L, 1L, 1L, false);
    }
  }
  
  public final boolean ccT()
  {
    AppMethodBeat.i(145640);
    JNIEnvNewWeakGlobalRefHook.init();
    try
    {
      JNIEnvNewWeakGlobalRefHook.calculateOffset();
      new View(ak.getContext());
      ae.i("MicroMsg.WeakGlobalRefFix", "init finish");
      Method localMethod1 = Class.forName("android.view.RenderNode").getDeclaredMethod("nCreate", new Class[] { String.class });
      Method localMethod2 = JNIEnvNewWeakGlobalRefHook.class.getMethod("calculateOffset", new Class[0]);
      ae.i("MicroMsg.WeakGlobalRefFix", "reflect finish");
      JNIEnvNewWeakGlobalRefHook.hook(localMethod1, localMethod2);
      new View(ak.getContext());
      ae.i("MicroMsg.WeakGlobalRefFix", "succ");
      AppMethodBeat.o(145640);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ay.aRX("weakglobal_fix").putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", -5).commit();
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(145636);
    ay localay = ay.aRX("weakglobal_fix");
    localay.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    localay.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", true);
    localay.putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0);
    localay.commit();
    AppMethodBeat.o(145636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.d.a
 * JD-Core Version:    0.7.0.1
 */