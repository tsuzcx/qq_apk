package com.tencent.mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(55666);
    a locala = new a();
    AppMethodBeat.o(55666);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(55667);
    n localn = new n();
    AppMethodBeat.o(55667);
    return localn;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.Plugin
 * JD-Core Version:    0.7.0.1
 */