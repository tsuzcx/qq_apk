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
import com.pay.ui.common.APAlertDialog.a;
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
import midas.x.dl;
import midas.x.e;
import midas.x.ec;
import midas.x.ed;
import midas.x.er;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fm;
import midas.x.gn;
import midas.x.hj;
import midas.x.hs;
import midas.x.is;

public class APWSJChannel
  extends ew
{
  public Handler i = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      APLog.i("APWSJChannelPaySDK", "handleMessage");
      paramAnonymousMessage = paramAnonymousMessage.getData().getString("resultInfo");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultInfo:");
      ((StringBuilder)localObject).append(paramAnonymousMessage);
      APLog.i("APWSJChannelPaySDK", ((StringBuilder)localObject).toString());
      paramAnonymousMessage = new APWSJChannel.a(APWSJChannel.this, paramAnonymousMessage);
      localObject = paramAnonymousMessage.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Result:");
      localStringBuilder.append(paramAnonymousMessage.b);
      APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Status:");
      localStringBuilder.append((String)localObject);
      APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
      if (TextUtils.equals((CharSequence)localObject, "9000"))
      {
        if (APWSJChannel.this.b(paramAnonymousMessage.b))
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.paysucc", ed.b().n().a.saveType, ed.b().n().e.m, null, null);
          APWSJChannel.this.a(null);
        }
        else
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.signerror", ed.b().n().a.saveType, ed.b().n().e.m, "9000", null);
          APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
        }
      }
      else if (TextUtils.equals((CharSequence)localObject, "8000"))
      {
        if (APWSJChannel.this.b(paramAnonymousMessage.b))
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.payunkown", ed.b().n().a.saveType, ed.b().n().e.m, null, null);
          paramAnonymousMessage = new Intent();
          paramAnonymousMessage.putExtra("channel", 12);
          paramAnonymousMessage.putExtra("state", "unkown");
          paramAnonymousMessage.setClass(APWSJChannel.a(APWSJChannel.this), APPayProgressActivity.class);
          APWSJChannel.b(APWSJChannel.this).startActivity(paramAnonymousMessage);
        }
        else
        {
          APDataReportManager.getInstance().insertData("sdk.wsj.signerror", ed.b().n().a.saveType, ed.b().n().e.m, "8000", null);
          APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
        }
      }
      else if (TextUtils.equals((CharSequence)localObject, "6001"))
      {
        APDataReportManager.getInstance().insertData("sdk.wsj.paycancel", ed.b().n().a.saveType, ed.b().n().e.m, null, null);
      }
      else
      {
        APDataReportManager.getInstance().insertData("sdk.wsj.payerror", ed.b().n().a.saveType, ed.b().n().e.m, null, null);
        APWSJChannel.a(APWSJChannel.this, "很抱歉,本次支付未成功\n建议更换其他方式进行支付");
      }
      try
      {
        APWSJChannel.c(APWSJChannel.this).getClass().getMethod("removeObserver", new Class[] { Handler.class }).invoke(APWSJChannel.c(APWSJChannel.this), new Object[] { APWSJChannel.this.i });
        return false;
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
      return false;
    }
  });
  private Object j = null;
  
  private void c(String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("提示");
    locala.a(paramString);
    locala.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.w("APWechatPaySDK", "toWSJChannel signInfo is null");
      APUICommonMethod.a(this.d, "系统繁忙,请稍后再试");
      return;
    }
    if (!f())
    {
      APLog.i("APWSJChannelPaySDK", "is not HasWsjSDK");
      paramActivity = new Intent();
      if (hs.b(this.d.getApplicationContext())) {
        paramActivity.setClass(this.d, APX5WebJSBridgeActivity.class);
      } else {
        paramActivity.setClass(this.d, APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("signInfo", paramString);
      localBundle.putSerializable("pageName", hj.w);
      paramActivity.putExtras(localBundle);
      this.d.startActivity(paramActivity);
      return;
    }
    try
    {
      this.j = Class.forName("com.tencent.midas.wsjchannel.APMidasWSJChannelHelper").getMethod("getInstance", new Class[] { Context.class }).invoke((Class)null, new Object[] { this.d });
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
    if (!f())
    {
      APLog.i("APWSJChannelPaySDK", "is not HasWsjSDK");
      APUICommonMethod.a(this.d, "抱歉，暂时不支持该支付方式");
      return;
    }
    try
    {
      this.j.getClass().getMethod("toPay", new Class[] { Activity.class, String.class }).invoke(this.j, new Object[] { paramActivity, paramString });
      this.j.getClass().getMethod("addObserver", new Class[] { Handler.class }).invoke(this.j, new Object[] { this.i });
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
    this.d = paramContext;
    int k = paramdl.R();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progressChannelSaveAns ret:");
    localStringBuilder.append(k);
    APLog.i("APWSJChannelPaySDK", localStringBuilder.toString());
    if (k != 0)
    {
      if (k != 1023)
      {
        a(k, paramdl.S(), false);
        return;
      }
      APUICommonMethod.b();
      fm.a(k, "订单失效");
      return;
    }
    paramdl = paramdl.c();
    a((Activity)paramContext, paramdl);
  }
  
  public boolean b(String paramString)
  {
    Object localObject1 = paramString.replace("&sign_type=\"RSA\"", "");
    paramString = new StringBuilder();
    paramString.append("signCheck result:");
    paramString.append((String)localObject1);
    APLog.i("APWSJChannelPaySDK", paramString.toString());
    int k = ((String)localObject1).indexOf("&sign=");
    paramString = new StringBuilder();
    paramString.append("signCheck pos:");
    paramString.append(k);
    APLog.i("APWSJChannelPaySDK", paramString.toString());
    paramString = null;
    Object localObject2;
    if (k > 0)
    {
      paramString = ((String)localObject1).substring(0, k);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("signCheck content:");
      ((StringBuilder)localObject2).append(paramString);
      APLog.i("APWSJChannelPaySDK", ((StringBuilder)localObject2).toString());
      localObject1 = ((String)localObject1).substring(k + 7, ((String)localObject1).length() - 1);
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
        return false;
      }
    }
    return false;
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    a(paramContext, paramev, parameu);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public class a
  {
    String a = "";
    String b = "";
    String c = "";
    
    public a(String paramString)
    {
      try
      {
        this$1 = paramString.split(";");
        int j = APWSJChannel.this.length;
        int i = 0;
        while (i < j)
        {
          paramString = APWSJChannel.this[i];
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
        APWSJChannel.this.printStackTrace();
      }
    }
    
    private String a(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.wsj.APWSJChannel
 * JD-Core Version:    0.7.0.1
 */