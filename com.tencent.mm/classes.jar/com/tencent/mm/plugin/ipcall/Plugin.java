package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  b uKd;
  
  public Plugin()
  {
    AppMethodBeat.i(25326);
    this.uKd = new b();
    AppMethodBeat.o(25326);
  }
  
  public n createApplication()
  {
    return this.uKd;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(25327);
    i locali = i.ddE();
    AppMethodBeat.o(25327);
    return locali;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.Plugin
 * JD-Core Version:    0.7.0.1
 */