package com.tencent.mm.media.d;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a eUw;
  private List<d.b> eUt;
  private boolean eUu;
  private d.c eUv;
  
  static
  {
    AppMethodBeat.i(12942);
    eUw = new d.a((byte)0);
    AppMethodBeat.o(12942);
  }
  
  public d(MediaFormat paramMediaFormat, m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> paramm, a.f.a.a<y> parama)
  {
    super(paramMediaFormat, paramm, parama);
    AppMethodBeat.i(12941);
    this.eUt = Collections.synchronizedList((List)new ArrayList());
    this.eUv = new d.c(this);
    try
    {
      this.eUg.setCallback((MediaCodec.Callback)this.eUv);
      this.eUg.start();
      AppMethodBeat.o(12941);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", (Throwable)paramMediaFormat, "", new Object[0]);
      AppMethodBeat.o(12941);
    }
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(12940);
    j.q(paramArrayOfByte, "data");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new d.b(paramArrayOfByte, paramLong, paramBoolean);
      this.eUt.add(paramArrayOfByte);
    }
    AppMethodBeat.o(12940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.d.d
 * JD-Core Version:    0.7.0.1
 */