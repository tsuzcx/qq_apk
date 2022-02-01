package com.google.android.exoplayer2.a;

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
  public static boolean cIy = false;
  public static boolean cIz = false;
  int bufferSize;
  p cFP;
  int cHE;
  b cHF;
  private final c cIA;
  final g cIB;
  private final l cIC;
  final d[] cID;
  final f cIE;
  final ConditionVariable cIF;
  private final long[] cIG;
  final a cIH;
  final LinkedList<g> cII;
  AudioTrack cIJ;
  AudioTrack cIK;
  int cIL;
  boolean cIM;
  long cIN;
  p cIO;
  private long cIP;
  private long cIQ;
  private ByteBuffer cIR;
  int cIS;
  private int cIT;
  private int cIU;
  private long cIV;
  private long cIW;
  private boolean cIX;
  private long cIY;
  private Method cIZ;
  int cJa;
  long cJb;
  long cJc;
  int cJd;
  private long cJe;
  private long cJf;
  int cJg;
  int cJh;
  long cJi;
  private long cJj;
  private long cJk;
  private d[] cJl;
  private ByteBuffer[] cJm;
  ByteBuffer cJn;
  private byte[] cJo;
  private int cJp;
  private int cJq;
  boolean cJr;
  boolean cJs;
  boolean cJt;
  boolean cJu;
  long cJv;
  int channelConfig;
  int encoding;
  private ByteBuffer outputBuffer;
  int sampleRate;
  float volume;
  
  public f(c paramc, d[] paramArrayOfd, f paramf)
  {
    AppMethodBeat.i(91785);
    this.cIA = paramc;
    this.cIE = paramf;
    this.cIF = new ConditionVariable(true);
    if (x.SDK_INT >= 18) {}
    try
    {
      this.cIZ = AudioTrack.class.getMethod("getLatency", null);
      label51:
      if (x.SDK_INT >= 19) {}
      for (this.cIH = new b();; this.cIH = new a((byte)0))
      {
        this.cIB = new g();
        this.cIC = new l();
        this.cID = new d[paramArrayOfd.length + 3];
        this.cID[0] = new j();
        this.cID[1] = this.cIB;
        System.arraycopy(paramArrayOfd, 0, this.cID, 2, paramArrayOfd.length);
        this.cID[(paramArrayOfd.length + 2)] = this.cIC;
        this.cIG = new long[10];
        this.volume = 1.0F;
        this.cJh = 0;
        this.cHF = b.cIg;
        this.cHE = 0;
        this.cFP = p.cHj;
        this.cJq = -1;
        this.cJl = new d[0];
        this.cJm = new ByteBuffer[0];
        this.cII = new LinkedList();
        AppMethodBeat.o(91785);
        return;
      }
    }
    catch (NoSuchMethodException paramc)
    {
      break label51;
    }
  }
  
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91801);
    if (this.cIR == null)
    {
      this.cIR = ByteBuffer.allocate(16);
      this.cIR.order(ByteOrder.BIG_ENDIAN);
      this.cIR.putInt(1431633921);
    }
    if (this.cIS == 0)
    {
      this.cIR.putInt(4, paramInt);
      this.cIR.putLong(8, 1000L * paramLong);
      this.cIR.position(0);
      this.cIS = paramInt;
    }
    int i = this.cIR.remaining();
    if (i > 0)
    {
      int j = paramAudioTrack.write(this.cIR, i, 1);
      if (j < 0)
      {
        this.cIS = 0;
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
      this.cIS = 0;
      AppMethodBeat.o(91801);
      return paramInt;
    }
    this.cIS -= paramInt;
    AppMethodBeat.o(91801);
    return paramInt;
  }
  
  private long bY(long paramLong)
  {
    AppMethodBeat.i(91798);
    while ((!this.cII.isEmpty()) && (paramLong >= ((g)this.cII.getFirst()).cGD))
    {
      g localg = (g)this.cII.remove();
      this.cFP = localg.cFP;
      this.cIQ = localg.cGD;
      this.cIP = (localg.cJK - this.cJi);
    }
    if (this.cFP.cHk == 1.0F)
    {
      l1 = this.cIP;
      long l2 = this.cIQ;
      AppMethodBeat.o(91798);
      return l1 + paramLong - l2;
    }
    if ((this.cII.isEmpty()) && (this.cIC.cKy >= 1024L))
    {
      l1 = this.cIP;
      paramLong = x.c(paramLong - this.cIQ, this.cIC.cKx, this.cIC.cKy);
      AppMethodBeat.o(91798);
      return paramLong + l1;
    }
    long l1 = this.cIP;
    paramLong = (this.cFP.cHk * (paramLong - this.cIQ));
    AppMethodBeat.o(91798);
    return l1 + paramLong;
  }
  
  static int cH(String paramString)
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
  
  final void Rf()
  {
    AppMethodBeat.i(91788);
    Object localObject = new ArrayList();
    d[] arrayOfd = this.cID;
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
    this.cJl = ((d[])((ArrayList)localObject).toArray(new d[j]));
    this.cJm = new ByteBuffer[j];
    i = 0;
    while (i < j)
    {
      localObject = this.cJl[i];
      ((d)localObject).flush();
      this.cJm[i] = ((d)localObject).Re();
      i += 1;
    }
    AppMethodBeat.o(91788);
  }
  
  final boolean Rg()
  {
    AppMethodBeat.i(91792);
    int i;
    if (this.cJq == -1) {
      if (this.cIM)
      {
        i = this.cJl.length;
        this.cJq = i;
        i = 1;
      }
    }
    for (;;)
    {
      if (this.cJq < this.cJl.length)
      {
        d locald = this.cJl[this.cJq];
        if (i != 0) {
          locald.Rd();
        }
        bX(-9223372036854775807L);
        if (!locald.QU())
        {
          AppMethodBeat.o(91792);
          return false;
          i = 0;
          break;
        }
        this.cJq += 1;
        i = 1;
        continue;
      }
      if (this.outputBuffer != null)
      {
        b(this.outputBuffer, -9223372036854775807L);
        if (this.outputBuffer != null)
        {
          AppMethodBeat.o(91792);
          return false;
        }
      }
      this.cJq = -1;
      AppMethodBeat.o(91792);
      return true;
      i = 0;
    }
  }
  
  public final boolean Rh()
  {
    AppMethodBeat.i(91793);
    if (isInitialized())
    {
      if (Rl() <= this.cIH.Rp()) {
        if ((!Rn()) || (this.cIK.getPlayState() != 2) || (this.cIK.getPlaybackHeadPosition() != 0)) {
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
  
  final void Ri()
  {
    AppMethodBeat.i(91795);
    if (isInitialized())
    {
      if (x.SDK_INT >= 21)
      {
        this.cIK.setVolume(this.volume);
        AppMethodBeat.o(91795);
        return;
      }
      AudioTrack localAudioTrack = this.cIK;
      float f = this.volume;
      localAudioTrack.setStereoVolume(f, f);
    }
    AppMethodBeat.o(91795);
  }
  
  final void Rj()
  {
    AppMethodBeat.i(91797);
    if (this.cIJ == null)
    {
      AppMethodBeat.o(91797);
      return;
    }
    final AudioTrack localAudioTrack = this.cIJ;
    this.cIJ = null;
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
  
  final long Rk()
  {
    if (this.cIM) {
      return this.cJc;
    }
    return this.cJb / this.cJa;
  }
  
  final long Rl()
  {
    if (this.cIM) {
      return this.cJf;
    }
    return this.cJe / this.cJd;
  }
  
  final void Rm()
  {
    this.cIV = 0L;
    this.cIU = 0;
    this.cIT = 0;
    this.cIW = 0L;
    this.cIX = false;
    this.cIY = 0L;
  }
  
  final boolean Rn()
  {
    return (x.SDK_INT < 23) && ((this.cIL == 5) || (this.cIL == 6));
  }
  
  final AudioTrack Ro()
  {
    AppMethodBeat.i(91799);
    Object localObject;
    if (x.SDK_INT >= 21) {
      if (this.cJt) {
        localObject = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      }
    }
    for (;;)
    {
      AudioFormat localAudioFormat = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.cIL).setSampleRate(this.sampleRate).build();
      int i;
      if (this.cHE != 0)
      {
        i = this.cHE;
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
        localObject = this.cHF;
        if (((b)localObject).cIj == null) {
          ((b)localObject).cIj = new AudioAttributes.Builder().setContentType(((b)localObject).cIh).setFlags(((b)localObject).flags).setUsage(((b)localObject).cIi).build();
        }
        localObject = ((b)localObject).cIj;
        continue;
        i = 0;
        break label89;
        i = x.iP(this.cHF.cIi);
        if (this.cHE == 0)
        {
          localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.cIL, this.bufferSize, 1);
          break label105;
        }
        localObject = new AudioTrack(i, this.sampleRate, this.channelConfig, this.cIL, this.bufferSize, 1, this.cHE);
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
  
  public final p b(p paramp)
  {
    AppMethodBeat.i(91794);
    if (this.cIM)
    {
      this.cFP = p.cHj;
      paramp = this.cFP;
      AppMethodBeat.o(91794);
      return paramp;
    }
    Object localObject = this.cIC;
    ((l)localObject).cHk = x.l(paramp.cHk, 0.1F, 8.0F);
    float f1 = ((l)localObject).cHk;
    localObject = this.cIC;
    float f2 = paramp.pitch;
    ((l)localObject).pitch = x.l(f2, 0.1F, 8.0F);
    localObject = new p(f1, f2);
    if (this.cIO != null)
    {
      paramp = this.cIO;
      if (!((p)localObject).equals(paramp))
      {
        if (!isInitialized()) {
          break label182;
        }
        this.cIO = ((p)localObject);
      }
    }
    for (;;)
    {
      paramp = this.cFP;
      AppMethodBeat.o(91794);
      return paramp;
      if (!this.cII.isEmpty())
      {
        paramp = ((g)this.cII.getLast()).cFP;
        break;
      }
      paramp = this.cFP;
      break;
      label182:
      this.cFP = ((p)localObject);
    }
  }
  
  final boolean b(ByteBuffer paramByteBuffer, long paramLong)
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
        i = (int)(this.cJe - this.cIH.Rp() * this.cJd);
        i = this.bufferSize - i;
        if (i <= 0) {
          break label400;
        }
        i = Math.min(k, i);
        j = this.cIK.write(this.cJo, this.cJp, i);
        i = j;
        if (j > 0)
        {
          this.cJp += j;
          paramByteBuffer.position(paramByteBuffer.position() + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      this.cJv = SystemClock.elapsedRealtime();
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
        if ((this.cJo == null) || (this.cJo.length < i)) {
          this.cJo = new byte[i];
        }
        j = paramByteBuffer.position();
        paramByteBuffer.get(this.cJo, 0, i);
        paramByteBuffer.position(j);
        this.cJp = 0;
        break label44;
        label270:
        if (this.cJt)
        {
          if (paramLong != -9223372036854775807L) {}
          for (bool = true;; bool = false)
          {
            a.checkState(bool);
            i = a(this.cIK, paramByteBuffer, k, paramLong);
            break;
          }
        }
        i = this.cIK.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.cIM) {
        this.cJe += i;
      }
      if (i == k)
      {
        if (this.cIM) {
          this.cJf += this.cJg;
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
  
  final void bX(long paramLong)
  {
    AppMethodBeat.i(91790);
    int j = this.cJl.length;
    int i = j;
    while (i >= 0)
    {
      ByteBuffer localByteBuffer;
      if (i > 0)
      {
        localByteBuffer = this.cJm[(i - 1)];
        label34:
        if (i != j) {
          break label87;
        }
        b(localByteBuffer, paramLong);
      }
      for (;;)
      {
        if (localByteBuffer.hasRemaining())
        {
          AppMethodBeat.o(91790);
          return;
          if (this.cJn != null)
          {
            localByteBuffer = this.cJn;
            break label34;
          }
          localByteBuffer = d.cIl;
          break label34;
          label87:
          Object localObject = this.cJl[i];
          ((d)localObject).d(localByteBuffer);
          localObject = ((d)localObject).Re();
          this.cJm[i] = localObject;
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
  
  final long bZ(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  public final long by(boolean paramBoolean)
  {
    AppMethodBeat.i(91787);
    if ((isInitialized()) && (this.cJh != 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(91787);
      return -9223372036854775808L;
    }
    long l1;
    long l3;
    long l4;
    Object localObject;
    if (this.cIK.getPlayState() == 3)
    {
      l1 = this.cIH.Rq();
      if (l1 != 0L)
      {
        l2 = System.nanoTime() / 1000L;
        if (l2 - this.cIW >= 30000L)
        {
          this.cIG[this.cIT] = (l1 - l2);
          this.cIT = ((this.cIT + 1) % 10);
          if (this.cIU < 10) {
            this.cIU += 1;
          }
          this.cIW = l2;
          this.cIV = 0L;
          i = 0;
          while (i < this.cIU)
          {
            this.cIV += this.cIG[i] / this.cIU;
            i += 1;
          }
        }
        if ((!Rn()) && (l2 - this.cIY >= 500000L))
        {
          this.cIX = this.cIH.Rr();
          if (this.cIX)
          {
            l3 = this.cIH.Rs() / 1000L;
            l4 = this.cIH.Rt();
            if (l3 < this.cJj) {
              break label666;
            }
            if (Math.abs(l3 - l2) <= 5000000L) {
              break label544;
            }
            localObject = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + Rk() + ", " + Rl();
            if (cIz)
            {
              localObject = new e((String)localObject);
              AppMethodBeat.o(91787);
              throw ((Throwable)localObject);
            }
            this.cIX = false;
          }
        }
      }
    }
    for (;;)
    {
      if ((this.cIZ != null) && (!this.cIM)) {}
      try
      {
        this.cJk = (((Integer)this.cIZ.invoke(this.cIK, null)).intValue() * 1000L - this.cIN);
        this.cJk = Math.max(this.cJk, 0L);
        if (this.cJk > 5000000L)
        {
          new StringBuilder("Ignoring impossibly large audio latency: ").append(this.cJk);
          this.cJk = 0L;
        }
        this.cIY = l2;
        l1 = System.nanoTime() / 1000L;
        if (this.cIX)
        {
          l1 = bZ(ca(l1 - this.cIH.Rs() / 1000L) + this.cIH.Rt());
          l2 = this.cJi;
          l1 = bY(l1);
          AppMethodBeat.o(91787);
          return l1 + l2;
          label544:
          if (Math.abs(bZ(l4) - l1) <= 5000000L) {
            continue;
          }
          localObject = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1 + ", " + Rk() + ", " + Rl();
          if (cIz)
          {
            localObject = new e((String)localObject);
            AppMethodBeat.o(91787);
            throw ((Throwable)localObject);
          }
          label666:
          this.cIX = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.cIZ = null;
        }
      }
    }
    if (this.cIU == 0) {}
    for (long l2 = this.cIH.Rq();; l2 = l1 + this.cIV)
    {
      l1 = l2;
      if (paramBoolean) {
        break;
      }
      l1 = l2 - this.cJk;
      break;
    }
  }
  
  public final boolean cG(String paramString)
  {
    AppMethodBeat.i(91786);
    if (this.cIA != null)
    {
      c localc = this.cIA;
      int i = cH(paramString);
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
  
  final long ca(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  final boolean isInitialized()
  {
    return this.cIK != null;
  }
  
  public final void play()
  {
    AppMethodBeat.i(91789);
    this.cJs = true;
    if (isInitialized())
    {
      this.cJj = (System.nanoTime() / 1000L);
      this.cIK.play();
    }
    AppMethodBeat.o(91789);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91796);
    if (isInitialized())
    {
      this.cJb = 0L;
      this.cJc = 0L;
      this.cJe = 0L;
      this.cJf = 0L;
      this.cJg = 0;
      if (this.cIO != null)
      {
        this.cFP = this.cIO;
        this.cIO = null;
      }
      for (;;)
      {
        this.cII.clear();
        this.cIP = 0L;
        this.cIQ = 0L;
        this.cJn = null;
        this.outputBuffer = null;
        int i = 0;
        while (i < this.cJl.length)
        {
          localObject = this.cJl[i];
          ((d)localObject).flush();
          this.cJm[i] = ((d)localObject).Re();
          i += 1;
        }
        if (!this.cII.isEmpty()) {
          this.cFP = ((g)this.cII.getLast()).cFP;
        }
      }
      this.cJr = false;
      this.cJq = -1;
      this.cIR = null;
      this.cIS = 0;
      this.cJh = 0;
      this.cJk = 0L;
      Rm();
      if (this.cIK.getPlayState() == 3) {
        this.cIK.pause();
      }
      Object localObject = this.cIK;
      this.cIK = null;
      this.cIH.a(null, false);
      this.cIF.close();
      new Thread()
      {
        public final void run()
        {
          AppMethodBeat.i(91771);
          try
          {
            this.cJw.flush();
            this.cJw.release();
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
    protected AudioTrack cIK;
    private long cJA;
    private long cJB;
    private long cJC;
    private long cJD;
    private long cJE;
    private boolean cJy;
    private long cJz;
    private int sampleRate;
    
    public final long Rp()
    {
      AppMethodBeat.i(91776);
      if (this.cJC != -9223372036854775807L)
      {
        l1 = (SystemClock.elapsedRealtime() * 1000L - this.cJC) * this.sampleRate / 1000000L;
        l1 = Math.min(this.cJE, l1 + this.cJD);
        AppMethodBeat.o(91776);
        return l1;
      }
      int i = this.cIK.getPlayState();
      if (i == 1)
      {
        AppMethodBeat.o(91776);
        return 0L;
      }
      long l2 = 0xFFFFFFFF & this.cIK.getPlaybackHeadPosition();
      long l1 = l2;
      if (this.cJy)
      {
        if ((i == 2) && (l2 == 0L)) {
          this.cJB = this.cJz;
        }
        l1 = l2 + this.cJB;
      }
      if (this.cJz > l1) {
        this.cJA += 1L;
      }
      this.cJz = l1;
      l2 = this.cJA;
      AppMethodBeat.o(91776);
      return l1 + (l2 << 32);
    }
    
    public final long Rq()
    {
      AppMethodBeat.i(91777);
      long l = Rp() * 1000000L / this.sampleRate;
      AppMethodBeat.o(91777);
      return l;
    }
    
    public boolean Rr()
    {
      return false;
    }
    
    public long Rs()
    {
      AppMethodBeat.i(91778);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91778);
      throw localUnsupportedOperationException;
    }
    
    public long Rt()
    {
      AppMethodBeat.i(91779);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(91779);
      throw localUnsupportedOperationException;
    }
    
    public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91773);
      this.cIK = paramAudioTrack;
      this.cJy = paramBoolean;
      this.cJC = -9223372036854775807L;
      this.cJz = 0L;
      this.cJA = 0L;
      this.cJB = 0L;
      if (paramAudioTrack != null) {
        this.sampleRate = paramAudioTrack.getSampleRate();
      }
      AppMethodBeat.o(91773);
    }
    
    public final void cb(long paramLong)
    {
      AppMethodBeat.i(91774);
      this.cJD = Rp();
      this.cJC = (SystemClock.elapsedRealtime() * 1000L);
      this.cJE = paramLong;
      this.cIK.stop();
      AppMethodBeat.o(91774);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(91775);
      if (this.cJC != -9223372036854775807L)
      {
        AppMethodBeat.o(91775);
        return;
      }
      this.cIK.pause();
      AppMethodBeat.o(91775);
    }
  }
  
  static final class b
    extends f.a
  {
    private final AudioTimestamp cJF;
    private long cJG;
    private long cJH;
    private long cJI;
    
    public b()
    {
      super();
      AppMethodBeat.i(91780);
      this.cJF = new AudioTimestamp();
      AppMethodBeat.o(91780);
    }
    
    public final boolean Rr()
    {
      AppMethodBeat.i(91782);
      boolean bool = this.cIK.getTimestamp(this.cJF);
      if (bool)
      {
        long l = this.cJF.framePosition;
        if (this.cJH > l) {
          this.cJG += 1L;
        }
        this.cJH = l;
        this.cJI = (l + (this.cJG << 32));
      }
      AppMethodBeat.o(91782);
      return bool;
    }
    
    public final long Rs()
    {
      return this.cJF.nanoTime;
    }
    
    public final long Rt()
    {
      return this.cJI;
    }
    
    public final void a(AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      AppMethodBeat.i(91781);
      super.a(paramAudioTrack, paramBoolean);
      this.cJG = 0L;
      this.cJH = 0L;
      this.cJI = 0L;
      AppMethodBeat.o(91781);
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
    public abstract void e(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void hl(int paramInt);
    
    public abstract void onPositionDiscontinuity();
  }
  
  static final class g
  {
    final p cFP;
    final long cGD;
    final long cJK;
    
    private g(p paramp, long paramLong1, long paramLong2)
    {
      this.cFP = paramp;
      this.cJK = paramLong1;
      this.cGD = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f
 * JD-Core Version:    0.7.0.1
 */