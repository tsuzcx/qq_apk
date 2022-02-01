package com.tencent.mm.plugin.auto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(21152);
    a locala = new a();
    AppMethodBeat.o(21152);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(21153);
    com.tencent.mm.plugin.auto.a.c localc = new com.tencent.mm.plugin.auto.a.c();
    AppMethodBeat.o(21153);
    return localc;
  }
  
  public com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.Plugin
 * JD-Core Version:    0.7.0.1
 */