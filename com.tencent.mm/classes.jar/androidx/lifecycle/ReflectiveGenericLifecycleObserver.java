package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver
  implements j
{
  private final Object aaG;
  private final b.a aaH;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    AppMethodBeat.i(213414);
    this.aaG = paramObject;
    this.aaH = b.Zx.d(this.aaG.getClass());
    AppMethodBeat.o(213414);
  }
  
  public final void a(l paraml, h.a parama)
  {
    AppMethodBeat.i(213416);
    b.a locala = this.aaH;
    Object localObject = this.aaG;
    b.a.a((List)locala.ZA.get(parama), paraml, parama, localObject);
    b.a.a((List)locala.ZA.get(h.a.ON_ANY), paraml, parama, localObject);
    AppMethodBeat.o(213416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */