package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  public boolean hlB;
  protected Surface hme;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, z> hmf;
  public a<z> hmg;
  volatile boolean hmh;
  volatile boolean hmi;
  final Object hmj;
  private d hmk;
  private d.g.a.b<? super b, z> hml;
  
  public b(d paramd, d.g.a.b<? super b, z> paramb)
  {
    this.hmk = paramd;
    this.hml = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.hmj = new Object();
  }
  
  public abstract void atH();
  
  public abstract void atI();
  
  protected final Surface atJ()
  {
    Surface localSurface = this.hme;
    if (localSurface == null) {
      p.bdF("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void atK();
  
  public abstract long atL();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.h(paramByteBuffer, "buffer");
    p.h(paramBufferInfo, "bufferInfo");
    ae.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + p.i(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.hmf;
    if (localm != null) {
      localm.p(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void g(Surface paramSurface)
  {
    p.h(paramSurface, "<set-?>");
    this.hme = paramSurface;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.hme;
    if (localSurface == null) {
      p.bdF("codecSurface");
    }
    return localSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.b
 * JD-Core Version:    0.7.0.1
 */