package com.tencent.mm.media.h;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.a.m;
import d.g.a.q;
import d.y;
import java.nio.ByteBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "Landroid/media/MediaFormat;", "format", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "Lkotlin/Function2;", "getVideoEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setVideoEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class g
{
  final String TAG;
  String fMx;
  int frameCount;
  int gmX;
  int gta;
  i gtg;
  com.tencent.mm.media.e.a guh;
  int gui;
  int guj;
  b<? super String, y> guk;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> gul;
  public q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, y> gum;
  public b<? super b<? super String, y>, y> gun;
  public d.g.a.a<y> guo;
  String outputFilePath;
  
  public g(i parami, com.tencent.mm.media.e.a parama, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93820);
    this.TAG = "MicroMsg.RemuxerCallback";
    this.outputFilePath = "";
    this.fMx = "";
    this.gul = ((m)new d(this));
    this.gum = ((q)new a(this));
    this.gun = ((b)new c(this));
    this.guo = ((d.g.a.a)new b(this));
    this.fMx = (paramString + "_" + System.currentTimeMillis() + ".mp4");
    this.gtg = parami;
    this.guh = parama;
    this.outputFilePath = paramString;
    this.gui = paramInt2;
    this.guj = 1;
    this.gmX = paramInt1;
    AppMethodBeat.o(93820);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class a
    extends d.g.b.l
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, y>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<b<? super String, ? extends y>, y>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class d
    extends d.g.b.l
    implements m<ByteBuffer, MediaCodec.BufferInfo, y>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.g
 * JD-Core Version:    0.7.0.1
 */