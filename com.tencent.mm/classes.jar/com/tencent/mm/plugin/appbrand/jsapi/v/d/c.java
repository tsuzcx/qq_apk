package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c
{
  private ap idS;
  com.tencent.mm.plugin.appbrand.f.b iiC;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.a iiQ;
  double iiR;
  int iiS;
  private String iiT;
  private HandlerThread mHandlerThread;
  
  public c()
  {
    AppMethodBeat.i(140077);
    this.mHandlerThread = new HandlerThread("AppBrandVideoEventHandler_HandlerThread");
    this.mHandlerThread.start();
    AppMethodBeat.o(140077);
  }
  
  private void aFE()
  {
    AppMethodBeat.i(117383);
    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.idS != null) {
      this.idS.stopTimer();
    }
    AppMethodBeat.o(117383);
  }
  
  private void aGw()
  {
    AppMethodBeat.i(117386);
    al.d(new c.3(this));
    AppMethodBeat.o(117386);
  }
  
  public final void B(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(117381);
    try
    {
      JSONObject localJSONObject = aFD();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      this.iiR = (paramInt3 * 1.0D / 1000.0D);
      localJSONObject.put("duration", this.iiR);
      a(new c.c((byte)0), localJSONObject);
      AppMethodBeat.o(117381);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(117381);
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.a parama)
  {
    this.iiQ = parama;
  }
  
  final void a(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117385);
    if ((!(paramai instanceof g)) && (!(paramai instanceof f))) {
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramai.getName(), paramJSONObject.toString() });
    }
    paramai = paramai.BN(paramJSONObject.toString());
    if (this.iiC != null)
    {
      paramJSONObject = this.iiC.hrA;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof r))
        {
          paramJSONObject = (r)paramJSONObject;
          paramJSONObject.b(paramai);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramai);
          }
          AppMethodBeat.o(117385);
          return;
        }
        if ((paramJSONObject instanceof v))
        {
          paramJSONObject = (v)paramJSONObject;
          paramJSONObject.b(paramai);
          paramJSONObject = paramJSONObject.ws();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramai);
          }
          AppMethodBeat.o(117385);
          return;
        }
        paramJSONObject.b(paramai);
      }
    }
    AppMethodBeat.o(117385);
  }
  
  final JSONObject aFD()
  {
    AppMethodBeat.i(117384);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.iiT);
    AppMethodBeat.o(117384);
    return localJSONObject;
  }
  
  public final void co(String paramString)
  {
    this.iiT = paramString;
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.f.b)) {
      this.iiC = ((com.tencent.mm.plugin.appbrand.f.b)parama);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(117382);
    aFE();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(117382);
  }
  
  public final void f(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117380);
    aFE();
    aGw();
    try
    {
      JSONObject localJSONObject = aFD();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new c.b((byte)0), localJSONObject);
      AppMethodBeat.o(117380);
      return;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
      AppMethodBeat.o(117380);
    }
  }
  
  public final void fD(int paramInt)
  {
    AppMethodBeat.i(117379);
    try
    {
      JSONObject localJSONObject = aFD();
      localJSONObject.put("buffered", paramInt);
      a(new f((byte)0), localJSONObject);
      AppMethodBeat.o(117379);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(117379);
    }
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(117376);
    try
    {
      a(new c.d((byte)0), aFD());
      aFE();
      aGw();
      AppMethodBeat.o(117376);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(117375);
    try
    {
      this.iiS = 0;
      JSONObject localJSONObject = aFD();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new c.e((byte)0), localJSONObject);
      ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.idS == null)
      {
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.idS = new ap(this.mHandlerThread.getLooper(), new ap.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(117372);
            c localc;
            Object localObject;
            int i;
            int j;
            if (c.this.iiQ != null)
            {
              localc = c.this;
              localObject = c.this.iiQ;
              if (((com.tencent.luggage.xweb_ext.extendplugin.component.video.a)localObject).bHu == null) {
                break label92;
              }
              i = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.a)localObject).bHu.getCurrentPosition();
              j = (int)(c.this.iiR * 1000.0D);
            }
            for (;;)
            {
              try
              {
                int k = Math.abs(i - localc.iiS);
                if (k >= 250) {
                  continue;
                }
              }
              catch (JSONException localJSONException)
              {
                label92:
                double d1;
                double d2;
                ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
                continue;
              }
              AppMethodBeat.o(117372);
              return true;
              i = 0;
              break;
              localc.iiS = i;
              d1 = j * 1.0D / 1000.0D;
              d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
              localObject = localc.aFD();
              ((JSONObject)localObject).put("position", d2);
              ((JSONObject)localObject).put("duration", d1);
              localc.a(new c.g((byte)0), (JSONObject)localObject);
            }
          }
        }, true);
      }
      this.idS.ag(250L, 250L);
      al.d(new c.2(this));
      if ((this.iiC != null) && (bo.isEqual(this.iiC.getAppId(), "wxfe02ecfe70800f46"))) {
        com.tencent.mm.sdk.b.a.ymk.l(new d());
      }
      AppMethodBeat.o(117375);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(117375);
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(117378);
    try
    {
      JSONObject localJSONObject = aFD();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new h((byte)0), localJSONObject);
      AppMethodBeat.o(117378);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(117378);
    }
  }
  
  public final void xT()
  {
    AppMethodBeat.i(117377);
    try
    {
      a(new c.a((byte)0), aFD());
      aFE();
      aGw();
      AppMethodBeat.o(117377);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  static final class f
    extends ai
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
  }
  
  static final class g
    extends ai
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
  
  static final class h
    extends ai
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.c
 * JD-Core Version:    0.7.0.1
 */