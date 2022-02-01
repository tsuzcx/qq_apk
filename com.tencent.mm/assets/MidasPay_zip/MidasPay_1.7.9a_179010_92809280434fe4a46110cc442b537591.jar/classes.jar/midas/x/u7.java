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

public class u7
  extends s7
{
  public o4 a = null;
  public int b = 1;
  public Activity c = null;
  public View d = null;
  public ImageView e;
  public EditText f;
  public TextView g;
  public TextView h;
  public LinearLayout i;
  public TextView j;
  public TextView k;
  public TextView l;
  public TextView m;
  public TextView n;
  public TextView o;
  public TextWatcher p = new a();
  public CheckBox q;
  public boolean r = false;
  
  public u7(Activity paramActivity, o4 paramo4)
  {
    this.c = paramActivity;
    this.a = paramo4;
  }
  
  public void a()
  {
    super.a();
    APDataReportManager.getInstance().insertData("sdk.gameinput.close", this.a.b.saveType);
  }
  
  public void a(final View paramView, int paramInt)
  {
    final InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getSystemService("input_method");
    localInputMethodManager.showSoftInput(paramView, 1);
    new Timer().schedule(new e(localInputMethodManager, paramView), paramInt);
  }
  
  public final void a(String paramString)
  {
    if ((this.a.b.saveType == 0) && ((d0.i().c()) || (d0.i().b())))
    {
      this.i.setVisibility(0);
      if (TextUtils.isEmpty(paramString))
      {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setText("");
        return;
      }
      int i2 = i.b(paramString);
      boolean bool = d0.i().b();
      Object localObject1 = null;
      if (bool)
      {
        paramString = d0.i().f(i2);
        if ((paramString != null) && (paramString.size() > 0))
        {
          this.k.setText("首充");
          this.k.setVisibility(0);
        }
        else
        {
          this.k.setVisibility(8);
        }
      }
      else
      {
        this.k.setVisibility(8);
        paramString = null;
      }
      Object localObject2 = d0.i().h(i2);
      int i1;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((z)localObject2).b)))
      {
        this.l.setText(((z)localObject2).b);
        this.l.setVisibility(0);
        i1 = 1;
      }
      else
      {
        this.l.setVisibility(8);
        i1 = 0;
      }
      if (d0.i().c())
      {
        localObject1 = d0.i().k(i2);
        if (i1 == 0)
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            this.j.setText("满赠");
            this.j.setVisibility(0);
          }
          else
          {
            this.j.setVisibility(8);
          }
        }
        else {
          this.j.setVisibility(8);
        }
      }
      else
      {
        this.j.setVisibility(8);
      }
      this.a.f.f = String.valueOf(i2);
      localObject1 = d0.i().a(paramString, (ArrayList)localObject1);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        paramString = new StringBuffer();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (w)((Iterator)localObject1).next();
          paramString.append(((w)localObject2).a);
          paramString.append("×");
          paramString.append(((w)localObject2).b);
          paramString.append(",");
        }
        if (paramString.length() > 0)
        {
          paramString = paramString.substring(0, paramString.length() - 1).toString();
          this.m.setText(paramString);
          return;
        }
        this.m.setText("");
        return;
      }
      this.m.setText("");
      return;
    }
    this.i.setVisibility(8);
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.gameinput.keyback", this.a.b.saveType);
    return super.a(paramContext, paramInt, paramKeyEvent);
  }
  
  public View b()
  {
    try
    {
      this.d = this.c.getLayoutInflater().inflate(2131165211, null);
      APLog.i("creatStoreView", "creatStoreView() begin");
      if (this.a.b.saveType == 4)
      {
        this.b = 960;
        if (((z4)this.a.c).l == 3)
        {
          this.b = i.b(g6.k().g());
          ((z4)this.a.c).c = g6.k().h();
        }
      }
      else if (this.a.b.saveType == 0)
      {
        if (c6.s0().n() > 0) {
          this.b = c6.s0().n();
        } else {
          this.b = 9999999;
        }
      }
      else
      {
        this.b = 9999999;
      }
      e();
      APLog.i("creatStoreView", "creatStoreView() done");
    }
    catch (Exception localException)
    {
      APLog.i("APTabStoreInput creatStoreView", localException.toString());
    }
    return this.d;
  }
  
  public void c()
  {
    super.c();
    APDataReportManager.getInstance().insertData("sdk.gameinput.show", this.a.b.saveType);
    if (this.f != null)
    {
      if (this.c.getResources().getConfiguration().orientation == 2) {
        return;
      }
      if (this.c.getResources().getConfiguration().orientation == 1) {
        a(this.f, 1100);
      }
    }
  }
  
  public void d()
  {
    Object localObject1 = this.c;
    if ((localObject1 instanceof APActivity)) {
      ((APActivity)localObject1).e();
    }
    Object localObject2 = this.a.f.f;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("b");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    APDataReportManager.getInstance().insertData("sdk.gameinput.sure", this.a.b.saveType, null, (String)localObject1, null);
    e5.h().a(this.c, "", null);
  }
  
  public final void e()
  {
    g();
    this.e = ((ImageView)this.d.findViewById(2131099973));
    this.f = ((EditText)this.d.findViewById(2131099974));
    this.g = ((TextView)this.d.findViewById(2131099975));
    this.h = ((TextView)this.d.findViewById(2131099972));
    this.i = ((LinearLayout)this.d.findViewById(2131099981));
    LinearLayout localLinearLayout = (LinearLayout)this.d.findViewById(2131099979);
    this.k = ((TextView)this.d.findViewById(2131099977));
    this.j = ((TextView)this.d.findViewById(2131099978));
    this.l = ((TextView)this.d.findViewById(2131099980));
    localLinearLayout = (LinearLayout)this.d.findViewById(2131099983);
    this.m = ((TextView)this.d.findViewById(2131099982));
    this.n = ((TextView)this.d.findViewById(2131099985));
    this.o = ((TextView)this.d.findViewById(2131099986));
    if (this.a.b.saveType == 4) {
      this.g.setVisibility(0);
    } else {
      this.g.setVisibility(8);
    }
    if ((p4.p().e().b.resId == 0) && (p4.p().e().b.resData == null))
    {
      ((TextView)this.d.findViewById(2131099984)).setVisibility(0);
      this.e.setVisibility(8);
    }
    else
    {
      ((TextView)this.d.findViewById(2131099984)).setVisibility(8);
      APUICommonMethod.a(this.e);
    }
    this.h.setText("确定");
    this.h.setOnClickListener(new b());
    int i1 = this.b;
    if ((this.a.b.saveType != 0) || (c6.s0().n() <= 0)) {
      this.f.setFilters(new InputFilter[] { new InputFilter.LengthFilter(String.valueOf(i1).length()) });
    }
    this.f.addTextChangedListener(this.p);
    this.f.setText(this.a.f.f);
    this.f.setSelection(this.a.f.f.length());
    this.f.setFocusable(true);
    this.f.setOnEditorActionListener(new c());
    this.f.requestFocus();
    h();
    i();
    a(this.f.getText().toString());
    if (this.c.getResources().getConfiguration().orientation == 2)
    {
      this.c.getWindow().setSoftInputMode(3);
      this.f.clearFocus();
      return;
    }
    i1 = this.c.getResources().getConfiguration().orientation;
  }
  
  public void f()
  {
    String str = this.f.getText().toString();
    TextView localTextView;
    StringBuilder localStringBuilder;
    if ((str != null) && (!str.equals("")))
    {
      localTextView = this.n;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(p4.p().e().c.b(str));
      localStringBuilder.append("元");
      localTextView.setText(localStringBuilder.toString());
    }
    else
    {
      this.n.setText("0.00元");
    }
    if (this.a.b.saveType == 4)
    {
      str = p4.p().e().c.b("1");
      this.o.setVisibility(0);
      localTextView = this.o;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(str);
      localStringBuilder.append("元/月)");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.o.setVisibility(8);
  }
  
  public final void g()
  {
    Object localObject = this.a.b;
    int i1 = ((APBaseRequest)localObject).saveType;
    if (i1 == 0) {
      i1 = ((APGameRequest)localObject).gameLogo;
    } else if (i1 == 4) {
      i1 = ((APMonthRequest)localObject).gameLogo;
    } else if (i1 == 1) {
      i1 = ((APGoodsRequest)localObject).gameLogo;
    } else if (i1 == 5) {
      i1 = ((APSubscribeRequest)localObject).gameLogo;
    } else {
      i1 = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("1setGameLogo=");
    ((StringBuilder)localObject).append(i1);
    APLog.i("setGameLogo", ((StringBuilder)localObject).toString());
    if (i1 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("2setGameLogo=");
      ((StringBuilder)localObject).append(i1);
      APLog.i("setGameLogo", ((StringBuilder)localObject).toString());
      localObject = (ImageView)this.d.findViewById(2131099976);
      byte[] arrayOfByte = z5.a(i1);
      ((ImageView)localObject).setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
  
  public final void h()
  {
    try
    {
      i1 = this.a.b.saveType;
      if ((i1 != 4) && (i1 != 5)) {
        return;
      }
      localLinearLayout = (LinearLayout)this.d.findViewById(2131099970);
      this.q = ((CheckBox)this.d.findViewById(2131099969));
      f1 = this.d.getResources().getDisplayMetrics().density;
    }
    catch (Exception localException1)
    {
      int i1;
      LinearLayout localLinearLayout;
      float f1;
      label87:
      final x6 localx6;
      label319:
      break label319;
    }
    try
    {
      i1 = this.q.getResources().getDrawable(2131034130).getIntrinsicWidth();
    }
    catch (Exception localException2)
    {
      break label87;
    }
    i1 = Math.round(f1 * 15.0F);
    if (Build.VERSION.SDK_INT < 17) {
      i1 = this.q.getPaddingLeft() + i1;
    } else {
      i1 = this.q.getPaddingLeft();
    }
    this.q.setPadding(i1, this.q.getPaddingTop(), this.q.getPaddingRight(), this.q.getPaddingBottom());
    localx6 = new x6(this.c, this.q);
    localLinearLayout.setVisibility(0);
    if (((APMonthRequest)this.a.b).autoPay)
    {
      this.q.setChecked(true);
      ((z4)this.a.c).n = "1";
      APDataReportManager.getInstance().insertData("sdk.gameinput.auto", this.a.b.saveType, null, "able", null);
      this.r = true;
      localx6.a(1000, 3000, false, false);
    }
    else
    {
      ((z4)this.a.c).n = "0";
      APDataReportManager.getInstance().insertData("sdk.gameinput.auto", this.a.b.saveType, null, "disable", null);
    }
    this.q.setOnCheckedChangeListener(new d(localx6));
    return;
    APLog.i("APTabStoreInput", "showAutoPay crash");
  }
  
  public final void i()
  {
    if (this.a.b.saveType != 0) {
      return;
    }
    String str = d0.i().e();
    LinearLayout localLinearLayout1 = (LinearLayout)this.d.findViewById(2131100034);
    LinearLayout localLinearLayout2 = (LinearLayout)this.d.findViewById(2131099971);
    int i1 = APUICommonMethod.a(a.r().a(), 8.0F);
    int i2 = localLinearLayout2.getPaddingTop();
    int i3 = localLinearLayout2.getPaddingBottom();
    int i4 = localLinearLayout2.getPaddingLeft();
    int i5 = localLinearLayout2.getPaddingRight();
    APScrollTextView localAPScrollTextView = (APScrollTextView)this.d.findViewById(2131099798);
    if (!TextUtils.isEmpty(str))
    {
      localAPScrollTextView.setText(str);
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setPadding(i4, i1, i5, i3);
      return;
    }
    if ((d0.i().b()) && (this.a.e.b))
    {
      localAPScrollTextView.setText(d0.i().d(this.a.c.b));
      localLinearLayout1.setVisibility(0);
      localLinearLayout2.setPadding(i4, i1, i5, i3);
      return;
    }
    localLinearLayout1.setVisibility(8);
    localLinearLayout2.setPadding(i4, i2, i5, i3);
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      Object localObject = paramEditable.toString().trim();
      u7 localu7;
      int i;
      if (((String)localObject).length() == 0)
      {
        u7.a(u7.this, "");
      }
      else if (((String)localObject).toString().equals("0"))
      {
        u7.a(u7.this).setText("");
        u7.a(u7.this, "");
      }
      else if (i.b((String)localObject) > u7.b(u7.this))
      {
        localu7 = u7.this;
        o4 localo4 = localu7.a;
        i = localo4.b.saveType;
        if (i == 4)
        {
          if (((z4)localo4.c).l == 3)
          {
            paramEditable = u7.c(localu7);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("升级时长最多不超过");
            ((StringBuilder)localObject).append(u7.b(u7.this));
            ((StringBuilder)localObject).append("个月");
            APUICommonMethod.a(paramEditable, ((StringBuilder)localObject).toString());
            u7.a(u7.this).setText(String.valueOf(u7.b(u7.this)));
            return;
          }
          APUICommonMethod.a(u7.c(localu7), "购买数量不能超过最大限制");
        }
        else if (i != 0) {}
      }
      try
      {
        paramEditable.delete(paramEditable.length() - 1, paramEditable.length());
        label226:
        APUICommonMethod.a(u7.c(u7.this), "购买数量不能超过最大限制");
        break label251;
        APUICommonMethod.a(u7.c(localu7), "购买数量不能超过最大限制");
        label251:
        u7.a(u7.this, (String)localObject);
        i = u7.a(u7.this).getText().length();
        if (i > 0) {
          u7.a(u7.this).setSelection(i);
        }
        u7.this.f();
        return;
      }
      catch (Exception paramEditable)
      {
        break label226;
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      paramView = u7.a(u7.this).getText().toString();
      if (!TextUtils.isEmpty(paramView))
      {
        u7 localu7 = u7.this;
        localu7.a.f.f = paramView;
        localu7.d();
        return;
      }
      Toast.makeText(u7.c(u7.this), "充值数量不能为空", 1).show();
    }
  }
  
  public class c
    implements TextView.OnEditorActionListener
  {
    public c() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("actionId: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" event: ");
      localStringBuilder.append(paramKeyEvent);
      APLog.e("APTabInput", localStringBuilder.toString());
      if (paramInt == 6)
      {
        u7.a(u7.this).clearFocus();
        paramTextView = (InputMethodManager)paramTextView.getContext().getSystemService("input_method");
        if (paramTextView != null)
        {
          APLog.e("APTabInput", "imm");
          paramTextView.hideSoftInputFromWindow(u7.c(u7.this).getWindow().getDecorView().getWindowToken(), 0);
        }
        return true;
      }
      return false;
    }
  }
  
  public class d
    implements CompoundButton.OnCheckedChangeListener
  {
    public d(x6 paramx6) {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        paramCompoundButton = u7.this;
        ((z4)paramCompoundButton.a.c).n = "1";
        if (!u7.d(paramCompoundButton))
        {
          u7.a(u7.this, true);
          localx6.a(0, 3000, false, false);
        }
      }
      else
      {
        ((z4)u7.this.a.c).n = "0";
        localx6.a();
      }
      if (paramBoolean) {
        paramCompoundButton = "able";
      } else {
        paramCompoundButton = "disable";
      }
      APDataReportManager.getInstance().insertData("sdk.gameinput.auto", u7.this.a.b.saveType, null, paramCompoundButton, null);
    }
  }
  
  public class e
    extends TimerTask
  {
    public e(InputMethodManager paramInputMethodManager, View paramView) {}
    
    public void run()
    {
      localInputMethodManager.showSoftInput(paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u7
 * JD-Core Version:    0.7.0.1
 */