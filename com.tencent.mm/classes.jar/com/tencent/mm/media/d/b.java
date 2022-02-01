package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  public boolean gON;
  protected Surface gQY;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> gQZ;
  public a<y> gRa;
  volatile boolean gRb;
  volatile boolean gRc;
  final Object gRd;
  private d gRe;
  private d.g.a.b<? super b, y> gRf;
  
  public b(d paramd, d.g.a.b<? super b, y> paramb)
  {
    this.gRe = paramd;
    this.gRf = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.gRd = new Object();
  }
  
  public abstract void aqE();
  
  public abstract void aqF();
  
  protected final Surface aqG()
  {
    Surface localSurface = this.gQY;
    if (localSurface == null) {
      k.aVY("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void aqH();
  
  public abstract long aqI();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    k.h(paramByteBuffer, "buffer");
    k.h(paramBufferInfo, "bufferInfo");
    ac.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + k.g(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.gQZ;
    if (localm != null) {
      localm.n(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void g(Surface paramSurface)
  {
    k.h(paramSurface, "<set-?>");
    this.gQY = paramSurface;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.gQY;
    if (localSurface == null) {
      k.aVY("codecSurface");
    }
    return localSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */