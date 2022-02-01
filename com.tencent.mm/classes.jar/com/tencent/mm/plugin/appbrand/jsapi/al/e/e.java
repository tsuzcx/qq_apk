package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
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
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.a eDR = null;
  private s eyR = null;
  private HandlerThread mHandlerThread;
  private MTimerHandler sEn;
  b sPI;
  c sQH;
  double sQM;
  private volatile boolean sQN = false;
  private int sQg;
  private String sQh;
  
  private void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(parambc instanceof e.j)) && (!(parambc instanceof e.h))) {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { parambc.getName(), paramJSONObject.toString() });
    }
    parambc = parambc.ZR(paramJSONObject.toString());
    if (this.sPI != null)
    {
      paramJSONObject = this.sPI.rot;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof y))
        {
          paramJSONObject = (y)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.a(parambc, null);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof ad))
        {
          paramJSONObject = (ad)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.ari();
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
  
  private JSONObject cws()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.sQh);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  private void cwt()
  {
    AppMethodBeat.i(139593);
    Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.sEn != null) {
      this.sEn.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void cyR()
  {
    AppMethodBeat.i(139596);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.sPI != null)
        {
          localObject1 = e.this.sPI.rot;
          if (localObject1 != null) {
            if ((localObject1 instanceof y)) {
              localObject1 = ((y)localObject1).aQ(Activity.class);
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
            if ((!(localObject1 instanceof ad)) || (!(((f)localObject1).getContext() instanceof Activity))) {
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
  
  private void cyS()
  {
    AppMethodBeat.i(327171);
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.sQH == null) || (this.sPI == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(327171);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.sPI);
    if (locala == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(327171);
      return;
    }
    locala.e(this.sQH);
    AppMethodBeat.o(327171);
  }
  
  public final void X(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.sQM = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.sQM);
      a(new e.d((byte)0), localJSONObject);
      AppMethodBeat.o(139590);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139590);
    }
  }
  
  public final void a(s params)
  {
    try
    {
      this.eyR = params;
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
      this.eDR = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void db(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    this.sQN = false;
    try
    {
      this.sQg = 0;
      JSONObject localJSONObject = cws();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new e.f((byte)0), localJSONObject);
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.threadpool.c.d.jw("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.sEn == null) && (this.mHandlerThread != null))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.sEn = new MTimerHandler(this.mHandlerThread.getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            if (e.this.sQH != null) {
              e.this.dh(e.this.sQH.getCurrentPosition(), (int)(e.this.sQM * 1000.0D));
            }
            AppMethodBeat.o(139581);
            return true;
          }
        }, true);
      }
      if (this.sEn != null) {
        this.sEn.startTimer(0L, 250L);
      }
      if ((this.sPI != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.sPI.getAppId())))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        new com.tencent.mm.plugin.appbrand.jsapi.video.c.a().publish();
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.sPI != null)
          {
            localObject1 = e.this.sPI.rot;
            if (localObject1 != null) {
              if ((localObject1 instanceof y)) {
                localObject1 = ((y)localObject1).aQ(Activity.class);
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
              if ((!(localObject1 instanceof ad)) || (!(((f)localObject1).getContext() instanceof Activity))) {
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
        com.tencent.mm.plugin.appbrand.jsapi.al.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.sPI);
        if (locala == null) {
          Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.sQH);
        }
      }
    }
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.sQH == null) || (this.sPI == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.eyR != null) {
        this.eyR.cS(paramBoolean);
      }
      AppMethodBeat.o(177220);
      return;
    }
  }
  
  public final void dc(boolean paramBoolean)
  {
    AppMethodBeat.i(177221);
    try
    {
      a(new e.e((byte)0), cws());
      cwt();
      cyR();
      cyS();
      if (this.eyR != null) {
        if (!paramBoolean)
        {
          this.eyR.onPause();
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
      this.eyR.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void dd(boolean paramBoolean)
  {
    AppMethodBeat.i(327214);
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new e.a((byte)0), localJSONObject);
      AppMethodBeat.o(327214);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(327214);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    cwt();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327185);
    if (this.sQN)
    {
      Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
      AppMethodBeat.o(327185);
      return;
    }
    try
    {
      int i = Math.abs(paramInt1 - this.sQg);
      if (i < 250)
      {
        AppMethodBeat.o(327185);
        return;
      }
      if (this.eDR != null) {
        this.eDR.dh(paramInt1, paramInt2);
      }
      this.sQg = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = cws();
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a(new e.j((byte)0), localJSONObject);
      AppMethodBeat.o(327185);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(327185);
    }
  }
  
  public final void dx(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("preloadSize", paramLong);
      a(new e.g((byte)0), localJSONObject);
      AppMethodBeat.o(139591);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139591);
    }
  }
  
  public final void fT(String paramString)
  {
    this.sQh = paramString;
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof b)) {
      this.sPI = ((b)parama);
    }
  }
  
  public final void m(c paramc)
  {
    this.sQH = paramc;
  }
  
  public final void mJ(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("buffered", paramInt);
      a(new e.h((byte)0), localJSONObject);
      AppMethodBeat.o(139588);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139588);
    }
  }
  
  public final void mK(int paramInt)
  {
    AppMethodBeat.i(327205);
    this.sQN = false;
    if (((this.sEn == null) || (this.sEn.stopped())) && (this.sQH != null))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
      dh(this.sQH.getCurrentPosition(), (int)(this.sQM * 1000.0D));
    }
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("position", paramInt);
      a(new e.i((byte)0), localJSONObject);
      AppMethodBeat.o(327205);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(327205);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new e.b((byte)0), cws());
      cwt();
      cyR();
      cyS();
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
  
  public final void onVideoError(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    cwt();
    cyR();
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new e.c((byte)0), localJSONObject);
      cyS();
      if (this.eyR != null) {
        this.eyR.atR();
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
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139587);
    this.sQN = true;
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new e.k((byte)0), localJSONObject);
      if (this.eyR != null) {
        this.eyR.atP();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.e
 * JD-Core Version:    0.7.0.1
 */