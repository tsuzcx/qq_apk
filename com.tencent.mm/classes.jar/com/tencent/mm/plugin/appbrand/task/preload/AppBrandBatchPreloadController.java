package com.tencent.mm.plugin.appbrand.task.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.task.c.a;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.ac;
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
  
  private void dealPreload(b paramb, PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48495);
    switch (AppBrandBatchPreloadController.5.lYX[paramb.ordinal()])
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
    XIPCInvoker.a("com.tencent.mm", new TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, false), b.class, new d() {});
    AppMethodBeat.o(48498);
  }
  
  private void predownloadPlugins(PreloadAppInfo paramPreloadAppInfo)
  {
    AppMethodBeat.i(48497);
    XIPCInvoker.a("com.tencent.mm", new TaskParamsCallPredownload(paramPreloadAppInfo.appId, paramPreloadAppInfo.appType, paramPreloadAppInfo.path, this.mBusinessScene, true), b.class, new d() {});
    AppMethodBeat.o(48497);
  }
  
  private void preloadMiniProgramEnv(int paramInt, PRELOAD_ENV_LEVEL paramPRELOAD_ENV_LEVEL, boolean paramBoolean)
  {
    AppMethodBeat.i(48496);
    paramPRELOAD_ENV_LEVEL = e.lYt;
    if (paramInt == 1004) {
      paramPRELOAD_ENV_LEVEL = e.lYs;
    }
    while ((this.mIsGameEnv) && (paramPRELOAD_ENV_LEVEL == e.lYs))
    {
      XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, a.class, null);
      AppMethodBeat.o(48496);
      return;
      if (paramInt == 1000) {
        paramPRELOAD_ENV_LEVEL = e.lYr;
      }
    }
    if (com.tencent.mm.plugin.appbrand.task.c.but())
    {
      com.tencent.mm.plugin.appbrand.task.c.a(paramPRELOAD_ENV_LEVEL, new c.a()
      {
        public final void onReady()
        {
          AppMethodBeat.i(48483);
          ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv success");
          AppMethodBeat.o(48483);
        }
      }, paramBoolean);
      AppMethodBeat.o(48496);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.task.c.aUy())
    {
      ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv alreadyExist");
      AppMethodBeat.o(48496);
      return;
    }
    ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadMiniProgramEnv fail internal error");
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
          ac.w("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadList is empty");
          AppMethodBeat.o(48494);
          return "fail:preloadList is empty";
        }
        a.buL();
        localObject1 = a.eg(this.mBusinessScene, k);
        if (((localObject1 == null) || (((Map)localObject1).size() <= 0)) && (this.mBusinessScene != 1))
        {
          ac.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "predictRate null businessScene:%d,innerScene:%d", new Object[] { Integer.valueOf(this.mBusinessScene), Integer.valueOf(k) });
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
            ac.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "inner predictRate null businessScene:%d,innerScene:%d", new Object[] { Integer.valueOf(this.mBusinessScene), Integer.valueOf(k) });
            f2 = 1.0F;
            f1 = 1.0F;
            ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "mVisitScene:%d,mBusinessScene:%d,mInnerScene:%d,mLowLevelRate:%f,middleLevelRate:%f,highLevelRate:%f", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mBusinessScene), Integer.valueOf(k), Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(f2) });
            localObject1 = new ArrayList();
            i = 0;
            if (i >= paramJSONObject.length()) {
              break label708;
            }
            Object localObject2 = paramJSONObject.optJSONObject(i);
            localPreloadAppInfo = new PreloadAppInfo();
            localPreloadAppInfo.openRate = ((float)((JSONObject)localObject2).optDouble("openRate"));
            localPreloadAppInfo.appId = ((JSONObject)localObject2).optString("appId");
            localPreloadAppInfo.appType = ((JSONObject)localObject2).optInt("appType");
            localPreloadAppInfo.path = ((JSONObject)localObject2).optString("path");
            localObject2 = new hl();
            ((hl)localObject2).efG = j;
            ((hl)localObject2).efH = this.mBusinessScene;
            ((hl)localObject2).efI = k;
            ((hl)localObject2).ecm = ((hl)localObject2).t("AppId", localPreloadAppInfo.appId, true);
            ((hl)localObject2).eco = localPreloadAppInfo.appType;
            ((hl)localObject2).efJ = ((hl)localObject2).t("openRate", String.valueOf(localPreloadAppInfo.openRate), true);
            ((hl)localObject2).eex = ((hl)localObject2).t("path", localPreloadAppInfo.path, true);
            ((hl)localObject2).aHZ();
            if (localPreloadAppInfo.openRate < f3)
            {
              ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "preloadAppInfo.openRate:%f < mLowLevelRate:%f", new Object[] { Float.valueOf(localPreloadAppInfo.openRate), Float.valueOf(f3) });
              break label826;
            }
          }
          else
          {
            f1 = ((Float)((Map)localObject1).get(Integer.valueOf(b.lZe.ordinal()))).floatValue();
            f2 = ((Float)((Map)localObject1).get(Integer.valueOf(b.lZf.ordinal()))).floatValue();
            continue;
          }
        }
        else
        {
          f3 = ((Float)((Map)localObject1).get(Integer.valueOf(b.lZd.ordinal()))).floatValue();
          f1 = ((Float)((Map)localObject1).get(Integer.valueOf(b.lZe.ordinal()))).floatValue();
          f2 = ((Float)((Map)localObject1).get(Integer.valueOf(b.lZf.ordinal()))).floatValue();
          continue;
        }
        ((ArrayList)localObject1).add(localPreloadAppInfo);
      }
      catch (JSONException paramJSONObject)
      {
        ac.e("MicroMsg.Predownload.AppBrandBatchPreloadController", "parse data error:%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(48494);
        return "fail:params error!";
      }
      label708:
      if (((ArrayList)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new Comparator() {});
        paramJSONObject = (PreloadAppInfo)((ArrayList)localObject1).get(0);
        ac.i("MicroMsg.Predownload.AppBrandBatchPreloadController", "high preloadAppInfo openRate:%f,appid:%s", new Object[] { Float.valueOf(paramJSONObject.openRate), paramJSONObject.appId });
        if (paramJSONObject.openRate < f2) {
          break label795;
        }
        dealPreload(b.lZf, paramJSONObject);
      }
      for (;;)
      {
        AppMethodBeat.o(48494);
        return "ok";
        label795:
        if (paramJSONObject.openRate >= f1) {
          dealPreload(b.lZe, paramJSONObject);
        } else {
          dealPreload(b.lZd, paramJSONObject);
        }
      }
      label826:
      i += 1;
    }
  }
  
  public static class TaskParamsCallPredownload
    implements Parcelable
  {
    public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR;
    String appId;
    int appType;
    boolean lZa;
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
        this.lZa = bool;
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
      this.lZa = paramBoolean;
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
      if (this.lZa) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController
 * JD-Core Version:    0.7.0.1
 */