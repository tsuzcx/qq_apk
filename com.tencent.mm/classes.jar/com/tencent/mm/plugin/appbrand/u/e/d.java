package com.tencent.mm.plugin.appbrand.u.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends g
  implements b
{
  private String iZa = "*";
  
  public final void Fw(String paramString)
  {
    AppMethodBeat.i(73266);
    if (paramString == null)
    {
      ab.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      AppMethodBeat.o(73266);
      return;
    }
    this.iZa = paramString;
    AppMethodBeat.o(73266);
  }
  
  public final String aOp()
  {
    return this.iZa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.e.d
 * JD-Core Version:    0.7.0.1
 */