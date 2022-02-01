package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class SandBoxProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cIB;
  
  static
  {
    AppMethodBeat.i(19474);
    cIB = ai.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.bK(ai.getContext());
    SandBoxProfile.class.getClassLoader();
    j.sC("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.sC("wechatbase");
    Object localObject2 = a.GpP;
    SandBoxProfile.class.getClassLoader();
    j.sC((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.sC("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.DIc);
        AppMethodBeat.o(19472);
      }
    };
    try
    {
      ((Runnable)localObject2).run();
      localObject1 = new u((com.tencent.mm.booter.d)localObject1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        ((u)localObject1).rq("SANDBOX");
        com.tencent.mm.platformtools.ab.ivv = bs.a(((u)localObject1).rr(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        ac.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + com.tencent.mm.platformtools.ab.ivv);
        label126:
        localObject1 = l.a.GmN;
        ab.KT();
        AppMethodBeat.o(19473);
        return;
        localThrowable = localThrowable;
        ((Runnable)localObject2).run();
      }
      catch (Error localError)
      {
        break label126;
      }
    }
  }
  
  public final String toString()
  {
    return cIB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */