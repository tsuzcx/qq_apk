package com.tencent.mm.media.g;

import a.f.a.m;
import a.f.a.q;
import a.f.b.k;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  final a.f.a.b<MediaFormat, y> eRV;
  final q<ByteBuffer, Long, MediaCodec.BufferInfo, y> eWB;
  final a eWC;
  com.tencent.mm.media.c.b eWv;
  boolean eWw;
  m<? super MediaFormat, ? super f, y> evL;
  final ak handler;
  final Object lock;
  
  public f(a parama)
  {
    AppMethodBeat.i(13039);
    this.eWC = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new ak(parama);
    ab.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.eWC.UT();
    this.eWB = ((q)new f.a(this));
    this.eRV = ((a.f.a.b)new f.b(this));
    AppMethodBeat.o(13039);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  static final class c
    extends k
    implements a.f.a.b<com.tencent.mm.media.c.b, y>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  static final class d
    extends k
    implements a.f.a.b<com.tencent.mm.media.c.b, y>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.f
 * JD-Core Version:    0.7.0.1
 */