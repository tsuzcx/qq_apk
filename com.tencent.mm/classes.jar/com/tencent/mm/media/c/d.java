package com.tencent.mm.media.c;

import a.f.a.m;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoderAsync";
  public static final d.a eSm;
  private int eSj;
  private long eSk;
  private MediaCodec.Callback eSl;
  
  static
  {
    AppMethodBeat.i(12861);
    eSm = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoderAsync";
    AppMethodBeat.o(12861);
  }
  
  public d(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, a.f.a.a<y> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(12860);
    this.eSk = paramLong2;
    this.eSl = ((MediaCodec.Callback)new d.b(this, paramString, paramLong1, parama));
    Uy().setCallback(this.eSl);
    AppMethodBeat.o(12860);
  }
  
  public final void Uz()
  {
    AppMethodBeat.i(12859);
    try
    {
      Uy().start();
      ab.i(TAG, "startDecoder " + this.ceu);
      AppMethodBeat.o(12859);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(TAG, (Throwable)localException, "startDecoder error", new Object[0]);
      AppMethodBeat.o(12859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.c.d
 * JD-Core Version:    0.7.0.1
 */