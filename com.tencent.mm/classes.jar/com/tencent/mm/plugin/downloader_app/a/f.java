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
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.aa(paramInt, paramString);
    bGv().nfG = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public final boolean bcW()
  {
    return false;
  }
  
  public final void bcX()
  {
    AppMethodBeat.i(175272);
    super.bcX();
    e.bYo().oLp = true;
    AppMethodBeat.o(175272);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(175273);
    super.bcY();
    e.bYo().oLp = false;
    e.bYo().iO(false);
    AppMethodBeat.o(175273);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(175274);
    super.bcZ();
    this.ngF.gb(false);
    AppMethodBeat.o(175274);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.nfN = e.bYo().nfN;
    boolean bool = super.rT(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */