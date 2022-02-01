package com.bumptech.glide.manager;

import com.bumptech.glide.f.a.e;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class o
  implements i
{
  public final Set<e<?>> aKn;
  
  public o()
  {
    AppMethodBeat.i(77590);
    this.aKn = Collections.newSetFromMap(new WeakHashMap());
    AppMethodBeat.o(77590);
  }
  
  public final void f(e<?> parame)
  {
    AppMethodBeat.i(77591);
    this.aKn.remove(parame);
    AppMethodBeat.o(77591);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(77594);
    Iterator localIterator = j.c(this.aKn).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(77594);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(77592);
    Iterator localIterator = j.c(this.aKn).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onStart();
    }
    AppMethodBeat.o(77592);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(77593);
    Iterator localIterator = j.c(this.aKn).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onStop();
    }
    AppMethodBeat.o(77593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.o
 * JD-Core Version:    0.7.0.1
 */