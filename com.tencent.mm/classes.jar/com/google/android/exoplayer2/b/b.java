package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int bhg;
  public int bhh;
  public final MediaCodec.CryptoInfo bhi;
  private final a bhj;
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
      this.bhi = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.bhi, (byte)0);
      }
      this.bhj = ((a)localObject1);
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
    this.bhg = paramInt3;
    this.bhh = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.bhi.numSubSamples = this.numSubSamples;
      this.bhi.numBytesOfClearData = this.numBytesOfClearData;
      this.bhi.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.bhi.key = this.key;
      this.bhi.iv = this.iv;
      this.bhi.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.bhj;
        paramInt1 = this.bhg;
        paramInt2 = this.bhh;
        paramArrayOfInt1.bhk.set(paramInt1, paramInt2);
        paramArrayOfInt1.bhi.setPattern(paramArrayOfInt1.bhk);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  @TargetApi(24)
  static final class a
  {
    final MediaCodec.CryptoInfo bhi;
    final MediaCodec.CryptoInfo.Pattern bhk;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.bhi = paramCryptoInfo;
      this.bhk = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */