package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ol;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandTempFileCleaner;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class h
{
  private static final long nMG;
  private static final s nMH;
  public static final a nMI;
  
  static
  {
    AppMethodBeat.i(270123);
    nMI = new a((byte)0);
    nMG = TimeUnit.DAYS.toMillis(1L);
    nMH = (s)h.b.nMJ;
    AppMethodBeat.o(270123);
  }
  
  public static final void bIC()
  {
    AppMethodBeat.i(270124);
    long l = AppBrandGlobalSystemConfig.bLe().nWU * 1048576L;
    Log.i("MicroMsg.AppBrandTempFileCleaner", "checkTotalTempFileLimitSync limit:".concat(String.valueOf(l)));
    if (l > 0L)
    {
      ol localol = new ol();
      a.a(l, localol);
      if (localol.aoA() > 0L) {
        com.tencent.mm.plugin.report.service.h.IzE.el(358, 248);
      }
    }
    AppMethodBeat.o(270124);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandTempFileCleaner$Companion;", "", "()V", "LOCK_GAP", "", "TAG", "", "TEMP_FILES_FILTER", "Lcom/tencent/mm/vfs/VFSFileFilter;", "getTEMP_FILES_FILTER", "()Lcom/tencent/mm/vfs/VFSFileFilter;", "calculateTotalAppDirTempFileSize", "checkAppDirHasLocked", "", "path", "checkAppDirTempFileLimit", "", "appId", "minTempSize", "maxTempSize", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppFileSystemTempFileLastOccupationStatStruct;", "checkTotalTempFileLimit", "maxTotalTempSize", "checkTotalTempFileLimitSync", "clearAllTempFileAsync", "lruPruneAllAppDirTempFiles", "currentSize", "targetSize", "lruPruneAppDirTempFiles", "pruneAppDirTempFiles", "dir", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    private static long G(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(271051);
      paramLong1 -= paramLong2;
      Object localObject1 = (aj)m.W(aj.class);
      if (localObject1 != null) {}
      Object localObject2;
      Object localObject3;
      for (localObject1 = ((aj)localObject1).bGW();; localObject1 = null)
      {
        if (localObject1 == null) {
          p.iCn();
        }
        localObject2 = new q(av.bSa()).ifJ();
        if (localObject2 == null) {
          break;
        }
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          p.j(localObject3, "appDir");
          if (!((LinkedList)localObject1).contains(((q)localObject3).getName())) {
            ((LinkedList)localObject1).addFirst(((q)localObject3).getName());
          }
          i += 1;
        }
      }
      localObject1 = ((LinkedList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = AppBrandStorageQuotaManager.nMv;
        p.j(localObject2, "appId");
        long l = AppBrandStorageQuotaManager.cL((String)localObject2, "temp");
        if (l > 0L)
        {
          localObject3 = h.nMI;
          d(new q(av.bSa() + (String)localObject2 + '/'), (String)localObject2);
          paramLong1 -= l;
          label231:
          if (paramLong1 > 0L) {}
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", "allAppDir lru clean done, nowSize:" + (paramLong2 + paramLong1));
        AppMethodBeat.o(271051);
        return paramLong1 + paramLong2;
        break;
        break label231;
      }
    }
    
    public static void a(long paramLong, ol paramol)
    {
      AppMethodBeat.i(271048);
      long l1 = System.currentTimeMillis();
      long l2 = bID();
      Log.i("MicroMsg.AppBrandTempFileCleaner", "checkTotalTempFileLimit current: " + l2 + " max: " + paramLong + " cost:" + (System.currentTimeMillis() - l1));
      if (paramol != null) {
        paramol.AW(a.N(l2 / 1024.0D));
      }
      if (l2 <= paramLong)
      {
        AppMethodBeat.o(271048);
        return;
      }
      if (paramol != null) {
        paramol.aoz();
      }
      G(l2, paramLong / 2L);
      Log.i("MicroMsg.AppBrandTempFileCleaner", "checkTotalTempFileLimit cost " + (System.currentTimeMillis() - l1));
      AppMethodBeat.o(271048);
    }
    
    static boolean adH(String paramString)
    {
      AppMethodBeat.i(271050);
      if (u.agG(paramString + "/dir.lock"))
      {
        if (Util.nowMilliSecond() - new q(paramString + "/dir.lock").lastModified() < h.bIA())
        {
          Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, locked", new Object[] { paramString });
          AppMethodBeat.o(271050);
          return true;
        }
        Log.e("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, lock expired", new Object[] { paramString });
      }
      Log.i("MicroMsg.AppBrandTempFileCleaner", "checkAppDirHasLocked path %s, lock free", new Object[] { paramString });
      AppMethodBeat.o(271050);
      return false;
    }
    
    private static long bID()
    {
      AppMethodBeat.i(271049);
      q[] arrayOfq = new q(av.bSa()).ifJ();
      long l1 = 0L;
      if (arrayOfq != null)
      {
        int j = arrayOfq.length;
        int i = 0;
        l1 = 0L;
        if (i < j)
        {
          Object localObject1 = arrayOfq[i];
          Object localObject2 = AppBrandStorageQuotaManager.nMv;
          p.j(localObject1, "it");
          localObject2 = ((q)localObject1).getName();
          p.j(localObject2, "it.name");
          if (AppBrandStorageQuotaManager.cK((String)localObject2, "temp"))
          {
            localObject2 = AppBrandStorageQuotaManager.nMv;
            localObject1 = ((q)localObject1).getName();
            p.j(localObject1, "it.name");
          }
          for (long l2 = AppBrandStorageQuotaManager.cL((String)localObject1, "temp");; l2 = AppBrandStorageQuotaManager.a((String)localObject2, "temp", (q)localObject1))
          {
            l1 += l2;
            i += 1;
            break;
            localObject2 = AppBrandStorageQuotaManager.nMv;
            localObject2 = ((q)localObject1).getName();
            p.j(localObject2, "it.name");
          }
        }
      }
      AppMethodBeat.o(271049);
      return l1;
    }
    
    static void d(q paramq, String paramString)
    {
      AppMethodBeat.i(271054);
      Log.i("MicroMsg.AppBrandTempFileCleaner", "pruneAppDirTempFiles " + paramq.bOF());
      String str;
      if ((paramq.ifE()) && (paramq.isDirectory()))
      {
        str = paramq.bOF();
        p.j(str, "dir.absolutePath");
        if (!adH(str)) {}
      }
      else
      {
        AppMethodBeat.o(271054);
        return;
      }
      paramq = paramq.a(h.bIB());
      if (paramq != null)
      {
        int j = paramq.length;
        int i = 0;
        while (i < j)
        {
          str = paramq[i];
          p.j(str, "it");
          u.deleteFile(str.bOF());
          i += 1;
        }
      }
      if (paramString != null)
      {
        paramq = AppBrandStorageQuotaManager.nMv;
        AppBrandStorageQuotaManager.a(paramString, "temp", 0L, true);
        AppMethodBeat.o(271054);
        return;
      }
      AppMethodBeat.o(271054);
    }
    
    static long n(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(271056);
      Log.i("MicroMsg.AppBrandTempFileCleaner", "lruPruneAppDirAsync %s %d %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      Object localObject1 = av.bSa() + paramString + '/';
      if ((TextUtils.isEmpty((CharSequence)paramString)) || (paramLong1 <= paramLong2) || (adH((String)localObject1)))
      {
        AppMethodBeat.o(271056);
        return -1L;
      }
      localObject1 = new q((String)localObject1);
      if ((!((q)localObject1).ifE()) || (!((q)localObject1).isDirectory()))
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", "appDir not exist");
        AppMethodBeat.o(271056);
        return -1L;
      }
      localObject1 = ((q)localObject1).a(h.bIB());
      if (localObject1 != null) {
        if (localObject1.length != 0) {
          break label189;
        }
      }
      label189:
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.AppBrandTempFileCleaner", "no temp file");
        AppMethodBeat.o(271056);
        return -1L;
      }
      Arrays.sort((Object[])localObject1, (Comparator)h.a.b.nML);
      int j = localObject1.length;
      paramLong1 -= paramLong2;
      i = 0;
      long l2;
      for (;;)
      {
        l2 = paramLong1;
        if (i >= j) {
          break;
        }
        Object localObject2 = localObject1[i];
        p.j(localObject2, "file");
        long l1 = paramLong1;
        if (u.deleteFile(localObject2.bOF())) {
          l1 = paramLong1 - localObject2.length();
        }
        l2 = l1;
        if (l1 <= 0L) {
          break;
        }
        i += 1;
        paramLong1 = l1;
      }
      Log.i("MicroMsg.AppBrandTempFileCleaner", "%s lru clean done, current: %d", new Object[] { paramString, Long.valueOf(paramLong2 + l2) });
      AppMethodBeat.o(271056);
      return l2 + paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h
 * JD-Core Version:    0.7.0.1
 */