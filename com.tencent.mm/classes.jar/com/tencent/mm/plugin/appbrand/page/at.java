package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;

public final class at
  implements com.tencent.mm.plugin.appbrand.page.b.a, com.tencent.mm.plugin.appbrand.page.b.c
{
  private final v bBK;
  volatile String bBU;
  private a.b iza;
  final com.tencent.luggage.sdk.b.a.b.c izb;
  private boolean mDestroyed;
  
  at(v paramv)
  {
    AppMethodBeat.i(140878);
    this.iza = null;
    this.mDestroyed = false;
    this.bBK = paramv;
    this.izb = new com.tencent.luggage.sdk.b.a.b.c(paramv);
    this.bBK.ivI.addOnLayoutChangeListener(new at.1(this));
    if (com.tencent.mm.sdk.f.a.hr(paramv.mContext) != null) {
      this.iza = com.tencent.mm.plugin.appbrand.config.a.a.s(com.tencent.mm.sdk.f.a.hr(paramv.mContext)).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
    }
    AppMethodBeat.o(140878);
  }
  
  private void aJM()
  {
    AppMethodBeat.i(140882);
    if (!al.isMainThread())
    {
      this.bBK.A(new at.3(this));
      AppMethodBeat.o(140882);
      return;
    }
    Object localObject = com.tencent.mm.sdk.f.a.hr(this.bBK.mContext);
    if (localObject == null)
    {
      AppMethodBeat.o(140882);
      return;
    }
    if ((a.b.hkG == com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK())) && (((com.tencent.luggage.sdk.config.a)this.bBK.U(com.tencent.luggage.sdk.config.a.class)).bCP))
    {
      com.tencent.luggage.g.d.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.bBK.getAppId(), this.bBK.hzM });
      AppMethodBeat.o(140882);
      return;
    }
    at.4 local4 = new at.4(this);
    com.tencent.luggage.g.d.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { this.bBK.getAppId(), this.bBK.hzM, this.bBU });
    String str = bo.bf(this.bBU, "portrait");
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        localObject = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.bBK.getAppId(), this.bBK.hzM, this.bBU });
        if (!this.bBK.gPS) {
          break label458;
        }
        localObject = new IllegalArgumentException((String)localObject);
        AppMethodBeat.o(140882);
        throw ((Throwable)localObject);
        if (str.equals("auto"))
        {
          i = 0;
          continue;
          if (str.equals("landscape"))
          {
            i = 1;
            continue;
            if (str.equals("portrait"))
            {
              i = 2;
              continue;
              if (str.equals("landscapeLeft")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).a(a.b.hkE, local4);
    AppMethodBeat.o(140882);
    return;
    com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).a(a.b.hkG, local4);
    AppMethodBeat.o(140882);
    return;
    com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).a(a.b.hkD, local4);
    AppMethodBeat.o(140882);
    return;
    com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).a(a.b.hkH, local4);
    AppMethodBeat.o(140882);
    return;
    label458:
    com.tencent.luggage.g.d.e("Luggage.MPPageViewOrientationExtensionImpl", (String)localObject);
    AppMethodBeat.o(140882);
  }
  
  public final void bW(String paramString)
  {
    AppMethodBeat.i(140880);
    this.bBU = paramString;
    aJM();
    AppMethodBeat.o(140880);
  }
  
  public final void m(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140881);
    if (!al.isMainThread())
    {
      this.bBK.runOnUiThread(new at.2(this, paramString, paramMap));
      AppMethodBeat.o(140881);
      return;
    }
    com.tencent.luggage.sdk.b.a.b.c localc = this.izb;
    if (paramMap != null) {
      localc.bEs.putAll(paramMap);
    }
    bW(paramString);
    AppMethodBeat.o(140881);
  }
  
  public final void onBackground()
  {
    this.izb.foreground = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(140883);
    aJM();
    com.tencent.luggage.sdk.b.a.b.c localc = this.izb;
    if (localc.bEp)
    {
      com.tencent.luggage.g.d.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { localc.bBK.getAppId(), localc.bBK.hzM });
      localc.wv();
      localc.bEp = false;
    }
    localc.foreground = true;
    AppMethodBeat.o(140883);
  }
  
  public final boolean vy()
  {
    AppMethodBeat.i(140879);
    Object localObject = com.tencent.mm.sdk.f.a.hr(this.bBK.mContext);
    a.b localb;
    if (localObject != null)
    {
      localb = com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
      localObject = com.tencent.mm.plugin.appbrand.config.a.a.zX(this.bBU);
      com.tencent.luggage.g.d.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { this.bBK.getAppId(), this.bBK.hzM, localb, localObject });
      if (a.b.hkE != localObject)
      {
        if ((a.b.hkG != localb) || (!((com.tencent.luggage.sdk.config.a)this.bBK.U(com.tencent.luggage.sdk.config.a.class)).bCP)) {
          break label162;
        }
        com.tencent.luggage.g.d.i("Luggage.MPPageViewOrientationExtensionImpl", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { this.bBK.getAppId(), this.bBK.hzM });
      }
    }
    label162:
    label184:
    for (;;)
    {
      boolean bool = false;
      this.izb.bEt = bool;
      AppMethodBeat.o(140879);
      return bool;
      if (localObject == null) {
        localObject = a.b.hkD;
      }
      for (;;)
      {
        if (localb.c((a.b)localObject)) {
          break label184;
        }
        bool = true;
        break;
      }
    }
  }
  
  public final String vz()
  {
    return this.bBU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at
 * JD-Core Version:    0.7.0.1
 */