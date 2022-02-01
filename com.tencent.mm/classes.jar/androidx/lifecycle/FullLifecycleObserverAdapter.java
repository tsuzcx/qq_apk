package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

class FullLifecycleObserverAdapter
  implements o
{
  private final g bHd;
  private final o bHe;
  
  FullLifecycleObserverAdapter(g paramg, o paramo)
  {
    this.bHd = paramg;
    this.bHe = paramo;
  }
  
  public void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194312);
    switch (1.bHf[parama.ordinal()])
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        if (this.bHe != null) {
          this.bHe.onStateChanged(paramq, parama);
        }
        AppMethodBeat.o(194312);
        return;
        this.bHd.onStart(paramq);
        continue;
        this.bHd.onStop(paramq);
        continue;
        this.bHd.onDestroy(paramq);
      }
    }
    paramq = new IllegalArgumentException("ON_ANY must not been send by anybody");
    AppMethodBeat.o(194312);
    throw paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */