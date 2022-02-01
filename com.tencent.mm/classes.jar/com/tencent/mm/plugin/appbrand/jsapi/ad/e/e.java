package com.tencent.mm.plugin.appbrand.jsapi.ad.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
{
  private s csH = null;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.a cvE = null;
  private int lCM;
  private String lCN;
  b lCs;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c lDr;
  double lDw;
  private aw luk;
  private HandlerThread mHandlerThread;
  
  private void a(at paramat, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(paramat instanceof j)) && (!(paramat instanceof h))) {
      ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramat.getName(), paramJSONObject.toString() });
    }
    paramat = paramat.PQ(paramJSONObject.toString());
    if (this.lCs != null)
    {
      paramJSONObject = this.lCs.kmw;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof r))
        {
          paramJSONObject = (r)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramat);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof z))
        {
          paramJSONObject = (z)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.Ey();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramat);
          }
          AppMethodBeat.o(139595);
          return;
        }
        paramJSONObject.b(paramat);
      }
    }
    AppMethodBeat.o(139595);
  }
  
  private JSONObject boS()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.lCN);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  private void boT()
  {
    AppMethodBeat.i(139593);
    ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.luk != null) {
      this.luk.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bqA()
  {
    AppMethodBeat.i(220648);
    ae.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.lDr == null) || (this.lCs == null))
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(220648);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lCs);
    if (locala == null)
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(220648);
      return;
    }
    locala.e(this.lDr);
    AppMethodBeat.o(220648);
  }
  
  private void bqz()
  {
    AppMethodBeat.i(139596);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.lCs != null)
        {
          localObject1 = e.this.lCs.kmw;
          if (localObject1 != null) {
            if ((localObject1 instanceof r)) {
              localObject1 = ((r)localObject1).au(Activity.class);
            }
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
            try
            {
              ((Activity)localObject1).getWindow().clearFlags(128);
              AppMethodBeat.o(139583);
              return;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", new Object[] { localException });
            }
            if ((!(localObject1 instanceof z)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext() instanceof Activity))) {
              break label128;
            }
            localObject1 = (Activity)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext();
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
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.lDw = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.lDw);
      a(new d((byte)0), localJSONObject);
      AppMethodBeat.o(139590);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139590);
    }
  }
  
  public final void a(s params)
  {
    try
    {
      this.csH = params;
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
      this.cvE = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void aL(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("preloadSize", paramLong);
      a(new g((byte)0), localJSONObject);
      AppMethodBeat.o(139591);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139591);
    }
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.lDr = paramc;
  }
  
  public final void bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    try
    {
      this.lCM = 0;
      JSONObject localJSONObject = boS();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.e.c.d.hg("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.luk == null) && (this.mHandlerThread != null))
      {
        ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.luk = new aw(this.mHandlerThread.getLooper(), new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            if (e.this.lDr != null) {
              e.this.bZ(e.this.lDr.getCurrentPosition(), (int)(e.this.lDw * 1000.0D));
            }
            AppMethodBeat.o(139581);
            return true;
          }
        }, true);
      }
      if (this.luk != null) {
        this.luk.ay(0L, 250L);
      }
      if ((this.lCs != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.lCs.getAppId())))
      {
        ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        com.tencent.mm.sdk.b.a.IvT.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.lCs != null)
          {
            localObject1 = e.this.lCs.kmw;
            if (localObject1 != null) {
              if ((localObject1 instanceof r)) {
                localObject1 = ((r)localObject1).au(Activity.class);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
              try
              {
                ((Activity)localObject1).getWindow().addFlags(128);
                AppMethodBeat.o(139582);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", new Object[] { localException });
              }
              if ((!(localObject1 instanceof z)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext() instanceof Activity))) {
                break label128;
              }
              localObject1 = (Activity)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext();
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
        ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lCs);
        if (locala == null) {
          ae.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.lDr);
        }
      }
    }
    ae.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.lDr == null) || (this.lCs == null))
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.csH != null) {
        this.csH.bA(paramBoolean);
      }
      AppMethodBeat.o(177220);
      return;
    }
  }
  
  public final void bK(boolean paramBoolean)
  {
    AppMethodBeat.i(177221);
    try
    {
      a(new e((byte)0), boS());
      boT();
      bqz();
      bqA();
      if (this.csH != null) {
        if (!paramBoolean)
        {
          this.csH.onPause();
          AppMethodBeat.o(177221);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
      this.csH.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(220647);
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(220647);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(220647);
    }
  }
  
  public final void bZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220645);
    try
    {
      int i = Math.abs(paramInt1 - this.lCM);
      if (i < 250)
      {
        AppMethodBeat.o(220645);
        return;
      }
      if (this.cvE != null) {
        this.cvE.bZ(paramInt1, paramInt2);
      }
      this.lCM = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = boS();
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a(new j((byte)0), localJSONObject);
      AppMethodBeat.o(220645);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(220645);
    }
  }
  
  public final void dC(String paramString)
  {
    this.lCN = paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    boT();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void gO(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("buffered", paramInt);
      a(new h((byte)0), localJSONObject);
      AppMethodBeat.o(139588);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139588);
    }
  }
  
  public final void gP(int paramInt)
  {
    AppMethodBeat.i(220646);
    if (((this.luk == null) || (this.luk.foU())) && (this.lDr != null))
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
      bZ(this.lDr.getCurrentPosition(), (int)(this.lDw * 1000.0D));
    }
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(220646);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(220646);
    }
  }
  
  public final void h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    boT();
    bqz();
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bqA();
      if (this.csH != null) {
        this.csH.onError();
      }
      AppMethodBeat.o(139589);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof b)) {
      this.lCs = ((b)parama);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), boS());
      boT();
      bqz();
      bqA();
      AppMethodBeat.o(139586);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139587);
    try
    {
      JSONObject localJSONObject = boS();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.csH != null) {
        this.csH.Gc();
      }
      AppMethodBeat.o(139587);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      }
    }
  }
  
  static final class a
    extends at
  {
    private static final int CTRL_INDEX = 838;
    private static final String NAME = "onXWebVideoBackgroundPlaybackChange";
  }
  
  static final class b
    extends at
  {
    private static final int CTRL_INDEX = 543;
    private static final String NAME = "onXWebVideoEnded";
  }
  
  static final class c
    extends at
  {
    private static final int CTRL_INDEX = 545;
    private static final String NAME = "onXWebVideoError";
  }
  
  static final class d
    extends at
  {
    private static final int CTRL_INDEX = 546;
    private static final String NAME = "onXWebVideoLoadedMetaData";
  }
  
  static final class e
    extends at
  {
    private static final int CTRL_INDEX = 542;
    private static final String NAME = "onXWebVideoPause";
  }
  
  static final class f
    extends at
  {
    private static final int CTRL_INDEX = 541;
    private static final String NAME = "onXWebVideoPlay";
  }
  
  static final class g
    extends at
  {
    private static final int CTRL_INDEX = 683;
    private static final String NAME = "onXWebVideoPreloadedMetaData";
  }
  
  static final class h
    extends at
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
  }
  
  static final class i
    extends at
  {
    private static final int CTRL_INDEX = 837;
    private static final String NAME = "onXWebVideoSeekComplete";
  }
  
  static final class j
    extends at
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
  
  static final class k
    extends at
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.e
 * JD-Core Version:    0.7.0.1
 */