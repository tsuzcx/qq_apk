package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  private boolean aXg;
  private final com.google.android.exoplayer2.i.m aXx;
  private final com.google.android.exoplayer2.i.m aXy;
  private int aXz;
  private int frameType;
  
  public e(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
    AppMethodBeat.i(91993);
    this.aXx = new com.google.android.exoplayer2.i.m(k.byG);
    this.aXy = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(91993);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(91995);
    int i = paramm.readUnsignedByte();
    long l = paramm.vL();
    Object localObject;
    if ((i == 0) && (!this.aXg))
    {
      localObject = new com.google.android.exoplayer2.i.m(new byte[paramm.vJ()]);
      paramm.readBytes(((com.google.android.exoplayer2.i.m)localObject).data, 0, paramm.vJ());
      paramm = a.K((com.google.android.exoplayer2.i.m)localObject);
      this.aXz = paramm.aXz;
      paramm = Format.a(null, "video/avc", paramm.width, paramm.height, paramm.aSf, paramm.byY);
      this.aXw.f(paramm);
      this.aXg = true;
      AppMethodBeat.o(91995);
      return;
    }
    if ((i == 1) && (this.aXg))
    {
      localObject = this.aXy.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      j = this.aXz;
      int k;
      for (i = 0; paramm.vJ() > 0; i = i + 4 + k)
      {
        paramm.readBytes(this.aXy.data, 4 - j, this.aXz);
        this.aXy.setPosition(0);
        k = this.aXy.vQ();
        this.aXx.setPosition(0);
        this.aXw.a(this.aXx, 4);
        this.aXw.a(paramm, k);
      }
      paramm = this.aXw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.e
 * JD-Core Version:    0.7.0.1
 */