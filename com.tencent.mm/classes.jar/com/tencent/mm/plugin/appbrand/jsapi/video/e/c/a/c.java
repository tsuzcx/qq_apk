package com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a;

import android.net.Uri;
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
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic;", "", "cache", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "cacheDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSourceFactory;", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/cache/CacheDataSourceFactory;)V", "interruptCacheDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "getInterruptCacheDataSourceFactory", "()Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "url2FutureMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/Future;", "", "url", "offset", "", "length", "CacheInfo", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final com.google.android.exoplayer2.h.a.a dja;
  final e sGZ;
  final ConcurrentHashMap<String, Future<?>> sHa;
  final g.a sHb;
  
  public c(com.google.android.exoplayer2.h.a.a parama, e parame)
  {
    AppMethodBeat.i(328748);
    this.dja = parama;
    this.sGZ = parame;
    this.sHa = new ConcurrentHashMap();
    this.sHb = new c..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(328748);
  }
  
  private static final com.google.android.exoplayer2.h.g a(final c paramc)
  {
    AppMethodBeat.i(328757);
    s.u(paramc, "this$0");
    paramc = (com.google.android.exoplayer2.h.g)new b(paramc.sGZ.Us(), paramc);
    AppMethodBeat.o(328757);
    return paramc;
  }
  
  public final void q(String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328772);
    s.u(paramString, "url");
    Map localMap = (Map)this.sHa;
    com.tencent.threadpool.i.d locald = com.tencent.threadpool.h.ahAA.bm((Runnable)new a(paramString, paramLong1, paramLong2, this));
    s.s(locald, "fun cache(url: String, o…        }\n        )\n    }");
    localMap.put(paramString, locald);
    AppMethodBeat.o(328772);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$cache$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.threadpool.i.h
  {
    a(String paramString, long paramLong1, long paramLong2, c paramc) {}
    
    public final String getKey()
    {
      return "AppBrandVideoCache#Exo";
    }
    
    public final void run()
    {
      AppMethodBeat.i(328777);
      Object localObject2 = Uri.parse(this.mrs);
      com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD();
      Object localObject3 = com.tencent.mm.plugin.appbrand.jsapi.video.i.abO(this.mrs);
      localObject2 = new j((Uri)localObject2, paramLong1, jdField_this, (String)localObject3);
      h.a locala = new h.a();
      this.sHd.dja.a((String)localObject3, (a.b)new a());
      long l3;
      long l1;
      long l2;
      for (;;)
      {
        try
        {
          Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, offset:%s, length:%s, url:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(jdField_this), this.mrs });
          localObject3 = this.sHd.dja;
          com.google.android.exoplayer2.h.a.d locald = this.sHd.sGZ.Us();
          byte[] arrayOfByte = new byte[131072];
          com.google.android.exoplayer2.i.a.checkNotNull(locald);
          com.google.android.exoplayer2.i.a.checkNotNull(arrayOfByte);
          String str = com.google.android.exoplayer2.h.a.h.c((j)localObject2);
          l3 = ((j)localObject2).absoluteStreamPosition;
          if (((j)localObject2).length != -1L)
          {
            l1 = ((j)localObject2).length;
            locala.contentLength = l1;
            locala.djA = 0L;
            locala.djB = 0L;
            break label472;
            Object localObject1;
            l2 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, localObject1);
            if (l2 <= 0L) {
              break label523;
            }
            locala.djA += l2;
            break;
          }
          l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).cS(str);
          continue;
          label259:
          str = com.google.android.exoplayer2.h.a.h.c((j)localObject2);
          l3 = ((j)localObject2).absoluteStreamPosition;
          if (((j)localObject2).length != -1L)
          {
            l1 = ((j)localObject2).length;
            break label542;
            l4 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, l2);
            l2 = l4;
            if (l4 > 0L) {
              break label561;
            }
            l2 = -l4;
            if (com.google.android.exoplayer2.h.a.h.a((j)localObject2, l3, l2, locald, arrayOfByte, locala) < l2) {
              continue;
            }
            break label561;
          }
          l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).cS(str);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localIOException, "cache IOException", new Object[0]);
          this.sHd.sHa.remove(this.mrs);
          AppMethodBeat.o(328777);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localIllegalArgumentException, "cache IllegalArgumentException", new Object[0]);
          continue;
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localInterruptedException, "cache InterruptedException", new Object[0]);
          continue;
        }
        catch (Exception localException)
        {
          label357:
          label364:
          Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", (Throwable)localException, "cache Exception", new Object[0]);
          label388:
          continue;
        }
        l2 = 9223372036854775807L;
        continue;
        l4 = l2;
        break label572;
        label472:
        if (l1 == 0L) {
          break label514;
        }
        if (l1 == -1L) {
          break label516;
        }
        l2 = l1;
      }
      label491:
      if (l1 == -1L) {}
      for (long l4 = 0L;; l4 = l2)
      {
        l1 -= l4;
        l3 += l2;
        break label472;
        label514:
        break label259;
        label516:
        l2 = 9223372036854775807L;
        break;
        label523:
        l4 = -l2;
        l2 = l4;
        if (l4 != 9223372036854775807L) {
          break label491;
        }
        break label259;
        for (;;)
        {
          label542:
          if (l1 == 0L) {
            break label584;
          }
          if (l1 == -1L) {
            break label357;
          }
          l2 = l1;
          break;
          label561:
          if (l1 != -1L) {
            break label364;
          }
          l4 = 0L;
          label572:
          l1 -= l4;
          l3 += l2;
        }
        label584:
        break label388;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$cache$1$run$1", "Lcom/google/android/exoplayer2/upstream/cache/Cache$Listener;", "onSpanAdded", "", "cache", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "cacheSpan", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "onSpanRemoved", "onSpanTouched", "cacheSpan1", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements a.b
    {
      public final void a(com.google.android.exoplayer2.h.a.a parama, com.google.android.exoplayer2.h.a.g paramg)
      {
        AppMethodBeat.i(328766);
        s.u(parama, "cache");
        s.u(paramg, "cacheSpan");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg.djy), Long.valueOf(paramg.position), Long.valueOf(paramg.length) });
        AppMethodBeat.o(328766);
      }
      
      public final void a(com.google.android.exoplayer2.h.a.a parama, com.google.android.exoplayer2.h.a.g paramg1, com.google.android.exoplayer2.h.a.g paramg2)
      {
        AppMethodBeat.i(328784);
        s.u(parama, "cache");
        s.u(paramg1, "cacheSpan");
        s.u(paramg2, "cacheSpan1");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg1.djy), Long.valueOf(paramg1.position), Long.valueOf(paramg1.length) });
        AppMethodBeat.o(328784);
      }
      
      public final void b(com.google.android.exoplayer2.h.a.a parama, com.google.android.exoplayer2.h.a.g paramg)
      {
        AppMethodBeat.i(328775);
        s.u(parama, "cache");
        s.u(paramg, "cacheSpan");
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramg.djy), Long.valueOf(paramg.position), Long.valueOf(paramg.length) });
        AppMethodBeat.o(328775);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/CancellableCacheLogic$interruptCacheDataSourceFactory$1$interruptCacheDataSource$1", "Lcom/google/android/exoplayer2/upstream/DataSource;", "close", "", "getUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "open", "", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "read", "", "p0", "", "p1", "p2", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.google.android.exoplayer2.h.g
  {
    b(com.google.android.exoplayer2.h.a.d paramd, c paramc)
    {
      AppMethodBeat.i(328763);
      this.sHe = this.sHf;
      AppMethodBeat.o(328763);
    }
    
    public final long a(j paramj)
    {
      AppMethodBeat.i(328800);
      long l = this.sHf.a(paramj);
      if (paramj == null)
      {
        AppMethodBeat.o(328800);
        return l;
      }
      paramj = paramj.uri;
      if (paramj == null) {}
      for (paramj = null;; paramj = paramj.toString())
      {
        Log.i("MicroMsg.AppBrand.CancellableCacheLogic", s.X("open#DataSource, url: ", paramj));
        localObject = (Map)paramc.sHa;
        if (localObject != null) {
          break;
        }
        paramj = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(328800);
        throw paramj;
      }
      Object localObject = (Future)an.hJ(localObject).remove(paramj);
      if (localObject != null) {
        Log.i("MicroMsg.AppBrand.CancellableCacheLogic", "open#DataSource, url: " + paramj + ", cancel cache, success: " + ((Future)localObject).cancel(true));
      }
      AppMethodBeat.o(328800);
      return l;
    }
    
    public final void close()
    {
      AppMethodBeat.i(328769);
      this.sHe.close();
      AppMethodBeat.o(328769);
    }
    
    public final Uri getUri()
    {
      AppMethodBeat.i(328778);
      Uri localUri = this.sHe.getUri();
      AppMethodBeat.o(328778);
      return localUri;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(328787);
      paramInt1 = this.sHe.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(328787);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.c
 * JD-Core Version:    0.7.0.1
 */