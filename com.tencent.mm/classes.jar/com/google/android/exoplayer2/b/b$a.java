package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(24)
final class b$a
{
  final MediaCodec.CryptoInfo aAH;
  final MediaCodec.CryptoInfo.Pattern aAJ;
  
  private b$a(MediaCodec.CryptoInfo paramCryptoInfo)
  {
    AppMethodBeat.i(94736);
    this.aAH = paramCryptoInfo;
    this.aAJ = new MediaCodec.CryptoInfo.Pattern(0, 0);
    AppMethodBeat.o(94736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b.a
 * JD-Core Version:    0.7.0.1
 */