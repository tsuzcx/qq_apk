package com.tencent.mm.media.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  private static final int eRQ = 2048;
  private static final int eRR = 4096;
  public static final a.a eRS = new a.a((byte)0);
  long aZw;
  String ceu;
  private String cfP;
  protected MediaCodec eRD;
  volatile boolean eRE;
  public int eRF;
  public int eRG;
  final Object eRH;
  long eRI;
  private long eRJ;
  private boolean eRK;
  MediaCodec.BufferInfo eRL;
  com.tencent.mm.media.e.a eRM;
  long eRN;
  private m<? super byte[], ? super Long, y> eRO;
  private a.f.a.a<y> eRP;
  MediaFormat mMediaFormat;
  
  public a(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, a.f.a.a<y> parama1)
  {
    this.eRM = parama;
    this.ceu = paramString;
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    this.eRO = paramm;
    this.eRP = parama1;
    this.eRH = new Object();
    this.eRL = new MediaCodec.BufferInfo();
    this.cfP = "";
    this.mMediaFormat = this.eRM.eUU;
    ab.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.ceu + ", startTimeMs:" + this.aZw + ", endTimeMs:" + this.eRN + ", mediaFormat:" + this.mMediaFormat);
    if (this.mMediaFormat != null)
    {
      parama = this.mMediaFormat;
      if (parama == null) {
        j.ebi();
      }
      this.eRF = parama.getInteger("channel-count");
      parama = this.mMediaFormat;
      if (parama != null) {
        parama.setInteger("max-input-size", this.eRF * 16384);
      }
      parama = this.mMediaFormat;
      if (parama == null) {
        j.ebi();
      }
      this.eRG = parama.getInteger("sample-rate");
      parama = this.mMediaFormat;
      if (parama == null) {
        j.ebi();
      }
      parama = parama.getString("mime");
      j.p(parama, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
      this.cfP = parama;
      parama = this.mMediaFormat;
      if ((parama != null) && (parama.containsKey("encoder-delay") == true))
      {
        parama = this.mMediaFormat;
        if (parama != null) {
          parama.setInteger("encoder-delay", 0);
        }
      }
      parama = this.mMediaFormat;
      if ((parama != null) && (parama.containsKey("encoder-padding") == true))
      {
        parama = this.mMediaFormat;
        if (parama != null) {
          parama.setInteger("encoder-padding", 0);
        }
      }
      this.eRM.UU();
      if (this.aZw >= 0L) {
        this.eRM.seek(this.aZw * 1000L);
      }
      parama = MediaCodec.createDecoderByType(this.cfP);
      j.p(parama, "MediaCodec.createDecoderByType(mime)");
      this.eRD = parama;
      parama = this.eRD;
      if (parama == null) {
        j.ays("decoder");
      }
      parama.configure(this.mMediaFormat, null, null, 0);
    }
  }
  
  public final void UA()
  {
    ab.a("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
    synchronized (this.eRH)
    {
      ab.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
      try
      {
        if (!this.eRE)
        {
          this.eRE = true;
          localObject2 = this.eRD;
          if (localObject2 == null) {
            j.ays("decoder");
          }
          ((MediaCodec)localObject2).stop();
          localObject2 = this.eRD;
          if (localObject2 == null) {
            j.ays("decoder");
          }
          ((MediaCodec)localObject2).release();
          this.eRP.invoke();
          ab.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.eRJ);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ab.printErrStackTrace("MicroMsg.IAudioDecoder", (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = y.BMg;
      return;
    }
  }
  
  protected final MediaCodec Uy()
  {
    MediaCodec localMediaCodec = this.eRD;
    if (localMediaCodec == null) {
      j.ays("decoder");
    }
    return localMediaCodec;
  }
  
  public abstract void Uz();
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    j.q(paramBufferInfo, "bufferInfo");
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
        ab.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", audioId:" + this.ceu);
        long l = bo.av(this.eRI);
        this.eRJ += l;
        ab.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + l);
        this.eRK = true;
        if (this.eRF != 1) {
          break label338;
        }
        i = eRQ;
        if (arrayOfByte.length <= i) {
          break label352;
        }
        j = arrayOfByte.length;
        k = 0;
        label202:
        if (j <= 0) {
          return;
        }
        if (j <= i) {
          break label345;
        }
      }
      label338:
      label345:
      for (int m = i;; m = j)
      {
        paramByteBuffer = new byte[m];
        System.arraycopy(arrayOfByte, k, paramByteBuffer, 0, m);
        j -= m;
        k += m;
        ab.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + j + ", sizeOffset:" + k + ", maxBufferSize:" + i + ", copySize:" + m + ", data.size:" + paramByteBuffer.length);
        this.eRO.h(paramByteBuffer, Long.valueOf(paramBufferInfo.presentationTimeUs));
        break label202;
        i = 0;
        break;
        i = eRR;
        break label187;
      }
      label352:
      this.eRO.h(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.c.a
 * JD-Core Version:    0.7.0.1
 */