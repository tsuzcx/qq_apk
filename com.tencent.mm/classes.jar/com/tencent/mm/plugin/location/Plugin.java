package com.tencent.mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(113287);
    a locala = new a();
    AppMethodBeat.o(113287);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(113288);
    l locall = new l();
    AppMethodBeat.o(113288);
    return locall;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.Plugin
 * JD-Core Version:    0.7.0.1
 */