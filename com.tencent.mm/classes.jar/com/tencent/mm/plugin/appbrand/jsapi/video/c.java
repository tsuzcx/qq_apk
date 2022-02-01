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
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.IOException;

public class c
  implements com.tencent.mm.kernel.c.b, g
{
  private static c kPe;
  private com.google.android.exoplayer2.h.a.a bvo;
  com.google.android.exoplayer2.h.a.e kPd;
  
  private c()
  {
    AppMethodBeat.i(194121);
    String str3 = ai.getProcessName();
    String str2 = "main";
    String str1 = str2;
    if (!bs.isNullOrNil(str3))
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
    str3 = com.tencent.mm.loader.j.b.aph();
    str2 = str3;
    if (!str3.endsWith("/")) {
      str2 = str3 + "/";
    }
    str2 = str2 + "wxavideocache/";
    try
    {
      i.cU(str2, true);
      str3 = com.tencent.mm.loader.j.b.aph();
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
          if (i.aSh(str1)) {
            break;
          }
          ac.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
          if (new com.tencent.mm.vfs.e(str1).isDirectory()) {
            break;
          }
          ac.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          i.deleteFile(str1);
          if (i.aSh(str1)) {
            break;
          }
          ac.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
          AppMethodBeat.o(194121);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ac.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable1 });
          AppMethodBeat.o(194121);
          return;
        }
        localThrowable2 = localThrowable2;
        ac.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", new Object[] { localThrowable2 });
      }
    }
    Object localObject1 = new com.tencent.mm.vfs.e(localThrowable1);
    Object localObject2 = new k();
    this.bvo = new com.google.android.exoplayer2.h.a.l(new File(i.k(q.B(((com.tencent.mm.vfs.e)localObject1).fxV()), true)), (f)localObject2);
    ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { q.B(((com.tencent.mm.vfs.e)localObject1).fxV()) });
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.a.d.dB(ai.getContext());
    localObject2 = new com.google.android.exoplayer2.h.a.c(this.bvo);
    this.kPd = new com.google.android.exoplayer2.h.a.e(this.bvo, (g.a)localObject1, new r(), (f.a)localObject2, new c.1(this));
    ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.bvo });
    AppMethodBeat.o(194121);
  }
  
  public static c bjr()
  {
    AppMethodBeat.i(194120);
    if (kPe == null) {}
    try
    {
      if (kPe == null) {
        kPe = new c();
      }
      c localc = kPe;
      AppMethodBeat.o(194120);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(194120);
    }
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(194118);
    ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(194118);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(194119);
    ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(194119);
  }
  
  public final g.a bjs()
  {
    return this.kPd;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194123);
    if (this.bvo == null)
    {
      ac.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      AppMethodBeat.o(194123);
      return 0L;
    }
    String str = Uri.parse(paramString).toString();
    long l = this.bvo.f(str, paramLong1, paramLong2);
    ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(194123);
    return l;
  }
  
  public final String getProxyUrl(String paramString)
  {
    return paramString;
  }
  
  public final void o(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194122);
    if (this.bvo == null)
    {
      ac.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, cache is null");
      AppMethodBeat.o(194122);
      return;
    }
    com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194117);
        Object localObject2 = Uri.parse(paramString);
        Object localObject3 = ((Uri)localObject2).toString();
        localObject2 = new j((Uri)localObject2, paramLong1, this.kPh, (String)localObject3);
        h.a locala = new h.a();
        c.a(c.this).a((String)localObject3, new a.b()
        {
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(194114);
            ac.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.bvL), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(194114);
          }
          
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g1, com.google.android.exoplayer2.h.a.g paramAnonymous2g2)
          {
            AppMethodBeat.i(194116);
            ac.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g1.bvL), Long.valueOf(paramAnonymous2g1.position), Long.valueOf(paramAnonymous2g1.length) });
            AppMethodBeat.o(194116);
          }
          
          public final void c(com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(194115);
            ac.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.bvL), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(194115);
          }
        });
        long l3;
        long l1;
        long l2;
        for (;;)
        {
          try
          {
            ac.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.kPh), paramString });
            localObject3 = c.a(c.this);
            com.google.android.exoplayer2.h.a.d locald = c.b(c.this).vm();
            byte[] arrayOfByte = new byte[131072];
            com.google.android.exoplayer2.i.a.checkNotNull(locald);
            com.google.android.exoplayer2.i.a.checkNotNull(arrayOfByte);
            String str = h.c((j)localObject2);
            l3 = ((j)localObject2).absoluteStreamPosition;
            if (((j)localObject2).length != -1L)
            {
              l1 = ((j)localObject2).length;
              locala.aMd = l1;
              locala.bvN = 0L;
              locala.bvO = 0L;
              break label452;
              Object localObject1;
              l2 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, localObject1);
              if (l2 <= 0L) {
                break label503;
              }
              locala.bvN += l2;
              break;
            }
            else
            {
              l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).aw(str);
              continue;
              label251:
              str = h.c((j)localObject2);
              l3 = ((j)localObject2).absoluteStreamPosition;
              if (((j)localObject2).length != -1L)
              {
                l1 = ((j)localObject2).length;
                break label522;
                l4 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, l2);
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
                l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).aw(str);
                break label522;
                label349:
                l2 = 9223372036854775807L;
                continue;
                label356:
                l4 = l2;
                break label552;
              }
              label362:
              AppMethodBeat.o(194117);
              return;
            }
          }
          catch (IOException localIOException)
          {
            ac.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIOException, "cache IOException", new Object[0]);
            AppMethodBeat.o(194117);
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            ac.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIllegalArgumentException, "cache IllegalArgumentException", new Object[0]);
            AppMethodBeat.o(194117);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ac.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localInterruptedException, "cache InterruptedException", new Object[0]);
            AppMethodBeat.o(194117);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localException, "cache Exception", new Object[0]);
            AppMethodBeat.o(194117);
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
    AppMethodBeat.o(194122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c
 * JD-Core Version:    0.7.0.1
 */