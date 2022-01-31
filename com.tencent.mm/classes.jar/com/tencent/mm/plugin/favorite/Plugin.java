package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(20533);
    b localb = new b();
    AppMethodBeat.o(20533);
    return localb;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(20534);
    f localf = new f();
    AppMethodBeat.o(20534);
    return localf;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.Plugin
 * JD-Core Version:    0.7.0.1
 */