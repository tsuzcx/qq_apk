package com.tencent.luggage.k.a.a;

import com.tencent.luggage.k.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.aj.10;
import com.tencent.mm.plugin.appbrand.page.aj.6;
import com.tencent.mm.plugin.appbrand.page.aj.7;
import com.tencent.mm.plugin.appbrand.page.aj.8;
import com.tencent.mm.plugin.appbrand.page.aj.9;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private aj b(aa paramaa)
  {
    paramaa = paramaa.getRuntime();
    if (paramaa == null)
    {
      ad.w(EE(), "handlePipInfo, null == runtime");
      return null;
    }
    paramaa = paramaa.iDT;
    if (paramaa == null)
    {
      ad.w(EE(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramaa;
  }
  
  public static aa f(a parama)
  {
    parama = parama.Dj();
    if (!(parama instanceof aa))
    {
      ad.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.q))
      {
        ad.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((com.tencent.mm.plugin.appbrand.q)parama).getCurrentPageView();
    }
    return (aa)parama;
  }
  
  protected abstract String EE();
  
  protected abstract PipInfoProvider EF();
  
  public final void a(a parama, String paramString)
  {
    ad.i(EE(), "handlePipInfo");
    Object localObject1 = f(parama);
    if (localObject1 == null) {
      ad.w(EE(), "handlePipInfo, null == pageView");
    }
    Object localObject4;
    Object localObject3;
    int i;
    h localh;
    i.a locala;
    do
    {
      return;
      localObject4 = ((aa)localObject1).lbd;
      if (localObject4 == null)
      {
        ad.w(EE(), "handlePipInfo, null == page");
        return;
      }
      localObject2 = b((aa)localObject1);
      if (localObject2 == null)
      {
        ad.w(EE(), "handlePipInfo, null == pipManager");
        return;
      }
      if ((x)((aj)localObject2).lcS.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new x((aa)localObject1);
        if (((aj)localObject2).lda == null) {
          ((aj)localObject2).lda = new aj.9((aj)localObject2);
        }
        ((x)localObject3).kzM = ((aj)localObject2).lda;
        ad.i(((aj)localObject2).cjP, "createPageScopedPipInfoIfNeed for " + aj.r(((aa)localObject1).lbd));
        ((aj)localObject2).lcS.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.EB();
      if (parama == null)
      {
        ad.w(EE(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = EF();
      parama = ((c)localObject3).cE(parama.toString());
      if (parama == null)
      {
        ad.w(EE(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new ag(((aj)localObject2).iGV.mAppId, ((com.tencent.mm.plugin.appbrand.page.q)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localh = ((c)localObject3).EQ();
      locala = ((c)localObject3).ER();
      localObject3 = ((c)localObject3).ES();
      localObject1 = ((aj)localObject2).s((aa)localObject1);
    } while (localObject1 == null);
    ad.d(((x)localObject1).cjP, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (x.a)((x)localObject1).laz.get(localObject4);
    if (localObject2 == null)
    {
      ad.i(((x)localObject1).cjP, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((x)localObject1).laz.put(localObject4, new x.a(i, parama, localh, locala, (d)localObject3, paramString, ((x)localObject1).kzM));
      return;
    }
    ad.i(((x)localObject1).cjP, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((x.a)localObject2).a(parama);
    ((x.a)localObject2).laH = paramString;
  }
  
  public final void b(a parama)
  {
    ad.i(EE(), "addPipId");
    Object localObject2 = f(parama);
    if (localObject2 == null) {}
    do
    {
      do
      {
        return;
        ??? = b((aa)localObject2);
      } while (??? == null);
      parama = getKey();
      localObject2 = ((aj)???).s((aa)localObject2);
    } while (localObject2 == null);
    if (!((aj)???).lcR)
    {
      ((aj)???).iDz.setPipPageLifeCycleListener(new aj.7((aj)???));
      ((aj)???).iDz.setOnPageSwitchListener(new aj.8((aj)???));
      g.a(((aj)???).iGV.mAppId, new aj.6((aj)???));
      ((aj)???).iDz.setDelegateWrapperFactory(new aj.10((aj)???));
      ((aj)???).lcR = true;
    }
    ad.i(((x)localObject2).cjP, "addPipRelatedKey, key: ".concat(String.valueOf(parama)));
    synchronized (((x)localObject2).lay)
    {
      ((x)localObject2).lay.remove(parama);
      ((x)localObject2).lay.addFirst(parama);
      return;
    }
  }
  
  public final void c(a parama)
  {
    ad.i(EE(), "removePipId");
    parama = f(parama);
    if (parama == null) {}
    aj localaj;
    do
    {
      return;
      localaj = b(parama);
    } while (localaj == null);
    localaj.a(parama, getKey());
  }
  
  public final boolean d(a parama)
  {
    ad.i(EE(), "exitPip");
    parama = f(parama);
    if (parama == null) {}
    do
    {
      return false;
      parama = b(parama);
    } while (parama == null);
    return parama.tv(getId());
  }
  
  public final boolean e(a parama)
  {
    ad.i(EE(), "amIPipPlayer");
    if (parama == null) {}
    do
    {
      do
      {
        return false;
        parama = f(parama);
      } while (parama == null);
      parama = b(parama);
    } while (parama == null);
    String str = getKey();
    return Objects.equals(parama.lcW, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */