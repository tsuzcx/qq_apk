package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sandbox.updater.k.a;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class SandBoxProfile
  extends e
{
  public static final String bXW;
  
  static
  {
    AppMethodBeat.i(15399);
    bXW = ah.getPackageName() + ":sandbox";
    AppMethodBeat.o(15399);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(15398);
    Object localObject = com.tencent.mm.booter.d.bt(ah.getContext());
    k.a("MMProtocalJni", SandBoxProfile.class.getClassLoader());
    k.a(a.ylY, SandBoxProfile.class.getClassLoader());
    MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.whH);
    localObject = new t((com.tencent.mm.booter.d)localObject);
    try
    {
      ((t)localObject).kt("SANDBOX");
      ae.gkz = bo.a(((t)localObject).ku(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
      ab.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + ae.gkz);
      label92:
      localObject = k.a.ylX;
      s.By();
      AppMethodBeat.o(15398);
      return;
    }
    catch (Error localError)
    {
      break label92;
    }
  }
  
  public final String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.SandBoxProfile
 * JD-Core Version:    0.7.0.1
 */