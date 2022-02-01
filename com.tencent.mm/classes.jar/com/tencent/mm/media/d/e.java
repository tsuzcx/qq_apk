package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.m;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e
{
  private static final int hlp = 2048;
  private static final int hlq = 4096;
  public static final e.a hlr = new e.a((byte)0);
  private int audioChannelCount;
  MediaCodec.BufferInfo bufferInfo;
  String ddg;
  MediaFormat hke;
  com.tencent.mm.compatible.deviceinfo.z hlf;
  protected volatile boolean hlg;
  int hlh;
  long hli;
  private long hlj;
  private boolean hlk;
  com.tencent.mm.media.f.a hll;
  long hlm;
  public m<? super byte[], ? super Long, d.z> hln;
  public d.g.a.a<d.z> hlo;
  private String mime;
  long startTimeMs;
  final Object stopLock;
  
  public e(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, d.z> paramm, d.g.a.a<d.z> parama1)
  {
    this.hll = parama;
    this.ddg = paramString;
    this.startTimeMs = paramLong1;
    this.hlm = paramLong2;
    this.hln = paramm;
    this.hlo = parama1;
    this.stopLock = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.mime = "";
    parama = this.hll;
    if (parama != null)
    {
      this.hke = parama.hmP;
      ae.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.ddg + ", startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.hlm + ", mediaFormat:" + this.hke);
      if (this.hke != null)
      {
        paramString = this.hke;
        if (paramString == null) {
          p.gkB();
        }
        this.audioChannelCount = paramString.getInteger("channel-count");
        paramString = this.hke;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.audioChannelCount * 16384);
        }
        paramString = this.hke;
        if (paramString == null) {
          p.gkB();
        }
        this.hlh = paramString.getInteger("sample-rate");
        paramString = this.hke;
        if (paramString == null) {
          p.gkB();
        }
        paramString = paramString.getString("mime");
        p.g(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
        this.mime = paramString;
        paramString = this.hke;
        if ((paramString != null) && (paramString.containsKey("encoder-delay") == true))
        {
          paramString = this.hke;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.hke;
        if ((paramString != null) && (paramString.containsKey("encoder-padding") == true))
        {
          paramString = this.hke;
          if (paramString != null) {
            paramString.setInteger("encoder-padding", 0);
          }
        }
        parama.atP();
        if (this.startTimeMs >= 0L) {
          parama.seek(this.startTimeMs * 1000L);
        }
        this.hlf = com.tencent.mm.compatible.deviceinfo.z.vI(this.mime);
        parama = this.hlf;
        if (parama != null) {
          parama.a(this.hke, null, 0);
        }
      }
    }
  }
  
  public void atB()
  {
    ae.l("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
    synchronized (this.stopLock)
    {
      ae.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
      try
      {
        if (!this.hlg)
        {
          this.hlg = true;
          localObject2 = this.hlf;
          if (localObject2 != null) {
            ((com.tencent.mm.compatible.deviceinfo.z)localObject2).stop();
          }
          localObject2 = this.hlf;
          if (localObject2 != null) {
            ((com.tencent.mm.compatible.deviceinfo.z)localObject2).release();
          }
          localObject2 = this.hlo;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          ae.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.hlj);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ae.printErrStackTrace("MicroMsg.IAudioDecoder", (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = d.z.Nhr;
      return;
    }
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.h(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer != null)
    {
      paramByteBuffer.position(paramBufferInfo.offset);
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.position(0);
      paramByteBuffer.get(arrayOfByte);
      int i;
      label187:
      int j;
      int k;
      if (arrayOfByte.length == 0)
      {
        i = 1;
        if (i != 0) {
          return;
        }
        ae.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", audioId:" + this.ddg);
        long l = bu.aO(this.hli);
        this.hlj += l;
        ae.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + l);
        this.hlk = true;
        if (this.audioChannelCount != 1) {
          break label363;
        }
        i = hlp;
        if (arrayOfByte.length <= i) {
          break label377;
        }
        j = arrayOfByte.length;
        k = 0;
        label202:
        if (j <= 0) {
          return;
        }
        if (j <= i) {
          break label370;
        }
      }
      label363:
      label370:
      for (int m = i;; m = j)
      {
        paramByteBuffer = new byte[m];
        System.arraycopy(arrayOfByte, k, paramByteBuffer, 0, m);
        int n = j - m;
        int i1 = k + m;
        ae.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + n + ", sizeOffset:" + i1 + ", maxBufferSize:" + i + ", copySize:" + m + ", data.size:" + paramByteBuffer.length);
        m localm = this.hln;
        j = n;
        k = i1;
        if (localm == null) {
          break label202;
        }
        localm.p(paramByteBuffer, Long.valueOf(paramBufferInfo.presentationTimeUs));
        j = n;
        k = i1;
        break label202;
        i = 0;
        break;
        i = hlq;
        break label187;
      }
      label377:
      paramByteBuffer = this.hln;
      if (paramByteBuffer != null) {
        paramByteBuffer.p(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public int getChannelCount()
  {
    return this.audioChannelCount;
  }
  
  public int getSampleRate()
  {
    return this.hlh;
  }
  
  public abstract void startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */