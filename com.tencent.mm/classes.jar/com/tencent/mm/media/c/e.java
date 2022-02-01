package com.tencent.mm.media.c;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e
{
  private static final int gOC = 2048;
  private static final int gOD = 4096;
  public static final e.a gOE = new e.a((byte)0);
  MediaCodec.BufferInfo bufferInfo;
  long bvf;
  String cQO;
  MediaFormat gNt;
  public m<? super byte[], ? super Long, y> gOA;
  public d.g.a.a<y> gOB;
  z gOr;
  protected volatile boolean gOs;
  private int gOt;
  int gOu;
  long gOv;
  private long gOw;
  private boolean gOx;
  com.tencent.mm.media.e.a gOy;
  long gOz;
  private String mime;
  final Object stopLock;
  
  public e(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, d.g.a.a<y> parama1)
  {
    this.gOy = parama;
    this.cQO = paramString;
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    this.gOA = paramm;
    this.gOB = parama1;
    this.stopLock = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.mime = "";
    parama = this.gOy;
    if (parama != null)
    {
      this.gNt = parama.gRJ;
      ac.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.cQO + ", startTimeMs:" + this.bvf + ", endTimeMs:" + this.gOz + ", mediaFormat:" + this.gNt);
      if (this.gNt != null)
      {
        paramString = this.gNt;
        if (paramString == null) {
          k.fOy();
        }
        this.gOt = paramString.getInteger("channel-count");
        paramString = this.gNt;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.gOt * 16384);
        }
        paramString = this.gNt;
        if (paramString == null) {
          k.fOy();
        }
        this.gOu = paramString.getInteger("sample-rate");
        paramString = this.gNt;
        if (paramString == null) {
          k.fOy();
        }
        paramString = paramString.getString("mime");
        k.g(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
        this.mime = paramString;
        paramString = this.gNt;
        if ((paramString != null) && (paramString.containsKey("encoder-delay") == true))
        {
          paramString = this.gNt;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.gNt;
        if ((paramString != null) && (paramString.containsKey("encoder-padding") == true))
        {
          paramString = this.gNt;
          if (paramString != null) {
            paramString.setInteger("encoder-padding", 0);
          }
        }
        parama.aqM();
        if (this.bvf >= 0L) {
          parama.seek(this.bvf * 1000L);
        }
        this.gOr = z.sx(this.mime);
        parama = this.gOr;
        if (parama != null) {
          parama.a(this.gNt, null, 0);
        }
      }
    }
  }
  
  public void aqr()
  {
    ac.l("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
    synchronized (this.stopLock)
    {
      ac.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
      try
      {
        if (!this.gOs)
        {
          this.gOs = true;
          localObject2 = this.gOr;
          if (localObject2 != null) {
            ((z)localObject2).stop();
          }
          localObject2 = this.gOr;
          if (localObject2 != null) {
            ((z)localObject2).release();
          }
          localObject2 = this.gOB;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          ac.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.gOw);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ac.printErrStackTrace("MicroMsg.IAudioDecoder", (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = y.KTp;
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
        ac.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", audioId:" + this.cQO);
        long l = bs.aO(this.gOv);
        this.gOw += l;
        ac.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + l);
        this.gOx = true;
        if (this.gOt != 1) {
          break label363;
        }
        i = gOC;
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
        ac.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + n + ", sizeOffset:" + i1 + ", maxBufferSize:" + i + ", copySize:" + m + ", data.size:" + paramByteBuffer.length);
        m localm = this.gOA;
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
        i = gOD;
        break label187;
      }
      label377:
      paramByteBuffer = this.gOA;
      if (paramByteBuffer != null) {
        paramByteBuffer.n(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public int getChannelCount()
  {
    return this.gOt;
  }
  
  public int getSampleRate()
  {
    return this.gOu;
  }
  
  public abstract void startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.c.e
 * JD-Core Version:    0.7.0.1
 */