package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements com.tencent.mm.plugin.appbrand.page.a.b, com.tencent.mm.plugin.appbrand.page.a.d, e.a
{
  private final ad enm;
  private String enx;
  private boolean eny = false;
  private boolean mDestroyed = false;
  
  g(ad paramad, String paramString)
  {
    this.enm = paramad;
    this.enx = paramString;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(177442);
    if (this.mDestroyed)
    {
      Log.w("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", new Object[] { this.enm.getAppId() });
      AppMethodBeat.o(177442);
      return;
    }
    if ((this.enm.qwF == null) || (this.enm.qwF.getOrientationHandler() == null))
    {
      if (parama != null) {
        parama.onOrientationChanged(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    if (this.enm.getRuntime().cbO())
    {
      Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
      if (parama != null) {
        parama.onOrientationChanged(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    e.b localb = e.b.afK(this.enx);
    Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.enm.getAppId(), localb });
    if (localb != null) {
      this.enm.qwF.getOrientationHandler().a(localb, new e.a()
      {
        public final void onOrientationChanged(e.b paramAnonymousb, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(177441);
          g.this.onOrientationChanged(paramAnonymousb, paramAnonymousBoolean);
          if (parama != null) {
            parama.onOrientationChanged(paramAnonymousb, paramAnonymousBoolean);
          }
          AppMethodBeat.o(177441);
        }
      });
    }
    AppMethodBeat.o(177442);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final boolean apZ()
  {
    return false;
  }
  
  public final String aqa()
  {
    return this.enx;
  }
  
  public final void fb(String paramString)
  {
    AppMethodBeat.i(130646);
    Log.e("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.enm.getAppId() });
    AppMethodBeat.o(130646);
  }
  
  public final void onBackground()
  {
    this.eny = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.eny = false;
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(130649);
    this.eny = true;
    if ((this.enm.getFullscreenImpl() != null) && (this.enm.getFullscreenImpl().cHN())) {
      this.enm.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void aqb()
        {
          AppMethodBeat.i(220143);
          g.a(g.this).getFullscreenImpl().b(this);
          if ((!g.b(g.this)) && (g.c(g.this))) {
            g.this.a(null);
          }
          AppMethodBeat.o(220143);
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
  
  public final void onOrientationChanged(e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(177443);
    if (paramb == null) {}
    for (paramb = "null";; paramb = paramb.name())
    {
      Log.i("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(177443);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.g
 * JD-Core Version:    0.7.0.1
 */