package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class SandBoxProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cTJ;
  
  static
  {
    AppMethodBeat.i(19474);
    cTJ = aj.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.bJ(aj.getContext());
    SandBoxProfile.class.getClassLoader();
    j.vr("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.vr("wechatbase");
    Object localObject2 = a.IbC;
    SandBoxProfile.class.getClassLoader();
    j.vr((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.vr("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.Fnj);
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
        ((u)localObject1).uc("SANDBOX");
        ac.iOC = bt.a(((u)localObject1).ud(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        ad.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ac.iOC);
        label126:
        localObject1 = l.a.HYA;
        ab.MA();
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
    return cTJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */