package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class d$2$1
  implements av.a
{
  d$2$1(d.2 param2, View paramView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(138265);
    View localView = this.leU;
    if (localView != null)
    {
      localView.setVisibility(8);
      if (ViewGroup.class.isInstance(localView.getParent())) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
    }
    ad.i("MicroMsg.JsApiShowToast", "on timer expired!");
    AppMethodBeat.o(138265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d.2.1
 * JD-Core Version:    0.7.0.1
 */