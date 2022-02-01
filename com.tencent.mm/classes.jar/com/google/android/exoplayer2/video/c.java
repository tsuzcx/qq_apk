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
  private static final int[] bzM = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private int aSG;
  private boolean aUS;
  private long bAa;
  private int bAb;
  private int bAc;
  private int bAd;
  private float bAe;
  private int bAf;
  private int bAg;
  private int bAh;
  private float bAi;
  private int bAj;
  private int bAk;
  private int bAl;
  private float bAm;
  b bAn;
  private long bAo;
  private int bAp;
  private final d bzN;
  private final e.a bzO;
  private final long bzP;
  private final int bzQ;
  private final boolean bzR;
  private final long[] bzS;
  private Format[] bzT;
  private a bzU;
  private boolean bzV;
  private Surface bzW;
  private int bzX;
  private boolean bzY;
  private long bzZ;
  private final Context context;
  private Surface surface;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame, int paramInt)
  {
    super(2, paramc, paramb, false);
    AppMethodBeat.i(93269);
    this.bzP = paramLong;
    this.bzQ = paramInt;
    this.context = paramContext.getApplicationContext();
    this.bzN = new d(paramContext);
    this.bzO = new e.a(paramHandler, parame);
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
    this.bzR = bool1;
    this.bzS = new long[10];
    this.bAo = -9223372036854775807L;
    this.bzZ = -9223372036854775807L;
    this.bAf = -1;
    this.bAg = -1;
    this.bAi = -1.0F;
    this.bAe = -1.0F;
    this.bzX = 1;
    wf();
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
      arrayOfInt = bzM;
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
          if (parama.bif != null) {
            break label213;
          }
          parama.am("align.caps");
          localObject = null;
        }
        for (;;)
        {
          float f2 = paramFormat.aSh;
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
          localObject = parama.bif.getVideoCapabilities();
          if (localObject == null)
          {
            parama.am("align.vCaps");
            localObject = null;
          }
          else
          {
            i1 = ((MediaCodecInfo.VideoCapabilities)localObject).getWidthAlignment();
            int i4 = ((MediaCodecInfo.VideoCapabilities)localObject).getHeightAlignment();
            localObject = new Point(x.bp(n, i1) * i1, x.bp(i2, i4) * i4);
          }
        }
      }
      int n = x.bp(i2, 16) * 16;
      i1 = x.bp(i1, 16) * 16;
      if (n * i1 <= com.google.android.exoplayer2.e.d.tu())
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
    paramMediaCodec = this.biP;
    paramMediaCodec.aWh += 1;
    AppMethodBeat.o(93288);
  }
  
  @TargetApi(21)
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93290);
    wg();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    v.endSection();
    paramMediaCodec = this.biP;
    paramMediaCodec.aWg += 1;
    this.bAc = 0;
    we();
    AppMethodBeat.o(93290);
  }
  
  private boolean aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(93291);
    if ((x.SDK_INT >= 23) && (!this.aUS) && ((!paramBoolean) || (DummySurface.ah(this.context))))
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
    wg();
    v.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    v.endSection();
    paramMediaCodec = this.biP;
    paramMediaCodec.aWg += 1;
    this.bAc = 0;
    we();
    AppMethodBeat.o(93289);
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(93301);
    if ((paramFormat1.aSd.equals(paramFormat2.aSd)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height))))
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
      paramInt1 = x.bp(paramInt1, 16) * x.bp(paramInt2, 16) * 16 * 16;
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
    if (paramFormat.aSe != -1)
    {
      int k = paramFormat.aSf.size();
      int j = 0;
      i = 0;
      while (j < k)
      {
        i += ((byte[])paramFormat.aSf.get(j)).length;
        j += 1;
      }
      j = paramFormat.aSe;
      AppMethodBeat.o(93299);
      return j + i;
    }
    int i = e(paramFormat.aSd, paramFormat.width, paramFormat.height);
    AppMethodBeat.o(93299);
    return i;
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.aSi == -1) {
      return 0;
    }
    return paramFormat.aSi;
  }
  
  private void wc()
  {
    AppMethodBeat.i(93292);
    if (this.bzP > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.bzP;; l = -9223372036854775807L)
    {
      this.bzZ = l;
      AppMethodBeat.o(93292);
      return;
    }
  }
  
  private void wd()
  {
    AppMethodBeat.i(93293);
    this.bzY = false;
    if ((x.SDK_INT >= 23) && (this.aUS))
    {
      MediaCodec localMediaCodec = this.biq;
      if (localMediaCodec != null) {
        this.bAn = new b(localMediaCodec, (byte)0);
      }
    }
    AppMethodBeat.o(93293);
  }
  
  private void wf()
  {
    this.bAj = -1;
    this.bAk = -1;
    this.bAm = -1.0F;
    this.bAl = -1;
  }
  
  private void wg()
  {
    AppMethodBeat.i(93295);
    if (((this.bAf != -1) || (this.bAg != -1)) && ((this.bAj != this.bAf) || (this.bAk != this.bAg) || (this.bAl != this.bAh) || (this.bAm != this.bAi)))
    {
      this.bzO.b(this.bAf, this.bAg, this.bAh, this.bAi);
      this.bAj = this.bAf;
      this.bAk = this.bAg;
      this.bAl = this.bAh;
      this.bAm = this.bAi;
    }
    AppMethodBeat.o(93295);
  }
  
  private void wh()
  {
    AppMethodBeat.i(93296);
    if ((this.bAj != -1) || (this.bAk != -1)) {
      this.bzO.b(this.bAj, this.bAk, this.bAl, this.bAm);
    }
    AppMethodBeat.o(93296);
  }
  
  private void wi()
  {
    AppMethodBeat.i(93297);
    if (this.bAb > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.bAa;
      this.bzO.m(this.bAb, l1 - l2);
      this.bAb = 0;
      this.bAa = l1;
    }
    AppMethodBeat.o(93297);
  }
  
  public final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    AppMethodBeat.i(93270);
    String str = paramFormat.aSd;
    if (!j.aK(str))
    {
      AppMethodBeat.o(93270);
      return 0;
    }
    Object localObject = paramFormat.aSg;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).aWy) {
          break;
        }
        bool1 |= localObject.aWx[i].aWz;
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
    str = paramFormat.aSa;
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
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.aSh);
          }
        }
      }
      if (!paramc.bid) {
        break label521;
      }
      i = 16;
      label197:
      if (paramc.aUS) {
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
      localObject = j.aO(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.am("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.an(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.tn();
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
      paramc.am("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      label432:
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.tu()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(x.bzu).append("]");
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
    wd();
    this.bAc = 0;
    if (this.bAp != 0)
    {
      this.bAo = this.bzS[(this.bAp - 1)];
      this.bAp = 0;
    }
    if (paramBoolean)
    {
      wc();
      AppMethodBeat.o(93273);
      return;
    }
    this.bzZ = -9223372036854775807L;
    AppMethodBeat.o(93273);
  }
  
  public final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(93280);
    Object localObject = this.bzT;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new a(k, j, i);
      this.bzU = ((a)localObject);
      localObject = this.bzU;
      boolean bool = this.bzR;
      i = this.aSG;
      paramFormat = paramFormat.rH();
      paramFormat.setInteger("max-width", ((a)localObject).width);
      paramFormat.setInteger("max-height", ((a)localObject).height);
      if (((a)localObject).bAq != -1) {
        paramFormat.setInteger("max-input-size", ((a)localObject).bAq);
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
        com.google.android.exoplayer2.i.a.checkState(aZ(parama.bie));
        if (this.bzW == null) {
          this.bzW = DummySurface.j(this.context, parama.bie);
        }
        this.surface = this.bzW;
      }
      paramMediaCodec.configure(paramFormat, this.surface, paramMediaCrypto, 0);
      if ((x.SDK_INT >= 23) && (this.aUS)) {
        this.bAn = new b(paramMediaCodec, (byte)0);
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
      if (!b(parama.bid, paramFormat, localFormat)) {
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
          i2 = Math.max(i, e(paramFormat.aSd, n, i1));
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
    this.bzT = paramArrayOfFormat;
    if (this.bAo == -9223372036854775807L)
    {
      this.bAo = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      AppMethodBeat.o(93272);
      return;
    }
    if (this.bAp == this.bzS.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.bzS[(this.bAp - 1)]);
    }
    for (;;)
    {
      this.bzS[(this.bAp - 1)] = paramLong;
      break;
      this.bAp += 1;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(93287);
    while ((this.bAp != 0) && (paramLong3 >= this.bzS[0]))
    {
      this.bAo = this.bzS[0];
      this.bAp -= 1;
      System.arraycopy(this.bzS, 1, this.bzS, 0, this.bAp);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      AppMethodBeat.o(93287);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.surface == this.bzW)
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
    if (!this.bzY)
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
    paramByteBuffer = this.bzN;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.bAz)
    {
      if (paramLong3 != paramByteBuffer.bAw)
      {
        paramByteBuffer.bAC += 1L;
        paramByteBuffer.bAx = paramByteBuffer.bAy;
      }
      if (paramByteBuffer.bAC >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.bAB) / paramByteBuffer.bAC;
        paramLong2 = paramByteBuffer.bAx + paramLong1;
        if (paramByteBuffer.p(paramLong2, l1))
        {
          paramByteBuffer.bAz = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.bAz)
      {
        paramByteBuffer.bAB = l2;
        paramByteBuffer.bAA = l1;
        paramByteBuffer.bAC = 0L;
        paramByteBuffer.bAz = true;
      }
      paramByteBuffer.bAw = paramLong3;
      paramByteBuffer.bAy = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.bAs != null)
      {
        if (paramByteBuffer.bAs.bAD != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!aw(paramLong1)) {
        break label650;
      }
      v.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      v.endSection();
      paramMediaCodec = this.biP;
      paramMediaCodec.aWi += 1;
      this.bAb += 1;
      this.bAc += 1;
      this.biP.aWj = Math.max(this.bAc, this.biP.aWj);
      if (this.bAb == this.bzQ) {
        wi();
      }
      AppMethodBeat.o(93287);
      return true;
      paramLong1 = paramByteBuffer.bAA + paramLong2 - paramByteBuffer.bAB;
      continue;
      if (paramByteBuffer.p(l2, l1)) {
        paramByteBuffer.bAz = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.bAs.bAD;
    paramLong3 = paramByteBuffer.bAu;
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
      paramLong2 -= paramByteBuffer.bAv;
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
    if ((this.surface != null) || (aZ(parama.bie)))
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
    if ((b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.bzU.width) && (paramFormat2.height <= this.bzU.height) && (l(paramFormat2) <= this.bzU.bAq))
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
    this.aSG = this.aQr.aSG;
    if (this.aSG != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aUS = paramBoolean;
      Object localObject = this.bzO;
      com.google.android.exoplayer2.b.d locald = this.biP;
      if (((e.a)localObject).bAH != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.bzN;
      ((d)localObject).bAz = false;
      if (((d)localObject).bAt) {
        ((d)localObject).bAs.handler.sendEmptyMessage(1);
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
        if (this.bzW != null) {
          paramObject = this.bzW;
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
          localObject = this.biq;
          if ((x.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.bzV)) {
            break label182;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
      }
      for (;;)
      {
        if ((paramObject == null) || (paramObject == this.bzW)) {
          break label193;
        }
        wh();
        wd();
        if (paramInt != 2) {
          break label201;
        }
        wc();
        AppMethodBeat.o(93278);
        return;
        com.google.android.exoplayer2.e.a locala = this.bir;
        paramObject = localObject;
        if (locala == null) {
          break;
        }
        paramObject = localObject;
        if (!aZ(locala.bie)) {
          break;
        }
        this.bzW = DummySurface.j(this.context, locala.bie);
        paramObject = this.bzW;
        break;
        label182:
        tp();
        to();
      }
      label193:
      wf();
      wd();
      label201:
      AppMethodBeat.o(93278);
      return;
      label208:
      if ((paramObject != null) && (paramObject != this.bzW))
      {
        wh();
        if (this.bzY) {
          this.bzO.e(this.surface);
        }
      }
      AppMethodBeat.o(93278);
      return;
    }
    if (paramInt == 4)
    {
      this.bzX = ((Integer)paramObject).intValue();
      paramObject = this.biq;
      if (paramObject != null) {
        paramObject.setVideoScalingMode(this.bzX);
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
    e.a locala = this.bzO;
    if (locala.bAH != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(x.DEVICE)) && (!"flo".equals(x.DEVICE))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(x.DEVICE)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bzV = bool;
      AppMethodBeat.o(93282);
      return;
    }
  }
  
  public final void e(Format paramFormat)
  {
    AppMethodBeat.i(93283);
    super.e(paramFormat);
    e.a locala = this.bzO;
    if (locala.bAH != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.aSj == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.aSj)
    {
      this.bAe = f;
      this.bAd = m(paramFormat);
      AppMethodBeat.o(93283);
      return;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(93274);
    if ((super.isReady()) && ((this.bzY) || ((this.bzW != null) && (this.surface == this.bzW)) || (this.biq == null) || (this.aUS)))
    {
      this.bzZ = -9223372036854775807L;
      AppMethodBeat.o(93274);
      return true;
    }
    if (this.bzZ == -9223372036854775807L)
    {
      AppMethodBeat.o(93274);
      return false;
    }
    if (SystemClock.elapsedRealtime() < this.bzZ)
    {
      AppMethodBeat.o(93274);
      return true;
    }
    this.bzZ = -9223372036854775807L;
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
      this.bAf = j;
      if (i == 0) {
        break label199;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label99:
      this.bAg = i;
      this.bAi = this.bAe;
      if (x.SDK_INT < 21) {
        break label210;
      }
      if ((this.bAd == 90) || (this.bAd == 270))
      {
        i = this.bAf;
        this.bAf = this.bAg;
        this.bAg = i;
        this.bAi = (1.0F / this.bAi);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.bzX);
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
      this.bAh = this.bAd;
    }
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(93275);
    super.onStarted();
    this.bAb = 0;
    this.bAa = SystemClock.elapsedRealtime();
    AppMethodBeat.o(93275);
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(93276);
    this.bzZ = -9223372036854775807L;
    wi();
    super.onStopped();
    AppMethodBeat.o(93276);
  }
  
  public final void rp()
  {
    AppMethodBeat.i(93277);
    this.bAf = -1;
    this.bAg = -1;
    this.bAi = -1.0F;
    this.bAe = -1.0F;
    this.bAo = -9223372036854775807L;
    this.bAp = 0;
    wf();
    wd();
    d locald = this.bzN;
    if (locald.bAt) {
      locald.bAs.handler.sendEmptyMessage(2);
    }
    this.bAn = null;
    this.aUS = false;
    try
    {
      super.rp();
      return;
    }
    finally
    {
      this.bzO.e(this.biP);
      AppMethodBeat.o(93277);
    }
  }
  
  public final void tp()
  {
    AppMethodBeat.i(93281);
    try
    {
      super.tp();
      return;
    }
    finally
    {
      if (this.bzW != null)
      {
        if (this.surface == this.bzW) {
          this.surface = null;
        }
        this.bzW.release();
        this.bzW = null;
      }
      AppMethodBeat.o(93281);
    }
    AppMethodBeat.o(93281);
  }
  
  public final void tr()
  {
    AppMethodBeat.i(93284);
    if ((x.SDK_INT < 23) && (this.aUS)) {
      we();
    }
    AppMethodBeat.o(93284);
  }
  
  final void we()
  {
    AppMethodBeat.i(93294);
    if (!this.bzY)
    {
      this.bzY = true;
      this.bzO.e(this.surface);
    }
    AppMethodBeat.o(93294);
  }
  
  protected static final class a
  {
    public final int bAq;
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.bAq = paramInt3;
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
      if (this != c.this.bAn)
      {
        AppMethodBeat.o(93268);
        return;
      }
      c.this.we();
      AppMethodBeat.o(93268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */