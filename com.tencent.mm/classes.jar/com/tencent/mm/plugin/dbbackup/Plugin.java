package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public m createApplication()
  {
    AppMethodBeat.i(23076);
    a locala = new a();
    AppMethodBeat.o(23076);
    return locala;
  }
  
  public aw createSubCore()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.Plugin
 * JD-Core Version:    0.7.0.1
 */