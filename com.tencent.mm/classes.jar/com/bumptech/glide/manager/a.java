package com.bumptech.glide.manager;

import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

final class a
  implements h
{
  private final Set<i> aMm;
  private boolean aMn;
  private boolean isStarted;
  
  a()
  {
    AppMethodBeat.i(77540);
    this.aMm = Collections.newSetFromMap(new WeakHashMap());
    AppMethodBeat.o(77540);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(77541);
    this.aMm.add(parami);
    if (this.aMn)
    {
      parami.onDestroy();
      AppMethodBeat.o(77541);
      return;
    }
    if (this.isStarted)
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
    this.aMm.remove(parami);
    AppMethodBeat.o(77542);
  }
  
  final void onDestroy()
  {
    AppMethodBeat.i(77545);
    this.aMn = true;
    Iterator localIterator = k.c(this.aMm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(77545);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(77543);
    this.isStarted = true;
    Iterator localIterator = k.c(this.aMm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onStart();
    }
    AppMethodBeat.o(77543);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(77544);
    this.isStarted = false;
    Iterator localIterator = k.c(this.aMm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onStop();
    }
    AppMethodBeat.o(77544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.a
 * JD-Core Version:    0.7.0.1
 */