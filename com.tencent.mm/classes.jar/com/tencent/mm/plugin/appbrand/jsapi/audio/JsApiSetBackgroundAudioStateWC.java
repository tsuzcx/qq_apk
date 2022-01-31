package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC(parama, paramc, paramInt);
  }
  
  protected final String a(JSONObject paramJSONObject, c paramc)
  {
    String str = super.a(paramJSONObject, paramc);
    if ((str == null) || (str.length() <= 0)) {
      paramJSONObject = "";
    }
    do
    {
      do
      {
        do
        {
          return paramJSONObject;
          paramJSONObject = str;
        } while (str.startsWith("http://"));
        paramJSONObject = str;
      } while (str.startsWith("https://"));
      paramJSONObject = paramc.Zl().rx(str);
      if ((paramJSONObject == null) || (!paramJSONObject.exists())) {
        break;
      }
      paramc = paramJSONObject.getAbsolutePath();
      paramJSONObject = paramc;
    } while (paramc.startsWith("file://"));
    return "file://" + paramc;
    return "";
  }
  
  protected final void a(String paramString, c paramc)
  {
    if (this.giA != null)
    {
      i locali = (i)paramc.D(i.class);
      this.giA.bOa = locali.aej();
      this.giA.bJw = locali.bJw;
      if ((locali instanceof AppBrandSysConfigWC)) {
        this.giA.bNZ = ((AppBrandSysConfigWC)locali).bFn;
      }
      y.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.giA.bOa), this.giA.bJw, this.giA.bNZ });
      synchronized (u.Hc().v(paramString, true))
      {
        f localf = (f)???.get("StickyBannerChangeListener", null);
        paramString = localf;
        if (localf == null)
        {
          paramString = new JsApiSetBackgroundAudioStateWC.1(this, ???);
          ???.h("pkgType", Integer.valueOf(locali.aej()));
          ???.h("StickyBannerChangeListener", paramString);
          ???.h("appId", paramc.getAppId());
        }
        if ((g.b)???.get("AppBrandLifeCycle.Listener", null) == null)
        {
          paramc = new JsApiSetBackgroundAudioStateWC.2(this, ???);
          ???.h("AppBrandLifeCycle.Listener", paramc);
          this.giA.gda = paramc;
        }
        if ((this.giA instanceof JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC))
        {
          ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.giA).giI = paramString;
          ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.giA).fVQ = ???;
        }
        return;
      }
    }
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(a parama, c paramc, int paramInt)
  {
    return new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioStateTaskWC(parama, paramc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */