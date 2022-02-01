package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ac
  implements ab
{
  private h iID;
  protected Map<String, o> iIE;
  
  public ac(ab paramab)
  {
    AppMethodBeat.i(76393);
    this.iIE = new HashMap();
    if (paramab == null)
    {
      AppMethodBeat.o(76393);
      return;
    }
    this.iID = paramab.aXU();
    a(paramab);
    AppMethodBeat.o(76393);
  }
  
  public ac(h paramh)
  {
    AppMethodBeat.i(76392);
    this.iIE = new HashMap();
    this.iID = paramh;
    AppMethodBeat.o(76392);
  }
  
  private void a(ab paramab)
  {
    AppMethodBeat.i(76394);
    paramab = paramab.aXV().iterator();
    while (paramab.hasNext()) {
      a((o)paramab.next());
    }
    AppMethodBeat.o(76394);
  }
  
  public final <T> T LA(String paramString)
  {
    AppMethodBeat.i(76395);
    paramString = this.iIE.get(paramString);
    AppMethodBeat.o(76395);
    return paramString;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(76396);
    this.iIE.put(paramo.getName(), paramo);
    AppMethodBeat.o(76396);
  }
  
  public final h aXU()
  {
    return this.iID;
  }
  
  public final List<o> aXV()
  {
    AppMethodBeat.i(76397);
    ArrayList localArrayList = new ArrayList(this.iIE.values());
    AppMethodBeat.o(76397);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.ac
 * JD-Core Version:    0.7.0.1
 */