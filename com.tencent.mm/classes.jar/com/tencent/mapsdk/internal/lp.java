package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.FileUploadResetException;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lp
  extends ll
  implements RequestProcessor
{
  public final void onRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222443);
    paramNetRequest.setRespHeaders(new String[] { "User-ReturnCode" });
    AppMethodBeat.o(222443);
  }
  
  public final void onResponse(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222450);
    String str = paramNetResponse.getHeaderField("User-ReturnCode");
    int i = Integer.parseInt(str);
    if (i != 0)
    {
      if (i == -2) {
        paramNetResponse.exception(new FileUploadResetException());
      }
      paramNetResponse.exception(new Exception("FileUploader user error:".concat(String.valueOf(str))));
    }
    AppMethodBeat.o(222450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lp
 * JD-Core Version:    0.7.0.1
 */