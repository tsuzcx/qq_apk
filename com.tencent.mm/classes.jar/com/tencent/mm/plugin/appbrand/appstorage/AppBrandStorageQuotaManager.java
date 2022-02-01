package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ol;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager;", "", "()V", "MMKV_KEY_PREFIX", "", "MMKV_NAME", "STORAGE_KEY_NORMAL_NONE_FLATTEN", "STORAGE_KEY_SAVED_TEMP", "STORAGE_KEY_TEMP", "TAG", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "supportRuntimeSpaceStaticsMap", "", "", "calculateAllStorageSize", "", "appId", "key2ReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "calculateStorageSize", "", "key", "dir", "Lcom/tencent/mm/vfs/VFSFile;", "reportStruct", "calculateStorageSizeAndCleanupTempFilesOnExit", "minTempSize", "maxTempSize", "maxTotalTempSize", "clearCalculatedStorageSize", "getStorageSize", "getSupportRuntimeSpaceStaticsMap", "hasCalculatedStorageSize", "", "markSupportRuntimeSpaceStatics", "registerStorage", "path", "reset", "saveStorageSize", "size", "log", "report1654", "CleanupTempFilesOnExitParams", "IPCCleanupTempFilesOnExitTask", "plugin-appbrand-integration_release"})
public final class AppBrandStorageQuotaManager
{
  public static final HashMap<String, String> nMt;
  public static final Map<String, List<String>> nMu;
  public static final AppBrandStorageQuotaManager nMv;
  
  static
  {
    AppMethodBeat.i(279268);
    nMv = new AppBrandStorageQuotaManager();
    nMt = new HashMap();
    nMu = (Map)new LinkedHashMap();
    AppMethodBeat.o(279268);
  }
  
  public static long a(String paramString1, String paramString2, q paramq)
  {
    AppMethodBeat.i(279264);
    p.k(paramString1, "appId");
    p.k(paramString2, "key");
    p.k(paramq, "dir");
    if ((!paramq.ifE()) || (!paramq.isDirectory()))
    {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "dir not exist[" + paramString1 + ',' + paramString2 + ',' + paramq.getPath() + ']');
      a(paramString1, paramString2, 0L, true);
      AppMethodBeat.o(279264);
      return 0L;
    }
    long l3 = System.currentTimeMillis();
    long l1;
    switch (paramString2.hashCode())
    {
    default: 
      l1 = o.p(paramq);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "calculateStorageSize [" + paramString1 + ',' + paramString2 + ',' + paramq.getPath() + "]->" + l1 + " cost[" + (System.currentTimeMillis() - l3) + ']');
      if (l1 >= 0L) {
        a(paramString1, paramString2, l1, true);
      }
      l1 = i.be(l1, 0L);
      AppMethodBeat.o(279264);
      return l1;
      if (!paramString2.equals("temp")) {
        break;
      }
      label249:
      if (p.h(paramString2, "temp")) {
        localObject = h.nMI;
      }
      for (Object localObject = h.bIB();; localObject = LuggageLocalFileObjectManager.nNG)
      {
        localObject = paramq.a((s)localObject);
        if (localObject == null) {
          break label340;
        }
        int j = localObject.length;
        int i = 0;
        long l2 = 0L;
        for (;;)
        {
          l1 = l2;
          if (i >= j) {
            break;
          }
          l2 += localObject[i].length();
          i += 1;
        }
        if (!paramString2.equals("saved_temp")) {
          break;
        }
        break label249;
      }
      label340:
      l1 = 0L;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(279260);
    p.k(paramString1, "appId");
    p.k(paramString2, "key");
    if (paramBoolean) {
      Log.i("MicroMsg.AppBrandStorageQuotaManager", "save storage size:" + paramLong + " for " + paramString1 + ',' + paramString2);
    }
    Object localObject = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        paramString1 = ((SharedPreferences.Editor)localObject).putLong("storage_size_" + paramString1 + '_' + paramString2, paramLong);
        if (paramString1 != null)
        {
          paramString1.apply();
          AppMethodBeat.o(279260);
          return;
        }
      }
    }
    AppMethodBeat.o(279260);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap, HashMap<String, ol> paramHashMap1, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(279262);
    p.k(paramString, "appId");
    p.k(paramHashMap, "storageKey2Path");
    p.k(paramMap, "supportRuntimeSpaceStaticsMap");
    Object localObject1 = paramHashMap.keySet();
    p.j(localObject1, "storageKey2Path.keys");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      p.j(str, "it");
      ol localol = (ol)paramHashMap1.get(str);
      p.k(paramString, "appId");
      p.k(str, "key");
      p.k(paramHashMap, "storageKey2Path");
      p.k(paramMap, "supportRuntimeSpaceStaticsMap");
      Object localObject2 = (String)paramHashMap.get(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = new q((String)localObject1);
      if (localol != null)
      {
        localObject2 = (List)paramMap.get(paramString);
        if ((localObject2 == null) || (((List)localObject2).contains(str) != true)) {
          break label249;
        }
      }
      label249:
      for (long l = a.N(cL(paramString, str) / 1024.0D);; l = -1L)
      {
        localol.AX(l);
        l = a(paramString, str, (q)localObject1);
        if (localol == null) {
          break;
        }
        localol.AU(a.N(l / 1024.0D));
        break;
      }
    }
    AppMethodBeat.o(279262);
  }
  
  public static void adG(String paramString)
  {
    AppMethodBeat.i(279257);
    p.k(paramString, "appId");
    Log.i("MicroMsg.AppBrandStorageQuotaManager", "clearCalculatedStorageSize ".concat(String.valueOf(paramString)));
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.remove("storage_size_" + paramString + "_temp");
    }
    localMultiProcessMMKV = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.remove("storage_size_" + paramString + "_saved_temp");
    }
    localMultiProcessMMKV = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.remove("storage_size_" + paramString + "_normal_none_flatten");
      AppMethodBeat.o(279257);
      return;
    }
    AppMethodBeat.o(279257);
  }
  
  public static void cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279256);
    p.k(paramString1, "key");
    p.k(paramString2, "path");
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
      AppMethodBeat.o(279256);
      return;
      i = 0;
      break;
    }
    label72:
    ((Map)nMt).put(paramString1, paramString2);
    AppMethodBeat.o(279256);
  }
  
  public static boolean cK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279258);
    p.k(paramString1, "appId");
    p.k(paramString2, "key");
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localMultiProcessMMKV != null)
    {
      boolean bool = localMultiProcessMMKV.containsKey("storage_size_" + paramString1 + '_' + paramString2);
      AppMethodBeat.o(279258);
      return bool;
    }
    AppMethodBeat.o(279258);
    return false;
  }
  
  public static long cL(String paramString1, String paramString2)
  {
    long l = 0L;
    AppMethodBeat.i(279259);
    p.k(paramString1, "appId");
    p.k(paramString2, "key");
    MultiProcessMMKV localMultiProcessMMKV = f.nCi.getMMKV("AppBrandStorageQuota");
    if (localMultiProcessMMKV != null) {
      l = localMultiProcessMMKV.getLong("storage_size_" + paramString1 + '_' + paramString2, 0L);
    }
    Log.i("MicroMsg.AppBrandStorageQuotaManager", "get saved storage size:" + l + " for " + paramString1 + ',' + paramString2);
    AppMethodBeat.o(279259);
    return l;
  }
  
  public static void cM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279265);
    p.k(paramString2, "key");
    if (paramString1 == null)
    {
      AppMethodBeat.o(279265);
      return;
    }
    if ((List)nMu.get(paramString1) == null)
    {
      nMu.put(paramString1, (List)new ArrayList());
      x localx = x.aazN;
    }
    paramString1 = (List)nMu.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.add(paramString2);
      AppMethodBeat.o(279265);
      return;
    }
    AppMethodBeat.o(279265);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(279255);
    nMt.clear();
    nMu.clear();
    AppMethodBeat.o(279255);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$IPCCleanupTempFilesOnExitTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "createStatStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "params", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class a
    implements d<AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams, IPCVoid>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$IPCCleanupTempFilesOnExitTask$invoke$1$1"})
    static final class a
      implements Runnable
    {
      a(AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams paramCleanupTempFilesOnExitParams1, AppBrandStorageQuotaManager.a parama, AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams paramCleanupTempFilesOnExitParams2) {}
      
      public final void run()
      {
        AppMethodBeat.i(274043);
        HashMap localHashMap = new HashMap();
        Object localObject1;
        long l1;
        Object localObject2;
        Object localObject3;
        if (this.nMD.nMz)
        {
          localObject1 = AppBrandStorageQuotaManager.a.a(this.nMD);
          ((ol)localObject1).FA("tmp");
          if (this.nMF.nMC)
          {
            l1 = 1L;
            ((ol)localObject1).AY(l1);
            ((Map)localHashMap).put("temp", localObject1);
            localObject2 = (Map)localHashMap;
            localObject3 = AppBrandStorageQuotaManager.a.a(this.nMD);
            ((ol)localObject3).FA("store");
            if (!this.nMF.nMC) {
              break label573;
            }
            l1 = 1L;
            label111:
            ((ol)localObject3).AY(l1);
            ((Map)localObject2).put("saved_temp", localObject3);
            localObject2 = (Map)localHashMap;
            localObject3 = AppBrandStorageQuotaManager.a.a(this.nMD);
            ((ol)localObject3).FA("usr");
            if (!this.nMF.nMC) {
              break label578;
            }
            l1 = 1L;
            label166:
            ((ol)localObject3).AY(l1);
            ((Map)localObject2).put("normal_none_flatten", localObject3);
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.AppBrandStorageQuotaManager", "[mm]start check: appId[" + this.nMD.appId + "] minTemp[" + this.nMD.nMw + "] maxTemp[" + this.nMD.nMx + "] maxTotal[" + this.nMD.nMy + ']');
          localObject2 = AppBrandStorageQuotaManager.nMv;
          AppBrandStorageQuotaManager.a(this.nMD.appId, this.nMD.nMt, localHashMap, this.nMD.nMu);
          localObject2 = h.nMI;
          String str = this.nMD.appId;
          long l2 = this.nMD.nMw;
          long l4 = this.nMD.nMx;
          localObject2 = this.nMD.nMt;
          p.k(str, "appId");
          p.k(localObject2, "storageKey2Path");
          long l3 = System.currentTimeMillis();
          localObject3 = (String)((HashMap)localObject2).get("temp");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject2 = new q((String)localObject2);
          if ((((q)localObject2).ifE()) && (((q)localObject2).isDirectory()))
          {
            localObject2 = ((q)localObject2).bOF();
            p.j(localObject2, "appDir.absolutePath");
            if (!h.a.adH((String)localObject2)) {}
          }
          else
          {
            localObject2 = h.nMI;
            h.a.a(this.nMD.nMy, (ol)localObject1);
            localObject1 = localHashMap.values();
            p.j(localObject1, "key2ReportStruct.values");
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ol)((Iterator)localObject1).next();
              Log.i("MicroMsg.AppBrandStorageQuotaManager", "report " + ((ol)localObject2).agI());
              ((ol)localObject2).bpa();
              p.j(localObject2, "this");
              if ((p.h("store", ((ol)localObject2).aow())) || (p.h("usr", ((ol)localObject2).aow())))
              {
                localObject3 = AppBrandStorageQuotaManager.nMv;
                AppBrandStorageQuotaManager.a((ol)localObject2);
              }
            }
            l1 = 0L;
            break;
            label573:
            l1 = 0L;
            break label111;
            label578:
            l1 = 0L;
            break label166;
          }
          localObject2 = AppBrandStorageQuotaManager.nMv;
          l1 = AppBrandStorageQuotaManager.cL(str, "temp");
          if (localObject1 != null) {
            ((ol)localObject1).AU(a.N(l1 / 1024.0D));
          }
          long l5 = l4 - l2;
          Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirTempFileLimit current:" + l1 + " min:" + l2 + " max:" + l4 + " limit:" + l5);
          l2 = h.a.n(str, l1, l5);
          if (l2 >= 0L)
          {
            if (localObject1 != null) {
              ((ol)localObject1).aoy();
            }
            localObject2 = AppBrandStorageQuotaManager.nMv;
            AppBrandStorageQuotaManager.a(str, "temp", l2, true);
          }
          localObject2 = new StringBuilder("checkAppDirTempFileLimit after:");
          if (l2 >= 0L) {
            l1 = l2;
          }
          for (;;)
          {
            Log.i("MicroMsg.AppBrandTempFileCleaner", l1 + " cost " + (System.currentTimeMillis() - l3));
            break;
          }
          AppMethodBeat.o(274043);
          return;
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager
 * JD-Core Version:    0.7.0.1
 */