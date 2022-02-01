package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.pip.f.4;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private f b(ac paramac)
  {
    paramac = paramac.getRuntime();
    if (paramac == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramac = paramac.kAQ;
    if (paramac == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramac;
  }
  
  public static ac e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    parama = parama.NN();
    if (!(parama instanceof ac))
    {
      Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof s))
      {
        Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((s)parama).getCurrentPageView();
    }
    return (ac)parama;
  }
  
  protected abstract PipInfoProvider Pw();
  
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
    g localg;
    h.a locala;
    do
    {
      return;
      localObject4 = ((ac)localObject1).nqU;
      if (localObject4 == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((ac)localObject1);
      if (localObject2 == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.pip.a)((f)localObject2).nDe.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((ac)localObject1);
        if (((f)localObject2).nDm == null) {
          ((f)localObject2).nDm = new f.4((f)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).mKh = ((f)localObject2).nDm;
        Log.i(((f)localObject2).cDW, "createPageScopedPipInfoIfNeed for " + f.s(((ac)localObject1).nqU));
        ((f)localObject2).nDe.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.Ps();
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = Pw();
      parama = ((c)localObject3).dQ(parama.toString());
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((f)localObject2).kEc.mAppId, ((t)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).PI();
      locala = ((c)localObject3).PJ();
      localObject3 = ((c)localObject3).PK();
      localObject1 = ((f)localObject2).z((ac)localObject1);
    } while (localObject1 == null);
    Log.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cDW, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).nBP.get(localObject4);
    if (localObject2 == null)
    {
      Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cDW, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).nBP.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.s.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).mKh));
      return;
    }
    Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cDW, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).nBX = paramString;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    Log.i(getLogTag(), "removePipId");
    Object localObject = e(parama);
    if (localObject == null) {}
    do
    {
      f localf;
      do
      {
        return;
        localf = b((ac)localObject);
      } while (localf == null);
      parama = getKey();
      localObject = localf.z((ac)localObject);
    } while (localObject == null);
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).aez(parama);
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
    return parama.yV(getId());
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
    return Objects.equals(parama.nDi, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.b
 * JD-Core Version:    0.7.0.1
 */