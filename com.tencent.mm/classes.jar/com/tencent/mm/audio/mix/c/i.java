package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;

public final class i
  implements h
{
  private int cfq = 0;
  private int cfr = 0;
  private String fileName;
  
  public final byte[] E(byte[] paramArrayOfByte)
  {
    int j = 0;
    AppMethodBeat.i(137034);
    Object localObject = new short[paramArrayOfByte.length / 2];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | (paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8));
      i += 1;
    }
    paramArrayOfByte = new short[localObject.length * this.cfr / this.cfq];
    if (SilkResampleJni.resamplePcm(this.fileName, this.cfq, this.cfr, (short[])localObject, localObject.length, paramArrayOfByte) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", new Object[] { this.fileName });
      AppMethodBeat.o(137034);
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
    AppMethodBeat.o(137034);
    return localObject;
  }
  
  public final boolean k(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137033);
    this.cfq = paramInt1;
    this.cfr = paramInt2;
    this.fileName = paramString;
    b.i("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (SilkResampleJni.initResample(paramString, paramInt1, paramInt2) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", new Object[] { paramString });
      AppMethodBeat.o(137033);
      return false;
    }
    AppMethodBeat.o(137033);
    return true;
  }
  
  public final boolean release()
  {
    AppMethodBeat.i(137035);
    if (SilkResampleJni.clearResample(this.fileName) == -1)
    {
      b.e("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
      AppMethodBeat.o(137035);
      return false;
    }
    b.i("MicroMsg.Mix.SilkResampleAlgorithm", "release");
    AppMethodBeat.o(137035);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.i
 * JD-Core Version:    0.7.0.1
 */