package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final Set<o> bIA;
  final Set<o> bIB;
  final a<?> bIz;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(4090);
    this.bIA = new HashSet();
    this.bIB = new HashSet();
    this.bIz = parama;
    AppMethodBeat.o(4090);
  }
  
  final boolean yv()
  {
    AppMethodBeat.i(4091);
    boolean bool = this.bIB.isEmpty();
    AppMethodBeat.o(4091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */