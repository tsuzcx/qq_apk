package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.a;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.page.b.c;
import com.tencent.mm.plugin.appbrand.page.v;

public final class g
  implements a.a, com.tencent.mm.plugin.appbrand.page.b.a, c
{
  private final v bBK;
  private String bBU;
  
  g(v paramv, String paramString)
  {
    this.bBK = paramv;
    this.bBU = paramString;
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(140503);
    if (paramb == null) {}
    for (paramb = "null";; paramb = paramb.name())
    {
      d.i("Luggage.WAGamePageViewOrientationExtensionImpl", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(140503);
      return;
    }
  }
  
  public final void bW(String paramString)
  {
    AppMethodBeat.i(140502);
    d.e("Luggage.WAGamePageViewOrientationExtensionImpl", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.bBK.getAppId() });
    AppMethodBeat.o(140502);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(140504);
    if (com.tencent.mm.sdk.f.a.hr(this.bBK.mContext) != null)
    {
      a.b localb = com.tencent.mm.plugin.appbrand.config.a.a.zX(this.bBU);
      d.i("Luggage.WAGamePageViewOrientationExtensionImpl", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.bBK.getAppId(), localb });
      if (localb != null) {
        com.tencent.mm.plugin.appbrand.config.a.a.s(com.tencent.mm.sdk.f.a.hr(this.bBK.mContext)).a(localb, this);
      }
    }
    AppMethodBeat.o(140504);
  }
  
  public final boolean vy()
  {
    return false;
  }
  
  public final String vz()
  {
    return this.bBU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.g
 * JD-Core Version:    0.7.0.1
 */