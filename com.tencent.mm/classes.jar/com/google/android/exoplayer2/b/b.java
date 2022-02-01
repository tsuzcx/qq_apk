package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int aWL;
  public int aWM;
  public final MediaCodec.CryptoInfo aWN;
  private final a aWO;
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
      this.aWN = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.aWN, (byte)0);
      }
      this.aWO = ((a)localObject1);
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
    this.aWL = paramInt3;
    this.aWM = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.aWN.numSubSamples = this.numSubSamples;
      this.aWN.numBytesOfClearData = this.numBytesOfClearData;
      this.aWN.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.aWN.key = this.key;
      this.aWN.iv = this.iv;
      this.aWN.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.aWO;
        paramInt1 = this.aWL;
        paramInt2 = this.aWM;
        paramArrayOfInt1.aWP.set(paramInt1, paramInt2);
        paramArrayOfInt1.aWN.setPattern(paramArrayOfInt1.aWP);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  @TargetApi(24)
  static final class a
  {
    final MediaCodec.CryptoInfo aWN;
    final MediaCodec.CryptoInfo.Pattern aWP;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.aWN = paramCryptoInfo;
      this.aWP = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */