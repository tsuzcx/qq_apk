package com.pay.paychannel.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.APPayResponse;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.d5;
import midas.x.e5;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.s5;
import midas.x.w3;
import midas.x.z5;

public class APUnionPayChannel
  extends i5
{
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = "支付失败！";
    APLog.i("APUnionPayChannel onActivityResult", "arg0");
    if (paramIntent == null) {
      return;
    }
    APPayResponse localAPPayResponse = new APPayResponse();
    try
    {
      paramIntent = paramIntent.getExtras().getString("pay_result");
      if (paramIntent.equalsIgnoreCase("success"))
      {
        localAPPayResponse.resultCode = 0;
        paramIntent = "支付成功！";
      }
      else if (paramIntent.equalsIgnoreCase("fail"))
      {
        localAPPayResponse.resultCode = -1;
        paramIntent = (Intent)localObject;
      }
      else if (paramIntent.equalsIgnoreCase("cancel"))
      {
        localAPPayResponse.resultCode = 2;
        paramIntent = "用户取消了支付";
      }
      else
      {
        paramIntent = "";
      }
    }
    catch (Exception paramIntent)
    {
      label104:
      break label104;
    }
    localAPPayResponse.resultCode = -1;
    paramIntent = (Intent)localObject;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("msg:");
    ((StringBuilder)localObject).append(paramIntent);
    APLog.i("APUnionPayChannel onActivityResult", ((StringBuilder)localObject).toString());
    a(localAPPayResponse.resultCode, null);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (a.r().a == null) {
      return;
    }
    if (paramInt == 0)
    {
      a(null);
    }
    else if (paramInt == -1)
    {
      a(this.c, -1, "系统繁忙,请稍后再试(100-100--1)", this.f);
    }
    else if (paramInt == 2)
    {
      b(this.c, this.f);
    }
    else
    {
      paramBundle = this.f;
      if (paramBundle != null)
      {
        paramBundle.a(paramInt);
      }
      else if (z5.d())
      {
        APUICommonMethod.f();
        paramBundle = new StringBuilder();
        paramBundle.append("unionPay result code:");
        paramBundle.append(paramInt);
        z5.a(-1, paramBundle.toString());
      }
      else if ((e5.h().e()) && (!TextUtils.isEmpty(p4.p().e().b.saveValue)) && (!p4.p().e().b.isCanChange))
      {
        APUICommonMethod.f();
        paramBundle = new StringBuilder();
        paramBundle.append("unionPay result code:");
        paramBundle.append(paramInt);
        z5.a(-1, paramBundle.toString());
      }
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.unionpaycallback", p4.p().e().b.saveType, p4.p().e().f.l, String.valueOf(paramInt), null);
      return;
    }
    catch (Exception paramBundle) {}
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
    if (s5.a(paramContext))
    {
      a(paramContext, paramh5, paramg5);
      return;
    }
    if (paramh5 != null) {
      paramh5.a();
    }
    paramBundle = p4.p().e().b.mpInfo.payChannel;
    if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("wechat_quickpass")))
    {
      APUICommonMethod.b();
      z5.a(-1, -1, "抱歉，你未安装银联云闪付客户端");
    }
    APUICommonMethod.a(paramContext, "抱歉，你未安装银联云闪付客户端");
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(i);
    APLog.i("APUnionPayChannel", paramContext.toString());
    paramContext = p4.p().e().b.mpInfo.payChannel;
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals("wechat_quickpass"))) {
      APUICommonMethod.b();
    }
    if (i != 0)
    {
      a(i, paramw3.f(), false);
      return;
    }
    a(paramw3);
  }
  
  public final void a(w3 paramw3)
  {
    Object localObject = this.c;
    if ((localObject != null) && ((localObject instanceof Activity)))
    {
      Activity localActivity = (Activity)localObject;
      if (!"release".equals(APAppDataInterface.singleton().h())) {
        localObject = "01";
      } else {
        localObject = "00";
      }
      if (s5.a(localActivity, paramw3.R(), paramw3.S(), paramw3.Q(), (String)localObject) == -1) {
        a(this.c, -1, "启动云闪付失败", this.f);
      }
    }
    else
    {
      a(this.c, -1, "启动云闪付失败", this.f);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.unionpay.APUnionPayChannel
 * JD-Core Version:    0.7.0.1
 */