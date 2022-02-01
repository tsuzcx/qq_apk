package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXLaunchWxaRedirectingPage$Resp
  extends BaseResp
{
  private static final String TAG = "MicroMsg.SDK.WXLaunchWxaFRedirectingPage.Resp";
  public String callbackActivity;
  public String invokeTicket;
  
  public WXLaunchWxaRedirectingPage$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(196991);
    fromBundle(paramBundle);
    AppMethodBeat.o(196991);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(196993);
    super.fromBundle(paramBundle);
    this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
    this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
    AppMethodBeat.o(196993);
  }
  
  public final int getType()
  {
    return 30;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(196992);
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
    AppMethodBeat.o(196992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp
 * JD-Core Version:    0.7.0.1
 */