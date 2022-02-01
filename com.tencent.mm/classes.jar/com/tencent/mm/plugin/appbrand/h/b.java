package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.ai.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements a
{
  public JSONObject oiG;
  public int okO;
  public o okP;
  public e okQ;
  private h.d okR;
  private h.b okS;
  private h.c okT;
  
  public b(int paramInt, JSONObject paramJSONObject, e parame, o paramo)
  {
    this.okO = paramInt;
    this.oiG = paramJSONObject;
    this.okQ = parame;
    this.okP = paramo;
  }
  
  public final JSONObject NN()
  {
    return this.oiG;
  }
  
  public final e QK()
  {
    return this.okQ;
  }
  
  public final boolean SQ()
  {
    return this.okP instanceof aa;
  }
  
  public final JSONObject SR()
  {
    AppMethodBeat.i(139387);
    if (this.oiG != null)
    {
      localJSONObject = this.oiG;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String SS()
  {
    AppMethodBeat.i(139388);
    if (this.okP != null)
    {
      String str = this.okP.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void ST()
  {
    AppMethodBeat.i(139392);
    if ((this.okQ instanceof g))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
      g localg = (g)this.okQ;
      if (this.okR != null)
      {
        localg.b(this.okR);
        this.okR = null;
      }
      if (this.okS != null)
      {
        localg.b(this.okS);
        this.okS = null;
      }
      if (this.okT != null)
      {
        localg.b(this.okT);
        this.okT = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final boolean SU()
  {
    return this.okP instanceof d;
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.okQ instanceof g))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
      g localg = (g)this.okQ;
      this.okR = new h.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139382);
          Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onForeground");
          if (parama != null) {
            parama.onForeground();
          }
          AppMethodBeat.o(139382);
        }
      };
      this.okS = new h.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onBackground");
          if (parama != null) {
            parama.iW(com.tencent.mm.plugin.appbrand.jsapi.ai.b.ajG(b.this.okQ.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.okT = new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(139384);
          if (parama != null) {
            parama.onDestroy();
          }
          AppMethodBeat.o(139384);
        }
      };
      localg.a(this.okR);
      localg.a(this.okS);
      localg.a(this.okT);
    }
    AppMethodBeat.o(139391);
  }
  
  public final void b(a.a parama) {}
  
  public final int bNR()
  {
    return this.okO;
  }
  
  public final o bNS()
  {
    return this.okP;
  }
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.okQ != null) && (this.okP != null)) {
      this.okQ.j(this.okO, this.okP.m(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String er(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.okQ != null) && (this.okP != null)) {
      this.okQ.j(this.okO, this.okP.h(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.okQ != null)
    {
      String str = this.okQ.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.okQ != null)
    {
      Context localContext = this.okQ.getContext();
      AppMethodBeat.o(139386);
      return localContext;
    }
    AppMethodBeat.o(139386);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b
 * JD-Core Version:    0.7.0.1
 */