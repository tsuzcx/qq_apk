package com.pay.ui.channel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APLinearLayout;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.e5;
import midas.x.o4;
import midas.x.p;
import midas.x.p4;
import midas.x.u;
import midas.x.w4;
import midas.x.z5;

public class APGoldCouponsDeductSelectValueActivity
  extends APActivity
  implements View.OnClickListener
{
  public static String I = "APGoldCouponsDeductSelectValueActivity";
  public int A;
  public int B;
  public int C;
  public int D;
  public String E;
  public String F;
  public String G = "";
  public boolean H = false;
  public RelativeLayout d;
  public RelativeLayout e;
  public RelativeLayout f;
  public RelativeLayout g;
  public APLinearLayout h;
  public APLinearLayout i;
  public TextView j;
  public TextView k;
  public CheckBox l;
  public CheckBox m;
  public TextView n;
  public TextView o;
  public TextView p;
  public TextView q;
  public TextView r;
  public TextView s;
  public TextView t;
  public TextView u;
  public TextView v;
  public TextView w;
  public TextView x;
  public TextView y;
  public int z;
  
  public final void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramTextView.setText("");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("本次使用");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramTextView.setText(localStringBuilder.toString());
  }
  
  public final void a(String paramString)
  {
    u localu;
    if ("PriGold".equals(paramString))
    {
      paramString = p.o().d().iterator();
      while (paramString.hasNext())
      {
        localu = (u)paramString.next();
        if (("PriGold".equals(localu.e())) && (localu.h())) {
          b("sdk.goldcoupons.select.private");
        }
      }
    }
    paramString = p.o().d().iterator();
    while (paramString.hasNext())
    {
      localu = (u)paramString.next();
      if ((!"PriGold".equals(localu.e())) && (localu.h())) {
        b("sdk.goldcoupons.select.share");
      }
    }
  }
  
  public final void a(u paramu)
  {
    if ("PriGold".equals(paramu.e()))
    {
      this.f.setVisibility(0);
      this.t.setText(paramu.d());
      localTextView = this.v;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("冻结");
      localStringBuilder.append(paramu.d());
      localStringBuilder.append("：");
      localStringBuilder.append(APTools.a(Integer.parseInt(paramu.f())));
      localTextView.setText(localStringBuilder.toString());
      this.x.setTag(paramu.d());
      return;
    }
    this.g.setVisibility(0);
    this.u.setText(paramu.d());
    TextView localTextView = this.w;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("冻结");
    localStringBuilder.append(paramu.d());
    localStringBuilder.append("：");
    localStringBuilder.append(APTools.a(Integer.parseInt(paramu.f())));
    localTextView.setText(localStringBuilder.toString());
    this.y.setTag(paramu.d());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1;
    int i2;
    if (paramBoolean)
    {
      if (this.e.getVisibility() != 0)
      {
        i1 = this.C;
        i2 = this.z;
        if (i1 > i2)
        {
          a(this.p, APTools.a(i2), this.E);
          return;
        }
        a(this.p, APTools.a(i1), this.E);
        return;
      }
      if (this.m.isChecked())
      {
        i1 = this.C;
        if (this.D + i1 > this.z)
        {
          a(this.p, APTools.a(i1), this.E);
          a(this.s, APTools.a(this.z - this.C), this.F);
          return;
        }
        a(this.p, APTools.a(i1), this.E);
        a(this.s, APTools.a(this.D), this.F);
        return;
      }
      i1 = this.C;
      i2 = this.z;
      if (i1 > i2)
      {
        a(this.p, APTools.a(i2), this.E);
        return;
      }
      a(this.p, APTools.a(i1), this.E);
      return;
    }
    if (this.e.getVisibility() != 0)
    {
      a(this.p, "", "");
      return;
    }
    if (this.m.isChecked())
    {
      i1 = this.D;
      i2 = this.z;
      if (i1 >= i2) {
        a(this.s, APTools.a(i2), this.F);
      } else {
        a(this.s, APTools.a(i1), this.F);
      }
    }
    a(this.p, "", "");
  }
  
  public final void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i1 = 0;
      String str = paramArrayOfString[0];
      paramArrayOfString = paramArrayOfString[1];
      ArrayList localArrayList = p.o().d();
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        while (i1 < localArrayList.size())
        {
          u localu = (u)localArrayList.get(i1);
          if ((localu.b().equals(str)) && (Integer.parseInt(localu.c()) > 0))
          {
            localu.b(String.valueOf(Integer.parseInt(localu.c()) - Integer.parseInt(paramArrayOfString)));
            if (TextUtils.isEmpty(localu.f()))
            {
              localu.e(paramArrayOfString);
              return;
            }
            localu.e(String.valueOf(Integer.parseInt(localu.f()) + Integer.parseInt(paramArrayOfString)));
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public final void b(String paramString)
  {
    APDataReportManager.getInstance().insertData(paramString, this.a, p4.p().e().f.k, p4.p().e().f.e, null);
  }
  
  public final void b(boolean paramBoolean)
  {
    int i1;
    int i2;
    if (paramBoolean)
    {
      if (this.d.getVisibility() != 0)
      {
        i1 = this.D;
        i2 = this.z;
        if (i1 > i2)
        {
          a(this.s, APTools.a(i2), this.F);
          return;
        }
        a(this.s, APTools.a(i1), this.F);
        return;
      }
      if (this.l.isChecked())
      {
        i1 = this.C;
        if (this.D + i1 > this.z)
        {
          a(this.p, APTools.a(i1), this.E);
          a(this.s, APTools.a(this.z - this.C), this.F);
          return;
        }
        a(this.p, APTools.a(i1), this.E);
        a(this.s, APTools.a(this.D), this.F);
        return;
      }
      i1 = this.D;
      i2 = this.z;
      if (i1 > i2)
      {
        a(this.s, APTools.a(i2), this.F);
        return;
      }
      a(this.s, APTools.a(i1), this.F);
      return;
    }
    if (this.d.getVisibility() != 0)
    {
      a(this.s, "", "");
      return;
    }
    if (this.l.isChecked())
    {
      i1 = this.C;
      i2 = this.z;
      if (i1 >= i2) {
        a(this.p, APTools.a(i2), this.E);
      } else {
        a(this.p, APTools.a(i1), this.E);
      }
    }
    a(this.s, "", "");
  }
  
  public void c(String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this);
    localf.a(paramString);
    localf.b("我知道了", new a());
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void f()
  {
    if ("backOrError".equals(this.G))
    {
      if ((!e5.h().d()) && (!this.H))
      {
        setResult(0);
        finish();
        APUICommonMethod.a(this);
        overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
        return;
      }
      startActivity(new Intent(this, APGoldCouponsDeductActivity.class));
      finish();
      APUICommonMethod.a(this);
      APUICommonMethod.f();
      return;
    }
    setResult(0);
    finish();
    APUICommonMethod.a(this);
    overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
  }
  
  public final void g()
  {
    p.o().a(false);
    Object localObject1 = this.c;
    localObject1 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
    p.o().a(true);
    this.z = APTools.p((String)localObject1);
    this.l.setChecked(false);
    this.m.setChecked(false);
    Object localObject3 = p.o().d();
    int i1 = ((ArrayList)localObject3).size();
    localObject1 = null;
    if (i1 > 0) {
      localObject2 = (u)((ArrayList)localObject3).get(0);
    } else {
      localObject2 = null;
    }
    if (((ArrayList)localObject3).size() > 1) {
      localObject1 = (u)((ArrayList)localObject3).get(1);
    }
    int i2 = 2131034126;
    Object localObject4;
    boolean bool;
    if (localObject2 != null)
    {
      this.A = Integer.parseInt(((u)localObject2).c());
      this.E = ((u)localObject2).d();
      localObject4 = I;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goldType:");
      localStringBuilder.append(((u)localObject2).e());
      localStringBuilder.append(";goldNum:");
      localStringBuilder.append(((u)localObject2).c());
      APLog.i((String)localObject4, localStringBuilder.toString());
      this.n.setText(((u)localObject2).d());
      localObject4 = this.o;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("余额：");
      localStringBuilder.append(APTools.a(this.A));
      ((TextView)localObject4).setText(localStringBuilder.toString());
      this.d.setVisibility(0);
      bool = ((u)localObject2).h();
      this.l.setChecked(bool);
      localObject4 = this.l;
      if (bool) {
        i1 = 2131034126;
      } else {
        i1 = 2131034125;
      }
      ((CheckBox)localObject4).setBackgroundResource(i1);
      this.C = ((u)localObject2).a();
      if (p.o().d(this.z))
      {
        i1 = 0;
        break label352;
      }
    }
    i1 = 1;
    label352:
    if (i1 != 0)
    {
      if (localObject1 != null)
      {
        this.B = Integer.parseInt(((u)localObject1).c());
        this.F = ((u)localObject1).d();
        localObject2 = I;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("goldType:");
        ((StringBuilder)localObject4).append(((u)localObject1).e());
        ((StringBuilder)localObject4).append(";goldNum:");
        ((StringBuilder)localObject4).append(((u)localObject1).c());
        APLog.i((String)localObject2, ((StringBuilder)localObject4).toString());
        this.q.setText(((u)localObject1).d());
        localObject2 = this.r;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("余额：");
        ((StringBuilder)localObject4).append(APTools.a(this.B));
        ((TextView)localObject2).setText(((StringBuilder)localObject4).toString());
        this.e.setVisibility(0);
        bool = ((u)localObject1).h();
        this.m.setChecked(bool);
        localObject2 = this.m;
        if (bool) {
          i1 = i2;
        } else {
          i1 = 2131034125;
        }
        ((CheckBox)localObject2).setBackgroundResource(i1);
        this.D = ((u)localObject1).a();
      }
    }
    else if (localObject1 != null) {
      ((u)localObject1).a(false);
    }
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
      if (((ArrayList)localObject3).size() == 1)
      {
        localObject1 = (u)((ArrayList)localObject3).get(0);
        if (!TextUtils.isEmpty(((u)localObject1).f())) {
          a((u)localObject1);
        }
      }
      else if (((ArrayList)localObject3).size() > 1)
      {
        localObject1 = (u)((ArrayList)localObject3).get(0);
        if (!TextUtils.isEmpty(((u)localObject1).f())) {
          a((u)localObject1);
        }
        localObject1 = (u)((ArrayList)localObject3).get(1);
        if (!TextUtils.isEmpty(((u)localObject1).f())) {
          a((u)localObject1);
        }
      }
    }
    if (this.A <= 0)
    {
      this.l.setChecked(false);
      this.h.setEnabled(false);
      this.l.setBackgroundResource(2131034125);
      this.d.setVisibility(8);
    }
    if (this.B <= 0)
    {
      this.m.setChecked(false);
      this.i.setEnabled(false);
      this.m.setBackgroundResource(2131034125);
      this.e.setVisibility(8);
    }
    a(this.l.isChecked());
    b(this.m.isChecked());
    this.j = ((TextView)findViewById(2131099717));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("MonthlyCleared = ");
    ((StringBuilder)localObject1).append(c6.s0().o());
    APLog.w("APGoldCouponsDeuctSelectValueActivity", ((StringBuilder)localObject1).toString());
    if (c6.s0().o())
    {
      this.j.setVisibility(0);
      if (!TextUtils.isEmpty(this.E))
      {
        localObject2 = this.E;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.F))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("和");
          ((StringBuilder)localObject1).append(this.F);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("所有");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("月底清零，请及时使用");
        localObject1 = ((StringBuilder)localObject2).toString();
        this.j.setText((CharSequence)localObject1);
      }
      else
      {
        this.j.setVisibility(8);
      }
    }
    else
    {
      this.j.setVisibility(8);
    }
    Object localObject2 = (LinearLayout)findViewById(2131099722);
    localObject1 = p.o().c(this.z);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((LinearLayout)localObject2).setVisibility(8);
      return;
    }
    ((LinearLayout)localObject2).setVisibility(0);
    localObject2 = (TextView)findViewById(2131099723);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("温馨提示：");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
  }
  
  public final void h()
  {
    this.f = ((RelativeLayout)findViewById(2131099872));
    this.g = ((RelativeLayout)findViewById(2131099874));
    this.t = ((TextView)findViewById(2131099876));
    this.u = ((TextView)findViewById(2131099878));
    this.v = ((TextView)findViewById(2131099865));
    this.w = ((TextView)findViewById(2131099868));
    this.x = ((TextView)findViewById(2131099901));
    this.x.setOnClickListener(this);
    this.y = ((TextView)findViewById(2131099902));
    this.y.setOnClickListener(this);
  }
  
  public void i()
  {
    this.h = ((APLinearLayout)findViewById(2131099871));
    this.i = ((APLinearLayout)findViewById(2131099873));
    this.k = ((TextView)findViewById(2131099920));
    this.l = ((CheckBox)findViewById(2131099825));
    this.m = ((CheckBox)findViewById(2131099826));
    this.d = ((RelativeLayout)findViewById(2131099893));
    this.e = ((RelativeLayout)findViewById(2131099894));
    this.n = ((TextView)findViewById(2131099875));
    this.o = ((TextView)findViewById(2131099864));
    this.p = ((TextView)findViewById(2131099866));
    this.q = ((TextView)findViewById(2131099877));
    this.r = ((TextView)findViewById(2131099867));
    this.s = ((TextView)findViewById(2131099869));
    this.l.setChecked(true);
    this.m.setChecked(true);
    APLinearLayout.setClickAble(false);
    APLinearLayout.setClickAble(false);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public final void j()
  {
    Object localObject = URLDecoder.decode(URLDecoder.decode(p.o().c()).replace("SPResRuleList=", "").trim());
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      if (((String)localObject).contains("&"))
      {
        String[] arrayOfString = ((String)localObject).split("&");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject = arrayOfString[0].split("=");
          arrayOfString = arrayOfString[1].split("=");
          a((String[])localObject);
          a(arrayOfString);
        }
      }
      else
      {
        a(((String)localObject).split("="));
      }
    }
  }
  
  public final void k()
  {
    ArrayList localArrayList = p.o().d();
    int i1 = localArrayList.size();
    u localu2 = null;
    u localu1;
    if (i1 > 0) {
      localu1 = (u)localArrayList.get(0);
    } else {
      localu1 = null;
    }
    if (localArrayList.size() > 1) {
      localu2 = (u)localArrayList.get(1);
    }
    if (localu1 != null) {
      this.C = localu1.a();
    }
    if (localu2 != null) {
      this.D = localu2.a();
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int i3 = this.h.getId();
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    int i1 = 2131034126;
    boolean bool;
    if (i2 == i3)
    {
      bool = this.l.isChecked();
      this.l.setChecked(bool ^ true);
      paramView = this.l;
      if (bool) {
        i1 = 2131034125;
      }
      paramView.setBackgroundResource(i1);
      localArrayList2 = p.o().d();
      paramView = localArrayList1;
      if (localArrayList2.size() > 0) {
        paramView = (u)localArrayList2.get(0);
      }
      if (paramView != null)
      {
        paramView.a(bool ^ true);
        p.o().a(this.z);
        k();
      }
      a(this.l.isChecked());
      paramView = (u)p.o().d().get(0);
      if (paramView != null) {
        a(paramView.e());
      }
    }
    else if (paramView.getId() == this.i.getId())
    {
      bool = this.m.isChecked();
      this.m.setChecked(bool ^ true);
      paramView = this.m;
      if (bool) {
        i1 = 2131034125;
      }
      paramView.setBackgroundResource(i1);
      localArrayList1 = p.o().d();
      paramView = localArrayList2;
      if (localArrayList1.size() > 1) {
        paramView = (u)localArrayList1.get(1);
      }
      if (paramView != null)
      {
        paramView.a(bool ^ true);
        p.o().a(this.z);
        k();
      }
      b(this.m.isChecked());
      paramView = (u)p.o().d().get(1);
      if (paramView != null) {
        a(paramView.e());
      }
    }
    else
    {
      if (paramView.getId() == this.k.getId())
      {
        b("sdk.goldcoupons.select.sure");
        f();
        return;
      }
      if (paramView.getId() == this.x.getId())
      {
        c(getString(2131230787).replace("宝券", (String)this.x.getTag()));
        return;
      }
      if (paramView.getId() == this.y.getId()) {
        c(getString(2131230787).replace("宝券", (String)this.y.getTag()));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setRequestedOrientation(1);
      this.a = this.c.b.saveType;
      setContentView(2131165214);
      this.G = getIntent().getStringExtra("resource");
      this.H = getIntent().getBooleanExtra("toGoldCouponsPage", false);
      if ("backOrError".equals(this.G))
      {
        j();
        p.o().a(false);
        paramBundle = this.c;
        paramBundle = paramBundle.c.a(paramBundle.f.f);
        p.o().a(true);
        int i1 = APTools.p(paramBundle);
        p.o().l();
        p.o().a(i1);
      }
      i();
      h();
      g();
      a.r().f = true;
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b("sdk.goldcoupons.select.keyback");
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    b("sdk.goldcoupons.select.show");
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements c7
  {
    public a() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity
 * JD-Core Version:    0.7.0.1
 */