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
  private static final byte[] bgh = { 73, 68, 51 };
  private final String aTm;
  private boolean aXS;
  private com.google.android.exoplayer2.c.m aYi;
  private int bgc;
  private long bge;
  private final boolean bgi;
  private final l bgj;
  private final com.google.android.exoplayer2.i.m bgk;
  private String bgl;
  private com.google.android.exoplayer2.c.m bgm;
  private int bgn;
  private boolean bgo;
  private com.google.android.exoplayer2.c.m bgp;
  private long bgq;
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
    this.bgj = new l(new byte[7]);
    this.bgk = new com.google.android.exoplayer2.i.m(Arrays.copyOf(bgh, 10));
    tj();
    this.bgi = paramBoolean;
    this.aTm = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.bgc = paramInt1;
    this.bgp = paramm;
    this.bgq = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.vy(), paramInt - this.bgc);
    paramm.readBytes(paramArrayOfByte, this.bgc, i);
    this.bgc = (i + this.bgc);
    if (this.bgc == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void tk()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.bgc = bgh.length;
    this.sampleSize = 0;
    this.bgk.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void tl()
  {
    this.state = 2;
    this.bgc = 0;
  }
  
  private void tm()
  {
    AppMethodBeat.i(92217);
    this.bgm.a(this.bgk, 10);
    this.bgk.setPosition(6);
    a(this.bgm, 0L, 10, this.bgk.vE() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void tn()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.bgj.setPosition(0);
    int j;
    if (!this.aXS)
    {
      j = this.bgj.eo(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.bgj.eo(4);
      this.bgj.ep(1);
      Object localObject = com.google.android.exoplayer2.i.d.u(i, j, this.bgj.eo(3));
      Pair localPair = com.google.android.exoplayer2.i.d.u((byte[])localObject);
      localObject = Format.a(this.bgl, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.aTm);
      this.bge = (1024000000L / ((Format)localObject).sampleRate);
      this.aYi.f((Format)localObject);
      this.aXS = true;
      for (;;)
      {
        this.bgj.ep(4);
        j = this.bgj.eo(13) - 2 - 5;
        i = j;
        if (this.bgo) {
          i = j - 2;
        }
        a(this.aYi, this.bge, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.bgj.ep(10);
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
        if ((this.bgn == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.bgo = bool;
            tl();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.bgn)
        {
        default: 
          if (this.bgn == 256) {
            break label234;
          }
          this.bgn = 256;
          i = j - 1;
          break;
        case 511: 
          this.bgn = 512;
          i = j;
          break;
        case 329: 
          this.bgn = 768;
          i = j;
          break;
        case 836: 
          this.bgn = 1024;
          i = j;
          break;
        case 1075: 
          tk();
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
    int i = Math.min(paramm.vy(), this.sampleSize - this.bgc);
    this.bgp.a(paramm, i);
    this.bgc = (i + this.bgc);
    if (this.bgc == this.sampleSize)
    {
      this.bgp.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.bgq;
      tj();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.ts();
    this.bgl = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    if (this.bgi)
    {
      paramd.ts();
      this.bgm = paramg.dW(paramd.getTrackId());
      this.bgm.f(Format.k(paramd.tt(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.bgm = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.vy() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.bgk.data, 10)) {
          tm();
        }
        break;
      case 2: 
        if (this.bgo) {}
        for (int i = 7; a(paramm, this.bgj.data, i); i = 5)
        {
          tn();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
  
  public final void tg()
  {
    AppMethodBeat.i(210390);
    tj();
    AppMethodBeat.o(210390);
  }
  
  public final void th() {}
  
  final void tj()
  {
    this.state = 0;
    this.bgc = 0;
    this.bgn = 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */