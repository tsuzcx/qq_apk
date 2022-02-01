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
  public static boolean aTU = false;
  public static boolean aTV = false;
  p aRf;
  int aSY;
  b aSZ;
  private final c aTW;
  final g aTX;
  private final l aTY;
  final d[] aTZ;
  int aUA;
  private long aUB;
  private long aUC;
  int aUD;
  int aUE;
  long aUF;
  private long aUG;
  private long aUH;
  private d[] aUJ;
  private ByteBuffer[] aUK;
  ByteBuffer aUL;
  private byte[] aUN;
  private int aUO;
  private int aUP;
  boolean aUQ;
  boolean aUR;
  boolean aUS;
  boolean aUT;
  long aUU;
  final f aUa;
  final ConditionVariable aUb;
  private final long[] aUc;
  final a aUd;
  final LinkedList<g> aUe;
  AudioTrack aUf;
  AudioTrack aUg;
  int aUi;
  boolean aUj;
  long aUk;
  p aUl;
  private long aUm;
  private long aUn;
  private ByteBuffer aUo;
  int aUp;
  private int aUq;
  private int aUr;
  private long aUs;
  private long aUt;
  private boolean aUu;
  private long aUv;
  private Method aUw;
  int aUx;
  long aUy;
  long aUz;
  int bufferSize;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.aTW = paramc;
    this.aUa = paramf;
    this.aUb = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.aUw = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.aUd = new b();; this.aUd = new a((byte)0))
      {
        this.aTX = new g();
        this.aTY = new l();
        this.aTZ = new d[paramArrayOfd.length + 3];
        this.aTZ[0] = new j();
        this.aTZ[1] = this.aTX;
        System.arraycopy(paramArrayOfd, 0, this.aTZ, 2, paramArrayOfd.length);
        this.aTZ[(paramArrayOfd.length + 2)] = this.aTY;
        this.aUc = new long[10];
        this.volume = 1.0F;
        this.aUE = 0;
        this.aSZ = b.aTA;
        this.aSY = 0;
        this.aRf = p.aSC;
        this.aUP = -1;
        this.aUJ = new d[0];
        this.aUK = new ByteBuffer[0];
        this.aUe = new LinkedList();
        AppMethodBeat.o(91785);
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label51;
    }
  }
  
  private long F(long paramLong)
  {
    AppMethodBeat.i(91798);
    while ((!this.aUe.isEmpty()) && (paramLong >= ((g)this.aUe.getFirst()).aRT))
    {
      g localg = (g)this.aUe.remove();
      this.aRf = localg.aRf;
      this.aUn = localg.aRT;
      this.aUm = (localg.aVj - this.aUF);
    }
    if (this.aRf.aSD == 1.0F)
    {
      l1 = this.aUm;
      long l2 = this.aUn;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.aUe.isEmpty()) && (this.aTY.aVX >= 1024L))
    {
      l1 = this.aUm;
      paramLong = x.b(paramLong - this.aUn, this.aTY.aVW, this.aTY.aVX);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.aUm;
    paramLong = (this.aRf.aSD * (paramLong - this.aUn));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.aUo == null)
    {
      this.aUo = ByteBuffer.allocate(16);
      this.aUo.order(ByteOrder.BIG_ENDIAN);
      this.aUo.putInt(1431633921);
    }
    if (this.aUp == 0)
    {
      this.aUo.putInt(4, paramInt);
      this.aUo.putLong(8, 1000L * paramLong);
      this.aUo.position(0);
      this.aUp = paramInt;
    }
    int i = this.aUo.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.aUo, i, 1);
      if (j < 0)
      {
        this.aUp = 0;
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
      this.aUp = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.aUp -= paramInt;
    AppMethodBeat.o(91801);
    return paramInt;
  }
  
  static int aj(String paramString)
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
  
  final void E(long paramLong)
  {
    AppMethodBeat.i(91790);
    int j = this.aUJ.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.aUK[(i - 1)];
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
          if (this.aUL != null)
          {
            localByteBuffer = this.aUL;
            break label34;
          }
          localByteBuffer = d.aTH;
          break label34;
          label87:
          Object localObject = this.aUJ[i];
          ((d)localObject).f(localByteBuffer);
          localObject = ((d)localObject).rW();
          this.aUK[i] = localObject;
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
  
  final long G(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  final long H(long paramLong)
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
        i = (int)(this.aUB - this.aUd.sh() * this.aUA);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.aUg.write(this.aUN, this.aUO, i);
        i = j;
        if (j > 0)
        {
          this.aUO += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.aUU = SystemClock.elapsedRealtime();
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
        if ((this.aUN == null) || (this.aUN.length < i)) {
          this.aUN = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.aUN, 0, i);
        paramByteBuffer.position(j);
        this.aUO = 0;
        break label44;
        label270:
        if (this.aUS)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.aUg, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.aUg.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.aUj) {
        this.aUB += i;
      }
      if (i == k)
      {
        if (this.aUj) {
          this.aUC += this.aUD;
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
    if ((isInitialized()) && (this.aUE != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.aUg.getPlayState() == 3)
    {
      l1 = this.aUd.si();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.aUt >= 30000L)
        {
          this.aUc[this.aUq] = (l1 - l2);
          this.aUq = ((this.aUq + 1) % 10);
          if (this.aUr < 10) {
            this.aUr += 1;
          }
          this.aUt = l2;
          this.aUs = 0L;
          i = 0;
          while (i < this.aUr)
          {
            this.aUs += this.aUc[i] / this.aUr;
            i += 1;
          }
        }
        if ((!sf()) && (l2 - this.aUv >= 500000L))
        {
          this.aUu = this.aUd.sj();
          if (this.aUu)
          {
            l3 = this.aUd.sk() / 1000L;
            l4 = this.aUd.sl();
            if (l3 < this.aUG) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + sc() + ", " + sd();
            if (aTV)
            {
              localObject = new e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.aUu = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.aUw != null) && (!this.aUj)) {}
      try
      {
        this.aUH = (((Integer)this.aUw.invoke(this.aUg, null)).intValue() * 1000L - this.aUk);
        this.aUH = Math.max(this.aUH, 0L);
        if (this.aUH > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.aUH);
          this.aUH = 0L;
        }
        this.aUv = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.aUu)
        {
          l1 = G(H(l1 - this.aUd.sk() / 1000L) + this.aUd.sl());
          l2 = this.aUF;
          l1 = F(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(G(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + sc() + ", " + sd();
          if (aTV)
          {
            localObject = new e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.aUu = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.aUw = null;
        }
      }
    }
    if (this.aUr == 0) {}
    for (long l2 = this.aUd.si();; l2 = l1 + this.aUs)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.aUH;
      break;
    }
  }
  
  public final boolean ai(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.aTW != null)
    {
      c localc = this.aTW;
      int i = aj(paramString);
      if (Arrays.binarySearch(localc.aTF, i) >= 0) {}
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
    if (this.aUj)
    {
      this.aRf = p.aSC;
      paramp = this.aRf;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.aTY;
    ((l)localObject).aSD = x.j(paramp.aSD, 0.1F, 8.0F);
    float f1 = ((l)localObject).aSD;
    localObject = this.aTY;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.j(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.aUl != null)
    {
      paramp = this.aUl;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.aUl = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.aRf;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.aUe.isEmpty())
      {
        paramp = ((g)this.aUe.getLast()).aRf;
        break;
      }
      paramp = this.aRf;
      break;
      label182:
      this.aRf = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.aUg != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.aUR = true;
    if (isInitialized())
    {
      this.aUG = (System.nanoTime() / 1000L);
      this.aUg.play();
    }
    AppMethodBeat.o(91789);
  }
  
  final void rX()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.aTZ;
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
    this.aUJ = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.aUK = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.aUJ[i];
      ((d)localObject).flush();
      this.aUK[i] = ((d)localObject).rW();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean rY()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.aUP == -1) {
      if (this.aUj)
      {
        i = this.aUJ.length;
        this.aUP = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.aUP < this.aUJ.length)
      {
        d locald = this.aUJ[this.aUP];
        if (i != 0) {
          locald.rV();
        }
        E(-9223372036854775807L);
        if (!locald.rM())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.aUP += 1;
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
      this.aUP = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean rZ()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (sd() <= this.aUd.sh()) {
        if ((!sf()) || (this.aUg.getPlayState() != 2) || (this.aUg.getPlaybackHeadPosition() != 0)) {
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
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.aUy = 0L;
      this.aUz = 0L;
      this.aUB = 0L;
      this.aUC = 0L;
      this.aUD = 0;
      if (this.aUl != null)
      {
        this.aRf = this.aUl;
        this.aUl = null;
      }
      for (;;)
      {
        this.aUe.clear();
        this.aUm = 0L;
        this.aUn = 0L;
        this.aUL = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.aUJ.length)
        {
          localObject = this.aUJ[i];
          ((d)localObject).flush();
          this.aUK[i] = ((d)localObject).rW();
          i += 1;
        }
        if (!this.aUe.isEmpty()) {
          this.aRf = ((g)this.aUe.getLast()).aRf;
        }
      }
      this.aUQ = false;
      this.aUP = -1;
      this.aUo = null;
      this.aUp = 0;
      this.aUE = 0;
      this.aUH = 0L;
      se();
      if (this.aUg.getPlayState() == 3) {
        this.aUg.pause();
      }
      Object localObject = this.aUg;
      this.aUg = null;
      this.aUd.a(null, false);
      this.aUb.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.aUV.flush();
            this.aUV.release();
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
  
  final void sa()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.aUg.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.aUg;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void sb()
  {
    AppMethodBeat.i(91797);
    if (this.aUf == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.aUf;
    this.aUf = null;
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
  
  final long sc()
  {
    if (this.aUj) {
      return this.aUz;
    }
    return this.aUy / this.aUx;
  }
  
  final long sd()
  {
    if (this.aUj) {
      return this.aUC;
    }
    return this.aUB / this.aUA;
  }
  
  final void se()
  {
    this.aUs = 0L;
    this.aUr = 0;
    this.aUq = 0;
    this.aUt = 0L;
    this.aUu = false;
    this.aUv = 0L;
  }
  
  final boolean sf()
  {
    return (x.SDK_INT < 23) && ((this.aUi == 5) || (this.aUi == 6));
  }
  
  final AudioTrack sg()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.aUS) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.aUi).setSampleRate(this.sampleRate).build();
      int i;
      if (this.aSY != 0)
      {
        i = this.aSY;
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
        localObject = this.aSZ;
        if (((b)localObject).aTD == null) {
          ((b)localObject).aTD = new AudioAttributes.Builder().setContentType(((b)localObject).aTB).setFlags(((b)localObject).flags).setUsage(((b)localObject).aTC).build();
        }
        localObject = ((b)localObject).aTD;
        continue;
        i = 0;
        break label89;
        i = x.fr(this.aSZ.aTC);
        if (this.aSY == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aUi, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.aUi, this.bufferSize, 1, this.aSY);
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
    private boolean aUX;
    private long aUY;
    private long aUZ;
    protected AudioTrack aUg;
    private long aVa;
    private long aVb;
    private long aVc;
    private long aVd;
    private int sampleRate;
    
    public final void I(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.aVc = sh();
      this.aVb = (SystemClock.elapsedRealtime() * 1000L);
      this.aVd = paramLong;
      this.aUg.stop();
      AppMethodBeat.o(91774);
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.aUg = paramAudioTrack;
      this.aUX = paramBoolean;
      this.aVb = -9223372036854775807L;
      this.aUY = 0L;
      this.aUZ = 0L;
      this.aVa = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.aVb != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.aUg.pause();
      AppMethodBeat.o(91775);
    }
    
    public final long sh()
    {
      AppMethodBeat.i(91776);
      if (this.aVb != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.aVb) * this.sampleRate / 1000000L;
        l1 = Math.min(this.aVd, l1 + this.aVc);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.aUg.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.aUg.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.aUX)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.aVa = this.aUY;
        }
        l1 = l2 + this.aVa;
      }
      if (this.aUY > l1) {
        this.aUZ += 1L;
      }
      this.aUY = l1;
      l2 = this.aUZ;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long si()
    {
      AppMethodBeat.i(91777);
      long l = sh() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean sj()
    {
      return false;
    }
    
    public long sk()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long sl()
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
    private final AudioTimestamp aVe;
    private long aVf;
    private long aVg;
    private long aVh;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.aVe = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.aVf = 0L;
      this.aVg = 0L;
      this.aVh = 0L;
      AppMethodBeat.o(91781);
    }
    
    public final boolean sj()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.aUg.getTimestamp(this.aVe);
      if (bool)
      {
        long l = this.aVe.framePosition;
        if (this.aVg > l) {
          this.aVf += 1L;
        }
        this.aVg = l;
        this.aVh = (l + (this.aVf << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long sk()
    {
      return this.aVe.nanoTime;
    }
    
    public final long sl()
    {
      return this.aVh;
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
    
    public abstract void dI(int paramInt);
    
    public abstract void rL();
  }
  
  static final class g
  {
    final long aRT;
    final p aRf;
    final long aVj;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.aRf = paramp;
      this.aVj = paramLong1;
      this.aRT = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */