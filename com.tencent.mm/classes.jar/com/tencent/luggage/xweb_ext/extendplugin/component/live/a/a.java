package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.k;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i, o
{
  private z cDL;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c cEA;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b cEB;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a cEC;
  public com.tencent.luggage.xweb_ext.extendplugin.a cED;
  a.a cEE;
  public int cEF;
  public int cEG;
  public int cEH;
  public int cEI;
  private boolean cEJ;
  boolean cEK;
  boolean cEL;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cEM;
  com.tencent.mm.plugin.appbrand.jsapi.u.c cEN;
  String cEO;
  public Handler cEP;
  private HandlerThread cEQ;
  boolean cER;
  volatile boolean cES;
  AtomicBoolean cET;
  com.tencent.luggage.xweb_ext.extendplugin.component.a cEU;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<d> cEV;
  String cEW;
  public s cEX;
  public int cEY;
  volatile boolean cEZ;
  public b cEz;
  boolean cFa;
  boolean cFb;
  public boolean cFc;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i cFd;
  public AtomicBoolean cFe;
  volatile String cFf;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g cFg;
  volatile Bitmap cFh;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public a()
  {
    AppMethodBeat.i(138827);
    this.cEH = 0;
    this.cEI = 0;
    this.cEM = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.cEN = null;
    this.cEO = null;
    this.cER = false;
    this.cES = false;
    this.cET = null;
    this.cDL = new a.11(this);
    this.cEU = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cDL)
    {
      public final boolean Pv()
      {
        return !a.this.cES;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(215574);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.Ps();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cDM = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.ac.K(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cDN = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(a.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cDM + ", mIsAutoRotationEnabled: " + this.cDN);
          AppMethodBeat.o(215574);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.cDM = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cDM = false;
          }
        }
      }
    };
    this.cEV = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private d cFm = null;
      
      public final int getId()
      {
        AppMethodBeat.i(215576);
        int i = a.this.getId();
        AppMethodBeat.o(215576);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(215577);
        String str = a.this.getKey();
        AppMethodBeat.o(215577);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(215575);
        String str = a.this.getLogTag();
        AppMethodBeat.o(215575);
        return str;
      }
    };
    this.cEW = "";
    this.cEX = null;
    this.cEY = -1;
    this.cEZ = false;
    this.cFa = false;
    this.cFb = false;
    this.cFc = false;
    this.cFd = new r();
    this.cFe = new AtomicBoolean(false);
    this.mTitle = null;
    this.cFf = null;
    this.cFg = null;
    this.cFh = null;
    this.cEQ = com.tencent.f.c.d.hA(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cEQ.start();
    this.cEP = new Handler(this.cEQ.getLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.live.b.PP();
    this.cEz = new b(MMApplicationContext.getContext());
    this.cEz.mHandler = this.cEP;
    this.cEz.cFv = new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (a.this.PS()) {
          a.this.cEB.d(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (a.this.PS()) {
          a.this.cEB.a(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (a.this.cEC != null) {
          a.this.cEC.hY(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        default: 
        case 2007: 
        case 2004: 
          do
          {
            AppMethodBeat.o(138813);
            return;
            if (a.this.cEX != null)
            {
              a.this.cEX.PL();
              AppMethodBeat.o(138813);
              return;
            }
            a.this.cEY = 0;
            AppMethodBeat.o(138813);
            return;
            if (a.this.cEX == null) {
              break;
            }
            a.this.cEX.PM();
            a.this.cEX.bZ(a.this.cEZ);
            Log.d(a.this.getLogTag(), "onPlayEvent play, mIsWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(a.this.cES), Boolean.valueOf(a.this.cER) });
          } while ((a.this.cES) || (a.this.cER) || (a.this.isMuted()));
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215566);
              Log.i(a.this.getLogTag(), "onPlayEvent play, requestFocus");
              a.this.cEM.bJI();
              AppMethodBeat.o(215566);
            }
          });
          AppMethodBeat.o(138813);
          return;
          paramAnonymousBundle = a.this;
          if (a.this.cEZ) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.cEY = paramAnonymousInt;
            break;
          }
        case 2006: 
          if (a.this.cEX != null) {
            a.this.cEX.PN();
          }
          for (;;)
          {
            h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(215567);
                Log.i(a.this.getLogTag(), "onPlayEnd, abandonFocus");
                a.this.cEM.bJJ();
                AppMethodBeat.o(215567);
              }
            });
            AppMethodBeat.o(138813);
            return;
            a.this.cEY = 7;
          }
        }
        if (a.this.cEX != null) {
          a.this.cEX.onStop();
        }
        for (;;)
        {
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215568);
              Log.i(a.this.getLogTag(), "onStop, abandonFocus");
              a.this.cEM.bJJ();
              AppMethodBeat.o(215568);
            }
          });
          break;
          a.this.cEY = 6;
        }
      }
    };
    this.cEz.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (a.this.cEB != null) {
          a.this.cEB.bW(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    };
    AppMethodBeat.o(138827);
  }
  
  private void PR()
  {
    AppMethodBeat.i(138833);
    if ((this.cEF != 0) && (this.cEG != 0) && (this.mSurfaceTexture != null) && (this.cEz != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.cEF), Integer.valueOf(this.cEG) });
      this.mSurfaceTexture.setDefaultBufferSize(this.cEF, this.cEG);
      if ((PT()) && (this.cES))
      {
        Log.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.cEz.bV(this.cEF, this.cEG);
    }
    AppMethodBeat.o(138833);
  }
  
  public final void PG()
  {
    AppMethodBeat.i(215601);
    if (this.cEP != null) {
      this.cEP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215579);
          if (a.this.cEz != null)
          {
            a.this.cEz.e("stop", null);
            a.this.dS("stop");
            b localb = a.this.cEz;
            if (localb.cFv != null) {
              localb.cFv.onPlayEvent(6001, new Bundle());
            }
          }
          AppMethodBeat.o(215579);
        }
      });
    }
    AppMethodBeat.o(215601);
  }
  
  public final String PH()
  {
    AppMethodBeat.i(215602);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(215602);
    return str;
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(138829);
    if (this.cEP != null) {
      this.cEP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138818);
          a.a(a.this);
          AppMethodBeat.o(138818);
        }
      });
    }
    AppMethodBeat.o(138829);
  }
  
  final boolean PS()
  {
    return this.cEB != null;
  }
  
  final boolean PT()
  {
    AppMethodBeat.i(215598);
    boolean bool = this.cEV.d(this.cED);
    AppMethodBeat.o(215598);
    return bool;
  }
  
  public final void PU()
  {
    AppMethodBeat.i(215603);
    if ((this.cEz != null) && (!this.cEz.cFu.isPlaying())) {
      dR("play");
    }
    AppMethodBeat.o(215603);
  }
  
  final boolean PV()
  {
    AppMethodBeat.i(215606);
    if (this.cED == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(215606);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cED);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(215606);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(215606);
    return bool;
  }
  
  public final <AddOn extends j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(215610);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.cFd.X(paramClass);
    AppMethodBeat.o(215610);
    return paramClass;
  }
  
  final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.cEJ = paramJSONObject.optBoolean("needEvent", false);
      if (PS()) {
        this.cEB.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(215609);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.cFd.a(paramClass, paramAddOn);
    AppMethodBeat.o(215609);
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215600);
    Log.d(getLogTag(), "setSurfaceSize, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (this.cEz != null))
    {
      if (!this.cFe.get()) {
        this.cEz.bV(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(215600);
        return true;
        Log.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(215600);
    return false;
  }
  
  public final void dR(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.cEP != null) {
      this.cEP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215581);
          if (a.this.cEz == null)
          {
            Log.w(a.this.getLogTag(), "run#operate, adapter is null");
            AppMethodBeat.o(215581);
            return;
          }
          a.this.cEz.e(paramString, null);
          a.this.dS(paramString);
          AppMethodBeat.o(215581);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void dS(final String paramString)
  {
    int j = 1;
    AppMethodBeat.i(215604);
    int i;
    if (paramString.equalsIgnoreCase("pause")) {
      if (this.cEX != null)
      {
        this.cEX.onPause();
        i = j;
        if (this.cEC != null)
        {
          this.cEC.hY(2006);
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215582);
            Log.i(a.this.getLogTag(), "operate " + paramString + ", abandonFocus");
            a.this.cEM.bJJ();
            AppMethodBeat.o(215582);
          }
        });
      }
      AppMethodBeat.o(215604);
      return;
      this.cEY = 4;
      break;
      if (paramString.equalsIgnoreCase("stop"))
      {
        if (this.cEX != null) {
          this.cEX.onStop();
        }
        for (;;)
        {
          i = j;
          if (this.cEC == null) {
            break;
          }
          this.cEC.hY(2006);
          i = j;
          break;
          this.cEY = 6;
        }
      }
      i = 0;
    }
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.cEP != null) {
      this.cEP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138817);
          a.a(a.this, paramSurfaceTexture);
          AppMethodBeat.o(138817);
        }
      });
    }
    AppMethodBeat.o(138828);
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(215599);
    if (this.cEz != null)
    {
      if (!this.cFe.get()) {
        this.cEz.f(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(215599);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    Log.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(215599);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = Lb() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", Lb() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(215608);
    String str = getKey();
    AppMethodBeat.o(215608);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.cEP != null) {
      this.cEP.post(new Runnable()
      {
        public final void run()
        {
          int j = 1;
          AppMethodBeat.i(138819);
          a locala = a.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala1 = parama;
          String str = locala1.Pt();
          Object localObject1;
          boolean bool2;
          Object localObject2;
          int i;
          if (!Util.isNullOrNil(str))
          {
            localObject1 = locala1.Ps();
            Log.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.Lb(), str, ((JSONObject)localObject1).toString() });
            new StringBuilder("handleJsApi:").append(str).append(", data:").append(localObject1);
            bool2 = locala.isMuted();
            if (!str.contains("insert")) {
              break label1312;
            }
            locala.hV(1);
            localObject1 = locala1.Ps();
            if (((JSONObject)localObject1).optInt("mode", 0) != 2) {
              break label402;
            }
            locala.cFa = true;
            localObject2 = locala1.getContext();
            if ((localObject2 instanceof Activity)) {
              break label335;
            }
            Log.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
            locala1.dP("fail:internal error invalid android context");
            i = 0;
            if (i != 0) {
              break label408;
            }
          }
          label231:
          label255:
          Object localObject3;
          label402:
          label1940:
          for (;;)
          {
            locala.cEU.a(str, locala1);
            localObject1 = locala1.Ps();
            if (localObject1 != null) {
              break label3191;
            }
            Log.w(locala.getLogTag(), "handleAutoPlay, null == dataJsonObj");
            localObject1 = locala1.Ps();
            if (localObject1 != null) {
              break label3212;
            }
            Log.w(locala.getLogTag(), "handlePlayerUrl, null == dataJsonObj");
            locala.cEV.a(locala1, locala.cEW);
            bool1 = locala.isMuted();
            if (bool1 == bool2) {
              break label3233;
            }
            i = j;
            label284:
            if (((i & locala.isPlaying()) != 0) && (!locala.cES) && (!locala.cER)) {
              h.RTc.aV(new a.28(locala, bool1));
            }
            AppMethodBeat.o(138819);
            return;
            label335:
            if (com.tencent.luggage.h.i.n((Activity)localObject2, "android.permission.RECORD_AUDIO"))
            {
              i = 1;
              break;
            }
            localObject2 = new HashMap();
            ((Map)localObject2).put("errCode", Integer.valueOf(10001));
            Log.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
            locala1.f("fail:system permission denied", (Map)localObject2);
            i = 0;
            break;
            locala.cFa = false;
            label408:
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { locala1.getAppId() }));
            locala.cED = locala1;
            localObject2 = locala1.NN();
            if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.page.ac)) {
              if (!((com.tencent.mm.plugin.appbrand.page.ac)localObject2).cwV)
              {
                bool1 = true;
                label467:
                locala.cES = bool1;
                label473:
                locala.cEE = new a.29(locala);
                locala1.a(locala.cEE);
                if (locala.cEC != null) {
                  locala.cEC.m(locala1);
                }
                locala.a(locala1, (JSONObject)localObject1);
                locala.i((JSONObject)localObject1);
                locala.cEK = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
                locala.cEL = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
                locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
                locala.cFf = ((JSONObject)localObject1).optString("backgroundPoster", locala.cFf);
                localObject2 = locala1.NN();
                if (localObject2 != null) {
                  break label756;
                }
                Log.w(locala.getLogTag(), "updateReferrers, component is null");
                label624:
                if (locala.cEO == null) {}
              }
            }
            label756:
            Object localObject4;
            try
            {
              ((JSONObject)localObject1).put("referrer", locala.cEO);
              if ((locala.cES) && (!locala.PT())) {
                Log.i(locala.getLogTag(), "insert, webView in background");
              }
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                ((JSONObject)localObject1).put("canStartPlay", false);
                locala.cET = new AtomicBoolean(((JSONObject)localObject1).optBoolean("autoplay", false));
                if (locala.cEz == null)
                {
                  Log.w(locala.getLogTag(), "insert, adapter is null");
                  locala1.dP("fail");
                  continue;
                  bool1 = false;
                  break label467;
                  Log.w(locala.getLogTag(), "insert, component is not AppBrandPageView");
                  break label473;
                  localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.u.a)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
                  if (localObject4 == null)
                  {
                    Log.w(locala.getLogTag(), "updateReferrers, referrerHelper is null");
                    break label624;
                  }
                  if (locala.cEN == null) {
                    locala.cEN = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject4).bIw();
                  }
                  com.tencent.mm.plugin.appbrand.jsapi.u.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject4).a((JSONObject)localObject1, (f)localObject2);
                  if (localc != null) {
                    locala.cEN = localc;
                  }
                  Log.i(locala.getLogTag(), "updateReferrers, mReferrerPolicy: " + locala.cEN);
                  if (com.tencent.mm.plugin.appbrand.jsapi.u.c.mou == locala.cEN)
                  {
                    locala.cEO = null;
                    break label624;
                  }
                  locala.cEO = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject4).y((f)localObject2);
                  Log.i(locala.getLogTag(), "updateReferrers, mReferrer: " + locala.cEO);
                  break label624;
                  localJSONException1 = localJSONException1;
                  Log.w(locala.getLogTag(), "insert, put referrer fail since " + localJSONException1.toString());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  Log.w(locala.getLogTag(), "insert, put isInForeground fail since " + localJSONException2.toString());
                }
                localObject3 = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.g((JSONObject)localObject1);
                localObject1 = locala.cEz;
                if (((b)localObject1).cFv != null)
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
                  ((Bundle)localObject4).putLong("EVT_TIME", System.currentTimeMillis());
                  ((b)localObject1).cFv.onPlayEvent(-9999999, (Bundle)localObject4);
                }
                b.l("initLivePlayer", (Bundle)localObject3);
                ((b)localObject1).mVideoView = null;
                ((b)localObject1).cEW = ((Bundle)localObject3).getString("playUrl", ((b)localObject1).cEW);
                ((b)localObject1).cFx = ((b)localObject1).n((Bundle)localObject3);
                ((b)localObject1).a((Bundle)localObject3, true);
                ((b)localObject1).cEZ = ((Bundle)localObject3).getBoolean("autoplay", ((b)localObject1).cEZ);
                if ((((Bundle)localObject3).getBoolean("canStartPlay", true)) && (((b)localObject1).cEZ) && (((b)localObject1).cEW != null) && (!((b)localObject1).cEW.isEmpty()))
                {
                  Log.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                  ((b)localObject1).cFu.startPlay(((b)localObject1).cEW, ((b)localObject1).cFx);
                }
                ((b)localObject1).mInited = true;
                localObject4 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
                Log.i(locala.getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject4).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject4).errorInfo });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject4).errorCode != 0) {}
              }
            }
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.dP((String)localObject1);
              if ((((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject4).errorCode != 0) || (locala.cEC == null)) {
                break;
              }
              locala.cEC.a(locala1, (Bundle)localObject3);
              break;
            }
            label1312:
            if (str.contains("update"))
            {
              locala.hV(2);
              localObject1 = locala1.Ps();
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                locala.cEK = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                locala.cEL = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              }
              if (locala.cEC != null) {
                locala.cEC.m(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.cFf = ((JSONObject)localObject1).optString("backgroundPoster", locala.cFf);
              if (locala.cEz == null)
              {
                Log.w(locala.getLogTag(), "update, adapter is null");
                locala1.dP("fail");
              }
              else
              {
                localObject4 = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.g((JSONObject)localObject1);
                localObject1 = locala.cEz;
                if (!((b)localObject1).mInited)
                {
                  localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePlayer");
                  label1529:
                  Log.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorInfo });
                  if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode != 0) {
                    break label1940;
                  }
                }
                for (localObject3 = "ok";; localObject3 = "fail")
                {
                  locala1.dP((String)localObject3);
                  if ((((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode != 0) || (locala.cEC == null)) {
                    break;
                  }
                  locala.cEC.a(locala1, (Bundle)localObject4);
                  break;
                  b.l("updateLivePlayer", (Bundle)localObject4);
                  ((b)localObject1).a((Bundle)localObject4, false);
                  bool1 = ((b)localObject1).cFu.isPlaying();
                  localObject3 = ((Bundle)localObject4).getString("playUrl", ((b)localObject1).cEW);
                  if ((localObject3 != null) && (!((String)localObject3).isEmpty()) && (((b)localObject1).cEW != null) && (!((b)localObject1).cEW.equalsIgnoreCase((String)localObject3)) && (((b)localObject1).cFu.isPlaying()))
                  {
                    Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject1).cEW + " playUrl-new = " + (String)localObject3);
                    ((b)localObject1).cFu.stopPlay(true);
                  }
                  ((b)localObject1).cEW = ((String)localObject3);
                  i = ((b)localObject1).n((Bundle)localObject4);
                  if ((i != ((b)localObject1).cFx) && (((b)localObject1).cFu.isPlaying()))
                  {
                    Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject1).cFx + " playType-new = " + i);
                    ((b)localObject1).cFu.stopPlay(true);
                  }
                  ((b)localObject1).cFx = i;
                  ((b)localObject1).cEZ = ((Bundle)localObject4).getBoolean("autoplay", ((b)localObject1).cEZ);
                  if (((((b)localObject1).cEZ) || (bool1)) && (((b)localObject1).cEW != null) && (!((b)localObject1).cEW.isEmpty()) && (!((b)localObject1).cFu.isPlaying()))
                  {
                    Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                    ((b)localObject1).cFu.startPlay(((b)localObject1).cEW, ((b)localObject1).cFx);
                  }
                  localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
                  break label1529;
                }
              }
            }
            else if ((str.contains("operate")) && (str.contains("Background")))
            {
              localObject1 = locala1.Ps().optString("type");
              Log.i(locala.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
              if ((!Util.isNullOrNil((String)localObject1)) && (locala.cEz != null))
              {
                if (((String)localObject1).equals("stop"))
                {
                  locala.i(locala1);
                  if (locala.cER)
                  {
                    Log.i(locala.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    locala.cET = new AtomicBoolean(false);
                  }
                }
                else
                {
                  locala1.dP("fail");
                }
              }
              else {
                locala1.dP("fail");
              }
            }
            else
            {
              if (!str.contains("operate")) {
                break label3145;
              }
              locala.hV(3);
              localObject1 = locala1.Ps();
              localObject3 = ((JSONObject)localObject1).optString("type");
              Log.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject3 });
              if ((Util.isNullOrNil((String)localObject3)) || (locala.cEz == null)) {
                break label3131;
              }
              if (((String)localObject3).equals("snapshot"))
              {
                if (locala.cEz == null)
                {
                  Log.w(locala.getLogTag(), "operateSnapshot, adapter is null");
                  locala1.dP("fail");
                }
                else
                {
                  locala.cEz.cFw = new a.9(locala, locala1);
                  localObject1 = locala.cEz.e("snapshot", locala1.Ps());
                  if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode != 0)
                  {
                    Log.i(locala.getLogTag(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode) });
                    locala1.dP("fail:snapshot error");
                  }
                  else
                  {
                    Log.i(locala.getLogTag(), "operateSnapshot, success");
                  }
                }
              }
              else
              {
                if (((String)localObject3).equalsIgnoreCase("requestFullScreen"))
                {
                  if ((locala.cEC != null) && (locala.cEC.j(locala1)))
                  {
                    bool1 = true;
                    label2355:
                    Log.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool1) });
                    if (!bool1) {
                      break label2401;
                    }
                  }
                  label2401:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dP((String)localObject1);
                    break;
                    bool1 = false;
                    break label2355;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitFullScreen"))
                {
                  if ((locala.cEC != null) && (locala.cEC.k(locala1)))
                  {
                    bool1 = true;
                    Log.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool1) });
                    if (!bool1) {
                      break label2491;
                    }
                  }
                  label2491:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dP((String)localObject1);
                    break;
                    bool1 = false;
                    break label2445;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitPictureInPicture"))
                {
                  bool1 = locala.cEV.c(locala1);
                  Log.i(locala.getLogTag(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool1) });
                  if (bool1) {}
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dP((String)localObject1);
                    break;
                  }
                }
                if (!((String)localObject3).equalsIgnoreCase("requestBackgroundPlayback")) {
                  break label2984;
                }
                Log.d(locala.getLogTag(), "enableBackgroundPlayAudio");
                if (locala.cFa)
                {
                  Log.w(locala.getLogTag(), "enableBackgroundPlayAudio, mIsRTCMode");
                  locala1.dP("fail");
                }
                else
                {
                  if (!locala.cER) {
                    break label2661;
                  }
                  Log.w(locala.getLogTag(), "enableBackgroundPlayAudio, isRuntimeInBackground");
                  locala1.dP("fail");
                }
              }
            }
          }
          label2445:
          label2661:
          if (!locala.cFb)
          {
            Log.d(locala.getLogTag(), "registerAddOnPlayAudio");
            locala.a(m.class, new a.19(locala));
            Log.d(locala.getLogTag(), "registerAddOnVideoController");
            locala.a(n.class, new a.20(locala));
            Log.d(locala.getLogTag(), "registerAddOnInfo");
            locala.a(l.class, new a.21(locala));
            Log.d(locala.getLogTag(), "registerAddOnGetSnapshot");
            locala.a(k.class, new a.25(locala));
            locala.cFb = true;
          }
          Log.d(locala.getLogTag(), "enableBackgroundPlayAudioInternal");
          if (locala1 == null)
          {
            Log.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            bool1 = false;
            label2816:
            if (!bool1) {
              break label3238;
            }
            if ((locala.cEz != null) && (!locala.cEz.cFu.isPlaying()))
            {
              locala.cFe.set(true);
              locala.cEz.f(null);
            }
            locala.cFc = true;
            if (locala.cEB != null) {
              locala.cEB.v(locala.getId(), true);
            }
          }
          label3212:
          label3233:
          label3238:
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.i(locala.getLogTag(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.dP((String)localObject1);
              break;
              localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala1);
              if (localObject1 == null)
              {
                Log.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                bool1 = false;
                break label2816;
              }
              bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.a)localObject1).b(locala);
              break label2816;
            }
            label2984:
            if (((String)localObject3).equalsIgnoreCase("exitBackgroundPlayback"))
            {
              locala.i(locala1);
              break;
            }
            if (locala.cEz.e((String)localObject3, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.dP((String)localObject1);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) && (!((String)localObject3).equalsIgnoreCase("pause"))) {
                break;
              }
              locala.cEV.b(locala1);
              locala.dS((String)localObject3);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) || (!locala.cER)) {
                break;
              }
              Log.i(locala.getLogTag(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
              locala.cET = new AtomicBoolean(false);
              break;
            }
            label3131:
            locala1.dP("fail");
            break;
            label3145:
            if (!str.contains("remove")) {
              break;
            }
            locala.hV(4);
            locala.release();
            locala1.dP("ok");
            locala.cEV.b(locala1);
            break;
            label3191:
            locala.cEZ = ((JSONObject)localObject1).optBoolean("autoplay", locala.cEZ);
            break label231;
            locala.cEW = ((JSONObject)localObject1).optString("playUrl", locala.cEW);
            break label255;
            i = 0;
            break label284;
          }
        }
      });
    }
    AppMethodBeat.o(138830);
    return null;
  }
  
  final void hV(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.cEA != null) {
      this.cEA.aW(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  final void i(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215607);
    Log.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.cFa)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.dP("fail");
      AppMethodBeat.o(215607);
      return;
    }
    Log.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label226;
      }
      this.cFe.set(false);
      if (this.cEz != null) {
        this.cEz.f(this.mSurface);
      }
      this.cFc = false;
      if (this.cEB != null) {
        this.cEB.v(getId(), false);
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      Log.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.dP((String)localObject);
        AppMethodBeat.o(215607);
        return;
        localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
        if (localObject == null)
        {
          Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.ag.a)localObject).c(this);
        i = 1;
        break;
      }
    }
  }
  
  final void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138832);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(paramJSONObject.optInt("width", 0));
        this.cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.cEF), Integer.valueOf(this.cEG) });
        PR();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  final boolean isMuted()
  {
    return (this.cEz != null) && (this.cEz.mMuteAudio);
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(215605);
    if ((this.cEz != null) && (this.cEz.cFu.isPlaying()))
    {
      AppMethodBeat.o(215605);
      return true;
    }
    AppMethodBeat.o(215605);
    return false;
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.cEC != null) {
      this.cEC.l(this.cED);
    }
    b localb;
    if (this.cEz != null)
    {
      localb = this.cEz;
      if (localb.mInited) {
        break label167;
      }
      new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePlayer");
    }
    for (;;)
    {
      this.cEz = null;
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      if (this.cED != null)
      {
        this.cED.Pu();
        this.cEE = null;
      }
      Log.i(getLogTag(), "LivePlayer release handler thread");
      if (this.cEP != null) {
        this.cEP.removeCallbacksAndMessages(null);
      }
      if (this.cEQ != null) {
        this.cEQ.quitSafely();
      }
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215572);
          Log.i(a.this.getLogTag(), "release, abandonFocus");
          a.this.cEM.bJJ();
          AppMethodBeat.o(215572);
        }
      });
      AppMethodBeat.o(138834);
      return;
      label167:
      localb.cFu.stopPlay(true);
      localb.cFu.setPlayListener(null);
      localb.mInited = false;
      new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a
 * JD-Core Version:    0.7.0.1
 */