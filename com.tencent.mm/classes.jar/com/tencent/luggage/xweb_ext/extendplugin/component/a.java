package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.platform.window.a.j;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  z ckP;
  f.c crA = null;
  final com.tencent.luggage.xweb_ext.extendplugin.a.a cru;
  final w crv;
  protected boolean crw = false;
  protected boolean crx = false;
  private boolean cry = false;
  j crz = null;
  
  public a(com.tencent.luggage.xweb_ext.extendplugin.a.a parama, w paramw)
  {
    this.cru = parama;
    this.crv = paramw;
  }
  
  protected abstract boolean FM();
  
  protected final void a(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if (this.ckP != null) {
      return;
    }
    parama = parama.Eo();
    Object localObject;
    if (!(parama instanceof z))
    {
      ae.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof r))
      {
        ae.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((r)parama).getCurrentPageView();
      if (!this.cry)
      {
        if (this.crz == null)
        {
          this.crz = new j()
          {
            public final void a(ad.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              ae.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if (!a.this.FM())
              {
                ae.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                AppMethodBeat.o(178799);
                return;
              }
              if ((!a.this.crw) || (!a.this.crx))
              {
                ae.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.crw + ", mIsAutoRotationEnabled: " + a.this.crx);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.ckP == null)
              {
                ae.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.platform.window.c)localObject1).EX()))
              {
                ae.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.crv.Gn();
              z localz = a.this.ckP;
              int i = a.this.cru.getId();
              d.g.b.p.h(localz, "pageView");
              d.g.b.p.h(paramAnonymousa, "orientation");
              ae.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localz + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.v.cqt[paramAnonymousa.ordinal()])
              {
              default: 
                paramAnonymousa = null;
              }
              while (paramAnonymousa == null)
              {
                ae.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
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
              paramAnonymousa = h.t((Map)localObject2).toString();
              ae.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((u)localObject1).getName() + ", data: " + paramAnonymousa);
              ((u)localObject1).PP(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localz, localz.aXX()).bja();
              localObject2 = localz.Ey();
              if (localObject2 != null)
              {
                ((u)localObject1).PP(paramAnonymousa).a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, localz.aXX()).bja();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.crA = new f.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(178800);
              ae.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy");
              Object localObject = parama.getActivity();
              if (localObject == null)
              {
                ae.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onDestroy, null == activity");
                AppMethodBeat.o(178800);
                return;
              }
              localObject = i.E((Activity)localObject);
              j localj = a.this.crz;
              d.g.b.p.h(localj, "orientationObserver");
              ae.d(((i)localObject).kIm, "removeOrientationObserver");
              ((i)localObject).muB.remove(localj);
              parama.b(a.this.crA);
              AppMethodBeat.o(178800);
            }
          };
        }
        localObject = parama.getActivity();
        if (localObject != null) {
          break label160;
        }
        ae.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
      }
    }
    for (;;)
    {
      this.ckP = parama;
      return;
      parama = (z)parama;
      break;
      label160:
      localObject = i.E((Activity)localObject);
      j localj = this.crz;
      d.g.b.p.h(localj, "orientationObserver");
      ae.d(((i)localObject).kIm, "addOrientationObserver");
      ((i)localObject).muB.add(localj);
      parama.a(this.crA);
      this.cry = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a
 * JD-Core Version:    0.7.0.1
 */