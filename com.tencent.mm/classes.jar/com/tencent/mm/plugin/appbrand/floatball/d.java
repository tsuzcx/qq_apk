package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  public final w roO;
  public c roP;
  public f roQ;
  public g roR;
  public h roS;
  public a roT;
  
  public d(w paramw)
  {
    this.roO = paramw;
  }
  
  public static void a(FloatBallHelper paramFloatBallHelper, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(318249);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(318249);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    Log.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { paramFloatBallHelper, paramAppBrandInitConfig.hEy });
    paramFloatBallHelper.cYv().hOH = paramAppBrandInitConfig.appId;
    paramFloatBallHelper.cYv().ovT = paramAppBrandInitConfig.hEy;
    paramFloatBallHelper.cYv().vjO = String.valueOf(paramAppBrandInitConfig.appServiceType);
    paramFloatBallHelper = paramFloatBallHelper.cYv();
    if (paramAppBrandInitConfig.epn == null) {}
    for (;;)
    {
      paramFloatBallHelper.vjN = i;
      AppMethodBeat.o(318249);
      return;
      i = paramAppBrandInitConfig.epn.scene;
    }
  }
  
  public final boolean Aa(int paramInt)
  {
    AppMethodBeat.i(318268);
    if (this.roP != null) {
      this.roP.finish();
    }
    if ((this.roP != null) && (this.roP.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    if ((this.roQ != null) && (this.roQ.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    if ((this.roR != null) && (this.roR.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    if ((this.roT != null) && (this.roT.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    if ((this.roS != null) && (this.roS.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    b localb = t.ak(this.roO);
    if ((localb != null) && (localb.zX(paramInt)))
    {
      AppMethodBeat.o(318268);
      return true;
    }
    AppMethodBeat.o(318268);
    return false;
  }
  
  public final void C(final w paramw)
  {
    AppMethodBeat.i(318261);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { paramw.mAppId });
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(318207);
        if ((paramw.qsE.get()) || (paramw.ccV))
        {
          Log.w("MicroMsg.AppBrandFloatBallLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(318207);
          return;
        }
        if (d.this.roP != null) {
          d.this.roP.onDestroy();
        }
        Object localObject = new e(AndroidContextUtil.castActivityOrNull(paramw.mContext), paramw);
        d.this.roP = new c((com.tencent.mm.plugin.ball.a.f)localObject, paramw);
        d.this.roP.J(1, com.tencent.mm.plugin.ball.f.b.dx(paramw.mAppId, paramw.qsh.eul));
        localObject = d.this.roP;
        AppBrandInitConfigWC localAppBrandInitConfigWC = paramw.getInitConfig();
        if (localAppBrandInitConfigWC != null)
        {
          Log.i("MicroMsg.AppBrandFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
          ((c)localObject).vjV.icon = ((c)localObject).qxC.getInitConfig().iconUrl;
          ((c)localObject).vjV.name = ((c)localObject).qxC.getInitConfig().hEy;
          if (((c)localObject).qxC.qsh.eul == 1)
          {
            ((c)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
            ((c)localObject).vjV.fx("appId", ((c)localObject).qxC.getInitConfig().appId);
            ((c)localObject).vjV.fx("username", ((c)localObject).qxC.getInitConfig().username);
            ((c)localObject).vjV.dv("versionType", ((c)localObject).qxC.getInitConfig().eul);
            d.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((c)localObject).cYv().mUU = 6;
            ((c)localObject).cYr();
          }
        }
        else
        {
          if (d.this.roQ != null) {
            d.this.roQ.onDestroy();
          }
          localObject = new e(AndroidContextUtil.castActivityOrNull(paramw.mContext), paramw);
          d.this.roQ = new f((com.tencent.mm.plugin.ball.a.f)localObject, paramw);
          d.this.roQ.J(7, com.tencent.mm.plugin.ball.f.b.dy(paramw.mAppId, paramw.qsh.eul));
          localObject = d.this.roQ;
          localAppBrandInitConfigWC = paramw.getInitConfig();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((f)localObject).vjV.icon = ((f)localObject).qxC.getInitConfig().iconUrl;
            ((f)localObject).vjV.name = ((f)localObject).qxC.getInitConfig().hEy;
            if (((f)localObject).qxC.qsh.eul != 1) {
              break label1308;
            }
            ((f)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
            label499:
            d.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((f)localObject).cYv().mUU = 2;
            ((f)localObject).cYr();
          }
          if (d.this.roR != null) {
            d.this.roR.onDestroy();
          }
          localObject = new e(AndroidContextUtil.castActivityOrNull(paramw.mContext), paramw);
          d.this.roR = new g((com.tencent.mm.plugin.ball.a.f)localObject, paramw);
          d.this.roR.J(17, com.tencent.mm.plugin.ball.f.b.dy(paramw.mAppId, paramw.qsh.eul));
          localObject = d.this.roR;
          localAppBrandInitConfigWC = paramw.getInitConfig();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((g)localObject).vjV.icon = ((g)localObject).qxC.getInitConfig().iconUrl;
            ((g)localObject).vjV.name = ((g)localObject).qxC.getInitConfig().hEy;
            if (((g)localObject).qxC.qsh.eul != 1) {
              break label1352;
            }
            ((g)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
            label708:
            ((g)localObject).vjV.fx("appId", ((g)localObject).qxC.getInitConfig().appId);
            ((g)localObject).vjV.fx("username", ((g)localObject).qxC.getInitConfig().username);
            ((g)localObject).vjV.dv("versionType", ((g)localObject).qxC.getInitConfig().eul);
            d.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
            ((g)localObject).cYv().mUU = 12;
            ((g)localObject).cYr();
          }
          if (d.this.roT != null) {
            d.this.roT.onDestroy();
          }
          localObject = new e(AndroidContextUtil.castActivityOrNull(paramw.mContext), paramw);
          d.this.roT = new a((com.tencent.mm.plugin.ball.a.f)localObject, paramw);
          d.this.roT.J(18, com.tencent.mm.plugin.ball.f.b.dx(paramw.mAppId, paramw.qsh.eul));
          localObject = d.this.roT;
          localAppBrandInitConfigWC = paramw.getInitConfig();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i(((a)localObject).exO, "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((a)localObject).vjV.icon = ((a)localObject).qts.getInitConfig().iconUrl;
            ((a)localObject).vjV.name = ((a)localObject).col();
            if (((a)localObject).qts.qsh.eul != 1) {
              break label1396;
            }
            ((a)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
            label971:
            ((a)localObject).cYr();
          }
          if (d.this.roS != null) {
            d.this.roS.onDestroy();
          }
          localObject = new i(AndroidContextUtil.castActivityOrNull(paramw.mContext), paramw);
          d.this.roS = new h((com.tencent.mm.plugin.ball.a.f)localObject, paramw);
          d.this.roS.J(19, com.tencent.mm.plugin.ball.f.b.dy(paramw.mAppId, paramw.qsh.eul));
          localObject = d.this.roS;
          localAppBrandInitConfigWC = paramw.getInitConfig();
          if (localAppBrandInitConfigWC != null)
          {
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", new Object[] { localAppBrandInitConfigWC });
            ((h)localObject).vjV.icon = ((h)localObject).qxC.getInitConfig().iconUrl;
            ((h)localObject).vjV.name = ((h)localObject).qxC.getInitConfig().hEy;
            if (((h)localObject).qxC.qsh.eul != 1) {
              break label1440;
            }
            ((h)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_testing);
          }
        }
        for (;;)
        {
          ((h)localObject).vjV.fx("appId", ((h)localObject).qxC.getInitConfig().appId);
          ((h)localObject).vjV.fx("username", ((h)localObject).qxC.getInitConfig().username);
          ((h)localObject).vjV.dv("versionType", ((h)localObject).qxC.getInitConfig().eul);
          d.a((FloatBallHelper)localObject, localAppBrandInitConfigWC);
          ((h)localObject).cYv().mUU = 14;
          ((h)localObject).cYr();
          paramw.U(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(318201);
              if (d.this.roP != null) {
                d.this.roP.coi();
              }
              if (d.this.roQ != null) {
                d.this.roQ.coi();
              }
              if (d.this.roR != null) {
                d.this.roR.coi();
              }
              if (d.this.roT != null) {
                d.this.roT.coi();
              }
              if (d.this.roS != null) {
                d.this.roS.coi();
              }
              AppMethodBeat.o(318201);
            }
          });
          AppMethodBeat.o(318207);
          return;
          if (((c)localObject).qxC.qsh.eul == 2)
          {
            ((c)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
            break;
          }
          ((c)localObject).vjV.tag = null;
          break;
          label1308:
          if (((f)localObject).qxC.qsh.eul == 2)
          {
            ((f)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
            break label499;
          }
          ((f)localObject).vjV.tag = null;
          break label499;
          label1352:
          if (((g)localObject).qxC.qsh.eul == 2)
          {
            ((g)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
            break label708;
          }
          ((g)localObject).vjV.tag = null;
          break label708;
          label1396:
          if (((a)localObject).qts.qsh.eul == 2)
          {
            ((a)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
            break label971;
          }
          ((a)localObject).vjV.tag = null;
          break label971;
          label1440:
          if (((h)localObject).qxC.qsh.eul == 2) {
            ((h)localObject).vjV.tag = MMApplicationContext.getContext().getString(ba.i.app_brand_app_debug_type_previewing);
          } else {
            ((h)localObject).vjV.tag = null;
          }
        }
      }
    }, "FloatBallHelperThread");
    AppMethodBeat.o(318261);
  }
  
  public final void D(w paramw)
  {
    AppMethodBeat.i(318279);
    Log.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramw.mAppId });
    if (this.roP != null) {
      this.roP.onDestroy();
    }
    if (this.roQ != null) {
      this.roQ.onDestroy();
    }
    if (this.roR != null) {
      this.roR.onDestroy();
    }
    if (this.roT != null) {
      this.roT.onDestroy();
    }
    if (this.roS != null) {
      this.roS.onDestroy();
    }
    paramw = t.ak(this.roO);
    if (paramw != null) {
      paramw.onDestroy();
    }
    AppMethodBeat.o(318279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */