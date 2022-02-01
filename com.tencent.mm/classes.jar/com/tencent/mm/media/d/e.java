package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "TAG", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "frameCount", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "frameDuration", "lastBufferInfoPts", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "samplePerFrame", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "checkFrameDuration", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e
{
  private static final int kSZ = 2048;
  private static final int kTa = 4096;
  public static final a kTb = new a((byte)0);
  private final String TAG;
  private final Object aFF;
  private String aFM;
  private int audioChannelCount;
  private MediaCodec.BufferInfo bufferInfo;
  private long endTimeMs;
  private String fmF;
  private int frameCount;
  MediaFormat kRH;
  aa kSN;
  protected volatile boolean kSO;
  int kSP;
  long kSQ;
  private long kSR;
  private boolean kSS;
  private long kST;
  private final int kSU;
  private long kSV;
  private com.tencent.mm.media.f.a kSW;
  public m<? super byte[], ? super Long, x> kSX;
  public kotlin.g.a.a<x> kSY;
  private long startTimeMs;
  
  public e(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, x> paramm, kotlin.g.a.a<x> parama1)
  {
    this.kSW = parama;
    this.fmF = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.kSX = paramm;
    this.kSY = parama1;
    this.TAG = ("MicroMsg.IAudioDecoder@" + this.fmF);
    this.aFF = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.aFM = "";
    this.kSU = 1024;
    parama = this.kSW;
    if (parama != null)
    {
      this.kRH = parama.kUW;
      Log.i(this.TAG, "create MediaCodecAACDecoder, audioId:" + this.fmF + ", startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs + ", mediaFormat:" + this.kRH);
      if (this.kRH != null)
      {
        paramString = this.kRH;
        if (paramString == null) {
          p.iCn();
        }
        this.audioChannelCount = paramString.getInteger("channel-count");
        paramString = this.kRH;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.audioChannelCount * 16384);
        }
        paramString = this.kRH;
        if (paramString == null) {
          p.iCn();
        }
        this.kSP = paramString.getInteger("sample-rate");
        paramString = this.kRH;
        if (paramString == null) {
          p.iCn();
        }
        paramString = paramString.getString("mime");
        p.j(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
        this.aFM = paramString;
        paramString = this.kRH;
        if ((paramString != null) && (paramString.containsKey("encoder-delay") == true))
        {
          paramString = this.kRH;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.kRH;
        if ((paramString != null) && (paramString.containsKey("encoder-padding") == true))
        {
          paramString = this.kRH;
          if (paramString != null) {
            paramString.setInteger("encoder-padding", 0);
          }
        }
        parama.aUH();
        if (this.startTimeMs >= 0L) {
          parama.seek(this.startTimeMs * 1000L);
        }
        this.kSN = aa.KR(this.aFM);
        parama = this.kSN;
        if (parama != null) {
          parama.a(this.kRH, null, 0);
        }
      }
    }
  }
  
  protected final void a(MediaCodec.BufferInfo paramBufferInfo)
  {
    p.k(paramBufferInfo, "<set-?>");
    this.bufferInfo = paramBufferInfo;
  }
  
  protected final Object aUl()
  {
    return this.aFF;
  }
  
  protected final MediaCodec.BufferInfo aUm()
  {
    return this.bufferInfo;
  }
  
  public void aUn()
  {
    Log.printDebugStack(this.TAG, "stop decoder", new Object[0]);
    synchronized (this.aFF)
    {
      Log.i(this.TAG, "stopDecoder in lock");
      try
      {
        if (!this.kSO)
        {
          this.kSO = true;
          localObject2 = this.kSN;
          if (localObject2 != null) {
            ((aa)localObject2).stop();
          }
          localObject2 = this.kSN;
          if (localObject2 != null) {
            ((aa)localObject2).release();
          }
          localObject2 = this.kSY;
          if (localObject2 != null) {
            ((kotlin.g.a.a)localObject2).invoke();
          }
          Log.i(this.TAG, hashCode() + " total decode used " + this.kSR);
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
      localObject2 = x.aazN;
      return;
    }
  }
  
  public int aUo()
  {
    return this.audioChannelCount;
  }
  
  protected final com.tencent.mm.media.f.a aUp()
  {
    return this.kSW;
  }
  
  protected final String adU()
  {
    return this.fmF;
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.k(paramBufferInfo, "bufferInfo");
    if (this.kST <= 0L)
    {
      this.kST = kotlin.h.a.N(1.0D * this.kSU / this.kSP * 1000000.0D);
      Log.i(this.TAG, "checkFrameDuration, frameDuration:" + this.kST);
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
      label282:
      int j;
      int m;
      int i1;
      int k;
      if (arrayOfByte.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label574;
        }
        Log.i(this.TAG, "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", diff:" + (paramBufferInfo.presentationTimeUs - this.kSV) + ", audioId:" + this.fmF + ", frameCount:" + this.frameCount);
        l = Util.ticksToNow(this.kSQ);
        this.kSR += l;
        Log.i(this.TAG, hashCode() + " decode frame cost " + l);
        this.kSS = true;
        if (this.audioChannelCount != 1) {
          break label525;
        }
        i = kSZ;
        if (arrayOfByte.length <= i) {
          break label539;
        }
        j = arrayOfByte.length;
        m = 0;
        i1 = j / i;
        k = 0;
        label306:
        if (j <= 0) {
          break label574;
        }
        if (j <= i) {
          break label532;
        }
      }
      label525:
      label532:
      for (int n = i;; n = j)
      {
        paramByteBuffer = new byte[n];
        System.arraycopy(arrayOfByte, m, paramByteBuffer, 0, n);
        j -= n;
        m += n;
        k += 1;
        l = this.kST * this.frameCount;
        Log.i(this.TAG, "split ret pcmData, leftSize:" + j + ", sizeOffset:" + m + ", maxBufferSize:" + i + ", copySize:" + n + ", data.size:" + paramByteBuffer.length + ", splitCount:" + i1 + ", bufferInfo.pts:" + paramBufferInfo.presentationTimeUs + ", pts:" + l + ", count:" + k);
        m localm = this.kSX;
        if (localm != null) {
          localm.invoke(paramByteBuffer, Long.valueOf(l));
        }
        this.frameCount += 1;
        break label306;
        i = 0;
        break;
        i = kTa;
        break label282;
      }
      label539:
      paramByteBuffer = this.kSX;
      if (paramByteBuffer != null) {
        paramByteBuffer.invoke(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      this.frameCount += 1;
      label574:
      this.kSV = paramBufferInfo.presentationTimeUs;
    }
  }
  
  protected final long getEndTimeMs()
  {
    return this.endTimeMs;
  }
  
  public int getSampleRate()
  {
    return this.kSP;
  }
  
  protected final long getStartTimeMs()
  {
    return this.startTimeMs;
  }
  
  public abstract void startDecoder();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/IAudioDecoder$Companion;", "", "()V", "MONO_CHANNEL_BUF_SIZE", "", "STEREO_CHANNLE_BUF_SIZE", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */