package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.t;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class PatchProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cTJ;
  
  static
  {
    AppMethodBeat.i(19464);
    cTJ = aj.getPackageName() + ":patch";
    AppMethodBeat.o(19464);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19463);
    long l = System.currentTimeMillis();
    t localt = new t(com.tencent.mm.booter.d.bJ(this.app.getBaseContext()));
    localt.uc("PATCH");
    try
    {
      i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.ZA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localt.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnh = String.valueOf(str);
          b.aPX(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(b.fjO());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Fni = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bt.a(localt.ud(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bt.a(localt.ud(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bt.a(localt.ud(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bt.a(localt.ud(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              a.bF(aj.getContext());
              s.fk(cTJ);
              ab.MA();
              ad.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              ad.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(19463);
              return;
              localException2 = localException2;
              ad.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ad.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              ad.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ad.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cTJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */