package com.pay.paychannel.qqwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
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
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.er;
import midas.x.es;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fe;
import midas.x.fm;
import midas.x.fp;
import midas.x.gn;
import midas.x.i;
import midas.x.is;

public class APQQWalletChannel
  extends ew
{
  ResultReceiver i = new ResultReceiver(new Handler())
  {
    public void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qqpayCallbackReceiver resultCode = ");
      localStringBuilder.append(paramAnonymousInt);
      localStringBuilder.append(" resultData = ");
      localStringBuilder.append(paramAnonymousBundle);
      APLog.i("APQDChannel", localStringBuilder.toString());
      APQQWalletChannel.a(APQQWalletChannel.this, paramAnonymousInt, paramAnonymousBundle);
    }
  };
  
  private void a(int paramInt, Bundle paramBundle)
  {
    APLog.i("APQQWalletSDK", "qqpayCallBack");
    b(paramBundle);
    fp.a().q(true);
    if (a.a().a == null) {
      return;
    }
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      int j = paramBundle.getInt("retCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qqpayCallBack retCode = ");
      localStringBuilder.append(j);
      APLog.i("APQQWalletSDK", localStringBuilder.toString());
      if (bool)
      {
        APLog.i("APQQWalletSDK", "qqpayCallBack ret=0");
        a(null);
        return;
      }
      if (j == -1)
      {
        a(this.d, this.g);
        return;
      }
      if (j == -11)
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
        a(this.d, j + 230000, paramBundle.getString("retMsg"), this.g);
      }
    }
    else
    {
      if (this.g != null)
      {
        this.g.a(paramInt);
        return;
      }
      if (fm.f())
      {
        APUICommonMethod.b();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        fm.a(-1, paramBundle.toString());
        return;
      }
      if ((es.a().g()) && (!TextUtils.isEmpty(ed.b().n().a.saveValue)) && (!ed.b().n().a.isCanChange))
      {
        APUICommonMethod.b();
        paramBundle = new StringBuilder();
        paramBundle.append("qqwallet result code:");
        paramBundle.append(paramInt);
        fm.a(-1, paramBundle.toString());
      }
    }
  }
  
  private void a(dl paramdl)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet appid:");
    ((StringBuilder)localObject).append(paramdl.m());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet token:");
    ((StringBuilder)localObject).append(paramdl.v());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQQWallet sign:");
    ((StringBuilder)localObject).append(paramdl.r());
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    if (fp.a().aj())
    {
      if ((this.d instanceof APChannelQRCodeActivity))
      {
        paramdl = b(paramdl);
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramdl);
        this.f.a(0, (Bundle)localObject);
        return;
      }
      paramdl = b(paramdl);
      localObject = new Intent();
      ((Intent)localObject).setClass(this.d, APChannelQRCodeActivity.class);
      ((Intent)localObject).putExtra("payChannel", "qqwallet");
      ((Intent)localObject).putExtra("payUrl", paramdl);
      this.d.startActivity((Intent)localObject);
      if (this.g != null) {
        this.g.a();
      }
    }
    else
    {
      long l1 = i.b(paramdl.p());
      long l2 = i.b(paramdl.o());
      localObject = new Bundle();
      ((Bundle)localObject).putString("appId", paramdl.m());
      ((Bundle)localObject).putString("bargainorId", paramdl.q());
      ((Bundle)localObject).putString("tokenId", paramdl.v());
      ((Bundle)localObject).putString("nonce", paramdl.n());
      ((Bundle)localObject).putInt("serialNumber", (int)(l1 / 10000L));
      ((Bundle)localObject).putLong("timeStamp", l2);
      ((Bundle)localObject).putString("sig", paramdl.r());
      ((Bundle)localObject).putString("sigType", paramdl.s());
      ((Bundle)localObject).putString("pubAcc", paramdl.t());
      ((Bundle)localObject).putString("pubAccHint", paramdl.u());
      fp.a().q(false);
      new fe(this.d, paramdl.m()).a((Bundle)localObject, this.i);
    }
  }
  
  private String b(dl paramdl)
  {
    String str = APAppDataInterface.singleton().e();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("_wv", "1027");
    ((HashMap)localObject).put("pf", ed.b().n().a.pf);
    ((HashMap)localObject).put("usr", ed.b().n().a.openId);
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
    ((HashMap)localObject).put("uuid", fp.a().i());
    ((HashMap)localObject).put("id", fp.a().ab());
    ((HashMap)localObject).put("scan", "1");
    ((HashMap)localObject).put("t", paramdl.v());
    ((HashMap)localObject).put("a", paramdl.m());
    ((HashMap)localObject).put("b", paramdl.q());
    paramdl = new StringBuilder();
    paramdl.append("http://pay.qq.com/h5/mqqPay.shtml?");
    paramdl.append(APTools.a((HashMap)localObject));
    paramdl = paramdl.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toQRCodePay url = ");
    ((StringBuilder)localObject).append(paramdl);
    APLog.d("APQQWalletChannel", ((StringBuilder)localObject).toString());
    return paramdl;
  }
  
  private void b(final Context paramContext, final ev paramev, final eu parameu)
  {
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    locala.a("检测到您当前还未安装QQ，是否使用QQ扫码支付");
    locala.b("取消", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", ed.b().g(), null, "", "payChannel=qqwallet");
        if (!a.a().f)
        {
          paramAnonymousAPAlertDialog.a();
          if (paramev != null) {
            paramev.a();
          }
          APUICommonMethod.b();
          fm.a(2, "");
          return;
        }
        paramAnonymousAPAlertDialog.a();
        if (paramev != null) {
          paramev.a();
        }
      }
    });
    locala.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", ed.b().g(), null, "", "payChannel=qqwallet");
        fp.a().u(true);
        paramAnonymousAPAlertDialog.a();
        APQQWalletChannel.this.a(paramContext, APQQWalletChannel.a(APQQWalletChannel.this), parameu);
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", ed.b().g(), null, "", "payChannel=qqwallet");
          if (!a.a().f)
          {
            APUICommonMethod.b();
            fm.a(2, "");
            return;
          }
          if (paramev != null) {
            paramev.a();
          }
        }
      }
    });
    try
    {
      locala.c();
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", ed.b().g(), null, "", "payChannel=qqwallet");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", ed.b().g(), null, "", "payChannel=qqwallet");
      paramContext.printStackTrace();
      if (paramev != null) {
        paramev.a();
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      int j = paramBundle.getInt("retCode");
      paramBundle = paramBundle.getString("retMsg");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("code=");
      localStringBuffer.append(j);
      localStringBuffer.append("&");
      localStringBuffer.append("errorMsg=");
      localStringBuffer.append(paramBundle);
      localStringBuffer.append("&");
      localStringBuffer.append("isresult=");
      localStringBuffer.append(bool);
      try
      {
        APDataReportManager.getInstance().insertData("sdk.qqwalletcallback", ed.b().n().a.saveType, ed.b().n().e.m, String.valueOf(j), localStringBuffer.toString());
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
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
    int j = paramdl.R();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progressChannelSaveAns ret:");
    localStringBuilder.append(j);
    APLog.i("APQDChannel", localStringBuilder.toString());
    if (j != 0)
    {
      if (j != 1023)
      {
        if ((paramContext instanceof APChannelQRCodeActivity))
        {
          paramContext = new Bundle();
          paramContext.putString("errMsg", paramdl.T());
          this.f.a(paramdl.R(), paramContext);
          return;
        }
        a(j, paramdl.S(), false);
        return;
      }
      APUICommonMethod.b();
      fm.a(j, "订单失效");
      return;
    }
    a(paramdl);
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    fp.a().u(false);
    if (APTools.m())
    {
      fp.a().u(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", ed.b().g(), null, "", "payChannel=qqwallet");
      a(paramContext, paramev, parameu);
      return;
    }
    boolean bool1 = fe.b();
    boolean bool2 = fe.a();
    boolean bool3 = fe.a(paramContext);
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
      a(paramContext, paramev, parameu);
      return;
    }
    b(paramContext, paramev, parameu);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.qqwallet.APQQWalletChannel
 * JD-Core Version:    0.7.0.1
 */