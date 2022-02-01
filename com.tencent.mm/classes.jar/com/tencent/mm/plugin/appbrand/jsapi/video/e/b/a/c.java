package com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.a.a.b;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.h.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic;", "", "cache", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "cacheDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSourceFactory;", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/cache/CacheDataSourceFactory;)V", "interruptCacheDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "getInterruptCacheDataSourceFactory", "()Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "url2FutureMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/Future;", "", "url", "offset", "", "length", "CacheInfo", "luggage-commons-jsapi-video-ext_release"})
public final class c
{
  final a bpx;
  final ConcurrentHashMap<String, Future<?>> pBK;
  final g.a pBL;
  final e pBM;
  
  public c(a parama, e parame)
  {
    AppMethodBeat.i(227539);
    this.bpx = parama;
    this.pBM = parame;
    this.pBK = new ConcurrentHashMap();
    this.pBL = ((g.a)new b(this));
    AppMethodBeat.o(227539);
  }
  
  public final void o(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227535);
    p.k(paramString, "url");
    Map localMap = (Map)this.pBK;
    com.tencent.e.i.d locald = com.tencent.e.h.ZvG.be((Runnable)new a(this, paramString, paramLong1, paramLong2));
    p.j(locald, "ThreadPool.INSTANCE.exec…\"\n            }\n        )");
    localMap.put(paramString, locald);
    AppMethodBeat.o(227535);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$cache$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-commons-jsapi-video-ext_release"})
  public static final class a
    implements com.tencent.e.i.h
  {
    a(String paramString, long paramLong1, long paramLong2) {}
    
    public final String getKey()
    {
      return "AppBrandVideoCache#Exo";
    }
    
    public final void run()
    {
      AppMethodBeat.i(228101);
      Object localObject = Uri.parse(paramString);
      String str = com.tencent.mm.plugin.appbrand.jsapi.video.i.bVn().aiO(paramString);
      localObject = new j((Uri)localObject, paramLong1, this.pBP, str);
      h.a locala = new h.a();
      this.pBN.bpx.a(str, (a.b)new a());
      try
      {
        Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, offset:%s, length:%s, url:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.pBP), paramString });
        com.google.android.exoplayer2.h.a.h.a((j)localObject, this.pBN.bpx, this.pBN.pBM.uT(), new byte[131072], locala);
        this.pBN.pBK.remove(paramString);
        AppMethodBeat.o(228101);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localIOException, "cache IOException", new Object[0]);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localIllegalArgumentException, "cache IllegalArgumentException", new Object[0]);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localInterruptedException, "cache InterruptedException", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localException, "cache Exception", new Object[0]);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$cache$1$run$1", "Lcom/google/android/exoplayer2/upstream/cache/Cache$Listener;", "onSpanAdded", "", "cache", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "cacheSpan", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "onSpanRemoved", "onSpanTouched", "cacheSpan1", "luggage-commons-jsapi-video-ext_release"})
    public static final class a
      implements a.b
    {
      public final void a(a parama, com.google.android.exoplayer2.h.a.g paramg)
      {
        AppMethodBeat.i(227706);
        p.k(parama, "cache");
        p.k(paramg, "cacheSpan");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg.bpU), Long.valueOf(paramg.position), Long.valueOf(paramg.aFL) });
        AppMethodBeat.o(227706);
      }
      
      public final void a(a parama, com.google.android.exoplayer2.h.a.g paramg1, com.google.android.exoplayer2.h.a.g paramg2)
      {
        AppMethodBeat.i(227710);
        p.k(parama, "cache");
        p.k(paramg1, "cacheSpan");
        p.k(paramg2, "cacheSpan1");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg1.bpU), Long.valueOf(paramg1.position), Long.valueOf(paramg1.aFL) });
        AppMethodBeat.o(227710);
      }
      
      public final void b(a parama, com.google.android.exoplayer2.h.a.g paramg)
      {
        AppMethodBeat.i(227707);
        p.k(parama, "cache");
        p.k(paramg, "cacheSpan");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg.bpU), Long.valueOf(paramg.position), Long.valueOf(paramg.aFL) });
        AppMethodBeat.o(227707);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$interruptCacheDataSourceFactory$1$interruptCacheDataSource$1", "createDataSource", "()Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$interruptCacheDataSourceFactory$1$interruptCacheDataSource$1;"})
  static final class b
    implements g.a
  {
    b(c paramc) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$interruptCacheDataSourceFactory$1$interruptCacheDataSource$1", "Lcom/google/android/exoplayer2/upstream/DataSource;", "close", "", "getUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "open", "", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "read", "", "p0", "", "p1", "p2", "luggage-commons-jsapi-video-ext_release"})
    public static final class a
      implements com.google.android.exoplayer2.h.g
    {
      a(com.google.android.exoplayer2.h.a.d paramd)
      {
        AppMethodBeat.i(228150);
        p.j(localObject, "cacheDataSource");
        this.pBQ = localObject;
        AppMethodBeat.o(228150);
      }
      
      public final long a(j paramj)
      {
        AppMethodBeat.i(228149);
        long l = this.pBS.a(paramj);
        if (paramj == null)
        {
          AppMethodBeat.o(228149);
          return l;
        }
        paramj = paramj.uri;
        if (paramj != null) {}
        for (paramj = paramj.toString();; paramj = null)
        {
          Log.i("MicroMsg.AppBrand.CancellableCacheLogic", "open#DataSource, url: ".concat(String.valueOf(paramj)));
          localObject = (Map)this.pBR.pBN.pBK;
          if (localObject != null) {
            break;
          }
          paramj = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
          AppMethodBeat.o(228149);
          throw paramj;
        }
        Object localObject = (Future)ag.fk(localObject).remove(paramj);
        if (localObject != null) {
          Log.i("MicroMsg.AppBrand.CancellableCacheLogic", "open#DataSource, url: " + paramj + ", cancel cache, success: " + ((Future)localObject).cancel(true));
        }
        AppMethodBeat.o(228149);
        return l;
      }
      
      public final void close()
      {
        AppMethodBeat.i(228152);
        this.pBQ.close();
        AppMethodBeat.o(228152);
      }
      
      public final Uri getUri()
      {
        AppMethodBeat.i(228154);
        Uri localUri = this.pBQ.getUri();
        AppMethodBeat.o(228154);
        return localUri;
      }
      
      public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(228156);
        paramInt1 = this.pBQ.read(paramArrayOfByte, paramInt1, paramInt2);
        AppMethodBeat.o(228156);
        return paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.c
 * JD-Core Version:    0.7.0.1
 */