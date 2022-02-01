package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;

public final class i
  implements h
{
  private int dda = 0;
  private int ddb = 0;
  private String fileName;
  
  public final byte[] J(byte[] paramArrayOfByte)
  {
    int j = 0;
    AppMethodBeat.i(136782);
    Object localObject = new short[paramArrayOfByte.length / 2];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | (paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8));
      i += 1;
    }
    int k = localObject.length * this.ddb / this.dda;
    i = k;
    if (this.ddb % this.dda != 0) {
      i = k + 1;
    }
    paramArrayOfByte = new short[i];
    if (SilkResampleJni.resamplePcm(this.fileName, this.dda, this.ddb, (short[])localObject, localObject.length, paramArrayOfByte) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", new Object[] { this.fileName });
      AppMethodBeat.o(136782);
      return null;
    }
    localObject = new byte[paramArrayOfByte.length << 1];
    i = j;
    while (i < paramArrayOfByte.length)
    {
      localObject[(i * 2)] = ((byte)(paramArrayOfByte[i] & 0xFF));
      localObject[(i * 2 + 1)] = ((byte)((paramArrayOfByte[i] & 0xFF00) >> 8));
      i += 1;
    }
    AppMethodBeat.o(136782);
    return localObject;
  }
  
  public final boolean l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136781);
    this.dda = paramInt1;
    this.ddb = paramInt2;
    this.fileName = paramString;
    b.i("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (SilkResampleJni.initResample(paramString, paramInt1, paramInt2) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", new Object[] { paramString });
      AppMethodBeat.o(136781);
      return false;
    }
    AppMethodBeat.o(136781);
    return true;
  }
  
  public final boolean release()
  {
    AppMethodBeat.i(136783);
    if (SilkResampleJni.clearResample(this.fileName) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
      AppMethodBeat.o(136783);
      return false;
    }
    b.i("MicroMsg.Mix.SilkResampleAlgorithm", "release");
    AppMethodBeat.o(136783);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.i
 * JD-Core Version:    0.7.0.1
 */