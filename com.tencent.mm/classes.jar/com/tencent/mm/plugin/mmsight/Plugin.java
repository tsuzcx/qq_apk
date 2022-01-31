package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(76425);
    b localb = new b();
    AppMethodBeat.o(76425);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.Plugin
 * JD-Core Version:    0.7.0.1
 */