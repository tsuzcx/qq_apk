package com.tencent.mm.plugin.appbrand.aa.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends g
  implements b
{
  private String mpQ = "*";
  
  public final void RC(String paramString)
  {
    AppMethodBeat.i(156664);
    if (paramString == null)
    {
      ac.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      AppMethodBeat.o(156664);
      return;
    }
    this.mpQ = paramString;
    AppMethodBeat.o(156664);
  }
  
  public final String bxI()
  {
    return this.mpQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.e.d
 * JD-Core Version:    0.7.0.1
 */