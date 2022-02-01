package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.a.m;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "Landroid/media/MediaFormat;", "format", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "Lkotlin/Function2;", "getVideoEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setVideoEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class g
{
  final String TAG;
  int frameCount;
  String gmc;
  int hku;
  i hoD;
  int hoy;
  com.tencent.mm.media.f.a hpD;
  int hpE;
  int hpF;
  b<? super String, z> hpG;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, z> hpH;
  public d.g.a.q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, z> hpI;
  public b<? super b<? super String, z>, z> hpJ;
  public d.g.a.a<z> hpK;
  String outputFilePath;
  
  public g(i parami, com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93820);
    this.TAG = "MicroMsg.RemuxerCallback";
    this.outputFilePath = "";
    this.gmc = "";
    this.hpH = ((m)new d(this));
    this.hpI = ((d.g.a.q)new a(this));
    this.hpJ = ((b)new c(this));
    this.hpK = ((d.g.a.a)new b(this));
    this.gmc = (paramString + "_" + System.currentTimeMillis() + ".mp4");
    this.hoD = parami;
    this.hpD = parama;
    this.outputFilePath = paramString;
    this.hpE = paramInt2;
    this.hpF = 1;
    this.hku = paramInt1;
    AppMethodBeat.o(93820);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
  static final class c
    extends d.g.b.q
    implements b<b<? super String, ? extends z>, z>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class d
    extends d.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, z>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.i.g
 * JD-Core Version:    0.7.0.1
 */