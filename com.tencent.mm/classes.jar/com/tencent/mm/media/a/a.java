package com.tencent.mm.media.a;

import a.f.a.m;
import a.f.b.k;
import a.l;
import a.y;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "Lcom/tencent/mm/media/codec/IAudioCodec;", "bufId", "", "mixType", "sampleRate", "channelCount", "onFrameEncode", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Landroid/media/MediaCodec$BufferInfo;", "", "(IIIILkotlin/jvm/functions/Function2;)V", "TAG", "", "cacheAACFilePath", "decodeBackgroundFrameCount", "decodeMusicFrameCount", "encodeFrameCount", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "isBackgroundDecodeEnd", "", "isDecodeEnd", "isMusicDecodeEnd", "mAudioEncoder", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mAudioMixCodec", "Lcom/tencent/mm/media/mix/AudioMixCodec;", "mBackgroundDecoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mBackgroundDecoderRunnable", "Ljava/lang/Runnable;", "mMediaFormat", "Landroid/media/MediaFormat;", "mMusicDecoder", "mMusicDecoderRunnable", "mixCount", "mixFinishCallback", "Lkotlin/Function0;", "mixStartTime", "", "useAsync", "checkPostEncoder", "data", "", "pts", "isEnd", "initDecoder", "background", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "music", "startTime", "endTime", "initEncoder", "mediaFormat", "onAudioFrameEncode", "bufferInfo", "onAudioFrameEncodeEnd", "onBackgroundDecodeEnd", "onBackgroundFrameDecodeEnd", "pcmData", "onDecodeEnd", "isBackground", "onEncodeEnd", "onFrameMix", "onFrameMixEnd", "onMusicDecodeEnd", "onMusicFrameDecodeEnd", "startCodec", "stopCodec", "EncoderData", "plugin-mediaeditor_release"})
public final class a
{
  final String TAG;
  private final int awU;
  private int cgz;
  com.tencent.mm.media.c.a eQU;
  com.tencent.mm.media.c.a eQV;
  com.tencent.mm.media.d.a eQW;
  private com.tencent.mm.media.f.a eQX;
  private volatile boolean eQY;
  private boolean eQZ;
  private boolean eRa;
  private HandlerThread eRb;
  private ak eRc;
  private a.f.a.a<y> eRd;
  private final String eRe;
  private int eRf;
  private int eRg;
  private int eRh;
  Runnable eRi;
  Runnable eRj;
  private boolean eRk;
  private long eRl;
  private final int eRm;
  private int eRn;
  private final m<ByteBuffer, MediaCodec.BufferInfo, y> eRo;
  private MediaFormat mMediaFormat;
  private final int sampleRate;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> paramm)
  {
    AppMethodBeat.i(152081);
    this.eRm = paramInt1;
    this.eRn = paramInt2;
    this.sampleRate = paramInt3;
    this.awU = paramInt4;
    this.eRo = paramm;
    this.TAG = "MicroMsg.MediaCodecAACCodec";
    paramm = com.tencent.mm.sdk.g.d.aqu("MediaCodecAACCodec_EncodeThread");
    a.f.b.j.p(paramm, "ThreadPool.newFreeHandle…ecAACCodec_EncodeThread\")");
    this.eRb = paramm;
    this.eRe = (com.tencent.mm.loader.j.b.eQz + "cache.pcm");
    this.eRi = ((Runnable)new a.q(this));
    this.eRj = ((Runnable)new a.r(this));
    ab.i(this.TAG, "init MediaCodecAACCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.awU);
    this.eQX = new com.tencent.mm.media.f.a(this.sampleRate, this.awU, a.a.j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1) }).contains(Integer.valueOf(this.eRn)), a.a.j.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(3) }).contains(Integer.valueOf(this.eRn)), (a.f.a.a)new a.1(this), (m)new a.2(this));
    AppMethodBeat.o(152081);
  }
  
  private final void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(12835);
    if (this.eRc == null)
    {
      this.eRb.start();
      this.eRc = new ak(this.eRb.getLooper(), (ak.a)new a.b(this));
    }
    Object localObject = this.eRc;
    if (localObject != null) {}
    for (localObject = ((ak)localObject).obtainMessage();; localObject = null)
    {
      if (localObject != null) {
        ((Message)localObject).what = 1024;
      }
      paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      a.f.b.j.p(paramArrayOfByte, "Arrays.copyOf(data, data.size)");
      paramArrayOfByte = new a.a(paramArrayOfByte, paramLong, paramBoolean);
      if (localObject != null) {
        ((Message)localObject).obj = paramArrayOfByte;
      }
      paramArrayOfByte = this.eRc;
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte.sendMessage((Message)localObject);
      AppMethodBeat.o(12835);
      return;
    }
    AppMethodBeat.o(12835);
  }
  
  private final void cx(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(12836);
        ab.b(this.TAG, "onDecodeEnd, isDecodeEnd:" + this.eQY + ", isBackground:" + paramBoolean, new Object[0]);
        if (paramBoolean)
        {
          this.eRa = true;
          if ((this.eRn == 3) && (this.eQZ) && (this.eRa))
          {
            if (this.eQY) {
              break label213;
            }
            this.eQY = true;
            com.tencent.mm.media.c.a locala1 = this.eQU;
            if (locala1 != null) {
              locala1.UA();
            }
            locala1 = this.eQV;
            if (locala1 != null) {
              locala1.UA();
            }
            long l = bo.yB();
            a(new byte[0], l, true);
            AppMethodBeat.o(12836);
          }
        }
        else
        {
          this.eQZ = true;
          continue;
        }
        if (this.eRn != 2) {
          break label213;
        }
      }
      finally {}
      if ((this.eQZ) && (!this.eQY))
      {
        this.eQY = true;
        com.tencent.mm.media.c.a locala2 = this.eQU;
        if (locala2 != null)
        {
          locala2.UA();
          AppMethodBeat.o(12836);
          continue;
        }
      }
      label213:
      AppMethodBeat.o(12836);
    }
  }
  
  public final boolean Us()
  {
    AppMethodBeat.i(152080);
    Object localObject = this.eQV;
    if (localObject != null) {
      ((com.tencent.mm.media.c.a)localObject).UA();
    }
    localObject = this.eQU;
    if (localObject != null) {
      ((com.tencent.mm.media.c.a)localObject).UA();
    }
    localObject = this.eQW;
    if (localObject == null) {
      a.f.b.j.ays("mAudioEncoder");
    }
    ((com.tencent.mm.media.d.a)localObject).stopEncoder();
    com.tencent.mm.sdk.g.d.ysm.remove(this.eRj);
    com.tencent.mm.sdk.g.d.ysm.remove(this.eRi);
    this.eRb.quit();
    long l;
    if (this.eRl > 0L)
    {
      l = bo.av(this.eRl);
      if (!this.eRk) {
        break label132;
      }
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Wr();
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.gn(l);
    }
    for (;;)
    {
      AppMethodBeat.o(152080);
      return true;
      label132:
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Ws();
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.go(l);
    }
  }
  
  public final void a(com.tencent.mm.media.e.a parama1, com.tencent.mm.media.e.a parama2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(152077);
    ab.i(this.TAG, "init decoder background " + parama1 + "music is " + parama2);
    if (parama1 != null) {}
    try
    {
      Object localObject = parama1.eUU;
      this.mMediaFormat = ((MediaFormat)localObject);
      if ((this.mMediaFormat == null) && (this.eRn == 3))
      {
        this.eRn = 2;
        ab.w(this.TAG, "background AudioFormat is null, recreate AudioMixCodec, sampleRate:" + this.sampleRate + ", channelCount:" + this.awU);
        this.eQX = new com.tencent.mm.media.f.a(this.sampleRate, this.awU, a.a.j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1) }).contains(Integer.valueOf(this.eRn)), a.a.j.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(3) }).contains(Integer.valueOf(this.eRn)), (a.f.a.a)new c(this), (m)new a.e(this));
        localObject = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Wu();
      }
      if ((this.eRn == 3) && (parama1 != null))
      {
        this.mMediaFormat = parama1.eUU;
        if (com.tencent.luggage.g.b.fw(23))
        {
          parama1 = (com.tencent.mm.media.c.a)new com.tencent.mm.media.c.c(parama1, "background", paramLong1, paramLong2, (m)new a.f(this), (a.f.a.a)new a.g(this));
          label298:
          this.eQV = parama1;
        }
      }
      else
      {
        if (parama2 == null) {
          break label512;
        }
        if (!com.tencent.luggage.g.b.fw(23)) {
          break label423;
        }
      }
      for (parama1 = (com.tencent.mm.media.c.a)new com.tencent.mm.media.c.c(parama2, "music", 0L, paramLong2 - paramLong1, (m)new a.j(this), (a.f.a.a)new a.k(this));; parama1 = (com.tencent.mm.media.c.a)new com.tencent.mm.media.c.d(parama2, "music", 0L, paramLong2 - paramLong1, (m)new l(this), (a.f.a.a)new a.d(this)))
      {
        this.eQU = parama1;
        AppMethodBeat.o(152077);
        return;
        localObject = null;
        break;
        this.eRk = true;
        parama1 = (com.tencent.mm.media.c.a)new com.tencent.mm.media.c.d(parama1, "background", paramLong1, paramLong2, (m)new a.h(this), (a.f.a.a)new a.i(this));
        break label298;
        label423:
        this.eRk = true;
      }
      AppMethodBeat.o(152077);
    }
    catch (Exception parama1)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)parama1, "", new Object[0]);
      parama2 = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Wo();
      parama1 = (Throwable)parama1;
      AppMethodBeat.o(152077);
      throw parama1;
    }
    label512:
  }
  
  public final void c(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(152078);
    a.f.b.j.q(paramMediaFormat, "mediaFormat");
    try
    {
      if (com.tencent.luggage.g.b.fw(23)) {}
      for (paramMediaFormat = (com.tencent.mm.media.d.a)new com.tencent.mm.media.d.c(paramMediaFormat, (m)new a.m(this), (a.f.a.a)new a.n(this));; paramMediaFormat = (com.tencent.mm.media.d.a)new com.tencent.mm.media.d.d(paramMediaFormat, (m)new a.o(this), (a.f.a.a)new a.p(this)))
      {
        this.eQW = paramMediaFormat;
        AppMethodBeat.o(152078);
        return;
        this.eRk = true;
      }
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)paramMediaFormat, "", new Object[0]);
      paramMediaFormat = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Wp();
      AppMethodBeat.o(152078);
    }
  }
  
  public final boolean c(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(152079);
    com.tencent.mm.media.f.a locala = this.eQX;
    if (locala != null)
    {
      ab.i(locala.TAG, "startMix");
      com.tencent.mm.ab.b.a((a.f.a.a)new com.tencent.mm.media.f.a.c(locala), "AudioMixCodec_MixAudio");
      locala.eVh = true;
    }
    if (this.eRn == 3) {
      com.tencent.mm.ab.b.a((a.f.a.a)new s(this), "BackgroundDecoder");
    }
    com.tencent.mm.ab.b.a((a.f.a.a)new a.t(this), "MusicDecoder");
    ab.i(this.TAG, "startCodec");
    this.eRd = parama;
    this.eRl = bo.yB();
    AppMethodBeat.o(152079);
    return true;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class c
    extends k
    implements a.f.a.a<y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "pcmData", "", "pts", "", "invoke"})
  static final class l
    extends k
    implements m<byte[], Long, y>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class s
    extends k
    implements a.f.a.a<y>
  {
    s(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.a.a
 * JD-Core Version:    0.7.0.1
 */