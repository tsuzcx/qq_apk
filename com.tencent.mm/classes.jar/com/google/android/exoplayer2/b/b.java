package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public byte[] aQD;
  public int[] aQE;
  public int[] aQF;
  public int aQG;
  public int aQH;
  public int aQI;
  public final MediaCodec.CryptoInfo aQJ;
  private final a aQK;
  public byte[] key;
  public int mode;
  
  public b()
  {
    AppMethodBeat.i(91848);
    if (x.SDK_INT >= 16) {}
    for (Object localObject1 = new MediaCodec.CryptoInfo();; localObject1 = null)
    {
      this.aQJ = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.aQJ, (byte)0);
      }
      this.aQK = ((a)localObject1);
      AppMethodBeat.o(91848);
      return;
    }
  }
  
  public final void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91849);
    this.aQG = paramInt1;
    this.aQE = paramArrayOfInt1;
    this.aQF = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.aQD = paramArrayOfByte2;
    this.mode = paramInt2;
    this.aQH = paramInt3;
    this.aQI = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.aQJ.numSubSamples = this.aQG;
      this.aQJ.numBytesOfClearData = this.aQE;
      this.aQJ.numBytesOfEncryptedData = this.aQF;
      this.aQJ.key = this.key;
      this.aQJ.iv = this.aQD;
      this.aQJ.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.aQK;
        paramInt1 = this.aQH;
        paramInt2 = this.aQI;
        paramArrayOfInt1.aQL.set(paramInt1, paramInt2);
        paramArrayOfInt1.aQJ.setPattern(paramArrayOfInt1.aQL);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  @TargetApi(24)
  static final class a
  {
    final MediaCodec.CryptoInfo aQJ;
    final MediaCodec.CryptoInfo.Pattern aQL;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.aQJ = paramCryptoInfo;
      this.aQL = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */