package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class PatchProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cLt;
  
  static
  {
    AppMethodBeat.i(19464);
    cLt = aj.getPackageName() + ":patch";
    AppMethodBeat.o(19464);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19463);
    long l = System.currentTimeMillis();
    com.tencent.mm.booter.s locals = new com.tencent.mm.booter.s(com.tencent.mm.booter.d.bH(this.app.getBaseContext()));
    locals.ok("PATCH");
    try
    {
      i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.Vv(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = locals.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.glX = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpG = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpI = String.valueOf(str);
          b.aFa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.glX).append(" ").append(b.eER());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.CpJ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.CpJ = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bt.a(locals.ol(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bt.a(locals.ol(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bt.a(locals.ol(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bt.a(locals.ol(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              a.bD(aj.getContext());
              s.eA(cLt);
              aa.KV();
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
    return cLt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */