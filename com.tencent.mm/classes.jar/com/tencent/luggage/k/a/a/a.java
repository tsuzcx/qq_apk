package com.tencent.luggage.k.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.a.i;
import com.tencent.mm.plugin.appbrand.r.a.a.j;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  aa caw;
  final w cgA;
  protected boolean cgB = false;
  protected boolean cgC = false;
  private boolean cgD = false;
  j cgE = null;
  f.c cgF = null;
  final com.tencent.luggage.k.a.b.a cgz;
  
  public a(com.tencent.luggage.k.a.b.a parama, w paramw)
  {
    this.cgz = parama;
    this.cgA = paramw;
  }
  
  protected final void a(final com.tencent.luggage.k.a.a parama)
  {
    if (this.caw != null) {
      return;
    }
    parama = parama.CM();
    Object localObject;
    if (!(parama instanceof aa))
    {
      ac.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof q))
      {
        ac.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((q)parama).getCurrentPageView();
      if (!this.cgD)
      {
        if (this.cgE == null)
        {
          this.cgE = new j()
          {
            public final void a(aa.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              ac.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if ((!a.this.cgB) || (!a.this.cgC))
              {
                ac.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cgB + ", mIsAutoRotationEnabled: " + a.this.cgC);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.caw == null)
              {
                ac.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.r.a.c)localObject1).aTx()))
              {
                ac.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.cgA.EK();
              aa localaa = a.this.caw;
              int i = a.this.cgz.getId();
              k.h(localaa, "pageView");
              k.h(paramAnonymousa, "orientation");
              ac.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localaa + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.v.cfA[paramAnonymousa.ordinal()])
              {
              default: 
                paramAnonymousa = null;
              }
              while (paramAnonymousa == null)
              {
                ac.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
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
              ac.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((u)localObject1).getName() + ", data: " + paramAnonymousa);
              ((u)localObject1).LN(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localaa, localaa.aUT()).beN();
              localObject2 = localaa.CX();
              if (localObject2 != null)
              {
                ((u)localObject1).LN(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, localaa.aUT()).beN();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.cgF = new f.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(178800);
              ac.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
              Object localObject = parama.getActivity();
              if (localObject == null)
              {
                ac.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
                AppMethodBeat.o(178800);
                return;
              }
              localObject = i.D((Activity)localObject);
              j localj = a.this.cgE;
              k.h(localj, "orientationObserver");
              ac.d(((i)localObject).kjY, "removeOrientationObserver");
              ((i)localObject).lPL.remove(localj);
              parama.b(a.this.cgF);
              AppMethodBeat.o(178800);
            }
          };
        }
        localObject = parama.getActivity();
        if (localObject != null) {
          break label160;
        }
        ac.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
      }
    }
    for (;;)
    {
      this.caw = parama;
      return;
      parama = (aa)parama;
      break;
      label160:
      localObject = i.D((Activity)localObject);
      j localj = this.cgE;
      k.h(localj, "orientationObserver");
      ac.d(((i)localObject).kjY, "addOrientationObserver");
      ((i)localObject).lPL.add(localj);
      parama.a(this.cgF);
      this.cgD = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.k.a.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */