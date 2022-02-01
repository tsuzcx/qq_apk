package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class b$4
  implements com.tencent.magicbrush.handler.b
{
  b$4(b paramb) {}
  
  public final String a(final String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(188747);
    if (this.mwl.El() == null)
    {
      AppMethodBeat.o(188747);
      return "";
    }
    try
    {
      paramString1 = ((c)this.mwl.El()).b(paramString1, paramString2, paramInt, paramBoolean);
      AppMethodBeat.o(188747);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramString1, "IMBInvokeHandler.invoke", new Object[0]);
      aq.f(new Runnable()
      {
        public final void run()
        {
          throw paramString1;
        }
      });
      AppMethodBeat.o(188747);
    }
    return "";
  }
  
  public final String[] getAsyncableJsApis()
  {
    AppMethodBeat.i(188748);
    if (this.mwl.El() == null)
    {
      AppMethodBeat.o(188748);
      return null;
    }
    String[] arrayOfString = ((c)this.mwl.El()).getAsyncableJsApis();
    AppMethodBeat.o(188748);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b.4
 * JD-Core Version:    0.7.0.1
 */