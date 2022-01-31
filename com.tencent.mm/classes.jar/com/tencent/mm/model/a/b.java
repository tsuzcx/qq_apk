package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String ewh;
  public String fof;
  public String fog;
  public String foh;
  public HashMap<String, e> foi;
  
  public b()
  {
    AppMethodBeat.i(118140);
    this.foi = new HashMap();
    AppMethodBeat.o(118140);
  }
  
  public final e pL(String paramString)
  {
    AppMethodBeat.i(118141);
    if ((this.foi != null) && (this.foi.containsKey(paramString)))
    {
      paramString = (e)this.foi.get(paramString);
      AppMethodBeat.o(118141);
      return paramString;
    }
    AppMethodBeat.o(118141);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */