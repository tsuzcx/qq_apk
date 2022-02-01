package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(45955);
    parama = new SetBackgroundAudioListenerTaskWC(parama, paramc, paramInt);
    AppMethodBeat.o(45955);
    return parama;
  }
  
  protected final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(45956);
    if (this.kws != null)
    {
      k localk = (k)paramc.ar(k.class);
      this.kws.dtF = localk.jYh.jIU;
      this.kws.doD = localk.doD;
      this.kws.dtE = AppBrandRuntimeWCAccessible.c(paramc);
      ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.kws.dtF), this.kws.doD, this.kws.dtE });
      synchronized (y.aBq().F(paramString, true))
      {
        f localf = (f)???.get("StickyBannerChangeListener", null);
        paramString = localf;
        if (localf == null)
        {
          paramString = new f()
          {
            public final void bB(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(45950);
              String str = localb.getString("appId", "");
              int i = localb.getInt("pkgType", 0);
              if (((!str.equals(paramAnonymousString)) || (i != paramAnonymousInt)) && (localb.AI("setBackgroundAudioState#isPlaying")) && (g.Kw(str) != g.b.jwg))
              {
                ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                paramAnonymousString = new JSONObject();
              }
              try
              {
                paramAnonymousString.put("operationType", "pause");
                label90:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.kws.ktc, JsApiSetBackgroundAudioStateWC.this.kws.kje);
                localSetBackgroundAudioStateTask.kwv = paramAnonymousString.toString();
                localSetBackgroundAudioStateTask.appId = str;
                AppBrandMainProcessService.a(localSetBackgroundAudioStateTask);
                AppMethodBeat.o(45950);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label90;
              }
            }
          };
          ???.k("pkgType", Integer.valueOf(localk.jYh.jIU));
          ???.k("StickyBannerChangeListener", paramString);
          ???.k("appId", paramc.getAppId());
        }
        if ((this.kws instanceof SetBackgroundAudioListenerTaskWC))
        {
          ((SetBackgroundAudioListenerTaskWC)this.kws).kwB = paramString;
          ((SetBackgroundAudioListenerTaskWC)this.kws).kwA = ???;
        }
        AppMethodBeat.o(45956);
        return;
      }
    }
    AppMethodBeat.o(45956);
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(a parama, c paramc, int paramInt)
  {
    AppMethodBeat.i(45954);
    parama = new SetBackgroundAudioStateTaskWC(parama, paramc, paramInt);
    AppMethodBeat.o(45954);
    return parama;
  }
  
  public static class SetBackgroundAudioListenerTaskWC
    extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
  {
    private Context context;
    public y.b kwA;
    public f kwB;
    
    public SetBackgroundAudioListenerTaskWC(a parama, c paramc, int paramInt)
    {
      super(paramc, paramInt);
      AppMethodBeat.i(45951);
      this.context = paramc.getContext();
      AppMethodBeat.o(45951);
    }
    
    protected final void sM(int paramInt)
    {
      AppMethodBeat.i(45952);
      switch (paramInt)
      {
      case 5: 
      case 6: 
      case 9: 
      default: 
        AppMethodBeat.o(45952);
        return;
      case 0: 
      case 1: 
        this.kwA.k("setBackgroundAudioState#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.kwB);
        if (!b.ca(aj.getContext())) {
          AppBrandFloatBallPermissionHelper.a(this.context, 6, null);
        }
        AppMethodBeat.o(45952);
        return;
      case 2: 
      case 3: 
      case 4: 
      case 7: 
        this.kwA.k("setBackgroundAudioState#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kwB);
        AppMethodBeat.o(45952);
        return;
      case 10: 
        AppMethodBeat.o(45952);
        return;
      case 8: 
      case 11: 
      case 12: 
        AppMethodBeat.o(45952);
        return;
      case 13: 
        AppMethodBeat.o(45952);
        return;
      }
      AppMethodBeat.o(45952);
    }
  }
  
  public static class SetBackgroundAudioStateTaskWC
    extends JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask
  {
    public SetBackgroundAudioStateTaskWC(a parama, c paramc, int paramInt)
    {
      super(paramc, paramInt);
    }
    
    public final String Pl(String paramString)
    {
      AppMethodBeat.i(45953);
      paramString = d.azA() + paramString.hashCode();
      AppMethodBeat.o(45953);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */