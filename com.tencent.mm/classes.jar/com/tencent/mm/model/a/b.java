package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String endTime;
  public String mhv;
  public String onX;
  public String onY;
  public HashMap<String, e> onZ;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.onZ = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e Km(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.onZ != null) && (this.onZ.containsKey(paramString)))
    {
      paramString = (e)this.onZ.get(paramString);
      AppMethodBeat.o(153090);
      return paramString;
    }
    AppMethodBeat.o(153090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */