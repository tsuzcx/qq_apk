package com.google.c.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final byte[] bUf;
  private int bUg;
  
  b(int paramInt)
  {
    AppMethodBeat.i(12222);
    this.bUf = new byte[paramInt];
    this.bUg = 0;
    AppMethodBeat.o(12222);
  }
  
  final void f(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      int k = this.bUg;
      this.bUg = (k + 1);
      byte[] arrayOfByte = this.bUf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.e.a.b
 * JD-Core Version:    0.7.0.1
 */