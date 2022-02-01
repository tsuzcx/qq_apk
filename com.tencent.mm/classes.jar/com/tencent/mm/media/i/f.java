package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "Landroid/media/MediaFormat;", "format", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "Lkotlin/Function2;", "getVideoEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setVideoEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final String TAG;
  int frameCount;
  String mhx;
  com.tencent.mm.media.f.a nCS;
  int nCT;
  int nCU;
  b<? super String, ah> nCV;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> nCW;
  public q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, ah> nCX;
  public b<? super b<? super String, ah>, ah> nCY;
  public kotlin.g.a.a<ah> nCZ;
  int nCg;
  h nCl;
  int nxj;
  String outputFilePath;
  
  public f(h paramh, com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93820);
    this.TAG = "MicroMsg.RemuxerCallback";
    this.outputFilePath = "";
    this.mhx = "";
    this.nCW = ((m)new d(this));
    this.nCX = ((q)new a(this));
    this.nCY = ((b)new c(this));
    this.nCZ = ((kotlin.g.a.a)new b(this));
    this.mhx = (paramString + '_' + System.currentTimeMillis() + ".mp4");
    this.nCl = paramh;
    this.nCS = parama;
    this.outputFilePath = paramString;
    this.nCT = paramInt2;
    this.nCU = 1;
    this.nxj = paramInt1;
    AppMethodBeat.o(93820);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, ah>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<b<? super String, ? extends ah>, ah>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<ByteBuffer, MediaCodec.BufferInfo, ah>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.f
 * JD-Core Version:    0.7.0.1
 */