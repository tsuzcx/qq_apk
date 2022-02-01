package com.google.android.exoplayer2.a;

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

public final class i
  extends com.google.android.exoplayer2.e.b
  implements com.google.android.exoplayer2.i.i
{
  private final e.a cJS;
  private final f cJT;
  private boolean cJU;
  private boolean cJV;
  private MediaFormat cJW;
  private long cJX;
  private boolean cJY;
  private int channelCount;
  private int pcmEncoding;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(91810);
    this.cJT = new f(paramc1, paramVarArgs, new a((byte)0));
    this.cJS = new e.a(paramHandler, parame);
    AppMethodBeat.o(91810);
  }
  
  private boolean cI(String paramString)
  {
    AppMethodBeat.i(91813);
    boolean bool = this.cJT.cG(paramString);
    AppMethodBeat.o(91813);
    return bool;
  }
  
  public final boolean QU()
  {
    AppMethodBeat.i(91823);
    if (super.QU())
    {
      f localf = this.cJT;
      if ((!localf.isInitialized()) || ((localf.cJr) && (!localf.Rh()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91823);
        return true;
      }
    }
    AppMethodBeat.o(91823);
    return false;
  }
  
  public final com.google.android.exoplayer2.i.i Qn()
  {
    return this;
  }
  
  public final void Qu()
  {
    AppMethodBeat.i(91820);
    super.Qu();
    this.cJT.play();
    AppMethodBeat.o(91820);
  }
  
  public final void Qv()
  {
    AppMethodBeat.i(91821);
    f localf = this.cJT;
    localf.cJs = false;
    if (localf.isInitialized())
    {
      localf.Rm();
      localf.cIH.pause();
    }
    super.Qv();
    AppMethodBeat.o(91821);
  }
  
  /* Error */
  public final void Qw()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 115
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 46	com/google/android/exoplayer2/a/i:cJT	Lcom/google/android/exoplayer2/a/f;
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 118	com/google/android/exoplayer2/a/f:reset	()V
    //   16: aload_3
    //   17: invokevirtual 121	com/google/android/exoplayer2/a/f:Rj	()V
    //   20: aload_3
    //   21: getfield 125	com/google/android/exoplayer2/a/f:cID	[Lcom/google/android/exoplayer2/a/d;
    //   24: astore 4
    //   26: aload 4
    //   28: arraylength
    //   29: istore_2
    //   30: iload_1
    //   31: iload_2
    //   32: if_icmpge +19 -> 51
    //   35: aload 4
    //   37: iload_1
    //   38: aaload
    //   39: invokeinterface 128 1 0
    //   44: iload_1
    //   45: iconst_1
    //   46: iadd
    //   47: istore_1
    //   48: goto -18 -> 30
    //   51: aload_3
    //   52: iconst_0
    //   53: putfield 131	com/google/android/exoplayer2/a/f:cHE	I
    //   56: aload_3
    //   57: iconst_0
    //   58: putfield 99	com/google/android/exoplayer2/a/f:cJs	Z
    //   61: aload_0
    //   62: invokespecial 133	com/google/android/exoplayer2/e/b:Qw	()V
    //   65: aload_0
    //   66: getfield 53	com/google/android/exoplayer2/a/i:cJS	Lcom/google/android/exoplayer2/a/e$a;
    //   69: aload_0
    //   70: getfield 137	com/google/android/exoplayer2/a/i:cXg	Lcom/google/android/exoplayer2/b/d;
    //   73: invokevirtual 141	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   76: ldc 115
    //   78: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 53	com/google/android/exoplayer2/a/i:cJS	Lcom/google/android/exoplayer2/a/e$a;
    //   87: aload_0
    //   88: getfield 137	com/google/android/exoplayer2/a/i:cXg	Lcom/google/android/exoplayer2/b/d;
    //   91: invokevirtual 141	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   94: ldc 115
    //   96: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_3
    //   100: athrow
    //   101: astore_3
    //   102: aload_0
    //   103: invokespecial 133	com/google/android/exoplayer2/e/b:Qw	()V
    //   106: aload_0
    //   107: getfield 53	com/google/android/exoplayer2/a/i:cJS	Lcom/google/android/exoplayer2/a/e$a;
    //   110: aload_0
    //   111: getfield 137	com/google/android/exoplayer2/a/i:cXg	Lcom/google/android/exoplayer2/b/d;
    //   114: invokevirtual 141	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   117: ldc 115
    //   119: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_3
    //   123: athrow
    //   124: astore_3
    //   125: aload_0
    //   126: getfield 53	com/google/android/exoplayer2/a/i:cJS	Lcom/google/android/exoplayer2/a/e$a;
    //   129: aload_0
    //   130: getfield 137	com/google/android/exoplayer2/a/i:cXg	Lcom/google/android/exoplayer2/b/d;
    //   133: invokevirtual 141	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   136: ldc 115
    //   138: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_3
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	i
    //   1	47	1	i	int
    //   29	4	2	j	int
    //   11	46	3	localf	f
    //   82	18	3	localObject1	Object
    //   101	22	3	localObject2	Object
    //   124	18	3	localObject3	Object
    //   24	12	4	arrayOfd	d[]
    // Exception table:
    //   from	to	target	type
    //   61	65	82	finally
    //   7	30	101	finally
    //   35	44	101	finally
    //   51	61	101	finally
    //   102	106	124	finally
  }
  
  public final long Rq()
  {
    AppMethodBeat.i(91825);
    long l = this.cJT.by(QU());
    if (l != -9223372036854775808L) {
      if (!this.cJY) {
        break label54;
      }
    }
    for (;;)
    {
      this.cJX = l;
      this.cJY = false;
      l = this.cJX;
      AppMethodBeat.o(91825);
      return l;
      label54:
      l = Math.max(this.cJX, l);
    }
  }
  
  public final p Ru()
  {
    return this.cJT.cFP;
  }
  
  public final void Rv()
  {
    AppMethodBeat.i(91828);
    try
    {
      f localf = this.cJT;
      if ((localf.cJr) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(91828);
        return;
      }
      if (localf.Rg())
      {
        localf.cIH.cb(localf.Rl());
        localf.cIS = 0;
        localf.cJr = true;
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
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(91811);
    Object localObject = paramFormat.cGN;
    if (!j.df((String)localObject))
    {
      AppMethodBeat.o(91811);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (cI((String)localObject)) && (paramc.SF() != null); j = 0)
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
        if (paramc.cWx != null) {
          break label203;
        }
        paramc.cK("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label183;
        }
      }
      if (paramFormat.channelCount != -1)
      {
        n = paramFormat.channelCount;
        if (paramc.cWx != null) {
          break label260;
        }
        paramc.cK("channelCount.caps");
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
      localObject = paramc.cWx.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.cK("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.cK("sampleRate.support, ".concat(String.valueOf(i)));
        i = 0;
        break;
      }
      i = 1;
      break;
      label260:
      paramFormat = paramc.cWx.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.cK("channelCount.aCaps");
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
          paramc.cK("channelCount.support, ".concat(String.valueOf(n)));
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
    if (cI(paramFormat.cGN))
    {
      com.google.android.exoplayer2.e.a locala = paramc.SF();
      if (locala != null)
      {
        this.cJU = true;
        AppMethodBeat.o(91812);
        return locala;
      }
    }
    this.cJU = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(91812);
    return paramc;
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat)
  {
    AppMethodBeat.i(210315);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.MANUFACTURER)) && ((x.dkS.startsWith("zeroflte")) || (x.dkS.startsWith("herolte")) || (x.dkS.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.cJV = bool;
      if (!this.cJU) {
        break;
      }
      this.cJW = paramFormat.QS();
      this.cJW.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.cJW, null, null, 0);
      this.cJW.setString("mime", paramFormat.cGN);
      AppMethodBeat.o(210315);
      return;
    }
    paramMediaCodec.configure(paramFormat.QS(), null, null, 0);
    this.cJW = null;
    AppMethodBeat.o(210315);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(91827);
    if ((this.cJU) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(91827);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.cXg;
      paramMediaCodec.cKM += 1;
      paramMediaCodec = this.cJT;
      if (paramMediaCodec.cJh == 1) {
        paramMediaCodec.cJh = 2;
      }
      AppMethodBeat.o(91827);
      return true;
    }
    try
    {
      localf = this.cJT;
      if (localf.cJn == null) {
        break label962;
      }
      if (paramByteBuffer != localf.cJn) {
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
        paramLong1 = localf.cJi + localf.bZ(localf.Rk());
        if ((localf.cJh == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.cJh = 2;
        }
        if (localf.cJh == 2)
        {
          localf.cJi = (paramLong3 - paramLong1 + localf.cJi);
          localf.cJh = 1;
          localf.cIE.onPositionDiscontinuity();
          continue;
          localf.cJb += paramByteBuffer.remaining();
          continue;
          localf.bX(paramLong3);
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
      localf.cIF.block();
      localf.cIK = localf.Ro();
      paramInt2 = localf.cIK.getAudioSessionId();
      if ((f.cIy) && (x.SDK_INT < 21))
      {
        if ((localf.cIJ != null) && (paramInt2 != localf.cIJ.getAudioSessionId())) {
          localf.Rj();
        }
        if (localf.cIJ == null) {
          localf.cIJ = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.cHE != paramInt2)
      {
        localf.cHE = paramInt2;
        localf.cIE.hl(paramInt2);
      }
      localf.cIH.a(localf.cIK, localf.Rn());
      localf.Ri();
      localf.cJu = false;
      if (localf.cJs) {
        localf.play();
      }
    }
    if (localf.Rn()) {
      if (localf.cIK.getPlayState() == 2)
      {
        localf.cJu = false;
        break label968;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label954;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.cXg;
      paramMediaCodec.cKL += 1;
      AppMethodBeat.o(91827);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.cIK.getPlayState() == 1) && (localf.cIH.Rp() != 0L)) {
        break label968;
      }
      paramBoolean = localf.cJu;
      localf.cJu = localf.Rh();
      if ((paramBoolean) && (!localf.cJu) && (localf.cIK.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.cJv;
        localf.cIE.e(localf.bufferSize, com.google.android.exoplayer2.b.bM(localf.cIN), paramLong1 - paramLong2);
      }
      if (localf.cJn != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.cIM) && (localf.cJg == 0))
    {
      paramInt2 = localf.cIL;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.e(paramByteBuffer);
    }
    for (;;)
    {
      localf.cJg = paramInt2;
      if (localf.cIO != null)
      {
        if (!localf.Rg()) {
          break label968;
        }
        localf.cII.add(new f.g(localf.cIO, Math.max(0L, paramLong3), localf.bZ(localf.Rl()), (byte)0));
        localf.cIO = null;
        localf.Rf();
      }
      if (localf.cJh != 0) {
        break label803;
      }
      localf.cJi = Math.max(0L, paramLong3);
      localf.cJh = 1;
      if (!localf.cIM) {
        break label924;
      }
      localf.cJc += localf.cJg;
      localf.cJn = paramByteBuffer;
      label677:
      if (!localf.cIM) {
        break label944;
      }
      localf.b(localf.cJn, paramLong3);
      if (localf.cJn.hasRemaining()) {
        break label968;
      }
      localf.cJn = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.QZ();
      }
      else
      {
        if (paramInt2 != 6) {
          break label752;
        }
        paramInt2 = a.c(paramByteBuffer);
      }
    }
    label752:
    paramMediaCodec = new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(91827);
    throw paramMediaCodec;
  }
  
  public final p b(p paramp)
  {
    AppMethodBeat.i(91826);
    paramp = this.cJT.b(paramp);
    AppMethodBeat.o(91826);
    return paramp;
  }
  
  public final void bu(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(91818);
    super.bu(paramBoolean);
    Object localObject = this.cJS;
    com.google.android.exoplayer2.b.d locald = this.cXg;
    if (((e.a)localObject).cIm != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = Qx().cHn;
    if (i != 0)
    {
      localObject = this.cJT;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).cJt) || (((f)localObject).cHE != i))
      {
        ((f)localObject).cJt = true;
        ((f)localObject).cHE = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(91818);
      return;
    }
    localObject = this.cJT;
    if (((f)localObject).cJt)
    {
      ((f)localObject).cJt = false;
      ((f)localObject).cHE = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(91818);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91815);
    e.a locala = this.cJS;
    if (locala.cIm != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(91815);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(91816);
    super.e(paramFormat);
    e.a locala = this.cJS;
    if (locala.cIm != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.cGN)) {}
    for (int i = paramFormat.pcmEncoding;; i = 2)
    {
      this.pcmEncoding = i;
      this.channelCount = paramFormat.channelCount;
      AppMethodBeat.o(91816);
      return;
    }
  }
  
  public final void f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(91819);
    super.f(paramLong, paramBoolean);
    this.cJT.reset();
    this.cJX = paramLong;
    this.cJY = true;
    AppMethodBeat.o(91819);
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(91824);
    if ((this.cJT.Rh()) || (super.isReady()))
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
    if (this.cJW != null)
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
    }
    int m;
    int i1;
    label113:
    for (paramMediaCodec = this.cJW.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.cJW;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.cJV) || (m != 6) || (this.channelCount >= 6)) {
        break label806;
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
    label145:
    label155:
    int k;
    int n;
    try
    {
      localf = this.cJT;
      j = this.pcmEncoding;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label811;
      }
      bool1 = true;
      if (!bool1) {
        break label817;
      }
      i = f.cH(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label788;
      }
      localf.cJa = x.cm(j, m);
      localf.cIB.cJM = paramMediaFormat;
      paramMediaCodec = localf.cID;
      int i2 = paramMediaCodec.length;
      n = 0;
      j = m;
      m = n;
      label205:
      if (m < i2)
      {
        paramMediaFormat = paramMediaCodec[m];
        try
        {
          int i3 = paramMediaFormat.C(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label797;
          }
          j = paramMediaFormat.Rb();
          i = paramMediaFormat.Rc();
        }
        catch (d.a paramMediaCodec)
        {
          paramMediaCodec = new f.c(paramMediaCodec);
          AppMethodBeat.o(91817);
          throw paramMediaCodec;
        }
      }
      if (k == 0) {
        break label823;
      }
    }
    catch (f.c paramMediaCodec)
    {
      paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, getIndex());
      AppMethodBeat.o(91817);
      throw paramMediaCodec;
    }
    localf.Rf();
    break label823;
    paramMediaCodec = new f.c("Unsupported channel count: ".concat(String.valueOf(m)));
    AppMethodBeat.o(91817);
    throw paramMediaCodec;
    label340:
    int j = i;
    if (x.SDK_INT <= 23)
    {
      j = i;
      if ("foster".equals(x.dkS))
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
      label420:
      if ((x.SDK_INT <= 25) && ("fugu".equals(x.dkS)) && (bool1) && (m == 1))
      {
        i = 12;
        label454:
        if ((n != 0) || (!localf.isInitialized()) || (localf.encoding != k) || (localf.sampleRate != i1) || (localf.channelConfig != i))
        {
          localf.reset();
          localf.encoding = k;
          localf.cIM = bool1;
          localf.sampleRate = i1;
          localf.channelConfig = i;
          if (!bool1) {
            break label913;
          }
          localf.cIL = k;
          localf.cJd = x.cm(2, m);
          if (!bool1) {
            break label674;
          }
          if (localf.cIL == 5) {
            break label898;
          }
          if (localf.cIL != 6) {
            break label919;
          }
        }
      }
      label533:
      break;
    }
    for (;;)
    {
      label578:
      localf.bufferSize = i;
      long l;
      if (bool1)
      {
        l = -9223372036854775807L;
        label594:
        localf.cIN = l;
        localf.b(localf.cFP);
        AppMethodBeat.o(91817);
        return;
        i = 12;
        break label340;
        i = 28;
        break label340;
        i = 204;
        break label340;
        i = 220;
        break label340;
        i = 252;
        break label340;
        i = 1276;
        break label340;
        i = com.google.android.exoplayer2.b.cFe;
        break label340;
        j = com.google.android.exoplayer2.b.cFe;
        break label420;
        label674:
        k = AudioTrack.getMinBufferSize(i1, i, localf.cIL);
        if (k == -2) {
          break label926;
        }
      }
      label788:
      label797:
      label926:
      for (boolean bool2 = true;; bool2 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool2);
        i = k * 4;
        j = (int)localf.ca(250000L) * localf.cJd;
        k = (int)Math.max(k, localf.ca(750000L) * localf.cJd);
        if (i >= j) {
          break label932;
        }
        i = j;
        break label578;
        l = localf.bZ(localf.bufferSize / localf.cJd);
        break label594;
        i = j;
        break label454;
        n = 0;
        k = i;
        break label834;
        m += 1;
        break label205;
        label806:
        paramMediaFormat = null;
        break;
        label811:
        bool1 = false;
        break label145;
        label817:
        i = j;
        break label155;
        label823:
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
          label834:
          i = 4;
          break label340;
          j = i;
          break label420;
          i = 20480;
          break label578;
          j = 252;
          break label420;
          k = 2;
          break label533;
          i = 49152;
          break label578;
        }
      }
      label898:
      label913:
      label919:
      label932:
      if (i > k) {
        i = k;
      }
    }
  }
  
  public final void u(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(91829);
    switch (paramInt)
    {
    default: 
      super.u(paramInt, paramObject);
      AppMethodBeat.o(91829);
      return;
    case 2: 
      localf = this.cJT;
      float f = ((Float)paramObject).floatValue();
      if (localf.volume != f)
      {
        localf.volume = f;
        localf.Ri();
      }
      AppMethodBeat.o(91829);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.cJT;
    if (!localf.cHF.equals(paramObject))
    {
      localf.cHF = paramObject;
      if (!localf.cJt)
      {
        localf.reset();
        localf.cHE = 0;
      }
    }
    AppMethodBeat.o(91829);
  }
  
  final class a
    implements f.f
  {
    private a() {}
    
    public final void e(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(91809);
      e.a locala = i.a(i.this);
      if (locala.cIm != null) {
        locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
      }
      AppMethodBeat.o(91809);
    }
    
    public final void hl(int paramInt)
    {
      AppMethodBeat.i(91807);
      e.a locala = i.a(i.this);
      if (locala.cIm != null) {
        locala.handler.post(new e.a.6(locala, paramInt));
      }
      AppMethodBeat.o(91807);
    }
    
    public final void onPositionDiscontinuity()
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