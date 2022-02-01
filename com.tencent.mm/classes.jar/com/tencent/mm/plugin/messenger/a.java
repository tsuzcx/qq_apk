package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.af;

public final class a
  implements b
{
  public final String b(af paramaf)
  {
    AppMethodBeat.i(90704);
    paramaf = v.b(paramaf);
    AppMethodBeat.o(90704);
    return paramaf;
  }
  
  public final String b(af paramaf, String paramString)
  {
    AppMethodBeat.i(90702);
    paramaf = v.b(paramaf, paramString);
    AppMethodBeat.o(90702);
    return paramaf;
  }
  
  public final String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90700);
    paramString1 = v.getDisplayName(paramString1, paramString2);
    AppMethodBeat.o(90700);
    return paramString1;
  }
  
  public final String sg(String paramString)
  {
    AppMethodBeat.i(90703);
    paramString = v.sg(paramString);
    AppMethodBeat.o(90703);
    return paramString;
  }
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(90701);
    paramString = v.sh(paramString);
    AppMethodBeat.o(90701);
    return paramString;
  }
  
  public final String sj(String paramString)
  {
    AppMethodBeat.i(168685);
    paramString = v.sj(paramString);
    AppMethodBeat.o(168685);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */