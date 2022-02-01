package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public class i
  implements f
{
  private static i sAw;
  private boolean ojM;
  private k sAA;
  public boolean sAx;
  public boolean sAy;
  public boolean sAz;
  
  public i()
  {
    AppMethodBeat.i(328231);
    this.ojM = false;
    this.sAx = true;
    this.sAy = false;
    this.sAz = false;
    this.sAA = new k()
    {
      public final void Bi(int paramAnonymousInt)
      {
        AppMethodBeat.i(328122);
        if (paramAnonymousInt < 0) {
          i.a(i.this);
        }
        AppMethodBeat.o(328122);
      }
      
      public final void cvE()
      {
        AppMethodBeat.i(328124);
        i.a(i.this);
        AppMethodBeat.o(328124);
      }
    };
    AppMethodBeat.o(328231);
  }
  
  private static String abN(String paramString)
  {
    AppMethodBeat.i(328247);
    String str2 = b.bmz();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!y.bDX(str1))
      {
        Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new u(str1).isDirectory())
        {
          Log.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          y.deleteFile(str1);
          if (!y.bDX(str1)) {
            return null;
          }
        }
      }
      Log.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(328247);
      return str1;
    }
    finally
    {
      Log.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(328247);
    }
    return null;
  }
  
  public static String abO(String paramString)
  {
    AppMethodBeat.i(328253);
    Object localObject = Uri.parse(paramString);
    String str3 = ((Uri)localObject).toString();
    String str1 = str3;
    if (paramString != null)
    {
      str1 = str3;
      paramString = str3;
    }
    try
    {
      if (((Uri)localObject).getHost().equals("mpvideo.qpic.cn"))
      {
        str1 = str3;
        paramString = str3;
        if (((Uri)localObject).getQueryParameter("vid") != null)
        {
          paramString = str3;
          str1 = ((Uri)localObject).getPath();
          paramString = str3;
          String str4 = ((Uri)localObject).getQueryParameter("vid");
          paramString = str3;
          str3 = str1 + "_" + str4;
          paramString = str3;
          localObject = ((Uri)localObject).getQueryParameter("format_id");
          str1 = str3;
          if (localObject != null)
          {
            paramString = str3;
            str1 = str3 + "_" + (String)localObject;
          }
          paramString = str1;
          Log.i("MicroMsg.SameLayer.VideoCore", "[TRACE_VIDEO_PRELOAD] cachekey = %s", new Object[] { str1 });
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(328253);
    return str1;
  }
  
  public static i cvD()
  {
    AppMethodBeat.i(328235);
    if (sAw == null) {}
    try
    {
      if (sAw == null) {
        sAw = new i();
      }
      i locali = sAw;
      AppMethodBeat.o(328235);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(328235);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f paramf)
  {
    AppMethodBeat.i(328262);
    if (this.ojM)
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.sAx) });
      AppMethodBeat.o(328262);
      return;
    }
    Log.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = Util.nowMilliSecond();
    this.ojM = true;
    this.sAy = paramBoolean2;
    this.sAx = paramBoolean1;
    String str;
    if (this.sAx)
    {
      str = abN("wxvideocache");
      if (Util.isNullOrNil(str))
      {
        this.sAx = false;
        Log.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.Bi(-1);
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
      AppMethodBeat.o(328262);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH();
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.eYL = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAM = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAL = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAF = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAG = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAH = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAI = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAJ = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAN = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAO = new j();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAQ = new g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAP = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAR = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAA = this.sAA;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().tmpDir = abN("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final String cd(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(328274);
    if (!this.sAx)
    {
      paramString = d.cwX().cd(paramString);
      AppMethodBeat.o(328274);
      return paramString;
    }
    if (!Util.isNullOrNil(paramString)) {
      if ((Util.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(328274);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.cvQ().sCf.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(328274);
      return str;
    }
    catch (Exception localException)
    {
      h.b(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(328274);
    }
    return paramString;
  }
  
  public final g.a cvB()
  {
    AppMethodBeat.i(328266);
    if (!this.sAx)
    {
      e locale = d.cwX().sGZ;
      AppMethodBeat.o(328266);
      return locale;
    }
    AppMethodBeat.o(328266);
    return null;
  }
  
  public final g.a cvC()
  {
    AppMethodBeat.i(328270);
    if (!this.sAx)
    {
      locala = d.cwX().cvC();
      AppMethodBeat.o(328270);
      return locala;
    }
    g.a locala = cvB();
    AppMethodBeat.o(328270);
    return locala;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328283);
    if (!this.sAx)
    {
      paramLong1 = d.cwX().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(328283);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.cvQ().abT(paramString);
      AppMethodBeat.o(328283);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      h.b(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(328283);
    }
    return 0L;
  }
  
  public final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328278);
    if (!this.sAx)
    {
      d.cwX().q(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(328278);
      return;
    }
    try
    {
      l.cvQ().Z(paramString, paramLong2);
      AppMethodBeat.o(328278);
      return;
    }
    catch (Exception paramString)
    {
      h.b(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(328278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.i
 * JD-Core Version:    0.7.0.1
 */