package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class PatchProfile
  extends e
{
  public static final String bXW;
  
  static
  {
    AppMethodBeat.i(15391);
    bXW = ah.getPackageName() + ":patch";
    AppMethodBeat.o(15391);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(15390);
    long l = System.currentTimeMillis();
    com.tencent.mm.booter.s locals = new com.tencent.mm.booter.s(com.tencent.mm.booter.d.bt(this.app.getBaseContext()));
    locals.kt("PATCH");
    try
    {
      i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.MA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = locals.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bo.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.eQs = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whF = String.valueOf(str);
          b.aoP(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eQs).append(" ").append(b.dsg());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.whG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.whG = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bo.a(locals.ku(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bo.a(locals.ku(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bo.a(locals.ku(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bo.a(locals.ku(".com.tencent.mm.debug.report.useraction"), false);
              c.c(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              a.bp(ah.getContext());
              m.dw(bXW);
              s.By();
              ab.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              ab.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(15390);
              return;
              localException2 = localException2;
              ab.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ab.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              ab.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              ab.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */