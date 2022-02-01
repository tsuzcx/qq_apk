package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  private boolean cLK;
  private final com.google.android.exoplayer2.i.m cMb;
  private final com.google.android.exoplayer2.i.m cMc;
  private int cMd;
  private int frameType;
  
  public e(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
    AppMethodBeat.i(91993);
    this.cMb = new com.google.android.exoplayer2.i.m(k.dkg);
    this.cMc = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(91993);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(91995);
    int i = paramm.readUnsignedByte();
    long l = paramm.UI();
    Object localObject;
    if ((i == 0) && (!this.cLK))
    {
      localObject = new com.google.android.exoplayer2.i.m(new byte[paramm.UF()]);
      paramm.readBytes(((com.google.android.exoplayer2.i.m)localObject).data, 0, paramm.UF());
      paramm = a.K((com.google.android.exoplayer2.i.m)localObject);
      this.cMd = paramm.cMd;
      paramm = Format.a(null, "video/avc", paramm.width, paramm.height, paramm.cGP, paramm.dky);
      this.cMa.f(paramm);
      this.cLK = true;
      AppMethodBeat.o(91995);
      return;
    }
    if ((i == 1) && (this.cLK))
    {
      localObject = this.cMc.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      j = this.cMd;
      int k;
      for (i = 0; paramm.UF() > 0; i = i + 4 + k)
      {
        paramm.readBytes(this.cMc.data, 4 - j, this.cMd);
        this.cMc.setPosition(0);
        k = this.cMc.UN();
        this.cMb.setPosition(0);
        this.cMa.a(this.cMb, 4);
        this.cMa.a(paramm, k);
      }
      paramm = this.cMa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.e
 * JD-Core Version:    0.7.0.1
 */