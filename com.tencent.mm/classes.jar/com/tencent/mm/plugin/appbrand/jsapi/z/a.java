package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.util.ArrayMap;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.luggage.k.a.a.p;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.j
{
  private final AppBrandRuntime jgY;
  private volatile boolean kZH;
  public volatile a kZI;
  private volatile boolean kZJ;
  private final Object kZL;
  private final Map<p, Boolean> kZM;
  private final List<p> kZN;
  private final List<p> kZO;
  private final LinkedList<p> kZP;
  public final c kZQ;
  public AtomicBoolean kZR;
  public AtomicBoolean kZS;
  private volatile p kZV;
  private final String mAppId;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(206674);
    this.kZI = null;
    this.kZJ = true;
    this.kZV = null;
    this.kZL = new Object();
    this.kZM = new ArrayMap();
    this.kZN = new ArrayList();
    this.kZO = new ArrayList();
    this.kZP = new LinkedList();
    this.kZR = new AtomicBoolean(false);
    this.kZS = new AtomicBoolean(false);
    this.jgY = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.kZQ = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.kZH = bool;
      g.a(this.mAppId, new g.c()
      {
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(210445);
          super.a(paramAnonymousd);
          ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramAnonymousd)));
          a.this.c(paramAnonymousd);
          AppMethodBeat.o(210445);
        }
        
        public final void onCreate()
        {
          AppMethodBeat.i(210443);
          super.onCreate();
          ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
          a.a(a.this);
          AppMethodBeat.o(210443);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(210446);
          super.onDestroy();
          ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
          a.this.blS();
          AppMethodBeat.o(210446);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(210444);
          super.onResume();
          ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
          a.b(a.this);
          AppMethodBeat.o(210444);
        }
      });
      AppMethodBeat.o(206674);
      return;
      bool = false;
    }
  }
  
  private void blR()
  {
    AppMethodBeat.i(206692);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.z.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a();
    locala.laL.appId = this.mAppId;
    locala.laL.aUu = 8;
    locala.laL.cZu = 1;
    com.tencent.mm.sdk.b.a.GpY.l(locala);
    AppMethodBeat.o(206692);
  }
  
  private String blT()
  {
    AppMethodBeat.i(206695);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)this.jgY.as(com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c.class);
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(206695);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)localObject).bma();
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(206695);
    return localObject;
  }
  
  private void g(p paramp)
  {
    AppMethodBeat.i(210457);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + paramp.getName());
    com.tencent.luggage.k.a.a.j localj = (com.tencent.luggage.k.a.a.j)paramp.U(com.tencent.luggage.k.a.a.j.class);
    if (localj == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(210457);
      return;
    }
    localj.playAudio();
    d(paramp);
    AppMethodBeat.o(210457);
  }
  
  private void h(p paramp)
  {
    AppMethodBeat.i(210458);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + paramp.getName());
    com.tencent.luggage.k.a.a.j localj = (com.tencent.luggage.k.a.a.j)paramp.U(com.tencent.luggage.k.a.a.j.class);
    if (localj == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(210458);
      return;
    }
    localj.Er();
    d(paramp);
    AppMethodBeat.o(210458);
  }
  
  private static boolean i(p paramp)
  {
    AppMethodBeat.i(210459);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + paramp.getName());
    paramp = (r)paramp.U(r.class);
    if (paramp == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(210459);
      return false;
    }
    paramp.start();
    AppMethodBeat.o(210459);
    return true;
  }
  
  private static boolean j(p paramp)
  {
    AppMethodBeat.i(210460);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + paramp.getName());
    paramp = (r)paramp.U(r.class);
    if (paramp == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(210460);
      return false;
    }
    paramp.pause();
    AppMethodBeat.o(210460);
    return true;
  }
  
  private static String k(p paramp)
  {
    AppMethodBeat.i(210461);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + paramp.getName());
    paramp = (com.tencent.luggage.k.a.a.i)paramp.U(com.tencent.luggage.k.a.a.i.class);
    if (paramp == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(210461);
      return null;
    }
    paramp = paramp.getTitle();
    AppMethodBeat.o(210461);
    return paramp;
  }
  
  private static String l(p paramp)
  {
    AppMethodBeat.i(210462);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + paramp.getName());
    paramp = (com.tencent.luggage.k.a.a.i)paramp.U(com.tencent.luggage.k.a.a.i.class);
    if (paramp == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(210462);
      return null;
    }
    paramp = paramp.Eq();
    AppMethodBeat.o(210462);
    return paramp;
  }
  
  private boolean m(p paramp)
  {
    AppMethodBeat.i(210463);
    synchronized (this.kZL)
    {
      paramp = (Boolean)this.kZM.get(paramp);
      if ((paramp != null) && (paramp.booleanValue()))
      {
        AppMethodBeat.o(210463);
        return true;
      }
    }
    AppMethodBeat.o(210463);
    return false;
  }
  
  public final boolean a(p paramp)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210448);
    ??? = g.Hg(this.mAppId);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + paramp.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.kZL)
      {
        boolean bool1;
        if ((!this.kZP.isEmpty()) && (paramp == this.kZP.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.kZS.getAndSet(false)))
          {
            ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(210448);
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
  
  public final p aXY()
  {
    AppMethodBeat.i(210449);
    p localp2 = this.kZV;
    p localp1 = localp2;
    if (localp2 != null)
    {
      localp1 = localp2;
      if (this.kZS.get())
      {
        ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        localp1 = null;
      }
    }
    AppMethodBeat.o(210449);
    return localp1;
  }
  
  public final boolean aZH()
  {
    AppMethodBeat.i(206675);
    synchronized (this.kZL)
    {
      if (!this.kZP.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(206675);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean b(p paramp)
  {
    int i = 0;
    AppMethodBeat.i(210450);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { paramp.getName(), Boolean.TRUE });
    if (this.kZH)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(210450);
      return false;
    }
    synchronized (this.kZL)
    {
      this.kZM.put(paramp, Boolean.TRUE);
      if (this.kZO.contains(paramp))
      {
        this.kZO.remove(paramp);
        this.kZP.remove(paramp);
        this.kZP.addFirst(paramp);
        i = 1;
        if (i != 0) {
          g(paramp);
        }
        AppMethodBeat.o(210450);
        return true;
      }
      this.kZN.remove(paramp);
      this.kZN.add(paramp);
    }
  }
  
  public final void blM()
  {
    AppMethodBeat.i(210455);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = aXY();
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(210455);
      return;
    }
    if (i((p)localObject))
    {
      this.kZJ = false;
      this.kZQ.requestFocus();
      localObject = this.kZI;
      if (localObject != null) {
        ((a)localObject).aZB();
      }
    }
    AppMethodBeat.o(210455);
  }
  
  public final String blN()
  {
    AppMethodBeat.i(206678);
    Object localObject = aXY();
    if (localObject == null)
    {
      AppMethodBeat.o(206678);
      return null;
    }
    localObject = k((p)localObject);
    AppMethodBeat.o(206678);
    return localObject;
  }
  
  public final String blO()
  {
    AppMethodBeat.i(206679);
    Object localObject = aXY();
    if (localObject == null)
    {
      AppMethodBeat.o(206679);
      return null;
    }
    localObject = l((p)localObject);
    AppMethodBeat.o(206679);
    return localObject;
  }
  
  public final boolean blP()
  {
    AppMethodBeat.i(206680);
    ac.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.kZJ);
    boolean bool = this.kZJ;
    AppMethodBeat.o(206680);
    return bool;
  }
  
  public final void blQ()
  {
    AppMethodBeat.i(206686);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    p localp = aXY();
    if (localp == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(206686);
      return;
    }
    if (j(localp))
    {
      this.kZJ = false;
      this.kZQ.bjF();
    }
    AppMethodBeat.o(206686);
  }
  
  public final void blS()
  {
    AppMethodBeat.i(206693);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.z.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a();
    locala.laL.appId = this.mAppId;
    locala.laL.aUu = 8;
    locala.laL.cZu = 2;
    com.tencent.mm.sdk.b.a.GpY.l(locala);
    AppMethodBeat.o(206693);
  }
  
  public final void blU()
  {
    AppMethodBeat.i(210456);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = aXY();
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(210456);
      return;
    }
    if (j((p)localObject))
    {
      this.kZJ = true;
      localObject = this.kZI;
      if (localObject != null) {
        ((a)localObject).aZC();
      }
    }
    AppMethodBeat.o(210456);
  }
  
  public final void c(p paramp)
  {
    AppMethodBeat.i(210451);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + paramp.getName());
    synchronized (this.kZL)
    {
      this.kZM.remove(paramp);
      p localp = aXY();
      if ((this.kZP.contains(paramp)) || (localp == paramp))
      {
        this.kZP.remove(paramp);
        if (localp == paramp) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            blQ();
            blS();
            this.kZQ.bjF();
            this.kZV = null;
          }
          if (i != 0) {
            h(paramp);
          }
          AppMethodBeat.o(210451);
          return;
          i = 1;
        }
      }
      this.kZN.remove(paramp);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(g.d arg1)
  {
    AppMethodBeat.i(206687);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.kZH = true;
    ??? = aXY();
    if (??? != null)
    {
      ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(206687);
      return;
    }
    synchronized (this.kZL)
    {
      p localp1;
      if (!this.kZP.isEmpty())
      {
        localp1 = (p)this.kZP.getFirst();
        if (localp1 != null) {}
      }
      else
      {
        ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(206687);
        return;
      }
      this.kZV = localp1;
      ??? = blT();
      if (!bs.isNullOrNil(???))
      {
        ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        blQ();
        h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210447);
            Toast.makeText(ai.getContext(), paramd, 0).show();
            AppMethodBeat.o(210447);
          }
        });
        AppMethodBeat.o(206687);
        return;
      }
    }
    this.kZQ.requestFocus();
    this.kZJ = false;
    g(localp2);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    blR();
    AppMethodBeat.o(206687);
  }
  
  public final void d(p paramp)
  {
    AppMethodBeat.i(210452);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + paramp.getName());
    int i = 0;
    synchronized (this.kZL)
    {
      if (this.kZN.contains(paramp))
      {
        this.kZN.remove(paramp);
        i = 1;
        this.kZP.remove(paramp);
        this.kZP.addFirst(paramp);
        if ((i != 0) && (m(paramp))) {
          g(paramp);
        }
        if ((this.kZH) && (aXY() != null)) {
          blR();
        }
        AppMethodBeat.o(210452);
        return;
      }
      this.kZO.remove(paramp);
      this.kZO.add(paramp);
    }
  }
  
  public final void e(p paramp)
  {
    AppMethodBeat.i(210453);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + paramp.getName());
    synchronized (this.kZL)
    {
      if (this.kZP.contains(paramp))
      {
        this.kZP.remove(paramp);
        this.kZN.add(paramp);
        if (aXY() == paramp)
        {
          ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          blS();
          if (!this.kZJ)
          {
            this.kZQ.bjF();
            this.kZV = null;
          }
        }
        AppMethodBeat.o(210453);
        return;
      }
      this.kZO.remove(paramp);
    }
  }
  
  public final void f(p paramp)
  {
    AppMethodBeat.i(210454);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + paramp.getName());
    synchronized (this.kZL)
    {
      this.kZN.add(paramp);
      this.kZO.remove(paramp);
      this.kZP.remove(paramp);
      if (aXY() == paramp)
      {
        ac.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        blS();
        if (!this.kZJ)
        {
          this.kZQ.bjF();
          this.kZV = null;
        }
      }
      AppMethodBeat.o(210454);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aZB();
    
    public abstract void aZC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a
 * JD-Core Version:    0.7.0.1
 */