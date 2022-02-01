package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.pip.f.4;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private f b(z paramz)
  {
    paramz = paramz.getRuntime();
    if (paramz == null)
    {
      ae.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramz = paramz.jzZ;
    if (paramz == null)
    {
      ae.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramz;
  }
  
  public static z e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    parama = parama.Eo();
    if (!(parama instanceof z))
    {
      ae.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof r))
      {
        ae.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((r)parama).getCurrentPageView();
    }
    return (z)parama;
  }
  
  protected abstract PipInfoProvider FN();
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    ae.i(getLogTag(), "handlePipInfo");
    Object localObject1 = e(parama);
    if (localObject1 == null) {
      ae.w(getLogTag(), "handlePipInfo, null == pageView");
    }
    Object localObject4;
    Object localObject3;
    int i;
    g localg;
    h.a locala;
    do
    {
      return;
      localObject4 = ((z)localObject1).mgv;
      if (localObject4 == null)
      {
        ae.w(getLogTag(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((z)localObject1);
      if (localObject2 == null)
      {
        ae.w(getLogTag(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.pip.a)((f)localObject2).msu.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((z)localObject1);
        if (((f)localObject2).msC == null) {
          ((f)localObject2).msC = new f.4((f)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).lCC = ((f)localObject2).msC;
        ae.i(((f)localObject2).crG, "createPageScopedPipInfoIfNeed for " + f.r(((z)localObject1).mgv));
        ((f)localObject2).msu.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.FJ();
      if (parama == null)
      {
        ae.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = FN();
      parama = ((c)localObject3).dx(parama.toString());
      if (parama == null)
      {
        ae.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((f)localObject2).jDb.mAppId, ((q)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).FZ();
      locala = ((c)localObject3).Ga();
      localObject3 = ((c)localObject3).Gb();
      localObject1 = ((f)localObject2).u((z)localObject1);
    } while (localObject1 == null);
    ae.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crG, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).mre.get(localObject4);
    if (localObject2 == null)
    {
      ae.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crG, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).mre.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.q.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).lCC));
      return;
    }
    ae.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crG, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).mrm = paramString;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ae.i(getLogTag(), "removePipId");
    Object localObject = e(parama);
    if (localObject == null) {}
    do
    {
      f localf;
      do
      {
        return;
        localf = b((z)localObject);
      } while (localf == null);
      parama = getKey();
      localObject = localf.u((z)localObject);
    } while (localObject == null);
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).UL(parama);
  }
  
  public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ae.i(getLogTag(), "exitPip");
    parama = e(parama);
    if (parama == null) {}
    do
    {
      return false;
      parama = b(parama);
    } while (parama == null);
    return parama.vd(getId());
  }
  
  public final boolean d(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ae.i(getLogTag(), "amIPipPlayer");
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
    return Objects.equals(parama.msy, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.b
 * JD-Core Version:    0.7.0.1
 */