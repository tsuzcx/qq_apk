package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.c;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$j
  implements h.b
{
  public static final j uIm;
  
  static
  {
    AppMethodBeat.i(211967);
    uIm = new j();
    AppMethodBeat.o(211967);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(211966);
    Object localObject = c.uJS;
    localObject = c.cBk();
    AppMethodBeat.o(211966);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.j
 * JD-Core Version:    0.7.0.1
 */