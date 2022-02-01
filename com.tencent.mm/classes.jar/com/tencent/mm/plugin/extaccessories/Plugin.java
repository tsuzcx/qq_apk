package com.tencent.mm.plugin.extaccessories;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(24538);
    a locala = new a();
    AppMethodBeat.o(24538);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(24539);
    b localb = new b();
    AppMethodBeat.o(24539);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.Plugin
 * JD-Core Version:    0.7.0.1
 */