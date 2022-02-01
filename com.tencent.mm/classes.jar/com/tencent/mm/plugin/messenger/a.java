package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.as;

public final class a
  implements b
{
  public final String PI(String paramString)
  {
    AppMethodBeat.i(90703);
    paramString = aa.PI(paramString);
    AppMethodBeat.o(90703);
    return paramString;
  }
  
  public final String PJ(String paramString)
  {
    AppMethodBeat.i(90701);
    paramString = aa.PJ(paramString);
    AppMethodBeat.o(90701);
    return paramString;
  }
  
  public final String PL(String paramString)
  {
    AppMethodBeat.i(168685);
    paramString = aa.PL(paramString);
    AppMethodBeat.o(168685);
    return paramString;
  }
  
  public final String aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90700);
    paramString1 = aa.aL(paramString1, paramString2);
    AppMethodBeat.o(90700);
    return paramString1;
  }
  
  public final String b(as paramas)
  {
    AppMethodBeat.i(90704);
    paramas = aa.b(paramas);
    AppMethodBeat.o(90704);
    return paramas;
  }
  
  public final String b(as paramas, String paramString)
  {
    AppMethodBeat.i(90702);
    paramas = aa.b(paramas, paramString);
    AppMethodBeat.o(90702);
    return paramas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */