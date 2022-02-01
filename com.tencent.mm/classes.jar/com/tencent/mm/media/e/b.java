package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.media.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecSurface", "Landroid/view/Surface;", "getCodecSurface", "()Landroid/view/Surface;", "setCodecSurface", "(Landroid/view/Surface;)V", "encoderLock", "Ljava/lang/Object;", "getEncoderLock", "()Ljava/lang/Object;", "frameNum", "", "getFrameNum", "()I", "setFrameNum", "(I)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "isFinishEncode", "", "()Z", "setFinishEncode", "(Z)V", "isRelease", "setRelease", "onEncodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "getOnEncodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnEncodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onEncodeEnd", "Lkotlin/Function0;", "getOnEncodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnEncodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "getVideoCodecConfig", "()Lcom/tencent/mm/media/config/VideoCodecConfig;", "setVideoCodecConfig", "(Lcom/tencent/mm/media/config/VideoCodecConfig;)V", "encodeFrame", "pts", "", "finishEncode", "getFrameCount", "getInputSurface", "getRecordTimes", "onEncode", "callback", "processEncodeBuffer", "buffer", "releaseEncoder", "useInRemux", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  private final String TAG;
  public int frameNum;
  private kotlin.g.a.b<? super b, ah> mVC;
  public boolean nyT;
  private volatile boolean nzA;
  private volatile boolean nzB;
  private final Object nzC;
  private d nzw;
  protected Surface nzx;
  public m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> nzy;
  public a<ah> nzz;
  
  public b(d paramd, kotlin.g.a.b<? super b, ah> paramb)
  {
    this.nzw = paramd;
    this.mVC = paramb;
    this.TAG = "MicroMsg.IMediaCodecTransEncoder";
    this.nzC = new Object();
  }
  
  public abstract void boZ();
  
  public abstract void bpa();
  
  protected final Surface bpb()
  {
    Surface localSurface = this.nzx;
    if (localSurface != null) {
      return localSurface;
    }
    s.bIx("codecSurface");
    return null;
  }
  
  protected final boolean bpc()
  {
    return this.nzA;
  }
  
  protected final void bpd()
  {
    this.nzA = true;
  }
  
  protected final boolean bpe()
  {
    return this.nzB;
  }
  
  protected final void bpf()
  {
    this.nzB = true;
  }
  
  protected final Object bpg()
  {
    return this.nzC;
  }
  
  public final Surface bph()
  {
    return bpb();
  }
  
  public abstract void bpi();
  
  public abstract long bpj();
  
  protected final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    s.u(paramByteBuffer, "buffer");
    s.u(paramBufferInfo, "bufferInfo");
    Log.i(this.TAG, "processEncodeBuffer, buffer " + paramByteBuffer + ", pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size + ", isMain: " + s.p(Looper.getMainLooper(), Looper.myLooper()));
    m localm = this.nzy;
    if (localm != null) {
      localm.invoke(paramByteBuffer, paramBufferInfo);
    }
    this.frameNum += 1;
  }
  
  protected final void l(Surface paramSurface)
  {
    s.u(paramSurface, "<set-?>");
    this.nzx = paramSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.b
 * JD-Core Version:    0.7.0.1
 */