package com.google.android.exoplayer2.b;

import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer2.i.t;

public final class b
{
  public int ayq;
  public int ayr;
  public final MediaCodec.CryptoInfo ays;
  public final b.a ayt;
  public byte[] iv;
  public byte[] key;
  public int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  public int numSubSamples;
  
  public b()
  {
    if (t.SDK_INT >= 16) {}
    for (Object localObject1 = new MediaCodec.CryptoInfo();; localObject1 = null)
    {
      this.ays = ((MediaCodec.CryptoInfo)localObject1);
      localObject1 = localObject2;
      if (t.SDK_INT >= 24) {
        localObject1 = new b.a(this.ays, (byte)0);
      }
      this.ayt = ((b.a)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.7.0.1
 */