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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fb;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fn;
import midas.x.fv;
import midas.x.fy;
import midas.x.gy;
import midas.x.i;
import midas.x.jd;

public class APQQWalletChannel
  extends ff
{
  private void a(dt paramdt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet appid:");
    ((StringBuilder)localObject).append(paramdt.o());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet token:");
    ((StringBuilder)localObject).append(paramdt.x());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet sign:");
    ((StringBuilder)localObject).append(paramdt.t());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    if (fy.a().aj())
    {
      if ((this.d instanceof APChannelQRCodeActivity))
      {
        paramdt = b(paramdt);
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramdt);
        this.f.a(0, (Bundle)localObject);
        return;
      }
      paramdt = b(paramdt);
      localObject = new Intent();
      ((Intent)localObject).setClass(this.d, APChannelQRCodeActivity.class);
      ((Intent)localObject).putExtra("payChannel", "qqwallet");
      ((Intent)localObject).putExtra("payUrl", paramdt);
      this.d.startActivity((Intent)localObject);
      if (this.g != null) {
        this.g.a();
      }
    }
    else
    {
      long l1 = i.b(paramdt.r());
      long l2 = i.b(paramdt.q());
      localObject = new Bundle();
      ((Bundle)localObject).putString("appId", paramdt.o());
      ((Bundle)localObject).putString("bargainorId", paramdt.s());
      ((Bundle)localObject).putString("tokenId", paramdt.x());
      ((Bundle)localObject).putString("nonce", paramdt.p());
      ((Bundle)localObject).putInt("serialNumber", (int)(l1 / 10000L));
      ((Bundle)localObject).putLong("timeStamp", l2);
      ((Bundle)localObject).putString("sig", paramdt.t());
      ((Bundle)localObject).putString("sigType", paramdt.u());
      ((Bundle)localObject).putString("pubAcc", paramdt.v());
      ((Bundle)localObject).putString("pubAccHint", paramdt.w());
      fy.a().q(false);
      new fn(this.d, paramdt.o()).a((Bundle)localObject, this.h);
    }
  }
  
  private String b(dt paramdt)
  {
    String str = APAppDataInterface.singleton().e();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("_wv", "1027");
    ((HashMap)localObject).put("pf", em.b().n().a.pf);
    ((HashMap)localObject).put("usr", em.b().n().a.openId);
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
    ((HashMap)localObject).put("uuid", fy.a().i());
    ((HashMap)localObject).put("id", fy.a().ab());
    ((HashMap)localObject).put("scan", "1");
    ((HashMap)localObject).put("t", paramdt.x());
    ((HashMap)localObject).put("a", paramdt.o());
    ((HashMap)localObject).put("b", paramdt.s());
    paramdt = new StringBuilder();
    paramdt.append("http://pay.qq.com/h5/mqqPay.shtml?");
    paramdt.append(APTools.a((HashMap)localObject));
    paramdt = paramdt.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQRCodePay url = ");
    ((StringBuilder)localObject).append(paramdt);
    APLog.d("APQQWalletChannel", ((StringBuilder)localObject).toString());
    return paramdt;
  }
  
  private void b(final Context paramContext, final fe paramfe, final fd paramfd)
  {
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    locala.a("检测到您当前还未安装QQ，是否使用QQ扫码支付");
    locala.b("取消", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", em.b().g(), null, "", "payChannel=qqwallet");
        if (!a.a().f)
        {
          paramAnonymousAPAlertDialog.a();
          if (paramfe != null) {
            paramfe.a();
          }
          APUICommonMethod.b();
          fv.a(2, "");
          return;
        }
        paramAnonymousAPAlertDialog.a();
        if (paramfe != null) {
          paramfe.a();
        }
      }
    });
    locala.a("确定", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", em.b().g(), null, "", "payChannel=qqwallet");
        fy.a().u(true);
        paramAnonymousAPAlertDialog.a();
        APQQWalletChannel.this.a(paramContext, APQQWalletChannel.a(APQQWalletChannel.this), paramfd);
      }
    });
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", em.b().g(), null, "", "payChannel=qqwallet");
          if (!a.a().f)
          {
            APUICommonMethod.b();
            fv.a(2, "");
            return;
          }
          if (paramfe != null) {
            paramfe.a();
          }
        }
      }
    });
    try
    {
      locala.c();
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", em.b().g(), null, "", "payChannel=qqwallet");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", em.b().g(), null, "", "payChannel=qqwallet");
      paramContext.printStackTrace();
      if (paramfe != null) {
        paramfe.a();
      }
    }
  }
  
  private void b(Bundle paramBundle)
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
        APDataReportManager.getInstance().insertData("sdk.qqwalletcallback", em.b().n().a.saveType, em.b().n().e.m, String.valueOf(i), localStringBuffer.toString());
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    APLog.i("APQQWalletSDK", "qqpayCallBack");
    b(paramBundle);
    fy.a().q(true);
    if (a.a().a == null) {
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
        a(this.d, this.g);
        return;
      }
      if (i == -11)
      {
        a(this.d, this.g);
        paramBundle = new StringBuilder();
        paramBundle.append("qqpayCallBack -11:");
        paramBundle.append(this.g);
        APLog.i("APQQWalletSDK", paramBundle.toString());
        if (this.g != null) {
          this.g.a(paramInt);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage user fail msg:");
        localStringBuilder.append(paramBundle.getString("retMsg"));
        APLog.i("APQQWalletSDK", localStringBuilder.toString());
        a(this.d, i + 230000, paramBundle.getString("retMsg"), this.g);
      }
    }
    else
    {
      if (this.g != null)
      {
        this.g.a(paramInt);
        return;
      }
      if (fv.f())
      {
        APUICommonMethod.b();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        fv.a(-1, paramBundle.toString());
        return;
      }
      if ((fb.a().g()) && (!TextUtils.isEmpty(em.b().n().a.saveValue)) && (!em.b().n().a.isCanChange))
      {
        APUICommonMethod.b();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        fv.a(-1, paramBundle.toString());
      }
    }
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
          paramContext.putString("errMsg", paramdt.V());
          this.f.a(paramdt.T(), paramContext);
          return;
        }
        a(i, paramdt.U(), false);
        return;
      }
      APUICommonMethod.b();
      fv.a(i, "订单失效");
      return;
    }
    a(paramdt);
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    fy.a().u(false);
    if (APTools.m())
    {
      fy.a().u(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", em.b().g(), null, "", "payChannel=qqwallet");
      a(paramContext, paramfe, paramfd);
      return;
    }
    boolean bool1 = fn.b();
    boolean bool2 = fn.a();
    boolean bool3 = fn.a(paramContext);
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
      a(paramContext, paramfe, paramfd);
      return;
    }
    b(paramContext, paramfe, paramfd);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqwallet.APQQWalletChannel
 * JD-Core Version:    0.7.0.1
 */