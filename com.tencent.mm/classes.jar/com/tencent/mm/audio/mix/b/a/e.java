package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.j;

public final class e
  extends j
{
  private f dur;
  
  public e(f paramf, String paramString)
  {
    super(paramString);
    this.dur = paramf;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136755);
    if (this.dur != null)
    {
      this.dur.YC();
      this.dur.end();
    }
    this.dur = null;
    i.b(this);
    AppMethodBeat.o(136755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.e
 * JD-Core Version:    0.7.0.1
 */