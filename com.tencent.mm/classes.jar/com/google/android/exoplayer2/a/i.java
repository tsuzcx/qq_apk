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
  private MediaFormat bgA;
  private long bgB;
  private boolean bgC;
  private final e.a bgw;
  private final f bgx;
  private boolean bgy;
  private boolean bgz;
  private int channelCount;
  private int pcmEncoding;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(91810);
    this.bgx = new f(paramc1, paramVarArgs, new a((byte)0));
    this.bgw = new e.a(paramHandler, parame);
    AppMethodBeat.o(91810);
  }
  
  private boolean bf(String paramString)
  {
    AppMethodBeat.i(91813);
    boolean bool = this.bgx.bd(paramString);
    AppMethodBeat.o(91813);
    return bool;
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(91811);
    Object localObject = paramFormat.bdq;
    if (!j.bx((String)localObject))
    {
      AppMethodBeat.o(91811);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (bf((String)localObject)) && (paramc.vf() != null); j = 0)
    {
      AppMethodBeat.o(91811);
      return j | 0x8 | 0x4;
    }
    paramc = paramc.d((String)localObject, false);
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
        if (paramc.bsZ != null) {
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
        if (paramc.bsZ != null) {
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
      localObject = paramc.bsZ.getAudioCapabilities();
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
      paramFormat = paramc.bsZ.getAudioCapabilities();
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
    if (bf(paramFormat.bdq))
    {
      com.google.android.exoplayer2.e.a locala = paramc.vf();
      if (locala != null)
      {
        this.bgy = true;
        AppMethodBeat.o(91812);
        return locala;
      }
    }
    this.bgy = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(91812);
    return paramc;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(91819);
    super.a(paramLong, paramBoolean);
    this.bgx.reset();
    this.bgB = paramLong;
    this.bgC = true;
    AppMethodBeat.o(91819);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(91814);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("herolte")) || (x.DEVICE.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bgz = bool;
      if (!this.bgy) {
        break;
      }
      this.bgA = paramFormat.tw();
      this.bgA.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.bgA, null, paramMediaCrypto, 0);
      this.bgA.setString("mime", paramFormat.bdq);
      AppMethodBeat.o(91814);
      return;
    }
    paramMediaCodec.configure(paramFormat.tw(), null, paramMediaCrypto, 0);
    this.bgA = null;
    AppMethodBeat.o(91814);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(91827);
    if ((this.bgy) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(91827);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.btJ;
      paramMediaCodec.bhm += 1;
      paramMediaCodec = this.bgx;
      if (paramMediaCodec.bfL == 1) {
        paramMediaCodec.bfL = 2;
      }
      AppMethodBeat.o(91827);
      return true;
    }
    try
    {
      localf = this.bgx;
      if (localf.bfR == null) {
        break label961;
      }
      if (paramByteBuffer != localf.bfR) {
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
        paramLong1 = localf.bfM + localf.I(localf.tP());
        if ((localf.bfL == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.bfL = 2;
        }
        if (localf.bfL == 2)
        {
          localf.bfM = (paramLong3 - paramLong1 + localf.bfM);
          localf.bfL = 1;
          localf.bfh.tA();
          continue;
          localf.bfF += paramByteBuffer.remaining();
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
      localf.bfi.block();
      localf.bfn = localf.tT();
      paramInt2 = localf.bfn.getAudioSessionId();
      if ((f.bfb) && (x.SDK_INT < 21))
      {
        if ((localf.bfm != null) && (paramInt2 != localf.bfm.getAudioSessionId())) {
          localf.tO();
        }
        if (localf.bfm == null) {
          localf.bfm = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.beh != paramInt2)
      {
        localf.beh = paramInt2;
        localf.bfh.dG(paramInt2);
      }
      localf.bfk.a(localf.bfn, localf.tS());
      localf.tN();
      localf.bfY = false;
      if (localf.bfW) {
        localf.play();
      }
    }
    if (localf.tS()) {
      if (localf.bfn.getPlayState() == 2)
      {
        localf.bfY = false;
        break label967;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label953;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.btJ;
      paramMediaCodec.bhl += 1;
      AppMethodBeat.o(91827);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.bfn.getPlayState() == 1) && (localf.bfk.tU() != 0L)) {
        break label967;
      }
      paramBoolean = localf.bfY;
      localf.bfY = localf.tM();
      if ((paramBoolean) && (!localf.bfY) && (localf.bfn.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.bfZ;
        localf.bfh.e(localf.bufferSize, com.google.android.exoplayer2.b.v(localf.bfq), paramLong1 - paramLong2);
      }
      if (localf.bfR != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.bfp) && (localf.bfK == 0))
    {
      paramInt2 = localf.bfo;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.g(paramByteBuffer);
    }
    for (;;)
    {
      localf.bfK = paramInt2;
      if (localf.bfr != null)
      {
        if (!localf.tL()) {
          break label967;
        }
        localf.bfl.add(new f.g(localf.bfr, Math.max(0L, paramLong3), localf.I(localf.tQ()), (byte)0));
        localf.bfr = null;
        localf.tK();
      }
      if (localf.bfL != 0) {
        break label803;
      }
      localf.bfM = Math.max(0L, paramLong3);
      localf.bfL = 1;
      if (!localf.bfp) {
        break label923;
      }
      localf.bfG += localf.bfK;
      localf.bfR = paramByteBuffer;
      label677:
      if (!localf.bfp) {
        break label943;
      }
      localf.a(localf.bfR, paramLong3);
      if (localf.bfR.hasRemaining()) {
        break label967;
      }
      localf.bfR = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.tG();
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
  
  public final void aN(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(91818);
    super.aN(paramBoolean);
    Object localObject = this.bgw;
    com.google.android.exoplayer2.b.d locald = this.btJ;
    if (((e.a)localObject).beP != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = this.bbE.bdQ;
    if (i != 0)
    {
      localObject = this.bgx;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).bfX) || (((f)localObject).beh != i))
      {
        ((f)localObject).bfX = true;
        ((f)localObject).beh = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(91818);
      return;
    }
    localObject = this.bgx;
    if (((f)localObject).bfX)
    {
      ((f)localObject).bfX = false;
      ((f)localObject).beh = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(91818);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(91826);
    paramp = this.bgx.c(paramp);
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
      localf = this.bgx;
      float f = ((Float)paramObject).floatValue();
      if (localf.volume != f)
      {
        localf.volume = f;
        localf.tN();
      }
      AppMethodBeat.o(91829);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.bgx;
    if (!localf.bei.equals(paramObject))
    {
      localf.bei = paramObject;
      if (!localf.bfX)
      {
        localf.reset();
        localf.beh = 0;
      }
    }
    AppMethodBeat.o(91829);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91815);
    e.a locala = this.bgw;
    if (locala.beP != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(91815);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(91816);
    super.e(paramFormat);
    e.a locala = this.bgw;
    if (locala.beP != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.bdq)) {}
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
    if ((this.bgx.tM()) || (super.isReady()))
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
    if (this.bgA != null)
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    int m;
    int i1;
    label113:
    for (paramMediaCodec = this.bgA.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.bgA;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.bgz) || (m != 6) || (this.channelCount >= 6)) {
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
      localf = this.bgx;
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
      localf.bfE = x.bj(j, m);
      localf.bfe.bgq = paramMediaFormat;
      paramMediaCodec = localf.bfg;
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
          int i3 = paramMediaFormat.p(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label789;
          }
          j = paramMediaFormat.tH();
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
    localf.tK();
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
          localf.bfp = bool1;
          localf.sampleRate = i1;
          localf.channelConfig = i;
          if (!bool1) {
            break label905;
          }
          localf.bfo = k;
          localf.bfH = x.bj(2, m);
          if (!bool1) {
            break label666;
          }
          if (localf.bfo == 5) {
            break label890;
          }
          if (localf.bfo != 6) {
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
        localf.bfq = l;
        localf.c(localf.bcs);
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
        k = AudioTrack.getMinBufferSize(i1, i, localf.bfo);
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
        j = (int)localf.J(250000L) * localf.bfH;
        k = (int)Math.max(k, localf.J(750000L) * localf.bfH);
        if (i >= j) {
          break label924;
        }
        i = j;
        break label570;
        l = localf.I(localf.bufferSize / localf.bfH);
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
    this.bgx.play();
    AppMethodBeat.o(91820);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(91821);
    f localf = this.bgx;
    localf.bfW = false;
    if (localf.isInitialized())
    {
      localf.tR();
      localf.bfk.pause();
    }
    super.onStopped();
    AppMethodBeat.o(91821);
  }
  
  public final com.google.android.exoplayer2.i.i sX()
  {
    return this;
  }
  
  public final boolean tB()
  {
    AppMethodBeat.i(91823);
    if (super.tB())
    {
      f localf = this.bgx;
      if ((!localf.isInitialized()) || ((localf.bfV) && (!localf.tM()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91823);
        return true;
      }
    }
    AppMethodBeat.o(91823);
    return false;
  }
  
  public final long tV()
  {
    AppMethodBeat.i(91825);
    long l = this.bgx.aS(tB());
    if (l != -9223372036854775808L) {
      if (!this.bgC) {
        break label56;
      }
    }
    for (;;)
    {
      this.bgB = l;
      this.bgC = false;
      l = this.bgB;
      AppMethodBeat.o(91825);
      return l;
      label56:
      l = Math.max(this.bgB, l);
    }
  }
  
  public final p tZ()
  {
    return this.bgx.bcs;
  }
  
  /* Error */
  public final void te()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 746
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/google/android/exoplayer2/a/i:bgx	Lcom/google/android/exoplayer2/a/f;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 225	com/google/android/exoplayer2/a/f:reset	()V
    //   17: aload_3
    //   18: invokevirtual 337	com/google/android/exoplayer2/a/f:tO	()V
    //   21: aload_3
    //   22: getfield 657	com/google/android/exoplayer2/a/f:bfg	[Lcom/google/android/exoplayer2/a/d;
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
    //   40: invokeinterface 747 1 0
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -18 -> 31
    //   52: aload_3
    //   53: iconst_0
    //   54: putfield 343	com/google/android/exoplayer2/a/f:beh	I
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 373	com/google/android/exoplayer2/a/f:bfW	Z
    //   62: aload_0
    //   63: invokespecial 749	com/google/android/exoplayer2/e/b:te	()V
    //   66: aload_0
    //   67: getfield 56	com/google/android/exoplayer2/a/i:bgw	Lcom/google/android/exoplayer2/a/e$a;
    //   70: aload_0
    //   71: getfield 284	com/google/android/exoplayer2/a/i:btJ	Lcom/google/android/exoplayer2/b/d;
    //   74: invokevirtual 752	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   77: ldc_w 746
    //   80: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 56	com/google/android/exoplayer2/a/i:bgw	Lcom/google/android/exoplayer2/a/e$a;
    //   89: aload_0
    //   90: getfield 284	com/google/android/exoplayer2/a/i:btJ	Lcom/google/android/exoplayer2/b/d;
    //   93: invokevirtual 752	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   96: ldc_w 746
    //   99: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aload_0
    //   106: invokespecial 749	com/google/android/exoplayer2/e/b:te	()V
    //   109: aload_0
    //   110: getfield 56	com/google/android/exoplayer2/a/i:bgw	Lcom/google/android/exoplayer2/a/e$a;
    //   113: aload_0
    //   114: getfield 284	com/google/android/exoplayer2/a/i:btJ	Lcom/google/android/exoplayer2/b/d;
    //   117: invokevirtual 752	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   120: ldc_w 746
    //   123: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 56	com/google/android/exoplayer2/a/i:bgw	Lcom/google/android/exoplayer2/a/e$a;
    //   133: aload_0
    //   134: getfield 284	com/google/android/exoplayer2/a/i:btJ	Lcom/google/android/exoplayer2/b/d;
    //   137: invokevirtual 752	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   140: ldc_w 746
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
  
  public final void ua()
  {
    AppMethodBeat.i(91828);
    try
    {
      f localf = this.bgx;
      if ((localf.bfV) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(91828);
        return;
      }
      if (localf.tL())
      {
        localf.bfk.K(localf.tQ());
        localf.bfw = 0;
        localf.bfV = true;
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
  
  final class a
    implements f.f
  {
    private a() {}
    
    public final void dG(int paramInt)
    {
      AppMethodBeat.i(91807);
      e.a locala = i.a(i.this);
      if (locala.beP != null) {
        locala.handler.post(new e.a.6(locala, paramInt));
      }
      AppMethodBeat.o(91807);
    }
    
    public final void e(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(91809);
      e.a locala = i.a(i.this);
      if (locala.beP != null) {
        locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
      }
      AppMethodBeat.o(91809);
    }
    
    public final void tA()
    {
      AppMethodBeat.i(91808);
      i.b(i.this);
      AppMethodBeat.o(91808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */