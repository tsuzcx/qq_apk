package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(108288);
    c localc = new c();
    AppMethodBeat.o(108288);
    return localc;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(108289);
    s locals = new s();
    AppMethodBeat.o(108289);
    return locals;
  }
  
  public com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.Plugin
 * JD-Core Version:    0.7.0.1
 */