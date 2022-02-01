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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public int frameNum;
  public boolean iex;
  protected Surface ifa;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> ifb;
  public a<x> ifc;
  volatile boolean ifd;
  volatile boolean ife;
  final Object iff;
  private d ifg;
  private kotlin.g.a.b<? super b, x> ifh;
  
  public b(d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    this.ifg = paramd;
    this.ifh = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.iff = new Object();
  }
  
  public abstract void aMi();
  
  public abstract void aMj();
  
  protected final Surface aMk()
  {
    Surface localSurface = this.ifa;
    if (localSurface == null) {
      p.btv("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void aMl();
  
  public abstract long aMm();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.h(paramByteBuffer, "buffer");
    p.h(paramBufferInfo, "bufferInfo");
    Log.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + p.j(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.ifb;
    if (localm != null) {
      localm.invoke(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void g(Surface paramSurface)
  {
    p.h(paramSurface, "<set-?>");
    this.ifa = paramSurface;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.ifa;
    if (localSurface == null) {
      p.btv("codecSurface");
    }
    return localSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.e.b
 * JD-Core Version:    0.7.0.1
 */