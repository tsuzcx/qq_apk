package com.tencent.mm.plugin.extaccessories;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(20461);
    a locala = new a();
    AppMethodBeat.o(20461);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(20462);
    b localb = new b();
    AppMethodBeat.o(20462);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.Plugin
 * JD-Core Version:    0.7.0.1
 */