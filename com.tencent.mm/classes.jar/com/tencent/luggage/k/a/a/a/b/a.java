package com.tencent.luggage.k.a.a.a.b;

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
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
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
  extends com.tencent.luggage.k.a.b.a
  implements n
{
  private boolean ckA;
  com.tencent.luggage.k.a.a cku;
  private com.tencent.luggage.k.a.a.a ckv;
  int ckw;
  int ckx;
  b clK;
  public com.tencent.luggage.k.a.a.a.b.a.c clL;
  public com.tencent.luggage.k.a.a.a.b.a.b clM;
  public com.tencent.luggage.k.a.a.a.b.a.a clN;
  private String clO;
  private String clP;
  int clQ;
  boolean clR;
  private boolean clS;
  private b clT;
  private int clU;
  z clV;
  a clW;
  Handler clX;
  private HandlerThread clY;
  int mCurrentScale;
  Handler mHandler;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(138878);
    this.clO = "";
    this.mCurrentScale = 1;
    this.clT = new b((byte)0);
    this.clU = 0;
    this.clW = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f2 = 0.9F;
        AppMethodBeat.i(194985);
        b localb = a.this.clK;
        int j;
        float f3;
        float f1;
        label86:
        int k;
        int i;
        if (localb.cmg != null)
        {
          j = localb.cmg.getMaxZoom();
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
          if (a.this.clK != null)
          {
            ad.i(a.this.EE(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(a.this.mCurrentScale) });
            paramAnonymousScaleGestureDetector = a.this.clK;
            i = a.this.mCurrentScale;
            paramAnonymousScaleGestureDetector.cmg.setZoom(i);
            new com.tencent.luggage.k.a.a.a.a();
          }
          AppMethodBeat.o(194985);
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
    this.clY = d.gv(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.clY.start();
    this.clX = new Handler(this.clY.getLooper());
    this.mHandler = new Handler(aj.getContext().getMainLooper());
    com.tencent.luggage.k.a.a.a.b.EX();
    this.clK = new b(aj.getContext());
    this.clK.mHandler = this.clX;
    this.clK.cmh = new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (a.this.Fa()) {
          a.this.clM.e(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (a.this.Fa())
        {
          ad.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          a.this.clM.b(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (a.this.clN != null))
        {
          a.this.clN.b(a.this, a.this.cku);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (a.this.clN != null)) {
          a.this.clN.c(a.this, a.this.cku);
        }
        AppMethodBeat.o(178826);
      }
    };
    this.clK.cmo = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (a.this.Fa()) {
          a.this.clM.bY(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (a.this.Fa()) {
          a.this.clM.f(a.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (a.this.Fa()) {
          a.this.clM.gW(a.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    };
    this.clK.cmp = new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (a.this.Fa()) {
          a.this.clM.bZ(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    };
    this.clV = new z(aj.getContext(), new z.b()
    {
      public final void a(z.a paramAnonymousa1, z.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (a.14.cmb[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = a.this.clW;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.clZ.mHandler.removeCallbacks(paramAnonymousa1);
          a.this.clW.cmd = i;
          paramAnonymousa1 = a.this.clW;
          paramAnonymousa1.clZ.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.clV.enable();
    gU(getRotationAngle());
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
  
  private void EZ()
  {
    AppMethodBeat.i(138888);
    if ((this.ckw != 0) && (this.ckx != 0) && (this.mSurfaceTexture != null) && (this.clK != null))
    {
      ad.i(EE(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.ckw), Integer.valueOf(this.ckx) });
      this.mSurfaceTexture.setDefaultBufferSize(this.ckw, this.ckx);
      this.clK.bW(this.ckw, this.ckx);
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
  
  final String EE()
  {
    AppMethodBeat.i(138877);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", AL() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final void EO()
  {
    AppMethodBeat.i(194987);
    if (this.clX != null) {
      this.clX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194984);
          if (a.this.clK != null)
          {
            a.this.clK.c("stop", new JSONObject());
            b localb = a.this.clK;
            if (localb.cmh != null)
            {
              ad.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
              localb.cmh.onPushEvent(5001, new Bundle());
            }
          }
          AppMethodBeat.o(194984);
        }
      });
    }
    AppMethodBeat.o(194987);
  }
  
  public final String EP()
  {
    AppMethodBeat.i(194988);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(194988);
    return str;
  }
  
  public final void EY()
  {
    AppMethodBeat.i(138882);
    if (this.clX != null) {
      this.clX.post(new Runnable()
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
  
  final boolean Fa()
  {
    return this.clM != null;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.clQ;
    this.clQ = (i + 1);
    if (i > 5)
    {
      ad.i(EE(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.cD("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    o.b(parama.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(178824);
        ad.i(a.this.EE(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178822);
                a.this.a(a.10.this.val$activity, a.10.this.ckZ);
                AppMethodBeat.o(178822);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ad.i(a.this.EE(), "onRequestPermissionsResult callback, camera permission not grant");
          parama.cD("fail:system permission denied");
          AppMethodBeat.o(178824);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178823);
                a.this.a(a.10.this.val$activity, a.10.this.ckZ);
                AppMethodBeat.o(178823);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ad.i(a.this.EE(), "onRequestPermissionsResult callback, microphone permission not grant");
          parama.cD("fail:system permission denied");
        }
        AppMethodBeat.o(178824);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ad.i(EE(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.cD("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ad.i(EE(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.cD("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    ad.i(EE(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    if (this.clK == null)
    {
      ad.i(EE(), "insert, adapter is null");
      AppMethodBeat.o(138891);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.cku = parama;
    this.ckv = new com.tencent.luggage.k.a.a.a()
    {
      public final void gP(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        a locala = a.this;
        if (locala.clX != null) {
          locala.clX.post(new a.4(locala, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        a locala = a.this;
        if (locala.clX != null) {
          locala.clX.post(new a.5(locala));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        a locala = a.this;
        if (locala.clX != null) {
          locala.clX.post(new a.3(locala));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.ckv);
    paramActivity = parama.EB();
    a(parama, paramActivity);
    i(paramActivity);
    k(paramActivity);
    l(paramActivity);
    j(paramActivity);
    Bundle localBundle = com.tencent.luggage.k.a.a.a.c.h(paramActivity);
    if (this.clN != null)
    {
      paramActivity = this.clN.c(parama, localBundle);
      if (!bt.isNullOrNil(paramActivity))
      {
        ad.i(EE(), "insert fail, message:%s", new Object[] { paramActivity });
        parama.cD("fail: can not insert RTC mode LivePusher now");
        Toast.makeText(parama.getContext(), paramActivity, 0).show();
        AppMethodBeat.o(138891);
        return;
      }
    }
    paramActivity = this.clK;
    if (paramActivity.cmh != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      paramActivity.cmh.onPushEvent(-9999999, (Bundle)localObject);
    }
    b.l("InitLivePusher", localBundle);
    paramActivity.mVideoView = null;
    paramActivity.cmi = localBundle.getString("pushUrl", "");
    paramActivity.cmg.setPusherUrl(paramActivity.cmi);
    paramActivity.a(localBundle, true);
    paramActivity.cms = localBundle.getBoolean("autopush", paramActivity.cms);
    if ((paramActivity.cms) && (paramActivity.cmi != null) && (!paramActivity.cmi.isEmpty()) && (!paramActivity.cmg.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      paramActivity.bC(paramActivity.cmy);
      paramActivity.bD(paramActivity.cmz);
      if ((paramActivity.cmy) && (paramActivity.mSurface != null)) {
        paramActivity.cmg.setSurface(paramActivity.mSurface);
      }
      paramActivity.cmg.startPusher(paramActivity.cmi);
    }
    paramActivity.mInited = true;
    Object localObject = new com.tencent.luggage.k.a.a.a.a();
    ad.i(EE(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject).cko });
    if (((com.tencent.luggage.k.a.a.a.a)localObject).errorCode == 0) {}
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      parama.cD(paramActivity);
      o(parama);
      p(parama);
      if ((((com.tencent.luggage.k.a.a.a.a)localObject).errorCode == 0) && (this.clN != null)) {
        this.clN.a(this, this.cku, localBundle);
      }
      AppMethodBeat.o(138891);
      return;
    }
  }
  
  final void a(com.tencent.luggage.k.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138886);
    if (paramJSONObject.has("needEvent"))
    {
      this.ckA = paramJSONObject.optBoolean("needEvent", false);
      if (Fa()) {
        this.clM.n(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.clX != null) {
      this.clX.post(new Runnable()
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
  
  final void gQ(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.clL != null) {
      this.clL.aO(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final boolean gU(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.clU)
    {
      this.clU = paramInt;
      ad.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.clK != null)
      {
        this.clK.gV(paramInt);
        AppMethodBeat.o(138880);
        return true;
      }
    }
    AppMethodBeat.o(138880);
    return false;
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String i(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.clX != null) {
      this.clX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          a locala = a.this;
          com.tencent.luggage.k.a.a locala1 = parama;
          Object localObject1 = locala1.EC();
          if (!bt.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala1.EB();
            ad.i(locala.EE(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.AL(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              locala.gQ(5);
              localObject1 = locala1.getContext();
              if (!(localObject1 instanceof Activity))
              {
                ad.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala1.cD("fail:internal error invalid android context");
                o.Mi(locala1.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              locala.clQ = 0;
              locala.a((Activity)localObject1, locala1);
              AppMethodBeat.o(138874);
              return;
            }
            com.tencent.luggage.k.a.a.a.a locala2;
            if (((String)localObject1).contains("update"))
            {
              locala.gQ(6);
              if (locala.clK == null)
              {
                ad.i(locala.EE(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.EB();
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.k((JSONObject)localObject1);
              locala.l((JSONObject)localObject1);
              locala.j((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.k.a.a.a.c.h((JSONObject)localObject1);
              locala2 = locala.clK.o((Bundle)localObject2);
              ad.i(locala.EE(), "update, code:%d info:%s", new Object[] { Integer.valueOf(locala2.errorCode), locala2.cko });
              if (locala2.errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.cD((String)localObject1);
                locala.o(locala1);
                locala.p(locala1);
                if ((locala2.errorCode == 0) && (locala.clN != null)) {
                  locala.clN.b(locala.cku, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              locala.gQ(7);
              if (locala.clK == null)
              {
                ad.i(locala.EE(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.EB();
              localObject2 = ((JSONObject)localObject1).optString("type");
              ad.i(locala.EE(), "operate, type:%s", new Object[] { localObject2 });
              if ((!bt.isNullOrNil((String)localObject2)) && (locala.clK != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  locala.clK.cmn = new a.8(locala, locala1);
                  if (locala.clK.c("snapshot", locala1.EB()).errorCode != 0) {
                    locala1.cD("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (locala.clN != null)
                  {
                    locala.clN.b(locala1, new a.9(locala));
                    locala1.cD("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala1.cD("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                locala2 = locala.clK.c((String)localObject2, (JSONObject)localObject1);
                ad.i(locala.EE(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(locala2.errorCode), locala2.cko });
                if (locala2.errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala1.cD((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (locala2.errorCode == 0) && (locala.clN != null)) {
                    locala.clN.c(locala, locala.cku);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala1.cD("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              locala.gQ(8);
              locala.release();
              locala1.cD("ok");
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
        this.ckw = g.um(paramJSONObject.optInt("width", 0));
        this.ckx = g.um(paramJSONObject.optInt("height", 0));
        ad.i(EE(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.ckw), Integer.valueOf(this.ckx) });
        EZ();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.clO = paramJSONObject.optString("filterImage", this.clO);
      this.clP = paramJSONObject.optString("filterImageMd5", null);
      if (bt.isNullOrNil(this.clO)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          AppMethodBeat.o(178836);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          ad.w(EE(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          AppMethodBeat.o(178836);
          return;
        }
      }
      if ((this.clO.startsWith("http://")) || (this.clO.startsWith("https://"))) {
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
      this.clR = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  final void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138890);
    if (paramJSONObject.has("zoom")) {
      this.clS = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  public final void n(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.clX != null) {
      this.clX.post(new Runnable()
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
  
  final void o(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.clN != null) {
      this.clN.a(parama, new com.tencent.luggage.k.a.a.a.b.a.a.a()
      {
        public final void B(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(138857);
          if (!bt.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ad.i(a.this.EE(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.clK != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              a.this.clK.o(paramAnonymousString2);
            }
            AppMethodBeat.o(138857);
            return;
          }
          ad.i(a.this.EE(), "convertBackgroundImageToLocalPath, load background image fail");
          if (a.this.clM != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.clM.a(a.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(138857);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  final void p(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.clN != null) && (!bt.isNullOrNil(this.clO))) {
      this.clN.a(parama, this.clO, this.clP, new com.tencent.luggage.k.a.a.a.b.a.a.a()
      {
        public final void B(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          if (!bt.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ad.i(a.this.EE(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.clK != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              a.this.clK.o(paramAnonymousString2);
            }
            AppMethodBeat.o(178819);
            return;
          }
          ad.i(a.this.EE(), "convertFilterImageToLocalPath, load filter image fail");
          if (a.this.clM != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.clM.a(a.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(178819);
        }
      });
    }
    AppMethodBeat.o(178835);
  }
  
  final void q(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.clK != null)
    {
      this.clK.cmg.setFocusPosition(paramFloat1, paramFloat2);
      com.tencent.luggage.k.a.a.a.a locala = new com.tencent.luggage.k.a.a.a.a();
      ad.i(EE(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(locala.errorCode), locala.cko });
    }
    AppMethodBeat.o(138894);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.clN != null)
    {
      this.clN.c(this, this.cku);
      this.clN.a(this, this.cku);
    }
    if (this.clK != null)
    {
      this.clK.Fk();
      this.clK = null;
    }
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
    ad.i(EE(), "LivePusher release handler thread");
    if (this.clX != null) {
      this.clX.removeCallbacksAndMessages(null);
    }
    if (this.clY != null) {
      this.clY.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final class a
    implements Runnable
  {
    int cmd;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = a.getRotationAngle();
      if (i == this.cmd)
      {
        a.this.gU(i);
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
    MotionEvent cme;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((a.this.clR) && (a.this.ckw != 0) && (a.this.ckx != 0)) {
        a.this.q(this.cme.getX() / a.this.ckw, this.cme.getY() / a.this.ckx);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */