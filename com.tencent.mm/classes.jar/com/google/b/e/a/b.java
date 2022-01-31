package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  final byte[] bkq;
  private int bkr;
  
  b(int paramInt)
  {
    AppMethodBeat.i(57157);
    this.bkq = new byte[paramInt];
    this.bkr = 0;
    AppMethodBeat.o(57157);
  }
  
  final void c(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      int k = this.bkr;
      this.bkr = (k + 1);
      byte[] arrayOfByte = this.bkq;
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
 * Qualified Name:     com.google.b.e.a.b
 * JD-Core Version:    0.7.0.1
 */