package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(108288);
    b localb = new b();
    AppMethodBeat.o(108288);
    return localb;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(108289);
    k localk = new k();
    AppMethodBeat.o(108289);
    return localk;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.Plugin
 * JD-Core Version:    0.7.0.1
 */