package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  implements com.tencent.luggage.k.a.a.b.b.d
{
  private r ckN = null;
  com.tencent.luggage.k.a.a.b.a cnw = null;
  com.tencent.luggage.k.a.a.b.b kAB;
  double kAG;
  private av krS;
  com.tencent.mm.plugin.appbrand.i.b kzD;
  int kzW;
  private String kzX;
  private HandlerThread mHandlerThread;
  
  private void bdD()
  {
    AppMethodBeat.i(139593);
    ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.krS != null) {
      this.krS.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bfk()
  {
    AppMethodBeat.i(139596);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.kzD != null)
        {
          localObject1 = e.this.kzD.joJ;
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
            ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
            try
            {
              ((Activity)localObject1).getWindow().clearFlags(128);
              AppMethodBeat.o(139583);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", new Object[] { localException });
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
  
  private void bfl()
  {
    AppMethodBeat.i(195118);
    ad.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.kAB == null) || (this.kzD == null))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(195118);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = com.tencent.luggage.k.a.a.e.g(this.kzD);
    if (locala == null)
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(195118);
      return;
    }
    locala.e(this.kAB);
    AppMethodBeat.o(195118);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.kAG = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.kAG);
      a(new d((byte)0), localJSONObject);
      AppMethodBeat.o(139590);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139590);
    }
  }
  
  public final void a(com.tencent.luggage.k.a.a.b.a parama)
  {
    try
    {
      this.cnw = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(r paramr)
  {
    try
    {
      this.ckN = paramr;
      return;
    }
    finally
    {
      paramr = finally;
      throw paramr;
    }
  }
  
  final void a(ar paramar, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(paramar instanceof j)) && (!(paramar instanceof h))) {
      ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramar.getName(), paramJSONObject.toString() });
    }
    paramar = paramar.HK(paramJSONObject.toString());
    if (this.kzD != null)
    {
      paramJSONObject = this.kzD.joJ;
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
          paramJSONObject = paramJSONObject.Du();
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
  
  public final void aP(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("preloadSize", paramLong);
      a(new g((byte)0), localJSONObject);
      AppMethodBeat.o(139591);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(139591);
    }
  }
  
  public final void b(com.tencent.luggage.k.a.a.b.b paramb)
  {
    this.kAB = paramb;
  }
  
  public final void bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    try
    {
      this.kzW = 0;
      JSONObject localJSONObject = bdC();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.e.c.d.gv("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.krS == null) && (this.mHandlerThread != null))
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.krS = new av(this.mHandlerThread.getLooper(), new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            e locale;
            int i;
            int j;
            if (e.this.kAB != null)
            {
              locale = e.this;
              i = e.this.kAB.getCurrentPosition();
              j = (int)(e.this.kAG * 1000.0D);
            }
            for (;;)
            {
              try
              {
                int k = Math.abs(i - locale.kzW);
                if (k >= 250) {
                  continue;
                }
              }
              catch (JSONException localJSONException)
              {
                double d1;
                double d2;
                JSONObject localJSONObject;
                ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
                continue;
              }
              AppMethodBeat.o(139581);
              return true;
              if (locale.cnw != null) {
                locale.cnw.ca(i, j);
              }
              locale.kzW = i;
              d1 = j * 1.0D / 1000.0D;
              d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
              localJSONObject = locale.bdC();
              localJSONObject.put("position", d2);
              localJSONObject.put("duration", d1);
              locale.a(new e.j((byte)0), localJSONObject);
            }
          }
        }, true);
      }
      if (this.krS != null) {
        this.krS.av(0L, 250L);
      }
      if ((this.kzD != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.kzD.getAppId())))
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        com.tencent.mm.sdk.b.a.ESL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.kzD != null)
          {
            localObject1 = e.this.kzD.joJ;
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
              ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
              try
              {
                ((Activity)localObject1).getWindow().addFlags(128);
                AppMethodBeat.o(139582);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", new Object[] { localException });
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
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = com.tencent.luggage.k.a.a.e.g(this.kzD);
        if (locala == null) {
          ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.kAB);
        }
      }
    }
    ad.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.kAB == null) || (this.kzD == null))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.ckN != null) {
        this.ckN.bB(paramBoolean);
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
      a(new e((byte)0), bdC());
      bdD();
      bfk();
      bfl();
      if (this.ckN != null) {
        if (!paramBoolean)
        {
          this.ckN.onPause();
          AppMethodBeat.o(177221);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
      this.ckN.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(195117);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(195117);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(195117);
    }
  }
  
  final JSONObject bdC()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.kzX);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  public final void cI(String paramString)
  {
    this.kzX = paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    bdD();
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
    bdD();
    bfk();
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bfl();
      if (this.ckN != null) {
        this.ckN.onError();
      }
      AppMethodBeat.o(139589);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
      }
    }
  }
  
  public final void gY(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("buffered", paramInt);
      a(new h((byte)0), localJSONObject);
      AppMethodBeat.o(139588);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139588);
    }
  }
  
  public final void gZ(int paramInt)
  {
    AppMethodBeat.i(195116);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(195116);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(195116);
    }
  }
  
  public final void n(com.tencent.luggage.k.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b)) {
      this.kzD = ((com.tencent.mm.plugin.appbrand.i.b)parama);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), bdC());
      bdD();
      bfk();
      bfl();
      AppMethodBeat.o(139586);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139587);
    try
    {
      JSONObject localJSONObject = bdC();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.ckN != null) {
        this.ckN.ET();
      }
      AppMethodBeat.o(139587);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.e
 * JD-Core Version:    0.7.0.1
 */