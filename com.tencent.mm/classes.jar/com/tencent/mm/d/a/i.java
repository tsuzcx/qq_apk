package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends a
{
  private MultiContextNodeJS cbq;
  public volatile l cbr;
  
  static
  {
    AppMethodBeat.i(113821);
    MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new i.1());
    AppMethodBeat.o(113821);
  }
  
  private i() {}
  
  private i(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  static i j(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113817);
    paramString = new i(paramString, paramArrayOfByte);
    AppMethodBeat.o(113817);
    return paramString;
  }
  
  final MultiContextV8 Ch()
  {
    AppMethodBeat.i(113818);
    this.cbq = MultiContextNodeJS.createMultiContextNodeJS(1, this.cbg, this.cbh);
    this.cbh = null;
    MultiContextV8 localMultiContextV8 = this.cbq.getRuntime();
    AppMethodBeat.o(113818);
    return localMultiContextV8;
  }
  
  final d Ci()
  {
    AppMethodBeat.i(113819);
    j localj = j.a(new i.2(this));
    AppMethodBeat.o(113819);
    return localj;
  }
  
  final void Cj()
  {
    AppMethodBeat.i(113820);
    ab.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.cbq.release();
      ab.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(113820);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(113820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.i
 * JD-Core Version:    0.7.0.1
 */