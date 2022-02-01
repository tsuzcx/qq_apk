package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int bhd;
  public int bhe;
  public final MediaCodec.CryptoInfo bhf;
  private final a bhg;
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
      this.bhf = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (x.SDK_INT >= 24) {
        localObject1 = new a(this.bhf, (byte)0);
      }
      this.bhg = ((a)localObject1);
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
    this.bhd = paramInt3;
    this.bhe = paramInt4;
    if (x.SDK_INT >= 16)
    {
      this.bhf.numSubSamples = this.numSubSamples;
      this.bhf.numBytesOfClearData = this.numBytesOfClearData;
      this.bhf.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
      this.bhf.key = this.key;
      this.bhf.iv = this.iv;
      this.bhf.mode = this.mode;
      if (x.SDK_INT >= 24)
      {
        paramArrayOfInt1 = this.bhg;
        paramInt1 = this.bhd;
        paramInt2 = this.bhe;
        paramArrayOfInt1.bhh.set(paramInt1, paramInt2);
        paramArrayOfInt1.bhf.setPattern(paramArrayOfInt1.bhh);
      }
    }
    AppMethodBeat.o(91849);
  }
  
  @TargetApi(24)
  static final class a
  {
    final MediaCodec.CryptoInfo bhf;
    final MediaCodec.CryptoInfo.Pattern bhh;
    
    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      AppMethodBeat.i(91847);
      this.bhf = paramCryptoInfo;
      this.bhh = new MediaCodec.CryptoInfo.Pattern(0, 0);
      AppMethodBeat.o(91847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */