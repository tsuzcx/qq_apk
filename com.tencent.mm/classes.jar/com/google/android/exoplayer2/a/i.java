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
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.p;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;

@TargetApi(16)
public final class i
  extends com.google.android.exoplayer2.e.b
  implements com.google.android.exoplayer2.i.f
{
  private int auC;
  private int auD;
  private final e.a axJ;
  private final f axK = new f(paramc1, paramVarArgs, new i.a(this, (byte)0));
  private boolean axL;
  private boolean axM;
  private MediaFormat axN;
  private long axO;
  private boolean axP;
  
  public i(com.google.android.exoplayer2.e.c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, c paramc1, d... paramVarArgs)
  {
    super(1, paramc, paramb, true);
    this.axJ = new e.a(paramHandler, parame);
  }
  
  private boolean aj(String paramString)
  {
    Object localObject = this.axK;
    if (((f)localObject).awn != null)
    {
      localObject = ((f)localObject).awn;
      int i = f.ai(paramString);
      if (Arrays.binarySearch(((c)localObject).avW, i) >= 0) {}
      for (i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  protected static void ls() {}
  
  protected static void lt() {}
  
  protected static void lu() {}
  
  protected final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int m = 0;
    Object localObject = paramFormat.aus;
    if (!g.av((String)localObject)) {
      return 0;
    }
    if (com.google.android.exoplayer2.i.t.SDK_INT >= 21) {}
    for (int j = 32; (aj((String)localObject)) && (paramc.mq() != null); j = 0) {
      return j | 0x8 | 0x4;
    }
    paramc = paramc.d((String)localObject, false);
    if (paramc == null) {
      return 1;
    }
    int n;
    if (com.google.android.exoplayer2.i.t.SDK_INT >= 21)
    {
      if (paramFormat.sampleRate != -1)
      {
        i = paramFormat.sampleRate;
        if (paramc.aFL != null) {
          break label178;
        }
        paramc.al("sampleRate.caps");
        i = 0;
        k = m;
        if (i == 0) {
          break label163;
        }
      }
      if (paramFormat.auC != -1)
      {
        n = paramFormat.auC;
        if (paramc.aFL != null) {
          break label242;
        }
        paramc.al("channelCount.caps");
        i = 0;
        label152:
        k = m;
        if (i == 0) {
          break label163;
        }
      }
    }
    int k = 1;
    label163:
    if (k != 0) {}
    for (int i = 4;; i = 3)
    {
      return i | j | 0x8;
      label178:
      localObject = paramc.aFL.getAudioCapabilities();
      if (localObject == null)
      {
        paramc.al("sampleRate.aCaps");
        i = 0;
        break;
      }
      if (!((MediaCodecInfo.AudioCapabilities)localObject).isSampleRateSupported(i))
      {
        paramc.al("sampleRate.support, " + i);
        i = 0;
        break;
      }
      i = 1;
      break;
      label242:
      paramFormat = paramc.aFL.getAudioCapabilities();
      if (paramFormat == null)
      {
        paramc.al("channelCount.aCaps");
        i = 0;
        break label152;
      }
      localObject = paramc.name;
      String str = paramc.mimeType;
      k = paramFormat.getMaxInputChannelCount();
      if ((k > 1) || ((com.google.android.exoplayer2.i.t.SDK_INT >= 26) && (k > 0))) {
        i = k;
      }
      for (;;)
      {
        if (i < n)
        {
          paramc.al("channelCount.support, " + n);
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
      break label152;
    }
  }
  
  protected final com.google.android.exoplayer2.e.a a(com.google.android.exoplayer2.e.c paramc, Format paramFormat, boolean paramBoolean)
  {
    if (aj(paramFormat.aus))
    {
      com.google.android.exoplayer2.e.a locala = paramc.mq();
      if (locala != null)
      {
        this.axL = true;
        return locala;
      }
    }
    this.axL = false;
    return super.a(paramc, paramFormat, paramBoolean);
  }
  
  protected final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    parama = parama.name;
    if ((com.google.android.exoplayer2.i.t.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(parama)) && ("samsung".equals(com.google.android.exoplayer2.i.t.MANUFACTURER)) && ((com.google.android.exoplayer2.i.t.DEVICE.startsWith("zeroflte")) || (com.google.android.exoplayer2.i.t.DEVICE.startsWith("herolte")) || (com.google.android.exoplayer2.i.t.DEVICE.startsWith("heroqlte")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.axM = bool;
      if (!this.axL) {
        break;
      }
      this.axN = paramFormat.kR();
      this.axN.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.axN, null, paramMediaCrypto, 0);
      this.axN.setString("mime", paramFormat.aus);
      return;
    }
    paramMediaCodec.configure(paramFormat.kR(), null, paramMediaCrypto, 0);
    this.axN = null;
  }
  
  protected final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    if ((this.axL) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.aGu;
      paramMediaCodec.ayz += 1;
      paramMediaCodec = this.axK;
      if (paramMediaCodec.awV == 1) {
        paramMediaCodec.awV = 2;
      }
      return true;
    }
    try
    {
      localf = this.axK;
      if (localf.axc == null) {
        break label912;
      }
      if (paramByteBuffer != localf.axc) {
        break label924;
      }
    }
    catch (f.d paramMediaCodec)
    {
      for (;;)
      {
        f localf;
        throw com.google.android.exoplayer2.e.a(paramMediaCodec, this.index);
        paramLong1 = localf.awW + localf.C(localf.li());
        if ((localf.awV == 1) && (Math.abs(paramLong1 - paramLong3) > 200000L))
        {
          new StringBuilder("Discontinuity detected [expected ").append(paramLong1).append(", got ").append(paramLong3).append("]");
          localf.awV = 2;
        }
        if (localf.awV == 2)
        {
          localf.awW = (paramLong3 - paramLong1 + localf.awW);
          localf.awV = 1;
          localf.awr.kT();
          continue;
          localf.awP += paramByteBuffer.remaining();
          continue;
          localf.A(paramLong3);
          continue;
          return false;
          paramBoolean = true;
          continue;
          paramInt2 = 0;
          continue;
          paramBoolean = false;
        }
      }
    }
    catch (f.h paramMediaCodec)
    {
      break label750;
    }
    com.google.android.exoplayer2.i.a.aB(paramBoolean);
    if (!localf.isInitialized())
    {
      localf.aws.block();
      localf.awx = localf.lm();
      paramInt2 = localf.awx.getAudioSessionId();
      if ((f.awl) && (com.google.android.exoplayer2.i.t.SDK_INT < 21))
      {
        if ((localf.aww != null) && (paramInt2 != localf.aww.getAudioSessionId())) {
          localf.lh();
        }
        if (localf.aww == null) {
          localf.aww = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt2);
        }
      }
      if (localf.avp != paramInt2)
      {
        localf.avp = paramInt2;
        localf.awr.cC(paramInt2);
      }
      localf.awu.a(localf.awx, localf.ll());
      localf.lg();
      localf.axk = false;
      if (localf.axi) {
        localf.play();
      }
    }
    if (localf.ll()) {
      if (localf.awx.getPlayState() == 2)
      {
        localf.axk = false;
        break label918;
      }
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        break label910;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.aGu;
      paramMediaCodec.ayy += 1;
      return true;
      if ((localf.awx.getPlayState() == 1) && (localf.awu.ln() != 0L)) {
        break label918;
      }
      paramBoolean = localf.axk;
      localf.axk = localf.lf();
      if ((paramBoolean) && (!localf.axk) && (localf.awx.getPlayState() != 1))
      {
        paramLong1 = SystemClock.elapsedRealtime();
        paramLong2 = localf.axl;
        localf.awr.d(localf.bufferSize, com.google.android.exoplayer2.b.q(localf.awB), paramLong1 - paramLong2);
      }
      if (localf.axc != null) {
        break label647;
      }
      if (paramByteBuffer.hasRemaining()) {
        break;
      }
      paramInt2 = 1;
    }
    if ((localf.awA) && (localf.awU == 0))
    {
      paramInt2 = localf.awz;
      if ((paramInt2 != 7) && (paramInt2 != 8)) {
        break label691;
      }
      paramInt2 = h.d(paramByteBuffer);
    }
    for (;;)
    {
      localf.awU = paramInt2;
      if (localf.awC != null)
      {
        if (!localf.le()) {
          break label918;
        }
        localf.awv.add(new f.g(localf.awC, Math.max(0L, paramLong3), localf.C(localf.lj()), (byte)0));
        localf.awC = null;
        localf.ld();
      }
      if (localf.awV != 0) {
        break label760;
      }
      localf.awW = Math.max(0L, paramLong3);
      localf.awV = 1;
      if (!localf.awA) {
        break label880;
      }
      localf.awQ += localf.awU;
      localf.axc = paramByteBuffer;
      label647:
      if (!localf.awA) {
        break label900;
      }
      localf.a(localf.axc, paramLong3);
      if (localf.axc.hasRemaining()) {
        break label918;
      }
      localf.axc = null;
      paramInt2 = 1;
      break;
      label691:
      if (paramInt2 == 5)
      {
        paramInt2 = a.kY();
      }
      else
      {
        if (paramInt2 != 6) {
          break label722;
        }
        paramInt2 = a.b(paramByteBuffer);
      }
    }
    label722:
    throw new IllegalStateException("Unexpected audio encoding: " + paramInt2);
  }
  
  protected final void as(boolean paramBoolean)
  {
    boolean bool = false;
    super.as(paramBoolean);
    Object localObject = this.axJ;
    com.google.android.exoplayer2.b.d locald = this.aGu;
    if (((e.a)localObject).avZ != null) {
      ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
    }
    int i = this.asH.auW;
    if (i != 0)
    {
      localObject = this.axK;
      paramBoolean = bool;
      if (com.google.android.exoplayer2.i.t.SDK_INT >= 21) {
        paramBoolean = true;
      }
      com.google.android.exoplayer2.i.a.aC(paramBoolean);
      if ((!((f)localObject).axj) || (((f)localObject).avp != i))
      {
        ((f)localObject).axj = true;
        ((f)localObject).avp = i;
        ((f)localObject).reset();
      }
    }
    do
    {
      return;
      localObject = this.axK;
    } while (!((f)localObject).axj);
    ((f)localObject).axj = false;
    ((f)localObject).avp = 0;
    ((f)localObject).reset();
  }
  
  public final p b(p paramp)
  {
    return this.axK.b(paramp);
  }
  
  protected final void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    this.axK.reset();
    this.axO = paramLong;
    this.axP = true;
  }
  
  protected final void c(String paramString, long paramLong1, long paramLong2)
  {
    e.a locala = this.axJ;
    if (locala.avZ != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
  }
  
  public final void d(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      super.d(paramInt, paramObject);
    }
    f localf;
    do
    {
      do
      {
        float f;
        do
        {
          return;
          localf = this.axK;
          f = ((Float)paramObject).floatValue();
        } while (localf.awZ == f);
        localf.awZ = f;
        localf.lg();
        return;
        paramObject = (b)paramObject;
        localf = this.axK;
      } while (localf.avq.equals(paramObject));
      localf.avq = paramObject;
    } while (localf.axj);
    localf.reset();
    localf.avp = 0;
  }
  
  protected final void e(Format paramFormat)
  {
    super.e(paramFormat);
    e.a locala = this.axJ;
    if (locala.avZ != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if ("audio/raw".equals(paramFormat.aus)) {}
    for (int i = paramFormat.auD;; i = 2)
    {
      this.auD = i;
      this.auC = paramFormat.auC;
      return;
    }
  }
  
  public final boolean isReady()
  {
    return (this.axK.lf()) || (super.isReady());
  }
  
  public final boolean kU()
  {
    if (super.kU())
    {
      f localf = this.axK;
      if ((!localf.isInitialized()) || ((localf.axh) && (!localf.lf()))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final com.google.android.exoplayer2.i.f ks()
  {
    return this;
  }
  
  /* Error */
  protected final void kz()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 41	com/google/android/exoplayer2/a/i:axK	Lcom/google/android/exoplayer2/a/f;
    //   6: astore_3
    //   7: aload_3
    //   8: invokevirtual 559	com/google/android/exoplayer2/a/f:reset	()V
    //   11: aload_3
    //   12: invokevirtual 329	com/google/android/exoplayer2/a/f:lh	()V
    //   15: aload_3
    //   16: getfield 623	com/google/android/exoplayer2/a/f:awq	[Lcom/google/android/exoplayer2/a/d;
    //   19: astore 4
    //   21: aload 4
    //   23: arraylength
    //   24: istore_2
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpge +19 -> 46
    //   30: aload 4
    //   32: iload_1
    //   33: aaload
    //   34: invokeinterface 626 1 0
    //   39: iload_1
    //   40: iconst_1
    //   41: iadd
    //   42: istore_1
    //   43: goto -18 -> 25
    //   46: aload_3
    //   47: iconst_0
    //   48: putfield 335	com/google/android/exoplayer2/a/f:avp	I
    //   51: aload_3
    //   52: iconst_0
    //   53: putfield 366	com/google/android/exoplayer2/a/f:axi	Z
    //   56: aload_0
    //   57: invokespecial 628	com/google/android/exoplayer2/e/b:kz	()V
    //   60: aload_0
    //   61: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   64: invokevirtual 631	com/google/android/exoplayer2/b/d:lD	()V
    //   67: aload_0
    //   68: getfield 48	com/google/android/exoplayer2/a/i:axJ	Lcom/google/android/exoplayer2/a/e$a;
    //   71: aload_0
    //   72: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   75: invokevirtual 634	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   78: return
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   84: invokevirtual 631	com/google/android/exoplayer2/b/d:lD	()V
    //   87: aload_0
    //   88: getfield 48	com/google/android/exoplayer2/a/i:axJ	Lcom/google/android/exoplayer2/a/e$a;
    //   91: aload_0
    //   92: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   95: invokevirtual 634	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   98: aload_3
    //   99: athrow
    //   100: astore_3
    //   101: aload_0
    //   102: invokespecial 628	com/google/android/exoplayer2/e/b:kz	()V
    //   105: aload_0
    //   106: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   109: invokevirtual 631	com/google/android/exoplayer2/b/d:lD	()V
    //   112: aload_0
    //   113: getfield 48	com/google/android/exoplayer2/a/i:axJ	Lcom/google/android/exoplayer2/a/e$a;
    //   116: aload_0
    //   117: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   120: invokevirtual 634	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   123: aload_3
    //   124: athrow
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   130: invokevirtual 631	com/google/android/exoplayer2/b/d:lD	()V
    //   133: aload_0
    //   134: getfield 48	com/google/android/exoplayer2/a/i:axJ	Lcom/google/android/exoplayer2/a/e$a;
    //   137: aload_0
    //   138: getfield 276	com/google/android/exoplayer2/a/i:aGu	Lcom/google/android/exoplayer2/b/d;
    //   141: invokevirtual 634	com/google/android/exoplayer2/a/e$a:e	(Lcom/google/android/exoplayer2/b/d;)V
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	i
    //   1	42	1	i	int
    //   24	4	2	j	int
    //   6	46	3	localf	f
    //   79	20	3	localObject1	Object
    //   100	24	3	localObject2	Object
    //   125	20	3	localObject3	Object
    //   19	12	4	arrayOfd	d[]
    // Exception table:
    //   from	to	target	type
    //   56	60	79	finally
    //   2	25	100	finally
    //   30	39	100	finally
    //   46	56	100	finally
    //   101	105	125	finally
  }
  
  public final long lo()
  {
    long l = this.axK.ax(kU());
    if (l != -9223372036854775808L) {
      if (!this.axP) {
        break label42;
      }
    }
    for (;;)
    {
      this.axO = l;
      this.axP = false;
      return this.axO;
      label42:
      l = Math.max(this.axO, l);
    }
  }
  
  public final p lv()
  {
    return this.axK.atv;
  }
  
  protected final void lw()
  {
    try
    {
      f localf = this.axK;
      if (!localf.axh)
      {
        if (!localf.isInitialized()) {
          return;
        }
        if (localf.le())
        {
          localf.awu.E(localf.lj());
          localf.awG = 0;
          localf.axh = true;
          return;
        }
      }
    }
    catch (f.h localh)
    {
      throw com.google.android.exoplayer2.e.a(localh, this.index);
    }
  }
  
  protected final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i;
    if (this.axN != null)
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
    }
    int m;
    int i1;
    label106:
    for (paramMediaCodec = this.axN.getString("mime");; paramMediaCodec = "audio/raw")
    {
      if (i != 0) {
        paramMediaFormat = this.axN;
      }
      m = paramMediaFormat.getInteger("channel-count");
      i1 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.axM) || (m != 6) || (this.auC >= 6)) {
        break label736;
      }
      paramMediaFormat = new int[this.auC];
      i = 0;
      while (i < this.auC)
      {
        paramMediaFormat[i] = i;
        i += 1;
      }
      i = 0;
      break;
    }
    f localf;
    boolean bool1;
    label136:
    label146:
    int k;
    int n;
    try
    {
      localf = this.axK;
      j = this.auD;
      if ("audio/raw".equals(paramMediaCodec)) {
        break label741;
      }
      bool1 = true;
      if (!bool1) {
        break label747;
      }
      i = f.ai(paramMediaCodec);
      k = 0;
      if (bool1) {
        break label718;
      }
      localf.awO = com.google.android.exoplayer2.i.t.aK(j, m);
      localf.awo.axC = paramMediaFormat;
      paramMediaCodec = localf.awq;
      int i2 = paramMediaCodec.length;
      n = 0;
      j = m;
      m = n;
      label196:
      if (m < i2)
      {
        paramMediaFormat = paramMediaCodec[m];
        try
        {
          int i3 = paramMediaFormat.q(i1, j, i);
          k |= i3;
          if (!paramMediaFormat.isActive()) {
            break label727;
          }
          j = paramMediaFormat.kZ();
          i = paramMediaFormat.la();
        }
        catch (d.a paramMediaCodec)
        {
          throw new f.c(paramMediaCodec);
        }
      }
      if (k == 0) {
        break label753;
      }
    }
    catch (f.c paramMediaCodec)
    {
      throw com.google.android.exoplayer2.e.a(paramMediaCodec, this.index);
    }
    localf.ld();
    break label753;
    throw new f.c("Unsupported channel count: " + m);
    label314:
    int j = i;
    if (com.google.android.exoplayer2.i.t.SDK_INT <= 23)
    {
      j = i;
      if ("foster".equals(com.google.android.exoplayer2.i.t.DEVICE))
      {
        j = i;
        if ("NVIDIA".equals(com.google.android.exoplayer2.i.t.MANUFACTURER)) {
          j = i;
        }
      }
    }
    switch (m)
    {
    case 4: 
    case 6: 
      label396:
      if ((com.google.android.exoplayer2.i.t.SDK_INT <= 25) && ("fugu".equals(com.google.android.exoplayer2.i.t.DEVICE)) && (bool1) && (m == 1))
      {
        i = 12;
        label430:
        if ((n == 0) && (localf.isInitialized()) && (localf.encoding == k) && (localf.sampleRate == i1) && (localf.awy == i)) {
          break label833;
        }
        localf.reset();
        localf.encoding = k;
        localf.awA = bool1;
        localf.sampleRate = i1;
        localf.awy = i;
        if (!bool1) {
          break label882;
        }
        label509:
        localf.awz = k;
        localf.awR = com.google.android.exoplayer2.i.t.aK(2, m);
        if (bool1)
        {
          if (localf.awz == 5) {
            break label826;
          }
          if (localf.awz != 6) {
            break label888;
          }
        }
      }
      break;
    }
    label901:
    for (;;)
    {
      label554:
      localf.bufferSize = i;
      long l;
      if (bool1)
      {
        l = -9223372036854775807L;
        label570:
        localf.awB = l;
        localf.b(localf.atv);
        return;
        i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label314;
        j = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
        break label396;
        k = AudioTrack.getMinBufferSize(i1, i, localf.awz);
        if (k == -2) {
          break label895;
        }
      }
      label718:
      label727:
      label736:
      label741:
      label747:
      label753:
      label764:
      label895:
      for (boolean bool2 = true;; bool2 = false)
      {
        com.google.android.exoplayer2.i.a.aC(bool2);
        i = k * 4;
        j = (int)localf.D(250000L) * localf.awR;
        k = (int)Math.max(k, localf.D(750000L) * localf.awR);
        if (i >= j) {
          break label901;
        }
        i = j;
        break label554;
        l = localf.C(localf.bufferSize / localf.awR);
        break label570;
        i = j;
        break label430;
        n = 0;
        k = i;
        break label764;
        m += 1;
        break label196;
        paramMediaFormat = null;
        break;
        bool1 = false;
        break label136;
        i = j;
        break label146;
        m = j;
        n = k;
        k = i;
        switch (m)
        {
        case 8: 
        default: 
          break;
        case 1: 
          i = 4;
          break label314;
          j = i;
          break label396;
          i = 20480;
          break label554;
          return;
        case 2: 
          i = 12;
          break;
        case 3: 
          i = 28;
          break;
        case 4: 
          i = 204;
          break;
        case 5: 
          i = 220;
          break;
        case 6: 
          i = 252;
          break;
        case 7: 
          i = 1276;
          break label314;
          j = 252;
          break label396;
          k = 2;
          break label509;
          i = 49152;
          break label554;
        }
      }
      label826:
      label833:
      label882:
      label888:
      if (i > k) {
        i = k;
      }
    }
  }
  
  protected final void onStarted()
  {
    super.onStarted();
    this.axK.play();
  }
  
  protected final void onStopped()
  {
    f localf = this.axK;
    localf.axi = false;
    if (localf.isInitialized())
    {
      localf.lk();
      localf.awu.pause();
    }
    super.onStopped();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i
 * JD-Core Version:    0.7.0.1
 */