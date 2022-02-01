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
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  com.tencent.luggage.xweb_ext.extendplugin.a cso;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a csp;
  int csq;
  int csr;
  private boolean csu;
  b ctF;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c ctG;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b ctH;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a ctI;
  private String ctJ;
  private String ctK;
  int ctL;
  boolean ctM;
  private boolean ctN;
  private b ctO;
  private int ctP;
  ad ctQ;
  a ctR;
  Handler ctS;
  private HandlerThread ctT;
  int mCurrentScale;
  Handler mHandler;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(138878);
    this.ctJ = "";
    this.mCurrentScale = 1;
    this.ctO = new b((byte)0);
    this.ctP = 0;
    this.ctR = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f2 = 0.9F;
        AppMethodBeat.i(220469);
        b localb = a.this.ctF;
        int j;
        float f3;
        float f1;
        label86:
        int k;
        int i;
        if (localb.cub != null)
        {
          j = localb.cub.getMaxZoom();
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
          if (a.this.ctF != null)
          {
            ae.i(a.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(a.this.mCurrentScale) });
            paramAnonymousScaleGestureDetector = a.this.ctF;
            i = a.this.mCurrentScale;
            paramAnonymousScaleGestureDetector.cub.setZoom(i);
            new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
          }
          AppMethodBeat.o(220469);
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
    this.ctT = d.hg(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.ctT.start();
    this.ctS = new Handler(this.ctT.getLooper());
    this.mHandler = new Handler(ak.getContext().getMainLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.Gg();
    this.ctF = new b(ak.getContext());
    this.ctF.mHandler = this.ctS;
    this.ctF.cuc = new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (a.this.Gj()) {
          a.this.ctH.e(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (a.this.Gj())
        {
          ae.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          a.this.ctH.b(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (a.this.ctI != null))
        {
          a.this.ctI.b(a.this, a.this.cso);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (a.this.ctI != null)) {
          a.this.ctI.c(a.this, a.this.cso);
        }
        AppMethodBeat.o(178826);
      }
    };
    this.ctF.cuj = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (a.this.Gj()) {
          a.this.ctH.bX(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (a.this.Gj()) {
          a.this.ctH.f(a.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (a.this.Gj()) {
          a.this.ctH.gM(a.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    };
    this.ctF.cuk = new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (a.this.Gj()) {
          a.this.ctH.bY(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    };
    this.ctQ = new ad(ak.getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (a.14.ctW[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = a.this.ctR;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.ctU.mHandler.removeCallbacks(paramAnonymousa1);
          a.this.ctR.ctY = i;
          paramAnonymousa1 = a.this.ctR;
          paramAnonymousa1.ctU.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.ctQ.enable();
    gK(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          a.this.mScaleGestureDetector = new ScaleGestureDetector(ak.getContext(), a.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
  }
  
  private void Gi()
  {
    AppMethodBeat.i(138888);
    if ((this.csq != 0) && (this.csr != 0) && (this.mSurfaceTexture != null) && (this.ctF != null))
    {
      ae.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.csq), Integer.valueOf(this.csr) });
      this.mSurfaceTexture.setDefaultBufferSize(this.csq, this.csr);
      this.ctF.bV(this.csq, this.csr);
    }
    AppMethodBeat.o(138888);
  }
  
  static int getRotationAngle()
  {
    AppMethodBeat.i(138879);
    if (ak.getContext().getSystemService("window") != null)
    {
      int i = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(138879);
      return i;
    }
    AppMethodBeat.o(138879);
    return 0;
  }
  
  public final void FX()
  {
    AppMethodBeat.i(220471);
    if (this.ctS != null) {
      this.ctS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220468);
          if (a.this.ctF != null)
          {
            a.this.ctF.c("stop", new JSONObject());
            b localb = a.this.ctF;
            if (localb.cuc != null)
            {
              ae.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
              localb.cuc.onPushEvent(5001, new Bundle());
            }
          }
          AppMethodBeat.o(220468);
        }
      });
    }
    AppMethodBeat.o(220471);
  }
  
  public final String FY()
  {
    AppMethodBeat.i(220472);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(220472);
    return str;
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(138882);
    if (this.ctS != null) {
      this.ctS.post(new Runnable()
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
  
  final boolean Gj()
  {
    return this.ctH != null;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.ctL;
    this.ctL = (i + 1);
    if (i > 5)
    {
      ae.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.dw("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    r.b(parama.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(178824);
        ae.i(a.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178822);
                a.this.a(a.10.this.val$activity, a.10.this.csT);
                AppMethodBeat.o(178822);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ae.i(a.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          parama.dw("fail:system permission denied");
          AppMethodBeat.o(178824);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178823);
                a.this.a(a.10.this.val$activity, a.10.this.csT);
                AppMethodBeat.o(178823);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ae.i(a.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          parama.dw("fail:system permission denied");
        }
        AppMethodBeat.o(178824);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ae.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.dw("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ae.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.dw("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    ae.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    if (this.ctF == null)
    {
      ae.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(138891);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.cso = parama;
    this.csp = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void gF(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        ae.i(a.this.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramAnonymousInt)));
        a locala = a.this;
        if (locala.ctS != null) {
          locala.ctS.post(new a.4(locala, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        a locala = a.this;
        if (locala.ctS != null) {
          locala.ctS.post(new a.5(locala));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        ae.i(a.this.getLogTag(), "onForeground");
        a locala = a.this;
        if (locala.ctS != null) {
          locala.ctS.post(new a.3(locala));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.csp);
    paramActivity = parama.FJ();
    a(parama, paramActivity);
    i(paramActivity);
    k(paramActivity);
    l(paramActivity);
    j(paramActivity);
    Bundle localBundle = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.h(paramActivity);
    if (this.ctI != null)
    {
      paramActivity = this.ctI.c(parama, localBundle);
      if (!bu.isNullOrNil(paramActivity))
      {
        ae.i(getLogTag(), "insert fail, message:%s", new Object[] { paramActivity });
        parama.dw("fail: can not insert RTC mode LivePusher now");
        Toast.makeText(parama.getContext(), paramActivity, 0).show();
        AppMethodBeat.o(138891);
        return;
      }
    }
    paramActivity = this.ctF;
    if (paramActivity.cuc != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      paramActivity.cuc.onPushEvent(-9999999, (Bundle)localObject);
    }
    b.l("InitLivePusher", localBundle);
    paramActivity.mVideoView = null;
    paramActivity.cud = localBundle.getString("pushUrl", "");
    paramActivity.cub.setPusherUrl(paramActivity.cud);
    paramActivity.a(localBundle, true);
    paramActivity.cun = localBundle.getBoolean("autopush", paramActivity.cun);
    if ((paramActivity.cun) && (paramActivity.cud != null) && (!paramActivity.cud.isEmpty()) && (!paramActivity.cub.isPushing()))
    {
      ae.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      paramActivity.bB(paramActivity.cut);
      paramActivity.bC(paramActivity.cuu);
      if ((paramActivity.cut) && (paramActivity.mSurface != null)) {
        paramActivity.cub.setSurface(paramActivity.mSurface);
      }
      paramActivity.cub.startPusher(paramActivity.cud);
    }
    paramActivity.mInited = true;
    Object localObject = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
    ae.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).csi });
    if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode == 0) {}
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      parama.dw(paramActivity);
      n(parama);
      o(parama);
      if ((((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject).errorCode == 0) && (this.ctI != null)) {
        this.ctI.a(this, this.cso, localBundle);
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
      this.csu = paramJSONObject.optBoolean("needEvent", false);
      if (Gj()) {
        this.ctH.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.ctS != null) {
      this.ctS.post(new Runnable()
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
  
  final void gG(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.ctG != null) {
      this.ctG.aK(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final boolean gK(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.ctP)
    {
      this.ctP = paramInt;
      ae.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.ctF != null)
      {
        this.ctF.gL(paramInt);
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
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", BN() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.ctS != null) {
      this.ctS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          a locala = a.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala1 = parama;
          Object localObject1 = locala1.FK();
          if (!bu.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala1.FJ();
            ae.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.BN(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              locala.gG(5);
              localObject1 = locala1.getContext();
              if (!(localObject1 instanceof Activity))
              {
                ae.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala1.dw("fail:internal error invalid android context");
                r.UC(locala1.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              locala.ctL = 0;
              locala.a((Activity)localObject1, locala1);
              AppMethodBeat.o(138874);
              return;
            }
            com.tencent.luggage.xweb_ext.extendplugin.component.a.a locala2;
            if (((String)localObject1).contains("update"))
            {
              locala.gG(6);
              if (locala.ctF == null)
              {
                ae.i(locala.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.FJ();
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.k((JSONObject)localObject1);
              locala.l((JSONObject)localObject1);
              locala.j((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.h((JSONObject)localObject1);
              locala2 = locala.ctF.o((Bundle)localObject2);
              ae.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(locala2.errorCode), locala2.csi });
              if (locala2.errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.dw((String)localObject1);
                locala.n(locala1);
                locala.o(locala1);
                if ((locala2.errorCode == 0) && (locala.ctI != null)) {
                  locala.ctI.b(locala.cso, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              locala.gG(7);
              if (locala.ctF == null)
              {
                ae.i(locala.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.FJ();
              localObject2 = ((JSONObject)localObject1).optString("type");
              ae.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!bu.isNullOrNil((String)localObject2)) && (locala.ctF != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  locala.ctF.cui = new a.8(locala, locala1);
                  if (locala.ctF.c("snapshot", locala1.FJ()).errorCode != 0) {
                    locala1.dw("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (locala.ctI != null)
                  {
                    locala.ctI.b(locala1, new a.9(locala));
                    locala1.dw("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala1.dw("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                locala2 = locala.ctF.c((String)localObject2, (JSONObject)localObject1);
                ae.i(locala.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(locala2.errorCode), locala2.csi });
                if (locala2.errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala1.dw((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (locala2.errorCode == 0) && (locala.ctI != null)) {
                    locala.ctI.c(locala, locala.cso);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala1.dw("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              locala.gG(8);
              locala.release();
              locala1.dw("ok");
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
        this.csq = g.vO(paramJSONObject.optInt("width", 0));
        this.csr = g.vO(paramJSONObject.optInt("height", 0));
        ae.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.csq), Integer.valueOf(this.csr) });
        Gi();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.ctJ = paramJSONObject.optString("filterImage", this.ctJ);
      this.ctK = paramJSONObject.optString("filterImageMd5", null);
      if (bu.isNullOrNil(this.ctJ)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          AppMethodBeat.o(178836);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          ae.w(getLogTag(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          AppMethodBeat.o(178836);
          return;
        }
      }
      if ((this.ctJ.startsWith("http://")) || (this.ctJ.startsWith("https://"))) {
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
      this.ctM = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  public final void l(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.ctS != null) {
      this.ctS.post(new Runnable()
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
      this.ctN = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  final void n(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.ctI != null) {
      this.ctI.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(138857);
          if (!bu.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ae.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ctF != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              a.this.ctF.o(paramAnonymousString2);
            }
            AppMethodBeat.o(138857);
            return;
          }
          ae.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (a.this.ctH != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ctH.a(a.this.getId(), 10004, "load background image fail", paramAnonymousString2);
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
    if ((this.ctI != null) && (!bu.isNullOrNil(this.ctJ))) {
      this.ctI.a(parama, this.ctJ, this.ctK, new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          if (!bu.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ae.i(a.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ctF != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              a.this.ctF.o(paramAnonymousString2);
            }
            AppMethodBeat.o(178819);
            return;
          }
          ae.i(a.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (a.this.ctH != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ctH.a(a.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
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
    if (this.ctI != null)
    {
      this.ctI.c(this, this.cso);
      this.ctI.a(this, this.cso);
    }
    if (this.ctF != null)
    {
      this.ctF.Gt();
      this.ctF = null;
    }
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
    ae.i(getLogTag(), "LivePusher release handler thread");
    if (this.ctS != null) {
      this.ctS.removeCallbacksAndMessages(null);
    }
    if (this.ctT != null) {
      this.ctT.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final void s(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.ctF != null)
    {
      this.ctF.cub.setFocusPosition(paramFloat1, paramFloat2);
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a locala = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
      ae.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(locala.errorCode), locala.csi });
    }
    AppMethodBeat.o(138894);
  }
  
  final class a
    implements Runnable
  {
    int ctY;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = a.getRotationAngle();
      if (i == this.ctY)
      {
        a.this.gK(i);
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
    MotionEvent ctZ;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((a.this.ctM) && (a.this.csq != 0) && (a.this.csr != 0)) {
        a.this.s(this.ctZ.getX() / a.this.csq, this.ctZ.getY() / a.this.csr);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a
 * JD-Core Version:    0.7.0.1
 */