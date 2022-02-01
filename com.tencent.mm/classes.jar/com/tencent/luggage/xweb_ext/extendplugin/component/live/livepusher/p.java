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
import com.tencent.e.c.d;
import com.tencent.luggage.k.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.plugin.appbrand.utils.af.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements o
{
  com.tencent.luggage.xweb_ext.extendplugin.a cFj;
  private com.tencent.luggage.xweb_ext.extendplugin.a.a cFk;
  int cFl;
  int cFm;
  private boolean cFp;
  l cHR;
  public c cHS;
  public b cHT;
  public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a cHU;
  private String cHV;
  private String cHW;
  int cHX;
  boolean cHY;
  private boolean cHZ;
  private c cIa;
  af cIb;
  a cIc;
  Handler cId;
  private HandlerThread cIe;
  int mCurrentScale;
  Handler mHandler;
  private int mLastAngle;
  ScaleGestureDetector mScaleGestureDetector;
  ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public p()
  {
    AppMethodBeat.i(138878);
    this.cHV = "";
    this.mCurrentScale = 1;
    this.cIa = new c((byte)0);
    this.mLastAngle = 0;
    this.cIc = new a();
    this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f1 = 1.1F;
        AppMethodBeat.i(223093);
        int k = p.this.cHR.getMaxZoom();
        float f2;
        if (k > 0)
        {
          f2 = paramAnonymousScaleGestureDetector.getScaleFactor();
          if (f2 <= 1.0F) {
            break label247;
          }
          f2 = 0.2F / k * (k - p.this.mCurrentScale) + 1.0F;
          if (f2 > 1.1F) {
            break label343;
          }
        }
        for (;;)
        {
          int j = Math.round(p.this.mCurrentScale * f1);
          int i = j;
          if (j == p.this.mCurrentScale)
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
            if (i >= p.this.mCurrentScale) {
              break label335;
            }
            i = p.this.mCurrentScale;
          }
          label305:
          label335:
          for (;;)
          {
            p.this.mCurrentScale = i;
            if (p.this.cHR != null)
            {
              Log.i(p.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(p.this.mCurrentScale) });
              p.this.cHR.jc(p.this.mCurrentScale);
            }
            AppMethodBeat.o(223093);
            return false;
            label247:
            if (f2 >= 1.0F) {
              break label338;
            }
            f2 = 1.0F - 0.2F / k * p.this.mCurrentScale;
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
            if ((f1 < 1.0F) && (i > p.this.mCurrentScale)) {
              i = p.this.mCurrentScale;
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
    this.cIe = d.ik(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cIe.start();
    this.cId = new Handler(this.cIe.getLooper());
    this.mHandler = new Handler(MMApplicationContext.getContext().getMainLooper());
    com.tencent.mm.plugin.appbrand.jsapi.live.l.bSv();
    this.cHR = new s(MMApplicationContext.getContext(), (byte)0);
    this.cHR.setThreadHandler(this.cId);
    this.cHR.setPushListener(new ITXLivePushListener()
    {
      public final void onNetStatus(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178827);
        if (p.this.Tt()) {
          p.this.cHT.f(p.this.getId(), paramAnonymousBundle);
        }
        AppMethodBeat.o(178827);
      }
      
      public final void onPushEvent(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178826);
        if (p.this.Tt())
        {
          Log.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          p.this.cHT.b(p.this.getId(), paramAnonymousInt, paramAnonymousBundle);
        }
        if (((paramAnonymousInt == 1002) || (paramAnonymousInt == 1003) || (paramAnonymousInt == 1018)) && (p.this.cHU != null))
        {
          p.this.cHU.b(p.this, p.this.cFj);
          AppMethodBeat.o(178826);
          return;
        }
        if ((paramAnonymousInt == -1307) && (p.this.cHU != null)) {
          p.this.cHU.c(p.this, p.this.cFj);
        }
        AppMethodBeat.o(178826);
      }
    });
    this.cHR.setBGMNotifyListener(new TXLivePusher.OnBGMNotify()
    {
      public final void onBGMComplete(int paramAnonymousInt)
      {
        AppMethodBeat.i(178831);
        if (p.this.Tt()) {
          p.this.cHT.cq(p.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178831);
      }
      
      public final void onBGMProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(178830);
        if (p.this.Tt()) {
          p.this.cHT.g(p.this.getId(), paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(178830);
      }
      
      public final void onBGMStart()
      {
        AppMethodBeat.i(178829);
        if (p.this.Tt()) {
          p.this.cHT.jf(p.this.getId());
        }
        AppMethodBeat.o(178829);
      }
    });
    this.cHR.setAudioVolumeListener(new TXLivePusher.ITXAudioVolumeEvaluationListener()
    {
      public final void onAudioVolumeEvaluationNotify(int paramAnonymousInt)
      {
        AppMethodBeat.i(178832);
        if (p.this.Tt()) {
          p.this.cHT.cr(p.this.getId(), paramAnonymousInt);
        }
        AppMethodBeat.o(178832);
      }
    });
    this.cIb = new af(MMApplicationContext.getContext(), new af.b()
    {
      public final void a(af.a paramAnonymousa1, af.a paramAnonymousa2)
      {
        AppMethodBeat.i(178833);
        int i;
        switch (p.17.cIm[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = p.this.cIc;
          paramAnonymousa1.number = 0;
          paramAnonymousa1.cIf.mHandler.removeCallbacks(paramAnonymousa1);
          p.this.cIc.cIo = i;
          paramAnonymousa1 = p.this.cIc;
          paramAnonymousa1.cIf.mHandler.postDelayed(paramAnonymousa1, 250L);
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
    this.cIb.enable();
    je(getRotationAngle());
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178813);
          p.this.mScaleGestureDetector = new ScaleGestureDetector(MMApplicationContext.getContext(), p.this.mScaleGestureListener);
          AppMethodBeat.o(178813);
        }
      });
    }
    AppMethodBeat.o(138878);
  }
  
  private void Ts()
  {
    AppMethodBeat.i(138888);
    if ((this.cFl != 0) && (this.cFm != 0) && (this.mSurfaceTexture != null) && (this.cHR != null))
    {
      Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
      this.mSurfaceTexture.setDefaultBufferSize(this.cFl, this.cFm);
      this.cHR.cn(this.cFl, this.cFm);
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
  
  public final String Tg()
  {
    AppMethodBeat.i(226938);
    String str = String.format("%s_%s", new Object[] { this.type, Integer.valueOf(getId()) });
    AppMethodBeat.o(226938);
    return str;
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(138882);
    if (this.cId != null) {
      this.cId.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138870);
          p.a(p.this);
          AppMethodBeat.o(138870);
        }
      });
    }
    AppMethodBeat.o(138882);
  }
  
  final boolean Tt()
  {
    return this.cHT != null;
  }
  
  final void a(final Activity paramActivity, final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138891);
    int i = this.cHX;
    this.cHX = (i + 1);
    if (i > 5)
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
      n(parama);
      AppMethodBeat.o(138891);
      return;
    }
    r.b(parama.getAppId(), new androidx.core.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(221111);
        Log.i(p.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 117)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(224764);
                p.this.a(p.14.this.val$activity, p.14.this.cFQ);
                AppMethodBeat.o(224764);
              }
            }, 50L);
            AppMethodBeat.o(221111);
            return;
          }
          Log.i(p.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
          Log.i(p.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
          p.this.n(parama);
          AppMethodBeat.o(221111);
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
                AppMethodBeat.i(227832);
                p.this.a(p.14.this.val$activity, p.14.this.cFQ);
                AppMethodBeat.o(227832);
              }
            }, 50L);
            AppMethodBeat.o(221111);
            return;
          }
          Log.i(p.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
          Log.i(p.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
          p.this.n(parama);
        }
        AppMethodBeat.o(221111);
      }
    });
    if (!i.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      AppMethodBeat.o(138891);
      return;
    }
    if (!i.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
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
      this.cFp = paramJSONObject.optBoolean("needEvent", false);
      if (Tt()) {
        this.cHT.m(parama);
      }
    }
    AppMethodBeat.o(138886);
  }
  
  final void a(String[] paramArrayOfString1, String[] paramArrayOfString2, final String[] paramArrayOfString3, final JSONObject paramJSONObject1, final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(226880);
    int j = paramArrayOfString1.length;
    final b localb = new b((byte)0);
    localb.count = j;
    final int i = 0;
    while (i < j)
    {
      this.cHU.a(parama, paramArrayOfString1[i], paramArrayOfString2[i], false, new a.b()
      {
        public final void K(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(224231);
          Log.i(p.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            paramJSONObject1.put(paramArrayOfString3[i], paramAnonymousString2);
            if (p.this.cHR == null)
            {
              Log.w(p.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(224231);
              return;
            }
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(p.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.er("fail");
            AppMethodBeat.o(224231);
            return;
          }
          paramAnonymousString1 = localb;
          paramAnonymousString1.count -= 1;
          Log.i(p.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
          if (localb.count == 0)
          {
            paramAnonymousString1 = p.this.cHR.e("applyMakeup", paramJSONObject2);
            Log.i(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousString1.errorCode), paramAnonymousString1.errorInfo });
            paramAnonymousString2 = parama;
            if (paramAnonymousString1.errorCode != 0) {
              break label303;
            }
          }
          label303:
          for (paramAnonymousString1 = "ok";; paramAnonymousString1 = "fail")
          {
            paramAnonymousString2.er(paramAnonymousString1);
            AppMethodBeat.o(224231);
            return;
          }
        }
        
        public final void TJ()
        {
          AppMethodBeat.i(224224);
          Log.w(p.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoadFailure#" + i);
          parama.er("fail");
          AppMethodBeat.o(224224);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(226880);
  }
  
  final void b(final com.tencent.luggage.xweb_ext.extendplugin.a parama, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226874);
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
      parama.er("fail");
      AppMethodBeat.o(226874);
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
        parama.er("fail");
        AppMethodBeat.o(226874);
        return;
      }
      String str1 = localJSONObject.optString("path", null);
      if (Util.isNullOrNil(str1))
      {
        Log.i(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", new Object[] { Integer.valueOf(i) });
        parama.er("fail");
        AppMethodBeat.o(226874);
        return;
      }
      String str2 = localJSONObject.optString("md5", null);
      this.cHU.a(parama, str1, str2, true, new a.b()
      {
        public final void K(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178819);
          Log.i(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, path: %s, localPath: %s", new Object[] { Integer.valueOf(i), paramAnonymousString1, paramAnonymousString2 });
          try
          {
            localJSONObject.put("path", paramAnonymousString2);
            if (p.this.cHR == null)
            {
              Log.w(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, adapter is null", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(178819);
              return;
            }
          }
          catch (Exception paramAnonymousString1)
          {
            Log.w(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, put fail since %s", new Object[] { Integer.valueOf(i), paramAnonymousString1 });
            parama.er("fail");
            AppMethodBeat.o(178819);
            return;
          }
          paramAnonymousString1 = localb;
          paramAnonymousString1.count -= 1;
          Log.i(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, pendingConvertCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localb.count) });
          if (localb.count == 0)
          {
            paramAnonymousString1 = p.this.cHR.e("applySticker", paramJSONObject);
            Log.i(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applySticker, error:[%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousString1.errorCode), paramAnonymousString1.errorInfo });
            paramAnonymousString2 = parama;
            if (paramAnonymousString1.errorCode != 0) {
              break label296;
            }
          }
          label296:
          for (paramAnonymousString1 = "ok";; paramAnonymousString1 = "fail")
          {
            paramAnonymousString2.er(paramAnonymousString1);
            AppMethodBeat.o(178819);
            return;
          }
        }
        
        public final void TJ()
        {
          AppMethodBeat.i(223477);
          Log.w(p.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoadFailure#" + i);
          parama.er("fail");
          AppMethodBeat.o(223477);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(226874);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138881);
    if (this.cId != null) {
      this.cId.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138869);
          p.a(p.this, paramSurfaceTexture);
          AppMethodBeat.o(138869);
        }
      });
    }
    AppMethodBeat.o(138881);
  }
  
  public final void forceStop()
  {
    AppMethodBeat.i(226934);
    if (this.cId != null) {
      this.cId.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223972);
          if (p.this.cHR != null)
          {
            p.this.cHR.e("stop", new JSONObject());
            p.this.cHR.Tq();
          }
          AppMethodBeat.o(223972);
        }
      });
    }
    AppMethodBeat.o(226934);
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
    if (this.cId != null) {
      this.cId.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(138874);
          p localp = p.this;
          com.tencent.luggage.xweb_ext.extendplugin.a locala = parama;
          Object localObject1 = locala.SS();
          if (!Util.isNullOrNil((String)localObject1))
          {
            Object localObject2 = locala.SR();
            Log.i(localp.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localp.key(), localObject1, ((JSONObject)localObject2).toString() });
            new StringBuilder("handleJsApi:").append((String)localObject1).append(", data:").append(localObject2);
            if (((String)localObject1).contains("insert"))
            {
              localp.iX(5);
              localObject1 = locala.getContext();
              if (!(localObject1 instanceof Activity))
              {
                Log.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                locala.er("fail:internal error invalid android context");
                r.amk(locala.getAppId());
                AppMethodBeat.o(138874);
                return;
              }
              localp.cHX = 0;
              localp.a((Activity)localObject1, locala);
              AppMethodBeat.o(138874);
              return;
            }
            Object localObject3;
            if (((String)localObject1).contains("update"))
            {
              localp.iX(6);
              if (localp.cHR == null)
              {
                Log.i(localp.getLogTag(), "update, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              localObject1 = locala.SR();
              localp.a(locala, (JSONObject)localObject1);
              localp.l((JSONObject)localObject1);
              localp.n((JSONObject)localObject1);
              localp.o((JSONObject)localObject1);
              localp.m((JSONObject)localObject1);
              localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.live.a.k((JSONObject)localObject1);
              if (localp.cHU != null)
              {
                localObject1 = localp.cHU.c(locala, (Bundle)localObject2);
                if (!Util.isNullOrNil((String)localObject1))
                {
                  Log.i(localp.getLogTag(), "update fail, message:%s", new Object[] { localObject1 });
                  locala.er("fail: can not update LivePusher to VOIP mode now");
                  Toast.makeText(locala.getContext(), (CharSequence)localObject1, 0).show();
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              localObject3 = localp.cHR.u((Bundle)localObject2);
              Log.i(localp.getLogTag(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject3).errorCode), ((k)localObject3).errorInfo });
              if (((k)localObject3).errorCode == 0) {}
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                locala.er((String)localObject1);
                localp.o(locala);
                localp.p(locala);
                if ((((k)localObject3).errorCode == 0) && (localp.cHU != null))
                {
                  localp.cHU.a(localp, localp.cFj, (Bundle)localObject2);
                  localp.cHU.b(localp.cFj, (Bundle)localObject2);
                }
                AppMethodBeat.o(138874);
                return;
              }
            }
            if (((String)localObject1).contains("operate"))
            {
              localp.iX(7);
              if (localp.cHR == null)
              {
                Log.i(localp.getLogTag(), "operate, adapter is null");
                AppMethodBeat.o(138874);
                return;
              }
              JSONObject localJSONObject1 = locala.SR();
              localObject2 = localJSONObject1.optString("type");
              Log.i(localp.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
              if ((!Util.isNullOrNil((String)localObject2)) && (localp.cHR != null))
              {
                if (((String)localObject2).equals("snapshot"))
                {
                  localp.cHR.setSnapshotListener(new p.11(localp, locala));
                  if (localp.cHR.e("snapshot", locala.SR()).errorCode != 0) {
                    locala.er("fail:snapshot error");
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
                if (((String)localObject2).equals("playBGM"))
                {
                  if (localp.cHU != null)
                  {
                    localp.cHU.b(locala, new p.13(localp));
                    locala.er("ok");
                    AppMethodBeat.o(138874);
                    return;
                  }
                  locala.er("fail");
                  AppMethodBeat.o(138874);
                  return;
                }
                int i;
                if ((((String)localObject2).equalsIgnoreCase("applyFilter")) || (((String)localObject2).equalsIgnoreCase("applySticker")) || (((String)localObject2).equalsIgnoreCase("applyMakeup"))) {
                  i = 1;
                }
                while (i != 0) {
                  if (localp.cHU == null)
                  {
                    Log.w(localp.getLogTag(), "convertResourcePathAndOperateLivePusher, customHandler is null");
                    locala.er("fail");
                    AppMethodBeat.o(138874);
                    return;
                    i = 0;
                  }
                  else
                  {
                    localObject1 = localJSONObject1.optString("path", null);
                    if (Util.isNullOrNil((String)localObject1))
                    {
                      Log.i(localp.getLogTag(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
                      Log.i(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher");
                      if (((String)localObject2).equalsIgnoreCase("applySticker"))
                      {
                        localp.b(locala, localJSONObject1);
                        AppMethodBeat.o(138874);
                        return;
                      }
                      if (((String)localObject2).equalsIgnoreCase("applyMakeup"))
                      {
                        localObject1 = localJSONObject1.optString("makeupType", null);
                        if (Util.isNullOrNil((String)localObject1))
                        {
                          Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
                          locala.er("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("makeup");
                        if (localJSONObject2 == null)
                        {
                          Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
                          locala.er("fail");
                          AppMethodBeat.o(138874);
                          return;
                        }
                        if (((String)localObject1).equalsIgnoreCase("lipStick"))
                        {
                          localObject1 = localp.cHR.e("applyMakeup", localJSONObject1);
                          Log.i(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(((k)localObject1).errorCode), ((k)localObject1).errorInfo });
                          if (((k)localObject1).errorCode == 0) {}
                          for (localObject1 = "ok";; localObject1 = "fail")
                          {
                            locala.er((String)localObject1);
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
                            Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                            locala.er("fail");
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
                            localp.a((String[])localObject1, (String[])localObject2, (String[])localObject3, localJSONObject2, locala, localJSONObject1);
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
                            Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                            locala.er("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject2 = localJSONObject2.optString("leftPathMD5", null);
                          localObject3 = localJSONObject2.optString("rightPath", null);
                          if (Util.isNullOrNil((String)localObject3))
                          {
                            Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, rightPath is empty");
                            locala.er("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          str = localJSONObject2.optString("rightPathMD5", null);
                          localp.a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str }, new String[] { "leftPath", "rightPath" }, localJSONObject2, locala, localJSONObject1);
                          AppMethodBeat.o(138874);
                          return;
                        }
                        if (((String)localObject1).equalsIgnoreCase("faceContour"))
                        {
                          localObject1 = localJSONObject2.optString("highlightPath", null);
                          if (Util.isNullOrNil((String)localObject1))
                          {
                            Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, highLightPath is empty");
                            locala.er("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          localObject2 = localJSONObject2.optString("highlightPathMD5", null);
                          localObject3 = localJSONObject2.optString("shadowPath", null);
                          if (Util.isNullOrNil((String)localObject3))
                          {
                            Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, shadowPath is empty");
                            locala.er("fail");
                            AppMethodBeat.o(138874);
                            return;
                          }
                          str = localJSONObject2.optString("shadowPathMD5", null);
                          localp.a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str }, new String[] { "highlightPath", "shadowPath" }, localJSONObject2, locala, localJSONObject1);
                          AppMethodBeat.o(138874);
                          return;
                        }
                        Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
                        locala.er("fail");
                        AppMethodBeat.o(138874);
                        return;
                      }
                      Log.w(localp.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
                      locala.er("fail");
                      AppMethodBeat.o(138874);
                      return;
                    }
                    localObject3 = localJSONObject1.optString("md5", null);
                    boolean bool = ((String)localObject2).equalsIgnoreCase("applySticker");
                    localp.cHU.a(locala, (String)localObject1, (String)localObject3, bool, new p.6(localp, locala, localJSONObject1, (String)localObject2));
                    AppMethodBeat.o(138874);
                    return;
                  }
                }
                localObject3 = localp.cHR.e((String)localObject2, localJSONObject1);
                Log.i(localp.getLogTag(), "operate, type:%s, error:[%s, %s]", new Object[] { localObject2, Integer.valueOf(((k)localObject3).errorCode), ((k)localObject3).errorInfo });
                if (((k)localObject3).errorCode == 0) {}
                for (localObject1 = "ok";; localObject1 = "fail")
                {
                  locala.er((String)localObject1);
                  if ((((String)localObject2).equalsIgnoreCase("stop")) && (((k)localObject3).errorCode == 0) && (localp.cHU != null)) {
                    localp.cHU.c(localp, localp.cFj);
                  }
                  AppMethodBeat.o(138874);
                  return;
                }
              }
              locala.er("fail");
              AppMethodBeat.o(138874);
              return;
            }
            if (((String)localObject1).contains("remove"))
            {
              localp.iX(8);
              localp.release();
              locala.er("ok");
            }
          }
          AppMethodBeat.o(138874);
        }
      });
    }
    AppMethodBeat.o(138884);
    return null;
  }
  
  final void iX(int paramInt)
  {
    AppMethodBeat.i(138893);
    if (this.cHS != null) {
      this.cHS.be(paramInt);
    }
    AppMethodBeat.o(138893);
  }
  
  final boolean je(int paramInt)
  {
    AppMethodBeat.i(138880);
    if (paramInt != this.mLastAngle)
    {
      this.mLastAngle = paramInt;
      Log.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      if (this.cHR != null)
      {
        this.cHR.notifyOrientationChanged(paramInt);
        AppMethodBeat.o(138880);
        return true;
      }
    }
    AppMethodBeat.o(138880);
    return false;
  }
  
  final void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138887);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.cFl = g.Di(paramJSONObject.optInt("width", 0));
        this.cFm = g.Di(paramJSONObject.optInt("height", 0));
        Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
        Ts();
      }
    }
    AppMethodBeat.o(138887);
  }
  
  final void m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178836);
    if (paramJSONObject.has("filterImage"))
    {
      this.cHV = paramJSONObject.optString("filterImage", this.cHV);
      this.cHW = paramJSONObject.optString("filterImageMd5", null);
      if (Util.isNullOrNil(this.cHV)) {
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
      if ((this.cHV.startsWith("http://")) || (this.cHV.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
    AppMethodBeat.o(178836);
  }
  
  final void n(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(226863);
    if (this.cHR == null)
    {
      Log.i(getLogTag(), "insert, adapter is null");
      AppMethodBeat.o(226863);
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
    this.cFj = parama;
    this.cFk = new com.tencent.luggage.xweb_ext.extendplugin.a.a()
    {
      public final void iW(int paramAnonymousInt)
      {
        AppMethodBeat.i(178815);
        Log.i(p.this.getLogTag(), "onBackground, type: ".concat(String.valueOf(paramAnonymousInt)));
        p localp = p.this;
        if (localp.cId != null) {
          localp.cId.post(new p.4(localp, paramAnonymousInt));
        }
        AppMethodBeat.o(178815);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(178816);
        p localp = p.this;
        if (localp.cId != null) {
          localp.cId.post(new p.5(localp));
        }
        AppMethodBeat.o(178816);
      }
      
      public final void onForeground()
      {
        AppMethodBeat.i(178814);
        Log.i(p.this.getLogTag(), "onForeground");
        p localp = p.this;
        if (localp.cId != null) {
          localp.cId.post(new p.3(localp));
        }
        AppMethodBeat.o(178814);
      }
    };
    parama.a(this.cFk);
    Object localObject = parama.SR();
    a(parama, (JSONObject)localObject);
    l((JSONObject)localObject);
    n((JSONObject)localObject);
    o((JSONObject)localObject);
    m((JSONObject)localObject);
    Bundle localBundle = com.tencent.luggage.xweb_ext.extendplugin.component.live.a.k((JSONObject)localObject);
    if (this.cHU != null)
    {
      localObject = this.cHU.c(parama, localBundle);
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i(getLogTag(), "insert fail, message:%s", new Object[] { localObject });
        parama.er("fail: can not insert VOIP mode LivePusher now");
        Toast.makeText(parama.getContext(), (CharSequence)localObject, 0).show();
        AppMethodBeat.o(226863);
        return;
      }
    }
    k localk = this.cHR.t(localBundle);
    Log.i(getLogTag(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    if (localk.errorCode == 0) {}
    for (localObject = "ok";; localObject = "fail")
    {
      parama.er((String)localObject);
      o(parama);
      p(parama);
      if ((localk.errorCode == 0) && (this.cHU != null)) {
        this.cHU.a(this, this.cFj, localBundle);
      }
      AppMethodBeat.o(226863);
      return;
    }
  }
  
  final void n(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(138889);
    if (paramJSONObject.has("focusMode"))
    {
      if (paramJSONObject.optInt("focusMode", 0) != 0) {
        bool = true;
      }
      this.cHY = bool;
    }
    AppMethodBeat.o(138889);
  }
  
  public final void o(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138883);
    if (this.cId != null) {
      this.cId.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178834);
          p.a(p.this, paramMotionEvent);
          AppMethodBeat.o(178834);
        }
      });
    }
    AppMethodBeat.o(138883);
  }
  
  final void o(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138885);
    if (this.cHU != null) {
      this.cHU.a(parama, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void K(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(178821);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.n(paramAnonymousString2, false);
            Log.i(p.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (p.this.cHR != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("backgroundImage", paramAnonymousString1);
              p.this.cHR.u(paramAnonymousString2);
            }
            AppMethodBeat.o(178821);
            return;
          }
          Log.i(p.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
          if (p.this.cHT != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            p.this.cHT.a(p.this.getId(), 10004, "load background image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(178821);
        }
      });
    }
    AppMethodBeat.o(138885);
  }
  
  final void o(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138890);
    if (paramJSONObject.has("zoom")) {
      this.cHZ = paramJSONObject.optBoolean("zoom", false);
    }
    AppMethodBeat.o(138890);
  }
  
  final void p(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(178835);
    if ((this.cHU != null) && (!Util.isNullOrNil(this.cHV))) {
      this.cHU.a(parama, this.cHV, this.cHW, new com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a()
      {
        public final void K(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(223720);
          if (!Util.isNullOrNil(paramAnonymousString2))
          {
            paramAnonymousString1 = q.n(paramAnonymousString2, false);
            Log.i(p.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", new Object[] { paramAnonymousString1 });
            if (p.this.cHR != null)
            {
              paramAnonymousString2 = new Bundle();
              paramAnonymousString2.putString("filterImage", paramAnonymousString1);
              p.this.cHR.u(paramAnonymousString2);
            }
            AppMethodBeat.o(223720);
            return;
          }
          Log.i(p.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
          if (p.this.cHT != null)
          {
            paramAnonymousString2 = new HashMap();
            paramAnonymousString2.put("url", paramAnonymousString1);
            p.this.cHT.a(p.this.getId(), 10005, "load filter image fail", paramAnonymousString2);
          }
          AppMethodBeat.o(223720);
        }
      });
    }
    AppMethodBeat.o(178835);
  }
  
  final void release()
  {
    AppMethodBeat.i(138892);
    if (this.cHU != null)
    {
      this.cHU.c(this, this.cFj);
      this.cHU.a(this, this.cFj);
    }
    if (this.cHR != null)
    {
      this.cHR.TK();
      this.cHR = null;
    }
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    if (this.cFj != null)
    {
      this.cFj.ST();
      this.cFk = null;
    }
    Log.i(getLogTag(), "LivePusher release handler thread");
    if (this.cId != null) {
      this.cId.removeCallbacksAndMessages(null);
    }
    if (this.cIe != null) {
      this.cIe.quitSafely();
    }
    AppMethodBeat.o(138892);
  }
  
  final void v(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(138894);
    if (this.cHR != null)
    {
      k localk = this.cHR.u(paramFloat1, paramFloat2);
      Log.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(localk.errorCode), localk.errorInfo });
    }
    AppMethodBeat.o(138894);
  }
  
  final class a
    implements Runnable
  {
    int cIo;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(138875);
      this.number += 1;
      int i = p.getRotationAngle();
      if (i == this.cIo)
      {
        p.this.je(i);
        AppMethodBeat.o(138875);
        return;
      }
      if (this.number < 8) {
        p.this.mHandler.postDelayed(this, 250L);
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
    MotionEvent cIp;
    
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(138876);
      if ((p.this.cHY) && (p.this.cFl != 0) && (p.this.cFm != 0)) {
        p.this.v(this.cIp.getX() / p.this.cFl, this.cIp.getY() / p.this.cFm);
      }
      AppMethodBeat.o(138876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p
 * JD-Core Version:    0.7.0.1
 */