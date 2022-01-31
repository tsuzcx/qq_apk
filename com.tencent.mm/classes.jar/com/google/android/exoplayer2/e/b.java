package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] aMH = x.aT("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final c aMI;
  private final boolean aMJ;
  private final com.google.android.exoplayer2.b.e aMK;
  private final com.google.android.exoplayer2.b.e aML;
  private final com.google.android.exoplayer2.k aMM;
  private final List<Long> aMN;
  private final MediaCodec.BufferInfo aMO;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aMP;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aMQ;
  protected MediaCodec aMR;
  protected a aMS;
  private int aMT;
  private boolean aMU;
  private boolean aMV;
  private boolean aMW;
  private boolean aMX;
  private boolean aMY;
  private boolean aMZ;
  private boolean aNa;
  private boolean aNb;
  private long aNc;
  private int aNd;
  private int aNe;
  private boolean aNf;
  private boolean aNg;
  private int aNh;
  private int aNi;
  private boolean aNj;
  private boolean aNk;
  private boolean aNl;
  private boolean aNm;
  private boolean aNn;
  private boolean aNo;
  protected com.google.android.exoplayer2.b.d aNp;
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> avq;
  private Format axd;
  private ByteBuffer[] azr;
  private ByteBuffer[] inputBuffers;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aMI = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.avq = paramb;
      this.aMJ = paramBoolean;
      this.aMK = new com.google.android.exoplayer2.b.e(0);
      this.aML = new com.google.android.exoplayer2.b.e(0);
      this.aMM = new com.google.android.exoplayer2.k();
      this.aMN = new ArrayList();
      this.aMO = new MediaCodec.BufferInfo();
      this.aNh = 0;
      this.aNi = 0;
      return;
    }
  }
  
  private void a(b.a parama)
  {
    throw com.google.android.exoplayer2.e.b(parama, this.index);
  }
  
  private boolean h(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.aNe < 0)
    {
      if ((this.aMY) && (this.aNk)) {}
      for (;;)
      {
        try
        {
          this.aNe = this.aMR.dequeueOutputBuffer(this.aMO, 0L);
          if (this.aNe < 0) {
            break label352;
          }
          if (!this.aNb) {
            break;
          }
          this.aNb = false;
          this.aMR.releaseOutputBuffer(this.aNe, false);
          this.aNe = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          oG();
          if (this.aNm) {
            oD();
          }
          return false;
        }
        this.aNe = this.aMR.dequeueOutputBuffer(this.aMO, 0L);
      }
      if ((this.aMO.flags & 0x4) != 0)
      {
        oG();
        this.aNe = -1;
        return false;
      }
      localObject = this.azr[this.aNe];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.aMO.offset);
        ((ByteBuffer)localObject).limit(this.aMO.offset + this.aMO.size);
      }
      long l = this.aMO.presentationTimeUs;
      int j = this.aMN.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.aMN.get(i)).longValue() == l)
      {
        this.aMN.remove(i);
        bool = true;
        label254:
        this.aNf = bool;
      }
    }
    else
    {
      if ((!this.aMY) || (!this.aNk)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.aMR, this.azr[this.aNe], this.aNe, this.aMO.flags, this.aMO.presentationTimeUs, this.aNf);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.aMO.presentationTimeUs;
        this.aNe = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        oG();
        if (!this.aNm) {
          continue;
        }
        oD();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.aNe == -2)
      {
        localObject = this.aMR.getOutputFormat();
        if ((this.aMT != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.aNb = true;
          return true;
        }
        if (this.aMZ) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.aMR, (MediaFormat)localObject);
        continue;
      }
      if (this.aNe == -3)
      {
        this.azr = this.aMR.getOutputBuffers();
        return true;
      }
      if ((this.aMW) && ((this.aNl) || (this.aNi == 2))) {
        oG();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.aMR, this.azr[this.aNe], this.aNe, this.aMO.flags, this.aMO.presentationTimeUs, this.aNf);
    }
    label551:
    return false;
  }
  
  private boolean oE()
  {
    if ((this.aMR == null) || (this.aNi == 2) || (this.aNl)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.aNd < 0)
      {
        this.aNd = this.aMR.dequeueInputBuffer(0L);
        if (this.aNd >= 0)
        {
          this.aMK.aAS = this.inputBuffers[this.aNd];
          this.aMK.clear();
        }
      }
      else
      {
        if (this.aNi == 1)
        {
          if (!this.aMW)
          {
            this.aNk = true;
            this.aMR.queueInputBuffer(this.aNd, 0, 0, 0L, 4);
            this.aNd = -1;
          }
          this.aNi = 2;
          return false;
        }
        if (this.aNa)
        {
          this.aNa = false;
          this.aMK.aAS.put(aMH);
          this.aMR.queueInputBuffer(this.aNd, 0, aMH.length, 0L, 0);
          this.aNd = -1;
          this.aNj = true;
          return true;
        }
        if (this.aNn) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.aMM, this.aMK, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.aNh == 2)
          {
            this.aMK.clear();
            this.aNh = 1;
          }
          e(this.aMM.axd);
          return true;
          if (this.aNh == 1)
          {
            i = 0;
            while (i < this.axd.awM.size())
            {
              byte[] arrayOfByte = (byte[])this.axd.awM.get(i);
              this.aMK.aAS.put(arrayOfByte);
              i += 1;
            }
            this.aNh = 2;
          }
          i = this.aMK.aAS.position();
        }
        continue;
        label330:
        if (this.aMK.nE())
        {
          if (this.aNh == 2)
          {
            this.aMK.clear();
            this.aNh = 1;
          }
          this.aNl = true;
          if (!this.aNj)
          {
            oG();
            return false;
          }
          try
          {
            if (!this.aMW)
            {
              this.aNk = true;
              this.aMR.queueInputBuffer(this.aNd, 0, 0, 0L, 4);
              this.aNd = -1;
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
    if ((this.aNo) && (!this.aMK.nF()))
    {
      this.aMK.clear();
      if (this.aNh == 2) {
        this.aNh = 1;
      }
      return true;
    }
    this.aNo = false;
    boolean bool2 = this.aMK.nI();
    boolean bool1;
    if ((this.aMP == null) || ((!bool2) && (this.aMJ))) {
      bool1 = false;
    }
    for (;;)
    {
      this.aNn = bool1;
      if (this.aNn) {
        break;
      }
      if ((!this.aMU) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.e(this.aMK.aAS);
      if (this.aMK.aAS.position() != 0) {
        break label594;
      }
      return true;
      j = this.aMP.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.aMP.nR(), this.index);
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.aMU = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.aMK.aAT;
        if (this.aMK.nD()) {
          this.aMN.add(Long.valueOf(l));
        }
        this.aMK.nJ();
        oF();
        if (bool2)
        {
          Object localObject = this.aMK.aAR.aAH;
          if (i == 0)
          {
            this.aMR.queueSecureInputBuffer(this.aNd, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.aNd = -1;
            this.aNj = true;
            this.aNh = 0;
            localObject = this.aNp;
            ((com.google.android.exoplayer2.b.d)localObject).aAM += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.aMR.queueInputBuffer(this.aNd, 0, this.aMK.aAS.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, this.index);
      }
    }
  }
  
  private void oG()
  {
    if (this.aNi == 2)
    {
      oD();
      oC();
      return;
    }
    this.aNm = true;
    nB();
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.f(paramFormat.awK, paramBoolean);
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
  
  public void aB(boolean paramBoolean)
  {
    this.aNp = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.aMI, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.avq;
      if (paramFormat.awN != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, this.index);
    }
    boolean bool = localb.nT();
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
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.aNl = false;
    this.aNm = false;
    if (this.aMR != null)
    {
      this.aNc = -9223372036854775807L;
      this.aNd = -1;
      this.aNe = -1;
      this.aNo = true;
      this.aNn = false;
      this.aNf = false;
      this.aMN.clear();
      this.aNa = false;
      this.aNb = false;
      if ((!this.aMV) && ((!this.aMX) || (!this.aNk))) {
        break label117;
      }
      oD();
      oC();
    }
    for (;;)
    {
      if ((this.aNg) && (this.axd != null)) {
        this.aNh = 1;
      }
      return;
      label117:
      if (this.aNi != 0)
      {
        oD();
        oC();
      }
      else
      {
        this.aMR.flush();
        this.aNj = false;
      }
    }
  }
  
  protected void d(String paramString, long paramLong1, long paramLong2) {}
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.axd;
    this.axd = paramFormat;
    DrmInitData localDrmInitData = this.axd.awN;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (x.e(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.axd.awN == null) {
          break label223;
        }
        if (this.avq == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
          paramFormat = localFormat.awN;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.avq;
        Looper.myLooper();
        this.aMQ = paramFormat.nU();
        if (this.aMQ != this.aMP) {}
      }
    }
    if ((this.aMQ == this.aMP) && (this.aMR != null) && (a(this.aMS.aME, localFormat, this.axd)))
    {
      this.aNg = true;
      this.aNh = 1;
      if ((this.aMT == 2) || ((this.aMT == 1) && (this.axd.width == localFormat.width) && (this.axd.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.aNa = bool;
        return;
        label223:
        this.aMQ = null;
        break;
      }
    }
    if (this.aNj)
    {
      this.aNi = 1;
      return;
    }
    oD();
    oC();
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    if (this.aNm) {
      nB();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.axd == null)
        {
          this.aML.clear();
          i = a(this.aMM, this.aML, true);
          if (i == -5) {
            e(this.aMM.axd);
          }
        }
        else
        {
          oC();
          if (this.aMR == null) {
            break;
          }
          v.beginSection("drainAndFeed");
          while (h(paramLong1, paramLong2)) {}
          while (oE()) {}
          v.endSection();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.aML.nE());
      this.aNl = true;
      oG();
      return;
      this.auZ.R(paramLong1 - this.ava);
      this.aML.clear();
      i = a(this.aMM, this.aML, false);
      if (i == -5)
      {
        e(this.aMM.axd);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.aML.nE());
    this.aNl = true;
    oG();
  }
  
  public boolean isReady()
  {
    if ((this.axd != null) && (!this.aNn))
    {
      if (this.avb) {}
      for (boolean bool = this.avc; (bool) || (this.aNe >= 0) || ((this.aNc != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.aNc)); bool = this.auZ.isReady()) {
        return true;
      }
    }
    return false;
  }
  
  public final int mE()
  {
    return 8;
  }
  
  public void mF()
  {
    this.axd = null;
    try
    {
      oD();
      return;
    }
    finally
    {
      this.aMP = null;
      this.aMQ = null;
    }
  }
  
  protected void nB() {}
  
  public boolean nd()
  {
    return this.aNm;
  }
  
  protected final void oC()
  {
    boolean bool3 = false;
    if ((this.aMR != null) || (this.axd == null)) {}
    String str;
    Object localObject3;
    do
    {
      return;
      this.aMP = this.aMQ;
      str = this.axd.awK;
      if (this.aMP == null) {
        break label972;
      }
      localObject3 = (com.google.android.exoplayer2.drm.d)this.aMP.nS();
      if (localObject3 != null) {
        break;
      }
      localObject1 = this.aMP.nR();
    } while (localObject1 == null);
    throw com.google.android.exoplayer2.e.b((Exception)localObject1, this.index);
    Object localObject1 = ((com.google.android.exoplayer2.drm.d)localObject3).aBi;
    boolean bool1;
    if ((!((com.google.android.exoplayer2.drm.d)localObject3).aBj) && (((com.google.android.exoplayer2.drm.d)localObject3).aBi.requiresSecureDecoderComponent(str))) {
      bool1 = true;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.aMS == null) {}
        try
        {
          this.aMS = a(this.aMI, this.axd, bool1);
          if ((this.aMS == null) && (bool1))
          {
            this.aMS = a(this.aMI, this.axd, false);
            if (this.aMS != null) {
              new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.aMS.name).append(".");
            }
          }
          if (this.aMS == null) {
            a(new b.a(this.axd, null, bool1, -49999));
          }
          if (!a(this.aMS)) {
            break;
          }
          str = this.aMS.name;
          if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(str)) && ((x.MODEL.startsWith("SM-T585")) || (x.MODEL.startsWith("SM-A520"))))
          {
            i = 2;
            this.aMT = i;
            localObject3 = this.axd;
            if ((x.SDK_INT >= 21) || (!((Format)localObject3).awM.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
              break label914;
            }
            bool2 = true;
            this.aMU = bool2;
            if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str)) && (!"OMX.SEC.avc.dec.secure".equals(str)))) && ((x.SDK_INT != 19) || (!x.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str)) && (!"OMX.Exynos.avc.dec.secure".equals(str))))) {
              break label919;
            }
            bool2 = true;
            this.aMV = bool2;
            if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str)) && (!"OMX.allwinner.video.decoder.avc".equals(str)))) {
              break label924;
            }
            bool2 = true;
            this.aMW = bool2;
            if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
              break label929;
            }
            bool2 = true;
            this.aMX = bool2;
            if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str))) {
              break label934;
            }
            bool2 = true;
            this.aMY = bool2;
            localObject3 = this.axd;
            bool2 = bool3;
            if (x.SDK_INT <= 18)
            {
              bool2 = bool3;
              if (((Format)localObject3).awU == 1)
              {
                bool2 = bool3;
                if ("OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                  bool2 = true;
                }
              }
            }
            this.aMZ = bool2;
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
              this.aMR = MediaCodec.createByCodecName(str);
              v.endSection();
              v.beginSection("configureCodec");
              a(this.aMS, this.aMR, this.axd, (MediaCrypto)localObject1);
              v.endSection();
              v.beginSection("startCodec");
              this.aMR.start();
              v.endSection();
              long l2 = SystemClock.elapsedRealtime();
              d(str, l2, l2 - l1);
              this.inputBuffers = this.aMR.getInputBuffers();
              this.azr = this.aMR.getOutputBuffers();
              if (this.state != 2) {
                break label964;
              }
              l1 = SystemClock.elapsedRealtime() + 1000L;
              this.aNc = l1;
              this.aNd = -1;
              this.aNe = -1;
              this.aNo = true;
              localObject1 = this.aNp;
              ((com.google.android.exoplayer2.b.d)localObject1).aAK += 1;
              return;
              bool1 = false;
              break;
              localb = localb;
              a(new b.a(this.axd, localb, bool1, -49998));
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
              a(new b.a(this.axd, localException, bool1, localb));
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
  protected void oD()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 426
    //   4: putfield 429	com/google/android/exoplayer2/e/b:aNc	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 266	com/google/android/exoplayer2/e/b:aNd	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 152	com/google/android/exoplayer2/e/b:aNe	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 293	com/google/android/exoplayer2/e/b:aNn	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 221	com/google/android/exoplayer2/e/b:aNf	Z
    //   27: aload_0
    //   28: getfield 124	com/google/android/exoplayer2/e/b:aMN	Ljava/util/List;
    //   31: invokeinterface 430 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 272	com/google/android/exoplayer2/e/b:inputBuffers	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 183	com/google/android/exoplayer2/e/b:azr	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 463	com/google/android/exoplayer2/e/b:aMS	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 436	com/google/android/exoplayer2/e/b:aNg	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 291	com/google/android/exoplayer2/e/b:aNj	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 326	com/google/android/exoplayer2/e/b:aMU	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 432	com/google/android/exoplayer2/e/b:aMV	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 230	com/google/android/exoplayer2/e/b:aMT	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 258	com/google/android/exoplayer2/e/b:aMW	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 434	com/google/android/exoplayer2/e/b:aMX	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 242	com/google/android/exoplayer2/e/b:aMZ	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 285	com/google/android/exoplayer2/e/b:aNa	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 166	com/google/android/exoplayer2/e/b:aNb	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 156	com/google/android/exoplayer2/e/b:aNk	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 131	com/google/android/exoplayer2/e/b:aNh	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 133	com/google/android/exoplayer2/e/b:aNi	I
    //   116: aload_0
    //   117: getfield 111	com/google/android/exoplayer2/e/b:aMK	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 276	com/google/android/exoplayer2/b/e:aAS	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 376	com/google/android/exoplayer2/e/b:aNp	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 672	com/google/android/exoplayer2/b/d:aAL	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 672	com/google/android/exoplayer2/b/d:aAL	I
    //   146: aload_0
    //   147: getfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   150: invokevirtual 675	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   157: invokevirtual 678	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 461	com/google/android/exoplayer2/e/b:aMQ	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 461	com/google/android/exoplayer2/e/b:aMQ	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   225: invokevirtual 678	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 461	com/google/android/exoplayer2/e/b:aMQ	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 158	com/google/android/exoplayer2/e/b:aMR	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 461	com/google/android/exoplayer2/e/b:aMQ	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 324	com/google/android/exoplayer2/e/b:aMP	Lcom/google/android/exoplayer2/drm/a;
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
  
  protected void oF() {}
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */