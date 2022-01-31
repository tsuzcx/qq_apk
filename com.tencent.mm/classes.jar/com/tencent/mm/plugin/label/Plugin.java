package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin
  implements c
{
  public final o createApplication()
  {
    AppMethodBeat.i(22509);
    a locala = new a();
    AppMethodBeat.o(22509);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(22510);
    e locale = new e();
    AppMethodBeat.o(22510);
    return locale;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.Plugin
 * JD-Core Version:    0.7.0.1
 */