package com.google.android.exoplayer2.video;

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

public final class c
  extends com.google.android.exoplayer2.e.b
{
  private static final int[] dlk = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private int cHn;
  private boolean cJt;
  private final Context context;
  private int dlA;
  private int dlB;
  private float dlC;
  private int dlD;
  private int dlE;
  private int dlF;
  private float dlG;
  private int dlH;
  private int dlI;
  private int dlJ;
  private float dlK;
  b dlL;
  private long dlM;
  private int dlN;
  private final d dll;
  private final e.a dlm;
  private final long dln;
  private final int dlo;
  private final boolean dlp;
  private final long[] dlq;
  private Format[] dlr;
  private a dls;
  private boolean dlt;
  private Surface dlu;
  private int dlv;
  private boolean dlw;
  private long dlx;
  private long dly;
  private int dlz;
  private Surface surface;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, int paramInt)
  {
    super(2, paramc, paramb, false);
    AppMethodBeat.i(93269);
    this.dln = paramLong;
    this.dlo = paramInt;
    this.context = paramContext.getApplicationContext();
    this.dll = new d(paramContext);
    this.dlm = new e.a(paramHandler, parame);
    boolean bool1 = bool2;
    if (x.SDK_INT <= 22)
    {
      bool1 = bool2;
      if ("foster".equals(x.dkS))
      {
        bool1 = bool2;
        if ("NVIDIA".equals(x.MANUFACTURER)) {
          bool1 = true;
        }
      }
    }
    this.dlp = bool1;
    this.dlq = new long[10];
    this.dlM = -9223372036854775807L;
    this.dlx = -9223372036854775807L;
    this.dlD = -1;
    this.dlE = -1;
    this.dlG = -1.0F;
    this.dlC = -1.0F;
    this.dlv = 1;
    UZ();
    AppMethodBeat.o(93269);
  }
  
  private void UW()
  {
    AppMethodBeat.i(93292);
    if (this.dln > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.dln;; l = -9223372036854775807L)
    {
      this.dlx = l;
      AppMethodBeat.o(93292);
      return;
    }
  }
  
  private void UX()
  {
    AppMethodBeat.i(93293);
    this.dlw = false;
    if ((x.SDK_INT >= 23) && (this.cJt))
    {
      MediaCodec localMediaCodec = getCodec();
      if (localMediaCodec != null) {
        this.dlL = new b(localMediaCodec, (byte)0);
      }
    }
    AppMethodBeat.o(93293);
  }
  
  private void UZ()
  {
    this.dlH = -1;
    this.dlI = -1;
    this.dlK = -1.0F;
    this.dlJ = -1;
  }
  
  private void Va()
  {
    AppMethodBeat.i(93295);
    if (((this.dlD != -1) || (this.dlE != -1)) && ((this.dlH != this.dlD) || (this.dlI != this.dlE) || (this.dlJ != this.dlF) || (this.dlK != this.dlG)))
    {
      this.dlm.c(this.dlD, this.dlE, this.dlF, this.dlG);
      this.dlH = this.dlD;
      this.dlI = this.dlE;
      this.dlJ = this.dlF;
      this.dlK = this.dlG;
    }
    AppMethodBeat.o(93295);
  }
  
  private void Vb()
  {
    AppMethodBeat.i(93296);
    if ((this.dlH != -1) || (this.dlI != -1)) {
      this.dlm.c(this.dlH, this.dlI, this.dlJ, this.dlK);
    }
    AppMethodBeat.o(93296);
  }
  
  private void Vc()
  {
    AppMethodBeat.i(93297);
    if (this.dlz > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.dly;
      this.dlm.m(this.dlz, l1 - l2);
      this.dlz = 0;
      this.dly = l1;
    }
    AppMethodBeat.o(93297);
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
      arrayOfInt = dlk;
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
          if (parama.cWx != null) {
            break label213;
          }
          parama.cK("align.caps");
          localObject = null;
        }
        for (;;)
        {
          float f2 = paramFormat.cGR;
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
          localObject = parama.cWx.getVideoCapabilities();
          if (localObject == null)
          {
            parama.cK("align.vCaps");
            localObject = null;
          }
          else
          {
            i1 = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
            int i4 = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
            localObject = new Point(x.cl(n, i1) * i1, x.cl(i2, i4) * i4);
          }
        }
      }
      int n = x.cl(i2, 16) * 16;
      i1 = x.cl(i1, 16) * 16;
      if (n * i1 <= com.google.android.exoplayer2.e.d.SG())
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
    v.ax("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    v.DS();
    paramMediaCodec = this.cXg;
    paramMediaCodec.cKM += 1;
    AppMethodBeat.o(93288);
  }
  
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93290);
    Va();
    v.ax("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    v.DS();
    paramMediaCodec = this.cXg;
    paramMediaCodec.cKL += 1;
    this.dlA = 0;
    UY();
    AppMethodBeat.o(93290);
  }
  
  private void b(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(93289);
    Va();
    v.ax("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.DS();
    paramMediaCodec = this.cXg;
    paramMediaCodec.cKL += 1;
    this.dlA = 0;
    UY();
    AppMethodBeat.o(93289);
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(93301);
    if ((paramFormat1.cGN.equals(paramFormat2.cGN)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))))
    {
      AppMethodBeat.o(93301);
      return true;
    }
    AppMethodBeat.o(93301);
    return false;
  }
  
  private boolean bE(boolean paramBoolean)
  {
    AppMethodBeat.i(93291);
    if ((x.SDK_INT >= 23) && (!this.cJt) && ((!paramBoolean) || (DummySurface.aN(this.context))))
    {
      AppMethodBeat.o(93291);
      return true;
    }
    AppMethodBeat.o(93291);
    return false;
  }
  
  private static boolean cK(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private static int k(String paramString, int paramInt1, int paramInt2)
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
      paramInt1 = x.cl(paramInt1, 16) * x.cl(paramInt2, 16) * 16 * 16;
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
    if (paramFormat.cGO != -1)
    {
      int k = paramFormat.cGP.size();
      int j = 0;
      i = 0;
      while (j < k)
      {
        i += ((byte[])paramFormat.cGP.get(j)).length;
        j += 1;
      }
      j = paramFormat.cGO;
      AppMethodBeat.o(93299);
      return j + i;
    }
    int i = k(paramFormat.cGN, paramFormat.width, paramFormat.height);
    AppMethodBeat.o(93299);
    return i;
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.Gj == -1) {
      return 0;
    }
    return paramFormat.Gj;
  }
  
  public final void Qu()
  {
    AppMethodBeat.i(93275);
    super.Qu();
    this.dlz = 0;
    this.dly = SystemClock.elapsedRealtime();
    AppMethodBeat.o(93275);
  }
  
  public final void Qv()
  {
    AppMethodBeat.i(93276);
    this.dlx = -9223372036854775807L;
    Vc();
    super.Qv();
    AppMethodBeat.o(93276);
  }
  
  public final void Qw()
  {
    AppMethodBeat.i(93277);
    this.dlD = -1;
    this.dlE = -1;
    this.dlG = -1.0F;
    this.dlC = -1.0F;
    this.dlM = -9223372036854775807L;
    this.dlN = 0;
    UZ();
    UX();
    d locald = this.dll;
    if (locald.dlR) {
      locald.dlQ.handler.sendEmptyMessage(2);
    }
    this.dlL = null;
    this.cJt = false;
    try
    {
      super.Qw();
      return;
    }
    finally
    {
      this.dlm.e(this.cXg);
      AppMethodBeat.o(93277);
    }
  }
  
  public final void SB()
  {
    AppMethodBeat.i(93281);
    try
    {
      super.SB();
      return;
    }
    finally
    {
      if (this.dlu != null)
      {
        if (this.surface == this.dlu) {
          this.surface = null;
        }
        this.dlu.release();
        this.dlu = null;
      }
      AppMethodBeat.o(93281);
    }
    AppMethodBeat.o(93281);
  }
  
  public final void SD()
  {
    AppMethodBeat.i(93284);
    if ((x.SDK_INT < 23) && (this.cJt)) {
      UY();
    }
    AppMethodBeat.o(93284);
  }
  
  final void UY()
  {
    AppMethodBeat.i(93294);
    if (!this.dlw)
    {
      this.dlw = true;
      this.dlm.g(this.surface);
    }
    AppMethodBeat.o(93294);
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    AppMethodBeat.i(93270);
    String str = paramFormat.cGN;
    if (!j.isVideo(str))
    {
      AppMethodBeat.o(93270);
      return 0;
    }
    Object localObject = paramFormat.cGQ;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).cLd) {
          break;
        }
        bool1 |= localObject.cLc[i].cLf;
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
    str = paramFormat.cGK;
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
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.cGR);
          }
        }
      }
      if (!paramc.cWv) {
        break label521;
      }
      i = 16;
      label197:
      if (paramc.cJt) {
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
      localObject = j.dl(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.cK("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.cL(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.Sy();
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
      paramc.cK("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      label432:
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.SG()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(x.dkT).append("]");
        bool2 = bool1;
        break;
      }
      i = 8;
      break label197;
    }
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat)
  {
    AppMethodBeat.i(210364);
    Object localObject = this.dlr;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new a(k, j, i);
      this.dls = ((a)localObject);
      localObject = this.dls;
      boolean bool = this.dlp;
      i = this.cHn;
      paramFormat = paramFormat.QS();
      paramFormat.setInteger("max-width", ((a)localObject).width);
      paramFormat.setInteger("max-height", ((a)localObject).height);
      if (((a)localObject).dlO != -1) {
        paramFormat.setInteger("max-input-size", ((a)localObject).dlO);
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
        com.google.android.exoplayer2.i.a.checkState(bE(parama.cWw));
        if (this.dlu == null) {
          this.dlu = DummySurface.i(this.context, parama.cWw);
        }
        this.surface = this.dlu;
      }
      paramMediaCodec.configure(paramFormat, this.surface, null, 0);
      if ((x.SDK_INT >= 23) && (this.cJt)) {
        this.dlL = new b(paramMediaCodec, (byte)0);
      }
      AppMethodBeat.o(210364);
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
      if (!b(parama.cWv, paramFormat, localFormat)) {
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
          i2 = Math.max(i, k(paramFormat.cGN, n, i1));
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
    this.dlr = paramArrayOfFormat;
    if (this.dlM == -9223372036854775807L)
    {
      this.dlM = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      AppMethodBeat.o(93272);
      return;
    }
    if (this.dlN == this.dlq.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.dlq[(this.dlN - 1)]);
    }
    for (;;)
    {
      this.dlq[(this.dlN - 1)] = paramLong;
      break;
      this.dlN += 1;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(93287);
    while ((this.dlN != 0) && (paramLong3 >= this.dlq[0]))
    {
      this.dlM = this.dlq[0];
      this.dlN -= 1;
      System.arraycopy(this.dlq, 1, this.dlq, 0, this.dlN);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      AppMethodBeat.o(93287);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.surface == this.dlu)
    {
      if (cK(paramLong1))
      {
        a(paramMediaCodec, paramInt1);
        AppMethodBeat.o(93287);
        return true;
      }
      AppMethodBeat.o(93287);
      return false;
    }
    if (!this.dlw)
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
    paramByteBuffer = this.dll;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.dlX)
    {
      if (paramLong3 != paramByteBuffer.dlU)
      {
        paramByteBuffer.dma += 1L;
        paramByteBuffer.dlV = paramByteBuffer.dlW;
      }
      if (paramByteBuffer.dma >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.dlZ) / paramByteBuffer.dma;
        paramLong2 = paramByteBuffer.dlV + paramLong1;
        if (paramByteBuffer.J(paramLong2, l1))
        {
          paramByteBuffer.dlX = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.dlX)
      {
        paramByteBuffer.dlZ = l2;
        paramByteBuffer.dlY = l1;
        paramByteBuffer.dma = 0L;
        paramByteBuffer.dlX = true;
      }
      paramByteBuffer.dlU = paramLong3;
      paramByteBuffer.dlW = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.dlQ != null)
      {
        if (paramByteBuffer.dlQ.dmb != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!cK(paramLong1)) {
        break label650;
      }
      v.ax("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      v.DS();
      paramMediaCodec = this.cXg;
      paramMediaCodec.cKN += 1;
      this.dlz += 1;
      this.dlA += 1;
      this.cXg.cKO = Math.max(this.dlA, this.cXg.cKO);
      if (this.dlz == this.dlo) {
        Vc();
      }
      AppMethodBeat.o(93287);
      return true;
      paramLong1 = paramByteBuffer.dlY + paramLong2 - paramByteBuffer.dlZ;
      continue;
      if (paramByteBuffer.J(l2, l1)) {
        paramByteBuffer.dlX = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.dlQ.dmb;
    paramLong3 = paramByteBuffer.dlS;
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
      paramLong2 -= paramByteBuffer.dlT;
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
    if ((this.surface != null) || (bE(parama.cWw)))
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
    if ((b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.dls.width) && (paramFormat2.height <= this.dls.height) && (l(paramFormat2) <= this.dls.dlO))
    {
      AppMethodBeat.o(93286);
      return true;
    }
    AppMethodBeat.o(93286);
    return false;
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(93271);
    super.bu(paramBoolean);
    this.cHn = Qx().cHn;
    if (this.cHn != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.cJt = paramBoolean;
      Object localObject = this.dlm;
      com.google.android.exoplayer2.b.d locald = this.cXg;
      if (((e.a)localObject).dmf != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.dll;
      ((d)localObject).dlX = false;
      if (((d)localObject).dlR) {
        ((d)localObject).dlQ.handler.sendEmptyMessage(1);
      }
      AppMethodBeat.o(93271);
      return;
    }
  }
  
  public final void d(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93282);
    e.a locala = this.dlm;
    if (locala.dmf != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(x.dkS)) && (!"flo".equals(x.dkS))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.dkS)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.dlt = bool;
      AppMethodBeat.o(93282);
      return;
    }
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(93283);
    super.e(paramFormat);
    e.a locala = this.dlm;
    if (locala.dmf != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.cGS == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.cGS)
    {
      this.dlC = f;
      this.dlB = m(paramFormat);
      AppMethodBeat.o(93283);
      return;
    }
  }
  
  public final void f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93273);
    super.f(paramLong, paramBoolean);
    UX();
    this.dlA = 0;
    if (this.dlN != 0)
    {
      this.dlM = this.dlq[(this.dlN - 1)];
      this.dlN = 0;
    }
    if (paramBoolean)
    {
      UW();
      AppMethodBeat.o(93273);
      return;
    }
    this.dlx = -9223372036854775807L;
    AppMethodBeat.o(93273);
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(93274);
    if ((super.isReady()) && ((this.dlw) || ((this.dlu != null) && (this.surface == this.dlu)) || (getCodec() == null) || (this.cJt)))
    {
      this.dlx = -9223372036854775807L;
      AppMethodBeat.o(93274);
      return true;
    }
    if (this.dlx == -9223372036854775807L)
    {
      AppMethodBeat.o(93274);
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.dlx)
    {
      AppMethodBeat.o(93274);
      return true;
    }
    this.dlx = -9223372036854775807L;
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
      this.dlD = j;
      if (i == 0) {
        break label199;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label99:
      this.dlE = i;
      this.dlG = this.dlC;
      if (x.SDK_INT < 21) {
        break label210;
      }
      if ((this.dlB == 90) || (this.dlB == 270))
      {
        i = this.dlD;
        this.dlD = this.dlE;
        this.dlE = i;
        this.dlG = (1.0F / this.dlG);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.dlv);
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
      this.dlF = this.dlB;
    }
  }
  
  public final void u(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(93278);
    if (paramInt == 1)
    {
      Object localObject = (Surface)paramObject;
      paramObject = localObject;
      if (localObject == null)
      {
        if (this.dlu != null) {
          paramObject = this.dlu;
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
          localObject = getCodec();
          if ((x.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.dlt)) {
            break label182;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
      }
      for (;;)
      {
        if ((paramObject == null) || (paramObject == this.dlu)) {
          break label193;
        }
        Vb();
        UX();
        if (paramInt != 2) {
          break label201;
        }
        UW();
        AppMethodBeat.o(93278);
        return;
        com.google.android.exoplayer2.e.a locala = SA();
        paramObject = localObject;
        if (locala == null) {
          break;
        }
        paramObject = localObject;
        if (!bE(locala.cWw)) {
          break;
        }
        this.dlu = DummySurface.i(this.context, locala.cWw);
        paramObject = this.dlu;
        break;
        label182:
        SB();
        Sz();
      }
      label193:
      UZ();
      UX();
      label201:
      AppMethodBeat.o(93278);
      return;
      label208:
      if ((paramObject != null) && (paramObject != this.dlu))
      {
        Vb();
        if (this.dlw) {
          this.dlm.g(this.surface);
        }
      }
      AppMethodBeat.o(93278);
      return;
    }
    if (paramInt == 4)
    {
      this.dlv = ((Integer)paramObject).intValue();
      paramObject = getCodec();
      if (paramObject != null) {
        paramObject.setVideoScalingMode(this.dlv);
      }
      AppMethodBeat.o(93278);
      return;
    }
    super.u(paramInt, paramObject);
    AppMethodBeat.o(93278);
  }
  
  protected static final class a
  {
    public final int dlO;
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.dlO = paramInt3;
    }
  }
  
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
      if (this != c.this.dlL)
      {
        AppMethodBeat.o(93268);
        return;
      }
      c.this.UY();
      AppMethodBeat.o(93268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */