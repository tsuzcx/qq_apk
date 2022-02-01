package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.platform.window.a.j;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public abstract class a
{
  final com.tencent.luggage.xweb_ext.extendplugin.a.a cEr;
  final y cEs;
  protected boolean cEt = false;
  protected boolean cEu = false;
  private boolean cEv = false;
  j cEw = null;
  h.c cEx = null;
  ad cvo;
  
  public a(com.tencent.luggage.xweb_ext.extendplugin.a.a parama, y paramy)
  {
    this.cEr = parama;
    this.cEs = paramy;
  }
  
  protected abstract boolean SV();
  
  protected final void a(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if (this.cvo != null) {
      return;
    }
    parama = parama.QK();
    Object localObject;
    if (!(parama instanceof ad))
    {
      Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof v))
      {
        Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((v)parama).getCurrentPageView();
      if (!this.cEv)
      {
        if (this.cEw == null)
        {
          this.cEw = new j()
          {
            public final void a(af.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if (!a.this.SV())
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                AppMethodBeat.o(178799);
                return;
              }
              if ((!a.this.cEt) || (!a.this.cEu))
              {
                Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cEt + ", mIsAutoRotationEnabled: " + a.this.cEu);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.cvo == null)
              {
                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((c)localObject1).RZ()))
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.cEs.Tx();
              ad localad = a.this.cvo;
              int i = a.this.cEr.getId();
              p.k(localad, "pageView");
              p.k(paramAnonymousa, "orientation");
              Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localad + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.x.$EnumSwitchMapping$0[paramAnonymousa.ordinal()])
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
              paramAnonymousa = h.n((Map)localObject2).toString();
              Log.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((w)localObject1).getName() + ", data: " + paramAnonymousa);
              ((w)localObject1).agT(paramAnonymousa).a((e)localad, localad.getComponentId()).bPO();
              localObject2 = localad.QW();
              if (localObject2 != null)
              {
                ((w)localObject1).agT(paramAnonymousa).a((e)localObject2, localad.getComponentId()).bPO();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.cEx = new h.c()
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
              localObject = i.F((Activity)localObject);
              j localj = a.this.cEw;
              p.k(localj, "orientationObserver");
              Log.d(((i)localObject).bqj, "removeOrientationObserver");
              ((i)localObject).qHu.remove(localj);
              parama.b(a.this.cEx);
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
      this.cvo = parama;
      return;
      parama = (ad)parama;
      break;
      label160:
      localObject = i.F((Activity)localObject);
      j localj = this.cEw;
      p.k(localj, "orientationObserver");
      Log.d(((i)localObject).bqj, "addOrientationObserver");
      ((i)localObject).qHu.add(localj);
      parama.a(this.cEx);
      this.cEv = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a
 * JD-Core Version:    0.7.0.1
 */