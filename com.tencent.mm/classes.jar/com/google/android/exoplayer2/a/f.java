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
  public static boolean aUK = false;
  public static boolean aUL = false;
  p aSa;
  int aTQ;
  b aTR;
  private final c aUM;
  final g aUN;
  private final l aUO;
  final d[] aUP;
  final f aUQ;
  final ConditionVariable aUR;
  private final long[] aUS;
  final a aUT;
  final LinkedList<g> aUU;
  AudioTrack aUV;
  AudioTrack aUW;
  int aUX;
  boolean aUY;
  long aUZ;
  private byte[] aVA;
  private int aVB;
  private int aVC;
  boolean aVD;
  boolean aVE;
  boolean aVF;
  boolean aVG;
  long aVH;
  p aVa;
  private long aVb;
  private long aVc;
  private ByteBuffer aVd;
  int aVe;
  private int aVf;
  private int aVg;
  private long aVh;
  private long aVi;
  private boolean aVj;
  private long aVk;
  private Method aVl;
  int aVm;
  long aVn;
  long aVo;
  int aVp;
  private long aVq;
  private long aVr;
  int aVs;
  int aVt;
  long aVu;
  private long aVv;
  private long aVw;
  private d[] aVx;
  private ByteBuffer[] aVy;
  ByteBuffer aVz;
  int bufferSize;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.aUM = paramc;
    this.aUQ = paramf;
    this.aUR = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.aVl = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.aUT = new b();; this.aUT = new a((byte)0))
      {
        this.aUN = new g();
        this.aUO = new l();
        this.aUP = new d[paramArrayOfd.length + 3];
        this.aUP[0] = new j();
        this.aUP[1] = this.aUN;
        System.arraycopy(paramArrayOfd, 0, this.aUP, 2, paramArrayOfd.length);
        this.aUP[(paramArrayOfd.length + 2)] = this.aUO;
        this.aUS = new long[10];
        this.volume = 1.0F;
        this.aVt = 0;
        this.aTR = b.aUs;
        this.aTQ = 0;
        this.aSa = p.aTv;
        this.aVC = -1;
        this.aVx = new d[0];
        this.aVy = new ByteBuffer[0];
        this.aUU = new LinkedList();
        AppMethodBeat.o(91785);
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label51;
    }
  }
  
  private long H(long paramLong)
  {
    AppMethodBeat.i(91798);
    while ((!this.aUU.isEmpty()) && (paramLong >= ((g)this.aUU.getFirst()).aSO))
    {
      g localg = (g)this.aUU.remove();
      this.aSa = localg.aSa;
      this.aVc = localg.aSO;
      this.aVb = (localg.aVW - this.aVu);
    }
    if (this.aSa.aTw == 1.0F)
    {
      l1 = this.aVb;
      long l2 = this.aVc;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.aUU.isEmpty()) && (this.aUO.aWK >= 1024L))
    {
      l1 = this.aVb;
      paramLong = x.b(paramLong - this.aVc, this.aUO.aWJ, this.aUO.aWK);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.aVb;
    paramLong = (this.aSa.aTw * (paramLong - this.aVc));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.aVd == null)
    {
      this.aVd = ByteBuffer.allocate(16);
      this.aVd.order(ByteOrder.BIG_ENDIAN);
      this.aVd.putInt(1431633921);
    }
    if (this.aVe == 0)
    {
      this.aVd.putInt(4, paramInt);
      this.aVd.putLong(8, 1000L * paramLong);
      this.aVd.position(0);
      this.aVe = paramInt;
    }
    int i = this.aVd.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.aVd, i, 1);
      if (j < 0)
      {
        this.aVe = 0;
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
      this.aVe = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.aVe -= paramInt;
    AppMethodBeat.o(91801);
    return paramInt;
  }
  
  static int al(String paramString)
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
  
  final void G(long paramLong)
  {
    AppMethodBeat.i(91790);
    int j = this.aVx.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.aVy[(i - 1)];
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
          if (this.aVz != null)
          {
            localByteBuffer = this.aVz;
            break label34;
          }
          localByteBuffer = d.aUx;
          break label34;
          label87:
          Object localObject = this.aVx[i];
          ((d)localObject).f(localByteBuffer);
          localObject = ((d)localObject).sf();
          this.aVy[i] = localObject;
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
  
  final long I(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  final long J(long paramLong)
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
        i = (int)(this.aVq - this.aUT.sq() * this.aVp);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.aUW.write(this.aVA, this.aVB, i);
        i = j;
        if (j > 0)
        {
          this.aVB += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.aVH = SystemClock.elapsedRealtime();
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
        if ((this.aVA == null) || (this.aVA.length < i)) {
          this.aVA = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.aVA, 0, i);
        paramByteBuffer.position(j);
        this.aVB = 0;
        break label44;
        label270:
        if (this.aVF)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.aUW, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.aUW.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.aUY) {
        this.aVq += i;
      }
      if (i == k)
      {
        if (this.aUY) {
          this.aVr += this.aVs;
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
  
  public final long aS(boolean paramBoolean)
  {
    AppMethodBeat.i(91787);
    if ((isInitialized()) && (this.aVt != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.aUW.getPlayState() == 3)
    {
      l1 = this.aUT.sr();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.aVi >= 30000L)
        {
          this.aUS[this.aVf] = (l1 - l2);
          this.aVf = ((this.aVf + 1) % 10);
          if (this.aVg < 10) {
            this.aVg += 1;
          }
          this.aVi = l2;
          this.aVh = 0L;
          i = 0;
          while (i < this.aVg)
          {
            this.aVh += this.aUS[i] / this.aVg;
            i += 1;
          }
        }
        if ((!so()) && (l2 - this.aVk >= 500000L))
        {
          this.aVj = this.aUT.ss();
          if (this.aVj)
          {
            l3 = this.aUT.st() / 1000L;
            l4 = this.aUT.su();
            if (l3 < this.aVv) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + sl() + ", " + sm();
            if (aUL)
            {
              localObject = new e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.aVj = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.aVl != null) && (!this.aUY)) {}
      try
      {
        this.aVw = (((Integer)this.aVl.invoke(this.aUW, null)).intValue() * 1000L - this.aUZ);
        this.aVw = Math.max(this.aVw, 0L);
        if (this.aVw > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.aVw);
          this.aVw = 0L;
        }
        this.aVk = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.aVj)
        {
          l1 = I(J(l1 - this.aUT.st() / 1000L) + this.aUT.su());
          l2 = this.aVu;
          l1 = H(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(I(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + sl() + ", " + sm();
          if (aUL)
          {
            localObject = new e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.aVj = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.aVl = null;
        }
      }
    }
    if (this.aVg == 0) {}
    for (long l2 = this.aUT.sr();; l2 = l1 + this.aVh)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.aVw;
      break;
    }
  }
  
  public final boolean ak(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.aUM != null)
    {
      c localc = this.aUM;
      int i = al(paramString);
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
    if (this.aUY)
    {
      this.aSa = p.aTv;
      paramp = this.aSa;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.aUO;
    ((l)localObject).aTw = x.i(paramp.aTw, 0.1F, 8.0F);
    float f1 = ((l)localObject).aTw;
    localObject = this.aUO;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.i(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.aVa != null)
    {
      paramp = this.aVa;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.aVa = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.aSa;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.aUU.isEmpty())
      {
        paramp = ((g)this.aUU.getLast()).aSa;
        break;
      }
      paramp = this.aSa;
      break;
      label182:
      this.aSa = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.aUW != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.aVE = true;
    if (isInitialized())
    {
      this.aVv = (System.nanoTime() / 1000L);
      this.aUW.play();
    }
    AppMethodBeat.o(91789);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.aVn = 0L;
      this.aVo = 0L;
      this.aVq = 0L;
      this.aVr = 0L;
      this.aVs = 0;
      if (this.aVa != null)
      {
        this.aSa = this.aVa;
        this.aVa = null;
      }
      for (;;)
      {
        this.aUU.clear();
        this.aVb = 0L;
        this.aVc = 0L;
        this.aVz = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.aVx.length)
        {
          localObject = this.aVx[i];
          ((d)localObject).flush();
          this.aVy[i] = ((d)localObject).sf();
          i += 1;
        }
        if (!this.aUU.isEmpty()) {
          this.aSa = ((g)this.aUU.getLast()).aSa;
        }
      }
      this.aVD = false;
      this.aVC = -1;
      this.aVd = null;
      this.aVe = 0;
      this.aVt = 0;
      this.aVw = 0L;
      sn();
      if (this.aUW.getPlayState() == 3) {
        this.aUW.pause();
      }
      Object localObject = this.aUW;
      this.aUW = null;
      this.aUT.a(null, false);
      this.aUR.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.aVI.flush();
            this.aVI.release();
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
  
  final void sg()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.aUP;
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
    this.aVx = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.aVy = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.aVx[i];
      ((d)localObject).flush();
      this.aVy[i] = ((d)localObject).sf();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean sh()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.aVC == -1) {
      if (this.aUY)
      {
        i = this.aVx.length;
        this.aVC = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.aVC < this.aVx.length)
      {
        d locald = this.aVx[this.aVC];
        if (i != 0) {
          locald.se();
        }
        G(-9223372036854775807L);
        if (!locald.rX())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.aVC += 1;
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
      this.aVC = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean si()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (sm() <= this.aUT.sq()) {
        if ((!so()) || (this.aUW.getPlayState() != 2) || (this.aUW.getPlaybackHeadPosition() != 0)) {
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
  
  final void sj()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.aUW.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.aUW;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void sk()
  {
    AppMethodBeat.i(91797);
    if (this.aUV == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.aUV;
    this.aUV = null;
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
  
  final long sl()
  {
    if (this.aUY) {
      return this.aVo;
    }
    return this.aVn / this.aVm;
  }
  
  final long sm()
  {
    if (this.aUY) {
      return this.aVr;
    }
    return this.aVq / this.aVp;
  }
  
  final void sn()
  {
    this.aVh = 0L;
    this.aVg = 0;
    this.aVf = 0;
    this.aVi = 0L;
    this.aVj = false;
    this.aVk = 0L;
  }
  
  final boolean so()
  {
    return (x.SDK_INT < 23) && ((this.aUX == 5) || (this.aUX == 6));
  }
  
  final AudioTrack sp()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.aVF) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.aUX).setSampleRate(this.sampleRate).build();
      int i;
      if (this.aTQ != 0)
      {
        i = this.aTQ;
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
        localObject = this.aTR;
        if (((b)localObject).aUv == null) {
          ((b)localObject).aUv = new AudioAttributes.Builder().setContentType(((b)localObject).aUt).setFlags(((b)localObject).flags).setUsage(((b)localObject).aUu).build();
        }
        localObject = ((b)localObject).aUv;
        continue;
        i = 0;
        break label89;
        i = x.fd(this.aTR.aUu);
        if (this.aTQ == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aUX, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aUX, this.bufferSize, 1, this.aTQ);
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
  
  static class a
  {
    protected AudioTrack aUW;
    private boolean aVK;
    private long aVL;
    private long aVM;
    private long aVN;
    private long aVO;
    private long aVP;
    private long aVQ;
    private int sampleRate;
    
    public final void K(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.aVP = sq();
      this.aVO = (SystemClock.elapsedRealtime() * 1000L);
      this.aVQ = paramLong;
      this.aUW.stop();
      AppMethodBeat.o(91774);
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.aUW = paramAudioTrack;
      this.aVK = paramBoolean;
      this.aVO = -9223372036854775807L;
      this.aVL = 0L;
      this.aVM = 0L;
      this.aVN = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.aVO != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.aUW.pause();
      AppMethodBeat.o(91775);
    }
    
    public final long sq()
    {
      AppMethodBeat.i(91776);
      if (this.aVO != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.aVO) * this.sampleRate / 1000000L;
        l1 = Math.min(this.aVQ, l1 + this.aVP);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.aUW.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.aUW.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.aVK)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.aVN = this.aVL;
        }
        l1 = l2 + this.aVN;
      }
      if (this.aVL > l1) {
        this.aVM += 1L;
      }
      this.aVL = l1;
      l2 = this.aVM;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long sr()
    {
      AppMethodBeat.i(91777);
      long l = sq() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean ss()
    {
      return false;
    }
    
    public long st()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long su()
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
    private final AudioTimestamp aVR;
    private long aVS;
    private long aVT;
    private long aVU;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.aVR = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.aVS = 0L;
      this.aVT = 0L;
      this.aVU = 0L;
      AppMethodBeat.o(91781);
    }
    
    public final boolean ss()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.aUW.getTimestamp(this.aVR);
      if (bool)
      {
        long l = this.aVR.framePosition;
        if (this.aVT > l) {
          this.aVS += 1L;
        }
        this.aVT = l;
        this.aVU = (l + (this.aVS << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long st()
    {
      return this.aVR.nanoTime;
    }
    
    public final long su()
    {
      return this.aVU;
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
  
  public static final class e
    extends RuntimeException
  {
    public e(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface f
  {
    public abstract void d(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void dH(int paramInt);
    
    public abstract void rW();
  }
  
  static final class g
  {
    final long aSO;
    final p aSa;
    final long aVW;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.aSa = paramp;
      this.aVW = paramLong1;
      this.aSO = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */