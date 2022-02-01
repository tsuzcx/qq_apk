package com.pay.ui.payCenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.er;
import midas.x.et;
import midas.x.ex;
import midas.x.ey;
import midas.x.ez;
import midas.x.fa;
import midas.x.fb;
import midas.x.fv;
import midas.x.fy;
import midas.x.gn;

public class APQDQBRechargeActivity
  extends APActivity
{
  int a = -1;
  private EditText b;
  private TextView c;
  private TextWatcher d = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      String str = paramAnonymousEditable.toString().trim();
      paramAnonymousEditable = new StringBuilder();
      paramAnonymousEditable.append("afterTextChanged num:");
      paramAnonymousEditable.append(str);
      APLog.i("APQDQBRecharge", paramAnonymousEditable.toString());
      if (str.toString().equals("0")) {
        APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).setText("");
      }
      paramAnonymousEditable = str;
      if (TextUtils.isEmpty(str)) {
        paramAnonymousEditable = "0";
      }
      APQDQBRechargeActivity.b(APQDQBRechargeActivity.this).setText(em.b().n().b.b(paramAnonymousEditable));
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  private void b()
  {
    Object localObject1 = (TextView)findViewById(2131100013);
    ((TextView)localObject1).setText(em.b().n().d.k);
    Object localObject2 = em.b().n().d.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ号：");
    localStringBuilder.append((String)localObject2);
    ((TextView)localObject1).setText(localStringBuilder.toString());
    localObject2 = (TextView)findViewById(2131099803);
    if (this.a == 3)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(em.b().n().d.b());
      ((StringBuilder)localObject1).append(" Q币");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(em.b().n().d.a());
      ((StringBuilder)localObject1).append(" Q点");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = (TextView)findViewById(2131099951);
    if (this.a == 3) {
      ((TextView)localObject1).setText("Q币充值");
    } else {
      ((TextView)localObject1).setText("Q点充值");
    }
    localObject1 = em.b().n().e.g;
    this.b = ((EditText)findViewById(2131099963));
    this.b.setText((CharSequence)localObject1);
    this.b.setSelection(((String)localObject1).length());
    this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.b.addTextChangedListener(this.d);
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).setCursorVisible(true);
        return false;
      }
    });
    this.c = ((TextView)findViewById(2131099851));
    this.c.setText(em.b().n().b.b((String)localObject1));
    ((Button)findViewById(2131099962)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).getText().toString().trim();
        if (APQDQBRechargeActivity.c(APQDQBRechargeActivity.this))
        {
          APDataReportManager.getInstance().insertData("sdk.accountinput.sure", APQDQBRechargeActivity.this.a, em.b().n().e.l, paramAnonymousView, null);
          APQDQBRechargeActivity.this.a();
        }
      }
    });
    ((ImageView)findViewById(2131099702)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.accountinput.close", APQDQBRechargeActivity.this.a, em.b().n().e.l, null, null);
        em.b().p();
        APQDQBRechargeActivity.this.finish();
        APUICommonMethod.b();
        fv.a(2, "");
      }
    });
  }
  
  private int c()
  {
    int i = em.b().n().b.b();
    int j = em.b().n().d.g;
    if (i % 100 == 0) {
      i /= 100;
    } else {
      i = i / 100 + 1;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    return j;
  }
  
  private int d()
  {
    int i = em.b().n().b.b();
    int j = em.b().n().d.g;
    if (i % 10 == 0) {
      i /= 10;
    } else {
      i = i / 10 + 1;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    return j;
  }
  
  private boolean h()
  {
    return !TextUtils.isEmpty(this.b.getText().toString().trim());
  }
  
  protected void a()
  {
    em.b().n().e.g = this.b.getText().toString().trim();
    g();
    fb.a().a(this, "", null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165244);
      a.a().f = true;
      fy.a().s(true);
      APHFChannel.f();
      try
      {
        el localel1 = em.b().n();
        el localel2 = (el)localel1.clone();
        String str1;
        String str2;
        if (gn.a().g() == 11)
        {
          this.a = 3;
          paramBundle = String.valueOf(c());
          str1 = String.valueOf(c());
          str2 = "Q币";
          localel2.b = new ex();
          localel2.c = new er();
          localel2.b.e = "100";
        }
        else
        {
          this.a = 2;
          paramBundle = String.valueOf(d());
          str1 = String.valueOf(d());
          str2 = "Q点";
          localel2.b = new ey();
          localel2.c = new er();
          localel2.b.e = "10";
        }
        localel2.a.saveType = this.a;
        localel2.a.saveValue = paramBundle;
        localel2.e.g = str1;
        localel2.b.b = str2;
        localel2.b.a = localel1.b.a;
        em.b().a(localel2);
      }
      catch (CloneNotSupportedException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      b();
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData("sdk.accountinput.keyback", this.a, em.b().n().e.l, null, null);
      em.b().p();
      finish();
      APUICommonMethod.b();
      fv.a(2, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.accountinput.show", this.a, em.b().n().e.l, null, null);
    super.onResume();
  }
  
  public void onStop()
  {
    g();
    APUICommonMethod.g();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payCenter.APQDQBRechargeActivity
 * JD-Core Version:    0.7.0.1
 */