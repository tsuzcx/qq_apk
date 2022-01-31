package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(21216);
    Plugin.1 local1 = new Plugin.1(this);
    AppMethodBeat.o(21216);
    return local1;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(21217);
    Plugin.2 local2 = new Plugin.2(this);
    AppMethodBeat.o(21217);
    return local2;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.Plugin
 * JD-Core Version:    0.7.0.1
 */