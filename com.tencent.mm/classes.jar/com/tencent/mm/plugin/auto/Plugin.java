package com.tencent.mm.plugin.auto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(17099);
    a locala = new a();
    AppMethodBeat.o(17099);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(17100);
    com.tencent.mm.plugin.auto.a.b localb = new com.tencent.mm.plugin.auto.a.b();
    AppMethodBeat.o(17100);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.Plugin
 * JD-Core Version:    0.7.0.1
 */