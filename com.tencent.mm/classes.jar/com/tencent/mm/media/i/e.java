package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e
{
  public final String TAG;
  public m<? super MediaFormat, ? super e, z> gjf;
  final ap handler;
  final b<MediaFormat, z> hiG;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z> hlA;
  public final com.tencent.mm.media.f.a hlB;
  public f hlx;
  boolean hly;
  public HandlerThread hlz;
  final Object lock;
  
  private e(com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(93776);
    this.hlB = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new ap(parama);
    ad.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.hlB.atz();
    this.hlA = ((r)new a(this));
    this.hiG = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
  static final class a
    extends q
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
  {
    a(e parame)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
    static final class a
      implements Runnable
    {
      a(MediaFormat paramMediaFormat, e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(93763);
        m localm = this.hlE.hlC.gjf;
        if (localm != null)
        {
          localm.p(this.hlD, this.hlE.hlC);
          AppMethodBeat.o(93763);
          return;
        }
        AppMethodBeat.o(93763);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
  static final class b
    extends q
    implements b<MediaFormat, z>
  {
    b(e parame)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, MediaFormat paramMediaFormat) {}
      
      public final void run()
      {
        AppMethodBeat.i(93765);
        m localm = this.hlF.hlC.gjf;
        if (localm != null)
        {
          localm.p(this.hlG, this.hlF.hlC);
          AppMethodBeat.o(93765);
          return;
        }
        AppMethodBeat.o(93765);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class c
    extends q
    implements b<f, z>
  {
    public c(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class d
    extends q
    implements b<f, z>
  {
    public d(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.i.e
 * JD-Core Version:    0.7.0.1
 */