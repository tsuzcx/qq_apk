package com.tencent.mm.plugin.appbrand.t.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "", "fetchCaIssuers", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "url", "", "timeoutMills", "", "maxRespBytes", "Companion", "IRequest", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final a tpJ = a.tpK;
  
  public abstract b aej(String paramString);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$Companion;", "", "()V", "DEFAULT_MAX_RESPONSE_SIZE_IN_BYTES_FOR_AIA", "", "DEFAULT_READ_BUFFER_SIZE_IN_BYTES", "DEFAULT_TIMEOUT_MILLS", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(319224);
      tpK = new a();
      AppMethodBeat.o(319224);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "", "waitForResult", "", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract byte[] cCO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.b.c
 * JD-Core Version:    0.7.0.1
 */