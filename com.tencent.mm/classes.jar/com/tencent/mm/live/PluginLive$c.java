package com.tencent.mm.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginLive$c
  implements h.b
{
  public static final c gIP;
  
  static
  {
    AppMethodBeat.i(215607);
    gIP = new c();
    AppMethodBeat.o(215607);
  }
  
  public final String[] getSQLs()
  {
    return c.SQL_CREATE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive.c
 * JD-Core Version:    0.7.0.1
 */