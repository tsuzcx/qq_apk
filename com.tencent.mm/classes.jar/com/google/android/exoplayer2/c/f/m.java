package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private int beI;
  private com.google.android.exoplayer2.c.m biA;
  private boolean bik;
  private String bqA;
  private final com.google.android.exoplayer2.i.m brR;
  private final j brS;
  private int brT;
  private boolean brU;
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
    this.brR = new com.google.android.exoplayer2.i.m(4);
    this.brR.data[0] = -1;
    this.brS = new j();
    this.language = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.uW();
    this.bqA = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    AppMethodBeat.o(92260);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.xd() > 0)
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
            if ((!this.brU) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.brU = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.brU = false;
            this.brR.data[1] = localObject[i];
            this.brT = 2;
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
        i = Math.min(paramm.xd(), 4 - this.brT);
        paramm.readBytes(this.brR.data, this.brT, i);
        this.brT = (i + this.brT);
        if (this.brT >= 4)
        {
          this.brR.setPosition(0);
          if (!j.a(this.brR.readInt(), this.brS))
          {
            this.brT = 0;
            this.state = 1;
          }
          else
          {
            this.beI = this.brS.beI;
            if (!this.bik)
            {
              this.frameDurationUs = (1000000L * this.brS.bif / this.brS.sampleRate);
              localObject = Format.a(this.bqA, this.brS.mimeType, -1, 4096, this.brS.channels, this.brS.sampleRate, null, null, this.language);
              this.biA.f((Format)localObject);
              this.bik = true;
            }
            this.brR.setPosition(0);
            this.biA.a(this.brR, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.xd(), this.beI - this.brT);
        label164:
        label169:
        label176:
        this.biA.a(paramm, i);
        this.brT = (i + this.brT);
        if (this.brT >= this.beI)
        {
          this.biA.a(this.timeUs, 1, this.beI, 0, null);
          this.timeUs += this.frameDurationUs;
          this.brT = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
  
  public final void uK()
  {
    this.state = 0;
    this.brT = 0;
    this.brU = false;
  }
  
  public final void uL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */