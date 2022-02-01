package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class WXLaunchWxaRedirectingPage$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
  public String callbackActivity;
  public String invokeTicket;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(190360);
    boolean bool = TextUtils.isEmpty(this.invokeTicket);
    AppMethodBeat.o(190360);
    return bool ^ true;
  }
  
  public final void fromArray(String[] paramArrayOfString)
  {
    this.invokeTicket = paramArrayOfString[0];
    this.callbackActivity = paramArrayOfString[1];
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190361);
    super.fromBundle(paramBundle);
    this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
    this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
    AppMethodBeat.o(190361);
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
    AppMethodBeat.i(190362);
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
    AppMethodBeat.o(190362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req
 * JD-Core Version:    0.7.0.1
 */