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
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;
import midas.x.gc;
import midas.x.gc.a;
import midas.x.gy;
import midas.x.jd;
import midas.x.o;

public class APQQCardChannel
  extends ff
{
  public static String j = "";
  public static String k = "";
  public static String l = "";
  public static String m = "";
  private String n = "";
  
  private void a(String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    final int i = em.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, String.valueOf(15), null);
    paramString1 = "";
    switch (i)
    {
    default: 
      break;
    case 5: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(em.b().n().b.a);
      paramString1.append(em.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 4: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可开通");
      paramString1.append(em.b().n().b.b);
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
      paramString1.append(em.b().n().b.a);
      paramString1.append(em.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
      break;
    case 0: 
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(em.b().n().b.a);
      paramString1.append(em.b().n().b.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
    }
    paramString2 = new APAlertDialog.a(this.d);
    paramString2.b("确认支付");
    paramString2.a(paramString1);
    paramString2.b("更换支付方式", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, String.valueOf(15), null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramString2.a("确定支付", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, String.valueOf(15), null);
        APQQCardChannel.a(APQQCardChannel.this, em.b().n().e.g);
        em.b().n().e.g = paramString4;
        if (APQQCardChannel.a(APQQCardChannel.this) != null) {
          APQQCardChannel.b(APQQCardChannel.this).a(1, null);
        }
      }
    });
    paramString2.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, String.valueOf(15), null);
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
  
  private void a(dt paramdt)
  {
    int i = em.b().n().a.saveType;
    if (((i != 5) && (i != 4)) || ((gc.a().f() != gc.a.a) && (em.b().n().a.isCanChange)))
    {
      if ((o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
      {
        a(this.d, "Q卡余额不足");
        return;
      }
      i = b(paramdt.y());
      if ((i == 0) || (i <= em.b().n().b.h)) {}
    }
    try
    {
      paramdt = String.valueOf(Float.valueOf(Integer.valueOf(paramdt.y()).intValue() / 100.0F));
    }
    catch (Exception paramdt)
    {
      label153:
      break label153;
    }
    paramdt = "";
    a(j, k, paramdt, String.valueOf(i));
    return;
    a(this.d, "Q卡余额不足");
    return;
    a(this.d, "Q卡余额不足");
  }
  
  private int b(String paramString)
  {
    try
    {
      i = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      int i;
      label11:
      int i1;
      break label11;
    }
    i = 0;
    i1 = em.b().n().a.saveType;
    paramString = em.b().n();
    switch (i1)
    {
    default: 
      return 0;
    case 4: 
    case 5: 
      return i / Integer.valueOf(paramString.b.e).intValue();
    case 3: 
      return i / 100;
    case 2: 
      return i / 10;
    case 1: 
      i1 = Integer.valueOf(paramString.b.e).intValue();
      if (!TextUtils.isEmpty(paramString.b.f)) {
        i1 = Integer.valueOf(paramString.b.f).intValue();
      }
      return i / i1;
    }
    return i * Integer.valueOf(paramString.b.e).intValue() / 100;
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
      if (i != 1014)
      {
        if (i != 1023)
        {
          if (i != 10002)
          {
            if (i != 10006)
            {
              if (!TextUtils.isEmpty(this.n)) {
                em.b().n().e.g = this.n;
              }
              a(i, paramdt.U(), false);
              l = "";
              m = "";
              return;
            }
            paramContext = new Bundle();
            paramContext.putString("vc", paramdt.g());
            paramContext.putString("vs", paramdt.h());
            if (this.f != null) {
              this.f.a(i, paramContext);
            }
          }
          else
          {
            paramContext = new Bundle();
            paramContext.putString("vc", paramdt.g());
            paramContext.putString("vs", paramdt.h());
            if (this.f != null) {
              this.f.a(i, paramContext);
            }
          }
        }
        else
        {
          l = "";
          m = "";
          APUICommonMethod.b();
          fv.a(i, "订单失效");
        }
      }
      else {
        a(paramdt);
      }
    }
    else
    {
      a(null);
      l = "";
      m = "";
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APQCardPayActivity.class);
    paramContext.startActivity(paramBundle);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqcard.APQQCardChannel
 * JD-Core Version:    0.7.0.1
 */