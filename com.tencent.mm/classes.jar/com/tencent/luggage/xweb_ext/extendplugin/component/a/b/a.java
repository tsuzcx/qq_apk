package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.t.t;
import com.tencent.mm.plugin.appbrand.t.t.a;
import com.tencent.mm.plugin.appbrand.t.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  private com.tencent.luggage.xweb_ext.extendplugin.a bFZ;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c bGA;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b bGB;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a bGC;
  private int bGD;
  boolean bGE;
  private boolean bGF;
  private a.b bGG;
  private int bGH;
  t bGI;
  a.a bGJ;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a bGa;
  private int bGb;
  private int bGc;
  private boolean bGd;
  b bGz;
  int mCurrentScale;
  Handler mHandler;
  private ScaleGestureDetector mScaleGestureDetector;
  private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139803);
    this.mCurrentScale = 1;
    this.bGG = new a.b(this, (byte)0);
    this.bGH = 0;
    this.bGJ = new a.a(this);
    this.mScaleGestureListener = new a.10(this);
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.xn();
    this.bGz = new b(ah.getContext());
    this.bGz.bGR = new a.1(this);
    this.bGz.bGY = new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(139788);
        if (a.this.xt()) {
          a.this.bGB.bH(a.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(139788);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(139787);
        if (a.this.xt()) {
          a.this.bGB.f(a.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(139787);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(139786);
        if (a.this.xt()) {
          a.this.bGB.fB(a.this.getId());
        }
        AppMethodBeat.o(139786);
      }
    };
    this.mHandler = new Handler(ah.getContext().getMainLooper());
    this.bGI = new t(ah.getContext(), new t.b()
    {
      public final void a(t.a paramAnonymousa1, t.a paramAnonymousa2)
      {
        AppMethodBeat.i(139789);
        int i;
        switch (a.2.bGL[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = a.this.bGJ;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.bGK.mHandler.removeCallbacks(paramAnonymousa1);
          a.this.bGJ.bGN = i;
          paramAnonymousa1 = a.this.bGJ;
          paramAnonymousa1.bGK.mHandler.postDelayed(paramAnonymousa1, 250L);
          AppMethodBeat.o(139789);
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
    this.bGI.enable();
    fz(getRotationAngle());
    this.mScaleGestureDetector = new ScaleGestureDetector(ah.getContext(), this.mScaleGestureListener);
    AppMethodBeat.o(139803);
  }
  
  private void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139811);
    if (paramJSONObject.has("needEvent"))
    {
      this.bGd = paramJSONObject.optBoolean("needEvent", false);
      if (xt()) {
        this.bGB.d(parama);
      }
    }
    AppMethodBeat.o(139811);
  }
  
  private void e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(154406);
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.bFZ = parama;
    this.bGa = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void fx(int paramAnonymousInt)
      {
        AppMethodBeat.i(154396);
        a locala = a.this;
        ab.i(locala.xo(), "*** handler(%s) handleWebViewBackground, type:%s", new Object[] { locala.tX(), Integer.valueOf(paramAnonymousInt) });
        if (locala.bGz != null)
        {
          b localb = locala.bGz;
          localb.bGV = localb.bGQ.isPushing();
          if (!localb.bGV) {
            break label88;
          }
          localb.b("pause", null);
        }
        for (;;)
        {
          locala.bGI.disable();
          AppMethodBeat.o(154396);
          return;
          label88:
          new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
        }
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(154397);
        a locala = a.this;
        ab.i(locala.xo(), "*** handler(%s) handleWebViewDestroy", new Object[] { locala.tX() });
        locala.release();
        AppMethodBeat.o(154397);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(154395);
        a locala = a.this;
        ab.i(locala.xo(), "*** handler(%s) handleWebViewForeground", new Object[] { locala.tX() });
        b localb;
        if (locala.bGz != null)
        {
          localb = locala.bGz;
          if (!localb.bGV) {
            break label88;
          }
          if (!localb.bGW) {
            break label77;
          }
          localb.b("start", null);
        }
        for (;;)
        {
          locala.bGI.enable();
          AppMethodBeat.o(154395);
          return;
          label77:
          localb.b("resume", null);
          continue;
          label88:
          new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
        }
      }
    };
    parama.a(this.bGa);
    Object localObject2 = parama.xk();
    a(parama, (JSONObject)localObject2);
    i((JSONObject)localObject2);
    j((JSONObject)localObject2);
    k((JSONObject)localObject2);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("pushUrl", ((JSONObject)localObject2).optString("pushUrl"));
    ((Bundle)localObject1).putInt("mode", ((JSONObject)localObject2).optInt("mode", 0));
    ((Bundle)localObject1).putBoolean("autopush", ((JSONObject)localObject2).optBoolean("autopush", false));
    ((Bundle)localObject1).putBoolean("muted", ((JSONObject)localObject2).optBoolean("muted", false));
    ((Bundle)localObject1).putBoolean("enableCamera", ((JSONObject)localObject2).optBoolean("enableCamera", true));
    ((Bundle)localObject1).putInt("focusMode", ((JSONObject)localObject2).optInt("focusMode", 0));
    ((Bundle)localObject1).putString("orientation", ((JSONObject)localObject2).optString("orientation"));
    ((Bundle)localObject1).putInt("beauty", ((JSONObject)localObject2).optInt("beauty", 0));
    ((Bundle)localObject1).putInt("whiteness", ((JSONObject)localObject2).optInt("whiteness", 0));
    ((Bundle)localObject1).putString("audioQuality", ((JSONObject)localObject2).optString("audioQuality", "high"));
    ((Bundle)localObject1).putInt("aspect", ((JSONObject)localObject2).optInt("aspect", 0));
    ((Bundle)localObject1).putInt("minBitrate", ((JSONObject)localObject2).optInt("minBitrate", 0));
    ((Bundle)localObject1).putInt("maxBitrate", ((JSONObject)localObject2).optInt("maxBitrate", 0));
    ((Bundle)localObject1).putBoolean("backgroundMute", ((JSONObject)localObject2).optBoolean("backgroundMute", false));
    ((Bundle)localObject1).putBoolean("zoom", ((JSONObject)localObject2).optBoolean("zoom", true));
    ((Bundle)localObject1).putBoolean("needEvent", ((JSONObject)localObject2).optBoolean("needEvent", false));
    ((Bundle)localObject1).putBoolean("debug", ((JSONObject)localObject2).optBoolean("debug", false));
    ((Bundle)localObject1).putBoolean("mirror", ((JSONObject)localObject2).optBoolean("mirror", false));
    ((Bundle)localObject1).putFloat("watermarkLeft", BigDecimal.valueOf(((JSONObject)localObject2).optDouble("watermarkLeft", 0.0D)).floatValue());
    ((Bundle)localObject1).putFloat("watermarkTop", BigDecimal.valueOf(((JSONObject)localObject2).optDouble("watermarkTop", 0.0D)).floatValue());
    ((Bundle)localObject1).putFloat("watermarkWidth", BigDecimal.valueOf(((JSONObject)localObject2).optDouble("watermarkWidth", 0.1D)).floatValue());
    ((Bundle)localObject1).putString("devicePosition", ((JSONObject)localObject2).optString("devicePosition", "front"));
    ((Bundle)localObject1).putBoolean("needBGMEvent", ((JSONObject)localObject2).optBoolean("needBGMEvent", false));
    localObject2 = this.bGz;
    if (((b)localObject2).bGR != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      ((b)localObject2).bGR.onPushEvent(-9999999, localBundle);
    }
    b.k("InitLivePusher", (Bundle)localObject1);
    ((b)localObject2).bGi = null;
    ((b)localObject2).bGS = ((Bundle)localObject1).getString("pushUrl", "");
    ((b)localObject2).a((Bundle)localObject1, true);
    ((b)localObject2).bHb = ((Bundle)localObject1).getBoolean("autopush", ((b)localObject2).bHb);
    if ((((b)localObject2).bHb) && (((b)localObject2).bGS != null) && (!((b)localObject2).bGS.isEmpty()) && (!((b)localObject2).bGQ.isPushing()))
    {
      ab.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      ((b)localObject2).bg(((b)localObject2).bHg);
      if ((((b)localObject2).bHg) && (((b)localObject2).mSurface != null)) {
        ((b)localObject2).bGQ.setSurface(((b)localObject2).mSurface);
      }
      ((b)localObject2).bGQ.startPusher(((b)localObject2).bGS);
    }
    ((b)localObject2).mInited = true;
    localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
    ab.i(xo(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).bFT });
    if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode == 0) {}
    for (localObject1 = "ok";; localObject1 = "fail")
    {
      parama.ck((String)localObject1);
      f(parama);
      AppMethodBeat.o(154406);
      return;
    }
  }
  
  private void f(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139810);
    if (this.bGC != null) {
      this.bGC.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a()
      {
        public final void z(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(154398);
          if (!bo.isNullOrNil(paramAnonymousString2))
          {
            ab.i(a.this.xo(), "convertBackgroundImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString2 });
            if (a.this.bGz != null)
            {
              paramAnonymousString1 = new Bundle();
              paramAnonymousString1.putString("backgroundImage", paramAnonymousString2);
              a.this.bGz.n(paramAnonymousString1);
              AppMethodBeat.o(154398);
            }
          }
          else
          {
            ab.i(a.this.xo(), "convertBackgroundImageToLocalPath, load background image fail");
            if (a.this.bGB != null)
            {
              paramAnonymousString2 = new HashMap();
              paramAnonymousString2.put("url", paramAnonymousString1);
              a.this.bGB.a(a.this.getId(), 10004, "load background image fail", paramAnonymousString2);
            }
          }
          AppMethodBeat.o(154398);
        }
      });
    }
    AppMethodBeat.o(139810);
  }
  
  private void fy(int paramInt)
  {
    AppMethodBeat.i(154408);
    if (this.bGA != null) {
      this.bGA.at(paramInt);
    }
    AppMethodBeat.o(154408);
  }
  
  static int getRotationAngle()
  {
    AppMethodBeat.i(139804);
    if (ah.getContext().getSystemService("window") != null)
    {
      int i = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(139804);
      return i;
    }
    AppMethodBeat.o(139804);
    return 0;
  }
  
  private void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139812);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.bGb = paramJSONObject.optInt("width", 0);
        this.bGc = paramJSONObject.optInt("height", 0);
        ab.i(xo(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
        xr();
      }
    }
    AppMethodBeat.o(139812);
  }
  
  private void j(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(139814);
    if (paramJSONObject.has("focusMode"))
    {
      if (paramJSONObject.optInt("focusMode", 0) != 0) {
        bool = true;
      }
      this.bGE = bool;
    }
    AppMethodBeat.o(139814);
  }
  
  private void k(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139815);
    if (paramJSONObject.has("zoom")) {
      this.bGF = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(139815);
  }
  
  private void mw()
  {
    AppMethodBeat.i(154407);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(154407);
  }
  
  private void xr()
  {
    AppMethodBeat.i(139813);
    if ((this.bGb != 0) && (this.bGc != 0) && (this.mSurfaceTexture != null) && (this.bGz != null))
    {
      ab.i(xo(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
      this.mSurfaceTexture.setDefaultBufferSize(this.bGb, this.bGc);
      this.bGz.bE(this.bGb, this.bGc);
    }
    AppMethodBeat.o(139813);
  }
  
  private void xs()
  {
    AppMethodBeat.i(154405);
    if (this.bFZ != null)
    {
      this.bFZ.xm();
      this.bGa = null;
    }
    AppMethodBeat.o(154405);
  }
  
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139809);
    Object localObject1 = parama.xl();
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(139809);
      return null;
    }
    Object localObject2 = parama.xk();
    ab.i(xo(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { tX(), localObject1, ((JSONObject)localObject2).toString() });
    if (((String)localObject1).contains("insert"))
    {
      fy(5);
      localObject1 = parama.getContext();
      if (!(localObject1 instanceof Activity))
      {
        ab.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
        parama.ck("fail:internal error invalid android context");
        n.EA(parama.getAppId());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(139809);
      return null;
      this.bGD = 0;
      a((Activity)localObject1, parama);
      continue;
      if (((String)localObject1).contains("update"))
      {
        fy(6);
        localObject1 = parama.xk();
        a(parama, (JSONObject)localObject1);
        i((JSONObject)localObject1);
        j((JSONObject)localObject1);
        k((JSONObject)localObject1);
        localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.h((JSONObject)localObject1);
        localObject1 = this.bGz.n((Bundle)localObject1);
        ab.i(xo(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).bFT });
        if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode == 0) {}
        for (localObject1 = "ok";; localObject1 = "fail")
        {
          parama.ck((String)localObject1);
          f(parama);
          break;
        }
      }
      if (((String)localObject1).contains("operate"))
      {
        fy(7);
        localObject1 = parama.xk();
        localObject2 = ((JSONObject)localObject1).optString("type");
        ab.i(xo(), "operate, type:%s", new Object[] { localObject2 });
        if ((!bo.isNullOrNil((String)localObject2)) && (this.bGz != null))
        {
          if (((String)localObject2).equals("snapshot"))
          {
            this.bGz.bGX = new a.7(this, parama);
            if (this.bGz.b("snapshot", null).errorCode != 0) {
              parama.ck("fail:snapshot error");
            }
          }
          else if (((String)localObject2).equals("playBGM"))
          {
            if (this.bGC != null)
            {
              this.bGC.b(parama, new a.8(this));
              parama.ck("ok");
            }
            else
            {
              parama.ck("fail");
            }
          }
          else
          {
            if (this.bGz.b((String)localObject2, (JSONObject)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              parama.ck((String)localObject1);
              break;
            }
          }
        }
        else {
          parama.ck("fail");
        }
      }
      else if (((String)localObject1).contains("remove"))
      {
        fy(8);
        release();
        parama.ck("ok");
      }
    }
  }
  
  final void a(Activity paramActivity, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139816);
    int i = this.bGD;
    this.bGD = (i + 1);
    if (i > 5)
    {
      ab.i(xo(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.ck("fail:system permission denied");
      AppMethodBeat.o(139816);
      return;
    }
    n.b(parama.getAppId(), new a.9(this, paramActivity, parama));
    if (!g.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      ab.i(xo(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.ck("fail:system permission denied");
      AppMethodBeat.o(139816);
      return;
    }
    if (!g.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      ab.i(xo(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.ck("fail:system permission denied");
      AppMethodBeat.o(139816);
      return;
    }
    ab.i(xo(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    e(parama);
    AppMethodBeat.o(139816);
  }
  
  final void bF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139818);
    if (this.bGz != null)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.a.a locala = this.bGz.bG(paramInt1, paramInt2);
      ab.i(xo(), "onTouchFocusPosition, set focus(%d, %d), code:%d, info:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala.errorCode), locala.bFT });
    }
    AppMethodBeat.o(139818);
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139806);
    super.d(paramSurfaceTexture);
    ab.i(xo(), "*** handler(%s) handlePluginReady", new Object[] { tX() });
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(paramSurfaceTexture);
    if (this.bGz != null)
    {
      paramSurfaceTexture = this.bGz;
      Surface localSurface = this.mSurface;
      paramSurfaceTexture.mSurface = localSurface;
      paramSurfaceTexture.bGQ.setSurface(localSurface);
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
      xr();
    }
    AppMethodBeat.o(139806);
  }
  
  final boolean fz(int paramInt)
  {
    AppMethodBeat.i(139805);
    if (paramInt != this.bGH)
    {
      this.bGH = paramInt;
      ab.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.bGz != null)
      {
        this.bGz.fA(paramInt);
        AppMethodBeat.o(139805);
        return true;
      }
    }
    AppMethodBeat.o(139805);
    return false;
  }
  
  public final void m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139808);
    super.m(paramMotionEvent);
    ab.i(xo(), "*** handler(%s) handlePluginTouch(%s)", new Object[] { tX(), paramMotionEvent });
    if ((this.bGE) || (this.bGF))
    {
      if ((paramMotionEvent.getPointerCount() == 1) && (paramMotionEvent.getAction() == 0))
      {
        ab.i(xo(), "handlePluginTouch, 1 pointer action down");
        this.bGG.bGO = paramMotionEvent;
        al.p(this.bGG, 100L);
        AppMethodBeat.o(139808);
        return;
      }
      if ((paramMotionEvent.getPointerCount() > 1) && (paramMotionEvent.getAction() == 2))
      {
        ab.i(xo(), "handlePluginTouch, 2 pointer action move");
        al.ae(this.bGG);
        bF(-1, -1);
        if ((this.bGF) && (this.mScaleGestureDetector != null)) {
          this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
        }
      }
    }
    AppMethodBeat.o(139808);
  }
  
  final void release()
  {
    AppMethodBeat.i(139817);
    if (this.bGz != null)
    {
      this.bGz.xx();
      this.bGz = null;
    }
    mw();
    xs();
    AppMethodBeat.o(139817);
  }
  
  final String xo()
  {
    AppMethodBeat.i(139802);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", tX() });
    AppMethodBeat.o(139802);
    return str;
  }
  
  public final boolean xp()
  {
    return true;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(139807);
    super.xq();
    ab.i(xo(), "*** handler(%s) handlePluginDestroy", new Object[] { tX() });
    AppMethodBeat.o(139807);
  }
  
  final boolean xt()
  {
    return this.bGB != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a
 * JD-Core Version:    0.7.0.1
 */