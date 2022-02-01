package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.i;

public final class e
  extends i
{
  private f cTH;
  
  public e(f paramf, String paramString)
  {
    super(paramString);
    this.cTH = paramf;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136755);
    if (this.cTH != null)
    {
      this.cTH.MQ();
      this.cTH.end();
    }
    this.cTH = null;
    h.b(this);
    AppMethodBeat.o(136755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.e
 * JD-Core Version:    0.7.0.1
 */