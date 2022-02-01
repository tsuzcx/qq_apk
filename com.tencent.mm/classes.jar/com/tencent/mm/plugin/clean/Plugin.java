package com.tencent.mm.plugin.clean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.clean.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  public n createApplication()
  {
    AppMethodBeat.i(22759);
    a locala = new a();
    AppMethodBeat.o(22759);
    return locala;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(22760);
    com.tencent.mm.plugin.clean.c.d locald = com.tencent.mm.plugin.clean.c.d.cyM();
    AppMethodBeat.o(22760);
    return locald;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.Plugin
 * JD-Core Version:    0.7.0.1
 */