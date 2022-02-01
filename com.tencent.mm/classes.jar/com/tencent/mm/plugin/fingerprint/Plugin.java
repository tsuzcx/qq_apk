package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    return null;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(64212);
    a locala = new a();
    AppMethodBeat.o(64212);
    return locala;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.Plugin
 * JD-Core Version:    0.7.0.1
 */