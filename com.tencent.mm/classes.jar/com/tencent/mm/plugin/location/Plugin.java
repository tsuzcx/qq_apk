package com.tencent.mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;

public class Plugin
  implements d
{
  public com.tencent.mm.pluginsdk.n createApplication()
  {
    AppMethodBeat.i(55666);
    a locala = new a();
    AppMethodBeat.o(55666);
    return locala;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(55667);
    com.tencent.mm.plugin.location.model.n localn = new com.tencent.mm.plugin.location.model.n();
    AppMethodBeat.o(55667);
    return localn;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.Plugin
 * JD-Core Version:    0.7.0.1
 */