package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getMediaFormat", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "setOnDecodeEndCallback", "callback", "setOnFrameDecodeCallback", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class e
{
  private static final int iel = 2048;
  private static final int iem = 4096;
  public static final e.a ien = new e.a((byte)0);
  private int audioChannelCount;
  MediaCodec.BufferInfo bufferInfo;
  String dtX;
  long endTimeMs;
  MediaFormat ida;
  z iec;
  protected volatile boolean ied;
  int iee;
  long ief;
  private long ieg;
  private boolean ieh;
  com.tencent.mm.media.f.a iei;
  public m<? super byte[], ? super Long, x> iej;
  public kotlin.g.a.a<x> iek;
  private String mime;
  long startTimeMs;
  final Object stopLock;
  
  public e(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, x> paramm, kotlin.g.a.a<x> parama1)
  {
    this.iei = parama;
    this.dtX = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.iej = paramm;
    this.iek = parama1;
    this.stopLock = new Object();
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.mime = "";
    parama = this.iei;
    if (parama != null)
    {
      this.ida = parama.igi;
      Log.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.dtX + ", startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs + ", mediaFormat:" + this.ida);
      if (this.ida != null)
      {
        paramString = this.ida;
        if (paramString == null) {
          p.hyc();
        }
        this.audioChannelCount = paramString.getInteger("channel-count");
        paramString = this.ida;
        if (paramString != null) {
          paramString.setInteger("max-input-size", this.audioChannelCount * 16384);
        }
        paramString = this.ida;
        if (paramString == null) {
          p.hyc();
        }
        this.iee = paramString.getInteger("sample-rate");
        paramString = this.ida;
        if (paramString == null) {
          p.hyc();
        }
        paramString = paramString.getString("mime");
        p.g(paramString, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
        this.mime = paramString;
        paramString = this.ida;
        if ((paramString != null) && (paramString.containsKey("encoder-delay") == true))
        {
          paramString = this.ida;
          if (paramString != null) {
            paramString.setInteger("encoder-delay", 0);
          }
        }
        paramString = this.ida;
        if ((paramString != null) && (paramString.containsKey("encoder-padding") == true))
        {
          paramString = this.ida;
          if (paramString != null) {
            paramString.setInteger("encoder-padding", 0);
          }
        }
        parama.aMr();
        if (this.startTimeMs >= 0L) {
          parama.seek(this.startTimeMs * 1000L);
        }
        this.iec = z.DZ(this.mime);
        parama = this.iec;
        if (parama != null) {
          parama.a(this.ida, null, 0);
        }
      }
    }
  }
  
  public void aMc()
  {
    Log.printDebugStack("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
    synchronized (this.stopLock)
    {
      Log.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
      try
      {
        if (!this.ied)
        {
          this.ied = true;
          localObject2 = this.iec;
          if (localObject2 != null) {
            ((z)localObject2).stop();
          }
          localObject2 = this.iec;
          if (localObject2 != null) {
            ((z)localObject2).release();
          }
          localObject2 = this.iek;
          if (localObject2 != null) {
            ((kotlin.g.a.a)localObject2).invoke();
          }
          Log.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.ieg);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          Log.printErrStackTrace("MicroMsg.IAudioDecoder", (Throwable)localException, "stopDecoder error", new Object[0]);
        }
      }
      localObject2 = x.SXb;
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
        Log.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + arrayOfByte.length + ", pts:" + paramBufferInfo.presentationTimeUs + ", audioId:" + this.dtX);
        long l = Util.ticksToNow(this.ief);
        this.ieg += l;
        Log.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + l);
        this.ieh = true;
        if (this.audioChannelCount != 1) {
          break label363;
        }
        i = iel;
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
        Log.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + n + ", sizeOffset:" + i1 + ", maxBufferSize:" + i + ", copySize:" + m + ", data.size:" + paramByteBuffer.length);
        m localm = this.iej;
        j = n;
        k = i1;
        if (localm == null) {
          break label202;
        }
        localm.invoke(paramByteBuffer, Long.valueOf(paramBufferInfo.presentationTimeUs));
        j = n;
        k = i1;
        break label202;
        i = 0;
        break;
        i = iem;
        break label187;
      }
      label377:
      paramByteBuffer = this.iej;
      if (paramByteBuffer != null) {
        paramByteBuffer.invoke(arrayOfByte, Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public int getChannelCount()
  {
    return this.audioChannelCount;
  }
  
  public int getSampleRate()
  {
    return this.iee;
  }
  
  public abstract void startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */