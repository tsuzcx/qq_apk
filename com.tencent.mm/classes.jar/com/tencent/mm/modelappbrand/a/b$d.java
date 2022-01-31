package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$d
{
  private final ak fqE;
  final Map<String, List<b.d.a>> fqF;
  final Map<String, Boolean> fqG;
  
  private b$d(ak paramak)
  {
    AppMethodBeat.i(77333);
    this.fqF = new HashMap();
    this.fqG = new HashMap();
    this.fqE = paramak;
    AppMethodBeat.o(77333);
  }
  
  final void a(String paramString, b.d.a parama)
  {
    AppMethodBeat.i(77337);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77337);
      return;
    }
    paramString = (List)this.fqF.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(77337);
      return;
    }
    paramString.remove(parama);
    AppMethodBeat.o(77337);
  }
  
  final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(77339);
    this.fqE.post(paramRunnable);
    AppMethodBeat.o(77339);
  }
  
  final void qE(String paramString)
  {
    AppMethodBeat.i(77334);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77334);
      return;
    }
    paramString = (List)this.fqF.remove(paramString);
    if (bo.es(paramString))
    {
      AppMethodBeat.o(77334);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((b.d.a)paramString.next()).acI();
    }
    AppMethodBeat.o(77334);
  }
  
  final boolean qF(String paramString)
  {
    AppMethodBeat.i(77335);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77335);
      return false;
    }
    boolean bool = this.fqG.containsKey(paramString);
    AppMethodBeat.o(77335);
    return bool;
  }
  
  final void qG(String paramString)
  {
    AppMethodBeat.i(77336);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77336);
      return;
    }
    this.fqG.remove(paramString);
    AppMethodBeat.o(77336);
  }
  
  final void qH(String paramString)
  {
    AppMethodBeat.i(77338);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77338);
      return;
    }
    paramString = (List)this.fqF.remove(paramString);
    if (!bo.es(paramString))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext()) {
        ((b.d.a)localIterator.next()).acJ();
      }
      paramString.clear();
    }
    AppMethodBeat.o(77338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.d
 * JD-Core Version:    0.7.0.1
 */