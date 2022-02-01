package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXOpenCustomerServiceChat
{
  public static final class Req
    extends BaseReq
  {
    public String corpId;
    public String url;
    
    public Req()
    {
      AppMethodBeat.i(243066);
      this.corpId = "";
      this.url = "";
      AppMethodBeat.o(243066);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final int getType()
    {
      return 37;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243072);
      super.toBundle(paramBundle);
      paramBundle.putString("_open_customer_service_chat_corpId", this.corpId);
      paramBundle.putString("_open_customer_service_chat_url", this.url);
      AppMethodBeat.o(243072);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243052);
      fromBundle(paramBundle);
      AppMethodBeat.o(243052);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243054);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(243054);
    }
    
    public final int getType()
    {
      return 37;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243057);
      super.toBundle(paramBundle);
      AppMethodBeat.o(243057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat
 * JD-Core Version:    0.7.0.1
 */