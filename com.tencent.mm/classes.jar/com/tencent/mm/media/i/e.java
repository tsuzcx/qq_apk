package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"})
public final class e
{
  public final String TAG;
  public m<? super MediaFormat, ? super e, x> gWp;
  final MMHandler handler;
  final b<MediaFormat, x> ieq;
  public f ihG;
  boolean ihH;
  public HandlerThread ihI;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x> ihJ;
  public final com.tencent.mm.media.f.a ihK;
  final Object lock;
  
  private e(com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(93776);
    this.ihK = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new MMHandler(parama);
    Log.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.ihK.aMq();
    this.ihJ = ((r)new a(this));
    this.ieq = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
  static final class a
    extends q
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x>
  {
    a(e parame)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onDecode$1$1$1"})
    static final class a
      implements Runnable
    {
      a(MediaFormat paramMediaFormat, e.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(93763);
        m localm = this.ihN.ihL.gWp;
        if (localm != null)
        {
          localm.invoke(this.ihM, this.ihN.ihL);
          AppMethodBeat.o(93763);
          return;
        }
        AppMethodBeat.o(93763);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;", "invoke"})
  static final class b
    extends q
    implements b<MediaFormat, x>
  {
    b(e parame)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect$onFormatChanged$1$1$1"})
    static final class a
      implements Runnable
    {
      a(e.b paramb, MediaFormat paramMediaFormat) {}
      
      public final void run()
      {
        AppMethodBeat.i(93765);
        m localm = this.ihO.ihL.gWp;
        if (localm != null)
        {
          localm.invoke(this.ihP, this.ihO.ihL);
          AppMethodBeat.o(93765);
          return;
        }
        AppMethodBeat.o(93765);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class c
    extends q
    implements b<f, x>
  {
    public c(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "invoke"})
  public static final class d
    extends q
    implements b<f, x>
  {
    public d(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.e
 * JD-Core Version:    0.7.0.1
 */