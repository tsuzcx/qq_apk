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
import java.util.ArrayList;
import java.util.HashMap;
import midas.x.a;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.en;
import midas.x.er;
import midas.x.es;
import midas.x.ev;
import midas.x.fm;
import midas.x.fp;
import midas.x.fs;
import midas.x.fs.a;
import midas.x.hj;
import midas.x.hs;
import midas.x.is;
import midas.x.o;
import midas.x.t;

public class APGoldCouponsDeductActivity
  extends APActivity
  implements View.OnClickListener
{
  private Button A;
  private int B;
  private int C;
  private boolean D = false;
  protected AP3PointsLoading a;
  ev b = new ev()
  {
    public void a()
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.a.a();
      APGoldCouponsDeductActivity.this.a.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
    
    public void a(int paramAnonymousInt)
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.a.a();
      APGoldCouponsDeductActivity.this.a.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this, false);
      APGoldCouponsDeductActivity.this.a.a();
      APGoldCouponsDeductActivity.this.a.setVisibility(8);
      APGoldCouponsDeductActivity.a(APGoldCouponsDeductActivity.this).setEnabled(true);
      APGoldCouponsDeductActivity.b(APGoldCouponsDeductActivity.this).setVisibility(0);
    }
  };
  private LinearLayout c;
  private LinearLayout d;
  private LinearLayout e;
  private LinearLayout q;
  private TextView r;
  private ImageButton s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(TextView paramTextView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    localStringBuilder.append("元");
    paramTextView.setText(localStringBuilder.toString());
    paramTextView.setTag(paramString);
  }
  
  private void a(TextView paramTextView, t paramt)
  {
    paramTextView.setText(paramt.d());
  }
  
  private boolean a()
  {
    return this.D;
  }
  
  private boolean a(String paramString)
  {
    return (!"hfpay".equals(paramString)) || (this.C % 100 == 0);
  }
  
  private void b()
  {
    this.A = ((Button)findViewById(2131099925));
    this.A.setOnClickListener(this);
    this.s = ((ImageButton)findViewById(2131099850));
    this.s.setOnClickListener(this);
    this.t = ((TextView)findViewById(2131099999));
    this.u = ((TextView)findViewById(2131100000));
    this.c = ((LinearLayout)findViewById(2131099870));
    this.c.setOnClickListener(this);
    this.d = ((LinearLayout)findViewById(2131099718));
    this.e = ((LinearLayout)findViewById(2131099719));
    this.q = ((LinearLayout)findViewById(2131099720));
    this.r = ((TextView)findViewById(2131099721));
    this.w = ((TextView)findViewById(2131099881));
    this.y = ((TextView)findViewById(2131099882));
    this.x = ((TextView)findViewById(2131099879));
    this.z = ((TextView)findViewById(2131099880));
    this.v = ((TextView)findViewById(2131099914));
    this.a = ((AP3PointsLoading)findViewById(2131099895));
    if (fp.a().g().equals("AndroidPay"))
    {
      this.s.setImageResource(2131034192);
      this.s.setContentDescription("关闭");
      return;
    }
    this.s.setImageResource(2131034194);
    this.s.setContentDescription("返回");
  }
  
  private void b(String paramString)
  {
    APDataReportManager.getInstance().insertData(paramString, this.f, ed.b().n().e.l, ed.b().n().e.f, null);
  }
  
  private void c()
  {
    Object localObject1 = "";
    o.a().a(false);
    String str = this.p.b.a(this.p.e.g);
    o.a().a(true);
    switch (this.f)
    {
    default: 
      break;
    case 5: 
      if (fs.a().f() == fs.a.a)
      {
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230828));
        ((StringBuilder)localObject1).append(this.p.e.g);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 4: 
      if (fs.a().f() == fs.a.a)
      {
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230828));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        ((StringBuilder)localObject1).append(((en)this.p.b).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230828));
      ((StringBuilder)localObject1).append(this.p.e.g);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.p.b.b);
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.u;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("元");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.B = APTools.g(str);
  }
  
  private void d()
  {
    o.a().a(true);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.q.setVisibility(8);
    this.C = this.B;
    int i = o.a().c(this.C);
    Object localObject3 = o.a().g();
    this.C -= i;
    i = ((ArrayList)localObject3).size();
    Object localObject2 = null;
    if (i > 0) {
      localObject1 = (t)((ArrayList)localObject3).get(0);
    } else {
      localObject1 = null;
    }
    if (((ArrayList)localObject3).size() > 1) {
      localObject2 = (t)((ArrayList)localObject3).get(1);
    }
    if ((localObject1 != null) && (((t)localObject1).f()) && (((t)localObject1).g() > 0))
    {
      this.d.setVisibility(0);
      a(this.w, (t)localObject1);
      a(this.x, APTools.a(((t)localObject1).g()));
    }
    if ((localObject2 != null) && (((t)localObject2).f()) && (((t)localObject2).g() > 0))
    {
      this.e.setVisibility(0);
      a(this.y, (t)localObject2);
      a(this.z, APTools.a(((t)localObject2).g()));
    }
    if ((this.d.getVisibility() == 8) && (this.e.getVisibility() == 8))
    {
      localObject1 = ((t)((ArrayList)localObject3).get(0)).d();
      localObject2 = this.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("点击使用");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("抵扣");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      this.q.setVisibility(0);
    }
    Object localObject1 = this.v;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(APTools.a(this.C, 2));
    ((StringBuilder)localObject2).append("元");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  private void h()
  {
    b("sdk.goldcoupons.keyback");
    o.a().a(false);
    o.a().f();
    Object localObject = fp.a().g();
    if (((String)localObject).equals("AndroidPay"))
    {
      if (!"buytuan".equals(this.p.b.j))
      {
        APUICommonMethod.b();
        fm.a(2, "");
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
      if (!"buytuan".equals(this.p.b.j))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, APPayStoreActivity.class);
        startActivity((Intent)localObject);
      }
    }
    else if (((String)localObject).equals("APWebBuyActivity"))
    {
      localObject = new Intent();
      if (!"buytuan".equals(this.p.b.j))
      {
        if (hs.b(this))
        {
          APX5WebBuyActivity.a = hj.s;
          ((Intent)localObject).setClass(this, APX5WebBuyActivity.class);
        }
        else
        {
          APWebBuyActivity.a = hj.s;
          ((Intent)localObject).setClass(this, APWebBuyActivity.class);
        }
        startActivity((Intent)localObject);
      }
    }
    else
    {
      APUICommonMethod.b();
      fm.a(2, "");
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  private void i()
  {
    String str = this.p.e.j;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expressChannel:");
    ((StringBuilder)localObject).append(str);
    APLog.i("APGoldCouponsDeductActivity", ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("fromCoupons", true);
    is.c.clear();
    if ((o.a().c(str)) && (a(str)))
    {
      if (!this.p.a.isCanChange)
      {
        if (!TextUtils.isEmpty(str))
        {
          if (("cft".equals(str)) || ("bank".equals(str))) {
            this.D = true;
          }
          es.a().b(this, str, (Bundle)localObject, this.b, null);
          return;
        }
        es.a().a(this, "channelList", (Bundle)localObject);
        return;
      }
      if (("cft".equals(str)) || ("bank".equals(str))) {
        this.D = true;
      }
      es.a().a(this, str, (Bundle)localObject);
      return;
    }
    this.p.e.j = "";
    es.a().a(this, "channelList", (Bundle)localObject);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0) {
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131099925)
    {
      b("sdk.goldcoupons.pay");
      if (!o.a().d())
      {
        i();
        return;
      }
      this.c.setEnabled(false);
      this.A.setVisibility(8);
      this.a.setVisibility(0);
      this.a.b();
      int i = o.a().c(this.B);
      if (this.B - i == 0)
      {
        this.D = true;
        ((APGoldCouponsDeductChannel)es.a("goldcouponsdeduct")).a(this, this.b, null);
        return;
      }
      i();
      paramView = this.p.e.j;
      if ((!"cft".equals(paramView)) && (!"bank".equals(paramView)))
      {
        this.a.a();
        this.a.setVisibility(8);
        this.c.setEnabled(true);
        this.A.setVisibility(0);
      }
    }
    else
    {
      if (paramView.getId() == 2131099850)
      {
        if (a()) {
          return;
        }
        b("sdk.goldcoupons.close");
        h();
        return;
      }
      if (paramView.getId() == 2131099870)
      {
        b("sdk.goldcoupons.change");
        startActivityForResult(new Intent(this, APGoldCouponsDeductSelectValueActivity.class), 0);
        overridePendingTransition(fm.a(this, "unipay_anim_in_from_right"), fm.a(this, "unipay_anim_out_to_left"));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      setContentView(2131165192);
      b();
      c();
      d();
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (a()) {
        return true;
      }
      h();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.D = false;
      this.a.a();
      this.a.setVisibility(8);
      this.c.setEnabled(true);
      this.A.setVisibility(0);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    b("sdk.goldcoupons.show");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APGoldCouponsDeductActivity
 * JD-Core Version:    0.7.0.1
 */