package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.util.HashMap;

public class WXOpenBusinessWebview
{
  public static class Req
    extends BaseReq
  {
    public int businessType;
    public HashMap<String, String> queryInfo;
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3918);
      super.fromBundle(paramBundle);
      this.queryInfo = ((HashMap)paramBundle.getSerializable("_wxapi_open_business_webview_query_info"));
      this.businessType = paramBundle.getInt("_wxapi_open_business_webview_query_type", 0);
      AppMethodBeat.o(3918);
    }
    
    public int getType()
    {
      return 25;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3919);
      super.toBundle(paramBundle);
      paramBundle.putSerializable("_wxapi_open_business_webview_query_info", this.queryInfo);
      paramBundle.putInt("_wxapi_open_business_webview_query_type", this.businessType);
      AppMethodBeat.o(3919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview
 * JD-Core Version:    0.7.0.1
 */