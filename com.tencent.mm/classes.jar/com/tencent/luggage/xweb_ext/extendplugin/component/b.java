package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.pip.f.4;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
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
      ad.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramaa = paramaa.jxb;
    if (paramaa == null)
    {
      ad.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramaa;
  }
  
  public static aa e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    parama = parama.El();
    if (!(parama instanceof aa))
    {
      ad.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof q))
      {
        ad.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((q)parama).getCurrentPageView();
    }
    return (aa)parama;
  }
  
  protected abstract PipInfoProvider FH();
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    ad.i(getLogTag(), "handlePipInfo");
    Object localObject1 = e(parama);
    if (localObject1 == null) {
      ad.w(getLogTag(), "handlePipInfo, null == pageView");
    }
    Object localObject4;
    Object localObject3;
    int i;
    g localg;
    h.a locala;
    do
    {
      return;
      localObject4 = ((aa)localObject1).mcd;
      if (localObject4 == null)
      {
        ad.w(getLogTag(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((aa)localObject1);
      if (localObject2 == null)
      {
        ad.w(getLogTag(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((com.tencent.mm.plugin.appbrand.pip.a)((f)localObject2).mnw.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((aa)localObject1);
        if (((f)localObject2).mnE == null) {
          ((f)localObject2).mnE = new f.4((f)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).lye = ((f)localObject2).mnE;
        ad.i(((f)localObject2).crd, "createPageScopedPipInfoIfNeed for " + f.r(((aa)localObject1).mcd));
        ((f)localObject2).mnw.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.FD();
      if (parama == null)
      {
        ad.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = FH();
      parama = ((c)localObject3).dv(parama.toString());
      if (parama == null)
      {
        ad.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((f)localObject2).jzY.mAppId, ((r)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).FT();
      locala = ((c)localObject3).FU();
      localObject3 = ((c)localObject3).FV();
      localObject1 = ((f)localObject2).t((aa)localObject1);
    } while (localObject1 == null);
    ad.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crd, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).mmh.get(localObject4);
    if (localObject2 == null)
    {
      ad.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crd, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).mmh.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.q.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).lye));
      return;
    }
    ad.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).crd, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).mmp = paramString;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ad.i(getLogTag(), "removePipId");
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
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).Ub(parama);
  }
  
  public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ad.i(getLogTag(), "exitPip");
    parama = e(parama);
    if (parama == null) {}
    do
    {
      return false;
      parama = b(parama);
    } while (parama == null);
    return parama.uY(getId());
  }
  
  public final boolean d(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    ad.i(getLogTag(), "amIPipPlayer");
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
    return Objects.equals(parama.mnA, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.b
 * JD-Core Version:    0.7.0.1
 */