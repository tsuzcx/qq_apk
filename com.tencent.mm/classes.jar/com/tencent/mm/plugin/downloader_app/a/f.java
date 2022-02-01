package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;

public final class f
  extends com.tencent.mm.plugin.ball.service.e
{
  public f(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.I(paramInt, paramString);
    cvL().kqZ = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    return false;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(175274);
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(175274);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(175273);
    super.aOj();
    e.cQB().umg = false;
    e.cQB().lf(false);
    AppMethodBeat.o(175273);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(175272);
    super.bNV();
    e.cQB().umg = true;
    AppMethodBeat.o(175272);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.rYE = e.cQB().rYE;
    boolean bool = super.zH(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */