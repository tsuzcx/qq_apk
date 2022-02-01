package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String fMu;
  public String gPI;
  public String gPJ;
  public String gPK;
  public HashMap<String, e> gPL;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.gPL = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e uz(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.gPL != null) && (this.gPL.containsKey(paramString)))
    {
      paramString = (e)this.gPL.get(paramString);
      AppMethodBeat.o(153090);
      return paramString;
    }
    AppMethodBeat.o(153090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */