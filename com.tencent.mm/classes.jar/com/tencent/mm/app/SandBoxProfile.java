package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.ad;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.k.a;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class SandBoxProfile
  extends c
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(19474);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":sandbox";
    AppMethodBeat.o(19474);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19473);
    Object localObject1 = com.tencent.mm.booter.d.cO(MMApplicationContext.getContext());
    SandBoxProfile.class.getClassLoader();
    k.DA("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    k.DA("wechatbase");
    Object localObject2 = CommLibFileName.quic;
    SandBoxProfile.class.getClassLoader();
    k.DA((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    k.DA("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.Yxh);
        AppMethodBeat.o(19472);
      }
    };
    try
    {
      ((Runnable)localObject2).run();
      localObject1 = new u((com.tencent.mm.booter.d)localObject1);
    }
    finally
    {
      try
      {
        ((u)localObject1).Ci("SANDBOX");
        z.pCb = Util.nullAs(((u)localObject1).Ck(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        Log.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + z.pCb);
        label126:
        localObject1 = k.a.acoQ;
        af.aCS();
        ad.iIg();
        AppMethodBeat.o(19473);
        return;
        localObject3 = finally;
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
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */