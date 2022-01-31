package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class PusherProfile
  extends e
{
  public static final String bwr = com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":push";
  private Shell bxc = new Shell();
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    t localt = new t(com.tencent.mm.booter.c.aS(com.tencent.mm.sdk.platformtools.ae.getContext()));
    localt.em("PUSH");
    com.tencent.mm.platformtools.ae.eSd = bk.a(localt.en(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ae.eSe = bk.a(localt.en(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ae.eSf = bk.a(localt.en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ae.eSg = bk.a(localt.en(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ae.eSh = bk.a(localt.en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ae.eSi = bk.a(localt.en(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ae.eSm = bk.a(localt.en(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ae.eSn = bk.a(localt.en(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ae.eSq = bk.a(localt.en(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ae.eSr = bk.a(localt.en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ae.eSs = bk.a(localt.en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ae.eSt = bk.a(localt.en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ae.eSw = bk.a(localt.en(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ae.eSx = bk.a(localt.en(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bk.a(localt.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ae.eSu = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
    {
      com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
      y.e("MicroMsg.PushDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
    }
    com.tencent.mm.platformtools.ae.eSv = bk.a(localt.en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    com.tencent.mm.platformtools.ae.eSA = bk.a(localt.en(".com.tencent.mm.debug.test.skip_getdns"), false);
    try
    {
      i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localt.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          com.tencent.mm.protocal.d.dOM = "android-" + str;
          com.tencent.mm.protocal.d.soW = "android-" + str;
          com.tencent.mm.protocal.d.soY = str;
          b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.dOM).append(" ").append(b.cql());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.soZ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.soZ = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localt.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localt.diu.dhC = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bk.a(localt.en(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bk.a(localt.en(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bk.a(localt.en(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bk.a(localt.en(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                a.cg(bwr);
                o.onCreate(false);
                com.tencent.mm.br.d.a("gcm", null, null);
                com.tencent.mm.br.d.Xi("gcm");
                com.tencent.mm.sdk.b.a.udP.c(new PusherProfile.1(this));
                x.initLanguage(com.tencent.mm.sdk.platformtools.ae.getContext());
                return;
                localException2 = localException2;
                y.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                y.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                y.i("MicroMsg.PushDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                y.i("MicroMsg.PushDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                y.i("MicroMsg.PushDebugger", "no debugger was got");
              }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.PusherProfile
 * JD-Core Version:    0.7.0.1
 */