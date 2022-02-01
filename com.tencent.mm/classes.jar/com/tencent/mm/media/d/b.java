package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  public boolean god;
  protected Surface gqq;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> gqr;
  public a<y> gqs;
  volatile boolean gqt;
  volatile boolean gqu;
  final Object gqv;
  private d gqw;
  private d.g.a.b<? super b, y> gqx;
  
  public b(d paramd, d.g.a.b<? super b, y> paramb)
  {
    this.gqw = paramd;
    this.gqx = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.gqv = new Object();
  }
  
  public abstract void ajF();
  
  public abstract void ajG();
  
  protected final Surface ajH()
  {
    Surface localSurface = this.gqq;
    if (localSurface == null) {
      k.aPZ("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void ajI();
  
  public abstract long ajJ();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    k.h(paramByteBuffer, "buffer");
    k.h(paramBufferInfo, "bufferInfo");
    ad.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + k.g(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.gqr;
    if (localm != null) {
      localm.n(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.gqq;
    if (localSurface == null) {
      k.aPZ("codecSurface");
    }
    return localSurface;
  }
  
  protected final void h(Surface paramSurface)
  {
    k.h(paramSurface, "<set-?>");
    this.gqq = paramSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */