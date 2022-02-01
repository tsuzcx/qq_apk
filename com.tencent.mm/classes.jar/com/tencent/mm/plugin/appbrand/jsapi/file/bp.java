package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IWxaStorageSpaceStatistics;", "appid", "", "(Ljava/lang/String;)V", "LOCK", "", "TAG", "debug", "", "mDirSizeInfo", "", "", "mFilePattern", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "", "findMatchMonitorDir", "filePath", "folderSize", "directory", "Lcom/tencent/mm/vfs/VFSFile;", "filePattern", "getDirTotalSize", "dirPath", "getFilePattern", "getSpaceSize", "handleDirSizeChangeEvent", "sizeDiff", "op", "handleFileSizeChangeEvent", "monitorDirPath", "makeMonitorTargetId", "register", "currentSize", "registerForNoneFlatten", "registerForStore", "fs", "Lcom/tencent/mm/plugin/appbrand/appstorage/FlattenFileSystem;", "reset", "setSpaceSize", "size", "wantMonitor", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bp
  implements y
{
  public static final bp.a rYj;
  final Object Mp;
  private final String TAG;
  private final String appid;
  boolean debug;
  final Map<String, Long> rYk;
  final Map<String, List<com.tencent.mm.plugin.appbrand.appstorage.s>> rYl;
  
  static
  {
    AppMethodBeat.i(329134);
    rYj = new bp.a((byte)0);
    AppMethodBeat.o(329134);
  }
  
  public bp(String paramString)
  {
    AppMethodBeat.i(329109);
    this.appid = paramString;
    this.TAG = "MicroMsg.WxaStorageSpaceStatisticsService";
    this.rYk = ((Map)new LinkedHashMap());
    this.rYl = ((Map)new LinkedHashMap());
    this.Mp = new Object();
    AppMethodBeat.o(329109);
  }
  
  private final long a(com.tencent.mm.vfs.u paramu, com.tencent.mm.plugin.appbrand.appstorage.s params)
  {
    AppMethodBeat.i(329130);
    if (paramu == null)
    {
      AppMethodBeat.o(329130);
      return -1L;
    }
    paramu = paramu.jKX();
    if (paramu == null)
    {
      AppMethodBeat.o(329130);
      return 0L;
    }
    int k = paramu.length;
    int i = 0;
    long l2 = 0L;
    if (i < k)
    {
      kotlin.ah localah = paramu[i];
      int j;
      label97:
      long l1;
      if (localah.jKV()) {
        if (params != null)
        {
          String str = com.tencent.mm.vfs.ah.v(localah.jKT());
          kotlin.g.b.s.s(str, "file.absolutePath");
          if (!params.Vq(str))
          {
            j = 1;
            if (j != 0) {
              break label134;
            }
            l1 = localah.length();
            label109:
            localah = kotlin.ah.aiuX;
          }
        }
      }
      for (;;)
      {
        l2 += l1;
        i += 1;
        break;
        j = 0;
        break label97;
        label134:
        l1 = 0L;
        break label109;
        l1 = a(localah, params);
      }
    }
    AppMethodBeat.o(329130);
    return l2;
  }
  
  private static String a(String paramString, com.tencent.mm.plugin.appbrand.appstorage.s params)
  {
    AppMethodBeat.i(329115);
    String str;
    if (params == null)
    {
      str = null;
      if (str != null) {
        break label41;
      }
    }
    label41:
    for (params = "";; params = kotlin.g.b.s.X("#", params.key()))
    {
      paramString = kotlin.g.b.s.X(paramString, params);
      AppMethodBeat.o(329115);
      return paramString;
      str = params.key();
      break;
    }
  }
  
  private final String aay(String paramString)
  {
    AppMethodBeat.i(329127);
    Object localObject2 = ((Iterable)this.rYl.keySet()).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (n.U(paramString, (String)localObject1, false))
      {
        localObject2 = (String)localObject1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!dZ((String)localObject1, paramString)) {
          break label130;
        }
      }
    }
    for (;;)
    {
      if (this.debug) {
        Log.i(this.TAG, "[findMatchMonitorDir] dirPath:" + (String)localObject1 + "  filePath:" + paramString + ' ');
      }
      AppMethodBeat.o(329127);
      return localObject1;
      localObject1 = null;
      break;
      label130:
      localObject1 = "";
    }
  }
  
  private final boolean dZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(329120);
    if (!this.rYl.containsKey(paramString1))
    {
      AppMethodBeat.o(329120);
      return false;
    }
    List localList = (List)this.rYl.get(paramString1);
    if (localList == null) {}
    for (int i = 0; i == 0; i = localList.size())
    {
      AppMethodBeat.o(329120);
      return true;
    }
    paramString1 = (List)this.rYl.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext()) {
        if (((com.tencent.mm.plugin.appbrand.appstorage.s)paramString1.next()).Vq(paramString2))
        {
          AppMethodBeat.o(329120);
          return true;
        }
      }
    }
    AppMethodBeat.o(329120);
    return false;
  }
  
  private final com.tencent.mm.plugin.appbrand.appstorage.s ea(String paramString1, String paramString2)
  {
    AppMethodBeat.i(329123);
    paramString1 = (List)this.rYl.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext())
      {
        com.tencent.mm.plugin.appbrand.appstorage.s locals = (com.tencent.mm.plugin.appbrand.appstorage.s)paramString1.next();
        if (locals.Vq(paramString2))
        {
          AppMethodBeat.o(329123);
          return locals;
        }
      }
    }
    AppMethodBeat.o(329123);
    return null;
  }
  
  private final long eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(329125);
    String str = a(paramString1, ea(paramString1, paramString2));
    Long localLong = (Long)this.rYk.get(str);
    if (localLong == null) {}
    for (long l1 = -1L;; l1 = localLong.longValue())
    {
      long l2 = l1;
      if (l1 == -9223372036854775808L)
      {
        l1 = System.currentTimeMillis();
        l2 = a(new com.tencent.mm.vfs.u(paramString1), ea(paramString1, paramString2));
        this.rYk.put(str, Long.valueOf(l2));
        long l3 = System.currentTimeMillis();
        Log.i(this.TAG, "[getSpaceSize] invalid storage space, get size recursively.  size[" + l2 + "]  cost[" + (l3 - l1) + ']');
      }
      AppMethodBeat.o(329125);
      return l2;
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(329160);
    kotlin.g.b.s.u(paramString1, "monitorDirPath");
    kotlin.g.b.s.u(paramString2, "filePath");
    kotlin.g.b.s.u(paramString3, "op");
    if (paramLong == 0L)
    {
      AppMethodBeat.o(329160);
      return;
    }
    long l1 = System.currentTimeMillis();
    synchronized (this.Mp)
    {
      if (((CharSequence)paramString1).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          boolean bool = dZ(paramString1, paramString2);
          if (bool) {
            break;
          }
        }
        AppMethodBeat.o(329160);
        return;
      }
      String str = a(paramString1, ea(paramString1, paramString2));
      long l2 = eb(paramString1, paramString2) + paramLong;
      com.tencent.mm.plugin.appbrand.appstorage.s locals = ea(paramString1, paramString2);
      Object localObject2 = a(paramString1, locals);
      Long localLong = (Long)this.rYk.get(localObject2);
      if (localLong == null) {}
      long l3;
      for (;;)
      {
        this.rYk.put(localObject2, Long.valueOf(l2));
        if (locals != null)
        {
          localObject2 = AppBrandStorageQuotaManager.qMt;
          AppBrandStorageQuotaManager.i(this.appid, locals.key(), l2);
        }
        do
        {
          if (this.debug)
          {
            l2 = a(new com.tencent.mm.vfs.u(paramString1), ea(paramString1, paramString2));
            l3 = eb(paramString1, paramString2);
            if (l3 != l2) {
              break;
            }
            Log.i(this.TAG, "[handleFileChanged] \nkey:" + str + " \nsizeDiff:" + paramLong + "  newDirSize:" + l3 + "  dirSizeByRecursively:" + l2 + " checkOk:TRUE \ndirPath:" + paramString1 + "  \nfilePath:" + paramString2 + " \nop:" + paramString3);
          }
          paramString1 = kotlin.ah.aiuX;
          paramLong = System.currentTimeMillis();
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
            Log.i(this.TAG, "handleFileSizeChangeEvent cost[" + (paramLong - l1) + "] filePath[" + paramString2 + ']');
          }
          AppMethodBeat.o(329160);
          return;
        } while (localLong.longValue() == l2);
      }
      Log.w(this.TAG, "[handleFileChanged] \nkey:" + str + " \nsizeDiff:" + paramLong + "  newDirSize:" + l3 + "  dirSizeByRecursively:" + l2 + " checkOk:FALSE \ndirPath:" + paramString1 + "  \nfilePath:" + paramString2 + " \nop:" + paramString3);
    }
  }
  
  public final boolean a(String paramString, com.tencent.mm.plugin.appbrand.appstorage.s params, long paramLong)
  {
    AppMethodBeat.i(329138);
    kotlin.g.b.s.u(paramString, "dirPath");
    kotlin.g.b.s.u(params, "filePattern");
    synchronized (this.Mp)
    {
      String str = a(paramString, params);
      boolean bool = this.rYk.containsKey(str);
      if (bool)
      {
        AppMethodBeat.o(329138);
        return false;
      }
      this.rYk.put(str, Long.valueOf(paramLong));
      if ((List)this.rYl.get(paramString) == null) {
        this.rYl.put(paramString, (List)new ArrayList());
      }
      paramString = (List)this.rYl.get(paramString);
      if (paramString != null) {
        paramString.add(params);
      }
      Log.i(this.TAG, "register id=" + str + " currentSize=" + paramLong);
      AppMethodBeat.o(329138);
      return true;
    }
  }
  
  public final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(329164);
    kotlin.g.b.s.u(paramString1, "filePath");
    kotlin.g.b.s.u(paramString2, "op");
    a(aay(paramString1), paramString1, paramLong, paramString2);
    AppMethodBeat.o(329164);
  }
  
  public final void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(329167);
    kotlin.g.b.s.u(paramString1, "dirPath");
    kotlin.g.b.s.u(paramString2, "op");
    a(aay(paramString1), paramString1, paramLong, paramString2);
    AppMethodBeat.o(329167);
  }
  
  public final long df(String paramString1, String paramString2)
  {
    AppMethodBeat.i(329144);
    kotlin.g.b.s.u(paramString1, "dirPath");
    kotlin.g.b.s.u(paramString2, "filePath");
    synchronized (this.Mp)
    {
      boolean bool = dZ(paramString1, paramString2);
      if (!bool)
      {
        AppMethodBeat.o(329144);
        return -1L;
      }
      long l = eb(paramString1, paramString2);
      AppMethodBeat.o(329144);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/WxaStorageSpaceStatisticsService$registerForStore$1", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "accept", "", "path", "", "key", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.appbrand.appstorage.s
  {
    c(com.tencent.mm.plugin.appbrand.appstorage.u paramu) {}
    
    public final boolean Vq(String paramString)
    {
      AppMethodBeat.i(328943);
      kotlin.g.b.s.u(paramString, "path");
      boolean bool = this.rYm.qNd.c(new com.tencent.mm.vfs.u(paramString), false);
      AppMethodBeat.o(328943);
      return bool;
    }
    
    public final String key()
    {
      return "saved_temp";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bp
 * JD-Core Version:    0.7.0.1
 */