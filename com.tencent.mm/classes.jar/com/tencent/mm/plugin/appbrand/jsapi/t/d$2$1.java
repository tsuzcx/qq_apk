package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class d$2$1
  implements MTimerHandler.CallBack
{
  d$2$1(d.2 param2, View paramView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(138265);
    View localView = this.mom;
    if (localView != null)
    {
      localView.setVisibility(8);
      if (ViewGroup.class.isInstance(localView.getParent())) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
    }
    Log.i("MicroMsg.JsApiShowToast", "on timer expired!");
    AppMethodBeat.o(138265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.d.2.1
 * JD-Core Version:    0.7.0.1
 */