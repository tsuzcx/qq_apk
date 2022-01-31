package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.ui.banner.f;

public final class i
  extends JsApiOperateBackgroundAudio
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC(parama, paramc, paramInt);
  }
  
  protected final void h(c paramc)
  {
    if (this.giA != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.config.i)paramc.D(com.tencent.mm.plugin.appbrand.config.i.class);
      this.giA.bOa = ((com.tencent.mm.plugin.appbrand.config.i)localObject).aej();
      this.giA.bJw = ((com.tencent.mm.plugin.appbrand.config.i)localObject).bJw;
      if ((localObject instanceof AppBrandSysConfigWC)) {
        this.giA.bNZ = ((AppBrandSysConfigWC)localObject).bFn;
      }
      localObject = u.ij("AppBrandService#" + paramc.hashCode());
      for (;;)
      {
        synchronized (u.Hc().v((String)localObject, true))
        {
          localObject = (f)???.get("StickyBannerChangeListener", null);
          if (localObject == null)
          {
            localObject = new i.1(this, ???);
            com.tencent.mm.plugin.appbrand.config.i locali = (com.tencent.mm.plugin.appbrand.config.i)paramc.D(com.tencent.mm.plugin.appbrand.config.i.class);
            if (locali != null) {
              ???.h("pkgType", Integer.valueOf(locali.aej()));
            }
            ???.h("StickyBannerChangeListener", localObject);
            ???.h("appId", paramc.getAppId());
            paramc = (c)localObject;
            if ((g.b)???.get("AppBrandLifeCycle.Listener", null) == null)
            {
              localObject = new i.2(this, ???);
              ???.h("AppBrandLifeCycle.Listener", localObject);
              this.giA.gda = ((g.b)localObject);
            }
            if ((this.giA instanceof JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC))
            {
              ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.giA).giI = paramc;
              ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.giA).fVQ = ???;
            }
            return;
          }
        }
        paramc = (c)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */