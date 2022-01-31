package com.tencent.mm.plugin.exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(19033);
    a locala = new a();
    AppMethodBeat.o(19033);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(19034);
    ad localad = new ad();
    AppMethodBeat.o(19034);
    return localad;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.Plugin
 * JD-Core Version:    0.7.0.1
 */