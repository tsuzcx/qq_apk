package com.google.android.exoplayer2.c.g;

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
  private static final byte[] bfA = { 73, 68, 51 };
  private final String aSt;
  private boolean aXg;
  private com.google.android.exoplayer2.c.m aXw;
  private final boolean bfB;
  private final l bfC;
  private final com.google.android.exoplayer2.i.m bfD;
  private String bfE;
  private com.google.android.exoplayer2.c.m bfF;
  private int bfG;
  private boolean bfH;
  private com.google.android.exoplayer2.c.m bfI;
  private long bfJ;
  private int bfv;
  private long bfx;
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
    this.bfC = new l(new byte[7]);
    this.bfD = new com.google.android.exoplayer2.i.m(Arrays.copyOf(bfA, 10));
    ta();
    this.bfB = paramBoolean;
    this.aSt = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.bfv = paramInt1;
    this.bfI = paramm;
    this.bfJ = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.vJ(), paramInt - this.bfv);
    paramm.readBytes(paramArrayOfByte, this.bfv, i);
    this.bfv = (i + this.bfv);
    if (this.bfv == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void tb()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.bfv = bfA.length;
    this.sampleSize = 0;
    this.bfD.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void tc()
  {
    this.state = 2;
    this.bfv = 0;
  }
  
  private void td()
  {
    AppMethodBeat.i(92217);
    this.bfF.a(this.bfD, 10);
    this.bfD.setPosition(6);
    a(this.bfF, 0L, 10, this.bfD.vP() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void te()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.bfC.setPosition(0);
    int j;
    if (!this.aXg)
    {
      j = this.bfC.eo(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.bfC.eo(4);
      this.bfC.ep(1);
      Object localObject = com.google.android.exoplayer2.i.d.u(i, j, this.bfC.eo(3));
      Pair localPair = com.google.android.exoplayer2.i.d.v((byte[])localObject);
      localObject = Format.a(this.bfE, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.aSt);
      this.bfx = (1024000000L / ((Format)localObject).sampleRate);
      this.aXw.f((Format)localObject);
      this.aXg = true;
      for (;;)
      {
        this.bfC.ep(4);
        j = this.bfC.eo(13) - 2 - 5;
        i = j;
        if (this.bfH) {
          i = j - 2;
        }
        a(this.aXw, this.bfx, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.bfC.ep(10);
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
        if ((this.bfG == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.bfH = bool;
            tc();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.bfG)
        {
        default: 
          if (this.bfG == 256) {
            break label234;
          }
          this.bfG = 256;
          i = j - 1;
          break;
        case 511: 
          this.bfG = 512;
          i = j;
          break;
        case 329: 
          this.bfG = 768;
          i = j;
          break;
        case 836: 
          this.bfG = 1024;
          i = j;
          break;
        case 1075: 
          tb();
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
    int i = Math.min(paramm.vJ(), this.sampleSize - this.bfv);
    this.bfI.a(paramm, i);
    this.bfv = (i + this.bfv);
    if (this.bfv == this.sampleSize)
    {
      this.bfI.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.bfJ;
      ta();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 1);
    if (this.bfB)
    {
      paramd.tj();
      this.bfF = paramg.bh(paramd.getTrackId(), 4);
      this.bfF.f(Format.j(paramd.tl(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.bfF = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sX()
  {
    AppMethodBeat.i(205007);
    ta();
    AppMethodBeat.o(205007);
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.vJ() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.bfD.data, 10)) {
          td();
        }
        break;
      case 2: 
        if (this.bfH) {}
        for (int i = 7; a(paramm, this.bfC.data, i); i = 5)
        {
          te();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
  
  final void ta()
  {
    this.state = 0;
    this.bfv = 0;
    this.bfG = 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.d
 * JD-Core Version:    0.7.0.1
 */