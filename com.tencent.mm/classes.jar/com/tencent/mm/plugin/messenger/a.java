package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.an;

public final class a
  implements b
{
  public final String b(an paraman)
  {
    AppMethodBeat.i(90704);
    paraman = w.b(paraman);
    AppMethodBeat.o(90704);
    return paraman;
  }
  
  public final String b(an paraman, String paramString)
  {
    AppMethodBeat.i(90702);
    paraman = w.b(paraman, paramString);
    AppMethodBeat.o(90702);
    return paraman;
  }
  
  public final String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90700);
    paramString1 = w.getDisplayName(paramString1, paramString2);
    AppMethodBeat.o(90700);
    return paramString1;
  }
  
  public final String zO(String paramString)
  {
    AppMethodBeat.i(90703);
    paramString = w.zO(paramString);
    AppMethodBeat.o(90703);
    return paramString;
  }
  
  public final String zP(String paramString)
  {
    AppMethodBeat.i(90701);
    paramString = w.zP(paramString);
    AppMethodBeat.o(90701);
    return paramString;
  }
  
  public final String zR(String paramString)
  {
    AppMethodBeat.i(168685);
    paramString = w.zR(paramString);
    AppMethodBeat.o(168685);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */