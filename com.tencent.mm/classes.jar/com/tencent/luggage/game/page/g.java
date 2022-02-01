package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  implements com.tencent.mm.plugin.appbrand.page.b.b, com.tencent.mm.plugin.appbrand.page.b.d, e.a
{
  private String caG;
  private boolean caH = false;
  private final aa caw;
  private boolean mDestroyed = false;
  
  g(aa paramaa, String paramString)
  {
    this.caw = paramaa;
    this.caG = paramString;
  }
  
  public final boolean BZ()
  {
    return false;
  }
  
  public final String Ca()
  {
    return this.caG;
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(177442);
    if (this.mDestroyed)
    {
      ac.w("Luggage.WAGamePageViewOrientationExtensionImpl", "resetPageOrientation but destroyed, appId:%s", new Object[] { this.caw.getAppId() });
      AppMethodBeat.o(177442);
      return;
    }
    if ((this.caw.jgX == null) || (this.caw.jgX.getOrientationHandler() == null))
    {
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    if (this.caw.getRuntime().aTe())
    {
      ac.m("Luggage.WAGamePageViewOrientationExtensionImpl", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
      if (parama != null) {
        parama.a(null, false);
      }
      AppMethodBeat.o(177442);
      return;
    }
    e.b localb = e.b.Qz(this.caG);
    ac.m("Luggage.WAGamePageViewOrientationExtensionImpl", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.caw.getAppId(), localb });
    if (localb != null) {
      this.caw.jgX.getOrientationHandler().a(localb, new e.a()
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
      ac.i("Luggage.WAGamePageViewOrientationExtensionImpl", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(177443);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void cc(String paramString)
  {
    AppMethodBeat.i(130646);
    ac.e("Luggage.WAGamePageViewOrientationExtensionImpl", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.caw.getAppId() });
    AppMethodBeat.o(130646);
  }
  
  public final void onBackground()
  {
    this.caH = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy()
  {
    this.caH = false;
    this.mDestroyed = true;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(130649);
    this.caH = true;
    if ((this.caw.getFullscreenImpl() != null) && (this.caw.getFullscreenImpl().bsE())) {
      this.caw.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.r.a.b()
      {
        public final void Cb()
        {
          AppMethodBeat.i(206106);
          g.a(g.this).getFullscreenImpl().b(this);
          if ((!g.b(g.this)) && (g.c(g.this))) {
            g.this.a(null);
          }
          AppMethodBeat.o(206106);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.g
 * JD-Core Version:    0.7.0.1
 */