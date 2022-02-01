package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
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
  private static final int[] brI = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private int aNr;
  private boolean aPx;
  private final d brJ;
  private final e.a brK;
  private final long brL;
  private final int brM;
  private final boolean brN;
  private final long[] brO;
  private Format[] brP;
  private a brQ;
  private boolean brR;
  private Surface brS;
  private int brT;
  private boolean brU;
  private long brV;
  private long brW;
  private int brX;
  private int brY;
  private int brZ;
  private float bsa;
  private int bsb;
  private int bsc;
  private int bsd;
  private float bse;
  private int bsf;
  private int bsg;
  private int bsh;
  private float bsi;
  b bsj;
  private long bsk;
  private int bsl;
  private final Context context;
  private Surface surface;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, int paramInt)
  {
    super(2, paramc, paramb, false);
    AppMethodBeat.i(93269);
    this.brL = paramLong;
    this.brM = paramInt;
    this.context = paramContext.getApplicationContext();
    this.brJ = new d(paramContext);
    this.brK = new e.a(paramHandler, parame);
    boolean bool1 = bool2;
    if (x.SDK_INT <= 22)
    {
      bool1 = bool2;
      if ("foster".equals(x.bro))
      {
        bool1 = bool2;
        if ("NVIDIA".equals(x.brp)) {
          bool1 = true;
        }
      }
    }
    this.brN = bool1;
    this.brO = new long[10];
    this.bsk = -9223372036854775807L;
    this.brV = -9223372036854775807L;
    this.bsb = -1;
    this.bsc = -1;
    this.bse = -1.0F;
    this.bsa = -1.0F;
    this.brT = 1;
    vA();
    AppMethodBeat.o(93269);
  }
  
  private static Point a(com.google.android.exoplayer2.e.a parama, Format paramFormat)
  {
    AppMethodBeat.i(93298);
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
      arrayOfInt = brI;
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
        AppMethodBeat.o(93298);
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
          if (parama.bcC != null) {
            break label213;
          }
          parama.bs("align.caps");
          localObject = null;
        }
        for (;;)
        {
          float f2 = paramFormat.aMU;
          if (!parama.a(((Point)localObject).x, ((Point)localObject).y, f2)) {
            break label367;
          }
          AppMethodBeat.o(93298);
          return localObject;
          n = i2;
          break;
          label206:
          i2 = i1;
          break label151;
          label213:
          localObject = parama.bcC.getVideoCapabilities();
          if (localObject == null)
          {
            parama.bs("align.vCaps");
            localObject = null;
          }
          else
          {
            i1 = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
            int i4 = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
            localObject = new Point(x.bq(n, i1) * i1, x.bq(i2, i4) * i4);
          }
        }
      }
      int n = x.bq(i2, 16) * 16;
      i1 = x.bq(i1, 16) * 16;
      if (n * i1 <= com.google.android.exoplayer2.e.d.td())
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
          AppMethodBeat.o(93298);
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
    AppMethodBeat.o(93298);
    return null;
  }
  
  private void a(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(93288);
    v.D("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.gH();
    paramMediaCodec = this.bdm;
    paramMediaCodec.aQQ += 1;
    AppMethodBeat.o(93288);
  }
  
  @TargetApi(21)
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93290);
    vB();
    v.D("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    v.gH();
    paramMediaCodec = this.bdm;
    paramMediaCodec.aQP += 1;
    this.brY = 0;
    vz();
    AppMethodBeat.o(93290);
  }
  
  private boolean aW(boolean paramBoolean)
  {
    AppMethodBeat.i(93291);
    if ((x.SDK_INT >= 23) && (!this.aPx) && ((!paramBoolean) || (DummySurface.ac(this.context))))
    {
      AppMethodBeat.o(93291);
      return true;
    }
    AppMethodBeat.o(93291);
    return false;
  }
  
  private static boolean aw(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private void b(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(93289);
    vB();
    v.D("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.gH();
    paramMediaCodec = this.bdm;
    paramMediaCodec.aQP += 1;
    this.brY = 0;
    vz();
    AppMethodBeat.o(93289);
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(93301);
    if ((paramFormat1.aMQ.equals(paramFormat2.aMQ)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))))
    {
      AppMethodBeat.o(93301);
      return true;
    }
    AppMethodBeat.o(93301);
    return false;
  }
  
  private static int g(String paramString, int paramInt1, int paramInt2)
  {
    int j = 2;
    AppMethodBeat.i(93300);
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      AppMethodBeat.o(93300);
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
        AppMethodBeat.o(93300);
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
      AppMethodBeat.o(93300);
      return paramInt1;
      if ("BRAVIA 4K 2015".equals(x.brq))
      {
        AppMethodBeat.o(93300);
        return -1;
      }
      paramInt1 = x.bq(paramInt1, 16) * x.bq(paramInt2, 16) * 16 * 16;
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
    AppMethodBeat.i(93299);
    if (paramFormat.aMR != -1)
    {
      int k = paramFormat.aMS.size();
      int j = 0;
      i = 0;
      while (j < k)
      {
        i += ((byte[])paramFormat.aMS.get(j)).length;
        j += 1;
      }
      j = paramFormat.aMR;
      AppMethodBeat.o(93299);
      return j + i;
    }
    int i = g(paramFormat.aMQ, paramFormat.width, paramFormat.height);
    AppMethodBeat.o(93299);
    return i;
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.aMV == -1) {
      return 0;
    }
    return paramFormat.aMV;
  }
  
  private void vA()
  {
    this.bsf = -1;
    this.bsg = -1;
    this.bsi = -1.0F;
    this.bsh = -1;
  }
  
  private void vB()
  {
    AppMethodBeat.i(93295);
    if (((this.bsb != -1) || (this.bsc != -1)) && ((this.bsf != this.bsb) || (this.bsg != this.bsc) || (this.bsh != this.bsd) || (this.bsi != this.bse)))
    {
      this.brK.b(this.bsb, this.bsc, this.bsd, this.bse);
      this.bsf = this.bsb;
      this.bsg = this.bsc;
      this.bsh = this.bsd;
      this.bsi = this.bse;
    }
    AppMethodBeat.o(93295);
  }
  
  private void vC()
  {
    AppMethodBeat.i(93296);
    if ((this.bsf != -1) || (this.bsg != -1)) {
      this.brK.b(this.bsf, this.bsg, this.bsh, this.bsi);
    }
    AppMethodBeat.o(93296);
  }
  
  private void vD()
  {
    AppMethodBeat.i(93297);
    if (this.brX > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.brW;
      this.brK.m(this.brX, l1 - l2);
      this.brX = 0;
      this.brW = l1;
    }
    AppMethodBeat.o(93297);
  }
  
  private void vx()
  {
    AppMethodBeat.i(93292);
    if (this.brL > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.brL;; l = -9223372036854775807L)
    {
      this.brV = l;
      AppMethodBeat.o(93292);
      return;
    }
  }
  
  private void vy()
  {
    AppMethodBeat.i(93293);
    this.brU = false;
    if ((x.SDK_INT >= 23) && (this.aPx))
    {
      MediaCodec localMediaCodec = sW();
      if (localMediaCodec != null) {
        this.bsj = new b(localMediaCodec, (byte)0);
      }
    }
    AppMethodBeat.o(93293);
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    AppMethodBeat.i(93270);
    String str = paramFormat.aMQ;
    if (!j.bJ(str))
    {
      AppMethodBeat.o(93270);
      return 0;
    }
    Object localObject = paramFormat.aMT;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).aRh) {
          break;
        }
        bool1 |= localObject.aRg[i].aRj;
        i += 1;
      }
    }
    boolean bool2 = false;
    paramc = paramc.e(str, bool2);
    if (paramc == null)
    {
      AppMethodBeat.o(93270);
      return 1;
    }
    str = paramFormat.aMN;
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
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.aMU);
          }
        }
      }
      if (!paramc.bcA) {
        break label521;
      }
      i = 16;
      label197:
      if (paramc.aPx) {
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
      AppMethodBeat.o(93270);
      return j | i | k;
      localObject = j.bL(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.bs("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.bt(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.sU();
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
      paramc.bs("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      label432:
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.td()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(x.brr).append("]");
        bool2 = bool1;
        break;
      }
      i = 8;
      break label197;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93273);
    super.a(paramLong, paramBoolean);
    vy();
    this.brY = 0;
    if (this.bsl != 0)
    {
      this.bsk = this.brO[(this.bsl - 1)];
      this.bsl = 0;
    }
    if (paramBoolean)
    {
      vx();
      AppMethodBeat.o(93273);
      return;
    }
    this.brV = -9223372036854775807L;
    AppMethodBeat.o(93273);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat)
  {
    AppMethodBeat.i(201335);
    Object localObject = this.brP;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new a(k, j, i);
      this.brQ = ((a)localObject);
      localObject = this.brQ;
      boolean bool = this.brN;
      i = this.aNr;
      paramFormat = paramFormat.rq();
      paramFormat.setInteger("max-width", ((a)localObject).width);
      paramFormat.setInteger("max-height", ((a)localObject).height);
      if (((a)localObject).bsm != -1) {
        paramFormat.setInteger("max-input-size", ((a)localObject).bsm);
      }
      if (bool) {
        paramFormat.setInteger("auto-frc", 0);
      }
      if (i != 0)
      {
        paramFormat.setFeatureEnabled("tunneled-playback", true);
        paramFormat.setInteger("audio-session-id", i);
      }
      if (this.surface == null)
      {
        com.google.android.exoplayer2.i.a.checkState(aW(parama.bcB));
        if (this.brS == null) {
          this.brS = DummySurface.i(this.context, parama.bcB);
        }
        this.surface = this.brS;
      }
      paramMediaCodec.configure(paramFormat, this.surface, null, 0);
      if ((x.SDK_INT >= 23) && (this.aPx)) {
        this.bsj = new b(paramMediaCodec, (byte)0);
      }
      AppMethodBeat.o(201335);
      return;
    }
    int m = 0;
    int i2 = localObject.length;
    int n = 0;
    label267:
    int i1;
    if (n < i2)
    {
      Format localFormat = localObject[n];
      if (!b(parama.bcA, paramFormat, localFormat)) {
        break label528;
      }
      if ((localFormat.width == -1) || (localFormat.height == -1))
      {
        i1 = 1;
        label315:
        m = i1 | m;
        k = Math.max(k, localFormat.width);
        j = Math.max(j, localFormat.height);
        i = Math.max(i, l(localFormat));
      }
    }
    label528:
    for (;;)
    {
      n += 1;
      break label267;
      i1 = 0;
      break label315;
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
          i2 = Math.max(i, g(paramFormat.aMQ, n, i1));
          new StringBuilder("Codec max resolution adjusted to: ").append(n).append("x").append(i1);
        }
      }
      localObject = new a(n, i1, i2);
      break;
    }
  }
  
  public final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    AppMethodBeat.i(93272);
    this.brP = paramArrayOfFormat;
    if (this.bsk == -9223372036854775807L)
    {
      this.bsk = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      AppMethodBeat.o(93272);
      return;
    }
    if (this.bsl == this.brO.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.brO[(this.bsl - 1)]);
    }
    for (;;)
    {
      this.brO[(this.bsl - 1)] = paramLong;
      break;
      this.bsl += 1;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(93287);
    while ((this.bsl != 0) && (paramLong3 >= this.brO[0]))
    {
      this.bsk = this.brO[0];
      this.bsl -= 1;
      System.arraycopy(this.brO, 1, this.brO, 0, this.bsl);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      AppMethodBeat.o(93287);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.surface == this.brS)
    {
      if (aw(paramLong1))
      {
        a(paramMediaCodec, paramInt1);
        AppMethodBeat.o(93287);
        return true;
      }
      AppMethodBeat.o(93287);
      return false;
    }
    if (!this.brU)
    {
      if (x.SDK_INT >= 21) {
        a(paramMediaCodec, paramInt1, System.nanoTime());
      }
      for (;;)
      {
        AppMethodBeat.o(93287);
        return true;
        b(paramMediaCodec, paramInt1);
      }
    }
    if (getState() != 2)
    {
      AppMethodBeat.o(93287);
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l3 = System.nanoTime();
    l1 = l3 + (paramLong1 - (l1 * 1000L - paramLong2)) * 1000L;
    paramByteBuffer = this.brJ;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.bsv)
    {
      if (paramLong3 != paramByteBuffer.bss)
      {
        paramByteBuffer.bsy += 1L;
        paramByteBuffer.bst = paramByteBuffer.bsu;
      }
      if (paramByteBuffer.bsy >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.bsx) / paramByteBuffer.bsy;
        paramLong2 = paramByteBuffer.bst + paramLong1;
        if (paramByteBuffer.n(paramLong2, l1))
        {
          paramByteBuffer.bsv = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.bsv)
      {
        paramByteBuffer.bsx = l2;
        paramByteBuffer.bsw = l1;
        paramByteBuffer.bsy = 0L;
        paramByteBuffer.bsv = true;
      }
      paramByteBuffer.bss = paramLong3;
      paramByteBuffer.bsu = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.bso != null)
      {
        if (paramByteBuffer.bso.bsz != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!aw(paramLong1)) {
        break label650;
      }
      v.D("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      v.gH();
      paramMediaCodec = this.bdm;
      paramMediaCodec.aQR += 1;
      this.brX += 1;
      this.brY += 1;
      this.bdm.aQS = Math.max(this.brY, this.bdm.aQS);
      if (this.brX == this.brM) {
        vD();
      }
      AppMethodBeat.o(93287);
      return true;
      paramLong1 = paramByteBuffer.bsw + paramLong2 - paramByteBuffer.bsx;
      continue;
      if (paramByteBuffer.n(l2, l1)) {
        paramByteBuffer.bsv = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.bso.bsz;
    paramLong3 = paramByteBuffer.bsq;
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
      paramLong2 -= paramByteBuffer.bsr;
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
        AppMethodBeat.o(93287);
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
        AppMethodBeat.o(93287);
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
    AppMethodBeat.o(93287);
    return false;
  }
  
  public final boolean a(com.google.android.exoplayer2.e.a parama)
  {
    AppMethodBeat.i(93279);
    if ((this.surface != null) || (aW(parama.bcB)))
    {
      AppMethodBeat.o(93279);
      return true;
    }
    AppMethodBeat.o(93279);
    return false;
  }
  
  public final boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(93286);
    if ((b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.brQ.width) && (paramFormat2.height <= this.brQ.height) && (l(paramFormat2) <= this.brQ.bsm))
    {
      AppMethodBeat.o(93286);
      return true;
    }
    AppMethodBeat.o(93286);
    return false;
  }
  
  public final void aL(boolean paramBoolean)
  {
    AppMethodBeat.i(93271);
    super.aL(paramBoolean);
    this.aNr = qV().aNr;
    if (this.aNr != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aPx = paramBoolean;
      Object localObject = this.brK;
      com.google.android.exoplayer2.b.d locald = this.bdm;
      if (((e.a)localObject).bsD != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.brJ;
      ((d)localObject).bsv = false;
      if (((d)localObject).bsp) {
        ((d)localObject).bso.handler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(93271);
      return;
    }
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93282);
    e.a locala = this.brK;
    if (locala.bsD != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(x.bro)) && (!"flo".equals(x.bro))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.bro)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.brR = bool;
      AppMethodBeat.o(93282);
      return;
    }
  }
  
  public final void e(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(93278);
    if (paramInt == 1)
    {
      Object localObject = (Surface)paramObject;
      paramObject = localObject;
      if (localObject == null)
      {
        if (this.brS != null) {
          paramObject = this.brS;
        }
      }
      else
      {
        if (this.surface == paramObject) {
          break label208;
        }
        this.surface = paramObject;
        paramInt = getState();
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = sW();
          if ((x.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.brR)) {
            break label182;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
      }
      for (;;)
      {
        if ((paramObject == null) || (paramObject == this.brS)) {
          break label193;
        }
        vC();
        vy();
        if (paramInt != 2) {
          break label201;
        }
        vx();
        AppMethodBeat.o(93278);
        return;
        com.google.android.exoplayer2.e.a locala = sX();
        paramObject = localObject;
        if (locala == null) {
          break;
        }
        paramObject = localObject;
        if (!aW(locala.bcB)) {
          break;
        }
        this.brS = DummySurface.i(this.context, locala.bcB);
        paramObject = this.brS;
        break;
        label182:
        sY();
        sV();
      }
      label193:
      vA();
      vy();
      label201:
      AppMethodBeat.o(93278);
      return;
      label208:
      if ((paramObject != null) && (paramObject != this.brS))
      {
        vC();
        if (this.brU) {
          this.brK.d(this.surface);
        }
      }
      AppMethodBeat.o(93278);
      return;
    }
    if (paramInt == 4)
    {
      this.brT = ((Integer)paramObject).intValue();
      paramObject = sW();
      if (paramObject != null) {
        paramObject.setVideoScalingMode(this.brT);
      }
      AppMethodBeat.o(93278);
      return;
    }
    super.e(paramInt, paramObject);
    AppMethodBeat.o(93278);
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(93283);
    super.e(paramFormat);
    e.a locala = this.brK;
    if (locala.bsD != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.aMW == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.aMW)
    {
      this.bsa = f;
      this.brZ = m(paramFormat);
      AppMethodBeat.o(93283);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(93274);
    if ((super.isReady()) && ((this.brU) || ((this.brS != null) && (this.surface == this.brS)) || (sW() == null) || (this.aPx)))
    {
      this.brV = -9223372036854775807L;
      AppMethodBeat.o(93274);
      return true;
    }
    if (this.brV == -9223372036854775807L)
    {
      AppMethodBeat.o(93274);
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.brV)
    {
      AppMethodBeat.o(93274);
      return true;
    }
    this.brV = -9223372036854775807L;
    AppMethodBeat.o(93274);
    return false;
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93285);
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
      this.bsb = j;
      if (i == 0) {
        break label199;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label99:
      this.bsc = i;
      this.bse = this.bsa;
      if (x.SDK_INT < 21) {
        break label210;
      }
      if ((this.brZ == 90) || (this.brZ == 270))
      {
        i = this.bsb;
        this.bsb = this.bsc;
        this.bsc = i;
        this.bse = (1.0F / this.bse);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.brT);
      AppMethodBeat.o(93285);
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
      this.bsd = this.brZ;
    }
  }
  
  public final void qS()
  {
    AppMethodBeat.i(93275);
    super.qS();
    this.brX = 0;
    this.brW = SystemClock.elapsedRealtime();
    AppMethodBeat.o(93275);
  }
  
  public final void qT()
  {
    AppMethodBeat.i(93276);
    this.brV = -9223372036854775807L;
    vD();
    super.qT();
    AppMethodBeat.o(93276);
  }
  
  public final void qU()
  {
    AppMethodBeat.i(93277);
    this.bsb = -1;
    this.bsc = -1;
    this.bse = -1.0F;
    this.bsa = -1.0F;
    this.bsk = -9223372036854775807L;
    this.bsl = 0;
    vA();
    vy();
    d locald = this.brJ;
    if (locald.bsp) {
      locald.bso.handler.sendEmptyMessage(2);
    }
    this.bsj = null;
    this.aPx = false;
    try
    {
      super.qU();
      return;
    }
    finally
    {
      this.brK.e(this.bdm);
      AppMethodBeat.o(93277);
    }
  }
  
  public final void sY()
  {
    AppMethodBeat.i(93281);
    try
    {
      super.sY();
      return;
    }
    finally
    {
      if (this.brS != null)
      {
        if (this.surface == this.brS) {
          this.surface = null;
        }
        this.brS.release();
        this.brS = null;
      }
      AppMethodBeat.o(93281);
    }
    AppMethodBeat.o(93281);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(93284);
    if ((x.SDK_INT < 23) && (this.aPx)) {
      vz();
    }
    AppMethodBeat.o(93284);
  }
  
  final void vz()
  {
    AppMethodBeat.i(93294);
    if (!this.brU)
    {
      this.brU = true;
      this.brK.d(this.surface);
    }
    AppMethodBeat.o(93294);
  }
  
  protected static final class a
  {
    public final int bsm;
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.bsm = paramInt3;
    }
  }
  
  @TargetApi(23)
  final class b
    implements MediaCodec.OnFrameRenderedListener
  {
    private b(MediaCodec paramMediaCodec)
    {
      AppMethodBeat.i(93267);
      paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
      AppMethodBeat.o(93267);
    }
    
    public final void onFrameRendered(MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(93268);
      if (this != c.this.bsj)
      {
        AppMethodBeat.o(93268);
        return;
      }
      c.this.vz();
      AppMethodBeat.o(93268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */