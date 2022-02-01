package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends g
{
  private final short bRJ;
  private final short bRK;
  
  b(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(12257);
    this.bRJ = ((short)paramInt1);
    this.bRK = ((short)paramInt2);
    AppMethodBeat.o(12257);
  }
  
  public final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12258);
    int i = 0;
    if (i < this.bRK)
    {
      if ((i == 0) || ((i == 31) && (this.bRK <= 62)))
      {
        parama.bH(31, 5);
        if (this.bRK <= 62) {
          break label85;
        }
        parama.bH(this.bRK - 31, 16);
      }
      for (;;)
      {
        parama.bH(paramArrayOfByte[(this.bRJ + i)], 8);
        i += 1;
        break;
        label85:
        if (i == 0) {
          parama.bH(Math.min(this.bRK, 31), 5);
        } else {
          parama.bH(this.bRK - 31, 5);
        }
      }
    }
    AppMethodBeat.o(12258);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12259);
    String str = "<" + this.bRJ + "::" + (this.bRJ + this.bRK - 1) + '>';
    AppMethodBeat.o(12259);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */