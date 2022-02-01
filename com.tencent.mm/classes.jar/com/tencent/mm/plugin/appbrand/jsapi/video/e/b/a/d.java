package com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;

import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.k;
import com.google.android.exoplayer2.h.a.m;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;

public class d
  implements com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.appbrand.jsapi.video.f
{
  private static d pBT;
  private a bpx;
  public e pBM;
  private c pBU;
  private boolean pBV;
  
  protected d()
  {
    AppMethodBeat.i(230528);
    this.pBU = null;
    this.pBV = false;
    String str = bWL();
    Object localObject3 = com.tencent.mm.loader.j.b.aSL();
    Object localObject1 = localObject3;
    if (!((String)localObject3).endsWith("/")) {
      localObject1 = (String)localObject3 + "/";
    }
    localObject1 = (String)localObject1 + "wxavideocache/";
    try
    {
      u.deleteDir((String)localObject1);
      localObject3 = com.tencent.mm.loader.j.b.aSL();
      localObject1 = localObject3;
      if (!((String)localObject3).endsWith("/")) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "videocache/" + str + "/";
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (u.bBD((String)localObject1)) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
          if (new q((String)localObject1).isDirectory()) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          u.deleteFile((String)localObject1);
          if (u.bBD((String)localObject1)) {
            break;
          }
          Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
          AppMethodBeat.o(230528);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable2 });
          AppMethodBeat.o(230528);
          return;
        }
        localThrowable1 = localThrowable1;
        Log.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "cleanOldVideoCacheFolder exception:%s", new Object[] { localThrowable1 });
      }
    }
    Object localObject2 = new q(localThrowable2);
    this.bpx = a(new File(u.n(((q)localObject2).bOF(), true)), new k(536870912L));
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { ((q)localObject2).bOF() });
    localObject2 = h.dW(MMApplicationContext.getContext());
    localObject3 = new com.google.android.exoplayer2.h.a.c(this.bpx, 10485760L);
    this.pBM = new e(this.bpx, (g.a)localObject2, new r(), (f.a)localObject3, 2, new d.1(this));
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.bpx });
    AppMethodBeat.o(230528);
  }
  
  public static d bWK()
  {
    AppMethodBeat.i(230525);
    if (pBT == null) {}
    try
    {
      if (pBT == null) {
        pBT = new d();
      }
      d locald = pBT;
      AppMethodBeat.o(230525);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(230525);
    }
  }
  
  private void bWM()
  {
    try
    {
      AppMethodBeat.i(230537);
      if (!this.pBV)
      {
        if ((this.bpx != null) && (this.pBM != null)) {
          this.pBU = new c(this.bpx, this.pBM);
        }
        this.pBV = true;
      }
      AppMethodBeat.o(230537);
      return;
    }
    finally {}
  }
  
  protected a a(File paramFile, com.google.android.exoplayer2.h.a.f paramf)
  {
    AppMethodBeat.i(230532);
    paramFile = new m(paramFile, paramf);
    AppMethodBeat.o(230532);
    return paramFile;
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(230518);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(230518);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(230522);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(230522);
  }
  
  public final String aQ(String paramString)
  {
    return paramString;
  }
  
  public final g.a bVl()
  {
    return this.pBM;
  }
  
  public final g.a bVm()
  {
    AppMethodBeat.i(230533);
    bWM();
    if (this.pBU != null)
    {
      localObject = this.pBU.pBL;
      AppMethodBeat.o(230533);
      return localObject;
    }
    Object localObject = this.pBM;
    AppMethodBeat.o(230533);
    return localObject;
  }
  
  protected String bWL()
  {
    AppMethodBeat.i(230530);
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
    AppMethodBeat.o(230530);
    return str1;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230536);
    if (this.bpx == null)
    {
      Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      AppMethodBeat.o(230536);
      return 0L;
    }
    String str = i.bVn().aiO(paramString);
    long l = this.bpx.f(str, paramLong1, paramLong2);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(230536);
    return l;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(230534);
    bWM();
    if (this.pBU == null)
    {
      AppMethodBeat.o(230534);
      return;
    }
    this.pBU.o(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(230534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.d
 * JD-Core Version:    0.7.0.1
 */