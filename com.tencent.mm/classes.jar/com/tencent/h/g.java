package com.tencent.h;

import com.tencent.h.b.a;
import com.tencent.h.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.h.b.b
{
  private f ByM;
  d ByN;
  b ByO;
  a ByP;
  int mReferenceCount = 0;
  int mState;
  
  public g(f paramf, d paramd)
  {
    this.ByM = paramf;
    this.ByN = paramd;
  }
  
  public final void start()
  {
    AppMethodBeat.i(127761);
    this.ByM.a(this);
    AppMethodBeat.o(127761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.g
 * JD-Core Version:    0.7.0.1
 */