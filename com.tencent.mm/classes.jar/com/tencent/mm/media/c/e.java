package com.tencent.mm.media.c;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e
{
  private static final int gnR = 2048;
  private static final int gnS = 4096;
  public static final e.a gnT = new e.a((byte)0);
  MediaCodec.BufferInfo bufferInfo;
  long bxw;
  String cTr;
  MediaFormat gmG;
  z gnF;
  protected volatile boolean gnG;
  private int gnH;
  int gnI;
  long gnJ;
  private long gnK;
  private boolean gnL;
  com.tencent.mm.media.e.a gnN;
  long gnO;
  public m<? super byte[], ? super Long, y> gnP;
  public d.g.a.a<y> gnQ;
  private String mime;
  final Object stopLock;
  
  public e(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, d.g.a.a<y> parama1)
  {
    this.gnN = parama;
    this.cTr = paramString;
    this.bxw = paramLong1;
    this.gnO = paramLong2;
    this.gnP = paramm;
    this.gnQ = parama1;
    this.stopLock = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.mime = "";
    parama = this.gnN;
    if (parama != null)
    {
      this.gmG = parama.grb;
      ad.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.cTr + ", startTimeMs:" + this.bxw + ", endTimeMs:" + this.gnO + ", mediaFormat:" + this.gmG);
      if (this.gmG != null)
      {
        paramString = this.gmG;
        if (paramString == null) {
          k.fvU();
        }
        this.gnH = paramString.getInteger("channel-count");
        paramString = this.gmG;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.gnH * 16384);
        }
        paramString = this.gmG;
        if (paramString == null) {
          k.fvU();
        }
        this.gnI = paramString.getInteger("sample-rate");
        paramString = this.gmG;
        if (paramString == null) {
          k.fvU();
        }
        paramString = paramString.getString("mime");
        k.g(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
        this.mime = paramString;
        paramString = this.gmG;
        if ((paramString != null) && (paramString.containsKey("encoder-delay") == true))
        {
          paramString = this.gmG;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.gmG;
        if ((paramString != null) && (paramString.containsKey("encoder-padding") == true))
        {
          paramString = this.gmG;
          if (paramString != null) {
            paramString.setInteger("encoder-padding", 0);
          }
        }
        parama.ajN();
        if (this.bxw >= 0L) {
          parama.seek(this.bxw * 1000L);
        }
        this.gnF = z.pl(this.mime);
        parama = this.gnF;
        if (parama != null) {
          parama.a(this.gmG, null, 0);
        }
      }
    }
  }
  
  public void ajs()
  {
    ad.l("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
    synchronized (this.stopLock)
    {
      ad.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
      try
      {
        if (!this.gnG)
        {
          this.gnG = true;
          localObject2 = this.gnF;
          if (localObject2 != null) {
            ((z)localObject2).stop();
          }
          localObject2 = this.gnF;
          if (localObject2 != null) {
            ((z)localObject2).release();
          }
          localObject2 = this.gnQ;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          ad.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.gnK);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ad.printErrStackTrace("MicroMsg.IAudioDecoder", (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = y.JfV;
      return;
    }
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    k.h(paramBufferInfo, "bufferInfo");
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
        ad.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", audioId:" + this.cTr);
        long l = bt.aS(this.gnJ);
        this.gnK += l;
        ad.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + l);
        this.gnL = true;
        if (this.gnH != 1) {
          break label363;
        }
        i = gnR;
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
        ad.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + n + ", sizeOffset:" + i1 + ", maxBufferSize:" + i + ", copySize:" + m + ", data.size:" + paramByteBuffer.length);
        m localm = this.gnP;
        j = n;
        k = i1;
        if (localm == null) {
          break label202;
        }
        localm.n(paramByteBuffer, Long.valueOf(paramBufferInfo.presentationTimeUs));
        j = n;
        k = i1;
        break label202;
        i = 0;
        break;
        i = gnS;
        break label187;
      }
      label377:
      paramByteBuffer = this.gnP;
      if (paramByteBuffer != null) {
        paramByteBuffer.n(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public int getChannelCount()
  {
    return this.gnH;
  }
  
  public int getSampleRate()
  {
    return this.gnI;
  }
  
  public abstract void startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.c.e
 * JD-Core Version:    0.7.0.1
 */