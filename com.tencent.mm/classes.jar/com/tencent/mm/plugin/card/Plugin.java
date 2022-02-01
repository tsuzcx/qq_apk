package com.tencent.mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    return null;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(112557);
    am localam = new am();
    AppMethodBeat.o(112557);
    return localam;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.Plugin
 * JD-Core Version:    0.7.0.1
 */