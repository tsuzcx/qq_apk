package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

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
import com.tencent.f.c.d;
import com.tencent.luggage.h.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePusher;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.o
{
  com.tencent.luggage.xweb_ext.extendplugin.a cED;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a cEE;
  int cEF;
  int cEG;
  private boolean cEJ;
  r cHl;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c cHm;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b cHn;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a cHo;
  private String cHp;
  private String cHq;
  int cHr;
  boolean cHs;
  private boolean cHt;
  private c cHu;
  private int cHv;
  ad cHw;
  a cHx;
  Handler cHy;
  private HandlerThread cHz;
  int mCurrentScale;
  Handler mHandler;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public o()
  {
    AppMethodBeat.i(138878);
    this.cHp = "";
    this.mCurrentScale = 1;
    this.cHu = new c((byte)0);
    this.cHv = 0;
    this.cHx = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f2 = 0.9F;
        AppMethodBeat.i(215646);
        r localr = o.this.cHl;
        int j;
        float f3;
        float f1;
        label86:
        int k;
        int i;
        if (localr.cHV != null)
        {
          j = localr.cHV.getMaxZoom();
          if (j > 0)
          {
            f3 = paramAnonymousScaleGestureDetector.getScaleFactor();
            if (f3 <= 1.0F) {
              break label288;
            }
            f2 = 0.2F / j * (j - o.this.mCurrentScale) + 1.0F;
            f1 = f2;
            if (f2 <= 1.1F) {
              f1 = 1.1F;
            }
            k = Math.round(o.this.mCurrentScale * f1);
            i = k;
            if (k == o.this.mCurrentScale)
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
            if (i >= o.this.mCurrentScale) {
              break label382;
            }
            i = o.this.mCurrentScale;
          }
        }
        label288:
        label333:
        label352:
        label382:
        for (;;)
        {
          o.this.mCurrentScale = i;
          if (o.this.cHl != null)
          {
            Log.i(o.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(o.this.mCurrentScale) });
            paramAnonymousScaleGestureDetector = o.this.cHl;
            i = o.this.mCurrentScale;
            paramAnonymousScaleGestureDetector.cHV.setZoom(i);
            new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
          }
          AppMethodBeat.o(215646);
          return false;
          j = 0;
          break;
          f1 = f3;
          if (f3 < 1.0F)
          {
            f3 = 1.0F - 0.2F / j * o.this.mCurrentScale;
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
          if ((f1 < 1.0F) && (i > o.this.mCurrentScale)) {
            i = o.this.mCurrentScale;
          }
        }
      }
      
      public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.cHz = d.hA(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cHz.start();
    this.cHy = new Handler(this.cHz.getLooper());
    this.mHandler = new Handler(MMApplicationContext.getContext().getMainLooper());
    com.tencent.luggage.xweb_ext.extendplugin.component.live.b.PP();
    this.cHl = new r(MMApplicationContext.getContext());
    this.cHl.mHandler = this.cHy;
    this.cHl.cHW = new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (o.this.PS()) {
          o.this.cHn.e(o.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (o.this.PS())
        {
          Log.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          o.this.cHn.b(o.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (o.this.cHo != null))
        {
          o.this.cHo.b(o.this, o.this.cED);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (o.this.cHo != null)) {
          o.this.cHo.c(o.this, o.this.cED);
        }
        AppMethodBeat.o(178826);
      }
    };
    this.cHl.cId = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (o.this.PS()) {
          o.this.cHn.bX(o.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (o.this.PS()) {
          o.this.cHn.g(o.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (o.this.PS()) {
          o.this.cHn.ic(o.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    };
    this.cHl.cIe = new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (o.this.PS()) {
          o.this.cHn.bY(o.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    };
    this.cHw = new ad(MMApplicationContext.getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (o.17.cHH[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = o.this.cHx;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.cHA.mHandler.removeCallbacks(paramAnonymousa1);
          o.this.cHx.cHJ = i;
          paramAnonymousa1 = o.this.cHx;
          paramAnonymousa1.cHA.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.cHw.enable();
    ia(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          o.this.mScaleGestureDetector = new ScaleGestureDetector(MMApplicationContext.getContext(), o.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
  }
  
  private void PR()
  {
    AppMethodBeat.i(138888);
    if ((this.cEF != 0) && (this.cEG != 0) && (this.mSurfaceTexture != null) && (this.cHl != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.cEF), Integer.valueOf(this.cEG) });
      this.mSurfaceTexture.setDefaultBufferSize(this.cEF, this.cEG);
      this.cHl.bV(this.cEF, this.cEG);
    }
    AppMethodBeat.o(138888);
  }
  
  static int getRotationAngle()
  {
    AppMethodBeat.i(138879);
    if (MMApplicationContext.getContext().getSystemService("window") != null)
    {
      int i = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(138879);
      return i;
    }
    AppMethodBeat.o(138879);
    return 0;
  }
  
  public final void PG()
  {
    AppMethodBeat.i(215650);
    if (this.cHy != null) {
      this.cHy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215645);
          if (o.this.cHl != null)
          {
            o.this.cHl.f("stop", new JSONObject());
            r localr = o.this.cHl;
            if (localr.cHW != null)
            {
              Log.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
              localr.cHW.onPushEvent(5001, new Bundle());
            }
          }
          AppMethodBeat.o(215645);
        }
      });
    }
    AppMethodBeat.o(215650);
  }
  
  public final String PH()
  {
    AppMethodBeat.i(215651);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(215651);
    return str;
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(138882);
    if (this.cHy != null) {
      this.cHy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138870);
          o.a(o.this);
          AppMethodBeat.o(138870);
        }
      });
    }
    AppMethodBeat.o(138882);
  }
  
  final boolean PS()
  {
    return this.cHn != null;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.cHr;
    this.cHr = (i + 1);
    if (i > 5)
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.dP("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    com.tencent.mm.plugin.appbrand.permission.r.b(parama.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(215644);
        Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(215642);
                o.this.a(o.14.this.val$activity, o.14.this.cFk);
                AppMethodBeat.o(215642);
              }
            }, 50L);
            AppMethodBeat.o(215644);
            return;
          }
          Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          parama.dP("fail:system permission denied");
          AppMethodBeat.o(215644);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(215643);
                o.this.a(o.14.this.val$activity, o.14.this.cFk);
                AppMethodBeat.o(215643);
              }
            }, 50L);
            AppMethodBeat.o(215644);
            return;
          }
          Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          parama.dP("fail:system permission denied");
        }
        AppMethodBeat.o(215644);
      }
    });
    if (!i.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.dP("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    if (!i.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.dP("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    if (this.cHl == null)
    {
      Log.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(138891);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.cED = parama;
    this.cEE = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void hU(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        Log.i(o.this.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramAnonymousInt)));
        o localo = o.this;
        if (localo.cHy != null) {
          localo.cHy.post(new o.4(localo, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        o localo = o.this;
        if (localo.cHy != null) {
          localo.cHy.post(new o.5(localo));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        Log.i(o.this.getLogTag(), "onForeground");
        o localo = o.this;
        if (localo.cHy != null) {
          localo.cHy.post(new o.3(localo));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.cEE);
    paramActivity = parama.Ps();
    a(parama, paramActivity);
    i(paramActivity);
    k(paramActivity);
    l(paramActivity);
    j(paramActivity);
    Bundle localBundle = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.h(paramActivity);
    if (this.cHo != null)
    {
      paramActivity = this.cHo.c(parama, localBundle);
      if (!Util.isNullOrNil(paramActivity))
      {
        Log.i(getLogTag(), "insert fail, message:%s", new Object[] { paramActivity });
        parama.dP("fail: can not insert VOIP mode LivePusher now");
        Toast.makeText(parama.getContext(), paramActivity, 0).show();
        AppMethodBeat.o(138891);
        return;
      }
    }
    paramActivity = this.cHl;
    if (paramActivity.cHW != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      paramActivity.cHW.onPushEvent(-9999999, (Bundle)localObject);
    }
    r.l("InitLivePusher", localBundle);
    paramActivity.mVideoView = null;
    paramActivity.cHX = localBundle.getString("pushUrl", "");
    paramActivity.cHV.setPusherUrl(paramActivity.cHX);
    paramActivity.a(localBundle, true);
    paramActivity.cIh = localBundle.getBoolean("autopush", paramActivity.cIh);
    if ((paramActivity.cIh) && (paramActivity.cHX != null) && (!paramActivity.cHX.isEmpty()) && (!paramActivity.cHV.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      paramActivity.ca(paramActivity.cIm);
      paramActivity.cb(paramActivity.cIn);
      if ((paramActivity.cIm) && (paramActivity.mSurface != null)) {
        paramActivity.cHV.setSurface(paramActivity.mSurface);
      }
      paramActivity.cHV.startPusher(paramActivity.cHX);
    }
    paramActivity.mInited = true;
    Object localObject = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
    Log.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject).errorInfo });
    if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject).errorCode == 0) {}
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      parama.dP(paramActivity);
      n(parama);
      o(parama);
      if ((((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject).errorCode == 0) && (this.cHo != null)) {
        this.cHo.a(this, this.cED, localBundle);
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
      this.cEJ = paramJSONObject.optBoolean("needEvent", false);
      if (PS()) {
        this.cHn.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  final void a(String[] paramArrayOfString1, String[] paramArrayOfString2, final String[] paramArrayOfString3, final JSONObject paramJSONObject1, final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(215649);
    int j = paramArrayOfString1.length;
    final b localb = new b((byte)0);
    localb.count = j;
    final int i = 0;
    while (i < j)
    {
      this.cHo.a(parama, paramArrayOfString1[i], paramArrayOfString2[i], false, new a.b()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(215638);
          Log.i(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            paramJSONObject1.put(paramArrayOfString3[i], paramAnonymousString2);
            if (o.this.cHl == null)
            {
              Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(215638);
              return;
            }
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.dP("fail");
            AppMethodBeat.o(215638);
            return;
          }
          paramAnonymousString1 = localb;
          paramAnonymousString1.count -= 1;
          Log.i(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
          if (localb.count == 0)
          {
            paramAnonymousString1 = o.this.cHl.f("applyMakeup", paramJSONObject2);
            Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousString1.errorCode), paramAnonymousString1.errorInfo });
            paramAnonymousString2 = parama;
            if (paramAnonymousString1.errorCode != 0) {
              break label301;
            }
          }
          label301:
          for (paramAnonymousString1 = "ok";; paramAnonymousString1 = "fail")
          {
            paramAnonymousString2.dP(paramAnonymousString1);
            AppMethodBeat.o(215638);
            return;
          }
        }
        
        public final void Qi()
        {
          AppMethodBeat.i(215637);
          Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoadFailure#" + i);
          parama.dP("fail");
          AppMethodBeat.o(215637);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(215649);
  }
  
  final void b(final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215648);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("stickers");
    int j;
    if (localJSONArray != null)
    {
      j = localJSONArray.length();
      if (j != 0) {}
    }
    else
    {
      Log.w(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, stickersJsonArr is empty");
      parama.dP("fail");
      AppMethodBeat.o(215648);
      return;
    }
    final b localb = new b((byte)0);
    localb.count = j;
    final int i = 0;
    while (i < j)
    {
      final JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject == null)
      {
        Log.w(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, stickerJsonObj(%d) is null", new Object[] { Integer.valueOf(i) });
        parama.dP("fail");
        AppMethodBeat.o(215648);
        return;
      }
      String str1 = localJSONObject.optString("path", null);
      if (Util.isNullOrNil(str1))
      {
        Log.i(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", new Object[] { Integer.valueOf(i) });
        parama.dP("fail");
        AppMethodBeat.o(215648);
        return;
      }
      String str2 = localJSONObject.optString("md5", null);
      this.cHo.a(parama, str1, str2, true, new a.b()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            localJSONObject.put("path", paramAnonymousString2);
            if (o.this.cHl == null)
            {
              Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(178819);
              return;
            }
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.dP("fail");
            AppMethodBeat.o(178819);
            return;
          }
          paramAnonymousString1 = localb;
          paramAnonymousString1.count -= 1;
          Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
          if (localb.count == 0)
          {
            paramAnonymousString1 = o.this.cHl.f("applySticker", paramJSONObject);
            Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applySticker, error:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousString1.errorCode), paramAnonymousString1.errorInfo });
            paramAnonymousString2 = parama;
            if (paramAnonymousString1.errorCode != 0) {
              break label294;
            }
          }
          label294:
          for (paramAnonymousString1 = "ok";; paramAnonymousString1 = "fail")
          {
            paramAnonymousString2.dP(paramAnonymousString1);
            AppMethodBeat.o(178819);
            return;
          }
        }
        
        public final void Qi()
        {
          AppMethodBeat.i(215636);
          Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoadFailure#" + i);
          parama.dP("fail");
          AppMethodBeat.o(215636);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(215648);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.cHy != null) {
      this.cHy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138869);
          o.a(o.this, paramSurfaceTexture);
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
  
  final String getLogTag()
  {
    AppMethodBeat.i(138877);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", Lb() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.cHy != null) {
      this.cHy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          o localo = o.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = parama;
          Object localObject1 = locala.Pt();
          if (!Util.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala.Ps();
            Log.i(localo.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localo.Lb(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              localo.hV(5);
              localObject1 = locala.getContext();
              if (!(localObject1 instanceof Activity))
              {
                Log.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala.dP("fail:internal error invalid android context");
                com.tencent.mm.plugin.appbrand.permission.r.aeq(locala.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              localo.cHr = 0;
              localo.a((Activity)localObject1, locala);
              AppMethodBeat.o(138874);
              return;
            }
            Object localObject3;
            if (((String)localObject1).contains("update"))
            {
              localo.hV(6);
              if (localo.cHl == null)
              {
                Log.i(localo.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala.Ps();
              localo.a(locala, (JSONObject)localObject1);
              localo.i((JSONObject)localObject1);
              localo.k((JSONObject)localObject1);
              localo.l((JSONObject)localObject1);
              localo.j((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.h((JSONObject)localObject1);
              if (localo.cHo != null)
              {
                localObject1 = localo.cHo.c(locala, (Bundle)localObject2);
                if (!Util.isNullOrNil((String)localObject1))
                {
                  Log.i(localo.getLogTag(), "update fail, message:%s", new Object[] { localObject1 });
                  locala.dP("fail: can not update LivePusher to VOIP mode now");
                  Toast.makeText(locala.getContext(), (CharSequence)localObject1, 0).show();
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              localObject3 = localo.cHl.o((Bundle)localObject2);
              Log.i(localo.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorInfo });
              if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala.dP((String)localObject1);
                localo.n(locala);
                localo.o(locala);
                if ((((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode == 0) && (localo.cHo != null))
                {
                  localo.cHo.a(localo, localo.cED, (Bundle)localObject2);
                  localo.cHo.b(localo.cED, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              localo.hV(7);
              if (localo.cHl == null)
              {
                Log.i(localo.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              JSONObject localJSONObject1 = locala.Ps();
              localObject2 = localJSONObject1.optString("type");
              Log.i(localo.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!Util.isNullOrNil((String)localObject2)) && (localo.cHl != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  localo.cHl.cIc = new o.11(localo, locala);
                  if (localo.cHl.f("snapshot", locala.Ps()).errorCode != 0) {
                    locala.dP("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (localo.cHo != null)
                  {
                    localo.cHo.b(locala, new o.13(localo));
                    locala.dP("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala.dP("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                int i;
                if ((((String)localObject2).equalsIgnoreCase("applyFilter")) || (((String)localObject2).equalsIgnoreCase("applySticker")) || (((String)localObject2).equalsIgnoreCase("applyMakeup"))) {
                  i = 1;
                }
                while (i != 0) {
                  if (localo.cHo == null)
                  {
                    Log.w(localo.getLogTag(), "convertResourcePathAndOperateLivePusher, customHandler is null");
                    locala.dP("fail");
                    AppMethodBeat.o(138874);
                    return;
                    i = 0;
                  }
                  else
                  {
                    localObject1 = localJSONObject1.optString("path", null);
                    if (Util.isNullOrNil((String)localObject1))
                    {
                      Log.i(localo.getLogTag(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
                      Log.i(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher");
                      if (((String)localObject2).equalsIgnoreCase("applySticker"))
                      {
                        localo.b(locala, localJSONObject1);
                        AppMethodBeat.o(138874);
                        return;
                      }
                      if (((String)localObject2).equalsIgnoreCase("applyMakeup"))
                      {
                        localObject1 = localJSONObject1.optString("makeupType", null);
                        if (Util.isNullOrNil((String)localObject1))
                        {
                          Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
                          locala.dP("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("makeup");
                        if (localJSONObject2 == null)
                        {
                          Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
                          locala.dP("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        if (((String)localObject1).equalsIgnoreCase("lipStick"))
                        {
                          localObject1 = localo.cHl.f("applyMakeup", localJSONObject1);
                          Log.i(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorInfo });
                          if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject1).errorCode == 0) {}
                          for (localObject1 = "ok";; localObject1 = "fail")
                          {
                            locala.dP((String)localObject1);
                            AppMethodBeat.o(138874);
                            return;
                          }
                        }
                        String str;
                        if (((String)localObject1).equalsIgnoreCase("eyeShadow"))
                        {
                          localObject2 = localJSONObject2.optString("leftPath", null);
                          if (Util.isNullOrNil((String)localObject2))
                          {
                            Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                            locala.dP("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject3 = localJSONObject2.optString("leftPathMD5", null);
                          str = localJSONObject2.optString("shimmerPosition", null);
                          if (!Util.isNullOrNil(str))
                          {
                            localObject1 = new String[2];
                            localObject1[0] = localObject2;
                            localObject1[1] = str;
                            str = localJSONObject2.optString("shimmerPositionMD5", null);
                            localObject2 = new String[2];
                            localObject2[0] = localObject3;
                            localObject2[1] = str;
                            localObject3 = new String[2];
                            localObject3[0] = "leftPath";
                            localObject3[1] = "shimmerPosition";
                          }
                          for (;;)
                          {
                            localo.a((String[])localObject1, (String[])localObject2, (String[])localObject3, localJSONObject2, locala, localJSONObject1);
                            AppMethodBeat.o(138874);
                            return;
                            localObject1 = new String[1];
                            localObject1[0] = localObject2;
                            localObject2 = new String[1];
                            localObject2[0] = localObject3;
                            localObject3 = new String[1];
                            localObject3[0] = "leftPath";
                          }
                        }
                        if ((((String)localObject1).equalsIgnoreCase("blusherStick")) || (((String)localObject1).equalsIgnoreCase("eyeBrow")))
                        {
                          localObject1 = localJSONObject2.optString("leftPath", null);
                          if (Util.isNullOrNil((String)localObject1))
                          {
                            Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                            locala.dP("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject2 = localJSONObject2.optString("leftPathMD5", null);
                          localObject3 = localJSONObject2.optString("rightPath", null);
                          if (Util.isNullOrNil((String)localObject3))
                          {
                            Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, rightPath is empty");
                            locala.dP("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          str = localJSONObject2.optString("rightPathMD5", null);
                          localo.a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str }, new String[] { "leftPath", "rightPath" }, localJSONObject2, locala, localJSONObject1);
                          AppMethodBeat.o(138874);
                          return;
                        }
                        if (((String)localObject1).equalsIgnoreCase("faceContour"))
                        {
                          localObject1 = localJSONObject2.optString("highlightPath", null);
                          if (Util.isNullOrNil((String)localObject1))
                          {
                            Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, highLightPath is empty");
                            locala.dP("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject2 = localJSONObject2.optString("highlightPathMD5", null);
                          localObject3 = localJSONObject2.optString("shadowPath", null);
                          if (Util.isNullOrNil((String)localObject3))
                          {
                            Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, shadowPath is empty");
                            locala.dP("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          str = localJSONObject2.optString("shadowPathMD5", null);
                          localo.a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str }, new String[] { "highlightPath", "shadowPath" }, localJSONObject2, locala, localJSONObject1);
                          AppMethodBeat.o(138874);
                          return;
                        }
                        Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
                        locala.dP("fail");
                        AppMethodBeat.o(138874);
                        return;
                      }
                      Log.w(localo.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
                      locala.dP("fail");
                      AppMethodBeat.o(138874);
                      return;
                    }
                    localObject3 = localJSONObject1.optString("md5", null);
                    boolean bool = ((String)localObject2).equalsIgnoreCase("applySticker");
                    localo.cHo.a(locala, (String)localObject1, (String)localObject3, bool, new o.6(localo, locala, localJSONObject1, (String)localObject2));
                    AppMethodBeat.o(138874);
                    return;
                  }
                }
                localObject3 = localo.cHl.f((String)localObject2, localJSONObject1);
                Log.i(localo.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorInfo });
                if (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala.dP((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (((com.tencent.luggage.xweb_ext.extendplugin.component.live.a)localObject3).errorCode == 0) && (localo.cHo != null)) {
                    localo.cHo.c(localo, localo.cED);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala.dP("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              localo.hV(8);
              localo.release();
              locala.dP("ok");
            }
          }
          AppMethodBeat.o(138874);
        }
      });
    }
    AppMethodBeat.o(138884);
    return null;
  }
  
  final void hV(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.cHm != null) {
      this.cHm.aW(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138887);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.cEF = g.zD(paramJSONObject.optInt("width", 0));
        this.cEG = g.zD(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.cEF), Integer.valueOf(this.cEG) });
        PR();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final boolean ia(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.cHv)
    {
      this.cHv = paramInt;
      Log.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.cHl != null)
      {
        this.cHl.ib(paramInt);
        AppMethodBeat.o(138880);
        return true;
      }
    }
    AppMethodBeat.o(138880);
    return false;
  }
  
  final void j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.cHp = paramJSONObject.optString("filterImage", this.cHp);
      this.cHq = paramJSONObject.optString("filterImageMd5", null);
      if (Util.isNullOrNil(this.cHp)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          AppMethodBeat.o(178836);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          Log.w(getLogTag(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          AppMethodBeat.o(178836);
          return;
        }
      }
      if ((this.cHp.startsWith("http://")) || (this.cHp.startsWith("https://"))) {
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
      this.cHs = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  final void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138890);
    if (paramJSONObject.has("zoom")) {
      this.cHt = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  final void n(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.cHo != null) {
      this.cHo.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178821);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            Log.i(o.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (o.this.cHl != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              o.this.cHl.o(paramAnonymousString2);
            }
            AppMethodBeat.o(178821);
            return;
          }
          Log.i(o.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (o.this.cHn != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            o.this.cHn.a(o.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(178821);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  public final void o(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.cHy != null) {
      this.cHy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178834);
          o.a(o.this, paramMotionEvent);
          AppMethodBeat.o(178834);
        }
      });
    }
    AppMethodBeat.o(138883);
  }
  
  final void o(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.cHo != null) && (!Util.isNullOrNil(this.cHp))) {
      this.cHo.a(parama, this.cHp, this.cHq, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void F(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(215639);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            Log.i(o.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (o.this.cHl != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              o.this.cHl.o(paramAnonymousString2);
            }
            AppMethodBeat.o(215639);
            return;
          }
          Log.i(o.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (o.this.cHn != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            o.this.cHn.a(o.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(215639);
        }
      });
    }
    AppMethodBeat.o(178835);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.cHo != null)
    {
      this.cHo.c(this, this.cED);
      this.cHo.a(this, this.cED);
    }
    if (this.cHl != null)
    {
      this.cHl.Qj();
      this.cHl = null;
    }
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
    Log.i(getLogTag(), "LivePusher release handler thread");
    if (this.cHy != null) {
      this.cHy.removeCallbacksAndMessages(null);
    }
    if (this.cHz != null) {
      this.cHz.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final void t(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.cHl != null)
    {
      this.cHl.cHV.setFocusPosition(paramFloat1, paramFloat2);
      com.tencent.luggage.xweb_ext.extendplugin.component.live.a locala = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
      Log.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(locala.errorCode), locala.errorInfo });
    }
    AppMethodBeat.o(138894);
  }
  
  final class a
    implements Runnable
  {
    int cHJ;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = o.getRotationAngle();
      if (i == this.cHJ)
      {
        o.this.ia(i);
        AppMethodBeat.o(138875);
        return;
      }
      if (this.number < 8) {
        o.this.mHandler.postDelayed(this, 250L);
      }
      AppMethodBeat.o(138875);
    }
  }
  
  static final class b
  {
    int count;
  }
  
  final class c
    implements Runnable
  {
    MotionEvent cHK;
    
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((o.this.cHs) && (o.this.cEF != 0) && (o.this.cEG != 0)) {
        o.this.t(this.cHK.getX() / o.this.cEF, this.cHK.getY() / o.this.cEG);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o
 * JD-Core Version:    0.7.0.1
 */