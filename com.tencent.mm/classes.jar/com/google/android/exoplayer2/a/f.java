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
  public static boolean bfb = false;
  public static boolean bfc = false;
  p bcs;
  int beh;
  b bei;
  private long bfA;
  private boolean bfB;
  private long bfC;
  private Method bfD;
  int bfE;
  long bfF;
  long bfG;
  int bfH;
  private long bfI;
  private long bfJ;
  int bfK;
  int bfL;
  long bfM;
  private long bfN;
  private long bfO;
  private d[] bfP;
  private ByteBuffer[] bfQ;
  ByteBuffer bfR;
  private byte[] bfS;
  private int bfT;
  private int bfU;
  boolean bfV;
  boolean bfW;
  boolean bfX;
  boolean bfY;
  long bfZ;
  private final c bfd;
  final g bfe;
  private final l bff;
  final d[] bfg;
  final f bfh;
  final ConditionVariable bfi;
  private final long[] bfj;
  final a bfk;
  final LinkedList<g> bfl;
  AudioTrack bfm;
  AudioTrack bfn;
  int bfo;
  boolean bfp;
  long bfq;
  p bfr;
  private long bft;
  private long bfu;
  private ByteBuffer bfv;
  int bfw;
  private int bfx;
  private int bfy;
  private long bfz;
  int bufferSize;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.bfd = paramc;
    this.bfh = paramf;
    this.bfi = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.bfD = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.bfk = new b();; this.bfk = new a((byte)0))
      {
        this.bfe = new g();
        this.bff = new l();
        this.bfg = new d[paramArrayOfd.length + 3];
        this.bfg[0] = new j();
        this.bfg[1] = this.bfe;
        System.arraycopy(paramArrayOfd, 0, this.bfg, 2, paramArrayOfd.length);
        this.bfg[(paramArrayOfd.length + 2)] = this.bff;
        this.bfj = new long[10];
        this.volume = 1.0F;
        this.bfL = 0;
        this.bei = b.beJ;
        this.beh = 0;
        this.bcs = p.bdM;
        this.bfU = -1;
        this.bfP = new d[0];
        this.bfQ = new ByteBuffer[0];
        this.bfl = new LinkedList();
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
    while ((!this.bfl.isEmpty()) && (paramLong >= ((g)this.bfl.getFirst()).bdg))
    {
      g localg = (g)this.bfl.remove();
      this.bcs = localg.bcs;
      this.bfu = localg.bdg;
      this.bft = (localg.bgo - this.bfM);
    }
    if (this.bcs.bdN == 1.0F)
    {
      l1 = this.bft;
      long l2 = this.bfu;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.bfl.isEmpty()) && (this.bff.bhc >= 1024L))
    {
      l1 = this.bft;
      paramLong = x.b(paramLong - this.bfu, this.bff.bhb, this.bff.bhc);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.bft;
    paramLong = (this.bcs.bdN * (paramLong - this.bfu));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.bfv == null)
    {
      this.bfv = ByteBuffer.allocate(16);
      this.bfv.order(ByteOrder.BIG_ENDIAN);
      this.bfv.putInt(1431633921);
    }
    if (this.bfw == 0)
    {
      this.bfv.putInt(4, paramInt);
      this.bfv.putLong(8, 1000L * paramLong);
      this.bfv.position(0);
      this.bfw = paramInt;
    }
    int i = this.bfv.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.bfv, i, 1);
      if (j < 0)
      {
        this.bfw = 0;
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
      this.bfw = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.bfw -= paramInt;
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
    int j = this.bfP.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.bfQ[(i - 1)];
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
          if (this.bfR != null)
          {
            localByteBuffer = this.bfR;
            break label34;
          }
          localByteBuffer = d.beO;
          break label34;
          label87:
          Object localObject = this.bfP[i];
          ((d)localObject).f(localByteBuffer);
          localObject = ((d)localObject).tJ();
          this.bfQ[i] = localObject;
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
        i = (int)(this.bfI - this.bfk.tU() * this.bfH);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.bfn.write(this.bfS, this.bfT, i);
        i = j;
        if (j > 0)
        {
          this.bfT += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.bfZ = SystemClock.elapsedRealtime();
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
        if ((this.bfS == null) || (this.bfS.length < i)) {
          this.bfS = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.bfS, 0, i);
        paramByteBuffer.position(j);
        this.bfT = 0;
        break label44;
        label270:
        if (this.bfX)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.bfn, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.bfn.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.bfp) {
        this.bfI += i;
      }
      if (i == k)
      {
        if (this.bfp) {
          this.bfJ += this.bfK;
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
    if ((isInitialized()) && (this.bfL != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.bfn.getPlayState() == 3)
    {
      l1 = this.bfk.tV();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.bfA >= 30000L)
        {
          this.bfj[this.bfx] = (l1 - l2);
          this.bfx = ((this.bfx + 1) % 10);
          if (this.bfy < 10) {
            this.bfy += 1;
          }
          this.bfA = l2;
          this.bfz = 0L;
          i = 0;
          while (i < this.bfy)
          {
            this.bfz += this.bfj[i] / this.bfy;
            i += 1;
          }
        }
        if ((!tS()) && (l2 - this.bfC >= 500000L))
        {
          this.bfB = this.bfk.tW();
          if (this.bfB)
          {
            l3 = this.bfk.tX() / 1000L;
            l4 = this.bfk.tY();
            if (l3 < this.bfN) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + tP() + ", " + tQ();
            if (bfc)
            {
              localObject = new e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.bfB = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.bfD != null) && (!this.bfp)) {}
      try
      {
        this.bfO = (((Integer)this.bfD.invoke(this.bfn, null)).intValue() * 1000L - this.bfq);
        this.bfO = Math.max(this.bfO, 0L);
        if (this.bfO > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.bfO);
          this.bfO = 0L;
        }
        this.bfC = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.bfB)
        {
          l1 = I(J(l1 - this.bfk.tX() / 1000L) + this.bfk.tY());
          l2 = this.bfM;
          l1 = H(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(I(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + tP() + ", " + tQ();
          if (bfc)
          {
            localObject = new e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.bfB = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.bfD = null;
        }
      }
    }
    if (this.bfy == 0) {}
    for (long l2 = this.bfk.tV();; l2 = l1 + this.bfz)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.bfO;
      break;
    }
  }
  
  public final boolean bd(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.bfd != null)
    {
      c localc = this.bfd;
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
    if (this.bfp)
    {
      this.bcs = p.bdM;
      paramp = this.bcs;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.bff;
    ((l)localObject).bdN = x.k(paramp.bdN, 0.1F, 8.0F);
    float f1 = ((l)localObject).bdN;
    localObject = this.bff;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.k(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.bfr != null)
    {
      paramp = this.bfr;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.bfr = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.bcs;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.bfl.isEmpty())
      {
        paramp = ((g)this.bfl.getLast()).bcs;
        break;
      }
      paramp = this.bcs;
      break;
      label182:
      this.bcs = ((p)localObject);
    }
  }
  
  final boolean isInitialized()
  {
    return this.bfn != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.bfW = true;
    if (isInitialized())
    {
      this.bfN = (System.nanoTime() / 1000L);
      this.bfn.play();
    }
    AppMethodBeat.o(91789);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.bfF = 0L;
      this.bfG = 0L;
      this.bfI = 0L;
      this.bfJ = 0L;
      this.bfK = 0;
      if (this.bfr != null)
      {
        this.bcs = this.bfr;
        this.bfr = null;
      }
      for (;;)
      {
        this.bfl.clear();
        this.bft = 0L;
        this.bfu = 0L;
        this.bfR = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.bfP.length)
        {
          localObject = this.bfP[i];
          ((d)localObject).flush();
          this.bfQ[i] = ((d)localObject).tJ();
          i += 1;
        }
        if (!this.bfl.isEmpty()) {
          this.bcs = ((g)this.bfl.getLast()).bcs;
        }
      }
      this.bfV = false;
      this.bfU = -1;
      this.bfv = null;
      this.bfw = 0;
      this.bfL = 0;
      this.bfO = 0L;
      tR();
      if (this.bfn.getPlayState() == 3) {
        this.bfn.pause();
      }
      Object localObject = this.bfn;
      this.bfn = null;
      this.bfk.a(null, false);
      this.bfi.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.bga.flush();
            this.bga.release();
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
  
  final void tK()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.bfg;
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
    this.bfP = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.bfQ = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.bfP[i];
      ((d)localObject).flush();
      this.bfQ[i] = ((d)localObject).tJ();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean tL()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.bfU == -1) {
      if (this.bfp)
      {
        i = this.bfP.length;
        this.bfU = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.bfU < this.bfP.length)
      {
        d locald = this.bfP[this.bfU];
        if (i != 0) {
          locald.tI();
        }
        G(-9223372036854775807L);
        if (!locald.tB())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.bfU += 1;
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
      this.bfU = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean tM()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (tQ() <= this.bfk.tU()) {
        if ((!tS()) || (this.bfn.getPlayState() != 2) || (this.bfn.getPlaybackHeadPosition() != 0)) {
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
  
  final void tN()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.bfn.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.bfn;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void tO()
  {
    AppMethodBeat.i(91797);
    if (this.bfm == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.bfm;
    this.bfm = null;
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
  
  final long tP()
  {
    if (this.bfp) {
      return this.bfG;
    }
    return this.bfF / this.bfE;
  }
  
  final long tQ()
  {
    if (this.bfp) {
      return this.bfJ;
    }
    return this.bfI / this.bfH;
  }
  
  final void tR()
  {
    this.bfz = 0L;
    this.bfy = 0;
    this.bfx = 0;
    this.bfA = 0L;
    this.bfB = false;
    this.bfC = 0L;
  }
  
  final boolean tS()
  {
    return (x.SDK_INT < 23) && ((this.bfo == 5) || (this.bfo == 6));
  }
  
  final AudioTrack tT()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.bfX) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.bfo).setSampleRate(this.sampleRate).build();
      int i;
      if (this.beh != 0)
      {
        i = this.beh;
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
        localObject = this.bei;
        if (((b)localObject).beM == null) {
          ((b)localObject).beM = new AudioAttributes.Builder().setContentType(((b)localObject).beK).setFlags(((b)localObject).flags).setUsage(((b)localObject).beL).build();
        }
        localObject = ((b)localObject).beM;
        continue;
        i = 0;
        break label89;
        i = x.fh(this.bei.beL);
        if (this.beh == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.bfo, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.bfo, this.bufferSize, 1, this.beh);
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
    protected AudioTrack bfn;
    private boolean bgc;
    private long bgd;
    private long bge;
    private long bgf;
    private long bgg;
    private long bgh;
    private long bgi;
    private int sampleRate;
    
    public final void K(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.bgh = tU();
      this.bgg = (SystemClock.elapsedRealtime() * 1000L);
      this.bgi = paramLong;
      this.bfn.stop();
      AppMethodBeat.o(91774);
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.bfn = paramAudioTrack;
      this.bgc = paramBoolean;
      this.bgg = -9223372036854775807L;
      this.bgd = 0L;
      this.bge = 0L;
      this.bgf = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.bgg != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.bfn.pause();
      AppMethodBeat.o(91775);
    }
    
    public final long tU()
    {
      AppMethodBeat.i(91776);
      if (this.bgg != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.bgg) * this.sampleRate / 1000000L;
        l1 = Math.min(this.bgi, l1 + this.bgh);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.bfn.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.bfn.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.bgc)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.bgf = this.bgd;
        }
        l1 = l2 + this.bgf;
      }
      if (this.bgd > l1) {
        this.bge += 1L;
      }
      this.bgd = l1;
      l2 = this.bge;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long tV()
    {
      AppMethodBeat.i(91777);
      long l = tU() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean tW()
    {
      return false;
    }
    
    public long tX()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long tY()
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
    private final AudioTimestamp bgj;
    private long bgk;
    private long bgl;
    private long bgm;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.bgj = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.bgk = 0L;
      this.bgl = 0L;
      this.bgm = 0L;
      AppMethodBeat.o(91781);
    }
    
    public final boolean tW()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.bfn.getTimestamp(this.bgj);
      if (bool)
      {
        long l = this.bgj.framePosition;
        if (this.bgl > l) {
          this.bgk += 1L;
        }
        this.bgl = l;
        this.bgm = (l + (this.bgk << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long tX()
    {
      return this.bgj.nanoTime;
    }
    
    public final long tY()
    {
      return this.bgm;
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
    public abstract void dG(int paramInt);
    
    public abstract void e(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void tA();
  }
  
  static final class g
  {
    final p bcs;
    final long bdg;
    final long bgo;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.bcs = paramp;
      this.bgo = paramLong1;
      this.bdg = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */