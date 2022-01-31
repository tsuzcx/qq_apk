package com.google.android.exoplayer2.b;

import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int aAF;
  public int aAG;
  public final MediaCodec.CryptoInfo aAH;
  private final b.a aAI;
  public byte[] iv;
  public byte[] key;
  public int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  public int numSubSamples;
  
  public b()
  {
    AppMethodBeat.i(94737);
    if (x.SDK_INT >= 16) {}
    for (Object localObject1 = new MediaCodec.CryptoInfo();; localObject1 = null)
    {
      this.aAH = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new b.a(this.aAH, (byte)0);
      }
      this.aAI = ((b.a)localObject1);
      AppMethodBeat.o(94737);
      return;
    }
  }
  
  public final void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(94738);
    this.numSubSamples = paramInt1;
    this.numBytesOfClearData = paramArrayOfInt1;
    this.numBytesOfEncryptedData = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.iv = paramArrayOfByte2;
    this.mode = paramInt2;
    this.aAF = paramInt3;
    this.aAG = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.aAH.numSubSamples = this.numSubSamples;
      this.aAH.numBytesOfClearData = this.numBytesOfClearData;
      this.aAH.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.aAH.key = this.key;
      this.aAH.iv = this.iv;
      this.aAH.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.aAI;
        paramInt1 = this.aAF;
        paramInt2 = this.aAG;
        paramArrayOfInt1.aAJ.set(paramInt1, paramInt2);
        paramArrayOfInt1.aAH.setPattern(paramArrayOfInt1.aAJ);
      }
    }
    AppMethodBeat.o(94738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */