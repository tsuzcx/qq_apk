package com.pay.paychannel.goldcouponsdeduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;
import midas.x.dt;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;
import midas.x.jd;

public class APGoldCouponsDeductChannel
  extends ff
{
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (jd.c.size() > 0) {
      try
      {
        ((APRecoChannelActivity)paramContext).a(1, 2, paramBundle);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localIntent = new Intent(paramContext, APRecoChannelActivity.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        paramContext.startActivity(localIntent);
        return;
      }
    }
    Intent localIntent = new Intent(paramContext, APRecoChannelActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void b(Context paramContext, dt paramdt)
  {
    int i = paramdt.T();
    if (i != 0)
    {
      if (i != 1023)
      {
        a(i, paramdt.U(), false);
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
 * Qualified Name:     com.pay.paychannel.goldcouponsdeduct.APGoldCouponsDeductChannel
 * JD-Core Version:    0.7.0.1
 */