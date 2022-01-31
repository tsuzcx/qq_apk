package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  long fZH;
  
  public h(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(155556);
    this.fZH = MediaRecorder.SilkDecInit(paramInt1, paramArrayOfByte, paramInt2, MediaRecorder.fZp);
    AppMethodBeat.o(155556);
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort)
  {
    AppMethodBeat.i(155557);
    int i = MediaRecorder.SilkDoDec(paramArrayOfByte, paramShort, this.fZH);
    AppMethodBeat.o(155557);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoice.h
 * JD-Core Version:    0.7.0.1
 */