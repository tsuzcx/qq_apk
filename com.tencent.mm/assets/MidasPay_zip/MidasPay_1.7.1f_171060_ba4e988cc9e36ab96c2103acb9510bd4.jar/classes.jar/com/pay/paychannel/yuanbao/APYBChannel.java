package com.pay.paychannel.yuanbao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;
import midas.x.gn;
import midas.x.is;

public class APYBChannel
  extends ew
{
  private void b(final String paramString)
  {
    final int i = ed.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, paramString, null);
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("提示");
    locala.a("您的元宝余额不足");
    locala.a("", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, paramString, null);
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
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
          a(i, paramdl.S(), false);
          return;
        }
        APUICommonMethod.b();
        fm.a(i, "订单失效");
        return;
      }
      b(this.e);
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
 * Qualified Name:     com.pay.paychannel.yuanbao.APYBChannel
 * JD-Core Version:    0.7.0.1
 */