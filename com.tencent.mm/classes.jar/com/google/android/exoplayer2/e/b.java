package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] biL = x.aR("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> aRD;
  private Format aTo;
  private ByteBuffer[] aVy;
  private final c biM;
  private final boolean biN;
  private final com.google.android.exoplayer2.b.e biO;
  private final com.google.android.exoplayer2.b.e biP;
  private final com.google.android.exoplayer2.k biQ;
  private final List<Long> biR;
  private final MediaCodec.BufferInfo biS;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> biT;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> biU;
  protected MediaCodec biV;
  protected a biW;
  private int biX;
  private boolean biY;
  private boolean biZ;
  private boolean bja;
  private boolean bjb;
  private boolean bjc;
  private boolean bjd;
  private boolean bje;
  private boolean bjf;
  private ByteBuffer[] bjg;
  private long bjh;
  private int bji;
  private int bjj;
  private boolean bjk;
  private boolean bjl;
  private int bjm;
  private int bjn;
  private boolean bjo;
  private boolean bjp;
  private boolean bjq;
  private boolean bjr;
  private boolean bjs;
  private boolean bjt;
  protected com.google.android.exoplayer2.b.d bju;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.biM = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aRD = paramb;
      this.biN = paramBoolean;
      this.biO = new com.google.android.exoplayer2.b.e(0);
      this.biP = new com.google.android.exoplayer2.b.e(0);
      this.biQ = new com.google.android.exoplayer2.k();
      this.biR = new ArrayList();
      this.biS = new MediaCodec.BufferInfo();
      this.bjm = 0;
      this.bjn = 0;
      return;
    }
  }
  
  private void a(a parama)
  {
    throw com.google.android.exoplayer2.e.b(parama, this.index);
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.bjj < 0)
    {
      if ((this.bjc) && (this.bjp)) {}
      for (;;)
      {
        try
        {
          this.bjj = this.biV.dequeueOutputBuffer(this.biS, 0L);
          if (this.bjj < 0) {
            break label352;
          }
          if (!this.bjf) {
            break;
          }
          this.bjf = false;
          this.biV.releaseOutputBuffer(this.bjj, false);
          this.bjj = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          tA();
          if (this.bjr) {
            tx();
          }
          return false;
        }
        this.bjj = this.biV.dequeueOutputBuffer(this.biS, 0L);
      }
      if ((this.biS.flags & 0x4) != 0)
      {
        tA();
        this.bjj = -1;
        return false;
      }
      localObject = this.aVy[this.bjj];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.biS.offset);
        ((ByteBuffer)localObject).limit(this.biS.offset + this.biS.size);
      }
      long l = this.biS.presentationTimeUs;
      int j = this.biR.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.biR.get(i)).longValue() == l)
      {
        this.biR.remove(i);
        bool = true;
        label254:
        this.bjk = bool;
      }
    }
    else
    {
      if ((!this.bjc) || (!this.bjp)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.biV, this.aVy[this.bjj], this.bjj, this.biS.flags, this.biS.presentationTimeUs, this.bjk);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.biS.presentationTimeUs;
        this.bjj = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        tA();
        if (!this.bjr) {
          continue;
        }
        tx();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.bjj == -2)
      {
        localObject = this.biV.getOutputFormat();
        if ((this.biX != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.bjf = true;
          return true;
        }
        if (this.bjd) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.biV, (MediaFormat)localObject);
        continue;
      }
      if (this.bjj == -3)
      {
        this.aVy = this.biV.getOutputBuffers();
        return true;
      }
      if ((this.bja) && ((this.bjq) || (this.bjn == 2))) {
        tA();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.biV, this.aVy[this.bjj], this.bjj, this.biS.flags, this.biS.presentationTimeUs, this.bjk);
    }
    label551:
    return false;
  }
  
  private void tA()
  {
    if (this.bjn == 2)
    {
      tx();
      tw();
      return;
    }
    this.bjr = true;
    sw();
  }
  
  private boolean ty()
  {
    if ((this.biV == null) || (this.bjn == 2) || (this.bjq)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.bji < 0)
      {
        this.bji = this.biV.dequeueInputBuffer(0L);
        if (this.bji >= 0)
        {
          this.biO.aJg = this.bjg[this.bji];
          this.biO.clear();
        }
      }
      else
      {
        if (this.bjn == 1)
        {
          if (!this.bja)
          {
            this.bjp = true;
            this.biV.queueInputBuffer(this.bji, 0, 0, 0L, 4);
            this.bji = -1;
          }
          this.bjn = 2;
          return false;
        }
        if (this.bje)
        {
          this.bje = false;
          this.biO.aJg.put(biL);
          this.biV.queueInputBuffer(this.bji, 0, biL.length, 0L, 0);
          this.bji = -1;
          this.bjo = true;
          return true;
        }
        if (this.bjs) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.biQ, this.biO, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.bjm == 2)
          {
            this.biO.clear();
            this.bjm = 1;
          }
          e(this.biQ.aTo);
          return true;
          if (this.bjm == 1)
          {
            i = 0;
            while (i < this.aTo.aTa.size())
            {
              byte[] arrayOfByte = (byte[])this.aTo.aTa.get(i);
              this.biO.aJg.put(arrayOfByte);
              i += 1;
            }
            this.bjm = 2;
          }
          i = this.biO.aJg.position();
        }
        continue;
        label330:
        if (this.biO.sz())
        {
          if (this.bjm == 2)
          {
            this.biO.clear();
            this.bjm = 1;
          }
          this.bjq = true;
          if (!this.bjo)
          {
            tA();
            return false;
          }
          try
          {
            if (!this.bja)
            {
              this.bjp = true;
              this.biV.queueInputBuffer(this.bji, 0, 0, 0L, 4);
              this.bji = -1;
              return false;
            }
          }
          catch (MediaCodec.CryptoException localCryptoException1)
          {
            throw com.google.android.exoplayer2.e.b(localCryptoException1, this.index);
          }
        }
      }
    }
    if ((this.bjt) && (!this.biO.sA()))
    {
      this.biO.clear();
      if (this.bjm == 2) {
        this.bjm = 1;
      }
      return true;
    }
    this.bjt = false;
    boolean bool2 = this.biO.sD();
    boolean bool1;
    if ((this.biT == null) || ((!bool2) && (this.biN))) {
      bool1 = false;
    }
    for (;;)
    {
      this.bjs = bool1;
      if (this.bjs) {
        break;
      }
      if ((!this.biY) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.h(this.biO.aJg);
      if (this.biO.aJg.position() != 0) {
        break label594;
      }
      return true;
      j = this.biT.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.biT.sM(), this.index);
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.biY = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.biO.timeUs;
        if (this.biO.sy()) {
          this.biR.add(Long.valueOf(l));
        }
        this.biO.sE();
        tz();
        if (bool2)
        {
          Object localObject = this.biO.aWX.aWN;
          if (i == 0)
          {
            this.biV.queueSecureInputBuffer(this.bji, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.bji = -1;
            this.bjo = true;
            this.bjm = 0;
            localObject = this.bju;
            ((com.google.android.exoplayer2.b.d)localObject).aWS += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.biV.queueInputBuffer(this.bji, 0, this.biO.aJg.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, this.index);
      }
    }
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.f(paramFormat.aSY, paramBoolean);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.bjq = false;
    this.bjr = false;
    if (this.biV != null)
    {
      this.bjh = -9223372036854775807L;
      this.bji = -1;
      this.bjj = -1;
      this.bjt = true;
      this.bjs = false;
      this.bjk = false;
      this.biR.clear();
      this.bje = false;
      this.bjf = false;
      if ((!this.biZ) && ((!this.bjb) || (!this.bjp))) {
        break label117;
      }
      tx();
      tw();
    }
    for (;;)
    {
      if ((this.bjl) && (this.aTo != null)) {
        this.bjm = 1;
      }
      return;
      label117:
      if (this.bjn != 0)
      {
        tx();
        tw();
      }
      else
      {
        this.biV.flush();
        this.bjo = false;
      }
    }
  }
  
  protected abstract void a(a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto);
  
  protected abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean);
  
  protected boolean a(a parama)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return false;
  }
  
  public void aN(boolean paramBoolean)
  {
    this.bju = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.biM, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.aRD;
      if (paramFormat.aTb != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, this.index);
    }
    boolean bool = localb.sO();
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
  
  protected void d(String paramString, long paramLong1, long paramLong2) {}
  
  public final void e(long paramLong1, long paramLong2)
  {
    if (this.bjr) {
      sw();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.aTo == null)
        {
          this.biP.clear();
          i = a(this.biQ, this.biP, true);
          if (i == -5) {
            e(this.biQ.aTo);
          }
        }
        else
        {
          tw();
          if (this.biV == null) {
            break;
          }
          v.beginSection("drainAndFeed");
          while (g(paramLong1, paramLong2)) {}
          while (ty()) {}
          v.endSection();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.biP.sz());
      this.bjq = true;
      tA();
      return;
      this.aRn.Y(paramLong1 - this.aRo);
      this.biP.clear();
      i = a(this.biQ, this.biP, false);
      if (i == -5)
      {
        e(this.biQ.aTo);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.biP.sz());
    this.bjq = true;
    tA();
  }
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.aTo;
    this.aTo = paramFormat;
    DrmInitData localDrmInitData = this.aTo.aTb;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (x.g(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.aTo.aTb == null) {
          break label223;
        }
        if (this.aRD == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
          paramFormat = localFormat.aTb;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.aRD;
        Looper.myLooper();
        this.biU = paramFormat.sP();
        if (this.biU != this.biT) {}
      }
    }
    if ((this.biU == this.biT) && (this.biV != null) && (a(this.biW.biI, localFormat, this.aTo)))
    {
      this.bjl = true;
      this.bjm = 1;
      if ((this.biX == 2) || ((this.biX == 1) && (this.aTo.width == localFormat.width) && (this.aTo.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.bje = bool;
        return;
        label223:
        this.biU = null;
        break;
      }
    }
    if (this.bjo)
    {
      this.bjn = 1;
      return;
    }
    tx();
    tw();
  }
  
  public boolean isReady()
  {
    if ((this.aTo != null) && (!this.bjs))
    {
      if (this.aRp) {}
      for (boolean bool = this.aRq; (bool) || (this.bjj >= 0) || ((this.bjh != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.bjh)); bool = this.aRn.isReady()) {
        return true;
      }
    }
    return false;
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
  
  public void rA()
  {
    this.aTo = null;
    try
    {
      tx();
      return;
    }
    finally
    {
      this.biT = null;
      this.biU = null;
    }
  }
  
  public boolean rX()
  {
    return this.bjr;
  }
  
  public final int rz()
  {
    return 8;
  }
  
  protected void sw() {}
  
  protected final void tw()
  {
    boolean bool3 = false;
    if ((this.biV != null) || (this.aTo == null)) {}
    String str;
    Object localObject3;
    do
    {
      return;
      this.biT = this.biU;
      str = this.aTo.aSY;
      if (this.biT == null) {
        break label972;
      }
      localObject3 = (com.google.android.exoplayer2.drm.d)this.biT.sN();
      if (localObject3 != null) {
        break;
      }
      localObject1 = this.biT.sM();
    } while (localObject1 == null);
    throw com.google.android.exoplayer2.e.b((Exception)localObject1, this.index);
    Object localObject1 = ((com.google.android.exoplayer2.drm.d)localObject3).aXm;
    boolean bool1;
    if ((!((com.google.android.exoplayer2.drm.d)localObject3).aXn) && (((com.google.android.exoplayer2.drm.d)localObject3).aXm.requiresSecureDecoderComponent(str))) {
      bool1 = true;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.biW == null) {}
        try
        {
          this.biW = a(this.biM, this.aTo, bool1);
          if ((this.biW == null) && (bool1))
          {
            this.biW = a(this.biM, this.aTo, false);
            if (this.biW != null) {
              new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.biW.name).append(".");
            }
          }
          if (this.biW == null) {
            a(new a(this.aTo, null, bool1, -49999));
          }
          if (!a(this.biW)) {
            break;
          }
          str = this.biW.name;
          if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(str)) && ((x.MODEL.startsWith("SM-T585")) || (x.MODEL.startsWith("SM-A520"))))
          {
            i = 2;
            this.biX = i;
            localObject3 = this.aTo;
            if ((x.SDK_INT >= 21) || (!((Format)localObject3).aTa.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
              break label914;
            }
            bool2 = true;
            this.biY = bool2;
            if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str)) && (!"OMX.SEC.avc.dec.secure".equals(str)))) && ((x.SDK_INT != 19) || (!x.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str)) && (!"OMX.Exynos.avc.dec.secure".equals(str))))) {
              break label919;
            }
            bool2 = true;
            this.biZ = bool2;
            if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str)) && (!"OMX.allwinner.video.decoder.avc".equals(str)))) {
              break label924;
            }
            bool2 = true;
            this.bja = bool2;
            if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
              break label929;
            }
            bool2 = true;
            this.bjb = bool2;
            if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str))) {
              break label934;
            }
            bool2 = true;
            this.bjc = bool2;
            localObject3 = this.aTo;
            bool2 = bool3;
            if (x.SDK_INT <= 18)
            {
              bool2 = bool3;
              if (((Format)localObject3).channelCount == 1)
              {
                bool2 = bool3;
                if ("OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                  bool2 = true;
                }
              }
            }
            this.bjd = bool2;
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
              v.beginSection("createCodec:".concat(String.valueOf(str)));
              this.biV = MediaCodec.createByCodecName(str);
              v.endSection();
              v.beginSection("configureCodec");
              a(this.biW, this.biV, this.aTo, (MediaCrypto)localObject1);
              v.endSection();
              v.beginSection("startCodec");
              this.biV.start();
              v.endSection();
              long l2 = SystemClock.elapsedRealtime();
              d(str, l2, l2 - l1);
              this.bjg = this.biV.getInputBuffers();
              this.aVy = this.biV.getOutputBuffers();
              if (this.state != 2) {
                break label964;
              }
              l1 = SystemClock.elapsedRealtime() + 1000L;
              this.bjh = l1;
              this.bji = -1;
              this.bjj = -1;
              this.bjt = true;
              localObject1 = this.bju;
              ((com.google.android.exoplayer2.b.d)localObject1).aWQ += 1;
              return;
              bool1 = false;
              break;
              localb = localb;
              a(new a(this.aTo, localb, bool1, -49998));
              continue;
              if ((x.SDK_INT < 24) && (("OMX.Nvidia.h264.decode".equals(localb)) || ("OMX.Nvidia.h264.decode.secure".equals(localb))) && (("flounder".equals(x.DEVICE)) || ("flounder_lte".equals(x.DEVICE)) || ("grouper".equals(x.DEVICE)) || ("tilapia".equals(x.DEVICE))))
              {
                i = 1;
              }
              else
              {
                i = 0;
                continue;
                label914:
                bool2 = false;
                continue;
                label919:
                bool2 = false;
                continue;
                label924:
                bool2 = false;
                continue;
                label929:
                bool2 = false;
              }
            }
            label934:
            boolean bool2 = false;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              a(new a(this.aTo, localException, bool1, localb));
              continue;
              label964:
              long l1 = -9223372036854775807L;
            }
          }
        }
      }
      label972:
      bool1 = false;
      Object localObject2 = null;
    }
  }
  
  /* Error */
  protected void tx()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 408
    //   4: putfield 411	com/google/android/exoplayer2/e/b:bjh	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 272	com/google/android/exoplayer2/e/b:bji	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 152	com/google/android/exoplayer2/e/b:bjj	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 299	com/google/android/exoplayer2/e/b:bjs	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 221	com/google/android/exoplayer2/e/b:bjk	Z
    //   27: aload_0
    //   28: getfield 125	com/google/android/exoplayer2/e/b:biR	Ljava/util/List;
    //   31: invokeinterface 412 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 278	com/google/android/exoplayer2/e/b:bjg	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 183	com/google/android/exoplayer2/e/b:aVy	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 492	com/google/android/exoplayer2/e/b:biW	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 418	com/google/android/exoplayer2/e/b:bjl	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 297	com/google/android/exoplayer2/e/b:bjo	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 332	com/google/android/exoplayer2/e/b:biY	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 414	com/google/android/exoplayer2/e/b:biZ	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 230	com/google/android/exoplayer2/e/b:biX	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 258	com/google/android/exoplayer2/e/b:bja	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 416	com/google/android/exoplayer2/e/b:bjb	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 242	com/google/android/exoplayer2/e/b:bjd	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 291	com/google/android/exoplayer2/e/b:bje	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 166	com/google/android/exoplayer2/e/b:bjf	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 156	com/google/android/exoplayer2/e/b:bjp	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 132	com/google/android/exoplayer2/e/b:bjm	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 134	com/google/android/exoplayer2/e/b:bjn	I
    //   116: aload_0
    //   117: getfield 112	com/google/android/exoplayer2/e/b:biO	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 282	com/google/android/exoplayer2/b/e:aJg	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 383	com/google/android/exoplayer2/e/b:bju	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 675	com/google/android/exoplayer2/b/d:aWR	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 675	com/google/android/exoplayer2/b/d:aWR	I
    //   146: aload_0
    //   147: getfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   150: invokevirtual 678	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   157: invokevirtual 681	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 490	com/google/android/exoplayer2/e/b:biU	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 490	com/google/android/exoplayer2/e/b:biU	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   225: invokevirtual 681	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 490	com/google/android/exoplayer2/e/b:biU	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 158	com/google/android/exoplayer2/e/b:biV	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 490	com/google/android/exoplayer2/e/b:biU	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 330	com/google/android/exoplayer2/e/b:biT	Lcom/google/android/exoplayer2/drm/a;
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
  
  protected void tz() {}
  
  public static final class a
    extends Exception
  {
    public final boolean bjv;
    public final String bjw;
    public final String bjx;
    public final String mimeType;
    
    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
    {
      super(paramThrowable);
      AppMethodBeat.i(92357);
      this.mimeType = paramFormat.aSY;
      this.bjv = paramBoolean;
      this.bjw = null;
      if (paramInt < 0) {}
      for (paramFormat = "neg_";; paramFormat = "")
      {
        this.bjx = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
        AppMethodBeat.o(92357);
        return;
      }
    }
    
    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
    {
      super(paramThrowable);
      AppMethodBeat.i(92358);
      this.mimeType = paramFormat.aSY;
      this.bjv = paramBoolean;
      this.bjw = paramString;
      paramFormat = localObject;
      if (x.SDK_INT >= 21)
      {
        paramFormat = localObject;
        if ((paramThrowable instanceof MediaCodec.CodecException)) {
          paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
        }
      }
      this.bjx = paramFormat;
      AppMethodBeat.o(92358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */