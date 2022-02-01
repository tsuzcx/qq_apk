package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements a
{
  public JSONObject kkm;
  public int kmu;
  public m kmv;
  public c kmw;
  private f.d kmx;
  private f.b kmy;
  private f.c kmz;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.kmu = paramInt;
    this.kkm = paramJSONObject;
    this.kmw = paramc;
    this.kmv = paramm;
  }
  
  public final JSONObject BI()
  {
    return this.kkm;
  }
  
  public final c Eo()
  {
    return this.kmw;
  }
  
  public final boolean FI()
  {
    return this.kmv instanceof y;
  }
  
  public final JSONObject FJ()
  {
    AppMethodBeat.i(139387);
    if (this.kkm != null)
    {
      localJSONObject = this.kkm;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String FK()
  {
    AppMethodBeat.i(139388);
    if (this.kmv != null)
    {
      String str = this.kmv.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void FL()
  {
    AppMethodBeat.i(139392);
    if ((this.kmw instanceof e))
    {
      ae.i("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
      e locale = (e)this.kmw;
      if (this.kmx != null)
      {
        locale.b(this.kmx);
        this.kmx = null;
      }
      if (this.kmy != null)
      {
        locale.b(this.kmy);
        this.kmy = null;
      }
      if (this.kmz != null)
      {
        locale.b(this.kmz);
        this.kmz = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.kmw instanceof e))
    {
      ae.i("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
      e locale = (e)this.kmw;
      this.kmx = new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139382);
          ae.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onForeground");
          if (parama != null) {
            parama.onForeground();
          }
          AppMethodBeat.o(139382);
        }
      };
      this.kmy = new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          ae.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onBackground");
          if (parama != null) {
            parama.gF(com.tencent.mm.plugin.appbrand.jsapi.ad.b.Sg(b.this.kmw.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.kmz = new f.c()
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
      locale.a(this.kmx);
      locale.a(this.kmy);
      locale.a(this.kmz);
    }
    AppMethodBeat.o(139391);
  }
  
  public final void b(a.a parama) {}
  
  public final int bhd()
  {
    return this.kmu;
  }
  
  public final m bhe()
  {
    return this.kmv;
  }
  
  public final String dw(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.kmw != null) && (this.kmv != null)) {
      this.kmw.h(this.kmu, this.kmv.e(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String f(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.kmw != null) && (this.kmv != null)) {
      this.kmw.h(this.kmu, this.kmv.n(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.kmw != null)
    {
      String str = this.kmw.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.kmw != null)
    {
      Context localContext = this.kmw.getContext();
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