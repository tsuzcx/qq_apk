package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.e.h;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class b
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i, o
{
  private y cEs;
  private com.tencent.luggage.xweb_ext.extendplugin.component.a cFA;
  private com.tencent.luggage.xweb_ext.extendplugin.component.b<g> cFB;
  private String cFC;
  public s cFD;
  public int cFE;
  volatile boolean cFF;
  private boolean cFG;
  private boolean cFH;
  public boolean cFI;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i cFJ;
  public AtomicBoolean cFK;
  volatile String cFL;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g cFM;
  volatile Bitmap cFN;
  public a cFf;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c cFg;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b cFh;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a cFi;
  public com.tencent.luggage.xweb_ext.extendplugin.a cFj;
  private a.a cFk;
  public int cFl;
  public int cFm;
  public int cFn;
  public int cFo;
  private boolean cFp;
  boolean cFq;
  boolean cFr;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cFs;
  private com.tencent.mm.plugin.appbrand.jsapi.v.c cFt;
  private String cFu;
  public Handler cFv;
  private HandlerThread cFw;
  boolean cFx;
  volatile boolean cFy;
  AtomicBoolean cFz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public b()
  {
    AppMethodBeat.i(138827);
    this.cFn = 0;
    this.cFo = 0;
    this.cFs = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.cFt = null;
    this.cFu = null;
    this.cFx = false;
    this.cFy = false;
    this.cFz = null;
    this.cEs = new b.11(this);
    this.cFA = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cEs)
    {
      public final boolean SV()
      {
        return !b.this.cFy;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(222940);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.SR();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cEt = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = ab.O(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cEu = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(b.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cEt + ", mIsAutoRotationEnabled: " + this.cEu);
          AppMethodBeat.o(222940);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.cEt = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cEt = false;
          }
        }
      }
    };
    this.cFB = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private g cFS = null;
      
      public final int getId()
      {
        AppMethodBeat.i(223111);
        int i = b.this.getId();
        AppMethodBeat.o(223111);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(223114);
        String str = b.this.getKey();
        AppMethodBeat.o(223114);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(223109);
        String str = b.this.getLogTag();
        AppMethodBeat.o(223109);
        return str;
      }
    };
    this.cFC = "";
    this.cFD = null;
    this.cFE = -1;
    this.cFF = false;
    this.cFG = false;
    this.cFH = false;
    this.cFI = false;
    this.cFJ = new r();
    this.cFK = new AtomicBoolean(false);
    this.mTitle = null;
    this.cFL = null;
    this.cFM = null;
    this.cFN = null;
    this.cFw = d.ik(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cFw.start();
    this.cFv = new Handler(this.cFw.getLooper());
    com.tencent.mm.plugin.appbrand.jsapi.live.l.bSv();
    this.cFf = new c(MMApplicationContext.getContext(), (byte)0);
    this.cFf.setThreadHandler(this.cFv);
    this.cFf.setPlayListener(new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (b.this.Tt()) {
          b.this.cFh.e(b.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (b.this.Tt()) {
          b.this.cFh.a(b.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (b.this.cFi != null)
        {
          paramAnonymousBundle = b.this.cFi;
          b.this.getId();
          paramAnonymousBundle.jb(paramAnonymousInt);
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
            if (b.this.cFD != null)
            {
              b.this.cFD.Tk();
              AppMethodBeat.o(138813);
              return;
            }
            b.this.cFE = 0;
            AppMethodBeat.o(138813);
            return;
            if (b.this.cFD == null) {
              break;
            }
            b.this.cFD.Tl();
            b.this.cFD.cm(b.this.cFF);
            Log.d(b.this.getLogTag(), "onPlayEvent play, mIsWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(b.this.cFy), Boolean.valueOf(b.this.cFx) });
          } while ((b.this.cFy) || (b.this.cFx) || (b.this.isMuted()));
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226563);
              Log.i(b.this.getLogTag(), "onPlayEvent play, requestFocus");
              b.this.cFs.bVr();
              AppMethodBeat.o(226563);
            }
          });
          AppMethodBeat.o(138813);
          return;
          paramAnonymousBundle = b.this;
          if (b.this.cFF) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.cFE = paramAnonymousInt;
            break;
          }
        case 2006: 
          if (b.this.cFD != null) {
            b.this.cFD.Tm();
          }
          for (;;)
          {
            h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(224936);
                Log.i(b.this.getLogTag(), "onPlayEnd, abandonFocus");
                b.this.cFs.bVs();
                AppMethodBeat.o(224936);
              }
            });
            AppMethodBeat.o(138813);
            return;
            b.this.cFE = 7;
          }
        }
        if (b.this.cFD != null) {
          b.this.cFD.onStop();
        }
        for (;;)
        {
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221115);
              Log.i(b.this.getLogTag(), "onStop, abandonFocus");
              b.this.cFs.bVs();
              AppMethodBeat.o(221115);
            }
          });
          break;
          b.this.cFE = 6;
        }
      }
    });
    this.cFf.setAudioVolumeListener(new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (b.this.cFh != null) {
          b.this.cFh.cp(b.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    });
    com.tencent.matrix.c.e.fo("AppBrandLive");
    AppMethodBeat.o(138827);
  }
  
  private void Ts()
  {
    AppMethodBeat.i(138833);
    if ((this.cFl != 0) && (this.cFm != 0) && (this.mSurfaceTexture != null) && (this.cFf != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
      this.mSurfaceTexture.setDefaultBufferSize(this.cFl, this.cFm);
      if ((Tu()) && (this.cFy))
      {
        Log.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.cFf.cn(this.cFl, this.cFm);
    }
    AppMethodBeat.o(138833);
  }
  
  private void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.cFp = paramJSONObject.optBoolean("needEvent", false);
      if (Tt()) {
        this.cFh.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  private void i(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(223640);
    Log.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.cFG)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.er("fail");
      AppMethodBeat.o(223640);
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
      this.cFK.set(false);
      if (this.cFf != null) {
        this.cFf.e(this.mSurface);
      }
      this.cFI = false;
      if (this.cFh != null) {
        this.cFh.x(getId(), false);
      }
    }
    label228:
    for (boolean bool = true;; bool = false)
    {
      Log.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.er((String)localObject);
        AppMethodBeat.o(223640);
        return;
        localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
        if (localObject == null)
        {
          Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.ai.a)localObject).c(this);
        i = 1;
        break;
      }
    }
  }
  
  private void iX(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.cFg != null) {
      this.cFg.be(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  private void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138832);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.cFl = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("width", 0));
        this.cFm = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
        Ts();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  public final String Tg()
  {
    AppMethodBeat.i(223616);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(223616);
    return str;
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(138829);
    if (this.cFv != null) {
      this.cFv.post(new Runnable()
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
  
  final boolean Tt()
  {
    return this.cFh != null;
  }
  
  final boolean Tu()
  {
    AppMethodBeat.i(223595);
    boolean bool = this.cFB.d(this.cFj);
    AppMethodBeat.o(223595);
    return bool;
  }
  
  public final void Tv()
  {
    AppMethodBeat.i(223618);
    if ((this.cFf != null) && (!this.cFf.isPlaying())) {
      et("play");
    }
    AppMethodBeat.o(223618);
  }
  
  final boolean Tw()
  {
    AppMethodBeat.i(223631);
    if (this.cFj == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(223631);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cFj);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(223631);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(223631);
    return bool;
  }
  
  public final <AddOn extends j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(223651);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.cFJ.X(paramClass);
    AppMethodBeat.o(223651);
    return paramClass;
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(223647);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.cFJ.a(paramClass, paramAddOn);
    AppMethodBeat.o(223647);
  }
  
  public final boolean co(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223608);
    Log.d(getLogTag(), "setSurfaceSize, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (this.cFf != null))
    {
      if (!this.cFK.get()) {
        this.cFf.cn(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(223608);
        return true;
        Log.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(223608);
    return false;
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.cFv != null) {
      this.cFv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138817);
          b.a(b.this, paramSurfaceTexture);
          AppMethodBeat.o(138817);
        }
      });
    }
    AppMethodBeat.o(138828);
  }
  
  public final void et(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.cFv != null) {
      this.cFv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(225389);
          if (b.this.cFf == null)
          {
            Log.w(b.this.getLogTag(), "run#operate, adapter is null");
            AppMethodBeat.o(225389);
            return;
          }
          b.this.cFf.d(paramString, null);
          b.this.eu(paramString);
          AppMethodBeat.o(225389);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void eu(final String paramString)
  {
    int j = 1;
    AppMethodBeat.i(223626);
    int i;
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a locala;
    if (paramString.equalsIgnoreCase("pause")) {
      if (this.cFD != null)
      {
        this.cFD.onPause();
        i = j;
        if (this.cFi != null)
        {
          locala = this.cFi;
          getId();
          locala.jb(2006);
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222730);
            Log.i(b.this.getLogTag(), "operate " + paramString + ", abandonFocus");
            b.this.cFs.bVs();
            AppMethodBeat.o(222730);
          }
        });
      }
      AppMethodBeat.o(223626);
      return;
      this.cFE = 4;
      break;
      if (paramString.equalsIgnoreCase("stop"))
      {
        if (this.cFD != null) {
          this.cFD.onStop();
        }
        for (;;)
        {
          i = j;
          if (this.cFi == null) {
            break;
          }
          locala = this.cFi;
          getId();
          locala.jb(2006);
          i = j;
          break;
          this.cFE = 6;
        }
      }
      i = 0;
    }
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(223602);
    if (this.cFf != null)
    {
      if (!this.cFK.get()) {
        this.cFf.e(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(223602);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(223602);
    return false;
  }
  
  public final void forceStop()
  {
    AppMethodBeat.i(223613);
    if (this.cFv != null) {
      this.cFv.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224793);
          if (b.this.cFf != null)
          {
            b.this.cFf.d("stop", null);
            b.this.eu("stop");
            b.this.cFf.Tq();
          }
          AppMethodBeat.o(224793);
        }
      });
    }
    AppMethodBeat.o(223613);
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
    AppMethodBeat.i(223644);
    String str = getKey();
    AppMethodBeat.o(223644);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.cFv != null) {
      this.cFv.post(new Runnable()
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
  
  final boolean isMuted()
  {
    AppMethodBeat.i(223629);
    if ((this.cFf != null) && (this.cFf.isMuted()))
    {
      AppMethodBeat.o(223629);
      return true;
    }
    AppMethodBeat.o(223629);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(223628);
    if ((this.cFf != null) && (this.cFf.isPlaying()))
    {
      AppMethodBeat.o(223628);
      return true;
    }
    AppMethodBeat.o(223628);
    return false;
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.cFi != null) {
      this.cFi.l(this.cFj);
    }
    if (this.cFf != null)
    {
      this.cFf.Tz();
      this.cFf = null;
    }
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.cFj != null)
    {
      this.cFj.ST();
      this.cFk = null;
    }
    Log.i(getLogTag(), "LivePlayer release handler thread");
    if (this.cFv != null) {
      this.cFv.removeCallbacksAndMessages(null);
    }
    if (this.cFw != null) {
      this.cFw.quitSafely();
    }
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(225144);
        Log.i(b.this.getLogTag(), "release, abandonFocus");
        b.this.cFs.bVs();
        AppMethodBeat.o(225144);
      }
    });
    com.tencent.matrix.c.e.fp("AppBrandLive");
    AppMethodBeat.o(138834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b
 * JD-Core Version:    0.7.0.1
 */