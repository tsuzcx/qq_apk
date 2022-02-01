package com.pay.paychannel.wsj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import midas.x.c7;
import midas.x.d5;
import midas.x.e;
import midas.x.g5;
import midas.x.h5;
import midas.x.h8;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.w3;
import midas.x.y7;
import midas.x.z5;

public class APWSJChannel
  extends i5
{
  public Object o = null;
  public Handler p = new Handler(new a());
  
  public void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.w("APWechatPaySDK", "toWSJChannel signInfo is null");
      APUICommonMethod.a(this.c, "系统繁忙,请稍后再试");
      return;
    }
    if (!h())
    {
      APLog.i("APWSJChannelPaySDK", "is not HasWsjSDK");
      paramActivity = new Intent();
      if (h8.d(this.c.getApplicationContext())) {
        paramActivity.setClass(this.c, APX5WebJSBridgeActivity.class);
      } else {
        paramActivity.setClass(this.c, APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("signInfo", paramString);
      localBundle.putSerializable("pageName", y7.u);
      paramActivity.putExtras(localBundle);
      this.c.startActivity(paramActivity);
      return;
    }
    try
    {
      this.o = Class.forName("com.tencent.midas.wsjchannel.APMidasWSJChannelHelper").getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { this.c });
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" registerApp e:");
      localStringBuilder2.append(localException.toString());
      APLog.w("APWSJChannelPaySDK", localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(" toWSJChannel signInfo:");
    localStringBuilder1.append(paramString);
    APLog.i("APWSJChannelPaySDK", localStringBuilder1.toString());
    if (!h())
    {
      APLog.i("APWSJChannelPaySDK", "is not HasWsjSDK");
      APUICommonMethod.a(this.c, "抱歉，暂时不支持该支付方式");
      return;
    }
    try
    {
      this.o.getClass().getMethod("toPay", new Class[] { Activity.class, String.class }).invoke(this.o, new Object[] { paramActivity, paramString });
      this.o.getClass().getMethod("addObserver", new Class[] { Handler.class }).invoke(this.o, new Object[] { this.p });
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      paramString = new StringBuilder();
      paramString.append(" toWSJChannel error:");
      paramString.append(paramActivity.toString());
      APLog.w("APWSJChannelPaySDK", paramString.toString());
    }
  }
  
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
    a(paramContext, paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    this.c = paramContext;
    int i = paramw3.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progressChannelSaveAns ret:");
    localStringBuilder.append(i);
    APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
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
    paramw3 = paramw3.g();
    a((Activity)paramContext, paramw3);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void c(String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this.c);
    localf.b("提示");
    localf.a(paramString);
    localf.b("确定", new b());
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean d(String paramString)
  {
    Object localObject1 = paramString.replace("&sign_type=\"RSA\"", "");
    paramString = new StringBuilder();
    paramString.append("signCheck result:");
    paramString.append((String)localObject1);
    APLog.i("APWSJChannelPaySDK", paramString.toString());
    int i = ((String)localObject1).indexOf("&sign=");
    paramString = new StringBuilder();
    paramString.append("signCheck pos:");
    paramString.append(i);
    APLog.i("APWSJChannelPaySDK", paramString.toString());
    paramString = null;
    Object localObject2;
    if (i > 0)
    {
      paramString = ((String)localObject1).substring(0, i);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("signCheck content:");
      ((StringBuilder)localObject2).append(paramString);
      APLog.i("APWSJChannelPaySDK", ((StringBuilder)localObject2).toString());
      localObject1 = ((String)localObject1).substring(i + 7, ((String)localObject1).length() - 1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("signCheck signData:");
      ((StringBuilder)localObject2).append((String)localObject1);
      APLog.i("APWSJChannelPaySDK", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        localObject2 = e.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRA\nFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQE\nB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5Ksi\nNG9zpgmLCUYuLkxpLQIDAQAB");
        localObject2 = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject2));
        localObject1 = e.a((String)localObject1);
        Signature localSignature = Signature.getInstance("SHA1WithRSA");
        localSignature.initVerify((PublicKey)localObject2);
        localSignature.update(paramString.getBytes());
        boolean bool = localSignature.verify((byte[])localObject1);
        paramString = new StringBuilder();
        paramString.append("signCheck verify:");
        paramString.append(bool);
        APLog.i("APWSJChannelPaySDK", paramString.toString());
        return bool;
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("signCheck error:");
        ((StringBuilder)localObject1).append(paramString.toString());
        APLog.w("APWSJChannelPaySDK", ((StringBuilder)localObject1).toString());
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public class a
    implements Handler.Callback
  {
    public a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      APLog.i("APWSJChannelPaySDK", "handleMessage");
      paramMessage = paramMessage.getData().getString("resultInfo");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultInfo:");
      ((StringBuilder)localObject).append(paramMessage);
      APLog.i("APWSJChannelPaySDK", ((StringBuilder)localObject).toString());
      paramMessage = new APWSJChannel.c(APWSJChannel.this, paramMessage);
      localObject = paramMessage.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Result:");
      localStringBuilder.append(paramMessage.b);
      APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Status:");
      localStringBuilder.append((String)localObject);
      APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
      if (TextUtils.equals((CharSequence)localObject, "9000"))
      {
        if (APWSJChannel.this.d(paramMessage.b))
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.paysucc", p4.p().e().b.saveType, p4.p().e().f.l, null, null);
          APWSJChannel.this.a(null);
        }
        else
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.signerror", p4.p().e().b.saveType, p4.p().e().f.l, "9000", null);
          APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
        }
      }
      else if (TextUtils.equals((CharSequence)localObject, "8000"))
      {
        if (APWSJChannel.this.d(paramMessage.b))
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.payunkown", p4.p().e().b.saveType, p4.p().e().f.l, null, null);
          paramMessage = new Intent();
          paramMessage.putExtra("channel", 12);
          paramMessage.putExtra("state", "unkown");
          paramMessage.setClass(APWSJChannel.this.c, APPayProgressActivity.class);
          APWSJChannel.this.c.startActivity(paramMessage);
        }
        else
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.signerror", p4.p().e().b.saveType, p4.p().e().f.l, "8000", null);
          APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
        }
      }
      else if (TextUtils.equals((CharSequence)localObject, "6001"))
      {
        APDataReportManager.getInstance().insertData("sdk.wsj.paycancel", p4.p().e().b.saveType, p4.p().e().f.l, null, null);
      }
      else
      {
        APDataReportManager.getInstance().insertData("sdk.wsj.payerror", p4.p().e().b.saveType, p4.p().e().f.l, null, null);
        APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
      }
      try
      {
        APWSJChannel.a(APWSJChannel.this).getClass().getMethod("removeObserver", new Class[] { Handler.class }).invoke(APWSJChannel.a(APWSJChannel.this), new Object[] { APWSJChannel.this.p });
        return false;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
      return false;
    }
  }
  
  public class b
    implements c7
  {
    public b() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
    }
  }
  
  public class c
  {
    public String a = "";
    public String b = "";
    public String c = "";
    
    public c(String paramString)
    {
      try
      {
        this$1 = paramString.split(";");
        int j = this$1.length;
        int i = 0;
        while (i < j)
        {
          paramString = this$1[i];
          if (paramString.startsWith("resultStatus")) {
            this.a = a(paramString, "resultStatus");
          }
          if (paramString.startsWith("result")) {
            this.b = a(paramString, "result");
          }
          if (paramString.startsWith("memo")) {
            this.c = a(paramString, "memo");
          }
          i += 1;
        }
        return;
      }
      catch (Exception this$1)
      {
        this$1.printStackTrace();
      }
    }
    
    public final String a(String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("={");
      paramString2 = localStringBuilder.toString();
      return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultStatus={");
      localStringBuilder.append(this.a);
      localStringBuilder.append("};memo={");
      localStringBuilder.append(this.c);
      localStringBuilder.append("};result={");
      localStringBuilder.append(this.b);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.wsj.APWSJChannel
 * JD-Core Version:    0.7.0.1
 */