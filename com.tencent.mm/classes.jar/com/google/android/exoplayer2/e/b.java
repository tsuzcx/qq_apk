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
import com.google.android.exoplayer2.source.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] big = x.aZ("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> aQI;
  private Format aSv;
  private ByteBuffer[] aUK;
  private boolean biA;
  private ByteBuffer[] biB;
  private long biC;
  private int biD;
  private int biE;
  private boolean biF;
  private boolean biG;
  private int biH;
  private int biI;
  private boolean biJ;
  private boolean biK;
  private boolean biL;
  private boolean biM;
  private boolean biN;
  private boolean biO;
  protected com.google.android.exoplayer2.b.d biP;
  private final c bih;
  private final boolean bii;
  private final com.google.android.exoplayer2.b.e bij;
  private final com.google.android.exoplayer2.b.e bik;
  private final com.google.android.exoplayer2.k bil;
  private final List<Long> bim;
  private final MediaCodec.BufferInfo bin;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> bio;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> bip;
  protected MediaCodec biq;
  protected a bir;
  private int bis;
  private boolean bit;
  private boolean biu;
  private boolean biv;
  private boolean biw;
  private boolean bix;
  private boolean biy;
  private boolean biz;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bih = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aQI = paramb;
      this.bii = paramBoolean;
      this.bij = new com.google.android.exoplayer2.b.e(0);
      this.bik = new com.google.android.exoplayer2.b.e(0);
      this.bil = new com.google.android.exoplayer2.k();
      this.bim = new ArrayList();
      this.bin = new MediaCodec.BufferInfo();
      this.biH = 0;
      this.biI = 0;
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
    if (this.biE < 0)
    {
      if ((this.bix) && (this.biK)) {}
      for (;;)
      {
        try
        {
          this.biE = this.biq.dequeueOutputBuffer(this.bin, 0L);
          if (this.biE < 0) {
            break label352;
          }
          if (!this.biA) {
            break;
          }
          this.biA = false;
          this.biq.releaseOutputBuffer(this.biE, false);
          this.biE = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          ts();
          if (this.biM) {
            tp();
          }
          return false;
        }
        this.biE = this.biq.dequeueOutputBuffer(this.bin, 0L);
      }
      if ((this.bin.flags & 0x4) != 0)
      {
        ts();
        this.biE = -1;
        return false;
      }
      localObject = this.aUK[this.biE];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.bin.offset);
        ((ByteBuffer)localObject).limit(this.bin.offset + this.bin.size);
      }
      long l = this.bin.presentationTimeUs;
      int j = this.bim.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.bim.get(i)).longValue() == l)
      {
        this.bim.remove(i);
        bool = true;
        label254:
        this.biF = bool;
      }
    }
    else
    {
      if ((!this.bix) || (!this.biK)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.biq, this.aUK[this.biE], this.biE, this.bin.flags, this.bin.presentationTimeUs, this.biF);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.bin.presentationTimeUs;
        this.biE = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        ts();
        if (!this.biM) {
          continue;
        }
        tp();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.biE == -2)
      {
        localObject = this.biq.getOutputFormat();
        if ((this.bis != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.biA = true;
          return true;
        }
        if (this.biy) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.biq, (MediaFormat)localObject);
        continue;
      }
      if (this.biE == -3)
      {
        this.aUK = this.biq.getOutputBuffers();
        return true;
      }
      if ((this.biv) && ((this.biL) || (this.biI == 2))) {
        ts();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.biq, this.aUK[this.biE], this.biE, this.bin.flags, this.bin.presentationTimeUs, this.biF);
    }
    label551:
    return false;
  }
  
  private boolean tq()
  {
    if ((this.biq == null) || (this.biI == 2) || (this.biL)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.biD < 0)
      {
        this.biD = this.biq.dequeueInputBuffer(0L);
        if (this.biD >= 0)
        {
          this.bij.aIq = this.biB[this.biD];
          this.bij.clear();
        }
      }
      else
      {
        if (this.biI == 1)
        {
          if (!this.biv)
          {
            this.biK = true;
            this.biq.queueInputBuffer(this.biD, 0, 0, 0L, 4);
            this.biD = -1;
          }
          this.biI = 2;
          return false;
        }
        if (this.biz)
        {
          this.biz = false;
          this.bij.aIq.put(big);
          this.biq.queueInputBuffer(this.biD, 0, big.length, 0L, 0);
          this.biD = -1;
          this.biJ = true;
          return true;
        }
        if (this.biN) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.bil, this.bij, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.biH == 2)
          {
            this.bij.clear();
            this.biH = 1;
          }
          e(this.bil.aSv);
          return true;
          if (this.biH == 1)
          {
            i = 0;
            while (i < this.aSv.aSf.size())
            {
              byte[] arrayOfByte = (byte[])this.aSv.aSf.get(i);
              this.bij.aIq.put(arrayOfByte);
              i += 1;
            }
            this.biH = 2;
          }
          i = this.bij.aIq.position();
        }
        continue;
        label330:
        if (this.bij.sq())
        {
          if (this.biH == 2)
          {
            this.bij.clear();
            this.biH = 1;
          }
          this.biL = true;
          if (!this.biJ)
          {
            ts();
            return false;
          }
          try
          {
            if (!this.biv)
            {
              this.biK = true;
              this.biq.queueInputBuffer(this.biD, 0, 0, 0L, 4);
              this.biD = -1;
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
    if ((this.biO) && (!this.bij.sr()))
    {
      this.bij.clear();
      if (this.biH == 2) {
        this.biH = 1;
      }
      return true;
    }
    this.biO = false;
    boolean bool2 = this.bij.su();
    boolean bool1;
    if ((this.bio == null) || ((!bool2) && (this.bii))) {
      bool1 = false;
    }
    for (;;)
    {
      this.biN = bool1;
      if (this.biN) {
        break;
      }
      if ((!this.bit) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.h(this.bij.aIq);
      if (this.bij.aIq.position() != 0) {
        break label594;
      }
      return true;
      j = this.bio.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.bio.sD(), this.index);
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.bit = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.bij.timeUs;
        if (this.bij.sp()) {
          this.bim.add(Long.valueOf(l));
        }
        this.bij.sv();
        tr();
        if (bool2)
        {
          Object localObject = this.bij.aWk.aWa;
          if (i == 0)
          {
            this.biq.queueSecureInputBuffer(this.biD, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.biD = -1;
            this.biJ = true;
            this.biH = 0;
            localObject = this.biP;
            ((com.google.android.exoplayer2.b.d)localObject).aWf += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.biq.queueInputBuffer(this.biD, 0, this.bij.aIq.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, this.index);
      }
    }
  }
  
  private void ts()
  {
    if (this.biI == 2)
    {
      tp();
      to();
      return;
    }
    this.biM = true;
    sn();
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.f(paramFormat.aSd, paramBoolean);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.biL = false;
    this.biM = false;
    if (this.biq != null)
    {
      this.biC = -9223372036854775807L;
      this.biD = -1;
      this.biE = -1;
      this.biO = true;
      this.biN = false;
      this.biF = false;
      this.bim.clear();
      this.biz = false;
      this.biA = false;
      if ((!this.biu) && ((!this.biw) || (!this.biK))) {
        break label117;
      }
      tp();
      to();
    }
    for (;;)
    {
      if ((this.biG) && (this.aSv != null)) {
        this.biH = 1;
      }
      return;
      label117:
      if (this.biI != 0)
      {
        tp();
        to();
      }
      else
      {
        this.biq.flush();
        this.biJ = false;
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
    this.biP = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.bih, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.aQI;
      if (paramFormat.aSg != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, this.index);
    }
    boolean bool = localb.sF();
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
    if (this.biM) {
      sn();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.aSv == null)
        {
          this.bik.clear();
          i = a(this.bil, this.bik, true);
          if (i == -5) {
            e(this.bil.aSv);
          }
        }
        else
        {
          to();
          if (this.biq == null) {
            break;
          }
          v.beginSection("drainAndFeed");
          while (g(paramLong1, paramLong2)) {}
          while (tq()) {}
          v.endSection();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.bik.sq());
      this.biL = true;
      ts();
      return;
      this.aQs.X(paramLong1 - this.aQt);
      this.bik.clear();
      i = a(this.bil, this.bik, false);
      if (i == -5)
      {
        e(this.bil.aSv);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.bik.sq());
    this.biL = true;
    ts();
  }
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.aSv;
    this.aSv = paramFormat;
    DrmInitData localDrmInitData = this.aSv.aSg;
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
        if (this.aSv.aSg == null) {
          break label223;
        }
        if (this.aQI == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
          paramFormat = localFormat.aSg;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.aQI;
        Looper.myLooper();
        this.bip = paramFormat.sG();
        if (this.bip != this.bio) {}
      }
    }
    if ((this.bip == this.bio) && (this.biq != null) && (a(this.bir.bid, localFormat, this.aSv)))
    {
      this.biG = true;
      this.biH = 1;
      if ((this.bis == 2) || ((this.bis == 1) && (this.aSv.width == localFormat.width) && (this.aSv.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.biz = bool;
        return;
        label223:
        this.bip = null;
        break;
      }
    }
    if (this.biJ)
    {
      this.biI = 1;
      return;
    }
    tp();
    to();
  }
  
  public boolean isReady()
  {
    if ((this.aSv != null) && (!this.biN))
    {
      if (this.aQu) {}
      for (boolean bool = this.aQv; (bool) || (this.biE >= 0) || ((this.biC != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.biC)); bool = this.aQs.isReady()) {
        return true;
      }
    }
    return false;
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
  
  public boolean rM()
  {
    return this.biM;
  }
  
  public final int ro()
  {
    return 8;
  }
  
  public void rp()
  {
    this.aSv = null;
    try
    {
      tp();
      return;
    }
    finally
    {
      this.bio = null;
      this.bip = null;
    }
  }
  
  protected void sn() {}
  
  protected final void to()
  {
    boolean bool3 = false;
    if ((this.biq != null) || (this.aSv == null)) {}
    String str;
    Object localObject3;
    do
    {
      return;
      this.bio = this.bip;
      str = this.aSv.aSd;
      if (this.bio == null) {
        break label972;
      }
      localObject3 = (com.google.android.exoplayer2.drm.d)this.bio.sE();
      if (localObject3 != null) {
        break;
      }
      localObject1 = this.bio.sD();
    } while (localObject1 == null);
    throw com.google.android.exoplayer2.e.b((Exception)localObject1, this.index);
    Object localObject1 = ((com.google.android.exoplayer2.drm.d)localObject3).aWA;
    boolean bool1;
    if ((!((com.google.android.exoplayer2.drm.d)localObject3).aWB) && (((com.google.android.exoplayer2.drm.d)localObject3).aWA.requiresSecureDecoderComponent(str))) {
      bool1 = true;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.bir == null) {}
        try
        {
          this.bir = a(this.bih, this.aSv, bool1);
          if ((this.bir == null) && (bool1))
          {
            this.bir = a(this.bih, this.aSv, false);
            if (this.bir != null) {
              new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.bir.name).append(".");
            }
          }
          if (this.bir == null) {
            a(new a(this.aSv, null, bool1, -49999));
          }
          if (!a(this.bir)) {
            break;
          }
          str = this.bir.name;
          if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(str)) && ((x.MODEL.startsWith("SM-T585")) || (x.MODEL.startsWith("SM-A520"))))
          {
            i = 2;
            this.bis = i;
            localObject3 = this.aSv;
            if ((x.SDK_INT >= 21) || (!((Format)localObject3).aSf.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
              break label914;
            }
            bool2 = true;
            this.bit = bool2;
            if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str)) && (!"OMX.SEC.avc.dec.secure".equals(str)))) && ((x.SDK_INT != 19) || (!x.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str)) && (!"OMX.Exynos.avc.dec.secure".equals(str))))) {
              break label919;
            }
            bool2 = true;
            this.biu = bool2;
            if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str)) && (!"OMX.allwinner.video.decoder.avc".equals(str)))) {
              break label924;
            }
            bool2 = true;
            this.biv = bool2;
            if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
              break label929;
            }
            bool2 = true;
            this.biw = bool2;
            if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str))) {
              break label934;
            }
            bool2 = true;
            this.bix = bool2;
            localObject3 = this.aSv;
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
            this.biy = bool2;
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
              this.biq = MediaCodec.createByCodecName(str);
              v.endSection();
              v.beginSection("configureCodec");
              a(this.bir, this.biq, this.aSv, (MediaCrypto)localObject1);
              v.endSection();
              v.beginSection("startCodec");
              this.biq.start();
              v.endSection();
              long l2 = SystemClock.elapsedRealtime();
              d(str, l2, l2 - l1);
              this.biB = this.biq.getInputBuffers();
              this.aUK = this.biq.getOutputBuffers();
              if (this.state != 2) {
                break label964;
              }
              l1 = SystemClock.elapsedRealtime() + 1000L;
              this.biC = l1;
              this.biD = -1;
              this.biE = -1;
              this.biO = true;
              localObject1 = this.biP;
              ((com.google.android.exoplayer2.b.d)localObject1).aWd += 1;
              return;
              bool1 = false;
              break;
              localb = localb;
              a(new a(this.aSv, localb, bool1, -49998));
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
              a(new a(this.aSv, localException, bool1, localb));
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
  protected void tp()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 408
    //   4: putfield 411	com/google/android/exoplayer2/e/b:biC	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 266	com/google/android/exoplayer2/e/b:biD	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 152	com/google/android/exoplayer2/e/b:biE	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 293	com/google/android/exoplayer2/e/b:biN	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 221	com/google/android/exoplayer2/e/b:biF	Z
    //   27: aload_0
    //   28: getfield 125	com/google/android/exoplayer2/e/b:bim	Ljava/util/List;
    //   31: invokeinterface 412 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 272	com/google/android/exoplayer2/e/b:biB	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 183	com/google/android/exoplayer2/e/b:aUK	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 492	com/google/android/exoplayer2/e/b:bir	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 418	com/google/android/exoplayer2/e/b:biG	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 291	com/google/android/exoplayer2/e/b:biJ	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 326	com/google/android/exoplayer2/e/b:bit	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 414	com/google/android/exoplayer2/e/b:biu	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 230	com/google/android/exoplayer2/e/b:bis	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 258	com/google/android/exoplayer2/e/b:biv	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 416	com/google/android/exoplayer2/e/b:biw	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 242	com/google/android/exoplayer2/e/b:biy	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 285	com/google/android/exoplayer2/e/b:biz	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 166	com/google/android/exoplayer2/e/b:biA	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 156	com/google/android/exoplayer2/e/b:biK	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 132	com/google/android/exoplayer2/e/b:biH	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 134	com/google/android/exoplayer2/e/b:biI	I
    //   116: aload_0
    //   117: getfield 112	com/google/android/exoplayer2/e/b:bij	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 276	com/google/android/exoplayer2/b/e:aIq	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 377	com/google/android/exoplayer2/e/b:biP	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 675	com/google/android/exoplayer2/b/d:aWe	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 675	com/google/android/exoplayer2/b/d:aWe	I
    //   146: aload_0
    //   147: getfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   150: invokevirtual 678	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   157: invokevirtual 681	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 490	com/google/android/exoplayer2/e/b:bip	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 490	com/google/android/exoplayer2/e/b:bip	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   225: invokevirtual 681	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 490	com/google/android/exoplayer2/e/b:bip	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 158	com/google/android/exoplayer2/e/b:biq	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 490	com/google/android/exoplayer2/e/b:bip	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 324	com/google/android/exoplayer2/e/b:bio	Lcom/google/android/exoplayer2/drm/a;
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
  
  protected void tr() {}
  
  public static final class a
    extends Exception
  {
    public final boolean biQ;
    public final String biR;
    public final String biS;
    public final String mimeType;
    
    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
    {
      super(paramThrowable);
      AppMethodBeat.i(92357);
      this.mimeType = paramFormat.aSd;
      this.biQ = paramBoolean;
      this.biR = null;
      if (paramInt < 0) {}
      for (paramFormat = "neg_";; paramFormat = "")
      {
        this.biS = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
        AppMethodBeat.o(92357);
        return;
      }
    }
    
    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
    {
      super(paramThrowable);
      AppMethodBeat.i(92358);
      this.mimeType = paramFormat.aSd;
      this.biQ = paramBoolean;
      this.biR = paramString;
      paramFormat = localObject;
      if (x.SDK_INT >= 21)
      {
        paramFormat = localObject;
        if ((paramThrowable instanceof MediaCodec.CodecException)) {
          paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
        }
      }
      this.biS = paramFormat;
      AppMethodBeat.o(92358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */