package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.LinkedList;

@TargetApi(16)
public final class i
  extends com.google.android.exoplayer2.e.b
  implements com.google.android.exoplayer2.i.i
{
  private final e.a aPW;
  private final f aPX;
  private boolean aPY;
  private boolean aPZ;
  private MediaFormat aQa;
  private long aQb;
  private boolean aQc;
  private int channelCount;
  private int pcmEncoding;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(91810);
    this.aPX = new f(paramc1, paramVarArgs, new a((byte)0));
    this.aPW = new e.a(paramHandler, parame);
    AppMethodBeat.o(91810);
  }
  
  private boolean bq(String paramString)
  {
    AppMethodBeat.i(91813);
    boolean bool = this.aPX.bo(paramString);
    AppMethodBeat.o(91813);
    return bool;
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(91811);
    Object localObject = paramFormat.aMQ;
    if (!j.bI((String)localObject))
    {
      AppMethodBeat.o(91811);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (bq((String)localObject)) && (paramc.tc() != null); j = 0)
    {
      AppMethodBeat.o(91811);
      return j | 0x8 | 0x4;
    }
    paramc = paramc.e((String)localObject, false);
    if (paramc == null)
    {
      AppMethodBeat.o(91811);
      return 1;
    }
    int n;
    if (x.SDK_INT >= 21)
    {
      if (paramFormat.sampleRate != -1)
      {
        i = paramFormat.sampleRate;
        if (paramc.bcC != null) {
          break label203;
        }
        paramc.bs("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label183;
        }
      }
      if (paramFormat.channelCount != -1)
      {
        n = paramFormat.channelCount;
        if (paramc.bcC != null) {
          break label260;
        }
        paramc.bs("channelCount.caps");
        i = 0;
        label172:
        k = m;
        if (i == 0) {
          break label183;
        }
      }
    }
    int k = 1;
    label183:
    if (k != 0) {}
    for (int i = 4;; i = 3)
    {
      AppMethodBeat.o(91811);
      return i | j | 0x8;
      label203:
      localObject = paramc.bcC.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.bs("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.bs("sampleRate.support, ".concat(String.valueOf(i)));
        i = 0;
        break;
      }
      i = 1;
      break;
      label260:
      paramFormat = paramc.bcC.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.bs("channelCount.aCaps");
        i = 0;
        break label172;
      }
      localObject = paramc.name;
      String str = paramc.mimeType;
      k = paramFormat.getMaxInputChannelCount();
      if ((k > 1) || ((x.SDK_INT >= 26) && (k > 0))) {
        i = k;
      }
      for (;;)
      {
        if (i < n)
        {
          paramc.bs("channelCount.support, ".concat(String.valueOf(n)));
          i = 0;
          break;
          if (("audio/mpeg".equals(str)) || ("audio/3gpp".equals(str)) || ("audio/amr-wb".equals(str)) || ("audio/mp4a-latm".equals(str)) || ("audio/vorbis".equals(str)) || ("audio/opus".equals(str)) || ("audio/raw".equals(str)) || ("audio/flac".equals(str)) || ("audio/g711-alaw".equals(str)) || ("audio/g711-mlaw".equals(str)) || ("audio/gsm".equals(str)))
          {
            i = k;
          }
          else
          {
            if ("audio/ac3".equals(str)) {
              i = 6;
            }
            for (;;)
            {
              new StringBuilder("AssumedMaxChannelAdjustment: ").append((String)localObject).append(", [").append(k).append(" to ").append(i).append("]");
              break;
              if ("audio/eac3".equals(str)) {
                i = 16;
              } else {
                i = 30;
              }
            }
          }
        }
      }
      i = 1;
      break label172;
    }
  }
  
  public final com.google.android.exoplayer2.e.a a(com.google.android.exoplayer2.e.c paramc, Format paramFormat, boolean paramBoolean)
  {
    AppMethodBeat.i(91812);
    if (bq(paramFormat.aMQ))
    {
      com.google.android.exoplayer2.e.a locala = paramc.tc();
      if (locala != null)
      {
        this.aPY = true;
        AppMethodBeat.o(91812);
        return locala;
      }
    }
    this.aPY = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(91812);
    return paramc;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(91819);
    super.a(paramLong, paramBoolean);
    this.aPX.reset();
    this.aQb = paramLong;
    this.aQc = true;
    AppMethodBeat.o(91819);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat)
  {
    AppMethodBeat.i(193642);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.brp)) && ((x.bro.startsWith("zeroflte")) || (x.bro.startsWith("herolte")) || (x.bro.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aPZ = bool;
      if (!this.aPY) {
        break;
      }
      this.aQa = paramFormat.rq();
      this.aQa.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.aQa, null, null, 0);
      this.aQa.setString("mime", paramFormat.aMQ);
      AppMethodBeat.o(193642);
      return;
    }
    paramMediaCodec.configure(paramFormat.rq(), null, null, 0);
    this.aQa = null;
    AppMethodBeat.o(193642);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(91827);
    if ((this.aPY) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(91827);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.bdm;
      paramMediaCodec.aQQ += 1;
      paramMediaCodec = this.aPX;
      if (paramMediaCodec.aPl == 1) {
        paramMediaCodec.aPl = 2;
      }
      AppMethodBeat.o(91827);
      return true;
    }
    try
    {
      localf = this.aPX;
      if (localf.aPr == null) {
        break label961;
      }
      if (paramByteBuffer != localf.aPr) {
        break label373;
      }
    }
    catch (f.d paramMediaCodec)
    {
      for (;;)
      {
        f localf;
        paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, getIndex());
        AppMethodBeat.o(91827);
        throw paramMediaCodec;
        paramLong1 = localf.aPm + localf.L(localf.rH());
        if ((localf.aPl == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.aPl = 2;
        }
        if (localf.aPl == 2)
        {
          localf.aPm = (paramLong3 - paramLong1 + localf.aPm);
          localf.aPl = 1;
          localf.aOI.rs();
          continue;
          localf.aPf += paramByteBuffer.remaining();
          continue;
          localf.J(paramLong3);
          continue;
          AppMethodBeat.o(91827);
          return false;
          paramBoolean = true;
          continue;
          paramInt2 = 0;
        }
      }
    }
    catch (f.h paramMediaCodec)
    {
      break label783;
    }
    com.google.android.exoplayer2.i.a.checkArgument(paramBoolean);
    if (!localf.isInitialized())
    {
      localf.aOJ.block();
      localf.aOO = localf.rL();
      paramInt2 = localf.aOO.getAudioSessionId();
      if ((f.aOC) && (x.SDK_INT < 21))
      {
        if ((localf.aON != null) && (paramInt2 != localf.aON.getAudioSessionId())) {
          localf.rG();
        }
        if (localf.aON == null) {
          localf.aON = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.aNI != paramInt2)
      {
        localf.aNI = paramInt2;
        localf.aOI.dU(paramInt2);
      }
      localf.aOL.a(localf.aOO, localf.rK());
      localf.rF();
      localf.aPy = false;
      if (localf.aPw) {
        localf.play();
      }
    }
    if (localf.rK()) {
      if (localf.aOO.getPlayState() == 2)
      {
        localf.aPy = false;
        break label967;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label953;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.bdm;
      paramMediaCodec.aQP += 1;
      AppMethodBeat.o(91827);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.aOO.getPlayState() == 1) && (localf.aOL.rM() != 0L)) {
        break label967;
      }
      paramBoolean = localf.aPy;
      localf.aPy = localf.rE();
      if ((paramBoolean) && (!localf.aPy) && (localf.aOO.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.aPz;
        localf.aOI.e(localf.bufferSize, com.google.android.exoplayer2.b.y(localf.aOR), paramLong1 - paramLong2);
      }
      if (localf.aPr != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.aOQ) && (localf.aPk == 0))
    {
      paramInt2 = localf.aOP;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.d(paramByteBuffer);
    }
    for (;;)
    {
      localf.aPk = paramInt2;
      if (localf.aOS != null)
      {
        if (!localf.rD()) {
          break label967;
        }
        localf.aOM.add(new f.g(localf.aOS, Math.max(0L, paramLong3), localf.L(localf.rI()), (byte)0));
        localf.aOS = null;
        localf.rC();
      }
      if (localf.aPl != 0) {
        break label803;
      }
      localf.aPm = Math.max(0L, paramLong3);
      localf.aPl = 1;
      if (!localf.aOQ) {
        break label923;
      }
      localf.aPg += localf.aPk;
      localf.aPr = paramByteBuffer;
      label677:
      if (!localf.aOQ) {
        break label943;
      }
      localf.a(localf.aPr, paramLong3);
      if (localf.aPr.hasRemaining()) {
        break label967;
      }
      localf.aPr = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.ry();
      }
      else
      {
        if (paramInt2 != 6) {
          break label752;
        }
        paramInt2 = a.b(paramByteBuffer);
      }
    }
    label752:
    paramMediaCodec = new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(91827);
    throw paramMediaCodec;
  }
  
  public final void aL(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(91818);
    super.aL(paramBoolean);
    Object localObject = this.aPW;
    com.google.android.exoplayer2.b.d locald = this.bdm;
    if (((e.a)localObject).aOq != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = qV().aNr;
    if (i != 0)
    {
      localObject = this.aPX;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).aPx) || (((f)localObject).aNI != i))
      {
        ((f)localObject).aPx = true;
        ((f)localObject).aNI = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(91818);
      return;
    }
    localObject = this.aPX;
    if (((f)localObject).aPx)
    {
      ((f)localObject).aPx = false;
      ((f)localObject).aNI = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(91818);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(91826);
    paramp = this.aPX.c(paramp);
    AppMethodBeat.o(91826);
    return paramp;
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91815);
    e.a locala = this.aPW;
    if (locala.aOq != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(91815);
  }
  
  public final void e(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(91829);
    switch (paramInt)
    {
    default: 
      super.e(paramInt, paramObject);
      AppMethodBeat.o(91829);
      return;
    case 2: 
      localf = this.aPX;
      float f = ((Float)paramObject).floatValue();
      if (localf.volume != f)
      {
        localf.volume = f;
        localf.rF();
      }
      AppMethodBeat.o(91829);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.aPX;
    if (!localf.aNJ.equals(paramObject))
    {
      localf.aNJ = paramObject;
      if (!localf.aPx)
      {
        localf.reset();
        localf.aNI = 0;
      }
    }
    AppMethodBeat.o(91829);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(91816);
    super.e(paramFormat);
    e.a locala = this.aPW;
    if (locala.aOq != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.aMQ)) {}
    for (int i = paramFormat.pcmEncoding;; i = 2)
    {
      this.pcmEncoding = i;
      this.channelCount = paramFormat.channelCount;
      AppMethodBeat.o(91816);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(91824);
    if ((this.aPX.rE()) || (super.isReady()))
    {
      AppMethodBeat.o(91824);
      return true;
    }
    AppMethodBeat.o(91824);
    return false;
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(91817);
    int i;
    if (this.aQa != null)
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    int m;
    int i1;
    label113:
    for (paramMediaCodec = this.aQa.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.aQa;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.aPZ) || (m != 6) || (this.channelCount >= 6)) {
        break label798;
      }
      paramMediaFormat = new int[this.channelCount];
      i = 0;
      while (i < this.channelCount)
      {
        paramMediaFormat[i] = i;
        i += 1;
      }
      i = 0;
      break;
    }
    f localf;
    boolean bool1;
    label143:
    label153:
    int k;
    int n;
    try
    {
      localf = this.aPX;
      j = this.pcmEncoding;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label803;
      }
      bool1 = true;
      if (!bool1) {
        break label809;
      }
      i = f.bp(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label780;
      }
      localf.aPe = x.br(j, m);
      localf.aOF.aPQ = paramMediaFormat;
      paramMediaCodec = localf.aOH;
      int i2 = paramMediaCodec.length;
      n = 0;
      j = m;
      m = n;
      label203:
      if (m < i2)
      {
        paramMediaFormat = paramMediaCodec[m];
        try
        {
          int i3 = paramMediaFormat.m(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label789;
          }
          j = paramMediaFormat.rz();
          i = 2;
        }
        catch (d.a paramMediaCodec)
        {
          paramMediaCodec = new f.c(paramMediaCodec);
          AppMethodBeat.o(91817);
          throw paramMediaCodec;
        }
      }
      if (k == 0) {
        break label815;
      }
    }
    catch (f.c paramMediaCodec)
    {
      paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, getIndex());
      AppMethodBeat.o(91817);
      throw paramMediaCodec;
    }
    localf.rC();
    break label815;
    paramMediaCodec = new f.c("Unsupported channel count: ".concat(String.valueOf(m)));
    AppMethodBeat.o(91817);
    throw paramMediaCodec;
    label333:
    int j = i;
    if (x.SDK_INT <= 23)
    {
      j = i;
      if ("foster".equals(x.bro))
      {
        j = i;
        if ("NVIDIA".equals(x.brp)) {
          j = i;
        }
      }
    }
    switch (m)
    {
    case 4: 
    case 6: 
      label412:
      if ((x.SDK_INT <= 25) && ("fugu".equals(x.bro)) && (bool1) && (m == 1))
      {
        i = 12;
        label446:
        if ((n != 0) || (!localf.isInitialized()) || (localf.encoding != k) || (localf.sampleRate != i1) || (localf.channelConfig != i))
        {
          localf.reset();
          localf.encoding = k;
          localf.aOQ = bool1;
          localf.sampleRate = i1;
          localf.channelConfig = i;
          if (!bool1) {
            break label905;
          }
          localf.aOP = k;
          localf.aPh = x.br(2, m);
          if (!bool1) {
            break label666;
          }
          if (localf.aOP == 5) {
            break label890;
          }
          if (localf.aOP != 6) {
            break label911;
          }
        }
      }
      label525:
      break;
    }
    for (;;)
    {
      label570:
      localf.bufferSize = i;
      long l;
      if (bool1)
      {
        l = -9223372036854775807L;
        label586:
        localf.aOR = l;
        localf.c(localf.aLS);
        AppMethodBeat.o(91817);
        return;
        i = 12;
        break label333;
        i = 28;
        break label333;
        i = 204;
        break label333;
        i = 220;
        break label333;
        i = 252;
        break label333;
        i = 1276;
        break label333;
        i = com.google.android.exoplayer2.b.aLh;
        break label333;
        j = com.google.android.exoplayer2.b.aLh;
        break label412;
        label666:
        k = AudioTrack.getMinBufferSize(i1, i, localf.aOP);
        if (k == -2) {
          break label918;
        }
      }
      label780:
      label789:
      label918:
      for (boolean bool2 = true;; bool2 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool2);
        i = k * 4;
        j = (int)localf.M(250000L) * localf.aPh;
        k = (int)Math.max(k, localf.M(750000L) * localf.aPh);
        if (i >= j) {
          break label924;
        }
        i = j;
        break label570;
        l = localf.L(localf.bufferSize / localf.aPh);
        break label586;
        i = j;
        break label446;
        n = 0;
        k = i;
        break label826;
        m += 1;
        break label203;
        label798:
        paramMediaFormat = null;
        break;
        label803:
        bool1 = false;
        break label143;
        label809:
        i = j;
        break label153;
        label815:
        m = j;
        n = k;
        k = i;
        switch (m)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          break;
        case 1: 
          label826:
          i = 4;
          break label333;
          j = i;
          break label412;
          label890:
          i = 20480;
          break label570;
          j = 252;
          break label412;
          k = 2;
          break label525;
          i = 49152;
          break label570;
        }
      }
      label905:
      label911:
      label924:
      if (i > k) {
        i = k;
      }
    }
  }
  
  public final com.google.android.exoplayer2.i.i qL()
  {
    return this;
  }
  
  public final void qS()
  {
    AppMethodBeat.i(91820);
    super.qS();
    this.aPX.play();
    AppMethodBeat.o(91820);
  }
  
  public final void qT()
  {
    AppMethodBeat.i(91821);
    f localf = this.aPX;
    localf.aPw = false;
    if (localf.isInitialized())
    {
      localf.rJ();
      localf.aOL.pause();
    }
    super.qT();
    AppMethodBeat.o(91821);
  }
  
  /* Error */
  public final void qU()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 726
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/google/android/exoplayer2/a/i:aPX	Lcom/google/android/exoplayer2/a/f;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 225	com/google/android/exoplayer2/a/f:reset	()V
    //   17: aload_3
    //   18: invokevirtual 337	com/google/android/exoplayer2/a/f:rG	()V
    //   21: aload_3
    //   22: getfield 654	com/google/android/exoplayer2/a/f:aOH	[Lcom/google/android/exoplayer2/a/d;
    //   25: astore 4
    //   27: aload 4
    //   29: arraylength
    //   30: istore_2
    //   31: iload_1
    //   32: iload_2
    //   33: if_icmpge +19 -> 52
    //   36: aload 4
    //   38: iload_1
    //   39: aaload
    //   40: invokeinterface 727 1 0
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -18 -> 31
    //   52: aload_3
    //   53: iconst_0
    //   54: putfield 343	com/google/android/exoplayer2/a/f:aNI	I
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 373	com/google/android/exoplayer2/a/f:aPw	Z
    //   62: aload_0
    //   63: invokespecial 729	com/google/android/exoplayer2/e/b:qU	()V
    //   66: aload_0
    //   67: getfield 56	com/google/android/exoplayer2/a/i:aPW	Lcom/google/android/exoplayer2/a/e$a;
    //   70: aload_0
    //   71: getfield 284	com/google/android/exoplayer2/a/i:bdm	Lcom/google/android/exoplayer2/b/d;
    //   74: invokevirtual 732	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   77: ldc_w 726
    //   80: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 56	com/google/android/exoplayer2/a/i:aPW	Lcom/google/android/exoplayer2/a/e$a;
    //   89: aload_0
    //   90: getfield 284	com/google/android/exoplayer2/a/i:bdm	Lcom/google/android/exoplayer2/b/d;
    //   93: invokevirtual 732	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   96: ldc_w 726
    //   99: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aload_0
    //   106: invokespecial 729	com/google/android/exoplayer2/e/b:qU	()V
    //   109: aload_0
    //   110: getfield 56	com/google/android/exoplayer2/a/i:aPW	Lcom/google/android/exoplayer2/a/e$a;
    //   113: aload_0
    //   114: getfield 284	com/google/android/exoplayer2/a/i:bdm	Lcom/google/android/exoplayer2/b/d;
    //   117: invokevirtual 732	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   120: ldc_w 726
    //   123: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 56	com/google/android/exoplayer2/a/i:aPW	Lcom/google/android/exoplayer2/a/e$a;
    //   133: aload_0
    //   134: getfield 284	com/google/android/exoplayer2/a/i:bdm	Lcom/google/android/exoplayer2/b/d;
    //   137: invokevirtual 732	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   140: ldc_w 726
    //   143: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_3
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	i
    //   1	48	1	i	int
    //   30	4	2	j	int
    //   12	46	3	localf	f
    //   84	19	3	localObject1	Object
    //   104	23	3	localObject2	Object
    //   128	19	3	localObject3	Object
    //   25	12	4	arrayOfd	d[]
    // Exception table:
    //   from	to	target	type
    //   62	66	84	finally
    //   8	31	104	finally
    //   36	45	104	finally
    //   52	62	104	finally
    //   105	109	128	finally
  }
  
  public final long rN()
  {
    AppMethodBeat.i(91825);
    long l = this.aPX.aQ(rt());
    if (l != -9223372036854775808L) {
      if (!this.aQc) {
        break label56;
      }
    }
    for (;;)
    {
      this.aQb = l;
      this.aQc = false;
      l = this.aQb;
      AppMethodBeat.o(91825);
      return l;
      label56:
      l = Math.max(this.aQb, l);
    }
  }
  
  public final p rR()
  {
    return this.aPX.aLS;
  }
  
  public final void rS()
  {
    AppMethodBeat.i(91828);
    try
    {
      f localf = this.aPX;
      if ((localf.aPv) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(91828);
        return;
      }
      if (localf.rD())
      {
        localf.aOL.N(localf.rI());
        localf.aOW = 0;
        localf.aPv = true;
      }
      AppMethodBeat.o(91828);
      return;
    }
    catch (f.h localh)
    {
      com.google.android.exoplayer2.e locale = com.google.android.exoplayer2.e.b(localh, getIndex());
      AppMethodBeat.o(91828);
      throw locale;
    }
  }
  
  public final boolean rt()
  {
    AppMethodBeat.i(91823);
    if (super.rt())
    {
      f localf = this.aPX;
      if ((!localf.isInitialized()) || ((localf.aPv) && (!localf.rE()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91823);
        return true;
      }
    }
    AppMethodBeat.o(91823);
    return false;
  }
  
  final class a
    implements f.f
  {
    private a() {}
    
    public final void dU(int paramInt)
    {
      AppMethodBeat.i(91807);
      e.a locala = i.a(i.this);
      if (locala.aOq != null) {
        locala.handler.post(new e.a.6(locala, paramInt));
      }
      AppMethodBeat.o(91807);
    }
    
    public final void e(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(91809);
      e.a locala = i.a(i.this);
      if (locala.aOq != null) {
        locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
      }
      AppMethodBeat.o(91809);
    }
    
    public final void rs()
    {
      AppMethodBeat.i(91808);
      i.b(i.this);
      AppMethodBeat.o(91808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */