package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class d$1
  implements d.a
{
  d$1(String paramString) {}
  
  public final void bAi()
  {
    AppMethodBeat.i(241944);
    Log.i(this.oiH, "[audioHelperTool] gain");
    AppMethodBeat.o(241944);
  }
  
  public final void bAj()
  {
    AppMethodBeat.i(241947);
    Log.i(this.oiH, "[audioHelperTool] loss");
    AppMethodBeat.o(241947);
  }
  
  public final void bAk()
  {
    AppMethodBeat.i(241949);
    Log.i(this.oiH, "[audioHelperTool] lossTransient");
    AppMethodBeat.o(241949);
  }
  
  public final void bAl()
  {
    AppMethodBeat.i(241950);
    Log.i(this.oiH, "[audioHelperTool] lossTransientCanDuck");
    AppMethodBeat.o(241950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.1
 * JD-Core Version:    0.7.0.1
 */