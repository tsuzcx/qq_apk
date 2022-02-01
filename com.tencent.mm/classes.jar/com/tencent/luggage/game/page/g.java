package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements com.tencent.mm.plugin.appbrand.page.a.b, com.tencent.mm.plugin.appbrand.page.a.d, e.a
{
  private final ac cwK;
  private String cwU;
  private boolean cwV = false;
  private boolean mDestroyed = false;
  
  g(ac paramac, String paramString)
  {
    this.cwK = paramac;
    this.cwU = paramString;
  }
  
  public final boolean MY()
  {
    return false;
  }
  
  public final String MZ()
  {
    return this.cwU;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(177442);
    if (this.mDestroyed)
    {
      Log.w("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", new Object[] { this.cwK.getAppId() });
      AppMethodBeat.o(177442);
      return;
    }
    if ((this.cwK.kEb == null) || (this.cwK.kEb.getOrientationHandler() == null))
    {
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    if (this.cwK.getRuntime().brM())
    {
      Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    e.b localb = e.b.aeE(this.cwU);
    Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.cwK.getAppId(), localb });
    if (localb != null) {
      this.cwK.kEb.getOrientationHandler().a(localb, new e.a()
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
      Log.i("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(177443);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void dx(String paramString)
  {
    AppMethodBeat.i(130646);
    Log.e("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.cwK.getAppId() });
    AppMethodBeat.o(130646);
  }
  
  public final void onBackground()
  {
    this.cwV = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.cwV = false;
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(130649);
    this.cwV = true;
    if ((this.cwK.getFullscreenImpl() != null) && (this.cwK.getFullscreenImpl().bTK())) {
      this.cwK.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b()
      {
        public final void Na()
        {
          AppMethodBeat.i(222888);
          g.a(g.this).getFullscreenImpl().b(this);
          if ((!g.b(g.this)) && (g.c(g.this))) {
            g.this.a(null);
          }
          AppMethodBeat.o(222888);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.g
 * JD-Core Version:    0.7.0.1
 */