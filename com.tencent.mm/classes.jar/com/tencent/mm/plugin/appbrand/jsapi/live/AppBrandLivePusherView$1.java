package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.t.a;
import com.tencent.mm.plugin.appbrand.t.t.b;

final class AppBrandLivePusherView$1
  implements t.b
{
  AppBrandLivePusherView$1(AppBrandLivePusherView paramAppBrandLivePusherView) {}
  
  public final void a(t.a parama1, t.a parama2)
  {
    AppMethodBeat.i(96055);
    int i;
    switch (AppBrandLivePusherView.2.bGL[parama2.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      parama1 = AppBrandLivePusherView.a(this.hNB);
      parama1.number = 0;
      AppBrandLivePusherView.b(parama1.hNB).removeCallbacks(parama1);
      AppBrandLivePusherView.a(this.hNB).bGN = i;
      parama1 = AppBrandLivePusherView.a(this.hNB);
      AppBrandLivePusherView.b(parama1.hNB).postDelayed(parama1, 250L);
      AppMethodBeat.o(96055);
      return;
      i = 1;
      continue;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.1
 * JD-Core Version:    0.7.0.1
 */