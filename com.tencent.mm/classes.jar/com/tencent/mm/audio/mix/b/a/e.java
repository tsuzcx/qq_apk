package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.decode.i;
import com.tencent.mm.audio.mix.decode.j;

public final class e
  extends j
{
  private f hrk;
  
  public e(f paramf, String paramString)
  {
    super(paramString);
    this.hrk = paramf;
  }
  
  public final void run()
  {
    AppMethodBeat.i(136755);
    if (this.hrk != null)
    {
      this.hrk.aFi();
      this.hrk.end();
    }
    this.hrk = null;
    i.b(this);
    AppMethodBeat.o(136755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a.e
 * JD-Core Version:    0.7.0.1
 */