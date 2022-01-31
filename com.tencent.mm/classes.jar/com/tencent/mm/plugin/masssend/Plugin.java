package com.tencent.mm.plugin.masssend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  private b jRP;
  
  public Plugin()
  {
    AppMethodBeat.i(22718);
    this.jRP = new Plugin.1(this);
    AppMethodBeat.o(22718);
  }
  
  public o createApplication()
  {
    AppMethodBeat.i(22719);
    a locala = new a();
    AppMethodBeat.o(22719);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(22720);
    h localh = new h();
    AppMethodBeat.o(22720);
    return localh;
  }
  
  public b getContactWidgetFactory()
  {
    return this.jRP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.Plugin
 * JD-Core Version:    0.7.0.1
 */