package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends i
{
  private final d bBE;
  
  public e(d paramd)
  {
    this.bBE = paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92784);
    d locald = this.bBE;
    clear();
    locald.bBB.add(this);
    AppMethodBeat.o(92784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.e
 * JD-Core Version:    0.7.0.1
 */