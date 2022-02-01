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
  private static final byte[] btf = x.bK("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> bbY;
  private Format bdI;
  private ByteBuffer[] bfT;
  private ByteBuffer[] btA;
  private long btB;
  private int btC;
  private int btD;
  private boolean btE;
  private boolean btF;
  private int btG;
  private int btH;
  private boolean btI;
  private boolean btJ;
  private boolean btK;
  private boolean btL;
  private boolean btM;
  private boolean btN;
  protected com.google.android.exoplayer2.b.d btO;
  private final c btg;
  private final boolean bth;
  private final com.google.android.exoplayer2.b.e bti;
  private final com.google.android.exoplayer2.b.e btj;
  private final com.google.android.exoplayer2.k btk;
  private final List<Long> btl;
  private final MediaCodec.BufferInfo btm;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> btn;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> bto;
  protected MediaCodec btp;
  protected a btq;
  private int btr;
  private boolean bts;
  private boolean btt;
  private boolean btu;
  private boolean btv;
  private boolean btw;
  private boolean btx;
  private boolean bty;
  private boolean btz;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (x.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.btg = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.bbY = paramb;
      this.bth = paramBoolean;
      this.bti = new com.google.android.exoplayer2.b.e(0);
      this.btj = new com.google.android.exoplayer2.b.e(0);
      this.btk = new com.google.android.exoplayer2.k();
      this.btl = new ArrayList();
      this.btm = new MediaCodec.BufferInfo();
      this.btG = 0;
      this.btH = 0;
      return;
    }
  }
  
  private void a(b.a parama)
  {
    throw com.google.android.exoplayer2.e.b(parama, this.index);
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.btD < 0)
    {
      if ((this.btw) && (this.btJ)) {}
      for (;;)
      {
        try
        {
          this.btD = this.btp.dequeueOutputBuffer(this.btm, 0L);
          if (this.btD < 0) {
            break label352;
          }
          if (!this.btz) {
            break;
          }
          this.btz = false;
          this.btp.releaseOutputBuffer(this.btD, false);
          this.btD = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          uZ();
          if (this.btL) {
            uW();
          }
          return false;
        }
        this.btD = this.btp.dequeueOutputBuffer(this.btm, 0L);
      }
      if ((this.btm.flags & 0x4) != 0)
      {
        uZ();
        this.btD = -1;
        return false;
      }
      localObject = this.bfT[this.btD];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.btm.offset);
        ((ByteBuffer)localObject).limit(this.btm.offset + this.btm.size);
      }
      long l = this.btm.presentationTimeUs;
      int j = this.btl.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.btl.get(i)).longValue() == l)
      {
        this.btl.remove(i);
        bool = true;
        label254:
        this.btE = bool;
      }
    }
    else
    {
      if ((!this.btw) || (!this.btJ)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.btp, this.bfT[this.btD], this.btD, this.btm.flags, this.btm.presentationTimeUs, this.btE);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.btm.presentationTimeUs;
        this.btD = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        uZ();
        if (!this.btL) {
          continue;
        }
        uW();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.btD == -2)
      {
        localObject = this.btp.getOutputFormat();
        if ((this.btr != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.btz = true;
          return true;
        }
        if (this.btx) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.btp, (MediaFormat)localObject);
        continue;
      }
      if (this.btD == -3)
      {
        this.bfT = this.btp.getOutputBuffers();
        return true;
      }
      if ((this.btu) && ((this.btK) || (this.btH == 2))) {
        uZ();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.btp, this.bfT[this.btD], this.btD, this.btm.flags, this.btm.presentationTimeUs, this.btE);
    }
    label551:
    return false;
  }
  
  private boolean uX()
  {
    if ((this.btp == null) || (this.btH == 2) || (this.btK)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.btC < 0)
      {
        this.btC = this.btp.dequeueInputBuffer(0L);
        if (this.btC >= 0)
        {
          this.bti.aKX = this.btA[this.btC];
          this.bti.clear();
        }
      }
      else
      {
        if (this.btH == 1)
        {
          if (!this.btu)
          {
            this.btJ = true;
            this.btp.queueInputBuffer(this.btC, 0, 0, 0L, 4);
            this.btC = -1;
          }
          this.btH = 2;
          return false;
        }
        if (this.bty)
        {
          this.bty = false;
          this.bti.aKX.put(btf);
          this.btp.queueInputBuffer(this.btC, 0, btf.length, 0L, 0);
          this.btC = -1;
          this.btI = true;
          return true;
        }
        if (this.btM) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.btk, this.bti, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.btG == 2)
          {
            this.bti.clear();
            this.btG = 1;
          }
          e(this.btk.bdI);
          return true;
          if (this.btG == 1)
          {
            i = 0;
            while (i < this.bdI.bdv.size())
            {
              byte[] arrayOfByte = (byte[])this.bdI.bdv.get(i);
              this.bti.aKX.put(arrayOfByte);
              i += 1;
            }
            this.btG = 2;
          }
          i = this.bti.aKX.position();
        }
        continue;
        label330:
        if (this.bti.tY())
        {
          if (this.btG == 2)
          {
            this.bti.clear();
            this.btG = 1;
          }
          this.btK = true;
          if (!this.btI)
          {
            uZ();
            return false;
          }
          try
          {
            if (!this.btu)
            {
              this.btJ = true;
              this.btp.queueInputBuffer(this.btC, 0, 0, 0L, 4);
              this.btC = -1;
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
    if ((this.btN) && (!this.bti.tZ()))
    {
      this.bti.clear();
      if (this.btG == 2) {
        this.btG = 1;
      }
      return true;
    }
    this.btN = false;
    boolean bool2 = this.bti.uc();
    boolean bool1;
    if ((this.btn == null) || ((!bool2) && (this.bth))) {
      bool1 = false;
    }
    for (;;)
    {
      this.btM = bool1;
      if (this.btM) {
        break;
      }
      if ((!this.bts) || (bool2)) {
        break label599;
      }
      com.google.android.exoplayer2.i.k.h(this.bti.aKX);
      if (this.bti.aKX.position() != 0) {
        break label594;
      }
      return true;
      j = this.btn.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.b(this.btn.ul(), this.index);
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.bts = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.bti.timeUs;
        if (this.bti.tX()) {
          this.btl.add(Long.valueOf(l));
        }
        this.bti.ud();
        uY();
        if (bool2)
        {
          Object localObject = this.bti.bhs.bhi;
          if (i == 0)
          {
            this.btp.queueSecureInputBuffer(this.btC, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.btC = -1;
            this.btI = true;
            this.btG = 0;
            localObject = this.btO;
            ((com.google.android.exoplayer2.b.d)localObject).bhn += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.btp.queueInputBuffer(this.btC, 0, this.bti.aKX.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.b(localCryptoException2, this.index);
      }
    }
  }
  
  private void uZ()
  {
    if (this.btH == 2)
    {
      uW();
      uV();
      return;
    }
    this.btL = true;
    tV();
  }
  
  protected abstract int a(c paramc, Format paramFormat);
  
  protected a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.f(paramFormat.bdt, paramBoolean);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.btK = false;
    this.btL = false;
    if (this.btp != null)
    {
      this.btB = -9223372036854775807L;
      this.btC = -1;
      this.btD = -1;
      this.btN = true;
      this.btM = false;
      this.btE = false;
      this.btl.clear();
      this.bty = false;
      this.btz = false;
      if ((!this.btt) && ((!this.btv) || (!this.btJ))) {
        break label117;
      }
      uW();
      uV();
    }
    for (;;)
    {
      if ((this.btF) && (this.bdI != null)) {
        this.btG = 1;
      }
      return;
      label117:
      if (this.btH != 0)
      {
        uW();
        uV();
      }
      else
      {
        this.btp.flush();
        this.btI = false;
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
  
  public void aO(boolean paramBoolean)
  {
    this.btO = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.btg, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.bbY;
      if (paramFormat.bdw != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.b(paramFormat, this.index);
    }
    boolean bool = localb.un();
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
    if (this.btL) {
      tV();
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.bdI == null)
        {
          this.btj.clear();
          i = a(this.btk, this.btj, true);
          if (i == -5) {
            e(this.btk.bdI);
          }
        }
        else
        {
          uV();
          if (this.btp == null) {
            break;
          }
          v.beginSection("drainAndFeed");
          while (g(paramLong1, paramLong2)) {}
          while (uX()) {}
          v.endSection();
          return;
        }
      } while (i != -4);
      com.google.android.exoplayer2.i.a.checkState(this.btj.tY());
      this.btK = true;
      uZ();
      return;
      this.bbI.Y(paramLong1 - this.bbJ);
      this.btj.clear();
      i = a(this.btk, this.btj, false);
      if (i == -5)
      {
        e(this.btk.bdI);
        return;
      }
    } while (i != -4);
    com.google.android.exoplayer2.i.a.checkState(this.btj.tY());
    this.btK = true;
    uZ();
  }
  
  protected void e(Format paramFormat)
  {
    Format localFormat = this.bdI;
    this.bdI = paramFormat;
    DrmInitData localDrmInitData = this.bdI.bdw;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (x.i(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.bdI.bdw == null) {
          break label223;
        }
        if (this.bbY == null)
        {
          throw com.google.android.exoplayer2.e.b(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
          paramFormat = localFormat.bdw;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.bbY;
        Looper.myLooper();
        this.bto = paramFormat.uo();
        if (this.bto != this.btn) {}
      }
    }
    if ((this.bto == this.btn) && (this.btp != null) && (a(this.btq.btc, localFormat, this.bdI)))
    {
      this.btF = true;
      this.btG = 1;
      if ((this.btr == 2) || ((this.btr == 1) && (this.bdI.width == localFormat.width) && (this.bdI.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.bty = bool;
        return;
        label223:
        this.bto = null;
        break;
      }
    }
    if (this.btI)
    {
      this.btH = 1;
      return;
    }
    uW();
    uV();
  }
  
  public boolean isReady()
  {
    if ((this.bdI != null) && (!this.btM))
    {
      if (this.bbK) {}
      for (boolean bool = this.bbL; (bool) || (this.btD >= 0) || ((this.btB != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.btB)); bool = this.bbI.isReady()) {
        return true;
      }
    }
    return false;
  }
  
  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
  
  public final int sY()
  {
    return 8;
  }
  
  public void sZ()
  {
    this.bdI = null;
    try
    {
      uW();
      return;
    }
    finally
    {
      this.btn = null;
      this.bto = null;
    }
  }
  
  protected void tV() {}
  
  public boolean tw()
  {
    return this.btL;
  }
  
  protected final void uV()
  {
    boolean bool3 = false;
    if ((this.btp != null) || (this.bdI == null)) {}
    String str;
    Object localObject3;
    do
    {
      return;
      this.btn = this.bto;
      str = this.bdI.bdt;
      if (this.btn == null) {
        break label972;
      }
      localObject3 = (com.google.android.exoplayer2.drm.d)this.btn.um();
      if (localObject3 != null) {
        break;
      }
      localObject1 = this.btn.ul();
    } while (localObject1 == null);
    throw com.google.android.exoplayer2.e.b((Exception)localObject1, this.index);
    Object localObject1 = ((com.google.android.exoplayer2.drm.d)localObject3).bhH;
    boolean bool1;
    if ((!((com.google.android.exoplayer2.drm.d)localObject3).bhI) && (((com.google.android.exoplayer2.drm.d)localObject3).bhH.requiresSecureDecoderComponent(str))) {
      bool1 = true;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.btq == null) {}
        try
        {
          this.btq = a(this.btg, this.bdI, bool1);
          if ((this.btq == null) && (bool1))
          {
            this.btq = a(this.btg, this.bdI, false);
            if (this.btq != null) {
              new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.btq.name).append(".");
            }
          }
          if (this.btq == null) {
            a(new b.a(this.bdI, null, bool1, -49999));
          }
          if (!a(this.btq)) {
            break;
          }
          str = this.btq.name;
          if ((x.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(str)) && ((x.MODEL.startsWith("SM-T585")) || (x.MODEL.startsWith("SM-A520"))))
          {
            i = 2;
            this.btr = i;
            localObject3 = this.bdI;
            if ((x.SDK_INT >= 21) || (!((Format)localObject3).bdv.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
              break label914;
            }
            bool2 = true;
            this.bts = bool2;
            if ((x.SDK_INT >= 18) && ((x.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str)) && (!"OMX.SEC.avc.dec.secure".equals(str)))) && ((x.SDK_INT != 19) || (!x.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str)) && (!"OMX.Exynos.avc.dec.secure".equals(str))))) {
              break label919;
            }
            bool2 = true;
            this.btt = bool2;
            if ((x.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str)) && (!"OMX.allwinner.video.decoder.avc".equals(str)))) {
              break label924;
            }
            bool2 = true;
            this.btu = bool2;
            if (((x.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str))) && ((x.SDK_INT > 19) || (!"hb2000".equals(x.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
              break label929;
            }
            bool2 = true;
            this.btv = bool2;
            if ((x.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str))) {
              break label934;
            }
            bool2 = true;
            this.btw = bool2;
            localObject3 = this.bdI;
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
            this.btx = bool2;
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
              this.btp = MediaCodec.createByCodecName(str);
              v.endSection();
              v.beginSection("configureCodec");
              a(this.btq, this.btp, this.bdI, (MediaCrypto)localObject1);
              v.endSection();
              v.beginSection("startCodec");
              this.btp.start();
              v.endSection();
              long l2 = SystemClock.elapsedRealtime();
              d(str, l2, l2 - l1);
              this.btA = this.btp.getInputBuffers();
              this.bfT = this.btp.getOutputBuffers();
              if (this.state != 2) {
                break label964;
              }
              l1 = SystemClock.elapsedRealtime() + 1000L;
              this.btB = l1;
              this.btC = -1;
              this.btD = -1;
              this.btN = true;
              localObject1 = this.btO;
              ((com.google.android.exoplayer2.b.d)localObject1).bhl += 1;
              return;
              bool1 = false;
              break;
              localb = localb;
              a(new b.a(this.bdI, localb, bool1, -49998));
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
              a(new b.a(this.bdI, localException, bool1, localb));
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
  protected void uW()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 408
    //   4: putfield 411	com/google/android/exoplayer2/e/b:btB	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 266	com/google/android/exoplayer2/e/b:btC	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 152	com/google/android/exoplayer2/e/b:btD	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 293	com/google/android/exoplayer2/e/b:btM	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 221	com/google/android/exoplayer2/e/b:btE	Z
    //   27: aload_0
    //   28: getfield 124	com/google/android/exoplayer2/e/b:btl	Ljava/util/List;
    //   31: invokeinterface 412 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 272	com/google/android/exoplayer2/e/b:btA	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 183	com/google/android/exoplayer2/e/b:bfT	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 493	com/google/android/exoplayer2/e/b:btq	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 418	com/google/android/exoplayer2/e/b:btF	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 291	com/google/android/exoplayer2/e/b:btI	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 326	com/google/android/exoplayer2/e/b:bts	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 414	com/google/android/exoplayer2/e/b:btt	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 230	com/google/android/exoplayer2/e/b:btr	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 258	com/google/android/exoplayer2/e/b:btu	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 416	com/google/android/exoplayer2/e/b:btv	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 242	com/google/android/exoplayer2/e/b:btx	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 285	com/google/android/exoplayer2/e/b:bty	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 166	com/google/android/exoplayer2/e/b:btz	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 156	com/google/android/exoplayer2/e/b:btJ	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 131	com/google/android/exoplayer2/e/b:btG	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 133	com/google/android/exoplayer2/e/b:btH	I
    //   116: aload_0
    //   117: getfield 111	com/google/android/exoplayer2/e/b:bti	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 276	com/google/android/exoplayer2/b/e:aKX	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 377	com/google/android/exoplayer2/e/b:btO	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 676	com/google/android/exoplayer2/b/d:bhm	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 676	com/google/android/exoplayer2/b/d:bhm	I
    //   146: aload_0
    //   147: getfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   150: invokevirtual 679	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   157: invokevirtual 682	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 491	com/google/android/exoplayer2/e/b:bto	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 491	com/google/android/exoplayer2/e/b:bto	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   225: invokevirtual 682	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 491	com/google/android/exoplayer2/e/b:bto	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 158	com/google/android/exoplayer2/e/b:btp	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 491	com/google/android/exoplayer2/e/b:bto	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 324	com/google/android/exoplayer2/e/b:btn	Lcom/google/android/exoplayer2/drm/a;
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
  
  protected void uY() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */