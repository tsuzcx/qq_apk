package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  implements com.tencent.mm.plugin.appbrand.page.b.b, com.tencent.mm.plugin.appbrand.page.b.d, e.a
{
  private final aa ckN;
  private String ckX;
  private boolean ckY = false;
  private boolean mDestroyed = false;
  
  g(aa paramaa, String paramString)
  {
    this.ckN = paramaa;
    this.ckX = paramString;
  }
  
  public final boolean Dy()
  {
    return false;
  }
  
  public final String Dz()
  {
    return this.ckX;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(177442);
    if (this.mDestroyed)
    {
      ad.w("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", new Object[] { this.ckN.getAppId() });
      AppMethodBeat.o(177442);
      return;
    }
    if ((this.ckN.jzX == null) || (this.ckN.jzX.getOrientationHandler() == null))
    {
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    if (this.ckN.getRuntime().aWo())
    {
      ad.m("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    e.b localb = e.b.Uf(this.ckX);
    ad.m("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.ckN.getAppId(), localb });
    if (localb != null) {
      this.ckN.jzX.getOrientationHandler().a(localb, new e.a()
      {
        public final void a(e.b paramAnonymousb, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177441);
          g.this.a(paramAnonymousb, paramAnonymousBoolean);
          if (parama != null) {
            parama.a(paramAnonymousb, paramAnonymousBoolean);
          }
          AppMethodBeat.o(177441);
        }
      });
    }
    AppMethodBeat.o(177442);
  }
  
  public final void a(e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(177443);
    if (paramb == null) {}
    for (paramb = "null";; paramb = paramb.name())
    {
      ad.i("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(177443);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(130646);
    ad.e("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.ckN.getAppId() });
    AppMethodBeat.o(130646);
  }
  
  public final void onBackground()
  {
    this.ckY = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.ckY = false;
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(130649);
    this.ckY = true;
    if ((this.ckN.getFullscreenImpl() != null) && (this.ckN.getFullscreenImpl().bwI())) {
      this.ckN.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void DA()
        {
          AppMethodBeat.i(190415);
          g.a(g.this).getFullscreenImpl().b(this);
          if ((!g.b(g.this)) && (g.c(g.this))) {
            g.this.a(null);
          }
          AppMethodBeat.o(190415);
        }
      });
    }
    for (;;)
    {
      a(null);
      AppMethodBeat.o(130649);
      return;
      a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.g
 * JD-Core Version:    0.7.0.1
 */