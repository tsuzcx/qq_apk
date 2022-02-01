package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  b szG;
  
  public Plugin()
  {
    AppMethodBeat.i(25326);
    this.szG = new b();
    AppMethodBeat.o(25326);
  }
  
  public m createApplication()
  {
    return this.szG;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(25327);
    i locali = i.cHi();
    AppMethodBeat.o(25327);
    return locali;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.Plugin
 * JD-Core Version:    0.7.0.1
 */