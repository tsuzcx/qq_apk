package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public final class c
  extends com.google.android.exoplayer2.e.b
{
  private static final int[] bbM = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private int axn;
  private Surface axw;
  private boolean azz;
  private final d bbN;
  private final e.a bbO;
  private final long bbP;
  private final int bbQ;
  private final boolean bbR;
  private final long[] bbS;
  private Format[] bbT;
  private c.a bbU;
  private boolean bbV;
  private Surface bbW;
  private int bbX;
  private boolean bbY;
  private long bbZ;
  private long bca;
  private int bcb;
  private int bcc;
  private int bcd;
  private float bce;
  private int bcf;
  private int bcg;
  private int bch;
  private float bci;
  private int bcj;
  private int bck;
  private int bcl;
  private float bcm;
  c.b bcn;
  private long bco;
  private int bcp;
  private final Context context;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, int paramInt)
  {
    super(2, paramc, paramb, false);
    AppMethodBeat.i(152032);
    this.bbP = paramLong;
    this.bbQ = paramInt;
    this.context = paramContext.getApplicationContext();
    this.bbN = new d(paramContext);
    this.bbO = new e.a(paramHandler, parame);
    boolean bool1 = bool2;
    if (x.SDK_INT <= 22)
    {
      bool1 = bool2;
      if ("foster".equals(x.DEVICE))
      {
        bool1 = bool2;
        if ("NVIDIA".equals(x.MANUFACTURER)) {
          bool1 = true;
        }
      }
    }
    this.bbR = bool1;
    this.bbS = new long[10];
    this.bco = -9223372036854775807L;
    this.bbZ = -9223372036854775807L;
    this.bcf = -1;
    this.bcg = -1;
    this.bci = -1.0F;
    this.bce = -1.0F;
    this.bbX = 1;
    rg();
    AppMethodBeat.o(152032);
  }
  
  private static Point a(com.google.android.exoplayer2.e.a parama, Format paramFormat)
  {
    AppMethodBeat.i(96027);
    int i;
    int j;
    label30:
    int k;
    label41:
    float f1;
    int[] arrayOfInt;
    int i3;
    int m;
    if (paramFormat.height > paramFormat.width)
    {
      i = 1;
      if (i == 0) {
        break label111;
      }
      j = paramFormat.height;
      if (i == 0) {
        break label120;
      }
      k = paramFormat.width;
      f1 = k / j;
      arrayOfInt = bbM;
      i3 = arrayOfInt.length;
      m = 0;
    }
    for (;;)
    {
      if (m >= i3) {
        break label376;
      }
      int i2 = arrayOfInt[m];
      int i1 = (int)(i2 * f1);
      if ((i2 <= j) || (i1 <= k))
      {
        AppMethodBeat.o(96027);
        return null;
        i = 0;
        break;
        label111:
        j = paramFormat.width;
        break label30;
        label120:
        k = paramFormat.height;
        break label41;
      }
      if (x.SDK_INT >= 21)
      {
        label151:
        Object localObject;
        if (i != 0)
        {
          n = i1;
          if (i == 0) {
            break label206;
          }
          if (parama.aMG != null) {
            break label213;
          }
          parama.aq("align.caps");
          localObject = null;
        }
        for (;;)
        {
          float f2 = paramFormat.awO;
          if (!parama.a(((Point)localObject).x, ((Point)localObject).y, f2)) {
            break label367;
          }
          AppMethodBeat.o(96027);
          return localObject;
          n = i2;
          break;
          label206:
          i2 = i1;
          break label151;
          label213:
          localObject = parama.aMG.getVideoCapabilities();
          if (localObject == null)
          {
            parama.aq("align.vCaps");
            localObject = null;
          }
          else
          {
            i1 = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
            int i4 = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
            localObject = new Point(x.bb(n, i1) * i1, x.bb(i2, i4) * i4);
          }
        }
      }
      int n = x.bb(i2, 16) * 16;
      i1 = x.bb(i1, 16) * 16;
      if (n * i1 <= com.google.android.exoplayer2.e.d.oI())
      {
        if (i != 0)
        {
          j = i1;
          if (i == 0) {
            break label360;
          }
        }
        for (;;)
        {
          parama = new Point(j, n);
          AppMethodBeat.o(96027);
          return parama;
          j = n;
          break;
          label360:
          n = i1;
        }
      }
      label367:
      m += 1;
    }
    label376:
    AppMethodBeat.o(96027);
    return null;
  }
  
  private void a(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(96017);
    v.beginSection("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.endSection();
    paramMediaCodec = this.aNp;
    paramMediaCodec.aAO += 1;
    AppMethodBeat.o(96017);
  }
  
  @TargetApi(21)
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    AppMethodBeat.i(96019);
    rh();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    v.endSection();
    paramMediaCodec = this.aNp;
    paramMediaCodec.aAN += 1;
    this.bcc = 0;
    rf();
    AppMethodBeat.o(96019);
  }
  
  private boolean aM(boolean paramBoolean)
  {
    AppMethodBeat.i(96020);
    if ((x.SDK_INT >= 23) && (!this.azz) && ((!paramBoolean) || (DummySurface.ab(this.context))))
    {
      AppMethodBeat.o(96020);
      return true;
    }
    AppMethodBeat.o(96020);
    return false;
  }
  
  private static boolean al(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private void b(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(96018);
    rh();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.endSection();
    paramMediaCodec = this.aNp;
    paramMediaCodec.aAN += 1;
    this.bcc = 0;
    rf();
    AppMethodBeat.o(96018);
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(96030);
    if ((paramFormat1.awK.equals(paramFormat2.awK)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))))
    {
      AppMethodBeat.o(96030);
      return true;
    }
    AppMethodBeat.o(96030);
    return false;
  }
  
  private static int e(String paramString, int paramInt1, int paramInt2)
  {
    int j = 2;
    AppMethodBeat.i(96029);
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      AppMethodBeat.o(96029);
      return -1;
    }
    label88:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(96029);
        return -1;
        if (!paramString.equals("video/3gpp")) {
          break label88;
        }
        i = 0;
        continue;
        if (!paramString.equals("video/mp4v-es")) {
          break label88;
        }
        i = 1;
        continue;
        if (!paramString.equals("video/avc")) {
          break label88;
        }
        i = 2;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break label88;
        }
        i = 3;
        continue;
        if (!paramString.equals("video/hevc")) {
          break label88;
        }
        i = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9")) {
          break label88;
        }
        i = 5;
      }
    }
    paramInt1 *= paramInt2;
    paramInt2 = j;
    for (;;)
    {
      paramInt1 = paramInt1 * 3 / (paramInt2 * 2);
      AppMethodBeat.o(96029);
      return paramInt1;
      if ("BRAVIA 4K 2015".equals(x.MODEL))
      {
        AppMethodBeat.o(96029);
        return -1;
      }
      paramInt1 = x.bb(paramInt1, 16) * x.bb(paramInt2, 16) * 16 * 16;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = 4;
    }
  }
  
  private static int l(Format paramFormat)
  {
    AppMethodBeat.i(96028);
    if (paramFormat.awL != -1)
    {
      int k = paramFormat.awM.size();
      int j = 0;
      i = 0;
      while (j < k)
      {
        i += ((byte[])paramFormat.awM.get(j)).length;
        j += 1;
      }
      j = paramFormat.awL;
      AppMethodBeat.o(96028);
      return j + i;
    }
    int i = e(paramFormat.awK, paramFormat.width, paramFormat.height);
    AppMethodBeat.o(96028);
    return i;
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.awP == -1) {
      return 0;
    }
    return paramFormat.awP;
  }
  
  private void rd()
  {
    AppMethodBeat.i(96021);
    if (this.bbP > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.bbP;; l = -9223372036854775807L)
    {
      this.bbZ = l;
      AppMethodBeat.o(96021);
      return;
    }
  }
  
  private void re()
  {
    AppMethodBeat.i(96022);
    this.bbY = false;
    if ((x.SDK_INT >= 23) && (this.azz))
    {
      MediaCodec localMediaCodec = this.aMR;
      if (localMediaCodec != null) {
        this.bcn = new c.b(this, localMediaCodec, (byte)0);
      }
    }
    AppMethodBeat.o(96022);
  }
  
  private void rg()
  {
    this.bcj = -1;
    this.bck = -1;
    this.bcm = -1.0F;
    this.bcl = -1;
  }
  
  private void rh()
  {
    AppMethodBeat.i(96024);
    if (((this.bcf != -1) || (this.bcg != -1)) && ((this.bcj != this.bcf) || (this.bck != this.bcg) || (this.bcl != this.bch) || (this.bcm != this.bci)))
    {
      this.bbO.c(this.bcf, this.bcg, this.bch, this.bci);
      this.bcj = this.bcf;
      this.bck = this.bcg;
      this.bcl = this.bch;
      this.bcm = this.bci;
    }
    AppMethodBeat.o(96024);
  }
  
  private void ri()
  {
    AppMethodBeat.i(96025);
    if ((this.bcj != -1) || (this.bck != -1)) {
      this.bbO.c(this.bcj, this.bck, this.bcl, this.bcm);
    }
    AppMethodBeat.o(96025);
  }
  
  private void rj()
  {
    AppMethodBeat.i(96026);
    if (this.bcb > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.bca;
      this.bbO.l(this.bcb, l1 - l2);
      this.bcb = 0;
      this.bca = l1;
    }
    AppMethodBeat.o(96026);
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    AppMethodBeat.i(95999);
    String str = paramFormat.awK;
    if (!j.aH(str))
    {
      AppMethodBeat.o(95999);
      return 0;
    }
    Object localObject = paramFormat.awN;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).aBg) {
          break;
        }
        bool1 |= localObject.aBf[i].aBh;
        i += 1;
      }
    }
    boolean bool2 = false;
    paramc = paramc.f(str, bool2);
    if (paramc == null)
    {
      AppMethodBeat.o(95999);
      return 1;
    }
    str = paramFormat.awH;
    if ((str == null) || (paramc.mimeType == null))
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramFormat.width > 0)
        {
          bool2 = bool1;
          if (paramFormat.height > 0)
          {
            if (x.SDK_INT < 21) {
              break label432;
            }
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.awO);
          }
        }
      }
      if (!paramc.aME) {
        break label521;
      }
      i = 16;
      label197:
      if (paramc.azz) {
        j = 32;
      }
      if (!bool2) {
        break label527;
      }
    }
    label393:
    label527:
    for (int k = 4;; k = 3)
    {
      AppMethodBeat.o(95999);
      return j | i | k;
      localObject = j.aJ(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.aq("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.ar(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.oB();
      k = arrayOfCodecProfileLevel.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label393;
        }
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        if ((localCodecProfileLevel.profile == ((Integer)localPair.first).intValue()) && (localCodecProfileLevel.level >= ((Integer)localPair.second).intValue()))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      paramc.aq("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      label432:
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.oI()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(x.bbt).append("]");
        bool2 = bool1;
        break;
      }
      i = 8;
      break label197;
    }
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(96009);
    Object localObject = this.bbT;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new c.a(k, j, i);
      this.bbU = ((c.a)localObject);
      localObject = this.bbU;
      boolean bool = this.bbR;
      i = this.axn;
      paramFormat = paramFormat.mY();
      paramFormat.setInteger("max-width", ((c.a)localObject).width);
      paramFormat.setInteger("max-height", ((c.a)localObject).height);
      if (((c.a)localObject).bcq != -1) {
        paramFormat.setInteger("max-input-size", ((c.a)localObject).bcq);
      }
      if (bool) {
        paramFormat.setInteger("auto-frc", 0);
      }
      if (i != 0)
      {
        paramFormat.setFeatureEnabled("tunneled-playback", true);
        paramFormat.setInteger("audio-session-id", i);
      }
      if (this.axw == null)
      {
        com.google.android.exoplayer2.i.a.checkState(aM(parama.aMF));
        if (this.bbW == null) {
          this.bbW = DummySurface.i(this.context, parama.aMF);
        }
        this.axw = this.bbW;
      }
      paramMediaCodec.configure(paramFormat, this.axw, paramMediaCrypto, 0);
      if ((x.SDK_INT >= 23) && (this.azz)) {
        this.bcn = new c.b(this, paramMediaCodec, (byte)0);
      }
      AppMethodBeat.o(96009);
      return;
    }
    int m = 0;
    int i2 = localObject.length;
    int n = 0;
    label268:
    int i1;
    if (n < i2)
    {
      Format localFormat = localObject[n];
      if (!b(parama.aME, paramFormat, localFormat)) {
        break label529;
      }
      if ((localFormat.width == -1) || (localFormat.height == -1))
      {
        i1 = 1;
        label316:
        m = i1 | m;
        k = Math.max(k, localFormat.width);
        j = Math.max(j, localFormat.height);
        i = Math.max(i, l(localFormat));
      }
    }
    label529:
    for (;;)
    {
      n += 1;
      break label268;
      i1 = 0;
      break label316;
      i2 = i;
      i1 = j;
      n = k;
      if (m != 0)
      {
        new StringBuilder("Resolutions unknown. Codec max resolution: ").append(k).append("x").append(j);
        localObject = a(parama, paramFormat);
        i2 = i;
        i1 = j;
        n = k;
        if (localObject != null)
        {
          n = Math.max(k, ((Point)localObject).x);
          i1 = Math.max(j, ((Point)localObject).y);
          i2 = Math.max(i, e(paramFormat.awK, n, i1));
          new StringBuilder("Codec max resolution adjusted to: ").append(n).append("x").append(i1);
        }
      }
      localObject = new c.a(n, i1, i2);
      break;
    }
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(96001);
    this.bbT = paramArrayOfFormat;
    if (this.bco == -9223372036854775807L)
    {
      this.bco = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      AppMethodBeat.o(96001);
      return;
    }
    if (this.bcp == this.bbS.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.bbS[(this.bcp - 1)]);
    }
    for (;;)
    {
      this.bbS[(this.bcp - 1)] = paramLong;
      break;
      this.bcp += 1;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(96016);
    while ((this.bcp != 0) && (paramLong3 >= this.bbS[0]))
    {
      this.bco = this.bbS[0];
      this.bcp -= 1;
      System.arraycopy(this.bbS, 1, this.bbS, 0, this.bcp);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      AppMethodBeat.o(96016);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.axw == this.bbW)
    {
      if (al(paramLong1))
      {
        a(paramMediaCodec, paramInt1);
        AppMethodBeat.o(96016);
        return true;
      }
      AppMethodBeat.o(96016);
      return false;
    }
    if (!this.bbY)
    {
      if (x.SDK_INT >= 21) {
        a(paramMediaCodec, paramInt1, System.nanoTime());
      }
      for (;;)
      {
        AppMethodBeat.o(96016);
        return true;
        b(paramMediaCodec, paramInt1);
      }
    }
    if (this.state != 2)
    {
      AppMethodBeat.o(96016);
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l3 = System.nanoTime();
    l1 = l3 + (paramLong1 - (l1 * 1000L - paramLong2)) * 1000L;
    paramByteBuffer = this.bbN;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.bcz)
    {
      if (paramLong3 != paramByteBuffer.bcw)
      {
        paramByteBuffer.bcC += 1L;
        paramByteBuffer.bcx = paramByteBuffer.bcy;
      }
      if (paramByteBuffer.bcC >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.bcB) / paramByteBuffer.bcC;
        paramLong2 = paramByteBuffer.bcx + paramLong1;
        if (paramByteBuffer.o(paramLong2, l1))
        {
          paramByteBuffer.bcz = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.bcz)
      {
        paramByteBuffer.bcB = l2;
        paramByteBuffer.bcA = l1;
        paramByteBuffer.bcC = 0L;
        paramByteBuffer.bcz = true;
      }
      paramByteBuffer.bcw = paramLong3;
      paramByteBuffer.bcy = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.bcs != null)
      {
        if (paramByteBuffer.bcs.bcD != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!al(paramLong1)) {
        break label650;
      }
      v.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      v.endSection();
      paramMediaCodec = this.aNp;
      paramMediaCodec.aAP += 1;
      this.bcb += 1;
      this.bcc += 1;
      this.aNp.aAQ = Math.max(this.bcc, this.aNp.aAQ);
      if (this.bcb == this.bbQ) {
        rj();
      }
      AppMethodBeat.o(96016);
      return true;
      paramLong1 = paramByteBuffer.bcA + paramLong2 - paramByteBuffer.bcB;
      continue;
      if (paramByteBuffer.o(l2, l1)) {
        paramByteBuffer.bcz = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.bcs.bcD;
    paramLong3 = paramByteBuffer.bcu;
    paramLong2 = (paramLong1 - paramLong2) / paramLong3 * paramLong3 + paramLong2;
    if (paramLong1 <= paramLong2)
    {
      paramLong3 = paramLong2 - paramLong3;
      label607:
      if (paramLong2 - paramLong1 >= paramLong1 - paramLong3) {
        break label644;
      }
    }
    for (;;)
    {
      paramLong2 -= paramByteBuffer.bcv;
      break;
      l1 = paramLong2 + paramLong3;
      paramLong3 = paramLong2;
      paramLong2 = l1;
      break label607;
      label644:
      paramLong2 = paramLong3;
    }
    label650:
    if (x.SDK_INT >= 21)
    {
      if (paramLong1 < 50000L)
      {
        a(paramMediaCodec, paramInt1, paramLong2);
        AppMethodBeat.o(96016);
        return true;
      }
    }
    else if (paramLong1 < 30000L)
    {
      if (paramLong1 > 11000L) {}
      try
      {
        Thread.sleep((paramLong1 - 10000L) / 1000L);
        b(paramMediaCodec, paramInt1);
        AppMethodBeat.o(96016);
        return true;
      }
      catch (InterruptedException paramByteBuffer)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    AppMethodBeat.o(96016);
    return false;
  }
  
  public final boolean a(com.google.android.exoplayer2.e.a parama)
  {
    AppMethodBeat.i(96008);
    if ((this.axw != null) || (aM(parama.aMF)))
    {
      AppMethodBeat.o(96008);
      return true;
    }
    AppMethodBeat.o(96008);
    return false;
  }
  
  public final boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(96015);
    if ((b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.bbU.width) && (paramFormat2.height <= this.bbU.height) && (l(paramFormat2) <= this.bbU.bcq))
    {
      AppMethodBeat.o(96015);
      return true;
    }
    AppMethodBeat.o(96015);
    return false;
  }
  
  public final void aB(boolean paramBoolean)
  {
    AppMethodBeat.i(96000);
    super.aB(paramBoolean);
    this.axn = this.auY.axn;
    if (this.axn != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.azz = paramBoolean;
      Object localObject = this.bbO;
      com.google.android.exoplayer2.b.d locald = this.aNp;
      if (((e.a)localObject).bcH != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.bbN;
      ((d)localObject).bcz = false;
      if (((d)localObject).bct) {
        ((d)localObject).bcs.handler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(96000);
      return;
    }
  }
  
  public final void b(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(96002);
    super.b(paramLong, paramBoolean);
    re();
    this.bcc = 0;
    if (this.bcp != 0)
    {
      this.bco = this.bbS[(this.bcp - 1)];
      this.bcp = 0;
    }
    if (paramBoolean)
    {
      rd();
      AppMethodBeat.o(96002);
      return;
    }
    this.bbZ = -9223372036854775807L;
    AppMethodBeat.o(96002);
  }
  
  public final void d(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(96007);
    if (paramInt == 1)
    {
      Object localObject = (Surface)paramObject;
      paramObject = localObject;
      if (localObject == null)
      {
        if (this.bbW != null) {
          paramObject = this.bbW;
        }
      }
      else
      {
        if (this.axw == paramObject) {
          break label208;
        }
        this.axw = paramObject;
        paramInt = this.state;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = this.aMR;
          if ((x.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.bbV)) {
            break label182;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
      }
      for (;;)
      {
        if ((paramObject == null) || (paramObject == this.bbW)) {
          break label193;
        }
        ri();
        re();
        if (paramInt != 2) {
          break label201;
        }
        rd();
        AppMethodBeat.o(96007);
        return;
        com.google.android.exoplayer2.e.a locala = this.aMS;
        paramObject = localObject;
        if (locala == null) {
          break;
        }
        paramObject = localObject;
        if (!aM(locala.aMF)) {
          break;
        }
        this.bbW = DummySurface.i(this.context, locala.aMF);
        paramObject = this.bbW;
        break;
        label182:
        oD();
        oC();
      }
      label193:
      rg();
      re();
      label201:
      AppMethodBeat.o(96007);
      return;
      label208:
      if ((paramObject != null) && (paramObject != this.bbW))
      {
        ri();
        if (this.bbY) {
          this.bbO.d(this.axw);
        }
      }
      AppMethodBeat.o(96007);
      return;
    }
    if (paramInt == 4)
    {
      this.bbX = ((Integer)paramObject).intValue();
      paramObject = this.aMR;
      if (paramObject != null) {
        paramObject.setVideoScalingMode(this.bbX);
      }
      AppMethodBeat.o(96007);
      return;
    }
    super.d(paramInt, paramObject);
    AppMethodBeat.o(96007);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96011);
    e.a locala = this.bbO;
    if (locala.bcH != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(x.DEVICE)) && (!"flo".equals(x.DEVICE))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.DEVICE)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bbV = bool;
      AppMethodBeat.o(96011);
      return;
    }
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(96012);
    super.e(paramFormat);
    e.a locala = this.bbO;
    if (locala.bcH != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.awQ == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.awQ)
    {
      this.bce = f;
      this.bcd = m(paramFormat);
      AppMethodBeat.o(96012);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(96003);
    if ((super.isReady()) && ((this.bbY) || ((this.bbW != null) && (this.axw == this.bbW)) || (this.aMR == null) || (this.azz)))
    {
      this.bbZ = -9223372036854775807L;
      AppMethodBeat.o(96003);
      return true;
    }
    if (this.bbZ == -9223372036854775807L)
    {
      AppMethodBeat.o(96003);
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.bbZ)
    {
      AppMethodBeat.o(96003);
      return true;
    }
    this.bbZ = -9223372036854775807L;
    AppMethodBeat.o(96003);
    return false;
  }
  
  public final void mF()
  {
    AppMethodBeat.i(96006);
    this.bcf = -1;
    this.bcg = -1;
    this.bci = -1.0F;
    this.bce = -1.0F;
    this.bco = -9223372036854775807L;
    this.bcp = 0;
    rg();
    re();
    d locald = this.bbN;
    if (locald.bct) {
      locald.bcs.handler.sendEmptyMessage(2);
    }
    this.bcn = null;
    this.azz = false;
    try
    {
      super.mF();
      return;
    }
    finally
    {
      this.bbO.e(this.aNp);
      AppMethodBeat.o(96006);
    }
  }
  
  public final void oD()
  {
    AppMethodBeat.i(96010);
    try
    {
      super.oD();
      return;
    }
    finally
    {
      if (this.bbW != null)
      {
        if (this.axw == this.bbW) {
          this.axw = null;
        }
        this.bbW.release();
        this.bbW = null;
      }
      AppMethodBeat.o(96010);
    }
    AppMethodBeat.o(96010);
  }
  
  public final void oF()
  {
    AppMethodBeat.i(96013);
    if ((x.SDK_INT < 23) && (this.azz)) {
      rf();
    }
    AppMethodBeat.o(96013);
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(96014);
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0) {
        break label187;
      }
      j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
      label71:
      this.bcf = j;
      if (i == 0) {
        break label199;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label99:
      this.bcg = i;
      this.bci = this.bce;
      if (x.SDK_INT < 21) {
        break label210;
      }
      if ((this.bcd == 90) || (this.bcd == 270))
      {
        i = this.bcf;
        this.bcf = this.bcg;
        this.bcg = i;
        this.bci = (1.0F / this.bci);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.bbX);
      AppMethodBeat.o(96014);
      return;
      i = 0;
      break;
      label187:
      j = paramMediaFormat.getInteger("width");
      break label71;
      label199:
      i = paramMediaFormat.getInteger("height");
      break label99;
      label210:
      this.bch = this.bcd;
    }
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(96004);
    super.onStarted();
    this.bcb = 0;
    this.bca = SystemClock.elapsedRealtime();
    AppMethodBeat.o(96004);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(96005);
    this.bbZ = -9223372036854775807L;
    rj();
    super.onStopped();
    AppMethodBeat.o(96005);
  }
  
  final void rf()
  {
    AppMethodBeat.i(96023);
    if (!this.bbY)
    {
      this.bbY = true;
      this.bbO.d(this.axw);
    }
    AppMethodBeat.o(96023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */