package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.i;
import com.tencent.mm.plugin.appbrand.platform.window.a.j;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public abstract class a
{
  final com.tencent.luggage.xweb_ext.extendplugin.a.a cDK;
  final z cDL;
  protected boolean cDM = false;
  protected boolean cDN = false;
  private boolean cDO = false;
  j cDP = null;
  i.c cDQ = null;
  ac cwK;
  
  public a(com.tencent.luggage.xweb_ext.extendplugin.a.a parama, z paramz)
  {
    this.cDK = parama;
    this.cDL = paramz;
  }
  
  protected abstract boolean Pv();
  
  protected final void a(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if (this.cwK != null) {
      return;
    }
    parama = parama.NN();
    Object localObject;
    if (!(parama instanceof ac))
    {
      Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandPageView");
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.s))
      {
        Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "setPageView, component(" + parama + ") is not AppBrandService");
        return;
      }
      parama = ((com.tencent.mm.plugin.appbrand.s)parama).getCurrentPageView();
      if (!this.cDO)
      {
        if (this.cDP == null)
        {
          this.cDP = new j()
          {
            public final void a(ad.a paramAnonymousa)
            {
              AppMethodBeat.i(178799);
              Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, orientation: ".concat(String.valueOf(paramAnonymousa)));
              if (!a.this.Pv())
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
                AppMethodBeat.o(178799);
                return;
              }
              if ((!a.this.cDM) || (!a.this.cDN))
              {
                Log.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, mIsNeedNotify: " + a.this.cDM + ", mIsAutoRotationEnabled: " + a.this.cDN);
                AppMethodBeat.o(178799);
                return;
              }
              if (a.this.cwK == null)
              {
                Log.w("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
                AppMethodBeat.o(178799);
                return;
              }
              Object localObject1 = parama.getRuntime().getWindowAndroid();
              if ((localObject1 != null) && (((c)localObject1).OD()))
              {
                Log.i("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                AppMethodBeat.o(178799);
                return;
              }
              localObject1 = a.this.cDL.PW();
              ac localac = a.this.cwK;
              int i = a.this.cDK.getId();
              p.h(localac, "pageView");
              p.h(paramAnonymousa, "orientation");
              Log.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, pageView: " + localac + ", viewId: " + i + ", orientation: " + paramAnonymousa);
              switch (com.tencent.mm.plugin.appbrand.jsapi.y.$EnumSwitchMapping$0[paramAnonymousa.ordinal()])
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
              paramAnonymousa = h.v((Map)localObject2).toString();
              Log.i("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, name: " + ((x)localObject1).getName() + ", data: " + paramAnonymousa);
              ((x)localObject1).Zg(paramAnonymousa).a((f)localac, localac.getComponentId()).bEo();
              localObject2 = localac.NY();
              if (localObject2 != null)
              {
                ((x)localObject1).Zg(paramAnonymousa).a((f)localObject2, localac.getComponentId()).bEo();
                AppMethodBeat.o(178799);
                return;
              }
              AppMethodBeat.o(178799);
            }
          };
          this.cDQ = new i.c()
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
              j localj = a.this.cDP;
              p.h(localj, "orientationObserver");
              Log.d(((i)localObject).lMQ, "removeOrientationObserver");
              ((i)localObject).nFk.remove(localj);
              parama.b(a.this.cDQ);
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
      this.cwK = parama;
      return;
      parama = (ac)parama;
      break;
      label160:
      localObject = i.F((Activity)localObject);
      j localj = this.cDP;
      p.h(localj, "orientationObserver");
      Log.d(((i)localObject).lMQ, "addOrientationObserver");
      ((i)localObject).nFk.add(localj);
      parama.a(this.cDQ);
      this.cDO = true;
    }
  }
  
  public abstract void a(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a
 * JD-Core Version:    0.7.0.1
 */