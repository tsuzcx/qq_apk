package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.g.4;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private com.tencent.mm.plugin.appbrand.pip.g b(ad paramad)
  {
    paramad = paramad.getRuntime();
    if (paramad == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramad = paramad.qsM;
    if (paramad == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramad;
  }
  
  public static ad e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    parama = parama.aqX();
    if (!(parama instanceof ad))
    {
      Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof y))
      {
        Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((y)parama).getCurrentPageView();
    }
    return (ad)parama;
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    Log.i(getLogTag(), "handlePipInfo");
    Object localObject1 = e(parama);
    if (localObject1 == null) {
      Log.w(getLogTag(), "handlePipInfo, null == pageView");
    }
    Object localObject4;
    Object localObject3;
    int i;
    com.tencent.mm.plugin.appbrand.jsapi.w.g localg;
    h.a locala;
    do
    {
      return;
      localObject4 = ((ad)localObject1).txk;
      if (localObject4 == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((ad)localObject1);
      if (localObject2 == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.pip.a)((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKf.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((ad)localObject1);
        if (((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKn == null) {
          ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKn = new g.4((com.tencent.mm.plugin.appbrand.pip.g)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).sPS = ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKn;
        Log.i(((com.tencent.mm.plugin.appbrand.pip.g)localObject2).exO, "createPageScopedPipInfoIfNeed for " + com.tencent.mm.plugin.appbrand.pip.g.u(((ad)localObject1).txk));
        ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKf.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.atw();
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = atB();
      parama = ((c)localObject3).fP(parama.toString());
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((com.tencent.mm.plugin.appbrand.pip.g)localObject2).qwG.mAppId, ((u)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).atM();
      locala = ((c)localObject3).atN();
      localObject3 = ((c)localObject3).atO();
      localObject1 = ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).A((ad)localObject1);
    } while (localObject1 == null);
    Log.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).exO, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).tIP.get(localObject4);
    if (localObject2 == null)
    {
      Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).exO, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).tIP.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.w.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).sPS));
      return;
    }
    Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).exO, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).tIX = paramString;
  }
  
  protected abstract PipInfoProvider atB();
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    Log.i(getLogTag(), "removePipId");
    Object localObject = e(parama);
    if (localObject == null) {}
    do
    {
      com.tencent.mm.plugin.appbrand.pip.g localg;
      do
      {
        return;
        localg = b((ad)localObject);
      } while (localg == null);
      parama = getKey();
      localObject = localg.A((ad)localObject);
    } while (localObject == null);
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).afG(parama);
  }
  
  public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    Log.i(getLogTag(), "exitPip");
    parama = e(parama);
    if (parama == null) {}
    do
    {
      return false;
      parama = b(parama);
    } while (parama == null);
    return parama.CR(getId());
  }
  
  public final boolean d(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    Log.i(getLogTag(), "amIPipPlayer");
    if (parama == null) {}
    do
    {
      do
      {
        return false;
        parama = e(parama);
      } while (parama == null);
      parama = b(parama);
    } while (parama == null);
    String str = getKey();
    return Objects.equals(parama.tKj, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.b
 * JD-Core Version:    0.7.0.1
 */