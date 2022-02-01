package com.tencent.mm.plugin.crashfix.d.b;

import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.mm.plugin.crashfix.d.a
{
  public final boolean AE(int paramInt)
  {
    AppMethodBeat.i(145639);
    if ((paramInt == 24) || (paramInt == 25))
    {
      ac.i("MicroMsg.WeakGlobalRefFix", "api ".concat(String.valueOf(paramInt)));
      paramInt = ((b)g.ab(b.class)).a(b.a.pWS, 1);
      ac.i("MicroMsg.WeakGlobalRefFix", "Expt : ".concat(String.valueOf(paramInt)));
      if (paramInt == 0)
      {
        AppMethodBeat.o(145639);
        return false;
      }
      if (paramInt == 2)
      {
        aw localaw = aw.aKU("weakglobal_fix");
        localaw.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
        localaw.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
        localaw.commit();
      }
      AppMethodBeat.o(145639);
      return true;
    }
    AppMethodBeat.o(145639);
    return false;
  }
  
  public final void bWZ()
  {
    AppMethodBeat.i(145637);
    aw.aKU("weakglobal_fix").putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", true).commit();
    AppMethodBeat.o(145637);
  }
  
  public final boolean bXa()
  {
    AppMethodBeat.i(145638);
    boolean bool1 = aw.aKU("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
    boolean bool2 = aw.aKU("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    ac.i("MicroMsg.WeakGlobalRefFix", "start ".concat(String.valueOf(bool1)));
    ac.i("MicroMsg.WeakGlobalRefFix", "end ".concat(String.valueOf(bool2)));
    if (bool1 == bool2)
    {
      if (bool2) {
        h.wUl.idkeyStat(1113L, 2L, 1L, false);
      }
      AppMethodBeat.o(145638);
      return false;
    }
    if (aw.aKU("weakglobal_fix").getInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0) == -5) {
      h.wUl.idkeyStat(1113L, 0L, 1L, false);
    }
    for (;;)
    {
      AppMethodBeat.o(145638);
      return true;
      h.wUl.idkeyStat(1113L, 1L, 1L, false);
    }
  }
  
  public final boolean bXb()
  {
    AppMethodBeat.i(145640);
    JNIEnvNewWeakGlobalRefHook.init();
    try
    {
      JNIEnvNewWeakGlobalRefHook.calculateOffset();
      new View(ai.getContext());
      ac.i("MicroMsg.WeakGlobalRefFix", "init finish");
      Method localMethod1 = Class.forName("android.view.RenderNode").getDeclaredMethod("nCreate", new Class[] { String.class });
      Method localMethod2 = JNIEnvNewWeakGlobalRefHook.class.getMethod("calculateOffset", new Class[0]);
      ac.i("MicroMsg.WeakGlobalRefFix", "reflect finish");
      JNIEnvNewWeakGlobalRefHook.hook(localMethod1, localMethod2);
      new View(ai.getContext());
      ac.i("MicroMsg.WeakGlobalRefFix", "succ");
      AppMethodBeat.o(145640);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aw.aKU("weakglobal_fix").putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", -5).commit();
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(145636);
    aw localaw = aw.aKU("weakglobal_fix");
    localaw.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
    localaw.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", true);
    localaw.putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0);
    localaw.commit();
    AppMethodBeat.o(145636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.b.a
 * JD-Core Version:    0.7.0.1
 */