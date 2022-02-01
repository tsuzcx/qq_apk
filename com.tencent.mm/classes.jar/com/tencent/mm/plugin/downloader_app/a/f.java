package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.service.a;

public final class f
  extends com.tencent.mm.plugin.ball.service.f
{
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.G(paramInt, paramString);
    ciw().hDa = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    return false;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(175274);
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(175274);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(175273);
    super.aGj();
    e.cBX().qKU = false;
    e.cBX().jU(false);
    AppMethodBeat.o(175273);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(175272);
    super.bCA();
    e.cBX().qKU = true;
    AppMethodBeat.o(175272);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.oWE = e.cBX().oWE;
    boolean bool = super.wu(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */