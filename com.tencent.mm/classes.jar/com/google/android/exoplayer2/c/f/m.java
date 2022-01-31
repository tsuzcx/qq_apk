package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private long aAT;
  private boolean aBO;
  private com.google.android.exoplayer2.c.m aCe;
  private String aKf;
  private long aKt;
  private boolean aLA;
  private final com.google.android.exoplayer2.i.m aLx;
  private final j aLy;
  private int aLz;
  private final String axa;
  private int ayg;
  private int state;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(95137);
    this.state = 0;
    this.aLx = new com.google.android.exoplayer2.i.m(4);
    this.aLx.data[0] = -1;
    this.aLy = new j();
    this.axa = paramString;
    AppMethodBeat.o(95137);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95138);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    AppMethodBeat.o(95138);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aAT = paramLong;
  }
  
  public final void ol()
  {
    this.state = 0;
    this.aLz = 0;
    this.aLA = false;
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95139);
    while (paramm.qM() > 0)
    {
      Object localObject;
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        localObject = paramm.data;
        i = paramm.position;
        int k = paramm.limit;
        for (;;)
        {
          if (i >= k) {
            break label176;
          }
          boolean bool;
          if ((localObject[i] & 0xFF) == 255)
          {
            bool = true;
            if ((!this.aLA) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.aLA = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.aLA = false;
            this.aLx.data[1] = localObject[i];
            this.aLz = 2;
            this.state = 1;
            break;
            bool = false;
            break label87;
          }
          i += 1;
        }
        paramm.setPosition(k);
        break;
      case 1: 
        i = Math.min(paramm.qM(), 4 - this.aLz);
        paramm.readBytes(this.aLx.data, this.aLz, i);
        this.aLz = (i + this.aLz);
        if (this.aLz >= 4)
        {
          this.aLx.setPosition(0);
          if (!j.a(this.aLx.readInt(), this.aLy))
          {
            this.aLz = 0;
            this.state = 1;
          }
          else
          {
            this.ayg = this.aLy.ayg;
            if (!this.aBO)
            {
              this.aKt = (1000000L * this.aLy.aBJ / this.aLy.sampleRate);
              localObject = Format.a(this.aKf, this.aLy.mimeType, -1, 4096, this.aLy.channels, this.aLy.sampleRate, null, null, this.axa);
              this.aCe.f((Format)localObject);
              this.aBO = true;
            }
            this.aLx.setPosition(0);
            this.aCe.a(this.aLx, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.qM(), this.ayg - this.aLz);
        label164:
        label169:
        label176:
        this.aCe.a(paramm, i);
        this.aLz = (i + this.aLz);
        if (this.aLz >= this.ayg)
        {
          this.aCe.a(this.aAT, 1, this.ayg, 0, null);
          this.aAT += this.aKt;
          this.aLz = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(95139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */