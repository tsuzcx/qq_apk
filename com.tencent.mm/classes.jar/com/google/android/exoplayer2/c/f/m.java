package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private int cIf;
  private boolean cLK;
  private com.google.android.exoplayer2.c.m cMa;
  private String cTX;
  private final com.google.android.exoplayer2.i.m cVo;
  private final j cVp;
  private int cVq;
  private boolean cVr;
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
    this.cVo = new com.google.android.exoplayer2.i.m(4);
    this.cVo.data[0] = -1;
    this.cVp = new j();
    this.language = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void Si()
  {
    this.state = 0;
    this.cVq = 0;
    this.cVr = false;
  }
  
  public final void Sj() {}
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.Sv();
    this.cTX = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    AppMethodBeat.o(92260);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.UF() > 0)
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
            if ((!this.cVr) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.cVr = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.cVr = false;
            this.cVo.data[1] = localObject[i];
            this.cVq = 2;
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
        i = Math.min(paramm.UF(), 4 - this.cVq);
        paramm.readBytes(this.cVo.data, this.cVq, i);
        this.cVq = (i + this.cVq);
        if (this.cVq >= 4)
        {
          this.cVo.setPosition(0);
          if (!j.a(this.cVo.readInt(), this.cVp))
          {
            this.cVq = 0;
            this.state = 1;
          }
          else
          {
            this.cIf = this.cVp.cIf;
            if (!this.cLK)
            {
              this.frameDurationUs = (1000000L * this.cVp.cLF / this.cVp.sampleRate);
              localObject = Format.a(this.cTX, this.cVp.mimeType, -1, 4096, this.cVp.channels, this.cVp.sampleRate, null, null, this.language);
              this.cMa.f((Format)localObject);
              this.cLK = true;
            }
            this.cVo.setPosition(0);
            this.cMa.a(this.cVo, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.UF(), this.cIf - this.cVq);
        label164:
        label169:
        label176:
        this.cMa.a(paramm, i);
        this.cVq = (i + this.cVq);
        if (this.cVq >= this.cIf)
        {
          this.cMa.a(this.timeUs, 1, this.cIf, 0, null);
          this.timeUs += this.frameDurationUs;
          this.cVq = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */