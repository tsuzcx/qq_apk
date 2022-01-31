package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends g
{
  private final short bic;
  private final short value;
  
  e(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(57137);
    this.value = ((short)paramInt1);
    this.bic = ((short)paramInt2);
    AppMethodBeat.o(57137);
  }
  
  final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57138);
    parama.bt(this.value, this.bic);
    AppMethodBeat.o(57138);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57139);
    int i = this.value;
    int j = this.bic;
    int k = this.bic;
    String str = "<" + Integer.toBinaryString(i & (1 << j) - 1 | 1 << k | 1 << this.bic).substring(1) + '>';
    AppMethodBeat.o(57139);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */