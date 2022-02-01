package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.al.d;
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
  public JSONObject rmi;
  public int ror;
  public p ros;
  public f rot;
  private i.d rou;
  private i.b rov;
  private i.c rox;
  
  public b(int paramInt, JSONObject paramJSONObject, f paramf, p paramp)
  {
    this.ror = paramInt;
    this.rmi = paramJSONObject;
    this.rot = paramf;
    this.ros = paramp;
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(139391);
    if ((this.rot instanceof h))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
      h localh = (h)this.rot;
      this.rou = new i.d()
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
      this.rov = new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139383);
          Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onBackground");
          if (parama != null) {
            parama.my(com.tencent.mm.plugin.appbrand.jsapi.al.b.acG(b.this.rot.getAppId()));
          }
          AppMethodBeat.o(139383);
        }
      };
      this.rox = new i.c()
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
      localh.a(this.rou);
      localh.a(this.rov);
      localh.a(this.rox);
    }
    AppMethodBeat.o(139391);
  }
  
  public final f aqX()
  {
    return this.rot;
  }
  
  public final boolean atv()
  {
    return this.ros instanceof ab;
  }
  
  public final JSONObject atw()
  {
    AppMethodBeat.i(139387);
    if (this.rmi != null)
    {
      localJSONObject = this.rmi;
      AppMethodBeat.o(139387);
      return localJSONObject;
    }
    JSONObject localJSONObject = new JSONObject();
    AppMethodBeat.o(139387);
    return localJSONObject;
  }
  
  public final String atx()
  {
    AppMethodBeat.i(139388);
    if (this.ros != null)
    {
      String str = this.ros.getName();
      AppMethodBeat.o(139388);
      return str;
    }
    AppMethodBeat.o(139388);
    return null;
  }
  
  public final void aty()
  {
    AppMethodBeat.i(139392);
    if ((this.rot instanceof h))
    {
      Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
      h localh = (h)this.rot;
      if (this.rou != null)
      {
        localh.b(this.rou);
        this.rou = null;
      }
      if (this.rov != null)
      {
        localh.b(this.rov);
        this.rov = null;
      }
      if (this.rox != null)
      {
        localh.b(this.rox);
        this.rox = null;
      }
    }
    AppMethodBeat.o(139392);
  }
  
  public final boolean atz()
  {
    return this.ros instanceof d;
  }
  
  public final void b(a.a parama) {}
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(139390);
    if ((this.rot != null) && (this.ros != null)) {
      this.rot.callback(this.ror, this.ros.m(paramString, paramMap));
    }
    AppMethodBeat.o(139390);
    return null;
  }
  
  public final String fO(String paramString)
  {
    AppMethodBeat.i(139389);
    if ((this.rot != null) && (this.ros != null)) {
      this.rot.callback(this.ror, this.ros.ZP(paramString));
    }
    AppMethodBeat.o(139389);
    return null;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(139385);
    if (this.rot != null)
    {
      String str = this.rot.getAppId();
      AppMethodBeat.o(139385);
      return str;
    }
    AppMethodBeat.o(139385);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(139386);
    if (this.rot != null)
    {
      Context localContext = this.rot.getContext();
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