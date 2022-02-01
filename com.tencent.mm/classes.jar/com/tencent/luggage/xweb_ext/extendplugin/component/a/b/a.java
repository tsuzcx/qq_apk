package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.e.c.d;
import com.tencent.luggage.h.h;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.permission.p;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.aa.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePusher;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements o
{
  com.tencent.luggage.xweb_ext.extendplugin.a crL;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a crM;
  int crN;
  int crO;
  private boolean crR;
  b ctb;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c ctc;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b ctd;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a cte;
  private String ctf;
  private String ctg;
  int cth;
  boolean cti;
  private boolean ctj;
  private b ctk;
  private int ctl;
  aa ctm;
  a ctn;
  Handler cto;
  private HandlerThread ctp;
  int mCurrentScale;
  Handler mHandler;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(138878);
    this.ctf = "";
    this.mCurrentScale = 1;
    this.ctk = new b((byte)0);
    this.ctl = 0;
    this.ctn = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f2 = 0.9F;
        AppMethodBeat.i(186786);
        b localb = a.this.ctb;
        int j;
        float f3;
        float f1;
        label86:
        int k;
        int i;
        if (localb.cty != null)
        {
          j = localb.cty.getMaxZoom();
          if (j > 0)
          {
            f3 = paramAnonymousScaleGestureDetector.getScaleFactor();
            if (f3 <= 1.0F) {
              break label288;
            }
            f2 = 0.2F / j * (j - a.this.mCurrentScale) + 1.0F;
            f1 = f2;
            if (f2 <= 1.1F) {
              f1 = 1.1F;
            }
            k = Math.round(a.this.mCurrentScale * f1);
            i = k;
            if (k == a.this.mCurrentScale)
            {
              if (f1 <= 1.0F) {
                break label333;
              }
              i = k + 1;
            }
            label129:
            k = i;
            if (i >= j) {
              k = j;
            }
            i = k;
            if (k <= 1) {
              i = 1;
            }
            if (f1 <= 1.0F) {
              break label352;
            }
            if (i >= a.this.mCurrentScale) {
              break label382;
            }
            i = a.this.mCurrentScale;
          }
        }
        label288:
        label333:
        label352:
        label382:
        for (;;)
        {
          a.this.mCurrentScale = i;
          if (a.this.ctb != null)
          {
            ad.i(a.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(a.this.mCurrentScale) });
            paramAnonymousScaleGestureDetector = a.this.ctb;
            i = a.this.mCurrentScale;
            paramAnonymousScaleGestureDetector.cty.setZoom(i);
            new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
          }
          AppMethodBeat.o(186786);
          return false;
          j = 0;
          break;
          f1 = f3;
          if (f3 < 1.0F)
          {
            f3 = 1.0F - 0.2F / j * a.this.mCurrentScale;
            f1 = f2;
            if (f3 >= 0.9F) {
              break label86;
            }
            f1 = f3;
          }
          break label86;
          i = k;
          if (f1 >= 1.0F) {
            break label129;
          }
          i = k - 1;
          break label129;
          if ((f1 < 1.0F) && (i > a.this.mCurrentScale)) {
            i = a.this.mCurrentScale;
          }
        }
      }
      
      public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.ctp = d.gX(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.ctp.start();
    this.cto = new Handler(this.ctp.getLooper());
    this.mHandler = new Handler(aj.getContext().getMainLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.Ga();
    this.ctb = new b(aj.getContext());
    this.ctb.mHandler = this.cto;
    this.ctb.ctz = new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (a.this.Gd()) {
          a.this.ctd.e(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (a.this.Gd())
        {
          ad.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          a.this.ctd.b(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (a.this.cte != null))
        {
          a.this.cte.b(a.this, a.this.crL);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (a.this.cte != null)) {
          a.this.cte.c(a.this, a.this.crL);
        }
        AppMethodBeat.o(178826);
      }
    };
    this.ctb.ctG = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (a.this.Gd()) {
          a.this.ctd.bX(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (a.this.Gd()) {
          a.this.ctd.f(a.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (a.this.Gd()) {
          a.this.ctd.gL(a.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    };
    this.ctb.ctH = new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (a.this.Gd()) {
          a.this.ctd.bY(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    };
    this.ctm = new aa(aj.getContext(), new aa.b()
    {
      public final void a(aa.a paramAnonymousa1, aa.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (a.14.cts[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = a.this.ctn;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.ctq.mHandler.removeCallbacks(paramAnonymousa1);
          a.this.ctn.ctu = i;
          paramAnonymousa1 = a.this.ctn;
          paramAnonymousa1.ctq.mHandler.postDelayed(paramAnonymousa1, 250L);
          AppMethodBeat.o(178833);
          return;
          i = 1;
          continue;
          i = 0;
          continue;
          i = 2;
          continue;
          i = 3;
        }
      }
    });
    this.ctm.enable();
    gJ(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          a.this.mScaleGestureDetector = new ScaleGestureDetector(aj.getContext(), a.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
  }
  
  private void Gc()
  {
    AppMethodBeat.i(138888);
    if ((this.crN != 0) && (this.crO != 0) && (this.mSurfaceTexture != null) && (this.ctb != null))
    {
      ad.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.crN), Integer.valueOf(this.crO) });
      this.mSurfaceTexture.setDefaultBufferSize(this.crN, this.crO);
      this.ctb.bV(this.crN, this.crO);
    }
    AppMethodBeat.o(138888);
  }
  
  static int getRotationAngle()
  {
    AppMethodBeat.i(138879);
    if (aj.getContext().getSystemService("window") != null)
    {
      int i = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(138879);
      return i;
    }
    AppMethodBeat.o(138879);
    return 0;
  }
  
  public final void FR()
  {
    AppMethodBeat.i(186788);
    if (this.cto != null) {
      this.cto.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186785);
          if (a.this.ctb != null)
          {
            a.this.ctb.c("stop", new JSONObject());
            b localb = a.this.ctb;
            if (localb.ctz != null)
            {
              ad.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
              localb.ctz.onPushEvent(5001, new Bundle());
            }
          }
          AppMethodBeat.o(186785);
        }
      });
    }
    AppMethodBeat.o(186788);
  }
  
  public final String FS()
  {
    AppMethodBeat.i(186789);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(186789);
    return str;
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(138882);
    if (this.cto != null) {
      this.cto.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138870);
          a.a(a.this);
          AppMethodBeat.o(138870);
        }
      });
    }
    AppMethodBeat.o(138882);
  }
  
  final boolean Gd()
  {
    return this.ctd != null;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.cth;
    this.cth = (i + 1);
    if (i > 5)
    {
      ad.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.du("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    p.b(parama.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(178824);
        ad.i(a.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178822);
                a.this.a(a.10.this.val$activity, a.10.this.csq);
                AppMethodBeat.o(178822);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ad.i(a.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          parama.du("fail:system permission denied");
          AppMethodBeat.o(178824);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178823);
                a.this.a(a.10.this.val$activity, a.10.this.csq);
                AppMethodBeat.o(178823);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ad.i(a.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          parama.du("fail:system permission denied");
        }
        AppMethodBeat.o(178824);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ad.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.du("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ad.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.du("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    ad.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    if (this.ctb == null)
    {
      ad.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(138891);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.crL = parama;
    this.crM = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void gE(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        a locala = a.this;
        if (locala.cto != null) {
          locala.cto.post(new a.4(locala, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        a locala = a.this;
        if (locala.cto != null) {
          locala.cto.post(new a.5(locala));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        a locala = a.this;
        if (locala.cto != null) {
          locala.cto.post(new a.3(locala));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.crM);
    paramActivity = parama.FD();
    a(parama, paramActivity);
    i(paramActivity);
    k(paramActivity);
    l(paramActivity);
    j(paramActivity);
    Bundle localBundle = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.h(paramActivity);
    if (this.cte != null)
    {
      paramActivity = this.cte.c(parama, localBundle);
      if (!bt.isNullOrNil(paramActivity))
      {
        ad.i(getLogTag(), "insert fail, message:%s", new Object[] { paramActivity });
        parama.du("fail: can not insert RTC mode LivePusher now");
        Toast.makeText(parama.getContext(), paramActivity, 0).show();
        AppMethodBeat.o(138891);
        return;
      }
    }
    paramActivity = this.ctb;
    if (paramActivity.ctz != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      paramActivity.ctz.onPushEvent(-9999999, (Bundle)localObject);
    }
    b.l("InitLivePusher", localBundle);
    paramActivity.mVideoView = null;
    paramActivity.ctA = localBundle.getString("pushUrl", "");
    paramActivity.cty.setPusherUrl(paramActivity.ctA);
    paramActivity.a(localBundle, true);
    paramActivity.ctK = localBundle.getBoolean("autopush", paramActivity.ctK);
    if ((paramActivity.ctK) && (paramActivity.ctA != null) && (!paramActivity.ctA.isEmpty()) && (!paramActivity.cty.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      paramActivity.bB(paramActivity.ctQ);
      paramActivity.bC(paramActivity.ctR);
      if ((paramActivity.ctQ) && (paramActivity.mSurface != null)) {
        paramActivity.cty.setSurface(paramActivity.mSurface);
      }
      paramActivity.cty.startPusher(paramActivity.ctA);
    }
    paramActivity.mInited = true;
    Object localObject = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
    ad.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).crF });
    if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode == 0) {}
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      parama.du(paramActivity);
      n(parama);
      o(parama);
      if ((((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode == 0) && (this.cte != null)) {
        this.cte.a(this, this.crL, localBundle);
      }
      AppMethodBeat.o(138891);
      return;
    }
  }
  
  final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138886);
    if (paramJSONObject.has("needEvent"))
    {
      this.crR = paramJSONObject.optBoolean("needEvent", false);
      if (Gd()) {
        this.ctd.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.cto != null) {
      this.cto.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138869);
          a.a(a.this, paramSurfaceTexture);
          AppMethodBeat.o(138869);
        }
      });
    }
    AppMethodBeat.o(138881);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  final void gF(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.ctc != null) {
      this.ctc.aK(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final boolean gJ(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.ctl)
    {
      this.ctl = paramInt;
      ad.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.ctb != null)
      {
        this.ctb.gK(paramInt);
        AppMethodBeat.o(138880);
        return true;
      }
    }
    AppMethodBeat.o(138880);
    return false;
  }
  
  final String getLogTag()
  {
    AppMethodBeat.i(138877);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", BM() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.cto != null) {
      this.cto.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          a locala = a.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala1 = parama;
          Object localObject1 = locala1.FE();
          if (!bt.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala1.FD();
            ad.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.BM(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              locala.gF(5);
              localObject1 = locala1.getContext();
              if (!(localObject1 instanceof Activity))
              {
                ad.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala1.du("fail:internal error invalid android context");
                p.TS(locala1.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              locala.cth = 0;
              locala.a((Activity)localObject1, locala1);
              AppMethodBeat.o(138874);
              return;
            }
            com.tencent.luggage.xweb_ext.extendplugin.component.a.a locala2;
            if (((String)localObject1).contains("update"))
            {
              locala.gF(6);
              if (locala.ctb == null)
              {
                ad.i(locala.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.FD();
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.k((JSONObject)localObject1);
              locala.l((JSONObject)localObject1);
              locala.j((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.h((JSONObject)localObject1);
              locala2 = locala.ctb.o((Bundle)localObject2);
              ad.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(locala2.errorCode), locala2.crF });
              if (locala2.errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.du((String)localObject1);
                locala.n(locala1);
                locala.o(locala1);
                if ((locala2.errorCode == 0) && (locala.cte != null)) {
                  locala.cte.b(locala.crL, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              locala.gF(7);
              if (locala.ctb == null)
              {
                ad.i(locala.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.FD();
              localObject2 = ((JSONObject)localObject1).optString("type");
              ad.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!bt.isNullOrNil((String)localObject2)) && (locala.ctb != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  locala.ctb.ctF = new a.8(locala, locala1);
                  if (locala.ctb.c("snapshot", locala1.FD()).errorCode != 0) {
                    locala1.du("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (locala.cte != null)
                  {
                    locala.cte.b(locala1, new a.9(locala));
                    locala1.du("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala1.du("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                locala2 = locala.ctb.c((String)localObject2, (JSONObject)localObject1);
                ad.i(locala.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(locala2.errorCode), locala2.crF });
                if (locala2.errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala1.du((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (locala2.errorCode == 0) && (locala.cte != null)) {
                    locala.cte.c(locala, locala.crL);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala1.du("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              locala.gF(8);
              locala.release();
              locala1.du("ok");
            }
          }
          AppMethodBeat.o(138874);
        }
      });
    }
    AppMethodBeat.o(138884);
    return null;
  }
  
  final void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138887);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.crN = g.vJ(paramJSONObject.optInt("width", 0));
        this.crO = g.vJ(paramJSONObject.optInt("height", 0));
        ad.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.crN), Integer.valueOf(this.crO) });
        Gc();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.ctf = paramJSONObject.optString("filterImage", this.ctf);
      this.ctg = paramJSONObject.optString("filterImageMd5", null);
      if (bt.isNullOrNil(this.ctf)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          AppMethodBeat.o(178836);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          ad.w(getLogTag(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          AppMethodBeat.o(178836);
          return;
        }
      }
      if ((this.ctf.startsWith("http://")) || (this.ctf.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
    AppMethodBeat.o(178836);
  }
  
  final void k(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(138889);
    if (paramJSONObject.has("focusMode"))
    {
      if (paramJSONObject.optInt("focusMode", 0) != 0) {
        bool = true;
      }
      this.cti = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  public final void l(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.cto != null) {
      this.cto.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178834);
          a.a(a.this, paramMotionEvent);
          AppMethodBeat.o(178834);
        }
      });
    }
    AppMethodBeat.o(138883);
  }
  
  final void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138890);
    if (paramJSONObject.has("zoom")) {
      this.ctj = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  final void n(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.cte != null) {
      this.cte.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(138857);
          if (!bt.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ad.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ctb != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              a.this.ctb.o(paramAnonymousString2);
            }
            AppMethodBeat.o(138857);
            return;
          }
          ad.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (a.this.ctd != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ctd.a(a.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(138857);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  final void o(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.cte != null) && (!bt.isNullOrNil(this.ctf))) {
      this.cte.a(parama, this.ctf, this.ctg, new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          if (!bt.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ad.i(a.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ctb != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              a.this.ctb.o(paramAnonymousString2);
            }
            AppMethodBeat.o(178819);
            return;
          }
          ad.i(a.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (a.this.ctd != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ctd.a(a.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(178819);
        }
      });
    }
    AppMethodBeat.o(178835);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.cte != null)
    {
      this.cte.c(this, this.crL);
      this.cte.a(this, this.crL);
    }
    if (this.ctb != null)
    {
      this.ctb.Gn();
      this.ctb = null;
    }
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
    ad.i(getLogTag(), "LivePusher release handler thread");
    if (this.cto != null) {
      this.cto.removeCallbacksAndMessages(null);
    }
    if (this.ctp != null) {
      this.ctp.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final void s(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.ctb != null)
    {
      this.ctb.cty.setFocusPosition(paramFloat1, paramFloat2);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a locala = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
      ad.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(locala.errorCode), locala.crF });
    }
    AppMethodBeat.o(138894);
  }
  
  final class a
    implements Runnable
  {
    int ctu;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = a.getRotationAngle();
      if (i == this.ctu)
      {
        a.this.gJ(i);
        AppMethodBeat.o(138875);
        return;
      }
      if (this.number < 8) {
        a.this.mHandler.postDelayed(this, 250L);
      }
      AppMethodBeat.o(138875);
    }
  }
  
  final class b
    implements Runnable
  {
    MotionEvent ctv;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((a.this.cti) && (a.this.crN != 0) && (a.this.crO != 0)) {
        a.this.s(this.ctv.getX() / a.this.crN, this.ctv.getY() / a.this.crO);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a
 * JD-Core Version:    0.7.0.1
 */