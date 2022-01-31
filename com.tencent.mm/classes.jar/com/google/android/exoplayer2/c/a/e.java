package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  private boolean aBO;
  private final com.google.android.exoplayer2.i.m aCf;
  private final com.google.android.exoplayer2.i.m aCg;
  private int aCh;
  private int frameType;
  
  public e(com.google.android.exoplayer2.c.m paramm)
  {
    super(paramm);
    AppMethodBeat.i(94878);
    this.aCf = new com.google.android.exoplayer2.i.m(k.baF);
    this.aCg = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(94878);
  }
  
  protected final void a(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    AppMethodBeat.i(94880);
    int i = paramm.readUnsignedByte();
    long l = paramm.qO();
    Object localObject;
    if ((i == 0) && (!this.aBO))
    {
      localObject = new com.google.android.exoplayer2.i.m(new byte[paramm.qM()]);
      paramm.readBytes(((com.google.android.exoplayer2.i.m)localObject).data, 0, paramm.qM());
      paramm = a.K((com.google.android.exoplayer2.i.m)localObject);
      this.aCh = paramm.aCh;
      paramm = Format.a(null, "video/avc", paramm.width, paramm.height, paramm.awM, paramm.baX);
      this.aCe.f(paramm);
      this.aBO = true;
      AppMethodBeat.o(94880);
      return;
    }
    if ((i == 1) && (this.aBO))
    {
      localObject = this.aCg.data;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      j = this.aCh;
      int k;
      for (i = 0; paramm.qM() > 0; i = i + 4 + k)
      {
        paramm.readBytes(this.aCg.data, 4 - j, this.aCh);
        this.aCg.setPosition(0);
        k = this.aCg.qT();
        this.aCf.setPosition(0);
        this.aCe.a(this.aCf, 4);
        this.aCe.a(paramm, k);
      }
      paramm = this.aCe;
      if (this.frameType != 1) {
        break label294;
      }
    }
    label294:
    for (int j = 1;; j = 0)
    {
      paramm.a(l * 1000L + paramLong, j, i, 0, null);
      AppMethodBeat.o(94880);
      return;
    }
  }
  
  protected final boolean a(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(94879);
    int j = paramm.readUnsignedByte();
    int i = j >> 4 & 0xF;
    j &= 0xF;
    if (j != 7)
    {
      paramm = new d.a("Video format not supported: ".concat(String.valueOf(j)));
      AppMethodBeat.o(94879);
      throw paramm;
    }
    this.frameType = i;
    if (i != 5)
    {
      AppMethodBeat.o(94879);
      return true;
    }
    AppMethodBeat.o(94879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.e
 * JD-Core Version:    0.7.0.1
 */