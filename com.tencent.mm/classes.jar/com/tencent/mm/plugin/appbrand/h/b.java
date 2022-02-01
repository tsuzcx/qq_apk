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
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements a
{
  public JSONObject kgW;
  public int kje;
  public m kjf;
  public c kjg;
  private f.d kjh;
  private f.b kji;
  private f.c kjj;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.kje = paramInt;
    this.kgW = paramJSONObject;
    this.kjg = paramc;
    this.kjf = paramm;
  }
  
  public final JSONObject BH()
  {
    return this.kgW;
  }
  
  public final c El()
  {
    return this.kjg;
  }
  
  public final boolean FC()
  {
    return this.kjf instanceof y;
  }
  
  public final JSONObject FD()
  {
    AppMethodBeat.i(139387);
    if (this.kgW != null)
    {
      localJSONObject = this.kgW;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String FE()
  {
    AppMethodBeat.i(139388);
    if (this.kjf != null)
    {
      String str = this.kjf.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void FF()
  {
    AppMethodBeat.i(139392);
    if ((this.kjg instanceof e))
    {
      e locale = (e)this.kjg;
      if (this.kjh != null)
      {
        locale.b(this.kjh);
        this.kjh = null;
      }
      if (this.kji != null)
      {
        locale.b(this.kji);
        this.kji = null;
      }
      if (this.kjj != null)
      {
        locale.b(this.kjj);
        this.kjj = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.kjg instanceof e))
    {
      e locale = (e)this.kjg;
      this.kjh = new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139382);
          if (parama != null) {
            parama.onForeground();
          }
          AppMethodBeat.o(139382);
        }
      };
      this.kji = new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          if (parama != null) {
            parama.gE(com.tencent.mm.plugin.appbrand.jsapi.ac.b.Rx(b.this.kjg.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.kjj = new f.c()
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
      locale.a(this.kjh);
      locale.a(this.kji);
      locale.a(this.kjj);
    }
    AppMethodBeat.o(139391);
  }
  
  public final void b(a.a parama) {}
  
  public final int bgv()
  {
    return this.kje;
  }
  
  public final m bgw()
  {
    return this.kjf;
  }
  
  public final String du(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.kjg != null) && (this.kjf != null)) {
      this.kjg.h(this.kje, this.kjf.e(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.kjg != null) && (this.kjf != null)) {
      this.kjg.h(this.kje, this.kjf.m(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.kjg != null)
    {
      String str = this.kjg.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.kjg != null)
    {
      Context localContext = this.kjg.getContext();
      AppMethodBeat.o(139386);
      return localContext;
    }
    AppMethodBeat.o(139386);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b
 * JD-Core Version:    0.7.0.1
 */