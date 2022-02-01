package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  public final n createApplication()
  {
    AppMethodBeat.i(26132);
    a locala = new a();
    AppMethodBeat.o(26132);
    return locala;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(26133);
    d locald = new d();
    AppMethodBeat.o(26133);
    return locald;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.Plugin
 * JD-Core Version:    0.7.0.1
 */