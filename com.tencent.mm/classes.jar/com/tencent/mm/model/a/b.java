package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  public String gjG;
  public String hIA;
  public String hIB;
  public String hIC;
  public HashMap<String, e> hID;
  
  public b()
  {
    AppMethodBeat.i(153089);
    this.hID = new HashMap();
    AppMethodBeat.o(153089);
  }
  
  public final e BE(String paramString)
  {
    AppMethodBeat.i(153090);
    if ((this.hID != null) && (this.hID.containsKey(paramString)))
    {
      paramString = (e)this.hID.get(paramString);
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