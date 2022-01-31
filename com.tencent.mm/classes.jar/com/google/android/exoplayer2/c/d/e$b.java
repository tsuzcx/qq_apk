package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$b
{
  public final m aCe;
  public final l aHf;
  public j aHg;
  public c aHh;
  public int aHi;
  public int aHj;
  public int aHk;
  
  public e$b(m paramm)
  {
    AppMethodBeat.i(94961);
    this.aHf = new l();
    this.aCe = paramm;
    AppMethodBeat.o(94961);
  }
  
  public final void a(j paramj, c paramc)
  {
    AppMethodBeat.i(94962);
    this.aHg = ((j)a.checkNotNull(paramj));
    this.aHh = ((c)a.checkNotNull(paramc));
    this.aCe.f(paramj.axd);
    reset();
    AppMethodBeat.o(94962);
  }
  
  public final void b(DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(94964);
    Object localObject = this.aHg.dz(this.aHf.aIe.aGB);
    if (localObject != null) {}
    for (localObject = ((k)localObject).aIb;; localObject = null)
    {
      this.aCe.f(this.aHg.axd.a(paramDrmInitData.ap((String)localObject)));
      AppMethodBeat.o(94964);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94963);
    this.aHf.reset();
    this.aHi = 0;
    this.aHk = 0;
    this.aHj = 0;
    AppMethodBeat.o(94963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e.b
 * JD-Core Version:    0.7.0.1
 */