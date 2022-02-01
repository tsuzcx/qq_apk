package com.tencent.mm.plugin.appbrand.jsapi.ag;

import android.util.ArrayMap;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.i
{
  private final AppBrandRuntime kEc;
  private final String mAppId;
  public final c mIF;
  private volatile boolean mIG;
  public volatile a mIH;
  private volatile boolean mII;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i mIJ;
  private final Object mIK;
  private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> mIL;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIM;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIN;
  private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIO;
  public AtomicBoolean mIP;
  public AtomicBoolean mIQ;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(215768);
    this.mIH = null;
    this.mII = true;
    this.mIJ = null;
    this.mIK = new Object();
    this.mIL = new ArrayMap();
    this.mIM = new ArrayList();
    this.mIN = new ArrayList();
    this.mIO = new LinkedList();
    this.mIP = new AtomicBoolean(false);
    this.mIQ = new AtomicBoolean(false);
    this.kEc = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.mIF = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.mIG = bool;
      com.tencent.mm.plugin.appbrand.h.a(this.mAppId, new a.1(this));
      AppMethodBeat.o(215768);
      return;
      bool = false;
    }
  }
  
  private void bLW()
  {
    AppMethodBeat.i(215790);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a();
    locala.mJH.appId = this.mAppId;
    locala.mJH.beL = 8;
    locala.mJH.dDe = 1;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(215790);
  }
  
  private String bLY()
  {
    AppMethodBeat.i(215793);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c)this.kEc.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(215793);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c)localObject).bMg();
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(215793);
    return localObject;
  }
  
  private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215784);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + parami.getName());
    m localm = (m)parami.X(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(215784);
      return;
    }
    localm.playAudio();
    d(parami);
    AppMethodBeat.o(215784);
  }
  
  private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215785);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + parami.getName());
    m localm = (m)parami.X(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(215785);
      return;
    }
    localm.PF();
    d(parami);
    AppMethodBeat.o(215785);
  }
  
  private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215786);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + parami.getName());
    parami = (n)parami.X(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(215786);
      return false;
    }
    parami.start();
    AppMethodBeat.o(215786);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215787);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + parami.getName());
    parami = (n)parami.X(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(215787);
      return false;
    }
    parami.pause();
    AppMethodBeat.o(215787);
    return true;
  }
  
  private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215788);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + parami.getName());
    parami = (l)parami.X(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(215788);
      return null;
    }
    parami = parami.getTitle();
    AppMethodBeat.o(215788);
    return parami;
  }
  
  private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215789);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + parami.getName());
    parami = (l)parami.X(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(215789);
      return null;
    }
    parami = parami.PE();
    AppMethodBeat.o(215789);
    return parami;
  }
  
  private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215792);
    synchronized (this.mIK)
    {
      parami = (Boolean)this.mIL.get(parami);
      if ((parami != null) && (parami.booleanValue()))
      {
        AppMethodBeat.o(215792);
        return true;
      }
    }
    AppMethodBeat.o(215792);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    boolean bool2 = false;
    AppMethodBeat.i(215770);
    ??? = com.tencent.mm.plugin.appbrand.h.Uc(this.mAppId);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + parami.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.mIK)
      {
        boolean bool1;
        if ((!this.mIO.isEmpty()) && (parami == this.mIO.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.mIQ.getAndSet(false)))
          {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(215770);
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
  
  public final boolean b(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    int i = 0;
    AppMethodBeat.i(215775);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { parami.getName(), Boolean.TRUE });
    if (this.mIG)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(215775);
      return false;
    }
    synchronized (this.mIK)
    {
      this.mIL.put(parami, Boolean.TRUE);
      if (this.mIN.contains(parami))
      {
        this.mIN.remove(parami);
        this.mIO.remove(parami);
        this.mIO.addFirst(parami);
        i = 1;
        if (i != 0) {
          g(parami);
        }
        AppMethodBeat.o(215775);
        return true;
      }
      this.mIM.remove(parami);
      this.mIM.add(parami);
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.i bLP()
  {
    AppMethodBeat.i(215771);
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali2 = this.mIJ;
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.mIQ.get())
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    AppMethodBeat.o(215771);
    return locali1;
  }
  
  public final String bLQ()
  {
    AppMethodBeat.i(215772);
    Object localObject = bLP();
    if (localObject == null)
    {
      AppMethodBeat.o(215772);
      return null;
    }
    localObject = k((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(215772);
    return localObject;
  }
  
  public final String bLR()
  {
    AppMethodBeat.i(215773);
    Object localObject = bLP();
    if (localObject == null)
    {
      AppMethodBeat.o(215773);
      return null;
    }
    localObject = l((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(215773);
    return localObject;
  }
  
  public final boolean bLS()
  {
    AppMethodBeat.i(215774);
    Log.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.mII);
    boolean bool = this.mII;
    AppMethodBeat.o(215774);
    return bool;
  }
  
  public final void bLT()
  {
    AppMethodBeat.i(215780);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = bLP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(215780);
      return;
    }
    if (i((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.mII = false;
      this.mIF.requestFocus();
      localObject = this.mIH;
      if (localObject != null) {
        ((a)localObject).byV();
      }
    }
    AppMethodBeat.o(215780);
  }
  
  public final void bLU()
  {
    AppMethodBeat.i(215781);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = bLP();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(215781);
      return;
    }
    if (j((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.mII = true;
      localObject = this.mIH;
      if (localObject != null) {
        ((a)localObject).byW();
      }
    }
    AppMethodBeat.o(215781);
  }
  
  public final void bLV()
  {
    AppMethodBeat.i(215782);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bLP();
    if (locali == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(215782);
      return;
    }
    if (j(locali))
    {
      this.mII = false;
      this.mIF.bLZ();
    }
    AppMethodBeat.o(215782);
  }
  
  public final void bLX()
  {
    AppMethodBeat.i(215791);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a();
    locala.mJH.appId = this.mAppId;
    locala.mJH.beL = 8;
    locala.mJH.dDe = 2;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(215791);
  }
  
  public final boolean bzc()
  {
    AppMethodBeat.i(215769);
    synchronized (this.mIK)
    {
      if (!this.mIO.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(215769);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215776);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + parami.getName());
    synchronized (this.mIK)
    {
      this.mIL.remove(parami);
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bLP();
      if ((this.mIO.contains(parami)) || (locali == parami))
      {
        this.mIO.remove(parami);
        if (locali == parami) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            bLV();
            bLX();
            this.mIF.bLZ();
            this.mIJ = null;
          }
          if (i != 0) {
            h(parami);
          }
          AppMethodBeat.o(215776);
          return;
          i = 1;
        }
      }
      this.mIM.remove(parami);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(h.d arg1)
  {
    AppMethodBeat.i(215783);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.mIG = true;
    ??? = bLP();
    if (??? != null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(215783);
      return;
    }
    synchronized (this.mIK)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali1;
      if (!this.mIO.isEmpty())
      {
        locali1 = (com.tencent.luggage.xweb_ext.extendplugin.component.i)this.mIO.getFirst();
        if (locali1 != null) {}
      }
      else
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(215783);
        return;
      }
      this.mIJ = locali1;
      ??? = bLY();
      if (!Util.isNullOrNil(???))
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        bLV();
        com.tencent.f.h.RTc.aV(new a.2(this, ???));
        AppMethodBeat.o(215783);
        return;
      }
    }
    this.mIF.requestFocus();
    this.mII = false;
    g(locali2);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    bLW();
    AppMethodBeat.o(215783);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215777);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + parami.getName());
    int i = 0;
    synchronized (this.mIK)
    {
      if (this.mIM.contains(parami))
      {
        this.mIM.remove(parami);
        i = 1;
        this.mIO.remove(parami);
        this.mIO.addFirst(parami);
        if ((i != 0) && (m(parami))) {
          g(parami);
        }
        if ((this.mIG) && (bLP() != null)) {
          bLW();
        }
        AppMethodBeat.o(215777);
        return;
      }
      this.mIN.remove(parami);
      this.mIN.add(parami);
    }
  }
  
  public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215778);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + parami.getName());
    synchronized (this.mIK)
    {
      if (this.mIO.contains(parami))
      {
        this.mIO.remove(parami);
        this.mIM.add(parami);
        if (bLP() == parami)
        {
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          bLX();
          if (!this.mII)
          {
            this.mIF.bLZ();
            this.mIJ = null;
          }
        }
        AppMethodBeat.o(215778);
        return;
      }
      this.mIN.remove(parami);
    }
  }
  
  public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(215779);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + parami.getName());
    synchronized (this.mIK)
    {
      this.mIM.remove(parami);
      this.mIN.remove(parami);
      this.mIO.remove(parami);
      if (bLP() == parami)
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        bLX();
        if (!this.mII)
        {
          this.mIF.bLZ();
          this.mIJ = null;
        }
      }
      AppMethodBeat.o(215779);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void byV();
    
    public abstract void byW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a
 * JD-Core Version:    0.7.0.1
 */