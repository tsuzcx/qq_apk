package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"appBrandDebugUIPrecondition", "", "getAppBrandDebugUIPrecondition", "()Z", "plugin-appbrand-integration_release"})
public final class d
{
  public static final boolean cjA()
  {
    AppMethodBeat.i(269892);
    t localt = (t)h.ae(t.class);
    if ((localt != null) && (localt.bFs() == true))
    {
      AppMethodBeat.o(269892);
      return true;
    }
    AppMethodBeat.o(269892);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */