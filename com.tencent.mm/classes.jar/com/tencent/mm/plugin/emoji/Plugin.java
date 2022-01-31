package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(52712);
    b localb = new b();
    AppMethodBeat.o(52712);
    return localb;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(52713);
    i locali = new i();
    AppMethodBeat.o(52713);
    return locali;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.Plugin
 * JD-Core Version:    0.7.0.1
 */