package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends g
{
  private final short bhT;
  private final short bhU;
  
  b(g paramg, int paramInt1, int paramInt2)
  {
    super(paramg);
    AppMethodBeat.i(57192);
    this.bhT = ((short)paramInt1);
    this.bhU = ((short)paramInt2);
    AppMethodBeat.o(57192);
  }
  
  public final void a(a parama, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57193);
    int i = 0;
    if (i < this.bhU)
    {
      if ((i == 0) || ((i == 31) && (this.bhU <= 62)))
      {
        parama.bt(31, 5);
        if (this.bhU <= 62) {
          break label84;
        }
        parama.bt(this.bhU - 31, 16);
      }
      for (;;)
      {
        parama.bt(paramArrayOfByte[(this.bhT + i)], 8);
        i += 1;
        break;
        label84:
        if (i == 0) {
          parama.bt(Math.min(this.bhU, 31), 5);
        } else {
          parama.bt(this.bhU - 31, 5);
        }
      }
    }
    AppMethodBeat.o(57193);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57194);
    String str = "<" + this.bhT + "::" + (this.bhT + this.bhU - 1) + '>';
    AppMethodBeat.o(57194);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */