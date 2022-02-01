package com.google.android.exoplayer2.b;

import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int[] cKA;
  public int[] cKB;
  public int cKC;
  public int cKD;
  public int cKE;
  public final MediaCodec.CryptoInfo cKF;
  private final a cKG;
  public byte[] cKz;
  public byte[] key;
  public int mode;
  
  public b()
  {
    AppMethodBeat.i(91848);
    if (x.SDK_INT >= 16) {}
    for (Object localObject1 = new MediaCodec.CryptoInfo();; localObject1 = null)
    {
      this.cKF = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.cKF, (byte)0);
      }
      this.cKG = ((a)localObject1);
      AppMethodBeat.o(91848);
      return;
    }
  }
  
  public final void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91849);
    this.cKC = paramInt1;
    this.cKA = paramArrayOfInt1;
    this.cKB = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.cKz = paramArrayOfByte2;
    this.mode = paramInt2;
    this.cKD = paramInt3;
    this.cKE = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.cKF.numSubSamples = this.cKC;
      this.cKF.numBytesOfClearData = this.cKA;
      this.cKF.numBytesOfEncryptedData = this.cKB;
      this.cKF.key = this.key;
      this.cKF.iv = this.cKz;
      this.cKF.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.cKG;
        paramInt1 = this.cKD;
        paramInt2 = this.cKE;
        paramArrayOfInt1.cKH.set(paramInt1, paramInt2);
        paramArrayOfInt1.cKF.setPattern(paramArrayOfInt1.cKH);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  static final class a
  {
    final MediaCodec.CryptoInfo cKF;
    final MediaCodec.CryptoInfo.Pattern cKH;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.cKF = paramCryptoInfo;
      this.cKH = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */