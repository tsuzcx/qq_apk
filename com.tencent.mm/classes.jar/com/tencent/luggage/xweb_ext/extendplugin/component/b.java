package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.h.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.pip.a.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.pip.f.4;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  private f b(ad paramad)
  {
    paramad = paramad.getRuntime();
    if (paramad == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == runtime");
      return null;
    }
    paramad = paramad.nuc;
    if (paramad == null)
    {
      Log.w(getLogTag(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramad;
  }
  
  public static ad e(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    parama = parama.QK();
    if (!(parama instanceof ad))
    {
      Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof v))
      {
        Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((v)parama).getCurrentPageView();
    }
    return (ad)parama;
  }
  
  protected abstract PipInfoProvider SW();
  
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
      localObject4 = ((ad)localObject1).qsG;
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
      if ((com.tencent.mm.plugin.appbrand.pip.a)((f)localObject2).qFp.get(Integer.valueOf(localObject1.hashCode())) == null)
      {
        localObject3 = new com.tencent.mm.plugin.appbrand.pip.a((ad)localObject1);
        if (((f)localObject2).qFx == null) {
          ((f)localObject2).qFx = new f.4((f)localObject2);
        }
        ((com.tencent.mm.plugin.appbrand.pip.a)localObject3).pKZ = ((f)localObject2).qFx;
        Log.i(((f)localObject2).cED, "createPageScopedPipInfoIfNeed for " + f.t(((ad)localObject1).qsG));
        ((f)localObject2).qFp.put(Integer.valueOf(localObject1.hashCode()), localObject3);
      }
      parama = parama.SR();
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
        return;
      }
      localObject3 = SW();
      parama = ((c)localObject3).es(parama.toString());
      if (parama == null)
      {
        Log.w(getLogTag(), "handlePipInfo, null == pipExtra");
        return;
      }
      paramString = new com.tencent.mm.plugin.appbrand.pip.c(((f)localObject2).nxs.mAppId, ((u)localObject4).getCurrentUrl(), paramString);
      localObject4 = getKey();
      i = getId();
      localg = ((c)localObject3).Th();
      locala = ((c)localObject3).Ti();
      localObject3 = ((c)localObject3).Tj();
      localObject1 = ((f)localObject2).z((ad)localObject1);
    } while (localObject1 == null);
    Log.d(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cED, "processPipInfo, key: ".concat(String.valueOf(localObject4)));
    Object localObject2 = (a.a)((com.tencent.mm.plugin.appbrand.pip.a)localObject1).qEa.get(localObject4);
    if (localObject2 == null)
    {
      Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cED, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(localObject4)));
      ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).qEa.put(localObject4, new a.a(i, parama, localg, locala, (com.tencent.mm.plugin.appbrand.jsapi.t.c)localObject3, paramString, ((com.tencent.mm.plugin.appbrand.pip.a)localObject1).pKZ));
      return;
    }
    Log.i(((com.tencent.mm.plugin.appbrand.pip.a)localObject1).cED, "processPipInfo, pipVideoSession for key: " + (String)localObject4 + " exists");
    ((a.a)localObject2).a(parama);
    ((a.a)localObject2).qEi = paramString;
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
        localf = b((ad)localObject);
      } while (localf == null);
      parama = getKey();
      localObject = localf.z((ad)localObject);
    } while (localObject == null);
    ((com.tencent.mm.plugin.appbrand.pip.a)localObject).amt(parama);
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
    return parama.CA(getId());
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
    return Objects.equals(parama.qFt, str);
  }
  
  protected abstract int getId();
  
  protected abstract String getKey();
  
  protected abstract String getLogTag();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.b
 * JD-Core Version:    0.7.0.1
 */