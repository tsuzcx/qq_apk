package com.tencent.mm.plugin.appbrand.z.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends g
  implements b
{
  private String mVF = "*";
  
  public final void VS(String paramString)
  {
    AppMethodBeat.i(156664);
    if (paramString == null)
    {
      ae.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      AppMethodBeat.o(156664);
      return;
    }
    this.mVF = paramString;
    AppMethodBeat.o(156664);
  }
  
  public final String bCH()
  {
    return this.mVF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.e.d
 * JD-Core Version:    0.7.0.1
 */