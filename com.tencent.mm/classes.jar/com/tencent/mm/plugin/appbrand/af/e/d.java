package com.tencent.mm.plugin.appbrand.af.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends g
  implements b
{
  private String rkT = "*";
  
  public final void ant(String paramString)
  {
    AppMethodBeat.i(156664);
    if (paramString == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      AppMethodBeat.o(156664);
      return;
    }
    this.rkT = paramString;
    AppMethodBeat.o(156664);
  }
  
  public final String cmG()
  {
    return this.rkT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.e.d
 * JD-Core Version:    0.7.0.1
 */