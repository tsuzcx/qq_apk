package com.tencent.mm.plugin.appbrand.f;

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
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements a
{
  public JSONObject hpr;
  public c hrA;
  private f.d hrB;
  private f.b hrC;
  private f.c hrD;
  public int hry;
  public m hrz;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.hry = paramInt;
    this.hpr = paramJSONObject;
    this.hrA = paramc;
    this.hrz = paramm;
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(140021);
    if ((this.hrA instanceof e))
    {
      e locale = (e)this.hrA;
      this.hrB = new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(140011);
          if (parama != null) {
            parama.onForeground();
          }
          AppMethodBeat.o(140011);
        }
      };
      this.hrC = new b.2(this, parama);
      this.hrD = new b.3(this, parama);
      locale.a(this.hrB);
      locale.a(this.hrC);
      locale.a(this.hrD);
    }
    AppMethodBeat.o(140021);
  }
  
  public final String ck(String paramString)
  {
    AppMethodBeat.i(140018);
    if ((this.hrA != null) && (this.hrz != null)) {
      this.hrA.h(this.hry, this.hrz.j(paramString, null));
    }
    AppMethodBeat.o(140018);
    return null;
  }
  
  public final String d(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(140019);
    if ((this.hrA != null) && (this.hrz != null)) {
      this.hrA.h(this.hry, this.hrz.j(paramString, paramMap));
    }
    AppMethodBeat.o(140019);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(140014);
    if (this.hrA != null)
    {
      String str = this.hrA.getAppId();
      AppMethodBeat.o(140014);
      return str;
    }
    AppMethodBeat.o(140014);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(140015);
    if (this.hrA != null)
    {
      Context localContext = this.hrA.getContext();
      AppMethodBeat.o(140015);
      return localContext;
    }
    AppMethodBeat.o(140015);
    return null;
  }
  
  public final boolean xj()
  {
    return this.hrz instanceof u;
  }
  
  public final JSONObject xk()
  {
    AppMethodBeat.i(140016);
    if (this.hpr != null)
    {
      localJSONObject = this.hpr;
      AppMethodBeat.o(140016);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(140016);
    return localJSONObject;
  }
  
  public final String xl()
  {
    AppMethodBeat.i(140017);
    if (this.hrz != null)
    {
      String str = this.hrz.getName();
      AppMethodBeat.o(140017);
      return str;
    }
    AppMethodBeat.o(140017);
    return null;
  }
  
  public final void xm()
  {
    AppMethodBeat.i(140022);
    if ((this.hrA instanceof e))
    {
      e locale = (e)this.hrA;
      if (this.hrB != null)
      {
        locale.b(this.hrB);
        this.hrB = null;
      }
      if (this.hrC != null)
      {
        locale.b(this.hrC);
        this.hrC = null;
      }
      if (this.hrD != null)
      {
        locale.b(this.hrD);
        this.hrD = null;
      }
    }
    AppMethodBeat.o(140022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.b
 * JD-Core Version:    0.7.0.1
 */