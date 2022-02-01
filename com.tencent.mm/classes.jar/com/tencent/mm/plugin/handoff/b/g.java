package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParserFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "type", "", "api-handoff_release"})
public final class g
{
  public static final g DrQ;
  
  static
  {
    AppMethodBeat.i(193031);
    DrQ = new g();
    AppMethodBeat.o(193031);
  }
  
  public static i Uj(int paramInt)
  {
    AppMethodBeat.i(193027);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(193027);
      return null;
    case 2: 
      locali = (i)new h();
      AppMethodBeat.o(193027);
      return locali;
    case 1: 
      locali = (i)new b();
      AppMethodBeat.o(193027);
      return locali;
    case 3: 
      locali = (i)new e();
      AppMethodBeat.o(193027);
      return locali;
    }
    i locali = (i)new d();
    AppMethodBeat.o(193027);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.g
 * JD-Core Version:    0.7.0.1
 */