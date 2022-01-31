package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

@Deprecated
public final class Plugin
  implements c
{
  public final o createApplication()
  {
    return null;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(129143);
    g localg = new g();
    AppMethodBeat.o(129143);
    return localg;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.Plugin
 * JD-Core Version:    0.7.0.1
 */