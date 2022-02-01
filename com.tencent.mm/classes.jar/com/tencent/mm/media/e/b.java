package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  public boolean hiN;
  protected Surface hjq;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, z> hjr;
  public a<z> hjs;
  volatile boolean hjt;
  volatile boolean hju;
  final Object hjv;
  private d hjw;
  private d.g.a.b<? super b, z> hjx;
  
  public b(d paramd, d.g.a.b<? super b, z> paramb)
  {
    this.hjw = paramd;
    this.hjx = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.hjv = new Object();
  }
  
  public abstract void ats();
  
  public abstract void att();
  
  protected final Surface atu()
  {
    Surface localSurface = this.hjq;
    if (localSurface == null) {
      p.bcb("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void atv();
  
  public abstract long atw();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.h(paramByteBuffer, "buffer");
    p.h(paramBufferInfo, "bufferInfo");
    ad.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + p.i(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.hjr;
    if (localm != null) {
      localm.p(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void g(Surface paramSurface)
  {
    p.h(paramSurface, "<set-?>");
    this.hjq = paramSurface;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.hjq;
    if (localSurface == null) {
      p.bcb("codecSurface");
    }
    return localSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.b
 * JD-Core Version:    0.7.0.1
 */