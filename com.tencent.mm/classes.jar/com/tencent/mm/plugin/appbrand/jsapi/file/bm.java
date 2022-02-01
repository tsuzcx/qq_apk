package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IWxaStorageSpaceStatistics;", "appid", "", "(Ljava/lang/String;)V", "LOCK", "", "TAG", "debug", "", "mDirSizeInfo", "", "", "mFilePattern", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "", "findMatchMonitorDir", "filePath", "folderSize", "directory", "Lcom/tencent/mm/vfs/VFSFile;", "filePattern", "getDirTotalSize", "dirPath", "getFilePattern", "getSpaceSize", "handleDirSizeChangeEvent", "sizeDiff", "op", "handleFileSizeChangeEvent", "monitorDirPath", "makeMonitorTargetId", "register", "currentSize", "registerForNoneFlatten", "registerForStore", "fs", "Lcom/tencent/mm/plugin/appbrand/appstorage/FlattenFileSystem;", "reset", "setSpaceSize", "size", "wantMonitor", "Companion", "plugin-appbrand-integration_release"})
public final class bm
  implements t
{
  public static final a oSS;
  final Object LOCK;
  private final String TAG;
  boolean aGM;
  private final String appid;
  final Map<String, Long> oSQ;
  final Map<String, List<com.tencent.mm.plugin.appbrand.appstorage.n>> oSR;
  
  static
  {
    AppMethodBeat.i(284693);
    oSS = new a((byte)0);
    AppMethodBeat.o(284693);
  }
  
  public bm(String paramString)
  {
    AppMethodBeat.i(284692);
    this.appid = paramString;
    this.TAG = "MicroMsg.WxaStorageSpaceStatisticsService";
    this.oSQ = ((Map)new LinkedHashMap());
    this.oSR = ((Map)new LinkedHashMap());
    this.LOCK = new Object();
    AppMethodBeat.o(284692);
  }
  
  private final long a(q paramq, com.tencent.mm.plugin.appbrand.appstorage.n paramn)
  {
    AppMethodBeat.i(284691);
    if (paramq == null)
    {
      AppMethodBeat.o(284691);
      return -1L;
    }
    paramq = paramq.ifJ();
    if (paramq == null)
    {
      AppMethodBeat.o(284691);
      return 0L;
    }
    p.j(paramq, "directory.listFiles() ?: return 0L");
    int j = paramq.length;
    int i = 0;
    long l2 = 0L;
    if (i < j)
    {
      Object localObject = paramq[i];
      p.j(localObject, "file");
      long l1;
      if (localObject.ifH()) {
        if (paramn != null)
        {
          String str = localObject.bOF();
          p.j(str, "file.absolutePath");
          if (!paramn.acS(str)) {}
        }
        else
        {
          l1 = localObject.length();
        }
      }
      for (;;)
      {
        l2 += l1;
        i += 1;
        break;
        l1 = 0L;
        continue;
        l1 = a(localObject, paramn);
      }
    }
    AppMethodBeat.o(284691);
    return l2;
  }
  
  private static String a(String paramString, com.tencent.mm.plugin.appbrand.appstorage.n paramn)
  {
    AppMethodBeat.i(284678);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramn != null)
    {
      paramString = paramn.key();
      if (paramString != null) {
        break label56;
      }
    }
    label56:
    for (paramString = "";; paramString = "#" + paramn.key())
    {
      paramString = paramString;
      AppMethodBeat.o(284678);
      return paramString;
      paramString = null;
      break;
    }
  }
  
  private final String ahB(String paramString)
  {
    AppMethodBeat.i(284690);
    Object localObject2 = ((Iterable)this.oSR.keySet()).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (kotlin.n.n.M(paramString, (String)localObject1, false))
      {
        localObject2 = (String)localObject1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!dG((String)localObject1, paramString)) {
          break label130;
        }
      }
    }
    for (;;)
    {
      if (this.aGM) {
        Log.i(this.TAG, "[findMatchMonitorDir] dirPath:" + (String)localObject1 + "  filePath:" + paramString + ' ');
      }
      AppMethodBeat.o(284690);
      return localObject1;
      localObject1 = null;
      break;
      label130:
      localObject1 = "";
    }
  }
  
  private final boolean dG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284679);
    if (!this.oSR.containsKey(paramString1))
    {
      AppMethodBeat.o(284679);
      return false;
    }
    List localList = (List)this.oSR.get(paramString1);
    if (localList != null) {}
    for (int i = localList.size(); i == 0; i = 0)
    {
      AppMethodBeat.o(284679);
      return true;
    }
    paramString1 = (List)this.oSR.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext()) {
        if (((com.tencent.mm.plugin.appbrand.appstorage.n)paramString1.next()).acS(paramString2))
        {
          AppMethodBeat.o(284679);
          return true;
        }
      }
    }
    AppMethodBeat.o(284679);
    return false;
  }
  
  private final com.tencent.mm.plugin.appbrand.appstorage.n dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284680);
    paramString1 = (List)this.oSR.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext())
      {
        com.tencent.mm.plugin.appbrand.appstorage.n localn = (com.tencent.mm.plugin.appbrand.appstorage.n)paramString1.next();
        if (localn.acS(paramString2))
        {
          AppMethodBeat.o(284680);
          return localn;
        }
      }
    }
    AppMethodBeat.o(284680);
    return null;
  }
  
  private final long dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284682);
    String str = a(paramString1, dH(paramString1, paramString2));
    Long localLong = (Long)this.oSQ.get(str);
    if (localLong != null) {}
    for (long l1 = localLong.longValue();; l1 = -1L)
    {
      long l2 = l1;
      if (l1 == -9223372036854775808L)
      {
        l1 = System.currentTimeMillis();
        l2 = a(new q(paramString1), dH(paramString1, paramString2));
        this.oSQ.put(str, Long.valueOf(l2));
        long l3 = System.currentTimeMillis();
        Log.i(this.TAG, "[getSpaceSize] invalid storage space, get size recursively.  size[" + l2 + "]  cost[" + (l3 - l1) + ']');
      }
      AppMethodBeat.o(284682);
      return l2;
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(284686);
    p.k(paramString1, "monitorDirPath");
    p.k(paramString2, "filePath");
    p.k(paramString3, "op");
    if (paramLong == 0L)
    {
      AppMethodBeat.o(284686);
      return;
    }
    long l1 = System.currentTimeMillis();
    synchronized (this.LOCK)
    {
      if (((CharSequence)paramString1).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          boolean bool = dG(paramString1, paramString2);
          if (bool) {
            break;
          }
        }
        AppMethodBeat.o(284686);
        return;
      }
      String str = a(paramString1, dH(paramString1, paramString2));
      long l2 = dI(paramString1, paramString2) + paramLong;
      com.tencent.mm.plugin.appbrand.appstorage.n localn = dH(paramString1, paramString2);
      Object localObject2 = a(paramString1, localn);
      Long localLong = (Long)this.oSQ.get(localObject2);
      if (localLong == null) {}
      long l3;
      for (;;)
      {
        this.oSQ.put(localObject2, Long.valueOf(l2));
        if (localn != null)
        {
          localObject2 = AppBrandStorageQuotaManager.nMv;
          AppBrandStorageQuotaManager.i(this.appid, localn.key(), l2);
        }
        do
        {
          if (this.aGM)
          {
            l2 = a(new q(paramString1), dH(paramString1, paramString2));
            l3 = dI(paramString1, paramString2);
            if (l3 != l2) {
              break;
            }
            Log.i(this.TAG, "[handleFileChanged] \nkey:" + str + " \nsizeDiff:" + paramLong + "  newDirSize:" + l3 + "  dirSizeByRecursively:" + l2 + " checkOk:TRUE \ndirPath:" + paramString1 + "  \nfilePath:" + paramString2 + " \nop:" + paramString3);
          }
          paramString1 = x.aazN;
          paramLong = System.currentTimeMillis();
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
            Log.i(this.TAG, "handleFileSizeChangeEvent cost[" + (paramLong - l1) + "] filePath[" + paramString2 + ']');
          }
          AppMethodBeat.o(284686);
          return;
        } while (localLong.longValue() == l2);
      }
      Log.w(this.TAG, "[handleFileChanged] \nkey:" + str + " \nsizeDiff:" + paramLong + "  newDirSize:" + l3 + "  dirSizeByRecursively:" + l2 + " checkOk:FALSE \ndirPath:" + paramString1 + "  \nfilePath:" + paramString2 + " \nop:" + paramString3);
    }
  }
  
  public final boolean a(String paramString, com.tencent.mm.plugin.appbrand.appstorage.n paramn, long paramLong)
  {
    AppMethodBeat.i(284677);
    p.k(paramString, "dirPath");
    p.k(paramn, "filePattern");
    synchronized (this.LOCK)
    {
      String str = a(paramString, paramn);
      boolean bool = this.oSQ.containsKey(str);
      if (bool)
      {
        AppMethodBeat.o(284677);
        return false;
      }
      this.oSQ.put(str, Long.valueOf(paramLong));
      if ((List)this.oSR.get(paramString) == null)
      {
        this.oSR.put(paramString, (List)new ArrayList());
        x localx = x.aazN;
      }
      paramString = (List)this.oSR.get(paramString);
      if (paramString != null) {
        paramString.add(paramn);
      }
      Log.i(this.TAG, "register id=" + str + " currentSize=" + paramLong);
      AppMethodBeat.o(284677);
      return true;
    }
  }
  
  public final long cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284683);
    p.k(paramString1, "dirPath");
    p.k(paramString2, "filePath");
    synchronized (this.LOCK)
    {
      boolean bool = dG(paramString1, paramString2);
      if (!bool)
      {
        AppMethodBeat.o(284683);
        return -1L;
      }
      long l = dI(paramString1, paramString2);
      AppMethodBeat.o(284683);
      return l;
    }
  }
  
  public final void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(284688);
    p.k(paramString1, "filePath");
    p.k(paramString2, "op");
    a(ahB(paramString1), paramString1, paramLong, paramString2);
    AppMethodBeat.o(284688);
  }
  
  public final void e(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(284689);
    p.k(paramString1, "dirPath");
    p.k(paramString2, "op");
    a(ahB(paramString1), paramString1, paramLong, paramString2);
    AppMethodBeat.o(284689);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService$Companion;", "", "()V", "ENABLE_APPBRAND_FILE_SIZE_STATISTICS_DEBUG", "", "INVALID_STORAGE_SPACE", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService$registerForNoneFlatten$1", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "accept", "", "path", "", "key", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.plugin.appbrand.appstorage.n
  {
    public final boolean acS(String paramString)
    {
      AppMethodBeat.i(267932);
      p.k(paramString, "path");
      AppMethodBeat.o(267932);
      return true;
    }
    
    public final String key()
    {
      return "normal_none_flatten";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bm
 * JD-Core Version:    0.7.0.1
 */