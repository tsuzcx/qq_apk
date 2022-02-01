package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends e
{
  private static final String TAG;
  public static final g.a nyZ;
  private static final long nza;
  private boolean codeOver;
  
  static
  {
    AppMethodBeat.i(93536);
    nyZ = new g.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoder";
    nza = 60000L;
    AppMethodBeat.o(93536);
  }
  
  public g(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93535);
    AppMethodBeat.o(93535);
  }
  
  public g(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, ah> paramm, kotlin.g.a.a<ah> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93534);
    AppMethodBeat.o(93534);
  }
  
  private final boolean boT()
  {
    AppMethodBeat.i(93531);
    int m;
    try
    {
      synchronized (boO())
      {
        if (this.nyA) {
          Log.i(TAG, "readNextSample decoder stop");
        }
        Object localObject3 = ah.aiuX;
        localObject3 = this.nyz;
        if (localObject3 != null)
        {
          this.nyC = Util.currentTicks();
          m = ((aa)localObject3).dequeueInputBuffer(100L);
          if (m < 0) {
            boU();
          }
          if (m >= 0) {
            break label125;
          }
          AppMethodBeat.o(93531);
          return false;
        }
      }
      AppMethodBeat.o(93531);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
    }
    return true;
    label125:
    Log.i(TAG, s.X("inputIndex: ", Integer.valueOf(m)));
    this.nyC = Util.currentTicks();
    ByteBuffer localByteBuffer = localObject4.aPD()[m];
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    Object localObject2 = boN();
    label183:
    int i;
    long l2;
    int j;
    label224:
    long l1;
    label252:
    int k;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (!s.p(localObject2, Boolean.FALSE)) {
        break label404;
      }
      Log.i(TAG, "read sample end");
      i = 1;
      l2 = 0L;
      if (i != 0) {
        break label399;
      }
      localObject2 = boN();
      if (localObject2 != null) {
        break label375;
      }
      j = 0;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localObject2 = boN();
      if (localObject2 != null) {
        break label384;
      }
      l1 = -1L;
      Log.i(TAG, "sampleTime : " + l1 + ", sampleSize:" + j);
      if (j >= 0)
      {
        k = j;
        l2 = l1;
        if (l1 < getEndTimeMs() * 1000L) {
          break label409;
        }
      }
      Log.i(TAG, "sawInputEOS");
      i = 1;
      k = j;
      l2 = l1;
      break label409;
    }
    for (;;)
    {
      label327:
      localObject4.a(m, k, l2, j);
      if (i != 0) {
        boQ();
      }
      boU();
      break;
      s.s(localByteBuffer, "inputBuffer");
      localObject2 = Boolean.valueOf(com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject2, localByteBuffer));
      break label183;
      label375:
      j = ((com.tencent.mm.media.f.a)localObject2).sampleSize;
      break label224;
      label384:
      l1 = ((com.tencent.mm.media.f.a)localObject2).getSampleTime();
      break label252;
      label399:
      label404:
      label409:
      do
      {
        j = 0;
        break label327;
        k = 0;
        continue;
        i = 0;
        break;
      } while (i == 0);
      j = 4;
    }
  }
  
  private final void boU()
  {
    AppMethodBeat.i(93532);
    label517:
    for (;;)
    {
      int i;
      try
      {
        synchronized (boO())
        {
          if (this.nyA)
          {
            Log.i(TAG, "drainDecoder, decoder is stop");
            AppMethodBeat.o(93532);
            return;
          }
          Object localObject2 = ah.aiuX;
          ??? = this.nyz;
          if (??? != null)
          {
            a(new MediaCodec.BufferInfo());
            i = ((aa)???).dequeueOutputBuffer(boP(), nza);
            if (i != -2) {
              break label279;
            }
            this.nxp = ((aa)???).getOutputFormat();
            localObject2 = this.nxp;
            if ((localObject2 == null) || (((MediaFormat)localObject2).containsKey("sample-rate") != true)) {
              break label274;
            }
            i = 1;
            if (i != 0)
            {
              localObject2 = this.nxp;
              if (localObject2 == null) {
                break label517;
              }
              i = ((MediaFormat)localObject2).getInteger("sample-rate");
              if (i > 0) {
                this.nyB = i;
              }
            }
            Log.i(TAG, "onOutputFormatChanged:" + this.nxp + ", aacSampleRate:" + this.nyB + ", audioId:" + aFS());
            int j = ((aa)???).dequeueOutputBuffer(boP(), nza);
            i = j;
            if (j >= 0) {
              continue;
            }
            AppMethodBeat.o(93532);
          }
        }
        i = 0;
      }
      catch (Exception localException)
      {
        this.codeOver = true;
        Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(93532);
        return;
      }
      label274:
      continue;
      label279:
      if (i >= 0)
      {
        ByteBuffer localByteBuffer = localException.aPE()[i];
        if (localByteBuffer == null)
        {
          Log.e(TAG, "ERROR, retrieve decoderOutputBuffer is null!!");
          AppMethodBeat.o(93532);
          return;
        }
        long l = boP().presentationTimeUs;
        Log.i(TAG, s.X("presentationTimeUs : ", Long.valueOf(l)));
        if ((l < getStartTimeMs() * 1000L) && ((boP().flags & 0x4) == 0))
        {
          localException.releaseOutputBuffer(i, false);
          Log.i(TAG, "decoder pts: " + l + ", not reach start: " + getStartTimeMs() * 1000L);
          AppMethodBeat.o(93532);
          return;
        }
        if (boP().size > 0) {
          e(localByteBuffer, boP());
        }
        localException.releaseOutputBuffer(i, false);
        if ((getEndTimeMs() * 1000L != 1L) && (l >= getEndTimeMs() * 1000L))
        {
          Log.e(TAG, "exceed endTimeMs");
          boQ();
          AppMethodBeat.o(93532);
          return;
        }
        if ((boP().flags & 0x4) != 0)
        {
          Log.i(TAG, "receive EOS!");
          boQ();
          AppMethodBeat.o(93532);
          return;
          i = 0;
        }
      }
    }
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93533);
    aa localaa = this.nyz;
    if (localaa != null) {
      localaa.start();
    }
    while ((!this.codeOver) && (!this.nyA)) {
      boT();
    }
    boQ();
    AppMethodBeat.o(93533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */