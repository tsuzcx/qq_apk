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
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APQDQBRechargeActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.c5;
import midas.x.c6;
import midas.x.c7;
import midas.x.d;
import midas.x.d5;
import midas.x.g5;
import midas.x.g6;
import midas.x.h5;
import midas.x.h8;
import midas.x.i5;
import midas.x.i6;
import midas.x.j9;
import midas.x.l1;
import midas.x.n6;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.r1;
import midas.x.w3;
import midas.x.w4;
import midas.x.y7;
import midas.x.z5;

public class APQDQBChannel
  extends i5
{
  public static String o = "";
  public static String p = "";
  public static String q = "";
  public static String r = "";
  public static String s = "";
  
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
    this.f = paramh5;
    this.e = paramg5;
    o = "";
    if (r1.i())
    {
      if ((a.r().e()) && (!p4.p().e().e.e))
      {
        APUICommonMethod.a(paramContext, "使用Q币支付请先绑定QQ号码");
        if (paramh5 != null) {
          paramh5.a();
        }
        return;
      }
      a(paramContext, paramh5, paramg5);
      return;
    }
    if (a.r().e())
    {
      if (p4.p().e().e.e)
      {
        a(paramContext, paramh5, paramg5);
        return;
      }
      paramBundle = p4.p().e().f.i;
      if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.equals("qdqb")) || (paramBundle.equals("qbqd"))))
      {
        if (c6.s0().o0())
        {
          e();
          return;
        }
        a(paramContext, paramh5, paramg5);
        return;
      }
      if (!p4.p().e().e.f)
      {
        e();
        return;
      }
      a(paramContext, paramh5, paramg5);
      return;
    }
    if ((!d.a()) && (!d.b()))
    {
      a(paramContext, paramh5, paramg5);
      return;
    }
    if (!p4.p().e().e.f)
    {
      e();
      return;
    }
    a(paramContext, paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
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
                      g6.k().a(false);
                      a(i, paramw3.f(), false);
                      return;
                    case 100009: 
                      c6.s0().a(false);
                      c(paramw3.f());
                      return;
                    }
                    p4.p().e().e.f = false;
                    c(paramw3.f());
                    return;
                  }
                  paramContext = paramw3.i();
                  a(this.d, paramContext);
                  return;
                }
                int j = paramw3.P();
                String str = paramw3.O();
                localObject = new Bundle();
                s = paramw3.v();
                r = paramw3.N();
                if (r.length() > 0)
                {
                  if (str.equals("1")) {
                    ((Bundle)localObject).putBoolean("smsMbOnly", true);
                  } else {
                    ((Bundle)localObject).putBoolean("smsMbOnly", false);
                  }
                  ((Bundle)localObject).putInt("smsRemain", j);
                  ((Bundle)localObject).putString("mbUrl", s);
                  ((Bundle)localObject).putString("mbSmsInfo", r);
                  ((Bundle)localObject).putString("mbType", "smsMb");
                  paramw3 = this.e;
                  if (paramw3 != null)
                  {
                    paramw3.a(i, (Bundle)localObject);
                    return;
                  }
                  ((Bundle)localObject).putInt("to", 2);
                  if (j9.b.size() > 0) {
                    try
                    {
                      ((APRecoChannelActivity)paramContext).a(1, 2, (Bundle)localObject);
                      return;
                    }
                    catch (Exception paramw3)
                    {
                      paramw3.printStackTrace();
                      paramw3 = new Intent(paramContext, APRecoChannelActivity.class);
                      paramw3.putExtras((Bundle)localObject);
                      paramContext.startActivity(paramw3);
                      return;
                    }
                  }
                  paramw3 = new Intent(paramContext, APRecoChannelActivity.class);
                  paramw3.putExtras((Bundle)localObject);
                  paramContext.startActivity(paramw3);
                  return;
                }
                i6.a((Activity)paramContext, false, 0, s, r, false);
                return;
              }
              if (this.e != null)
              {
                paramContext = new Bundle();
                paramContext.putString("errMsg", paramw3.c());
                this.e.a(i, paramContext);
                return;
              }
              APUICommonMethod.a(paramContext, paramw3.c(), null, false);
            }
          }
          else {
            a(i, paramw3.f(), false);
          }
        }
        else
        {
          APUICommonMethod.f();
          z5.a(i, "订单失效");
        }
      }
      else
      {
        if (o.length() > 0)
        {
          p4.p().e().e.f = false;
          c(paramw3.f());
          return;
        }
        d(this.d);
      }
    }
    else
    {
      a(null);
      p = "";
      q = "";
      r = "";
      s = "";
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = new Intent();
    if (h8.d(this.c)) {
      paramString1.setClass(this.c, APX5WebJSBridgeActivity.class);
    } else {
      paramString1.setClass(this.c, APWebJSBridgeActivity.class);
    }
    paramString1.putExtra("pageName", y7.z);
    paramString1.putExtra("errCode", paramString2);
    this.c.startActivity(paramString1);
  }
  
  public boolean b()
  {
    if (c6.s0().f() > 0)
    {
      q = "";
      r = "";
      s = "";
    }
    return true;
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void c(String paramString)
  {
    g6.k().a(false);
    o = "";
    Object localObject = p4.p().e().b.openId;
    p4.p().e().f.a = n6.a(this.c).b((String)localObject);
    p4.p().e().f.b = n6.a(this.c).a((String)localObject);
    final int i = p4.p().e().b.saveType;
    localObject = new APAlertDialog.f(this.c);
    ((APAlertDialog.f)localObject).b("提示");
    ((APAlertDialog.f)localObject).a(paramString);
    ((APAlertDialog.f)localObject).b("我知道了", new e(i));
    ((APAlertDialog.f)localObject).b(new f(i));
    ((APAlertDialog.f)localObject).b();
  }
  
  public final void d(final String paramString)
  {
    String str1;
    if ("qbqd".equals(paramString)) {
      str1 = "Q币余额不足";
    } else {
      str1 = "Q点余额不足";
    }
    boolean bool = a.r().e();
    String str2 = "充值Q币";
    Object localObject;
    if ((bool) && (p4.p().e().e.e))
    {
      if ("qbqd".equals(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("已绑定QQ：");
        ((StringBuilder)localObject).append(p4.p().e().e.i);
        ((StringBuilder)localObject).append("\n余额：");
        ((StringBuilder)localObject).append(p4.p().e().e.b());
        ((StringBuilder)localObject).append(" Q币\n还需充值：");
        ((StringBuilder)localObject).append(h());
        ((StringBuilder)localObject).append(" Q币");
        localObject = ((StringBuilder)localObject).toString();
        break label423;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("已绑定QQ：");
      ((StringBuilder)localObject).append(p4.p().e().e.i);
      ((StringBuilder)localObject).append("\n余额：");
      ((StringBuilder)localObject).append(p4.p().e().e.c());
      ((StringBuilder)localObject).append(" Q点\n还需充值：");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append(" Q点");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      if ("qbqd".equals(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("余额：");
        ((StringBuilder)localObject).append(p4.p().e().e.b());
        ((StringBuilder)localObject).append(" Q币\n还需充值：");
        ((StringBuilder)localObject).append(h());
        ((StringBuilder)localObject).append(" Q币");
        localObject = ((StringBuilder)localObject).toString();
        break label423;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("余额：");
      ((StringBuilder)localObject).append(p4.p().e().e.c());
      ((StringBuilder)localObject).append(" Q点\n还需充值：");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append(" Q点");
      localObject = ((StringBuilder)localObject).toString();
    }
    str2 = "充值Q点";
    label423:
    final int i = p4.p().e().b.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i, null, paramString, null);
    APAlertDialog.f localf = new APAlertDialog.f(this.c);
    localf.b(str1);
    localf.a((String)localObject);
    localf.b(str2, new a(i, paramString));
    localf.a("返回", new b(i, paramString));
    if ((c6.s0().v()) && (p4.p().e().e.e)) {
      localf.a(new c(i, paramString));
    }
    localf.b(new d(i, paramString));
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final int h()
  {
    int j = p4.p().e().c.b() - p4.p().e().e.g;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (i % 100 == 0) {
      return i / 100;
    }
    return i / 100 + 1;
  }
  
  public final int i()
  {
    int j = p4.p().e().c.b() - p4.p().e().e.g;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (i % 10 == 0) {
      return i / 10;
    }
    return i / 10 + 1;
  }
  
  public class a
    implements c7
  {
    public a(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      g6.k().a(false);
      APDataReportManager.getInstance().insertData("sdk.notenough.sure", i, null, paramString, null);
      paramAPAlertDialog.f();
      paramAPAlertDialog = new Intent();
      c6.s0().A("APRechargeAccountActivity");
      paramAPAlertDialog.setClass(APQDQBChannel.this.c, APQDQBRechargeActivity.class);
      APQDQBChannel.this.c.startActivity(paramAPAlertDialog);
      APUICommonMethod.f();
    }
  }
  
  public class b
    implements c7
  {
    public b(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      g6.k().a(false);
      APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, paramString, null);
      paramAPAlertDialog.f();
    }
  }
  
  public class c
    implements c7
  {
    public c(int paramInt, String paramString) {}
    
    public void a(final APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.notenough.changeqqwxb", i, null, paramString, null);
      if (APQDQBChannel.a(APQDQBChannel.this) != null) {
        APQDQBChannel.b(APQDQBChannel.this).a(-999);
      }
      APQDQBChannel.this.a(paramAPAlertDialog, new a(true, paramAPAlertDialog));
    }
    
    public class a
      extends l1
    {
      public a(boolean paramBoolean, APAlertDialog paramAPAlertDialog)
      {
        super();
      }
      
      public void a(String paramString1, String paramString2, String paramString3)
      {
        paramAPAlertDialog.f();
        g6.k().a(true);
        paramString1 = APQDQBChannel.this;
        paramString1.a(paramString1.c, APQDQBChannel.c(paramString1), APQDQBChannel.d(APQDQBChannel.this));
      }
      
      public void c()
      {
        paramAPAlertDialog.f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadLogin onLoginFail stateCallback:");
        localStringBuilder.append(APQDQBChannel.e(APQDQBChannel.this));
        APLog.i("APBasePayChannel", localStringBuilder.toString());
        if (APQDQBChannel.f(APQDQBChannel.this) != null) {
          APQDQBChannel.g(APQDQBChannel.this).a();
        }
      }
      
      public void d()
      {
        paramAPAlertDialog.f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadLogin onLoginFail stateCallback:");
        localStringBuilder.append(APQDQBChannel.h(APQDQBChannel.this));
        APLog.i("APBasePayChannel", localStringBuilder.toString());
        if (APQDQBChannel.i(APQDQBChannel.this) != null) {
          APQDQBChannel.j(APQDQBChannel.this).a();
        }
        APQDQBChannel.c(APQDQBChannel.this.c, "您购买业务未提供QQ授权信息，暂时无法使用Q币支付，请咨询客服或更换其他支付渠道。（错误码：-6）");
      }
    }
  }
  
  public class d
    implements c7
  {
    public d(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APQDQBChannel.o = "";
        g6.k().a(false);
        APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, paramString, null);
      }
    }
  }
  
  public class e
    implements c7
  {
    public e(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APDataReportManager.getInstance().insertData("sdk.notenough.cancel", i, null, APQDQBChannel.this.d, null);
    }
  }
  
  public class f
    implements c7
  {
    public f(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i, null, APQDQBChannel.this.d, null);
        paramAPAlertDialog.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qdqb.APQDQBChannel
 * JD-Core Version:    0.7.0.1
 */