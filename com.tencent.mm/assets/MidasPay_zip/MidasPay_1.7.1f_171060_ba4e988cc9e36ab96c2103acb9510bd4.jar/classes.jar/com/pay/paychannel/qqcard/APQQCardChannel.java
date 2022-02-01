package com.pay.paychannel.qqcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.channel.APQCardPayActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.er;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;
import midas.x.fs;
import midas.x.fs.a;
import midas.x.gn;
import midas.x.is;
import midas.x.o;

public class APQQCardChannel
  extends ew
{
  public static String i = "";
  public static String j = "";
  public static String k = "";
  public static String l = "";
  private String m = "";
  
  private void a(String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    final int n = ed.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", n, null, String.valueOf(15), null);
    paramString1 = "";
    switch (n)
    {
    default: 
      break;
    case 5: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(ed.b().n().b.a);
      paramString1.append(ed.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 4: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可开通");
      paramString1.append(ed.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 3: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可充值Q币x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 2: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可充值Q点x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 1: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(ed.b().n().b.a);
      paramString1.append(ed.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 0: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(ed.b().n().b.a);
      paramString1.append(ed.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
    }
    paramString2 = new APAlertDialog.a(this.d);
    paramString2.b("确认支付");
    paramString2.a(paramString1);
    paramString2.b("更换支付方式", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", n, null, String.valueOf(15), null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramString2.a("确定支付", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", n, null, String.valueOf(15), null);
        APQQCardChannel.a(APQQCardChannel.this, ed.b().n().e.g);
        ed.b().n().e.g = paramString4;
        if (APQQCardChannel.a(APQQCardChannel.this) != null) {
          APQQCardChannel.b(APQQCardChannel.this).a(1, null);
        }
      }
    });
    paramString2.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", n, null, String.valueOf(15), null);
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    try
    {
      paramString2.c();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private void a(dl paramdl)
  {
    int n = ed.b().n().a.saveType;
    if (((n != 5) && (n != 4)) || ((fs.a().f() != fs.a.a) && (ed.b().n().a.isCanChange)))
    {
      if ((o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
      {
        a(this.d, "Q卡余额不足");
        return;
      }
      n = b(paramdl.w());
      if ((n == 0) || (n <= ed.b().n().b.h)) {}
    }
    try
    {
      paramdl = String.valueOf(Float.valueOf(Integer.valueOf(paramdl.w()).intValue() / 100.0F));
    }
    catch (Exception paramdl)
    {
      label153:
      break label153;
    }
    paramdl = "";
    a(i, j, paramdl, String.valueOf(n));
    return;
    a(this.d, "Q卡余额不足");
    return;
    a(this.d, "Q卡余额不足");
  }
  
  private int b(String paramString)
  {
    try
    {
      n = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      int n;
      label11:
      int i1;
      break label11;
    }
    n = 0;
    i1 = ed.b().n().a.saveType;
    paramString = ed.b().n();
    switch (i1)
    {
    default: 
      return 0;
    case 4: 
    case 5: 
      return n / Integer.valueOf(paramString.b.e).intValue();
    case 3: 
      return n / 100;
    case 2: 
      return n / 10;
    case 1: 
      i1 = Integer.valueOf(paramString.b.e).intValue();
      if (!TextUtils.isEmpty(paramString.b.f)) {
        i1 = Integer.valueOf(paramString.b.f).intValue();
      }
      return n / i1;
    }
    return n * Integer.valueOf(paramString.b.e).intValue() / 100;
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
    int n = paramdl.R();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(n);
    APLog.i("APQDChannel", paramContext.toString());
    if (n != 0)
    {
      if (n != 1014)
      {
        if (n != 1023)
        {
          if (n != 10002)
          {
            if (n != 10006)
            {
              if (!TextUtils.isEmpty(this.m)) {
                ed.b().n().e.g = this.m;
              }
              a(n, paramdl.S(), false);
              k = "";
              l = "";
              return;
            }
            paramContext = new Bundle();
            paramContext.putString("vc", paramdl.e());
            paramContext.putString("vs", paramdl.f());
            if (this.f != null) {
              this.f.a(n, paramContext);
            }
          }
          else
          {
            paramContext = new Bundle();
            paramContext.putString("vc", paramdl.e());
            paramContext.putString("vs", paramdl.f());
            if (this.f != null) {
              this.f.a(n, paramContext);
            }
          }
        }
        else
        {
          k = "";
          l = "";
          APUICommonMethod.b();
          fm.a(n, "订单失效");
        }
      }
      else {
        a(paramdl);
      }
    }
    else
    {
      a(null);
      k = "";
      l = "";
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APQCardPayActivity.class);
    paramContext.startActivity(paramBundle);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqcard.APQQCardChannel
 * JD-Core Version:    0.7.0.1
 */