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
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.Z(paramInt, paramString);
    bzz().mDz = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aVY()
  {
    return false;
  }
  
  public final void aVZ()
  {
    AppMethodBeat.i(175272);
    super.aVZ();
    e.bQZ().ohP = true;
    AppMethodBeat.o(175272);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(175273);
    super.aWa();
    e.bQZ().ohP = false;
    e.bQZ().io(false);
    AppMethodBeat.o(175273);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(175274);
    super.aWb();
    this.mEA.fF(false);
    AppMethodBeat.o(175274);
  }
  
  public final boolean rg(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.mDH = e.bQZ().mDH;
    boolean bool = super.rg(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */