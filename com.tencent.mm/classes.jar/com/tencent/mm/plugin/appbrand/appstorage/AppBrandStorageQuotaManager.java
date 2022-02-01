package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.se;
import com.tencent.mm.autogen.mmdata.rpt.se.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager;", "", "()V", "MMKV_KEY_PREFIX", "", "MMKV_NAME", "STORAGE_KEY_NORMAL_NONE_FLATTEN", "STORAGE_KEY_SAVED_TEMP", "STORAGE_KEY_TEMP", "TAG", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "supportRuntimeSpaceStaticsMap", "", "", "calculateAllStorageSize", "", "appId", "key2ReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "calculateStorageSize", "", "key", "dir", "Lcom/tencent/mm/vfs/VFSFile;", "reportStruct", "calculateStorageSizeAndCleanupTempFilesOnExit", "minTempSize", "maxTempSize", "maxTotalTempSize", "clearCalculatedStorageSize", "getStorageSize", "getSupportRuntimeSpaceStaticsMap", "hasCalculatedStorageSize", "", "markSupportRuntimeSpaceStatics", "registerStorage", "path", "reset", "saveStorageSize", "size", "log", "report1654", "CleanupTempFilesOnExitParams", "IPCCleanupTempFilesOnExitTask", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandStorageQuotaManager
{
  public static final AppBrandStorageQuotaManager qMt;
  public static final HashMap<String, String> qMu;
  public static final Map<String, List<String>> qMv;
  
  static
  {
    AppMethodBeat.i(323227);
    qMt = new AppBrandStorageQuotaManager();
    qMu = new HashMap();
    qMv = (Map)new LinkedHashMap();
    AppMethodBeat.o(323227);
  }
  
  public static void Wh(String paramString)
  {
    AppMethodBeat.i(323198);
    s.u(paramString, "appId");
    Log.i("MicroMsg.AppBrandStorageQuotaManager", s.X("clearCalculatedStorageSize ", paramString));
    Object localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).remove("storage_size_" + paramString + "_temp");
    }
    localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).remove("storage_size_" + paramString + "_saved_temp");
    }
    localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).remove("storage_size_" + paramString + "_normal_none_flatten");
    }
    AppMethodBeat.o(323198);
  }
  
  public static long a(String paramString1, String paramString2, u paramu)
  {
    AppMethodBeat.i(323213);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    s.u(paramu, "dir");
    if ((!paramu.jKS()) || (!paramu.isDirectory()))
    {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "dir not exist[" + paramString1 + ',' + paramString2 + ',' + ah.v(paramu.mUri) + ']');
      b(paramString1, paramString2, 0L, true);
      AppMethodBeat.o(323213);
      return 0L;
    }
    long l3 = System.currentTimeMillis();
    boolean bool;
    if (s.p(paramString2, "temp"))
    {
      bool = true;
      if (!bool) {
        break label213;
      }
      if (!s.p(paramString2, "temp")) {
        break label205;
      }
      localObject = m.qMD;
    }
    long l1;
    label205:
    for (Object localObject = m.cif();; localObject = LuggageLocalFileObjectManager.qNy)
    {
      localObject = paramu.a((w)localObject);
      if (localObject == null) {
        break label324;
      }
      int j = localObject.length;
      int i = 0;
      l1 = 0L;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += localObject[i].length();
        i += 1;
      }
      bool = s.p(paramString2, "saved_temp");
      break;
    }
    label213:
    for (long l2 = t.q(paramu);; l2 = 0L)
    {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "calculateStorageSize [" + paramString1 + ',' + paramString2 + ',' + ah.v(paramu.mUri) + "]->" + l2 + " cost[" + (System.currentTimeMillis() - l3) + ']');
      if (l2 >= 0L) {
        b(paramString1, paramString2, l2, true);
      }
      l1 = k.bR(l2, 0L);
      AppMethodBeat.o(323213);
      return l1;
    }
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap, HashMap<String, se> paramHashMap1, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(323208);
    s.u(paramString, "appId");
    s.u(paramHashMap, "storageKey2Path");
    s.u(paramMap, "supportRuntimeSpaceStaticsMap");
    Object localObject1 = paramHashMap.keySet();
    s.s(localObject1, "storageKey2Path.keys");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      s.s(str, "it");
      se localse = (se)paramHashMap1.get(str);
      s.u(paramString, "appId");
      s.u(str, "key");
      s.u(paramHashMap, "storageKey2Path");
      s.u(paramMap, "supportRuntimeSpaceStaticsMap");
      Object localObject2 = (String)paramHashMap.get(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = new u((String)localObject1);
      int i;
      if (localse != null)
      {
        localObject2 = (List)paramMap.get(paramString);
        if ((localObject2 == null) || (((List)localObject2).contains(str) != true)) {
          break label255;
        }
        i = 1;
        label194:
        if (i == 0) {
          break label261;
        }
      }
      label261:
      for (long l = a.ai(dc(paramString, str) / 1024.0D);; l = -1L)
      {
        localse.jxC = l;
        l = a(paramString, str, (u)localObject1);
        if (localse == null) {
          break;
        }
        localse.jxx = a.ai(l / 1024.0D);
        break;
        label255:
        i = 0;
        break label194;
      }
    }
    AppMethodBeat.o(323208);
  }
  
  public static void b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(323204);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    if (paramBoolean) {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "save storage size:" + paramLong + " for " + paramString1 + ',' + paramString2);
    }
    Object localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        paramString1 = ((SharedPreferences.Editor)localObject).putLong("storage_size_" + paramString1 + '_' + paramString2, paramLong);
        if (paramString1 != null) {
          paramString1.apply();
        }
      }
    }
    AppMethodBeat.o(323204);
  }
  
  public static void da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323194);
    s.u(paramString1, "key");
    s.u(paramString2, "path");
    if (((CharSequence)paramString1).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)paramString2).length() != 0) {
          break label67;
        }
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label72;
      }
      AppMethodBeat.o(323194);
      return;
      i = 0;
      break;
    }
    label72:
    ((Map)qMu).put(paramString1, paramString2);
    AppMethodBeat.o(323194);
  }
  
  public static boolean db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323199);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    Object localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject == null)
    {
      AppMethodBeat.o(323199);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).containsKey("storage_size_" + paramString1 + '_' + paramString2);
    AppMethodBeat.o(323199);
    return bool;
  }
  
  public static long dc(String paramString1, String paramString2)
  {
    long l = 0L;
    AppMethodBeat.i(323202);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    Object localObject = f.qBv;
    localObject = f.getMMKV("AppBrandStorageQuota");
    if (localObject == null) {}
    for (;;)
    {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "get saved storage size:" + l + " for " + paramString1 + ',' + paramString2);
      AppMethodBeat.o(323202);
      return l;
      l = ((MultiProcessMMKV)localObject).getLong("storage_size_" + paramString1 + '_' + paramString2, 0L);
    }
  }
  
  public static void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323218);
    s.u(paramString2, "key");
    if (paramString1 == null)
    {
      AppMethodBeat.o(323218);
      return;
    }
    if ((List)qMv.get(paramString1) == null) {
      qMv.put(paramString1, (List)new ArrayList());
    }
    paramString1 = (List)qMv.get(paramString1);
    if (paramString1 != null) {
      paramString1.add(paramString2);
    }
    AppMethodBeat.o(323218);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(323192);
    qMu.clear();
    qMv.clear();
    AppMethodBeat.o(323192);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$IPCCleanupTempFilesOnExitTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "createStatStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "params", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams, IPCVoid>
  {
    private static se a(AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams paramCleanupTempFilesOnExitParams)
    {
      AppMethodBeat.i(323207);
      se localse = new se();
      localse.iqr = 1L;
      localse.yQ(paramCleanupTempFilesOnExitParams.appId);
      localse.ind = paramCleanupTempFilesOnExitParams.qMA;
      localse.jxw = se.a.oC(paramCleanupTempFilesOnExitParams.hzw);
      localse.jax = paramCleanupTempFilesOnExitParams.qMB;
      AppMethodBeat.o(323207);
      return localse;
    }
    
    private static final void a(AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams paramCleanupTempFilesOnExitParams1, a parama, AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams paramCleanupTempFilesOnExitParams2)
    {
      AppMethodBeat.i(323225);
      s.u(paramCleanupTempFilesOnExitParams1, "$it");
      s.u(parama, "this$0");
      HashMap localHashMap = new HashMap();
      long l1;
      Object localObject1;
      Object localObject2;
      if (paramCleanupTempFilesOnExitParams1.qMz)
      {
        parama = a(paramCleanupTempFilesOnExitParams1);
        parama.yR("tmp");
        if (paramCleanupTempFilesOnExitParams2.qMC)
        {
          l1 = 1L;
          parama.jxD = l1;
          ((Map)localHashMap).put("temp", parama);
          localObject1 = (Map)localHashMap;
          localObject2 = a(paramCleanupTempFilesOnExitParams1);
          ((se)localObject2).yR("store");
          if (!paramCleanupTempFilesOnExitParams2.qMC) {
            break label486;
          }
          l1 = 1L;
          label103:
          ((se)localObject2).jxD = l1;
          ((Map)localObject1).put("saved_temp", localObject2);
          localObject1 = (Map)localHashMap;
          localObject2 = a(paramCleanupTempFilesOnExitParams1);
          ((se)localObject2).yR("usr");
          if (!paramCleanupTempFilesOnExitParams2.qMC) {
            break label491;
          }
          l1 = 1L;
          label151:
          ((se)localObject2).jxD = l1;
          ((Map)localObject1).put("normal_none_flatten", localObject2);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandStorageQuotaManager", "[mm]start check: appId[" + paramCleanupTempFilesOnExitParams1.appId + "] minTemp[" + paramCleanupTempFilesOnExitParams1.qMw + "] maxTemp[" + paramCleanupTempFilesOnExitParams1.qMx + "] maxTotal[" + paramCleanupTempFilesOnExitParams1.qMy + ']');
        paramCleanupTempFilesOnExitParams2 = AppBrandStorageQuotaManager.qMt;
        AppBrandStorageQuotaManager.a(paramCleanupTempFilesOnExitParams1.appId, paramCleanupTempFilesOnExitParams1.qMu, localHashMap, paramCleanupTempFilesOnExitParams1.qMv);
        paramCleanupTempFilesOnExitParams2 = m.qMD;
        localObject2 = paramCleanupTempFilesOnExitParams1.appId;
        long l2 = paramCleanupTempFilesOnExitParams1.qMw;
        long l4 = paramCleanupTempFilesOnExitParams1.qMx;
        paramCleanupTempFilesOnExitParams2 = paramCleanupTempFilesOnExitParams1.qMu;
        s.u(localObject2, "appId");
        s.u(paramCleanupTempFilesOnExitParams2, "storageKey2Path");
        long l3 = System.currentTimeMillis();
        localObject1 = (String)paramCleanupTempFilesOnExitParams2.get("temp");
        paramCleanupTempFilesOnExitParams2 = (AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams)localObject1;
        if (localObject1 == null) {
          paramCleanupTempFilesOnExitParams2 = "";
        }
        paramCleanupTempFilesOnExitParams2 = new u(paramCleanupTempFilesOnExitParams2);
        if ((paramCleanupTempFilesOnExitParams2.jKS()) && (paramCleanupTempFilesOnExitParams2.isDirectory()))
        {
          paramCleanupTempFilesOnExitParams2 = ah.v(paramCleanupTempFilesOnExitParams2.jKT());
          s.s(paramCleanupTempFilesOnExitParams2, "appDir.absolutePath");
          if (!m.a.Wi(paramCleanupTempFilesOnExitParams2)) {}
        }
        else
        {
          paramCleanupTempFilesOnExitParams2 = m.qMD;
          m.a.a(paramCleanupTempFilesOnExitParams1.qMy, parama);
          paramCleanupTempFilesOnExitParams1 = localHashMap.values();
          s.s(paramCleanupTempFilesOnExitParams1, "key2ReportStruct.values");
          paramCleanupTempFilesOnExitParams1 = ((Iterable)paramCleanupTempFilesOnExitParams1).iterator();
          while (paramCleanupTempFilesOnExitParams1.hasNext())
          {
            parama = (se)paramCleanupTempFilesOnExitParams1.next();
            Log.i("MicroMsg.AppBrandStorageQuotaManager", s.X("report ", parama.aIF()));
            parama.bMH();
            if ((s.p("store", parama.jxy)) || (s.p("usr", parama.jxy)))
            {
              paramCleanupTempFilesOnExitParams2 = AppBrandStorageQuotaManager.qMt;
              s.s(parama, "");
              AppBrandStorageQuotaManager.a(parama);
            }
          }
          l1 = 0L;
          break;
          label486:
          l1 = 0L;
          break label103;
          label491:
          l1 = 0L;
          break label151;
        }
        paramCleanupTempFilesOnExitParams2 = AppBrandStorageQuotaManager.qMt;
        l1 = AppBrandStorageQuotaManager.dc((String)localObject2, "temp");
        if (parama != null) {
          parama.jxx = a.ai(l1 / 1024.0D);
        }
        long l5 = l4 - l2;
        Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirTempFileLimit current:" + l1 + " min:" + l2 + " max:" + l4 + " limit:" + l5);
        l2 = m.a.p((String)localObject2, l1, l5);
        if (l2 >= 0L)
        {
          if (parama != null) {
            parama.jxA = 1L;
          }
          paramCleanupTempFilesOnExitParams2 = AppBrandStorageQuotaManager.qMt;
          AppBrandStorageQuotaManager.b((String)localObject2, "temp", l2, true);
        }
        paramCleanupTempFilesOnExitParams2 = new StringBuilder("checkAppDirTempFileLimit after:");
        if (l2 >= 0L) {
          l1 = l2;
        }
        for (;;)
        {
          Log.i("MicroMsg.AppBrandTempFileCleaner", l1 + " cost " + (System.currentTimeMillis() - l3));
          break;
        }
        AppMethodBeat.o(323225);
        return;
        parama = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager
 * JD-Core Version:    0.7.0.1
 */