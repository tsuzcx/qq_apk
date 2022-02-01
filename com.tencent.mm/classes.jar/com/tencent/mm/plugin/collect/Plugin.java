package com.tencent.mm.plugin.collect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    return null;
  }
  
  public final ax createSubCore()
  {
    AppMethodBeat.i(63756);
    a locala = new a();
    AppMethodBeat.o(63756);
    return locala;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.Plugin
 * JD-Core Version:    0.7.0.1
 */