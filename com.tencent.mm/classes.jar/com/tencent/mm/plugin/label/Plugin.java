package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  public final m createApplication()
  {
    AppMethodBeat.i(26132);
    a locala = new a();
    AppMethodBeat.o(26132);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(26133);
    e locale = new e();
    AppMethodBeat.o(26133);
    return locale;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.Plugin
 * JD-Core Version:    0.7.0.1
 */