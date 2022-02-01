package com.pay.ui.realname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;
import java.lang.ref.WeakReference;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.o4;
import midas.x.p4;
import midas.x.z5;

public class APRegistResultActivity
  extends APActivity
{
  public Button d;
  public Button e;
  public TextView f;
  public TextView g;
  public int h = -1;
  
  public void f()
  {
    this.f = ((TextView)findViewById(2131100046));
    this.g = ((TextView)findViewById(2131100045));
    this.d = ((Button)findViewById(2131099706));
    this.e = ((Button)findViewById(2131099701));
    Object localObject = getIntent().getExtras();
    if (((Bundle)localObject).containsKey("ret")) {
      this.h = ((Bundle)localObject).getInt("ret");
    }
    if (((Bundle)localObject).containsKey("msg")) {
      localObject = ((Bundle)localObject).getString("msg");
    } else {
      localObject = null;
    }
    if (this.h == 0)
    {
      this.f.setText("认证成功");
      this.d.setText("去支付");
      this.e.setVisibility(8);
    }
    else
    {
      this.f.setText("认证失败");
      this.d.setText("重新验证");
      this.e.setVisibility(0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.g.setText((CharSequence)localObject);
      }
    }
    this.d.setOnClickListener(new a());
    this.e.setOnClickListener(new b());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165249);
      f();
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
      APDataReportManager.getInstance().insertData("sdk.realname.back", this.a, p4.p().e().f.k, String.valueOf(4), null);
      APUICommonMethod.f();
      z5.a(13, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.qcard.show", this.a, p4.p().e().f.k, String.valueOf(4), null);
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      if (APRegistResultActivity.a(APRegistResultActivity.this) == 0)
      {
        if (a.r().c.get() != null)
        {
          APRegistResultActivity.this.finish();
          APUICommonMethod.a(APRegistResultActivity.this);
          a.r().a((Activity)a.r().c.get(), p4.p().e().b, a.r().a);
        }
        else
        {
          APUICommonMethod.f();
          z5.a(13, "");
        }
      }
      else
      {
        APRegistResultActivity.this.finish();
        APUICommonMethod.a(APRegistResultActivity.this);
      }
      APDataReportManager.getInstance().insertData("sdk.qcard.pay", APRegistResultActivity.b(APRegistResultActivity.this), p4.p().e().f.k, String.valueOf(4), null);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APUICommonMethod.f();
      z5.a(13, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.realname.APRegistResultActivity
 * JD-Core Version:    0.7.0.1
 */