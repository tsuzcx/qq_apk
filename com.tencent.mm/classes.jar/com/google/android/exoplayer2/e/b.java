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
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b
  extends com.google.android.exoplayer2.a
{
  private static final byte[] aFM = t.aH("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final c aFN;
  private final boolean aFO;
  private final com.google.android.exoplayer2.b.e aFP;
  private final com.google.android.exoplayer2.b.e aFQ;
  private final k aFR;
  private final List<Long> aFS;
  private final MediaCodec.BufferInfo aFT;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aFU;
  private com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.d> aFV;
  public MediaCodec aFW;
  public a aFX;
  private int aFY;
  private boolean aFZ;
  private boolean aGa;
  private boolean aGb;
  private boolean aGc;
  private boolean aGd;
  private boolean aGe;
  private boolean aGf;
  private boolean aGg;
  private long aGh;
  private int aGi;
  private int aGj;
  private boolean aGk;
  private boolean aGl;
  private int aGm;
  private int aGn;
  private boolean aGo;
  private boolean aGp;
  private boolean aGq;
  private boolean aGr;
  private boolean aGs;
  private boolean aGt;
  public com.google.android.exoplayer2.b.d aGu;
  private final com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> asY;
  private Format auL;
  private ByteBuffer[] axb;
  private ByteBuffer[] inputBuffers;
  
  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> paramb, boolean paramBoolean)
  {
    super(paramInt);
    if (t.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.aFN = ((c)com.google.android.exoplayer2.i.a.E(paramc));
      this.asY = paramb;
      this.aFO = paramBoolean;
      this.aFP = new com.google.android.exoplayer2.b.e(0);
      this.aFQ = new com.google.android.exoplayer2.b.e(0);
      this.aFR = new k();
      this.aFS = new ArrayList();
      this.aFT = new MediaCodec.BufferInfo();
      this.aGm = 0;
      this.aGn = 0;
      return;
    }
  }
  
  private void a(b.a parama)
  {
    throw com.google.android.exoplayer2.e.a(parama, this.index);
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.aGj < 0)
    {
      if ((this.aGd) && (this.aGp)) {}
      for (;;)
      {
        try
        {
          this.aGj = this.aFW.dequeueOutputBuffer(this.aFT, 0L);
          if (this.aGj < 0) {
            break label352;
          }
          if (!this.aGg) {
            break;
          }
          this.aGg = false;
          this.aFW.releaseOutputBuffer(this.aGj, false);
          this.aGj = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          mp();
          if (this.aGr) {
            mm();
          }
          return false;
        }
        this.aGj = this.aFW.dequeueOutputBuffer(this.aFT, 0L);
      }
      if ((this.aFT.flags & 0x4) != 0)
      {
        mp();
        this.aGj = -1;
        return false;
      }
      localObject = this.axb[this.aGj];
      if (localObject != null)
      {
        ((ByteBuffer)localObject).position(this.aFT.offset);
        ((ByteBuffer)localObject).limit(this.aFT.offset + this.aFT.size);
      }
      long l = this.aFT.presentationTimeUs;
      int j = this.aFS.size();
      i = 0;
      if (i >= j) {
        break label346;
      }
      if (((Long)this.aFS.get(i)).longValue() == l)
      {
        this.aFS.remove(i);
        bool = true;
        label254:
        this.aGk = bool;
      }
    }
    else
    {
      if ((!this.aGd) || (!this.aGp)) {
        break label505;
      }
    }
    for (;;)
    {
      try
      {
        bool = a(paramLong1, paramLong2, this.aFW, this.axb[this.aGj], this.aGj, this.aFT.flags, this.aFT.presentationTimeUs, this.aGk);
        if (!bool) {
          break label551;
        }
        paramLong1 = this.aFT.presentationTimeUs;
        this.aGj = -1;
        return true;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        label346:
        label352:
        mp();
        if (!this.aGr) {
          continue;
        }
        mm();
        return false;
      }
      i += 1;
      break;
      bool = false;
      break label254;
      if (this.aGj == -2)
      {
        localObject = this.aFW.getOutputFormat();
        if ((this.aFY != 0) && (((MediaFormat)localObject).getInteger("width") == 32) && (((MediaFormat)localObject).getInteger("height") == 32))
        {
          this.aGg = true;
          return true;
        }
        if (this.aGe) {
          ((MediaFormat)localObject).setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.aFW, (MediaFormat)localObject);
        continue;
      }
      if (this.aGj == -3)
      {
        this.axb = this.aFW.getOutputBuffers();
        return true;
      }
      if ((this.aGb) && ((this.aGq) || (this.aGn == 2))) {
        mp();
      }
      return false;
      label505:
      bool = a(paramLong1, paramLong2, this.aFW, this.axb[this.aGj], this.aGj, this.aFT.flags, this.aFT.presentationTimeUs, this.aGk);
    }
    label551:
    return false;
  }
  
  private boolean mn()
  {
    if ((this.aFW == null) || (this.aGn == 2) || (this.aGq)) {}
    int i;
    int j;
    for (;;)
    {
      return false;
      if (this.aGi < 0)
      {
        this.aGi = this.aFW.dequeueInputBuffer(0L);
        if (this.aGi >= 0)
        {
          this.aFP.ayD = this.inputBuffers[this.aGi];
          this.aFP.clear();
        }
      }
      else
      {
        if (this.aGn == 1)
        {
          if (!this.aGb)
          {
            this.aGp = true;
            this.aFW.queueInputBuffer(this.aGi, 0, 0, 0L, 4);
            this.aGi = -1;
          }
          this.aGn = 2;
          return false;
        }
        if (this.aGf)
        {
          this.aGf = false;
          this.aFP.ayD.put(aFM);
          this.aFW.queueInputBuffer(this.aGi, 0, aFM.length, 0L, 0);
          this.aGi = -1;
          this.aGo = true;
          return true;
        }
        if (this.aGs) {
          i = 0;
        }
        for (j = -4; j != -3; j = a(this.aFR, this.aFP, false))
        {
          if (j != -5) {
            break label330;
          }
          if (this.aGm == 2)
          {
            this.aFP.clear();
            this.aGm = 1;
          }
          e(this.aFR.auL);
          return true;
          if (this.aGm == 1)
          {
            i = 0;
            while (i < this.auL.auu.size())
            {
              byte[] arrayOfByte = (byte[])this.auL.auu.get(i);
              this.aFP.ayD.put(arrayOfByte);
              i += 1;
            }
            this.aGm = 2;
          }
          i = this.aFP.ayD.position();
        }
        continue;
        label330:
        if (this.aFP.lz())
        {
          if (this.aGm == 2)
          {
            this.aFP.clear();
            this.aGm = 1;
          }
          this.aGq = true;
          if (!this.aGo)
          {
            mp();
            return false;
          }
          try
          {
            if (!this.aGb)
            {
              this.aGp = true;
              this.aFW.queueInputBuffer(this.aGi, 0, 0, 0L, 4);
              this.aGi = -1;
              return false;
            }
          }
          catch (MediaCodec.CryptoException localCryptoException1)
          {
            throw com.google.android.exoplayer2.e.a(localCryptoException1, this.index);
          }
        }
      }
    }
    if ((this.aGt) && (!this.aFP.lA()))
    {
      this.aFP.clear();
      if (this.aGm == 2) {
        this.aGm = 1;
      }
      return true;
    }
    this.aGt = false;
    boolean bool2 = this.aFP.lE();
    boolean bool1;
    if ((this.aFU == null) || ((!bool2) && (this.aFO))) {
      bool1 = false;
    }
    for (;;)
    {
      this.aGs = bool1;
      if (this.aGs) {
        break;
      }
      if ((!this.aFZ) || (bool2)) {
        break label599;
      }
      h.e(this.aFP.ayD);
      if (this.aFP.ayD.position() != 0) {
        break label594;
      }
      return true;
      j = this.aFU.getState();
      if (j == 1) {
        throw com.google.android.exoplayer2.e.a(this.aFU.lO(), this.index);
      }
      if (j != 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    label594:
    this.aFZ = false;
    for (;;)
    {
      try
      {
        label599:
        long l = this.aFP.ayE;
        if (this.aFP.ly()) {
          this.aFS.add(Long.valueOf(l));
        }
        this.aFP.lF();
        mo();
        if (bool2)
        {
          Object localObject = this.aFP.ayC.ays;
          if (i == 0)
          {
            this.aFW.queueSecureInputBuffer(this.aGi, 0, (MediaCodec.CryptoInfo)localObject, l, 0);
            this.aGi = -1;
            this.aGo = true;
            this.aGm = 0;
            localObject = this.aGu;
            ((com.google.android.exoplayer2.b.d)localObject).ayx += 1;
            return true;
          }
          if (((MediaCodec.CryptoInfo)localObject).numBytesOfClearData == null) {
            ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = ((MediaCodec.CryptoInfo)localObject).numBytesOfClearData;
          arrayOfInt[0] = (i + arrayOfInt[0]);
          continue;
        }
        this.aFW.queueInputBuffer(this.aGi, 0, this.aFP.ayD.limit(), l, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        throw com.google.android.exoplayer2.e.a(localCryptoException2, this.index);
      }
    }
  }
  
  private void mp()
  {
    if (this.aGn == 2)
    {
      mm();
      ml();
      return;
    }
    this.aGr = true;
    lw();
  }
  
  public abstract int a(c paramc, Format paramFormat);
  
  public a a(c paramc, Format paramFormat, boolean paramBoolean)
  {
    return paramc.d(paramFormat.aus, paramBoolean);
  }
  
  public abstract void a(a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto);
  
  public abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean);
  
  public boolean a(a parama)
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean, Format paramFormat1, Format paramFormat2)
  {
    return false;
  }
  
  public void as(boolean paramBoolean)
  {
    this.aGu = new com.google.android.exoplayer2.b.d();
  }
  
  public final int b(Format paramFormat)
  {
    int j;
    int i;
    com.google.android.exoplayer2.drm.b localb;
    try
    {
      j = a(this.aFN, paramFormat);
      i = j;
      if ((j & 0x7) <= 2) {
        break label75;
      }
      localb = this.asY;
      if (paramFormat.auv != null) {
        break label77;
      }
      bool = true;
    }
    catch (d.b paramFormat)
    {
      throw com.google.android.exoplayer2.e.a(paramFormat, this.index);
    }
    boolean bool = localb.lQ();
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
    this.aGq = false;
    this.aGr = false;
    if (this.aFW != null)
    {
      this.aGh = -9223372036854775807L;
      this.aGi = -1;
      this.aGj = -1;
      this.aGt = true;
      this.aGs = false;
      this.aGk = false;
      this.aFS.clear();
      this.aGf = false;
      this.aGg = false;
      if ((!this.aGa) && ((!this.aGc) || (!this.aGp))) {
        break label117;
      }
      mm();
      ml();
    }
    for (;;)
    {
      if ((this.aGl) && (this.auL != null)) {
        this.aGm = 1;
      }
      return;
      label117:
      if (this.aGn != 0)
      {
        mm();
        ml();
      }
      else
      {
        this.aFW.flush();
        this.aGo = false;
      }
    }
  }
  
  public void c(String paramString, long paramLong1, long paramLong2) {}
  
  public void e(Format paramFormat)
  {
    Format localFormat = this.auL;
    this.auL = paramFormat;
    DrmInitData localDrmInitData = this.auL.auv;
    int i;
    if (localFormat == null)
    {
      paramFormat = null;
      if (t.e(localDrmInitData, paramFormat)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.auL.auv == null) {
          break label232;
        }
        if (this.asY == null)
        {
          throw com.google.android.exoplayer2.e.a(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
          paramFormat = localFormat.auv;
          break;
          label86:
          i = 0;
          continue;
        }
        paramFormat = this.asY;
        Looper.myLooper();
        localDrmInitData = this.auL.auv;
        this.aFV = paramFormat.lR();
        if (this.aFV != this.aFU) {}
      }
    }
    if ((this.aFV == this.aFU) && (this.aFW != null) && (a(this.aFX.aFJ, localFormat, this.auL)))
    {
      this.aGl = true;
      this.aGm = 1;
      if ((this.aFY == 2) || ((this.aFY == 1) && (this.auL.width == localFormat.width) && (this.auL.height == localFormat.height))) {}
      for (boolean bool = true;; bool = false)
      {
        this.aGf = bool;
        return;
        label232:
        this.aFV = null;
        break;
      }
    }
    if (this.aGo)
    {
      this.aGn = 1;
      return;
    }
    mm();
    ml();
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    if (this.aGr)
    {
      lw();
      return;
    }
    int i;
    if (this.auL == null)
    {
      this.aFQ.clear();
      i = a(this.aFR, this.aFQ, true);
      if (i == -5) {
        e(this.aFR.auL);
      }
    }
    else
    {
      ml();
      if (this.aFW == null) {
        break label130;
      }
      r.beginSection("drainAndFeed");
      while (g(paramLong1, paramLong2)) {}
      while (mn()) {}
      r.endSection();
    }
    for (;;)
    {
      this.aGu.lD();
      return;
      if (i != -4) {
        break;
      }
      com.google.android.exoplayer2.i.a.aC(this.aFQ.lz());
      this.aGq = true;
      mp();
      return;
      label130:
      this.asI.K(paramLong1 - this.asJ);
      this.aFQ.clear();
      i = a(this.aFR, this.aFQ, false);
      if (i == -5)
      {
        e(this.aFR.auL);
      }
      else if (i == -4)
      {
        com.google.android.exoplayer2.i.a.aC(this.aFQ.lz());
        this.aGq = true;
        mp();
      }
    }
  }
  
  public boolean isReady()
  {
    if ((this.auL != null) && (!this.aGs))
    {
      if (this.asK) {}
      for (boolean bool = this.asL; (bool) || (this.aGj >= 0) || ((this.aGh != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.aGh)); bool = this.asI.isReady()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean kU()
  {
    return this.aGr;
  }
  
  public final int ky()
  {
    return 8;
  }
  
  public void kz()
  {
    this.auL = null;
    try
    {
      mm();
      return;
    }
    finally
    {
      this.aFU = null;
      this.aFV = null;
    }
  }
  
  public void lw() {}
  
  public final void ml()
  {
    boolean bool3 = false;
    if ((this.aFW != null) || (this.auL == null)) {}
    String str;
    Object localObject3;
    do
    {
      return;
      this.aFU = this.aFV;
      str = this.auL.aus;
      if (this.aFU == null) {
        break label979;
      }
      localObject3 = (com.google.android.exoplayer2.drm.d)this.aFU.lP();
      if (localObject3 != null) {
        break;
      }
      localObject1 = this.aFU.lO();
    } while (localObject1 == null);
    throw com.google.android.exoplayer2.e.a((Exception)localObject1, this.index);
    Object localObject1 = ((com.google.android.exoplayer2.drm.d)localObject3).ayT;
    boolean bool1;
    if ((!((com.google.android.exoplayer2.drm.d)localObject3).ayU) && (((com.google.android.exoplayer2.drm.d)localObject3).ayT.requiresSecureDecoderComponent(str))) {
      bool1 = true;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.aFX == null) {}
        try
        {
          this.aFX = a(this.aFN, this.auL, bool1);
          if ((this.aFX == null) && (bool1))
          {
            this.aFX = a(this.aFN, this.auL, false);
            if (this.aFX != null) {
              new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.aFX.name).append(".");
            }
          }
          if (this.aFX == null) {
            a(new b.a(this.auL, null, bool1, -49999));
          }
          if (!a(this.aFX)) {
            break;
          }
          str = this.aFX.name;
          if ((t.SDK_INT <= 24) && ("OMX.Exynos.avc.dec.secure".equals(str)) && ((t.MODEL.startsWith("SM-T585")) || (t.MODEL.startsWith("SM-A520"))))
          {
            i = 2;
            this.aFY = i;
            localObject3 = this.auL;
            if ((t.SDK_INT >= 21) || (!((Format)localObject3).auu.isEmpty()) || (!"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
              break label921;
            }
            bool2 = true;
            this.aFZ = bool2;
            if ((t.SDK_INT >= 18) && ((t.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str)) && (!"OMX.SEC.avc.dec.secure".equals(str)))) && ((t.SDK_INT != 19) || (!t.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str)) && (!"OMX.Exynos.avc.dec.secure".equals(str))))) {
              break label926;
            }
            bool2 = true;
            this.aGa = bool2;
            if ((t.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str)) && (!"OMX.allwinner.video.decoder.avc".equals(str)))) {
              break label931;
            }
            bool2 = true;
            this.aGb = bool2;
            if (((t.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str))) && ((t.SDK_INT > 19) || (!"hb2000".equals(t.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
              break label936;
            }
            bool2 = true;
            this.aGc = bool2;
            if ((t.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str))) {
              break label941;
            }
            bool2 = true;
            this.aGd = bool2;
            localObject3 = this.auL;
            bool2 = bool3;
            if (t.SDK_INT <= 18)
            {
              bool2 = bool3;
              if (((Format)localObject3).auC == 1)
              {
                bool2 = bool3;
                if ("OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                  bool2 = true;
                }
              }
            }
            this.aGe = bool2;
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
              r.beginSection("createCodec:" + str);
              this.aFW = MediaCodec.createByCodecName(str);
              r.endSection();
              r.beginSection("configureCodec");
              a(this.aFX, this.aFW, this.auL, (MediaCrypto)localObject1);
              r.endSection();
              r.beginSection("startCodec");
              this.aFW.start();
              r.endSection();
              long l2 = SystemClock.elapsedRealtime();
              c(str, l2, l2 - l1);
              this.inputBuffers = this.aFW.getInputBuffers();
              this.axb = this.aFW.getOutputBuffers();
              if (this.state != 2) {
                break label971;
              }
              l1 = SystemClock.elapsedRealtime() + 1000L;
              this.aGh = l1;
              this.aGi = -1;
              this.aGj = -1;
              this.aGt = true;
              localObject1 = this.aGu;
              ((com.google.android.exoplayer2.b.d)localObject1).ayv += 1;
              return;
              bool1 = false;
              break;
              localb = localb;
              a(new b.a(this.auL, localb, bool1, -49998));
              continue;
              if ((t.SDK_INT < 24) && (("OMX.Nvidia.h264.decode".equals(localb)) || ("OMX.Nvidia.h264.decode.secure".equals(localb))) && (("flounder".equals(t.DEVICE)) || ("flounder_lte".equals(t.DEVICE)) || ("grouper".equals(t.DEVICE)) || ("tilapia".equals(t.DEVICE))))
              {
                i = 1;
              }
              else
              {
                i = 0;
                continue;
                label921:
                bool2 = false;
                continue;
                label926:
                bool2 = false;
                continue;
                label931:
                bool2 = false;
                continue;
                label936:
                bool2 = false;
              }
            }
            label941:
            boolean bool2 = false;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              a(new b.a(this.auL, localException, bool1, localb));
              continue;
              label971:
              long l1 = -9223372036854775807L;
            }
          }
        }
      }
      label979:
      bool1 = false;
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public void mm()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc2_w 426
    //   4: putfield 429	com/google/android/exoplayer2/e/b:aGh	J
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 265	com/google/android/exoplayer2/e/b:aGi	I
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 151	com/google/android/exoplayer2/e/b:aGj	I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 292	com/google/android/exoplayer2/e/b:aGs	Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 220	com/google/android/exoplayer2/e/b:aGk	Z
    //   27: aload_0
    //   28: getfield 124	com/google/android/exoplayer2/e/b:aFS	Ljava/util/List;
    //   31: invokeinterface 430 1 0
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 271	com/google/android/exoplayer2/e/b:inputBuffers	[Ljava/nio/ByteBuffer;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 182	com/google/android/exoplayer2/e/b:axb	[Ljava/nio/ByteBuffer;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 463	com/google/android/exoplayer2/e/b:aFX	Lcom/google/android/exoplayer2/e/a;
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 436	com/google/android/exoplayer2/e/b:aGl	Z
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 290	com/google/android/exoplayer2/e/b:aGo	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 325	com/google/android/exoplayer2/e/b:aFZ	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 432	com/google/android/exoplayer2/e/b:aGa	Z
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 229	com/google/android/exoplayer2/e/b:aFY	I
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 257	com/google/android/exoplayer2/e/b:aGb	Z
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 434	com/google/android/exoplayer2/e/b:aGc	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 241	com/google/android/exoplayer2/e/b:aGe	Z
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 284	com/google/android/exoplayer2/e/b:aGf	Z
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 165	com/google/android/exoplayer2/e/b:aGg	Z
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 155	com/google/android/exoplayer2/e/b:aGp	Z
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 131	com/google/android/exoplayer2/e/b:aGm	I
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 133	com/google/android/exoplayer2/e/b:aGn	I
    //   116: aload_0
    //   117: getfield 111	com/google/android/exoplayer2/e/b:aFP	Lcom/google/android/exoplayer2/b/e;
    //   120: aconst_null
    //   121: putfield 275	com/google/android/exoplayer2/b/e:ayD	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   128: ifnull +60 -> 188
    //   131: aload_0
    //   132: getfield 375	com/google/android/exoplayer2/e/b:aGu	Lcom/google/android/exoplayer2/b/d;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_1
    //   138: getfield 673	com/google/android/exoplayer2/b/d:ayw	I
    //   141: iconst_1
    //   142: iadd
    //   143: putfield 673	com/google/android/exoplayer2/b/d:ayw	I
    //   146: aload_0
    //   147: getfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   150: invokevirtual 676	android/media/MediaCodec:stop	()V
    //   153: aload_0
    //   154: getfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   157: invokevirtual 679	android/media/MediaCodec:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   165: aload_0
    //   166: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   169: ifnull +19 -> 188
    //   172: aload_0
    //   173: getfield 461	com/google/android/exoplayer2/e/b:aFV	Lcom/google/android/exoplayer2/drm/a;
    //   176: aload_0
    //   177: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   180: if_acmpeq +8 -> 188
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   188: return
    //   189: astore_1
    //   190: aload_0
    //   191: aconst_null
    //   192: putfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   199: ifnull +19 -> 218
    //   202: aload_0
    //   203: getfield 461	com/google/android/exoplayer2/e/b:aFV	Lcom/google/android/exoplayer2/drm/a;
    //   206: aload_0
    //   207: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   210: if_acmpeq +8 -> 218
    //   213: aload_0
    //   214: aconst_null
    //   215: putfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   225: invokevirtual 679	android/media/MediaCodec:release	()V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   233: aload_0
    //   234: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   237: ifnull +19 -> 256
    //   240: aload_0
    //   241: getfield 461	com/google/android/exoplayer2/e/b:aFV	Lcom/google/android/exoplayer2/drm/a;
    //   244: aload_0
    //   245: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   248: if_acmpeq +8 -> 256
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 157	com/google/android/exoplayer2/e/b:aFW	Landroid/media/MediaCodec;
    //   264: aload_0
    //   265: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: getfield 461	com/google/android/exoplayer2/e/b:aFV	Lcom/google/android/exoplayer2/drm/a;
    //   275: aload_0
    //   276: getfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
    //   279: if_acmpeq +8 -> 287
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield 323	com/google/android/exoplayer2/e/b:aFU	Lcom/google/android/exoplayer2/drm/a;
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
  
  public void mo() {}
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void onStarted() {}
  
  public void onStopped() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.7.0.1
 */