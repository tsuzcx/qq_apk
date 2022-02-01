package com.tencent.mm.plugin.login_exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(231726);
    a locala = new a();
    AppMethodBeat.o(231726);
    return locala;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(231727);
    b localb = new b();
    AppMethodBeat.o(231727);
    return localb;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.Plugin
 * JD-Core Version:    0.7.0.1
 */