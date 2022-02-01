package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends g
{
  private final short cci;
  private final short ccj;
  
  b(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(12257);
    this.cci = ((short)paramInt1);
    this.ccj = ((short)paramInt2);
    AppMethodBeat.o(12257);
  }
  
  public final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12258);
    int i = 0;
    if (i < this.ccj)
    {
      if ((i == 0) || ((i == 31) && (this.ccj <= 62)))
      {
        parama.bH(31, 5);
        if (this.ccj <= 62) {
          break label85;
        }
        parama.bH(this.ccj - 31, 16);
      }
      for (;;)
      {
        parama.bH(paramArrayOfByte[(this.cci + i)], 8);
        i += 1;
        break;
        label85:
        if (i == 0) {
          parama.bH(Math.min(this.ccj, 31), 5);
        } else {
          parama.bH(this.ccj - 31, 5);
        }
      }
    }
    AppMethodBeat.o(12258);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12259);
    String str = "<" + this.cci + "::" + (this.cci + this.ccj - 1) + '>';
    AppMethodBeat.o(12259);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */