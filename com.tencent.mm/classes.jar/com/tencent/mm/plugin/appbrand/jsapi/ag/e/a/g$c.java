package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.al;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
public final class g$c
  extends al
{
  public final boolean c(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(139698);
    p.h(paramKeyEvent, "event");
    if (1 == paramKeyEvent.getAction())
    {
      AppMethodBeat.o(139698);
      return false;
    }
    paramKeyEvent = g.c(this.mLZ);
    if (paramKeyEvent != null) {
      paramKeyEvent.invoke(null, Integer.valueOf(0));
    }
    this.mLZ.bMo();
    AppMethodBeat.o(139698);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.g.c
 * JD-Core Version:    0.7.0.1
 */