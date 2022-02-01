package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$b$c
{
  boolean iNF;
  int iNG;
  int iNH;
  
  public final String toString()
  {
    AppMethodBeat.i(151388);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail[").append(this.iNF).append("],");
    ((StringBuilder)localObject).append("tryTimes[").append(this.iNG).append("],");
    ((StringBuilder)localObject).append("lastTS[").append(this.iNH).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(151388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.u.b.c
 * JD-Core Version:    0.7.0.1
 */