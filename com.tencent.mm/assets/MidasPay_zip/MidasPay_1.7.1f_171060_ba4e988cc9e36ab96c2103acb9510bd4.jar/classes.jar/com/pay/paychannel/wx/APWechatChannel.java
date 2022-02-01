package com.pay.paychannel.wx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.channel.APChannelQRCodeActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.bs;
import midas.x.ca;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.er;
import midas.x.es;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fg;
import midas.x.fm;
import midas.x.fp;
import midas.x.gn;
import midas.x.hh;
import midas.x.is;
import midas.x.jw;
import midas.x.kl;

public class APWechatChannel
  extends ew
{
  ResultReceiver i = new ResultReceiver(new Handler())
  {
    public void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wxpayCallbackReceiver resultCode = ");
      localStringBuilder.append(paramAnonymousInt);
      APLog.i("APWechatChannel", localStringBuilder.toString());
      APWechatChannel.a(APWechatChannel.this, paramAnonymousInt, paramAnonymousBundle);
    }
  };
  
  private void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("wxpayCallBack result:");
    paramBundle.append(paramInt);
    APLog.i("APWechatChannel", paramBundle.toString());
    a(paramInt, "");
    fp.a().p(true);
    if (a.a().a == null) {
      return;
    }
    if (paramInt == 0)
    {
      APLog.i("APWechatPaySDK", "handleMessage result=0");
      if (fp.a().G().equals("0"))
      {
        if ((!TextUtils.isEmpty(fp.a().N())) && (!TextUtils.isEmpty(fp.a().O()))) {
          a(fp.a().N(), fp.a().M(), fp.a().P(), fp.a().O());
        }
        APUICommonMethod.b();
        fm.a(8, 0, 0);
        return;
      }
      if ("APVmallBuyActivity".equals(fp.a().g()))
      {
        hh.a();
        return;
      }
      a(null);
      return;
    }
    if (paramInt == -1)
    {
      a(this.d, 210001, "系统繁忙,请稍后再试(100-100--1)", this.g);
      return;
    }
    if (paramInt == -2)
    {
      a(this.d, this.g);
      return;
    }
    if (this.g != null)
    {
      this.g.a(paramInt);
      return;
    }
    if (fm.f())
    {
      APUICommonMethod.b();
      paramBundle = new StringBuilder();
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      fm.a(-1, paramBundle.toString());
      return;
    }
    if ((es.a().g()) && (!TextUtils.isEmpty(ed.b().n().a.saveValue)) && (!ed.b().n().a.isCanChange))
    {
      APUICommonMethod.b();
      paramBundle = new StringBuilder();
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      fm.a(-1, paramBundle.toString());
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("code=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&");
    localStringBuffer.append("errorMsg=");
    localStringBuffer.append(paramString);
    try
    {
      APDataReportManager.getInstance().insertData("sdk.wechatcallback", ed.b().n().a.saveType, ed.b().n().e.m, String.valueOf(paramInt), localStringBuffer.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    new fg(this.d, paramString1).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(dl paramdl)
  {
    Object localObject = paramdl.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat wxappid:");
    localStringBuilder.append((String)localObject);
    APLog.i("APWechatChannel", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat partnerid:");
    ((StringBuilder)localObject).append(paramdl.h());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat url:");
    ((StringBuilder)localObject).append(paramdl.c());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat sign:");
    ((StringBuilder)localObject).append(paramdl.k());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    fp.a().p(false);
    if ((a.a().a(ed.b().n().a)) && ("wechat".equals(ed.b().n().a.mpInfo.payChannel))) {
      APDataReportManager.getInstance().insertData("sdk.market.pay", ed.b().n().a.saveType, null, ed.b().n().a.mpInfo.payChannel, fp.a().m());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat isWechatQRCode:");
    ((StringBuilder)localObject).append(fp.a().ai());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    if (fp.a().ai())
    {
      if ((this.d instanceof APChannelQRCodeActivity))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramdl.k());
        this.f.a(0, (Bundle)localObject);
        return;
      }
      b(paramdl);
      return;
    }
    new fg(this.d, paramdl.g()).a(paramdl.g(), paramdl.h(), paramdl.c(), paramdl.j(), paramdl.i(), paramdl.l(), paramdl.k(), this.i);
  }
  
  private void b(final Context paramContext, final ev paramev, final eu parameu)
  {
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    locala.a("检测到您当前还未安装微信，是否使用微信扫码支付");
    locala.b("取消", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", ed.b().g(), null, "", "payChannel=wechat");
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
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", ed.b().g(), null, "", "payChannel=wechat");
        fp.a().t(true);
        paramAnonymousAPAlertDialog.a();
        APWechatChannel.this.a(paramContext, APWechatChannel.a(APWechatChannel.this), parameu);
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", ed.b().g(), null, "", "payChannel=wechat");
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
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", ed.b().g(), null, "", "payChannel=wechat");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", ed.b().g(), null, "", "payChannel=wechat");
      paramContext.printStackTrace();
      if (paramev != null) {
        paramev.a();
      }
    }
  }
  
  private void b(dl paramdl)
  {
    paramdl = paramdl.k();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat signsign url = :");
    ((StringBuilder)localObject).append(paramdl);
    APLog.d("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setClass(this.d, APChannelQRCodeActivity.class);
    ((Intent)localObject).putExtra("payChannel", "wechat");
    ((Intent)localObject).putExtra("payUrl", paramdl);
    this.d.startActivity((Intent)localObject);
    if (this.g != null) {
      this.g.a();
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this.d, APPayProgressActivity.class);
    localIntent.putExtra("channel", 8);
    this.d.startActivity(localIntent);
    ((Activity)this.d).finish();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(j);
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = ed.b().n().a.mpInfo.payChannel;
    ek localek = ed.b().n().b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("wechat")) && (2 != localek.e())) {
      APUICommonMethod.g();
    }
    if (j != 0)
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
    if (localek.e() == 2)
    {
      if ((a.a().e()) && (2 == localek.e()))
      {
        APRecoChannelActivity.b = false;
        paramContext = localek.g();
        bs.a().a(paramContext, "3", new kl()
        {
          public void a(jw paramAnonymousjw)
          {
            APUICommonMethod.g();
            paramAnonymousjw = (ca)paramAnonymousjw;
            int i = paramAnonymousjw.R();
            if (i == 0)
            {
              if ((paramAnonymousjw.a() != 2) && (paramAnonymousjw.a() != 3) && (paramAnonymousjw.a() != 4) && (paramAnonymousjw.a() != 5))
              {
                APWechatChannel.b(APWechatChannel.this);
                return;
              }
              es.a();
              es.a("wechat").a(null);
              return;
            }
            if (!TextUtils.isEmpty(paramAnonymousjw.S()))
            {
              APWechatChannel.this.a(i, paramAnonymousjw.S(), true);
              return;
            }
            APWechatChannel.b(APWechatChannel.this);
          }
          
          public void b(jw paramAnonymousjw)
          {
            APUICommonMethod.g();
            APWechatChannel.b(APWechatChannel.this);
          }
          
          public void c(jw paramAnonymousjw)
          {
            APUICommonMethod.g();
            APWechatChannel.b(APWechatChannel.this);
          }
        });
      }
    }
    else {
      a(paramdl);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    boolean bool1 = fg.a();
    boolean bool2 = fg.a(paramContext);
    paramBundle = new StringBuilder();
    paramBundle.append("APWechatSDK.isContainsWXSDK() = ");
    paramBundle.append(bool1);
    paramBundle.append(", isWechatInstalled(context) = ");
    paramBundle.append(bool2);
    APLog.d("APWechatChannel", paramBundle.toString());
    fp.a().t(false);
    if (APTools.m())
    {
      fp.a().t(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", ed.b().g(), null, "", "payChannel=wechat");
      a(paramContext, paramev, parameu);
      return;
    }
    if ((bool1) && (bool2))
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
 * Qualified Name:     com.pay.paychannel.wx.APWechatChannel
 * JD-Core Version:    0.7.0.1
 */