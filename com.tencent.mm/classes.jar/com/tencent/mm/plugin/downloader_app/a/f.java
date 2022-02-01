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
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(175270);
    super.J(paramInt, paramString);
    cYv().mUU = 11;
    AppMethodBeat.o(175270);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(175274);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(175274);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(175273);
    super.bhW();
    e.duU().xss = false;
    e.duU().ms(false);
    AppMethodBeat.o(175273);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(175272);
    super.coi();
    e.duU().xss = true;
    AppMethodBeat.o(175272);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(175271);
    this.vjV = e.duU().vjV;
    boolean bool = super.zX(paramInt);
    AppMethodBeat.o(175271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.f
 * JD-Core Version:    0.7.0.1
 */