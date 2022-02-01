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
import com.tencent.luggage.k.a.a.n;
import com.tencent.luggage.k.a.a.p;
import com.tencent.luggage.k.a.a.q;
import com.tencent.luggage.k.a.a.r;
import com.tencent.luggage.k.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements k, p
{
  private w cgA;
  boolean chA;
  boolean chB;
  com.tencent.mm.plugin.appbrand.jsapi.p.c chC;
  String chD;
  public Handler chE;
  private HandlerThread chF;
  boolean chG;
  volatile boolean chH;
  AtomicBoolean chI;
  private p chK;
  com.tencent.luggage.k.a.a.a chM;
  com.tencent.luggage.k.a.a.b<d> chN;
  String chO;
  public n chP;
  public int chQ;
  volatile boolean chR;
  boolean chS;
  boolean chT;
  public boolean chU;
  public AtomicBoolean chW;
  volatile String chX;
  volatile com.tencent.luggage.k.a.a.g chY;
  volatile Bitmap chZ;
  public b chp;
  public com.tencent.luggage.k.a.a.a.a.a.c chq;
  public com.tencent.luggage.k.a.a.a.a.a.b chr;
  public com.tencent.luggage.k.a.a.a.a.a.a chs;
  public com.tencent.luggage.k.a.a cht;
  a.a chu;
  public int chv;
  public int chw;
  public int chx;
  public int chy;
  private boolean chz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public a()
  {
    AppMethodBeat.i(138827);
    this.chx = 0;
    this.chy = 0;
    this.chC = null;
    this.chD = null;
    this.chG = false;
    this.chH = false;
    this.chI = null;
    this.cgA = new w()
    {
      private u chL;
      
      public final u EK()
      {
        return this.chL;
      }
    };
    this.chM = new com.tencent.luggage.k.a.a.a(this, this.cgA)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.k.a.a paramAnonymousa)
      {
        AppMethodBeat.i(178802);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.Ee();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cgB = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cgC = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ac.d(a.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cgB + ", mIsAutoRotationEnabled: " + this.cgC);
          AppMethodBeat.o(178802);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bs.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.cgB = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cgB = false;
          }
        }
      }
    };
    this.chN = new com.tencent.luggage.k.a.a.b()
    {
      private d chV = null;
      
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
    this.chO = "";
    this.chP = null;
    this.chQ = -1;
    this.chR = false;
    this.chS = false;
    this.chT = false;
    this.chU = false;
    this.chK = new s();
    this.chW = new AtomicBoolean(false);
    this.mTitle = null;
    this.chX = null;
    this.chY = null;
    this.chZ = null;
    this.chF = com.tencent.e.c.d.gz(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.chF.start();
    this.chE = new Handler(this.chF.getLooper());
    com.tencent.luggage.k.a.a.a.b.EB();
    this.chp = new b(ai.getContext());
    this.chp.mHandler = this.chE;
    this.chp.cik = new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (a.this.EE()) {
          a.this.chr.d(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (a.this.EE()) {
          a.this.chr.a(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (a.this.chs != null) {
          a.this.chs.gD(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138813);
          return;
          if (a.this.chP != null)
          {
            a.this.chP.Ex();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.chQ = 0;
          AppMethodBeat.o(138813);
          return;
          if (a.this.chP != null)
          {
            a.this.chP.Ey();
            a.this.chP.bA(a.this.chR);
            AppMethodBeat.o(138813);
            return;
          }
          paramAnonymousBundle = a.this;
          if (a.this.chR) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.chQ = paramAnonymousInt;
            AppMethodBeat.o(138813);
            return;
          }
          if (a.this.chP != null)
          {
            a.this.chP.Ez();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.chQ = 7;
          AppMethodBeat.o(138813);
          return;
          if (a.this.chP != null)
          {
            a.this.chP.onStop();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.chQ = 6;
        }
      }
    };
    this.chp.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (a.this.chr != null) {
          a.this.chr.bU(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    };
    AppMethodBeat.o(138827);
  }
  
  private void ED()
  {
    AppMethodBeat.i(138833);
    if ((this.chv != 0) && (this.chw != 0) && (this.mSurfaceTexture != null) && (this.chp != null))
    {
      ac.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.chv), Integer.valueOf(this.chw) });
      this.mSurfaceTexture.setDefaultBufferSize(this.chv, this.chw);
      if ((EG()) && (this.chH))
      {
        ac.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.chp.bT(this.chv, this.chw);
    }
    AppMethodBeat.o(138833);
  }
  
  public final void EC()
  {
    AppMethodBeat.i(138829);
    if (this.chE != null) {
      this.chE.post(new Runnable()
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
  
  final boolean EE()
  {
    return this.chr != null;
  }
  
  final boolean EG()
  {
    AppMethodBeat.i(206562);
    boolean bool = this.chN.d(this.cht);
    AppMethodBeat.o(206562);
    return bool;
  }
  
  public final void EH()
  {
    AppMethodBeat.i(206567);
    if ((this.chp != null) && (!this.chp.cij.isPlaying())) {
      cu("play");
    }
    AppMethodBeat.o(206567);
  }
  
  final boolean EI()
  {
    AppMethodBeat.i(206569);
    if (this.cht == null)
    {
      ac.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(206569);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala = com.tencent.luggage.k.a.a.e.f(this.cht);
    if (locala == null)
    {
      ac.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(206569);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(206569);
    return bool;
  }
  
  public final void Es()
  {
    AppMethodBeat.i(206565);
    if (this.chE != null) {
      this.chE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178807);
          if (a.this.chp != null)
          {
            a.this.chp.b("stop", null);
            a.this.cv("stop");
            b localb = a.this.chp;
            if (localb.cik != null) {
              localb.cik.onPlayEvent(6001, new Bundle());
            }
          }
          AppMethodBeat.o(178807);
        }
      });
    }
    AppMethodBeat.o(206565);
  }
  
  public final String Et()
  {
    AppMethodBeat.i(206566);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(206566);
    return str;
  }
  
  public final <AddOn extends q> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(210420);
    ac.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.chK.U(paramClass);
    AppMethodBeat.o(210420);
    return paramClass;
  }
  
  final void a(com.tencent.luggage.k.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.chz = paramJSONObject.optBoolean("needEvent", false);
      if (EE()) {
        this.chr.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  public final <AddOn extends q> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(210419);
    ac.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.chK.a(paramClass, paramAddOn);
    AppMethodBeat.o(210419);
  }
  
  public final boolean bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206564);
    if (this.chp != null)
    {
      if (!this.chW.get()) {
        this.chp.bT(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(206564);
        return true;
        ac.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    ac.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(206564);
    return false;
  }
  
  public final void cu(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.chE != null) {
      this.chE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206540);
          a.this.chp.b(paramString, null);
          a.this.cv(paramString);
          AppMethodBeat.o(206540);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void cv(String paramString)
  {
    AppMethodBeat.i(206568);
    if (paramString.equalsIgnoreCase("pause"))
    {
      if (this.chP != null) {
        this.chP.onPause();
      }
      while (this.chs != null)
      {
        this.chs.gD(2006);
        AppMethodBeat.o(206568);
        return;
        this.chQ = 4;
      }
    }
    if (paramString.equalsIgnoreCase("stop"))
    {
      if (this.chP == null) {
        break label118;
      }
      this.chP.onStop();
    }
    for (;;)
    {
      if (this.chs != null) {
        this.chs.gD(2006);
      }
      AppMethodBeat.o(206568);
      return;
      label118:
      this.chQ = 6;
    }
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.chE != null) {
      this.chE.post(new Runnable()
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
    AppMethodBeat.i(206563);
    if (this.chp != null)
    {
      if (!this.chW.get()) {
        this.chp.f(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(206563);
        return true;
        ac.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    ac.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(206563);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  final void gA(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.chq != null) {
      this.chq.aK(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = Ap() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", Ap() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(206571);
    String str = getKey();
    AppMethodBeat.o(206571);
    return str;
  }
  
  public final String h(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.chE != null) {
      this.chE.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138819);
          a locala = a.this;
          com.tencent.luggage.k.a.a locala1 = parama;
          String str = locala1.Ef();
          Object localObject1;
          Object localObject2;
          int i;
          if (!bs.isNullOrNil(str))
          {
            localObject1 = locala1.Ee();
            ac.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.Ap(), str, ((JSONObject)localObject1).toString() });
            new StringBuilder("handleJsApi:").append(str).append(", data:").append(localObject1);
            if (!str.contains("insert")) {
              break label1161;
            }
            locala.gA(1);
            localObject1 = locala1.Ee();
            if (((JSONObject)localObject1).optInt("mode", 0) != 2) {
              break label325;
            }
            locala.chS = true;
            localObject2 = locala1.getContext();
            if ((localObject2 instanceof Activity)) {
              break label258;
            }
            ac.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
            locala1.cs("fail:internal error invalid android context");
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
            locala.chM.a(str, locala1);
            localObject1 = locala1.Ee();
            if (localObject1 != null) {
              break label2890;
            }
            ac.w(locala.getLogTag(), "handleAutoPlay, null == dataJsonObj");
            localObject1 = locala1.Ee();
            if (localObject1 != null) {
              break label2910;
            }
            ac.w(locala.getLogTag(), "handlePlayerUrl, null == dataJsonObj");
            locala.chN.a(locala1, locala.chO);
            AppMethodBeat.o(138819);
            return;
            label258:
            if (com.tencent.luggage.h.h.o((Activity)localObject2, "android.permission.RECORD_AUDIO"))
            {
              i = 1;
              break;
            }
            localObject2 = new HashMap();
            ((Map)localObject2).put("errCode", Integer.valueOf(10001));
            ac.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
            locala1.d("fail:system permission denied", (Map)localObject2);
            i = 0;
            break;
            label325:
            locala.chS = false;
            label331:
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { locala1.getAppId() }));
            locala.cht = locala1;
            localObject2 = locala1.CM();
            if ((localObject2 instanceof aa)) {
              if (!((aa)localObject2).caH)
              {
                bool = true;
                label390:
                locala.chH = bool;
                label396:
                locala.chu = new a.22(locala);
                locala1.a(locala.chu);
                if (locala.chs != null) {
                  locala.chs.m(locala1);
                }
                locala.a(locala1, (JSONObject)localObject1);
                locala.i((JSONObject)localObject1);
                locala.chA = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
                locala.chB = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
                locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
                locala.chX = ((JSONObject)localObject1).optString("backgroundPoster", locala.chX);
                localObject2 = locala1.CM();
                if (localObject2 != null) {
                  break label917;
                }
                ac.w(locala.getLogTag(), "updateReferrers, component is null");
                label540:
                if (locala.chD == null) {}
              }
            }
            Object localObject4;
            try
            {
              ((JSONObject)localObject1).put("referrer", locala.chD);
              if (locala.chH) {
                ac.i(locala.getLogTag(), "insert, webView in background");
              }
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                ((JSONObject)localObject1).put("isInForeground", false);
                locala.chI = new AtomicBoolean(((JSONObject)localObject1).optBoolean("autoplay", false));
                localObject2 = com.tencent.luggage.k.a.a.a.c.g((JSONObject)localObject1);
                localObject1 = locala.chp;
                if (((b)localObject1).cik != null)
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
                  ((Bundle)localObject4).putLong("EVT_TIME", System.currentTimeMillis());
                  ((b)localObject1).cik.onPlayEvent(-9999999, (Bundle)localObject4);
                }
                b.l("initLivePlayer", (Bundle)localObject2);
                ((b)localObject1).mVideoView = null;
                ((b)localObject1).chO = ((Bundle)localObject2).getString("playUrl", ((b)localObject1).chO);
                ((b)localObject1).cim = ((b)localObject1).n((Bundle)localObject2);
                ((b)localObject1).a((Bundle)localObject2, true);
                ((b)localObject1).chR = ((Bundle)localObject2).getBoolean("autoplay", ((b)localObject1).chR);
                if ((((Bundle)localObject2).getBoolean("isInForeground", true)) && (((b)localObject1).chR) && (((b)localObject1).chO != null) && (!((b)localObject1).chO.isEmpty()))
                {
                  ac.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                  ((b)localObject1).cij.startPlay(((b)localObject1).chO, ((b)localObject1).cim);
                }
                ((b)localObject1).mInited = true;
                localObject4 = new com.tencent.luggage.k.a.a.a.a();
                ac.i(locala.getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject4).chn });
                if (((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode == 0)
                {
                  localObject1 = "ok";
                  locala1.cs((String)localObject1);
                  if ((((com.tencent.luggage.k.a.a.a.a)localObject4).errorCode != 0) || (locala.chs == null)) {
                    continue;
                  }
                  locala.chs.a(locala1, (Bundle)localObject2);
                  continue;
                  bool = false;
                  break label390;
                  ac.w(locala.getLogTag(), "insert, component is not AppBrandPageView");
                  break label396;
                  label917:
                  localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
                  if (localObject4 == null)
                  {
                    ac.w(locala.getLogTag(), "updateReferrers, referrerHelper is null");
                    break label540;
                  }
                  if (locala.chC == null) {
                    locala.chC = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject4).biC();
                  }
                  com.tencent.mm.plugin.appbrand.jsapi.p.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject4).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  if (localc != null) {
                    locala.chC = localc;
                  }
                  ac.i(locala.getLogTag(), "updateReferrers, mReferrerPolicy: " + locala.chC);
                  if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ == locala.chC)
                  {
                    locala.chD = null;
                    break label540;
                  }
                  locala.chD = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject4).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  ac.i(locala.getLogTag(), "updateReferrers, mReferrer: " + locala.chD);
                  break label540;
                  localJSONException1 = localJSONException1;
                  ac.w(locala.getLogTag(), "insert, put referrer fail since " + localJSONException1.toString());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  ac.w(locala.getLogTag(), "insert, put isInForeground fail since " + localJSONException2.toString());
                  continue;
                  localObject1 = "fail";
                }
              }
            }
            label1161:
            if (str.contains("update"))
            {
              locala.gA(2);
              localObject1 = locala1.Ee();
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                locala.chA = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                locala.chB = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              }
              if (locala.chs != null) {
                locala.chs.m(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.chX = ((JSONObject)localObject1).optString("backgroundPoster", locala.chX);
              localObject1 = com.tencent.luggage.k.a.a.a.c.g((JSONObject)localObject1);
              localObject3 = locala.chp;
              if (!((b)localObject3).mInited)
              {
                localObject1 = new com.tencent.luggage.k.a.a.a.a(-3, "uninited livePlayer");
                label1331:
                ac.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject1).chn });
                if (((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode != 0) {
                  break label1701;
                }
              }
              label1701:
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.cs((String)localObject1);
                break;
                b.l("updateLivePlayer", (Bundle)localObject1);
                ((b)localObject3).a((Bundle)localObject1, false);
                bool = ((b)localObject3).cij.isPlaying();
                localObject4 = ((Bundle)localObject1).getString("playUrl", ((b)localObject3).chO);
                if ((localObject4 != null) && (!((String)localObject4).isEmpty()) && (((b)localObject3).chO != null) && (!((b)localObject3).chO.equalsIgnoreCase((String)localObject4)) && (((b)localObject3).cij.isPlaying()))
                {
                  ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject3).chO + " playUrl-new = " + (String)localObject4);
                  ((b)localObject3).cij.stopPlay(true);
                }
                ((b)localObject3).chO = ((String)localObject4);
                i = ((b)localObject3).n((Bundle)localObject1);
                if ((i != ((b)localObject3).cim) && (((b)localObject3).cij.isPlaying()))
                {
                  ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject3).cim + " playType-new = " + i);
                  ((b)localObject3).cij.stopPlay(true);
                }
                ((b)localObject3).cim = i;
                ((b)localObject3).chR = ((Bundle)localObject1).getBoolean("autoplay", ((b)localObject3).chR);
                if (((((b)localObject3).chR) || (bool)) && (((b)localObject3).chO != null) && (!((b)localObject3).chO.isEmpty()) && (!((b)localObject3).cij.isPlaying()))
                {
                  ac.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                  ((b)localObject3).cij.startPlay(((b)localObject3).chO, ((b)localObject3).cim);
                }
                localObject1 = new com.tencent.luggage.k.a.a.a.a();
                break label1331;
              }
            }
            if ((str.contains("operate")) && (str.contains("Background")))
            {
              localObject1 = locala1.Ee().optString("type");
              ac.i(locala.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
              if ((!bs.isNullOrNil((String)localObject1)) && (locala.chp != null))
              {
                if (((String)localObject1).equals("stop"))
                {
                  locala.i(locala1);
                  if (locala.chG)
                  {
                    ac.i(locala.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    locala.chI = new AtomicBoolean(false);
                  }
                }
                else
                {
                  locala1.cs("fail");
                }
              }
              else {
                locala1.cs("fail");
              }
            }
            else
            {
              if (!str.contains("operate")) {
                break label2844;
              }
              locala.gA(3);
              localObject1 = locala1.Ee();
              localObject3 = ((JSONObject)localObject1).optString("type");
              ac.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject3 });
              if ((bs.isNullOrNil((String)localObject3)) || (locala.chp == null)) {
                break label2830;
              }
              if (((String)localObject3).equals("snapshot"))
              {
                locala.chp.cil = new a.4(locala, locala1);
                localObject1 = locala.chp.b("snapshot", locala1.Ee());
                if (((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode != 0)
                {
                  ac.i(locala.getLogTag(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject1).errorCode) });
                  locala1.cs("fail:snapshot error");
                }
                else
                {
                  ac.i(locala.getLogTag(), "operateSnapshot, success");
                }
              }
              else
              {
                if (((String)localObject3).equalsIgnoreCase("requestFullScreen"))
                {
                  if ((locala.chs != null) && (locala.chs.j(locala1)))
                  {
                    bool = true;
                    label2073:
                    ac.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2117;
                    }
                  }
                  label2117:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cs((String)localObject1);
                    break;
                    bool = false;
                    break label2073;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitFullScreen"))
                {
                  if ((locala.chs != null) && (locala.chs.k(locala1)))
                  {
                    bool = true;
                    label2160:
                    ac.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2204;
                    }
                  }
                  label2204:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cs((String)localObject1);
                    break;
                    bool = false;
                    break label2160;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitPictureInPicture"))
                {
                  bool = locala.chN.c(locala1);
                  ac.i(locala.getLogTag(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool) });
                  if (bool) {}
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.cs((String)localObject1);
                    break;
                  }
                }
                if (!((String)localObject3).equalsIgnoreCase("requestBackgroundPlayback")) {
                  break label2687;
                }
                ac.d(locala.getLogTag(), "enableBackgroundPlayAudio");
                if (locala.chS)
                {
                  ac.w(locala.getLogTag(), "enableBackgroundPlayAudio, mIsRTCMode");
                  locala1.cs("fail");
                }
                else
                {
                  if (!locala.chG) {
                    break label2370;
                  }
                  ac.w(locala.getLogTag(), "enableBackgroundPlayAudio, isRuntimeInBackground");
                  locala1.cs("fail");
                }
              }
            }
          }
          label2370:
          if (!locala.chT)
          {
            ac.d(locala.getLogTag(), "registerAddOnPlayAudio");
            locala.a(j.class, new a.11(locala));
            ac.d(locala.getLogTag(), "registerAddOnVideoController");
            locala.a(r.class, new a.13(locala));
            ac.d(locala.getLogTag(), "registerAddOnInfo");
            locala.a(i.class, new a.14(locala));
            ac.d(locala.getLogTag(), "registerAddOnGetSnapshot");
            locala.a(com.tencent.luggage.k.a.a.h.class, new a.17(locala));
            locala.chT = true;
          }
          ac.d(locala.getLogTag(), "enableBackgroundPlayAudioInternal");
          if (locala1 == null)
          {
            ac.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            bool = false;
            label2525:
            if (!bool) {
              break label2930;
            }
            if ((locala.chp != null) && (!locala.chp.cij.isPlaying()))
            {
              locala.chW.set(true);
              locala.chp.f(null);
            }
            locala.chU = true;
            if (locala.chr != null) {
              locala.chr.r(locala.getId(), true);
            }
          }
          label2830:
          label2844:
          label2890:
          label2910:
          label2930:
          for (boolean bool = true;; bool = false)
          {
            ac.i(locala.getLogTag(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
            if (bool) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.cs((String)localObject1);
              break;
              localObject1 = com.tencent.luggage.k.a.a.e.f(locala1);
              if (localObject1 == null)
              {
                ac.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                bool = false;
                break label2525;
              }
              bool = ((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject1).b(locala);
              break label2525;
            }
            label2687:
            if (((String)localObject3).equalsIgnoreCase("exitBackgroundPlayback"))
            {
              locala.i(locala1);
              break;
            }
            if (locala.chp.b((String)localObject3, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.cs((String)localObject1);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) && (!((String)localObject3).equalsIgnoreCase("pause"))) {
                break;
              }
              locala.chN.b(locala1);
              locala.cv((String)localObject3);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) || (!locala.chG)) {
                break;
              }
              ac.i(locala.getLogTag(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
              locala.chI = new AtomicBoolean(false);
              break;
            }
            locala1.cs("fail");
            break;
            if (!str.contains("remove")) {
              break;
            }
            locala.gA(4);
            locala.release();
            locala1.cs("ok");
            locala.chN.b(locala1);
            break;
            locala.chR = ((JSONObject)localObject1).optBoolean("autoplay", locala.chR);
            break label215;
            locala.chO = ((JSONObject)localObject1).optString("playUrl", locala.chO);
            break label237;
          }
        }
      });
    }
    AppMethodBeat.o(138830);
    return null;
  }
  
  final void i(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(206570);
    ac.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.chS)
    {
      ac.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.cs("fail");
      AppMethodBeat.o(206570);
      return;
    }
    ac.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ac.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label226;
      }
      this.chW.set(false);
      if (this.chp != null) {
        this.chp.f(this.mSurface);
      }
      this.chU = false;
      if (this.chr != null) {
        this.chr.r(getId(), false);
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      ac.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.cs((String)localObject);
        AppMethodBeat.o(206570);
        return;
        localObject = com.tencent.luggage.k.a.a.e.f(parama);
        if (localObject == null)
        {
          ac.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject).c(this);
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
        this.chv = com.tencent.mm.plugin.appbrand.z.g.ve(paramJSONObject.optInt("width", 0));
        this.chw = com.tencent.mm.plugin.appbrand.z.g.ve(paramJSONObject.optInt("height", 0));
        ac.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.chv), Integer.valueOf(this.chw) });
        ED();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.chs != null) {
      this.chs.l(this.cht);
    }
    b localb;
    if (this.chp != null)
    {
      localb = this.chp;
      if (localb.mInited) {
        break label150;
      }
      new com.tencent.luggage.k.a.a.a.a(-3, "uninited livePlayer");
    }
    for (;;)
    {
      this.chp = null;
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      if (this.cht != null)
      {
        this.cht.Eg();
        this.chu = null;
      }
      ac.i(getLogTag(), "LivePlayer release handler thread");
      if (this.chE != null) {
        this.chE.removeCallbacksAndMessages(null);
      }
      if (this.chF != null) {
        this.chF.quitSafely();
      }
      AppMethodBeat.o(138834);
      return;
      label150:
      localb.cij.stopPlay(true);
      localb.cij.setPlayListener(null);
      localb.mInited = false;
      new com.tencent.luggage.k.a.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */