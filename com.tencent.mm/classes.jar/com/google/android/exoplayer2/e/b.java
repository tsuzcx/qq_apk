package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
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

@TargetApi(16)
public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] bcD = x.bV("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> aLu;
  private Format aNg;
  private ByteBuffer[] aPq;
  private final c bcE;
  private final boolean bcF;
  private final com.google.android.exoplayer2.b.e bcG;
  private final com.google.android.exoplayer2.b.e bcH;
  private final com.google.android.exoplayer2.k bcI;
  private final List<Long> bcJ;
  private final MediaCodec.BufferInfo bcK;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> bcL;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> bcM;
  private MediaCodec bcN;
  private a bcO;
  private int bcP;
  private boolean bcQ;
  private boolean bcR;
  private boolean bcS;
  private boolean bcT;
  private boolean bcU;
  private boolean bcV;
  private boolean bcW;
  private boolean bcX;
  private ByteBuffer[] bcY;
  private long bcZ;
  private int bda;
  private int bdb;
  private boolean bdc;
  private boolean bdd;
  private int bde;
  private int bdf;
  private boolean bdg;
  private boolean bdh;
  private boolean bdi;
  private boolean bdj;
  private boolean bdk;
  private boolean bdl;
  protected com.google.android.exoplayer2.b.d bdm;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bcE = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aLu = paramb;
      this.bcF = paramBoolean;
      this.bcG = new com.google.android.exoplayer2.b.e(0);
      this.bcH = new com.google.android.exoplayer2.b.e(0);
      this.bcI = new com.google.android.exoplayer2.k();
      this.bcJ = new ArrayList();
      this.bcK = new MediaCodec.BufferInfo();
      this.bde = 0;
      this.bdf = 0;
      return;
    }
  }
  
  private void a(a parama)
  {
    throw com.google.android.exoplayer2.e.b(parama, getIndex());
  }
  
  private boolean h(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.bdb < 0)
    {
      if ((this.bcU) && (this.bdh)) {}
      for (;;)
      {
        try
        {
          this.bdb = this.bcN.dequeueOutputBuffer(this.bcK, 0L);
          if (this.bdb < 0) {
            break label352;
          }
          if (!this.bcX) {
            break;
          }
          this.bcX = false;
          this.bcN.releaseOutputBuffer(this.bdb, false);
          this.bdb = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          tb();
          if (this.bdj) {
            sY();
          }
          return false;
        }
        this.bdb = this.bcN.dequeueOutputBuffer(this.bcK, 0L);
      }
      if ((this.bcK.flags & 0x4) != 0)
      {
        tb();
        this.bdb = -1;
        return false;
      }
      localObject = this.aPq[this.bdb];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.bcK.offset);
        ((ByteBuffer)localObject).limit(this.bcK.offset + this.bcK.size);
      }
      long l = this.bcK.presentationTimeUs;
      int j = this.bcJ.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.bcJ.get(i)).longValue() == l)
      {
        this.bcJ.remove(i);
        bool = true;
        label254:
        this.bdc = bool;
      }
    }
    else
    {
      if ((!this.bcU) || (!this.bdh)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.bcN, this.aPq[this.bdb], this.bdb, this.bcK.flags, this.bcK.presentationTimeUs, this.bdc);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.bcK.presentationTimeUs;
        this.bdb = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        tb();
        if (!this.bdj) {
          continue;
        }
        sY();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.bdb == -2)
      {
        localObject = this.bcN.getOutputFormat();
        if ((this.bcP != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.bcX = true;
          return true;
        }
        if (this.bcV) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.bcN, (MediaFormat)localObject);
        continue;
      }
      if (this.bdb == -3)
      {
        this.aPq = this.bcN.getOutputBuffers();
        return true;
      }
      if ((this.bcS) && ((this.bdi) || (this.bdf == 2))) {
        tb();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.bcN, this.aPq[this.bdb], this.bdb, this.bcK.flags, this.bcK.presentationTimeUs, this.bdc);
    }
    label551:
    return false;
  }
  
  private boolean sZ()
  {
    if ((this.bcN == null) || (this.bdf == 2) || (this.bdi)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.bda < 0)
      {
        this.bda = this.bcN.dequeueInputBuffer(0L);
        if (this.bda >= 0)
        {
          this.bcG.aQU = this.bcY[this.bda];
          this.bcG.clear();
        }
      }
      else
      {
        if (this.bdf == 1)
        {
          if (!this.bcS)
          {
            this.bdh = true;
            this.bcN.queueInputBuffer(this.bda, 0, 0, 0L, 4);
            this.bda = -1;
          }
          this.bdf = 2;
          return false;
        }
        if (this.bcW)
        {
          this.bcW = false;
          this.bcG.aQU.put(bcD);
          this.bcN.queueInputBuffer(this.bda, 0, bcD.length, 0L, 0);
          this.bda = -1;
          this.bdg = true;
          return true;
        }
        if (this.bdk) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.bcI, this.bcG, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.bde == 2)
          {
            this.bcG.clear();
            this.bde = 1;
          }
          e(this.bcI.aNg);
          return true;
          if (this.bde == 1)
          {
            i = 0;
            while (i < this.aNg.aMS.size())
            {
              byte[] arrayOfByte = (byte[])this.aNg.aMS.get(i);
              this.bcG.aQU.put(arrayOfByte);
              i += 1;
            }
            this.bde = 2;
          }
          i = this.bcG.aQU.position();
        }
        continue;
        label330:
        if (this.bcG.rV())
        {
          if (this.bde == 2)
          {
            this.bcG.clear();
            this.bde = 1;
          }
          this.bdi = true;
          if (!this.bdg)
          {
            tb();
            return false;
          }
          try
          {
            if (!this.bcS)
            {
              this.bdh = true;
              this.bcN.queueInputBuffer(this.bda, 0, 0, 0L, 4);
              this.bda = -1;
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
    if ((this.bdl) && (!this.bcG.rW()))
    {
      this.bcG.clear();
      if (this.bde == 2) {
        this.bde = 1;
      }
      return true;
    }
    this.bdl = false;
    boolean bool2 = this.bcG.rZ();
    boolean bool1;
    if ((this.bcL == null) || ((!bool2) && (this.bcF))) {
      bool1 = false;
    }
    for (;;)
    {
      this.bdk = bool1;
      if (this.bdk) {
        break;
      }
      if ((!this.bcQ) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.e(this.bcG.aQU);
      if (this.bcG.aQU.position() != 0) {
        break label594;
      }
      return true;
      j = this.bcL.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.bcL.sk(), getIndex());
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.bcQ = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.bcG.timeUs;
        if (this.bcG.rU()) {
          this.bcJ.add(Long.valueOf(l));
        }
        this.bcG.sa();
        ta();
        if (bool2)
        {
          Object localObject = this.bcG.aQT.aQJ;
          if (i == 0)
          {
            this.bcN.queueSecureInputBuffer(this.bda, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.bda = -1;
            this.bdg = true;
            this.bde = 0;
            localObject = this.bdm;
            ((com.google.android.exoplayer2.b.d)localObject).aQO += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.bcN.queueInputBuffer(this.bda, 0, this.bcG.aQU.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, getIndex());
      }
    }
  }
  
  private void tb()
  {
    if (this.bdf == 2)
    {
      sY();
      sV();
      return;
    }
    this.bdj = true;
    rS();
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.e(paramFormat.aMQ, paramBoolean);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.bdi = false;
    this.bdj = false;
    if (this.bcN != null)
    {
      this.bcZ = -9223372036854775807L;
      this.bda = -1;
      this.bdb = -1;
      this.bdl = true;
      this.bdk = false;
      this.bdc = false;
      this.bcJ.clear();
      this.bcW = false;
      this.bcX = false;
      if ((!this.bcR) && ((!this.bcT) || (!this.bdh))) {
        break label117;
      }
      sY();
      sV();
    }
    for (;;)
    {
      if ((this.bdd) && (this.aNg != null)) {
        this.bde = 1;
      }
      return;
      label117:
      if (this.bdf != 0)
      {
        sY();
        sV();
      }
      else
      {
        this.bcN.flush();
        this.bdg = false;
      }
    }
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
  
  public void aL(boolean paramBoolean)
  {
    this.bdm = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.bcE, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.aLu;
      if (paramFormat.aMT != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, getIndex());
    }
    boolean bool = localb.sm();
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
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.aNg;
    this.aNg = paramFormat;
    DrmInitData localDrmInitData = this.aNg.aMT;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (x.h(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.aNg.aMT == null) {
          break label223;
        }
        if (this.aLu == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
          paramFormat = localFormat.aMT;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.aLu;
        Looper.myLooper();
        this.bcM = paramFormat.sn();
        if (this.bcM != this.bcL) {}
      }
    }
    if ((this.bcM == this.bcL) && (this.bcN != null) && (a(this.bcO.bcA, localFormat, this.aNg)))
    {
      this.bdd = true;
      this.bde = 1;
      if ((this.bcP == 2) || ((this.bcP == 1) && (this.aNg.width == localFormat.width) && (this.aNg.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.bcW = bool;
        return;
        label223:
        this.bcM = null;
        break;
      }
    }
    if (this.bdg)
    {
      this.bdf = 1;
      return;
    }
    sY();
    sV();
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    if (this.bdj) {
      rS();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.aNg == null)
        {
          this.bcH.clear();
          i = a(this.bcI, this.bcH, true);
          if (i == -5) {
            e(this.bcI.aNg);
          }
        }
        else
        {
          sV();
          if (this.bcN == null) {
            break;
          }
          v.D("drainAndFeed");
          while (h(paramLong1, paramLong2)) {}
          while (sZ()) {}
          v.gH();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.bcH.rV());
      this.bdi = true;
      tb();
      return;
      x(paramLong1);
      this.bcH.clear();
      i = a(this.bcI, this.bcH, false);
      if (i == -5)
      {
        e(this.bcI.aNg);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.bcH.rV());
    this.bdi = true;
    tb();
  }
  
  public boolean isReady()
  {
    return (this.aNg != null) && (!this.bdk) && ((qW()) || (this.bdb >= 0) || ((this.bcZ != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.bcZ)));
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public final int qR()
  {
    return 8;
  }
  
  public void qS() {}
  
  public void qT() {}
  
  public void qU()
  {
    this.aNg = null;
    try
    {
      sY();
      return;
    }
    finally
    {
      this.bcL = null;
      this.bcM = null;
    }
  }
  
  protected void rS() {}
  
  public boolean rt()
  {
    return this.bdj;
  }
  
  protected final void sV()
  {
    boolean bool2 = false;
    if ((this.bcN != null) || (this.aNg == null)) {}
    for (;;)
    {
      return;
      this.bcL = this.bcM;
      Object localObject;
      if (this.bcL != null)
      {
        if ((com.google.android.exoplayer2.drm.d)this.bcL.sl() == null)
        {
          localObject = this.bcL.sk();
          if (localObject == null) {
            continue;
          }
          throw com.google.android.exoplayer2.e.b((Exception)localObject, getIndex());
        }
        throw null;
      }
      if (this.bcO == null) {}
      try
      {
        this.bcO = a(this.bcE, this.aNg, false);
        if (this.bcO == null) {
          a(new a(this.aNg, null, -49999));
        }
        if (!a(this.bcO)) {
          continue;
        }
        localObject = this.bcO.name;
        if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(localObject)) && ((x.brq.startsWith("SM-T585")) || (x.brq.startsWith("SM-A520"))))
        {
          i = 2;
          this.bcP = i;
          Format localFormat = this.aNg;
          if ((x.SDK_INT >= 21) || (!localFormat.aMS.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(localObject))) {
            break label787;
          }
          bool1 = true;
          this.bcQ = bool1;
          if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(localObject)) && (!"OMX.SEC.avc.dec.secure".equals(localObject)))) && ((x.SDK_INT != 19) || (!x.brq.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(localObject)) && (!"OMX.Exynos.avc.dec.secure".equals(localObject))))) {
            break label792;
          }
          bool1 = true;
          this.bcR = bool1;
          if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(localObject)) && (!"OMX.allwinner.video.decoder.avc".equals(localObject)))) {
            break label797;
          }
          bool1 = true;
          this.bcS = bool1;
          if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(localObject))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.bro)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(localObject)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(localObject))))) {
            break label802;
          }
          bool1 = true;
          this.bcT = bool1;
          if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(localObject))) {
            break label807;
          }
          bool1 = true;
          this.bcU = bool1;
          localFormat = this.aNg;
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
          this.bcV = bool1;
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
            v.D("createCodec:".concat(String.valueOf(localObject)));
            this.bcN = MediaCodec.createByCodecName((String)localObject);
            v.gH();
            v.D("configureCodec");
            a(this.bcO, this.bcN, this.aNg);
            v.gH();
            v.D("startCodec");
            this.bcN.start();
            v.gH();
            long l2 = SystemClock.elapsedRealtime();
            d((String)localObject, l2, l2 - l1);
            this.bcY = this.bcN.getInputBuffers();
            this.aPq = this.bcN.getOutputBuffers();
            if (getState() != 2) {
              break;
            }
            l1 = SystemClock.elapsedRealtime() + 1000L;
            this.bcZ = l1;
            this.bda = -1;
            this.bdb = -1;
            this.bdl = true;
            localObject = this.bdm;
            ((com.google.android.exoplayer2.b.d)localObject).aQM += 1;
            return;
            localb = localb;
            a(new a(this.aNg, localb, -49998));
            continue;
            if ((x.SDK_INT < 24) && (("OMX.Nvidia.h264.decode".equals(localb)) || ("OMX.Nvidia.h264.decode.secure".equals(localb))) && (("flounder".equals(x.bro)) || ("flounder_lte".equals(x.bro)) || ("grouper".equals(x.bro)) || ("tilapia".equals(x.bro))))
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
            a(new a(this.aNg, localException, localb));
            continue;
            long l1 = -9223372036854775807L;
          }
        }
      }
    }
  }
  
  protected final MediaCodec sW()
  {
    return this.bcN;
  }
  
  protected final a sX()
  {
    return this.bcO;
  }
  
  /* Error */
  protected void sY()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 406
    //   4: putfield 409	com/google/android/exoplayer2/e/b:bcZ	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 266	com/google/android/exoplayer2/e/b:bda	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 153	com/google/android/exoplayer2/e/b:bdb	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 293	com/google/android/exoplayer2/e/b:bdk	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 221	com/google/android/exoplayer2/e/b:bdc	Z
    //   27: aload_0
    //   28: getfield 125	com/google/android/exoplayer2/e/b:bcJ	Ljava/util/List;
    //   31: invokeinterface 410 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 272	com/google/android/exoplayer2/e/b:bcY	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 184	com/google/android/exoplayer2/e/b:aPq	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 462	com/google/android/exoplayer2/e/b:bcO	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 416	com/google/android/exoplayer2/e/b:bdd	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 291	com/google/android/exoplayer2/e/b:bdg	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 326	com/google/android/exoplayer2/e/b:bcQ	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 412	com/google/android/exoplayer2/e/b:bcR	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 230	com/google/android/exoplayer2/e/b:bcP	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 258	com/google/android/exoplayer2/e/b:bcS	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 414	com/google/android/exoplayer2/e/b:bcT	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 242	com/google/android/exoplayer2/e/b:bcV	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 285	com/google/android/exoplayer2/e/b:bcW	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 167	com/google/android/exoplayer2/e/b:bcX	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 157	com/google/android/exoplayer2/e/b:bdh	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 132	com/google/android/exoplayer2/e/b:bde	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 134	com/google/android/exoplayer2/e/b:bdf	I
    //   116: aload_0
    //   117: getfield 112	com/google/android/exoplayer2/e/b:bcG	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 276	com/google/android/exoplayer2/b/e:aQU	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 376	com/google/android/exoplayer2/e/b:bdm	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 637	com/google/android/exoplayer2/b/d:aQN	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 637	com/google/android/exoplayer2/b/d:aQN	I
    //   146: aload_0
    //   147: getfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   150: invokevirtual 640	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   157: invokevirtual 643	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 460	com/google/android/exoplayer2/e/b:bcM	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 460	com/google/android/exoplayer2/e/b:bcM	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   225: invokevirtual 643	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 460	com/google/android/exoplayer2/e/b:bcM	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 159	com/google/android/exoplayer2/e/b:bcN	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 460	com/google/android/exoplayer2/e/b:bcM	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 324	com/google/android/exoplayer2/e/b:bcL	Lcom/google/android/exoplayer2/drm/a;
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
  
  protected void ta() {}
  
  public static final class a
    extends Exception
  {
    public final boolean bdn;
    public final String bdo;
    public final String bdp;
    public final String mimeType;
    
    public a(Format paramFormat, Throwable paramThrowable, int paramInt)
    {
      super(paramThrowable);
      AppMethodBeat.i(195365);
      this.mimeType = paramFormat.aMQ;
      this.bdn = false;
      this.bdo = null;
      if (paramInt < 0) {}
      for (paramFormat = "neg_";; paramFormat = "")
      {
        this.bdp = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramFormat + Math.abs(paramInt));
        AppMethodBeat.o(195365);
        return;
      }
    }
    
    public a(Format paramFormat, Throwable paramThrowable, String paramString)
    {
      super(paramThrowable);
      AppMethodBeat.i(195371);
      this.mimeType = paramFormat.aMQ;
      this.bdn = false;
      this.bdo = paramString;
      paramFormat = localObject;
      if (x.SDK_INT >= 21)
      {
        paramFormat = localObject;
        if ((paramThrowable instanceof MediaCodec.CodecException)) {
          paramFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
        }
      }
      this.bdp = paramFormat;
      AppMethodBeat.o(195371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */