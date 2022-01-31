package com.tencent.mm.media.g;

import a.f.a.b;
import a.f.a.m;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "outputFilePath", "", "type", "", "outputSampleRate", "outputChannelCount", "(Lcom/tencent/mm/media/remuxer/MixMuxerController;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;III)V", "TAG", "audioEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "getAudioEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setAudioEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "backgroundMediaExtractor", "drawCallback", "Lkotlin/Function0;", "getDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "encodeEndCallback", "Lkotlin/Function1;", "path", "encodeFinish", "getEncodeEndCallback", "()Lkotlin/jvm/functions/Function1;", "setEncodeEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "frameCount", "mixFinishCallback", "mixType", "tempPath", "videoEncodeCallback", "getVideoEncodeCallback", "setVideoEncodeCallback", "videoRotate", "getVideoRotate", "()I", "setVideoRotate", "(I)V", "finishMix", "plugin-mediaeditor_release"})
public final class h
{
  final String TAG;
  int eRn;
  int eWL;
  j eWS;
  com.tencent.mm.media.e.a eXK;
  int eXL;
  int eXM;
  b<? super String, y> eXN;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> eXO;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> eXP;
  public b<? super b<? super String, y>, y> eXQ;
  public a.f.a.a<y> eXR;
  String eXn;
  String ewk;
  int frameCount;
  
  public h(j paramj, com.tencent.mm.media.e.a parama, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13073);
    this.TAG = "MicroMsg.RemuxerCallback";
    this.eXn = "";
    this.ewk = "";
    this.eXO = ((m)new h.d(this));
    this.eXP = ((m)new h.a(this));
    this.eXQ = ((b)new h.c(this));
    this.eXR = ((a.f.a.a)new h.b(this));
    this.ewk = (paramString + "_" + System.currentTimeMillis() + ".mp4");
    this.eWS = paramj;
    this.eXK = parama;
    this.eXn = paramString;
    this.eXL = paramInt2;
    this.eXM = 1;
    this.eRn = paramInt1;
    AppMethodBeat.o(13073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.g.h
 * JD-Core Version:    0.7.0.1
 */