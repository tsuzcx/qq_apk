package com.tencent.mm.media.d;

import a.f.a.a;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "", "getUseInRemuxer", "()Z", "setUseInRemuxer", "(Z)V", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "release", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  private final String TAG;
  public boolean eSb;
  protected Surface eUn;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> eUo;
  public a<y> eUp;
  private c eUq;
  private a.f.a.b<? super b, y> eUr;
  public int frameNum;
  
  public b(c paramc, a.f.a.b<? super b, y> paramb)
  {
    this.eUq = paramc;
    this.eUr = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
  }
  
  public abstract void UN();
  
  protected final Surface UO()
  {
    Surface localSurface = this.eUn;
    if (localSurface == null) {
      j.ays("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void UP();
  
  public abstract long UQ();
  
  protected final void e(Surface paramSurface)
  {
    j.q(paramSurface, "<set-?>");
    this.eUn = paramSurface;
  }
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    j.q(paramByteBuffer, "buffer");
    j.q(paramBufferInfo, "bufferInfo");
    ab.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + j.e(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.eUo;
    if (localm != null) {
      localm.h(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  public final Surface getInputSurface()
  {
    Surface localSurface = this.eUn;
    if (localSurface == null) {
      j.ays("codecSurface");
    }
    return localSurface;
  }
  
  public abstract void release();
  
  public abstract void releaseEncoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */