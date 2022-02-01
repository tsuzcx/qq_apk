package com.pay.paychannel.wx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import midas.x.by;
import midas.x.cg;
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fb;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fp;
import midas.x.fv;
import midas.x.fy;
import midas.x.gy;
import midas.x.hs;
import midas.x.jd;
import midas.x.lh;
import midas.x.lw;

public class APWechatChannel
  extends ff
{
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
      APDataReportManager.getInstance().insertData("sdk.wechatcallback", em.b().n().a.saveType, em.b().n().e.m, String.valueOf(paramInt), localStringBuffer.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    new fp(this.d, paramString1).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  private void a(dt paramdt)
  {
    Object localObject = paramdt.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat context:");
    localStringBuilder.append(this.d);
    APLog.i("APWechatChannel", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat wxappid:");
    localStringBuilder.append((String)localObject);
    APLog.i("APWechatChannel", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat partnerid:");
    ((StringBuilder)localObject).append(paramdt.j());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat url:");
    ((StringBuilder)localObject).append(paramdt.e());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat sign:");
    ((StringBuilder)localObject).append(paramdt.m());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    fy.a().p(false);
    if ((a.a().a(em.b().n().a)) && ("wechat".equals(em.b().n().a.mpInfo.payChannel))) {
      APDataReportManager.getInstance().insertData("sdk.market.pay", em.b().n().a.saveType, null, em.b().n().a.mpInfo.payChannel, fy.a().m());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat isWechatQRCode:");
    ((StringBuilder)localObject).append(fy.a().ai());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    if (fy.a().ai())
    {
      if ((this.d instanceof APChannelQRCodeActivity))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramdt.m());
        this.f.a(0, (Bundle)localObject);
        return;
      }
      b(paramdt);
      return;
    }
    new fp(this.d, paramdt.i()).a(paramdt.i(), paramdt.j(), paramdt.e(), paramdt.l(), paramdt.k(), paramdt.n(), paramdt.m(), this.h);
  }
  
  private void b(final Context paramContext, final fe paramfe, final fd paramfd)
  {
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    locala.a("检测到您当前还未安装微信，是否使用微信扫码支付");
    locala.b("取消", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", em.b().g(), null, "", "payChannel=wechat");
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
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", em.b().g(), null, "", "payChannel=wechat");
        fy.a().t(true);
        paramAnonymousAPAlertDialog.a();
        APWechatChannel.this.a(paramContext, APWechatChannel.a(APWechatChannel.this), paramfd);
      }
    });
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", em.b().g(), null, "", "payChannel=wechat");
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
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", em.b().g(), null, "", "payChannel=wechat");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", em.b().g(), null, "", "payChannel=wechat");
      paramContext.printStackTrace();
      if (paramfe != null) {
        paramfe.a();
      }
    }
  }
  
  private void b(dt paramdt)
  {
    paramdt = paramdt.m();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat signsign url = :");
    ((StringBuilder)localObject).append(paramdt);
    APLog.d("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setClass(this.d, APChannelQRCodeActivity.class);
    ((Intent)localObject).putExtra("payChannel", "wechat");
    ((Intent)localObject).putExtra("payUrl", paramdt);
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
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("wxpayCallBack result:");
    paramBundle.append(paramInt);
    APLog.i("APWechatChannel", paramBundle.toString());
    a(paramInt, "");
    fy.a().p(true);
    if (a.a().a == null) {
      return;
    }
    if (paramInt == 0)
    {
      APLog.i("APWechatPaySDK", "handleMessage result=0");
      if (fy.a().G().equals("0"))
      {
        if ((!TextUtils.isEmpty(fy.a().N())) && (!TextUtils.isEmpty(fy.a().O()))) {
          a(fy.a().N(), fy.a().M(), fy.a().P(), fy.a().O());
        }
        APUICommonMethod.b();
        fv.a(8, 0, 0);
        return;
      }
      if ("APVmallBuyActivity".equals(fy.a().g()))
      {
        hs.a();
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
      paramBundle = em.b().n().b.g();
      by.a().a("wechat", paramBundle, new lw()
      {
        public void a(lh paramAnonymouslh) {}
        
        public void b(lh paramAnonymouslh) {}
        
        public void c(lh paramAnonymouslh) {}
      });
      a(this.d, this.g);
      return;
    }
    if (this.g != null)
    {
      this.g.a(paramInt);
      return;
    }
    if (fv.f())
    {
      APUICommonMethod.b();
      paramBundle = new StringBuilder();
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      fv.a(-1, paramBundle.toString());
      return;
    }
    if ((fb.a().g()) && (!TextUtils.isEmpty(em.b().n().a.saveValue)) && (!em.b().n().a.isCanChange))
    {
      APUICommonMethod.b();
      paramBundle = new StringBuilder();
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      fv.a(-1, paramBundle.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = em.b().n().a.mpInfo.payChannel;
    et localet = em.b().n().b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("wechat")) && (2 != localet.e())) {
      APUICommonMethod.g();
    }
    if (i != 0)
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
    if (localet.e() == 2)
    {
      if ((a.a().e()) && (2 == localet.e()))
      {
        APRecoChannelActivity.b = false;
        paramContext = localet.g();
        by.a().b(paramContext, "3", new lw()
        {
          public void a(lh paramAnonymouslh)
          {
            APUICommonMethod.g();
            paramAnonymouslh = (cg)paramAnonymouslh;
            int i = paramAnonymouslh.T();
            if (i == 0)
            {
              if ((paramAnonymouslh.a() != 2) && (paramAnonymouslh.a() != 3) && (paramAnonymouslh.a() != 4) && (paramAnonymouslh.a() != 5))
              {
                APWechatChannel.b(APWechatChannel.this);
                return;
              }
              fb.a();
              fb.a("wechat").a(null);
              return;
            }
            if (!TextUtils.isEmpty(paramAnonymouslh.U()))
            {
              APWechatChannel.this.a(i, paramAnonymouslh.U(), true);
              return;
            }
            APWechatChannel.b(APWechatChannel.this);
          }
          
          public void b(lh paramAnonymouslh)
          {
            APUICommonMethod.g();
            APWechatChannel.b(APWechatChannel.this);
          }
          
          public void c(lh paramAnonymouslh)
          {
            APUICommonMethod.g();
            APWechatChannel.b(APWechatChannel.this);
          }
        });
      }
    }
    else {
      a(paramdt);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    boolean bool1 = fp.a();
    boolean bool2 = fp.a(paramContext);
    paramBundle = new StringBuilder();
    paramBundle.append("APWechatSDK.isContainsWXSDK() = ");
    paramBundle.append(bool1);
    paramBundle.append(", isWechatInstalled(context) = ");
    paramBundle.append(bool2);
    APLog.d("APWechatChannel", paramBundle.toString());
    fy.a().t(false);
    if (APTools.m())
    {
      fy.a().t(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", em.b().g(), null, "", "payChannel=wechat");
      a(paramContext, paramfe, paramfd);
      return;
    }
    if ((bool1) && (bool2))
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
 * Qualified Name:     com.pay.paychannel.wx.APWechatChannel
 * JD-Core Version:    0.7.0.1
 */