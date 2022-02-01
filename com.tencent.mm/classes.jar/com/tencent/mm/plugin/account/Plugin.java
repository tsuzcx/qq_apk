package com.tencent.mm.plugin.account;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(127753);
    a locala = new a();
    AppMethodBeat.o(127753);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.Plugin
 * JD-Core Version:    0.7.0.1
 */