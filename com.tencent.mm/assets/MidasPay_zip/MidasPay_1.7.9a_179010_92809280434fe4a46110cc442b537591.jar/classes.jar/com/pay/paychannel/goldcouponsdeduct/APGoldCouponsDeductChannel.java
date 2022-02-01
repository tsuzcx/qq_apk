package com.pay.paychannel.goldcouponsdeduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.ob;
import midas.x.w3;
import midas.x.z5;

public class APGoldCouponsDeductChannel
  extends i5
{
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (j9.b.size() > 0) {
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
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    a(paramContext, paramh5, this.e);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    if (i != 0)
    {
      if (i != 1023)
      {
        a(i, paramw3.f(), false);
        return;
      }
      APUICommonMethod.f();
      z5.a(i, "订单失效");
      return;
    }
    a(null);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    a(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.goldcouponsdeduct.APGoldCouponsDeductChannel
 * JD-Core Version:    0.7.0.1
 */