package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final a<?> bKE;
  final Set<o> bKF;
  final Set<o> bKG;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(4090);
    this.bKF = new HashSet();
    this.bKG = new HashSet();
    this.bKE = parama;
    AppMethodBeat.o(4090);
  }
  
  final boolean xT()
  {
    AppMethodBeat.i(4091);
    boolean bool = this.bKG.isEmpty();
    AppMethodBeat.o(4091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */