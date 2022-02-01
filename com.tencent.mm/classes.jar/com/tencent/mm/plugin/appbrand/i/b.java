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
  public JSONObject jmy;
  public int joH;
  public m joI;
  public c joJ;
  private f.d joK;
  private f.b joL;
  private f.c joM;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.joH = paramInt;
    this.jmy = paramJSONObject;
    this.joJ = paramc;
    this.joI = paramm;
  }
  
  public final JSONObject AG()
  {
    return this.jmy;
  }
  
  public final c Dj()
  {
    return this.joJ;
  }
  
  public final boolean EA()
  {
    return this.joI instanceof y;
  }
  
  public final JSONObject EB()
  {
    AppMethodBeat.i(139387);
    if (this.jmy != null)
    {
      localJSONObject = this.jmy;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String EC()
  {
    AppMethodBeat.i(139388);
    if (this.joI != null)
    {
      String str = this.joI.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void ED()
  {
    AppMethodBeat.i(139392);
    if ((this.joJ instanceof e))
    {
      e locale = (e)this.joJ;
      if (this.joK != null)
      {
        locale.b(this.joK);
        this.joK = null;
      }
      if (this.joL != null)
      {
        locale.b(this.joL);
        this.joL = null;
      }
      if (this.joM != null)
      {
        locale.b(this.joM);
        this.joM = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.joJ instanceof e))
    {
      e locale = (e)this.joJ;
      this.joK = new f.d()
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
      this.joL = new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          if (parama != null) {
            parama.gP(com.tencent.mm.plugin.appbrand.jsapi.aa.b.JR(b.this.joJ.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.joM = new f.c()
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
      locale.a(this.joK);
      locale.a(this.joL);
      locale.a(this.joM);
    }
    AppMethodBeat.o(139391);
  }
  
  public final int aVT()
  {
    return this.joH;
  }
  
  public final m aVU()
  {
    return this.joI;
  }
  
  public final void b(a.a parama) {}
  
  public final String cD(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.joJ != null) && (this.joI != null)) {
      this.joJ.h(this.joH, this.joI.e(paramString, null));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String d(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.joJ != null) && (this.joI != null)) {
      this.joJ.h(this.joH, this.joI.k(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.joJ != null)
    {
      String str = this.joJ.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.joJ != null)
    {
      Context localContext = this.joJ.getContext();
      AppMethodBeat.o(139386);
      return localContext;
    }
    AppMethodBeat.o(139386);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.b
 * JD-Core Version:    0.7.0.1
 */