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
import midas.x.bw;
import midas.x.by;
import midas.x.cv;
import midas.x.d;
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.ez;
import midas.x.fa;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fo;
import midas.x.fv;
import midas.x.gc;
import midas.x.lh;
import midas.x.lw;
import midas.x.n;
import midas.x.o;

public class APTenpayChannel
  extends ff
{
  private void a(el paramel)
  {
    paramel = new Bundle();
    paramel.putBoolean("isPayExpress", false);
    Intent localIntent = new Intent();
    localIntent.putExtra("to", 1);
    localIntent.setClass(this.d, APRecoChannelActivity.class);
    localIntent.putExtras(paramel);
    this.d.startActivity(localIntent);
  }
  
  private void b(final int paramInt)
  {
    APUICommonMethod.b(this.d);
    a.a().a(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APUICommonMethod.c(APTenpayChannel.this.d);
        if (((cv)paramAnonymouslh).T() != 0)
        {
          APTenpayChannel.a(APTenpayChannel.this);
          return;
        }
        if (paramInt == 2)
        {
          APTenpayChannel.b(APTenpayChannel.this);
          return;
        }
        if (paramInt == 3)
        {
          paramAnonymouslh = em.b().n();
          APTenpayChannel.a(APTenpayChannel.this, paramAnonymouslh);
        }
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.c(APTenpayChannel.this.d);
        APTenpayChannel.a(APTenpayChannel.this);
      }
      
      public void c(lh paramAnonymouslh) {}
    });
  }
  
  private void b(int paramInt, Bundle paramBundle)
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
    APDataReportManager.getInstance().insertData("sdk.tenpaycallback", em.b().n().a.saveType, em.b().n().e.m, String.valueOf(paramInt), null);
    localObject = em.b().n();
    int j = 0;
    boolean bool1 = false;
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      fv.d();
      return;
    case 4: 
      if (this.c != null) {
        bool1 = this.c.getBoolean("isFromChannelList");
      }
      if ((!bool1) && (!"bank".endsWith(em.b().n().a.mpInfo.payChannel)))
      {
        em.b().n().e.j = "";
        d();
        return;
      }
      paramBundle = paramBundle.getString("msg");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(bw.a(3004));
        paramBundle = ((StringBuilder)localObject).toString();
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append("系统繁忙,请稍后再试");
        paramBundle.append(bw.a(3004));
        paramBundle = paramBundle.toString();
      }
      a(this.d, 220004, paramBundle, this.g);
      return;
    case 3: 
      APLog.i("APTenpayChannel", " resultCode=3");
      if (n.a().c(em.b().n().e.f))
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
      a((el)localObject);
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
      if (n.a().c(em.b().n().e.f))
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
            int j = em.b().n().a.saveType;
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
    boolean bool = em.b().n().d.e;
    String str1 = em.b().n().d.k;
    String str2 = em.b().n().d.l;
    return (bool) && (!TextUtils.isEmpty(str1)) && ("uin".equals(str2));
  }
  
  private void i()
  {
    if ((!o.a().b()) && (!a.a().f))
    {
      APUICommonMethod.b();
      fv.a(2, "");
      return;
    }
    if (em.b().n().e.f.equals(em.b().n().a.mpInfo.payChannel))
    {
      APUICommonMethod.b();
      fv.a(2, "");
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
    ((Activity)this.d).overridePendingTransition(fv.a(this.d, "unipay_anim_in_from_right"), fv.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public void a(final Context paramContext)
  {
    APUICommonMethod.b(paramContext);
    by.a().h(this.e, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        if (paramAnonymouslh.T() != 0) {
          n.a().j();
        }
        APUICommonMethod.c(paramContext);
      }
      
      public void b(lh paramAnonymouslh)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
      }
      
      public void c(lh paramAnonymouslh)
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
  
  public void b(Context paramContext, dt paramdt)
  {
    int i = paramdt.T();
    Object localObject = gc.a();
    boolean bool = false;
    ((gc)localObject).a(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APQDChannel", ((StringBuilder)localObject).toString());
    localObject = em.b().n().a.mpInfo.payChannel;
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
        if ((this.e.equals(em.b().n().e.j)) && (!bool))
        {
          em.b().n().e.j = "";
          d();
          return;
        }
        a(i, paramdt.U(), false);
        return;
      }
      APUICommonMethod.b();
      fv.a(i, "订单失效");
      return;
    }
    em.b().n().e.m = paramdt.e();
    paramContext = new fo(paramContext);
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
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.c = paramBundle;
    if ("cft".equals(this.e))
    {
      f();
      return;
    }
    g();
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.c = paramBundle;
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
  
  public void f()
  {
    int i = em.b().n().a.saveType;
    if ((!a.a().j()) && (!d.a()) && (!d.b()))
    {
      if (!em.b().n().d.d)
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
    if (!em.b().n().d.f)
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
    int i = em.b().n().a.saveType;
    if ((a.a().j()) && (!em.b().n().d.f))
    {
      if (em.b().n().d.c)
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
    if (!em.b().n().d.f)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.tenpay.APTenpayChannel
 * JD-Core Version:    0.7.0.1
 */