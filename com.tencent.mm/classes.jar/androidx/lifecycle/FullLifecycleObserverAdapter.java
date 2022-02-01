package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

class FullLifecycleObserverAdapter
  implements j
{
  private final e ZK;
  private final j ZL;
  
  FullLifecycleObserverAdapter(e parame, j paramj)
  {
    this.ZK = parame;
    this.ZL = paramj;
  }
  
  public final void a(l paraml, h.a parama)
  {
    AppMethodBeat.i(213337);
    switch (1.ZM[parama.ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      if (this.ZL != null) {
        this.ZL.a(paraml, parama);
      }
      AppMethodBeat.o(213337);
      return;
    }
    paraml = new IllegalArgumentException("ON_ANY must not been send by anybody");
    AppMethodBeat.o(213337);
    throw paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */