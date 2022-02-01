package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final a<?> bCI;
  final Set<o> bCJ;
  final Set<o> bCK;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(4090);
    this.bCJ = new HashSet();
    this.bCK = new HashSet();
    this.bCI = parama;
    AppMethodBeat.o(4090);
  }
  
  final boolean wJ()
  {
    AppMethodBeat.i(4091);
    boolean bool = this.bCK.isEmpty();
    AppMethodBeat.o(4091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */