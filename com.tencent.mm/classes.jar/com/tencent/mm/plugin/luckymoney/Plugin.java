package com.tencent.mm.plugin.luckymoney;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(64854);
    a locala = new a();
    AppMethodBeat.o(64854);
    return locala;
  }
  
  public final az createSubCore()
  {
    AppMethodBeat.i(64855);
    com.tencent.mm.plugin.luckymoney.b.a locala = new com.tencent.mm.plugin.luckymoney.b.a();
    AppMethodBeat.o(64855);
    return locala;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.Plugin
 * JD-Core Version:    0.7.0.1
 */