package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  ad enm;
  final com.tencent.luggage.xweb_ext.extendplugin.a.a exC;
  final z exD;
  protected boolean exE = false;
  protected boolean exF = false;
  private boolean exG = false;
  i exH = null;
  i.c exI = null;
  
  public a(com.tencent.luggage.xweb_ext.extendplugin.a.a parama, z paramz)
  {
    this.exC = parama;
    this.exD = paramz;
  }
  
  protected final void a(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if (this.enm != null) {
      return;
    }
    parama = parama.aqX();
    Object localObject;
    if (!(parama instanceof ad))
    {
      Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.y))
      {
        Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((com.tencent.mm.plugin.appbrand.y)parama).getCurrentPageView();
      if (!this.exG)
      {
        if (this.exH == null)
        {
          this.exH = new i()
          {
            public final void a(ak.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if (!a.this.atA())
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                AppMethodBeat.o(178799);
                return;
              }
              if ((!a.this.exE) || (!a.this.exF))
              {
                Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.exE + ", mIsAutoRotationEnabled: " + a.this.exF);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.enm == null)
              {
                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((c)localObject1).asq()))
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.exD.auc();
              ad localad = a.this.enm;
              int i = a.this.exC.getId();
              kotlin.g.b.s.u(localad, "pageView");
              kotlin.g.b.s.u(paramAnonymousa, "orientation");
              Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localad + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.y.a.$EnumSwitchMapping$0[paramAnonymousa.ordinal()])
              {
              default: 
                paramAnonymousa = null;
              }
              while (paramAnonymousa == null)
              {
                Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
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
              paramAnonymousa = com.tencent.mm.ad.h.u((Map)localObject2).toString();
              Log.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((com.tencent.mm.plugin.appbrand.jsapi.y)localObject1).getName() + ", data: " + paramAnonymousa);
              ((com.tencent.mm.plugin.appbrand.jsapi.y)localObject1).ZQ(paramAnonymousa).a((f)localad, localad.getComponentId()).cpV();
              localObject2 = localad.ari();
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.appbrand.jsapi.y)localObject1).ZQ(paramAnonymousa).a((f)localObject2, localad.getComponentId()).cpV();
              }
              AppMethodBeat.o(178799);
            }
          };
          this.exI = new i.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(178800);
              Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
              Object localObject = parama.getActivity();
              if (localObject == null)
              {
                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
                AppMethodBeat.o(178800);
                return;
              }
              localObject = com.tencent.mm.plugin.appbrand.platform.window.a.h.L((Activity)localObject);
              i locali = a.this.exH;
              kotlin.g.b.s.u(locali, "orientationObserver");
              Log.d(((com.tencent.mm.plugin.appbrand.platform.window.a.h)localObject).djQ, "removeOrientationObserver");
              ((com.tencent.mm.plugin.appbrand.platform.window.a.h)localObject).tMf.remove(locali);
              parama.b(a.this.exI);
              AppMethodBeat.o(178800);
            }
          };
        }
        localObject = parama.getActivity();
        if (localObject != null) {
          break label160;
        }
        Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
      }
    }
    for (;;)
    {
      this.enm = parama;
      return;
      parama = (ad)parama;
      break;
      label160:
      localObject = com.tencent.mm.plugin.appbrand.platform.window.a.h.L((Activity)localObject);
      i locali = this.exH;
      kotlin.g.b.s.u(locali, "orientationObserver");
      Log.d(((com.tencent.mm.plugin.appbrand.platform.window.a.h)localObject).djQ, "addOrientationObserver");
      ((com.tencent.mm.plugin.appbrand.platform.window.a.h)localObject).tMf.add(locali);
      parama.a(this.exI);
      this.exG = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama);
  
  protected abstract boolean atA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a
 * JD-Core Version:    0.7.0.1
 */