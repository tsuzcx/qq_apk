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
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.r;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public final class c
  extends com.google.android.exoplayer2.e.b
{
  private static final int[] aTo = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private boolean aTA;
  private long aTB;
  private long aTC;
  private int aTD;
  private int aTE;
  private int aTF;
  private float aTG;
  private int aTH;
  private int aTI;
  private int aTJ;
  private float aTK;
  private int aTL;
  private int aTM;
  private int aTN;
  private float aTO;
  c.b aTP;
  private long aTQ;
  private int aTR;
  private final d aTp;
  private final e.a aTq;
  private final long aTr;
  private final int aTs;
  private final boolean aTt;
  private final long[] aTu;
  private Format[] aTv;
  private c.a aTw;
  private boolean aTx;
  private Surface aTy;
  private int aTz;
  private int auW;
  private Surface avf;
  private boolean axj;
  private final Context context;
  
  public c(Context paramContext, com.google.android.exoplayer2.e.c paramc, long paramLong, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, Handler paramHandler, e parame)
  {
    super(2, paramc, paramb, false);
    this.aTr = paramLong;
    this.aTs = 50;
    this.context = paramContext.getApplicationContext();
    this.aTp = new d(paramContext);
    this.aTq = new e.a(paramHandler, parame);
    boolean bool1 = bool2;
    if (com.google.android.exoplayer2.i.t.SDK_INT <= 22)
    {
      bool1 = bool2;
      if ("foster".equals(com.google.android.exoplayer2.i.t.DEVICE))
      {
        bool1 = bool2;
        if ("NVIDIA".equals(com.google.android.exoplayer2.i.t.MANUFACTURER)) {
          bool1 = true;
        }
      }
    }
    this.aTt = bool1;
    this.aTu = new long[10];
    this.aTQ = -9223372036854775807L;
    this.aTB = -9223372036854775807L;
    this.aTH = -1;
    this.aTI = -1;
    this.aTK = -1.0F;
    this.aTG = -1.0F;
    this.aTz = 1;
    ou();
  }
  
  private static Point a(com.google.android.exoplayer2.e.a parama, Format paramFormat)
  {
    int i;
    int j;
    label25:
    int k;
    label36:
    int m;
    int i2;
    int i1;
    Object localObject2;
    if (paramFormat.height > paramFormat.width)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      j = paramFormat.height;
      if (i == 0) {
        break label114;
      }
      k = paramFormat.width;
      float f1 = k / j;
      int[] arrayOfInt = aTo;
      int i3 = arrayOfInt.length;
      m = 0;
      if (m >= i3) {
        break label359;
      }
      i2 = arrayOfInt[m];
      i1 = (int)(i2 * f1);
      if ((i2 > j) && (i1 > k)) {
        break label123;
      }
      localObject2 = null;
    }
    label105:
    label114:
    label123:
    int n;
    label140:
    label145:
    Object localObject1;
    label161:
    float f2;
    do
    {
      return localObject2;
      i = 0;
      break;
      j = paramFormat.width;
      break label25;
      k = paramFormat.height;
      break label36;
      if (com.google.android.exoplayer2.i.t.SDK_INT < 21) {
        break label284;
      }
      if (i == 0) {
        break label198;
      }
      n = i1;
      if (i == 0) {
        break label205;
      }
      if (parama.aFL != null) {
        break label212;
      }
      parama.al("align.caps");
      localObject1 = null;
      f2 = paramFormat.auw;
      localObject2 = localObject1;
    } while (parama.a(((Point)localObject1).x, ((Point)localObject1).y, f2));
    label198:
    label205:
    label212:
    do
    {
      m += 1;
      break;
      n = i2;
      break label140;
      i2 = i1;
      break label145;
      localObject1 = parama.aFL.getVideoCapabilities();
      if (localObject1 == null)
      {
        parama.al("align.vCaps");
        localObject1 = null;
        break label161;
      }
      i1 = ((MediaCodecInfo.VideoCapabilities)localObject1).getWidthAlignment();
      int i4 = ((MediaCodecInfo.VideoCapabilities)localObject1).getHeightAlignment();
      localObject1 = new Point(com.google.android.exoplayer2.i.t.aJ(n, i1) * i1, com.google.android.exoplayer2.i.t.aJ(i2, i4) * i4);
      break label161;
      n = com.google.android.exoplayer2.i.t.aJ(i2, 16) * 16;
      i1 = com.google.android.exoplayer2.i.t.aJ(i1, 16) * 16;
    } while (n * i1 > com.google.android.exoplayer2.e.d.mr());
    label284:
    if (i != 0)
    {
      j = i1;
      if (i == 0) {
        break label352;
      }
    }
    for (;;)
    {
      return new Point(j, n);
      j = n;
      break;
      label352:
      n = i1;
    }
    label359:
    return null;
  }
  
  private void a(MediaCodec paramMediaCodec, int paramInt)
  {
    r.beginSection("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    r.endSection();
    paramMediaCodec = this.aGu;
    paramMediaCodec.ayz += 1;
  }
  
  @TargetApi(21)
  private void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    ov();
    r.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    r.endSection();
    paramMediaCodec = this.aGu;
    paramMediaCodec.ayy += 1;
    this.aTE = 0;
    ot();
  }
  
  private boolean aE(boolean paramBoolean)
  {
    return (com.google.android.exoplayer2.i.t.SDK_INT >= 23) && (!this.axj) && ((!paramBoolean) || (DummySurface.Z(this.context)));
  }
  
  private static boolean aa(long paramLong)
  {
    return paramLong < -30000L;
  }
  
  private static int b(String paramString, int paramInt1, int paramInt2)
  {
    int j = 2;
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      return -1;
    }
    label76:
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
        return -1;
        if (!paramString.equals("video/3gpp")) {
          break label76;
        }
        i = 0;
        continue;
        if (!paramString.equals("video/mp4v-es")) {
          break label76;
        }
        i = 1;
        continue;
        if (!paramString.equals("video/avc")) {
          break label76;
        }
        i = 2;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break label76;
        }
        i = 3;
        continue;
        if (!paramString.equals("video/hevc")) {
          break label76;
        }
        i = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9")) {
          break label76;
        }
        i = 5;
      }
    }
    paramInt1 *= paramInt2;
    paramInt2 = j;
    for (;;)
    {
      return paramInt1 * 3 / (paramInt2 * 2);
      if ("BRAVIA 4K 2015".equals(com.google.android.exoplayer2.i.t.MODEL)) {
        return -1;
      }
      paramInt1 = com.google.android.exoplayer2.i.t.aJ(paramInt1, 16) * com.google.android.exoplayer2.i.t.aJ(paramInt2, 16) * 16 * 16;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = 4;
    }
  }
  
  private void b(MediaCodec paramMediaCodec, int paramInt)
  {
    ov();
    r.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    r.endSection();
    paramMediaCodec = this.aGu;
    paramMediaCodec.ayy += 1;
    this.aTE = 0;
    ot();
  }
  
  private static boolean b(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return (paramFormat1.aus.equals(paramFormat2.aus)) && (m(paramFormat1) == m(paramFormat2)) && ((paramBoolean) || ((paramFormat1.width == paramFormat2.width) && (paramFormat1.height == paramFormat2.height)));
  }
  
  private static int l(Format paramFormat)
  {
    if (paramFormat.aut != -1)
    {
      int k = paramFormat.auu.size();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((byte[])paramFormat.auu.get(i)).length;
        i += 1;
      }
      return paramFormat.aut + j;
    }
    return b(paramFormat.aus, paramFormat.width, paramFormat.height);
  }
  
  private static int m(Format paramFormat)
  {
    if (paramFormat.aux == -1) {
      return 0;
    }
    return paramFormat.aux;
  }
  
  private void or()
  {
    if (this.aTr > 0L) {}
    for (long l = SystemClock.elapsedRealtime() + this.aTr;; l = -9223372036854775807L)
    {
      this.aTB = l;
      return;
    }
  }
  
  private void os()
  {
    this.aTA = false;
    if ((com.google.android.exoplayer2.i.t.SDK_INT >= 23) && (this.axj))
    {
      MediaCodec localMediaCodec = this.aFW;
      if (localMediaCodec != null) {
        this.aTP = new c.b(this, localMediaCodec, (byte)0);
      }
    }
  }
  
  private void ou()
  {
    this.aTL = -1;
    this.aTM = -1;
    this.aTO = -1.0F;
    this.aTN = -1;
  }
  
  private void ov()
  {
    if (((this.aTH != -1) || (this.aTI != -1)) && ((this.aTL != this.aTH) || (this.aTM != this.aTI) || (this.aTN != this.aTJ) || (this.aTO != this.aTK)))
    {
      this.aTq.c(this.aTH, this.aTI, this.aTJ, this.aTK);
      this.aTL = this.aTH;
      this.aTM = this.aTI;
      this.aTN = this.aTJ;
      this.aTO = this.aTK;
    }
  }
  
  private void ow()
  {
    if ((this.aTL != -1) || (this.aTM != -1)) {
      this.aTq.c(this.aTL, this.aTM, this.aTN, this.aTO);
    }
  }
  
  private void ox()
  {
    if (this.aTD > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.aTC;
      e.a locala = this.aTq;
      int i = this.aTD;
      if (locala.aUk != null) {
        locala.handler.post(new e.a.4(locala, i, l1 - l2));
      }
      this.aTD = 0;
      this.aTC = l1;
    }
  }
  
  protected final int a(com.google.android.exoplayer2.e.c paramc, Format paramFormat)
  {
    int j = 0;
    String str = paramFormat.aus;
    if (!g.aw(str)) {
      return 0;
    }
    Object localObject = paramFormat.auv;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      i = 0;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= ((DrmInitData)localObject).ayR) {
          break;
        }
        bool1 |= localObject.ayQ[i].ayS;
        i += 1;
      }
    }
    boolean bool2 = false;
    paramc = paramc.d(str, bool2);
    if (paramc == null) {
      return 1;
    }
    str = paramFormat.aup;
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
            if (com.google.android.exoplayer2.i.t.SDK_INT < 21) {
              break label408;
            }
            bool2 = paramc.a(paramFormat.width, paramFormat.height, paramFormat.auw);
          }
        }
      }
      if (!paramc.aFJ) {
        break label497;
      }
      i = 16;
      label179:
      if (paramc.axj) {
        j = 32;
      }
      if (!bool2) {
        break label503;
      }
    }
    label369:
    label503:
    for (int k = 4;; k = 3)
    {
      return j | i | k;
      localObject = g.ay(str);
      if (localObject == null)
      {
        bool1 = true;
        break;
      }
      if (!paramc.mimeType.equals(localObject))
      {
        paramc.al("codec.mime " + str + ", " + (String)localObject);
        bool1 = false;
        break;
      }
      Pair localPair = com.google.android.exoplayer2.e.d.am(str);
      if (localPair == null)
      {
        bool1 = true;
        break;
      }
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramc.mk();
      k = arrayOfCodecProfileLevel.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label369;
        }
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        if ((localCodecProfileLevel.profile == ((Integer)localPair.first).intValue()) && (localCodecProfileLevel.level >= ((Integer)localPair.second).intValue()))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      paramc.al("codec.profileLevel, " + str + ", " + (String)localObject);
      bool1 = false;
      break;
      if (paramFormat.width * paramFormat.height <= com.google.android.exoplayer2.e.d.mr()) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        new StringBuilder("FalseCheck [legacyFrameSize, ").append(paramFormat.width).append("x").append(paramFormat.height).append("] [").append(com.google.android.exoplayer2.i.t.aSS).append("]");
        bool2 = bool1;
        break;
      }
      i = 8;
      break label179;
    }
  }
  
  protected final void a(com.google.android.exoplayer2.e.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto)
  {
    Object localObject = this.aTv;
    int k = paramFormat.width;
    int j = paramFormat.height;
    int i = l(paramFormat);
    if (localObject.length == 1)
    {
      localObject = new c.a(k, j, i);
      this.aTw = ((c.a)localObject);
      localObject = this.aTw;
      boolean bool = this.aTt;
      i = this.auW;
      paramFormat = paramFormat.kR();
      paramFormat.setInteger("max-width", ((c.a)localObject).width);
      paramFormat.setInteger("max-height", ((c.a)localObject).height);
      if (((c.a)localObject).aTS != -1) {
        paramFormat.setInteger("max-input-size", ((c.a)localObject).aTS);
      }
      if (bool) {
        paramFormat.setInteger("auto-frc", 0);
      }
      if (i != 0)
      {
        paramFormat.setFeatureEnabled("tunneled-playback", true);
        paramFormat.setInteger("audio-session-id", i);
      }
      if (this.avf == null)
      {
        com.google.android.exoplayer2.i.a.aC(aE(parama.aFK));
        if (this.aTy == null) {
          this.aTy = DummySurface.h(this.context, parama.aFK);
        }
        this.avf = this.aTy;
      }
      paramMediaCodec.configure(paramFormat, this.avf, paramMediaCrypto, 0);
      if ((com.google.android.exoplayer2.i.t.SDK_INT >= 23) && (this.axj)) {
        this.aTP = new c.b(this, paramMediaCodec, (byte)0);
      }
      return;
    }
    int m = 0;
    int i2 = localObject.length;
    int n = 0;
    label256:
    int i1;
    if (n < i2)
    {
      Format localFormat = localObject[n];
      if (!b(parama.aFJ, paramFormat, localFormat)) {
        break label517;
      }
      if ((localFormat.width == -1) || (localFormat.height == -1))
      {
        i1 = 1;
        label304:
        m = i1 | m;
        k = Math.max(k, localFormat.width);
        j = Math.max(j, localFormat.height);
        i = Math.max(i, l(localFormat));
      }
    }
    label517:
    for (;;)
    {
      n += 1;
      break label256;
      i1 = 0;
      break label304;
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
          i2 = Math.max(i, b(paramFormat.aus, n, i1));
          new StringBuilder("Codec max resolution adjusted to: ").append(n).append("x").append(i1);
        }
      }
      localObject = new c.a(n, i1, i2);
      break;
    }
  }
  
  protected final void a(Format[] paramArrayOfFormat, long paramLong)
  {
    this.aTv = paramArrayOfFormat;
    if (this.aTQ == -9223372036854775807L)
    {
      this.aTQ = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      return;
    }
    if (this.aTR == this.aTu.length) {
      new StringBuilder("Too many stream changes, so dropping offset: ").append(this.aTu[(this.aTR - 1)]);
    }
    for (;;)
    {
      this.aTu[(this.aTR - 1)] = paramLong;
      break;
      this.aTR += 1;
    }
  }
  
  protected final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    while ((this.aTR != 0) && (paramLong3 >= this.aTu[0]))
    {
      this.aTQ = this.aTu[0];
      this.aTR -= 1;
      System.arraycopy(this.aTu, 1, this.aTu, 0, this.aTR);
    }
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1);
      return true;
    }
    paramLong1 = paramLong3 - paramLong1;
    if (this.avf == this.aTy)
    {
      if (aa(paramLong1))
      {
        a(paramMediaCodec, paramInt1);
        return true;
      }
      return false;
    }
    if (!this.aTA)
    {
      if (com.google.android.exoplayer2.i.t.SDK_INT >= 21) {
        a(paramMediaCodec, paramInt1, System.nanoTime());
      }
      for (;;)
      {
        return true;
        b(paramMediaCodec, paramInt1);
      }
    }
    if (this.state != 2) {
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l3 = System.nanoTime();
    l1 = l3 + (paramLong1 - (l1 * 1000L - paramLong2)) * 1000L;
    paramByteBuffer = this.aTp;
    long l2 = paramLong3 * 1000L;
    if (paramByteBuffer.aUb)
    {
      if (paramLong3 != paramByteBuffer.aTY)
      {
        paramByteBuffer.aUe += 1L;
        paramByteBuffer.aTZ = paramByteBuffer.aUa;
      }
      if (paramByteBuffer.aUe >= 6L)
      {
        paramLong1 = (l2 - paramByteBuffer.aUd) / paramByteBuffer.aUe;
        paramLong2 = paramByteBuffer.aTZ + paramLong1;
        if (paramByteBuffer.h(paramLong2, l1))
        {
          paramByteBuffer.aUb = false;
          paramLong1 = l1;
          paramLong2 = l2;
        }
      }
    }
    for (;;)
    {
      if (!paramByteBuffer.aUb)
      {
        paramByteBuffer.aUd = l2;
        paramByteBuffer.aUc = l1;
        paramByteBuffer.aUe = 0L;
        paramByteBuffer.aUb = true;
      }
      paramByteBuffer.aTY = paramLong3;
      paramByteBuffer.aUa = paramLong2;
      paramLong2 = paramLong1;
      if (paramByteBuffer.aTU != null)
      {
        if (paramByteBuffer.aTU.aUf != 0L) {
          break;
        }
        paramLong2 = paramLong1;
      }
      paramLong1 = (paramLong2 - l3) / 1000L;
      if (!aa(paramLong1)) {
        break label608;
      }
      r.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      r.endSection();
      paramMediaCodec = this.aGu;
      paramMediaCodec.ayA += 1;
      this.aTD += 1;
      this.aTE += 1;
      this.aGu.ayB = Math.max(this.aTE, this.aGu.ayB);
      if (this.aTD == this.aTs) {
        ox();
      }
      return true;
      paramLong1 = paramByteBuffer.aUc + paramLong2 - paramByteBuffer.aUd;
      continue;
      if (paramByteBuffer.h(l2, l1)) {
        paramByteBuffer.aUb = false;
      }
      paramLong1 = l1;
      paramLong2 = l2;
    }
    paramLong2 = paramByteBuffer.aTU.aUf;
    paramLong3 = paramByteBuffer.aTW;
    paramLong2 = (paramLong1 - paramLong2) / paramLong3 * paramLong3 + paramLong2;
    if (paramLong1 <= paramLong2)
    {
      paramLong3 = paramLong2 - paramLong3;
      label565:
      if (paramLong2 - paramLong1 >= paramLong1 - paramLong3) {
        break label602;
      }
    }
    for (;;)
    {
      paramLong2 -= paramByteBuffer.aTX;
      break;
      l1 = paramLong2 + paramLong3;
      paramLong3 = paramLong2;
      paramLong2 = l1;
      break label565;
      label602:
      paramLong2 = paramLong3;
    }
    label608:
    if (com.google.android.exoplayer2.i.t.SDK_INT >= 21)
    {
      if (paramLong1 < 50000L)
      {
        a(paramMediaCodec, paramInt1, paramLong2);
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
    return false;
  }
  
  protected final boolean a(com.google.android.exoplayer2.e.a parama)
  {
    return (this.avf != null) || (aE(parama.aFK));
  }
  
  protected final boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return (b(paramBoolean, paramFormat1, paramFormat2)) && (paramFormat2.width <= this.aTw.width) && (paramFormat2.height <= this.aTw.height) && (l(paramFormat2) <= this.aTw.aTS);
  }
  
  protected final void as(boolean paramBoolean)
  {
    super.as(paramBoolean);
    this.auW = this.asH.auW;
    if (this.auW != 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.axj = paramBoolean;
      Object localObject = this.aTq;
      com.google.android.exoplayer2.b.d locald = this.aGu;
      if (((e.a)localObject).aUk != null) {
        ((e.a)localObject).handler.post(new e.a.1((e.a)localObject, locald));
      }
      localObject = this.aTp;
      ((d)localObject).aUb = false;
      if (((d)localObject).aTV) {
        ((d)localObject).aTU.handler.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  protected final void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    os();
    this.aTE = 0;
    if (this.aTR != 0)
    {
      this.aTQ = this.aTu[(this.aTR - 1)];
      this.aTR = 0;
    }
    if (paramBoolean)
    {
      or();
      return;
    }
    this.aTB = -9223372036854775807L;
  }
  
  protected final void c(String paramString, long paramLong1, long paramLong2)
  {
    e.a locala = this.aTq;
    if (locala.aUk != null) {
      locala.handler.post(new e.a.2(locala, paramString, paramLong1, paramLong2));
    }
    if (((!"deb".equals(com.google.android.exoplayer2.i.t.DEVICE)) && (!"flo".equals(com.google.android.exoplayer2.i.t.DEVICE))) || (("OMX.qcom.video.decoder.avc".equals(paramString)) || (("tcl_eu".equals(com.google.android.exoplayer2.i.t.DEVICE)) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString))))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aTx = bool;
      return;
    }
  }
  
  public final void d(int paramInt, Object paramObject)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (Surface)paramObject;
      paramObject = localObject;
      if (localObject == null)
      {
        if (this.aTy != null) {
          paramObject = this.aTy;
        }
      }
      else
      {
        if (this.avf == paramObject) {
          break label190;
        }
        this.avf = paramObject;
        paramInt = this.state;
        if ((paramInt == 1) || (paramInt == 2))
        {
          localObject = this.aFW;
          if ((com.google.android.exoplayer2.i.t.SDK_INT < 23) || (localObject == null) || (paramObject == null) || (this.aTx)) {
            break label170;
          }
          ((MediaCodec)localObject).setOutputSurface(paramObject);
        }
        label89:
        if ((paramObject == null) || (paramObject == this.aTy)) {
          break label181;
        }
        ow();
        os();
        if (paramInt == 2) {
          or();
        }
      }
    }
    label170:
    label181:
    label190:
    do
    {
      do
      {
        do
        {
          return;
          com.google.android.exoplayer2.e.a locala = this.aFX;
          paramObject = localObject;
          if (locala == null) {
            break;
          }
          paramObject = localObject;
          if (!aE(locala.aFK)) {
            break;
          }
          this.aTy = DummySurface.h(this.context, locala.aFK);
          paramObject = this.aTy;
          break;
          mm();
          ml();
          break label89;
          ou();
          os();
          return;
        } while ((paramObject == null) || (paramObject == this.aTy));
        ow();
      } while (!this.aTA);
      this.aTq.c(this.avf);
      return;
      if (paramInt != 4) {
        break label259;
      }
      this.aTz = ((Integer)paramObject).intValue();
      paramObject = this.aFW;
    } while (paramObject == null);
    paramObject.setVideoScalingMode(this.aTz);
    return;
    label259:
    super.d(paramInt, paramObject);
  }
  
  protected final void e(Format paramFormat)
  {
    super.e(paramFormat);
    e.a locala = this.aTq;
    if (locala.aUk != null) {
      locala.handler.post(new e.a.3(locala, paramFormat));
    }
    if (paramFormat.auy == -1.0F) {}
    for (float f = 1.0F;; f = paramFormat.auy)
    {
      this.aTG = f;
      this.aTF = m(paramFormat);
      return;
    }
  }
  
  public final boolean isReady()
  {
    if ((super.isReady()) && ((this.aTA) || ((this.aTy != null) && (this.avf == this.aTy)) || (this.aFW == null) || (this.axj))) {
      this.aTB = -9223372036854775807L;
    }
    do
    {
      return true;
      if (this.aTB == -9223372036854775807L) {
        return false;
      }
    } while (SystemClock.elapsedRealtime() < this.aTB);
    this.aTB = -9223372036854775807L;
    return false;
  }
  
  protected final void kz()
  {
    this.aTH = -1;
    this.aTI = -1;
    this.aTK = -1.0F;
    this.aTG = -1.0F;
    this.aTQ = -9223372036854775807L;
    this.aTR = 0;
    ou();
    os();
    d locald = this.aTp;
    if (locald.aTV) {
      locald.aTU.handler.sendEmptyMessage(2);
    }
    this.aTP = null;
    this.axj = false;
    try
    {
      super.kz();
      return;
    }
    finally
    {
      this.aGu.lD();
      this.aTq.e(this.aGu);
    }
  }
  
  protected final void mm()
  {
    try
    {
      super.mm();
      return;
    }
    finally
    {
      if (this.aTy != null)
      {
        if (this.avf == this.aTy) {
          this.avf = null;
        }
        this.aTy.release();
        this.aTy = null;
      }
    }
  }
  
  protected final void mo()
  {
    if ((com.google.android.exoplayer2.i.t.SDK_INT < 23) && (this.axj)) {
      ot();
    }
  }
  
  protected final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0) {
        break label175;
      }
      j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
      label65:
      this.aTH = j;
      if (i == 0) {
        break label187;
      }
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label93:
      this.aTI = i;
      this.aTK = this.aTG;
      if (com.google.android.exoplayer2.i.t.SDK_INT < 21) {
        break label198;
      }
      if ((this.aTF == 90) || (this.aTF == 270))
      {
        i = this.aTH;
        this.aTH = this.aTI;
        this.aTI = i;
        this.aTK = (1.0F / this.aTK);
      }
    }
    for (;;)
    {
      paramMediaCodec.setVideoScalingMode(this.aTz);
      return;
      i = 0;
      break;
      label175:
      j = paramMediaFormat.getInteger("width");
      break label65;
      label187:
      i = paramMediaFormat.getInteger("height");
      break label93;
      label198:
      this.aTJ = this.aTF;
    }
  }
  
  protected final void onStarted()
  {
    super.onStarted();
    this.aTD = 0;
    this.aTC = SystemClock.elapsedRealtime();
  }
  
  protected final void onStopped()
  {
    this.aTB = -9223372036854775807L;
    ox();
    super.onStopped();
  }
  
  final void ot()
  {
    if (!this.aTA)
    {
      this.aTA = true;
      this.aTq.c(this.avf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.7.0.1
 */