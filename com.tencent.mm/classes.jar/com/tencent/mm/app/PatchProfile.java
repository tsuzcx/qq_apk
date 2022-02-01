package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class PatchProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cUu;
  
  static
  {
    AppMethodBeat.i(19464);
    cUu = ak.getPackageName() + ":patch";
    AppMethodBeat.o(19464);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19463);
    long l = System.currentTimeMillis();
    com.tencent.mm.booter.t localt = new com.tencent.mm.booter.t(com.tencent.mm.booter.d.bL(this.app.getBaseContext()));
    localt.ux("PATCH");
    try
    {
      i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aag(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localt.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bu.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFF = String.valueOf(str);
          b.aRu(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(b.fnG());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.FFG = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bu.a(localt.uy(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bu.a(localt.uy(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bu.a(localt.uy(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bu.a(localt.uy(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              a.bH(ak.getContext());
              t.fq(cUu);
              ab.Mv();
              ae.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              ae.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(19463);
              return;
              localException2 = localException2;
              ae.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ae.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              ae.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ae.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */