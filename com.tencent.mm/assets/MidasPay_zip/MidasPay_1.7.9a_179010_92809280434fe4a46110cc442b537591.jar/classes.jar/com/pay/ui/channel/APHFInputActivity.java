package com.pay.ui.channel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.g6;
import midas.x.g6.a;
import midas.x.h5;
import midas.x.o4;
import midas.x.p4;
import midas.x.w4;
import midas.x.x4;
import midas.x.z4;
import midas.x.z5;

public class APHFInputActivity
  extends APActivity
{
  public AP3PointsLoading d;
  public View e;
  public EditText f;
  public ImageButton g;
  public LinearLayout h;
  public TextView i;
  public boolean j = false;
  public String k;
  
  public final void a(String paramString)
  {
    this.h.setVisibility(0);
    this.i.setText(paramString);
  }
  
  public final boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("1")) && (paramString.length() == 11);
  }
  
  public final void f()
  {
    if (this.j) {
      return;
    }
    if (this.a == 4) {
      p4.p().e().f.f = this.k;
    }
    finish();
    APUICommonMethod.a(this);
    overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
  }
  
  public final void g()
  {
    getWindow().setSoftInputMode(3);
  }
  
  public final void h()
  {
    this.j = false;
    Object localObject = this.f;
    if (localObject != null) {
      ((EditText)localObject).setEnabled(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(8);
      this.d.d();
    }
  }
  
  public final void i()
  {
    this.h.setVisibility(8);
  }
  
  public final void j()
  {
    this.c = p4.p().e();
    this.a = this.c.b.saveType;
  }
  
  public final void k()
  {
    this.d = ((AP3PointsLoading)findViewById(2131099667));
    this.e = findViewById(2131099666);
    h();
    ((Button)findViewById(2131099666)).setOnClickListener(new d());
  }
  
  public final void l()
  {
    Object localObject1 = (LinearLayout)findViewById(2131099674);
    this.f = ((EditText)findViewById(2131099673));
    this.g = ((ImageButton)findViewById(2131099672));
    this.h = ((LinearLayout)findViewById(2131099676));
    Object localObject2 = (ImageView)findViewById(2131099675);
    this.i = ((TextView)findViewById(2131099677));
    i();
    ((LinearLayout)localObject1).setOnFocusChangeListener(new b());
    this.f.addTextChangedListener(new e(null));
    localObject2 = APTools.v(this);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = APTools.p(this);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.f.setText((CharSequence)localObject1);
      this.f.setSelection(((String)localObject1).length());
    }
    this.g.setOnClickListener(new c());
  }
  
  public final void m()
  {
    if (this.a == 4)
    {
      this.k = p4.p().e().f.f;
      p4.p().e().f.f = "1";
    }
    Object localObject2 = (TextView)findViewById(2131100002);
    Object localObject3 = (TextView)findViewById(2131100005);
    int m = this.a;
    if ((m != 0) && (m != 1) && (m != 2) && (m != 3))
    {
      if (m != 4)
      {
        if (m != 5)
        {
          localObject1 = "";
        }
        else if (g6.k().e() == g6.a.a)
        {
          ((TextView)localObject2).setVisibility(8);
          localObject1 = this.c.c.b;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" × ");
          ((StringBuilder)localObject1).append(this.c.f.f);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
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
    ((TextView)localObject2).setText(this.c.c.b);
    ((TextView)localObject3).setText((CharSequence)localObject1);
    if (!APAppDataInterface.singleton().n()) {
      ((TextView)localObject3).setVisibility(4);
    }
    TextView localTextView3 = (TextView)findViewById(2131100000);
    TextView localTextView1 = (TextView)findViewById(2131100003);
    TextView localTextView2 = (TextView)findViewById(2131100007);
    Object localObject1 = this.c;
    localObject1 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
    if ((this.a == 0) && (!TextUtils.isEmpty(APHFChannel.v)))
    {
      localObject2 = this.c;
      localObject3 = ((x4)((o4)localObject2).c).b(((o4)localObject2).f.f, APHFChannel.v);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    else
    {
      if (this.a == 4)
      {
        localObject1 = this.c;
        localObject1 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
      }
      localObject2 = localObject1;
    }
    m = this.a;
    Object localObject4;
    if (m != 4)
    {
      localObject3 = localObject1;
      if (m != 5) {}
    }
    else
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(APHFChannel.w))
      {
        localObject3 = localObject1;
        if (!"0".equals(APHFChannel.w))
        {
          try
          {
            m = Integer.parseInt(APHFChannel.w);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            m = 0;
          }
          localObject4 = localObject1;
          if (m > 0) {
            localObject4 = APTools.a(m, 2);
          }
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getString(2131230879));
    ((StringBuilder)localObject1).append((String)localObject4);
    localTextView3.setText(((StringBuilder)localObject1).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject4).equals(localObject2)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230879));
      ((StringBuilder)localObject1).append((String)localObject2);
      localTextView1.setText(((StringBuilder)localObject1).toString());
      localTextView1.getPaint().setFlags(16);
      localTextView1.setVisibility(0);
      localTextView2.setVisibility(0);
      return;
    }
    localTextView1.setVisibility(4);
    localTextView2.setVisibility(4);
  }
  
  public final void n()
  {
    ((TextView)findViewById(2131100042)).setText("请输入手机号码");
    ((ImageButton)findViewById(2131099702)).setOnClickListener(new a());
  }
  
  public final void o()
  {
    n();
    m();
    l();
    k();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165185);
      j();
      o();
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public final void p()
  {
    this.j = true;
    Object localObject = this.f;
    if (localObject != null) {
      ((EditText)localObject).setEnabled(false);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((AP3PointsLoading)localObject).c();
      this.d.setVisibility(0);
    }
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APHFInputActivity.a(APHFInputActivity.this);
    }
  }
  
  public class b
    implements View.OnFocusChangeListener
  {
    public b() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (!paramBoolean) {
        APHFInputActivity.b(APHFInputActivity.this);
      }
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      APHFInputActivity.c(APHFInputActivity.this).setText("");
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      String str1 = APHFInputActivity.c(APHFInputActivity.this).getText().toString().trim();
      if (!APHFInputActivity.a(APHFInputActivity.this, str1))
      {
        APHFInputActivity.b(APHFInputActivity.this, "请输入正确的手机号码");
        return;
      }
      String str2 = APTools.p(APHFInputActivity.this);
      if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      APHFChannel.r = paramView;
      APHFChannel.s = str1;
      APHFChannel.t = str2;
      APHFInputActivity.d(APHFInputActivity.this);
      e5.h().a(APHFInputActivity.this, "hfpay", new Bundle(), new a(), null);
    }
    
    public class a
      implements h5
    {
      public a() {}
      
      public void a()
      {
        APHFInputActivity.e(APHFInputActivity.this);
      }
      
      public void a(int paramInt)
      {
        APHFInputActivity.e(APHFInputActivity.this);
      }
      
      public void a(int paramInt, String paramString1, String paramString2)
      {
        APHFInputActivity.e(APHFInputActivity.this);
      }
    }
  }
  
  public class e
    implements TextWatcher
  {
    public e() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() == 0) {
        APHFInputActivity.f(APHFInputActivity.this).setVisibility(8);
      } else {
        APHFInputActivity.f(APHFInputActivity.this).setVisibility(0);
      }
      if ((paramEditable.toString().length() > 0) && (!paramEditable.toString().startsWith("1")))
      {
        APHFInputActivity.c(APHFInputActivity.this).removeTextChangedListener(this);
        APHFInputActivity.c(APHFInputActivity.this).setText("1");
        APHFInputActivity.c(APHFInputActivity.this).setSelection(1);
        APHFInputActivity.c(APHFInputActivity.this).addTextChangedListener(this);
      }
      APHFInputActivity.g(APHFInputActivity.this);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFInputActivity
 * JD-Core Version:    0.7.0.1
 */