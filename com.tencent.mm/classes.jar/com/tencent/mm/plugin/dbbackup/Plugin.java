package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  public n createApplication()
  {
    AppMethodBeat.i(23076);
    a locala = new a();
    AppMethodBeat.o(23076);
    return locala;
  }
  
  public be createSubCore()
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