package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends RuntimeException
{
  private final int column;
  private final int line;
  private final int offset;
  
  j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString + " at " + paramInt2 + ":" + paramInt3);
    AppMethodBeat.i(70596);
    this.offset = paramInt1;
    this.line = paramInt2;
    this.column = paramInt3;
    AppMethodBeat.o(70596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.j
 * JD-Core Version:    0.7.0.1
 */