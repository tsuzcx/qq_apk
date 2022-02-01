package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends g
{
  private final short bJW;
  private final short value;
  
  e(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(12202);
    this.value = ((short)paramInt1);
    this.bJW = ((short)paramInt2);
    AppMethodBeat.o(12202);
  }
  
  final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12203);
    parama.bI(this.value, this.bJW);
    AppMethodBeat.o(12203);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12204);
    int i = this.value;
    int j = this.bJW;
    int k = this.bJW;
    String str = "<" + Integer.toBinaryString(i & (1 << j) - 1 | 1 << k | 1 << this.bJW).substring(1) + '>';
    AppMethodBeat.o(12204);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.a.a.e
 * JD-Core Version:    0.7.0.1
 */