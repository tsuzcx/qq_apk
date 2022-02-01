package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "TAG", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "frameCount", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "frameDuration", "lastBufferInfoPts", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "samplePerFrame", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "checkFrameDuration", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
{
  private static final int nyI = 2048;
  private static final int nyJ = 4096;
  public static final e.a nyv = new e.a((byte)0);
  private final String TAG;
  private int audioChannelCount;
  private MediaCodec.BufferInfo bufferInfo;
  private final Object cBq;
  private String cBw;
  private long endTimeMs;
  private int frameCount;
  private String hqQ;
  MediaFormat nxp;
  protected volatile boolean nyA;
  int nyB;
  long nyC;
  private long nyD;
  private boolean nyE;
  private long nyF;
  private final int nyG;
  private long nyH;
  private com.tencent.mm.media.f.a nyw;
  public m<? super byte[], ? super Long, ah> nyx;
  public kotlin.g.a.a<ah> nyy;
  aa nyz;
  private long startTimeMs;
  
  public e(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, ah> paramm, kotlin.g.a.a<ah> parama1)
  {
    this.nyw = parama;
    this.hqQ = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.nyx = paramm;
    this.nyy = parama1;
    this.TAG = s.X("MicroMsg.IAudioDecoder@", this.hqQ);
    this.cBq = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.cBw = "";
    this.nyG = 1024;
    parama = this.nyw;
    if (parama != null)
    {
      this.nxp = parama.nAt;
      Log.i(this.TAG, "create MediaCodecAACDecoder, audioId:" + this.hqQ + ", startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs + ", mediaFormat:" + this.nxp);
      if (this.nxp != null)
      {
        paramString = this.nxp;
        s.checkNotNull(paramString);
        this.audioChannelCount = paramString.getInteger("channel-count");
        paramString = this.nxp;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.audioChannelCount * 16384);
        }
        paramString = this.nxp;
        s.checkNotNull(paramString);
        this.nyB = paramString.getInteger("sample-rate");
        paramString = this.nxp;
        s.checkNotNull(paramString);
        paramString = paramString.getString("mime");
        s.checkNotNull(paramString);
        s.s(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)!!");
        s.u(paramString, "<set-?>");
        this.cBw = paramString;
        paramString = this.nxp;
        if ((paramString == null) || (paramString.containsKey("encoder-delay") != true)) {
          break label426;
        }
        i = 1;
        if (i != 0)
        {
          paramString = this.nxp;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.nxp;
        if ((paramString == null) || (paramString.containsKey("encoder-padding") != true)) {
          break label432;
        }
      }
    }
    label426:
    label432:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = this.nxp;
        if (paramString != null) {
          paramString.setInteger("encoder-padding", 0);
        }
      }
      parama.bpo();
      if (this.startTimeMs >= 0L) {
        parama.seek(this.startTimeMs * 1000L);
      }
      this.nyz = aa.Dw(this.cBw);
      parama = this.nyz;
      if (parama != null) {
        parama.a(this.nxp, null, 0);
      }
      return;
      i = 0;
      break;
    }
  }
  
  protected final void a(MediaCodec.BufferInfo paramBufferInfo)
  {
    s.u(paramBufferInfo, "<set-?>");
    this.bufferInfo = paramBufferInfo;
  }
  
  protected final String aFS()
  {
    return this.hqQ;
  }
  
  protected final com.tencent.mm.media.f.a boN()
  {
    return this.nyw;
  }
  
  protected final Object boO()
  {
    return this.cBq;
  }
  
  protected final MediaCodec.BufferInfo boP()
  {
    return this.bufferInfo;
  }
  
  public void boQ()
  {
    Log.printDebugStack(this.TAG, "stop decoder", new Object[0]);
    synchronized (this.cBq)
    {
      Log.i(this.TAG, "stopDecoder in lock");
      try
      {
        if (!this.nyA)
        {
          this.nyA = true;
          localObject2 = this.nyz;
          if (localObject2 != null) {
            ((aa)localObject2).stop();
          }
          localObject2 = this.nyz;
          if (localObject2 != null) {
            ((aa)localObject2).release();
          }
          localObject2 = this.nyy;
          if (localObject2 != null) {
            ((kotlin.g.a.a)localObject2).invoke();
          }
          Log.i(this.TAG, hashCode() + " total decode used " + this.nyD);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = ah.aiuX;
      return;
    }
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    s.u(paramBufferInfo, "bufferInfo");
    if (this.nyF <= 0L)
    {
      this.nyF = kotlin.h.a.ai(1.0D * this.nyG / this.nyB * 1000000.0D);
      Log.i(this.TAG, s.X("checkFrameDuration, frameDuration:", Long.valueOf(this.nyF)));
    }
    if (paramByteBuffer != null)
    {
      paramByteBuffer.position(paramBufferInfo.offset);
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.position(0);
      paramByteBuffer.get(arrayOfByte);
      int i;
      long l;
      label275:
      int j;
      int m;
      int i1;
      int k;
      if (arrayOfByte.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label567;
        }
        Log.i(this.TAG, "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", diff:" + (paramBufferInfo.presentationTimeUs - this.nyH) + ", audioId:" + this.hqQ + ", frameCount:" + this.frameCount);
        l = Util.ticksToNow(this.nyC);
        this.nyD += l;
        Log.i(this.TAG, hashCode() + " decode frame cost " + l);
        this.nyE = true;
        if (this.audioChannelCount != 1) {
          break label518;
        }
        i = nyI;
        if (arrayOfByte.length <= i) {
          break label532;
        }
        j = arrayOfByte.length;
        m = 0;
        i1 = j / i;
        k = 0;
        label299:
        if (j <= 0) {
          break label567;
        }
        if (j <= i) {
          break label525;
        }
      }
      label518:
      label525:
      for (int n = i;; n = j)
      {
        paramByteBuffer = new byte[n];
        System.arraycopy(arrayOfByte, m, paramByteBuffer, 0, n);
        j -= n;
        m += n;
        k += 1;
        l = this.nyF * this.frameCount;
        Log.i(this.TAG, "split ret pcmData, leftSize:" + j + ", sizeOffset:" + m + ", maxBufferSize:" + i + ", copySize:" + n + ", data.size:" + paramByteBuffer.length + ", splitCount:" + i1 + ", bufferInfo.pts:" + paramBufferInfo.presentationTimeUs + ", pts:" + l + ", count:" + k);
        m localm = this.nyx;
        if (localm != null) {
          localm.invoke(paramByteBuffer, Long.valueOf(l));
        }
        this.frameCount += 1;
        break label299;
        i = 0;
        break;
        i = nyJ;
        break label275;
      }
      label532:
      paramByteBuffer = this.nyx;
      if (paramByteBuffer != null) {
        paramByteBuffer.invoke(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      this.frameCount += 1;
      label567:
      this.nyH = paramBufferInfo.presentationTimeUs;
    }
  }
  
  public int getChannelCount()
  {
    return this.audioChannelCount;
  }
  
  protected final long getEndTimeMs()
  {
    return this.endTimeMs;
  }
  
  public int getSampleRate()
  {
    return this.nyB;
  }
  
  protected final long getStartTimeMs()
  {
    return this.startTimeMs;
  }
  
  public abstract void startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */