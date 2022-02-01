package com.pay.paychannel.qqwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.channel.APChannelQRCodeActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.e5;
import midas.x.g5;
import midas.x.h5;
import midas.x.i;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.q5;
import midas.x.r1;
import midas.x.w3;
import midas.x.z5;

public class APQQWalletChannel
  extends i5
{
  public final String a(w3 paramw3)
  {
    String str = APAppDataInterface.singleton().h();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("_wv", "1027");
    ((HashMap)localObject).put("pf", p4.p().e().b.pf);
    ((HashMap)localObject).put("usr", p4.p().e().b.openId);
    if ("release".equals(str)) {
      ((HashMap)localObject).put("env", "live");
    } else if ("test".equals(str)) {
      ((HashMap)localObject).put("env", "sandbox");
    } else if ("dev".equals(str)) {
      ((HashMap)localObject).put("env", "dev");
    } else if ("testing".equals(str)) {
      ((HashMap)localObject).put("env", "live");
    } else {
      ((HashMap)localObject).put("env", "live");
    }
    ((HashMap)localObject).put("uuid", c6.s0().Z());
    ((HashMap)localObject).put("id", c6.s0().a());
    ((HashMap)localObject).put("scan", "1");
    ((HashMap)localObject).put("t", paramw3.K());
    ((HashMap)localObject).put("a", paramw3.C());
    ((HashMap)localObject).put("b", paramw3.z());
    paramw3 = new StringBuilder();
    paramw3.append("http://pay.qq.com/h5/mqqPay.shtml?");
    paramw3.append(APTools.a((HashMap)localObject));
    paramw3 = paramw3.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQRCodePay url = ");
    ((StringBuilder)localObject).append(paramw3);
    APLog.d("APQQWalletChannel", ((StringBuilder)localObject).toString());
    return paramw3;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    APLog.i("APQQWalletSDK", "qqpayCallBack");
    c(paramBundle);
    c6.s0().f(true);
    if (a.r().a == null) {
      return;
    }
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      int i = paramBundle.getInt("retCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qqpayCallBack retCode = ");
      localStringBuilder.append(i);
      APLog.i("APQQWalletSDK", localStringBuilder.toString());
      if (bool)
      {
        APLog.i("APQQWalletSDK", "qqpayCallBack ret=0");
        a(null);
        return;
      }
      if (i == -1)
      {
        b(this.c, this.f);
        return;
      }
      if (i == -11)
      {
        b(this.c, this.f);
        paramBundle = new StringBuilder();
        paramBundle.append("qqpayCallBack -11:");
        paramBundle.append(this.f);
        APLog.i("APQQWalletSDK", paramBundle.toString());
        paramBundle = this.f;
        if (paramBundle != null) {
          paramBundle.a(paramInt);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage user fail msg:");
        localStringBuilder.append(paramBundle.getString("retMsg"));
        APLog.i("APQQWalletSDK", localStringBuilder.toString());
        a(this.c, i + 230000, paramBundle.getString("retMsg"), this.f);
      }
    }
    else
    {
      paramBundle = this.f;
      if (paramBundle != null)
      {
        paramBundle.a(paramInt);
        return;
      }
      if (z5.d())
      {
        APUICommonMethod.f();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        z5.a(-1, paramBundle.toString());
        return;
      }
      if ((e5.h().e()) && (!TextUtils.isEmpty(p4.p().e().b.saveValue)) && (!p4.p().e().b.isCanChange))
      {
        APUICommonMethod.f();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        z5.a(-1, paramBundle.toString());
      }
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
    c6.s0().l(false);
    if (APTools.n())
    {
      c6.s0().l(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", p4.p().g(), null, "", "payChannel=qqwallet");
      a(paramContext, paramh5, paramg5);
      return;
    }
    boolean bool1 = q5.b();
    boolean bool2 = q5.a();
    boolean bool3 = q5.a(paramContext);
    paramBundle = new StringBuilder();
    paramBundle.append("APQQWalletSDK.isIncludeQQJar() = ");
    paramBundle.append(bool1);
    paramBundle.append(", isContainsQQActivity() = ");
    paramBundle.append(bool2);
    paramBundle.append(", isQQInstalled(context) = ");
    paramBundle.append(bool3);
    APLog.d("APQQWalletChannel", paramBundle.toString());
    if ((bool1) && (bool2) && (bool3))
    {
      a(paramContext, paramh5, paramg5);
      return;
    }
    b(paramContext, paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progressChannelSaveAns ret:");
    localStringBuilder.append(i);
    APLog.i("APQDChannel", localStringBuilder.toString());
    if (i != 0)
    {
      if (i != 1023)
      {
        if ((paramContext instanceof APChannelQRCodeActivity))
        {
          paramContext = new Bundle();
          paramContext.putString("errMsg", paramw3.c());
          this.e.a(paramw3.d(), paramContext);
          return;
        }
        a(i, paramw3.f(), false);
        return;
      }
      APUICommonMethod.f();
      z5.a(i, "订单失效");
      return;
    }
    b(paramw3);
  }
  
  public final void b(final Context paramContext, final h5 paramh5, final g5 paramg5)
  {
    if ((r1.i()) && (r1.h()))
    {
      c6.s0().l(true);
      a(paramContext, this.f, paramg5);
      return;
    }
    APAlertDialog.f localf = new APAlertDialog.f(paramContext);
    localf.b("提示");
    localf.a("检测到您当前还未安装QQ，是否使用QQ扫码支付");
    localf.a("取消", new a(paramh5));
    localf.b("确定", new b(paramContext, paramg5));
    localf.b(new c(paramh5));
    try
    {
      localf.b();
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", p4.p().g(), null, "", "payChannel=qqwallet");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", p4.p().g(), null, "", "payChannel=qqwallet");
      paramContext.printStackTrace();
      if (paramh5 != null) {
        paramh5.a();
      }
    }
  }
  
  public final void b(w3 paramw3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet appid:");
    ((StringBuilder)localObject).append(paramw3.C());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet token:");
    ((StringBuilder)localObject).append(paramw3.K());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet sign:");
    ((StringBuilder)localObject).append(paramw3.H());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    if (c6.s0().j0())
    {
      if ((this.c instanceof APChannelQRCodeActivity))
      {
        paramw3 = a(paramw3);
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramw3);
        this.e.a(0, (Bundle)localObject);
        return;
      }
      paramw3 = a(paramw3);
      localObject = new Intent();
      ((Intent)localObject).setClass(this.c, APChannelQRCodeActivity.class);
      ((Intent)localObject).putExtra("payChannel", "qqwallet");
      ((Intent)localObject).putExtra("payUrl", paramw3);
      this.c.startActivity((Intent)localObject);
      paramw3 = this.f;
      if (paramw3 != null) {
        paramw3.a();
      }
    }
    else
    {
      long l1 = i.c(paramw3.G());
      long l2 = i.c(paramw3.J());
      localObject = new Bundle();
      ((Bundle)localObject).putString("appId", paramw3.C());
      ((Bundle)localObject).putString("bargainorId", paramw3.z());
      ((Bundle)localObject).putString("tokenId", paramw3.K());
      ((Bundle)localObject).putString("nonce", paramw3.D());
      ((Bundle)localObject).putInt("serialNumber", (int)(l1 / 10000L));
      ((Bundle)localObject).putLong("timeStamp", l2);
      ((Bundle)localObject).putString("sig", paramw3.H());
      ((Bundle)localObject).putString("sigType", paramw3.I());
      ((Bundle)localObject).putString("pubAcc", paramw3.E());
      ((Bundle)localObject).putString("pubAccHint", paramw3.F());
      c6.s0().f(false);
      new q5(this.c, paramw3.C()).a((Bundle)localObject, this.g);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      int i = paramBundle.getInt("retCode");
      paramBundle = paramBundle.getString("retMsg");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("code=");
      localStringBuffer.append(i);
      localStringBuffer.append("&");
      localStringBuffer.append("errorMsg=");
      localStringBuffer.append(paramBundle);
      localStringBuffer.append("&");
      localStringBuffer.append("isresult=");
      localStringBuffer.append(bool);
      try
      {
        APDataReportManager.getInstance().insertData("sdk.qqwalletcallback", p4.p().e().b.saveType, p4.p().e().f.l, String.valueOf(i), localStringBuffer.toString());
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public class a
    implements c7
  {
    public a(h5 paramh5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", p4.p().g(), null, "", "payChannel=qqwallet");
      if (!a.r().f)
      {
        paramAPAlertDialog.f();
        paramAPAlertDialog = paramh5;
        if (paramAPAlertDialog != null) {
          paramAPAlertDialog.a();
        }
        APUICommonMethod.f();
        z5.a(2, "");
        return;
      }
      paramAPAlertDialog.f();
      paramAPAlertDialog = paramh5;
      if (paramAPAlertDialog != null) {
        paramAPAlertDialog.a();
      }
    }
  }
  
  public class b
    implements c7
  {
    public b(Context paramContext, g5 paramg5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", p4.p().g(), null, "", "payChannel=qqwallet");
      c6.s0().l(true);
      paramAPAlertDialog.f();
      paramAPAlertDialog = APQQWalletChannel.this;
      paramAPAlertDialog.a(paramContext, APQQWalletChannel.a(paramAPAlertDialog), paramg5);
    }
  }
  
  public class c
    implements c7
  {
    public c(h5 paramh5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", p4.p().g(), null, "", "payChannel=qqwallet");
        if (!a.r().f)
        {
          APUICommonMethod.f();
          z5.a(2, "");
          return;
        }
        paramAPAlertDialog = paramh5;
        if (paramAPAlertDialog != null) {
          paramAPAlertDialog.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqwallet.APQQWalletChannel
 * JD-Core Version:    0.7.0.1
 */