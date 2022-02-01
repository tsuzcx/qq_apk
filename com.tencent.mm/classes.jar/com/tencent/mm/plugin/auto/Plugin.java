package com.tencent.mm.plugin.auto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(21152);
    a locala = new a();
    AppMethodBeat.o(21152);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(21153);
    b localb = new b();
    AppMethodBeat.o(21153);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.Plugin
 * JD-Core Version:    0.7.0.1
 */