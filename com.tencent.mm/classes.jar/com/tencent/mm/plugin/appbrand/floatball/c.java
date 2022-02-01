package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import com.tencent.f.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c
{
  public a lqA;
  public b lqw;
  public e lqx;
  public f lqy;
  public g lqz;
  
  public static void a(com.tencent.mm.plugin.ball.service.a parama, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(226542);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(226542);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    Log.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { parama, paramAppBrandInitConfig.brandName });
    parama.ciw().dPJ = paramAppBrandInitConfig.appId;
    parama.ciw().iNV = paramAppBrandInitConfig.brandName;
    parama.ciw().oWy = String.valueOf(paramAppBrandInitConfig.cyo);
    parama = parama.ciw();
    if (paramAppBrandInitConfig.cyA == null) {}
    for (;;)
    {
      parama.oWx = i;
      AppMethodBeat.o(226542);
      return;
      i = paramAppBrandInitConfig.cyA.scene;
    }
  }
  
  public final void v(final q paramq)
  {
    AppMethodBeat.i(226539);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { paramq.mAppId });
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226536);
        if ((paramq.isDestroyed()) || (paramq.SO))
        {
          Log.w("MicroMsg.AppBrandFloatBallLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(226536);
          return;
        }
        if (c.this.lqw != null) {
          c.this.lqw.onDestroy();
        }
        Object localObject = new d(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
        c.this.lqw = new b((com.tencent.mm.plugin.ball.a.f)localObject, paramq);
        c.this.lqw.G(1, com.tencent.mm.plugin.ball.f.b.cA(paramq.mAppId, paramq.kAq.eix));
        localObject = c.this.lqw;
        AppBrandInitConfigWC localAppBrandInitConfigWC = paramq.bsC();
        if (localAppBrandInitConfigWC != null)
        {
          Log.i("MicroMsg.AppBrandFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
          ((b)localObject).oWE.icon = ((b)localObject).kGW.bsC().iconUrl;
          ((b)localObject).oWE.name = ((b)localObject).kGW.bsC().brandName;
          if (((b)localObject).kGW.kAq.eix == 1)
          {
            ((b)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755352);
            ((b)localObject).oWE.eS("appId", ((b)localObject).kGW.bsC().appId);
            ((b)localObject).oWE.eS("username", ((b)localObject).kGW.bsC().username);
            ((b)localObject).oWE.cy("versionType", ((b)localObject).kGW.bsC().eix);
            c.a((com.tencent.mm.plugin.ball.service.a)localObject, localAppBrandInitConfigWC);
            ((b)localObject).ciw().hDa = 6;
            ((b)localObject).cit();
          }
        }
        else
        {
          if (c.this.lqx != null) {
            c.this.lqx.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
          c.this.lqx = new e((com.tencent.mm.plugin.ball.a.f)localObject, paramq);
          c.this.lqx.G(7, com.tencent.mm.plugin.ball.f.b.cB(paramq.mAppId, paramq.kAq.eix));
          localObject = c.this.lqx;
          localAppBrandInitConfigWC = paramq.bsC();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((e)localObject).oWE.icon = ((e)localObject).kGW.bsC().iconUrl;
            ((e)localObject).oWE.name = ((e)localObject).kGW.bsC().brandName;
            if (((e)localObject).kGW.kAq.eix != 1) {
              break label1300;
            }
            ((e)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755352);
            label494:
            c.a((com.tencent.mm.plugin.ball.service.a)localObject, localAppBrandInitConfigWC);
            ((e)localObject).ciw().hDa = 2;
            ((e)localObject).cit();
          }
          if (c.this.lqy != null) {
            c.this.lqy.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
          c.this.lqy = new f((com.tencent.mm.plugin.ball.a.f)localObject, paramq);
          c.this.lqy.G(17, com.tencent.mm.plugin.ball.f.b.cB(paramq.mAppId, paramq.kAq.eix));
          localObject = c.this.lqy;
          localAppBrandInitConfigWC = paramq.bsC();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((f)localObject).oWE.icon = ((f)localObject).kGW.bsC().iconUrl;
            ((f)localObject).oWE.name = ((f)localObject).kGW.bsC().brandName;
            if (((f)localObject).kGW.kAq.eix != 1) {
              break label1344;
            }
            ((f)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755352);
            label702:
            ((f)localObject).oWE.eS("appId", ((f)localObject).kGW.bsC().appId);
            ((f)localObject).oWE.eS("username", ((f)localObject).kGW.bsC().username);
            ((f)localObject).oWE.cy("versionType", ((f)localObject).kGW.bsC().eix);
            c.a((com.tencent.mm.plugin.ball.service.a)localObject, localAppBrandInitConfigWC);
            ((f)localObject).ciw().hDa = 12;
            ((f)localObject).cit();
          }
          if (c.this.lqA != null) {
            c.this.lqA.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
          c.this.lqA = new a((com.tencent.mm.plugin.ball.a.f)localObject, paramq);
          c.this.lqA.G(18, com.tencent.mm.plugin.ball.f.b.cA(paramq.mAppId, paramq.kAq.eix));
          localObject = c.this.lqA;
          localAppBrandInitConfigWC = paramq.bsC();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i(((a)localObject).cDW, "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((a)localObject).oWE.icon = ((a)localObject).kBw.bsC().iconUrl;
            ((a)localObject).oWE.name = ((a)localObject).bCD();
            if (((a)localObject).kBw.kAq.eix != 1) {
              break label1388;
            }
            ((a)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755352);
            label964:
            ((a)localObject).cit();
          }
          if (c.this.lqz != null) {
            c.this.lqz.onDestroy();
          }
          localObject = new h(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
          c.this.lqz = new g((com.tencent.mm.plugin.ball.a.f)localObject, paramq);
          c.this.lqz.G(19, com.tencent.mm.plugin.ball.f.b.cB(paramq.mAppId, paramq.kAq.eix));
          localObject = c.this.lqz;
          localAppBrandInitConfigWC = paramq.bsC();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((g)localObject).oWE.icon = ((g)localObject).kGW.bsC().iconUrl;
            ((g)localObject).oWE.name = ((g)localObject).kGW.bsC().brandName;
            if (((g)localObject).kGW.kAq.eix != 1) {
              break label1432;
            }
            ((g)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755352);
          }
        }
        for (;;)
        {
          ((g)localObject).oWE.eS("appId", ((g)localObject).kGW.bsC().appId);
          ((g)localObject).oWE.eS("username", ((g)localObject).kGW.bsC().username);
          ((g)localObject).oWE.cy("versionType", ((g)localObject).kGW.bsC().eix);
          c.a((com.tencent.mm.plugin.ball.service.a)localObject, localAppBrandInitConfigWC);
          ((g)localObject).ciw().hDa = 14;
          ((g)localObject).cit();
          paramq.O(new c.1.1(this));
          AppMethodBeat.o(226536);
          return;
          if (((b)localObject).kGW.kAq.eix == 2)
          {
            ((b)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755351);
            break;
          }
          ((b)localObject).oWE.tag = null;
          break;
          label1300:
          if (((e)localObject).kGW.kAq.eix == 2)
          {
            ((e)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755351);
            break label494;
          }
          ((e)localObject).oWE.tag = null;
          break label494;
          label1344:
          if (((f)localObject).kGW.kAq.eix == 2)
          {
            ((f)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755351);
            break label702;
          }
          ((f)localObject).oWE.tag = null;
          break label702;
          label1388:
          if (((a)localObject).kBw.kAq.eix == 2)
          {
            ((a)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755351);
            break label964;
          }
          ((a)localObject).oWE.tag = null;
          break label964;
          label1432:
          if (((g)localObject).kGW.kAq.eix == 2) {
            ((g)localObject).oWE.tag = MMApplicationContext.getContext().getString(2131755351);
          } else {
            ((g)localObject).oWE.tag = null;
          }
        }
      }
    }, "FloatBallHelperThread");
    AppMethodBeat.o(226539);
  }
  
  public final void w(q paramq)
  {
    AppMethodBeat.i(226541);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramq.mAppId });
    if (this.lqw != null) {
      this.lqw.onDestroy();
    }
    if (this.lqx != null) {
      this.lqx.onDestroy();
    }
    if (this.lqy != null) {
      this.lqy.onDestroy();
    }
    if (this.lqA != null) {
      this.lqA.onDestroy();
    }
    if (this.lqz != null) {
      this.lqz.onDestroy();
    }
    AppMethodBeat.o(226541);
  }
  
  public final boolean ww(int paramInt)
  {
    AppMethodBeat.i(226540);
    if ((this.lqw != null) && (this.lqw.wu(paramInt)))
    {
      AppMethodBeat.o(226540);
      return true;
    }
    if ((this.lqx != null) && (this.lqx.wu(paramInt)))
    {
      AppMethodBeat.o(226540);
      return true;
    }
    if ((this.lqy != null) && (this.lqy.wu(paramInt)))
    {
      AppMethodBeat.o(226540);
      return true;
    }
    if ((this.lqA != null) && (this.lqA.wu(paramInt)))
    {
      AppMethodBeat.o(226540);
      return true;
    }
    if ((this.lqz != null) && (this.lqz.wu(paramInt)))
    {
      AppMethodBeat.o(226540);
      return true;
    }
    AppMethodBeat.o(226540);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */