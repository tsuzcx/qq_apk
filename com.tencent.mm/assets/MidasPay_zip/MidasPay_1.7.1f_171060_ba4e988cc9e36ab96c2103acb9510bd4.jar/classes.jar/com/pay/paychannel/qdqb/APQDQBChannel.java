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
import midas.x.d;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.eq;
import midas.x.er;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;
import midas.x.fp;
import midas.x.fs;
import midas.x.fu;
import midas.x.fz;
import midas.x.gn;
import midas.x.hj;
import midas.x.hs;
import midas.x.is;

public class APQDQBChannel
  extends ew
{
  public static String i = "";
  public static String j = "";
  public static String k = "";
  public static String l = "";
  public static String m = "";
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = new Intent();
    if (hs.b(this.d)) {
      paramString1.setClass(this.d, APX5WebJSBridgeActivity.class);
    } else {
      paramString1.setClass(this.d, APWebJSBridgeActivity.class);
    }
    paramString1.putExtra("pageName", hj.C);
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
    if ((a.a().j()) && (ed.b().n().d.e))
    {
      if ("qbqd".equals(paramString))
      {
        str1 = "充值Q币";
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("已绑定QQ：");
        ((StringBuilder)localObject).append(ed.b().n().d.k);
        ((StringBuilder)localObject).append("\n余额：");
        ((StringBuilder)localObject).append(ed.b().n().d.b());
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
        ((StringBuilder)localObject).append(ed.b().n().d.k);
        ((StringBuilder)localObject).append("\n余额：");
        ((StringBuilder)localObject).append(ed.b().n().d.a());
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
      ((StringBuilder)localObject).append(ed.b().n().d.b());
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
      ((StringBuilder)localObject).append(ed.b().n().d.a());
      ((StringBuilder)localObject).append(" Q点\n还需充值：");
      ((StringBuilder)localObject).append(g());
      ((StringBuilder)localObject).append(" Q点");
      localObject = ((StringBuilder)localObject).toString();
    }
    final int n = ed.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", n, null, paramString, null);
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b(str2);
    locala.a((String)localObject);
    locala.a(str1, new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fs.a().a(false);
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", n, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
        paramAnonymousAPAlertDialog = new Intent();
        fp.a().b("APRechargeAccountActivity");
        paramAnonymousAPAlertDialog.setClass(APQDQBChannel.a(APQDQBChannel.this), APQDQBRechargeActivity.class);
        APQDQBChannel.b(APQDQBChannel.this).startActivity(paramAnonymousAPAlertDialog);
        APUICommonMethod.b();
      }
    });
    locala.b("返回", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fs.a().a(false);
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", n, null, paramString, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    if ((fp.a().x()) && (ed.b().n().d.e)) {
      locala.a(new gn()
      {
        public void a(final APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.changeqqwxb", n, null, paramString, null);
          if (APQDQBChannel.c(APQDQBChannel.this) != null) {
            APQDQBChannel.d(APQDQBChannel.this).a(-999);
          }
          APQDQBChannel.this.a(paramAnonymousAPAlertDialog, new bk(true)
          {
            public void b(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3)
            {
              paramAnonymousAPAlertDialog.a();
              fs.a().a(true);
              APQDQBChannel.this.a(APQDQBChannel.e(APQDQBChannel.this), APQDQBChannel.f(APQDQBChannel.this), APQDQBChannel.g(APQDQBChannel.this));
            }
            
            public void c()
            {
              paramAnonymousAPAlertDialog.a();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("loadLogin onLoginFail stateCallback:");
              localStringBuilder.append(APQDQBChannel.h(APQDQBChannel.this));
              APLog.i("APBasePayChannel", localStringBuilder.toString());
              if (APQDQBChannel.i(APQDQBChannel.this) != null) {
                APQDQBChannel.j(APQDQBChannel.this).a();
              }
            }
          });
        }
      });
    }
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APQDQBChannel.i = "";
          fs.a().a(false);
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", n, null, paramString, null);
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
    fs.a().a(false);
    i = "";
    Object localObject = ed.b().n().a.openId;
    ed.b().n().e.a = fz.a(this.d).a((String)localObject);
    ed.b().n().e.b = fz.a(this.d).b((String)localObject);
    final int n = ed.b().n().a.saveType;
    localObject = new APAlertDialog.a(this.d);
    ((APAlertDialog.a)localObject).b("提示");
    ((APAlertDialog.a)localObject).a(paramString);
    ((APAlertDialog.a)localObject).a("我知道了", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APDataReportManager.getInstance().insertData("sdk.notenough.cancel", n, null, APQDQBChannel.k(APQDQBChannel.this), null);
      }
    });
    ((APAlertDialog.a)localObject).b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", n, null, APQDQBChannel.l(APQDQBChannel.this), null);
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    ((APAlertDialog.a)localObject).c();
  }
  
  private int f()
  {
    int i1 = ed.b().n().b.b() - ed.b().n().d.g;
    int n = i1;
    if (i1 < 0) {
      n = 0;
    }
    if (n % 100 == 0) {
      return n / 100;
    }
    return n / 100 + 1;
  }
  
  private int g()
  {
    int i1 = ed.b().n().b.b() - ed.b().n().d.g;
    int n = i1;
    if (i1 < 0) {
      n = 0;
    }
    if (n % 10 == 0) {
      return n / 10;
    }
    return n / 10 + 1;
  }
  
  public boolean a()
  {
    if (fp.a().F() > 0)
    {
      k = "";
      l = "";
      m = "";
    }
    return true;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(n);
    APLog.i("APQDChannel", ((StringBuilder)localObject).toString());
    if (n != 0)
    {
      if (n != 1004)
      {
        if (n != 1023)
        {
          if (n != 1035)
          {
            if ((n != 1094) && (n != 1099))
            {
              if (n != 1125)
              {
                if (n != 10001)
                {
                  if (n != 100004)
                  {
                    switch (n)
                    {
                    default: 
                      fs.a().a(false);
                      a(n, paramdl.S(), false);
                      return;
                    case 100009: 
                      fp.a().f(false);
                      c(paramdl.S());
                      return;
                    }
                    ed.b().n().d.f = false;
                    c(paramdl.S());
                    return;
                  }
                  paramContext = paramdl.P();
                  a(this.e, paramContext);
                  return;
                }
                int i1 = paramdl.G();
                String str = paramdl.H();
                localObject = new Bundle();
                m = paramdl.a();
                l = paramdl.b();
                if (l.length() > 0)
                {
                  if (str.equals("1")) {
                    ((Bundle)localObject).putBoolean("smsMbOnly", true);
                  } else {
                    ((Bundle)localObject).putBoolean("smsMbOnly", false);
                  }
                  ((Bundle)localObject).putInt("smsRemain", i1);
                  ((Bundle)localObject).putString("mbUrl", m);
                  ((Bundle)localObject).putString("mbSmsInfo", l);
                  ((Bundle)localObject).putString("mbType", "smsMb");
                  if (this.f != null)
                  {
                    this.f.a(n, (Bundle)localObject);
                    return;
                  }
                  ((Bundle)localObject).putInt("to", 2);
                  if (is.c.size() > 0) {
                    try
                    {
                      ((APRecoChannelActivity)paramContext).a(1, 2, (Bundle)localObject);
                      return;
                    }
                    catch (Exception paramdl)
                    {
                      paramdl.printStackTrace();
                      paramdl = new Intent(paramContext, APRecoChannelActivity.class);
                      paramdl.putExtras((Bundle)localObject);
                      paramContext.startActivity(paramdl);
                      return;
                    }
                  }
                  paramdl = new Intent(paramContext, APRecoChannelActivity.class);
                  paramdl.putExtras((Bundle)localObject);
                  paramContext.startActivity(paramdl);
                  return;
                }
                fu.a((Activity)paramContext, false, 0, m, l, false);
                return;
              }
              if (this.f != null)
              {
                paramContext = new Bundle();
                paramContext.putString("errMsg", paramdl.T());
                this.f.a(n, paramContext);
                return;
              }
              APUICommonMethod.a(paramContext, paramdl.T(), null, false);
            }
          }
          else {
            a(n, paramdl.S(), false);
          }
        }
        else
        {
          APUICommonMethod.b();
          fm.a(n, "订单失效");
        }
      }
      else
      {
        if (i.length() > 0)
        {
          ed.b().n().d.f = false;
          c(paramdl.S());
          return;
        }
        b(this.e);
      }
    }
    else
    {
      a(null);
      j = "";
      k = "";
      l = "";
      m = "";
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.g = paramev;
    this.f = parameu;
    i = "";
    if (a.a().j())
    {
      if (ed.b().n().d.e)
      {
        a(paramContext, paramev, parameu);
        return;
      }
      paramBundle = ed.b().n().e.j;
      if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.equals("qdqb")) || (paramBundle.equals("qbqd"))))
      {
        if (fp.a().v())
        {
          c();
          return;
        }
        a(paramContext, paramev, parameu);
        return;
      }
      if (!ed.b().n().d.f)
      {
        c();
        return;
      }
      a(paramContext, paramev, parameu);
      return;
    }
    if ((!d.a()) && (!d.b()))
    {
      a(paramContext, paramev, parameu);
      return;
    }
    if (!ed.b().n().d.f)
    {
      c();
      return;
    }
    a(paramContext, paramev, parameu);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qdqb.APQDQBChannel
 * JD-Core Version:    0.7.0.1
 */