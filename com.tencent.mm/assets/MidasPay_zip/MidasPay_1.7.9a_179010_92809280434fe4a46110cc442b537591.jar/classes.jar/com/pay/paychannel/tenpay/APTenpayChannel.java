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
import midas.x.c5;
import midas.x.d;
import midas.x.d5;
import midas.x.fc;
import midas.x.g5;
import midas.x.g6;
import midas.x.h5;
import midas.x.i5;
import midas.x.o;
import midas.x.o4;
import midas.x.ob;
import midas.x.p;
import midas.x.p4;
import midas.x.r5;
import midas.x.w2;
import midas.x.w3;
import midas.x.x1;
import midas.x.z1;
import midas.x.z5;

public class APTenpayChannel
  extends i5
{
  public void a(final Context paramContext)
  {
    APUICommonMethod.c(paramContext);
    z1.d().h(this.d, new a(paramContext));
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    paramContext = new StringBuilder();
    paramContext.append("gotoRecChannel currentChannelId:");
    paramContext.append(this.d);
    APLog.i("APTenpayChannel", paramContext.toString());
    this.b = paramBundle;
    if ("cft".equals(this.d))
    {
      i();
      return;
    }
    h();
  }
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.b = paramBundle;
    if ("cft".equals(this.d))
    {
      i();
      return;
    }
    h();
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    Object localObject = g6.k();
    boolean bool = false;
    ((g6)localObject).a(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APQDChannel", ((StringBuilder)localObject).toString());
    localObject = p4.p().e().b.mpInfo.payChannel;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("bank"))) {
      APUICommonMethod.b();
    }
    if (i != 0)
    {
      if (i != 1023)
      {
        paramContext = this.b;
        if (paramContext != null) {
          bool = paramContext.getBoolean("isFromChannelList", false);
        } else {
          bool = false;
        }
        paramContext = new StringBuilder();
        paramContext.append("isFromChannelList:");
        paramContext.append(bool);
        APLog.i("APTenpay", paramContext.toString());
        if ((this.d.equals(p4.p().e().f.i)) && (!bool))
        {
          p4.p().e().f.i = "";
          f();
          return;
        }
        a(i, paramw3.f(), false);
        return;
      }
      APUICommonMethod.f();
      z5.a(i, "订单失效");
      return;
    }
    p4.p().e().f.l = paramw3.g();
    paramContext = new r5(paramContext);
    if ("cft".equals(this.d)) {
      i = 1;
    } else {
      i = 2;
    }
    paramw3 = this.b;
    if (paramw3 != null) {
      bool = paramw3.getBoolean("isFromChannelList");
    }
    paramContext.a(i, bool, new c(null, this));
  }
  
  public final void a(o4 paramo4)
  {
    paramo4 = new Bundle();
    paramo4.putBoolean("isPayExpress", false);
    Intent localIntent = new Intent();
    localIntent.putExtra("to", 1);
    localIntent.setClass(this.c, APRecoChannelActivity.class);
    localIntent.putExtras(paramo4);
    this.c.startActivity(localIntent);
  }
  
  public final void b(int paramInt, Bundle paramBundle)
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
    c((String)localObject);
    APDataReportManager.getInstance().insertData("sdk.tenpaycallback", p4.p().e().b.saveType, p4.p().e().f.l, String.valueOf(paramInt), null);
    localObject = p4.p().e();
    int i = 1;
    if (paramInt != 1)
    {
      boolean bool1 = false;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            z5.f();
            return;
          }
          localObject = this.b;
          if (localObject != null) {
            bool1 = ((Bundle)localObject).getBoolean("isFromChannelList");
          }
          if ((!bool1) && (!"bank".endsWith(p4.p().e().b.mpInfo.payChannel)))
          {
            p4.p().e().f.i = "";
            f();
            return;
          }
          paramBundle = paramBundle.getString("msg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramBundle);
            ((StringBuilder)localObject).append(x1.a(3004));
            paramBundle = ((StringBuilder)localObject).toString();
          }
          else
          {
            paramBundle = new StringBuilder();
            paramBundle.append("系统繁忙,请稍后再试");
            paramBundle.append(x1.a(3004));
            paramBundle = paramBundle.toString();
          }
          a(this.c, 220004, paramBundle, this.f);
          return;
        }
        APLog.i("APTenpayChannel", " resultCode=3");
        if (o.m().g(p4.p().e().f.e))
        {
          a(this.c);
          return;
        }
        if ((p.o().h()) && (p.o().f()) && (p.o().j()) && (p.o().i()))
        {
          APLog.i("APTenpayChannel", " goldConpousDeductRollBack");
          c(paramInt);
          return;
        }
        APLog.i("APTenpayChannel", " morePayChannel");
        a((o4)localObject);
        return;
      }
      bool1 = p.o().h();
      boolean bool2 = p.o().f();
      boolean bool3 = p.o().j();
      boolean bool4 = p.o().i();
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
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4)) {
        i = 0;
      }
      if (o.m().g(p4.p().e().f.e))
      {
        a(this.c);
        return;
      }
      if (i != 0)
      {
        c(paramInt);
        return;
      }
      l();
      return;
    }
    a(null);
  }
  
  public final void c(final int paramInt)
  {
    APUICommonMethod.c(this.c);
    a.r().a(new b(paramInt));
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.b = paramBundle;
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void c(String paramString)
  {
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.split("\\|");
        int i = 0;
        if (i < arrayOfString.length)
        {
          Object localObject2 = arrayOfString[i].split("\\-");
          if (localObject2.length > 0)
          {
            int j = localObject2.length;
            paramString = "";
            if (j != 2) {
              break label152;
            }
            paramString = localObject2[0];
            localObject1 = localObject2[1];
            if (localObject2.length == 1) {
              paramString = localObject2[0];
            }
            if (!TextUtils.isEmpty(paramString))
            {
              localObject2 = APDataReportManager.getInstance();
              j = p4.p().e().b.saveType;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("pt");
              localStringBuilder.append(String.valueOf(localObject1));
              ((APDataReportManager)localObject2).insertData(paramString, j, null, localStringBuilder.toString(), null);
            }
          }
          i += 1;
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      label152:
      Object localObject1 = "";
    }
  }
  
  public void h()
  {
    int i = p4.p().e().b.saveType;
    if ((a.r().e()) && (!p4.p().e().e.f))
    {
      if (p4.p().e().e.c)
      {
        if ((i != 3) && (i != 2))
        {
          if (k())
          {
            e();
            return;
          }
          e();
          return;
        }
        e();
        return;
      }
      e();
      return;
    }
    if ((!d.a()) && (!d.b()))
    {
      a(this.c, this.f, this.e);
      return;
    }
    if (!p4.p().e().e.f)
    {
      e();
      return;
    }
    a(this.c, this.f, this.e);
  }
  
  public void i()
  {
    int i = p4.p().e().b.saveType;
    if ((!a.r().e()) && (!d.a()) && (!d.b()))
    {
      if (!p4.p().e().e.d)
      {
        h5 localh5 = this.f;
        if (localh5 != null) {
          localh5.a();
        }
        APUICommonMethod.a(this.c, "您还没有开通财付通,请使用其它方式支付");
        return;
      }
      a(this.c, this.f, this.e);
      return;
    }
    if (!p4.p().e().e.f)
    {
      if ((i != 3) && (i != 2))
      {
        if (k())
        {
          e();
          return;
        }
        e();
        return;
      }
      e();
      return;
    }
    a(this.c, this.f, this.e);
  }
  
  public final void j()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("resource", "backOrError");
    ((Intent)localObject).putExtra("toGoldCouponsPage", true);
    ((Intent)localObject).setClass(this.c, APGoldCouponsDeductSelectValueActivity.class);
    this.c.startActivity((Intent)localObject);
    localObject = this.c;
    ((Activity)localObject).overridePendingTransition(z5.a((Context)localObject, "unipay_anim_in_from_right"), z5.a(this.c, "unipay_anim_out_to_left"));
  }
  
  public final boolean k()
  {
    boolean bool = p4.p().e().e.e;
    String str1 = p4.p().e().e.i;
    String str2 = p4.p().e().e.j;
    return (bool) && (!TextUtils.isEmpty(str1)) && ("uin".equals(str2));
  }
  
  public final void l()
  {
    if ((!p.o().h()) && (!a.r().f))
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    if (p4.p().e().f.e.equals(p4.p().e().b.mpInfo.payChannel))
    {
      APUICommonMethod.f();
      z5.a(2, "");
    }
  }
  
  public class a
    implements fc
  {
    public a(Context paramContext) {}
    
    public void a(ob paramob)
    {
      if (paramob.d() != 0) {
        o.m().b();
      }
      APUICommonMethod.a(paramContext);
    }
    
    public void b(ob paramob)
    {
      o.m().b();
      APUICommonMethod.a(paramContext);
    }
    
    public void c(ob paramob)
    {
      o.m().b();
    }
  }
  
  public class b
    implements fc
  {
    public b(int paramInt) {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.a(APTenpayChannel.this.c);
      if (((w2)paramob).d() != 0)
      {
        APTenpayChannel.a(APTenpayChannel.this);
        return;
      }
      int i = paramInt;
      if (i == 2)
      {
        APTenpayChannel.b(APTenpayChannel.this);
        return;
      }
      if (i == 3)
      {
        paramob = p4.p().e();
        APTenpayChannel.a(APTenpayChannel.this, paramob);
      }
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.a(APTenpayChannel.this.c);
      APTenpayChannel.a(APTenpayChannel.this);
    }
    
    public void c(ob paramob) {}
  }
  
  public static class c
    extends ResultReceiver
  {
    public final WeakReference<APTenpayChannel> a;
    
    public c(Handler paramHandler, APTenpayChannel paramAPTenpayChannel)
    {
      super();
      this.a = new WeakReference(paramAPTenpayChannel);
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tenpayCallbackReceiver resultCode = ");
        ((StringBuilder)localObject).append(paramInt);
        APLog.i("APTenpayChannel", ((StringBuilder)localObject).toString());
        APTenpayChannel.a((APTenpayChannel)this.a.get(), paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.tenpay.APTenpayChannel
 * JD-Core Version:    0.7.0.1
 */