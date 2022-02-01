package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String glZ;
  public String hLt;
  public String hLu;
  public String hLv;
  public HashMap<String, e> hLw;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.hLw = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e Cg(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.hLw != null) && (this.hLw.containsKey(paramString)))
    {
      paramString = (e)this.hLw.get(paramString);
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