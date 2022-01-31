package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class HandleScanResult$Req
  extends BaseReq
{
  private static final int MAX_URL_LENGHT = 10240;
  public String scanResult;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128236);
    if ((this.scanResult == null) || (this.scanResult.length() < 0))
    {
      AppMethodBeat.o(128236);
      return false;
    }
    if (this.scanResult.length() > 10240)
    {
      AppMethodBeat.o(128236);
      return false;
    }
    AppMethodBeat.o(128236);
    return true;
  }
  
  public int getType()
  {
    return 17;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128237);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
    AppMethodBeat.o(128237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.HandleScanResult.Req
 * JD-Core Version:    0.7.0.1
 */