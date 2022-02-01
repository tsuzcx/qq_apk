package com.pay.paychannel.qdqb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APQDQBRechargeActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.bk;
import midas.x.bq;
import midas.x.d;
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ez;
import midas.x.fa;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;
import midas.x.fy;
import midas.x.gc;
import midas.x.ge;
import midas.x.gj;
import midas.x.gy;
import midas.x.hu;
import midas.x.id;
import midas.x.jd;

public class APQDQBChannel
  extends ff
{
  public static String j = "";
  public static String k = "";
  public static String l = "";
  public static String m = "";
  public static String n = "";
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = new Intent();
    if (id.b(this.d)) {
      paramString1.setClass(this.d, APX5WebJSBridgeActivity.class);
    } else {
      paramString1.setClass(this.d, APWebJSBridgeActivity.class);
    }
    paramString1.putExtra("pageName", hu.C);
    paramString1.putExtra("errCode", paramString2);
    this.d.startActivity(paramString1);
  }
  
  private void b(final String paramString)
  {
    String str2;
    if ("qbqd".equals(paramString)) {
      str2 = "Q币余额不足";
    } else {
      str2 = "Q点余额不足";
    }
    String str1;
    Object localObject;
    if ((a.a().j()) && (em.b().n().d.e))
    {
      if ("qbqd".equals(paramString))
      {
        str1 = "充值Q币";
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("已绑定QQ：");
        ((StringBuilder)localObject).append(em.b().n().d.k);
        ((StringBuilder)localObject).append("\n余额：");
        ((StringBuilder)localObject).append(em.b().n().d.b());
        ((StringBuilder)localObject).append(" Q币\n还需充值：");
        ((StringBuilder)localObject).append(f());
        ((StringBuilder)localObject).append(" Q币");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        str1 = "充值Q点";
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("已绑定QQ：");
        ((StringBuilder)localObject).append(em.b().n().d.k);
        ((StringBuilder)localObject).append("\n余额：");
        ((StringBuilder)localObject).append(em.b().n().d.a());
        ((StringBuilder)localObject).append(" Q点\n还需充值：");
        ((StringBuilder)localObject).append(g());
        ((StringBuilder)localObject).append(" Q点");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else if ("qbqd".equals(paramString))
    {
      str1 = "充值Q币";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("余额：");
      ((StringBuilder)localObject).append(em.b().n().d.b());
      ((StringBuilder)localObject).append(" Q币\n还需充值：");
      ((StringBuilder)localObject).append(f());
      ((StringBuilder)localObject).append(" Q币");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      str1 = "充值Q点";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("余额：");
      ((StringBuilder)localObject).append(em.b().n().d.a());
      ((StringBuilder)localObject).append(" Q点\n还需充值：");
      ((StringBuilder)localObject).append(g());
      ((StringBuilder)localObject).append(" Q点");
      localObject = ((StringBuilder)localObject).toString();
    }
    final int i = em.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, paramString, null);
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b(str2);
    locala.a((String)localObject);
    locala.a(str1, new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        gc.a().a(false);
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
        paramAnonymousAPAlertDialog = new Intent();
        fy.a().b("APRechargeAccountActivity");
        paramAnonymousAPAlertDialog.setClass(APQDQBChannel.this.d, APQDQBRechargeActivity.class);
        APQDQBChannel.this.d.startActivity(paramAnonymousAPAlertDialog);
        APUICommonMethod.b();
      }
    });
    locala.b("返回", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        gc.a().a(false);
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    if ((fy.a().x()) && (em.b().n().d.e)) {
      locala.a(new gy()
      {
        public void a(final APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.changeqqwxb", i, null, paramString, null);
          if (APQDQBChannel.a(APQDQBChannel.this) != null) {
            APQDQBChannel.b(APQDQBChannel.this).a(-999);
          }
          APQDQBChannel.this.a(paramAnonymousAPAlertDialog, new bk(true)
          {
            public void b(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3)
            {
              paramAnonymousAPAlertDialog.a();
              gc.a().a(true);
              APQDQBChannel.this.a(APQDQBChannel.this.d, APQDQBChannel.c(APQDQBChannel.this), APQDQBChannel.d(APQDQBChannel.this));
            }
            
            public void c()
            {
              paramAnonymousAPAlertDialog.a();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("loadLogin onLoginFail stateCallback:");
              localStringBuilder.append(APQDQBChannel.e(APQDQBChannel.this));
              APLog.i("APBasePayChannel", localStringBuilder.toString());
              if (APQDQBChannel.f(APQDQBChannel.this) != null) {
                APQDQBChannel.g(APQDQBChannel.this).a();
              }
            }
          });
        }
      });
    }
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APQDQBChannel.j = "";
          gc.a().a(false);
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, paramString, null);
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
  
  private void c(String paramString)
  {
    gc.a().a(false);
    j = "";
    Object localObject = em.b().n().a.openId;
    em.b().n().e.a = gj.a(this.d).a((String)localObject);
    em.b().n().e.b = gj.a(this.d).b((String)localObject);
    final int i = em.b().n().a.saveType;
    localObject = new APAlertDialog.a(this.d);
    ((APAlertDialog.a)localObject).b("提示");
    ((APAlertDialog.a)localObject).a(paramString);
    ((APAlertDialog.a)localObject).a("我知道了", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, APQDQBChannel.this.e, null);
      }
    });
    ((APAlertDialog.a)localObject).b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, APQDQBChannel.this.e, null);
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    ((APAlertDialog.a)localObject).c();
  }
  
  private int f()
  {
    int i1 = em.b().n().b.b() - em.b().n().d.g;
    int i = i1;
    if (i1 < 0) {
      i = 0;
    }
    if (i % 100 == 0) {
      return i / 100;
    }
    return i / 100 + 1;
  }
  
  private int g()
  {
    int i1 = em.b().n().b.b() - em.b().n().d.g;
    int i = i1;
    if (i1 < 0) {
      i = 0;
    }
    if (i % 10 == 0) {
      return i / 10;
    }
    return i / 10 + 1;
  }
  
  public boolean a()
  {
    if (fy.a().F() > 0)
    {
      l = "";
      m = "";
      n = "";
    }
    return true;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APQDChannel", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      if (i != 1004)
      {
        if (i != 1023)
        {
          if (i != 1035)
          {
            if ((i != 1094) && (i != 1099))
            {
              if (i != 1125)
              {
                if (i != 10001)
                {
                  if (i != 100004)
                  {
                    switch (i)
                    {
                    default: 
                      gc.a().a(false);
                      a(i, paramdt.U(), false);
                      return;
                    case 100009: 
                      fy.a().f(false);
                      c(paramdt.U());
                      return;
                    }
                    em.b().n().d.f = false;
                    c(paramdt.U());
                    return;
                  }
                  paramContext = paramdt.P();
                  a(this.e, paramContext);
                  return;
                }
                int i1 = paramdt.H();
                String str = paramdt.I();
                localObject = new Bundle();
                n = paramdt.c();
                m = paramdt.d();
                if (m.length() > 0)
                {
                  if (str.equals("1")) {
                    ((Bundle)localObject).putBoolean("smsMbOnly", true);
                  } else {
                    ((Bundle)localObject).putBoolean("smsMbOnly", false);
                  }
                  ((Bundle)localObject).putInt("smsRemain", i1);
                  ((Bundle)localObject).putString("mbUrl", n);
                  ((Bundle)localObject).putString("mbSmsInfo", m);
                  ((Bundle)localObject).putString("mbType", "smsMb");
                  if (this.f != null)
                  {
                    this.f.a(i, (Bundle)localObject);
                    return;
                  }
                  ((Bundle)localObject).putInt("to", 2);
                  if (jd.c.size() > 0) {
                    try
                    {
                      ((APRecoChannelActivity)paramContext).a(1, 2, (Bundle)localObject);
                      return;
                    }
                    catch (Exception paramdt)
                    {
                      paramdt.printStackTrace();
                      paramdt = new Intent(paramContext, APRecoChannelActivity.class);
                      paramdt.putExtras((Bundle)localObject);
                      paramContext.startActivity(paramdt);
                      return;
                    }
                  }
                  paramdt = new Intent(paramContext, APRecoChannelActivity.class);
                  paramdt.putExtras((Bundle)localObject);
                  paramContext.startActivity(paramdt);
                  return;
                }
                ge.a((Activity)paramContext, false, 0, n, m, false);
                return;
              }
              if (this.f != null)
              {
                paramContext = new Bundle();
                paramContext.putString("errMsg", paramdt.V());
                this.f.a(i, paramContext);
                return;
              }
              APUICommonMethod.a(paramContext, paramdt.V(), null, false);
            }
          }
          else {
            a(i, paramdt.U(), false);
          }
        }
        else
        {
          APUICommonMethod.b();
          fv.a(i, "订单失效");
        }
      }
      else
      {
        if (j.length() > 0)
        {
          em.b().n().d.f = false;
          c(paramdt.U());
          return;
        }
        b(this.e);
      }
    }
    else
    {
      a(null);
      k = "";
      l = "";
      m = "";
      n = "";
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.g = paramfe;
    this.f = paramfd;
    j = "";
    if (bq.c())
    {
      if ((a.a().j()) && (!em.b().n().d.e))
      {
        APUICommonMethod.a(paramContext, "使用Q币支付请先绑定QQ号码");
        if (paramfe != null) {
          paramfe.a();
        }
        return;
      }
      a(paramContext, paramfe, paramfd);
      return;
    }
    if (a.a().j())
    {
      if (em.b().n().d.e)
      {
        a(paramContext, paramfe, paramfd);
        return;
      }
      paramBundle = em.b().n().e.j;
      if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.equals("qdqb")) || (paramBundle.equals("qbqd"))))
      {
        if (fy.a().v())
        {
          c();
          return;
        }
        a(paramContext, paramfe, paramfd);
        return;
      }
      if (!em.b().n().d.f)
      {
        c();
        return;
      }
      a(paramContext, paramfe, paramfd);
      return;
    }
    if ((!d.a()) && (!d.b()))
    {
      a(paramContext, paramfe, paramfd);
      return;
    }
    if (!em.b().n().d.f)
    {
      c();
      return;
    }
    a(paramContext, paramfe, paramfd);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qdqb.APQDQBChannel
 * JD-Core Version:    0.7.0.1
 */