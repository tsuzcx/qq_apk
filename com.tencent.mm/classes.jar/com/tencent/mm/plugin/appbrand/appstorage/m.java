package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.se;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandTempFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a qMD;
  private static final long qME;
  private static final w qMF;
  
  static
  {
    AppMethodBeat.i(323271);
    qMD = new a((byte)0);
    qME = TimeUnit.DAYS.toMillis(1L);
    qMF = m..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(323271);
  }
  
  public static final void cid()
  {
    AppMethodBeat.i(323262);
    long l = AppBrandGlobalSystemConfig.ckD().qWK * 1048576L;
    Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("checkTotalTempFileLimitSync limit:", Long.valueOf(l)));
    if (l > 0L)
    {
      se localse = new se();
      a.a(l, localse);
      if (localse.jxB > 0L) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(358, 248);
      }
    }
    AppMethodBeat.o(323262);
  }
  
  private static final boolean p(u paramu)
  {
    AppMethodBeat.i(323257);
    s.u(paramu, "pathname");
    String str = paramu.getName();
    s.s(str, "pathname.name");
    if (!kotlin.n.n.rs(str, ".data"))
    {
      str = paramu.getName();
      s.s(str, "pathname.name");
      if (!kotlin.n.n.U(str, "store_", false))
      {
        paramu = paramu.getName();
        s.s(paramu, "pathname.name");
        if (!kotlin.n.n.rs(paramu, ".nomedia"))
        {
          AppMethodBeat.o(323257);
          return true;
        }
      }
    }
    AppMethodBeat.o(323257);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandTempFileCleaner$Companion;", "", "()V", "CLEANUP_TIMEOUT_S", "", "LOCK_GAP", "", "TAG", "", "TEMP_FILES_FILTER", "Lcom/tencent/mm/vfs/VFSFileFilter;", "getTEMP_FILES_FILTER", "()Lcom/tencent/mm/vfs/VFSFileFilter;", "calculateTotalAppDirTempFileSize", "checkAppDirHasLocked", "", "path", "checkAppDirTempFileLimit", "", "appId", "minTempSize", "maxTempSize", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "checkTotalTempFileLimit", "maxTotalTempSize", "checkTotalTempFileLimitSync", "clearAllTempFileAsync", "lruPruneAllAppDirTempFiles", "currentSize", "targetSize", "lruPruneAppDirTempFiles", "pruneAppDirTempFiles", "dir", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static boolean Wi(String paramString)
    {
      AppMethodBeat.i(323226);
      if (y.ZC(s.X(paramString, "/dir.lock")))
      {
        if (Util.nowMilliSecond() - new u(s.X(paramString, "/dir.lock")).lastModified() < m.cie())
        {
          Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, locked", new Object[] { paramString });
          AppMethodBeat.o(323226);
          return true;
        }
        Log.e("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, lock expired", new Object[] { paramString });
      }
      Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, lock free", new Object[] { paramString });
      AppMethodBeat.o(323226);
      return false;
    }
    
    public static void a(long paramLong, se paramse)
    {
      AppMethodBeat.i(323216);
      long l1 = System.currentTimeMillis();
      long l2 = cih();
      Log.i("MicroMsg.AppBrandTempFileCleaner", "checkTotalTempFileLimit current: " + l2 + " max: " + paramLong + " cost:" + (System.currentTimeMillis() - l1));
      if (paramse != null) {
        paramse.jxz = kotlin.h.a.ai(l2 / 1024.0D);
      }
      if (l2 <= paramLong)
      {
        AppMethodBeat.o(323216);
        return;
      }
      if (paramse != null) {
        paramse.jxB = 1L;
      }
      ad(l2, paramLong / 2L);
      Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("checkTotalTempFileLimit cost ", Long.valueOf(System.currentTimeMillis() - l1)));
      AppMethodBeat.o(323216);
    }
    
    private static final void a(String paramString1, String paramString2, AtomicLong paramAtomicLong)
    {
      AppMethodBeat.i(323250);
      s.u(paramString1, "$path");
      s.u(paramString2, "$appId");
      s.u(paramAtomicLong, "$afterSize");
      a locala = m.qMD;
      if (Wi(paramString1))
      {
        Log.w("MicroMsg.AppBrandTempFileCleaner", s.X("lruPruneAppDirTempFiles timeout but locked ", paramString2));
        AppMethodBeat.o(323250);
        return;
      }
      if (y.ew(paramString1, true))
      {
        paramAtomicLong.compareAndSet(-1L, 0L);
        paramString1 = AppBrandStorageQuotaManager.qMt;
        AppBrandStorageQuotaManager.b(paramString2, "temp", 0L, true);
        Log.i("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirTempFiles timeout delete success");
        AppMethodBeat.o(323250);
        return;
      }
      Log.w("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirTempFiles timeout delete failed");
      AppMethodBeat.o(323250);
    }
    
    private static long ad(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(323234);
      paramLong1 -= paramLong2;
      Object localObject1 = (ak)com.tencent.mm.plugin.appbrand.app.n.ag(ak.class);
      if (localObject1 == null) {}
      Object localObject2;
      Object localObject3;
      for (localObject1 = null;; localObject1 = ((ak)localObject1).cgs())
      {
        s.checkNotNull(localObject1);
        localObject2 = new u(ax.cse()).jKX();
        if (localObject2 == null) {
          break;
        }
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          if (!((LinkedList)localObject1).contains(((u)localObject3).getName())) {
            ((LinkedList)localObject1).addFirst(((u)localObject3).getName());
          }
          i += 1;
        }
      }
      localObject1 = ((LinkedList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = AppBrandStorageQuotaManager.qMt;
        s.s(localObject2, "appId");
        long l = AppBrandStorageQuotaManager.dc((String)localObject2, "temp");
        if (l > 0L)
        {
          localObject3 = m.qMD;
          d(new u(ax.cse() + localObject2 + '/'), (String)localObject2);
          paramLong1 -= l;
          label222:
          if (paramLong1 > 0L) {}
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("allAppDir lru clean done, nowSize:", Long.valueOf(paramLong2 + paramLong1)));
        AppMethodBeat.o(323234);
        return paramLong1 + paramLong2;
        break;
        break label222;
      }
    }
    
    private static final int b(u paramu1, u paramu2)
    {
      AppMethodBeat.i(323256);
      if (paramu1.lastModified() > paramu2.lastModified())
      {
        AppMethodBeat.o(323256);
        return 1;
      }
      if (paramu1.lastModified() < paramu2.lastModified())
      {
        AppMethodBeat.o(323256);
        return -1;
      }
      AppMethodBeat.o(323256);
      return 0;
    }
    
    private static final void b(String paramString1, String paramString2, AtomicLong paramAtomicLong)
    {
      AppMethodBeat.i(323252);
      s.u(paramString1, "$appId");
      s.u(paramString2, "$path");
      s.u(paramAtomicLong, "$afterSize");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(358, 252);
      Log.w("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirTempFiles timeout! " + paramString1 + " deletePath " + paramString2);
      com.tencent.threadpool.h.ahAA.bn(new m.a..ExternalSyntheticLambda1(paramString2, paramString1, paramAtomicLong));
      AppMethodBeat.o(323252);
    }
    
    public static void cig()
    {
      AppMethodBeat.i(323211);
      com.tencent.threadpool.h.ahAA.bm((Runnable)new com.tencent.mm.plugin.appbrand.utils.a(m.a..ExternalSyntheticLambda2.INSTANCE));
      AppMethodBeat.o(323211);
    }
    
    private static long cih()
    {
      AppMethodBeat.i(323221);
      u[] arrayOfu = new u(ax.cse()).jKX();
      long l1 = 0L;
      if (arrayOfu != null)
      {
        int j = arrayOfu.length;
        int i = 0;
        l1 = 0L;
        if (i < j)
        {
          Object localObject1 = arrayOfu[i];
          Object localObject2 = AppBrandStorageQuotaManager.qMt;
          localObject2 = ((u)localObject1).getName();
          s.s(localObject2, "it.name");
          if (AppBrandStorageQuotaManager.db((String)localObject2, "temp"))
          {
            localObject2 = AppBrandStorageQuotaManager.qMt;
            localObject1 = ((u)localObject1).getName();
            s.s(localObject1, "it.name");
          }
          for (long l2 = AppBrandStorageQuotaManager.dc((String)localObject1, "temp");; l2 = AppBrandStorageQuotaManager.a((String)localObject2, "temp", (u)localObject1))
          {
            l1 += l2;
            i += 1;
            break;
            localObject2 = AppBrandStorageQuotaManager.qMt;
            localObject2 = ((u)localObject1).getName();
            s.s(localObject2, "it.name");
            s.s(localObject1, "it");
          }
        }
      }
      AppMethodBeat.o(323221);
      return l1;
    }
    
    private static final void cii()
    {
      AppMethodBeat.i(323248);
      Object localObject = new u(ax.cse());
      if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
      {
        AppMethodBeat.o(323248);
        return;
      }
      localObject = ((u)localObject).jKX();
      if (localObject != null)
      {
        if (localObject.length != 0) {
          break label71;
        }
        i = 1;
        if (i == 0) {
          break label76;
        }
      }
      label71:
      label76:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label81;
        }
        AppMethodBeat.o(323248);
        return;
        i = 0;
        break;
      }
      label81:
      localObject = kotlin.g.b.c.ao((Object[])localObject);
      u localu;
      a locala;
      while (((Iterator)localObject).hasNext())
      {
        localu = (u)((Iterator)localObject).next();
        locala = m.qMD;
        s.s(localu, "mayBeDir");
        d(localu, localu.getName());
      }
      localObject = new u(AppBrandVideoDownLoadMgr.szi);
      if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
      {
        AppMethodBeat.o(323248);
        return;
      }
      localObject = ((u)localObject).jKX();
      if (localObject != null)
      {
        if (localObject.length != 0) {
          break label192;
        }
        i = 1;
        if (i == 0) {
          break label197;
        }
      }
      label192:
      label197:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label202;
        }
        AppMethodBeat.o(323248);
        return;
        i = 0;
        break;
      }
      label202:
      localObject = kotlin.g.b.c.ao((Object[])localObject);
      while (((Iterator)localObject).hasNext())
      {
        localu = (u)((Iterator)localObject).next();
        locala = m.qMD;
        d(localu, null);
      }
      AppMethodBeat.o(323248);
    }
    
    private static void d(u paramu, String paramString)
    {
      AppMethodBeat.i(323237);
      Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("pruneAppDirTempFiles ", ah.v(paramu.jKT())));
      if ((paramu.jKS()) && (paramu.isDirectory()))
      {
        localObject = ah.v(paramu.jKT());
        s.s(localObject, "dir.absolutePath");
        if (!Wi((String)localObject)) {}
      }
      else
      {
        AppMethodBeat.o(323237);
        return;
      }
      Object localObject = paramu.a(m.cif());
      if (localObject == null) {}
      for (paramu = null;; paramu = Integer.valueOf(localObject.length))
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("pruneAppDirTempFiles listFile done:", paramu));
        if (localObject == null) {
          break;
        }
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          y.deleteFile(ah.v(localObject[i].jKT()));
          i += 1;
        }
      }
      if (paramString != null)
      {
        paramu = AppBrandStorageQuotaManager.qMt;
        AppBrandStorageQuotaManager.b(paramString, "temp", 0L, true);
      }
      AppMethodBeat.o(323237);
    }
    
    static long p(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(323243);
      Log.i("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirTempFiles %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      Object localObject1 = ax.cse() + paramString + '/';
      if ((TextUtils.isEmpty((CharSequence)paramString)) || (paramLong1 <= paramLong2) || (Wi((String)localObject1)))
      {
        AppMethodBeat.o(323243);
        return -1L;
      }
      Object localObject2 = new u((String)localObject1);
      if ((!((u)localObject2).jKS()) || (!((u)localObject2).isDirectory()))
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", "appDir not exist");
        AppMethodBeat.o(323243);
        return -1L;
      }
      AtomicLong localAtomicLong = new AtomicLong(-1L);
      MMHandler localMMHandler = new MMHandler(Looper.getMainLooper());
      localObject1 = new m.a..ExternalSyntheticLambda0(paramString, (String)localObject1, localAtomicLong);
      localMMHandler.postDelayed((Runnable)localObject1, ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTU, 180) * 1000L);
      localObject2 = ((u)localObject2).a(m.cif());
      if (localObject2 != null) {
        if (localObject2.length != 0) {
          break label260;
        }
      }
      label260:
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", "no temp file");
        AppMethodBeat.o(323243);
        return -1L;
      }
      Log.i("MicroMsg.AppBrandTempFileCleaner", s.X("lruPruneAppDirTempFiles listFiles done: ", Integer.valueOf(localObject2.length)));
      Arrays.sort((Object[])localObject2, m.a..ExternalSyntheticLambda3.INSTANCE);
      Log.i("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirTempFiles sort done");
      localObject2 = kotlin.g.b.c.ao((Object[])localObject2);
      paramLong1 -= paramLong2;
      if (((Iterator)localObject2).hasNext())
      {
        u localu = (u)((Iterator)localObject2).next();
        if (y.deleteFile(ah.v(localu.jKT())))
        {
          paramLong1 -= localu.length();
          label354:
          if (paramLong1 > 0L) {}
        }
      }
      for (;;)
      {
        localAtomicLong.compareAndSet(-1L, paramLong1 + paramLong2);
        localMMHandler.removeCallbacks((Runnable)localObject1);
        Log.i("MicroMsg.AppBrandTempFileCleaner", "%s lru clean done, current: %d", new Object[] { paramString, Long.valueOf(localAtomicLong.get()) });
        paramLong1 = localAtomicLong.get();
        AppMethodBeat.o(323243);
        return paramLong1;
        break;
        break label354;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m
 * JD-Core Version:    0.7.0.1
 */