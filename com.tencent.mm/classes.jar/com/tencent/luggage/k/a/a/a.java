package com.tencent.luggage.k.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s.a.a.i;
import com.tencent.mm.plugin.appbrand.s.a.a.j;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  aa cdz;
  final com.tencent.luggage.k.a.b.a cjD;
  final w cjE;
  protected boolean cjF = false;
  protected boolean cjG = false;
  private boolean cjH = false;
  j cjI = null;
  f.c cjJ = null;
  
  public a(com.tencent.luggage.k.a.b.a parama, w paramw)
  {
    this.cjD = parama;
    this.cjE = paramw;
  }
  
  protected final void a(final com.tencent.luggage.k.a.a parama)
  {
    if (this.cdz != null) {
      return;
    }
    parama = parama.Dj();
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
      if (!this.cjH)
      {
        if (this.cjI == null)
        {
          this.cjI = new j()
          {
            public final void a(z.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              ad.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if ((!a.this.cjF) || (!a.this.cjG))
              {
                ad.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cjF + ", mIsAutoRotationEnabled: " + a.this.cjG);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.cdz == null)
              {
                ad.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.s.a.c)localObject1).aMH()))
              {
                ad.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.cjE.Fe();
              aa localaa = a.this.cdz;
              int i = a.this.cjD.getId();
              k.h(localaa, "pageView");
              k.h(paramAnonymousa, "orientation");
              ad.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localaa + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.v.ciE[paramAnonymousa.ordinal()])
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
              paramAnonymousa = h.n((Map)localObject2).toString();
              ad.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((u)localObject1).getName() + ", data: " + paramAnonymousa);
              ((u)localObject1).HJ(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localaa, localaa.aOd()).aXQ();
              localObject2 = localaa.Du();
              if (localObject2 != null)
              {
                ((u)localObject1).HJ(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, localaa.aOd()).aXQ();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.cjJ = new f.c()
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
              j localj = a.this.cjI;
              k.h(localj, "orientationObserver");
              ad.d(((i)localObject).jJy, "removeOrientationObserver");
              ((i)localObject).lnK.remove(localj);
              parama.b(a.this.cjJ);
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
      this.cdz = parama;
      return;
      parama = (aa)parama;
      break;
      label160:
      localObject = i.D((Activity)localObject);
      j localj = this.cjI;
      k.h(localj, "orientationObserver");
      ad.d(((i)localObject).jJy, "addOrientationObserver");
      ((i)localObject).lnK.add(localj);
      parama.a(this.cjJ);
      this.cjH = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.k.a.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */