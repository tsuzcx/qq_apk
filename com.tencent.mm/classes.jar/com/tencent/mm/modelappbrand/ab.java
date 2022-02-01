package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ab
  implements aa
{
  private i oqh;
  protected Map<String, o> oqi;
  
  public ab(aa paramaa)
  {
    AppMethodBeat.i(76393);
    this.oqi = new HashMap();
    if (paramaa == null)
    {
      AppMethodBeat.o(76393);
      return;
    }
    this.oqh = paramaa.bEU();
    a(paramaa);
    AppMethodBeat.o(76393);
  }
  
  public ab(i parami)
  {
    AppMethodBeat.i(76392);
    this.oqi = new HashMap();
    this.oqh = parami;
    AppMethodBeat.o(76392);
  }
  
  private void a(aa paramaa)
  {
    AppMethodBeat.i(76394);
    paramaa = paramaa.bEV().iterator();
    while (paramaa.hasNext()) {
      a((o)paramaa.next());
    }
    AppMethodBeat.o(76394);
  }
  
  public final <T> T KV(String paramString)
  {
    AppMethodBeat.i(76395);
    paramString = this.oqi.get(paramString);
    AppMethodBeat.o(76395);
    return paramString;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(76396);
    this.oqi.put(paramo.getName(), paramo);
    AppMethodBeat.o(76396);
  }
  
  public final i bEU()
  {
    return this.oqh;
  }
  
  public final List<o> bEV()
  {
    AppMethodBeat.i(76397);
    ArrayList localArrayList = new ArrayList(this.oqi.values());
    AppMethodBeat.o(76397);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.ab
 * JD-Core Version:    0.7.0.1
 */