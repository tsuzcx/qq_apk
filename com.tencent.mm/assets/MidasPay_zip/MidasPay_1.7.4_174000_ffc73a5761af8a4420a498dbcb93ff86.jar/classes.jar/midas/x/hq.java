package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APScrollTextView;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class hq
  extends ho
{
  protected el a = null;
  TextWatcher b = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      Object localObject = paramAnonymousEditable.toString().trim();
      if (((String)localObject).length() == 0)
      {
        hq.a(hq.this, "");
      }
      else if (((String)localObject).toString().equals("0"))
      {
        hq.a(hq.this).setText("");
        hq.a(hq.this, "");
      }
      else if (i.a((String)localObject) > hq.b(hq.this))
      {
        if (hq.this.a.a.saveType == 4)
        {
          if (((ew)hq.this.a.b).l == 3)
          {
            paramAnonymousEditable = hq.c(hq.this);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("升级时长最多不超过");
            ((StringBuilder)localObject).append(hq.b(hq.this));
            ((StringBuilder)localObject).append("个月");
            APUICommonMethod.a(paramAnonymousEditable, ((StringBuilder)localObject).toString());
            hq.a(hq.this).setText(String.valueOf(hq.b(hq.this)));
            return;
          }
          APUICommonMethod.a(hq.c(hq.this), "购买数量不能超过最大限制");
        }
        else if (hq.this.a.a.saveType != 0) {}
      }
      try
      {
        paramAnonymousEditable.delete(paramAnonymousEditable.length() - 1, paramAnonymousEditable.length());
        label237:
        APUICommonMethod.a(hq.c(hq.this), "购买数量不能超过最大限制");
        break label264;
        APUICommonMethod.a(hq.c(hq.this), "购买数量不能超过最大限制");
        label264:
        hq.a(hq.this, (String)localObject);
        int i = hq.a(hq.this).getText().length();
        if (i > 0) {
          hq.a(hq.this).setSelection(i);
        }
        hq.this.e();
        return;
      }
      catch (Exception paramAnonymousEditable)
      {
        break label237;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private int c = 1;
  private int d = 1;
  private Activity e = null;
  private View f = null;
  private ImageView g;
  private EditText h;
  private TextView i;
  private TextView j;
  private LinearLayout k;
  private LinearLayout l;
  private TextView m;
  private TextView n;
  private TextView o;
  private LinearLayout p;
  private TextView q;
  private TextView r;
  private TextView s;
  private CheckBox t;
  private boolean u = false;
  
  public hq(Activity paramActivity, el paramel)
  {
    this.e = paramActivity;
    this.a = paramel;
  }
  
  private void a(String paramString)
  {
    if ((this.a.a.saveType == 0) && ((ac.a().c()) || (ac.a().d())))
    {
      this.k.setVisibility(0);
      if (TextUtils.isEmpty(paramString))
      {
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.q.setText("");
        return;
      }
      int i2 = i.a(paramString);
      boolean bool = ac.a().d();
      Object localObject1 = null;
      if (bool)
      {
        paramString = ac.a().h(i2);
        if ((paramString != null) && (paramString.size() > 0))
        {
          this.n.setText("首充");
          this.n.setVisibility(0);
        }
        else
        {
          this.n.setVisibility(8);
        }
      }
      else
      {
        this.n.setVisibility(8);
        paramString = null;
      }
      Object localObject2 = ac.a().b(i2);
      int i1;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((y)localObject2).c)))
      {
        this.o.setText(((y)localObject2).c);
        this.o.setVisibility(0);
        i1 = 1;
      }
      else
      {
        this.o.setVisibility(8);
        i1 = 0;
      }
      if (ac.a().c())
      {
        localObject1 = ac.a().e(i2);
        if (i1 == 0)
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            this.m.setText("满赠");
            this.m.setVisibility(0);
          }
          else
          {
            this.m.setVisibility(8);
          }
        }
        else {
          this.m.setVisibility(8);
        }
      }
      else
      {
        this.m.setVisibility(8);
      }
      this.a.e.g = String.valueOf(i2);
      localObject1 = ac.a().a(paramString, (ArrayList)localObject1);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        paramString = new StringBuffer();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (v)((Iterator)localObject1).next();
          paramString.append(((v)localObject2).a);
          paramString.append("×");
          paramString.append(((v)localObject2).b);
          paramString.append(",");
        }
        if (paramString.length() > 0)
        {
          paramString = paramString.substring(0, paramString.length() - 1).toString();
          this.q.setText(paramString);
          return;
        }
        this.q.setText("");
        return;
      }
      this.q.setText("");
      return;
    }
    this.k.setVisibility(8);
  }
  
  private void f()
  {
    g();
    this.g = ((ImageView)this.f.findViewById(2131099973));
    this.h = ((EditText)this.f.findViewById(2131099974));
    this.i = ((TextView)this.f.findViewById(2131099975));
    this.j = ((TextView)this.f.findViewById(2131099972));
    this.k = ((LinearLayout)this.f.findViewById(2131099981));
    this.l = ((LinearLayout)this.f.findViewById(2131099979));
    this.n = ((TextView)this.f.findViewById(2131099977));
    this.m = ((TextView)this.f.findViewById(2131099978));
    this.o = ((TextView)this.f.findViewById(2131099980));
    this.p = ((LinearLayout)this.f.findViewById(2131099983));
    this.q = ((TextView)this.f.findViewById(2131099982));
    this.r = ((TextView)this.f.findViewById(2131099985));
    this.s = ((TextView)this.f.findViewById(2131099986));
    if (this.a.a.saveType == 4) {
      this.i.setVisibility(0);
    } else {
      this.i.setVisibility(8);
    }
    if ((em.b().n().a.resId == 0) && (em.b().n().a.resData == null))
    {
      ((TextView)this.f.findViewById(2131099984)).setVisibility(0);
      this.g.setVisibility(8);
    }
    else
    {
      ((TextView)this.f.findViewById(2131099984)).setVisibility(8);
      APUICommonMethod.a(this.g);
    }
    this.j.setText("确定");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = hq.a(hq.this).getText().toString();
        if (!TextUtils.isEmpty(paramAnonymousView))
        {
          hq.this.a.e.g = paramAnonymousView;
          hq.this.d();
          return;
        }
        Toast.makeText(hq.c(hq.this), "充值数量不能为空", 1).show();
      }
    });
    int i1 = this.c;
    if ((this.a.a.saveType != 0) || (fy.a().ae() <= 0)) {
      this.h.setFilters(new InputFilter[] { new InputFilter.LengthFilter(String.valueOf(i1).length()) });
    }
    this.h.addTextChangedListener(this.b);
    this.h.setText(this.a.e.g);
    this.h.setSelection(this.a.e.g.length());
    this.h.setFocusable(true);
    this.h.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionId: ");
        localStringBuilder.append(paramAnonymousInt);
        localStringBuilder.append(" event: ");
        localStringBuilder.append(paramAnonymousKeyEvent);
        APLog.e("APTabInput", localStringBuilder.toString());
        if (paramAnonymousInt == 6)
        {
          hq.a(hq.this).clearFocus();
          paramAnonymousTextView = (InputMethodManager)paramAnonymousTextView.getContext().getSystemService("input_method");
          if (paramAnonymousTextView != null)
          {
            APLog.e("APTabInput", "imm");
            paramAnonymousTextView.hideSoftInputFromWindow(hq.c(hq.this).getWindow().getDecorView().getWindowToken(), 0);
          }
          return true;
        }
        return false;
      }
    });
    this.h.requestFocus();
    h();
    i();
    a(this.h.getText().toString());
    if (this.e.getResources().getConfiguration().orientation == 2)
    {
      this.e.getWindow().setSoftInputMode(3);
      this.h.clearFocus();
      return;
    }
    i1 = this.e.getResources().getConfiguration().orientation;
  }
  
  private void g()
  {
    int i1;
    if (this.a.a.saveType == 0) {
      i1 = ((APGameRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 4) {
      i1 = ((APMonthRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 1) {
      i1 = ((APGoodsRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 5) {
      i1 = ((APSubscribeRequest)this.a.a).gameLogo;
    } else {
      i1 = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("1setGameLogo=");
    ((StringBuilder)localObject).append(i1);
    APLog.i("setGameLogo", ((StringBuilder)localObject).toString());
    if (i1 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("2setGameLogo=");
      ((StringBuilder)localObject).append(i1);
      APLog.i("setGameLogo", ((StringBuilder)localObject).toString());
      localObject = (ImageView)this.f.findViewById(2131099976);
      byte[] arrayOfByte = fv.a(i1);
      ((ImageView)localObject).setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
  
  private void h()
  {
    try
    {
      i1 = this.a.a.saveType;
      if ((i1 != 4) && (i1 != 5)) {
        return;
      }
      localLinearLayout = (LinearLayout)this.f.findViewById(2131099970);
      this.t = ((CheckBox)this.f.findViewById(2131099969));
      f1 = this.f.getResources().getDisplayMetrics().density;
    }
    catch (Exception localException1)
    {
      int i1;
      LinearLayout localLinearLayout;
      float f1;
      label87:
      final gt localgt;
      label319:
      break label319;
    }
    try
    {
      i1 = this.t.getResources().getDrawable(2131034130).getIntrinsicWidth();
    }
    catch (Exception localException2)
    {
      break label87;
    }
    i1 = Math.round(f1 * 15.0F);
    if (Build.VERSION.SDK_INT < 17) {
      i1 = this.t.getPaddingLeft() + i1;
    } else {
      i1 = this.t.getPaddingLeft();
    }
    this.t.setPadding(i1, this.t.getPaddingTop(), this.t.getPaddingRight(), this.t.getPaddingBottom());
    localgt = new gt(this.e, this.t);
    localLinearLayout.setVisibility(0);
    if (((APMonthRequest)this.a.a).autoPay)
    {
      this.t.setChecked(true);
      ((ew)this.a.b).n = "1";
      APDataReportManager.getInstance().insertData("sdk.gameinput.auto", this.a.a.saveType, null, "able", null);
      this.u = true;
      localgt.a(1000, 3000, false, false);
    }
    else
    {
      ((ew)this.a.b).n = "0";
      APDataReportManager.getInstance().insertData("sdk.gameinput.auto", this.a.a.saveType, null, "disable", null);
    }
    this.t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ((ew)hq.this.a.b).n = "1";
          if (!hq.d(hq.this))
          {
            hq.a(hq.this, true);
            localgt.a(0, 3000, false, false);
          }
        }
        else
        {
          ((ew)hq.this.a.b).n = "0";
          localgt.a();
        }
        if (paramAnonymousBoolean) {}
        for (paramAnonymousCompoundButton = "able";; paramAnonymousCompoundButton = "disable") {
          break;
        }
        APDataReportManager.getInstance().insertData("sdk.gameinput.auto", hq.this.a.a.saveType, null, paramAnonymousCompoundButton, null);
      }
    });
    return;
    APLog.i("APTabStoreInput", "showAutoPay crash");
  }
  
  private void i()
  {
    if (this.a.a.saveType != 0) {
      return;
    }
    String str = ac.a().e();
    LinearLayout localLinearLayout1 = (LinearLayout)this.f.findViewById(2131100034);
    LinearLayout localLinearLayout2 = (LinearLayout)this.f.findViewById(2131099971);
    int i1 = APUICommonMethod.a(a.a().b(), 8.0F);
    int i2 = localLinearLayout2.getPaddingTop();
    int i3 = localLinearLayout2.getPaddingBottom();
    int i4 = localLinearLayout2.getPaddingLeft();
    int i5 = localLinearLayout2.getPaddingRight();
    APScrollTextView localAPScrollTextView = (APScrollTextView)this.f.findViewById(2131099798);
    if (!TextUtils.isEmpty(str))
    {
      localAPScrollTextView.setText(str);
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setPadding(i4, i1, i5, i3);
      return;
    }
    if ((ac.a().d()) && (this.a.d.b))
    {
      localAPScrollTextView.setText(ac.a().c(this.a.b.b));
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setPadding(i4, i1, i5, i3);
      return;
    }
    localLinearLayout1.setVisibility(8);
    localLinearLayout2.setPadding(i4, i2, i5, i3);
  }
  
  public View a()
  {
    try
    {
      this.f = this.e.getLayoutInflater().inflate(2131165211, null);
      APLog.i("creatStoreView", "creatStoreView() begin");
      if (this.a.a.saveType == 4)
      {
        this.c = 960;
        if (((ew)this.a.b).l == 3)
        {
          this.c = i.a(gc.a().d());
          ((ew)this.a.b).e = gc.a().c();
        }
      }
      else if (this.a.a.saveType == 0)
      {
        if (fy.a().ae() > 0) {
          this.c = fy.a().ae();
        } else {
          this.c = 9999999;
        }
      }
      else
      {
        this.c = 9999999;
      }
      f();
      APLog.i("creatStoreView", "creatStoreView() done");
    }
    catch (Exception localException)
    {
      APLog.i("APTabStoreInput creatStoreView", localException.toString());
    }
    return this.f;
  }
  
  public void a(final View paramView, int paramInt)
  {
    Object localObject = this.e;
    Activity localActivity = this.e;
    localObject = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
    ((InputMethodManager)localObject).showSoftInput(paramView, 1);
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        this.a.showSoftInput(paramView, 1);
      }
    }, paramInt);
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.gameinput.keyback", this.a.a.saveType);
    return super.a(paramContext, paramInt, paramKeyEvent);
  }
  
  public void b()
  {
    super.b();
    APDataReportManager.getInstance().insertData("sdk.gameinput.close", this.a.a.saveType);
  }
  
  public void c()
  {
    super.c();
    APDataReportManager.getInstance().insertData("sdk.gameinput.show", this.a.a.saveType);
    if (this.h != null)
    {
      if (this.e.getResources().getConfiguration().orientation == 2) {
        return;
      }
      if (this.e.getResources().getConfiguration().orientation == 1) {
        a(this.h, 1100);
      }
    }
  }
  
  public void d()
  {
    if ((this.e instanceof APActivity)) {
      ((APActivity)this.e).g();
    }
    if (this.a.e.g == null) {
      str = "";
    } else {
      str = this.a.e.g;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("b");
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    APDataReportManager.getInstance().insertData("sdk.gameinput.sure", this.a.a.saveType, null, str, null);
    fb.a().a(this.e, "", null);
  }
  
  public void e()
  {
    String str = this.h.getText().toString();
    TextView localTextView;
    StringBuilder localStringBuilder;
    if ((str != null) && (!str.equals("")))
    {
      localTextView = this.r;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(em.b().n().b.b(str));
      localStringBuilder.append("元");
      localTextView.setText(localStringBuilder.toString());
    }
    else
    {
      this.r.setText("0.00元");
    }
    if (this.a.a.saveType == 4)
    {
      str = em.b().n().b.b("1");
      this.s.setVisibility(0);
      localTextView = this.s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(str);
      localStringBuilder.append("元/月)");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.s.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hq
 * JD-Core Version:    0.7.0.1
 */