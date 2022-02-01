package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.au;

public final class a
  implements b
{
  public final String ID(String paramString)
  {
    AppMethodBeat.i(90703);
    paramString = aa.ID(paramString);
    AppMethodBeat.o(90703);
    return paramString;
  }
  
  public final String IE(String paramString)
  {
    AppMethodBeat.i(288618);
    paramString = aa.getDisplayName(paramString);
    AppMethodBeat.o(288618);
    return paramString;
  }
  
  public final String IF(String paramString)
  {
    AppMethodBeat.i(168685);
    paramString = aa.IF(paramString);
    AppMethodBeat.o(168685);
    return paramString;
  }
  
  public final String aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90700);
    paramString1 = aa.aV(paramString1, paramString2);
    AppMethodBeat.o(90700);
    return paramString1;
  }
  
  public final String b(au paramau)
  {
    AppMethodBeat.i(90704);
    paramau = aa.b(paramau);
    AppMethodBeat.o(90704);
    return paramau;
  }
  
  public final String b(au paramau, String paramString)
  {
    AppMethodBeat.i(90702);
    paramau = aa.b(paramau, paramString);
    AppMethodBeat.o(90702);
    return paramau;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(90701);
    paramString = aa.getDisplayName(paramString);
    AppMethodBeat.o(90701);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */