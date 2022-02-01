package com.tencent.mm.plugin.appbrand.jsapi.ac.e;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.Window;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.at;
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
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
{
  private s cse = null;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.a cvb = null;
  private av lpN;
  b lxU;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c lyT;
  double lyY;
  int lyo;
  private String lyp;
  private HandlerThread mHandlerThread;
  
  private void boj()
  {
    AppMethodBeat.i(139593);
    ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.lpN != null) {
      this.lpN.stopTimer();
    }
    AppMethodBeat.o(139593);
  }
  
  private void bpP()
  {
    AppMethodBeat.i(139596);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139583);
        Object localObject1;
        if (e.this.lxU != null)
        {
          localObject1 = e.this.lxU.kjg;
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
            if ((!(localObject1 instanceof aa)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext() instanceof Activity))) {
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
  
  private void bpQ()
  {
    AppMethodBeat.i(186950);
    ad.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if ((this.lyT == null) || (this.lxU == null))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
      AppMethodBeat.o(186950);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lxU);
    if (locala == null)
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(186950);
      return;
    }
    locala.e(this.lyT);
    AppMethodBeat.o(186950);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(139590);
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.lyY = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.lyY);
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
  
  public final void a(s params)
  {
    try
    {
      this.cse = params;
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
      this.cvb = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  final void a(at paramat, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139595);
    if ((!(paramat instanceof j)) && (!(paramat instanceof h))) {
      ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramat.getName(), paramJSONObject.toString() });
    }
    paramat = paramat.Pi(paramJSONObject.toString());
    if (this.lxU != null)
    {
      paramJSONObject = this.lxU.kjg;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof q))
        {
          paramJSONObject = (q)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramat);
          }
          AppMethodBeat.o(139595);
          return;
        }
        if ((paramJSONObject instanceof aa))
        {
          paramJSONObject = (aa)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.Ew();
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
  
  public final void aL(long paramLong)
  {
    AppMethodBeat.i(139591);
    try
    {
      JSONObject localJSONObject = boi();
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
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.lyT = paramc;
  }
  
  public final void bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(177220);
    try
    {
      this.lyo = 0;
      JSONObject localJSONObject = boi();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new f((byte)0), localJSONObject);
      ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = com.tencent.e.c.d.gX("AppBrandVideoEventHandler_HandlerThread", 5);
        this.mHandlerThread.start();
      }
      if ((this.lpN == null) && (this.mHandlerThread != null))
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.lpN = new av(this.mHandlerThread.getLooper(), new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(139581);
            e locale;
            int i;
            int j;
            if (e.this.lyT != null)
            {
              locale = e.this;
              i = e.this.lyT.getCurrentPosition();
              j = (int)(e.this.lyY * 1000.0D);
            }
            for (;;)
            {
              try
              {
                int k = Math.abs(i - locale.lyo);
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
              if (locale.cvb != null) {
                locale.cvb.bZ(i, j);
              }
              locale.lyo = i;
              d1 = j * 1.0D / 1000.0D;
              d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
              localJSONObject = locale.boi();
              localJSONObject.put("position", d2);
              localJSONObject.put("duration", d1);
              locale.a(new e.j((byte)0), localJSONObject);
            }
          }
        }, true);
      }
      if (this.lpN != null) {
        this.lpN.az(0L, 250L);
      }
      if ((this.lxU != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(this.lxU.getAppId())))
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
        com.tencent.mm.sdk.b.a.IbL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139582);
          Object localObject1;
          if (e.this.lxU != null)
          {
            localObject1 = e.this.lxU.kjg;
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
              if ((!(localObject1 instanceof aa)) || (!(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getContext() instanceof Activity))) {
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
        ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lxU);
        if (locala == null) {
          ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        } else {
          locala.d(this.lyT);
        }
      }
    }
    ad.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if ((this.lyT == null) || (this.lxU == null))
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
      if (this.cse != null) {
        this.cse.bA(paramBoolean);
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
      a(new e((byte)0), boi());
      boj();
      bpP();
      bpQ();
      if (this.cse != null) {
        if (!paramBoolean)
        {
          this.cse.onPause();
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
      this.cse.onStop();
      AppMethodBeat.o(177221);
    }
  }
  
  public final void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(186949);
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new a((byte)0), localJSONObject);
      AppMethodBeat.o(186949);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(186949);
    }
  }
  
  final JSONObject boi()
  {
    AppMethodBeat.i(139594);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.lyp);
    AppMethodBeat.o(139594);
    return localJSONObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(139592);
    boj();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(139592);
  }
  
  public final void dz(String paramString)
  {
    this.lyp = paramString;
  }
  
  public final void gN(int paramInt)
  {
    AppMethodBeat.i(139588);
    try
    {
      JSONObject localJSONObject = boi();
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
  
  public final void gO(int paramInt)
  {
    AppMethodBeat.i(186948);
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("position", paramInt);
      a(new i((byte)0), localJSONObject);
      AppMethodBeat.o(186948);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(186948);
    }
  }
  
  public final void h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139589);
    boj();
    bpP();
    try
    {
      JSONObject localJSONObject = boi();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c((byte)0), localJSONObject);
      bpQ();
      if (this.cse != null) {
        this.cse.onError();
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
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof b)) {
      this.lxU = ((b)parama);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139586);
    try
    {
      a(new b((byte)0), boi());
      boj();
      bpP();
      bpQ();
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
      JSONObject localJSONObject = boi();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new k((byte)0), localJSONObject);
      if (this.cse != null) {
        this.cse.FW();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.e
 * JD-Core Version:    0.7.0.1
 */