package com.tencent.mm.plugin.luckymoney;

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
    AppMethodBeat.i(41965);
    a locala = new a();
    AppMethodBeat.o(41965);
    return locala;
  }
  
  public final at createSubCore()
  {
    AppMethodBeat.i(41966);
    com.tencent.mm.plugin.luckymoney.b.a locala = new com.tencent.mm.plugin.luckymoney.b.a();
    AppMethodBeat.o(41966);
    return locala;
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.Plugin
 * JD-Core Version:    0.7.0.1
 */