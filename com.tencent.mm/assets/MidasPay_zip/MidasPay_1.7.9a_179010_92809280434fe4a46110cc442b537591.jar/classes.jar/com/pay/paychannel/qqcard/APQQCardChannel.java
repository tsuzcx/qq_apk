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
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.c7;
import midas.x.d5;
import midas.x.g5;
import midas.x.g6;
import midas.x.g6.a;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p;
import midas.x.p4;
import midas.x.w3;
import midas.x.w4;
import midas.x.z5;

public class APQQCardChannel
  extends i5
{
  public static String p = "";
  public static String q = "";
  public static String r = "";
  public static String s = "";
  public String o = "";
  
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
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APQCardPayActivity.class);
    paramContext.startActivity(paramBundle);
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
      if (i != 1014)
      {
        if (i != 1023)
        {
          if (i != 10002)
          {
            if (i != 10006)
            {
              if (!TextUtils.isEmpty(this.o)) {
                p4.p().e().f.f = this.o;
              }
              a(i, paramw3.f(), false);
              r = "";
              s = "";
              return;
            }
            paramContext = new Bundle();
            paramContext.putString("vc", paramw3.T());
            paramContext.putString("vs", paramw3.U());
            paramw3 = this.e;
            if (paramw3 != null) {
              paramw3.a(i, paramContext);
            }
          }
          else
          {
            paramContext = new Bundle();
            paramContext.putString("vc", paramw3.T());
            paramContext.putString("vs", paramw3.U());
            paramw3 = this.e;
            if (paramw3 != null) {
              paramw3.a(i, paramContext);
            }
          }
        }
        else
        {
          r = "";
          s = "";
          APUICommonMethod.f();
          z5.a(i, "订单失效");
        }
      }
      else {
        a(paramw3);
      }
    }
    else
    {
      a(null);
      r = "";
      s = "";
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, final String paramString4)
  {
    final int i = p4.p().e().b.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, String.valueOf(15), null);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                paramString1 = "";
              }
              else
              {
                paramString1 = new StringBuilder();
                paramString1.append("QQ卡内金额只可购买");
                paramString1.append(p4.p().e().c.a);
                paramString1.append(p4.p().e().c.b);
                paramString1.append("x");
                paramString1.append(paramString4);
                paramString1.append(",是否支付?");
                paramString1 = paramString1.toString();
              }
            }
            else
            {
              paramString1 = new StringBuilder();
              paramString1.append("QQ卡内金额只可开通");
              paramString1.append(p4.p().e().c.b);
              paramString1.append("x");
              paramString1.append(paramString4);
              paramString1.append(",是否支付?");
              paramString1 = paramString1.toString();
            }
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("QQ卡内金额只可充值Q币x");
            paramString1.append(paramString4);
            paramString1.append(",是否支付?");
            paramString1 = paramString1.toString();
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("QQ卡内金额只可充值Q点x");
          paramString1.append(paramString4);
          paramString1.append(",是否支付?");
          paramString1 = paramString1.toString();
        }
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("QQ卡内金额只可购买");
        paramString1.append(p4.p().e().c.a);
        paramString1.append(p4.p().e().c.b);
        paramString1.append("x");
        paramString1.append(paramString4);
        paramString1.append(",是否支付?");
        paramString1 = paramString1.toString();
      }
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("QQ卡内金额只可购买");
      paramString1.append(p4.p().e().c.a);
      paramString1.append(p4.p().e().c.b);
      paramString1.append("x");
      paramString1.append(paramString4);
      paramString1.append(",是否支付?");
      paramString1 = paramString1.toString();
    }
    paramString2 = new APAlertDialog.f(this.c);
    paramString2.b("确认支付");
    paramString2.a(paramString1);
    paramString2.a("更换支付方式", new a(i));
    paramString2.b("确定支付", new b(i, paramString4));
    paramString2.b(new c(i));
    try
    {
      paramString2.b();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public final void a(w3 paramw3)
  {
    int i = p4.p().e().b.saveType;
    if (((i != 5) && (i != 4)) || ((g6.k().e() != g6.a.a) && (p4.p().e().b.isCanChange)))
    {
      if ((p.o().h()) && (p.o().f()) && (p.o().j()) && (p.o().i()))
      {
        a(this.c, "Q卡余额不足");
        return;
      }
      i = c(paramw3.B());
      if ((i == 0) || (i <= p4.p().e().c.e)) {}
    }
    try
    {
      paramw3 = String.valueOf(Float.valueOf(Integer.valueOf(paramw3.B()).intValue() / 100.0F));
    }
    catch (Exception paramw3)
    {
      label155:
      break label155;
    }
    paramw3 = "";
    a(p, q, paramw3, String.valueOf(i));
    return;
    a(this.c, "Q卡余额不足");
    return;
    a(this.c, "Q卡余额不足");
  }
  
  public final int c(String paramString)
  {
    try
    {
      i = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      int i;
      label11:
      int j;
      break label11;
    }
    i = 0;
    j = p4.p().e().b.saveType;
    paramString = p4.p().e();
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if ((j != 4) && (j != 5)) {
              return 0;
            }
            return i / Integer.valueOf(paramString.c.c).intValue();
          }
          return i / 100;
        }
        return i / 10;
      }
      j = Integer.valueOf(paramString.c.c).intValue();
      if (!TextUtils.isEmpty(paramString.c.d)) {
        j = Integer.valueOf(paramString.c.d).intValue();
      }
      return i / j;
    }
    return i * Integer.valueOf(paramString.c.c).intValue() / 100;
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public class a
    implements c7
  {
    public a(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, String.valueOf(15), null);
      paramAPAlertDialog.f();
    }
  }
  
  public class b
    implements c7
  {
    public b(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, String.valueOf(15), null);
      APQQCardChannel.a(APQQCardChannel.this, p4.p().e().f.f);
      p4.p().e().f.f = paramString4;
      if (APQQCardChannel.a(APQQCardChannel.this) != null) {
        APQQCardChannel.b(APQQCardChannel.this).a(1, null);
      }
    }
  }
  
  public class c
    implements c7
  {
    public c(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, String.valueOf(15), null);
        paramAPAlertDialog.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqcard.APQQCardChannel
 * JD-Core Version:    0.7.0.1
 */