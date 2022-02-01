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
    bLD().nLC = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    return false;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(175272);
    super.bhj();
    e.ceh().pvD = true;
    AppMethodBeat.o(175272);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(175273);
    super.bhk();
    e.ceh().pvD = false;
    e.ceh().iW(false);
    AppMethodBeat.o(175273);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(175274);
    super.bhl();
    this.nME.ge(false);
    AppMethodBeat.o(175274);
  }
  
  public final boolean sy(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.nLK = e.ceh().nLK;
    boolean bool = super.sy(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */