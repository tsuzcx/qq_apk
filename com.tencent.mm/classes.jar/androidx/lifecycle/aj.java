package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class aj
{
  public final HashMap<String, af> bIx;
  
  public aj()
  {
    AppMethodBeat.i(194425);
    this.bIx = new HashMap();
    AppMethodBeat.o(194425);
  }
  
  final Set<String> Hq()
  {
    AppMethodBeat.i(194460);
    HashSet localHashSet = new HashSet(this.bIx.keySet());
    AppMethodBeat.o(194460);
    return localHashSet;
  }
  
  final void a(String paramString, af paramaf)
  {
    AppMethodBeat.i(194436);
    paramString = (af)this.bIx.put(paramString, paramaf);
    if (paramString != null) {
      paramString.onCleared();
    }
    AppMethodBeat.o(194436);
  }
  
  final af aN(String paramString)
  {
    AppMethodBeat.i(194448);
    paramString = (af)this.bIx.get(paramString);
    AppMethodBeat.o(194448);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(194472);
    Iterator localIterator = this.bIx.values().iterator();
    while (localIterator.hasNext()) {
      ((af)localIterator.next()).clear();
    }
    this.bIx.clear();
    AppMethodBeat.o(194472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.aj
 * JD-Core Version:    0.7.0.1
 */