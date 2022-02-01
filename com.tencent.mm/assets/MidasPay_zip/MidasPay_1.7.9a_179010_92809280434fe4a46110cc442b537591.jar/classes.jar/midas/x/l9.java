package midas.x;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.plugin.APPluginActivity;

public class l9
  extends j9
{
  public LinearLayout c;
  public AP3PointsLoading d;
  public ImageButton e;
  public LinearLayout f;
  public Button g;
  public TextView h;
  public TextView i;
  public TextView j;
  public TextView k;
  public TextView l;
  public TextView m;
  public TextView n;
  public ImageView o;
  public String p = "";
  public o4 q;
  public int r;
  public LinearLayout s;
  public ImageView t;
  public TextView u;
  public EditText v;
  public ImageButton w;
  public String x = "";
  public View y;
  public Context z;
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.a = paramAPRecoChannelActivity;
    this.z = paramContext;
    this.q = p4.p().e();
    this.r = this.q.b.saveType;
    this.y = LayoutInflater.from(paramContext).inflate(2131165184, null);
    this.p = this.q.f.e;
    f();
    a(this.y);
    return this.y;
  }
  
  public void a()
  {
    super.a();
  }
  
  public final void a(View paramView)
  {
    j();
    i();
    e();
    h();
    g();
    this.c = ((LinearLayout)paramView.findViewById(2131099805));
    this.d = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.d.setVisibility(8);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.s;
    ImageView localImageView = this.t;
    TextView localTextView = this.u;
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(this.a.getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(this.a.getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      c();
    }
    return true;
  }
  
  public final void b(String paramString)
  {
    paramString = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    paramString.height = this.c.getMeasuredHeight();
    this.c.setVisibility(8);
    this.d.setLayoutParams(paramString);
    this.d.setVisibility(0);
    this.d.setText("");
    this.d.c();
    a(true);
  }
  
  public final void c()
  {
    if (APRecoChannelActivity.f()) {
      return;
    }
    if ((this.r == 4) && (!TextUtils.isEmpty(this.x))) {
      p4.p().e().f.f = this.x;
    }
    if (c6.s0().Q().equals("AndroidPay"))
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    this.a.finish();
    APUICommonMethod.a(this.a);
  }
  
  public final void d()
  {
    try
    {
      this.d.d();
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      a(false);
      APRecoChannelActivity.h = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void e()
  {
    this.f = ((LinearLayout)this.y.findViewById(2131099910));
    this.f.setOnClickListener(new b());
    this.o = ((ImageView)this.y.findViewById(2131100036));
    this.l = ((TextView)this.y.findViewById(2131100040));
    TextView localTextView1 = (TextView)this.y.findViewById(2131100041);
    TextView localTextView2 = (TextView)this.y.findViewById(2131099842);
    Object localObject = r6.j().b(this.p);
    if (localObject != null)
    {
      this.o.setVisibility(0);
      this.o.setBackgroundResource(((q6)localObject).c);
      this.l.setText(((q6)localObject).b);
    }
    else
    {
      this.o.setVisibility(4);
      this.l.setText("手机话费");
    }
    if ((this.r == 0) && (!TextUtils.isEmpty(APHFChannel.v)))
    {
      localObject = this.q;
      localObject = ((x4)((o4)localObject).c).b(((o4)localObject).f.f, APHFChannel.v);
      localTextView1.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(需支付");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("元)");
      localTextView1.setText(localStringBuilder.toString());
    }
    else
    {
      localTextView1.setVisibility(8);
    }
    if (this.r == 4)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText("每次买一个月");
    }
    else
    {
      localTextView1.setVisibility(8);
    }
    localTextView2.setText("");
    localTextView2.setVisibility(8);
  }
  
  public final void f()
  {
    if (this.r == 4)
    {
      this.x = p4.p().e().f.f;
      p4.p().e().f.f = "1";
    }
  }
  
  public final void g()
  {
    this.g = ((Button)this.y.findViewById(2131099704));
    this.g.setText("下一步");
    this.g.setOnClickListener(new d());
  }
  
  public final void h()
  {
    this.s = ((LinearLayout)this.y.findViewById(2131100018));
    this.t = ((ImageView)this.y.findViewById(2131100017));
    this.u = ((TextView)this.y.findViewById(2131100019));
    a(false, false, "");
    this.w = ((ImageButton)this.y.findViewById(2131099930));
    this.w.setOnClickListener(new c());
    this.v = ((EditText)this.y.findViewById(2131099931));
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });
    this.v.addTextChangedListener(new f(null));
    String str = APTools.p(this.a);
    if ((!TextUtils.isEmpty(str)) && (str.length() == 11)) {
      this.v.setText(str);
    }
  }
  
  public final void i()
  {
    this.i = ((TextView)this.y.findViewById(2131100002));
    this.i.setText(this.q.c.b);
    this.j = ((TextView)this.y.findViewById(2131100005));
    int i1 = this.r;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4)
      {
        if (i1 != 5)
        {
          localObject = "";
        }
        else if (g6.k().e() == g6.a.a)
        {
          this.i.setVisibility(8);
          localObject = this.q.c.b;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" × ");
          ((StringBuilder)localObject).append(this.q.f.f);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        this.i.setVisibility(8);
        localObject = this.q.c.b;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.z.getString(2131230829));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.q.f.f);
        ((StringBuilder)localObject).append(((z4)this.q.c).h());
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.z.getString(2131230829));
      ((StringBuilder)localObject).append(this.q.f.f);
      localObject = ((StringBuilder)localObject).toString();
    }
    i1 = this.r;
    if ((i1 != 3) && (i1 != 2))
    {
      if (APUICommonMethod.e())
      {
        localObject = (x4)this.q.c;
        this.j.setText(((x4)localObject).h());
      }
      else
      {
        localTextView = this.j;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(this.q.b.extendInfo.unit);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else {
      this.j.setText((CharSequence)localObject);
    }
    if (!APAppDataInterface.singleton().n()) {
      this.j.setVisibility(8);
    }
    this.k = ((TextView)this.y.findViewById(2131100000));
    Object localObject = this.q;
    localObject = ((o4)localObject).c.a(((o4)localObject).f.f);
    TextView localTextView = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.z.getString(2131230879));
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    this.n = ((TextView)this.y.findViewById(2131100007));
    this.m = ((TextView)this.y.findViewById(2131100003));
    this.n.setVisibility(8);
    this.m.setVisibility(8);
  }
  
  public final void j()
  {
    this.h = ((TextView)this.y.findViewById(2131100042));
    this.h.setText(p4.p().e().c.a);
    this.e = ((ImageButton)this.y.findViewById(2131099702));
    this.e.setOnClickListener(new a());
  }
  
  public final void k()
  {
    if ((this.r == 4) && (!TextUtils.isEmpty(this.x))) {
      p4.p().e().f.f = this.x;
    }
    new Bundle().putBoolean("isFromExpress", true);
    this.a.a(2, 1, null);
  }
  
  public final void l()
  {
    String str1 = this.p;
    String str2 = this.v.getText().toString().trim();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() == 11))
    {
      String str3 = APTools.p(this.z);
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str3))) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      APHFChannel.r = (String)localObject;
      APHFChannel.s = str2;
      APHFChannel.t = str3;
      b(str1);
      Object localObject = new Bundle();
      APRecoChannelActivity.h = true;
      e5.h().a(this.z, str1, (Bundle)localObject, new e(), null);
      return;
    }
    a(true, false, "请输入正确的手机号");
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      l9.a(l9.this);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      l9.b(l9.this);
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      l9.c(l9.this).setText("");
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      l9.d(l9.this);
    }
  }
  
  public class e
    implements h5
  {
    public e() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      l9.e(l9.this);
    }
    
    public void a(int paramInt)
    {
      APRecoChannelActivity.h = false;
      l9.e(l9.this);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      l9.e(l9.this);
    }
  }
  
  public class f
    implements TextWatcher
  {
    public f() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() == 0) {
        l9.f(l9.this).setVisibility(8);
      } else {
        l9.f(l9.this).setVisibility(0);
      }
      l9.a(l9.this, false, false, "");
      if ((paramEditable.toString().length() > 0) && (!paramEditable.toString().startsWith("1")))
      {
        l9.c(l9.this).removeTextChangedListener(this);
        l9.c(l9.this).setText("1");
        l9.c(l9.this).setSelection(1);
        l9.c(l9.this).addTextChangedListener(this);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l9
 * JD-Core Version:    0.7.0.1
 */