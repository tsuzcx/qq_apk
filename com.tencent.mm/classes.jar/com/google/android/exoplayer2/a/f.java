package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
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
  public static boolean ayB = false;
  public static boolean ayC = false;
  p avN;
  int axF;
  b axG;
  private final c ayD;
  final g ayE;
  private final l ayF;
  final d[] ayG;
  final f.f ayH;
  final ConditionVariable ayI;
  private final long[] ayJ;
  final f.a ayK;
  final LinkedList<f.g> ayL;
  AudioTrack ayM;
  AudioTrack ayN;
  int ayO;
  int ayP;
  boolean ayQ;
  long ayR;
  p ayS;
  private long ayT;
  private long ayU;
  private ByteBuffer ayV;
  int ayW;
  private int ayX;
  private int ayY;
  private long ayZ;
  boolean azA;
  long azB;
  private long aza;
  private boolean azb;
  private long azc;
  private Method azd;
  int aze;
  long azf;
  long azg;
  int azh;
  private long azi;
  private long azj;
  int azk;
  int azl;
  long azm;
  private long azn;
  private long azo;
  float azp;
  private d[] azq;
  private ByteBuffer[] azr;
  ByteBuffer azs;
  private ByteBuffer azt;
  private byte[] azu;
  private int azv;
  private int azw;
  boolean azx;
  boolean azy;
  boolean azz;
  int bufferSize;
  int encoding;
  int sampleRate;
  
  public f(c paramc, d[] paramArrayOfd, f.f paramf)
  {
    AppMethodBeat.i(94674);
    this.ayD = paramc;
    this.ayH = paramf;
    this.ayI = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.azd = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.ayK = new f.b();; this.ayK = new f.a((byte)0))
      {
        this.ayE = new g();
        this.ayF = new l();
        this.ayG = new d[paramArrayOfd.length + 3];
        this.ayG[0] = new j();
        this.ayG[1] = this.ayE;
        System.arraycopy(paramArrayOfd, 0, this.ayG, 2, paramArrayOfd.length);
        this.ayG[(paramArrayOfd.length + 2)] = this.ayF;
        this.ayJ = new long[10];
        this.azp = 1.0F;
        this.azl = 0;
        this.axG = b.ayh;
        this.axF = 0;
        this.avN = p.axk;
        this.azw = -1;
        this.azq = new d[0];
        this.azr = new ByteBuffer[0];
        this.ayL = new LinkedList();
        AppMethodBeat.o(94674);
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label51;
    }
  }
  
  private long A(long paramLong)
  {
    AppMethodBeat.i(94687);
    while ((!this.ayL.isEmpty()) && (paramLong >= ((f.g)this.ayL.getFirst()).awA))
    {
      f.g localg = (f.g)this.ayL.remove();
      this.avN = localg.avN;
      this.ayU = localg.awA;
      this.ayT = (localg.azQ - this.azm);
    }
    if (this.avN.speed == 1.0F)
    {
      l1 = this.ayT;
      long l2 = this.ayU;
      AppMethodBeat.o(94687);
      return l1 + paramLong - l2;
    }
    if ((this.ayL.isEmpty()) && (this.ayF.aAE >= 1024L))
    {
      l1 = this.ayT;
      paramLong = x.b(paramLong - this.ayU, this.ayF.aAD, this.ayF.aAE);
      AppMethodBeat.o(94687);
      return paramLong + l1;
    }
    long l1 = this.ayT;
    paramLong = (this.avN.speed * (paramLong - this.ayU));
    AppMethodBeat.o(94687);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(94690);
    if (this.ayV == null)
    {
      this.ayV = ByteBuffer.allocate(16);
      this.ayV.order(ByteOrder.BIG_ENDIAN);
      this.ayV.putInt(1431633921);
    }
    if (this.ayW == 0)
    {
      this.ayV.putInt(4, paramInt);
      this.ayV.putLong(8, 1000L * paramLong);
      this.ayV.position(0);
      this.ayW = paramInt;
    }
    int i = this.ayV.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.ayV, i, 1);
      if (j < 0)
      {
        this.ayW = 0;
        AppMethodBeat.o(94690);
        return j;
      }
      if (j < i)
      {
        AppMethodBeat.o(94690);
        return 0;
      }
    }
    paramInt = paramAudioTrack.write(paramByteBuffer, paramInt, 1);
    if (paramInt < 0)
    {
      this.ayW = 0;
      AppMethodBeat.o(94690);
      return paramInt;
    }
    this.ayW -= paramInt;
    AppMethodBeat.o(94690);
    return paramInt;
  }
  
  static int an(String paramString)
  {
    AppMethodBeat.i(94689);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(94689);
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
    AppMethodBeat.o(94689);
    return 5;
    AppMethodBeat.o(94689);
    return 6;
    AppMethodBeat.o(94689);
    return 7;
    AppMethodBeat.o(94689);
    return 8;
  }
  
  final long B(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  final long C(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  final boolean a(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(94680);
    if (!paramByteBuffer.hasRemaining())
    {
      AppMethodBeat.o(94680);
      return true;
    }
    boolean bool;
    label44:
    int k;
    int i;
    int j;
    if (this.azt != null) {
      if (this.azt == paramByteBuffer)
      {
        bool = true;
        a.checkArgument(bool);
        k = paramByteBuffer.remaining();
        if (x.SDK_INT >= 21) {
          break label270;
        }
        i = (int)(this.azi - this.ayK.nv() * this.azh);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.ayN.write(this.azu, this.azv, i);
        i = j;
        if (j > 0)
        {
          this.azv += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.azB = SystemClock.elapsedRealtime();
      if (i < 0)
      {
        paramByteBuffer = new f.h(i);
        AppMethodBeat.o(94680);
        throw paramByteBuffer;
        bool = false;
        break;
        this.azt = paramByteBuffer;
        if (x.SDK_INT >= 21) {
          break label44;
        }
        i = paramByteBuffer.remaining();
        if ((this.azu == null) || (this.azu.length < i)) {
          this.azu = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.azu, 0, i);
        paramByteBuffer.position(j);
        this.azv = 0;
        break label44;
        label270:
        if (this.azz)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.ayN, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.ayN.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.ayQ) {
        this.azi += i;
      }
      if (i == k)
      {
        if (this.ayQ) {
          this.azj += this.azk;
        }
        this.azt = null;
        AppMethodBeat.o(94680);
        return true;
      }
      AppMethodBeat.o(94680);
      return false;
      label400:
      i = 0;
    }
  }
  
  public final long aG(boolean paramBoolean)
  {
    AppMethodBeat.i(94676);
    if ((isInitialized()) && (this.azl != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(94676);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.ayN.getPlayState() == 3)
    {
      l1 = this.ayK.nw();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.aza >= 30000L)
        {
          this.ayJ[this.ayX] = (l1 - l2);
          this.ayX = ((this.ayX + 1) % 10);
          if (this.ayY < 10) {
            this.ayY += 1;
          }
          this.aza = l2;
          this.ayZ = 0L;
          i = 0;
          while (i < this.ayY)
          {
            this.ayZ += this.ayJ[i] / this.ayY;
            i += 1;
          }
        }
        if ((!nt()) && (l2 - this.azc >= 500000L))
        {
          this.azb = this.ayK.nx();
          if (this.azb)
          {
            l3 = this.ayK.ny() / 1000L;
            l4 = this.ayK.nz();
            if (l3 < this.azn) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + nq() + ", " + nr();
            if (ayC)
            {
              localObject = new f.e((String)localObject);
              AppMethodBeat.o(94676);
              throw ((Throwable)localObject);
            }
            this.azb = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.azd != null) && (!this.ayQ)) {}
      try
      {
        this.azo = (((Integer)this.azd.invoke(this.ayN, null)).intValue() * 1000L - this.ayR);
        this.azo = Math.max(this.azo, 0L);
        if (this.azo > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.azo);
          this.azo = 0L;
        }
        this.azc = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.azb)
        {
          l1 = B(C(l1 - this.ayK.ny() / 1000L) + this.ayK.nz());
          l2 = this.azm;
          l1 = A(l1);
          AppMethodBeat.o(94676);
          return l1 + l2;
          label544:
          if (Math.abs(B(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + nq() + ", " + nr();
          if (ayC)
          {
            localObject = new f.e((String)localObject);
            AppMethodBeat.o(94676);
            throw ((Throwable)localObject);
          }
          label666:
          this.azb = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.azd = null;
        }
      }
    }
    if (this.ayY == 0) {}
    for (long l2 = this.ayK.nw();; l2 = l1 + this.ayZ)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.azo;
      break;
    }
  }
  
  public final boolean am(String paramString)
  {
    AppMethodBeat.i(94675);
    if (this.ayD != null)
    {
      c localc = this.ayD;
      int i = an(paramString);
      if (Arrays.binarySearch(localc.aym, i) >= 0) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(94675);
        return true;
      }
    }
    AppMethodBeat.o(94675);
    return false;
  }
  
  public final p c(p paramp)
  {
    AppMethodBeat.i(94683);
    if (this.ayQ)
    {
      this.avN = p.axk;
      paramp = this.avN;
      AppMethodBeat.o(94683);
      return paramp;
    }
    Object localObject = this.ayF;
    ((l)localObject).speed = x.h(paramp.speed, 0.1F, 8.0F);
    float f1 = ((l)localObject).speed;
    localObject = this.ayF;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.h(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.ayS != null)
    {
      paramp = this.ayS;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.ayS = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.avN;
      AppMethodBeat.o(94683);
      return paramp;
      if (!this.ayL.isEmpty())
      {
        paramp = ((f.g)this.ayL.getLast()).avN;
        break;
      }
      paramp = this.avN;
      break;
      label182:
      this.avN = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.ayN != null;
  }
  
  final void nl()
  {
    AppMethodBeat.i(94677);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.ayG;
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
    this.azq = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.azr = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.azq[i];
      ((d)localObject).flush();
      this.azr[i] = ((d)localObject).nk();
      i += 1;
    }
    AppMethodBeat.o(94677);
  }
  
  final boolean nm()
  {
    AppMethodBeat.i(94681);
    int i;
    if (this.azw == -1) {
      if (this.ayQ)
      {
        i = this.azq.length;
        this.azw = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.azw < this.azq.length)
      {
        d locald = this.azq[this.azw];
        if (i != 0) {
          locald.nj();
        }
        z(-9223372036854775807L);
        if (!locald.nd())
        {
          AppMethodBeat.o(94681);
          return false;
          i = 0;
          break;
        }
        this.azw += 1;
        i = 1;
        continue;
      }
      if (this.azt != null)
      {
        a(this.azt, -9223372036854775807L);
        if (this.azt != null)
        {
          AppMethodBeat.o(94681);
          return false;
        }
      }
      this.azw = -1;
      AppMethodBeat.o(94681);
      return true;
      i = 0;
    }
  }
  
  public final boolean nn()
  {
    AppMethodBeat.i(94682);
    if (isInitialized())
    {
      if (nr() <= this.ayK.nv()) {
        if ((!nt()) || (this.ayN.getPlayState() != 2) || (this.ayN.getPlaybackHeadPosition() != 0)) {
          break label70;
        }
      }
      label70:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(94682);
        return true;
      }
    }
    AppMethodBeat.o(94682);
    return false;
  }
  
  final void no()
  {
    AppMethodBeat.i(94684);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.ayN.setVolume(this.azp);
        AppMethodBeat.o(94684);
        return;
      }
      AudioTrack localAudioTrack = this.ayN;
      float f = this.azp;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(94684);
  }
  
  final void np()
  {
    AppMethodBeat.i(94686);
    if (this.ayM == null)
    {
      AppMethodBeat.o(94686);
      return;
    }
    AudioTrack localAudioTrack = this.ayM;
    this.ayM = null;
    new f.2(this, localAudioTrack).start();
    AppMethodBeat.o(94686);
  }
  
  final long nq()
  {
    if (this.ayQ) {
      return this.azg;
    }
    return this.azf / this.aze;
  }
  
  final long nr()
  {
    if (this.ayQ) {
      return this.azj;
    }
    return this.azi / this.azh;
  }
  
  final void ns()
  {
    this.ayZ = 0L;
    this.ayY = 0;
    this.ayX = 0;
    this.aza = 0L;
    this.azb = false;
    this.azc = 0L;
  }
  
  final boolean nt()
  {
    return (x.SDK_INT < 23) && ((this.ayP == 5) || (this.ayP == 6));
  }
  
  final AudioTrack nu()
  {
    AppMethodBeat.i(94688);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.azz) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.ayO).setEncoding(this.ayP).setSampleRate(this.sampleRate).build();
      int i;
      if (this.axF != 0)
      {
        i = this.axF;
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
        localObject = new f.d(i, this.sampleRate, this.ayO, this.bufferSize);
        AppMethodBeat.o(94688);
        throw ((Throwable)localObject);
        localObject = this.axG;
        if (((b)localObject).ayk == null) {
          ((b)localObject).ayk = new AudioAttributes.Builder().setContentType(((b)localObject).ayi).setFlags(((b)localObject).flags).setUsage(((b)localObject).ayj).build();
        }
        localObject = ((b)localObject).ayk;
        continue;
        i = 0;
        break label89;
        i = x.et(this.axG.ayj);
        if (this.axF == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.ayO, this.ayP, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.ayO, this.ayP, this.bufferSize, 1, this.axF);
        break label105;
        label288:
        AppMethodBeat.o(94688);
        return localObject;
      }
      catch (Exception localException)
      {
        break label119;
      }
    }
  }
  
  public final void play()
  {
    AppMethodBeat.i(94678);
    this.azy = true;
    if (isInitialized())
    {
      this.azn = (System.nanoTime() / 1000L);
      this.ayN.play();
    }
    AppMethodBeat.o(94678);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94685);
    if (isInitialized())
    {
      this.azf = 0L;
      this.azg = 0L;
      this.azi = 0L;
      this.azj = 0L;
      this.azk = 0;
      if (this.ayS != null)
      {
        this.avN = this.ayS;
        this.ayS = null;
      }
      for (;;)
      {
        this.ayL.clear();
        this.ayT = 0L;
        this.ayU = 0L;
        this.azs = null;
        this.azt = null;
        int i = 0;
        while (i < this.azq.length)
        {
          localObject = this.azq[i];
          ((d)localObject).flush();
          this.azr[i] = ((d)localObject).nk();
          i += 1;
        }
        if (!this.ayL.isEmpty()) {
          this.avN = ((f.g)this.ayL.getLast()).avN;
        }
      }
      this.azx = false;
      this.azw = -1;
      this.ayV = null;
      this.ayW = 0;
      this.azl = 0;
      this.azo = 0L;
      ns();
      if (this.ayN.getPlayState() == 3) {
        this.ayN.pause();
      }
      Object localObject = this.ayN;
      this.ayN = null;
      this.ayK.a(null, false);
      this.ayI.close();
      new f.1(this, (AudioTrack)localObject).start();
    }
    AppMethodBeat.o(94685);
  }
  
  final void z(long paramLong)
  {
    AppMethodBeat.i(94679);
    int j = this.azq.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.azr[(i - 1)];
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
          AppMethodBeat.o(94679);
          return;
          if (this.azs != null)
          {
            localByteBuffer = this.azs;
            break label34;
          }
          localByteBuffer = d.ayo;
          break label34;
          label87:
          Object localObject = this.azq[i];
          ((d)localObject).c(localByteBuffer);
          localObject = ((d)localObject).nk();
          this.azr[i] = localObject;
          if (((ByteBuffer)localObject).hasRemaining())
          {
            i += 1;
            break;
          }
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(94679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */