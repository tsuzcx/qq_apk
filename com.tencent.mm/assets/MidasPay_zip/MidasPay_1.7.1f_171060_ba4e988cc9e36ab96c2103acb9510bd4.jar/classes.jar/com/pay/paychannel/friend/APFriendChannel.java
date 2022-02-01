package com.pay.paychannel.friend;

import android.content.Context;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import midas.x.c.b;
import midas.x.dl;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;

public class APFriendChannel
  extends ew
{
  private c.b i = new c.b();
  
  public void b(Context paramContext, Bundle paramBundle) {}
  
  public void b(Context paramContext, dl paramdl)
  {
    int j = paramdl.R();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(j);
    APLog.i("APQDChannel", paramContext.toString());
    if (j != 0)
    {
      if (j != 1023) {
        return;
      }
      APUICommonMethod.b();
      fm.a(j, "订单失效");
      return;
    }
    a(null);
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    a(paramContext, paramev, this.f);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.friend.APFriendChannel
 * JD-Core Version:    0.7.0.1
 */