package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements h
{
  private final String aSt;
  private int aTz;
  private boolean aXg;
  private com.google.android.exoplayer2.c.m aXw;
  private String bfE;
  private final com.google.android.exoplayer2.i.m bgW;
  private final j bgX;
  private int bgY;
  private boolean bgZ;
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
    this.bgW = new com.google.android.exoplayer2.i.m(4);
    this.bgW.data[0] = -1;
    this.bgX = new j();
    this.aSt = paramString;
    AppMethodBeat.o(92259);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92260);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 1);
    AppMethodBeat.o(92260);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sX()
  {
    this.state = 0;
    this.bgY = 0;
    this.bgZ = false;
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92261);
    while (paramm.vJ() > 0)
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
            if ((!this.bgZ) || ((localObject[i] & 0xE0) != 224)) {
              break label164;
            }
          }
          for (int j = 1;; j = 0)
          {
            this.bgZ = bool;
            if (j == 0) {
              break label169;
            }
            paramm.setPosition(i + 1);
            this.bgZ = false;
            this.bgW.data[1] = localObject[i];
            this.bgY = 2;
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
        i = Math.min(paramm.vJ(), 4 - this.bgY);
        paramm.readBytes(this.bgW.data, this.bgY, i);
        this.bgY = (i + this.bgY);
        if (this.bgY >= 4)
        {
          this.bgW.setPosition(0);
          if (!j.a(this.bgW.readInt(), this.bgX))
          {
            this.bgY = 0;
            this.state = 1;
          }
          else
          {
            this.aTz = this.bgX.aTz;
            if (!this.aXg)
            {
              this.frameDurationUs = (1000000L * this.bgX.aXb / this.bgX.sampleRate);
              localObject = Format.a(this.bfE, this.bgX.mimeType, -1, 4096, this.bgX.channels, this.bgX.sampleRate, null, null, this.aSt);
              this.aXw.f((Format)localObject);
              this.aXg = true;
            }
            this.bgW.setPosition(0);
            this.aXw.a(this.bgW, 4);
            this.state = 2;
          }
        }
        break;
      case 2: 
        label87:
        i = Math.min(paramm.vJ(), this.aTz - this.bgY);
        label164:
        label169:
        label176:
        this.aXw.a(paramm, i);
        this.bgY = (i + this.bgY);
        if (this.bgY >= this.aTz)
        {
          this.aXw.a(this.timeUs, 1, this.aTz, 0, null);
          this.timeUs += this.frameDurationUs;
          this.bgY = 0;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.m
 * JD-Core Version:    0.7.0.1
 */