package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver
  implements o
{
  private final Object bIa;
  private final b.a bIb;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    AppMethodBeat.i(194311);
    this.bIa = paramObject;
    this.bIb = b.bGQ.l(this.bIa.getClass());
    AppMethodBeat.o(194311);
  }
  
  public void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194321);
    b.a locala = this.bIb;
    Object localObject = this.bIa;
    b.a.a((List)locala.bGS.get(parama), paramq, parama, localObject);
    b.a.a((List)locala.bGS.get(j.a.ON_ANY), paramq, parama, localObject);
    AppMethodBeat.o(194321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */