package com.tencent.mm.plugin.exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(23141);
    a locala = new a();
    AppMethodBeat.o(23141);
    return locala;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(23142);
    ad localad = new ad();
    AppMethodBeat.o(23142);
    return localad;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.Plugin
 * JD-Core Version:    0.7.0.1
 */