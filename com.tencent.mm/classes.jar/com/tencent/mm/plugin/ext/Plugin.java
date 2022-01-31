package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(20260);
    a locala = new a();
    AppMethodBeat.o(20260);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(20259);
    b localb = new b();
    AppMethodBeat.o(20259);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.Plugin
 * JD-Core Version:    0.7.0.1
 */