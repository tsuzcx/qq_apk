package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class d$1
  implements d.a
{
  d$1(String paramString) {}
  
  public final void bcu()
  {
    AppMethodBeat.i(206501);
    Log.i(this.lrg, "[audioHelperTool] gain");
    AppMethodBeat.o(206501);
  }
  
  public final void bcv()
  {
    AppMethodBeat.i(206503);
    Log.i(this.lrg, "[audioHelperTool] loss");
    AppMethodBeat.o(206503);
  }
  
  public final void bcw()
  {
    AppMethodBeat.i(206505);
    Log.i(this.lrg, "[audioHelperTool] lossTransient");
    AppMethodBeat.o(206505);
  }
  
  public final void bcx()
  {
    AppMethodBeat.i(206506);
    Log.i(this.lrg, "[audioHelperTool] lossTransientCanDuck");
    AppMethodBeat.o(206506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.1
 * JD-Core Version:    0.7.0.1
 */