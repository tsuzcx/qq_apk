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
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;

public class iu
  extends is
{
  private Context A;
  public final int a = 1;
  protected LinearLayout b;
  protected AP3PointsLoading e;
  private ImageButton f;
  private LinearLayout g;
  private Button h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private String q = "";
  private ec r;
  private int s;
  private LinearLayout t;
  private ImageView u;
  private TextView v;
  private EditText w;
  private ImageButton x;
  private String y = "";
  private View z;
  
  private void a(View paramView)
  {
    d();
    e();
    f();
    g();
    h();
    this.b = ((LinearLayout)paramView.findViewById(2131099805));
    this.e = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.e.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    paramString = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    paramString.height = this.b.getMeasuredHeight();
    this.b.setVisibility(8);
    this.e.setLayoutParams(paramString);
    this.e.setVisibility(0);
    this.e.setText("");
    this.e.b();
    a(true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.t;
    ImageView localImageView = this.u;
    TextView localTextView = this.v;
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(this.d.getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(this.d.getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  private void c()
  {
    if (this.s == 4)
    {
      this.y = ed.b().n().e.g;
      ed.b().n().e.g = "1";
    }
  }
  
  private void d()
  {
    this.i = ((TextView)this.z.findViewById(2131100042));
    this.i.setText(ed.b().n().b.a);
    this.f = ((ImageButton)this.z.findViewById(2131099702));
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        iu.a(iu.this);
      }
    });
  }
  
  private void e()
  {
    this.j = ((TextView)this.z.findViewById(2131100002));
    this.j.setText(this.r.b.b);
    this.k = ((TextView)this.z.findViewById(2131100005));
    Object localObject = "";
    switch (this.s)
    {
    default: 
      break;
    case 5: 
      if (fs.a().f() == fs.a.a)
      {
        this.j.setVisibility(8);
        localObject = this.r.b.b;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" × ");
        ((StringBuilder)localObject).append(this.r.e.g);
        localObject = ((StringBuilder)localObject).toString();
      }
      break;
    case 4: 
      if (fs.a().f() == fs.a.a)
      {
        this.j.setVisibility(8);
        localObject = this.r.b.b;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.A.getString(2131230828));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.r.e.g);
        ((StringBuilder)localObject).append(((en)this.r.b).h());
        localObject = ((StringBuilder)localObject).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.A.getString(2131230828));
      ((StringBuilder)localObject).append(this.r.e.g);
      localObject = ((StringBuilder)localObject).toString();
    }
    if ((this.s != 3) && (this.s != 2))
    {
      if (APUICommonMethod.h())
      {
        localObject = (el)this.r.b;
        this.k.setText(((el)localObject).h());
      }
      else
      {
        localTextView = this.k;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(this.r.a.extendInfo.unit);
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else {
      this.k.setText((CharSequence)localObject);
    }
    if (!APAppDataInterface.singleton().h()) {
      this.k.setVisibility(8);
    }
    this.l = ((TextView)this.z.findViewById(2131100000));
    localObject = this.r.b.a(this.r.e.g);
    TextView localTextView = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.A.getString(2131230878));
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    this.o = ((TextView)this.z.findViewById(2131100007));
    this.n = ((TextView)this.z.findViewById(2131100003));
    this.o.setVisibility(8);
    this.n.setVisibility(8);
  }
  
  private void f()
  {
    this.g = ((LinearLayout)this.z.findViewById(2131099910));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        iu.b(iu.this);
      }
    });
    this.p = ((ImageView)this.z.findViewById(2131100036));
    this.m = ((TextView)this.z.findViewById(2131100040));
    TextView localTextView1 = (TextView)this.z.findViewById(2131100041);
    TextView localTextView2 = (TextView)this.z.findViewById(2131099842);
    Object localObject = gd.a().d(this.q);
    if (localObject != null)
    {
      this.p.setVisibility(0);
      this.p.setBackgroundResource(((gc)localObject).c);
      this.m.setText(((gc)localObject).b);
    }
    else
    {
      this.p.setVisibility(4);
      this.m.setText("手机话费");
    }
    if ((this.s == 0) && (!TextUtils.isEmpty(APHFChannel.n)))
    {
      localObject = ((el)this.r.b).b(this.r.e.g, APHFChannel.n);
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
    if (this.s == 4)
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
  
  private void g()
  {
    this.t = ((LinearLayout)this.z.findViewById(2131100018));
    this.u = ((ImageView)this.z.findViewById(2131100017));
    this.v = ((TextView)this.z.findViewById(2131100019));
    a(false, false, "");
    this.x = ((ImageButton)this.z.findViewById(2131099930));
    this.x.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        iu.c(iu.this).setText("");
      }
    });
    this.w = ((EditText)this.z.findViewById(2131099931));
    this.w.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });
    this.w.addTextChangedListener(new a(null));
    String str = APTools.h(this.d);
    if ((!TextUtils.isEmpty(str)) && (str.length() == 11)) {
      this.w.setText(str);
    }
  }
  
  private void h()
  {
    this.h = ((Button)this.z.findViewById(2131099704));
    this.h.setText("下一步");
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        iu.d(iu.this);
      }
    });
  }
  
  private void i()
  {
    String str1 = this.q;
    String str2 = this.w.getText().toString().trim();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() == 11))
    {
      String str3 = APTools.h(this.A);
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str3))) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      APHFChannel.j = (String)localObject;
      APHFChannel.k = str2;
      APHFChannel.l = str3;
      a(str1);
      Object localObject = new Bundle();
      APRecoChannelActivity.b = true;
      es.a().a(this.A, str1, (Bundle)localObject, new ev()
      {
        public void a()
        {
          APRecoChannelActivity.b = false;
          iu.e(iu.this);
        }
        
        public void a(int paramAnonymousInt)
        {
          APRecoChannelActivity.b = false;
          iu.e(iu.this);
        }
        
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          APRecoChannelActivity.b = false;
          iu.e(iu.this);
        }
      }, null);
      return;
    }
    a(true, false, "请输入正确的手机号");
  }
  
  private void j()
  {
    if ((this.s == 4) && (!TextUtils.isEmpty(this.y))) {
      ed.b().n().e.g = this.y;
    }
    new Bundle().putBoolean("isFromExpress", true);
    this.d.a(2, 1, null);
  }
  
  private void k()
  {
    if (APRecoChannelActivity.a()) {
      return;
    }
    if ((this.s == 4) && (!TextUtils.isEmpty(this.y))) {
      ed.b().n().e.g = this.y;
    }
    if (fp.a().g().equals("AndroidPay"))
    {
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    this.d.finish();
    APUICommonMethod.b(this.d);
  }
  
  private void l()
  {
    try
    {
      this.e.a();
      this.e.setVisibility(8);
      this.b.setVisibility(0);
      a(false);
      APRecoChannelActivity.b = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.d = paramAPRecoChannelActivity;
    this.A = paramContext;
    this.r = ed.b().n();
    this.s = this.r.a.saveType;
    this.z = LayoutInflater.from(paramContext).inflate(2131165184, null);
    this.q = this.r.e.f;
    c();
    a(this.z);
    return this.z;
  }
  
  public void a()
  {
    super.a();
  }
  
  protected boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      k();
    }
    return true;
  }
  
  class a
    implements TextWatcher
  {
    private a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() == 0) {
        iu.f(iu.this).setVisibility(8);
      } else {
        iu.f(iu.this).setVisibility(0);
      }
      iu.a(iu.this, false, false, "");
      if ((paramEditable.toString().length() > 0) && (!paramEditable.toString().startsWith("1")))
      {
        iu.c(iu.this).removeTextChangedListener(this);
        iu.c(iu.this).setText("1");
        iu.c(iu.this).setSelection(1);
        iu.c(iu.this).addTextChangedListener(this);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.iu
 * JD-Core Version:    0.7.0.1
 */