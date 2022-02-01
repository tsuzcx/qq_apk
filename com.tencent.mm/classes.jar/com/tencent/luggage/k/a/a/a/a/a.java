package com.tencent.luggage.k.a.a.a.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.luggage.k.a.a.a;
import com.tencent.luggage.k.a.a.i;
import com.tencent.luggage.k.a.a.j;
import com.tencent.luggage.k.a.a.k;
import com.tencent.luggage.k.a.a.l;
import com.tencent.luggage.k.a.a.m;
import com.tencent.luggage.k.a.a.n;
import com.tencent.luggage.k.a.a.q;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  extends com.tencent.luggage.k.a.b.a
  implements com.tencent.luggage.k.a.a.h, n
{
  private w cjE;
  private boolean ckA;
  boolean ckB;
  boolean ckC;
  com.tencent.mm.plugin.appbrand.jsapi.q.c ckD;
  String ckE;
  public Handler ckF;
  private HandlerThread ckG;
  boolean ckH;
  volatile boolean ckI;
  AtomicBoolean ckJ;
  com.tencent.luggage.k.a.a.a ckK;
  com.tencent.luggage.k.a.a.b<d> ckL;
  String ckM;
  public r ckN;
  public int ckO;
  volatile boolean ckP;
  boolean ckQ;
  boolean ckR;
  public boolean ckS;
  private com.tencent.luggage.k.a.a.h ckT;
  public AtomicBoolean ckU;
  volatile String ckV;
  volatile com.tencent.luggage.k.a.a.g ckW;
  volatile Bitmap ckX;
  public b ckq;
  public com.tencent.luggage.k.a.a.a.a.a.c ckr;
  public com.tencent.luggage.k.a.a.a.a.a.b cks;
  public com.tencent.luggage.k.a.a.a.a.a.a ckt;
  public com.tencent.luggage.k.a.a cku;
  a.a ckv;
  public int ckw;
  public int ckx;
  public int cky;
  public int ckz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public a()
  {
    AppMethodBeat.i(138827);
    this.cky = 0;
    this.ckz = 0;
    this.ckD = null;
    this.ckE = null;
    this.ckH = false;
    this.ckI = false;
    this.ckJ = null;
    this.cjE = new a.5(this);
    this.ckK = new com.tencent.luggage.k.a.a.a(this, this.cjE)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.k.a.a paramAnonymousa)
      {
        AppMethodBeat.i(178802);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.EB();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cjF = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cjG = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ad.d(a.this.EE(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cjF + ", mIsAutoRotationEnabled: " + this.cjG);
          AppMethodBeat.o(178802);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.cjF = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cjF = false;
          }
        }
      }
    };
    this.ckL = new com.tencent.luggage.k.a.a.b()
    {
      private d clb = null;
      
      public final String EE()
      {
        AppMethodBeat.i(178803);
        String str = a.this.EE();
        AppMethodBeat.o(178803);
        return str;
      }
      
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
    };
    this.ckM = "";
    this.ckN = null;
    this.ckO = -1;
    this.ckP = false;
    this.ckQ = false;
    this.ckR = false;
    this.ckS = false;
    this.ckT = new q();
    this.ckU = new AtomicBoolean(false);
    this.mTitle = null;
    this.ckV = null;
    this.ckW = null;
    this.ckX = null;
    this.ckG = com.tencent.e.c.d.gv(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.ckG.start();
    this.ckF = new Handler(this.ckG.getLooper());
    com.tencent.luggage.k.a.a.a.b.EX();
    this.ckq = new b(aj.getContext());
    this.ckq.mHandler = this.ckF;
    this.ckq.cli = new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (a.this.Fa()) {
          a.this.cks.d(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (a.this.Fa()) {
          a.this.cks.a(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (a.this.ckt != null) {
          a.this.ckt.gT(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138813);
          return;
          if (a.this.ckN != null)
          {
            a.this.ckN.ET();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.ckO = 0;
          AppMethodBeat.o(138813);
          return;
          if (a.this.ckN != null)
          {
            a.this.ckN.EU();
            a.this.ckN.bB(a.this.ckP);
            AppMethodBeat.o(138813);
            return;
          }
          paramAnonymousBundle = a.this;
          if (a.this.ckP) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.ckO = paramAnonymousInt;
            AppMethodBeat.o(138813);
            return;
          }
          if (a.this.ckN != null)
          {
            a.this.ckN.EV();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.ckO = 7;
          AppMethodBeat.o(138813);
          return;
          if (a.this.ckN != null)
          {
            a.this.ckN.onStop();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.ckO = 6;
        }
      }
    };
    this.ckq.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (a.this.cks != null) {
          a.this.cks.bX(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    };
    AppMethodBeat.o(138827);
  }
  
  private void EZ()
  {
    AppMethodBeat.i(138833);
    if ((this.ckw != 0) && (this.ckx != 0) && (this.mSurfaceTexture != null) && (this.ckq != null))
    {
      ad.i(EE(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.ckw), Integer.valueOf(this.ckx) });
      this.mSurfaceTexture.setDefaultBufferSize(this.ckw, this.ckx);
      if ((Fb()) && (this.ckI))
      {
        ad.i(EE(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.ckq.bW(this.ckw, this.ckx);
    }
    AppMethodBeat.o(138833);
  }
  
  public final String EE()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", AL() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final void EO()
  {
    AppMethodBeat.i(194964);
    if (this.ckF != null) {
      this.ckF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178807);
          if (a.this.ckq != null)
          {
            a.this.ckq.b("stop", null);
            a.this.cG("stop");
            b localb = a.this.ckq;
            if (localb.cli != null) {
              localb.cli.onPlayEvent(6001, new Bundle());
            }
          }
          AppMethodBeat.o(178807);
        }
      });
    }
    AppMethodBeat.o(194964);
  }
  
  public final String EP()
  {
    AppMethodBeat.i(194965);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(194965);
    return str;
  }
  
  public final void EY()
  {
    AppMethodBeat.i(138829);
    if (this.ckF != null) {
      this.ckF.post(new Runnable()
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
  
  final boolean Fa()
  {
    return this.cks != null;
  }
  
  final boolean Fb()
  {
    AppMethodBeat.i(194961);
    boolean bool = this.ckL.e(this.cku);
    AppMethodBeat.o(194961);
    return bool;
  }
  
  public final void Fc()
  {
    AppMethodBeat.i(194966);
    if ((this.ckq != null) && (!this.ckq.clh.isPlaying())) {
      cF("play");
    }
    AppMethodBeat.o(194966);
  }
  
  final boolean Fd()
  {
    AppMethodBeat.i(194968);
    if (this.cku == null)
    {
      ad.w(EE(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(194968);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = com.tencent.luggage.k.a.a.e.g(this.cku);
    if (locala == null)
    {
      ad.w(EE(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(194968);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(194968);
    return bool;
  }
  
  public final <AddOn extends i> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(194972);
    ad.i(EE(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.ckT.U(paramClass);
    AppMethodBeat.o(194972);
    return paramClass;
  }
  
  final void a(com.tencent.luggage.k.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.ckA = paramJSONObject.optBoolean("needEvent", false);
      if (Fa()) {
        this.cks.n(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  public final <AddOn extends i> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(194971);
    ad.i(EE(), "setAddOn for " + paramClass.getSimpleName());
    this.ckT.a(paramClass, paramAddOn);
    AppMethodBeat.o(194971);
  }
  
  public final boolean bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194963);
    if (this.ckq != null)
    {
      if (!this.ckU.get()) {
        this.ckq.bW(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(194963);
        return true;
        ad.i(EE(), "setSurfaceSize, JustPlayAudio");
      }
    }
    ad.w(EE(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(194963);
    return false;
  }
  
  public final void cF(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.ckF != null) {
      this.ckF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194949);
          a.this.ckq.b(paramString, null);
          a.this.cG(paramString);
          AppMethodBeat.o(194949);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void cG(String paramString)
  {
    AppMethodBeat.i(194967);
    if (paramString.equalsIgnoreCase("pause"))
    {
      if (this.ckN != null) {
        this.ckN.onPause();
      }
      while (this.ckt != null)
      {
        this.ckt.gT(2006);
        AppMethodBeat.o(194967);
        return;
        this.ckO = 4;
      }
    }
    if (paramString.equalsIgnoreCase("stop"))
    {
      if (this.ckN == null) {
        break label118;
      }
      this.ckN.onStop();
    }
    for (;;)
    {
      if (this.ckt != null) {
        this.ckt.gT(2006);
      }
      AppMethodBeat.o(194967);
      return;
      label118:
      this.ckO = 6;
    }
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.ckF != null) {
      this.ckF.post(new Runnable()
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
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(194962);
    if (this.ckq != null)
    {
      if (!this.ckU.get()) {
        this.ckq.g(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(194962);
        return true;
        ad.i(EE(), "setSurface, JustPlayAudio");
      }
    }
    ad.w(EE(), "setSurface, Adapter is null");
    AppMethodBeat.o(194962);
    return false;
  }
  
  final void gQ(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.ckr != null) {
      this.ckr.aO(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = AL() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(194970);
    String str = getKey();
    AppMethodBeat.o(194970);
    return str;
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String i(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.ckF != null) {
      this.ckF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138819);
          a locala = a.this;
          com.tencent.luggage.k.a.a locala1 = parama;
          String str = locala1.EC();
          Object localObject1;
          Object localObject2;
          int i;
          if (!bt.isNullOrNil(str))
          {
            localObject1 = locala1.EB();
            ad.i(locala.EE(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.AL(), str, ((JSONObject)localObject1).toString() });
            new StringBuilder("handleJsApi:").append(str).append(", data:").append(localObject1);
            if (!str.contains("insert")) {
              break label1135;
            }
            locala.gQ(1);
            localObject1 = locala1.EB();
            if (((JSONObject)localObject1).optInt("mode", 0) != 2) {
              break label325;
            }
            locala.ckQ = true;
            localObject2 = locala1.getContext();
            if ((localObject2 instanceof Activity)) {
              break label258;
            }
            ad.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
            locala1.cD("fail:internal error invalid android context");
            i = 0;
            if (i != 0) {
              break label331;
            }
          }
          label215:
          label237:
          label891:
          Object localObject3;
          label258:
          label390:
          label1673:
          for (;;)
          {
            locala.ckK.a(str, locala1);
            localObject1 = locala1.EB();
            if (localObject1 != null) {
              break label2897;
            }
            ad.w(locala.EE(), "handleAutoPlay, null == dataJsonObj");
            localObject1 = locala1.EB();
            if (localObject1 != null) {
              break label2935;
            }
            ad.w(locala.EE(), "handlePlayerUrl, null == dataJsonObj");
            locala.ckL.a(locala1, locala.ckM);
            AppMethodBeat.o(138819);
            return;
            if (com.tencent.luggage.h.h.o((Activity)localObject2, "android.permission.RECORD_AUDIO"))
            {
              i = 1;
              break;
            }
            localObject2 = new HashMap();
            ((Map)localObject2).put("errCode", Integer.valueOf(10001));
            ad.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
            locala1.d("fail:system permission denied", (Map)localObject2);
            i = 0;
            break;
            label325:
            locala.ckQ = false;
            label331:
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { locala1.getAppId() }));
            locala.cku = locala1;
            localObject2 = locala1.Dj();
            if ((localObject2 instanceof aa))
            {
              if (!((aa)localObject2).cdK)
              {
                bool = true;
                locala.ckI = bool;
              }
            }
            else
            {
              locala.ckv = new a.21(locala);
              locala1.a(locala.ckv);
              if (locala.ckt != null) {
                locala.ckt.n(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.ckB = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              locala.ckC = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.ckV = ((JSONObject)localObject1).optString("backgroundPoster", locala.ckV);
              localObject2 = locala1.Dj();
              if (localObject2 != null) {
                break label891;
              }
              ad.w(locala.EE(), "updateReferrers, component is null");
              label539:
              if (locala.ckE == null) {}
            }
            Object localObject4;
            try
            {
              ((JSONObject)localObject1).put("referrer", locala.ckE);
              if (!locala.ckI) {}
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                ((JSONObject)localObject1).put("isInForeground", false);
                locala.ckJ = new AtomicBoolean(((JSONObject)localObject1).optBoolean("autoplay", false));
                localObject2 = com.tencent.luggage.k.a.a.a.c.g((JSONObject)localObject1);
                localObject1 = locala.ckq;
                if (((b)localObject1).cli != null)
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
                  ((Bundle)localObject4).putLong("EVT_TIME", System.currentTimeMillis());
                  ((b)localObject1).cli.onPlayEvent(-9999999, (Bundle)localObject4);
                }
                b.l("initLivePlayer", (Bundle)localObject2);
                ((b)localObject1).mVideoView = null;
                ((b)localObject1).ckM = ((Bundle)localObject2).getString("playUrl", ((b)localObject1).ckM);
                ((b)localObject1).clk = ((b)localObject1).n((Bundle)localObject2);
                ((b)localObject1).a((Bundle)localObject2, true);
                ((b)localObject1).ckP = ((Bundle)localObject2).getBoolean("autoplay", ((b)localObject1).ckP);
                if ((((Bundle)localObject2).getBoolean("isInForeground", true)) && (((b)localObject1).ckP) && (((b)localObject1).ckM != null) && (!((b)localObject1).ckM.isEmpty()))
                {
                  ad.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                  ((b)localObject1).clh.startPlay(((b)localObject1).ckM, ((b)localObject1).clk);
                }
                ((b)localObject1).mInited = true;
                localObject4 = new com.tencent.luggage.k.a.a.a.a();
                ad.i(locala.EE(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject4).cko });
                if (((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode == 0)
                {
                  localObject1 = "ok";
                  locala1.cD((String)localObject1);
                  if ((((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode != 0) || (locala.ckt == null)) {
                    continue;
                  }
                  locala.ckt.a(locala1, (Bundle)localObject2);
                  continue;
                  bool = false;
                  break label390;
                  localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
                  if (localObject4 == null)
                  {
                    ad.w(locala.EE(), "updateReferrers, referrerHelper is null");
                    break label539;
                  }
                  if (locala.ckD == null) {
                    locala.ckD = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject4).bbJ();
                  }
                  com.tencent.mm.plugin.appbrand.jsapi.q.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject4).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  if (localc != null) {
                    locala.ckD = localc;
                  }
                  ad.i(locala.EE(), "updateReferrers, mReferrerPolicy: " + locala.ckD);
                  if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khR == locala.ckD)
                  {
                    locala.ckE = null;
                    break label539;
                  }
                  locala.ckE = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject4).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  ad.i(locala.EE(), "updateReferrers, mReferrer: " + locala.ckE);
                  break label539;
                  localJSONException1 = localJSONException1;
                  ad.w(locala.EE(), "insert, put referrer fail since " + localJSONException1.toString());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  ad.w(locala.EE(), "insert, put isInForeground fail since " + localJSONException2.toString());
                  continue;
                  localObject1 = "fail";
                }
              }
            }
            label1135:
            if (str.contains("update"))
            {
              locala.gQ(2);
              localObject1 = locala1.EB();
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                locala.ckB = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                locala.ckC = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              }
              if (locala.ckt != null) {
                locala.ckt.n(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.ckV = ((JSONObject)localObject1).optString("backgroundPoster", locala.ckV);
              localObject1 = com.tencent.luggage.k.a.a.a.c.g((JSONObject)localObject1);
              localObject3 = locala.ckq;
              if (!((b)localObject3).mInited)
              {
                localObject1 = new com.tencent.luggage.k.a.a.a.a(-3, "uninited livePlayer");
                ad.i(locala.EE(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject1).cko });
                if (((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode != 0) {
                  break label1673;
                }
              }
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.cD((String)localObject1);
                break;
                b.l("updateLivePlayer", (Bundle)localObject1);
                ((b)localObject3).a((Bundle)localObject1, false);
                bool = ((b)localObject3).clh.isPlaying();
                localObject4 = ((Bundle)localObject1).getString("playUrl", ((b)localObject3).ckM);
                if ((localObject4 != null) && (!((String)localObject4).isEmpty()) && (((b)localObject3).ckM != null) && (!((b)localObject3).ckM.equalsIgnoreCase((String)localObject4)) && (((b)localObject3).clh.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject3).ckM + " playUrl-new = " + (String)localObject4);
                  ((b)localObject3).clh.stopPlay(true);
                }
                ((b)localObject3).ckM = ((String)localObject4);
                i = ((b)localObject3).n((Bundle)localObject1);
                if ((i != ((b)localObject3).clk) && (((b)localObject3).clh.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject3).clk + " playType-new = " + i);
                  ((b)localObject3).clh.stopPlay(true);
                }
                ((b)localObject3).clk = i;
                ((b)localObject3).ckP = ((Bundle)localObject1).getBoolean("autoplay", ((b)localObject3).ckP);
                if (((((b)localObject3).ckP) || (bool)) && (((b)localObject3).ckM != null) && (!((b)localObject3).ckM.isEmpty()) && (!((b)localObject3).clh.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                  ((b)localObject3).clh.startPlay(((b)localObject3).ckM, ((b)localObject3).clk);
                }
                localObject1 = new com.tencent.luggage.k.a.a.a.a();
                break label1303;
              }
            }
            label1303:
            if ((str.contains("operate")) && (str.contains("Background")))
            {
              localObject1 = locala1.EB().optString("type");
              ad.i(locala.EE(), "operateBackground, type:%s", new Object[] { localObject1 });
              if ((!bt.isNullOrNil((String)localObject1)) && (locala.ckq != null))
              {
                if (((String)localObject1).equals("stop"))
                {
                  locala.j(locala1);
                  if (locala.ckH)
                  {
                    ad.i(locala.EE(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    locala.ckJ = new AtomicBoolean(false);
                  }
                }
                else
                {
                  locala1.cD("fail");
                }
              }
              else {
                locala1.cD("fail");
              }
            }
            else
            {
              if (!str.contains("operate")) {
                break label2851;
              }
              locala.gQ(3);
              localObject1 = locala1.EB();
              localObject3 = ((JSONObject)localObject1).optString("type");
              ad.i(locala.EE(), "operate, type:%s", new Object[] { localObject3 });
              if ((bt.isNullOrNil((String)localObject3)) || (locala.ckq == null)) {
                break label2837;
              }
              if (((String)localObject3).equals("snapshot"))
              {
                locala.ckq.clj = new a.4(locala, locala1);
                localObject1 = locala.ckq.b("snapshot", locala1.EB());
                if (((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode != 0)
                {
                  ad.i(locala.EE(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode) });
                  locala1.cD("fail:snapshot error");
                }
                else
                {
                  ad.i(locala.EE(), "operateSnapshot, success");
                }
              }
              else
              {
                if (((String)localObject3).equalsIgnoreCase("requestFullScreen"))
                {
                  if ((locala.ckt != null) && (locala.ckt.k(locala1)))
                  {
                    bool = true;
                    label2045:
                    ad.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2089;
                    }
                  }
                  label2089:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cD((String)localObject1);
                    break;
                    bool = false;
                    break label2045;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitFullScreen"))
                {
                  if ((locala.ckt != null) && (locala.ckt.l(locala1)))
                  {
                    bool = true;
                    label2132:
                    ad.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2176;
                    }
                  }
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cD((String)localObject1);
                    break;
                    bool = false;
                    break label2132;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitPictureInPicture"))
                {
                  bool = locala.ckL.d(locala1);
                  ad.i(locala.EE(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool) });
                  if (bool) {}
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cD((String)localObject1);
                    break;
                  }
                }
                if (!((String)localObject3).equalsIgnoreCase("requestBackgroundPlayback")) {
                  break label2659;
                }
                ad.d(locala.EE(), "enableBackgroundPlayAudio");
                if (locala.ckQ)
                {
                  ad.w(locala.EE(), "enableBackgroundPlayAudio, mIsRTCMode");
                  locala1.cD("fail");
                }
                else
                {
                  if (!locala.ckH) {
                    break label2342;
                  }
                  ad.w(locala.EE(), "enableBackgroundPlayAudio, isRuntimeInBackground");
                  locala1.cD("fail");
                }
              }
            }
          }
          label2176:
          label2342:
          if (!locala.ckR)
          {
            ad.d(locala.EE(), "registerAddOnPlayAudio");
            locala.a(l.class, new a.11(locala));
            ad.d(locala.EE(), "registerAddOnVideoController");
            locala.a(m.class, new a.13(locala));
            ad.d(locala.EE(), "registerAddOnInfo");
            locala.a(k.class, new a.14(locala));
            ad.d(locala.EE(), "registerAddOnGetSnapshot");
            locala.a(j.class, new a.17(locala));
            locala.ckR = true;
          }
          ad.d(locala.EE(), "enableBackgroundPlayAudioInternal");
          if (locala1 == null)
          {
            ad.w(locala.EE(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            bool = false;
            label2497:
            if (!bool) {
              break label2955;
            }
            if ((locala.ckq != null) && (!locala.ckq.clh.isPlaying()))
            {
              locala.ckU.set(true);
              locala.ckq.g(null);
            }
            locala.ckS = true;
            if (locala.cks != null) {
              locala.cks.s(locala.getId(), true);
            }
          }
          label2955:
          for (boolean bool = true;; bool = false)
          {
            ad.i(locala.EE(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
            if (bool) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.cD((String)localObject1);
              break;
              localObject1 = com.tencent.luggage.k.a.a.e.g(locala1);
              if (localObject1 == null)
              {
                ad.w(locala.EE(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                bool = false;
                break label2497;
              }
              bool = ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)localObject1).b(locala);
              break label2497;
            }
            label2659:
            if (((String)localObject3).equalsIgnoreCase("exitBackgroundPlayback"))
            {
              locala.j(locala1);
              break;
            }
            if (locala.ckq.b((String)localObject3, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.cD((String)localObject1);
              if ((!((String)localObject3).equalsIgnoreCase("play")) && (!((String)localObject3).equalsIgnoreCase("resume"))) {
                break label2752;
              }
              locala.ckL.b(locala1);
              break;
            }
            label2752:
            if ((!((String)localObject3).equalsIgnoreCase("stop")) && (!((String)localObject3).equalsIgnoreCase("pause"))) {
              break;
            }
            locala.ckL.c(locala1);
            locala.cG((String)localObject3);
            if ((!((String)localObject3).equalsIgnoreCase("stop")) || (!locala.ckH)) {
              break;
            }
            ad.i(locala.EE(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
            locala.ckJ = new AtomicBoolean(false);
            break;
            label2837:
            locala1.cD("fail");
            break;
            label2851:
            if (!str.contains("remove")) {
              break;
            }
            locala.gQ(4);
            locala.release();
            locala1.cD("ok");
            locala.ckL.c(locala1);
            break;
            label2897:
            locala.ckP = ((JSONObject)localObject1).optBoolean("autoplay", locala.ckP);
            if (!locala.ckP) {
              break label215;
            }
            locala.ckL.b(locala1);
            break label215;
            label2935:
            locala.ckM = ((JSONObject)localObject1).optString("playUrl", locala.ckM);
            break label237;
          }
        }
      });
    }
    AppMethodBeat.o(138830);
    return null;
  }
  
  final void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138832);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.ckw = com.tencent.mm.plugin.appbrand.aa.g.um(paramJSONObject.optInt("width", 0));
        this.ckx = com.tencent.mm.plugin.appbrand.aa.g.um(paramJSONObject.optInt("height", 0));
        ad.i(EE(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.ckw), Integer.valueOf(this.ckx) });
        EZ();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  final void j(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(194969);
    ad.d(EE(), "disableBackgroundPlayAudio");
    if (this.ckQ)
    {
      ad.w(EE(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.cD("fail");
      AppMethodBeat.o(194969);
      return;
    }
    ad.d(EE(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ad.w(EE(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label226;
      }
      this.ckU.set(false);
      if (this.ckq != null) {
        this.ckq.g(this.mSurface);
      }
      this.ckS = false;
      if (this.cks != null) {
        this.cks.s(getId(), false);
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      ad.i(EE(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.cD((String)localObject);
        AppMethodBeat.o(194969);
        return;
        localObject = com.tencent.luggage.k.a.a.e.g(parama);
        if (localObject == null)
        {
          ad.w(EE(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)localObject).c(this);
        i = 1;
        break;
      }
    }
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.ckt != null) {
      this.ckt.m(this.cku);
    }
    b localb;
    if (this.ckq != null)
    {
      localb = this.ckq;
      if (localb.mInited) {
        break label150;
      }
      new com.tencent.luggage.k.a.a.a.a(-3, "uninited livePlayer");
    }
    for (;;)
    {
      this.ckq = null;
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      if (this.cku != null)
      {
        this.cku.ED();
        this.ckv = null;
      }
      ad.i(EE(), "LivePlayer release handler thread");
      if (this.ckF != null) {
        this.ckF.removeCallbacksAndMessages(null);
      }
      if (this.ckG != null) {
        this.ckG.quitSafely();
      }
      AppMethodBeat.o(138834);
      return;
      label150:
      localb.clh.stopPlay(true);
      localb.clh.setPlayListener(null);
      localb.mInited = false;
      new com.tencent.luggage.k.a.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */