package com.pay.ui.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.mcard.APMcardChannel;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.e5;
import midas.x.fc;
import midas.x.h2;
import midas.x.i5;
import midas.x.o4;
import midas.x.o5;
import midas.x.ob;
import midas.x.p4;
import midas.x.p5;
import midas.x.w4;
import midas.x.z1;
import midas.x.z5;

public class APPayProgressActivity
  extends APActivity
{
  public boolean d;
  public boolean e = false;
  public int f;
  public Button g;
  public h h = new h();
  public int i = 0;
  public TextView j;
  public TextView k;
  public ImageView l;
  public int m;
  public String n;
  public Runnable o = new a();
  public View.OnClickListener p = new b();
  
  public void a(String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("contextRef:");
    ((StringBuilder)localObject).append(this);
    APLog.e("APPayProgressActivity showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.f(this);
    ((APAlertDialog.f)localObject).a(paramString);
    ((APAlertDialog.f)localObject).b("我知道了", new f(paramBoolean));
    ((APAlertDialog.f)localObject).b(new g(paramBoolean));
    try
    {
      ((APAlertDialog.f)localObject).b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void f()
  {
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i1 = this.m;
    String str = this.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("&countdown=");
    localStringBuilder.append(60 - this.i);
    localAPDataReportManager.insertData("sdk.result.inner.back", i1, str, "", localStringBuilder.toString());
    this.l.clearAnimation();
    APUICommonMethod.f();
    i1 = this.f;
    if (i1 == 5)
    {
      z5.a(5, -1, -1);
      return;
    }
    if (i1 == 9)
    {
      z5.a(9, -1, -1);
      return;
    }
    if (i1 == 8) {
      z5.a(8, -1, -1);
    }
  }
  
  public final void g()
  {
    this.g = ((Button)findViewById(2131099773));
    this.g.setOnClickListener(this.p);
    this.j = ((TextView)findViewById(2131099996));
    this.l = ((ImageView)findViewById(2131099966));
    this.k = ((TextView)findViewById(2131099915));
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771973);
    localAnimation.setInterpolator(new LinearInterpolator());
    this.l.startAnimation(localAnimation);
  }
  
  public final void h()
  {
    int i1 = this.f;
    if (i1 == 5)
    {
      this.j.setText(getString(2131230814));
      return;
    }
    if (i1 == 9)
    {
      this.j.setText(getString(2131230797));
      return;
    }
    if (i1 == 8) {
      this.j.setText(getString(2131230932));
    }
  }
  
  public final void i()
  {
    e5.h().a(this, new e());
  }
  
  public final void j()
  {
    e5.h().a(this, new d());
  }
  
  public final void k()
  {
    int i1 = this.f;
    if (i1 == 5)
    {
      j();
      return;
    }
    if (i1 == 9)
    {
      i();
      return;
    }
    if (i1 == 8) {
      l();
    }
  }
  
  public final void l()
  {
    w4 localw4 = p4.p().e().c;
    z1.d().c(localw4.g(), "3", new c());
  }
  
  public final void m()
  {
    Object localObject = APDataReportManager.getInstance();
    int i1 = this.m;
    String str = this.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("&countdown=0");
    ((APDataReportManager)localObject).insertData("sdk.result.inner.query.timeout", i1, str, "", localStringBuilder.toString());
    i1 = this.f;
    if (i1 == 5)
    {
      z1.b("mcardstatus");
      localObject = e5.a("mcard");
      if ((localObject instanceof APMcardChannel)) {
        ((APMcardChannel)localObject).b(this);
      }
    }
    else if (i1 == 9)
    {
      z1.b("hfstatus");
      localObject = e5.a("hfpay");
      if ((localObject instanceof APHFChannel)) {
        ((APHFChannel)localObject).a(this);
      }
    }
    else if (i1 == 8)
    {
      z1.b("querywxresult");
      a("查询失败", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165207);
      this.f = getIntent().getExtras().getInt("channel");
      this.m = p4.p().e().b.saveType;
      this.n = p4.p().e().f.l;
      g();
      h();
      k();
      this.h.postDelayed(this.o, 1000L);
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e = false;
    this.h.removeCallbacks(this.o);
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
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      APPayProgressActivity.b(APPayProgressActivity.this);
      if (APPayProgressActivity.a(APPayProgressActivity.this) == 60)
      {
        APPayProgressActivity.c(APPayProgressActivity.this).clearAnimation();
        APPayProgressActivity.a(APPayProgressActivity.this, true);
        APPayProgressActivity.f(APPayProgressActivity.this);
        APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacksAndMessages(null);
        return;
      }
      if ((APPayProgressActivity.a(APPayProgressActivity.this) % 10 == 0) && (APPayProgressActivity.h(APPayProgressActivity.this)))
      {
        APPayProgressActivity.b(APPayProgressActivity.this, false);
        APPayProgressActivity.i(APPayProgressActivity.this);
      }
      APPayProgressActivity.j(APPayProgressActivity.this).setText(String.valueOf(60 - APPayProgressActivity.a(APPayProgressActivity.this)));
      APPayProgressActivity.g(APPayProgressActivity.this).postDelayed(APPayProgressActivity.this.o, 1000L);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APPayProgressActivity.k(APPayProgressActivity.this);
    }
  }
  
  public class c
    implements fc
  {
    public c() {}
    
    public void a(ob paramob)
    {
      paramob = (h2)paramob;
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      int i = APPayProgressActivity.l(APPayProgressActivity.this);
      String str = APPayProgressActivity.d(APPayProgressActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channel=");
      localStringBuilder.append(APPayProgressActivity.e(APPayProgressActivity.this));
      localStringBuilder.append("&countdown=");
      localStringBuilder.append(60 - APPayProgressActivity.a(APPayProgressActivity.this));
      localAPDataReportManager.insertData("sdk.result.inner.query.over", i, str, "", localStringBuilder.toString());
      if (paramob.d() == 0)
      {
        if ((paramob.k() != 2) && (paramob.k() != 3) && (paramob.k() != 4) && (paramob.k() != 5))
        {
          if (!TextUtils.isEmpty(paramob.f()))
          {
            APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.o);
            APPayProgressActivity.this.a(paramob.f(), true);
            return;
          }
          APPayProgressActivity.b(APPayProgressActivity.this, true);
          return;
        }
        APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.o);
        e5.h();
        e5.a("wechat").a(null);
        return;
      }
      APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.o);
      if (!TextUtils.isEmpty(paramob.f()))
      {
        APPayProgressActivity.this.a(paramob.f(), true);
        return;
      }
      APPayProgressActivity.this.a("查询失败", true);
    }
    
    public void b(ob paramob)
    {
      APPayProgressActivity.b(APPayProgressActivity.this, true);
    }
    
    public void c(ob paramob)
    {
      paramob = APDataReportManager.getInstance();
      int i = APPayProgressActivity.l(APPayProgressActivity.this);
      String str = APPayProgressActivity.d(APPayProgressActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channel=");
      localStringBuilder.append(APPayProgressActivity.e(APPayProgressActivity.this));
      localStringBuilder.append("&countdown=");
      localStringBuilder.append(60 - APPayProgressActivity.a(APPayProgressActivity.this));
      paramob.insertData("sdk.result.inner.query.over", i, str, "", localStringBuilder.toString());
      APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.o);
      APPayProgressActivity.this.a("查询失败", true);
    }
  }
  
  public class d
    implements p5
  {
    public d() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      if (paramInt == 0)
      {
        paramBundle = APDataReportManager.getInstance();
        paramInt = APPayProgressActivity.l(APPayProgressActivity.this);
        String str = APPayProgressActivity.d(APPayProgressActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(APPayProgressActivity.e(APPayProgressActivity.this));
        localStringBuilder.append("&countdown=");
        localStringBuilder.append(60 - APPayProgressActivity.a(APPayProgressActivity.this));
        paramBundle.insertData("sdk.result.inner.query.over", paramInt, str, "", localStringBuilder.toString());
        APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacksAndMessages(null);
        return;
      }
      APPayProgressActivity.b(APPayProgressActivity.this, true);
    }
  }
  
  public class e
    implements o5
  {
    public e() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      if (paramInt == 0)
      {
        paramBundle = APDataReportManager.getInstance();
        paramInt = APPayProgressActivity.l(APPayProgressActivity.this);
        String str = APPayProgressActivity.d(APPayProgressActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(APPayProgressActivity.e(APPayProgressActivity.this));
        localStringBuilder.append("&countdown=");
        localStringBuilder.append(60 - APPayProgressActivity.a(APPayProgressActivity.this));
        paramBundle.insertData("sdk.result.inner.query.over", paramInt, str, "", localStringBuilder.toString());
        APPayProgressActivity.g(APPayProgressActivity.this).removeCallbacksAndMessages(null);
        return;
      }
      APPayProgressActivity.b(APPayProgressActivity.this, true);
    }
  }
  
  public class f
    implements c7
  {
    public f(boolean paramBoolean) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((!paramBoolean) && (a.r().f))
      {
        paramAPAlertDialog.f();
        return;
      }
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(-1, "");
    }
  }
  
  public class g
    implements c7
  {
    public g(boolean paramBoolean) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.r().f)))
      {
        APUICommonMethod.f();
        z5.a(-1, "");
      }
    }
  }
  
  public static class h
    extends Handler
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APPayProgressActivity
 * JD-Core Version:    0.7.0.1
 */