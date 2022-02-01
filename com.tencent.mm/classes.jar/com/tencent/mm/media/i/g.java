package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "Landroid/media/MediaFormat;", "format", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "Lkotlin/Function2;", "getVideoEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setVideoEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class g
{
  final String TAG;
  int frameCount;
  String gWS;
  int idq;
  int ihS;
  i ihX;
  com.tencent.mm.media.f.a iiY;
  int iiZ;
  int ija;
  b<? super String, x> ijb;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> ijc;
  public kotlin.g.a.q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> ijd;
  public b<? super b<? super String, x>, x> ije;
  public kotlin.g.a.a<x> ijf;
  String outputFilePath;
  
  public g(i parami, com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93820);
    this.TAG = "MicroMsg.RemuxerCallback";
    this.outputFilePath = "";
    this.gWS = "";
    this.ijc = ((m)new d(this));
    this.ijd = ((kotlin.g.a.q)new a(this));
    this.ije = ((b)new c(this));
    this.ijf = ((kotlin.g.a.a)new b(this));
    this.gWS = (paramString + "_" + System.currentTimeMillis() + ".mp4");
    this.ihX = parami;
    this.iiY = parama;
    this.outputFilePath = paramString;
    this.iiZ = paramInt2;
    this.ija = 1;
    this.idq = paramInt1;
    AppMethodBeat.o(93820);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<b<? super String, ? extends x>, x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, x>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.g
 * JD-Core Version:    0.7.0.1
 */