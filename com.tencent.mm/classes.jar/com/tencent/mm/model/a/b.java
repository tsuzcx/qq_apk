package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String endTime;
  public String gWQ;
  public String iGw;
  public String iGx;
  public HashMap<String, e> iGy;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.iGy = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e KR(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.iGy != null) && (this.iGy.containsKey(paramString)))
    {
      paramString = (e)this.iGy.get(paramString);
      AppMethodBeat.o(153090);
      return paramString;
    }
    AppMethodBeat.o(153090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */