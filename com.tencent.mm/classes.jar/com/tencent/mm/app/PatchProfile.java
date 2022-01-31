package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.g.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class PatchProfile
  extends e
{
  public static final String bwr = ae.getPackageName() + ":patch";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    long l = System.currentTimeMillis();
    s locals = new s(com.tencent.mm.booter.c.aS(this.app.getBaseContext()));
    locals.em("PATCH");
    try
    {
      i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = locals.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          com.tencent.mm.protocal.d.dOM = "android-" + str;
          com.tencent.mm.protocal.d.soW = "android-" + str;
          com.tencent.mm.protocal.d.soY = str;
          b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.dOM).append(" ").append(b.cql());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(locals.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.soZ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.soZ = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bk.a(locals.en(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bk.a(locals.en(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bk.a(locals.en(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bk.a(locals.en(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              a.aQ(ae.getContext());
              k.cl(bwr);
              com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
              p.tb();
              y.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              com.tencent.mm.br.d.a("hp", null, null);
              com.tencent.mm.br.d.Xi("hp");
              y.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              return;
              localException2 = localException2;
              y.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              y.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              y.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              y.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return bwr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */