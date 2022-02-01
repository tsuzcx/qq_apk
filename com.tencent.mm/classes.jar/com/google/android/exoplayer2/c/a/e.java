package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  private boolean aXS;
  private final com.google.android.exoplayer2.i.m aYj;
  private final com.google.android.exoplayer2.i.m aYk;
  private int aYl;
  private int frameType;
  
  public e(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
    AppMethodBeat.i(91993);
    this.aYj = new com.google.android.exoplayer2.i.m(k.bwo);
    this.aYk = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(91993);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(91995);
    int i = paramm.readUnsignedByte();
    long l = paramm.vA();
    Object localObject;
    if ((i == 0) && (!this.aXS))
    {
      localObject = new com.google.android.exoplayer2.i.m(new byte[paramm.vy()]);
      paramm.readBytes(((com.google.android.exoplayer2.i.m)localObject).data, 0, paramm.vy());
      paramm = a.K((com.google.android.exoplayer2.i.m)localObject);
      this.aYl = paramm.aYl;
      paramm = Format.a(null, "video/avc", paramm.width, paramm.height, paramm.aTa, paramm.bwG);
      this.aYi.f(paramm);
      this.aXS = true;
      AppMethodBeat.o(91995);
      return;
    }
    if ((i == 1) && (this.aXS))
    {
      localObject = this.aYk.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      j = this.aYl;
      int k;
      for (i = 0; paramm.vy() > 0; i = i + 4 + k)
      {
        paramm.readBytes(this.aYk.data, 4 - j, this.aYl);
        this.aYk.setPosition(0);
        k = this.aYk.vF();
        this.aYj.setPosition(0);
        this.aYi.a(this.aYj, 4);
        this.aYi.a(paramm, k);
      }
      paramm = this.aYi;
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