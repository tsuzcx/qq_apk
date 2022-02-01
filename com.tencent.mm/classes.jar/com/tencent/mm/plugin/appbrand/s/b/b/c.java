package com.tencent.mm.plugin.appbrand.s.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "", "fetchCaIssuers", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "url", "", "timeoutMills", "", "maxRespBytes", "Companion", "IRequest", "luggage-commons_release"})
public abstract interface c
{
  public static final a qkM = a.qkN;
  
  public abstract b alc(String paramString);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$Companion;", "", "()V", "DEFAULT_MAX_RESPONSE_SIZE_IN_BYTES_FOR_AIA", "", "DEFAULT_READ_BUFFER_SIZE_IN_BYTES", "DEFAULT_TIMEOUT_MILLS", "luggage-commons_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(208368);
      qkN = new a();
      AppMethodBeat.o(208368);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "", "waitForResult", "", "luggage-commons_release"})
  public static abstract interface b
  {
    public abstract byte[] ccs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.b.c
 * JD-Core Version:    0.7.0.1
 */