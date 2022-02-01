package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.luggage.h.h;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.k;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements i, o
{
  private w crv;
  private HandlerThread csA;
  boolean csB;
  volatile boolean csC;
  AtomicBoolean csD;
  com.tencent.luggage.xweb_ext.extendplugin.component.a csE;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<d> csF;
  String csG;
  public s csH;
  public int csI;
  volatile boolean csJ;
  boolean csK;
  boolean csL;
  public boolean csM;
  private i csN;
  public AtomicBoolean csO;
  volatile String csP;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g csQ;
  volatile Bitmap csR;
  public b csk;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c csl;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b csm;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.a csn;
  public com.tencent.luggage.xweb_ext.extendplugin.a cso;
  a.a csp;
  public int csq;
  public int csr;
  public int css;
  public int cst;
  private boolean csu;
  boolean csv;
  boolean csw;
  com.tencent.mm.plugin.appbrand.jsapi.s.c csx;
  String csy;
  public Handler csz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public a()
  {
    AppMethodBeat.i(138827);
    this.css = 0;
    this.cst = 0;
    this.csx = null;
    this.csy = null;
    this.csB = false;
    this.csC = false;
    this.csD = null;
    this.crv = new a.5(this);
    this.csE = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.crv)
    {
      public final boolean FM()
      {
        return !a.this.csC;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(178802);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.FJ();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.crw = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.crx = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ae.d(a.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.crw + ", mIsAutoRotationEnabled: " + this.crx);
          AppMethodBeat.o(178802);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bu.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.crw = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.crw = false;
          }
        }
      }
    };
    this.csF = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private d csV = null;
      
      public final int getId()
      {
        AppMethodBeat.i(178804);
        int i = a.this.getId();
        AppMethodBeat.o(178804);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(178805);
        String str = a.this.getKey();
        AppMethodBeat.o(178805);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(178803);
        String str = a.this.getLogTag();
        AppMethodBeat.o(178803);
        return str;
      }
    };
    this.csG = "";
    this.csH = null;
    this.csI = -1;
    this.csJ = false;
    this.csK = false;
    this.csL = false;
    this.csM = false;
    this.csN = new r();
    this.csO = new AtomicBoolean(false);
    this.mTitle = null;
    this.csP = null;
    this.csQ = null;
    this.csR = null;
    this.csA = com.tencent.e.c.d.hg(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.csA.start();
    this.csz = new Handler(this.csA.getLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.Gg();
    this.csk = new b(ak.getContext());
    this.csk.mHandler = this.csz;
    this.csk.ctc = new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (a.this.Gj()) {
          a.this.csm.d(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (a.this.Gj()) {
          a.this.csm.a(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (a.this.csn != null) {
          a.this.csn.gJ(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138813);
          return;
          if (a.this.csH != null)
          {
            a.this.csH.Gc();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csI = 0;
          AppMethodBeat.o(138813);
          return;
          if (a.this.csH != null)
          {
            a.this.csH.Gd();
            a.this.csH.bA(a.this.csJ);
            AppMethodBeat.o(138813);
            return;
          }
          paramAnonymousBundle = a.this;
          if (a.this.csJ) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.csI = paramAnonymousInt;
            AppMethodBeat.o(138813);
            return;
          }
          if (a.this.csH != null)
          {
            a.this.csH.Ge();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csI = 7;
          AppMethodBeat.o(138813);
          return;
          if (a.this.csH != null)
          {
            a.this.csH.onStop();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csI = 6;
        }
      }
    };
    this.csk.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (a.this.csm != null) {
          a.this.csm.bW(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    };
    AppMethodBeat.o(138827);
  }
  
  private void Gi()
  {
    AppMethodBeat.i(138833);
    if ((this.csq != 0) && (this.csr != 0) && (this.mSurfaceTexture != null) && (this.csk != null))
    {
      ae.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.csq), Integer.valueOf(this.csr) });
      this.mSurfaceTexture.setDefaultBufferSize(this.csq, this.csr);
      if ((Gk()) && (this.csC))
      {
        ae.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.csk.bV(this.csq, this.csr);
    }
    AppMethodBeat.o(138833);
  }
  
  public final void FX()
  {
    AppMethodBeat.i(220444);
    if (this.csz != null) {
      this.csz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178807);
          if (a.this.csk != null)
          {
            a.this.csk.b("stop", null);
            a.this.dz("stop");
            b localb = a.this.csk;
            if (localb.ctc != null) {
              localb.ctc.onPlayEvent(6001, new Bundle());
            }
          }
          AppMethodBeat.o(178807);
        }
      });
    }
    AppMethodBeat.o(220444);
  }
  
  public final String FY()
  {
    AppMethodBeat.i(220445);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(220445);
    return str;
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(138829);
    if (this.csz != null) {
      this.csz.post(new a.19(this));
    }
    AppMethodBeat.o(138829);
  }
  
  final boolean Gj()
  {
    return this.csm != null;
  }
  
  final boolean Gk()
  {
    AppMethodBeat.i(220441);
    boolean bool = this.csF.d(this.cso);
    AppMethodBeat.o(220441);
    return bool;
  }
  
  public final void Gl()
  {
    AppMethodBeat.i(220446);
    if ((this.csk != null) && (!this.csk.ctb.isPlaying())) {
      dy("play");
    }
    AppMethodBeat.o(220446);
  }
  
  final boolean Gm()
  {
    AppMethodBeat.i(220448);
    if (this.cso == null)
    {
      ae.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(220448);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cso);
    if (locala == null)
    {
      ae.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(220448);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(220448);
    return bool;
  }
  
  public final <AddOn extends j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(220452);
    ae.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.csN.U(paramClass);
    AppMethodBeat.o(220452);
    return paramClass;
  }
  
  final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.csu = paramJSONObject.optBoolean("needEvent", false);
      if (Gj()) {
        this.csm.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(220451);
    ae.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.csN.a(paramClass, paramAddOn);
    AppMethodBeat.o(220451);
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220443);
    if (this.csk != null)
    {
      if (!this.csO.get()) {
        this.csk.bV(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(220443);
        return true;
        ae.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    ae.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(220443);
    return false;
  }
  
  public final void dy(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.csz != null) {
      this.csz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220429);
          a.this.csk.b(paramString, null);
          a.this.dz(paramString);
          AppMethodBeat.o(220429);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void dz(String paramString)
  {
    AppMethodBeat.i(220447);
    if (paramString.equalsIgnoreCase("pause"))
    {
      if (this.csH != null) {
        this.csH.onPause();
      }
      while (this.csn != null)
      {
        this.csn.gJ(2006);
        AppMethodBeat.o(220447);
        return;
        this.csI = 4;
      }
    }
    if (paramString.equalsIgnoreCase("stop"))
    {
      if (this.csH == null) {
        break label118;
      }
      this.csH.onStop();
    }
    for (;;)
    {
      if (this.csn != null) {
        this.csn.gJ(2006);
      }
      AppMethodBeat.o(220447);
      return;
      label118:
      this.csI = 6;
    }
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.csz != null) {
      this.csz.post(new Runnable()
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
    AppMethodBeat.i(220442);
    if (this.csk != null)
    {
      if (!this.csO.get()) {
        this.csk.f(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(220442);
        return true;
        ae.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    ae.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(220442);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  final void gG(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.csl != null) {
      this.csl.aK(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = BN() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", BN() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(220450);
    String str = getKey();
    AppMethodBeat.o(220450);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.csz != null) {
      this.csz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138819);
          a locala = a.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala1 = parama;
          String str = locala1.FK();
          Object localObject1;
          Object localObject2;
          int i;
          if (!bu.isNullOrNil(str))
          {
            localObject1 = locala1.FJ();
            ae.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.BN(), str, ((JSONObject)localObject1).toString() });
            new StringBuilder("handleJsApi:").append(str).append(", data:").append(localObject1);
            if (!str.contains("insert")) {
              break label1169;
            }
            locala.gG(1);
            localObject1 = locala1.FJ();
            if (((JSONObject)localObject1).optInt("mode", 0) != 2) {
              break label325;
            }
            locala.csK = true;
            localObject2 = locala1.getContext();
            if ((localObject2 instanceof Activity)) {
              break label258;
            }
            ae.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
            locala1.dw("fail:internal error invalid android context");
            i = 0;
            if (i != 0) {
              break label331;
            }
          }
          label215:
          label237:
          Object localObject3;
          for (;;)
          {
            locala.csE.a(str, locala1);
            localObject1 = locala1.FJ();
            if (localObject1 != null) {
              break label2898;
            }
            ae.w(locala.getLogTag(), "handleAutoPlay, null == dataJsonObj");
            localObject1 = locala1.FJ();
            if (localObject1 != null) {
              break label2918;
            }
            ae.w(locala.getLogTag(), "handlePlayerUrl, null == dataJsonObj");
            locala.csF.a(locala1, locala.csG);
            AppMethodBeat.o(138819);
            return;
            label258:
            if (h.n((Activity)localObject2, "android.permission.RECORD_AUDIO"))
            {
              i = 1;
              break;
            }
            localObject2 = new HashMap();
            ((Map)localObject2).put("errCode", Integer.valueOf(10001));
            ae.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
            locala1.f("fail:system permission denied", (Map)localObject2);
            i = 0;
            break;
            label325:
            locala.csK = false;
            label331:
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { locala1.getAppId() }));
            locala.cso = locala1;
            localObject2 = locala1.Eo();
            if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.page.z)) {
              if (!((com.tencent.mm.plugin.appbrand.page.z)localObject2).cla)
              {
                bool = true;
                label390:
                locala.csC = bool;
                label396:
                locala.csp = new a.21(locala);
                locala1.a(locala.csp);
                if (locala.csn != null) {
                  locala.csn.m(locala1);
                }
                locala.a(locala1, (JSONObject)localObject1);
                locala.i((JSONObject)localObject1);
                locala.csv = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
                locala.csw = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
                locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
                locala.csP = ((JSONObject)localObject1).optString("backgroundPoster", locala.csP);
                localObject2 = locala1.Eo();
                if (localObject2 != null) {
                  break label925;
                }
                ae.w(locala.getLogTag(), "updateReferrers, component is null");
                label540:
                if (locala.csy == null) {}
              }
            }
            Object localObject4;
            try
            {
              ((JSONObject)localObject1).put("referrer", locala.csy);
              if ((locala.csC) && (!locala.Gk())) {
                ae.i(locala.getLogTag(), "insert, webView in background");
              }
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                ((JSONObject)localObject1).put("canStartPlay", false);
                locala.csD = new AtomicBoolean(((JSONObject)localObject1).optBoolean("autoplay", false));
                localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.g((JSONObject)localObject1);
                localObject1 = locala.csk;
                if (((b)localObject1).ctc != null)
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
                  ((Bundle)localObject4).putLong("EVT_TIME", System.currentTimeMillis());
                  ((b)localObject1).ctc.onPlayEvent(-9999999, (Bundle)localObject4);
                }
                b.l("initLivePlayer", (Bundle)localObject2);
                ((b)localObject1).mVideoView = null;
                ((b)localObject1).csG = ((Bundle)localObject2).getString("playUrl", ((b)localObject1).csG);
                ((b)localObject1).cte = ((b)localObject1).n((Bundle)localObject2);
                ((b)localObject1).a((Bundle)localObject2, true);
                ((b)localObject1).csJ = ((Bundle)localObject2).getBoolean("autoplay", ((b)localObject1).csJ);
                if ((((Bundle)localObject2).getBoolean("canStartPlay", true)) && (((b)localObject1).csJ) && (((b)localObject1).csG != null) && (!((b)localObject1).csG.isEmpty()))
                {
                  ae.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                  ((b)localObject1).ctb.startPlay(((b)localObject1).csG, ((b)localObject1).cte);
                }
                ((b)localObject1).mInited = true;
                localObject4 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
                ae.i(locala.getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).csi });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode == 0)
                {
                  localObject1 = "ok";
                  locala1.dw((String)localObject1);
                  if ((((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode != 0) || (locala.csn == null)) {
                    continue;
                  }
                  locala.csn.a(locala1, (Bundle)localObject2);
                  continue;
                  bool = false;
                  break label390;
                  ae.w(locala.getLogTag(), "insert, component is not AppBrandPageView");
                  break label396;
                  label925:
                  localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
                  if (localObject4 == null)
                  {
                    ae.w(locala.getLogTag(), "updateReferrers, referrerHelper is null");
                    break label540;
                  }
                  if (locala.csx == null) {
                    locala.csx = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).bmX();
                  }
                  com.tencent.mm.plugin.appbrand.jsapi.s.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  if (localc != null) {
                    locala.csx = localc;
                  }
                  ae.i(locala.getLogTag(), "updateReferrers, mReferrerPolicy: " + locala.csx);
                  if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liO == locala.csx)
                  {
                    locala.csy = null;
                    break label540;
                  }
                  locala.csy = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  ae.i(locala.getLogTag(), "updateReferrers, mReferrer: " + locala.csy);
                  break label540;
                  localJSONException1 = localJSONException1;
                  ae.w(locala.getLogTag(), "insert, put referrer fail since " + localJSONException1.toString());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  ae.w(locala.getLogTag(), "insert, put isInForeground fail since " + localJSONException2.toString());
                  continue;
                  localObject1 = "fail";
                }
              }
            }
            label1169:
            if (str.contains("update"))
            {
              locala.gG(2);
              localObject1 = locala1.FJ();
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                locala.csv = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                locala.csw = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              }
              if (locala.csn != null) {
                locala.csn.m(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.csP = ((JSONObject)localObject1).optString("backgroundPoster", locala.csP);
              localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.g((JSONObject)localObject1);
              localObject3 = locala.csk;
              if (!((b)localObject3).mInited)
              {
                localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a(-3, "uninited livePlayer");
                label1339:
                ae.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).csi });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0) {
                  break label1709;
                }
              }
              label1709:
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.dw((String)localObject1);
                break;
                b.l("updateLivePlayer", (Bundle)localObject1);
                ((b)localObject3).a((Bundle)localObject1, false);
                bool = ((b)localObject3).ctb.isPlaying();
                localObject4 = ((Bundle)localObject1).getString("playUrl", ((b)localObject3).csG);
                if ((localObject4 != null) && (!((String)localObject4).isEmpty()) && (((b)localObject3).csG != null) && (!((b)localObject3).csG.equalsIgnoreCase((String)localObject4)) && (((b)localObject3).ctb.isPlaying()))
                {
                  ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject3).csG + " playUrl-new = " + (String)localObject4);
                  ((b)localObject3).ctb.stopPlay(true);
                }
                ((b)localObject3).csG = ((String)localObject4);
                i = ((b)localObject3).n((Bundle)localObject1);
                if ((i != ((b)localObject3).cte) && (((b)localObject3).ctb.isPlaying()))
                {
                  ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject3).cte + " playType-new = " + i);
                  ((b)localObject3).ctb.stopPlay(true);
                }
                ((b)localObject3).cte = i;
                ((b)localObject3).csJ = ((Bundle)localObject1).getBoolean("autoplay", ((b)localObject3).csJ);
                if (((((b)localObject3).csJ) || (bool)) && (((b)localObject3).csG != null) && (!((b)localObject3).csG.isEmpty()) && (!((b)localObject3).ctb.isPlaying()))
                {
                  ae.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                  ((b)localObject3).ctb.startPlay(((b)localObject3).csG, ((b)localObject3).cte);
                }
                localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
                break label1339;
              }
            }
            if ((str.contains("operate")) && (str.contains("Background")))
            {
              localObject1 = locala1.FJ().optString("type");
              ae.i(locala.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
              if ((!bu.isNullOrNil((String)localObject1)) && (locala.csk != null))
              {
                if (((String)localObject1).equals("stop"))
                {
                  locala.i(locala1);
                  if (locala.csB)
                  {
                    ae.i(locala.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    locala.csD = new AtomicBoolean(false);
                  }
                }
                else
                {
                  locala1.dw("fail");
                }
              }
              else {
                locala1.dw("fail");
              }
            }
            else
            {
              if (!str.contains("operate")) {
                break label2852;
              }
              locala.gG(3);
              localObject1 = locala1.FJ();
              localObject3 = ((JSONObject)localObject1).optString("type");
              ae.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject3 });
              if ((bu.isNullOrNil((String)localObject3)) || (locala.csk == null)) {
                break label2838;
              }
              if (((String)localObject3).equals("snapshot"))
              {
                locala.csk.ctd = new a.4(locala, locala1);
                localObject1 = locala.csk.b("snapshot", locala1.FJ());
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0)
                {
                  ae.i(locala.getLogTag(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode) });
                  locala1.dw("fail:snapshot error");
                }
                else
                {
                  ae.i(locala.getLogTag(), "operateSnapshot, success");
                }
              }
              else
              {
                if (((String)localObject3).equalsIgnoreCase("requestFullScreen"))
                {
                  if ((locala.csn != null) && (locala.csn.j(locala1)))
                  {
                    bool = true;
                    label2081:
                    ae.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2125;
                    }
                  }
                  label2125:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dw((String)localObject1);
                    break;
                    bool = false;
                    break label2081;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitFullScreen"))
                {
                  if ((locala.csn != null) && (locala.csn.k(locala1)))
                  {
                    bool = true;
                    label2168:
                    ae.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2212;
                    }
                  }
                  label2212:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dw((String)localObject1);
                    break;
                    bool = false;
                    break label2168;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitPictureInPicture"))
                {
                  bool = locala.csF.c(locala1);
                  ae.i(locala.getLogTag(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool) });
                  if (bool) {}
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.dw((String)localObject1);
                    break;
                  }
                }
                if (!((String)localObject3).equalsIgnoreCase("requestBackgroundPlayback")) {
                  break label2695;
                }
                ae.d(locala.getLogTag(), "enableBackgroundPlayAudio");
                if (locala.csK)
                {
                  ae.w(locala.getLogTag(), "enableBackgroundPlayAudio, mIsRTCMode");
                  locala1.dw("fail");
                }
                else
                {
                  if (!locala.csB) {
                    break label2378;
                  }
                  ae.w(locala.getLogTag(), "enableBackgroundPlayAudio, isRuntimeInBackground");
                  locala1.dw("fail");
                }
              }
            }
          }
          label2378:
          if (!locala.csL)
          {
            ae.d(locala.getLogTag(), "registerAddOnPlayAudio");
            locala.a(m.class, new a.11(locala));
            ae.d(locala.getLogTag(), "registerAddOnVideoController");
            locala.a(n.class, new a.13(locala));
            ae.d(locala.getLogTag(), "registerAddOnInfo");
            locala.a(l.class, new a.14(locala));
            ae.d(locala.getLogTag(), "registerAddOnGetSnapshot");
            locala.a(k.class, new a.17(locala));
            locala.csL = true;
          }
          ae.d(locala.getLogTag(), "enableBackgroundPlayAudioInternal");
          if (locala1 == null)
          {
            ae.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            bool = false;
            label2533:
            if (!bool) {
              break label2938;
            }
            if ((locala.csk != null) && (!locala.csk.ctb.isPlaying()))
            {
              locala.csO.set(true);
              locala.csk.f(null);
            }
            locala.csM = true;
            if (locala.csm != null) {
              locala.csm.r(locala.getId(), true);
            }
          }
          label2695:
          label2838:
          label2852:
          label2898:
          label2918:
          label2938:
          for (boolean bool = true;; bool = false)
          {
            ae.i(locala.getLogTag(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
            if (bool) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.dw((String)localObject1);
              break;
              localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala1);
              if (localObject1 == null)
              {
                ae.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                bool = false;
                break label2533;
              }
              bool = ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject1).b(locala);
              break label2533;
            }
            if (((String)localObject3).equalsIgnoreCase("exitBackgroundPlayback"))
            {
              locala.i(locala1);
              break;
            }
            if (locala.csk.b((String)localObject3, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.dw((String)localObject1);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) && (!((String)localObject3).equalsIgnoreCase("pause"))) {
                break;
              }
              locala.csF.b(locala1);
              locala.dz((String)localObject3);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) || (!locala.csB)) {
                break;
              }
              ae.i(locala.getLogTag(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
              locala.csD = new AtomicBoolean(false);
              break;
            }
            locala1.dw("fail");
            break;
            if (!str.contains("remove")) {
              break;
            }
            locala.gG(4);
            locala.release();
            locala1.dw("ok");
            locala.csF.b(locala1);
            break;
            locala.csJ = ((JSONObject)localObject1).optBoolean("autoplay", locala.csJ);
            break label215;
            locala.csG = ((JSONObject)localObject1).optString("playUrl", locala.csG);
            break label237;
          }
        }
      });
    }
    AppMethodBeat.o(138830);
    return null;
  }
  
  final void i(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220449);
    ae.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.csK)
    {
      ae.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.dw("fail");
      AppMethodBeat.o(220449);
      return;
    }
    ae.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ae.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label226;
      }
      this.csO.set(false);
      if (this.csk != null) {
        this.csk.f(this.mSurface);
      }
      this.csM = false;
      if (this.csm != null) {
        this.csm.r(getId(), false);
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      ae.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.dw((String)localObject);
        AppMethodBeat.o(220449);
        return;
        localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
        if (localObject == null)
        {
          ae.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject).c(this);
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
        this.csq = com.tencent.mm.plugin.appbrand.y.g.vO(paramJSONObject.optInt("width", 0));
        this.csr = com.tencent.mm.plugin.appbrand.y.g.vO(paramJSONObject.optInt("height", 0));
        ae.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.csq), Integer.valueOf(this.csr) });
        Gi();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.csn != null) {
      this.csn.l(this.cso);
    }
    b localb;
    if (this.csk != null)
    {
      localb = this.csk;
      if (localb.mInited) {
        break label150;
      }
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a(-3, "uninited livePlayer");
    }
    for (;;)
    {
      this.csk = null;
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      if (this.cso != null)
      {
        this.cso.FL();
        this.csp = null;
      }
      ae.i(getLogTag(), "LivePlayer release handler thread");
      if (this.csz != null) {
        this.csz.removeCallbacksAndMessages(null);
      }
      if (this.csA != null) {
        this.csA.quitSafely();
      }
      AppMethodBeat.o(138834);
      return;
      label150:
      localb.ctb.stopPlay(true);
      localb.ctb.setPlayListener(null);
      localb.mInited = false;
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a
 * JD-Core Version:    0.7.0.1
 */