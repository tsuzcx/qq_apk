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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/MediaCodecCheckVideoCropRect;", "", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "calbackInMainThread", "", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Z)V", "TAG", "", "callback", "Lkotlin/Function2;", "Landroid/media/MediaFormat;", "Lkotlin/ParameterName;", "name", "mediaFormat", "checker", "", "decodeThread", "Landroid/os/HandlerThread;", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invokeCallback", "lock", "Ljava/lang/Object;", "onDecode", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Landroid/media/MediaCodec$BufferInfo;", "onFormatChanged", "Lkotlin/Function1;", "getCropBottom", "", "getCropLeft", "getCropRight", "getCropTop", "hasCropRect", "startCheck", "stopDecoder", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final String TAG;
  final MMHandler handler;
  final Object lock;
  public m<? super MediaFormat, ? super d, ah> mgM;
  public final com.tencent.mm.media.f.a nBM;
  public f nBN;
  boolean nBO;
  public HandlerThread nBP;
  final r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, ah> nBQ;
  final b<MediaFormat, ah> nyM;
  
  private d(com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(93776);
    this.nBM = parama;
    this.lock = new Object();
    this.TAG = "MicroMsg.MediaCodecCheckVideoCropRect";
    Looper localLooper = Looper.myLooper();
    parama = localLooper;
    if (localLooper == null) {
      parama = Looper.getMainLooper();
    }
    this.handler = new MMHandler(parama);
    Log.i(this.TAG, "create MediaCodecCheckVideoCropRect");
    this.nBM.bpn();
    this.nBQ = ((r)new a(this));
    this.nyM = ((b)new b(this));
    AppMethodBeat.o(93776);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, ah>
  {
    a(d paramd)
    {
      super();
    }
    
    private static final void a(d paramd, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(237778);
      s.u(paramd, "this$0");
      m localm = paramd.mgM;
      if (localm != null) {
        localm.invoke(paramMediaFormat, paramd);
      }
      AppMethodBeat.o(237778);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "mediaFormat", "Landroid/media/MediaFormat;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<MediaFormat, ah>
  {
    b(d paramd)
    {
      super();
    }
    
    private static final void a(d paramd, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(237771);
      s.u(paramd, "this$0");
      s.u(paramMediaFormat, "$mediaFormat");
      m localm = paramd.mgM;
      if (localm != null) {
        localm.invoke(paramMediaFormat, paramd);
      }
      AppMethodBeat.o(237771);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements b<f, ah>
  {
    public c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements b<f, ah>
  {
    public d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    public e(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.d
 * JD-Core Version:    0.7.0.1
 */