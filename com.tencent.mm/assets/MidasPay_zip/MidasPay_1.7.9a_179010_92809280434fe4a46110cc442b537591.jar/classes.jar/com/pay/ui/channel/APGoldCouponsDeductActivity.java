package com.pay.ui.channel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.goldcouponsdeduct.APGoldCouponsDeductChannel;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payCenter.APPayStoreActivity;
import com.pay.ui.payWeb.APWebBuyActivity;
import com.pay.ui.payWeb.APX5WebBuyActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.g6;
import midas.x.g6.a;
import midas.x.h5;
import midas.x.h8;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.p;
import midas.x.p4;
import midas.x.u;
import midas.x.w4;
import midas.x.y7;
import midas.x.z4;
import midas.x.z5;

public class APGoldCouponsDeductActivity
  extends APActivity
  implements View.OnClickListener
{
  public AP3PointsLoading d;
  public LinearLayout e;
  public LinearLayout f;
  public LinearLayout g;
  public LinearLayout h;
  public TextView i;
  public ImageButton j;
  public TextView k;
  public TextView l;
  public TextView m;
  public TextView n;
  public TextView o;
  public TextView p;
  public TextView q;
  public Button r;
  public int s;
  public int t;
  public boolean u = false;
  public h5 v = new a();
  
  public final void a(TextView paramTextView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    localStringBuilder.append("元");
    paramTextView.setText(localStringBuilder.toString());
    paramTextView.setTag(paramString);
  }
  
  public final void a(TextView paramTextView, u paramu)
  {
    paramTextView.setText(paramu.d());
  }
  
  public final void a(String paramString)
  {
    APDataReportManager.getInstance().insertData(paramString, this.a, p4.p().e().f.k, p4.p().e().f.e, null);
  }
  
  public final boolean b(String paramString)
  {
    return (!"hfpay".equals(paramString)) || (this.t % 100 == 0);
  }
  
  public final void f()
  {
    a("sdk.goldcoupons.keyback");
    p.o().a(false);
    p.o().k();
    Object localObject = c6.s0().Q();
    if (((String)localObject).equals("AndroidPay"))
    {
      if (!"buytuan".equals(this.c.c.g))
      {
        APUICommonMethod.f();
        z5.a(2, "");
      }
    }
    else if (((String)localObject).equals("APPayGameInputNumActivity"))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this, APPayStoreActivity.class);
      startActivity((Intent)localObject);
    }
    else if (((String)localObject).equals("APPayGameListNumActivity"))
    {
      if (!"buytuan".equals(this.c.c.g))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, APPayStoreActivity.class);
        startActivity((Intent)localObject);
      }
    }
    else if (((String)localObject).equals("APWebBuyActivity"))
    {
      localObject = new Intent();
      if (!"buytuan".equals(this.c.c.g))
      {
        if (h8.d(this))
        {
          APX5WebBuyActivity.q = y7.q;
          ((Intent)localObject).setClass(this, APX5WebBuyActivity.class);
        }
        else
        {
          APWebBuyActivity.q = y7.q;
          ((Intent)localObject).setClass(this, APWebBuyActivity.class);
        }
        startActivity((Intent)localObject);
      }
    }
    else
    {
      APUICommonMethod.f();
      z5.a(2, "");
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public final boolean g()
  {
    return this.u;
  }
  
  public final void h()
  {
    String str = this.c.f.i;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expressChannel:");
    ((StringBuilder)localObject).append(str);
    APLog.i("APGoldCouponsDeductActivity", ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("fromCoupons", true);
    j9.b.clear();
    if ((p.o().a(str)) && (b(str)))
    {
      if (!this.c.b.isCanChange)
      {
        if (!TextUtils.isEmpty(str))
        {
          if (("cft".equals(str)) || ("bank".equals(str))) {
            this.u = true;
          }
          e5.h().b(this, str, (Bundle)localObject, this.v, null);
          return;
        }
        e5.h().a(this, "channelList", (Bundle)localObject);
        return;
      }
      if (("cft".equals(str)) || ("bank".equals(str))) {
        this.u = true;
      }
      e5.h().a(this, str, (Bundle)localObject);
      return;
    }
    this.c.f.i = "";
    e5.h().a(this, "channelList", (Bundle)localObject);
  }
  
  public final void i()
  {
    p.o().a(true);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.t = this.s;
    int i1 = p.o().a(this.t);
    Object localObject3 = p.o().d();
    this.t -= i1;
    i1 = ((ArrayList)localObject3).size();
    Object localObject2 = null;
    if (i1 > 0) {
      localObject1 = (u)((ArrayList)localObject3).get(0);
    } else {
      localObject1 = null;
    }
    if (((ArrayList)localObject3).size() > 1) {
      localObject2 = (u)((ArrayList)localObject3).get(1);
    }
    if ((localObject1 != null) && (((u)localObject1).h()) && (((u)localObject1).a() > 0))
    {
      this.f.setVisibility(0);
      a(this.n, (u)localObject1);
      a(this.o, APTools.b(((u)localObject1).a()));
    }
    if ((localObject2 != null) && (((u)localObject2).h()) && (((u)localObject2).a() > 0))
    {
      this.g.setVisibility(0);
      a(this.p, (u)localObject2);
      a(this.q, APTools.b(((u)localObject2).a()));
    }
    if ((this.f.getVisibility() == 8) && (this.g.getVisibility() == 8))
    {
      localObject1 = ((u)((ArrayList)localObject3).get(0)).d();
      localObject2 = this.i;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("点击使用");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("抵扣");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      this.h.setVisibility(0);
    }
    Object localObject1 = this.m;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(APTools.a(this.t, 2));
    ((StringBuilder)localObject2).append("元");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  public final void j()
  {
    p.o().a(false);
    Object localObject1 = this.c;
    String str = ((o4)localObject1).c.a(((o4)localObject1).f.f);
    p.o().a(true);
    int i1 = this.a;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4)
      {
        if (i1 != 5)
        {
          localObject1 = "";
        }
        else if (g6.k().e() == g6.a.a)
        {
          localObject1 = this.c.c.b;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getString(2131230829));
          ((StringBuilder)localObject1).append(this.c.f.f);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        localObject1 = this.c.c.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.c.f.f);
        ((StringBuilder)localObject1).append(((z4)this.c.c).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230829));
      ((StringBuilder)localObject1).append(this.c.f.f);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.c.b);
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.l;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("元");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.s = APTools.p(str);
  }
  
  public final void k()
  {
    this.r = ((Button)findViewById(2131099925));
    this.r.setOnClickListener(this);
    this.j = ((ImageButton)findViewById(2131099850));
    this.j.setOnClickListener(this);
    this.k = ((TextView)findViewById(2131099999));
    this.l = ((TextView)findViewById(2131100000));
    this.e = ((LinearLayout)findViewById(2131099870));
    this.e.setOnClickListener(this);
    this.f = ((LinearLayout)findViewById(2131099718));
    this.g = ((LinearLayout)findViewById(2131099719));
    this.h = ((LinearLayout)findViewById(2131099720));
    this.i = ((TextView)findViewById(2131099721));
    this.n = ((TextView)findViewById(2131099881));
    this.p = ((TextView)findViewById(2131099882));
    this.o = ((TextView)findViewById(2131099879));
    this.q = ((TextView)findViewById(2131099880));
    this.m = ((TextView)findViewById(2131099914));
    this.d = ((AP3PointsLoading)findViewById(2131099895));
    if (c6.s0().Q().equals("AndroidPay"))
    {
      this.j.setImageResource(2131034192);
      this.j.setContentDescription("关闭");
      return;
    }
    this.j.setImageResource(2131034194);
    this.j.setContentDescription("返回");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0) {
      i();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131099925)
    {
      a("sdk.goldcoupons.pay");
      if (!p.o().i())
      {
        h();
        return;
      }
      this.e.setEnabled(false);
      this.r.setVisibility(8);
      this.d.setVisibility(0);
      this.d.c();
      int i1 = p.o().a(this.s);
      if (this.s - i1 == 0)
      {
        this.u = true;
        ((APGoldCouponsDeductChannel)e5.a("goldcouponsdeduct")).a(this, this.v, null);
        return;
      }
      h();
      paramView = this.c.f.i;
      if ((!"cft".equals(paramView)) && (!"bank".equals(paramView)))
      {
        this.d.d();
        this.d.setVisibility(8);
        this.e.setEnabled(true);
        this.r.setVisibility(0);
      }
    }
    else
    {
      if (paramView.getId() == 2131099850)
      {
        if (g()) {
          return;
        }
        a("sdk.goldcoupons.close");
        f();
        return;
      }
      if (paramView.getId() == 2131099870)
      {
        a("sdk.goldcoupons.change");
        startActivityForResult(new Intent(this, APGoldCouponsDeductSelectValueActivity.class), 0);
        overridePendingTransition(z5.a(this, "unipay_anim_in_from_right"), z5.a(this, "unipay_anim_out_to_left"));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165193);
      k();
      j();
      i();
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (g()) {
        return true;
      }
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.u = false;
      this.d.d();
      this.d.setVisibility(8);
      this.e.setEnabled(true);
      this.r.setVisibility(0);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    a("sdk.goldcoupons.show");
  }
  
  public class a
    implements h5
  {
    public a() {}
    
    public void a()
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.d.d();
      APGoldCouponsDeductActivity.this.d.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
    
    public void a(int paramInt)
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.d.d();
      APGoldCouponsDeductActivity.this.d.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.d.d();
      APGoldCouponsDeductActivity.this.d.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APGoldCouponsDeductActivity
 * JD-Core Version:    0.7.0.1
 */