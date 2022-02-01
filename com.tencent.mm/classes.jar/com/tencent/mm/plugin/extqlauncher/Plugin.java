package com.tencent.mm.plugin.extqlauncher;

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
    AppMethodBeat.i(24548);
    a locala = new a();
    AppMethodBeat.o(24548);
    return locala;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(24547);
    b localb = new b();
    AppMethodBeat.o(24547);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.Plugin
 * JD-Core Version:    0.7.0.1
 */