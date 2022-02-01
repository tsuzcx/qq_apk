package com.tencent.mm.media.h;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.media.c.f;
import com.tencent.mm.media.c.i;
import com.tencent.mm.media.c.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e
{
  final String TAG;
  m<? super MediaFormat, ? super e, y> fLT;
  final b<MediaFormat, y> gnW;
  f gsO;
  boolean gsP;
  private HandlerThread gsQ;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y> gsR;
  private final com.tencent.mm.media.e.a gsS;
  final ap handler;
  final Object lock;
  
  private e(com.tencent.mm.media.e.a parama)
  {
    AppMethodBeat.i(93776);
    this.gsS = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new ap(parama);
    ad.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.gsS.ajM();
    this.gsR = ((r)new a(this));
    this.gnW = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  public static boolean f(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93771);
    k.h(paramMediaFormat, "mediaFormat");
    if ((paramMediaFormat.containsKey("crop-left")) || (paramMediaFormat.containsKey("crop-top")) || (paramMediaFormat.containsKey("crop-right")) || (paramMediaFormat.containsKey("crop-bottom")))
    {
      AppMethodBeat.o(93771);
      return true;
    }
    AppMethodBeat.o(93771);
    return false;
  }
  
  public static int g(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93772);
    k.h(paramMediaFormat, "mediaFormat");
    if (paramMediaFormat.containsKey("crop-left"))
    {
      int i = paramMediaFormat.getInteger("crop-left");
      AppMethodBeat.o(93772);
      return i;
    }
    AppMethodBeat.o(93772);
    return 0;
  }
  
  public static int h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93773);
    k.h(paramMediaFormat, "mediaFormat");
    if (paramMediaFormat.containsKey("crop-right"))
    {
      int i = paramMediaFormat.getInteger("crop-right");
      AppMethodBeat.o(93773);
      return i;
    }
    AppMethodBeat.o(93773);
    return 0;
  }
  
  public static int i(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93774);
    k.h(paramMediaFormat, "mediaFormat");
    if (paramMediaFormat.containsKey("crop-top"))
    {
      int i = paramMediaFormat.getInteger("crop-top");
      AppMethodBeat.o(93774);
      return i;
    }
    AppMethodBeat.o(93774);
    return 0;
  }
  
  public static int j(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93775);
    k.h(paramMediaFormat, "mediaFormat");
    if (paramMediaFormat.containsKey("crop-bottom"))
    {
      int i = paramMediaFormat.getInteger("crop-bottom");
      AppMethodBeat.o(93775);
      return i;
    }
    AppMethodBeat.o(93775);
    return 0;
  }
  
  public final void a(m<? super MediaFormat, ? super e, y> paramm)
  {
    AppMethodBeat.i(93770);
    this.fLT = paramm;
    for (;;)
    {
      try
      {
        if (!com.tencent.mm.compatible.util.d.lf(23)) {
          continue;
        }
        localf = (f)new j(this.gsS.getDuration() / 1000, this.gsS, (b)new c(this));
        this.gsO = localf;
      }
      catch (Exception localException)
      {
        f localf;
        ad.printErrStackTrace(this.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
        com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.ami();
        paramm.n(null, this);
        continue;
      }
      this.gsQ = c.a("MediaCodecCheckVideoCropRect_decode", false, (d.g.a.a)new e(this));
      AppMethodBeat.o(93770);
      return;
      localf = (f)new i(this.gsS.getDuration() / 1000, this.gsS, (b)new d(this));
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y>
  {
    a(e parame)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
    static final class a
      implements Runnable
    {
      a(MediaFormat paramMediaFormat, e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(93763);
        m localm = this.gsV.gsT.fLT;
        if (localm != null)
        {
          localm.n(this.gsU, this.gsV.gsT);
          AppMethodBeat.o(93763);
          return;
        }
        AppMethodBeat.o(93763);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<MediaFormat, y>
  {
    b(e parame)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, MediaFormat paramMediaFormat) {}
      
      public final void run()
      {
        AppMethodBeat.i(93765);
        m localm = this.gsW.gsT.fLT;
        if (localm != null)
        {
          localm.n(this.gsX, this.gsW.gsT);
          AppMethodBeat.o(93765);
          return;
        }
        AppMethodBeat.o(93765);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<f, y>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<f, y>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.e
 * JD-Core Version:    0.7.0.1
 */