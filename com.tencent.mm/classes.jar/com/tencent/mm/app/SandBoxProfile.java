package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.model.ab;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.l.a;
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
    Object localObject1 = com.tencent.mm.booter.d.cc(MMApplicationContext.getContext());
    SandBoxProfile.class.getClassLoader();
    j.KW("MMProtocalJni");
    SandBoxProfile.class.getClassLoader();
    j.KW("wechatbase");
    Object localObject2 = CommLibFileName.quic;
    SandBoxProfile.class.getClassLoader();
    j.KW((String)localObject2);
    SandBoxProfile.class.getClassLoader();
    j.KW("wechatmm");
    localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19472);
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.RAD);
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
        ((u)localObject1).JC("SANDBOX");
        com.tencent.mm.platformtools.ac.mFA = Util.nullAs(((u)localObject1).JE(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
        Log.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + com.tencent.mm.platformtools.ac.mFA);
        label126:
        localObject1 = l.a.UTG;
        ac.abg();
        ab.hhg();
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
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */