package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$b$c
{
  boolean jNu;
  int jNv;
  int jNw;
  
  public final String toString()
  {
    AppMethodBeat.i(151388);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail[").append(this.jNu).append("],");
    ((StringBuilder)localObject).append("tryTimes[").append(this.jNv).append("],");
    ((StringBuilder)localObject).append("lastTS[").append(this.jNw).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(151388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.u.b.c
 * JD-Core Version:    0.7.0.1
 */