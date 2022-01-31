package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(13800);
    b localb = new b();
    AppMethodBeat.o(13800);
    return localb;
  }
  
  public at createSubCore()
  {
    return null;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.Plugin
 * JD-Core Version:    0.7.0.1
 */