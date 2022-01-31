package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(130766);
    parama = new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC(parama, paramc, paramInt);
    AppMethodBeat.o(130766);
    return parama;
  }
  
  protected final String a(JSONObject paramJSONObject, c paramc)
  {
    AppMethodBeat.i(130768);
    paramJSONObject = super.a(paramJSONObject, paramc);
    if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
    {
      AppMethodBeat.o(130768);
      return "";
    }
    if ((paramJSONObject.startsWith("http://")) || (paramJSONObject.startsWith("https://")))
    {
      AppMethodBeat.o(130768);
      return paramJSONObject;
    }
    paramJSONObject = paramc.wX().zg(paramJSONObject);
    if ((paramJSONObject != null) && (paramJSONObject.exists()))
    {
      paramc = paramJSONObject.getAbsolutePath();
      paramJSONObject = paramc;
      if (!paramc.startsWith("file://")) {
        paramJSONObject = "file://".concat(String.valueOf(paramc));
      }
      AppMethodBeat.o(130768);
      return paramJSONObject;
    }
    AppMethodBeat.o(130768);
    return "";
  }
  
  protected final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(130767);
    if (this.hBT != null)
    {
      h localh = (h)paramc.U(h.class);
      this.hBT.cvs = localh.hiX.gXe;
      this.hBT.cqQ = localh.cqQ;
      this.hBT.cvr = p.b(paramc);
      ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.hBT.cvs), this.hBT.cqQ, this.hBT.cvr });
      synchronized (v.aae().z(paramString, true))
      {
        f localf = (f)???.get("StickyBannerChangeListener", null);
        paramString = localf;
        if (localf == null)
        {
          paramString = new JsApiSetBackgroundAudioStateWC.1(this, ???);
          ???.i("pkgType", Integer.valueOf(localh.hiX.gXe));
          ???.i("StickyBannerChangeListener", paramString);
          ???.i("appId", paramc.getAppId());
        }
        if ((this.hBT instanceof JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC))
        {
          ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.hBT).hCc = paramString;
          ((JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC)this.hBT).hCb = ???;
        }
        AppMethodBeat.o(130767);
        return;
      }
    }
    AppMethodBeat.o(130767);
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(130765);
    parama = new JsApiSetBackgroundAudioStateWC.SetBackgroundAudioStateTaskWC(parama, paramc, paramInt);
    AppMethodBeat.o(130765);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */