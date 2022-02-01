package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  long decodeHandle;
  
  public h(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(130037);
    this.decodeHandle = MediaRecorder.SilkDecInit(paramInt1, paramArrayOfByte, paramInt2, MediaRecorder.mjK);
    AppMethodBeat.o(130037);
  }
  
  public final int a(byte[] paramArrayOfByte, short paramShort)
  {
    AppMethodBeat.i(130038);
    int i = MediaRecorder.SilkDoDec(paramArrayOfByte, paramShort, this.decodeHandle);
    AppMethodBeat.o(130038);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.h
 * JD-Core Version:    0.7.0.1
 */