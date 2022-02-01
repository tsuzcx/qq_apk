package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

@Deprecated
public final class Plugin
  implements d
{
  public final m createApplication()
  {
    return null;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(43979);
    j localj = new j();
    AppMethodBeat.o(43979);
    return localj;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.Plugin
 * JD-Core Version:    0.7.0.1
 */