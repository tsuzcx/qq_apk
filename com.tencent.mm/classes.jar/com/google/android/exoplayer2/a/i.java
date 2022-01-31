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
  private boolean aAa;
  private boolean aAb;
  private MediaFormat aAc;
  private long aAd;
  private boolean aAe;
  private int awU;
  private int awV;
  private final e.a azY;
  private final f azZ;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    AppMethodBeat.i(94699);
    this.azZ = new f(paramc1, paramVarArgs, new i.a(this, (byte)0));
    this.azY = new e.a(paramHandler, parame);
    AppMethodBeat.o(94699);
  }
  
  private boolean ao(String paramString)
  {
    AppMethodBeat.i(94702);
    boolean bool = this.azZ.am(paramString);
    AppMethodBeat.o(94702);
    return bool;
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    AppMethodBeat.i(94700);
    Object localObject = paramFormat.awK;
    if (!j.aG((String)localObject))
    {
      AppMethodBeat.o(94700);
      return 0;
    }
    if (x.SDK_INT >= 21) {}
    for (int j = 32; (ao((String)localObject)) && (paramc.oH() != null); j = 0)
    {
      AppMethodBeat.o(94700);
      return j | 0x8 | 0x4;
    }
    paramc = paramc.f((String)localObject, false);
    if (paramc == null)
    {
      AppMethodBeat.o(94700);
      return 1;
    }
    int n;
    if (x.SDK_INT >= 21)
    {
      if (paramFormat.sampleRate != -1)
      {
        i = paramFormat.sampleRate;
        if (paramc.aMG != null) {
          break label203;
        }
        paramc.aq("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label183;
        }
      }
      if (paramFormat.awU != -1)
      {
        n = paramFormat.awU;
        if (paramc.aMG != null) {
          break label260;
        }
        paramc.aq("channelCount.caps");
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
      AppMethodBeat.o(94700);
      return i | j | 0x8;
      label203:
      localObject = paramc.aMG.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.aq("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.aq("sampleRate.support, ".concat(String.valueOf(i)));
        i = 0;
        break;
      }
      i = 1;
      break;
      label260:
      paramFormat = paramc.aMG.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.aq("channelCount.aCaps");
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
          paramc.aq("channelCount.support, ".concat(String.valueOf(n)));
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
    AppMethodBeat.i(94701);
    if (ao(paramFormat.awK))
    {
      com.google.android.exoplayer2.e.a locala = paramc.oH();
      if (locala != null)
      {
        this.aAa = true;
        AppMethodBeat.o(94701);
        return locala;
      }
    }
    this.aAa = false;
    paramc = super.a(paramc, paramFormat, paramBoolean);
    AppMethodBeat.o(94701);
    return paramc;
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(94703);
    parama = parama.name;
    if ((x.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(x.MANUFACTURER)) && ((x.DEVICE.startsWith("zeroflte")) || (x.DEVICE.startsWith("herolte")) || (x.DEVICE.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aAb = bool;
      if (!this.aAa) {
        break;
      }
      this.aAc = paramFormat.mY();
      this.aAc.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.aAc, null, paramMediaCrypto, 0);
      this.aAc.setString("mime", paramFormat.awK);
      AppMethodBeat.o(94703);
      return;
    }
    paramMediaCodec.configure(paramFormat.mY(), null, paramMediaCrypto, 0);
    this.aAc = null;
    AppMethodBeat.o(94703);
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(94716);
    if ((this.aAa) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      AppMethodBeat.o(94716);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.aNp;
      paramMediaCodec.aAO += 1;
      paramMediaCodec = this.azZ;
      if (paramMediaCodec.azl == 1) {
        paramMediaCodec.azl = 2;
      }
      AppMethodBeat.o(94716);
      return true;
    }
    try
    {
      localf = this.azZ;
      if (localf.azs == null) {
        break label961;
      }
      if (paramByteBuffer != localf.azs) {
        break label373;
      }
    }
    catch (f.d paramMediaCodec)
    {
      for (;;)
      {
        f localf;
        paramMediaCodec = com.google.android.exoplayer2.e.b(paramMediaCodec, this.index);
        AppMethodBeat.o(94716);
        throw paramMediaCodec;
        paramLong1 = localf.azm + localf.B(localf.nq());
        if ((localf.azl == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.azl = 2;
        }
        if (localf.azl == 2)
        {
          localf.azm = (paramLong3 - paramLong1 + localf.azm);
          localf.azl = 1;
          localf.ayH.nc();
          continue;
          localf.azf += paramByteBuffer.remaining();
          continue;
          localf.z(paramLong3);
          continue;
          AppMethodBeat.o(94716);
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
      localf.ayI.block();
      localf.ayN = localf.nu();
      paramInt2 = localf.ayN.getAudioSessionId();
      if ((f.ayB) && (x.SDK_INT < 21))
      {
        if ((localf.ayM != null) && (paramInt2 != localf.ayM.getAudioSessionId())) {
          localf.np();
        }
        if (localf.ayM == null) {
          localf.ayM = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.axF != paramInt2)
      {
        localf.axF = paramInt2;
        localf.ayH.cX(paramInt2);
      }
      localf.ayK.a(localf.ayN, localf.nt());
      localf.no();
      localf.azA = false;
      if (localf.azy) {
        localf.play();
      }
    }
    if (localf.nt()) {
      if (localf.ayN.getPlayState() == 2)
      {
        localf.azA = false;
        break label967;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label953;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.aNp;
      paramMediaCodec.aAN += 1;
      AppMethodBeat.o(94716);
      return true;
      label373:
      paramBoolean = false;
      break;
      if ((localf.ayN.getPlayState() == 1) && (localf.ayK.nv() != 0L)) {
        break label967;
      }
      paramBoolean = localf.azA;
      localf.azA = localf.nn();
      if ((paramBoolean) && (!localf.azA) && (localf.ayN.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.azB;
        localf.ayH.d(localf.bufferSize, com.google.android.exoplayer2.b.o(localf.ayR), paramLong1 - paramLong2);
      }
      if (localf.azs != null) {
        break label677;
      }
      if (paramByteBuffer.hasRemaining()) {
        break label504;
      }
      paramInt2 = 1;
    }
    label504:
    if ((localf.ayQ) && (localf.azk == 0))
    {
      paramInt2 = localf.ayP;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label721;
      }
      paramInt2 = h.d(paramByteBuffer);
    }
    for (;;)
    {
      localf.azk = paramInt2;
      if (localf.ayS != null)
      {
        if (!localf.nm()) {
          break label967;
        }
        localf.ayL.add(new f.g(localf.ayS, Math.max(0L, paramLong3), localf.B(localf.nr()), (byte)0));
        localf.ayS = null;
        localf.nl();
      }
      if (localf.azl != 0) {
        break label803;
      }
      localf.azm = Math.max(0L, paramLong3);
      localf.azl = 1;
      if (!localf.ayQ) {
        break label923;
      }
      localf.azg += localf.azk;
      localf.azs = paramByteBuffer;
      label677:
      if (!localf.ayQ) {
        break label943;
      }
      localf.a(localf.azs, paramLong3);
      if (localf.azs.hasRemaining()) {
        break label967;
      }
      localf.azs = null;
      paramInt2 = 1;
      break;
      label721:
      if (paramInt2 == 5)
      {
        paramInt2 = a.nh();
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
    AppMethodBeat.o(94716);
    throw paramMediaCodec;
  }
  
  public final void aB(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(94707);
    super.aB(paramBoolean);
    Object localObject = this.azY;
    com.google.android.exoplayer2.b.d locald = this.aNp;
    if (((e.a)localObject).ayp != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = this.auY.axn;
    if (i != 0)
    {
      localObject = this.azZ;
      paramBoolean = bool;
      if (x.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.checkState(paramBoolean);
      if ((!((f)localObject).azz) || (((f)localObject).axF != i))
      {
        ((f)localObject).azz = true;
        ((f)localObject).axF = i;
        ((f)localObject).reset();
      }
      AppMethodBeat.o(94707);
      return;
    }
    localObject = this.azZ;
    if (((f)localObject).azz)
    {
      ((f)localObject).azz = false;
      ((f)localObject).axF = 0;
      ((f)localObject).reset();
    }
    AppMethodBeat.o(94707);
  }
  
  public final void b(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94708);
    super.b(paramLong, paramBoolean);
    this.azZ.reset();
    this.aAd = paramLong;
    this.aAe = true;
    AppMethodBeat.o(94708);
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(94715);
    paramp = this.azZ.c(paramp);
    AppMethodBeat.o(94715);
    return paramp;
  }
  
  public final void d(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(94718);
    switch (paramInt)
    {
    default: 
      super.d(paramInt, paramObject);
      AppMethodBeat.o(94718);
      return;
    case 2: 
      localf = this.azZ;
      float f = ((Float)paramObject).floatValue();
      if (localf.azp != f)
      {
        localf.azp = f;
        localf.no();
      }
      AppMethodBeat.o(94718);
      return;
    }
    paramObject = (b)paramObject;
    f localf = this.azZ;
    if (!localf.axG.equals(paramObject))
    {
      localf.axG = paramObject;
      if (!localf.azz)
      {
        localf.reset();
        localf.axF = 0;
      }
    }
    AppMethodBeat.o(94718);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94704);
    e.a locala = this.azY;
    if (locala.ayp != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(94704);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(94705);
    super.e(paramFormat);
    e.a locala = this.azY;
    if (locala.ayp != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.awK)) {}
    for (int i = paramFormat.awV;; i = 2)
    {
      this.awV = i;
      this.awU = paramFormat.awU;
      AppMethodBeat.o(94705);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(94713);
    if ((this.azZ.nn()) || (super.isReady()))
    {
      AppMethodBeat.o(94713);
      return true;
    }
    AppMethodBeat.o(94713);
    return false;
  }
  
  /* Error */
  public final void mF()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 617
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/google/android/exoplayer2/a/i:azZ	Lcom/google/android/exoplayer2/a/f;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 558	com/google/android/exoplayer2/a/f:reset	()V
    //   17: aload_3
    //   18: invokevirtual 328	com/google/android/exoplayer2/a/f:np	()V
    //   21: aload_3
    //   22: getfield 621	com/google/android/exoplayer2/a/f:ayG	[Lcom/google/android/exoplayer2/a/d;
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
    //   40: invokeinterface 624 1 0
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -18 -> 31
    //   52: aload_3
    //   53: iconst_0
    //   54: putfield 334	com/google/android/exoplayer2/a/f:axF	I
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 364	com/google/android/exoplayer2/a/f:azy	Z
    //   62: aload_0
    //   63: invokespecial 626	com/google/android/exoplayer2/e/b:mF	()V
    //   66: aload_0
    //   67: getfield 55	com/google/android/exoplayer2/a/i:azY	Lcom/google/android/exoplayer2/a/e$a;
    //   70: aload_0
    //   71: getfield 274	com/google/android/exoplayer2/a/i:aNp	Lcom/google/android/exoplayer2/b/d;
    //   74: invokevirtual 629	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   77: ldc_w 617
    //   80: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 55	com/google/android/exoplayer2/a/i:azY	Lcom/google/android/exoplayer2/a/e$a;
    //   89: aload_0
    //   90: getfield 274	com/google/android/exoplayer2/a/i:aNp	Lcom/google/android/exoplayer2/b/d;
    //   93: invokevirtual 629	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   96: ldc_w 617
    //   99: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aload_0
    //   106: invokespecial 626	com/google/android/exoplayer2/e/b:mF	()V
    //   109: aload_0
    //   110: getfield 55	com/google/android/exoplayer2/a/i:azY	Lcom/google/android/exoplayer2/a/e$a;
    //   113: aload_0
    //   114: getfield 274	com/google/android/exoplayer2/a/i:aNp	Lcom/google/android/exoplayer2/b/d;
    //   117: invokevirtual 629	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   120: ldc_w 617
    //   123: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: getfield 55	com/google/android/exoplayer2/a/i:azY	Lcom/google/android/exoplayer2/a/e$a;
    //   133: aload_0
    //   134: getfield 274	com/google/android/exoplayer2/a/i:aNp	Lcom/google/android/exoplayer2/b/d;
    //   137: invokevirtual 629	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   140: ldc_w 617
    //   143: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final com.google.android.exoplayer2.i.i my()
  {
    return this;
  }
  
  public final p nA()
  {
    return this.azZ.avN;
  }
  
  public final void nB()
  {
    AppMethodBeat.i(94717);
    try
    {
      f localf = this.azZ;
      if ((localf.azx) || (!localf.isInitialized()))
      {
        AppMethodBeat.o(94717);
        return;
      }
      if (localf.nm())
      {
        localf.ayK.D(localf.nr());
        localf.ayW = 0;
        localf.azx = true;
      }
      AppMethodBeat.o(94717);
      return;
    }
    catch (f.h localh)
    {
      com.google.android.exoplayer2.e locale = com.google.android.exoplayer2.e.b(localh, this.index);
      AppMethodBeat.o(94717);
      throw locale;
    }
  }
  
  public final boolean nd()
  {
    AppMethodBeat.i(94712);
    if (super.nd())
    {
      f localf = this.azZ;
      if ((!localf.isInitialized()) || ((localf.azx) && (!localf.nn()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(94712);
        return true;
      }
    }
    AppMethodBeat.o(94712);
    return false;
  }
  
  public final long nw()
  {
    AppMethodBeat.i(94714);
    long l = this.azZ.aG(nd());
    if (l != -9223372036854775808L) {
      if (!this.aAe) {
        break label56;
      }
    }
    for (;;)
    {
      this.aAd = l;
      this.aAe = false;
      l = this.aAd;
      AppMethodBeat.o(94714);
      return l;
      label56:
      l = Math.max(this.aAd, l);
    }
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(94706);
    int i;
    if (this.aAc != null)
    {
      i = 1;
      if (i == 0) {
        break label112;
      }
    }
    int m;
    int i1;
    label112:
    for (paramMediaCodec = this.aAc.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.aAc;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.aAb) || (m != 6) || (this.awU >= 6)) {
        break label798;
      }
      paramMediaFormat = new int[this.awU];
      i = 0;
      while (i < this.awU)
      {
        paramMediaFormat[i] = i;
        i += 1;
      }
      i = 0;
      break;
    }
    f localf;
    boolean bool1;
    label142:
    label152:
    int k;
    int n;
    try
    {
      localf = this.azZ;
      j = this.awV;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label803;
      }
      bool1 = true;
      if (!bool1) {
        break label809;
      }
      i = f.an(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label780;
      }
      localf.aze = x.bc(j, m);
      localf.ayE.azS = paramMediaFormat;
      paramMediaCodec = localf.ayG;
      int i2 = paramMediaCodec.length;
      n = 0;
      j = m;
      m = n;
      label202:
      if (m < i2)
      {
        paramMediaFormat = paramMediaCodec[m];
        try
        {
          int i3 = paramMediaFormat.q(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label789;
          }
          j = paramMediaFormat.ni();
          i = 2;
        }
        catch (d.a paramMediaCodec)
        {
          paramMediaCodec = new f.c(paramMediaCodec);
          AppMethodBeat.o(94706);
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
      AppMethodBeat.o(94706);
      throw paramMediaCodec;
    }
    localf.nl();
    break label815;
    paramMediaCodec = new f.c("Unsupported channel count: ".concat(String.valueOf(m)));
    AppMethodBeat.o(94706);
    throw paramMediaCodec;
    label332:
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
        if ((n != 0) || (!localf.isInitialized()) || (localf.encoding != k) || (localf.sampleRate != i1) || (localf.ayO != i))
        {
          localf.reset();
          localf.encoding = k;
          localf.ayQ = bool1;
          localf.sampleRate = i1;
          localf.ayO = i;
          if (!bool1) {
            break label905;
          }
          localf.ayP = k;
          localf.azh = x.bc(2, m);
          if (!bool1) {
            break label666;
          }
          if (localf.ayP == 5) {
            break label890;
          }
          if (localf.ayP != 6) {
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
        localf.ayR = l;
        localf.c(localf.avN);
        AppMethodBeat.o(94706);
        return;
        i = 12;
        break label332;
        i = 28;
        break label332;
        i = 204;
        break label332;
        i = 220;
        break label332;
        i = 252;
        break label332;
        i = 1276;
        break label332;
        i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label332;
        j = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label412;
        label666:
        k = AudioTrack.getMinBufferSize(i1, i, localf.ayP);
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
        j = (int)localf.C(250000L) * localf.azh;
        k = (int)Math.max(k, localf.C(750000L) * localf.azh);
        if (i >= j) {
          break label924;
        }
        i = j;
        break label570;
        l = localf.B(localf.bufferSize / localf.azh);
        break label586;
        i = j;
        break label446;
        n = 0;
        k = i;
        break label826;
        m += 1;
        break label202;
        label798:
        paramMediaFormat = null;
        break;
        label803:
        bool1 = false;
        break label142;
        label809:
        i = j;
        break label152;
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
          break label332;
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
    AppMethodBeat.i(94709);
    super.onStarted();
    this.azZ.play();
    AppMethodBeat.o(94709);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(94710);
    f localf = this.azZ;
    localf.azy = false;
    if (localf.isInitialized())
    {
      localf.ns();
      localf.ayK.pause();
    }
    super.onStopped();
    AppMethodBeat.o(94710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */