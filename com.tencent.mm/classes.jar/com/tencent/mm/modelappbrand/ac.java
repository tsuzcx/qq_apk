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
  private h gRN;
  protected Map<String, o> gRO;
  
  public ac(ab paramab)
  {
    AppMethodBeat.i(76393);
    this.gRO = new HashMap();
    if (paramab == null)
    {
      AppMethodBeat.o(76393);
      return;
    }
    this.gRN = paramab.atX();
    a(paramab);
    AppMethodBeat.o(76393);
  }
  
  public ac(h paramh)
  {
    AppMethodBeat.i(76392);
    this.gRO = new HashMap();
    this.gRN = paramh;
    AppMethodBeat.o(76392);
  }
  
  private void a(ab paramab)
  {
    AppMethodBeat.i(76394);
    paramab = paramab.atY().iterator();
    while (paramab.hasNext()) {
      a((o)paramab.next());
    }
    AppMethodBeat.o(76394);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(76396);
    this.gRO.put(paramo.getName(), paramo);
    AppMethodBeat.o(76396);
  }
  
  public final h atX()
  {
    return this.gRN;
  }
  
  public final List<o> atY()
  {
    AppMethodBeat.i(76397);
    ArrayList localArrayList = new ArrayList(this.gRO.values());
    AppMethodBeat.o(76397);
    return localArrayList;
  }
  
  public final <T> T vi(String paramString)
  {
    AppMethodBeat.i(76395);
    paramString = this.gRO.get(paramString);
    AppMethodBeat.o(76395);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.ac
 * JD-Core Version:    0.7.0.1
 */