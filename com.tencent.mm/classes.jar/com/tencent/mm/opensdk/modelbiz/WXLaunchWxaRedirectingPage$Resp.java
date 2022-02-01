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
    AppMethodBeat.i(190418);
    fromBundle(paramBundle);
    AppMethodBeat.o(190418);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190420);
    super.fromBundle(paramBundle);
    this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
    this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
    AppMethodBeat.o(190420);
  }
  
  public final int getType()
  {
    return 30;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190419);
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
    AppMethodBeat.o(190419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp
 * JD-Core Version:    0.7.0.1
 */