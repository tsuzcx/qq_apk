package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e
{
  public final String TAG;
  public m<? super MediaFormat, ? super e, z> glx;
  final aq handler;
  final b<MediaFormat, z> hlu;
  public f hom;
  boolean hon;
  public HandlerThread hoo;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z> hop;
  public final com.tencent.mm.media.f.a hoq;
  final Object lock;
  
  private e(com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(93776);
    this.hoq = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new aq(parama);
    ae.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.hoq.atO();
    this.hop = ((r)new a(this));
    this.hlu = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
  static final class a
    extends q
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
  {
    a(e parame)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
    static final class a
      implements Runnable
    {
      a(MediaFormat paramMediaFormat, e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(93763);
        m localm = this.hot.hor.glx;
        if (localm != null)
        {
          localm.p(this.hos, this.hot.hor);
          AppMethodBeat.o(93763);
          return;
        }
        AppMethodBeat.o(93763);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
  static final class b
    extends q
    implements b<MediaFormat, z>
  {
    b(e parame)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, MediaFormat paramMediaFormat) {}
      
      public final void run()
      {
        AppMethodBeat.i(93765);
        m localm = this.hou.hor.glx;
        if (localm != null)
        {
          localm.p(this.hov, this.hou.hor);
          AppMethodBeat.o(93765);
          return;
        }
        AppMethodBeat.o(93765);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class c
    extends q
    implements b<f, z>
  {
    public c(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class d
    extends q
    implements b<f, z>
  {
    public d(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
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