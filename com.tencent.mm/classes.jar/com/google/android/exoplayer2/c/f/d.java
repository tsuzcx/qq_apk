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
  private static final byte[] aKb = { 73, 68, 51 };
  long aAT;
  private boolean aBO;
  private com.google.android.exoplayer2.c.m aCe;
  private int aJW;
  private long aJY;
  private final boolean aKc;
  private final l aKd;
  private final com.google.android.exoplayer2.i.m aKe;
  private String aKf;
  private com.google.android.exoplayer2.c.m aKg;
  private int aKh;
  private boolean aKi;
  private com.google.android.exoplayer2.c.m aKj;
  private long aKk;
  private final String axa;
  private int sampleSize;
  private int state;
  
  public d()
  {
    this(true, null);
  }
  
  public d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(95088);
    this.aKd = new l(new byte[7]);
    this.aKe = new com.google.android.exoplayer2.i.m(Arrays.copyOf(aKb, 10));
    oo();
    this.aKc = paramBoolean;
    this.axa = paramString;
    AppMethodBeat.o(95088);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.aJW = paramInt1;
    this.aKj = paramm;
    this.aKk = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95092);
    int i = Math.min(paramm.qM(), paramInt - this.aJW);
    paramm.readBytes(paramArrayOfByte, this.aJW, i);
    this.aJW = (i + this.aJW);
    if (this.aJW == paramInt)
    {
      AppMethodBeat.o(95092);
      return true;
    }
    AppMethodBeat.o(95092);
    return false;
  }
  
  private void op()
  {
    AppMethodBeat.i(95093);
    this.state = 1;
    this.aJW = aKb.length;
    this.sampleSize = 0;
    this.aKe.setPosition(0);
    AppMethodBeat.o(95093);
  }
  
  private void oq()
  {
    this.state = 2;
    this.aJW = 0;
  }
  
  private void or()
  {
    AppMethodBeat.i(95095);
    this.aKg.a(this.aKe, 10);
    this.aKe.setPosition(6);
    a(this.aKg, 0L, 10, this.aKe.qS() + 10);
    AppMethodBeat.o(95095);
  }
  
  private void os()
  {
    int i = 2;
    AppMethodBeat.i(95096);
    this.aKd.setPosition(0);
    int j;
    if (!this.aBO)
    {
      j = this.aKd.dD(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.aKd.dD(4);
      this.aKd.dE(1);
      Object localObject = com.google.android.exoplayer2.i.d.s(i, j, this.aKd.dD(3));
      Pair localPair = com.google.android.exoplayer2.i.d.p((byte[])localObject);
      localObject = Format.a(this.aKf, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.axa);
      this.aJY = (1024000000L / ((Format)localObject).sampleRate);
      this.aCe.f((Format)localObject);
      this.aBO = true;
      for (;;)
      {
        this.aKd.dE(4);
        j = this.aKd.dD(13) - 2 - 5;
        i = j;
        if (this.aKi) {
          i = j - 2;
        }
        a(this.aCe, this.aJY, 0, i);
        AppMethodBeat.o(95096);
        return;
        this.aKd.dE(10);
      }
      label232:
      i = j;
    }
  }
  
  private void v(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95094);
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
        if ((this.aKh == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.aKi = bool;
            oq();
            paramm.setPosition(j);
            AppMethodBeat.o(95094);
            return;
          }
        }
        switch (i | this.aKh)
        {
        default: 
          if (this.aKh == 256) {
            break label234;
          }
          this.aKh = 256;
          i = j - 1;
          break;
        case 511: 
          this.aKh = 512;
          i = j;
          break;
        case 329: 
          this.aKh = 768;
          i = j;
          break;
        case 836: 
          this.aKh = 1024;
          i = j;
          break;
        case 1075: 
          op();
          paramm.setPosition(j);
          AppMethodBeat.o(95094);
          return;
        }
      }
      else
      {
        paramm.setPosition(i);
        AppMethodBeat.o(95094);
        return;
        label234:
        i = j;
      }
    }
  }
  
  private void w(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95097);
    int i = Math.min(paramm.qM(), this.sampleSize - this.aJW);
    this.aKj.a(paramm, i);
    this.aJW = (i + this.aJW);
    if (this.aJW == this.sampleSize)
    {
      this.aKj.a(this.aAT, 1, this.sampleSize, 0, null);
      this.aAT += this.aKk;
      oo();
    }
    AppMethodBeat.o(95097);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95090);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    if (this.aKc)
    {
      paramd.ox();
      this.aKg = paramg.dm(paramd.oy());
      this.aKg.f(Format.k(paramd.oz(), "application/id3"));
      AppMethodBeat.o(95090);
      return;
    }
    this.aKg = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(95090);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aAT = paramLong;
  }
  
  public final void ol()
  {
    AppMethodBeat.i(156874);
    oo();
    AppMethodBeat.o(156874);
  }
  
  public final void om() {}
  
  final void oo()
  {
    this.state = 0;
    this.aJW = 0;
    this.aKh = 256;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95091);
    while (paramm.qM() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.aKe.data, 10)) {
          or();
        }
        break;
      case 2: 
        if (this.aKi) {}
        for (int i = 7; a(paramm, this.aKd.data, i); i = 5)
        {
          os();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(95091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */