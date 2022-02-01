package com.bumptech.glide.manager;

import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

final class a
  implements h
{
  private final Set<i> aKD;
  private boolean aKE;
  private boolean aKd;
  
  a()
  {
    AppMethodBeat.i(77540);
    this.aKD = Collections.newSetFromMap(new WeakHashMap());
    AppMethodBeat.o(77540);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(77541);
    this.aKD.add(parami);
    if (this.aKE)
    {
      parami.onDestroy();
      AppMethodBeat.o(77541);
      return;
    }
    if (this.aKd)
    {
      parami.onStart();
      AppMethodBeat.o(77541);
      return;
    }
    parami.onStop();
    AppMethodBeat.o(77541);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(77542);
    this.aKD.remove(parami);
    AppMethodBeat.o(77542);
  }
  
  final void onDestroy()
  {
    AppMethodBeat.i(77545);
    this.aKE = true;
    Iterator localIterator = j.c(this.aKD).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(77545);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(77543);
    this.aKd = true;
    Iterator localIterator = j.c(this.aKD).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onStart();
    }
    AppMethodBeat.o(77543);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(77544);
    this.aKd = false;
    Iterator localIterator = j.c(this.aKD).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onStop();
    }
    AppMethodBeat.o(77544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.manager.a
 * JD-Core Version:    0.7.0.1
 */