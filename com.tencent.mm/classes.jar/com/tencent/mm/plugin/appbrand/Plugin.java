package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

@Deprecated
public final class Plugin
  implements d
{
  public final n createApplication()
  {
    return null;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(43979);
    m localm = new m();
    AppMethodBeat.o(43979);
    return localm;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.Plugin
 * JD-Core Version:    0.7.0.1
 */