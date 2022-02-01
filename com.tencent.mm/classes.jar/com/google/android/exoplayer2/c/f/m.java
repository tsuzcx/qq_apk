package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private int aOj;
  private boolean aRO;
  private com.google.android.exoplayer2.c.m aSe;
  private String bac;
  private final com.google.android.exoplayer2.i.m bbt;
  private final j bbu;
  private int bbv;
  private boolean bbw;
  private long frameDurationUs;
  private final String language;
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
    this.bbt = new com.google.android.exoplayer2.i.m(4);
    this.bbt.data[0] = -1;
    this.bbu = new j();
    this.language = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.sR();
    this.bac = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    AppMethodBeat.o(92260);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sF()
  {
    this.state = 0;
    this.bbv = 0;
    this.bbw = false;
  }
  
  public final void sG() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.vg() > 0)
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
            if ((!this.bbw) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.bbw = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.bbw = false;
            this.bbt.data[1] = localObject[i];
            this.bbv = 2;
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
        i = Math.min(paramm.vg(), 4 - this.bbv);
        paramm.readBytes(this.bbt.data, this.bbv, i);
        this.bbv = (i + this.bbv);
        if (this.bbv >= 4)
        {
          this.bbt.setPosition(0);
          if (!j.a(this.bbt.readInt(), this.bbu))
          {
            this.bbv = 0;
            this.state = 1;
          }
          else
          {
            this.aOj = this.bbu.aOj;
            if (!this.aRO)
            {
              this.frameDurationUs = (1000000L * this.bbu.aRJ / this.bbu.sampleRate);
              localObject = Format.a(this.bac, this.bbu.mimeType, -1, 4096, this.bbu.channels, this.bbu.sampleRate, null, null, this.language);
              this.aSe.f((Format)localObject);
              this.aRO = true;
            }
            this.bbt.setPosition(0);
            this.aSe.a(this.bbt, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.vg(), this.aOj - this.bbv);
        label164:
        label169:
        label176:
        this.aSe.a(paramm, i);
        this.bbv = (i + this.bbv);
        if (this.bbv >= this.aOj)
        {
          this.aSe.a(this.timeUs, 1, this.aOj, 0, null);
          this.timeUs += this.frameDurationUs;
          this.bbv = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */