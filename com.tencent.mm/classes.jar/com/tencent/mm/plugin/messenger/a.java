package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.ad;

public final class a
  implements b
{
  public final String a(ad paramad, String paramString)
  {
    AppMethodBeat.i(136872);
    paramad = s.a(paramad, paramString);
    AppMethodBeat.o(136872);
    return paramad;
  }
  
  public final String c(ad paramad)
  {
    AppMethodBeat.i(136874);
    paramad = s.c(paramad);
    AppMethodBeat.o(136874);
    return paramad;
  }
  
  public final String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136870);
    paramString1 = s.getDisplayName(paramString1, paramString2);
    AppMethodBeat.o(136870);
    return paramString1;
  }
  
  public final String nD(String paramString)
  {
    AppMethodBeat.i(136873);
    paramString = s.nD(paramString);
    AppMethodBeat.o(136873);
    return paramString;
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(136871);
    paramString = s.nE(paramString);
    AppMethodBeat.o(136871);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */