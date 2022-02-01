package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class SandBoxProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cUu;
  
  static
  {
    AppMethodBeat.i(19474);
    cUu = ak.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.bL(ak.getContext());
    SandBoxProfile.class.getClassLoader();
    j.vN("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.vN("wechatbase");
    Object localObject2 = a.IvK;
    SandBoxProfile.class.getClassLoader();
    j.vN((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.vN("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.FFH);
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
        ((u)localObject1).ux("SANDBOX");
        ac.iRw = bu.a(((u)localObject1).uy(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        ae.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ac.iRw);
        label126:
        localObject1 = l.a.IsH;
        ab.Mv();
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
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */