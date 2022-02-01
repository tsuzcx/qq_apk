package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private int beL;
  private com.google.android.exoplayer2.c.m biD;
  private boolean bin;
  private String bqF;
  private final com.google.android.exoplayer2.i.m brW;
  private final j brX;
  private int brY;
  private boolean brZ;
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
    this.brW = new com.google.android.exoplayer2.i.m(4);
    this.brW.data[0] = -1;
    this.brX = new j();
    this.language = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.uR();
    this.bqF = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    AppMethodBeat.o(92260);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.wV() > 0)
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
            if ((!this.brZ) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.brZ = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.brZ = false;
            this.brW.data[1] = localObject[i];
            this.brY = 2;
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
        i = Math.min(paramm.wV(), 4 - this.brY);
        paramm.readBytes(this.brW.data, this.brY, i);
        this.brY = (i + this.brY);
        if (this.brY >= 4)
        {
          this.brW.setPosition(0);
          if (!j.a(this.brW.readInt(), this.brX))
          {
            this.brY = 0;
            this.state = 1;
          }
          else
          {
            this.beL = this.brX.beL;
            if (!this.bin)
            {
              this.frameDurationUs = (1000000L * this.brX.bii / this.brX.sampleRate);
              localObject = Format.a(this.bqF, this.brX.mimeType, -1, 4096, this.brX.channels, this.brX.sampleRate, null, null, this.language);
              this.biD.f((Format)localObject);
              this.bin = true;
            }
            this.brW.setPosition(0);
            this.biD.a(this.brW, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.wV(), this.beL - this.brY);
        label164:
        label169:
        label176:
        this.biD.a(paramm, i);
        this.brY = (i + this.brY);
        if (this.brY >= this.beL)
        {
          this.biD.a(this.timeUs, 1, this.beL, 0, null);
          this.timeUs += this.frameDurationUs;
          this.brY = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
  
  public final void uF()
  {
    this.state = 0;
    this.brY = 0;
    this.brZ = false;
  }
  
  public final void uG() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.m
 * JD-Core Version:    0.7.0.1
 */