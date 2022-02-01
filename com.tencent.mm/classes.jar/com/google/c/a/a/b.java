package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends g
{
  private final short bJN;
  private final short bJO;
  
  b(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(12257);
    this.bJN = ((short)paramInt1);
    this.bJO = ((short)paramInt2);
    AppMethodBeat.o(12257);
  }
  
  public final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12258);
    int i = 0;
    if (i < this.bJO)
    {
      if ((i == 0) || ((i == 31) && (this.bJO <= 62)))
      {
        parama.bI(31, 5);
        if (this.bJO <= 62) {
          break label85;
        }
        parama.bI(this.bJO - 31, 16);
      }
      for (;;)
      {
        parama.bI(paramArrayOfByte[(this.bJN + i)], 8);
        i += 1;
        break;
        label85:
        if (i == 0) {
          parama.bI(Math.min(this.bJO, 31), 5);
        } else {
          parama.bI(this.bJO - 31, 5);
        }
      }
    }
    AppMethodBeat.o(12258);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12259);
    String str = "<" + this.bJN + "::" + (this.bJN + this.bJO - 1) + '>';
    AppMethodBeat.o(12259);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */