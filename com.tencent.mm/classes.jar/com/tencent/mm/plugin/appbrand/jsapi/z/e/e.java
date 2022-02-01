package com.tencent.mm.plugin.appbrand.jsapi.z.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  implements com.tencent.luggage.k.a.a.b.b.d
{
  private n chP = null;
  com.tencent.luggage.k.a.a.b.a cky = null;
  private au kTk;
  com.tencent.mm.plugin.appbrand.i.b laU;
  com.tencent.luggage.k.a.a.b.b lbT;
  double lbY;
  int lbo;
  private String lbp;
  private HandlerThread mHandlerThread;
  
  private void bky()
  {
    AppMethodBeat.i(139593);
    ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.kTk != null) {
      this.kTk.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bme()
  {
    AppMethodBeat.i(139596);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.laU != null)
        {
          localObject1 = e.this.laU.jOV;
          if (localObject1 != null) {
            if ((localObject1 instanceof q)) {
              localObject1 = ((q)localObject1).au(Activity.class);
            }
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
            try
            {
              ((Activity)localObject1).getWindow().clearFlags(128);
              AppMethodBeat.o(139583);
              return;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", new Object[] { localException });
            }
            if ((!(localObject1 instanceof aa)) || (!(((c)localObject1).getContext() instanceof Activity))) {
              break label128;
            }
            localObject1 = (Activity)((c)localObject1).getContext();
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
  
  private void bmf()
  {
    AppMethodBeat.i(206762);
    ac.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.lbT == null) || (this.laU == null))
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(206762);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala = com.tencent.luggage.k.a.a.e.f(this.laU);
    if (locala == null)
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(206762);
      return;
    }
    locala.e(this.lbT);
    AppMethodBeat.o(206762);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.lbY = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.lbY);
      a(new d((byte)0), localJSONObject);
      AppMethodBeat.o(139590);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139590);
    }
  }
  
  public final void a(com.tencent.luggage.k.a.a.b.a parama)
  {
    try
    {
      this.cky = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(n paramn)
  {
    try
    {
      this.chP = paramn;
      return;
    }
    finally
    {
      paramn = finally;
      throw paramn;
    }
  }
  
  final void a(ar paramar, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(paramar instanceof j)) && (!(paramar instanceof h))) {
      ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramar.getName(), paramJSONObject.toString() });
    }
    paramar = paramar.LO(paramJSONObject.toString());
    if (this.laU != null)
    {
      paramJSONObject = this.laU.jOV;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof q))
        {
          paramJSONObject = (q)paramJSONObject;
          paramJSONObject.b(paramar);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramar);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof aa))
        {
          paramJSONObject = (aa)paramJSONObject;
          paramJSONObject.b(paramar);
          paramJSONObject = paramJSONObject.CX();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramar);
          }
          AppMethodBeat.o(139595);
          return;
        }
        paramJSONObject.b(paramar);
      }
    }
    AppMethodBeat.o(139595);
  }
  
  public final void aL(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("preloadSize", paramLong);
      a(new g((byte)0), localJSONObject);
      AppMethodBeat.o(139591);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139591);
    }
  }
  
  public final void b(com.tencent.luggage.k.a.a.b.b paramb)
  {
    this.lbT = paramb;
  }
  
  public final void bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    try
    {
      this.lbo = 0;
      JSONObject localJSONObject = bkx();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.e.c.d.gz("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.kTk == null) && (this.mHandlerThread != null))
      {
        ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.kTk = new au(this.mHandlerThread.getLooper(), new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            e locale;
            int i;
            int j;
            if (e.this.lbT != null)
            {
              locale = e.this;
              i = e.this.lbT.getCurrentPosition();
              j = (int)(e.this.lbY * 1000.0D);
            }
            for (;;)
            {
              try
              {
                int k = Math.abs(i - locale.lbo);
                if (k >= 250) {
                  continue;
                }
              }
              catch (JSONException localJSONException)
              {
                double d1;
                double d2;
                JSONObject localJSONObject;
                ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
                continue;
              }
              AppMethodBeat.o(139581);
              return true;
              if (locale.cky != null) {
                locale.cky.bX(i, j);
              }
              locale.lbo = i;
              d1 = j * 1.0D / 1000.0D;
              d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
              localJSONObject = locale.bkx();
              localJSONObject.put("position", d2);
              localJSONObject.put("duration", d1);
              locale.a(new e.j((byte)0), localJSONObject);
            }
          }
        }, true);
      }
      if (this.kTk != null) {
        this.kTk.au(0L, 250L);
      }
      if ((this.laU != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.laU.getAppId())))
      {
        ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        com.tencent.mm.sdk.b.a.GpY.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.laU != null)
          {
            localObject1 = e.this.laU.jOV;
            if (localObject1 != null) {
              if ((localObject1 instanceof q)) {
                localObject1 = ((q)localObject1).au(Activity.class);
              }
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ac.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
              try
              {
                ((Activity)localObject1).getWindow().addFlags(128);
                AppMethodBeat.o(139582);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", new Object[] { localException });
              }
              if ((!(localObject1 instanceof aa)) || (!(((c)localObject1).getContext() instanceof Activity))) {
                break label128;
              }
              localObject1 = (Activity)((c)localObject1).getContext();
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
        ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.z.a locala = com.tencent.luggage.k.a.a.e.f(this.laU);
        if (locala == null) {
          ac.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.lbT);
        }
      }
    }
    ac.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.lbT == null) || (this.laU == null))
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.chP != null) {
        this.chP.bA(paramBoolean);
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
      a(new e((byte)0), bkx());
      bky();
      bme();
      bmf();
      if (this.chP != null) {
        if (!paramBoolean)
        {
          this.chP.onPause();
          AppMethodBeat.o(177221);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
      this.chP.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(206761);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(206761);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(206761);
    }
  }
  
  final JSONObject bkx()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.lbp);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  public final void cx(String paramString)
  {
    this.lbp = paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    bky();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void f(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    bky();
    bme();
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bmf();
      if (this.chP != null) {
        this.chP.onError();
      }
      AppMethodBeat.o(139589);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
      }
    }
  }
  
  public final void gI(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("buffered", paramInt);
      a(new h((byte)0), localJSONObject);
      AppMethodBeat.o(139588);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139588);
    }
  }
  
  public final void gJ(int paramInt)
  {
    AppMethodBeat.i(206760);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(206760);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(206760);
    }
  }
  
  public final void m(com.tencent.luggage.k.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b)) {
      this.laU = ((com.tencent.mm.plugin.appbrand.i.b)parama);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), bkx());
      bky();
      bme();
      bmf();
      AppMethodBeat.o(139586);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139587);
    try
    {
      JSONObject localJSONObject = bkx();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.chP != null) {
        this.chP.Ex();
      }
      AppMethodBeat.o(139587);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      }
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 838;
    private static final String NAME = "onXWebVideoBackgroundPlaybackChange";
  }
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 543;
    private static final String NAME = "onXWebVideoEnded";
  }
  
  static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 545;
    private static final String NAME = "onXWebVideoError";
  }
  
  static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 546;
    private static final String NAME = "onXWebVideoLoadedMetaData";
  }
  
  static final class e
    extends ar
  {
    private static final int CTRL_INDEX = 542;
    private static final String NAME = "onXWebVideoPause";
  }
  
  static final class f
    extends ar
  {
    private static final int CTRL_INDEX = 541;
    private static final String NAME = "onXWebVideoPlay";
  }
  
  static final class g
    extends ar
  {
    private static final int CTRL_INDEX = 683;
    private static final String NAME = "onXWebVideoPreloadedMetaData";
  }
  
  static final class h
    extends ar
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
  }
  
  static final class i
    extends ar
  {
    private static final int CTRL_INDEX = 837;
    private static final String NAME = "onXWebVideoSeekComplete";
  }
  
  static final class j
    extends ar
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
  
  static final class k
    extends ar
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.e
 * JD-Core Version:    0.7.0.1
 */