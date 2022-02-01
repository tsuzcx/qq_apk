package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import com.tencent.luggage.k.a.a;
import com.tencent.luggage.k.a.a.a;
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
  public JSONObject jML;
  public int jOT;
  public m jOU;
  public c jOV;
  private f.d jOW;
  private f.b jOX;
  private f.c jOY;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.jOT = paramInt;
    this.jML = paramJSONObject;
    this.jOV = paramc;
    this.jOU = paramm;
  }
  
  public final JSONObject Ak()
  {
    return this.jML;
  }
  
  public final c CM()
  {
    return this.jOV;
  }
  
  public final boolean Ed()
  {
    return this.jOU instanceof y;
  }
  
  public final JSONObject Ee()
  {
    AppMethodBeat.i(139387);
    if (this.jML != null)
    {
      localJSONObject = this.jML;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String Ef()
  {
    AppMethodBeat.i(139388);
    if (this.jOU != null)
    {
      String str = this.jOU.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void Eg()
  {
    AppMethodBeat.i(139392);
    if ((this.jOV instanceof e))
    {
      e locale = (e)this.jOV;
      if (this.jOW != null)
      {
        locale.b(this.jOW);
        this.jOW = null;
      }
      if (this.jOX != null)
      {
        locale.b(this.jOX);
        this.jOX = null;
      }
      if (this.jOY != null)
      {
        locale.b(this.jOY);
        this.jOY = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.jOV instanceof e))
    {
      e locale = (e)this.jOV;
      this.jOW = new f.d()
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
      this.jOX = new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          if (parama != null) {
            parama.gz(com.tencent.mm.plugin.appbrand.jsapi.z.b.NY(b.this.jOV.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.jOY = new f.c()
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
      locale.a(this.jOW);
      locale.a(this.jOX);
      locale.a(this.jOY);
    }
    AppMethodBeat.o(139391);
  }
  
  public final void b(a.a parama) {}
  
  public final int bcR()
  {
    return this.jOT;
  }
  
  public final m bcS()
  {
    return this.jOU;
  }
  
  public final String cs(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.jOV != null) && (this.jOU != null)) {
      this.jOV.h(this.jOT, this.jOU.e(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String d(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.jOV != null) && (this.jOU != null)) {
      this.jOV.h(this.jOT, this.jOU.k(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.jOV != null)
    {
      String str = this.jOV.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.jOV != null)
    {
      Context localContext = this.jOV.getContext();
      AppMethodBeat.o(139386);
      return localContext;
    }
    AppMethodBeat.o(139386);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.b
 * JD-Core Version:    0.7.0.1
 */