package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParserFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "type", "", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g Jlw;
  
  static
  {
    AppMethodBeat.i(266255);
    Jlw = new g();
    AppMethodBeat.o(266255);
  }
  
  public static i Yf(int paramInt)
  {
    AppMethodBeat.i(266250);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(266250);
      return null;
    case 2: 
      locali = (i)new h();
      AppMethodBeat.o(266250);
      return locali;
    case 1: 
      locali = (i)new b();
      AppMethodBeat.o(266250);
      return locali;
    case 3: 
      locali = (i)new e();
      AppMethodBeat.o(266250);
      return locali;
    }
    i locali = (i)new d();
    AppMethodBeat.o(266250);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.g
 * JD-Core Version:    0.7.0.1
 */