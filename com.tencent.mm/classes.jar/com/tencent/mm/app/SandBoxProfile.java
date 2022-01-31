package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.k.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class SandBoxProfile
  extends e
{
  public static final String bwr = com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":sandbox";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    Object localObject = c.aS(com.tencent.mm.sdk.platformtools.ae.getContext());
    k.setupBrokenLibraryHandler();
    k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
    k.b(a.udJ, SandBoxProfile.class.getClassLoader());
    MMProtocalJni.setClientPackVersion(d.spa);
    localObject = new u((c)localObject);
    try
    {
      ((u)localObject).em("SANDBOX");
      com.tencent.mm.platformtools.ae.eSE = bk.a(((u)localObject).en(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
      y.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + com.tencent.mm.platformtools.ae.eSE);
      label89:
      localObject = k.a.udI;
      p.tb();
      return;
    }
    catch (Error localError)
    {
      break label89;
    }
  }
  
  public final String toString()
  {
    return bwr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */