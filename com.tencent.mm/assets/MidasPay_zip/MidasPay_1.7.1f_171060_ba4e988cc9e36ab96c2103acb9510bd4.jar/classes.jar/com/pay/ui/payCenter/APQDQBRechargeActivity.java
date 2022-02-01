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
import midas.x.ec;
import midas.x.ed;
import midas.x.ei;
import midas.x.ek;
import midas.x.eo;
import midas.x.ep;
import midas.x.eq;
import midas.x.er;
import midas.x.es;
import midas.x.fm;
import midas.x.fp;
import midas.x.gd;

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
      APQDQBRechargeActivity.b(APQDQBRechargeActivity.this).setText(ed.b().n().b.b(paramAnonymousEditable));
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  private void b()
  {
    Object localObject1 = (TextView)findViewById(2131100013);
    ((TextView)localObject1).setText(ed.b().n().d.k);
    Object localObject2 = ed.b().n().d.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ号：");
    localStringBuilder.append((String)localObject2);
    ((TextView)localObject1).setText(localStringBuilder.toString());
    localObject2 = (TextView)findViewById(2131099803);
    if (this.a == 3)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(ed.b().n().d.b());
      ((StringBuilder)localObject1).append(" Q币");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(ed.b().n().d.a());
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
    localObject1 = ed.b().n().e.g;
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
    this.c.setText(ed.b().n().b.b((String)localObject1));
    ((Button)findViewById(2131099962)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).getText().toString().trim();
        if (APQDQBRechargeActivity.c(APQDQBRechargeActivity.this))
        {
          APDataReportManager.getInstance().insertData("sdk.accountinput.sure", APQDQBRechargeActivity.this.a, ed.b().n().e.l, paramAnonymousView, null);
          APQDQBRechargeActivity.this.a();
        }
      }
    });
    ((ImageView)findViewById(2131099702)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.accountinput.close", APQDQBRechargeActivity.this.a, ed.b().n().e.l, null, null);
        ed.b().p();
        APQDQBRechargeActivity.this.finish();
        APUICommonMethod.b();
        fm.a(2, "");
      }
    });
  }
  
  private int c()
  {
    int i = ed.b().n().b.b();
    int j = ed.b().n().d.g;
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
    int i = ed.b().n().b.b();
    int j = ed.b().n().d.g;
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
    ed.b().n().e.g = this.b.getText().toString().trim();
    g();
    es.a().a(this, "", null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      setContentView(2131165243);
      a.a().f = true;
      fp.a().s(true);
      APHFChannel.f();
      try
      {
        ec localec1 = ed.b().n();
        ec localec2 = (ec)localec1.clone();
        String str1;
        String str2;
        if (gd.a().g() == 11)
        {
          this.a = 3;
          paramBundle = String.valueOf(c());
          str1 = String.valueOf(c());
          str2 = "Q币";
          localec2.b = new eo();
          localec2.c = new ei();
          localec2.b.e = "100";
        }
        else
        {
          this.a = 2;
          paramBundle = String.valueOf(d());
          str1 = String.valueOf(d());
          str2 = "Q点";
          localec2.b = new ep();
          localec2.c = new ei();
          localec2.b.e = "10";
        }
        localec2.a.saveType = this.a;
        localec2.a.saveValue = paramBundle;
        localec2.e.g = str1;
        localec2.b.b = str2;
        localec2.b.a = localec1.b.a;
        ed.b().a(localec2);
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
      APDataReportManager.getInstance().insertData("sdk.accountinput.keyback", this.a, ed.b().n().e.l, null, null);
      ed.b().p();
      finish();
      APUICommonMethod.b();
      fm.a(2, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.accountinput.show", this.a, ed.b().n().e.l, null, null);
    super.onResume();
  }
  
  public void onStop()
  {
    g();
    APUICommonMethod.g();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.payCenter.APQDQBRechargeActivity
 * JD-Core Version:    0.7.0.1
 */