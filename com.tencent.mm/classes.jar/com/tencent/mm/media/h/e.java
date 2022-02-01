package com.tencent.mm.media.h;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.c.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.y;
import java.nio.ByteBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e
{
  public final String TAG;
  public m<? super MediaFormat, ? super e, y> fPF;
  final b<MediaFormat, y> gOH;
  public final com.tencent.mm.media.e.a gTA;
  public f gTw;
  boolean gTx;
  public HandlerThread gTy;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y> gTz;
  final ao handler;
  final Object lock;
  
  private e(com.tencent.mm.media.e.a parama)
  {
    AppMethodBeat.i(93776);
    this.gTA = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new ao(parama);
    ac.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.gTA.aqL();
    this.gTz = ((r)new a(this));
    this.gOH = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y>
  {
    a(e parame)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
    static final class a
      implements Runnable
    {
      a(MediaFormat paramMediaFormat, e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(93763);
        m localm = this.gTD.gTB.fPF;
        if (localm != null)
        {
          localm.n(this.gTC, this.gTD.gTB);
          AppMethodBeat.o(93763);
          return;
        }
        AppMethodBeat.o(93763);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<MediaFormat, y>
  {
    b(e parame)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, MediaFormat paramMediaFormat) {}
      
      public final void run()
      {
        AppMethodBeat.i(93765);
        m localm = this.gTE.gTB.fPF;
        if (localm != null)
        {
          localm.n(this.gTF, this.gTE.gTB);
          AppMethodBeat.o(93765);
          return;
        }
        AppMethodBeat.o(93765);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class c
    extends d.g.b.l
    implements b<f, y>
  {
    public c(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class d
    extends d.g.b.l
    implements b<f, y>
  {
    public d(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.h.e
 * JD-Core Version:    0.7.0.1
 */