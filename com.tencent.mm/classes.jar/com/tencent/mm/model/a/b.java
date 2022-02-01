package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String endTime;
  public String jHO;
  public HashMap<String, e> lwA;
  public String lwy;
  public String lwz;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.lwA = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e Sk(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.lwA != null) && (this.lwA.containsKey(paramString)))
    {
      paramString = (e)this.lwA.get(paramString);
      AppMethodBeat.o(153090);
      return paramString;
    }
    AppMethodBeat.o(153090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */