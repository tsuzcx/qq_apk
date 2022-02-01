package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$b$c
{
  int iQA;
  int iQB;
  boolean iQz;
  
  public final String toString()
  {
    AppMethodBeat.i(151388);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail[").append(this.iQz).append("],");
    ((StringBuilder)localObject).append("tryTimes[").append(this.iQA).append("],");
    ((StringBuilder)localObject).append("lastTS[").append(this.iQB).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(151388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.u.b.c
 * JD-Core Version:    0.7.0.1
 */