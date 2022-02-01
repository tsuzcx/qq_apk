package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import com.google.android.exoplayer2.h.a.a.b;
import com.google.android.exoplayer2.h.a.d;
import com.google.android.exoplayer2.h.a.d.a;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.f;
import com.google.android.exoplayer2.h.a.h;
import com.google.android.exoplayer2.h.a.h.a;
import com.google.android.exoplayer2.h.a.k;
import com.google.android.exoplayer2.h.a.l;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.IOException;

public class c
  implements com.tencent.mm.kernel.c.b, g
{
  private static c mwM;
  private com.google.android.exoplayer2.h.a.a bFT;
  e mwL;
  
  private c()
  {
    AppMethodBeat.i(234627);
    String str3 = MMApplicationContext.getProcessName();
    String str2 = "main";
    String str1 = str2;
    if (!Util.isNullOrNil(str3))
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
    str3 = com.tencent.mm.loader.j.b.aKJ();
    str2 = str3;
    if (!str3.endsWith("/")) {
      str2 = str3 + "/";
    }
    str2 = str2 + "wxavideocache/";
    try
    {
      s.dy(str2, true);
      str3 = com.tencent.mm.loader.j.b.aKJ();
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
          if (s.boN(str1)) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
          if (new o(str1).isDirectory()) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          s.deleteFile(str1);
          if (s.boN(str1)) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
          AppMethodBeat.o(234627);
          return;
        }
        catch (Throwable localThrowable1)
        {
          Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable1 });
          AppMethodBeat.o(234627);
          return;
        }
        localThrowable2 = localThrowable2;
        Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", new Object[] { localThrowable2 });
      }
    }
    Object localObject1 = new o(localThrowable1);
    Object localObject2 = new k(536870912L);
    this.bFT = new l(new File(s.k(aa.z(((o)localObject1).her()), true)), (f)localObject2);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { aa.z(((o)localObject1).her()) });
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.dY(MMApplicationContext.getContext());
    localObject2 = new com.google.android.exoplayer2.h.a.c(this.bFT, 10485760L);
    this.mwL = new e(this.bFT, (g.a)localObject1, new r(), (f.a)localObject2, 2, new d.a()
    {
      public final void k(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(234619);
        Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onCachedBytesRead, cacheSpace:%s, totalCachedBytesRead:%s", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        AppMethodBeat.o(234619);
      }
    });
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.bFT });
    AppMethodBeat.o(234627);
  }
  
  public static c bJr()
  {
    AppMethodBeat.i(234626);
    if (mwM == null) {}
    try
    {
      if (mwM == null) {
        mwM = new c();
      }
      c localc = mwM;
      AppMethodBeat.o(234626);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(234626);
    }
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(234624);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(234624);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(234625);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(234625);
  }
  
  public final g.a bJs()
  {
    return this.mwL;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234629);
    if (this.bFT == null)
    {
      Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      AppMethodBeat.o(234629);
      return 0L;
    }
    Uri.parse(paramString);
    String str = j.bJE().aaV(paramString);
    long l = this.bFT.f(str, paramLong1, paramLong2);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(234629);
    return l;
  }
  
  public final String getProxyUrl(String paramString)
  {
    return paramString;
  }
  
  public final void o(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234628);
    if (this.bFT == null)
    {
      Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, cache is null");
      AppMethodBeat.o(234628);
      return;
    }
    m.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234623);
        Object localObject2 = Uri.parse(paramString);
        Object localObject3 = j.bJE().aaV(paramString);
        localObject2 = new com.google.android.exoplayer2.h.j((Uri)localObject2, paramLong1, this.mwP, (String)localObject3);
        h.a locala = new h.a();
        c.a(c.this).a((String)localObject3, new a.b()
        {
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(234620);
            Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanAdded, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.bGq), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(234620);
          }
          
          public final void a(com.google.android.exoplayer2.h.a.a paramAnonymous2a, com.google.android.exoplayer2.h.a.g paramAnonymous2g1, com.google.android.exoplayer2.h.a.g paramAnonymous2g2)
          {
            AppMethodBeat.i(234622);
            Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanTouched, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g1.bGq), Long.valueOf(paramAnonymous2g1.position), Long.valueOf(paramAnonymous2g1.length) });
            AppMethodBeat.o(234622);
          }
          
          public final void c(com.google.android.exoplayer2.h.a.g paramAnonymous2g)
          {
            AppMethodBeat.i(234621);
            Log.d("MicroMsg.SameLayer.ExoVideoCacheHandler", "onSpanRemoved, cacheSpan isCached:%s [%s, %s]", new Object[] { Boolean.valueOf(paramAnonymous2g.bGq), Long.valueOf(paramAnonymous2g.position), Long.valueOf(paramAnonymous2g.length) });
            AppMethodBeat.o(234621);
          }
        });
        long l3;
        long l1;
        long l2;
        for (;;)
        {
          try
          {
            Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.mwP), paramString });
            localObject3 = c.a(c.this);
            d locald = c.b(c.this).wR();
            byte[] arrayOfByte = new byte[131072];
            com.google.android.exoplayer2.i.a.checkNotNull(locald);
            com.google.android.exoplayer2.i.a.checkNotNull(arrayOfByte);
            String str = h.c((com.google.android.exoplayer2.h.j)localObject2);
            l3 = ((com.google.android.exoplayer2.h.j)localObject2).bEP;
            if (((com.google.android.exoplayer2.h.j)localObject2).length != -1L)
            {
              l1 = ((com.google.android.exoplayer2.h.j)localObject2).length;
              locala.contentLength = l1;
              locala.bGs = 0L;
              locala.bGt = 0L;
              break label457;
              Object localObject1;
              l2 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, localObject1);
              if (l2 <= 0L) {
                break label508;
              }
              locala.bGs += l2;
              break;
            }
            else
            {
              l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).bp(str);
              continue;
              label256:
              str = h.c((com.google.android.exoplayer2.h.j)localObject2);
              l3 = ((com.google.android.exoplayer2.h.j)localObject2).bEP;
              if (((com.google.android.exoplayer2.h.j)localObject2).length != -1L)
              {
                l1 = ((com.google.android.exoplayer2.h.j)localObject2).length;
                break label527;
                l4 = ((com.google.android.exoplayer2.h.a.a)localObject3).f(str, l3, l2);
                l2 = l4;
                if (l4 > 0L) {
                  break label546;
                }
                l2 = -l4;
                if (h.a((com.google.android.exoplayer2.h.j)localObject2, l3, l2, locald, arrayOfByte, locala) >= l2) {
                  break label546;
                }
              }
              else
              {
                l1 = ((com.google.android.exoplayer2.h.a.a)localObject3).bp(str);
                break label527;
                label354:
                l2 = 9223372036854775807L;
                continue;
                label361:
                l4 = l2;
                break label557;
              }
              label367:
              AppMethodBeat.o(234623);
              return;
            }
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIOException, "cache IOException", new Object[0]);
            AppMethodBeat.o(234623);
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localIllegalArgumentException, "cache IllegalArgumentException", new Object[0]);
            AppMethodBeat.o(234623);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localInterruptedException, "cache InterruptedException", new Object[0]);
            AppMethodBeat.o(234623);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SameLayer.ExoVideoCacheHandler", localException, "cache Exception", new Object[0]);
            AppMethodBeat.o(234623);
            return;
          }
          label457:
          if (l1 == 0L) {
            break label499;
          }
          if (l1 == -1L) {
            break label501;
          }
          l2 = l1;
        }
        label476:
        if (l1 == -1L) {}
        for (long l4 = 0L;; l4 = l2)
        {
          l1 -= l4;
          l3 += l2;
          break label457;
          label499:
          break label256;
          label501:
          l2 = 9223372036854775807L;
          break;
          label508:
          l4 = -l2;
          l2 = l4;
          if (l4 != 9223372036854775807L) {
            break label476;
          }
          break label256;
          for (;;)
          {
            label527:
            if (l1 == 0L) {
              break label569;
            }
            if (l1 == -1L) {
              break label354;
            }
            l2 = l1;
            break;
            label546:
            if (l1 != -1L) {
              break label361;
            }
            l4 = 0L;
            label557:
            l1 -= l4;
            l3 += l2;
          }
          label569:
          break label367;
        }
      }
    });
    AppMethodBeat.o(234628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c
 * JD-Core Version:    0.7.0.1
 */