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
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements i, o
{
  private w cqR;
  public b crH;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c crI;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b crJ;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.a crK;
  public com.tencent.luggage.xweb_ext.extendplugin.a crL;
  a.a crM;
  public int crN;
  public int crO;
  public int crP;
  public int crQ;
  private boolean crR;
  boolean crS;
  boolean crT;
  com.tencent.mm.plugin.appbrand.jsapi.s.c crU;
  String crV;
  public Handler crW;
  private HandlerThread crX;
  boolean crY;
  volatile boolean crZ;
  AtomicBoolean csa;
  com.tencent.luggage.xweb_ext.extendplugin.component.a csb;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<d> csc;
  String csd;
  public s cse;
  public int csf;
  volatile boolean csg;
  boolean csh;
  boolean csi;
  public boolean csj;
  private i csk;
  public AtomicBoolean csl;
  volatile String csm;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g csn;
  volatile Bitmap cso;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  
  public a()
  {
    AppMethodBeat.i(138827);
    this.crP = 0;
    this.crQ = 0;
    this.crU = null;
    this.crV = null;
    this.crY = false;
    this.crZ = false;
    this.csa = null;
    this.cqR = new a.5(this);
    this.csb = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cqR)
    {
      public final boolean FG()
      {
        return !a.this.crZ;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(178802);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.FD();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cqS = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cqT = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ad.d(a.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cqS + ", mIsAutoRotationEnabled: " + this.cqT);
          AppMethodBeat.o(178802);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equalsIgnoreCase("play")) || (paramAnonymousString.equalsIgnoreCase("resume")))) {
              this.cqS = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cqS = false;
          }
        }
      }
    };
    this.csc = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private d css = null;
      
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
    this.csd = "";
    this.cse = null;
    this.csf = -1;
    this.csg = false;
    this.csh = false;
    this.csi = false;
    this.csj = false;
    this.csk = new r();
    this.csl = new AtomicBoolean(false);
    this.mTitle = null;
    this.csm = null;
    this.csn = null;
    this.cso = null;
    this.crX = com.tencent.e.c.d.gX(String.format("LivePlayerThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.crX.start();
    this.crW = new Handler(this.crX.getLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.Ga();
    this.crH = new b(aj.getContext());
    this.crH.mHandler = this.crW;
    this.crH.csz = new ITXLivePlayListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138814);
        if (a.this.Gd()) {
          a.this.crJ.d(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(138814);
      }
      
      public final void onPlayEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(138813);
        if (a.this.Gd()) {
          a.this.crJ.a(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (a.this.crK != null) {
          a.this.crK.gI(paramAnonymousInt);
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138813);
          return;
          if (a.this.cse != null)
          {
            a.this.cse.FW();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csf = 0;
          AppMethodBeat.o(138813);
          return;
          if (a.this.cse != null)
          {
            a.this.cse.FX();
            a.this.cse.bA(a.this.csg);
            AppMethodBeat.o(138813);
            return;
          }
          paramAnonymousBundle = a.this;
          if (a.this.csg) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 3)
          {
            paramAnonymousBundle.csf = paramAnonymousInt;
            AppMethodBeat.o(138813);
            return;
          }
          if (a.this.cse != null)
          {
            a.this.cse.FY();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csf = 7;
          AppMethodBeat.o(138813);
          return;
          if (a.this.cse != null)
          {
            a.this.cse.onStop();
            AppMethodBeat.o(138813);
            return;
          }
          a.this.csf = 6;
        }
      }
    };
    this.crH.mAudioVolumeListener = new TXLivePlayer.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(138816);
        if (a.this.crJ != null) {
          a.this.crJ.bW(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(138816);
      }
    };
    AppMethodBeat.o(138827);
  }
  
  private void Gc()
  {
    AppMethodBeat.i(138833);
    if ((this.crN != 0) && (this.crO != 0) && (this.mSurfaceTexture != null) && (this.crH != null))
    {
      ad.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.crN), Integer.valueOf(this.crO) });
      this.mSurfaceTexture.setDefaultBufferSize(this.crN, this.crO);
      if ((Ge()) && (this.crZ))
      {
        ad.i(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
        AppMethodBeat.o(138833);
        return;
      }
      this.crH.bV(this.crN, this.crO);
    }
    AppMethodBeat.o(138833);
  }
  
  public final void FR()
  {
    AppMethodBeat.i(186761);
    if (this.crW != null) {
      this.crW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178807);
          if (a.this.crH != null)
          {
            a.this.crH.b("stop", null);
            a.this.dx("stop");
            b localb = a.this.crH;
            if (localb.csz != null) {
              localb.csz.onPlayEvent(6001, new Bundle());
            }
          }
          AppMethodBeat.o(178807);
        }
      });
    }
    AppMethodBeat.o(186761);
  }
  
  public final String FS()
  {
    AppMethodBeat.i(186762);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(186762);
    return str;
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(138829);
    if (this.crW != null) {
      this.crW.post(new a.19(this));
    }
    AppMethodBeat.o(138829);
  }
  
  final boolean Gd()
  {
    return this.crJ != null;
  }
  
  final boolean Ge()
  {
    AppMethodBeat.i(186758);
    boolean bool = this.csc.d(this.crL);
    AppMethodBeat.o(186758);
    return bool;
  }
  
  public final void Gf()
  {
    AppMethodBeat.i(186763);
    if ((this.crH != null) && (!this.crH.csy.isPlaying())) {
      dw("play");
    }
    AppMethodBeat.o(186763);
  }
  
  final boolean Gg()
  {
    AppMethodBeat.i(186765);
    if (this.crL == null)
    {
      ad.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(186765);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.crL);
    if (locala == null)
    {
      ad.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(186765);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(186765);
    return bool;
  }
  
  public final <AddOn extends j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(186769);
    ad.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.csk.U(paramClass);
    AppMethodBeat.o(186769);
    return paramClass;
  }
  
  final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138831);
    if (paramJSONObject.has("needEvent"))
    {
      this.crR = paramJSONObject.optBoolean("needEvent", false);
      if (Gd()) {
        this.crJ.m(parama);
      }
    }
    AppMethodBeat.o(138831);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(186768);
    ad.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.csk.a(paramClass, paramAddOn);
    AppMethodBeat.o(186768);
  }
  
  public final boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186760);
    if (this.crH != null)
    {
      if (!this.csl.get()) {
        this.crH.bV(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(186760);
        return true;
        ad.i(getLogTag(), "setSurfaceSize, JustPlayAudio");
      }
    }
    ad.w(getLogTag(), "setSurfaceSize, Adapter is null");
    AppMethodBeat.o(186760);
    return false;
  }
  
  public final void dw(final String paramString)
  {
    AppMethodBeat.i(177134);
    if (this.crW != null) {
      this.crW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186746);
          a.this.crH.b(paramString, null);
          a.this.dx(paramString);
          AppMethodBeat.o(186746);
        }
      });
    }
    AppMethodBeat.o(177134);
  }
  
  final void dx(String paramString)
  {
    AppMethodBeat.i(186764);
    if (paramString.equalsIgnoreCase("pause"))
    {
      if (this.cse != null) {
        this.cse.onPause();
      }
      while (this.crK != null)
      {
        this.crK.gI(2006);
        AppMethodBeat.o(186764);
        return;
        this.csf = 4;
      }
    }
    if (paramString.equalsIgnoreCase("stop"))
    {
      if (this.cse == null) {
        break label118;
      }
      this.cse.onStop();
    }
    for (;;)
    {
      if (this.crK != null) {
        this.crK.gI(2006);
      }
      AppMethodBeat.o(186764);
      return;
      label118:
      this.csf = 6;
    }
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138828);
    if (this.crW != null) {
      this.crW.post(new Runnable()
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
    AppMethodBeat.i(186759);
    if (this.crH != null)
    {
      if (!this.csl.get()) {
        this.crH.f(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(186759);
        return true;
        ad.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    ad.w(getLogTag(), "setSurface, Adapter is null");
    AppMethodBeat.o(186759);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  final void gF(int paramInt)
  {
    AppMethodBeat.i(138835);
    if (this.crI != null) {
      this.crI.aK(paramInt);
    }
    AppMethodBeat.o(138835);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177133);
    String str = BM() + "@" + hashCode();
    AppMethodBeat.o(177133);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138826);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", BM() });
    AppMethodBeat.o(138826);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(186767);
    String str = getKey();
    AppMethodBeat.o(186767);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138830);
    if (this.crW != null) {
      this.crW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138819);
          a locala = a.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala1 = parama;
          String str = locala1.FE();
          Object localObject1;
          Object localObject2;
          int i;
          if (!bt.isNullOrNil(str))
          {
            localObject1 = locala1.FD();
            ad.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.BM(), str, ((JSONObject)localObject1).toString() });
            new StringBuilder("handleJsApi:").append(str).append(", data:").append(localObject1);
            if (!str.contains("insert")) {
              break label1169;
            }
            locala.gF(1);
            localObject1 = locala1.FD();
            if (((JSONObject)localObject1).optInt("mode", 0) != 2) {
              break label325;
            }
            locala.csh = true;
            localObject2 = locala1.getContext();
            if ((localObject2 instanceof Activity)) {
              break label258;
            }
            ad.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
            locala1.du("fail:internal error invalid android context");
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
            locala.csb.a(str, locala1);
            localObject1 = locala1.FD();
            if (localObject1 != null) {
              break label2898;
            }
            ad.w(locala.getLogTag(), "handleAutoPlay, null == dataJsonObj");
            localObject1 = locala1.FD();
            if (localObject1 != null) {
              break label2918;
            }
            ad.w(locala.getLogTag(), "handlePlayerUrl, null == dataJsonObj");
            locala.csc.a(locala1, locala.csd);
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
            ad.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
            locala1.e("fail:system permission denied", (Map)localObject2);
            i = 0;
            break;
            label325:
            locala.csh = false;
            label331:
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { locala1.getAppId() }));
            locala.crL = locala1;
            localObject2 = locala1.El();
            if ((localObject2 instanceof aa)) {
              if (!((aa)localObject2).ckY)
              {
                bool = true;
                label390:
                locala.crZ = bool;
                label396:
                locala.crM = new a.21(locala);
                locala1.a(locala.crM);
                if (locala.crK != null) {
                  locala.crK.m(locala1);
                }
                locala.a(locala1, (JSONObject)localObject1);
                locala.i((JSONObject)localObject1);
                locala.crS = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
                locala.crT = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
                locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
                locala.csm = ((JSONObject)localObject1).optString("backgroundPoster", locala.csm);
                localObject2 = locala1.El();
                if (localObject2 != null) {
                  break label925;
                }
                ad.w(locala.getLogTag(), "updateReferrers, component is null");
                label540:
                if (locala.crV == null) {}
              }
            }
            Object localObject4;
            try
            {
              ((JSONObject)localObject1).put("referrer", locala.crV);
              if ((locala.crZ) && (!locala.Ge())) {
                ad.i(locala.getLogTag(), "insert, webView in background");
              }
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                ((JSONObject)localObject1).put("canStartPlay", false);
                locala.csa = new AtomicBoolean(((JSONObject)localObject1).optBoolean("autoplay", false));
                localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.g((JSONObject)localObject1);
                localObject1 = locala.crH;
                if (((b)localObject1).csz != null)
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
                  ((Bundle)localObject4).putLong("EVT_TIME", System.currentTimeMillis());
                  ((b)localObject1).csz.onPlayEvent(-9999999, (Bundle)localObject4);
                }
                b.l("initLivePlayer", (Bundle)localObject2);
                ((b)localObject1).mVideoView = null;
                ((b)localObject1).csd = ((Bundle)localObject2).getString("playUrl", ((b)localObject1).csd);
                ((b)localObject1).csB = ((b)localObject1).n((Bundle)localObject2);
                ((b)localObject1).a((Bundle)localObject2, true);
                ((b)localObject1).csg = ((Bundle)localObject2).getBoolean("autoplay", ((b)localObject1).csg);
                if ((((Bundle)localObject2).getBoolean("canStartPlay", true)) && (((b)localObject1).csg) && (((b)localObject1).csd != null) && (!((b)localObject1).csd.isEmpty()))
                {
                  ad.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                  ((b)localObject1).csy.startPlay(((b)localObject1).csd, ((b)localObject1).csB);
                }
                ((b)localObject1).mInited = true;
                localObject4 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
                ad.i(locala.getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).crF });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode == 0)
                {
                  localObject1 = "ok";
                  locala1.du((String)localObject1);
                  if ((((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject4).errorCode != 0) || (locala.crK == null)) {
                    continue;
                  }
                  locala.crK.a(locala1, (Bundle)localObject2);
                  continue;
                  bool = false;
                  break label390;
                  ad.w(locala.getLogTag(), "insert, component is not AppBrandPageView");
                  break label396;
                  label925:
                  localObject4 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
                  if (localObject4 == null)
                  {
                    ad.w(locala.getLogTag(), "updateReferrers, referrerHelper is null");
                    break label540;
                  }
                  if (locala.crU == null) {
                    locala.crU = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).bmo();
                  }
                  com.tencent.mm.plugin.appbrand.jsapi.s.c localc = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  if (localc != null) {
                    locala.crU = localc;
                  }
                  ad.i(locala.getLogTag(), "updateReferrers, mReferrerPolicy: " + locala.crU);
                  if (com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc == locala.crU)
                  {
                    locala.crV = null;
                    break label540;
                  }
                  locala.crV = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject4).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
                  ad.i(locala.getLogTag(), "updateReferrers, mReferrer: " + locala.crV);
                  break label540;
                  localJSONException1 = localJSONException1;
                  ad.w(locala.getLogTag(), "insert, put referrer fail since " + localJSONException1.toString());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  ad.w(locala.getLogTag(), "insert, put isInForeground fail since " + localJSONException2.toString());
                  continue;
                  localObject1 = "fail";
                }
              }
            }
            label1169:
            if (str.contains("update"))
            {
              locala.gF(2);
              localObject1 = locala1.FD();
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                locala.crS = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                locala.crT = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
              }
              if (locala.crK != null) {
                locala.crK.m(locala1);
              }
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.mTitle = ((JSONObject)localObject1).optString("title", locala.mTitle);
              locala.csm = ((JSONObject)localObject1).optString("backgroundPoster", locala.csm);
              localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.g((JSONObject)localObject1);
              localObject3 = locala.crH;
              if (!((b)localObject3).mInited)
              {
                localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a(-3, "uninited livePlayer");
                label1339:
                ad.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).crF });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0) {
                  break label1709;
                }
              }
              label1709:
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.du((String)localObject1);
                break;
                b.l("updateLivePlayer", (Bundle)localObject1);
                ((b)localObject3).a((Bundle)localObject1, false);
                bool = ((b)localObject3).csy.isPlaying();
                localObject4 = ((Bundle)localObject1).getString("playUrl", ((b)localObject3).csd);
                if ((localObject4 != null) && (!((String)localObject4).isEmpty()) && (((b)localObject3).csd != null) && (!((b)localObject3).csd.equalsIgnoreCase((String)localObject4)) && (((b)localObject3).csy.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject3).csd + " playUrl-new = " + (String)localObject4);
                  ((b)localObject3).csy.stopPlay(true);
                }
                ((b)localObject3).csd = ((String)localObject4);
                i = ((b)localObject3).n((Bundle)localObject1);
                if ((i != ((b)localObject3).csB) && (((b)localObject3).csy.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject3).csB + " playType-new = " + i);
                  ((b)localObject3).csy.stopPlay(true);
                }
                ((b)localObject3).csB = i;
                ((b)localObject3).csg = ((Bundle)localObject1).getBoolean("autoplay", ((b)localObject3).csg);
                if (((((b)localObject3).csg) || (bool)) && (((b)localObject3).csd != null) && (!((b)localObject3).csd.isEmpty()) && (!((b)localObject3).csy.isPlaying()))
                {
                  ad.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                  ((b)localObject3).csy.startPlay(((b)localObject3).csd, ((b)localObject3).csB);
                }
                localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
                break label1339;
              }
            }
            if ((str.contains("operate")) && (str.contains("Background")))
            {
              localObject1 = locala1.FD().optString("type");
              ad.i(locala.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
              if ((!bt.isNullOrNil((String)localObject1)) && (locala.crH != null))
              {
                if (((String)localObject1).equals("stop"))
                {
                  locala.i(locala1);
                  if (locala.crY)
                  {
                    ad.i(locala.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    locala.csa = new AtomicBoolean(false);
                  }
                }
                else
                {
                  locala1.du("fail");
                }
              }
              else {
                locala1.du("fail");
              }
            }
            else
            {
              if (!str.contains("operate")) {
                break label2852;
              }
              locala.gF(3);
              localObject1 = locala1.FD();
              localObject3 = ((JSONObject)localObject1).optString("type");
              ad.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject3 });
              if ((bt.isNullOrNil((String)localObject3)) || (locala.crH == null)) {
                break label2838;
              }
              if (((String)localObject3).equals("snapshot"))
              {
                locala.crH.csA = new a.4(locala, locala1);
                localObject1 = locala.crH.b("snapshot", locala1.FD());
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0)
                {
                  ad.i(locala.getLogTag(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode) });
                  locala1.du("fail:snapshot error");
                }
                else
                {
                  ad.i(locala.getLogTag(), "operateSnapshot, success");
                }
              }
              else
              {
                if (((String)localObject3).equalsIgnoreCase("requestFullScreen"))
                {
                  if ((locala.crK != null) && (locala.crK.j(locala1)))
                  {
                    bool = true;
                    label2081:
                    ad.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2125;
                    }
                  }
                  label2125:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.du((String)localObject1);
                    break;
                    bool = false;
                    break label2081;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitFullScreen"))
                {
                  if ((locala.crK != null) && (locala.crK.k(locala1)))
                  {
                    bool = true;
                    label2168:
                    ad.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                    if (!bool) {
                      break label2212;
                    }
                  }
                  label2212:
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.du((String)localObject1);
                    break;
                    bool = false;
                    break label2168;
                  }
                }
                if (((String)localObject3).equalsIgnoreCase("exitPictureInPicture"))
                {
                  bool = locala.csc.c(locala1);
                  ad.i(locala.getLogTag(), "operateExitPip, result:%s", new Object[] { Boolean.valueOf(bool) });
                  if (bool) {}
                  for (localObject1 = "ok";; localObject1 = "fail")
                  {
                    locala1.du((String)localObject1);
                    break;
                  }
                }
                if (!((String)localObject3).equalsIgnoreCase("requestBackgroundPlayback")) {
                  break label2695;
                }
                ad.d(locala.getLogTag(), "enableBackgroundPlayAudio");
                if (locala.csh)
                {
                  ad.w(locala.getLogTag(), "enableBackgroundPlayAudio, mIsRTCMode");
                  locala1.du("fail");
                }
                else
                {
                  if (!locala.crY) {
                    break label2378;
                  }
                  ad.w(locala.getLogTag(), "enableBackgroundPlayAudio, isRuntimeInBackground");
                  locala1.du("fail");
                }
              }
            }
          }
          label2378:
          if (!locala.csi)
          {
            ad.d(locala.getLogTag(), "registerAddOnPlayAudio");
            locala.a(m.class, new a.11(locala));
            ad.d(locala.getLogTag(), "registerAddOnVideoController");
            locala.a(n.class, new a.13(locala));
            ad.d(locala.getLogTag(), "registerAddOnInfo");
            locala.a(l.class, new a.14(locala));
            ad.d(locala.getLogTag(), "registerAddOnGetSnapshot");
            locala.a(k.class, new a.17(locala));
            locala.csi = true;
          }
          ad.d(locala.getLogTag(), "enableBackgroundPlayAudioInternal");
          if (locala1 == null)
          {
            ad.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            bool = false;
            label2533:
            if (!bool) {
              break label2938;
            }
            if ((locala.crH != null) && (!locala.crH.csy.isPlaying()))
            {
              locala.csl.set(true);
              locala.crH.f(null);
            }
            locala.csj = true;
            if (locala.crJ != null) {
              locala.crJ.r(locala.getId(), true);
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
            ad.i(locala.getLogTag(), "enableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
            if (bool) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.du((String)localObject1);
              break;
              localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala1);
              if (localObject1 == null)
              {
                ad.w(locala.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                bool = false;
                break label2533;
              }
              bool = ((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject1).b(locala);
              break label2533;
            }
            if (((String)localObject3).equalsIgnoreCase("exitBackgroundPlayback"))
            {
              locala.i(locala1);
              break;
            }
            if (locala.crH.b((String)localObject3, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala1.du((String)localObject1);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) && (!((String)localObject3).equalsIgnoreCase("pause"))) {
                break;
              }
              locala.csc.b(locala1);
              locala.dx((String)localObject3);
              if ((!((String)localObject3).equalsIgnoreCase("stop")) || (!locala.crY)) {
                break;
              }
              ad.i(locala.getLogTag(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
              locala.csa = new AtomicBoolean(false);
              break;
            }
            locala1.du("fail");
            break;
            if (!str.contains("remove")) {
              break;
            }
            locala.gF(4);
            locala.release();
            locala1.du("ok");
            locala.csc.b(locala1);
            break;
            locala.csg = ((JSONObject)localObject1).optBoolean("autoplay", locala.csg);
            break label215;
            locala.csd = ((JSONObject)localObject1).optString("playUrl", locala.csd);
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
    AppMethodBeat.i(186766);
    ad.d(getLogTag(), "disableBackgroundPlayAudio");
    if (this.csh)
    {
      ad.w(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
      parama.du("fail");
      AppMethodBeat.o(186766);
      return;
    }
    ad.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ad.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
      if (i == 0) {
        break label226;
      }
      this.csl.set(false);
      if (this.crH != null) {
        this.crH.f(this.mSurface);
      }
      this.csj = false;
      if (this.crJ != null) {
        this.crJ.r(getId(), false);
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      ad.i(getLogTag(), "disableBackgroundPlayAudio, result:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      for (Object localObject = "ok";; localObject = "fail")
      {
        parama.du((String)localObject);
        AppMethodBeat.o(186766);
        return;
        localObject = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
        if (localObject == null)
        {
          ad.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
          i = 0;
          break;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject).c(this);
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
        this.crN = com.tencent.mm.plugin.appbrand.z.g.vJ(paramJSONObject.optInt("width", 0));
        this.crO = com.tencent.mm.plugin.appbrand.z.g.vJ(paramJSONObject.optInt("height", 0));
        ad.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.crN), Integer.valueOf(this.crO) });
        Gc();
      }
    }
    AppMethodBeat.o(138832);
  }
  
  final void release()
  {
    AppMethodBeat.i(138834);
    if (this.crK != null) {
      this.crK.l(this.crL);
    }
    b localb;
    if (this.crH != null)
    {
      localb = this.crH;
      if (localb.mInited) {
        break label150;
      }
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a(-3, "uninited livePlayer");
    }
    for (;;)
    {
      this.crH = null;
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      if (this.crL != null)
      {
        this.crL.FF();
        this.crM = null;
      }
      ad.i(getLogTag(), "LivePlayer release handler thread");
      if (this.crW != null) {
        this.crW.removeCallbacksAndMessages(null);
      }
      if (this.crX != null) {
        this.crX.quitSafely();
      }
      AppMethodBeat.o(138834);
      return;
      label150:
      localb.csy.stopPlay(true);
      localb.csy.setPlayListener(null);
      localb.mInited = false;
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a
 * JD-Core Version:    0.7.0.1
 */