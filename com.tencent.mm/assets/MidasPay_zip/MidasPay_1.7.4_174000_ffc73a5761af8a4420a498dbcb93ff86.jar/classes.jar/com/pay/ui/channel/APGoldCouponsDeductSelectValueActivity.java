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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APLinearLayout;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fb;
import midas.x.fv;
import midas.x.fy;
import midas.x.gy;
import midas.x.o;
import midas.x.t;

public class APGoldCouponsDeductSelectValueActivity
  extends APActivity
  implements View.OnClickListener
{
  private static String a = "APGoldCouponsDeductSelectValueActivity";
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private TextView H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private String N;
  private String O;
  private String P = "";
  private boolean Q = false;
  private RelativeLayout b;
  private RelativeLayout c;
  private RelativeLayout d;
  private RelativeLayout e;
  private APLinearLayout q;
  private APLinearLayout r;
  private TextView s;
  private TextView t;
  private CheckBox u;
  private CheckBox v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(TextView paramTextView, String paramString1, String paramString2)
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
  
  private void a(t paramt)
  {
    if ("PriGold".equals(paramt.b()))
    {
      this.d.setVisibility(0);
      this.C.setText(paramt.d());
      localTextView = this.E;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("冻结");
      localStringBuilder.append(paramt.d());
      localStringBuilder.append("：");
      localStringBuilder.append(APTools.b(Integer.parseInt(paramt.a())));
      localTextView.setText(localStringBuilder.toString());
      this.G.setTag(paramt.d());
      return;
    }
    this.e.setVisibility(0);
    this.D.setText(paramt.d());
    TextView localTextView = this.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("冻结");
    localStringBuilder.append(paramt.d());
    localStringBuilder.append("：");
    localStringBuilder.append(APTools.b(Integer.parseInt(paramt.a())));
    localTextView.setText(localStringBuilder.toString());
    this.H.setTag(paramt.d());
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getVisibility() != 0)
      {
        if (this.L > this.I)
        {
          a(this.y, APTools.b(this.I), this.N);
          return;
        }
        a(this.y, APTools.b(this.L), this.N);
        return;
      }
      if (this.v.isChecked())
      {
        if (this.L + this.M > this.I)
        {
          a(this.y, APTools.b(this.L), this.N);
          a(this.B, APTools.b(this.I - this.L), this.O);
          return;
        }
        a(this.y, APTools.b(this.L), this.N);
        a(this.B, APTools.b(this.M), this.O);
        return;
      }
      if (this.L > this.I)
      {
        a(this.y, APTools.b(this.I), this.N);
        return;
      }
      a(this.y, APTools.b(this.L), this.N);
      return;
    }
    if (this.c.getVisibility() != 0)
    {
      a(this.y, "", "");
      return;
    }
    if (this.v.isChecked()) {
      if (this.M >= this.I) {
        a(this.B, APTools.b(this.I), this.O);
      } else {
        a(this.B, APTools.b(this.M), this.O);
      }
    }
    a(this.y, "", "");
  }
  
  private void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      String str = paramArrayOfString[0];
      paramArrayOfString = paramArrayOfString[1];
      ArrayList localArrayList = o.a().g();
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        while (i < localArrayList.size())
        {
          t localt = (t)localArrayList.get(i);
          if ((localt.c().equals(str)) && (Integer.parseInt(localt.e()) > 0))
          {
            localt.e(String.valueOf(Integer.parseInt(localt.e()) - Integer.parseInt(paramArrayOfString)));
            if (TextUtils.isEmpty(localt.a()))
            {
              localt.a(paramArrayOfString);
              return;
            }
            localt.a(String.valueOf(Integer.parseInt(localt.a()) + Integer.parseInt(paramArrayOfString)));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private void b()
  {
    Object localObject = URLDecoder.decode(URLDecoder.decode(o.a().l()).replace("SPResRuleList=", "").trim());
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
  
  private void b(String paramString)
  {
    APDataReportManager.getInstance().insertData(paramString, this.f, em.b().n().e.l, em.b().n().e.f, null);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b.getVisibility() != 0)
      {
        if (this.M > this.I)
        {
          a(this.B, APTools.b(this.I), this.O);
          return;
        }
        a(this.B, APTools.b(this.M), this.O);
        return;
      }
      if (this.u.isChecked())
      {
        if (this.L + this.M > this.I)
        {
          a(this.y, APTools.b(this.L), this.N);
          a(this.B, APTools.b(this.I - this.L), this.O);
          return;
        }
        a(this.y, APTools.b(this.L), this.N);
        a(this.B, APTools.b(this.M), this.O);
        return;
      }
      if (this.M > this.I)
      {
        a(this.B, APTools.b(this.I), this.O);
        return;
      }
      a(this.B, APTools.b(this.M), this.O);
      return;
    }
    if (this.b.getVisibility() != 0)
    {
      a(this.B, "", "");
      return;
    }
    if (this.u.isChecked()) {
      if (this.L >= this.I) {
        a(this.y, APTools.b(this.I), this.N);
      } else {
        a(this.y, APTools.b(this.L), this.N);
      }
    }
    a(this.B, "", "");
  }
  
  private void c()
  {
    this.d = ((RelativeLayout)findViewById(2131099872));
    this.e = ((RelativeLayout)findViewById(2131099874));
    this.C = ((TextView)findViewById(2131099876));
    this.D = ((TextView)findViewById(2131099878));
    this.E = ((TextView)findViewById(2131099865));
    this.F = ((TextView)findViewById(2131099868));
    this.G = ((TextView)findViewById(2131099901));
    this.G.setOnClickListener(this);
    this.H = ((TextView)findViewById(2131099902));
    this.H.setOnClickListener(this);
  }
  
  private void c(String paramString)
  {
    t localt;
    if ("PriGold".equals(paramString))
    {
      paramString = o.a().g().iterator();
      while (paramString.hasNext())
      {
        localt = (t)paramString.next();
        if (("PriGold".equals(localt.b())) && (localt.f())) {
          b("sdk.goldcoupons.select.private");
        }
      }
    }
    paramString = o.a().g().iterator();
    while (paramString.hasNext())
    {
      localt = (t)paramString.next();
      if ((!"PriGold".equals(localt.b())) && (localt.f())) {
        b("sdk.goldcoupons.select.share");
      }
    }
  }
  
  private void d()
  {
    o.a().a(false);
    Object localObject1 = this.p.b.a(this.p.e.g);
    o.a().a(true);
    this.I = APTools.g((String)localObject1);
    this.u.setChecked(false);
    this.v.setChecked(false);
    Object localObject3 = o.a().g();
    int i = ((ArrayList)localObject3).size();
    localObject1 = null;
    if (i > 0) {
      localObject2 = (t)((ArrayList)localObject3).get(0);
    } else {
      localObject2 = null;
    }
    if (((ArrayList)localObject3).size() > 1) {
      localObject1 = (t)((ArrayList)localObject3).get(1);
    }
    i = this.I;
    int j = 2131034126;
    Object localObject4;
    boolean bool;
    if (localObject2 != null)
    {
      this.J = Integer.parseInt(((t)localObject2).e());
      this.N = ((t)localObject2).d();
      localObject4 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goldType:");
      localStringBuilder.append(((t)localObject2).b());
      localStringBuilder.append(";goldNum:");
      localStringBuilder.append(((t)localObject2).e());
      APLog.i((String)localObject4, localStringBuilder.toString());
      this.w.setText(((t)localObject2).d());
      localObject4 = this.x;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("余额：");
      localStringBuilder.append(APTools.b(this.J));
      ((TextView)localObject4).setText(localStringBuilder.toString());
      this.b.setVisibility(0);
      bool = ((t)localObject2).f();
      this.u.setChecked(bool);
      localObject4 = this.u;
      if (bool) {
        i = 2131034126;
      } else {
        i = 2131034125;
      }
      ((CheckBox)localObject4).setBackgroundResource(i);
      this.L = ((t)localObject2).g();
      if (o.a().b(this.I))
      {
        i = 0;
        break label355;
      }
    }
    i = 1;
    label355:
    if (i != 0)
    {
      if (localObject1 != null)
      {
        this.K = Integer.parseInt(((t)localObject1).e());
        this.O = ((t)localObject1).d();
        localObject2 = a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("goldType:");
        ((StringBuilder)localObject4).append(((t)localObject1).b());
        ((StringBuilder)localObject4).append(";goldNum:");
        ((StringBuilder)localObject4).append(((t)localObject1).e());
        APLog.i((String)localObject2, ((StringBuilder)localObject4).toString());
        this.z.setText(((t)localObject1).d());
        localObject2 = this.A;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("余额：");
        ((StringBuilder)localObject4).append(APTools.b(this.K));
        ((TextView)localObject2).setText(((StringBuilder)localObject4).toString());
        this.c.setVisibility(0);
        bool = ((t)localObject1).f();
        this.v.setChecked(bool);
        localObject2 = this.v;
        if (bool) {
          i = j;
        } else {
          i = 2131034125;
        }
        ((CheckBox)localObject2).setBackgroundResource(i);
        this.M = ((t)localObject1).g();
      }
    }
    else if (localObject1 != null) {
      ((t)localObject1).a(false);
    }
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
      if (((ArrayList)localObject3).size() == 1)
      {
        localObject1 = (t)((ArrayList)localObject3).get(0);
        if (!TextUtils.isEmpty(((t)localObject1).a())) {
          a((t)localObject1);
        }
      }
      else if (((ArrayList)localObject3).size() > 1)
      {
        localObject1 = (t)((ArrayList)localObject3).get(0);
        if (!TextUtils.isEmpty(((t)localObject1).a())) {
          a((t)localObject1);
        }
        localObject1 = (t)((ArrayList)localObject3).get(1);
        if (!TextUtils.isEmpty(((t)localObject1).a())) {
          a((t)localObject1);
        }
      }
    }
    if (this.J <= 0)
    {
      this.u.setChecked(false);
      this.q.setEnabled(false);
      this.u.setBackgroundResource(2131034125);
      this.b.setVisibility(8);
    }
    if (this.K <= 0)
    {
      this.v.setChecked(false);
      this.r.setEnabled(false);
      this.v.setBackgroundResource(2131034125);
      this.c.setVisibility(8);
    }
    a(this.u.isChecked());
    b(this.v.isChecked());
    this.s = ((TextView)findViewById(2131099717));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("MonthlyCleared = ");
    ((StringBuilder)localObject1).append(fy.a().V());
    APLog.w("APGoldCouponsDeuctSelectValueActivity", ((StringBuilder)localObject1).toString());
    if (fy.a().V())
    {
      this.s.setVisibility(0);
      localObject1 = "";
      if (!TextUtils.isEmpty(this.N))
      {
        localObject2 = this.N;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.O))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("和");
          ((StringBuilder)localObject1).append(this.O);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("所有");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("月底清零，请及时使用");
        localObject1 = ((StringBuilder)localObject2).toString();
        this.s.setText((CharSequence)localObject1);
      }
      else
      {
        this.s.setVisibility(8);
      }
    }
    else
    {
      this.s.setVisibility(8);
    }
    Object localObject2 = (LinearLayout)findViewById(2131099722);
    localObject1 = o.a().d(this.I);
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
  
  private void h()
  {
    ArrayList localArrayList = o.a().g();
    int i = localArrayList.size();
    t localt2 = null;
    t localt1;
    if (i > 0) {
      localt1 = (t)localArrayList.get(0);
    } else {
      localt1 = null;
    }
    if (localArrayList.size() > 1) {
      localt2 = (t)localArrayList.get(1);
    }
    if (localt1 != null) {
      this.L = localt1.g();
    }
    if (localt2 != null) {
      this.M = localt2.g();
    }
  }
  
  private void i()
  {
    if ("backOrError".equals(this.P))
    {
      if ((!fb.a().f()) && (!this.Q))
      {
        setResult(0);
        finish();
        APUICommonMethod.b(this);
        overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
        return;
      }
      startActivity(new Intent(this, APGoldCouponsDeductActivity.class));
      finish();
      APUICommonMethod.b(this);
      APUICommonMethod.b();
      return;
    }
    setResult(0);
    finish();
    APUICommonMethod.b(this);
    overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
  }
  
  protected void a()
  {
    this.q = ((APLinearLayout)findViewById(2131099871));
    this.r = ((APLinearLayout)findViewById(2131099873));
    this.t = ((TextView)findViewById(2131099920));
    this.u = ((CheckBox)findViewById(2131099825));
    this.v = ((CheckBox)findViewById(2131099826));
    this.b = ((RelativeLayout)findViewById(2131099893));
    this.c = ((RelativeLayout)findViewById(2131099894));
    this.w = ((TextView)findViewById(2131099875));
    this.x = ((TextView)findViewById(2131099864));
    this.y = ((TextView)findViewById(2131099866));
    this.z = ((TextView)findViewById(2131099877));
    this.A = ((TextView)findViewById(2131099867));
    this.B = ((TextView)findViewById(2131099869));
    this.u.setChecked(true);
    this.v.setChecked(true);
    APLinearLayout localAPLinearLayout = this.q;
    APLinearLayout.setClickAble(false);
    localAPLinearLayout = this.r;
    APLinearLayout.setClickAble(false);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this);
    locala.a(paramString);
    locala.a("我知道了", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int k = this.q.getId();
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    int i = 2131034125;
    boolean bool;
    if (j == k)
    {
      bool = this.u.isChecked();
      this.u.setChecked(bool ^ true);
      paramView = this.u;
      if (!bool) {
        i = 2131034126;
      }
      paramView.setBackgroundResource(i);
      localArrayList2 = o.a().g();
      paramView = localArrayList1;
      if (localArrayList2.size() > 0) {
        paramView = (t)localArrayList2.get(0);
      }
      if (paramView != null)
      {
        paramView.a(bool ^ true);
        o.a().c(this.I);
        h();
      }
      a(this.u.isChecked());
      paramView = (t)o.a().g().get(0);
      if (paramView != null) {
        c(paramView.b());
      }
    }
    else if (paramView.getId() == this.r.getId())
    {
      bool = this.v.isChecked();
      this.v.setChecked(bool ^ true);
      paramView = this.v;
      if (!bool) {
        i = 2131034126;
      }
      paramView.setBackgroundResource(i);
      localArrayList1 = o.a().g();
      paramView = localArrayList2;
      if (localArrayList1.size() > 1) {
        paramView = (t)localArrayList1.get(1);
      }
      if (paramView != null)
      {
        paramView.a(bool ^ true);
        o.a().c(this.I);
        h();
      }
      b(this.v.isChecked());
      paramView = (t)o.a().g().get(1);
      if (paramView != null) {
        c(paramView.b());
      }
    }
    else
    {
      if (paramView.getId() == this.t.getId())
      {
        b("sdk.goldcoupons.select.sure");
        i();
        return;
      }
      if (paramView.getId() == this.G.getId())
      {
        a(getString(2131230787).replace("宝券", (String)this.G.getTag()));
        return;
      }
      if (paramView.getId() == this.H.getId()) {
        a(getString(2131230787).replace("宝券", (String)this.H.getTag()));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setRequestedOrientation(1);
      this.f = this.p.a.saveType;
      setContentView(2131165214);
      this.P = getIntent().getStringExtra("resource");
      this.Q = getIntent().getBooleanExtra("toGoldCouponsPage", false);
      if ("backOrError".equals(this.P))
      {
        b();
        o.a().a(false);
        paramBundle = this.p.b.a(this.p.e.g);
        o.a().a(true);
        int i = APTools.g(paramBundle);
        o.a().j();
        o.a().c(i);
      }
      a();
      c();
      d();
      a.a().f = true;
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b("sdk.goldcoupons.select.keyback");
      i();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity
 * JD-Core Version:    0.7.0.1
 */