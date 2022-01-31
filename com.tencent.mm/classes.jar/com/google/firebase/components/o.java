package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final a<?> beI;
  final Set<o> beJ;
  final Set<o> beK;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(10623);
    this.beJ = new HashSet();
    this.beK = new HashSet();
    this.beI = parama;
    AppMethodBeat.o(10623);
  }
  
  final boolean rK()
  {
    AppMethodBeat.i(10624);
    boolean bool = this.beK.isEmpty();
    AppMethodBeat.o(10624);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */