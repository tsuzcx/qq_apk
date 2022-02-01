package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(45955);
    paramd = new SetBackgroundAudioListenerTaskWC(paramd, paramf, paramInt);
    AppMethodBeat.o(45955);
    return paramd;
  }
  
  protected final void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(45956);
    if (this.lEa != null)
    {
      l locall = (l)paramf.av(l.class);
      this.lEa.dMe = locall.leE.kNW;
      this.lEa.brandName = locall.brandName;
      this.lEa.appUserName = AppBrandRuntimeWCAccessible.c(paramf);
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.lEa.dMe), this.lEa.brandName, this.lEa.appUserName });
      synchronized (ad.aVe().G(paramString, true))
      {
        com.tencent.mm.plugin.appbrand.ui.banner.f localf = (com.tencent.mm.plugin.appbrand.ui.banner.f)???.get("StickyBannerChangeListener", null);
        paramString = localf;
        if (localf == null)
        {
          paramString = new com.tencent.mm.plugin.appbrand.ui.banner.f()
          {
            public final void bJ(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(45950);
              String str = localb.getString("appId", "");
              int i = localb.getInt("pkgType", 0);
              if (((!str.equals(paramAnonymousString)) || (i != paramAnonymousInt)) && (localb.JY("setBackgroundAudioState#isPlaying")) && (h.Ud(str) != h.b.kzK))
              {
                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                paramAnonymousString = new JSONObject();
              }
              try
              {
                paramAnonymousString.put("operationType", "pause");
                label90:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.lEa.lAx, JsApiSetBackgroundAudioStateWC.this.lEa.lqe);
                localSetBackgroundAudioStateTask.lEd = paramAnonymousString.toString();
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
          ???.l("pkgType", Integer.valueOf(locall.leE.kNW));
          ???.l("StickyBannerChangeListener", paramString);
          ???.l("appId", paramf.getAppId());
        }
        if ((this.lEa instanceof SetBackgroundAudioListenerTaskWC))
        {
          ((SetBackgroundAudioListenerTaskWC)this.lEa).lEj = paramString;
          ((SetBackgroundAudioListenerTaskWC)this.lEa).lEi = ???;
        }
        AppMethodBeat.o(45956);
        return;
      }
    }
    AppMethodBeat.o(45956);
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(45954);
    paramd = new SetBackgroundAudioStateTaskWC(paramd, paramf, paramInt);
    AppMethodBeat.o(45954);
    return paramd;
  }
  
  public static class SetBackgroundAudioListenerTaskWC
    extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
  {
    private Context context;
    public ad.b lEi;
    public com.tencent.mm.plugin.appbrand.ui.banner.f lEj;
    
    public SetBackgroundAudioListenerTaskWC(com.tencent.mm.plugin.appbrand.jsapi.d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      super(paramf, paramInt);
      AppMethodBeat.i(45951);
      this.context = paramf.getContext();
      AppMethodBeat.o(45951);
    }
    
    protected final void wL(int paramInt)
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
        this.lEi.l("setBackgroundAudioState#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.lEj);
        if (!b.cx(MMApplicationContext.getContext())) {
          AppBrandFloatBallPermissionHelper.a(this.context, 6, null);
        }
        AppMethodBeat.o(45952);
        return;
      case 2: 
      case 3: 
      case 4: 
      case 7: 
        this.lEi.l("setBackgroundAudioState#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.lEj);
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
    public SetBackgroundAudioStateTaskWC(com.tencent.mm.plugin.appbrand.jsapi.d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      super(paramf, paramInt);
    }
    
    public final String Zn(String paramString)
    {
      AppMethodBeat.i(45953);
      paramString = com.tencent.mm.plugin.image.d.aSY() + paramString.hashCode();
      AppMethodBeat.o(45953);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */