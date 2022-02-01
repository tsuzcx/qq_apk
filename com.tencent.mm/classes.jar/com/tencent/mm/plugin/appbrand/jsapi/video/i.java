package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public class i
  implements f
{
  private static i pvq;
  private boolean lsn;
  public boolean pvr;
  private boolean pvs;
  private boolean pvt;
  private k pvu;
  
  public i()
  {
    AppMethodBeat.i(228125);
    this.lsn = false;
    this.pvr = true;
    this.pvs = false;
    this.pvt = false;
    this.pvu = new k()
    {
      public final void AT(int paramAnonymousInt)
      {
        AppMethodBeat.i(229313);
        if (paramAnonymousInt < 0) {
          i.a(i.this);
        }
        AppMethodBeat.o(229313);
      }
      
      public final void bVq()
      {
        AppMethodBeat.i(229315);
        i.a(i.this);
        AppMethodBeat.o(229315);
      }
    };
    AppMethodBeat.o(228125);
  }
  
  private static String aiN(String paramString)
  {
    AppMethodBeat.i(228132);
    String str2 = b.aSL();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!u.bBD(str1))
      {
        Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new q(str1).isDirectory())
        {
          Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          u.deleteFile(str1);
          if (!u.bBD(str1))
          {
            Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(228132);
            return null;
          }
        }
      }
      Log.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(228132);
      return str1;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(228132);
    }
    return null;
  }
  
  public static i bVn()
  {
    AppMethodBeat.i(228128);
    if (pvq == null) {}
    try
    {
      if (pvq == null) {
        pvq = new i();
      }
      i locali = pvq;
      AppMethodBeat.o(228128);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(228128);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f paramf)
  {
    AppMethodBeat.i(228131);
    if (this.lsn)
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.pvr) });
      AppMethodBeat.o(228131);
      return;
    }
    Log.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = Util.nowMilliSecond();
    this.lsn = true;
    this.pvs = paramBoolean2;
    this.pvr = paramBoolean1;
    String str;
    if (this.pvr)
    {
      str = aiN("wxvideocache");
      if (Util.isNullOrNil(str))
      {
        this.pvr = false;
        Log.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.AT(-1);
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
      AppMethodBeat.o(228131);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt();
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.dal = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvG = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvF = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvz = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvA = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvB = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvC = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvD = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvH = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvI = new j();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvK = new g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvJ = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvL = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvu = this.pvu;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().tmpDir = aiN("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final String aQ(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(228137);
    if (!this.pvr)
    {
      paramString = d.bWK().aQ(paramString);
      AppMethodBeat.o(228137);
      return paramString;
    }
    if (!Util.isNullOrNil(paramString)) {
      if ((Util.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(228137);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.bVD().pwZ.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(228137);
      return str;
    }
    catch (Exception localException)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(228137);
    }
    return paramString;
  }
  
  public final String aiO(String paramString)
  {
    AppMethodBeat.i(228144);
    Uri localUri = Uri.parse(paramString);
    String str = localUri.toString();
    localObject2 = str;
    localObject1 = str;
    try
    {
      if (this.pvt)
      {
        localObject2 = str;
        if (paramString != null)
        {
          localObject2 = str;
          localObject1 = str;
          if (localUri.getHost().equals("mpvideo.qpic.cn"))
          {
            localObject2 = str;
            localObject1 = str;
            if (localUri.getQueryParameter("vid") != null)
            {
              localObject1 = str;
              paramString = localUri.getPath();
              localObject1 = str;
              localObject2 = localUri.getQueryParameter("vid");
              localObject1 = str;
              localObject2 = paramString + "_" + (String)localObject2;
              localObject1 = localObject2;
              Log.i("MicroMsg.SameLayer.VideoCore", "[TRACE_VIDEO_PRELOAD] cachekey = %s", new Object[] { localObject2 });
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(228144);
    return localObject2;
  }
  
  public final g.a bVl()
  {
    AppMethodBeat.i(228134);
    if (!this.pvr)
    {
      e locale = d.bWK().pBM;
      AppMethodBeat.o(228134);
      return locale;
    }
    AppMethodBeat.o(228134);
    return null;
  }
  
  public final g.a bVm()
  {
    AppMethodBeat.i(228136);
    if (!this.pvr)
    {
      locala = d.bWK().bVm();
      AppMethodBeat.o(228136);
      return locala;
    }
    g.a locala = bVl();
    AppMethodBeat.o(228136);
    return locala;
  }
  
  public final boolean bVo()
  {
    return this.pvs;
  }
  
  public final boolean bVp()
  {
    return this.pvr;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228141);
    if (!this.pvr)
    {
      paramLong1 = d.bWK().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(228141);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.bVD().aiU(paramString);
      AppMethodBeat.o(228141);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(228141);
    }
    return 0L;
  }
  
  public final void iG(boolean paramBoolean)
  {
    this.pvt = paramBoolean;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228139);
    if (!this.pvr)
    {
      d.bWK().o(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(228139);
      return;
    }
    try
    {
      l.bVD().U(paramString, paramLong2);
      AppMethodBeat.o(228139);
      return;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(228139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.i
 * JD-Core Version:    0.7.0.1
 */