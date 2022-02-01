package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParserFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "type", "", "api-handoff_release"})
public final class g
{
  public static final g yhO;
  
  static
  {
    AppMethodBeat.i(238086);
    yhO = new g();
    AppMethodBeat.o(238086);
  }
  
  public static i OJ(int paramInt)
  {
    AppMethodBeat.i(238085);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(238085);
      return null;
    case 2: 
      locali = (i)new h();
      AppMethodBeat.o(238085);
      return locali;
    case 1: 
      locali = (i)new b();
      AppMethodBeat.o(238085);
      return locali;
    case 3: 
      locali = (i)new e();
      AppMethodBeat.o(238085);
      return locali;
    }
    i locali = (i)new d();
    AppMethodBeat.o(238085);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.g
 * JD-Core Version:    0.7.0.1
 */