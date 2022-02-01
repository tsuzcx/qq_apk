package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(24334);
    a locala = new a();
    AppMethodBeat.o(24334);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(24333);
    b localb = new b();
    AppMethodBeat.o(24333);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.Plugin
 * JD-Core Version:    0.7.0.1
 */