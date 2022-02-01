package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.PkgReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d tDh;
  
  static
  {
    AppMethodBeat.i(50968);
    tDh = new d();
    AppMethodBeat.o(50968);
  }
  
  private static final boolean G(u paramu)
  {
    AppMethodBeat.i(325219);
    s.u(paramu, "f");
    if ((paramu.jKS()) && (paramu.jKV()))
    {
      AppMethodBeat.o(325219);
      return true;
    }
    AppMethodBeat.o(325219);
    return false;
  }
  
  /* Error */
  private static final boolean a(c paramc, String paramString)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: checkcast 82	java/lang/CharSequence
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +13 -> 26
    //   16: aload 4
    //   18: invokeinterface 86 1 0
    //   23: ifne +16 -> 39
    //   26: iconst_1
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +15 -> 44
    //   32: ldc 80
    //   34: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_0
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -13 -> 28
    //   44: aload_0
    //   45: getfield 91	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   48: ldc 93
    //   50: iconst_1
    //   51: anewarray 95	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: iconst_2
    //   59: invokeinterface 101 4 0
    //   64: checkcast 103	java/io/Closeable
    //   67: astore_0
    //   68: aload_0
    //   69: checkcast 105	android/database/Cursor
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +38 -> 112
    //   77: aload_1
    //   78: invokeinterface 108 1 0
    //   83: ifeq +29 -> 112
    //   86: aload_1
    //   87: iconst_0
    //   88: invokeinterface 112 2 0
    //   93: istore_2
    //   94: iload_2
    //   95: ifle +17 -> 112
    //   98: iconst_1
    //   99: istore_3
    //   100: aload_0
    //   101: aconst_null
    //   102: invokestatic 117	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   105: ldc 80
    //   107: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iload_3
    //   111: ireturn
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -14 -> 100
    //   117: astore_1
    //   118: ldc 80
    //   120: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_1
    //   124: athrow
    //   125: astore 4
    //   127: aload_0
    //   128: aload_1
    //   129: invokestatic 117	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   132: ldc 80
    //   134: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 4
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramc	c
    //   0	140	1	paramString	String
    //   27	68	2	i	int
    //   99	15	3	bool	boolean
    //   9	8	4	localCharSequence	CharSequence
    //   125	13	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	73	117	finally
    //   77	94	117	finally
    //   118	125	125	finally
  }
  
  public static final void cGw()
  {
    AppMethodBeat.i(50966);
    u localu1 = new u(g.cGy());
    if ((!localu1.jKS()) || (!localu1.isDirectory()))
    {
      localu1.diJ();
      AppMethodBeat.o(50966);
      return;
    }
    Log.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "evictExpiredCache enter");
    c localc = (c)n.ag(c.class);
    Object localObject2;
    Object localObject4;
    if (localc != null)
    {
      localObject2 = new LinkedList();
      localObject4 = kB(true);
      if (localObject4 != null) {
        ((LinkedList)localObject2).add(localObject4);
      }
      localObject4 = kB(false);
      if (localObject4 != null) {
        ((LinkedList)localObject2).add(localObject4);
      }
      if (!((LinkedList)localObject2).isEmpty())
      {
        localObject4 = p.a((Iterable)localObject2, (CharSequence)" and ", null, null, 0, null, (kotlin.g.a.b)d.b.tDk, 30);
        localObject2 = (String[])((LinkedList)localObject2).toArray(new String[0]);
        localc.qGR.delete("WxaAppWebRenderingCacheAccessStatsTable", (String)localObject4, (String[])localObject2);
      }
      localObject4 = new LinkedList();
      localObject2 = (Closeable)localc.qGR.rawQuery("select distinct appId from WxaAppWebRenderingCacheAccessStatsTable", null, 2);
      for (;;)
      {
        try
        {
          localObject5 = (Cursor)localObject2;
          if ((localObject5 != null) && (((Cursor)localObject5).moveToFirst()))
          {
            ((LinkedList)localObject4).add(((Cursor)localObject5).getString(0));
            if (((Cursor)localObject5).moveToNext()) {
              continue;
            }
          }
          localObject5 = kotlin.ah.aiuX;
          kotlin.f.b.a((Closeable)localObject2, null);
          localObject2 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject4 = (String)((Iterator)localObject2).next();
          localObject5 = i.tWq;
          if (com.tencent.luggage.sdk.processes.d.a((com.tencent.luggage.sdk.processes.d)i.a.cJV(), (String)localObject4)) {
            continue;
          }
          localObject5 = n.cfc();
          if (localObject5 != null) {
            continue;
          }
          i = -1;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(50966);
            throw localThrowable1;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject2, localThrowable1);
            AppMethodBeat.o(50966);
          }
          Object localObject5 = ((af)localObject5).e((String)localObject4, new String[] { "versionInfo" });
          if (localObject5 != null) {
            continue;
          }
          int i = -1;
          continue;
          localObject5 = ((WxaAttributes)localObject5).clf();
          if (localObject5 != null) {
            continue;
          }
          i = -1;
          continue;
          i = ((WxaAttributes.WxaVersionInfo)localObject5).appVersion;
          continue;
          localObject2 = localu2.a(d..ExternalSyntheticLambda0.INSTANCE);
          if (localObject2 == null) {
            continue;
          }
          int j = localObject2.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject4 = localObject2[i];
          if (a(localThrowable1, com.tencent.mm.vfs.ah.v(((u)localObject4).jKT()))) {
            continue;
          }
          ((u)localObject4).diJ();
          i += 1;
          continue;
          double d1 = t.r(localu2) / 1048576.0D;
          if (d1 <= AppBrandGlobalSystemConfig.ckD().qXn) {
            break label839;
          }
          Log.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "rootDir.folderSizeMB=" + d1 + ", will evict files");
          double d2 = AppBrandGlobalSystemConfig.ckD().qXn;
          localObject2 = new LinkedList();
          Object localObject1 = (Closeable)localThrowable1.qGR.rawQuery("select * from WxaAppWebRenderingCacheAccessStatsTable order by accessTime asc ", null, 2);
          try
          {
            localObject4 = (Cursor)localObject1;
            if ((localObject4 == null) || (!((Cursor)localObject4).moveToFirst())) {
              continue;
            }
            localObject5 = new b();
            ((b)localObject5).convertFrom((Cursor)localObject4);
            kotlin.ah localah = kotlin.ah.aiuX;
            ((LinkedList)localObject2).add(localObject5);
            if (((Cursor)localObject4).moveToNext()) {
              continue;
            }
            localObject4 = kotlin.ah.aiuX;
            kotlin.f.b.a((Closeable)localObject1, null);
            localObject1 = ((LinkedList)localObject2).iterator();
            d1 = 1024.0D * ((d1 - d2) * 1024.0D);
            if (!((Iterator)localObject1).hasNext()) {
              break label839;
            }
            localObject2 = (b)((Iterator)localObject1).next();
            localObject4 = i.tWq;
            localObject4 = (com.tencent.luggage.sdk.processes.d)i.a.cJV();
            localObject5 = ((b)localObject2).field_appId;
            s.s(localObject5, "record.field_appId");
            if (com.tencent.luggage.sdk.processes.d.a((com.tencent.luggage.sdk.processes.d)localObject4, (String)localObject5)) {
              continue;
            }
            if (d1 <= 0.0D) {
              break label839;
            }
            d1 -= y.bEl(((b)localObject2).field_cacheFilePath);
            localThrowable1.delete((IAutoDBItem)localObject2, new String[0]);
            continue;
            AppMethodBeat.o(50966);
          }
          finally
          {
            try
            {
              AppMethodBeat.o(50966);
              throw localThrowable2;
            }
            finally
            {
              kotlin.f.b.a((Closeable)localObject1, localThrowable2);
              AppMethodBeat.o(50966);
            }
          }
        }
        if (i != -1) {
          localc.qGR.delete("WxaAppWebRenderingCacheAccessStatsTable", " appId =? and appVersionId != " + i + " and appVersionId != TEST and appVersionId != DEMO", new String[] { localObject4 });
        }
      }
    }
    label839:
  }
  
  public static final void cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(50967);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50967);
      return;
    }
    Object localObject3 = (c)n.ag(c.class);
    if (localObject3 != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new ah.f();
        ((ah.f)localObject2).aqH = "  appId=? ";
        switch (paramInt)
        {
        case 1: 
          localObject1 = new LinkedList();
          localObject3 = ((c)localObject3).qGR;
          localObject2 = (kotlin.g.a.b)new d.a((ah.f)localObject2, paramString, (LinkedList)localObject1);
          long l = ((ISQLiteDatabaseEx)localObject3).beginTransaction(Thread.currentThread().getId());
          ((kotlin.g.a.b)localObject2).invoke(localObject3);
          ((ISQLiteDatabaseEx)localObject3).endTransaction(l);
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label301;
          }
          y.deleteFile((String)((Iterator)localObject1).next());
          continue;
          AppMethodBeat.o(50967);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + paramString + "] versionType[" + paramInt + "], e=" + localException);
      }
      return;
      ((ah.f)localObject2).aqH = s.X((String)((ah.f)localObject2).aqH, " and appVersionId = TEST");
      continue;
      ((ah.f)localObject2).aqH = s.X((String)((ah.f)localObject2).aqH, " and appVersionId = DEMO");
      continue;
      label301:
      AppMethodBeat.o(50967);
      return;
    }
  }
  
  private static String kB(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(325209);
    Object localObject = n.cfm();
    s.s(localObject, "getAppWxaPkgStorage()");
    int i;
    if (paramBoolean)
    {
      i = 0;
      localObject = ay.a((bm)localObject, i);
      if (localObject == null) {
        break label132;
      }
      localObject = ay.b((bh)localObject);
      if (!((WxaPkgWrappingInfo)localObject).qHQ)
      {
        CharSequence localCharSequence = (CharSequence)((WxaPkgWrappingInfo)localObject).pkgPath;
        if (localCharSequence != null)
        {
          i = j;
          if (localCharSequence.length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0) {
          break label117;
        }
      }
      localObject = AssetReader.qDV;
      s.s(localObject, "{\n            AssetReader.INSTANCE\n        }");
    }
    label117:
    for (localObject = (ICommLibReader)localObject;; localObject = (ICommLibReader)new WxaCommLibRuntimeReader.PkgReader((WxaPkgWrappingInfo)localObject))
    {
      localObject = ((ICommLibReader)localObject).cfE();
      AppMethodBeat.o(325209);
      return localObject;
      i = 999;
      break;
    }
    label132:
    if (paramBoolean)
    {
      localObject = AssetReader.qDV.cfE();
      AppMethodBeat.o(325209);
      return localObject;
    }
    AppMethodBeat.o(325209);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.d
 * JD-Core Version:    0.7.0.1
 */