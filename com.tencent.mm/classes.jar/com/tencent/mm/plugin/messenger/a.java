package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.am;

public final class a
  implements b
{
  public final String b(am paramam)
  {
    AppMethodBeat.i(90704);
    paramam = v.b(paramam);
    AppMethodBeat.o(90704);
    return paramam;
  }
  
  public final String b(am paramam, String paramString)
  {
    AppMethodBeat.i(90702);
    paramam = v.b(paramam, paramString);
    AppMethodBeat.o(90702);
    return paramam;
  }
  
  public final String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90700);
    paramString1 = v.getDisplayName(paramString1, paramString2);
    AppMethodBeat.o(90700);
    return paramString1;
  }
  
  public final String ze(String paramString)
  {
    AppMethodBeat.i(90703);
    paramString = v.ze(paramString);
    AppMethodBeat.o(90703);
    return paramString;
  }
  
  public final String zf(String paramString)
  {
    AppMethodBeat.i(90701);
    paramString = v.zf(paramString);
    AppMethodBeat.o(90701);
    return paramString;
  }
  
  public final String zh(String paramString)
  {
    AppMethodBeat.i(168685);
    paramString = v.zh(paramString);
    AppMethodBeat.o(168685);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a
 * JD-Core Version:    0.7.0.1
 */