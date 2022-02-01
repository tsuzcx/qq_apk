package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class HandleScanResult
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String scanResult;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3934);
      if ((this.scanResult == null) || (this.scanResult.length() < 0))
      {
        AppMethodBeat.o(3934);
        return false;
      }
      if (this.scanResult.length() > 10240)
      {
        AppMethodBeat.o(3934);
        return false;
      }
      AppMethodBeat.o(3934);
      return true;
    }
    
    public int getType()
    {
      return 17;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3935);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
      AppMethodBeat.o(3935);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3931);
      fromBundle(paramBundle);
      AppMethodBeat.o(3931);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3932);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(3932);
    }
    
    public int getType()
    {
      return 17;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3933);
      super.toBundle(paramBundle);
      AppMethodBeat.o(3933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.HandleScanResult
 * JD-Core Version:    0.7.0.1
 */