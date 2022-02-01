package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends g
{
  private final short ccr;
  private final short value;
  
  e(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(12202);
    this.value = ((short)paramInt1);
    this.ccr = ((short)paramInt2);
    AppMethodBeat.o(12202);
  }
  
  final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12203);
    parama.bH(this.value, this.ccr);
    AppMethodBeat.o(12203);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12204);
    int i = this.value;
    int j = this.ccr;
    int k = this.ccr;
    String str = "<" + Integer.toBinaryString(i & (1 << j) - 1 | 1 << k | 1 << this.ccr).substring(1) + '>';
    AppMethodBeat.o(12204);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */