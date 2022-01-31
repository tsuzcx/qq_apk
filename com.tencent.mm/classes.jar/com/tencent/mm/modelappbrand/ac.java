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
  private f fqi;
  protected Map<String, m> fqj;
  
  public ac(ab paramab)
  {
    AppMethodBeat.i(70644);
    this.fqj = new HashMap();
    if (paramab == null)
    {
      AppMethodBeat.o(70644);
      return;
    }
    this.fqi = paramab.acz();
    a(paramab);
    AppMethodBeat.o(70644);
  }
  
  public ac(f paramf)
  {
    AppMethodBeat.i(70643);
    this.fqj = new HashMap();
    this.fqi = paramf;
    AppMethodBeat.o(70643);
  }
  
  private void a(ab paramab)
  {
    AppMethodBeat.i(70645);
    paramab = paramab.acA().iterator();
    while (paramab.hasNext()) {
      a((m)paramab.next());
    }
    AppMethodBeat.o(70645);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(70647);
    this.fqj.put(paramm.getName(), paramm);
    AppMethodBeat.o(70647);
  }
  
  public final List<m> acA()
  {
    AppMethodBeat.i(70648);
    ArrayList localArrayList = new ArrayList(this.fqj.values());
    AppMethodBeat.o(70648);
    return localArrayList;
  }
  
  public final f acz()
  {
    return this.fqi;
  }
  
  public final <T> T qs(String paramString)
  {
    AppMethodBeat.i(70646);
    paramString = this.fqj.get(paramString);
    AppMethodBeat.o(70646);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.ac
 * JD-Core Version:    0.7.0.1
 */