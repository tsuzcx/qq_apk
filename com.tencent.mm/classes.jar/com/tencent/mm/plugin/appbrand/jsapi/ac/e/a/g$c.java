package com.tencent.mm.plugin.appbrand.jsapi.ac.e.a;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aj;
import d.g.a.m;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
public final class g$c
  extends aj
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
    paramKeyEvent = g.c(this.lzS);
    if (paramKeyEvent != null) {
      paramKeyEvent.p(null, Integer.valueOf(0));
    }
    this.lzS.bpT();
    AppMethodBeat.o(139698);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.g.c
 * JD-Core Version:    0.7.0.1
 */