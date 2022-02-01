package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class SandBoxProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String dkO;
  
  static
  {
    AppMethodBeat.i(19474);
    dkO = MMApplicationContext.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.cg(MMApplicationContext.getContext());
    SandBoxProfile.class.getClassLoader();
    j.Ed("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.Ed("wechatbase");
    Object localObject2 = CommLibFileName.quic;
    SandBoxProfile.class.getClassLoader();
    j.Ed((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.Ed("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.KyO);
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
        ((u)localObject1).CN("SANDBOX");
        ac.jOr = Util.nullAs(((u)localObject1).CO(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        Log.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ac.jOr);
        label126:
        localObject1 = l.a.NGg;
        ab.WH();
        x.gmG();
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
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */