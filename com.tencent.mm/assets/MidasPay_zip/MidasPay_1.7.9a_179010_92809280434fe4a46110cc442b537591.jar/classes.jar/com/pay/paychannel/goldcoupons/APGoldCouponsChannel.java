package com.pay.paychannel.goldcoupons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.c7;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.w3;
import midas.x.z5;

public class APGoldCouponsChannel
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
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramh5, this.e);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(i);
    APLog.i("APQDChannel", paramContext.toString());
    if (i != 0)
    {
      if (i != 1004)
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
      c(this.d);
      return;
    }
    a(null);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void c(final String paramString)
  {
    final int i = p4.p().e().b.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, paramString, null);
    APAlertDialog.f localf = new APAlertDialog.f(this.c);
    localf.b("提示");
    localf.a("您的金券余额不足");
    localf.b("", new a(i, paramString));
    localf.b(new b(i, paramString));
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public class a
    implements c7
  {
    public a(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, paramString, null);
      paramAPAlertDialog.f();
    }
  }
  
  public class b
    implements c7
  {
    public b(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, paramString, null);
        paramAPAlertDialog.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.goldcoupons.APGoldCouponsChannel
 * JD-Core Version:    0.7.0.1
 */