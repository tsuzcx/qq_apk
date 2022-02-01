package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o
{
  final a<?> bKU;
  final Set<o> bKV;
  final Set<o> bKW;
  
  o(a<?> parama)
  {
    AppMethodBeat.i(4090);
    this.bKV = new HashSet();
    this.bKW = new HashSet();
    this.bKU = parama;
    AppMethodBeat.o(4090);
  }
  
  final boolean yb()
  {
    AppMethodBeat.i(4091);
    boolean bool = this.bKW.isEmpty();
    AppMethodBeat.o(4091);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.components.o
 * JD-Core Version:    0.7.0.1
 */