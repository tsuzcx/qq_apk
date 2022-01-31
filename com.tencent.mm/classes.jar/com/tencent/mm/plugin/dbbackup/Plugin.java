package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(18967);
    a locala = new a();
    AppMethodBeat.o(18967);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(18968);
    d locald = new d();
    AppMethodBeat.o(18968);
    return locald;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.Plugin
 * JD-Core Version:    0.7.0.1
 */