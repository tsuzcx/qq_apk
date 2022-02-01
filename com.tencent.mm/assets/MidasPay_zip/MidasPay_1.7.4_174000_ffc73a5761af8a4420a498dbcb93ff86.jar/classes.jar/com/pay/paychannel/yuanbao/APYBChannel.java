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
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;
import midas.x.gy;
import midas.x.jd;

public class APYBChannel
  extends ff
{
  private void b(final String paramString)
  {
    final int i = em.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, paramString, null);
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("提示");
    locala.a("您的元宝余额不足");
    locala.a("", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    locala.b(new gy()
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
          a(i, paramdt.U(), false);
          return;
        }
        APUICommonMethod.b();
        fv.a(i, "订单失效");
        return;
      }
      b(this.e);
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
 * Qualified Name:     com.pay.paychannel.yuanbao.APYBChannel
 * JD-Core Version:    0.7.0.1
 */