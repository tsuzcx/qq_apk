package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.i;

public final class e
  extends i
{
  private f ceI;
  
  public e(f paramf, String paramString)
  {
    super(paramString);
    this.ceI = paramf;
  }
  
  public final void run()
  {
    AppMethodBeat.i(137007);
    if (this.ceI != null)
    {
      this.ceI.Dh();
      this.ceI.end();
    }
    this.ceI = null;
    h.b(this);
    AppMethodBeat.o(137007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.e
 * JD-Core Version:    0.7.0.1
 */