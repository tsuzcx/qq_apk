package com.tencent.mm.plugin.collect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    return null;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(40905);
    a locala = new a();
    AppMethodBeat.o(40905);
    return locala;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.Plugin
 * JD-Core Version:    0.7.0.1
 */