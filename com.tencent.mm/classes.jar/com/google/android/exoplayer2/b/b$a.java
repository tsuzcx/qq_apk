package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
public final class b$a
{
  public final MediaCodec.CryptoInfo ays;
  public final MediaCodec.CryptoInfo.Pattern ayu;
  
  private b$a(MediaCodec.CryptoInfo paramCryptoInfo)
  {
    this.ays = paramCryptoInfo;
    this.ayu = new MediaCodec.CryptoInfo.Pattern(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b.a
 * JD-Core Version:    0.7.0.1
 */