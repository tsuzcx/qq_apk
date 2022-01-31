package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends i
{
  private final d aVg;
  
  public e(d paramd)
  {
    this.aVg = paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(95616);
    d locald = this.aVg;
    clear();
    locald.aVd.add(this);
    AppMethodBeat.o(95616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.e
 * JD-Core Version:    0.7.0.1
 */