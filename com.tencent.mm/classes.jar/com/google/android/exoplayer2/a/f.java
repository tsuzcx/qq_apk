package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
{
  public static boolean awl = false;
  public static boolean awm = false;
  p atv;
  int avp;
  b avq;
  boolean awA;
  long awB;
  p awC;
  private long awD;
  private long awE;
  private ByteBuffer awF;
  int awG;
  private int awH;
  private int awI;
  private long awJ;
  private long awK;
  private boolean awL;
  private long awM;
  private Method awN;
  int awO;
  long awP;
  long awQ;
  int awR;
  private long awS;
  private long awT;
  int awU;
  int awV;
  long awW;
  private long awX;
  private long awY;
  float awZ;
  final c awn;
  final g awo;
  private final l awp;
  final d[] awq;
  final f.f awr;
  final ConditionVariable aws;
  private final long[] awt;
  final f.a awu;
  final LinkedList<f.g> awv;
  AudioTrack aww;
  AudioTrack awx;
  int awy;
  int awz;
  private d[] axa;
  private ByteBuffer[] axb;
  ByteBuffer axc;
  private ByteBuffer axd;
  private byte[] axe;
  private int axf;
  private int axg;
  boolean axh;
  boolean axi;
  boolean axj;
  boolean axk;
  long axl;
  int bufferSize;
  int encoding;
  int sampleRate;
  
  public f(c paramc, d[] paramArrayOfd, f.f paramf)
  {
    this.awn = paramc;
    this.awr = paramf;
    this.aws = new ConditionVariable(true);
    if (t.SDK_INT >= 18) {}
    try
    {
      this.awN = AudioTrack.class.getMethod("getLatency", null);
      label46:
      if (t.SDK_INT >= 19) {}
      for (this.awu = new f.b();; this.awu = new f.a((byte)0))
      {
        this.awo = new g();
        this.awp = new l();
        this.awq = new d[paramArrayOfd.length + 3];
        this.awq[0] = new j();
        this.awq[1] = this.awo;
        System.arraycopy(paramArrayOfd, 0, this.awq, 2, paramArrayOfd.length);
        this.awq[(paramArrayOfd.length + 2)] = this.awp;
        this.awt = new long[10];
        this.awZ = 1.0F;
        this.awV = 0;
        this.avq = b.avR;
        this.avp = 0;
        this.atv = p.auS;
        this.axg = -1;
        this.axa = new d[0];
        this.axb = new ByteBuffer[0];
        this.awv = new LinkedList();
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label46;
    }
  }
  
  private long B(long paramLong)
  {
    while ((!this.awv.isEmpty()) && (paramLong >= ((f.g)this.awv.getFirst()).aui))
    {
      f.g localg = (f.g)this.awv.remove();
      this.atv = localg.atv;
      this.awE = localg.aui;
      this.awD = (localg.axA - this.awW);
    }
    if (this.atv.auT == 1.0F) {
      return this.awD + paramLong - this.awE;
    }
    if ((this.awv.isEmpty()) && (this.awp.ayp >= 1024L))
    {
      long l = this.awD;
      return t.b(paramLong - this.awE, this.awp.ayo, this.awp.ayp) + l;
    }
    return this.awD + (this.atv.auT * (paramLong - this.awE));
  }
  
  static int ai(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0;
        if (paramString.equals("audio/ac3"))
        {
          i = 0;
          continue;
          if (paramString.equals("audio/eac3"))
          {
            i = 1;
            continue;
            if (paramString.equals("audio/vnd.dts"))
            {
              i = 2;
              continue;
              if (paramString.equals("audio/vnd.dts.hd")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return 5;
    return 6;
    return 7;
    return 8;
  }
  
  final void A(long paramLong)
  {
    int j = this.axa.length;
    int i = j;
    for (;;)
    {
      ByteBuffer localByteBuffer;
      if (i >= 0)
      {
        if (i <= 0) {
          break label51;
        }
        localByteBuffer = this.axb[(i - 1)];
        label28:
        if (i != j) {
          break label75;
        }
        a(localByteBuffer, paramLong);
      }
      for (;;)
      {
        if (localByteBuffer.hasRemaining())
        {
          return;
          label51:
          if (this.axc != null)
          {
            localByteBuffer = this.axc;
            break label28;
          }
          localByteBuffer = d.avY;
          break label28;
          label75:
          Object localObject = this.axa[i];
          ((d)localObject).c(localByteBuffer);
          localObject = ((d)localObject).lc();
          this.axb[i] = localObject;
          if (((ByteBuffer)localObject).hasRemaining())
          {
            i += 1;
            break;
          }
        }
      }
      i -= 1;
    }
  }
  
  final long C(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  final long D(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  final boolean a(ByteBuffer paramByteBuffer, long paramLong)
  {
    if (!paramByteBuffer.hasRemaining()) {
      return true;
    }
    boolean bool;
    label32:
    int k;
    int i;
    int j;
    if (this.axd != null) {
      if (this.axd == paramByteBuffer)
      {
        bool = true;
        a.aB(bool);
        k = paramByteBuffer.remaining();
        if (t.SDK_INT >= 21) {
          break label250;
        }
        i = (int)(this.awS - this.awu.ln() * this.awR);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label535;
        }
        i = Math.min(k, i);
        j = this.awx.write(this.axe, this.axf, i);
        i = j;
        if (j > 0)
        {
          this.axf += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.axl = SystemClock.elapsedRealtime();
      if (i < 0)
      {
        throw new f.h(i);
        bool = false;
        break;
        this.axd = paramByteBuffer;
        if (t.SDK_INT >= 21) {
          break label32;
        }
        i = paramByteBuffer.remaining();
        if ((this.axe == null) || (this.axe.length < i)) {
          this.axe = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.axe, 0, i);
        paramByteBuffer.position(j);
        this.axf = 0;
        break label32;
        label250:
        if (this.axj)
        {
          if (paramLong != -9223372036854775807L) {}
          AudioTrack localAudioTrack;
          for (bool = true;; bool = false)
          {
            a.aC(bool);
            localAudioTrack = this.awx;
            if (this.awF == null)
            {
              this.awF = ByteBuffer.allocate(16);
              this.awF.order(ByteOrder.BIG_ENDIAN);
              this.awF.putInt(1431633921);
            }
            if (this.awG == 0)
            {
              this.awF.putInt(4, k);
              this.awF.putLong(8, 1000L * paramLong);
              this.awF.position(0);
              this.awG = k;
            }
            j = this.awF.remaining();
            if (j <= 0) {
              break label425;
            }
            i = localAudioTrack.write(this.awF, j, 1);
            if (i >= 0) {
              break label412;
            }
            this.awG = 0;
            break;
          }
          if (i < j)
          {
            i = 0;
            continue;
          }
          i = localAudioTrack.write(paramByteBuffer, k, 1);
          if (i < 0)
          {
            this.awG = 0;
            continue;
          }
          this.awG -= i;
          continue;
        }
        label412:
        label425:
        i = this.awx.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.awA) {
        this.awS += i;
      }
      if (i == k)
      {
        if (this.awA) {
          this.awT += this.awU;
        }
        this.axd = null;
        return true;
      }
      return false;
      label535:
      i = 0;
    }
  }
  
  public final long ax(boolean paramBoolean)
  {
    if ((isInitialized()) && (this.awV != 0)) {}
    for (int i = 1; i == 0; i = 0) {
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    String str;
    if (this.awx.getPlayState() == 3)
    {
      l1 = this.awu.lo();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.awK >= 30000L)
        {
          this.awt[this.awH] = (l1 - l2);
          this.awH = ((this.awH + 1) % 10);
          if (this.awI < 10) {
            this.awI += 1;
          }
          this.awK = l2;
          this.awJ = 0L;
          i = 0;
          while (i < this.awI)
          {
            this.awJ += this.awt[i] / this.awI;
            i += 1;
          }
        }
        if ((!ll()) && (l2 - this.awM >= 500000L))
        {
          this.awL = this.awu.lp();
          if (this.awL)
          {
            l3 = this.awu.lq() / 1000L;
            l4 = this.awu.lr();
            if (l3 < this.awX) {
              break label626;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label514;
            }
            str = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + li() + ", " + lj();
            if (awm) {
              throw new f.e(str);
            }
            this.awL = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.awN != null) && (!this.awA)) {}
      try
      {
        this.awY = (((Integer)this.awN.invoke(this.awx, null)).intValue() * 1000L - this.awB);
        this.awY = Math.max(this.awY, 0L);
        if (this.awY > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.awY);
          this.awY = 0L;
        }
        this.awM = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.awL)
        {
          l1 = C(D(l1 - this.awu.lq() / 1000L) + this.awu.lr());
          l2 = this.awW;
          return B(l1) + l2;
          label514:
          if (Math.abs(C(l4) - l1) <= 5000000L) {
            continue;
          }
          str = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + li() + ", " + lj();
          if (awm) {
            throw new f.e(str);
          }
          label626:
          this.awL = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.awN = null;
        }
      }
    }
    if (this.awI == 0) {}
    for (long l2 = this.awu.lo();; l2 = l1 + this.awJ)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.awY;
      break;
    }
  }
  
  public final p b(p paramp)
  {
    if (this.awA)
    {
      this.atv = p.auS;
      return this.atv;
    }
    Object localObject = this.awp;
    ((l)localObject).auT = t.h(paramp.auT, 0.1F, 8.0F);
    float f1 = ((l)localObject).auT;
    localObject = this.awp;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = t.h(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.awC != null)
    {
      paramp = this.awC;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label160;
        }
        this.awC = ((p)localObject);
      }
    }
    for (;;)
    {
      return this.atv;
      if (!this.awv.isEmpty())
      {
        paramp = ((f.g)this.awv.getLast()).atv;
        break;
      }
      paramp = this.atv;
      break;
      label160:
      this.atv = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.awx != null;
  }
  
  final void ld()
  {
    Object localObject = new ArrayList();
    d[] arrayOfd = this.awq;
    int j = arrayOfd.length;
    int i = 0;
    if (i < j)
    {
      d locald = arrayOfd[i];
      if (locald.isActive()) {
        ((ArrayList)localObject).add(locald);
      }
      for (;;)
      {
        i += 1;
        break;
        locald.flush();
      }
    }
    j = ((ArrayList)localObject).size();
    this.axa = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.axb = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.axa[i];
      ((d)localObject).flush();
      this.axb[i] = ((d)localObject).lc();
      i += 1;
    }
  }
  
  final boolean le()
  {
    int i;
    if (this.axg == -1) {
      if (this.awA)
      {
        i = this.axa.length;
        this.axg = i;
        i = 1;
      }
    }
    for (;;)
    {
      label28:
      if (this.axg < this.axa.length)
      {
        d locald = this.axa[this.axg];
        if (i != 0) {
          locald.lb();
        }
        A(-9223372036854775807L);
        if (locald.kU()) {}
      }
      do
      {
        return false;
        i = 0;
        break;
        this.axg += 1;
        i = 1;
        break label28;
        if (this.axd == null) {
          break label124;
        }
        a(this.axd, -9223372036854775807L);
      } while (this.axd != null);
      label124:
      this.axg = -1;
      return true;
      i = 0;
    }
  }
  
  public final boolean lf()
  {
    if (isInitialized())
    {
      if (lj() <= this.awu.ln()) {
        if ((!ll()) || (this.awx.getPlayState() != 2) || (this.awx.getPlaybackHeadPosition() != 0)) {
          break label58;
        }
      }
      label58:
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  final void lg()
  {
    if (isInitialized())
    {
      if (t.SDK_INT >= 21) {
        this.awx.setVolume(this.awZ);
      }
    }
    else {
      return;
    }
    AudioTrack localAudioTrack = this.awx;
    float f = this.awZ;
    localAudioTrack.setStereoVolume(f, f);
  }
  
  final void lh()
  {
    if (this.aww == null) {
      return;
    }
    final AudioTrack localAudioTrack = this.aww;
    this.aww = null;
    new Thread()
    {
      public final void run()
      {
        localAudioTrack.release();
      }
    }.start();
  }
  
  final long li()
  {
    if (this.awA) {
      return this.awQ;
    }
    return this.awP / this.awO;
  }
  
  final long lj()
  {
    if (this.awA) {
      return this.awT;
    }
    return this.awS / this.awR;
  }
  
  final void lk()
  {
    this.awJ = 0L;
    this.awI = 0;
    this.awH = 0;
    this.awK = 0L;
    this.awL = false;
    this.awM = 0L;
  }
  
  final boolean ll()
  {
    return (t.SDK_INT < 23) && ((this.awz == 5) || (this.awz == 6));
  }
  
  final AudioTrack lm()
  {
    Object localObject;
    if (t.SDK_INT >= 21) {
      if (this.axj) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.awy).setEncoding(this.awz).setSampleRate(this.sampleRate).build();
      int i;
      if (this.avp != 0)
      {
        i = this.avp;
        label83:
        localObject = new AudioTrack((AudioAttributes)localObject, localAudioFormat, this.bufferSize, 1, i);
        label99:
        i = ((AudioTrack)localObject).getState();
        if (i == 1) {}
      }
      else
      {
        try
        {
          ((AudioTrack)localObject).release();
          label113:
          throw new d(i, this.sampleRate, this.awy, this.bufferSize);
          localObject = this.avq;
          if (((b)localObject).avU == null) {
            ((b)localObject).avU = new AudioAttributes.Builder().setContentType(((b)localObject).avS).setFlags(((b)localObject).flags).setUsage(((b)localObject).avT).build();
          }
          localObject = ((b)localObject).avU;
          continue;
          i = 0;
          break label83;
          i = t.dF(this.avq.avT);
          if (this.avp == 0)
          {
            localObject = new AudioTrack(i, this.sampleRate, this.awy, this.awz, this.bufferSize, 1);
            break label99;
          }
          localObject = new AudioTrack(i, this.sampleRate, this.awy, this.awz, this.bufferSize, 1, this.avp);
        }
        catch (Exception localException)
        {
          break label113;
        }
      }
    }
    return localException;
  }
  
  public final void play()
  {
    this.axi = true;
    if (isInitialized())
    {
      this.awX = (System.nanoTime() / 1000L);
      this.awx.play();
    }
  }
  
  public final void reset()
  {
    if (isInitialized())
    {
      this.awP = 0L;
      this.awQ = 0L;
      this.awS = 0L;
      this.awT = 0L;
      this.awU = 0;
      if (this.awC != null)
      {
        this.atv = this.awC;
        this.awC = null;
      }
      for (;;)
      {
        this.awv.clear();
        this.awD = 0L;
        this.awE = 0L;
        this.axc = null;
        this.axd = null;
        int i = 0;
        while (i < this.axa.length)
        {
          localObject = this.axa[i];
          ((d)localObject).flush();
          this.axb[i] = ((d)localObject).lc();
          i += 1;
        }
        if (!this.awv.isEmpty()) {
          this.atv = ((f.g)this.awv.getLast()).atv;
        }
      }
      this.axh = false;
      this.axg = -1;
      this.awF = null;
      this.awG = 0;
      this.awV = 0;
      this.awY = 0L;
      lk();
      if (this.awx.getPlayState() == 3) {
        this.awx.pause();
      }
      Object localObject = this.awx;
      this.awx = null;
      this.awu.a(null, false);
      this.aws.close();
      new f.1(this, (AudioTrack)localObject).start();
    }
  }
  
  public static final class d
    extends Exception
  {
    public final int axz;
    
    public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      this.axz = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */