package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public final class f
{
  public static boolean aOC = false;
  public static boolean aOD = false;
  p aLS;
  int aNI;
  b aNJ;
  private final c aOE;
  final g aOF;
  private final l aOG;
  final d[] aOH;
  final f aOI;
  final ConditionVariable aOJ;
  private final long[] aOK;
  final a aOL;
  final LinkedList<g> aOM;
  AudioTrack aON;
  AudioTrack aOO;
  int aOP;
  boolean aOQ;
  long aOR;
  p aOS;
  private long aOT;
  private long aOU;
  private ByteBuffer aOV;
  int aOW;
  private int aOX;
  private int aOY;
  private long aOZ;
  private long aPa;
  private boolean aPb;
  private long aPc;
  private Method aPd;
  int aPe;
  long aPf;
  long aPg;
  int aPh;
  private long aPi;
  private long aPj;
  int aPk;
  int aPl;
  long aPm;
  private long aPn;
  private long aPo;
  private d[] aPp;
  private ByteBuffer[] aPq;
  ByteBuffer aPr;
  private byte[] aPs;
  private int aPt;
  private int aPu;
  boolean aPv;
  boolean aPw;
  boolean aPx;
  boolean aPy;
  long aPz;
  int bufferSize;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.aOE = paramc;
    this.aOI = paramf;
    this.aOJ = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.aPd = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.aOL = new b();; this.aOL = new a((byte)0))
      {
        this.aOF = new g();
        this.aOG = new l();
        this.aOH = new d[paramArrayOfd.length + 3];
        this.aOH[0] = new j();
        this.aOH[1] = this.aOF;
        System.arraycopy(paramArrayOfd, 0, this.aOH, 2, paramArrayOfd.length);
        this.aOH[(paramArrayOfd.length + 2)] = this.aOG;
        this.aOK = new long[10];
        this.volume = 1.0F;
        this.aPl = 0;
        this.aNJ = b.aOk;
        this.aNI = 0;
        this.aLS = p.aNn;
        this.aPu = -1;
        this.aPp = new d[0];
        this.aPq = new ByteBuffer[0];
        this.aOM = new LinkedList();
        AppMethodBeat.o(91785);
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label51;
    }
  }
  
  private long K(long paramLong)
  {
    AppMethodBeat.i(91798);
    while ((!this.aOM.isEmpty()) && (paramLong >= ((g)this.aOM.getFirst()).aMG))
    {
      g localg = (g)this.aOM.remove();
      this.aLS = localg.aLS;
      this.aOU = localg.aMG;
      this.aOT = (localg.aPO - this.aPm);
    }
    if (this.aLS.aNo == 1.0F)
    {
      l1 = this.aOT;
      long l2 = this.aOU;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.aOM.isEmpty()) && (this.aOG.aQC >= 1024L))
    {
      l1 = this.aOT;
      paramLong = x.b(paramLong - this.aOU, this.aOG.aQB, this.aOG.aQC);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.aOT;
    paramLong = (this.aLS.aNo * (paramLong - this.aOU));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.aOV == null)
    {
      this.aOV = ByteBuffer.allocate(16);
      this.aOV.order(ByteOrder.BIG_ENDIAN);
      this.aOV.putInt(1431633921);
    }
    if (this.aOW == 0)
    {
      this.aOV.putInt(4, paramInt);
      this.aOV.putLong(8, 1000L * paramLong);
      this.aOV.position(0);
      this.aOW = paramInt;
    }
    int i = this.aOV.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.aOV, i, 1);
      if (j < 0)
      {
        this.aOW = 0;
        AppMethodBeat.o(91801);
        return j;
      }
      if (j < i)
      {
        AppMethodBeat.o(91801);
        return 0;
      }
    }
    paramInt = paramAudioTrack.write(paramByteBuffer, paramInt, 1);
    if (paramInt < 0)
    {
      this.aOW = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.aOW -= paramInt;
    AppMethodBeat.o(91801);
    return paramInt;
  }
  
  static int bp(String paramString)
  {
    AppMethodBeat.i(91800);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(91800);
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
    AppMethodBeat.o(91800);
    return 5;
    AppMethodBeat.o(91800);
    return 6;
    AppMethodBeat.o(91800);
    return 7;
    AppMethodBeat.o(91800);
    return 8;
  }
  
  final void J(long paramLong)
  {
    AppMethodBeat.i(91790);
    int j = this.aPp.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.aPq[(i - 1)];
        label34:
        if (i != j) {
          break label87;
        }
        a(localByteBuffer, paramLong);
      }
      for (;;)
      {
        if (localByteBuffer.hasRemaining())
        {
          AppMethodBeat.o(91790);
          return;
          if (this.aPr != null)
          {
            localByteBuffer = this.aPr;
            break label34;
          }
          localByteBuffer = d.aOp;
          break label34;
          label87:
          Object localObject = this.aPp[i];
          ((d)localObject).c(localByteBuffer);
          localObject = ((d)localObject).rB();
          this.aPq[i] = localObject;
          if (((ByteBuffer)localObject).hasRemaining())
          {
            i += 1;
            break;
          }
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(91790);
  }
  
  final long L(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  final long M(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  final boolean a(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(91791);
    if (!paramByteBuffer.hasRemaining())
    {
      AppMethodBeat.o(91791);
      return true;
    }
    boolean bool;
    label44:
    int k;
    int i;
    int j;
    if (this.outputBuffer != null) {
      if (this.outputBuffer == paramByteBuffer)
      {
        bool = true;
        a.checkArgument(bool);
        k = paramByteBuffer.remaining();
        if (x.SDK_INT >= 21) {
          break label270;
        }
        i = (int)(this.aPi - this.aOL.rM() * this.aPh);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.aOO.write(this.aPs, this.aPt, i);
        i = j;
        if (j > 0)
        {
          this.aPt += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.aPz = SystemClock.elapsedRealtime();
      if (i < 0)
      {
        paramByteBuffer = new f.h(i);
        AppMethodBeat.o(91791);
        throw paramByteBuffer;
        bool = false;
        break;
        this.outputBuffer = paramByteBuffer;
        if (x.SDK_INT >= 21) {
          break label44;
        }
        i = paramByteBuffer.remaining();
        if ((this.aPs == null) || (this.aPs.length < i)) {
          this.aPs = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.aPs, 0, i);
        paramByteBuffer.position(j);
        this.aPt = 0;
        break label44;
        label270:
        if (this.aPx)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.aOO, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.aOO.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.aOQ) {
        this.aPi += i;
      }
      if (i == k)
      {
        if (this.aOQ) {
          this.aPj += this.aPk;
        }
        this.outputBuffer = null;
        AppMethodBeat.o(91791);
        return true;
      }
      AppMethodBeat.o(91791);
      return false;
      label400:
      i = 0;
    }
  }
  
  public final long aQ(boolean paramBoolean)
  {
    AppMethodBeat.i(91787);
    if ((isInitialized()) && (this.aPl != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.aOO.getPlayState() == 3)
    {
      l1 = this.aOL.rN();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.aPa >= 30000L)
        {
          this.aOK[this.aOX] = (l1 - l2);
          this.aOX = ((this.aOX + 1) % 10);
          if (this.aOY < 10) {
            this.aOY += 1;
          }
          this.aPa = l2;
          this.aOZ = 0L;
          i = 0;
          while (i < this.aOY)
          {
            this.aOZ += this.aOK[i] / this.aOY;
            i += 1;
          }
        }
        if ((!rK()) && (l2 - this.aPc >= 500000L))
        {
          this.aPb = this.aOL.rO();
          if (this.aPb)
          {
            l3 = this.aOL.rP() / 1000L;
            l4 = this.aOL.rQ();
            if (l3 < this.aPn) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + rH() + ", " + rI();
            if (aOD)
            {
              localObject = new f.e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.aPb = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.aPd != null) && (!this.aOQ)) {}
      try
      {
        this.aPo = (((Integer)this.aPd.invoke(this.aOO, null)).intValue() * 1000L - this.aOR);
        this.aPo = Math.max(this.aPo, 0L);
        if (this.aPo > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.aPo);
          this.aPo = 0L;
        }
        this.aPc = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.aPb)
        {
          l1 = L(M(l1 - this.aOL.rP() / 1000L) + this.aOL.rQ());
          l2 = this.aPm;
          l1 = K(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(L(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + rH() + ", " + rI();
          if (aOD)
          {
            localObject = new f.e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.aPb = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.aPd = null;
        }
      }
    }
    if (this.aOY == 0) {}
    for (long l2 = this.aOL.rN();; l2 = l1 + this.aOZ)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.aPo;
      break;
    }
  }
  
  public final boolean bo(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.aOE != null)
    {
      c localc = this.aOE;
      int i = bp(paramString);
      if (Arrays.binarySearch(localc.supportedEncodings, i) >= 0) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91786);
        return true;
      }
    }
    AppMethodBeat.o(91786);
    return false;
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(91794);
    if (this.aOQ)
    {
      this.aLS = p.aNn;
      paramp = this.aLS;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.aOG;
    ((l)localObject).aNo = x.i(paramp.aNo, 0.1F, 8.0F);
    float f1 = ((l)localObject).aNo;
    localObject = this.aOG;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.i(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.aOS != null)
    {
      paramp = this.aOS;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.aOS = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.aLS;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.aOM.isEmpty())
      {
        paramp = ((g)this.aOM.getLast()).aLS;
        break;
      }
      paramp = this.aLS;
      break;
      label182:
      this.aLS = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.aOO != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.aPw = true;
    if (isInitialized())
    {
      this.aPn = (System.nanoTime() / 1000L);
      this.aOO.play();
    }
    AppMethodBeat.o(91789);
  }
  
  final void rC()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.aOH;
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
    this.aPp = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.aPq = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.aPp[i];
      ((d)localObject).flush();
      this.aPq[i] = ((d)localObject).rB();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean rD()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.aPu == -1) {
      if (this.aOQ)
      {
        i = this.aPp.length;
        this.aPu = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.aPu < this.aPp.length)
      {
        d locald = this.aPp[this.aPu];
        if (i != 0) {
          locald.rA();
        }
        J(-9223372036854775807L);
        if (!locald.rt())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.aPu += 1;
        i = 1;
        continue;
      }
      if (this.outputBuffer != null)
      {
        a(this.outputBuffer, -9223372036854775807L);
        if (this.outputBuffer != null)
        {
          AppMethodBeat.o(91792);
          return false;
        }
      }
      this.aPu = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean rE()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (rI() <= this.aOL.rM()) {
        if ((!rK()) || (this.aOO.getPlayState() != 2) || (this.aOO.getPlaybackHeadPosition() != 0)) {
          break label70;
        }
      }
      label70:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(91793);
        return true;
      }
    }
    AppMethodBeat.o(91793);
    return false;
  }
  
  final void rF()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.aOO.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.aOO;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void rG()
  {
    AppMethodBeat.i(91797);
    if (this.aON == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.aON;
    this.aON = null;
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(91772);
        localAudioTrack.release();
        AppMethodBeat.o(91772);
      }
    }.start();
    AppMethodBeat.o(91797);
  }
  
  final long rH()
  {
    if (this.aOQ) {
      return this.aPg;
    }
    return this.aPf / this.aPe;
  }
  
  final long rI()
  {
    if (this.aOQ) {
      return this.aPj;
    }
    return this.aPi / this.aPh;
  }
  
  final void rJ()
  {
    this.aOZ = 0L;
    this.aOY = 0;
    this.aOX = 0;
    this.aPa = 0L;
    this.aPb = false;
    this.aPc = 0L;
  }
  
  final boolean rK()
  {
    return (x.SDK_INT < 23) && ((this.aOP == 5) || (this.aOP == 6));
  }
  
  final AudioTrack rL()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.aPx) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.aOP).setSampleRate(this.sampleRate).build();
      int i;
      if (this.aNI != 0)
      {
        i = this.aNI;
        label89:
        localObject = new AudioTrack((AudioAttributes)localObject, localAudioFormat, this.bufferSize, 1, i);
        label105:
        i = ((AudioTrack)localObject).getState();
        if (i == 1) {
          break label288;
        }
      }
      try
      {
        ((AudioTrack)localObject).release();
        label119:
        localObject = new f.d(i, this.sampleRate, this.channelConfig, this.bufferSize);
        AppMethodBeat.o(91799);
        throw ((Throwable)localObject);
        localObject = this.aNJ;
        if (((b)localObject).aOn == null) {
          ((b)localObject).aOn = new AudioAttributes.Builder().setContentType(((b)localObject).aOl).setFlags(((b)localObject).flags).setUsage(((b)localObject).aOm).build();
        }
        localObject = ((b)localObject).aOn;
        continue;
        i = 0;
        break label89;
        i = x.fA(this.aNJ.aOm);
        if (this.aNI == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aOP, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aOP, this.bufferSize, 1, this.aNI);
        break label105;
        label288:
        AppMethodBeat.o(91799);
        return localObject;
      }
      catch (Exception localException)
      {
        break label119;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.aPf = 0L;
      this.aPg = 0L;
      this.aPi = 0L;
      this.aPj = 0L;
      this.aPk = 0;
      if (this.aOS != null)
      {
        this.aLS = this.aOS;
        this.aOS = null;
      }
      for (;;)
      {
        this.aOM.clear();
        this.aOT = 0L;
        this.aOU = 0L;
        this.aPr = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.aPp.length)
        {
          localObject = this.aPp[i];
          ((d)localObject).flush();
          this.aPq[i] = ((d)localObject).rB();
          i += 1;
        }
        if (!this.aOM.isEmpty()) {
          this.aLS = ((g)this.aOM.getLast()).aLS;
        }
      }
      this.aPv = false;
      this.aPu = -1;
      this.aOV = null;
      this.aOW = 0;
      this.aPl = 0;
      this.aPo = 0L;
      rJ();
      if (this.aOO.getPlayState() == 3) {
        this.aOO.pause();
      }
      Object localObject = this.aOO;
      this.aOO = null;
      this.aOL.a(null, false);
      this.aOJ.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.aPA.flush();
            this.aPA.release();
            return;
          }
          finally
          {
            f.a(f.this).open();
            AppMethodBeat.o(91771);
          }
        }
      }.start();
    }
    AppMethodBeat.o(91796);
  }
  
  static class a
  {
    protected AudioTrack aOO;
    private boolean aPC;
    private long aPD;
    private long aPE;
    private long aPF;
    private long aPG;
    private long aPH;
    private long aPI;
    private int sampleRate;
    
    public final void N(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.aPH = rM();
      this.aPG = (SystemClock.elapsedRealtime() * 1000L);
      this.aPI = paramLong;
      this.aOO.stop();
      AppMethodBeat.o(91774);
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.aOO = paramAudioTrack;
      this.aPC = paramBoolean;
      this.aPG = -9223372036854775807L;
      this.aPD = 0L;
      this.aPE = 0L;
      this.aPF = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.aPG != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.aOO.pause();
      AppMethodBeat.o(91775);
    }
    
    public final long rM()
    {
      AppMethodBeat.i(91776);
      if (this.aPG != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.aPG) * this.sampleRate / 1000000L;
        l1 = Math.min(this.aPI, l1 + this.aPH);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.aOO.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.aOO.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.aPC)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.aPF = this.aPD;
        }
        l1 = l2 + this.aPF;
      }
      if (this.aPD > l1) {
        this.aPE += 1L;
      }
      this.aPD = l1;
      l2 = this.aPE;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long rN()
    {
      AppMethodBeat.i(91777);
      long l = rM() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean rO()
    {
      return false;
    }
    
    public long rP()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long rQ()
    {
      AppMethodBeat.i(91779);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91779);
      throw localUnsupportedOperationException;
    }
  }
  
  @TargetApi(19)
  static final class b
    extends f.a
  {
    private final AudioTimestamp aPJ;
    private long aPK;
    private long aPL;
    private long aPM;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.aPJ = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.aPK = 0L;
      this.aPL = 0L;
      this.aPM = 0L;
      AppMethodBeat.o(91781);
    }
    
    public final boolean rO()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.aOO.getTimestamp(this.aPJ);
      if (bool)
      {
        long l = this.aPJ.framePosition;
        if (this.aPL > l) {
          this.aPK += 1L;
        }
        this.aPL = l;
        this.aPM = (l + (this.aPK << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long rP()
    {
      return this.aPJ.nanoTime;
    }
    
    public final long rQ()
    {
      return this.aPM;
    }
  }
  
  public static final class c
    extends Exception
  {
    public c(String paramString)
    {
      super();
    }
    
    public c(Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static abstract interface f
  {
    public abstract void dU(int paramInt);
    
    public abstract void e(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void rs();
  }
  
  static final class g
  {
    final p aLS;
    final long aMG;
    final long aPO;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.aLS = paramp;
      this.aPO = paramLong1;
      this.aMG = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */