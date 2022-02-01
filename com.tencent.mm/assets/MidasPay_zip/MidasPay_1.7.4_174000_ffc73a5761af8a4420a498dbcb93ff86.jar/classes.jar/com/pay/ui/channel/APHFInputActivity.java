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
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.eu;
import midas.x.ew;
import midas.x.fa;
import midas.x.fb;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;
import midas.x.gc;
import midas.x.gc.a;

public class APHFInputActivity
  extends APActivity
{
  protected AP3PointsLoading a;
  private View b;
  private EditText c;
  private ImageButton d;
  private LinearLayout e;
  private ImageView q;
  private TextView r;
  private boolean s = false;
  private String t;
  
  private void a()
  {
    this.p = em.b().n();
    this.f = this.p.a.saveType;
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("1")) && (paramString.length() == 11);
  }
  
  private void b()
  {
    c();
    d();
    h();
    i();
  }
  
  private void b(String paramString)
  {
    this.e.setVisibility(0);
    this.r.setText(paramString);
  }
  
  private void c()
  {
    ((TextView)findViewById(2131100042)).setText("请输入手机号码");
    ((ImageButton)findViewById(2131099702)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APHFInputActivity.a(APHFInputActivity.this);
      }
    });
  }
  
  private void d()
  {
    if (this.f == 4)
    {
      this.t = em.b().n().e.g;
      em.b().n().e.g = "1";
    }
    Object localObject2 = (TextView)findViewById(2131100002);
    Object localObject3 = (TextView)findViewById(2131100005);
    Object localObject1 = "";
    switch (this.f)
    {
    default: 
      break;
    case 5: 
      if (gc.a().f() == gc.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" × ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 4: 
      if (gc.a().f() == gc.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        ((StringBuilder)localObject1).append(((ew)this.p.b).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230829));
      ((StringBuilder)localObject1).append(this.p.e.g);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText(this.p.b.b);
    ((TextView)localObject3).setText((CharSequence)localObject1);
    if (!APAppDataInterface.singleton().h()) {
      ((TextView)localObject3).setVisibility(4);
    }
    TextView localTextView3 = (TextView)findViewById(2131100000);
    TextView localTextView1 = (TextView)findViewById(2131100003);
    TextView localTextView2 = (TextView)findViewById(2131100007);
    localObject1 = this.p.b.a(this.p.e.g);
    if ((this.f == 0) && (!TextUtils.isEmpty(APHFChannel.o)))
    {
      localObject3 = ((eu)this.p.b).b(this.p.e.g, APHFChannel.o);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    else
    {
      if (this.f == 4) {
        localObject1 = this.p.b.a(this.p.e.g);
      }
      localObject2 = localObject1;
    }
    Object localObject4;
    if (this.f != 4)
    {
      localObject3 = localObject1;
      if (this.f != 5) {}
    }
    else
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(APHFChannel.p))
      {
        localObject3 = localObject1;
        if (!"0".equals(APHFChannel.p))
        {
          int i;
          try
          {
            i = Integer.parseInt(APHFChannel.p);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i = 0;
          }
          localObject4 = localObject1;
          if (i > 0) {
            localObject4 = APTools.a(i, 2);
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
  
  private void h()
  {
    Object localObject = (LinearLayout)findViewById(2131099674);
    this.c = ((EditText)findViewById(2131099673));
    this.d = ((ImageButton)findViewById(2131099672));
    this.e = ((LinearLayout)findViewById(2131099676));
    this.q = ((ImageView)findViewById(2131099675));
    this.r = ((TextView)findViewById(2131099677));
    m();
    ((LinearLayout)localObject).setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          APHFInputActivity.b(APHFInputActivity.this);
        }
      }
    });
    this.c.addTextChangedListener(new a(null));
    String str = APTools.i(this);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = APTools.h(this);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.c.setText((CharSequence)localObject);
      this.c.setSelection(((String)localObject).length());
    }
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APHFInputActivity.c(APHFInputActivity.this).setText("");
      }
    });
  }
  
  private void i()
  {
    this.a = ((AP3PointsLoading)findViewById(2131099667));
    this.b = findViewById(2131099666);
    l();
    ((Button)findViewById(2131099666)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = APHFInputActivity.c(APHFInputActivity.this).getText().toString().trim();
        if (!APHFInputActivity.a(APHFInputActivity.this, str1))
        {
          APHFInputActivity.b(APHFInputActivity.this, "请输入正确的手机号码");
          return;
        }
        String str2 = APTools.h(APHFInputActivity.this);
        if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {
          paramAnonymousView = "1";
        } else {
          paramAnonymousView = "2";
        }
        APHFChannel.k = paramAnonymousView;
        APHFChannel.l = str1;
        APHFChannel.m = str2;
        APHFInputActivity.d(APHFInputActivity.this);
        fb.a().a(APHFInputActivity.this, "hfpay", new Bundle(), new fe()
        {
          public void a()
          {
            APHFInputActivity.e(APHFInputActivity.this);
          }
          
          public void a(int paramAnonymous2Int)
          {
            APHFInputActivity.e(APHFInputActivity.this);
          }
          
          public void a(int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            APHFInputActivity.e(APHFInputActivity.this);
          }
        }, null);
      }
    });
  }
  
  private void j()
  {
    if (this.s) {
      return;
    }
    if (this.f == 4) {
      em.b().n().e.g = this.t;
    }
    finish();
    APUICommonMethod.b(this);
    overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
  }
  
  private void k()
  {
    this.s = true;
    if (this.c != null) {
      this.c.setEnabled(false);
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.a != null)
    {
      this.a.b();
      this.a.setVisibility(0);
    }
  }
  
  private void l()
  {
    this.s = false;
    if (this.c != null) {
      this.c.setEnabled(true);
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    if (this.a != null)
    {
      this.a.setVisibility(8);
      this.a.a();
    }
  }
  
  private void m()
  {
    this.e.setVisibility(8);
  }
  
  private void n()
  {
    getWindow().setSoftInputMode(3);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165185);
      a();
      b();
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j();
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
  
  class a
    implements TextWatcher
  {
    private a() {}
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFInputActivity
 * JD-Core Version:    0.7.0.1
 */