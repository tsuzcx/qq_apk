package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.a.b;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.a.h;
import com.google.android.exoplayer2.h.a.h.a;
import com.google.android.exoplayer2.h.a.k;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.IOException;

public class c
  implements com.tencent.mm.kernel.c.b, g
{
  private static c knK;
  private com.google.android.exoplayer2.h.a.a bxF;
  com.google.android.exoplayer2.h.a.e knJ;
  
  private c()
  {
    AppMethodBeat.i(193774);
    String str3 = aj.getProcessName();
    String str2 = "main";
    String str1 = str2;
    if (!bt.isNullOrNil(str3))
    {
      int i = str3.indexOf(":");
      str1 = str2;
      if (i >= 0)
      {
        str1 = str2;
        if (str3.length() >= i + 1) {
          str1 = str3.substring(i + 1);
        }
      }
    }
    str3 = com.tencent.mm.loader.j.b.aih();
    str2 = str3;
    if (!str3.endsWith("/")) {
      str2 = str3 + "/";
    }
    str2 = str2 + "wxavideocache/";
    try
    {
      i.cO(str2, true);
      str3 = com.tencent.mm.loader.j.b.aih();
      str2 = str3;
      if (!str3.endsWith("/")) {
        str2 = str3 + "/";
      }
      str1 = str2 + "videocache/" + str1 + "/";
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          if (i.aMF(str1)) {
            break;
          }
          ad.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
          if (new com.tencent.mm.vfs.e(str1).isDirectory()) {
            break;
          }
          ad.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          i.deleteFile(str1);
          if (i.aMF(str1)) {
            break;
          }
          ad.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
          AppMethodBeat.o(193774);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable1 });
          AppMethodBeat.o(193774);
          return;
        }
        localThrowable2 = localThrowable2;
        ad.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", new Object[] { localThrowable2 });
      }
    }
    Object localObject1 = new com.tencent.mm.vfs.e(localThrowable1);
    Object localObject2 = new k();
    this.bxF = new com.google.android.exoplayer2.h.a.l(new File(i.k(q.B(((com.tencent.mm.vfs.e)localObject1).fhU()), true)), (f)localObject2);
    ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { q.B(((com.tencent.mm.vfs.e)localObject1).fhU()) });
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.a.d.ds(aj.getContext());
    localObject2 = new com.google.android.exoplayer2.h.a.c(this.bxF);
    this.knJ = new com.google.android.exoplayer2.h.a.e(this.bxF, (g.a)localObject1, new r(), (f.a)localObject2, new c.1(this));
    ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.bxF });
    AppMethodBeat.o(193774);
  }
  
  public static c bcw()
  {
    AppMethodBeat.i(193773);
    if (knK == null) {}
    try
    {
      if (knK == null) {
        knK = new c();
      }
      c localc = knK;
      AppMethodBeat.o(193773);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(193773);
    }
  }
  
  public final void agv()
  {
    AppMethodBeat.i(193771);
    ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(193771);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(193772);
    ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(193772);
  }
  
  public final g.a bcx()
  {
    return this.knJ;
  }
  
  public final long g(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193776);
    if (this.bxF == null)
    {
      ad.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      AppMethodBeat.o(193776);
      return 0L;
    }
    String str = Uri.parse(paramString).toString();
    long l = this.bxF.g(str, paramLong1, paramLong2);
    ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(193776);
    return l;
  }
  
  public final String getProxyUrl(String paramString)
  {
    return paramString;
  }
  
  public final void r(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193775);
    if (this.bxF == null)
    {
      ad.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, cache is null");
      AppMethodBeat.o(193775);
      return;
    }
    com.tencent.mm.plugin.appbrand.aa.l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193770);
        Object localObject2 = Uri.parse(paramString);
        Object localObject3 = ((Uri)localObject2).toString();
        localObject2 = new j((Uri)localObject2, paramLong1, this.knN, (String)localObject3);
        h.a locala = new h.a();
        c.a(c.this).a((String)localObject3, new a.b()
        {
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(193767);
            ad.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.byc), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(193767);
          }
          
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g1, com.google.android.exoplayer2.h.a.g paramAnonymous2g2)
          {
            AppMethodBeat.i(193769);
            ad.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g1.byc), Long.valueOf(paramAnonymous2g1.position), Long.valueOf(paramAnonymous2g1.length) });
            AppMethodBeat.o(193769);
          }
          
          public final void c(com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(193768);
            ad.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.byc), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(193768);
          }
        });
        long l3;
        long l1;
        long l2;
        for (;;)
        {
          try
          {
            ad.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.knN), paramString });
            localObject3 = c.a(c.this);
            com.google.android.exoplayer2.h.a.d locald = c.b(c.this).vv();
            byte[] arrayOfByte = new byte[131072];
            com.google.android.exoplayer2.i.a.checkNotNull(locald);
            com.google.android.exoplayer2.i.a.checkNotNull(arrayOfByte);
            String str = h.c((j)localObject2);
            l3 = ((j)localObject2).bwz;
            if (((j)localObject2).length != -1L)
            {
              l1 = ((j)localObject2).length;
              locala.aLn = l1;
              locala.bye = 0L;
              locala.byf = 0L;
              break label452;
              Object localObject1;
              l2 = ((com.google.android.exoplayer2.h.a.a)localObject3).g(str, l3, localObject1);
              if (l2 <= 0L) {
                break label503;
              }
              locala.bye += l2;
              break;
            }
            else
            {
              l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).aB(str);
              continue;
              label251:
              str = h.c((j)localObject2);
              l3 = ((j)localObject2).bwz;
              if (((j)localObject2).length != -1L)
              {
                l1 = ((j)localObject2).length;
                break label522;
                l4 = ((com.google.android.exoplayer2.h.a.a)localObject3).g(str, l3, l2);
                l2 = l4;
                if (l4 > 0L) {
                  break label541;
                }
                l2 = -l4;
                if (h.a((j)localObject2, l3, l2, locald, arrayOfByte, locala) >= l2) {
                  break label541;
                }
              }
              else
              {
                l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).aB(str);
                break label522;
                label349:
                l2 = 9223372036854775807L;
                continue;
                label356:
                l4 = l2;
                break label552;
              }
              label362:
              AppMethodBeat.o(193770);
              return;
            }
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIOException, "cache IOException", new Object[0]);
            AppMethodBeat.o(193770);
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            ad.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIllegalArgumentException, "cache IllegalArgumentException", new Object[0]);
            AppMethodBeat.o(193770);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ad.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localInterruptedException, "cache InterruptedException", new Object[0]);
            AppMethodBeat.o(193770);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localException, "cache Exception", new Object[0]);
            AppMethodBeat.o(193770);
            return;
          }
          label452:
          if (l1 == 0L) {
            break label494;
          }
          if (l1 == -1L) {
            break label496;
          }
          l2 = l1;
        }
        label471:
        if (l1 == -1L) {}
        for (long l4 = 0L;; l4 = l2)
        {
          l1 -= l4;
          l3 += l2;
          break label452;
          label494:
          break label251;
          label496:
          l2 = 9223372036854775807L;
          break;
          label503:
          l4 = -l2;
          l2 = l4;
          if (l4 != 9223372036854775807L) {
            break label471;
          }
          break label251;
          for (;;)
          {
            label522:
            if (l1 == 0L) {
              break label564;
            }
            if (l1 == -1L) {
              break label349;
            }
            l2 = l1;
            break;
            label541:
            if (l1 != -1L) {
              break label356;
            }
            l4 = 0L;
            label552:
            l1 -= l4;
            l3 += l2;
          }
          label564:
          break label362;
        }
      }
    });
    AppMethodBeat.o(193775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c
 * JD-Core Version:    0.7.0.1
 */