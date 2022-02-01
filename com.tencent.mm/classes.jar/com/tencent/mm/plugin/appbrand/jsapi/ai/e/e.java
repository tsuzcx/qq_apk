package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
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
  private s cFD = null;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.a cKg = null;
  private HandlerThread mHandlerThread;
  b pKP;
  c pLR;
  double pLW;
  private volatile boolean pLX = false;
  private int pLm;
  private String pLn;
  private MTimerHandler pzi;
  
  private void a(az paramaz, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(paramaz instanceof j)) && (!(paramaz instanceof h))) {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramaz.getName(), paramJSONObject.toString() });
    }
    paramaz = paramaz.agU(paramJSONObject.toString());
    if (this.pKP != null)
    {
      paramJSONObject = this.pKP.okQ;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof v))
        {
          paramJSONObject = (v)paramJSONObject;
          paramJSONObject.a(paramaz, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.a(paramaz, null);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof ad))
        {
          paramJSONObject = (ad)paramJSONObject;
          paramJSONObject.a(paramaz, null);
          paramJSONObject = paramJSONObject.QW();
          if (paramJSONObject != null) {
            paramJSONObject.a(paramaz, null);
          }
          AppMethodBeat.o(139595);
          return;
        }
        paramJSONObject.a(paramaz, null);
      }
    }
    AppMethodBeat.o(139595);
  }
  
  private JSONObject bWg()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.pLn);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  private void bWh()
  {
    AppMethodBeat.i(139593);
    Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.pzi != null) {
      this.pzi.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bYB()
  {
    AppMethodBeat.i(139596);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.pKP != null)
        {
          localObject1 = e.this.pKP.okQ;
          if (localObject1 != null) {
            if ((localObject1 instanceof v)) {
              localObject1 = ((v)localObject1).ax(Activity.class);
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
            if ((!(localObject1 instanceof ad)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).getContext() instanceof Activity))) {
              break label128;
            }
            localObject1 = (Activity)((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).getContext();
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
  
  private void bYC()
  {
    AppMethodBeat.i(227617);
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.pLR == null) || (this.pKP == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(227617);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.pKP);
    if (locala == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(227617);
      return;
    }
    locala.e(this.pLR);
    AppMethodBeat.o(227617);
  }
  
  public final void H(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.pLW = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.pLW);
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
  
  public final void a(s params)
  {
    try
    {
      this.cFD = params;
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
      this.cKg = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void bf(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = bWg();
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
  
  public final void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227592);
    if (this.pLX)
    {
      Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
      AppMethodBeat.o(227592);
      return;
    }
    try
    {
      int i = Math.abs(paramInt1 - this.pLm);
      if (i < 250)
      {
        AppMethodBeat.o(227592);
        return;
      }
      if (this.cKg != null) {
        this.cKg.cs(paramInt1, paramInt2);
      }
      this.pLm = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = bWg();
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a(new j((byte)0), localJSONObject);
      AppMethodBeat.o(227592);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(227592);
    }
  }
  
  public final void cv(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    this.pLX = false;
    try
    {
      this.pLm = 0;
      JSONObject localJSONObject = bWg();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.e.c.d.ik("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.pzi == null) && (this.mHandlerThread != null))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.pzi = new MTimerHandler(this.mHandlerThread.getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            if (e.this.pLR != null) {
              e.this.cs(e.this.pLR.getCurrentPosition(), (int)(e.this.pLW * 1000.0D));
            }
            AppMethodBeat.o(139581);
            return true;
          }
        }, true);
      }
      if (this.pzi != null) {
        this.pzi.startTimer(0L, 250L);
      }
      if ((this.pKP != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.pKP.getAppId())))
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
          if (e.this.pKP != null)
          {
            localObject1 = e.this.pKP.okQ;
            if (localObject1 != null) {
              if ((localObject1 instanceof v)) {
                localObject1 = ((v)localObject1).ax(Activity.class);
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
              if ((!(localObject1 instanceof ad)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).getContext() instanceof Activity))) {
                break label128;
              }
              localObject1 = (Activity)((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).getContext();
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
        com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.pKP);
        if (locala == null) {
          Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.pLR);
        }
      }
    }
    Log.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.pLR == null) || (this.pKP == null))
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.cFD != null) {
        this.cFD.cm(paramBoolean);
      }
      AppMethodBeat.o(177220);
      return;
    }
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(177221);
    try
    {
      a(new e((byte)0), bWg());
      bWh();
      bYB();
      bYC();
      if (this.cFD != null) {
        if (!paramBoolean)
        {
          this.cFD.onPause();
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
      this.cFD.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void cx(boolean paramBoolean)
  {
    AppMethodBeat.i(227608);
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(227608);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(227608);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    bWh();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void ew(String paramString)
  {
    this.pLn = paramString;
  }
  
  public final void i(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    bWh();
    bYB();
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bYC();
      if (this.cFD != null) {
        this.cFD.onError();
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
  
  public final void jh(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = bWg();
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
  
  public final void ji(int paramInt)
  {
    AppMethodBeat.i(227606);
    this.pLX = false;
    if (((this.pzi == null) || (this.pzi.stopped())) && (this.pLR != null))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
      cs(this.pLR.getCurrentPosition(), (int)(this.pLW * 1000.0D));
    }
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(227606);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(227606);
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof b)) {
      this.pKP = ((b)parama);
    }
  }
  
  public final void m(c paramc)
  {
    this.pLR = paramc;
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), bWg());
      bWh();
      bYB();
      bYC();
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
    this.pLX = true;
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.cFD != null) {
        this.cFD.Tk();
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
    extends az
  {
    private static final int CTRL_INDEX = 838;
    private static final String NAME = "onXWebVideoBackgroundPlaybackChange";
  }
  
  static final class b
    extends az
  {
    private static final int CTRL_INDEX = 543;
    private static final String NAME = "onXWebVideoEnded";
  }
  
  static final class c
    extends az
  {
    private static final int CTRL_INDEX = 545;
    private static final String NAME = "onXWebVideoError";
  }
  
  static final class d
    extends az
  {
    private static final int CTRL_INDEX = 546;
    private static final String NAME = "onXWebVideoLoadedMetaData";
  }
  
  static final class e
    extends az
  {
    private static final int CTRL_INDEX = 542;
    private static final String NAME = "onXWebVideoPause";
  }
  
  static final class f
    extends az
  {
    private static final int CTRL_INDEX = 541;
    private static final String NAME = "onXWebVideoPlay";
  }
  
  static final class g
    extends az
  {
    private static final int CTRL_INDEX = 683;
    private static final String NAME = "onXWebVideoPreloadedMetaData";
  }
  
  static final class h
    extends az
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
  }
  
  static final class i
    extends az
  {
    private static final int CTRL_INDEX = 837;
    private static final String NAME = "onXWebVideoSeekComplete";
  }
  
  static final class j
    extends az
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
  
  static final class k
    extends az
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.e
 * JD-Core Version:    0.7.0.1
 */