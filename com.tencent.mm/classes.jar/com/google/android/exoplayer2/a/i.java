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
  private final e.a aVr;
  private final f aVs;
  private boolean aVt;
  private boolean aVu;
  private MediaFormat aVv;
  private long aVw;
  private boolean aVx;
  private int channelCount;
  private int pcmEncoding;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(91810);
    this.aVs = new f(paramc1, paramVarArgs, new a((byte)0));
    this.aVr = new e.a(paramHandler, parame);
    AppMethodBeat.o(91810);
  }
  
  private boolean ak(String paramString)
  {
    AppMethodBeat.i(91813);
    boolean bool = this.aVs.ai(paramString);
    AppMethodBeat.o(91813);
    return bool;
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(91811);
    Object localObject = paramFormat.aSd;
    if (!j.aJ((String)localObject))
    {
      AppMethodBeat.o(91811);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (ak((String)localObject)) && (paramc.tt() != null); j = 0)
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
        if (paramc.bif != null) {
          break label203;
        }
        paramc.am("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label183;
        }
      }
      if (paramFormat.channelCount != -1)
      {
        n = paramFormat.channelCount;
        if (paramc.bif != null) {
          break label260;
        }
        paramc.am("channelCount.caps");
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
      localObject = paramc.bif.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.am("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.am("sampleRate.support, ".concat(String.valueOf(i)));
        i = 0;
        break;
      }
      i = 1;
      break;
      label260:
      paramFormat = paramc.bif.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.am("channelCount.aCaps");
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
          paramc.am("channelCount.support, ".concat(String.valueOf(n)));
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
    if (ak(paramFormat.aSd))
    {
      com.google.android.exoplayer2.e.a locala = paramc.tt();
      if (locala != null)
      {
        this.aVt = true;
        AppMethodBeat.o(91812);
        return locala;
      }
    }
    this.aVt = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(91812);
    return paramc;
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(91819);
    super.a(paramLong, paramBoolean);
    this.aVs.reset();
    this.aVw = paramLong;
    this.aVx = true;
    AppMethodBeat.o(91819);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(91814);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("herolte")) || (x.DEVICE.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aVu = bool;
      if (!this.aVt) {
        break;
      }
      this.aVv = paramFormat.rH();
      this.aVv.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.aVv, null, paramMediaCrypto, 0);
      this.aVv.setString("mime", paramFormat.aSd);
      AppMethodBeat.o(91814);
      return;
    }
    paramMediaCodec.configure(paramFormat.rH(), null, paramMediaCrypto, 0);
    this.aVv = null;
    AppMethodBeat.o(91814);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(91827);
    if ((this.aVt) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(91827);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.biP;
      paramMediaCodec.aWh += 1;
      paramMediaCodec = this.aVs;
      if (paramMediaCodec.aUE == 1) {
        paramMediaCodec.aUE = 2;
      }
      AppMethodBeat.o(91827);
      return true;
    }
    try
    {
      localf = this.aVs;
      if (localf.aUL == null) {
        break label961;
      }
      if (paramByteBuffer != localf.aUL) {
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
        paramLong1 = localf.aUF + localf.G(localf.sc());
        if ((localf.aUE == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.aUE = 2;
        }
        if (localf.aUE == 2)
        {
          localf.aUF = (paramLong3 - paramLong1 + localf.aUF);
          localf.aUE = 1;
          localf.aUa.rL();
          continue;
          localf.aUy += paramByteBuffer.remaining();
          continue;
          localf.E(paramLong3);
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
      localf.aUb.block();
      localf.aUg = localf.sg();
      paramInt2 = localf.aUg.getAudioSessionId();
      if ((f.aTU) && (x.SDK_INT < 21))
      {
        if ((localf.aUf != null) && (paramInt2 != localf.aUf.getAudioSessionId())) {
          localf.sb();
        }
        if (localf.aUf == null) {
          localf.aUf = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.aSY != paramInt2)
      {
        localf.aSY = paramInt2;
        localf.aUa.dI(paramInt2);
      }
      localf.aUd.a(localf.aUg, localf.sf());
      localf.sa();
      localf.aUT = false;
      if (localf.aUR) {
        localf.play();
      }
    }
    if (localf.sf()) {
      if (localf.aUg.getPlayState() == 2)
      {
        localf.aUT = false;
        break label967;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label953;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.biP;
      paramMediaCodec.aWg += 1;
      AppMethodBeat.o(91827);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.aUg.getPlayState() == 1) && (localf.aUd.sh() != 0L)) {
        break label967;
      }
      paramBoolean = localf.aUT;
      localf.aUT = localf.rZ();
      if ((paramBoolean) && (!localf.aUT) && (localf.aUg.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.aUU;
        localf.aUa.d(localf.bufferSize, com.google.android.exoplayer2.b.t(localf.aUk), paramLong1 - paramLong2);
      }
      if (localf.aUL != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.aUj) && (localf.aUD == 0))
    {
      paramInt2 = localf.aUi;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.g(paramByteBuffer);
    }
    for (;;)
    {
      localf.aUD = paramInt2;
      if (localf.aUl != null)
      {
        if (!localf.rY()) {
          break label967;
        }
        localf.aUe.add(new f.g(localf.aUl, Math.max(0L, paramLong3), localf.G(localf.sd()), (byte)0));
        localf.aUl = null;
        localf.rX();
      }
      if (localf.aUE != 0) {
        break label803;
      }
      localf.aUF = Math.max(0L, paramLong3);
      localf.aUE = 1;
      if (!localf.aUj) {
        break label923;
      }
      localf.aUz += localf.aUD;
      localf.aUL = paramByteBuffer;
      label677:
      if (!localf.aUj) {
        break label943;
      }
      localf.a(localf.aUL, paramLong3);
      if (localf.aUL.hasRemaining()) {
        break label967;
      }
      localf.aUL = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.rS();
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
    Object localObject = this.aVr;
    com.google.android.exoplayer2.b.d locald = this.biP;
    if (((e.a)localObject).aTI != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = this.aQr.aSG;
    if (i != 0)
    {
      localObject = this.aVs;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).aUS) || (((f)localObject).aSY != i))
      {
        ((f)localObject).aUS = true;
        ((f)localObject).aSY = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(91818);
      return;
    }
    localObject = this.aVs;
    if (((f)localObject).aUS)
    {
      ((f)localObject).aUS = false;
      ((f)localObject).aSY = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(91818);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(91826);
    paramp = this.aVs.c(paramp);
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
      localf = this.aVs;
      float f = ((Float)paramObject).floatValue();
      if (localf.volume != f)
      {
        localf.volume = f;
        localf.sa();
      }
      AppMethodBeat.o(91829);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.aVs;
    if (!localf.aSZ.equals(paramObject))
    {
      localf.aSZ = paramObject;
      if (!localf.aUS)
      {
        localf.reset();
        localf.aSY = 0;
      }
    }
    AppMethodBeat.o(91829);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91815);
    e.a locala = this.aVr;
    if (locala.aTI != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(91815);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(91816);
    super.e(paramFormat);
    e.a locala = this.aVr;
    if (locala.aTI != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.aSd)) {}
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
    if ((this.aVs.rZ()) || (super.isReady()))
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
    if (this.aVv != null)
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    int m;
    int i1;
    label113:
    for (paramMediaCodec = this.aVv.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.aVv;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.aVu) || (m != 6) || (this.channelCount >= 6)) {
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
      localf = this.aVs;
      j = this.pcmEncoding;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label803;
      }
      bool1 = true;
      if (!bool1) {
        break label809;
      }
      i = f.aj(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label780;
      }
      localf.aUx = x.bq(j, m);
      localf.aTX.aVl = paramMediaFormat;
      paramMediaCodec = localf.aTZ;
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
          j = paramMediaFormat.rU();
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
    localf.rX();
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
          localf.aUj = bool1;
          localf.sampleRate = i1;
          localf.channelConfig = i;
          if (!bool1) {
            break label905;
          }
          localf.aUi = k;
          localf.aUA = x.bq(2, m);
          if (!bool1) {
            break label666;
          }
          if (localf.aUi == 5) {
            break label890;
          }
          if (localf.aUi != 6) {
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
        localf.aUk = l;
        localf.c(localf.aRf);
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
        k = AudioTrack.getMinBufferSize(i1, i, localf.aUi);
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
        j = (int)localf.H(250000L) * localf.aUA;
        k = (int)Math.max(k, localf.H(750000L) * localf.aUA);
        if (i >= j) {
          break label924;
        }
        i = j;
        break label570;
        l = localf.G(localf.bufferSize / localf.aUA);
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
    this.aVs.play();
    AppMethodBeat.o(91820);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(91821);
    f localf = this.aVs;
    localf.aUR = false;
    if (localf.isInitialized())
    {
      localf.se();
      localf.aUd.pause();
    }
    super.onStopped();
    AppMethodBeat.o(91821);
  }
  
  public final boolean rM()
  {
    AppMethodBeat.i(91823);
    if (super.rM())
    {
      f localf = this.aVs;
      if ((!localf.isInitialized()) || ((localf.aUQ) && (!localf.rZ()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91823);
        return true;
      }
    }
    AppMethodBeat.o(91823);
    return false;
  }
  
  public final com.google.android.exoplayer2.i.i ri()
  {
    return this;
  }
  
  /* Error */
  public final void rp()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 738
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/google/android/exoplayer2/a/i:aVs	Lcom/google/android/exoplayer2/a/f;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 225	com/google/android/exoplayer2/a/f:reset	()V
    //   17: aload_3
    //   18: invokevirtual 337	com/google/android/exoplayer2/a/f:sb	()V
    //   21: aload_3
    //   22: getfield 659	com/google/android/exoplayer2/a/f:aTZ	[Lcom/google/android/exoplayer2/a/d;
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
    //   40: invokeinterface 739 1 0
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -18 -> 31
    //   52: aload_3
    //   53: iconst_0
    //   54: putfield 343	com/google/android/exoplayer2/a/f:aSY	I
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 373	com/google/android/exoplayer2/a/f:aUR	Z
    //   62: aload_0
    //   63: invokespecial 741	com/google/android/exoplayer2/e/b:rp	()V
    //   66: aload_0
    //   67: getfield 56	com/google/android/exoplayer2/a/i:aVr	Lcom/google/android/exoplayer2/a/e$a;
    //   70: aload_0
    //   71: getfield 284	com/google/android/exoplayer2/a/i:biP	Lcom/google/android/exoplayer2/b/d;
    //   74: invokevirtual 744	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   77: ldc_w 738
    //   80: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 56	com/google/android/exoplayer2/a/i:aVr	Lcom/google/android/exoplayer2/a/e$a;
    //   89: aload_0
    //   90: getfield 284	com/google/android/exoplayer2/a/i:biP	Lcom/google/android/exoplayer2/b/d;
    //   93: invokevirtual 744	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   96: ldc_w 738
    //   99: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aload_0
    //   106: invokespecial 741	com/google/android/exoplayer2/e/b:rp	()V
    //   109: aload_0
    //   110: getfield 56	com/google/android/exoplayer2/a/i:aVr	Lcom/google/android/exoplayer2/a/e$a;
    //   113: aload_0
    //   114: getfield 284	com/google/android/exoplayer2/a/i:biP	Lcom/google/android/exoplayer2/b/d;
    //   117: invokevirtual 744	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   120: ldc_w 738
    //   123: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 56	com/google/android/exoplayer2/a/i:aVr	Lcom/google/android/exoplayer2/a/e$a;
    //   133: aload_0
    //   134: getfield 284	com/google/android/exoplayer2/a/i:biP	Lcom/google/android/exoplayer2/b/d;
    //   137: invokevirtual 744	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   140: ldc_w 738
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
  
  public final long si()
  {
    AppMethodBeat.i(91825);
    long l = this.aVs.aS(rM());
    if (l != -9223372036854775808L) {
      if (!this.aVx) {
        break label56;
      }
    }
    for (;;)
    {
      this.aVw = l;
      this.aVx = false;
      l = this.aVw;
      AppMethodBeat.o(91825);
      return l;
      label56:
      l = Math.max(this.aVw, l);
    }
  }
  
  public final p sm()
  {
    return this.aVs.aRf;
  }
  
  public final void sn()
  {
    AppMethodBeat.i(91828);
    try
    {
      f localf = this.aVs;
      if ((localf.aUQ) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(91828);
        return;
      }
      if (localf.rY())
      {
        localf.aUd.I(localf.sd());
        localf.aUp = 0;
        localf.aUQ = true;
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
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(91809);
      e.a locala = i.a(i.this);
      if (locala.aTI != null) {
        locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
      }
      AppMethodBeat.o(91809);
    }
    
    public final void dI(int paramInt)
    {
      AppMethodBeat.i(91807);
      e.a locala = i.a(i.this);
      if (locala.aTI != null) {
        locala.handler.post(new e.a.6(locala, paramInt));
      }
      AppMethodBeat.o(91807);
    }
    
    public final void rL()
    {
      AppMethodBeat.i(91808);
      i.b(i.this);
      AppMethodBeat.o(91808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */