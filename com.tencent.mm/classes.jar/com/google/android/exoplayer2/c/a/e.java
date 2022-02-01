package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  private boolean aRO;
  private final com.google.android.exoplayer2.i.m aSf;
  private final com.google.android.exoplayer2.i.m aSg;
  private int aSh;
  private int frameType;
  
  public e(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
    AppMethodBeat.i(91993);
    this.aSf = new com.google.android.exoplayer2.i.m(k.bqC);
    this.aSg = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(91993);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(91995);
    int i = paramm.readUnsignedByte();
    long l = paramm.vj();
    Object localObject;
    if ((i == 0) && (!this.aRO))
    {
      localObject = new com.google.android.exoplayer2.i.m(new byte[paramm.vg()]);
      paramm.readBytes(((com.google.android.exoplayer2.i.m)localObject).data, 0, paramm.vg());
      paramm = a.K((com.google.android.exoplayer2.i.m)localObject);
      this.aSh = paramm.aSh;
      paramm = Format.a(null, "video/avc", paramm.width, paramm.height, paramm.aMS, paramm.bqU);
      this.aSe.f(paramm);
      this.aRO = true;
      AppMethodBeat.o(91995);
      return;
    }
    if ((i == 1) && (this.aRO))
    {
      localObject = this.aSg.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      j = this.aSh;
      int k;
      for (i = 0; paramm.vg() > 0; i = i + 4 + k)
      {
        paramm.readBytes(this.aSg.data, 4 - j, this.aSh);
        this.aSg.setPosition(0);
        k = this.aSg.vo();
        this.aSf.setPosition(0);
        this.aSe.a(this.aSf, 4);
        this.aSe.a(paramm, k);
      }
      paramm = this.aSe;
      if (this.frameType != 1) {
        break label294;
      }
    }
    label294:
    for (int j = 1;; j = 0)
    {
      paramm.a(l * 1000L + paramLong, j, i, 0, null);
      AppMethodBeat.o(91995);
      return;
    }
  }
  
  protected final boolean a(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(91994);
    int j = paramm.readUnsignedByte();
    int i = j >> 4 & 0xF;
    j &= 0xF;
    if (j != 7)
    {
      paramm = new d.a("Video format not supported: ".concat(String.valueOf(j)));
      AppMethodBeat.o(91994);
      throw paramm;
    }
    this.frameType = i;
    if (i != 5)
    {
      AppMethodBeat.o(91994);
      return true;
    }
    AppMethodBeat.o(91994);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.e
 * JD-Core Version:    0.7.0.1
 */