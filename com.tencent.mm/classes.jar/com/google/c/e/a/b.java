package com.google.c.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final byte[] cgj;
  private int cgk;
  
  b(int paramInt)
  {
    AppMethodBeat.i(12222);
    this.cgj = new byte[paramInt];
    this.cgk = 0;
    AppMethodBeat.o(12222);
  }
  
  final void f(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      int k = this.cgk;
      this.cgk = (k + 1);
      byte[] arrayOfByte = this.cgj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.e.a.b
 * JD-Core Version:    0.7.0.1
 */