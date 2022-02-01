package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  protected Surface kTO;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> kTP;
  public a<x> kTQ;
  volatile boolean kTR;
  volatile boolean kTS;
  final Object kTT;
  private d kTU;
  public boolean kTl;
  private kotlin.g.a.b<? super b, x> krO;
  
  public b(d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    this.kTU = paramd;
    this.krO = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.kTT = new Object();
  }
  
  public final Surface aUA()
  {
    Surface localSurface = this.kTO;
    if (localSurface == null) {
      p.bGy("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void aUB();
  
  public abstract long aUC();
  
  public abstract void aUx();
  
  public abstract void aUy();
  
  protected final Surface aUz()
  {
    Surface localSurface = this.kTO;
    if (localSurface == null) {
      p.bGy("codecSurface");
    }
    return localSurface;
  }
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.k(paramByteBuffer, "buffer");
    p.k(paramBufferInfo, "bufferInfo");
    Log.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + p.h(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.kTP;
    if (localm != null) {
      localm.invoke(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void h(Surface paramSurface)
  {
    p.k(paramSurface, "<set-?>");
    this.kTO = paramSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.e.b
 * JD-Core Version:    0.7.0.1
 */