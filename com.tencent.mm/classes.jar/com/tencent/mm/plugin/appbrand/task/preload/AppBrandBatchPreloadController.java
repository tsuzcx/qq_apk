package com.tencent.mm.plugin.appbrand.task.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mn;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
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
    switch (AppBrandBatchPreloadController.5.nQK[paramc.ordinal()])
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
    XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, false), b.class, new d() {});
    AppMethodBeat.o(48498);
  }
  
  private void predownloadPlugins(PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48497);
    XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, true), b.class, new d() {});
    AppMethodBeat.o(48497);
  }
  
  private void preloadMiniProgramEnv(final int paramInt, PRELOAD_ENV_LEVEL paramPRELOAD_ENV_LEVEL, boolean paramBoolean)
  {
    AppMethodBeat.i(48496);
    paramPRELOAD_ENV_LEVEL = g.nPF;
    if (paramInt == 1004) {
      paramPRELOAD_ENV_LEVEL = g.nPE;
    }
    while ((this.mIsGameEnv) && (paramPRELOAD_ENV_LEVEL == g.nPE))
    {
      XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class, null);
      AppMethodBeat.o(48496);
      return;
      if (paramInt == 1000) {
        paramPRELOAD_ENV_LEVEL = g.nPD;
      }
    }
    if (com.tencent.mm.plugin.appbrand.task.e.l(paramPRELOAD_ENV_LEVEL))
    {
      if (paramPRELOAD_ENV_LEVEL == g.nPE) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt = e.iF(bool);
        h.CyF.dN(paramInt, z.nMJ.nMT);
        com.tencent.mm.plugin.appbrand.task.e.a(paramPRELOAD_ENV_LEVEL, new e.b()
        {
          public final void onReady()
          {
            AppMethodBeat.i(48483);
            h.CyF.dN(paramInt, z.nMJ.nMU);
            Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv success");
            AppMethodBeat.o(48483);
          }
        }, paramBoolean);
        AppMethodBeat.o(48496);
        return;
      }
    }
    if (com.tencent.mm.plugin.appbrand.task.e.k(paramPRELOAD_ENV_LEVEL))
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
        b.bWE();
        localObject1 = b.ew(this.mBusinessScene, k);
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
            localObject2 = new mn();
            ((mn)localObject2).fcC = j;
            ((mn)localObject2).fcD = this.mBusinessScene;
            ((mn)localObject2).fcE = k;
            ((mn)localObject2).eJx = ((mn)localObject2).x("AppId", localPreloadAppInfo.appId, true);
            ((mn)localObject2).eYW = localPreloadAppInfo.appType;
            ((mn)localObject2).fcF = ((mn)localObject2).x("openRate", String.valueOf(localPreloadAppInfo.openRate), true);
            ((mn)localObject2).fbm = ((mn)localObject2).x("path", localPreloadAppInfo.path, true);
            ((mn)localObject2).bfK();
            if (localPreloadAppInfo.openRate < f3)
            {
              Log.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadAppInfo.openRate:%f < mLowLevelRate:%f", new Object[] { Float.valueOf(localPreloadAppInfo.openRate), Float.valueOf(f3) });
              break label831;
            }
          }
          else
          {
            f1 = ((Float)((Map)localObject1).get(Integer.valueOf(c.nQS.ordinal()))).floatValue();
            f2 = ((Float)((Map)localObject1).get(Integer.valueOf(c.nQT.ordinal()))).floatValue();
            continue;
          }
        }
        else
        {
          f3 = ((Float)((Map)localObject1).get(Integer.valueOf(c.nQR.ordinal()))).floatValue();
          f1 = ((Float)((Map)localObject1).get(Integer.valueOf(c.nQS.ordinal()))).floatValue();
          f2 = ((Float)((Map)localObject1).get(Integer.valueOf(c.nQT.ordinal()))).floatValue();
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
        dealPreload(c.nQT, paramJSONObject);
      }
      for (;;)
      {
        AppMethodBeat.o(48494);
        return "ok";
        label800:
        if (paramJSONObject.openRate >= f1) {
          dealPreload(c.nQS, paramJSONObject);
        } else {
          dealPreload(c.nQR, paramJSONObject);
        }
      }
      label831:
      i += 1;
    }
  }
  
  public static class TaskParamsCallPredownload
    implements Parcelable
  {
    public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR;
    String appId;
    int appType;
    boolean nQN;
    String path;
    int scene;
    
    static
    {
      AppMethodBeat.i(48493);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(48493);
    }
    
    protected TaskParamsCallPredownload(Parcel paramParcel)
    {
      AppMethodBeat.i(48492);
      this.appId = paramParcel.readString();
      this.appType = paramParcel.readInt();
      this.path = paramParcel.readString();
      this.scene = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.nQN = bool;
        AppMethodBeat.o(48492);
        return;
        bool = false;
      }
    }
    
    public TaskParamsCallPredownload(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
    {
      this.appId = paramString1;
      this.appType = paramInt1;
      this.path = paramString2;
      this.scene = paramInt2;
      this.nQN = paramBoolean;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48491);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.appType);
      paramParcel.writeString(this.path);
      paramParcel.writeInt(this.scene);
      if (this.nQN) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(48491);
        return;
      }
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<AppBrandBatchPreloadController.TaskParamsCallPredownload, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController
 * JD-Core Version:    0.7.0.1
 */