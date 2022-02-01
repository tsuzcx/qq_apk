package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  b JFI;
  
  public Plugin()
  {
    AppMethodBeat.i(25326);
    this.JFI = new b();
    AppMethodBeat.o(25326);
  }
  
  public n createApplication()
  {
    return this.JFI;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(25327);
    h localh = h.fRo();
    AppMethodBeat.o(25327);
    return localh;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.Plugin
 * JD-Core Version:    0.7.0.1
 */