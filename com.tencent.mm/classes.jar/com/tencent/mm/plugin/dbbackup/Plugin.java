package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public n createApplication()
  {
    AppMethodBeat.i(23076);
    a locala = new a();
    AppMethodBeat.o(23076);
    return locala;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(23077);
    d locald = new d();
    AppMethodBeat.o(23077);
    return locald;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.Plugin
 * JD-Core Version:    0.7.0.1
 */