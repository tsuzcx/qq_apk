package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.t;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class PatchProfile
  extends com.tencent.mm.compatible.loader.c
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(19464);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":patch";
    AppMethodBeat.o(19464);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19463);
    long l = System.currentTimeMillis();
    t localt = new t(com.tencent.mm.booter.d.cO(this.app.getBaseContext()));
    localt.Ci("PATCH");
    try
    {
      i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.axo(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localt.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.nsC = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxc = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxe = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.nsC).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          int i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Yxg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Yxg = i;
        }
        catch (Exception localException4)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = Util.nullAs(localt.Ck(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = Util.nullAs(localt.Ck(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = Util.nullAs(localt.Ck(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = Util.nullAs(localt.Ck(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.e(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              w.f(false, PROCESS_NAME);
              af.aCS();
              Log.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
              Log.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - l));
              AppMethodBeat.o(19463);
              return;
              localException2 = localException2;
              Log.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              Log.i("MicroMsg.PatchDebugger", "no debugger was got");
              continue;
              localException4 = localException4;
              Log.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Log.i("MicroMsg.PatchDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.PatchProfile
 * JD-Core Version:    0.7.0.1
 */