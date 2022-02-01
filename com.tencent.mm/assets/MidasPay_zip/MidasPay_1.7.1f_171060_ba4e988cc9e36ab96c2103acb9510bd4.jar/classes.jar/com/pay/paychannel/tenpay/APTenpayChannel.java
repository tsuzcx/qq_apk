package com.pay.paychannel.tenpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import midas.x.a;
import midas.x.bq;
import midas.x.bs;
import midas.x.cp;
import midas.x.d;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.eq;
import midas.x.er;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.ff;
import midas.x.fm;
import midas.x.fs;
import midas.x.jw;
import midas.x.kl;
import midas.x.n;
import midas.x.o;

public class APTenpayChannel
  extends ew
{
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TenpayCallback resultCode = ");
    ((StringBuilder)localObject).append(paramInt);
    APLog.i("APTenpayActivity", ((StringBuilder)localObject).toString());
    localObject = paramBundle.getString("trace");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TenpayCallback trace = ");
    localStringBuilder.append((String)localObject);
    APLog.i("APTenpayActivity", localStringBuilder.toString());
    b((String)localObject);
    APDataReportManager.getInstance().insertData("sdk.tenpaycallback", ed.b().n().a.saveType, ed.b().n().e.m, String.valueOf(paramInt), null);
    localObject = ed.b().n();
    int j = 0;
    boolean bool1 = false;
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      fm.d();
      return;
    case 4: 
      if (this.c != null) {
        bool1 = this.c.getBoolean("isFromChannelList");
      }
      if ((!bool1) && (!"bank".endsWith(ed.b().n().a.mpInfo.payChannel)))
      {
        ed.b().n().e.j = "";
        d();
        return;
      }
      paramBundle = paramBundle.getString("msg");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(bq.a(3004));
        paramBundle = ((StringBuilder)localObject).toString();
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append("系统繁忙,请稍后再试");
        paramBundle.append(bq.a(3004));
        paramBundle = paramBundle.toString();
      }
      a(this.d, 220004, paramBundle, this.g);
      return;
    case 3: 
      APLog.i("APTenpayChannel", " resultCode=3");
      if (n.a().c(ed.b().n().e.f))
      {
        a(this.d);
        return;
      }
      if ((o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
      {
        APLog.i("APTenpayChannel", " goldConpousDeductRollBack");
        b(paramInt);
        return;
      }
      APLog.i("APTenpayChannel", " morePayChannel");
      a((ec)localObject);
      return;
    case 2: 
      bool1 = o.a().b();
      boolean bool2 = o.a().c();
      boolean bool3 = o.a().o();
      boolean bool4 = o.a().d();
      paramBundle = new StringBuilder();
      paramBundle.append("boolean = ");
      paramBundle.append(bool1);
      paramBundle.append(", ");
      paramBundle.append(bool2);
      paramBundle.append(", ");
      paramBundle.append(bool3);
      paramBundle.append(", ");
      paramBundle.append(bool4);
      APLog.d("APTenpayChannel", paramBundle.toString());
      int i = j;
      if (bool1)
      {
        i = j;
        if (bool2)
        {
          i = j;
          if (bool3)
          {
            i = j;
            if (bool4) {
              i = 1;
            }
          }
        }
      }
      if (n.a().c(ed.b().n().e.f))
      {
        a(this.d);
        return;
      }
      if (i != 0)
      {
        b(paramInt);
        return;
      }
      i();
      return;
    }
    a(null);
  }
  
  private void a(ec paramec)
  {
    paramec = new Bundle();
    paramec.putBoolean("isPayExpress", false);
    Intent localIntent = new Intent();
    localIntent.putExtra("to", 1);
    localIntent.setClass(this.d, APRecoChannelActivity.class);
    localIntent.putExtras(paramec);
    this.d.startActivity(localIntent);
  }
  
  private void b(final int paramInt)
  {
    APUICommonMethod.b(this.d);
    a.a().a(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        APUICommonMethod.c(APTenpayChannel.a(APTenpayChannel.this));
        if (((cp)paramAnonymousjw).R() != 0)
        {
          APTenpayChannel.b(APTenpayChannel.this);
          return;
        }
        if (paramInt == 2)
        {
          APTenpayChannel.c(APTenpayChannel.this);
          return;
        }
        if (paramInt == 3)
        {
          paramAnonymousjw = ed.b().n();
          APTenpayChannel.a(APTenpayChannel.this, paramAnonymousjw);
        }
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.c(APTenpayChannel.d(APTenpayChannel.this));
        APTenpayChannel.b(APTenpayChannel.this);
      }
      
      public void c(jw paramAnonymousjw) {}
    });
  }
  
  private void b(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      int i = 0;
      while (i < arrayOfString.length)
      {
        Object localObject = arrayOfString[i].split("\\-");
        paramString = "";
        String str = "";
        if (localObject.length > 0)
        {
          if (localObject.length == 2)
          {
            paramString = localObject[0];
            str = localObject[1];
          }
          if (localObject.length == 1) {
            paramString = localObject[0];
          }
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = APDataReportManager.getInstance();
            int j = ed.b().n().a.saveType;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("pt");
            localStringBuilder.append(String.valueOf(str));
            ((APDataReportManager)localObject).insertData(paramString, j, null, localStringBuilder.toString(), null);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean h()
  {
    boolean bool = ed.b().n().d.e;
    String str1 = ed.b().n().d.k;
    String str2 = ed.b().n().d.l;
    return (bool) && (!TextUtils.isEmpty(str1)) && ("uin".equals(str2));
  }
  
  private void i()
  {
    if ((!o.a().b()) && (!a.a().f))
    {
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    if (ed.b().n().e.f.equals(ed.b().n().a.mpInfo.payChannel))
    {
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("resource", "backOrError");
    localIntent.putExtra("toGoldCouponsPage", true);
    localIntent.setClass(this.d, APGoldCouponsDeductSelectValueActivity.class);
    this.d.startActivity(localIntent);
    ((Activity)this.d).overridePendingTransition(fm.a(this.d, "unipay_anim_in_from_right"), fm.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public void a(final Context paramContext)
  {
    APUICommonMethod.b(paramContext);
    bs.a().h(this.e, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        if (paramAnonymousjw.R() != 0) {
          n.a().j();
        }
        APUICommonMethod.c(paramContext);
      }
      
      public void b(jw paramAnonymousjw)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
      }
      
      public void c(jw paramAnonymousjw)
      {
        n.a().j();
      }
    });
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    paramContext = new StringBuilder();
    paramContext.append("gotoRecChannel currentChannelId:");
    paramContext.append(this.e);
    APLog.i("APTenpayChannel", paramContext.toString());
    this.c = paramBundle;
    if ("cft".equals(this.e))
    {
      f();
      return;
    }
    g();
  }
  
  public void b(Context paramContext, dl paramdl)
  {
    int i = paramdl.R();
    Object localObject = fs.a();
    boolean bool = false;
    ((fs)localObject).a(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APQDChannel", ((StringBuilder)localObject).toString());
    localObject = ed.b().n().a.mpInfo.payChannel;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("bank"))) {
      APUICommonMethod.g();
    }
    if (i != 0)
    {
      if (i != 1023)
      {
        if (this.c != null) {
          bool = this.c.getBoolean("isFromChannelList", false);
        } else {
          bool = false;
        }
        paramContext = new StringBuilder();
        paramContext.append("isFromChannelList:");
        paramContext.append(bool);
        APLog.i("APTenpay", paramContext.toString());
        if ((this.e.equals(ed.b().n().e.j)) && (!bool))
        {
          ed.b().n().e.j = "";
          d();
          return;
        }
        a(i, paramdl.S(), false);
        return;
      }
      APUICommonMethod.b();
      fm.a(i, "订单失效");
      return;
    }
    ed.b().n().e.m = paramdl.c();
    paramContext = new ff(paramContext);
    if ("cft".equals(this.e)) {
      i = 1;
    } else {
      i = 2;
    }
    if (this.c != null) {
      bool = this.c.getBoolean("isFromChannelList");
    }
    paramContext.a(i, bool, new a(null, this));
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.c = paramBundle;
    if ("cft".equals(this.e))
    {
      f();
      return;
    }
    g();
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.c = paramBundle;
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
  
  public void f()
  {
    int i = ed.b().n().a.saveType;
    if ((!a.a().j()) && (!d.a()) && (!d.b()))
    {
      if (!ed.b().n().d.d)
      {
        if (this.g != null) {
          this.g.a();
        }
        APUICommonMethod.a(this.d, "您还没有开通财付通,请使用其它方式支付");
        return;
      }
      a(this.d, this.g, this.f);
      return;
    }
    if (!ed.b().n().d.f)
    {
      if ((i != 3) && (i != 2))
      {
        if (h())
        {
          c();
          return;
        }
        c();
        return;
      }
      c();
      return;
    }
    a(this.d, this.g, this.f);
  }
  
  public void g()
  {
    int i = ed.b().n().a.saveType;
    if ((a.a().j()) && (!ed.b().n().d.f))
    {
      if (ed.b().n().d.c)
      {
        if ((i != 3) && (i != 2))
        {
          if (h())
          {
            c();
            return;
          }
          c();
          return;
        }
        c();
        return;
      }
      c();
      return;
    }
    if ((!d.a()) && (!d.b()))
    {
      a(this.d, this.g, this.f);
      return;
    }
    if (!ed.b().n().d.f)
    {
      c();
      return;
    }
    a(this.d, this.g, this.f);
  }
  
  public static class a
    extends ResultReceiver
  {
    private final WeakReference<APTenpayChannel> a;
    
    public a(Handler paramHandler, APTenpayChannel paramAPTenpayChannel)
    {
      super();
      this.a = new WeakReference(paramAPTenpayChannel);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (this.a != null)
      {
        if (this.a.get() == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tenpayCallbackReceiver resultCode = ");
        localStringBuilder.append(paramInt);
        APLog.i("APTenpayChannel", localStringBuilder.toString());
        APTenpayChannel.a((APTenpayChannel)this.a.get(), paramInt, paramBundle);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.tenpay.APTenpayChannel
 * JD-Core Version:    0.7.0.1
 */