package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(63301);
    a locala = new a();
    AppMethodBeat.o(63301);
    return locala;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(63302);
    b localb = new b();
    AppMethodBeat.o(63302);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.Plugin
 * JD-Core Version:    0.7.0.1
 */