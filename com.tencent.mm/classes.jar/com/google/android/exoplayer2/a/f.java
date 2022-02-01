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
  public static boolean bfe = false;
  public static boolean bff = false;
  p bcv;
  int bek;
  b bel;
  private int bfA;
  private int bfB;
  private long bfC;
  private long bfD;
  private boolean bfE;
  private long bfF;
  private Method bfG;
  int bfH;
  long bfI;
  long bfJ;
  int bfK;
  private long bfL;
  private long bfM;
  int bfN;
  int bfO;
  long bfP;
  private long bfQ;
  private long bfR;
  private d[] bfS;
  private ByteBuffer[] bfT;
  ByteBuffer bfU;
  private byte[] bfV;
  private int bfW;
  private int bfX;
  boolean bfY;
  boolean bfZ;
  private final c bfg;
  final g bfh;
  private final l bfi;
  final d[] bfj;
  final f bfk;
  final ConditionVariable bfl;
  private final long[] bfm;
  final a bfn;
  final LinkedList<g> bfo;
  AudioTrack bfp;
  AudioTrack bfq;
  int bfr;
  boolean bft;
  long bfu;
  p bfv;
  private long bfw;
  private long bfx;
  private ByteBuffer bfy;
  int bfz;
  boolean bga;
  boolean bgb;
  long bgc;
  int bufferSize;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.bfg = paramc;
    this.bfk = paramf;
    this.bfl = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.bfG = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.bfn = new b();; this.bfn = new a((byte)0))
      {
        this.bfh = new g();
        this.bfi = new l();
        this.bfj = new d[paramArrayOfd.length + 3];
        this.bfj[0] = new j();
        this.bfj[1] = this.bfh;
        System.arraycopy(paramArrayOfd, 0, this.bfj, 2, paramArrayOfd.length);
        this.bfj[(paramArrayOfd.length + 2)] = this.bfi;
        this.bfm = new long[10];
        this.volume = 1.0F;
        this.bfO = 0;
        this.bel = b.beM;
        this.bek = 0;
        this.bcv = p.bdP;
        this.bfX = -1;
        this.bfS = new d[0];
        this.bfT = new ByteBuffer[0];
        this.bfo = new LinkedList();
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
    while ((!this.bfo.isEmpty()) && (paramLong >= ((g)this.bfo.getFirst()).bdj))
    {
      g localg = (g)this.bfo.remove();
      this.bcv = localg.bcv;
      this.bfx = localg.bdj;
      this.bfw = (localg.bgr - this.bfP);
    }
    if (this.bcv.bdQ == 1.0F)
    {
      l1 = this.bfw;
      long l2 = this.bfx;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.bfo.isEmpty()) && (this.bfi.bhf >= 1024L))
    {
      l1 = this.bfw;
      paramLong = x.b(paramLong - this.bfx, this.bfi.bhe, this.bfi.bhf);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.bfw;
    paramLong = (this.bcv.bdQ * (paramLong - this.bfx));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.bfy == null)
    {
      this.bfy = ByteBuffer.allocate(16);
      this.bfy.order(ByteOrder.BIG_ENDIAN);
      this.bfy.putInt(1431633921);
    }
    if (this.bfz == 0)
    {
      this.bfy.putInt(4, paramInt);
      this.bfy.putLong(8, 1000L * paramLong);
      this.bfy.position(0);
      this.bfz = paramInt;
    }
    int i = this.bfy.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.bfy, i, 1);
      if (j < 0)
      {
        this.bfz = 0;
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
      this.bfz = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.bfz -= paramInt;
    AppMethodBeat.o(91801);
    return paramInt;
  }
  
  static int be(String paramString)
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
    int j = this.bfS.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.bfT[(i - 1)];
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
          if (this.bfU != null)
          {
            localByteBuffer = this.bfU;
            break label34;
          }
          localByteBuffer = d.beR;
          break label34;
          label87:
          Object localObject = this.bfS[i];
          ((d)localObject).f(localByteBuffer);
          localObject = ((d)localObject).tE();
          this.bfT[i] = localObject;
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
        i = (int)(this.bfL - this.bfn.tP() * this.bfK);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.bfq.write(this.bfV, this.bfW, i);
        i = j;
        if (j > 0)
        {
          this.bfW += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.bgc = SystemClock.elapsedRealtime();
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
        if ((this.bfV == null) || (this.bfV.length < i)) {
          this.bfV = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.bfV, 0, i);
        paramByteBuffer.position(j);
        this.bfW = 0;
        break label44;
        label270:
        if (this.bga)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.bfq, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.bfq.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.bft) {
        this.bfL += i;
      }
      if (i == k)
      {
        if (this.bft) {
          this.bfM += this.bfN;
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
  
  public final long aT(boolean paramBoolean)
  {
    AppMethodBeat.i(91787);
    if ((isInitialized()) && (this.bfO != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.bfq.getPlayState() == 3)
    {
      l1 = this.bfn.tQ();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.bfD >= 30000L)
        {
          this.bfm[this.bfA] = (l1 - l2);
          this.bfA = ((this.bfA + 1) % 10);
          if (this.bfB < 10) {
            this.bfB += 1;
          }
          this.bfD = l2;
          this.bfC = 0L;
          i = 0;
          while (i < this.bfB)
          {
            this.bfC += this.bfm[i] / this.bfB;
            i += 1;
          }
        }
        if ((!tN()) && (l2 - this.bfF >= 500000L))
        {
          this.bfE = this.bfn.tR();
          if (this.bfE)
          {
            l3 = this.bfn.tS() / 1000L;
            l4 = this.bfn.tT();
            if (l3 < this.bfQ) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + tK() + ", " + tL();
            if (bff)
            {
              localObject = new e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.bfE = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.bfG != null) && (!this.bft)) {}
      try
      {
        this.bfR = (((Integer)this.bfG.invoke(this.bfq, null)).intValue() * 1000L - this.bfu);
        this.bfR = Math.max(this.bfR, 0L);
        if (this.bfR > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.bfR);
          this.bfR = 0L;
        }
        this.bfF = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.bfE)
        {
          l1 = I(J(l1 - this.bfn.tS() / 1000L) + this.bfn.tT());
          l2 = this.bfP;
          l1 = H(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(I(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + tK() + ", " + tL();
          if (bff)
          {
            localObject = new e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.bfE = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.bfG = null;
        }
      }
    }
    if (this.bfB == 0) {}
    for (long l2 = this.bfn.tQ();; l2 = l1 + this.bfC)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.bfR;
      break;
    }
  }
  
  public final boolean bd(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.bfg != null)
    {
      c localc = this.bfg;
      int i = be(paramString);
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
    if (this.bft)
    {
      this.bcv = p.bdP;
      paramp = this.bcv;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.bfi;
    ((l)localObject).bdQ = x.k(paramp.bdQ, 0.1F, 8.0F);
    float f1 = ((l)localObject).bdQ;
    localObject = this.bfi;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.k(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.bfv != null)
    {
      paramp = this.bfv;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.bfv = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.bcv;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.bfo.isEmpty())
      {
        paramp = ((g)this.bfo.getLast()).bcv;
        break;
      }
      paramp = this.bcv;
      break;
      label182:
      this.bcv = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.bfq != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.bfZ = true;
    if (isInitialized())
    {
      this.bfQ = (System.nanoTime() / 1000L);
      this.bfq.play();
    }
    AppMethodBeat.o(91789);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.bfI = 0L;
      this.bfJ = 0L;
      this.bfL = 0L;
      this.bfM = 0L;
      this.bfN = 0;
      if (this.bfv != null)
      {
        this.bcv = this.bfv;
        this.bfv = null;
      }
      for (;;)
      {
        this.bfo.clear();
        this.bfw = 0L;
        this.bfx = 0L;
        this.bfU = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.bfS.length)
        {
          localObject = this.bfS[i];
          ((d)localObject).flush();
          this.bfT[i] = ((d)localObject).tE();
          i += 1;
        }
        if (!this.bfo.isEmpty()) {
          this.bcv = ((g)this.bfo.getLast()).bcv;
        }
      }
      this.bfY = false;
      this.bfX = -1;
      this.bfy = null;
      this.bfz = 0;
      this.bfO = 0;
      this.bfR = 0L;
      tM();
      if (this.bfq.getPlayState() == 3) {
        this.bfq.pause();
      }
      Object localObject = this.bfq;
      this.bfq = null;
      this.bfn.a(null, false);
      this.bfl.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.bgd.flush();
            this.bgd.release();
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
  
  final void tF()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.bfj;
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
    this.bfS = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.bfT = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.bfS[i];
      ((d)localObject).flush();
      this.bfT[i] = ((d)localObject).tE();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean tG()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.bfX == -1) {
      if (this.bft)
      {
        i = this.bfS.length;
        this.bfX = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.bfX < this.bfS.length)
      {
        d locald = this.bfS[this.bfX];
        if (i != 0) {
          locald.tD();
        }
        G(-9223372036854775807L);
        if (!locald.tw())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.bfX += 1;
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
      this.bfX = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean tH()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (tL() <= this.bfn.tP()) {
        if ((!tN()) || (this.bfq.getPlayState() != 2) || (this.bfq.getPlaybackHeadPosition() != 0)) {
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
  
  final void tI()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.bfq.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.bfq;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void tJ()
  {
    AppMethodBeat.i(91797);
    if (this.bfp == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.bfp;
    this.bfp = null;
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
  
  final long tK()
  {
    if (this.bft) {
      return this.bfJ;
    }
    return this.bfI / this.bfH;
  }
  
  final long tL()
  {
    if (this.bft) {
      return this.bfM;
    }
    return this.bfL / this.bfK;
  }
  
  final void tM()
  {
    this.bfC = 0L;
    this.bfB = 0;
    this.bfA = 0;
    this.bfD = 0L;
    this.bfE = false;
    this.bfF = 0L;
  }
  
  final boolean tN()
  {
    return (x.SDK_INT < 23) && ((this.bfr == 5) || (this.bfr == 6));
  }
  
  final AudioTrack tO()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.bga) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.bfr).setSampleRate(this.sampleRate).build();
      int i;
      if (this.bek != 0)
      {
        i = this.bek;
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
        localObject = this.bel;
        if (((b)localObject).beP == null) {
          ((b)localObject).beP = new AudioAttributes.Builder().setContentType(((b)localObject).beN).setFlags(((b)localObject).flags).setUsage(((b)localObject).beO).build();
        }
        localObject = ((b)localObject).beP;
        continue;
        i = 0;
        break label89;
        i = x.fg(this.bel.beO);
        if (this.bek == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.bfr, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.bfr, this.bufferSize, 1, this.bek);
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
    protected AudioTrack bfq;
    private boolean bgf;
    private long bgg;
    private long bgh;
    private long bgi;
    private long bgj;
    private long bgk;
    private long bgl;
    private int sampleRate;
    
    public final void K(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.bgk = tP();
      this.bgj = (SystemClock.elapsedRealtime() * 1000L);
      this.bgl = paramLong;
      this.bfq.stop();
      AppMethodBeat.o(91774);
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.bfq = paramAudioTrack;
      this.bgf = paramBoolean;
      this.bgj = -9223372036854775807L;
      this.bgg = 0L;
      this.bgh = 0L;
      this.bgi = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.bgj != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.bfq.pause();
      AppMethodBeat.o(91775);
    }
    
    public final long tP()
    {
      AppMethodBeat.i(91776);
      if (this.bgj != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.bgj) * this.sampleRate / 1000000L;
        l1 = Math.min(this.bgl, l1 + this.bgk);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.bfq.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.bfq.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.bgf)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.bgi = this.bgg;
        }
        l1 = l2 + this.bgi;
      }
      if (this.bgg > l1) {
        this.bgh += 1L;
      }
      this.bgg = l1;
      l2 = this.bgh;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long tQ()
    {
      AppMethodBeat.i(91777);
      long l = tP() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean tR()
    {
      return false;
    }
    
    public long tS()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long tT()
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
    private final AudioTimestamp bgm;
    private long bgn;
    private long bgo;
    private long bgp;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.bgm = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.bgn = 0L;
      this.bgo = 0L;
      this.bgp = 0L;
      AppMethodBeat.o(91781);
    }
    
    public final boolean tR()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.bfq.getTimestamp(this.bgm);
      if (bool)
      {
        long l = this.bgm.framePosition;
        if (this.bgo > l) {
          this.bgn += 1L;
        }
        this.bgo = l;
        this.bgp = (l + (this.bgn << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long tS()
    {
      return this.bgm.nanoTime;
    }
    
    public final long tT()
    {
      return this.bgp;
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
    
    public abstract void dL(int paramInt);
    
    public abstract void tv();
  }
  
  static final class g
  {
    final p bcv;
    final long bdj;
    final long bgr;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.bcv = paramp;
      this.bgr = paramLong1;
      this.bdj = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */