package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int aVY;
  public int aVZ;
  public final MediaCodec.CryptoInfo aWa;
  private final a aWb;
  public byte[] iv;
  public byte[] key;
  public int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  public int numSubSamples;
  
  public b()
  {
    AppMethodBeat.i(91848);
    if (x.SDK_INT >= 16) {}
    for (Object localObject1 = new MediaCodec.CryptoInfo();; localObject1 = null)
    {
      this.aWa = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.aWa, (byte)0);
      }
      this.aWb = ((a)localObject1);
      AppMethodBeat.o(91848);
      return;
    }
  }
  
  public final void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91849);
    this.numSubSamples = paramInt1;
    this.numBytesOfClearData = paramArrayOfInt1;
    this.numBytesOfEncryptedData = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.iv = paramArrayOfByte2;
    this.mode = paramInt2;
    this.aVY = paramInt3;
    this.aVZ = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.aWa.numSubSamples = this.numSubSamples;
      this.aWa.numBytesOfClearData = this.numBytesOfClearData;
      this.aWa.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.aWa.key = this.key;
      this.aWa.iv = this.iv;
      this.aWa.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.aWb;
        paramInt1 = this.aVY;
        paramInt2 = this.aVZ;
        paramArrayOfInt1.aWc.set(paramInt1, paramInt2);
        paramArrayOfInt1.aWa.setPattern(paramArrayOfInt1.aWc);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  @TargetApi(24)
  static final class a
  {
    final MediaCodec.CryptoInfo aWa;
    final MediaCodec.CryptoInfo.Pattern aWc;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.aWa = paramCryptoInfo;
      this.aWc = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */