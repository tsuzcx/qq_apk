package com.tencent.mm.plugin.login_exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(262323);
    a locala = new a();
    AppMethodBeat.o(262323);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(262335);
    b localb = new b();
    AppMethodBeat.o(262335);
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