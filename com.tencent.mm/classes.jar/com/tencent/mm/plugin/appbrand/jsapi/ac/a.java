package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.util.ArrayMap;
import com.tencent.e.h;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
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
  private final AppBrandRuntime jzY;
  public final c lwJ;
  private volatile boolean lwK;
  public volatile a lwL;
  private volatile boolean lwM;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i lwN;
  private final Object lwO;
  private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> lwP;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> lwQ;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> lwR;
  private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> lwS;
  public AtomicBoolean lwT;
  public AtomicBoolean lwU;
  private final String mAppId;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(186862);
    this.lwL = null;
    this.lwM = true;
    this.lwN = null;
    this.lwO = new Object();
    this.lwP = new ArrayMap();
    this.lwQ = new ArrayList();
    this.lwR = new ArrayList();
    this.lwS = new LinkedList();
    this.lwT = new AtomicBoolean(false);
    this.lwU = new AtomicBoolean(false);
    this.jzY = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lwJ = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.lwK = bool;
      g.a(this.mAppId, new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(186859);
          super.a(paramAnonymousd);
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramAnonymousd)));
          a.this.c(paramAnonymousd);
          AppMethodBeat.o(186859);
        }
        
        public final void onCreate()
        {
          AppMethodBeat.i(186857);
          super.onCreate();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
          a.a(a.this);
          AppMethodBeat.o(186857);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(186860);
          super.onDestroy();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
          a.this.bpF();
          AppMethodBeat.o(186860);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(186858);
          super.onResume();
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
          a.b(a.this);
          AppMethodBeat.o(186858);
        }
      });
      AppMethodBeat.o(186862);
      return;
      bool = false;
    }
  }
  
  private void bpE()
  {
    AppMethodBeat.i(186884);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.a();
    locala.lxL.appId = this.mAppId;
    locala.lxL.beO = 8;
    locala.lxL.dkM = 1;
    com.tencent.mm.sdk.b.a.IbL.l(locala);
    AppMethodBeat.o(186884);
  }
  
  private String bpG()
  {
    AppMethodBeat.i(186887);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c)this.jzY.as(com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c.class);
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(186887);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c)localObject).bpL();
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(186887);
    return localObject;
  }
  
  private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186878);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + parami.getName());
    m localm = (m)parami.U(m.class);
    if (localm == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(186878);
      return;
    }
    localm.playAudio();
    d(parami);
    AppMethodBeat.o(186878);
  }
  
  private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186879);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + parami.getName());
    m localm = (m)parami.U(m.class);
    if (localm == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(186879);
      return;
    }
    localm.FQ();
    d(parami);
    AppMethodBeat.o(186879);
  }
  
  private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186880);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + parami.getName());
    parami = (n)parami.U(n.class);
    if (parami == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(186880);
      return false;
    }
    parami.start();
    AppMethodBeat.o(186880);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186881);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + parami.getName());
    parami = (n)parami.U(n.class);
    if (parami == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(186881);
      return false;
    }
    parami.pause();
    AppMethodBeat.o(186881);
    return true;
  }
  
  private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186882);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + parami.getName());
    parami = (l)parami.U(l.class);
    if (parami == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(186882);
      return null;
    }
    parami = parami.getTitle();
    AppMethodBeat.o(186882);
    return parami;
  }
  
  private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186883);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + parami.getName());
    parami = (l)parami.U(l.class);
    if (parami == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(186883);
      return null;
    }
    parami = parami.FP();
    AppMethodBeat.o(186883);
    return parami;
  }
  
  private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186886);
    synchronized (this.lwO)
    {
      parami = (Boolean)this.lwP.get(parami);
      if ((parami != null) && (parami.booleanValue()))
      {
        AppMethodBeat.o(186886);
        return true;
      }
    }
    AppMethodBeat.o(186886);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    boolean bool2 = false;
    AppMethodBeat.i(186864);
    ??? = g.Kv(this.mAppId);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + parami.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.lwO)
      {
        boolean bool1;
        if ((!this.lwS.isEmpty()) && (parami == this.lwS.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.lwU.getAndSet(false)))
          {
            ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(186864);
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
    AppMethodBeat.i(186869);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { parami.getName(), Boolean.TRUE });
    if (this.lwK)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(186869);
      return false;
    }
    synchronized (this.lwO)
    {
      this.lwP.put(parami, Boolean.TRUE);
      if (this.lwR.contains(parami))
      {
        this.lwR.remove(parami);
        this.lwS.remove(parami);
        this.lwS.addFirst(parami);
        i = 1;
        if (i != 0) {
          g(parami);
        }
        AppMethodBeat.o(186869);
        return true;
      }
      this.lwQ.remove(parami);
      this.lwQ.add(parami);
    }
  }
  
  public final boolean bdg()
  {
    AppMethodBeat.i(186863);
    synchronized (this.lwO)
    {
      if (!this.lwS.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(186863);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean bpA()
  {
    AppMethodBeat.i(186868);
    ad.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.lwM);
    boolean bool = this.lwM;
    AppMethodBeat.o(186868);
    return bool;
  }
  
  public final void bpB()
  {
    AppMethodBeat.i(186874);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = bpx();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(186874);
      return;
    }
    if (i((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.lwM = false;
      this.lwJ.requestFocus();
      localObject = this.lwL;
      if (localObject != null) {
        ((a)localObject).bcZ();
      }
    }
    AppMethodBeat.o(186874);
  }
  
  public final void bpC()
  {
    AppMethodBeat.i(186875);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = bpx();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(186875);
      return;
    }
    if (j((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.lwM = true;
      localObject = this.lwL;
      if (localObject != null) {
        ((a)localObject).bda();
      }
    }
    AppMethodBeat.o(186875);
  }
  
  public final void bpD()
  {
    AppMethodBeat.i(186876);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bpx();
    if (locali == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(186876);
      return;
    }
    if (j(locali))
    {
      this.lwM = false;
      this.lwJ.bpH();
    }
    AppMethodBeat.o(186876);
  }
  
  public final void bpF()
  {
    AppMethodBeat.i(186885);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.a();
    locala.lxL.appId = this.mAppId;
    locala.lxL.beO = 8;
    locala.lxL.dkM = 2;
    com.tencent.mm.sdk.b.a.IbL.l(locala);
    AppMethodBeat.o(186885);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.i bpx()
  {
    AppMethodBeat.i(186865);
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali2 = this.lwN;
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.lwU.get())
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    AppMethodBeat.o(186865);
    return locali1;
  }
  
  public final String bpy()
  {
    AppMethodBeat.i(186866);
    Object localObject = bpx();
    if (localObject == null)
    {
      AppMethodBeat.o(186866);
      return null;
    }
    localObject = k((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(186866);
    return localObject;
  }
  
  public final String bpz()
  {
    AppMethodBeat.i(186867);
    Object localObject = bpx();
    if (localObject == null)
    {
      AppMethodBeat.o(186867);
      return null;
    }
    localObject = l((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(186867);
    return localObject;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186870);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + parami.getName());
    synchronized (this.lwO)
    {
      this.lwP.remove(parami);
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bpx();
      if ((this.lwS.contains(parami)) || (locali == parami))
      {
        this.lwS.remove(parami);
        if (locali == parami) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            bpD();
            bpF();
            this.lwJ.bpH();
            this.lwN = null;
          }
          if (i != 0) {
            h(parami);
          }
          AppMethodBeat.o(186870);
          return;
          i = 1;
        }
      }
      this.lwQ.remove(parami);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(g.d arg1)
  {
    AppMethodBeat.i(186877);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.lwK = true;
    ??? = bpx();
    if (??? != null)
    {
      ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(186877);
      return;
    }
    synchronized (this.lwO)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali1;
      if (!this.lwS.isEmpty())
      {
        locali1 = (com.tencent.luggage.xweb_ext.extendplugin.component.i)this.lwS.getFirst();
        if (locali1 != null) {}
      }
      else
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(186877);
        return;
      }
      this.lwN = locali1;
      ??? = bpG();
      if (!bt.isNullOrNil(???))
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        bpD();
        h.LTJ.aP(new a.2(this, ???));
        AppMethodBeat.o(186877);
        return;
      }
    }
    this.lwJ.requestFocus();
    this.lwM = false;
    g(locali2);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    bpE();
    AppMethodBeat.o(186877);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186871);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + parami.getName());
    int i = 0;
    synchronized (this.lwO)
    {
      if (this.lwQ.contains(parami))
      {
        this.lwQ.remove(parami);
        i = 1;
        this.lwS.remove(parami);
        this.lwS.addFirst(parami);
        if ((i != 0) && (m(parami))) {
          g(parami);
        }
        if ((this.lwK) && (bpx() != null)) {
          bpE();
        }
        AppMethodBeat.o(186871);
        return;
      }
      this.lwR.remove(parami);
      this.lwR.add(parami);
    }
  }
  
  public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186872);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + parami.getName());
    synchronized (this.lwO)
    {
      if (this.lwS.contains(parami))
      {
        this.lwS.remove(parami);
        this.lwQ.add(parami);
        if (bpx() == parami)
        {
          ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          bpF();
          if (!this.lwM)
          {
            this.lwJ.bpH();
            this.lwN = null;
          }
        }
        AppMethodBeat.o(186872);
        return;
      }
      this.lwR.remove(parami);
    }
  }
  
  public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(186873);
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + parami.getName());
    synchronized (this.lwO)
    {
      this.lwQ.remove(parami);
      this.lwR.remove(parami);
      this.lwS.remove(parami);
      if (bpx() == parami)
      {
        ad.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        bpF();
        if (!this.lwM)
        {
          this.lwJ.bpH();
          this.lwN = null;
        }
      }
      AppMethodBeat.o(186873);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bcZ();
    
    public abstract void bda();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a
 * JD-Core Version:    0.7.0.1
 */