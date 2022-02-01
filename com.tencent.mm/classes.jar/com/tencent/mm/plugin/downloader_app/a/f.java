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
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.ac(paramInt, paramString);
    bKG().nGc = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(175272);
    super.bgB();
    e.ccS().poX = true;
    AppMethodBeat.o(175272);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(175273);
    super.bgC();
    e.ccS().poX = false;
    e.ccS().iX(false);
    AppMethodBeat.o(175273);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(175274);
    super.bgD();
    this.nHb.gg(false);
    AppMethodBeat.o(175274);
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final boolean sv(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.nGj = e.ccS().nGj;
    boolean bool = super.sv(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */