package com.tencent.mm.plugin.appbrand.ab.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends g
  implements b
{
  private String lNQ = "*";
  
  public final void Nt(String paramString)
  {
    AppMethodBeat.i(156664);
    if (paramString == null)
    {
      ad.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      AppMethodBeat.o(156664);
      return;
    }
    this.lNQ = paramString;
    AppMethodBeat.o(156664);
  }
  
  public final String bqI()
  {
    return this.lNQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.e.d
 * JD-Core Version:    0.7.0.1
 */