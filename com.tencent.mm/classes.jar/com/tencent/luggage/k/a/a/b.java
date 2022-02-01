package com.tencent.luggage.k.a.a;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.h.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.pip.f.4;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private f b(aa paramaa)
  {
    paramaa = paramaa.getRuntime();
    if (paramaa == null)
    {
      ac.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramaa = paramaa.jdT;
    if (paramaa == null)
    {
      ac.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramaa;
  }
  
  public static aa e(com.tencent.luggage.k.a.a parama)
  {
    parama = parama.CM();
    if (!(parama instanceof aa))
    {
      ac.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof q))
      {
        ac.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((q)parama).getCurrentPageView();
    }
    return (aa)parama;
  }
  
  protected abstract PipInfoProvider Eh();
  
  public final void a(com.tencent.luggage.k.a.a parama, String paramString)
  {
    ac.i(getLogTag(), "handlePipInfo");
    Object localObject1 = e(parama);
    if (localObject1 == null) {
      ac.w(getLogTag(), "handlePipInfo, null == pageView");
    }
    Object localObject4;
    Object localObject3;
    int i;
    g localg;
    h.a locala;
    do
    {
      return;
      localObject4 = ((aa)localObject1).lCC;
      if (localObject4 == null)
      {
        ac.w(getLogTag(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((aa)localObject1);
      if (localObject2 == null)
      {
        ac.w(getLogTag(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.pip.a)((f)localObject2).lNJ.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((aa)localObject1);
        if (((f)localObject2).lNR == null) {
          ((f)localObject2).lNR = new f.4((f)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).lbd = ((f)localObject2).lNR;
        ac.i(((f)localObject2).cgL, "createPageScopedPipInfoIfNeed for " + f.r(((aa)localObject1).lCC));
        ((f)localObject2).lNJ.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.Ee();
      if (parama == null)
      {
        ac.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = Eh();
      parama = ((c)localObject3).ct(parama.toString());
      if (parama == null)
      {
        ac.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((f)localObject2).jgY.mAppId, ((r)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).Eu();
      locala = ((c)localObject3).Ev();
      localObject3 = ((c)localObject3).Ew();
      localObject1 = ((f)localObject2).t((aa)localObject1);
    } while (localObject1 == null);
    ac.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cgL, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).lMt.get(localObject4);
    if (localObject2 == null)
    {
      ac.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cgL, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).lMt.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.n.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).lbd));
      return;
    }
    ac.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cgL, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).lMB = paramString;
  }
  
  public final void b(com.tencent.luggage.k.a.a parama)
  {
    ac.i(getLogTag(), "removePipId");
    Object localObject = e(parama);
    if (localObject == null) {}
    do
    {
      f localf;
      do
      {
        return;
        localf = b((aa)localObject);
      } while (localf == null);
      parama = getKey();
      localObject = localf.t((aa)localObject);
    } while (localObject == null);
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).Qw(parama);
  }
  
  public final boolean c(com.tencent.luggage.k.a.a parama)
  {
    ac.i(getLogTag(), "exitPip");
    parama = e(parama);
    if (parama == null) {}
    do
    {
      return false;
      parama = b(parama);
    } while (parama == null);
    return parama.uu(getId());
  }
  
  public final boolean d(com.tencent.luggage.k.a.a parama)
  {
    ac.i(getLogTag(), "amIPipPlayer");
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
    return Objects.equals(parama.lNN, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */