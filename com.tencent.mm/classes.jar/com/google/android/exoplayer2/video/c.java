package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
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
  private static final int[] bxu = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private int aTz;
  private boolean aVF;
  private final long[] bxA;
  private Format[] bxB;
  private a bxC;
  private boolean bxD;
  private Surface bxE;
  private int bxF;
  private boolean bxG;
  private long bxH;
  private long bxI;
  private int bxJ;
  private int bxK;
  private int bxL;
  private float bxM;
  private int bxN;
  private int bxO;
  private int bxP;
  private float bxQ;
  private int bxR;
  private int bxS;
  private int bxT;
  private float bxU;
  b bxV;
  private long bxW;
  private int bxX;
  private final d bxv;
  private final e.a bxw;
  private final long bxx;
  private final int bxy;
  private final boolean bxz;
  private final Context context;
  private Surface surface;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, int paramInt)
  {
    super(2, paramc, paramb, false);
    AppMethodBeat.i(93269);
    this.bxx = paramLong;
    this.bxy = paramInt;
    this.context = paramContext.getApplicationContext();
    this.bxv = new d(paramContext);
    this.bxw = new e.a(paramHandler, parame);
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
    this.bxz = bool1;
    this.bxA = new long[10];
    this.bxW = -9223372036854775807L;
    this.bxH = -9223372036854775807L;
    this.bxN = -1;
    this.bxO = -1;
    this.bxQ = -1.0F;
    this.bxM = -1.0F;
    this.bxF = 1;
    vS();
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
      arrayOfInt = bxu;
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
          if (parama.biK != null) {
            break label213;
          }
          parama.ao("align.caps");
          localObject = null;
        }
        for (;;)
        {
          float f2 = paramFormat.aTc;
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
          localObject = parama.biK.getVideoCapabilities();
          if (localObject == null)
          {
            parama.ao("align.vCaps");
            localObject = null;
          }
          else
          {
            i1 = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
            int i4 = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
            localObject = new Point(x.bm(n, i1) * i1, x.bm(i2, i4) * i4);
          }
        }
      }
      int n = x.bm(i2, 16) * 16;
      i1 = x.bm(i1, 16) * 16;
      if (n * i1 <= com.google.android.exoplayer2.e.d.tC())
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
    v.beginSection("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.endSection();
    paramMediaCodec = this.bju;
    paramMediaCodec.aWU += 1;
    AppMethodBeat.o(93288);
  }
  
  @TargetApi(21)
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93290);
    vT();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    v.endSection();
    paramMediaCodec = this.bju;
    paramMediaCodec.aWT += 1;
    this.bxK = 0;
    vR();
    AppMethodBeat.o(93290);
  }
  
  private boolean aY(boolean paramBoolean)
  {
    AppMethodBeat.i(93291);
    if ((x.SDK_INT >= 23) && (!this.aVF) && ((!paramBoolean) || (DummySurface.ai(this.context))))
    {
      AppMethodBeat.o(93291);
      return true;
    }
    AppMethodBeat.o(93291);
    return false;
  }
  
  private static boolean as(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private void b(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(93289);
    vT();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.endSection();
    paramMediaCodec = this.bju;
    paramMediaCodec.aWT += 1;
    this.bxK = 0;
    vR();
    AppMethodBeat.o(93289);
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(93301);
    if ((paramFormat1.aSY.equals(paramFormat2.aSY)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))))
    {
      AppMethodBeat.o(93301);
      return true;
    }
    AppMethodBeat.o(93301);
    return false;
  }
  
  private static int e(String paramString, int paramInt1, int paramInt2)
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
      if ("BRAVIA 4K 2015".equals(x.MODEL))
      {
        AppMethodBeat.o(93300);
        return -1;
      }
      paramInt1 = x.bm(paramInt1, 16) * x.bm(paramInt2, 16) * 16 * 16;
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
    if (paramFormat.aSZ != -1)
    {
      int k = paramFormat.aTa.size();
      int j = 0;
      i = 0;
      while (j < k)
      {
        i += ((byte[])paramFormat.aTa.get(j)).length;
        j += 1;
      }
      j = paramFormat.aSZ;
      AppMethodBeat.o(93299);
      return j + i;
    }
    int i = e(paramFormat.aSY, paramFormat.width, paramFormat.height);
    AppMethodBeat.o(93299);
    return i;
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.aTd == -1) {
      return 0;
    }
    return paramFormat.aTd;
  }
  
  private void vP()
  {
    AppMethodBeat.i(93292);
    if (this.bxx > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.bxx;; l = -9223372036854775807L)
    {
      this.bxH = l;
      AppMethodBeat.o(93292);
      return;
    }
  }
  
  private void vQ()
  {
    AppMethodBeat.i(93293);
    this.bxG = false;
    if ((x.SDK_INT >= 23) && (this.aVF))
    {
      MediaCodec localMediaCodec = this.biV;
      if (localMediaCodec != null) {
        this.bxV = new b(localMediaCodec, (byte)0);
      }
    }
    AppMethodBeat.o(93293);
  }
  
  private void vS()
  {
    this.bxR = -1;
    this.bxS = -1;
    this.bxU = -1.0F;
    this.bxT = -1;
  }
  
  private void vT()
  {
    AppMethodBeat.i(93295);
    if (((this.bxN != -1) || (this.bxO != -1)) && ((this.bxR != this.bxN) || (this.bxS != this.bxO) || (this.bxT != this.bxP) || (this.bxU != this.bxQ)))
    {
      this.bxw.b(this.bxN, this.bxO, this.bxP, this.bxQ);
      this.bxR = this.bxN;
      this.bxS = this.bxO;
      this.bxT = this.bxP;
      this.bxU = this.bxQ;
    }
    AppMethodBeat.o(93295);
  }
  
  private void vU()
  {
    AppMethodBeat.i(93296);
    if ((this.bxR != -1) || (this.bxS != -1)) {
      this.bxw.b(this.bxR, this.bxS, this.bxT, this.bxU);
    }
    AppMethodBeat.o(93296);
  }
  
  private void vV()
  {
    AppMethodBeat.i(93297);
    if (this.bxJ > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.bxI;
      this.bxw.l(this.bxJ, l1 - l2);
      this.bxJ = 0;
      this.bxI = l1;
    }
    AppMethodBeat.o(93297);
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    AppMethodBeat.i(93270);
    String str = paramFormat.aSY;
    if (!j.aF(str))
    {
      AppMethodBeat.o(93270);
      return 0;
    }
    Object localObject = paramFormat.aTb;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).aXk) {
          break;
        }
        bool1 |= localObject.aXj[i].aXl;
        i += 1;
      }
    }
    boolean bool2 = false;
    paramc = paramc.f(str, bool2);
    if (paramc == null)
    {
      AppMethodBeat.o(93270);
      return 1;
    }
    str = paramFormat.aSV;
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
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.aTc);
          }
        }
      }
      if (!paramc.biI) {
        break label521;
      }
      i = 16;
      label197:
      if (paramc.aVF) {
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
      localObject = j.aH(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.ao("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.ap(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.tv();
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
      paramc.ao("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      label432:
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.tC()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(x.bxc).append("]");
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
    vQ();
    this.bxK = 0;
    if (this.bxX != 0)
    {
      this.bxW = this.bxA[(this.bxX - 1)];
      this.bxX = 0;
    }
    if (paramBoolean)
    {
      vP();
      AppMethodBeat.o(93273);
      return;
    }
    this.bxH = -9223372036854775807L;
    AppMethodBeat.o(93273);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(93280);
    Object localObject = this.bxB;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new a(k, j, i);
      this.bxC = ((a)localObject);
      localObject = this.bxC;
      boolean bool = this.bxz;
      i = this.aTz;
      paramFormat = paramFormat.rS();
      paramFormat.setInteger("max-width", ((a)localObject).width);
      paramFormat.setInteger("max-height", ((a)localObject).height);
      if (((a)localObject).bxY != -1) {
        paramFormat.setInteger("max-input-size", ((a)localObject).bxY);
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
        com.google.android.exoplayer2.i.a.checkState(aY(parama.biJ));
        if (this.bxE == null) {
          this.bxE = DummySurface.j(this.context, parama.biJ);
        }
        this.surface = this.bxE;
      }
      paramMediaCodec.configure(paramFormat, this.surface, paramMediaCrypto, 0);
      if ((x.SDK_INT >= 23) && (this.aVF)) {
        this.bxV = new b(paramMediaCodec, (byte)0);
      }
      AppMethodBeat.o(93280);
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
      if (!b(parama.biI, paramFormat, localFormat)) {
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
          i2 = Math.max(i, e(paramFormat.aSY, n, i1));
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
    this.bxB = paramArrayOfFormat;
    if (this.bxW == -9223372036854775807L)
    {
      this.bxW = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      AppMethodBeat.o(93272);
      return;
    }
    if (this.bxX == this.bxA.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.bxA[(this.bxX - 1)]);
    }
    for (;;)
    {
      this.bxA[(this.bxX - 1)] = paramLong;
      break;
      this.bxX += 1;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(93287);
    while ((this.bxX != 0) && (paramLong3 >= this.bxA[0]))
    {
      this.bxW = this.bxA[0];
      this.bxX -= 1;
      System.arraycopy(this.bxA, 1, this.bxA, 0, this.bxX);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      AppMethodBeat.o(93287);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.surface == this.bxE)
    {
      if (as(paramLong1))
      {
        a(paramMediaCodec, paramInt1);
        AppMethodBeat.o(93287);
        return true;
      }
      AppMethodBeat.o(93287);
      return false;
    }
    if (!this.bxG)
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
    if (this.state != 2)
    {
      AppMethodBeat.o(93287);
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l3 = System.nanoTime();
    l1 = l3 + (paramLong1 - (l1 * 1000L - paramLong2)) * 1000L;
    paramByteBuffer = this.bxv;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.byh)
    {
      if (paramLong3 != paramByteBuffer.bye)
      {
        paramByteBuffer.byk += 1L;
        paramByteBuffer.byf = paramByteBuffer.byg;
      }
      if (paramByteBuffer.byk >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.byj) / paramByteBuffer.byk;
        paramLong2 = paramByteBuffer.byf + paramLong1;
        if (paramByteBuffer.m(paramLong2, l1))
        {
          paramByteBuffer.byh = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.byh)
      {
        paramByteBuffer.byj = l2;
        paramByteBuffer.byi = l1;
        paramByteBuffer.byk = 0L;
        paramByteBuffer.byh = true;
      }
      paramByteBuffer.bye = paramLong3;
      paramByteBuffer.byg = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.bya != null)
      {
        if (paramByteBuffer.bya.byl != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!as(paramLong1)) {
        break label650;
      }
      v.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      v.endSection();
      paramMediaCodec = this.bju;
      paramMediaCodec.aWV += 1;
      this.bxJ += 1;
      this.bxK += 1;
      this.bju.aWW = Math.max(this.bxK, this.bju.aWW);
      if (this.bxJ == this.bxy) {
        vV();
      }
      AppMethodBeat.o(93287);
      return true;
      paramLong1 = paramByteBuffer.byi + paramLong2 - paramByteBuffer.byj;
      continue;
      if (paramByteBuffer.m(l2, l1)) {
        paramByteBuffer.byh = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.bya.byl;
    paramLong3 = paramByteBuffer.byc;
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
      paramLong2 -= paramByteBuffer.byd;
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
    if ((this.surface != null) || (aY(parama.biJ)))
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
    if ((b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.bxC.width) && (paramFormat2.height <= this.bxC.height) && (l(paramFormat2) <= this.bxC.bxY))
    {
      AppMethodBeat.o(93286);
      return true;
    }
    AppMethodBeat.o(93286);
    return false;
  }
  
  public final void aN(boolean paramBoolean)
  {
    AppMethodBeat.i(93271);
    super.aN(paramBoolean);
    this.aTz = this.aRm.aTz;
    if (this.aTz != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aVF = paramBoolean;
      Object localObject = this.bxw;
      com.google.android.exoplayer2.b.d locald = this.bju;
      if (((e.a)localObject).byp != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.bxv;
      ((d)localObject).byh = false;
      if (((d)localObject).byb) {
        ((d)localObject).bya.handler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(93271);
      return;
    }
  }
  
  public final void c(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(93278);
    if (paramInt == 1)
    {
      Object localObject = (Surface)paramObject;
      paramObject = localObject;
      if (localObject == null)
      {
        if (this.bxE != null) {
          paramObject = this.bxE;
        }
      }
      else
      {
        if (this.surface == paramObject) {
          break label208;
        }
        this.surface = paramObject;
        paramInt = this.state;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = this.biV;
          if ((x.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.bxD)) {
            break label182;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
      }
      for (;;)
      {
        if ((paramObject == null) || (paramObject == this.bxE)) {
          break label193;
        }
        vU();
        vQ();
        if (paramInt != 2) {
          break label201;
        }
        vP();
        AppMethodBeat.o(93278);
        return;
        com.google.android.exoplayer2.e.a locala = this.biW;
        paramObject = localObject;
        if (locala == null) {
          break;
        }
        paramObject = localObject;
        if (!aY(locala.biJ)) {
          break;
        }
        this.bxE = DummySurface.j(this.context, locala.biJ);
        paramObject = this.bxE;
        break;
        label182:
        tx();
        tw();
      }
      label193:
      vS();
      vQ();
      label201:
      AppMethodBeat.o(93278);
      return;
      label208:
      if ((paramObject != null) && (paramObject != this.bxE))
      {
        vU();
        if (this.bxG) {
          this.bxw.d(this.surface);
        }
      }
      AppMethodBeat.o(93278);
      return;
    }
    if (paramInt == 4)
    {
      this.bxF = ((Integer)paramObject).intValue();
      paramObject = this.biV;
      if (paramObject != null) {
        paramObject.setVideoScalingMode(this.bxF);
      }
      AppMethodBeat.o(93278);
      return;
    }
    super.c(paramInt, paramObject);
    AppMethodBeat.o(93278);
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93282);
    e.a locala = this.bxw;
    if (locala.byp != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(x.DEVICE)) && (!"flo".equals(x.DEVICE))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.DEVICE)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bxD = bool;
      AppMethodBeat.o(93282);
      return;
    }
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(93283);
    super.e(paramFormat);
    e.a locala = this.bxw;
    if (locala.byp != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.aTe == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.aTe)
    {
      this.bxM = f;
      this.bxL = m(paramFormat);
      AppMethodBeat.o(93283);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(93274);
    if ((super.isReady()) && ((this.bxG) || ((this.bxE != null) && (this.surface == this.bxE)) || (this.biV == null) || (this.aVF)))
    {
      this.bxH = -9223372036854775807L;
      AppMethodBeat.o(93274);
      return true;
    }
    if (this.bxH == -9223372036854775807L)
    {
      AppMethodBeat.o(93274);
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.bxH)
    {
      AppMethodBeat.o(93274);
      return true;
    }
    this.bxH = -9223372036854775807L;
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
      this.bxN = j;
      if (i == 0) {
        break label199;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label99:
      this.bxO = i;
      this.bxQ = this.bxM;
      if (x.SDK_INT < 21) {
        break label210;
      }
      if ((this.bxL == 90) || (this.bxL == 270))
      {
        i = this.bxN;
        this.bxN = this.bxO;
        this.bxO = i;
        this.bxQ = (1.0F / this.bxQ);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.bxF);
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
      this.bxP = this.bxL;
    }
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(93275);
    super.onStarted();
    this.bxJ = 0;
    this.bxI = SystemClock.elapsedRealtime();
    AppMethodBeat.o(93275);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(93276);
    this.bxH = -9223372036854775807L;
    vV();
    super.onStopped();
    AppMethodBeat.o(93276);
  }
  
  public final void rA()
  {
    AppMethodBeat.i(93277);
    this.bxN = -1;
    this.bxO = -1;
    this.bxQ = -1.0F;
    this.bxM = -1.0F;
    this.bxW = -9223372036854775807L;
    this.bxX = 0;
    vS();
    vQ();
    d locald = this.bxv;
    if (locald.byb) {
      locald.bya.handler.sendEmptyMessage(2);
    }
    this.bxV = null;
    this.aVF = false;
    try
    {
      super.rA();
      return;
    }
    finally
    {
      this.bxw.e(this.bju);
      AppMethodBeat.o(93277);
    }
  }
  
  public final void tx()
  {
    AppMethodBeat.i(93281);
    try
    {
      super.tx();
      return;
    }
    finally
    {
      if (this.bxE != null)
      {
        if (this.surface == this.bxE) {
          this.surface = null;
        }
        this.bxE.release();
        this.bxE = null;
      }
      AppMethodBeat.o(93281);
    }
    AppMethodBeat.o(93281);
  }
  
  public final void tz()
  {
    AppMethodBeat.i(93284);
    if ((x.SDK_INT < 23) && (this.aVF)) {
      vR();
    }
    AppMethodBeat.o(93284);
  }
  
  final void vR()
  {
    AppMethodBeat.i(93294);
    if (!this.bxG)
    {
      this.bxG = true;
      this.bxw.d(this.surface);
    }
    AppMethodBeat.o(93294);
  }
  
  protected static final class a
  {
    public final int bxY;
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.bxY = paramInt3;
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
      if (this != c.this.bxV)
      {
        AppMethodBeat.o(93268);
        return;
      }
      c.this.vR();
      AppMethodBeat.o(93268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */