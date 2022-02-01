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
import com.tencent.luggage.k.a.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.aa.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements k
{
  com.tencent.luggage.k.a.a cht;
  private com.tencent.luggage.k.a.a.a chu;
  int chv;
  int chw;
  private boolean chz;
  b ciM;
  public com.tencent.luggage.k.a.a.a.b.a.c ciN;
  public com.tencent.luggage.k.a.a.a.b.a.b ciO;
  public com.tencent.luggage.k.a.a.a.b.a.a ciP;
  private String ciQ;
  private String ciR;
  int ciS;
  boolean ciT;
  private boolean ciU;
  private b ciV;
  private int ciW;
  aa ciX;
  a ciY;
  Handler ciZ;
  private HandlerThread cja;
  int mCurrentScale;
  Handler mHandler;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(138878);
    this.ciQ = "";
    this.mCurrentScale = 1;
    this.ciV = new b((byte)0);
    this.ciW = 0;
    this.ciY = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f2 = 0.9F;
        AppMethodBeat.i(206590);
        b localb = a.this.ciM;
        int j;
        float f3;
        float f1;
        label86:
        int k;
        int i;
        if (localb.cji != null)
        {
          j = localb.cji.getMaxZoom();
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
          if (a.this.ciM != null)
          {
            ac.i(a.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(a.this.mCurrentScale) });
            paramAnonymousScaleGestureDetector = a.this.ciM;
            i = a.this.mCurrentScale;
            paramAnonymousScaleGestureDetector.cji.setZoom(i);
            new com.tencent.luggage.k.a.a.a.a();
          }
          AppMethodBeat.o(206590);
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
    this.cja = d.gz(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cja.start();
    this.ciZ = new Handler(this.cja.getLooper());
    this.mHandler = new Handler(ai.getContext().getMainLooper());
    com.tencent.luggage.k.a.a.a.b.EB();
    this.ciM = new b(ai.getContext());
    this.ciM.mHandler = this.ciZ;
    this.ciM.cjj = new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (a.this.EE()) {
          a.this.ciO.e(a.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (a.this.EE())
        {
          ac.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          a.this.ciO.b(a.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (a.this.ciP != null))
        {
          a.this.ciP.b(a.this, a.this.cht);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (a.this.ciP != null)) {
          a.this.ciP.c(a.this, a.this.cht);
        }
        AppMethodBeat.o(178826);
      }
    };
    this.ciM.cjq = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (a.this.EE()) {
          a.this.ciO.bV(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (a.this.EE()) {
          a.this.ciO.f(a.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (a.this.EE()) {
          a.this.ciO.gG(a.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    };
    this.ciM.cjr = new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (a.this.EE()) {
          a.this.ciO.bW(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    };
    this.ciX = new aa(ai.getContext(), new aa.b()
    {
      public final void a(aa.a paramAnonymousa1, aa.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (a.14.cjd[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = a.this.ciY;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.cjb.mHandler.removeCallbacks(paramAnonymousa1);
          a.this.ciY.cjf = i;
          paramAnonymousa1 = a.this.ciY;
          paramAnonymousa1.cjb.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.ciX.enable();
    gE(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          a.this.mScaleGestureDetector = new ScaleGestureDetector(ai.getContext(), a.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
  }
  
  private void ED()
  {
    AppMethodBeat.i(138888);
    if ((this.chv != 0) && (this.chw != 0) && (this.mSurfaceTexture != null) && (this.ciM != null))
    {
      ac.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.chv), Integer.valueOf(this.chw) });
      this.mSurfaceTexture.setDefaultBufferSize(this.chv, this.chw);
      this.ciM.bT(this.chv, this.chw);
    }
    AppMethodBeat.o(138888);
  }
  
  static int getRotationAngle()
  {
    AppMethodBeat.i(138879);
    if (ai.getContext().getSystemService("window") != null)
    {
      int i = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(138879);
      return i;
    }
    AppMethodBeat.o(138879);
    return 0;
  }
  
  public final void EC()
  {
    AppMethodBeat.i(138882);
    if (this.ciZ != null) {
      this.ciZ.post(new Runnable()
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
  
  final boolean EE()
  {
    return this.ciO != null;
  }
  
  public final void Es()
  {
    AppMethodBeat.i(206592);
    if (this.ciZ != null) {
      this.ciZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206589);
          if (a.this.ciM != null)
          {
            a.this.ciM.c("stop", new JSONObject());
            b localb = a.this.ciM;
            if (localb.cjj != null)
            {
              ac.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
              localb.cjj.onPushEvent(5001, new Bundle());
            }
          }
          AppMethodBeat.o(206589);
        }
      });
    }
    AppMethodBeat.o(206592);
  }
  
  public final String Et()
  {
    AppMethodBeat.i(206593);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(206593);
    return str;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.ciS;
    this.ciS = (i + 1);
    if (i > 5)
    {
      ac.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.cs("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    o.b(parama.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(178824);
        ac.i(a.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178822);
                a.this.a(a.10.this.val$activity, a.10.this.cib);
                AppMethodBeat.o(178822);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ac.i(a.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          parama.cs("fail:system permission denied");
          AppMethodBeat.o(178824);
          return;
        }
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178823);
                a.this.a(a.10.this.val$activity, a.10.this.cib);
                AppMethodBeat.o(178823);
              }
            }, 50L);
            AppMethodBeat.o(178824);
            return;
          }
          ac.i(a.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          parama.cs("fail:system permission denied");
        }
        AppMethodBeat.o(178824);
      }
    });
    if (!h.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ac.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.cs("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    if (!h.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ac.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.cs("fail:system permission denied");
      AppMethodBeat.o(138891);
      return;
    }
    ac.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    if (this.ciM == null)
    {
      ac.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(138891);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.cht = parama;
    this.chu = new com.tencent.luggage.k.a.a.a()
    {
      public final void gz(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        a locala = a.this;
        if (locala.ciZ != null) {
          locala.ciZ.post(new a.4(locala, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        a locala = a.this;
        if (locala.ciZ != null) {
          locala.ciZ.post(new a.5(locala));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        a locala = a.this;
        if (locala.ciZ != null) {
          locala.ciZ.post(new a.3(locala));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.chu);
    paramActivity = parama.Ee();
    a(parama, paramActivity);
    i(paramActivity);
    k(paramActivity);
    l(paramActivity);
    j(paramActivity);
    Bundle localBundle = com.tencent.luggage.k.a.a.a.c.h(paramActivity);
    if (this.ciP != null)
    {
      paramActivity = this.ciP.c(parama, localBundle);
      if (!bs.isNullOrNil(paramActivity))
      {
        ac.i(getLogTag(), "insert fail, message:%s", new Object[] { paramActivity });
        parama.cs("fail: can not insert RTC mode LivePusher now");
        Toast.makeText(parama.getContext(), paramActivity, 0).show();
        AppMethodBeat.o(138891);
        return;
      }
    }
    paramActivity = this.ciM;
    if (paramActivity.cjj != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      ((Bundle)localObject).putLong("EVT_TIME", System.currentTimeMillis());
      paramActivity.cjj.onPushEvent(-9999999, (Bundle)localObject);
    }
    b.l("InitLivePusher", localBundle);
    paramActivity.mVideoView = null;
    paramActivity.cjk = localBundle.getString("pushUrl", "");
    paramActivity.cji.setPusherUrl(paramActivity.cjk);
    paramActivity.a(localBundle, true);
    paramActivity.cju = localBundle.getBoolean("autopush", paramActivity.cju);
    if ((paramActivity.cju) && (paramActivity.cjk != null) && (!paramActivity.cjk.isEmpty()) && (!paramActivity.cji.isPushing()))
    {
      ac.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      paramActivity.bB(paramActivity.cjA);
      paramActivity.bC(paramActivity.cjB);
      if ((paramActivity.cjA) && (paramActivity.mSurface != null)) {
        paramActivity.cji.setSurface(paramActivity.mSurface);
      }
      paramActivity.cji.startPusher(paramActivity.cjk);
    }
    paramActivity.mInited = true;
    Object localObject = new com.tencent.luggage.k.a.a.a.a();
    ac.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.k.a.a.a.a)localObject).errorCode), ((com.tencent.luggage.k.a.a.a.a)localObject).chn });
    if (((com.tencent.luggage.k.a.a.a.a)localObject).errorCode == 0) {}
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      parama.cs(paramActivity);
      n(parama);
      o(parama);
      if ((((com.tencent.luggage.k.a.a.a.a)localObject).errorCode == 0) && (this.ciP != null)) {
        this.ciP.a(this, this.cht, localBundle);
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
      this.chz = paramJSONObject.optBoolean("needEvent", false);
      if (EE()) {
        this.ciO.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.ciZ != null) {
      this.ciZ.post(new Runnable()
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
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  final void gA(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.ciN != null) {
      this.ciN.aK(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final boolean gE(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.ciW)
    {
      this.ciW = paramInt;
      ac.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.ciM != null)
      {
        this.ciM.gF(paramInt);
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
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", Ap() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final String h(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.ciZ != null) {
      this.ciZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          a locala = a.this;
          com.tencent.luggage.k.a.a locala1 = parama;
          Object localObject1 = locala1.Ef();
          if (!bs.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala1.Ee();
            ac.i(locala.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { locala.Ap(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              locala.gA(5);
              localObject1 = locala1.getContext();
              if (!(localObject1 instanceof Activity))
              {
                ac.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala1.cs("fail:internal error invalid android context");
                o.Qo(locala1.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              locala.ciS = 0;
              locala.a((Activity)localObject1, locala1);
              AppMethodBeat.o(138874);
              return;
            }
            com.tencent.luggage.k.a.a.a.a locala2;
            if (((String)localObject1).contains("update"))
            {
              locala.gA(6);
              if (locala.ciM == null)
              {
                ac.i(locala.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.Ee();
              locala.a(locala1, (JSONObject)localObject1);
              locala.i((JSONObject)localObject1);
              locala.k((JSONObject)localObject1);
              locala.l((JSONObject)localObject1);
              locala.j((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.k.a.a.a.c.h((JSONObject)localObject1);
              locala2 = locala.ciM.o((Bundle)localObject2);
              ac.i(locala.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(locala2.errorCode), locala2.chn });
              if (locala2.errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala1.cs((String)localObject1);
                locala.n(locala1);
                locala.o(locala1);
                if ((locala2.errorCode == 0) && (locala.ciP != null)) {
                  locala.ciP.b(locala.cht, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              locala.gA(7);
              if (locala.ciM == null)
              {
                ac.i(locala.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala1.Ee();
              localObject2 = ((JSONObject)localObject1).optString("type");
              ac.i(locala.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!bs.isNullOrNil((String)localObject2)) && (locala.ciM != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  locala.ciM.cjp = new a.8(locala, locala1);
                  if (locala.ciM.c("snapshot", locala1.Ee()).errorCode != 0) {
                    locala1.cs("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (locala.ciP != null)
                  {
                    locala.ciP.b(locala1, new a.9(locala));
                    locala1.cs("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala1.cs("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                locala2 = locala.ciM.c((String)localObject2, (JSONObject)localObject1);
                ac.i(locala.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(locala2.errorCode), locala2.chn });
                if (locala2.errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala1.cs((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (locala2.errorCode == 0) && (locala.ciP != null)) {
                    locala.ciP.c(locala, locala.cht);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala1.cs("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              locala.gA(8);
              locala.release();
              locala1.cs("ok");
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
        this.chv = g.ve(paramJSONObject.optInt("width", 0));
        this.chw = g.ve(paramJSONObject.optInt("height", 0));
        ac.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.chv), Integer.valueOf(this.chw) });
        ED();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void j(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.ciQ = paramJSONObject.optString("filterImage", this.ciQ);
      this.ciR = paramJSONObject.optString("filterImageMd5", null);
      if (bs.isNullOrNil(this.ciQ)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          AppMethodBeat.o(178836);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          ac.w(getLogTag(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          AppMethodBeat.o(178836);
          return;
        }
      }
      if ((this.ciQ.startsWith("http://")) || (this.ciQ.startsWith("https://"))) {
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
      this.ciT = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  public final void l(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.ciZ != null) {
      this.ciZ.post(new Runnable()
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
      this.ciU = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  final void n(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.ciP != null) {
      this.ciP.a(parama, new com.tencent.luggage.k.a.a.a.b.a.a.a()
      {
        public final void C(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(138857);
          if (!bs.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ac.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ciM != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              a.this.ciM.o(paramAnonymousString2);
            }
            AppMethodBeat.o(138857);
            return;
          }
          ac.i(a.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (a.this.ciO != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ciO.a(a.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(138857);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  final void o(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.ciP != null) && (!bs.isNullOrNil(this.ciQ))) {
      this.ciP.a(parama, this.ciQ, this.ciR, new com.tencent.luggage.k.a.a.a.b.a.a.a()
      {
        public final void C(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          if (!bs.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.k(paramAnonymousString2, false);
            ac.i(a.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (a.this.ciM != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              a.this.ciM.o(paramAnonymousString2);
            }
            AppMethodBeat.o(178819);
            return;
          }
          ac.i(a.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (a.this.ciO != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            a.this.ciO.a(a.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
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
    if (this.ciM != null)
    {
      this.ciM.cji.setFocusPosition(paramFloat1, paramFloat2);
      com.tencent.luggage.k.a.a.a.a locala = new com.tencent.luggage.k.a.a.a.a();
      ac.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(locala.errorCode), locala.chn });
    }
    AppMethodBeat.o(138894);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.ciP != null)
    {
      this.ciP.c(this, this.cht);
      this.ciP.a(this, this.cht);
    }
    if (this.ciM != null)
    {
      this.ciM.ES();
      this.ciM = null;
    }
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
    ac.i(getLogTag(), "LivePusher release handler thread");
    if (this.ciZ != null) {
      this.ciZ.removeCallbacksAndMessages(null);
    }
    if (this.cja != null) {
      this.cja.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final class a
    implements Runnable
  {
    int cjf;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = a.getRotationAngle();
      if (i == this.cjf)
      {
        a.this.gE(i);
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
    MotionEvent cjg;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((a.this.ciT) && (a.this.chv != 0) && (a.this.chw != 0)) {
        a.this.q(this.cjg.getX() / a.this.chv, this.cjg.getY() / a.this.chw);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */