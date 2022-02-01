package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
{
  private com.tencent.luggage.xweb_ext.extendplugin.component.s cEX = null;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.a cJC = null;
  private MTimerHandler mAM;
  private HandlerThread mHandlerThread;
  b mJX;
  c mKZ;
  private int mKu;
  private String mKv;
  double mLe;
  private volatile boolean mLf = false;
  
  private void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(parambc instanceof j)) && (!(parambc instanceof h))) {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { parambc.getName(), paramJSONObject.toString() });
    }
    parambc = parambc.Zh(paramJSONObject.toString());
    if (this.mJX != null)
    {
      paramJSONObject = this.mJX.lqg;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof com.tencent.mm.plugin.appbrand.s))
        {
          paramJSONObject = (com.tencent.mm.plugin.appbrand.s)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.a(parambc, null);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof ac))
        {
          paramJSONObject = (ac)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.NY();
          if (paramJSONObject != null) {
            paramJSONObject.a(parambc, null);
          }
          AppMethodBeat.o(139595);
          return;
        }
        paramJSONObject.a(parambc, null);
      }
    }
    AppMethodBeat.o(139595);
  }
  
  private JSONObject bKv()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.mKv);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  private void bKw()
  {
    AppMethodBeat.i(139593);
    Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.mAM != null) {
      this.mAM.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bMk()
  {
    AppMethodBeat.i(139596);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.mJX != null)
        {
          localObject1 = e.this.mJX.lqg;
          if (localObject1 != null) {
            if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.s)) {
              localObject1 = ((com.tencent.mm.plugin.appbrand.s)localObject1).ay(Activity.class);
            }
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
            try
            {
              ((Activity)localObject1).getWindow().clearFlags(128);
              AppMethodBeat.o(139583);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", new Object[] { localException });
            }
            if ((!(localObject1 instanceof ac)) || (!(((f)localObject1).getContext() instanceof Activity))) {
              break label128;
            }
            localObject1 = (Activity)((f)localObject1).getContext();
            continue;
          }
          AppMethodBeat.o(139583);
          return;
          label128:
          Object localObject2 = null;
        }
      }
    });
    AppMethodBeat.o(139596);
  }
  
  private void bMl()
  {
    AppMethodBeat.i(215898);
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.mKZ == null) || (this.mJX == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(215898);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
    if (locala == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(215898);
      return;
    }
    locala.e(this.mKZ);
    AppMethodBeat.o(215898);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.mLe = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.mLe);
      a(new d((byte)0), localJSONObject);
      AppMethodBeat.o(139590);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139590);
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.s params)
  {
    try
    {
      this.cEX = params;
      return;
    }
    finally
    {
      params = finally;
      throw params;
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.a parama)
  {
    try
    {
      this.cJC = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void aX(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("preloadSize", paramLong);
      a(new g((byte)0), localJSONObject);
      AppMethodBeat.o(139591);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139591);
    }
  }
  
  public final void b(c paramc)
  {
    this.mKZ = paramc;
  }
  
  public final void bZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215895);
    if (this.mLf)
    {
      Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
      AppMethodBeat.o(215895);
      return;
    }
    try
    {
      int i = Math.abs(paramInt1 - this.mKu);
      if (i < 250)
      {
        AppMethodBeat.o(215895);
        return;
      }
      if (this.cJC != null) {
        this.cJC.bZ(paramInt1, paramInt2);
      }
      this.mKu = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = bKv();
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a(new j((byte)0), localJSONObject);
      AppMethodBeat.o(215895);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(215895);
    }
  }
  
  public final void ci(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    this.mLf = false;
    try
    {
      this.mKu = 0;
      JSONObject localJSONObject = bKv();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.f.c.d.hA("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.mAM == null) && (this.mHandlerThread != null))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.mAM = new MTimerHandler(this.mHandlerThread.getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            if (e.this.mKZ != null) {
              e.this.bZ(e.this.mKZ.getCurrentPosition(), (int)(e.this.mLe * 1000.0D));
            }
            AppMethodBeat.o(139581);
            return true;
          }
        }, true);
      }
      if (this.mAM != null) {
        this.mAM.startTimer(0L, 250L);
      }
      if ((this.mJX != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.mJX.getAppId())))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.mJX != null)
          {
            localObject1 = e.this.mJX.lqg;
            if (localObject1 != null) {
              if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.s)) {
                localObject1 = ((com.tencent.mm.plugin.appbrand.s)localObject1).ay(Activity.class);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
              try
              {
                ((Activity)localObject1).getWindow().addFlags(128);
                AppMethodBeat.o(139582);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", new Object[] { localException });
              }
              if ((!(localObject1 instanceof ac)) || (!(((f)localObject1).getContext() instanceof Activity))) {
                break label128;
              }
              localObject1 = (Activity)((f)localObject1).getContext();
              continue;
            }
            AppMethodBeat.o(139582);
            return;
            label128:
            Object localObject2 = null;
          }
        }
      });
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
        if (locala == null) {
          Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.mKZ);
        }
      }
    }
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.mKZ == null) || (this.mJX == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.cEX != null) {
        this.cEX.bZ(paramBoolean);
      }
      AppMethodBeat.o(177220);
      return;
    }
  }
  
  public final void cj(boolean paramBoolean)
  {
    AppMethodBeat.i(177221);
    try
    {
      a(new e((byte)0), bKv());
      bKw();
      bMk();
      bMl();
      if (this.cEX != null) {
        if (!paramBoolean)
        {
          this.cEX.onPause();
          AppMethodBeat.o(177221);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
      this.cEX.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(215897);
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(215897);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(215897);
    }
  }
  
  public final void dV(String paramString)
  {
    this.mKv = paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    bKw();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    bKw();
    bMk();
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bMl();
      if (this.cEX != null) {
        this.cEX.onError();
      }
      AppMethodBeat.o(139589);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
      }
    }
  }
  
  public final void ie(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("buffered", paramInt);
      a(new h((byte)0), localJSONObject);
      AppMethodBeat.o(139588);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139588);
    }
  }
  
  public final void jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(215896);
    this.mLf = false;
    if (((this.mAM == null) || (this.mAM.stopped())) && (this.mKZ != null))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
      bZ(this.mKZ.getCurrentPosition(), (int)(this.mLe * 1000.0D));
    }
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(215896);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(215896);
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof b)) {
      this.mJX = ((b)parama);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), bKv());
      bKw();
      bMk();
      bMl();
      AppMethodBeat.o(139586);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139587);
    this.mLf = true;
    try
    {
      JSONObject localJSONObject = bKv();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.cEX != null) {
        this.cEX.PL();
      }
      AppMethodBeat.o(139587);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      }
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 838;
    private static final String NAME = "onXWebVideoBackgroundPlaybackChange";
  }
  
  static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 543;
    private static final String NAME = "onXWebVideoEnded";
  }
  
  static final class c
    extends bc
  {
    private static final int CTRL_INDEX = 545;
    private static final String NAME = "onXWebVideoError";
  }
  
  static final class d
    extends bc
  {
    private static final int CTRL_INDEX = 546;
    private static final String NAME = "onXWebVideoLoadedMetaData";
  }
  
  static final class e
    extends bc
  {
    private static final int CTRL_INDEX = 542;
    private static final String NAME = "onXWebVideoPause";
  }
  
  static final class f
    extends bc
  {
    private static final int CTRL_INDEX = 541;
    private static final String NAME = "onXWebVideoPlay";
  }
  
  static final class g
    extends bc
  {
    private static final int CTRL_INDEX = 683;
    private static final String NAME = "onXWebVideoPreloadedMetaData";
  }
  
  static final class h
    extends bc
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
  }
  
  static final class i
    extends bc
  {
    private static final int CTRL_INDEX = 837;
    private static final String NAME = "onXWebVideoSeekComplete";
  }
  
  static final class j
    extends bc
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
  
  static final class k
    extends bc
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.e
 * JD-Core Version:    0.7.0.1
 */