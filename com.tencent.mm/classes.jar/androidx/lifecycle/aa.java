package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class aa
{
  public final HashMap<String, x> aaP;
  
  public aa()
  {
    AppMethodBeat.i(192187);
    this.aaP = new HashMap();
    AppMethodBeat.o(192187);
  }
  
  final void a(String paramString, x paramx)
  {
    AppMethodBeat.i(192188);
    paramString = (x)this.aaP.put(paramString, paramx);
    if (paramString != null) {
      paramString.onCleared();
    }
    AppMethodBeat.o(192188);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(192189);
    Iterator localIterator = this.aaP.values().iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).onCleared();
    }
    this.aaP.clear();
    AppMethodBeat.o(192189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.lifecycle.aa
 * JD-Core Version:    0.7.0.1
 */