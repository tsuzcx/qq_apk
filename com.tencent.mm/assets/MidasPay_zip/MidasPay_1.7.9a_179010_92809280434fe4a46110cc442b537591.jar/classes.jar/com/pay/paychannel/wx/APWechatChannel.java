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
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.e5;
import midas.x.fc;
import midas.x.g5;
import midas.x.h2;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.r1;
import midas.x.t5;
import midas.x.w3;
import midas.x.w4;
import midas.x.w7;
import midas.x.z1;
import midas.x.z5;

public class APWechatChannel
  extends i5
{
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("wxpayCallBack result:");
    paramBundle.append(paramInt);
    APLog.i("APWechatChannel", paramBundle.toString());
    a(paramInt, "");
    c6.s0().g(true);
    if (a.r().a == null) {
      return;
    }
    if (paramInt == 0)
    {
      APLog.i("APWechatPaySDK", "handleMessage result=0");
      if (c6.s0().P().equals("0"))
      {
        if ((!TextUtils.isEmpty(c6.s0().b0())) && (!TextUtils.isEmpty(c6.s0().d0()))) {
          a(c6.s0().b0(), c6.s0().e0(), c6.s0().c0(), c6.s0().d0());
        }
        APUICommonMethod.f();
        z5.a(8, 0, 0);
        return;
      }
      if ("APVmallBuyActivity".equals(c6.s0().Q()))
      {
        w7.a();
        return;
      }
      a(null);
      return;
    }
    if (paramInt == -1)
    {
      a(this.c, 210001, "系统繁忙,请稍后再试(100-100--1)", this.f);
      return;
    }
    if (paramInt == -2)
    {
      paramBundle = p4.p().e().c.g();
      z1.d().b("wechat", paramBundle, new e());
      b(this.c, this.f);
      return;
    }
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
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      z5.a(-1, paramBundle.toString());
      return;
    }
    if ((e5.h().e()) && (!TextUtils.isEmpty(p4.p().e().b.saveValue)) && (!p4.p().e().b.isCanChange))
    {
      APUICommonMethod.f();
      paramBundle = new StringBuilder();
      paramBundle.append("wechat result code:");
      paramBundle.append(paramInt);
      z5.a(-1, paramBundle.toString());
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("code=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&");
    localStringBuffer.append("errorMsg=");
    localStringBuffer.append(paramString);
    try
    {
      APDataReportManager.getInstance().insertData("sdk.wechatcallback", p4.p().e().b.saveType, p4.p().e().f.l, String.valueOf(paramInt), localStringBuffer.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
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
    boolean bool1 = t5.d();
    boolean bool2 = t5.a(paramContext);
    paramBundle = new StringBuilder();
    paramBundle.append("APWechatSDK.isContainsWXSDK() = ");
    paramBundle.append(bool1);
    paramBundle.append(", isWechatInstalled(context) = ");
    paramBundle.append(bool2);
    APLog.d("APWechatChannel", paramBundle.toString());
    c6.s0().w(false);
    if (APTools.n())
    {
      c6.s0().w(true);
      APDataReportManager.getInstance().insertData("sdk.qr.simulator", p4.p().g(), null, "", "payChannel=wechat");
      a(paramContext, paramh5, paramg5);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(paramContext, paramh5, paramg5);
      return;
    }
    b(paramContext, paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = p4.p().e().b.mpInfo.payChannel;
    w4 localw4 = p4.p().e().c;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("wechat")) && (2 != localw4.e())) {
      APUICommonMethod.b();
    }
    if (i != 0)
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
    if (localw4.e() == 2)
    {
      if ((a.r().j()) && (2 == localw4.e()))
      {
        APRecoChannelActivity.h = false;
        paramContext = localw4.g();
        z1.d().c(paramContext, "3", new d());
      }
    }
    else {
      b(paramw3);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    new t5(this.c, paramString1).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public final void a(w3 paramw3)
  {
    paramw3 = paramw3.Z();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat signsign url = :");
    ((StringBuilder)localObject).append(paramw3);
    APLog.d("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setClass(this.c, APChannelQRCodeActivity.class);
    ((Intent)localObject).putExtra("payChannel", "wechat");
    ((Intent)localObject).putExtra("payUrl", paramw3);
    this.c.startActivity((Intent)localObject);
    paramw3 = this.f;
    if (paramw3 != null) {
      paramw3.a();
    }
  }
  
  public final void b(final Context paramContext, final h5 paramh5, final g5 paramg5)
  {
    if ((r1.i()) && (r1.h()))
    {
      c6.s0().w(true);
      a(paramContext, this.f, paramg5);
      return;
    }
    APAlertDialog.f localf = new APAlertDialog.f(paramContext);
    localf.b("提示");
    localf.a("检测到您当前还未安装微信，是否使用微信扫码支付");
    localf.a("取消", new a(paramh5));
    localf.b("确定", new b(paramContext, paramg5));
    localf.b(new c(paramh5));
    try
    {
      localf.b();
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.show", p4.p().g(), null, "", "payChannel=wechat");
      return;
    }
    catch (Exception paramContext)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.error", p4.p().g(), null, "", "payChannel=wechat");
      paramContext.printStackTrace();
      if (paramh5 != null) {
        paramh5.a();
      }
    }
  }
  
  public final void b(w3 paramw3)
  {
    Object localObject = paramw3.V();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat context:");
    localStringBuilder.append(this.c);
    APLog.i("APWechatChannel", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("toWeChat wxappid:");
    localStringBuilder.append((String)localObject);
    APLog.i("APWechatChannel", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat partnerid:");
    ((StringBuilder)localObject).append(paramw3.Y());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat url:");
    ((StringBuilder)localObject).append(paramw3.g());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat sign:");
    ((StringBuilder)localObject).append(paramw3.Z());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    c6.s0().g(false);
    if ((a.r().e(p4.p().e().b)) && ("wechat".equals(p4.p().e().b.mpInfo.payChannel))) {
      APDataReportManager.getInstance().insertData("sdk.market.pay", p4.p().e().b.saveType, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("toWeChat isWechatQRCode:");
    ((StringBuilder)localObject).append(c6.s0().q0());
    APLog.i("APWechatChannel", ((StringBuilder)localObject).toString());
    if (c6.s0().q0())
    {
      if ((this.c instanceof APChannelQRCodeActivity))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("payUrl", paramw3.Z());
        this.e.a(0, (Bundle)localObject);
        return;
      }
      a(paramw3);
      return;
    }
    new t5(this.c, paramw3.V()).a(paramw3.V(), paramw3.Y(), paramw3.g(), paramw3.W(), paramw3.a0(), paramw3.X(), paramw3.Z(), this.g);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void h()
  {
    Intent localIntent = new Intent(this.c, APPayProgressActivity.class);
    localIntent.putExtra("channel", 8);
    this.c.startActivity(localIntent);
    ((Activity)this.c).finish();
  }
  
  public class a
    implements c7
  {
    public a(h5 paramh5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.cancel", p4.p().g(), null, "", "payChannel=wechat");
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
      APDataReportManager.getInstance().insertData("sdk.qr.dialog.sure", p4.p().g(), null, "", "payChannel=wechat");
      c6.s0().w(true);
      paramAPAlertDialog.f();
      paramAPAlertDialog = APWechatChannel.this;
      paramAPAlertDialog.a(paramContext, APWechatChannel.a(paramAPAlertDialog), paramg5);
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
        APDataReportManager.getInstance().insertData("sdk.qr.dialog.keyback", p4.p().g(), null, "", "payChannel=wechat");
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
  
  public class d
    implements fc
  {
    public d() {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.b();
      paramob = (h2)paramob;
      int i = paramob.d();
      if (i == 0)
      {
        if ((paramob.k() != 2) && (paramob.k() != 3) && (paramob.k() != 4) && (paramob.k() != 5))
        {
          APWechatChannel.b(APWechatChannel.this);
          return;
        }
        e5.h();
        e5.a("wechat").a(null);
        return;
      }
      if (!TextUtils.isEmpty(paramob.f()))
      {
        APWechatChannel.this.a(i, paramob.f(), true);
        return;
      }
      APWechatChannel.b(APWechatChannel.this);
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.b();
      APWechatChannel.b(APWechatChannel.this);
    }
    
    public void c(ob paramob)
    {
      APUICommonMethod.b();
      APWechatChannel.b(APWechatChannel.this);
    }
  }
  
  public class e
    implements fc
  {
    public e() {}
    
    public void a(ob paramob) {}
    
    public void b(ob paramob) {}
    
    public void c(ob paramob) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.wx.APWechatChannel
 * JD-Core Version:    0.7.0.1
 */