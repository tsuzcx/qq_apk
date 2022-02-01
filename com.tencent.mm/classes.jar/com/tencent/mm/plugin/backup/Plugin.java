package com.tencent.mm.plugin.backup;

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
    AppMethodBeat.i(21163);
    a locala = new a();
    AppMethodBeat.o(21163);
    return locala;
  }
  
  public az createSubCore()
  {
    return null;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.Plugin
 * JD-Core Version:    0.7.0.1
 */