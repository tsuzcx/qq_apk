package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$b$c
{
  boolean pBf;
  int pBg;
  int pBh;
  
  public final String toString()
  {
    AppMethodBeat.i(151388);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail[").append(this.pBf).append("],");
    ((StringBuilder)localObject).append("tryTimes[").append(this.pBg).append("],");
    ((StringBuilder)localObject).append("lastTS[").append(this.pBh).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(151388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.r.b.c
 * JD-Core Version:    0.7.0.1
 */