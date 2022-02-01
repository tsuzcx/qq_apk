package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.a.i;
import com.tencent.mm.plugin.appbrand.r.a.a.j;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  aa ckN;
  final com.tencent.luggage.xweb_ext.extendplugin.a.a cqQ;
  final w cqR;
  protected boolean cqS = false;
  protected boolean cqT = false;
  private boolean cqU = false;
  j cqV = null;
  f.c cqW = null;
  
  public a(com.tencent.luggage.xweb_ext.extendplugin.a.a parama, w paramw)
  {
    this.cqQ = parama;
    this.cqR = paramw;
  }
  
  protected abstract boolean FG();
  
  protected final void a(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if (this.ckN != null) {
      return;
    }
    parama = parama.El();
    Object localObject;
    if (!(parama instanceof aa))
    {
      ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof q))
      {
        ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((q)parama).getCurrentPageView();
      if (!this.cqU)
      {
        if (this.cqV == null)
        {
          this.cqV = new j()
          {
            public final void a(aa.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              ad.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if (!a.this.FG())
              {
                ad.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                AppMethodBeat.o(178799);
                return;
              }
              if ((!a.this.cqS) || (!a.this.cqT))
              {
                ad.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cqS + ", mIsAutoRotationEnabled: " + a.this.cqT);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.ckN == null)
              {
                ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.r.a.c)localObject1).aWN()))
              {
                ad.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.cqR.Gh();
              aa localaa = a.this.ckN;
              int i = a.this.cqQ.getId();
              d.g.b.p.h(localaa, "pageView");
              d.g.b.p.h(paramAnonymousa, "orientation");
              ad.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localaa + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.v.cpQ[paramAnonymousa.ordinal()])
              {
              default: 
                paramAnonymousa = null;
              }
              while (paramAnonymousa == null)
              {
                ad.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
                AppMethodBeat.o(178799);
                return;
                paramAnonymousa = "landscapeLeft";
                continue;
                paramAnonymousa = "landscape";
                continue;
                paramAnonymousa = "portrait";
              }
              Object localObject2 = new HashMap(2);
              ((Map)localObject2).put("viewId", Integer.valueOf(i));
              ((Map)localObject2).put("orientation", paramAnonymousa);
              paramAnonymousa = h.m((Map)localObject2).toString();
              ad.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((u)localObject1).getName() + ", data: " + paramAnonymousa);
              ((u)localObject1).Ph(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localaa, localaa.aXC()).bir();
              localObject2 = localaa.Ew();
              if (localObject2 != null)
              {
                ((u)localObject1).Ph(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, localaa.aXC()).bir();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.cqW = new f.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(178800);
              ad.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
              Object localObject = parama.getActivity();
              if (localObject == null)
              {
                ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
                AppMethodBeat.o(178800);
                return;
              }
              localObject = i.D((Activity)localObject);
              j localj = a.this.cqV;
              d.g.b.p.h(localj, "orientationObserver");
              ad.d(((i)localObject).kEX, "removeOrientationObserver");
              ((i)localObject).mpA.remove(localj);
              parama.b(a.this.cqW);
              AppMethodBeat.o(178800);
            }
          };
        }
        localObject = parama.getActivity();
        if (localObject != null) {
          break label160;
        }
        ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
      }
    }
    for (;;)
    {
      this.ckN = parama;
      return;
      parama = (aa)parama;
      break;
      label160:
      localObject = i.D((Activity)localObject);
      j localj = this.cqV;
      d.g.b.p.h(localj, "orientationObserver");
      ad.d(((i)localObject).kEX, "addOrientationObserver");
      ((i)localObject).mpA.add(localj);
      parama.a(this.cqW);
      this.cqU = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a
 * JD-Core Version:    0.7.0.1
 */