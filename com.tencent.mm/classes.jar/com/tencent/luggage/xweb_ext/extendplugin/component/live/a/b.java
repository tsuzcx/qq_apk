package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.threadpool.c.d;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class b
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i, o
{
  private z exD;
  public int eyA;
  public int eyB;
  public int eyC;
  private boolean eyD;
  boolean eyE;
  boolean eyF;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a eyG;
  private com.tencent.mm.plugin.appbrand.jsapi.y.c eyH;
  private String eyI;
  public Handler eyJ;
  private HandlerThread eyK;
  boolean eyL;
  volatile boolean eyM;
  AtomicBoolean eyN;
  private com.tencent.luggage.xweb_ext.extendplugin.component.a eyO;
  private com.tencent.luggage.xweb_ext.extendplugin.component.b<g> eyP;
  private String eyQ;
  public s eyR;
  public int eyS;
  volatile boolean eyT;
  private boolean eyU;
  private boolean eyV;
  public boolean eyW;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i eyX;
  public AtomicBoolean eyY;
  volatile String eyZ;
  private volatile int eyr;
  private volatile int eys;
  public a eyt;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c eyu;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b eyv;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a eyw;
  public com.tencent.luggage.xweb_ext.extendplugin.a eyx;
  private a.a eyy;
  public int eyz;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g eza;
  volatile Bitmap ezb;
  public Surface mSurface;
  private volatile SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public b()
  {
    AppMethodBeat.i(138827);
    this.eyr = -1;
    this.eys = -1;
    this.eyB = 0;
    this.eyC = 0;
    this.eyG = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.eyH = null;
    this.eyI = null;
    this.eyL = false;
    this.eyM = false;
    this.eyN = null;
    this.exD = new b.11(this);
    this.eyO = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.exD)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(220681);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.atw();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.exE = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = ac.Z(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.exF = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(b.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.exE + ", mIsAutoRotationEnabled: " + this.exF);
          AppMethodBeat.o(220681);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.exE = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.exE = false;
          }
        }
      }
      
      public final boolean atA()
      {
        return !b.this.eyM;
      }
    };
    this.eyP = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private g ezg = null;
      
      public final int getId()
      {
        AppMethodBeat.i(220689);
        int i = b.this.getId();
        AppMethodBeat.o(220689);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(220695);
        String str = b.this.getKey();
        AppMethodBeat.o(220695);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(220683);
        String str = b.this.getLogTag();
        AppMethodBeat.o(220683);
        return str;
      }
    };
    this.eyQ = "";
    this.eyR = null;
    this.eyS = -1;
    this.eyT = false;
    this.eyU = false;
    this.eyV = false;
    this.eyW = false;
    this.eyX = new r();
    this.eyY = new AtomicBoolean(false);
    this.mTitle = null;
    this.eyZ = null;
    this.eza = null;
    this.ezb = null;
    this.eyK = d.jw(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.eyK.start();
    this.eyJ = new Handler(this.eyK.getLooper());
    com.tencent.mm.plugin.appbrand.jsapi.live.l.csC();
    this.eyt = new c(MMApplicationContext.getContext(), (byte)0);
    this.eyt.setThreadHandler(this.eyJ);
    this.eyt.setPlayListener(new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (b.this.atY()) {
          b.this.eyv.f(b.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (b.this.atY()) {
          b.this.eyv.a(b.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (b.this.eyw != null)
        {
          paramAnonymousBundle = b.this.eyw;
          b.this.getId();
          paramAnonymousBundle.mD(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        default: 
        case 2007: 
        case 2003: 
          do
          {
            AppMethodBeat.o(138813);
            return;
            if (b.this.eyR != null)
            {
              b.this.eyR.atP();
              AppMethodBeat.o(138813);
              return;
            }
            b.this.eyS = 0;
            AppMethodBeat.o(138813);
            return;
            if (b.this.eyR == null) {
              break;
            }
            b.this.eyR.atQ();
            b.this.eyR.cS(b.this.eyT);
            Log.d(b.this.getLogTag(), "onPlayEvent play, mIsWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(b.this.eyM), Boolean.valueOf(b.this.eyL) });
          } while ((b.this.eyM) || (b.this.eyL) || (b.this.isMuted()));
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220650);
              Log.i(b.this.getLogTag(), "onPlayEvent play, requestFocus");
              b.this.eyG.cvF();
              AppMethodBeat.o(220650);
            }
          });
          AppMethodBeat.o(138813);
          return;
          paramAnonymousBundle = b.this;
          if (b.this.eyT) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.eyS = paramAnonymousInt;
            break;
          }
        case 2006: 
          if (b.this.eyR != null) {
            b.this.eyR.atS();
          }
          for (;;)
          {
            com.tencent.threadpool.h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220652);
                Log.i(b.this.getLogTag(), "onPlayEnd, abandonFocus");
                b.this.eyG.cvG();
                AppMethodBeat.o(220652);
              }
            });
            AppMethodBeat.o(138813);
            return;
            b.this.eyS = 7;
          }
        }
        if (b.this.eyR != null) {
          b.this.eyR.onStop();
        }
        for (;;)
        {
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220647);
              Log.i(b.this.getLogTag(), "onStop, abandonFocus");
              b.this.eyG.cvG();
              AppMethodBeat.o(220647);
            }
          });
          break;
          b.this.eyS = 6;
        }
      }
    });
    this.eyt.setAudioVolumeListener(new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (b.this.eyv != null) {
          b.this.eyv.de(b.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    });
    com.tencent.matrix.c.h.gF("AppBrandLive");
    AppMethodBeat.o(138827);
  }
  
  private void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.eyD = paramJSONObject.optBoolean("needEvent", false);
      if (atY()) {
        this.eyv.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  private void i(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220699);
    Log.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.eyU)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.fO("fail");
      AppMethodBeat.o(220699);
      return;
    }
    Log.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label228;
      }
      this.eyY.set(false);
      if (this.eyt != null) {
        this.eyt.h(this.mSurface);
      }
      this.eyW = false;
      if (this.eyv != null) {
        this.eyv.M(getId(), false);
      }
    }
    label228:
    for (boolean bool = true;; bool = false)
    {
      Log.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.fO((String)localObject);
        AppMethodBeat.o(220699);
        return;
        localObject = e.f(parama);
        if (localObject == null)
        {
          Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.al.a)localObject).c(this);
        i = 1;
        break;
      }
    }
  }
  
  private void k(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138832);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.eyz = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("width", 0));
        this.eyA = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.eyz), Integer.valueOf(this.eyA) });
        atX();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  private void mz(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.eyu != null) {
      this.eyu.dw(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(220875);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.eyX.a(paramClass, paramAddOn);
    AppMethodBeat.o(220875);
  }
  
  public final <AddOn extends j> AddOn ah(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(220884);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.eyX.ah(paramClass);
    AppMethodBeat.o(220884);
    return paramClass;
  }
  
  public final String atL()
  {
    AppMethodBeat.i(220809);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(220809);
    return str;
  }
  
  public final void atW()
  {
    AppMethodBeat.i(138829);
    this.mSurfaceTexture = null;
    if (this.eyJ != null) {
      this.eyJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138818);
          b.a(b.this);
          AppMethodBeat.o(138818);
        }
      });
    }
    AppMethodBeat.o(138829);
  }
  
  final void atX()
  {
    AppMethodBeat.i(138833);
    if ((this.eyz != 0) && (this.eyA != 0) && (this.eyt != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.eyz), Integer.valueOf(this.eyA) });
      if ((atZ()) && (this.eyM))
      {
        Log.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.eyt.dc(this.eyz, this.eyA);
    }
    AppMethodBeat.o(138833);
  }
  
  final boolean atY()
  {
    return this.eyv != null;
  }
  
  final boolean atZ()
  {
    AppMethodBeat.i(220783);
    boolean bool = this.eyP.d(this.eyx);
    AppMethodBeat.o(220783);
    return bool;
  }
  
  public final void aua()
  {
    AppMethodBeat.i(220814);
    if ((this.eyt != null) && (!this.eyt.isPlaying())) {
      fQ("play");
    }
    AppMethodBeat.o(220814);
  }
  
  final boolean aub()
  {
    AppMethodBeat.i(220855);
    if (this.eyx == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(220855);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala = e.f(this.eyx);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(220855);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(220855);
    return bool;
  }
  
  public final boolean dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220789);
    Log.d(getLogTag(), "setSurfaceSize, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (this.eyt != null))
    {
      if (!this.eyY.get()) {
        this.eyt.dc(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(220789);
        return true;
        Log.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(220789);
    return false;
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(138828);
  }
  
  public final void fQ(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.eyJ != null) {
      this.eyJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220671);
          if (b.this.eyt == null)
          {
            Log.w(b.this.getLogTag(), "run#operate, adapter is null");
            AppMethodBeat.o(220671);
            return;
          }
          b.this.eyt.d(paramString, null);
          b.this.fR(paramString);
          AppMethodBeat.o(220671);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void fR(final String paramString)
  {
    int j = 1;
    AppMethodBeat.i(220834);
    int i;
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a locala;
    if (paramString.equalsIgnoreCase("pause")) {
      if (this.eyR != null)
      {
        this.eyR.onPause();
        i = j;
        if (this.eyw != null)
        {
          locala = this.eyw;
          getId();
          locala.mD(2006);
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220672);
            Log.i(b.this.getLogTag(), "operate " + paramString + ", abandonFocus");
            b.this.eyG.cvG();
            AppMethodBeat.o(220672);
          }
        });
      }
      AppMethodBeat.o(220834);
      return;
      this.eyS = 4;
      break;
      if (paramString.equalsIgnoreCase("stop"))
      {
        if (this.eyR != null) {
          this.eyR.onStop();
        }
        for (;;)
        {
          i = j;
          if (this.eyw == null) {
            break;
          }
          locala = this.eyw;
          getId();
          locala.mD(2006);
          i = j;
          break;
          this.eyS = 6;
        }
      }
      i = 0;
    }
  }
  
  public final void forceStop()
  {
    AppMethodBeat.i(220800);
    if (this.eyJ != null) {
      this.eyJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220686);
          if (b.this.eyt != null)
          {
            b.this.eyt.d("stop", null);
            b.this.fR("stop");
            b.this.eyt.atV();
          }
          AppMethodBeat.o(220686);
        }
      });
    }
    AppMethodBeat.o(220800);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = key() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", key() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(220865);
    String str = getKey();
    AppMethodBeat.o(220865);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.eyJ != null) {
      this.eyJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138819);
          b.a(b.this, parama);
          AppMethodBeat.o(138819);
        }
      });
    }
    AppMethodBeat.o(138830);
    return null;
  }
  
  public final void i(final Surface paramSurface)
  {
    AppMethodBeat.i(220753);
    super.i(paramSurface);
    if (this.eyJ != null) {
      this.eyJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138817);
          b localb = b.this;
          Surface localSurface = paramSurface;
          Log.i(localb.getLogTag(), "*** handler(%s) handlePluginReady", new Object[] { localb.key() });
          localb.mSurface = localSurface;
          if (localb.eyt != null)
          {
            if (localb.eyY.get()) {
              break label81;
            }
            localb.eyt.h(localb.mSurface);
          }
          for (;;)
          {
            localb.atX();
            AppMethodBeat.o(138817);
            return;
            label81:
            Log.i(localb.getLogTag(), "setSurface, JustPlayAudio");
          }
        }
      });
    }
    AppMethodBeat.o(220753);
  }
  
  final boolean isMuted()
  {
    AppMethodBeat.i(220850);
    if ((this.eyt != null) && (this.eyt.isMuted()))
    {
      AppMethodBeat.o(220850);
      return true;
    }
    AppMethodBeat.o(220850);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(220842);
    if ((this.eyt != null) && (this.eyt.isPlaying()))
    {
      AppMethodBeat.o(220842);
      return true;
    }
    AppMethodBeat.o(220842);
    return false;
  }
  
  public final boolean j(Surface paramSurface)
  {
    AppMethodBeat.i(220788);
    if (this.eyt != null)
    {
      if (!this.eyY.get()) {
        this.eyt.h(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(220788);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(220788);
    return false;
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.eyw != null) {
      this.eyw.l(this.eyx);
    }
    if (this.eyt != null)
    {
      this.eyt.aue();
      this.eyt = null;
    }
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.eyx != null)
    {
      this.eyx.aty();
      this.eyy = null;
    }
    Log.i(getLogTag(), "LivePlayer release handler thread");
    if (this.eyJ != null) {
      this.eyJ.removeCallbacksAndMessages(null);
    }
    if (this.eyK != null) {
      this.eyK.quitSafely();
    }
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220655);
        Log.i(b.this.getLogTag(), "release, abandonFocus");
        b.this.eyG.cvG();
        AppMethodBeat.o(220655);
      }
    });
    com.tencent.matrix.c.h.gG("AppBrandLive");
    AppMethodBeat.o(138834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b
 * JD-Core Version:    0.7.0.1
 */