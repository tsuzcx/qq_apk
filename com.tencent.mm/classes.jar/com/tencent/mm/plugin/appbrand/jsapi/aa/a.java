package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.util.ArrayMap;
import com.tencent.e.i;
import com.tencent.luggage.k.a.a.k;
import com.tencent.luggage.k.a.a.l;
import com.tencent.luggage.k.a.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends j
{
  private final AppBrandRuntime iGV;
  private final List<com.tencent.luggage.k.a.a.h> kyA;
  private final List<com.tencent.luggage.k.a.a.h> kyB;
  private final LinkedList<com.tencent.luggage.k.a.a.h> kyC;
  public AtomicBoolean kyD;
  public AtomicBoolean kyE;
  public final c kyt;
  private volatile boolean kyu;
  public volatile a kyv;
  private volatile boolean kyw;
  private volatile com.tencent.luggage.k.a.a.h kyx;
  private final Object kyy;
  private final Map<com.tencent.luggage.k.a.a.h, Boolean> kyz;
  private final String mAppId;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(195039);
    this.kyv = null;
    this.kyw = true;
    this.kyx = null;
    this.kyy = new Object();
    this.kyz = new ArrayMap();
    this.kyA = new ArrayList();
    this.kyB = new ArrayList();
    this.kyC = new LinkedList();
    this.kyD = new AtomicBoolean(false);
    this.kyE = new AtomicBoolean(false);
    this.iGV = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.kyt = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.kyu = bool;
      g.a(this.mAppId, new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(195036);
          super.a(paramAnonymousd);
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramAnonymousd)));
          a.this.c(paramAnonymousd);
          AppMethodBeat.o(195036);
        }
        
        public final void onCreate()
        {
          AppMethodBeat.i(195034);
          super.onCreate();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
          a.a(a.this);
          AppMethodBeat.o(195034);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(195037);
          super.onDestroy();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
          a.this.bfa();
          AppMethodBeat.o(195037);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(195035);
          super.onResume();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
          a.b(a.this);
          AppMethodBeat.o(195035);
        }
      });
      AppMethodBeat.o(195039);
      return;
      bool = false;
    }
  }
  
  private void beZ()
  {
    AppMethodBeat.i(195061);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.a();
    locala.kzu.appId = this.mAppId;
    locala.kzu.aTC = 8;
    locala.kzu.dbV = 1;
    com.tencent.mm.sdk.b.a.ESL.l(locala);
    AppMethodBeat.o(195061);
  }
  
  private String bfb()
  {
    AppMethodBeat.i(195064);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.c)this.iGV.as(com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.c.class);
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(195064);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.c)localObject).bfg();
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(195064);
    return localObject;
  }
  
  private void g(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195055);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + paramh.getName());
    l locall = (l)paramh.U(l.class);
    if (locall == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(195055);
      return;
    }
    locall.playAudio();
    d(paramh);
    AppMethodBeat.o(195055);
  }
  
  private void h(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195056);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + paramh.getName());
    l locall = (l)paramh.U(l.class);
    if (locall == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(195056);
      return;
    }
    locall.EN();
    d(paramh);
    AppMethodBeat.o(195056);
  }
  
  private static boolean i(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195057);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + paramh.getName());
    paramh = (m)paramh.U(m.class);
    if (paramh == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(195057);
      return false;
    }
    paramh.start();
    AppMethodBeat.o(195057);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195058);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + paramh.getName());
    paramh = (m)paramh.U(m.class);
    if (paramh == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(195058);
      return false;
    }
    paramh.pause();
    AppMethodBeat.o(195058);
    return true;
  }
  
  private static String k(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195059);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + paramh.getName());
    paramh = (k)paramh.U(k.class);
    if (paramh == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(195059);
      return null;
    }
    paramh = paramh.getTitle();
    AppMethodBeat.o(195059);
    return paramh;
  }
  
  private static String l(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195060);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + paramh.getName());
    paramh = (k)paramh.U(k.class);
    if (paramh == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(195060);
      return null;
    }
    paramh = paramh.EM();
    AppMethodBeat.o(195060);
    return paramh;
  }
  
  private boolean m(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195063);
    synchronized (this.kyy)
    {
      paramh = (Boolean)this.kyz.get(paramh);
      if ((paramh != null) && (paramh.booleanValue()))
      {
        AppMethodBeat.o(195063);
        return true;
      }
    }
    AppMethodBeat.o(195063);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.h paramh)
  {
    boolean bool2 = false;
    AppMethodBeat.i(195041);
    ??? = g.Dd(this.mAppId);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + paramh.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.kyy)
      {
        boolean bool1;
        if ((!this.kyC.isEmpty()) && (paramh == this.kyC.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.kyE.getAndSet(false)))
          {
            ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(195041);
            return bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean aSK()
  {
    AppMethodBeat.i(195040);
    synchronized (this.kyy)
    {
      if (!this.kyC.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(195040);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean b(com.tencent.luggage.k.a.a.h paramh)
  {
    int i = 0;
    AppMethodBeat.i(195046);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { paramh.getName(), Boolean.TRUE });
    if (this.kyu)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(195046);
      return false;
    }
    synchronized (this.kyy)
    {
      this.kyz.put(paramh, Boolean.TRUE);
      if (this.kyB.contains(paramh))
      {
        this.kyB.remove(paramh);
        this.kyC.remove(paramh);
        this.kyC.addFirst(paramh);
        i = 1;
        if (i != 0) {
          g(paramh);
        }
        AppMethodBeat.o(195046);
        return true;
      }
      this.kyA.remove(paramh);
      this.kyA.add(paramh);
    }
  }
  
  public final com.tencent.luggage.k.a.a.h beS()
  {
    AppMethodBeat.i(195042);
    com.tencent.luggage.k.a.a.h localh2 = this.kyx;
    com.tencent.luggage.k.a.a.h localh1 = localh2;
    if (localh2 != null)
    {
      localh1 = localh2;
      if (this.kyE.get())
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        localh1 = null;
      }
    }
    AppMethodBeat.o(195042);
    return localh1;
  }
  
  public final String beT()
  {
    AppMethodBeat.i(195043);
    Object localObject = beS();
    if (localObject == null)
    {
      AppMethodBeat.o(195043);
      return null;
    }
    localObject = k((com.tencent.luggage.k.a.a.h)localObject);
    AppMethodBeat.o(195043);
    return localObject;
  }
  
  public final String beU()
  {
    AppMethodBeat.i(195044);
    Object localObject = beS();
    if (localObject == null)
    {
      AppMethodBeat.o(195044);
      return null;
    }
    localObject = l((com.tencent.luggage.k.a.a.h)localObject);
    AppMethodBeat.o(195044);
    return localObject;
  }
  
  public final boolean beV()
  {
    AppMethodBeat.i(195045);
    ad.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.kyw);
    boolean bool = this.kyw;
    AppMethodBeat.o(195045);
    return bool;
  }
  
  public final void beW()
  {
    AppMethodBeat.i(195051);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = beS();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(195051);
      return;
    }
    if (i((com.tencent.luggage.k.a.a.h)localObject))
    {
      this.kyw = false;
      this.kyt.requestFocus();
      localObject = this.kyv;
      if (localObject != null) {
        ((a)localObject).aSE();
      }
    }
    AppMethodBeat.o(195051);
  }
  
  public final void beX()
  {
    AppMethodBeat.i(195052);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = beS();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(195052);
      return;
    }
    if (j((com.tencent.luggage.k.a.a.h)localObject))
    {
      this.kyw = true;
      localObject = this.kyv;
      if (localObject != null) {
        ((a)localObject).aSF();
      }
    }
    AppMethodBeat.o(195052);
  }
  
  public final void beY()
  {
    AppMethodBeat.i(195053);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.k.a.a.h localh = beS();
    if (localh == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(195053);
      return;
    }
    if (j(localh))
    {
      this.kyw = false;
      this.kyt.bfc();
    }
    AppMethodBeat.o(195053);
  }
  
  public final void bfa()
  {
    AppMethodBeat.i(195062);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.a();
    locala.kzu.appId = this.mAppId;
    locala.kzu.aTC = 8;
    locala.kzu.dbV = 2;
    com.tencent.mm.sdk.b.a.ESL.l(locala);
    AppMethodBeat.o(195062);
  }
  
  public final void c(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195047);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + paramh.getName());
    synchronized (this.kyy)
    {
      this.kyz.remove(paramh);
      com.tencent.luggage.k.a.a.h localh = beS();
      if ((this.kyC.contains(paramh)) || (localh == paramh))
      {
        this.kyC.remove(paramh);
        if (localh == paramh) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            beY();
            bfa();
            this.kyt.bfc();
            this.kyx = null;
          }
          if (i != 0) {
            h(paramh);
          }
          AppMethodBeat.o(195047);
          return;
          i = 1;
        }
      }
      this.kyA.remove(paramh);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(g.d arg1)
  {
    AppMethodBeat.i(195054);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.kyu = true;
    ??? = beS();
    if (??? != null)
    {
      ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(195054);
      return;
    }
    synchronized (this.kyy)
    {
      com.tencent.luggage.k.a.a.h localh1;
      if (!this.kyC.isEmpty())
      {
        localh1 = (com.tencent.luggage.k.a.a.h)this.kyC.getFirst();
        if (localh1 != null) {}
      }
      else
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(195054);
        return;
      }
      this.kyx = localh1;
      ??? = bfb();
      if (!bt.isNullOrNil(???))
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        beY();
        com.tencent.e.h.Iye.aN(new a.2(this, ???));
        AppMethodBeat.o(195054);
        return;
      }
    }
    this.kyt.requestFocus();
    this.kyw = false;
    g(localh2);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    beZ();
    AppMethodBeat.o(195054);
  }
  
  public final void d(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195048);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + paramh.getName());
    int i = 0;
    synchronized (this.kyy)
    {
      if (this.kyA.contains(paramh))
      {
        this.kyA.remove(paramh);
        i = 1;
        this.kyC.remove(paramh);
        this.kyC.addFirst(paramh);
        if ((i != 0) && (m(paramh))) {
          g(paramh);
        }
        if ((this.kyu) && (beS() != null)) {
          beZ();
        }
        AppMethodBeat.o(195048);
        return;
      }
      this.kyB.remove(paramh);
      this.kyB.add(paramh);
    }
  }
  
  public final void e(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195049);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + paramh.getName());
    synchronized (this.kyy)
    {
      if (this.kyC.contains(paramh))
      {
        this.kyC.remove(paramh);
        this.kyA.add(paramh);
        if (beS() == paramh)
        {
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          bfa();
          if (!this.kyw)
          {
            this.kyt.bfc();
            this.kyx = null;
          }
        }
        AppMethodBeat.o(195049);
        return;
      }
      this.kyB.remove(paramh);
    }
  }
  
  public final void f(com.tencent.luggage.k.a.a.h paramh)
  {
    AppMethodBeat.i(195050);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + paramh.getName());
    synchronized (this.kyy)
    {
      this.kyA.add(paramh);
      this.kyB.remove(paramh);
      this.kyC.remove(paramh);
      if (beS() == paramh)
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        bfa();
        if (!this.kyw)
        {
          this.kyt.bfc();
          this.kyx = null;
        }
      }
      AppMethodBeat.o(195050);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aSE();
    
    public abstract void aSF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a
 * JD-Core Version:    0.7.0.1
 */