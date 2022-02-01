package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class j
  implements g
{
  private static j mwW;
  private boolean iCs;
  public boolean mwX;
  private boolean mwY;
  private boolean mwZ;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k mxa;
  
  public j()
  {
    AppMethodBeat.i(234633);
    this.iCs = false;
    this.mwX = true;
    this.mwY = false;
    this.mwZ = false;
    this.mxa = new com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k()
    {
      public final void bJH()
      {
        AppMethodBeat.i(234632);
        j.a(j.this);
        AppMethodBeat.o(234632);
      }
      
      public final void xw(int paramAnonymousInt)
      {
        AppMethodBeat.i(234631);
        if (paramAnonymousInt < 0) {
          j.a(j.this);
        }
        AppMethodBeat.o(234631);
      }
    };
    AppMethodBeat.o(234633);
  }
  
  private static String aaU(String paramString)
  {
    AppMethodBeat.i(234636);
    String str2 = b.aKJ();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!s.boN(str1))
      {
        Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new o(str1).isDirectory())
        {
          Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          s.deleteFile(str1);
          if (!s.boN(str1))
          {
            Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(234636);
            return null;
          }
        }
      }
      Log.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(234636);
      return str1;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(234636);
    }
    return null;
  }
  
  public static j bJE()
  {
    AppMethodBeat.i(234634);
    if (mwW == null) {}
    try
    {
      if (mwW == null) {
        mwW = new j();
      }
      j localj = mwW;
      AppMethodBeat.o(234634);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(234634);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, f paramf)
  {
    AppMethodBeat.i(234635);
    if (this.iCs)
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.mwX) });
      AppMethodBeat.o(234635);
      return;
    }
    Log.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = Util.nowMilliSecond();
    this.iCs = true;
    this.mwY = paramBoolean2;
    this.mwX = paramBoolean1;
    String str;
    if (this.mwX)
    {
      str = aaU("wxvideocache");
      if (Util.isNullOrNil(str))
      {
        this.mwX = false;
        Log.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.xw(-1);
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
      AppMethodBeat.o(234635);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.cWq = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxm = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxl = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxf = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxg = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxh = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxi = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxj = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxn = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxo = new k();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxq = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxr = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa = this.mxa;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().tmpDir = aaU("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final String aaV(String paramString)
  {
    AppMethodBeat.i(234641);
    Uri localUri = Uri.parse(paramString);
    String str = localUri.toString();
    localObject2 = str;
    localObject1 = str;
    try
    {
      if (this.mwZ)
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
    AppMethodBeat.o(234641);
    return localObject2;
  }
  
  public final boolean bJF()
  {
    return this.mwY;
  }
  
  public final boolean bJG()
  {
    return this.mwX;
  }
  
  public final g.a bJs()
  {
    AppMethodBeat.i(234637);
    if (!this.mwX)
    {
      e locale = c.bJr().mwL;
      AppMethodBeat.o(234637);
      return locale;
    }
    AppMethodBeat.o(234637);
    return null;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234640);
    if (!this.mwX)
    {
      paramLong1 = c.bJr().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(234640);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.bJT().aba(paramString);
      AppMethodBeat.o(234640);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(234640);
    }
    return 0L;
  }
  
  public final String getProxyUrl(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(234638);
    if (!this.mwX)
    {
      paramString = c.bJr().getProxyUrl(paramString);
      AppMethodBeat.o(234638);
      return paramString;
    }
    if (!Util.isNullOrNil(paramString)) {
      if ((Util.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(234638);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.bJT().myF.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(234638);
      return str;
    }
    catch (Exception localException)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(234638);
    }
    return paramString;
  }
  
  public final void hQ(boolean paramBoolean)
  {
    this.mwZ = paramBoolean;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234639);
    if (!this.mwX)
    {
      c.bJr().o(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(234639);
      return;
    }
    try
    {
      l.bJT().U(paramString, paramLong2);
      AppMethodBeat.o(234639);
      return;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(234639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j
 * JD-Core Version:    0.7.0.1
 */