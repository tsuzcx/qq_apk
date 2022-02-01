package com.pay.paychannel.goldcouponsdeduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;
import midas.x.dl;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;
import midas.x.is;

public class APGoldCouponsDeductChannel
  extends ew
{
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (is.c.size() > 0) {
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
  
  public void b(Context paramContext, dl paramdl)
  {
    int i = paramdl.R();
    if (i != 0)
    {
      if (i != 1023)
      {
        a(i, paramdl.S(), false);
        return;
      }
      APUICommonMethod.b();
      fm.a(i, "订单失效");
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
 * Qualified Name:     com.pay.paychannel.goldcouponsdeduct.APGoldCouponsDeductChannel
 * JD-Core Version:    0.7.0.1
 */