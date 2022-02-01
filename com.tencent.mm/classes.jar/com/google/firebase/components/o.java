package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final a<?> bAq;
  final Set<o> bAr;
  final Set<o> bAs;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(4090);
    this.bAr = new HashSet();
    this.bAs = new HashSet();
    this.bAq = parama;
    AppMethodBeat.o(4090);
  }
  
  final boolean ww()
  {
    AppMethodBeat.i(4091);
    boolean bool = this.bAs.isEmpty();
    AppMethodBeat.o(4091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */