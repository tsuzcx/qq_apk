package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

public final class d
  implements h
{
  private static final byte[] bqw = { 73, 68, 51 };
  private com.google.android.exoplayer2.c.m biA;
  private boolean bik;
  private String bqA;
  private com.google.android.exoplayer2.c.m bqB;
  private int bqC;
  private boolean bqD;
  private com.google.android.exoplayer2.c.m bqE;
  private long bqF;
  private int bqr;
  private long bqt;
  private final boolean bqx;
  private final l bqy;
  private final com.google.android.exoplayer2.i.m bqz;
  private final String language;
  private int sampleSize;
  private int state;
  long timeUs;
  
  public d()
  {
    this(true, null);
  }
  
  public d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(92210);
    this.bqy = new l(new byte[7]);
    this.bqz = new com.google.android.exoplayer2.i.m(Arrays.copyOf(bqw, 10));
    uN();
    this.bqx = paramBoolean;
    this.language = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.bqr = paramInt1;
    this.bqE = paramm;
    this.bqF = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.xd(), paramInt - this.bqr);
    paramm.readBytes(paramArrayOfByte, this.bqr, i);
    this.bqr = (i + this.bqr);
    if (this.bqr == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void uO()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.bqr = bqw.length;
    this.sampleSize = 0;
    this.bqz.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void uP()
  {
    this.state = 2;
    this.bqr = 0;
  }
  
  private void uQ()
  {
    AppMethodBeat.i(92217);
    this.bqB.a(this.bqz, 10);
    this.bqz.setPosition(6);
    a(this.bqB, 0L, 10, this.bqz.xj() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void uR()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.bqy.setPosition(0);
    int j;
    if (!this.bik)
    {
      j = this.bqy.em(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.bqy.em(4);
      this.bqy.en(1);
      Object localObject = com.google.android.exoplayer2.i.d.r(i, j, this.bqy.em(3));
      Pair localPair = com.google.android.exoplayer2.i.d.u((byte[])localObject);
      localObject = Format.a(this.bqA, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.language);
      this.bqt = (1024000000L / ((Format)localObject).sampleRate);
      this.biA.f((Format)localObject);
      this.bik = true;
      for (;;)
      {
        this.bqy.en(4);
        j = this.bqy.em(13) - 2 - 5;
        i = j;
        if (this.bqD) {
          i = j - 2;
        }
        a(this.biA, this.bqt, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.bqy.en(10);
      }
      label232:
      i = j;
    }
  }
  
  private void v(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92216);
    byte[] arrayOfByte = paramm.data;
    int i = paramm.position;
    int k = paramm.limit;
    for (;;)
    {
      int j;
      if (i < k)
      {
        j = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if ((this.bqC == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.bqD = bool;
            uP();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.bqC)
        {
        default: 
          if (this.bqC == 256) {
            break label234;
          }
          this.bqC = 256;
          i = j - 1;
          break;
        case 511: 
          this.bqC = 512;
          i = j;
          break;
        case 329: 
          this.bqC = 768;
          i = j;
          break;
        case 836: 
          this.bqC = 1024;
          i = j;
          break;
        case 1075: 
          uO();
          paramm.setPosition(j);
          AppMethodBeat.o(92216);
          return;
        }
      }
      else
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92216);
        return;
        label234:
        i = j;
      }
    }
  }
  
  private void w(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92219);
    int i = Math.min(paramm.xd(), this.sampleSize - this.bqr);
    this.bqE.a(paramm, i);
    this.bqr = (i + this.bqr);
    if (this.bqr == this.sampleSize)
    {
      this.bqE.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.bqF;
      uN();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.uW();
    this.bqA = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    if (this.bqx)
    {
      paramd.uW();
      this.bqB = paramg.dV(paramd.getTrackId());
      this.bqB.f(Format.k(paramd.uX(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.bqB = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.xd() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.bqz.data, 10)) {
          uQ();
        }
        break;
      case 2: 
        if (this.bqD) {}
        for (int i = 7; a(paramm, this.bqy.data, i); i = 5)
        {
          uR();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
  
  public final void uK()
  {
    AppMethodBeat.i(258460);
    uN();
    AppMethodBeat.o(258460);
  }
  
  public final void uL() {}
  
  final void uN()
  {
    this.state = 0;
    this.bqr = 0;
    this.bqC = 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */