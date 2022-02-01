package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$b$c
{
  boolean mEC;
  int mED;
  int mEE;
  
  public final String toString()
  {
    AppMethodBeat.i(151388);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail[").append(this.mEC).append("],");
    ((StringBuilder)localObject).append("tryTimes[").append(this.mED).append("],");
    ((StringBuilder)localObject).append("lastTS[").append(this.mEE).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(151388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.u.b.c
 * JD-Core Version:    0.7.0.1
 */