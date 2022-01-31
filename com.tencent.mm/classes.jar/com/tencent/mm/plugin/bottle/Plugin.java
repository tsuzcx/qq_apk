package com.tencent.mm.plugin.bottle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  private b jRP;
  
  public Plugin()
  {
    AppMethodBeat.i(18529);
    this.jRP = new Plugin.1(this);
    AppMethodBeat.o(18529);
  }
  
  public final o createApplication()
  {
    AppMethodBeat.i(18530);
    a locala = new a();
    AppMethodBeat.o(18530);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(18531);
    d locald = new d();
    AppMethodBeat.o(18531);
    return locald;
  }
  
  public final b getContactWidgetFactory()
  {
    return this.jRP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.Plugin
 * JD-Core Version:    0.7.0.1
 */