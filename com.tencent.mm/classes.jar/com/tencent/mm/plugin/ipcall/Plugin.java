package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  b nLO;
  
  public Plugin()
  {
    AppMethodBeat.i(21703);
    this.nLO = new b();
    AppMethodBeat.o(21703);
  }
  
  public o createApplication()
  {
    return this.nLO;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(21704);
    i locali = i.bJm();
    AppMethodBeat.o(21704);
    return locali;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.Plugin
 * JD-Core Version:    0.7.0.1
 */