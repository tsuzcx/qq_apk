package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame, int paramInt)
  {
    AppMethodBeat.i(45955);
    paramc = new SetBackgroundAudioListenerTaskWC(paramc, parame, paramInt);
    AppMethodBeat.o(45955);
    return paramc;
  }
  
  protected final void a(String paramString, e parame)
  {
    AppMethodBeat.i(45956);
    if (this.ozB != null)
    {
      if ((parame instanceof g)) {
        ((g)parame).getRuntime().ntR.a(new c.a()
        {
          public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
          {
            AppMethodBeat.i(279563);
            if ((com.tencent.mm.plugin.appbrand.a.b.nKS == paramAnonymousb) && (JsApiSetBackgroundAudioStateWC.this.ozB != null)) {
              JsApiSetBackgroundAudioStateWC.this.ozB.bPk();
            }
            AppMethodBeat.o(279563);
          }
        });
      }
      l locall = (l)parame.au(l.class);
      this.ozB.fES = locall.nYR.nHY;
      this.ozB.fzM = locall.fzM;
      this.ozB.appUserName = AppBrandRuntimeWCAccessible.e(parame);
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.ozB.fES), this.ozB.fzM, this.ozB.appUserName });
      synchronized (ad.beh().I(paramString, true))
      {
        f localf = (f)???.get("StickyBannerChangeListener", null);
        paramString = localf;
        if (localf == null)
        {
          paramString = new f()
          {
            public final void ce(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(279599);
              String str = localb.getString("appId", "");
              int i = localb.getInt("pkgType", 0);
              if (((!str.equals(paramAnonymousString)) || (i != paramAnonymousInt)) && (localb.Rq("setBackgroundAudioState#isPlaying")) && (k.abN(str) != k.b.nsW))
              {
                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                paramAnonymousString = new JSONObject();
              }
              try
              {
                paramAnonymousString.put("operationType", "pause");
                label90:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.ozB.ovO, JsApiSetBackgroundAudioStateWC.this.ozB.okO);
                localSetBackgroundAudioStateTask.ozE = paramAnonymousString.toString();
                localSetBackgroundAudioStateTask.appId = str;
                localSetBackgroundAudioStateTask.bsM();
                AppMethodBeat.o(279599);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label90;
              }
            }
          };
          ???.k("pkgType", Integer.valueOf(locall.nYR.nHY));
          ???.k("StickyBannerChangeListener", paramString);
          ???.k("appId", parame.getAppId());
        }
        if ((this.ozB instanceof SetBackgroundAudioListenerTaskWC))
        {
          ((SetBackgroundAudioListenerTaskWC)this.ozB).ozK = paramString;
          ((SetBackgroundAudioListenerTaskWC)this.ozB).ozJ = ???;
        }
        AppMethodBeat.o(45956);
        return;
      }
    }
    AppMethodBeat.o(45956);
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame, int paramInt)
  {
    AppMethodBeat.i(45954);
    paramc = new SetBackgroundAudioStateTaskWC(paramc, parame, paramInt);
    AppMethodBeat.o(45954);
    return paramc;
  }
  
  public static class SetBackgroundAudioListenerTaskWC
    extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
  {
    private Context context;
    public ad.b ozJ;
    public f ozK;
    
    public SetBackgroundAudioListenerTaskWC(com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame, int paramInt)
    {
      super(parame, paramInt);
      AppMethodBeat.i(45951);
      this.context = parame.getContext();
      AppMethodBeat.o(45951);
    }
    
    protected final void Aa(int paramInt)
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
        this.ozJ.k("setBackgroundAudioState#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.ozK);
        if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext())) {
          AppBrandFloatBallPermissionHelper.a(this.context, 6, null);
        }
        AppMethodBeat.o(45952);
        return;
      case 2: 
      case 3: 
      case 4: 
      case 7: 
        this.ozJ.k("setBackgroundAudioState#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.ozK);
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
    public SetBackgroundAudioStateTaskWC(com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame, int paramInt)
    {
      super(parame, paramInt);
    }
    
    public final String aha(String paramString)
    {
      AppMethodBeat.i(45953);
      paramString = d.bbW() + paramString.hashCode();
      AppMethodBeat.o(45953);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */