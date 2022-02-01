package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public b olg;
  public e olh;
  public f oli;
  public g olj;
  public a olk;
  
  public static void a(FloatBallHelper paramFloatBallHelper, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(267818);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(267818);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    Log.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { paramFloatBallHelper, paramAppBrandInitConfig.fzM });
    paramFloatBallHelper.cvL().fIZ = paramAppBrandInitConfig.appId;
    paramFloatBallHelper.cvL().lEm = paramAppBrandInitConfig.fzM;
    paramFloatBallHelper.cvL().rYy = String.valueOf(paramAppBrandInitConfig.cwR);
    paramFloatBallHelper = paramFloatBallHelper.cvL();
    if (paramAppBrandInitConfig.cxf == null) {}
    for (;;)
    {
      paramFloatBallHelper.rYx = i;
      AppMethodBeat.o(267818);
      return;
      i = paramAppBrandInitConfig.cxf.scene;
    }
  }
  
  public final void w(final t paramt)
  {
    AppMethodBeat.i(267815);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { paramt.mAppId });
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(270572);
        if ((paramt.ntU.get()) || (paramt.aol))
        {
          Log.w("MicroMsg.AppBrandFloatBallLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(270572);
          return;
        }
        if (c.this.olg != null) {
          c.this.olg.onDestroy();
        }
        Object localObject = new d(AndroidContextUtil.castActivityOrNull(paramt.mContext), paramt);
        c.this.olg = new b((com.tencent.mm.plugin.ball.a.f)localObject, paramt);
        c.this.olg.I(1, com.tencent.mm.plugin.ball.f.b.cV(paramt.mAppId, paramt.ntz.cBI));
        localObject = c.this.olg;
        AppBrandInitConfigWC localAppBrandInitConfigWC = paramt.bDy();
        if (localAppBrandInitConfigWC != null)
        {
          Log.i("MicroMsg.AppBrandFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
          ((b)localObject).rYE.icon = ((b)localObject).nAH.bDy().iconUrl;
          ((b)localObject).rYE.name = ((b)localObject).nAH.bDy().fzM;
          if (((b)localObject).nAH.ntz.cBI == 1)
          {
            ((b)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
            ((b)localObject).rYE.fg("appId", ((b)localObject).nAH.bDy().appId);
            ((b)localObject).rYE.fg("username", ((b)localObject).nAH.bDy().username);
            ((b)localObject).rYE.cT("versionType", ((b)localObject).nAH.bDy().cBI);
            c.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((b)localObject).cvL().kqZ = 6;
            ((b)localObject).cvG();
          }
        }
        else
        {
          if (c.this.olh != null) {
            c.this.olh.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramt.mContext), paramt);
          c.this.olh = new e((com.tencent.mm.plugin.ball.a.f)localObject, paramt);
          c.this.olh.I(7, com.tencent.mm.plugin.ball.f.b.cW(paramt.mAppId, paramt.ntz.cBI));
          localObject = c.this.olh;
          localAppBrandInitConfigWC = paramt.bDy();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((e)localObject).rYE.icon = ((e)localObject).nAH.bDy().iconUrl;
            ((e)localObject).rYE.name = ((e)localObject).nAH.bDy().fzM;
            if (((e)localObject).nAH.ntz.cBI != 1) {
              break label1308;
            }
            ((e)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
            label499:
            c.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((e)localObject).cvL().kqZ = 2;
            ((e)localObject).cvG();
          }
          if (c.this.oli != null) {
            c.this.oli.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramt.mContext), paramt);
          c.this.oli = new f((com.tencent.mm.plugin.ball.a.f)localObject, paramt);
          c.this.oli.I(17, com.tencent.mm.plugin.ball.f.b.cW(paramt.mAppId, paramt.ntz.cBI));
          localObject = c.this.oli;
          localAppBrandInitConfigWC = paramt.bDy();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((f)localObject).rYE.icon = ((f)localObject).nAH.bDy().iconUrl;
            ((f)localObject).rYE.name = ((f)localObject).nAH.bDy().fzM;
            if (((f)localObject).nAH.ntz.cBI != 1) {
              break label1352;
            }
            ((f)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
            label708:
            ((f)localObject).rYE.fg("appId", ((f)localObject).nAH.bDy().appId);
            ((f)localObject).rYE.fg("username", ((f)localObject).nAH.bDy().username);
            ((f)localObject).rYE.cT("versionType", ((f)localObject).nAH.bDy().cBI);
            c.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((f)localObject).cvL().kqZ = 12;
            ((f)localObject).cvG();
          }
          if (c.this.olk != null) {
            c.this.olk.onDestroy();
          }
          localObject = new d(AndroidContextUtil.castActivityOrNull(paramt.mContext), paramt);
          c.this.olk = new a((com.tencent.mm.plugin.ball.a.f)localObject, paramt);
          c.this.olk.I(18, com.tencent.mm.plugin.ball.f.b.cV(paramt.mAppId, paramt.ntz.cBI));
          localObject = c.this.olk;
          localAppBrandInitConfigWC = paramt.bDy();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i(((a)localObject).cED, "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((a)localObject).rYE.icon = ((a)localObject).nuJ.bDy().iconUrl;
            ((a)localObject).rYE.name = ((a)localObject).bNY();
            if (((a)localObject).nuJ.ntz.cBI != 1) {
              break label1396;
            }
            ((a)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
            label971:
            ((a)localObject).cvG();
          }
          if (c.this.olj != null) {
            c.this.olj.onDestroy();
          }
          localObject = new h(AndroidContextUtil.castActivityOrNull(paramt.mContext), paramt);
          c.this.olj = new g((com.tencent.mm.plugin.ball.a.f)localObject, paramt);
          c.this.olj.I(19, com.tencent.mm.plugin.ball.f.b.cW(paramt.mAppId, paramt.ntz.cBI));
          localObject = c.this.olj;
          localAppBrandInitConfigWC = paramt.bDy();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((g)localObject).rYE.icon = ((g)localObject).nAH.bDy().iconUrl;
            ((g)localObject).rYE.name = ((g)localObject).nAH.bDy().fzM;
            if (((g)localObject).nAH.ntz.cBI != 1) {
              break label1440;
            }
            ((g)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_testing);
          }
        }
        for (;;)
        {
          ((g)localObject).rYE.fg("appId", ((g)localObject).nAH.bDy().appId);
          ((g)localObject).rYE.fg("username", ((g)localObject).nAH.bDy().username);
          ((g)localObject).rYE.cT("versionType", ((g)localObject).nAH.bDy().cBI);
          c.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
          ((g)localObject).cvL().kqZ = 14;
          ((g)localObject).cvG();
          paramt.O(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(273624);
              if (c.this.olg != null) {
                c.this.olg.bNV();
              }
              if (c.this.olh != null) {
                c.this.olh.bNV();
              }
              if (c.this.oli != null) {
                c.this.oli.bNV();
              }
              if (c.this.olk != null) {
                c.this.olk.bNV();
              }
              if (c.this.olj != null) {
                c.this.olj.bNV();
              }
              AppMethodBeat.o(273624);
            }
          });
          AppMethodBeat.o(270572);
          return;
          if (((b)localObject).nAH.ntz.cBI == 2)
          {
            ((b)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
            break;
          }
          ((b)localObject).rYE.tag = null;
          break;
          label1308:
          if (((e)localObject).nAH.ntz.cBI == 2)
          {
            ((e)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
            break label499;
          }
          ((e)localObject).rYE.tag = null;
          break label499;
          label1352:
          if (((f)localObject).nAH.ntz.cBI == 2)
          {
            ((f)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
            break label708;
          }
          ((f)localObject).rYE.tag = null;
          break label708;
          label1396:
          if (((a)localObject).nuJ.ntz.cBI == 2)
          {
            ((a)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
            break label971;
          }
          ((a)localObject).rYE.tag = null;
          break label971;
          label1440:
          if (((g)localObject).nAH.ntz.cBI == 2) {
            ((g)localObject).rYE.tag = MMApplicationContext.getContext().getString(au.i.app_brand_app_debug_type_previewing);
          } else {
            ((g)localObject).rYE.tag = null;
          }
        }
      }
    }, "FloatBallHelperThread");
    AppMethodBeat.o(267815);
  }
  
  public final void x(t paramt)
  {
    AppMethodBeat.i(267817);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramt.mAppId });
    if (this.olg != null) {
      this.olg.onDestroy();
    }
    if (this.olh != null) {
      this.olh.onDestroy();
    }
    if (this.oli != null) {
      this.oli.onDestroy();
    }
    if (this.olk != null) {
      this.olk.onDestroy();
    }
    if (this.olj != null) {
      this.olj.onDestroy();
    }
    AppMethodBeat.o(267817);
  }
  
  public final boolean zJ(int paramInt)
  {
    AppMethodBeat.i(267816);
    if ((this.olg != null) && (this.olg.zH(paramInt)))
    {
      AppMethodBeat.o(267816);
      return true;
    }
    if ((this.olh != null) && (this.olh.zH(paramInt)))
    {
      AppMethodBeat.o(267816);
      return true;
    }
    if ((this.oli != null) && (this.oli.zH(paramInt)))
    {
      AppMethodBeat.o(267816);
      return true;
    }
    if ((this.olk != null) && (this.olk.zH(paramInt)))
    {
      AppMethodBeat.o(267816);
      return true;
    }
    if ((this.olj != null) && (this.olj.zH(paramInt)))
    {
      AppMethodBeat.o(267816);
      return true;
    }
    AppMethodBeat.o(267816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */