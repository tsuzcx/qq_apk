package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lo
  implements RequestProcessor, ResponseProcessor
{
  private final boolean a;
  
  public lo(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void onRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222489);
    if (this.a) {
      kh.c("TNT", "REQ[" + paramNetRequest.mRequestId + "][" + paramNetRequest.mNetMethod.name() + "]: " + paramNetRequest.toString());
    }
    AppMethodBeat.o(222489);
  }
  
  public final void onResponse(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222501);
    if (this.a) {
      kh.c("TNT", "RESP[" + paramNetResponse.mRequestId + "]: " + paramNetResponse.toHumanString());
    }
    AppMethodBeat.o(222501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lo
 * JD-Core Version:    0.7.0.1
 */