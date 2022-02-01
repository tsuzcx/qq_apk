package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class SandBoxProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cLt;
  
  static
  {
    AppMethodBeat.i(19474);
    cLt = aj.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.bH(aj.getContext());
    SandBoxProfile.class.getClassLoader();
    j.pq("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.pq("wechatbase");
    Object localObject2 = a.ESC;
    SandBoxProfile.class.getClassLoader();
    j.pq((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.pq("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.CpK);
        AppMethodBeat.o(19472);
      }
    };
    try
    {
      ((Runnable)localObject2).run();
      localObject1 = new t((com.tencent.mm.booter.d)localObject1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        ((t)localObject1).ok("SANDBOX");
        ab.hVr = bt.a(((t)localObject1).ol(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        ad.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ab.hVr);
        label126:
        localObject1 = l.a.EPA;
        aa.KV();
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
    return cLt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */