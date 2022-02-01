package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final byte[] ceE;
  private int ceF;
  
  b(int paramInt)
  {
    AppMethodBeat.i(12222);
    this.ceE = new byte[paramInt];
    this.ceF = 0;
    AppMethodBeat.o(12222);
  }
  
  final void d(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      int k = this.ceF;
      this.ceF = (k + 1);
      byte[] arrayOfByte = this.ceE;
      if (paramBoolean) {}
      for (int j = 1;; j = 0)
      {
        arrayOfByte[k] = ((byte)j);
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.e.a.b
 * JD-Core Version:    0.7.0.1
 */