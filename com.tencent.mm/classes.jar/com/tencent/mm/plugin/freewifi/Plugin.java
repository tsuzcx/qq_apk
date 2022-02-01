package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(24699);
    g localg = new g();
    AppMethodBeat.o(24699);
    return localg;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(24700);
    j localj = new j();
    AppMethodBeat.o(24700);
    return localj;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.Plugin
 * JD-Core Version:    0.7.0.1
 */