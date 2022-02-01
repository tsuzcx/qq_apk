package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC
  extends JsApiSetBackgroundAudioState
{
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(45955);
    paramc = new SetBackgroundAudioListenerTaskWC(paramc, paramf, paramInt);
    AppMethodBeat.o(45955);
    return paramc;
  }
  
  protected final JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(45954);
    paramc = new SetBackgroundAudioStateTaskWC(paramc, paramf, paramInt);
    AppMethodBeat.o(45954);
    return paramc;
  }
  
  protected final void b(final String paramString, com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(45956);
    if (this.rDu != null)
    {
      Object localObject = this.rDu;
      if ((paramf instanceof g)) {
        ((g)paramf).getRuntime().qsB.a(new c.a()
        {
          public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
          {
            AppMethodBeat.i(327784);
            if (com.tencent.mm.plugin.appbrand.b.b.qKz == paramAnonymousb)
            {
              this.rvG.cpx();
              paramAnonymousString = ad.bCb().Jn(paramString);
              if (paramAnonymousString != null) {
                paramAnonymousString.recycle();
              }
            }
            AppMethodBeat.o(327784);
          }
        });
      }
      n localn = (n)paramf.aN(n.class);
      this.rDu.hJK = localn.qYY.qHO;
      this.rDu.hEy = localn.hEy;
      this.rDu.appUserName = AppBrandRuntimeWCAccessible.d(paramf);
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[] { Integer.valueOf(this.rDu.hJK), this.rDu.hEy, this.rDu.appUserName });
      synchronized (ad.bCb().M(paramString, true))
      {
        localObject = (com.tencent.mm.plugin.appbrand.ui.banner.f)???.get("StickyBannerChangeListener", null);
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramString = new com.tencent.mm.plugin.appbrand.ui.banner.f()
          {
            public final void cB(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(327785);
              String str = localb.getString("appId", "");
              int i = localb.getInt("pkgType", 0);
              if (((!str.equals(paramAnonymousString)) || (i != paramAnonymousInt)) && (localb.Jp("setBackgroundAudioState#isPlaying")) && (k.Up(str) != k.b.qrB))
              {
                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                paramAnonymousString = new JSONObject();
              }
              try
              {
                paramAnonymousString.put("operationType", "pause");
                label90:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.rDu.rzi, JsApiSetBackgroundAudioStateWC.this.rDu.ror);
                localSetBackgroundAudioStateTask.rDx = paramAnonymousString.toString();
                localSetBackgroundAudioStateTask.appId = str;
                localSetBackgroundAudioStateTask.bQt();
                AppMethodBeat.o(327785);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label90;
              }
            }
          };
          ???.q("pkgType", Integer.valueOf(localn.qYY.qHO));
          ???.q("StickyBannerChangeListener", paramString);
          ???.q("appId", paramf.getAppId());
        }
        if ((this.rDu instanceof SetBackgroundAudioListenerTaskWC))
        {
          ((SetBackgroundAudioListenerTaskWC)this.rDu).rDD = paramString;
          ((SetBackgroundAudioListenerTaskWC)this.rDu).rDC = ???;
        }
        AppMethodBeat.o(45956);
        return;
      }
    }
    AppMethodBeat.o(45956);
  }
  
  public static class SetBackgroundAudioListenerTaskWC
    extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
  {
    private Context context;
    public ad.b rDC;
    public com.tencent.mm.plugin.appbrand.ui.banner.f rDD;
    
    public SetBackgroundAudioListenerTaskWC(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      super(paramf, paramInt);
      AppMethodBeat.i(45951);
      this.context = paramf.getContext();
      AppMethodBeat.o(45951);
    }
    
    protected final void Ar(int paramInt)
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
        this.rDC.q("setBackgroundAudioState#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.rDD);
        if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext())) {
          AppBrandFloatBallPermissionHelper.a(this.context, 6, null);
        }
        AppMethodBeat.o(45952);
        return;
      case 2: 
      case 3: 
      case 4: 
      case 7: 
        this.rDC.q("setBackgroundAudioState#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.rDD);
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
    public SetBackgroundAudioStateTaskWC(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      super(paramf, paramInt);
    }
    
    public final String ZY(String paramString)
    {
      AppMethodBeat.i(45953);
      paramString = d.bzL() + paramString.hashCode();
      AppMethodBeat.o(45953);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC
 * JD-Core Version:    0.7.0.1
 */