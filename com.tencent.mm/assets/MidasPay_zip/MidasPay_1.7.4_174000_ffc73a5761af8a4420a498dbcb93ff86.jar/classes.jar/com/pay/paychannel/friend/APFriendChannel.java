package com.pay.paychannel.friend;

import android.content.Context;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import midas.x.c.b;
import midas.x.dt;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;

public class APFriendChannel
  extends ff
{
  private c.b j = new c.b();
  
  public void b(Context paramContext, Bundle paramBundle) {}
  
  public void b(Context paramContext, dt paramdt)
  {
    int i = paramdt.T();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(i);
    APLog.i("APQDChannel", paramContext.toString());
    if (i != 0)
    {
      if (i != 1023) {
        return;
      }
      APUICommonMethod.b();
      fv.a(i, "订单失效");
      return;
    }
    a(null);
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    a(paramContext, paramfe, this.f);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.friend.APFriendChannel
 * JD-Core Version:    0.7.0.1
 */