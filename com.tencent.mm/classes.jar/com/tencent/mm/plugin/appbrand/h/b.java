package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements a
{
  public JSONObject lnV;
  public int lqe;
  public p lqf;
  public f lqg;
  private i.d lqh;
  private i.b lqi;
  private i.c lqj;
  
  public b(int paramInt, JSONObject paramJSONObject, f paramf, p paramp)
  {
    this.lqe = paramInt;
    this.lnV = paramJSONObject;
    this.lqg = paramf;
    this.lqf = paramp;
  }
  
  public final JSONObject KX()
  {
    return this.lnV;
  }
  
  public final f NN()
  {
    return this.lqg;
  }
  
  public final boolean Pr()
  {
    return this.lqf instanceof ab;
  }
  
  public final JSONObject Ps()
  {
    AppMethodBeat.i(139387);
    if (this.lnV != null)
    {
      localJSONObject = this.lnV;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String Pt()
  {
    AppMethodBeat.i(139388);
    if (this.lqf != null)
    {
      String str = this.lqf.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(139392);
    if ((this.lqg instanceof h))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
      h localh = (h)this.lqg;
      if (this.lqh != null)
      {
        localh.b(this.lqh);
        this.lqh = null;
      }
      if (this.lqi != null)
      {
        localh.b(this.lqi);
        this.lqi = null;
      }
      if (this.lqj != null)
      {
        localh.b(this.lqj);
        this.lqj = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.lqg instanceof h))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
      h localh = (h)this.lqg;
      this.lqh = new i.d()
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
      this.lqi = new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onBackground");
          if (parama != null) {
            parama.hU(com.tencent.mm.plugin.appbrand.jsapi.ag.b.abL(b.this.lqg.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.lqj = new i.c()
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
      localh.a(this.lqh);
      localh.a(this.lqi);
      localh.a(this.lqj);
    }
    AppMethodBeat.o(139391);
  }
  
  public final void b(a.a parama) {}
  
  public final int bCw()
  {
    return this.lqe;
  }
  
  public final p bCx()
  {
    return this.lqf;
  }
  
  public final String dP(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.lqg != null) && (this.lqf != null)) {
      this.lqg.i(this.lqe, this.lqf.h(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String f(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.lqg != null) && (this.lqf != null)) {
      this.lqg.i(this.lqe, this.lqf.n(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.lqg != null)
    {
      String str = this.lqg.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.lqg != null)
    {
      Context localContext = this.lqg.getContext();
      AppMethodBeat.o(139386);
      return localContext;
    }
    AppMethodBeat.o(139386);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b
 * JD-Core Version:    0.7.0.1
 */