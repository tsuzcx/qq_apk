package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c$b
  implements Serializable
{
  final List<c.d> fAL;
  final List<c.a> fAM;
  final List<c.a> fAN;
  final List<c.c> fAO;
  
  c$b()
  {
    AppMethodBeat.i(58339);
    this.fAL = new CopyOnWriteArrayList();
    this.fAM = new CopyOnWriteArrayList();
    this.fAN = new CopyOnWriteArrayList();
    this.fAO = new CopyOnWriteArrayList();
    AppMethodBeat.o(58339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.c.b
 * JD-Core Version:    0.7.0.1
 */