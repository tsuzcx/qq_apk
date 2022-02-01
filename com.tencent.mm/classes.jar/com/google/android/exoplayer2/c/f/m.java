package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private final String aTm;
  private int aUr;
  private boolean aXS;
  private com.google.android.exoplayer2.c.m aYi;
  private String bgl;
  private final com.google.android.exoplayer2.i.m bhC;
  private final j bhD;
  private int bhE;
  private boolean bhF;
  private long frameDurationUs;
  private int state;
  private long timeUs;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(92259);
    this.state = 0;
    this.bhC = new com.google.android.exoplayer2.i.m(4);
    this.bhC.data[0] = -1;
    this.bhD = new j();
    this.aTm = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.ts();
    this.bgl = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    AppMethodBeat.o(92260);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.vy() > 0)
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
            if ((!this.bhF) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.bhF = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.bhF = false;
            this.bhC.data[1] = localObject[i];
            this.bhE = 2;
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
        i = Math.min(paramm.vy(), 4 - this.bhE);
        paramm.readBytes(this.bhC.data, this.bhE, i);
        this.bhE = (i + this.bhE);
        if (this.bhE >= 4)
        {
          this.bhC.setPosition(0);
          if (!j.a(this.bhC.readInt(), this.bhD))
          {
            this.bhE = 0;
            this.state = 1;
          }
          else
          {
            this.aUr = this.bhD.aUr;
            if (!this.aXS)
            {
              this.frameDurationUs = (1000000L * this.bhD.aXN / this.bhD.sampleRate);
              localObject = Format.a(this.bgl, this.bhD.mimeType, -1, 4096, this.bhD.channels, this.bhD.sampleRate, null, null, this.aTm);
              this.aYi.f((Format)localObject);
              this.aXS = true;
            }
            this.bhC.setPosition(0);
            this.aYi.a(this.bhC, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.vy(), this.aUr - this.bhE);
        label164:
        label169:
        label176:
        this.aYi.a(paramm, i);
        this.bhE = (i + this.bhE);
        if (this.bhE >= this.aUr)
        {
          this.aYi.a(this.timeUs, 1, this.aUr, 0, null);
          this.timeUs += this.frameDurationUs;
          this.bhE = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
  
  public final void tg()
  {
    this.state = 0;
    this.bhE = 0;
    this.bhF = false;
  }
  
  public final void th() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */