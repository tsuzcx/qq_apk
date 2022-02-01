package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCrypto;
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
  private final f bgA;
  private boolean bgB;
  private boolean bgC;
  private MediaFormat bgD;
  private long bgE;
  private boolean bgF;
  private final e.a bgz;
  private int channelCount;
  private int pcmEncoding;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(91810);
    this.bgA = new f(paramc1, paramVarArgs, new a((byte)0));
    this.bgz = new e.a(paramHandler, parame);
    AppMethodBeat.o(91810);
  }
  
  private boolean bf(String paramString)
  {
    AppMethodBeat.i(91813);
    boolean bool = this.bgA.bd(paramString);
    AppMethodBeat.o(91813);
    return bool;
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(91811);
    Object localObject = paramFormat.bdt;
    if (!j.bx((String)localObject))
    {
      AppMethodBeat.o(91811);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (bf((String)localObject)) && (paramc.va() != null); j = 0)
    {
      AppMethodBeat.o(91811);
      return j | 0x8 | 0x4;
    }
    paramc = paramc.f((String)localObject, false);
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
        if (paramc.bte != null) {
          break label203;
        }
        paramc.bh("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label183;
        }
      }
      if (paramFormat.channelCount != -1)
      {
        n = paramFormat.channelCount;
        if (paramc.bte != null) {
          break label260;
        }
        paramc.bh("channelCount.caps");
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
      localObject = paramc.bte.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.bh("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.bh("sampleRate.support, ".concat(String.valueOf(i)));
        i = 0;
        break;
      }
      i = 1;
      break;
      label260:
      paramFormat = paramc.bte.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.bh("channelCount.aCaps");
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
          paramc.bh("channelCount.support, ".concat(String.valueOf(n)));
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
    if (bf(paramFormat.bdt))
    {
      com.google.android.exoplayer2.e.a locala = paramc.va();
      if (locala != null)
      {
        this.bgB = true;
        AppMethodBeat.o(91812);
        return locala;
      }
    }
    this.bgB = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(91812);
    return paramc;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(91819);
    super.a(paramLong, paramBoolean);
    this.bgA.reset();
    this.bgE = paramLong;
    this.bgF = true;
    AppMethodBeat.o(91819);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(91814);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("herolte")) || (x.DEVICE.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bgC = bool;
      if (!this.bgB) {
        break;
      }
      this.bgD = paramFormat.tr();
      this.bgD.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.bgD, null, paramMediaCrypto, 0);
      this.bgD.setString("mime", paramFormat.bdt);
      AppMethodBeat.o(91814);
      return;
    }
    paramMediaCodec.configure(paramFormat.tr(), null, paramMediaCrypto, 0);
    this.bgD = null;
    AppMethodBeat.o(91814);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(91827);
    if ((this.bgB) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(91827);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.btO;
      paramMediaCodec.bhp += 1;
      paramMediaCodec = this.bgA;
      if (paramMediaCodec.bfO == 1) {
        paramMediaCodec.bfO = 2;
      }
      AppMethodBeat.o(91827);
      return true;
    }
    try
    {
      localf = this.bgA;
      if (localf.bfU == null) {
        break label961;
      }
      if (paramByteBuffer != localf.bfU) {
        break label373;
      }
    }
    catch (f.d paramMediaCodec)
    {
      for (;;)
      {
        f localf;
        paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, this.index);
        AppMethodBeat.o(91827);
        throw paramMediaCodec;
        paramLong1 = localf.bfP + localf.I(localf.tK());
        if ((localf.bfO == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.bfO = 2;
        }
        if (localf.bfO == 2)
        {
          localf.bfP = (paramLong3 - paramLong1 + localf.bfP);
          localf.bfO = 1;
          localf.bfk.tv();
          continue;
          localf.bfI += paramByteBuffer.remaining();
          continue;
          localf.G(paramLong3);
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
      localf.bfl.block();
      localf.bfq = localf.tO();
      paramInt2 = localf.bfq.getAudioSessionId();
      if ((f.bfe) && (x.SDK_INT < 21))
      {
        if ((localf.bfp != null) && (paramInt2 != localf.bfp.getAudioSessionId())) {
          localf.tJ();
        }
        if (localf.bfp == null) {
          localf.bfp = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.bek != paramInt2)
      {
        localf.bek = paramInt2;
        localf.bfk.dL(paramInt2);
      }
      localf.bfn.a(localf.bfq, localf.tN());
      localf.tI();
      localf.bgb = false;
      if (localf.bfZ) {
        localf.play();
      }
    }
    if (localf.tN()) {
      if (localf.bfq.getPlayState() == 2)
      {
        localf.bgb = false;
        break label967;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label953;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.btO;
      paramMediaCodec.bho += 1;
      AppMethodBeat.o(91827);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.bfq.getPlayState() == 1) && (localf.bfn.tP() != 0L)) {
        break label967;
      }
      paramBoolean = localf.bgb;
      localf.bgb = localf.tH();
      if ((paramBoolean) && (!localf.bgb) && (localf.bfq.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.bgc;
        localf.bfk.d(localf.bufferSize, com.google.android.exoplayer2.b.v(localf.bfu), paramLong1 - paramLong2);
      }
      if (localf.bfU != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.bft) && (localf.bfN == 0))
    {
      paramInt2 = localf.bfr;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.g(paramByteBuffer);
    }
    for (;;)
    {
      localf.bfN = paramInt2;
      if (localf.bfv != null)
      {
        if (!localf.tG()) {
          break label967;
        }
        localf.bfo.add(new f.g(localf.bfv, Math.max(0L, paramLong3), localf.I(localf.tL()), (byte)0));
        localf.bfv = null;
        localf.tF();
      }
      if (localf.bfO != 0) {
        break label803;
      }
      localf.bfP = Math.max(0L, paramLong3);
      localf.bfO = 1;
      if (!localf.bft) {
        break label923;
      }
      localf.bfJ += localf.bfN;
      localf.bfU = paramByteBuffer;
      label677:
      if (!localf.bft) {
        break label943;
      }
      localf.a(localf.bfU, paramLong3);
      if (localf.bfU.hasRemaining()) {
        break label967;
      }
      localf.bfU = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.tB();
      }
      else
      {
        if (paramInt2 != 6) {
          break label752;
        }
        paramInt2 = a.e(paramByteBuffer);
      }
    }
    label752:
    paramMediaCodec = new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(91827);
    throw paramMediaCodec;
  }
  
  public final void aO(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(91818);
    super.aO(paramBoolean);
    Object localObject = this.bgz;
    com.google.android.exoplayer2.b.d locald = this.btO;
    if (((e.a)localObject).beS != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = this.bbH.bdT;
    if (i != 0)
    {
      localObject = this.bgA;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).bga) || (((f)localObject).bek != i))
      {
        ((f)localObject).bga = true;
        ((f)localObject).bek = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(91818);
      return;
    }
    localObject = this.bgA;
    if (((f)localObject).bga)
    {
      ((f)localObject).bga = false;
      ((f)localObject).bek = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(91818);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(91826);
    paramp = this.bgA.c(paramp);
    AppMethodBeat.o(91826);
    return paramp;
  }
  
  public final void c(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(91829);
    switch (paramInt)
    {
    default: 
      super.c(paramInt, paramObject);
      AppMethodBeat.o(91829);
      return;
    case 2: 
      localf = this.bgA;
      float f = ((Float)paramObject).floatValue();
      if (localf.volume != f)
      {
        localf.volume = f;
        localf.tI();
      }
      AppMethodBeat.o(91829);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.bgA;
    if (!localf.bel.equals(paramObject))
    {
      localf.bel = paramObject;
      if (!localf.bga)
      {
        localf.reset();
        localf.bek = 0;
      }
    }
    AppMethodBeat.o(91829);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91815);
    e.a locala = this.bgz;
    if (locala.beS != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(91815);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(91816);
    super.e(paramFormat);
    e.a locala = this.bgz;
    if (locala.beS != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.bdt)) {}
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
    if ((this.bgA.tH()) || (super.isReady()))
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
    if (this.bgD != null)
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    int m;
    int i1;
    label113:
    for (paramMediaCodec = this.bgD.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.bgD;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.bgC) || (m != 6) || (this.channelCount >= 6)) {
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
      localf = this.bgA;
      j = this.pcmEncoding;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label803;
      }
      bool1 = true;
      if (!bool1) {
        break label809;
      }
      i = f.be(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label780;
      }
      localf.bfH = x.bp(j, m);
      localf.bfh.bgt = paramMediaFormat;
      paramMediaCodec = localf.bfj;
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
          int i3 = paramMediaFormat.s(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label789;
          }
          j = paramMediaFormat.tC();
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
      paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, this.index);
      AppMethodBeat.o(91817);
      throw paramMediaCodec;
    }
    localf.tF();
    break label815;
    paramMediaCodec = new f.c("Unsupported channel count: ".concat(String.valueOf(m)));
    AppMethodBeat.o(91817);
    throw paramMediaCodec;
    label333:
    int j = i;
    if (x.SDK_INT <= 23)
    {
      j = i;
      if ("foster".equals(x.DEVICE))
      {
        j = i;
        if ("NVIDIA".equals(x.MANUFACTURER)) {
          j = i;
        }
      }
    }
    switch (m)
    {
    case 4: 
    case 6: 
      label412:
      if ((x.SDK_INT <= 25) && ("fugu".equals(x.DEVICE)) && (bool1) && (m == 1))
      {
        i = 12;
        label446:
        if ((n != 0) || (!localf.isInitialized()) || (localf.encoding != k) || (localf.sampleRate != i1) || (localf.channelConfig != i))
        {
          localf.reset();
          localf.encoding = k;
          localf.bft = bool1;
          localf.sampleRate = i1;
          localf.channelConfig = i;
          if (!bool1) {
            break label905;
          }
          localf.bfr = k;
          localf.bfK = x.bp(2, m);
          if (!bool1) {
            break label666;
          }
          if (localf.bfr == 5) {
            break label890;
          }
          if (localf.bfr != 6) {
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
        localf.bfu = l;
        localf.c(localf.bcv);
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
        i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label333;
        j = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label412;
        label666:
        k = AudioTrack.getMinBufferSize(i1, i, localf.bfr);
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
        j = (int)localf.J(250000L) * localf.bfK;
        k = (int)Math.max(k, localf.J(750000L) * localf.bfK);
        if (i >= j) {
          break label924;
        }
        i = j;
        break label570;
        l = localf.I(localf.bufferSize / localf.bfK);
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
  
  public final void onStarted()
  {
    AppMethodBeat.i(91820);
    super.onStarted();
    this.bgA.play();
    AppMethodBeat.o(91820);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(91821);
    f localf = this.bgA;
    localf.bfZ = false;
    if (localf.isInitialized())
    {
      localf.tM();
      localf.bfn.pause();
    }
    super.onStopped();
    AppMethodBeat.o(91821);
  }
  
  public final com.google.android.exoplayer2.i.i sS()
  {
    return this;
  }
  
  /* Error */
  public final void sZ()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 729
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/google/android/exoplayer2/a/i:bgA	Lcom/google/android/exoplayer2/a/f;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 225	com/google/android/exoplayer2/a/f:reset	()V
    //   17: aload_3
    //   18: invokevirtual 337	com/google/android/exoplayer2/a/f:tJ	()V
    //   21: aload_3
    //   22: getfield 658	com/google/android/exoplayer2/a/f:bfj	[Lcom/google/android/exoplayer2/a/d;
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
    //   40: invokeinterface 730 1 0
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -18 -> 31
    //   52: aload_3
    //   53: iconst_0
    //   54: putfield 343	com/google/android/exoplayer2/a/f:bek	I
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 373	com/google/android/exoplayer2/a/f:bfZ	Z
    //   62: aload_0
    //   63: invokespecial 732	com/google/android/exoplayer2/e/b:sZ	()V
    //   66: aload_0
    //   67: getfield 56	com/google/android/exoplayer2/a/i:bgz	Lcom/google/android/exoplayer2/a/e$a;
    //   70: aload_0
    //   71: getfield 284	com/google/android/exoplayer2/a/i:btO	Lcom/google/android/exoplayer2/b/d;
    //   74: invokevirtual 735	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   77: ldc_w 729
    //   80: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 56	com/google/android/exoplayer2/a/i:bgz	Lcom/google/android/exoplayer2/a/e$a;
    //   89: aload_0
    //   90: getfield 284	com/google/android/exoplayer2/a/i:btO	Lcom/google/android/exoplayer2/b/d;
    //   93: invokevirtual 735	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   96: ldc_w 729
    //   99: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aload_0
    //   106: invokespecial 732	com/google/android/exoplayer2/e/b:sZ	()V
    //   109: aload_0
    //   110: getfield 56	com/google/android/exoplayer2/a/i:bgz	Lcom/google/android/exoplayer2/a/e$a;
    //   113: aload_0
    //   114: getfield 284	com/google/android/exoplayer2/a/i:btO	Lcom/google/android/exoplayer2/b/d;
    //   117: invokevirtual 735	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   120: ldc_w 729
    //   123: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 56	com/google/android/exoplayer2/a/i:bgz	Lcom/google/android/exoplayer2/a/e$a;
    //   133: aload_0
    //   134: getfield 284	com/google/android/exoplayer2/a/i:btO	Lcom/google/android/exoplayer2/b/d;
    //   137: invokevirtual 735	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   140: ldc_w 729
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
  
  public final long tQ()
  {
    AppMethodBeat.i(91825);
    long l = this.bgA.aT(tw());
    if (l != -9223372036854775808L) {
      if (!this.bgF) {
        break label56;
      }
    }
    for (;;)
    {
      this.bgE = l;
      this.bgF = false;
      l = this.bgE;
      AppMethodBeat.o(91825);
      return l;
      label56:
      l = Math.max(this.bgE, l);
    }
  }
  
  public final p tU()
  {
    return this.bgA.bcv;
  }
  
  public final void tV()
  {
    AppMethodBeat.i(91828);
    try
    {
      f localf = this.bgA;
      if ((localf.bfY) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(91828);
        return;
      }
      if (localf.tG())
      {
        localf.bfn.K(localf.tL());
        localf.bfz = 0;
        localf.bfY = true;
      }
      AppMethodBeat.o(91828);
      return;
    }
    catch (f.h localh)
    {
      com.google.android.exoplayer2.e locale = com.google.android.exoplayer2.e.b(localh, this.index);
      AppMethodBeat.o(91828);
      throw locale;
    }
  }
  
  public final boolean tw()
  {
    AppMethodBeat.i(91823);
    if (super.tw())
    {
      f localf = this.bgA;
      if ((!localf.isInitialized()) || ((localf.bfY) && (!localf.tH()))) {}
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
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(91809);
      e.a locala = i.a(i.this);
      if (locala.beS != null) {
        locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
      }
      AppMethodBeat.o(91809);
    }
    
    public final void dL(int paramInt)
    {
      AppMethodBeat.i(91807);
      e.a locala = i.a(i.this);
      if (locala.beS != null) {
        locala.handler.post(new e.a.6(locala, paramInt));
      }
      AppMethodBeat.o(91807);
    }
    
    public final void tv()
    {
      AppMethodBeat.i(91808);
      i.b(i.this);
      AppMethodBeat.o(91808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */