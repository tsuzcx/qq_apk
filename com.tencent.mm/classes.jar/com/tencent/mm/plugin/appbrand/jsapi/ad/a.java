package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.util.ArrayMap;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.i
{
  private final AppBrandRuntime jDb;
  public final c lBh;
  private volatile boolean lBi;
  public volatile a lBj;
  private volatile boolean lBk;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i lBl;
  private final Object lBm;
  private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> lBn;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> lBo;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> lBp;
  private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> lBq;
  public AtomicBoolean lBr;
  public AtomicBoolean lBs;
  private final String mAppId;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(220554);
    this.lBj = null;
    this.lBk = true;
    this.lBl = null;
    this.lBm = new Object();
    this.lBn = new ArrayMap();
    this.lBo = new ArrayList();
    this.lBp = new ArrayList();
    this.lBq = new LinkedList();
    this.lBr = new AtomicBoolean(false);
    this.lBs = new AtomicBoolean(false);
    this.jDb = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lBh = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.lBi = bool;
      com.tencent.mm.plugin.appbrand.h.a(this.mAppId, new a.1(this));
      AppMethodBeat.o(220554);
      return;
      bool = false;
    }
  }
  
  private void bqo()
  {
    AppMethodBeat.i(220576);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a();
    locala.lCj.appId = this.mAppId;
    locala.lCj.beO = 8;
    locala.lCj.dlO = 1;
    com.tencent.mm.sdk.b.a.IvT.l(locala);
    AppMethodBeat.o(220576);
  }
  
  private String bqq()
  {
    AppMethodBeat.i(220579);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c)this.jDb.as(com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c.class);
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(220579);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c)localObject).bqv();
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(220579);
    return localObject;
  }
  
  private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220570);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + parami.getName());
    m localm = (m)parami.U(m.class);
    if (localm == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(220570);
      return;
    }
    localm.playAudio();
    d(parami);
    AppMethodBeat.o(220570);
  }
  
  private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220571);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + parami.getName());
    m localm = (m)parami.U(m.class);
    if (localm == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(220571);
      return;
    }
    localm.FW();
    d(parami);
    AppMethodBeat.o(220571);
  }
  
  private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220572);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + parami.getName());
    parami = (n)parami.U(n.class);
    if (parami == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(220572);
      return false;
    }
    parami.start();
    AppMethodBeat.o(220572);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220573);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + parami.getName());
    parami = (n)parami.U(n.class);
    if (parami == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(220573);
      return false;
    }
    parami.pause();
    AppMethodBeat.o(220573);
    return true;
  }
  
  private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220574);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + parami.getName());
    parami = (l)parami.U(l.class);
    if (parami == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(220574);
      return null;
    }
    parami = parami.getTitle();
    AppMethodBeat.o(220574);
    return parami;
  }
  
  private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220575);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + parami.getName());
    parami = (l)parami.U(l.class);
    if (parami == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(220575);
      return null;
    }
    parami = parami.FV();
    AppMethodBeat.o(220575);
    return parami;
  }
  
  private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220578);
    synchronized (this.lBm)
    {
      parami = (Boolean)this.lBn.get(parami);
      if ((parami != null) && (parami.booleanValue()))
      {
        AppMethodBeat.o(220578);
        return true;
      }
    }
    AppMethodBeat.o(220578);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    boolean bool2 = false;
    AppMethodBeat.i(220556);
    ??? = com.tencent.mm.plugin.appbrand.h.KU(this.mAppId);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + parami.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.lBm)
      {
        boolean bool1;
        if ((!this.lBq.isEmpty()) && (parami == this.lBq.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.lBs.getAndSet(false)))
          {
            ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(220556);
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
    AppMethodBeat.i(220561);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { parami.getName(), Boolean.TRUE });
    if (this.lBi)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(220561);
      return false;
    }
    synchronized (this.lBm)
    {
      this.lBn.put(parami, Boolean.TRUE);
      if (this.lBp.contains(parami))
      {
        this.lBp.remove(parami);
        this.lBq.remove(parami);
        this.lBq.addFirst(parami);
        i = 1;
        if (i != 0) {
          g(parami);
        }
        AppMethodBeat.o(220561);
        return true;
      }
      this.lBo.remove(parami);
      this.lBo.add(parami);
    }
  }
  
  public final boolean bdL()
  {
    AppMethodBeat.i(220555);
    synchronized (this.lBm)
    {
      if (!this.lBq.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(220555);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.i bqh()
  {
    AppMethodBeat.i(220557);
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali2 = this.lBl;
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.lBs.get())
      {
        ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    AppMethodBeat.o(220557);
    return locali1;
  }
  
  public final String bqi()
  {
    AppMethodBeat.i(220558);
    Object localObject = bqh();
    if (localObject == null)
    {
      AppMethodBeat.o(220558);
      return null;
    }
    localObject = k((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(220558);
    return localObject;
  }
  
  public final String bqj()
  {
    AppMethodBeat.i(220559);
    Object localObject = bqh();
    if (localObject == null)
    {
      AppMethodBeat.o(220559);
      return null;
    }
    localObject = l((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(220559);
    return localObject;
  }
  
  public final boolean bqk()
  {
    AppMethodBeat.i(220560);
    ae.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.lBk);
    boolean bool = this.lBk;
    AppMethodBeat.o(220560);
    return bool;
  }
  
  public final void bql()
  {
    AppMethodBeat.i(220566);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = bqh();
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(220566);
      return;
    }
    if (i((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.lBk = false;
      this.lBh.requestFocus();
      localObject = this.lBj;
      if (localObject != null) {
        ((a)localObject).bdE();
      }
    }
    AppMethodBeat.o(220566);
  }
  
  public final void bqm()
  {
    AppMethodBeat.i(220567);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = bqh();
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(220567);
      return;
    }
    if (j((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.lBk = true;
      localObject = this.lBj;
      if (localObject != null) {
        ((a)localObject).bdF();
      }
    }
    AppMethodBeat.o(220567);
  }
  
  public final void bqn()
  {
    AppMethodBeat.i(220568);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bqh();
    if (locali == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(220568);
      return;
    }
    if (j(locali))
    {
      this.lBk = false;
      this.lBh.bqr();
    }
    AppMethodBeat.o(220568);
  }
  
  public final void bqp()
  {
    AppMethodBeat.i(220577);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a();
    locala.lCj.appId = this.mAppId;
    locala.lCj.beO = 8;
    locala.lCj.dlO = 2;
    com.tencent.mm.sdk.b.a.IvT.l(locala);
    AppMethodBeat.o(220577);
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220562);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + parami.getName());
    synchronized (this.lBm)
    {
      this.lBn.remove(parami);
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bqh();
      if ((this.lBq.contains(parami)) || (locali == parami))
      {
        this.lBq.remove(parami);
        if (locali == parami) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            bqn();
            bqp();
            this.lBh.bqr();
            this.lBl = null;
          }
          if (i != 0) {
            h(parami);
          }
          AppMethodBeat.o(220562);
          return;
          i = 1;
        }
      }
      this.lBo.remove(parami);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(h.d arg1)
  {
    AppMethodBeat.i(220569);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.lBi = true;
    ??? = bqh();
    if (??? != null)
    {
      ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(220569);
      return;
    }
    synchronized (this.lBm)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali1;
      if (!this.lBq.isEmpty())
      {
        locali1 = (com.tencent.luggage.xweb_ext.extendplugin.component.i)this.lBq.getFirst();
        if (locali1 != null) {}
      }
      else
      {
        ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(220569);
        return;
      }
      this.lBl = locali1;
      ??? = bqq();
      if (!bu.isNullOrNil(???))
      {
        ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        bqn();
        com.tencent.e.h.MqF.aM(new a.2(this, ???));
        AppMethodBeat.o(220569);
        return;
      }
    }
    this.lBh.requestFocus();
    this.lBk = false;
    g(locali2);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    bqo();
    AppMethodBeat.o(220569);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220563);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + parami.getName());
    int i = 0;
    synchronized (this.lBm)
    {
      if (this.lBo.contains(parami))
      {
        this.lBo.remove(parami);
        i = 1;
        this.lBq.remove(parami);
        this.lBq.addFirst(parami);
        if ((i != 0) && (m(parami))) {
          g(parami);
        }
        if ((this.lBi) && (bqh() != null)) {
          bqo();
        }
        AppMethodBeat.o(220563);
        return;
      }
      this.lBp.remove(parami);
      this.lBp.add(parami);
    }
  }
  
  public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220564);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + parami.getName());
    synchronized (this.lBm)
    {
      if (this.lBq.contains(parami))
      {
        this.lBq.remove(parami);
        this.lBo.add(parami);
        if (bqh() == parami)
        {
          ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          bqp();
          if (!this.lBk)
          {
            this.lBh.bqr();
            this.lBl = null;
          }
        }
        AppMethodBeat.o(220564);
        return;
      }
      this.lBp.remove(parami);
    }
  }
  
  public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(220565);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + parami.getName());
    synchronized (this.lBm)
    {
      this.lBo.remove(parami);
      this.lBp.remove(parami);
      this.lBq.remove(parami);
      if (bqh() == parami)
      {
        ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        bqp();
        if (!this.lBk)
        {
          this.lBh.bqr();
          this.lBl = null;
        }
      }
      AppMethodBeat.o(220565);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bdE();
    
    public abstract void bdF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a
 * JD-Core Version:    0.7.0.1
 */