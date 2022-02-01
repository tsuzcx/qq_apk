package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.pm;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandBatchPreloadController
  implements IAppBrandBatchPreloadController
{
  private static final String TAG = "MicroMsg.Predownload.AppBrandBatchPreloadController";
  private int mBusinessScene = 0;
  private boolean mIsGameEnv = false;
  
  private void dealPreload(c paramc, PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48495);
    switch (AppBrandBatchPreloadController.5.qSp[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48495);
      return;
      preloadMiniProgramEnv(paramPreloadAppInfo.appType, PRELOAD_ENV_LEVEL.LOW_LEVEL, true);
      AppMethodBeat.o(48495);
      return;
      preloadMiniProgramEnv(paramPreloadAppInfo.appType, PRELOAD_ENV_LEVEL.MIDDLE_LEVEL, true);
      predownloadPlugins(paramPreloadAppInfo);
      AppMethodBeat.o(48495);
      return;
      preloadMiniProgramEnv(paramPreloadAppInfo.appType, PRELOAD_ENV_LEVEL.HIGH_LEVEL, true);
      predownloadAllPackages(paramPreloadAppInfo);
    }
  }
  
  private void predownloadAllPackages(PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48498);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppBrandBatchPreloadController.TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, false), AppBrandBatchPreloadController.b.class, new f() {});
    AppMethodBeat.o(48498);
  }
  
  private void predownloadPlugins(PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48497);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppBrandBatchPreloadController.TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, true), AppBrandBatchPreloadController.b.class, new f() {});
    AppMethodBeat.o(48497);
  }
  
  private void preloadMiniProgramEnv(final int paramInt, PRELOAD_ENV_LEVEL paramPRELOAD_ENV_LEVEL, boolean paramBoolean)
  {
    AppMethodBeat.i(48496);
    paramPRELOAD_ENV_LEVEL = com.tencent.mm.plugin.appbrand.task.n.qRU;
    if (paramInt == 1004) {
      paramPRELOAD_ENV_LEVEL = com.tencent.mm.plugin.appbrand.task.n.qRT;
    }
    while ((!com.tencent.mm.plugin.appbrand.game.a.n.bOz()) && (this.mIsGameEnv) && (paramPRELOAD_ENV_LEVEL == com.tencent.mm.plugin.appbrand.task.n.qRT))
    {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, AppBrandBatchPreloadController.a.class, null);
      AppMethodBeat.o(48496);
      return;
      if (paramInt == 1000) {
        paramPRELOAD_ENV_LEVEL = com.tencent.mm.plugin.appbrand.task.n.qRS;
      }
    }
    if (com.tencent.mm.plugin.appbrand.task.h.k(paramPRELOAD_ENV_LEVEL))
    {
      if (paramPRELOAD_ENV_LEVEL == com.tencent.mm.plugin.appbrand.task.n.qRT) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt = e.jB(bool);
        com.tencent.mm.plugin.report.service.h.IzE.el(paramInt, z.qPb.qPo);
        com.tencent.mm.plugin.appbrand.task.h.a(paramPRELOAD_ENV_LEVEL, new h.b()
        {
          public final void NR()
          {
            AppMethodBeat.i(48483);
            com.tencent.mm.plugin.report.service.h.IzE.el(paramInt, z.qPb.qPp);
            Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv success");
            AppMethodBeat.o(48483);
          }
        }, paramBoolean);
        AppMethodBeat.o(48496);
        return;
      }
    }
    if (com.tencent.mm.plugin.appbrand.task.h.j(paramPRELOAD_ENV_LEVEL))
    {
      Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv alreadyExist");
      AppMethodBeat.o(48496);
      return;
    }
    Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv fail internal error");
    AppMethodBeat.o(48496);
  }
  
  public String preload(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(48494);
    this.mIsGameEnv = paramBoolean;
    for (;;)
    {
      Object localObject1;
      float f2;
      float f1;
      int i;
      try
      {
        localObject1 = new JSONObject(paramJSONObject.optString("openParams"));
        int j = ((JSONObject)localObject1).optInt("visitScene");
        this.mBusinessScene = ((JSONObject)localObject1).optInt("businessScene");
        int k = ((JSONObject)localObject1).optInt("innerScene");
        if (this.mBusinessScene == 0)
        {
          AppMethodBeat.o(48494);
          return "fail:mBusinessScene illegal";
        }
        paramJSONObject = new JSONArray(paramJSONObject.optString("preloadList"));
        if (paramJSONObject.length() <= 0)
        {
          Log.w("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadList is empty");
          AppMethodBeat.o(48494);
          return "fail:preloadList is empty";
        }
        b.cjj();
        localObject1 = b.eV(this.mBusinessScene, k);
        if (((localObject1 == null) || (((Map)localObject1).size() <= 0)) && (this.mBusinessScene != 1))
        {
          Log.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "predictRate null businessScene:%d,innerScene:%d", new Object[] { Integer.valueOf(this.mBusinessScene), Integer.valueOf(k) });
          AppMethodBeat.o(48494);
          return "fail:mBusinessScene predictRate error!";
        }
        float f3;
        PreloadAppInfo localPreloadAppInfo;
        if (this.mBusinessScene == 1)
        {
          f3 = 0.0F;
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            Log.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "inner predictRate null businessScene:%d,innerScene:%d", new Object[] { Integer.valueOf(this.mBusinessScene), Integer.valueOf(k) });
            f2 = 1.0F;
            f1 = 1.0F;
            Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "mVisitScene:%d,mBusinessScene:%d,mInnerScene:%d,mLowLevelRate:%f,middleLevelRate:%f,highLevelRate:%f", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mBusinessScene), Integer.valueOf(k), Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(f2) });
            localObject1 = new ArrayList();
            i = 0;
            if (i >= paramJSONObject.length()) {
              break label713;
            }
            Object localObject2 = paramJSONObject.optJSONObject(i);
            localPreloadAppInfo = new PreloadAppInfo();
            localPreloadAppInfo.openRate = ((float)((JSONObject)localObject2).optDouble("openRate"));
            localPreloadAppInfo.appId = ((JSONObject)localObject2).optString("appId");
            localPreloadAppInfo.appType = ((JSONObject)localObject2).optInt("appType");
            localPreloadAppInfo.path = ((JSONObject)localObject2).optString("path");
            localObject2 = new pm();
            ((pm)localObject2).hfw = j;
            ((pm)localObject2).hfx = this.mBusinessScene;
            ((pm)localObject2).hfy = k;
            ((pm)localObject2).gmF = ((pm)localObject2).z("AppId", localPreloadAppInfo.appId, true);
            ((pm)localObject2).gYN = localPreloadAppInfo.appType;
            ((pm)localObject2).hfz = ((pm)localObject2).z("openRate", String.valueOf(localPreloadAppInfo.openRate), true);
            ((pm)localObject2).hee = ((pm)localObject2).z("path", localPreloadAppInfo.path, true);
            ((pm)localObject2).bpa();
            if (localPreloadAppInfo.openRate < f3)
            {
              Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadAppInfo.openRate:%f < mLowLevelRate:%f", new Object[] { Float.valueOf(localPreloadAppInfo.openRate), Float.valueOf(f3) });
              break label831;
            }
          }
          else
          {
            f1 = ((Float)((Map)localObject1).get(Integer.valueOf(c.qSx.ordinal()))).floatValue();
            f2 = ((Float)((Map)localObject1).get(Integer.valueOf(c.qSy.ordinal()))).floatValue();
            continue;
          }
        }
        else
        {
          f3 = ((Float)((Map)localObject1).get(Integer.valueOf(c.qSw.ordinal()))).floatValue();
          f1 = ((Float)((Map)localObject1).get(Integer.valueOf(c.qSx.ordinal()))).floatValue();
          f2 = ((Float)((Map)localObject1).get(Integer.valueOf(c.qSy.ordinal()))).floatValue();
          continue;
        }
        ((ArrayList)localObject1).add(localPreloadAppInfo);
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "parse data error:%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(48494);
        return "fail:params error!";
      }
      label713:
      if (((ArrayList)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new Comparator() {});
        paramJSONObject = (PreloadAppInfo)((ArrayList)localObject1).get(0);
        Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "high preloadAppInfo openRate:%f,appid:%s", new Object[] { Float.valueOf(paramJSONObject.openRate), paramJSONObject.appId });
        if (paramJSONObject.openRate < f2) {
          break label800;
        }
        dealPreload(c.qSy, paramJSONObject);
      }
      for (;;)
      {
        AppMethodBeat.o(48494);
        return "ok";
        label800:
        if (paramJSONObject.openRate >= f1) {
          dealPreload(c.qSx, paramJSONObject);
        } else {
          dealPreload(c.qSw, paramJSONObject);
        }
      }
      label831:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController
 * JD-Core Version:    0.7.0.1
 */