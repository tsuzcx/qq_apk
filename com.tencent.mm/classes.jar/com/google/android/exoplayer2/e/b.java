package com.google.android.exoplayer2.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] cWy = x.dv("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> cFr;
  private Format cHc;
  private ByteBuffer[] cJm;
  private final boolean cWA;
  private final com.google.android.exoplayer2.b.e cWB;
  private final com.google.android.exoplayer2.b.e cWC;
  private final com.google.android.exoplayer2.k cWD;
  private final List<Long> cWE;
  private final MediaCodec.BufferInfo cWF;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> cWG;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> cWH;
  private a cWI;
  private int cWJ;
  private boolean cWK;
  private boolean cWL;
  private boolean cWM;
  private boolean cWN;
  private boolean cWO;
  private boolean cWP;
  private boolean cWQ;
  private boolean cWR;
  private ByteBuffer[] cWS;
  private long cWT;
  private int cWU;
  private int cWV;
  private boolean cWW;
  private boolean cWX;
  private int cWY;
  private int cWZ;
  private final c cWz;
  private boolean cXa;
  private boolean cXb;
  private boolean cXc;
  private boolean cXd;
  private boolean cXe;
  private boolean cXf;
  protected com.google.android.exoplayer2.b.d cXg;
  private MediaCodec codec;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.cWz = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.cFr = paramb;
      this.cWA = paramBoolean;
      this.cWB = new com.google.android.exoplayer2.b.e(0);
      this.cWC = new com.google.android.exoplayer2.b.e(0);
      this.cWD = new com.google.android.exoplayer2.k();
      this.cWE = new ArrayList();
      this.cWF = new MediaCodec.BufferInfo();
      this.cWY = 0;
      this.cWZ = 0;
      return;
    }
  }
  
  private boolean D(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.cWV < 0)
    {
      if ((this.cWO) && (this.cXb)) {}
      for (;;)
      {
        try
        {
          this.cWV = this.codec.dequeueOutputBuffer(this.cWF, 0L);
          if (this.cWV < 0) {
            break label352;
          }
          if (!this.cWR) {
            break;
          }
          this.cWR = false;
          this.codec.releaseOutputBuffer(this.cWV, false);
          this.cWV = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          SE();
          if (this.cXd) {
            SB();
          }
          return false;
        }
        this.cWV = this.codec.dequeueOutputBuffer(this.cWF, 0L);
      }
      if ((this.cWF.flags & 0x4) != 0)
      {
        SE();
        this.cWV = -1;
        return false;
      }
      localObject = this.cJm[this.cWV];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.cWF.offset);
        ((ByteBuffer)localObject).limit(this.cWF.offset + this.cWF.size);
      }
      long l = this.cWF.presentationTimeUs;
      int j = this.cWE.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.cWE.get(i)).longValue() == l)
      {
        this.cWE.remove(i);
        bool = true;
        label254:
        this.cWW = bool;
      }
    }
    else
    {
      if ((!this.cWO) || (!this.cXb)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.codec, this.cJm[this.cWV], this.cWV, this.cWF.flags, this.cWF.presentationTimeUs, this.cWW);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.cWF.presentationTimeUs;
        this.cWV = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        SE();
        if (!this.cXd) {
          continue;
        }
        SB();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.cWV == -2)
      {
        localObject = this.codec.getOutputFormat();
        if ((this.cWJ != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.cWR = true;
          return true;
        }
        if (this.cWP) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, (MediaFormat)localObject);
        continue;
      }
      if (this.cWV == -3)
      {
        this.cJm = this.codec.getOutputBuffers();
        return true;
      }
      if ((this.cWM) && ((this.cXc) || (this.cWZ == 2))) {
        SE();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.codec, this.cJm[this.cWV], this.cWV, this.cWF.flags, this.cWF.presentationTimeUs, this.cWW);
    }
    label551:
    return false;
  }
  
  private boolean SC()
  {
    if ((this.codec == null) || (this.cWZ == 2) || (this.cXc)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.cWU < 0)
      {
        this.cWU = this.codec.dequeueInputBuffer(0L);
        if (this.cWU >= 0)
        {
          this.cWB.cKQ = this.cWS[this.cWU];
          this.cWB.clear();
        }
      }
      else
      {
        if (this.cWZ == 1)
        {
          if (!this.cWM)
          {
            this.cXb = true;
            this.codec.queueInputBuffer(this.cWU, 0, 0, 0L, 4);
            this.cWU = -1;
          }
          this.cWZ = 2;
          return false;
        }
        if (this.cWQ)
        {
          this.cWQ = false;
          this.cWB.cKQ.put(cWy);
          this.codec.queueInputBuffer(this.cWU, 0, cWy.length, 0L, 0);
          this.cWU = -1;
          this.cXa = true;
          return true;
        }
        if (this.cXe) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.cWD, this.cWB, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.cWY == 2)
          {
            this.cWB.clear();
            this.cWY = 1;
          }
          e(this.cWD.cHc);
          return true;
          if (this.cWY == 1)
          {
            i = 0;
            while (i < this.cHc.cGP.size())
            {
              byte[] arrayOfByte = (byte[])this.cHc.cGP.get(i);
              this.cWB.cKQ.put(arrayOfByte);
              i += 1;
            }
            this.cWY = 2;
          }
          i = this.cWB.cKQ.position();
        }
        continue;
        label330:
        if (this.cWB.Ry())
        {
          if (this.cWY == 2)
          {
            this.cWB.clear();
            this.cWY = 1;
          }
          this.cXc = true;
          if (!this.cXa)
          {
            SE();
            return false;
          }
          try
          {
            if (!this.cWM)
            {
              this.cXb = true;
              this.codec.queueInputBuffer(this.cWU, 0, 0, 0L, 4);
              this.cWU = -1;
              return false;
            }
          }
          catch (MediaCodec.CryptoException localCryptoException1)
          {
            throw com.google.android.exoplayer2.e.b(localCryptoException1, getIndex());
          }
        }
      }
    }
    if ((this.cXf) && (!this.cWB.Rz()))
    {
      this.cWB.clear();
      if (this.cWY == 2) {
        this.cWY = 1;
      }
      return true;
    }
    this.cXf = false;
    boolean bool2 = this.cWB.RC();
    boolean bool1;
    if ((this.cWG == null) || ((!bool2) && (this.cWA))) {
      bool1 = false;
    }
    for (;;)
    {
      this.cXe = bool1;
      if (this.cXe) {
        break;
      }
      if ((!this.cWK) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.f(this.cWB.cKQ);
      if (this.cWB.cKQ.position() != 0) {
        break label594;
      }
      return true;
      j = this.cWG.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.cWG.RN(), getIndex());
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.cWK = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.cWB.timeUs;
        if (this.cWB.Rx()) {
          this.cWE.add(Long.valueOf(l));
        }
        this.cWB.RD();
        SD();
        if (bool2)
        {
          Object localObject = this.cWB.cKP.cKF;
          if (i == 0)
          {
            this.codec.queueSecureInputBuffer(this.cWU, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.cWU = -1;
            this.cXa = true;
            this.cWY = 0;
            localObject = this.cXg;
            ((com.google.android.exoplayer2.b.d)localObject).cKK += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.codec.queueInputBuffer(this.cWU, 0, this.cWB.cKQ.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, getIndex());
      }
    }
  }
  
  private void SE()
  {
    if (this.cWZ == 2)
    {
      SB();
      Sz();
      return;
    }
    this.cXd = true;
    Rv();
  }
  
  private void a(a parama)
  {
    throw com.google.android.exoplayer2.e.b(parama, getIndex());
  }
  
  public final void B(long paramLong1, long paramLong2)
  {
    if (this.cXd) {
      Rv();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.cHc == null)
        {
          this.cWC.clear();
          i = a(this.cWD, this.cWC, true);
          if (i == -5) {
            e(this.cWD.cHc);
          }
        }
        else
        {
          Sz();
          if (this.codec == null) {
            break;
          }
          v.ax("drainAndFeed");
          while (D(paramLong1, paramLong2)) {}
          while (SC()) {}
          v.DS();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.cWC.Ry());
      this.cXc = true;
      SE();
      return;
      bL(paramLong1);
      this.cWC.clear();
      i = a(this.cWD, this.cWC, false);
      if (i == -5)
      {
        e(this.cWD.cHc);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.cWC.Ry());
    this.cXc = true;
    SE();
  }
  
  public boolean QU()
  {
    return this.cXd;
  }
  
  public final int Qt()
  {
    return 8;
  }
  
  public void Qu() {}
  
  public void Qv() {}
  
  public void Qw()
  {
    this.cHc = null;
    try
    {
      SB();
      return;
    }
    finally
    {
      this.cWG = null;
      this.cWH = null;
    }
  }
  
  protected void Rv() {}
  
  protected final a SA()
  {
    return this.cWI;
  }
  
  /* Error */
  protected void SB()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 426
    //   4: putfield 429	com/google/android/exoplayer2/e/b:cWT	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 253	com/google/android/exoplayer2/e/b:cWU	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 139	com/google/android/exoplayer2/e/b:cWV	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 280	com/google/android/exoplayer2/e/b:cXe	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 208	com/google/android/exoplayer2/e/b:cWW	Z
    //   27: aload_0
    //   28: getfield 122	com/google/android/exoplayer2/e/b:cWE	Ljava/util/List;
    //   31: invokeinterface 430 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 259	com/google/android/exoplayer2/e/b:cWS	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 170	com/google/android/exoplayer2/e/b:cJm	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 425	com/google/android/exoplayer2/e/b:cWI	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 432	com/google/android/exoplayer2/e/b:cWX	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 278	com/google/android/exoplayer2/e/b:cXa	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 322	com/google/android/exoplayer2/e/b:cWK	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 434	com/google/android/exoplayer2/e/b:cWL	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 217	com/google/android/exoplayer2/e/b:cWJ	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 245	com/google/android/exoplayer2/e/b:cWM	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 436	com/google/android/exoplayer2/e/b:cWN	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 229	com/google/android/exoplayer2/e/b:cWP	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 272	com/google/android/exoplayer2/e/b:cWQ	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 153	com/google/android/exoplayer2/e/b:cWR	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 143	com/google/android/exoplayer2/e/b:cXb	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 129	com/google/android/exoplayer2/e/b:cWY	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 131	com/google/android/exoplayer2/e/b:cWZ	I
    //   116: aload_0
    //   117: getfield 109	com/google/android/exoplayer2/e/b:cWB	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 263	com/google/android/exoplayer2/b/e:cKQ	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 373	com/google/android/exoplayer2/e/b:cXg	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 439	com/google/android/exoplayer2/b/d:cKJ	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 439	com/google/android/exoplayer2/b/d:cKJ	I
    //   146: aload_0
    //   147: getfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   150: invokevirtual 442	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   157: invokevirtual 445	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 421	com/google/android/exoplayer2/e/b:cWH	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 421	com/google/android/exoplayer2/e/b:cWH	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   225: invokevirtual 445	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 421	com/google/android/exoplayer2/e/b:cWH	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 145	com/google/android/exoplayer2/e/b:codec	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 421	com/google/android/exoplayer2/e/b:cWH	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 320	com/google/android/exoplayer2/e/b:cWG	Lcom/google/android/exoplayer2/drm/a;
    //   287: aload_1
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	b
    //   135	3	1	locald	com.google.android.exoplayer2.b.d
    //   189	30	1	localObject1	Object
    //   220	37	1	localObject2	Object
    //   258	30	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   153	160	189	finally
    //   146	153	220	finally
    //   221	228	258	finally
  }
  
  protected void SD() {}
  
  protected final void Sz()
  {
    boolean bool2 = false;
    if ((this.codec != null) || (this.cHc == null)) {}
    for (;;)
    {
      return;
      this.cWG = this.cWH;
      Object localObject;
      if (this.cWG != null)
      {
        if ((com.google.android.exoplayer2.drm.d)this.cWG.RO() == null)
        {
          localObject = this.cWG.RN();
          if (localObject == null) {
            continue;
          }
          throw com.google.android.exoplayer2.e.b((Exception)localObject, getIndex());
        }
        throw null;
      }
      if (this.cWI == null) {}
      try
      {
        this.cWI = a(this.cWz, this.cHc, false);
        if (this.cWI == null) {
          a(new a(this.cHc, null, -49999));
        }
        if (!a(this.cWI)) {
          continue;
        }
        localObject = this.cWI.name;
        if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(localObject)) && ((x.MODEL.startsWith("SM-T585")) || (x.MODEL.startsWith("SM-A520"))))
        {
          i = 2;
          this.cWJ = i;
          Format localFormat = this.cHc;
          if ((x.SDK_INT >= 21) || (!localFormat.cGP.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(localObject))) {
            break label787;
          }
          bool1 = true;
          this.cWK = bool1;
          if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(localObject)) && (!"OMX.SEC.avc.dec.secure".equals(localObject)))) && ((x.SDK_INT != 19) || (!x.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(localObject)) && (!"OMX.Exynos.avc.dec.secure".equals(localObject))))) {
            break label792;
          }
          bool1 = true;
          this.cWL = bool1;
          if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(localObject)) && (!"OMX.allwinner.video.decoder.avc".equals(localObject)))) {
            break label797;
          }
          bool1 = true;
          this.cWM = bool1;
          if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(localObject))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.dkS)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(localObject)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(localObject))))) {
            break label802;
          }
          bool1 = true;
          this.cWN = bool1;
          if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(localObject))) {
            break label807;
          }
          bool1 = true;
          this.cWO = bool1;
          localFormat = this.cHc;
          bool1 = bool2;
          if (x.SDK_INT <= 18)
          {
            bool1 = bool2;
            if (localFormat.channelCount == 1)
            {
              bool1 = bool2;
              if ("OMX.MTK.AUDIO.DECODER.MP3".equals(localObject)) {
                bool1 = true;
              }
            }
          }
          this.cWP = bool1;
        }
      }
      catch (d.b localb)
      {
        try
        {
          for (;;)
          {
            int i;
            l1 = SystemClock.elapsedRealtime();
            v.ax("createCodec:".concat(String.valueOf(localObject)));
            this.codec = MediaCodec.createByCodecName((String)localObject);
            v.DS();
            v.ax("configureCodec");
            a(this.cWI, this.codec, this.cHc);
            v.DS();
            v.ax("startCodec");
            this.codec.start();
            v.DS();
            long l2 = SystemClock.elapsedRealtime();
            d((String)localObject, l2, l2 - l1);
            this.cWS = this.codec.getInputBuffers();
            this.cJm = this.codec.getOutputBuffers();
            if (getState() != 2) {
              break;
            }
            l1 = SystemClock.elapsedRealtime() + 1000L;
            this.cWT = l1;
            this.cWU = -1;
            this.cWV = -1;
            this.cXf = true;
            localObject = this.cXg;
            ((com.google.android.exoplayer2.b.d)localObject).cKI += 1;
            return;
            localb = localb;
            a(new a(this.cHc, localb, -49998));
            continue;
            if ((x.SDK_INT < 24) && (("OMX.Nvidia.h264.decode".equals(localb)) || ("OMX.Nvidia.h264.decode.secure".equals(localb))) && (("flounder".equals(x.dkS)) || ("flounder_lte".equals(x.dkS)) || ("grouper".equals(x.dkS)) || ("tilapia".equals(x.dkS))))
            {
              i = 1;
            }
            else
            {
              i = 0;
              continue;
              label787:
              bool1 = false;
              continue;
              label792:
              bool1 = false;
              continue;
              label797:
              bool1 = false;
              continue;
              label802:
              bool1 = false;
            }
          }
          label807:
          boolean bool1 = false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a(new a(this.cHc, localException, localb));
            continue;
            long l1 = -9223372036854775807L;
          }
        }
      }
    }
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.e(paramFormat.cGN, paramBoolean);
  }
  
  protected abstract void a(a parama, MediaCodec paramMediaCodec, Format paramFormat);
  
  protected abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean);
  
  protected boolean a(a parama)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return false;
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.cWz, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.cFr;
      if (paramFormat.cGQ != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, getIndex());
    }
    boolean bool = localb.RP();
    for (;;)
    {
      i = j;
      if (!bool) {
        i = j & 0xFFFFFFF8 | 0x2;
      }
      label75:
      return i;
      label77:
      if (localb != null) {
        break;
      }
      bool = false;
    }
  }
  
  public void bu(boolean paramBoolean)
  {
    this.cXg = new com.google.android.exoplayer2.b.d();
  }
  
  protected void d(String paramString, long paramLong1, long paramLong2) {}
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.cHc;
    this.cHc = paramFormat;
    DrmInitData localDrmInitData = this.cHc.cGQ;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (x.p(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.cHc.cGQ == null) {
          break label223;
        }
        if (this.cFr == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
          paramFormat = localFormat.cGQ;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.cFr;
        Looper.myLooper();
        this.cWH = paramFormat.RQ();
        if (this.cWH != this.cWG) {}
      }
    }
    if ((this.cWH == this.cWG) && (this.codec != null) && (a(this.cWI.cWv, localFormat, this.cHc)))
    {
      this.cWX = true;
      this.cWY = 1;
      if ((this.cWJ == 2) || ((this.cWJ == 1) && (this.cHc.width == localFormat.width) && (this.cHc.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.cWQ = bool;
        return;
        label223:
        this.cWH = null;
        break;
      }
    }
    if (this.cXa)
    {
      this.cWZ = 1;
      return;
    }
    SB();
    Sz();
  }
  
  public void f(long paramLong, boolean paramBoolean)
  {
    this.cXc = false;
    this.cXd = false;
    if (this.codec != null)
    {
      this.cWT = -9223372036854775807L;
      this.cWU = -1;
      this.cWV = -1;
      this.cXf = true;
      this.cXe = false;
      this.cWW = false;
      this.cWE.clear();
      this.cWQ = false;
      this.cWR = false;
      if ((!this.cWL) && ((!this.cWN) || (!this.cXb))) {
        break label117;
      }
      SB();
      Sz();
    }
    for (;;)
    {
      if ((this.cWX) && (this.cHc != null)) {
        this.cWY = 1;
      }
      return;
      label117:
      if (this.cWZ != 0)
      {
        SB();
        Sz();
      }
      else
      {
        this.codec.flush();
        this.cXa = false;
      }
    }
  }
  
  protected final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  public boolean isReady()
  {
    return (this.cHc != null) && (!this.cXe) && ((Qy()) || (this.cWV >= 0) || ((this.cWT != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.cWT)));
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public static final class a
    extends Exception
  {
    public final boolean cXh;
    public final String cXi;
    public final String cXj;
    public final String mimeType;
    
    public a(Format paramFormat, Throwable paramThrowable, int paramInt)
    {
      super(paramThrowable);
      AppMethodBeat.i(210230);
      this.mimeType = paramFormat.cGN;
      this.cXh = false;
      this.cXi = null;
      if (paramInt < 0) {}
      for (paramFormat = "neg_";; paramFormat = "")
      {
        this.cXj = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
        AppMethodBeat.o(210230);
        return;
      }
    }
    
    public a(Format paramFormat, Throwable paramThrowable, String paramString)
    {
      super(paramThrowable);
      AppMethodBeat.i(210238);
      this.mimeType = paramFormat.cGN;
      this.cXh = false;
      this.cXi = paramString;
      paramFormat = localObject;
      if (x.SDK_INT >= 21)
      {
        paramFormat = localObject;
        if ((paramThrowable instanceof MediaCodec.CodecException)) {
          paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
        }
      }
      this.cXj = paramFormat;
      AppMethodBeat.o(210238);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */