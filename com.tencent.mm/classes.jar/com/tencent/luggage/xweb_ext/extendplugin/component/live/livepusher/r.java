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
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.jsapi.live.l;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.plugin.appbrand.utils.ak.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.threadpool.c.d;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements o
{
  Handler eBA;
  private HandlerThread eBB;
  m eBo;
  public c eBp;
  public b eBq;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a eBr;
  private String eBs;
  private String eBt;
  int eBu;
  boolean eBv;
  private boolean eBw;
  private c eBx;
  ak eBy;
  a eBz;
  int eyA;
  private boolean eyD;
  private volatile int eyr;
  private volatile int eys;
  com.tencent.luggage.xweb_ext.extendplugin.a eyx;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a eyy;
  int eyz;
  int mCurrentScale;
  Handler mHandler;
  private int mLastAngle;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  Surface mSurface;
  private volatile SurfaceTexture mSurfaceTexture;
  
  public r()
  {
    AppMethodBeat.i(138878);
    this.eyr = -1;
    this.eys = -1;
    this.eBs = "";
    this.mCurrentScale = 1;
    this.eBx = new c((byte)0);
    this.mLastAngle = 0;
    this.eBz = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f1 = 1.1F;
        AppMethodBeat.i(220758);
        int k = r.this.eBo.getMaxZoom();
        float f2;
        if (k > 0)
        {
          f2 = paramAnonymousScaleGestureDetector.getScaleFactor();
          if (f2 <= 1.0F) {
            break label247;
          }
          f2 = 0.2F / k * (k - r.this.mCurrentScale) + 1.0F;
          if (f2 > 1.1F) {
            break label343;
          }
        }
        for (;;)
        {
          int j = Math.round(r.this.mCurrentScale * f1);
          int i = j;
          if (j == r.this.mCurrentScale)
          {
            if (f1 > 1.0F) {
              i = j + 1;
            }
          }
          else
          {
            label109:
            j = i;
            if (i >= k) {
              j = k;
            }
            i = j;
            if (j <= 1) {
              i = 1;
            }
            if (f1 <= 1.0F) {
              break label305;
            }
            if (i >= r.this.mCurrentScale) {
              break label335;
            }
            i = r.this.mCurrentScale;
          }
          label305:
          label335:
          for (;;)
          {
            r.this.mCurrentScale = i;
            if (r.this.eBo != null)
            {
              Log.i(r.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(r.this.mCurrentScale) });
              r.this.eBo.mF(r.this.mCurrentScale);
            }
            AppMethodBeat.o(220758);
            return false;
            label247:
            if (f2 >= 1.0F) {
              break label338;
            }
            f2 = 1.0F - 0.2F / k * r.this.mCurrentScale;
            f1 = f2;
            if (f2 < 0.9F) {
              break;
            }
            f1 = 0.9F;
            break;
            i = j;
            if (f1 >= 1.0F) {
              break label109;
            }
            i = j - 1;
            break label109;
            if ((f1 < 1.0F) && (i > r.this.mCurrentScale)) {
              i = r.this.mCurrentScale;
            }
          }
          label338:
          f1 = f2;
          continue;
          label343:
          f1 = f2;
        }
      }
      
      public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.eBB = d.jw(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.eBB.start();
    this.eBA = new Handler(this.eBB.getLooper());
    this.mHandler = new Handler(MMApplicationContext.getContext().getMainLooper());
    l.csC();
    this.eBo = new u(MMApplicationContext.getContext(), (byte)0);
    this.eBo.setThreadHandler(this.eBA);
    this.eBo.setPushListener(new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (r.this.atY()) {
          r.this.eBq.g(r.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (r.this.atY())
        {
          Log.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          r.this.eBq.b(r.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (r.this.eBr != null))
        {
          r.this.eBr.b(r.this, r.this.eyx);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (r.this.eBr != null)) {
          r.this.eBr.c(r.this, r.this.eyx);
        }
        AppMethodBeat.o(178826);
      }
    });
    this.eBo.setBGMNotifyListener(new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (r.this.atY()) {
          r.this.eBq.df(r.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (r.this.atY()) {
          r.this.eBq.g(r.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (r.this.atY()) {
          r.this.eBq.mI(r.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    });
    this.eBo.setAudioVolumeListener(new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (r.this.atY()) {
          r.this.eBq.dg(r.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    });
    this.eBy = new ak(MMApplicationContext.getContext(), new ak.b()
    {
      public final void onFourOrientationsChange(ak.a paramAnonymousa1, ak.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (r.18.eBS[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = r.this.eBz;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.eBC.mHandler.removeCallbacks(paramAnonymousa1);
          r.this.eBz.eBU = i;
          paramAnonymousa1 = r.this.eBz;
          paramAnonymousa1.eBC.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.eBy.enable();
    mH(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          r.this.mScaleGestureDetector = new ScaleGestureDetector(MMApplicationContext.getContext(), r.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
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
  
  final void a(final Activity paramActivity, final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.eBu;
    this.eBu = (i + 1);
    if (i > 5)
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
      n(parama);
      AppMethodBeat.o(138891);
      return;
    }
    s.c(parama.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(220777);
        Log.i(r.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0)) {
            break label82;
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220797);
              r.this.a(r.14.this.val$activity, r.14.this.eze);
              AppMethodBeat.o(220797);
            }
          }, 50L);
        }
        for (;;)
        {
          s.b(parama.getAppId(), this);
          AppMethodBeat.o(220777);
          return;
          label82:
          Log.i(r.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          Log.i(r.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
          r.this.n(parama);
        }
      }
    });
    s.c(parama.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(220778);
        Log.i(r.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 118)
        {
          if ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0)) {
            break label82;
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220729);
              r.this.a(r.15.this.val$activity, r.15.this.eze);
              AppMethodBeat.o(220729);
            }
          }, 50L);
        }
        for (;;)
        {
          s.b(parama.getAppId(), this);
          AppMethodBeat.o(220778);
          return;
          label82:
          Log.i(r.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          Log.i(r.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
          r.this.n(parama);
        }
      }
    });
    if (!com.tencent.luggage.l.i.a(paramActivity, parama.aqX(), "android.permission.CAMERA", 117, "", ""))
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      AppMethodBeat.o(138891);
      return;
    }
    if (!com.tencent.luggage.l.i.a(paramActivity, parama.aqX(), "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      AppMethodBeat.o(138891);
      return;
    }
    Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    n(parama);
    AppMethodBeat.o(138891);
  }
  
  final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138886);
    if (paramJSONObject.has("needEvent"))
    {
      this.eyD = paramJSONObject.optBoolean("needEvent", false);
      if (atY()) {
        this.eBq.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  final void a(String[] paramArrayOfString1, String[] paramArrayOfString2, final String[] paramArrayOfString3, final JSONObject paramJSONObject1, final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(220959);
    int j = paramArrayOfString1.length;
    final b localb = new b((byte)0);
    localb.count = j;
    final int i = 0;
    while (i < j)
    {
      this.eBr.a(parama, paramArrayOfString1[i], paramArrayOfString2[i], false, new a.b()
      {
        public final void N(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(220714);
          Log.i(r.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            paramJSONObject1.put(paramArrayOfString3[i], paramAnonymousString2);
            paramAnonymousString1 = localb;
            paramAnonymousString1.count -= 1;
            Log.i(r.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
            if (localb.count == 0) {
              r.a(r.this, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(220858);
                  if (r.this.eBo == null)
                  {
                    Log.w(r.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(r.8.this.eBE) });
                    AppMethodBeat.o(220858);
                    return;
                  }
                  Object localObject = r.this.eBo.e("applyMakeup", r.8.this.ejE);
                  Log.i(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(r.8.this.eBE), Integer.valueOf(((k)localObject).errorCode), ((k)localObject).errorInfo });
                  com.tencent.luggage.xweb_ext.extendplugin.a locala = r.8.this.eze;
                  if (((k)localObject).errorCode == 0) {}
                  for (localObject = "ok";; localObject = "fail")
                  {
                    locala.fO((String)localObject);
                    AppMethodBeat.o(220858);
                    return;
                  }
                }
              });
            }
            AppMethodBeat.o(220714);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(r.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.fO("fail");
            AppMethodBeat.o(220714);
          }
        }
        
        public final void auo()
        {
          AppMethodBeat.i(220708);
          Log.w(r.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoadFailure#" + i);
          parama.fO("fail");
          AppMethodBeat.o(220708);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(220959);
  }
  
  final void ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.eBo != null)
    {
      k localk = this.eBo.aa(paramFloat1, paramFloat2);
      Log.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(localk.errorCode), localk.errorInfo });
    }
    AppMethodBeat.o(138894);
  }
  
  public final String atL()
  {
    AppMethodBeat.i(221009);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(221009);
    return str;
  }
  
  public final void atW()
  {
    AppMethodBeat.i(138882);
    this.mSurfaceTexture = null;
    if (this.eBA != null) {
      this.eBA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138870);
          r.a(r.this);
          AppMethodBeat.o(138870);
        }
      });
    }
    AppMethodBeat.o(138882);
  }
  
  final void atX()
  {
    AppMethodBeat.i(138888);
    if ((this.eyz != 0) && (this.eyA != 0) && (this.eBo != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.eyz), Integer.valueOf(this.eyA) });
      this.eBo.dc(this.eyz, this.eyA);
    }
    AppMethodBeat.o(138888);
  }
  
  final boolean atY()
  {
    return this.eBq != null;
  }
  
  final void b(final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220954);
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
      parama.fO("fail");
      AppMethodBeat.o(220954);
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
        parama.fO("fail");
        AppMethodBeat.o(220954);
        return;
      }
      String str1 = localJSONObject.optString("path", null);
      if (Util.isNullOrNil(str1))
      {
        Log.i(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", new Object[] { Integer.valueOf(i) });
        parama.fO("fail");
        AppMethodBeat.o(220954);
        return;
      }
      String str2 = localJSONObject.optString("md5", null);
      this.eBr.a(parama, str1, str2, true, new a.b()
      {
        public final void N(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          Log.i(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            localJSONObject.put("path", paramAnonymousString2);
            paramAnonymousString1 = localb;
            paramAnonymousString1.count -= 1;
            Log.i(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
            if (localb.count == 0) {
              r.a(r.this, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(138858);
                  if (r.this.eBo == null)
                  {
                    Log.w(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(r.7.this.eBE) });
                    AppMethodBeat.o(138858);
                    return;
                  }
                  Object localObject = r.this.eBo.e("applySticker", r.7.this.ejE);
                  Log.i(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applySticker, error:[%s, %s]", new Object[] { Integer.valueOf(r.7.this.eBE), Integer.valueOf(((k)localObject).errorCode), ((k)localObject).errorInfo });
                  com.tencent.luggage.xweb_ext.extendplugin.a locala = r.7.this.eze;
                  if (((k)localObject).errorCode == 0) {}
                  for (localObject = "ok";; localObject = "fail")
                  {
                    locala.fO((String)localObject);
                    AppMethodBeat.o(138858);
                    return;
                  }
                }
              });
            }
            AppMethodBeat.o(178819);
            return;
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.fO("fail");
            AppMethodBeat.o(178819);
          }
        }
        
        public final void auo()
        {
          AppMethodBeat.i(220709);
          Log.w(r.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoadFailure#" + i);
          parama.fO("fail");
          AppMethodBeat.o(220709);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(220954);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(138881);
  }
  
  public final void forceStop()
  {
    AppMethodBeat.i(221006);
    if (this.eBA != null) {
      this.eBA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220757);
          if (r.this.eBo != null)
          {
            r.this.eBo.e("stop", new JSONObject());
            r.this.eBo.atV();
          }
          AppMethodBeat.o(220757);
        }
      });
    }
    AppMethodBeat.o(221006);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  final String getLogTag()
  {
    AppMethodBeat.i(138877);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", key() });
    AppMethodBeat.o(138877);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138884);
    if (this.eBA != null) {
      this.eBA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          r localr = r.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = parama;
          Object localObject1 = locala.atx();
          if (!Util.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala.atw();
            Log.i(localr.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localr.key(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              localr.mz(5);
              localObject1 = locala.getContext();
              if (!(localObject1 instanceof Activity))
              {
                Log.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala.fO("fail:internal error invalid android context");
                s.afs(locala.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              localr.eBu = 0;
              localr.a((Activity)localObject1, locala);
              AppMethodBeat.o(138874);
              return;
            }
            Object localObject3;
            if (((String)localObject1).contains("update"))
            {
              localr.mz(6);
              if (localr.eBo == null)
              {
                Log.i(localr.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala.atw();
              localr.a(locala, (JSONObject)localObject1);
              localr.k((JSONObject)localObject1);
              localr.m((JSONObject)localObject1);
              localr.n((JSONObject)localObject1);
              localr.l((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.live.a.j((JSONObject)localObject1);
              if (localr.eBr != null)
              {
                localObject1 = localr.eBr.c(locala, (Bundle)localObject2);
                if (!Util.isNullOrNil((String)localObject1))
                {
                  Log.i(localr.getLogTag(), "update fail, message:%s", new Object[] { localObject1 });
                  locala.fO("fail: can not update LivePusher to VOIP mode now");
                  Toast.makeText(locala.getContext(), (CharSequence)localObject1, 0).show();
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              localObject3 = localr.eBo.z((Bundle)localObject2);
              Log.i(localr.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject3).errorCode), ((k)localObject3).errorInfo });
              if (((k)localObject3).errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala.fO((String)localObject1);
                localr.o(locala);
                localr.p(locala);
                if ((((k)localObject3).errorCode == 0) && (localr.eBr != null))
                {
                  localr.eBr.a(localr, localr.eyx, (Bundle)localObject2);
                  localr.eBr.b(localr.eyx, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              localr.mz(7);
              if (localr.eBo == null)
              {
                Log.i(localr.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              JSONObject localJSONObject1 = locala.atw();
              localObject2 = localJSONObject1.optString("type");
              Log.i(localr.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!Util.isNullOrNil((String)localObject2)) && (localr.eBo != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  localr.eBo.setSnapshotListener(new r.11(localr, locala));
                  if (localr.eBo.e("snapshot", locala.atw()).errorCode != 0) {
                    locala.fO("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (localr.eBr != null)
                  {
                    localr.eBr.b(locala, new r.13(localr));
                    locala.fO("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala.fO("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                int i;
                if ((((String)localObject2).equalsIgnoreCase("applyFilter")) || (((String)localObject2).equalsIgnoreCase("applySticker")) || (((String)localObject2).equalsIgnoreCase("applyMakeup"))) {
                  i = 1;
                }
                while (i != 0) {
                  if (localr.eBr == null)
                  {
                    Log.w(localr.getLogTag(), "convertResourcePathAndOperateLivePusher, customHandler is null");
                    locala.fO("fail");
                    AppMethodBeat.o(138874);
                    return;
                    i = 0;
                  }
                  else
                  {
                    if (!((String)localObject2).equalsIgnoreCase("applyFilter"))
                    {
                      Log.i(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher");
                      if (((String)localObject2).equalsIgnoreCase("applySticker"))
                      {
                        localr.b(locala, localJSONObject1);
                        AppMethodBeat.o(138874);
                        return;
                      }
                      if (((String)localObject2).equalsIgnoreCase("applyMakeup"))
                      {
                        localObject1 = localJSONObject1.optString("makeupType", null);
                        if (Util.isNullOrNil((String)localObject1))
                        {
                          Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
                          locala.fO("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("makeup");
                        if (localJSONObject2 == null)
                        {
                          Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
                          locala.fO("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        if (((String)localObject1).equalsIgnoreCase("lipStick"))
                        {
                          localObject1 = localr.eBo.e("applyMakeup", localJSONObject1);
                          Log.i(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(((k)localObject1).errorCode), ((k)localObject1).errorInfo });
                          if (((k)localObject1).errorCode == 0) {}
                          for (localObject1 = "ok";; localObject1 = "fail")
                          {
                            locala.fO((String)localObject1);
                            AppMethodBeat.o(138874);
                            return;
                          }
                        }
                        if (((String)localObject1).equalsIgnoreCase("eyeShadow"))
                        {
                          localObject2 = localJSONObject2.optString("path", null);
                          if (Util.isNullOrNil((String)localObject2))
                          {
                            Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, path is empty");
                            locala.fO("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject3 = localJSONObject2.optString("pathMd5", null);
                          String str = localJSONObject2.optString("shimmerPosition", null);
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
                            localObject3[0] = "path";
                            localObject3[1] = "shimmerPosition";
                          }
                          for (;;)
                          {
                            localr.a((String[])localObject1, (String[])localObject2, (String[])localObject3, localJSONObject2, locala, localJSONObject1);
                            AppMethodBeat.o(138874);
                            return;
                            localObject1 = new String[1];
                            localObject1[0] = localObject2;
                            localObject2 = new String[1];
                            localObject2[0] = localObject3;
                            localObject3 = new String[1];
                            localObject3[0] = "path";
                          }
                        }
                        if ((((String)localObject1).equalsIgnoreCase("blusherStick")) || (((String)localObject1).equalsIgnoreCase("faceContour")) || (((String)localObject1).equalsIgnoreCase("eyeBrow")))
                        {
                          localObject1 = localJSONObject2.optString("path", null);
                          if (Util.isNullOrNil((String)localObject1))
                          {
                            Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, path is empty");
                            locala.fO("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject2 = localJSONObject2.optString("pathMd5", null);
                          localr.a(new String[] { localObject1 }, new String[] { localObject2 }, new String[] { "path" }, localJSONObject2, locala, localJSONObject1);
                          AppMethodBeat.o(138874);
                          return;
                        }
                        Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
                        locala.fO("fail");
                        AppMethodBeat.o(138874);
                        return;
                      }
                      Log.w(localr.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
                      locala.fO("fail");
                      AppMethodBeat.o(138874);
                      return;
                    }
                    localObject1 = localJSONObject1.optString("path", null);
                    if (Util.isNullOrNil((String)localObject1))
                    {
                      Log.i(localr.getLogTag(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
                      AppMethodBeat.o(138874);
                      return;
                    }
                    localObject3 = localJSONObject1.optString("md5", null);
                    boolean bool = ((String)localObject2).equalsIgnoreCase("applySticker");
                    localr.eBr.a(locala, (String)localObject1, (String)localObject3, bool, new r.6(localr, locala, localJSONObject1, (String)localObject2));
                    AppMethodBeat.o(138874);
                    return;
                  }
                }
                localObject3 = localr.eBo.e((String)localObject2, localJSONObject1);
                Log.i(localr.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(((k)localObject3).errorCode), ((k)localObject3).errorInfo });
                if (((k)localObject3).errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala.fO((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (((k)localObject3).errorCode == 0) && (localr.eBr != null)) {
                    localr.eBr.c(localr, localr.eyx);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala.fO("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              localr.mz(8);
              localr.release();
              locala.fO("ok");
            }
          }
          AppMethodBeat.o(138874);
        }
      });
    }
    AppMethodBeat.o(138884);
    return null;
  }
  
  public final void i(final Surface paramSurface)
  {
    AppMethodBeat.i(220916);
    super.i(paramSurface);
    if (this.eBA != null) {
      this.eBA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138869);
          r localr = r.this;
          Surface localSurface = paramSurface;
          Log.i(localr.getLogTag(), "*** handler(%s) handlePluginReady", new Object[] { localr.key() });
          localr.mSurface = localSurface;
          if (localr.eBo != null)
          {
            localr.eBo.h(localr.mSurface);
            localr.atX();
          }
          AppMethodBeat.o(138869);
        }
      });
    }
    AppMethodBeat.o(220916);
  }
  
  final void k(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138887);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.eyz = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("width", 0));
        this.eyA = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.eyz), Integer.valueOf(this.eyA) });
        atX();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.eBs = paramJSONObject.optString("filterImage", this.eBs);
      this.eBt = paramJSONObject.optString("filterImageMd5", null);
      if (Util.isNullOrNil(this.eBs)) {
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
      if ((this.eBs.startsWith("http://")) || (this.eBs.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
    AppMethodBeat.o(178836);
  }
  
  final void m(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(138889);
    if (paramJSONObject.has("focusMode"))
    {
      if (paramJSONObject.optInt("focusMode", 0) != 0) {
        bool = true;
      }
      this.eBv = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  final boolean mH(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.mLastAngle)
    {
      this.mLastAngle = paramInt;
      Log.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.eBo != null)
      {
        this.eBo.notifyOrientationChanged(paramInt);
        AppMethodBeat.o(138880);
        return true;
      }
    }
    AppMethodBeat.o(138880);
    return false;
  }
  
  final void mz(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.eBp != null) {
      this.eBp.dw(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final void n(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220948);
    if (this.eBo == null)
    {
      Log.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(220948);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.eyx = parama;
    this.eyy = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void my(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        Log.i(r.this.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramAnonymousInt)));
        r localr = r.this;
        if (localr.eBA != null) {
          localr.eBA.post(new r.4(localr, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        r localr = r.this;
        if (localr.eBA != null) {
          localr.eBA.post(new r.5(localr));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        Log.i(r.this.getLogTag(), "onForeground");
        r localr = r.this;
        if (localr.eBA != null) {
          localr.eBA.post(new r.3(localr));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.eyy);
    Object localObject = parama.atw();
    a(parama, (JSONObject)localObject);
    k((JSONObject)localObject);
    m((JSONObject)localObject);
    n((JSONObject)localObject);
    l((JSONObject)localObject);
    Bundle localBundle = com.tencent.luggage.xweb_ext.extendplugin.component.live.a.j((JSONObject)localObject);
    if (this.eBr != null)
    {
      localObject = this.eBr.c(parama, localBundle);
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i(getLogTag(), "insert fail, message:%s", new Object[] { localObject });
        parama.fO("fail: can not insert VOIP mode LivePusher now");
        Toast.makeText(parama.getContext(), (CharSequence)localObject, 0).show();
        AppMethodBeat.o(220948);
        return;
      }
    }
    k localk = this.eBo.y(localBundle);
    Log.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    if (localk.errorCode == 0) {}
    for (localObject = "ok";; localObject = "fail")
    {
      parama.fO((String)localObject);
      o(parama);
      p(parama);
      if ((localk.errorCode == 0) && (this.eBr != null)) {
        this.eBr.a(this, this.eyx, localBundle);
      }
      AppMethodBeat.o(220948);
      return;
    }
  }
  
  final void n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138890);
    if (paramJSONObject.has("zoom")) {
      this.eBw = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  public final void o(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.eBA != null) {
      this.eBA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178834);
          r.a(r.this, paramMotionEvent);
          AppMethodBeat.o(178834);
        }
      });
    }
    AppMethodBeat.o(138883);
  }
  
  final void o(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.eBr != null) {
      this.eBr.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void N(final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178821);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.n(paramAnonymousString2, false);
            Log.i(r.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            r.a(r.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220746);
                if (r.this.eBo != null)
                {
                  Bundle localBundle = new Bundle();
                  localBundle.putString("backgroundImage", paramAnonymousString1);
                  r.this.eBo.z(localBundle);
                }
                AppMethodBeat.o(220746);
              }
            });
            AppMethodBeat.o(178821);
            return;
          }
          Log.i(r.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (r.this.eBq != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            r.this.eBq.a(r.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(178821);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  final void p(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.eBr != null) && (!Util.isNullOrNil(this.eBs))) {
      this.eBr.a(parama, this.eBs, this.eBt, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void N(final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(220771);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.n(paramAnonymousString2, false);
            Log.i(r.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            r.a(r.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(178822);
                if (r.this.eBo != null)
                {
                  Bundle localBundle = new Bundle();
                  localBundle.putString("filterImage", paramAnonymousString1);
                  r.this.eBo.z(localBundle);
                }
                AppMethodBeat.o(178822);
              }
            });
            AppMethodBeat.o(220771);
            return;
          }
          Log.i(r.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (r.this.eBq != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            r.this.eBq.a(r.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(220771);
        }
      });
    }
    AppMethodBeat.o(178835);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.eBr != null)
    {
      this.eBr.c(this, this.eyx);
      this.eBr.a(this, this.eyx);
    }
    if (this.eBo != null)
    {
      this.eBo.aup();
      this.eBo = null;
    }
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.eyx != null)
    {
      this.eyx.aty();
      this.eyy = null;
    }
    Log.i(getLogTag(), "LivePusher release handler thread");
    if (this.eBA != null) {
      this.eBA.removeCallbacksAndMessages(null);
    }
    if (this.eBB != null) {
      this.eBB.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final class a
    implements Runnable
  {
    int eBU;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = r.getRotationAngle();
      if (i == this.eBU)
      {
        r.this.mH(i);
        AppMethodBeat.o(138875);
        return;
      }
      if (this.number < 8) {
        r.this.mHandler.postDelayed(this, 250L);
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
    MotionEvent eBV;
    
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((r.this.eBv) && (r.this.eyz != 0) && (r.this.eyA != 0)) {
        r.this.ab(this.eBV.getX() / r.this.eyz, this.eBV.getY() / r.this.eyA);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r
 * JD-Core Version:    0.7.0.1
 */