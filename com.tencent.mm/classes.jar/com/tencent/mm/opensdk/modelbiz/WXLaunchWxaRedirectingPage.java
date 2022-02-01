package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXLaunchWxaRedirectingPage
{
  public static final String URI_PATH = "launchWxaOpenApiRedirectingPage";
  
  static abstract interface ConstantsWxaRedirectingPage
  {
    public static final String KEY_CALLBACK_ACTIVITY = "_launch_wx_wxa_redirecting_page_callback_activity";
    public static final String KEY_CALLBACK_MSG = "_launch_wx_wxa_redirecting_page_callback_msg";
    public static final String KEY_INVOKE_TICKET = "_launch_wx_wxa_redirecting_page_invoke_ticket";
  }
  
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
    public String callbackActivity;
    public String invokeTicket;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(243082);
      boolean bool = TextUtils.isEmpty(this.invokeTicket);
      AppMethodBeat.o(243082);
      return bool ^ true;
    }
    
    public final void fromArray(String[] paramArrayOfString)
    {
      this.invokeTicket = paramArrayOfString[0];
      this.callbackActivity = paramArrayOfString[1];
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243085);
      super.fromBundle(paramBundle);
      this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
      this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
      AppMethodBeat.o(243085);
    }
    
    public final int getType()
    {
      return 30;
    }
    
    public final String[] toArray()
    {
      return new String[] { this.invokeTicket, this.callbackActivity };
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243087);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
      paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
      AppMethodBeat.o(243087);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
    public String callbackActivity;
    public String invokeTicket;
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243029);
      fromBundle(paramBundle);
      AppMethodBeat.o(243029);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243036);
      super.fromBundle(paramBundle);
      this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
      this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
      AppMethodBeat.o(243036);
    }
    
    public final int getType()
    {
      return 30;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243033);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
      paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
      AppMethodBeat.o(243033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage
 * JD-Core Version:    0.7.0.1
 */