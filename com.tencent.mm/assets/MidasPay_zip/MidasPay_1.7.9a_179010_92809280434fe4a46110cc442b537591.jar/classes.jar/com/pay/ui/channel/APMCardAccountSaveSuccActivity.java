package com.pay.ui.channel;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c5;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.h5;
import midas.x.o4;
import midas.x.p4;
import midas.x.w4;
import midas.x.z5;

public class APMCardAccountSaveSuccActivity
  extends APActivity
{
  public AP3PointsLoading d;
  public Button e;
  public h5 f = new a();
  
  public void f()
  {
    String str = p4.p().e().f.e;
    e5.h().a(this, str, this.f, null);
  }
  
  public void g()
  {
    Object localObject1 = p4.p().e();
    Object localObject2 = getIntent().getExtras();
    int k = ((Bundle)localObject2).getInt("mcardAmt");
    int m = ((Bundle)localObject2).getInt("mcardAccountBalance");
    int j = ((Bundle)localObject2).getInt("mcardNeedDeposit");
    int i = j;
    if (j < 0) {
      i = APTools.p(((o4)localObject1).c.a(((o4)localObject1).f.f)) - ((o4)localObject1).e.h;
    }
    this.d = ((AP3PointsLoading)findViewById(2131099895));
    this.e = ((Button)findViewById(2131099773));
    localObject1 = (Button)findViewById(2131099774);
    Object localObject4 = (TextView)findViewById(2131099904);
    localObject2 = (TextView)findViewById(2131099906);
    Object localObject3 = (TextView)findViewById(2131099907);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099818);
    Object localObject5;
    if (m >= 0)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(APTools.b(m));
      ((StringBuilder)localObject5).append("元");
      ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
      ((TextView)localObject4).setVisibility(0);
    }
    else
    {
      localObject5 = (TextView)findViewById(2131099905);
      ((TextView)localObject4).setVisibility(8);
      ((TextView)localObject5).setVisibility(8);
    }
    final boolean bool = true;
    if (i > 0)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("充值成功 还需充值");
      ((StringBuilder)localObject4).append(APTools.b(i));
      ((StringBuilder)localObject4).append("元");
      ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
    }
    else
    {
      ((TextView)localObject3).setText("充值成功");
      if (this.a != 1)
      {
        ((Button)localObject1).setVisibility(8);
        this.e.setText(getString(2131230806));
      }
    }
    if (k <= 0)
    {
      localLinearLayout.setVisibility(8);
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(APTools.b(k));
      ((StringBuilder)localObject3).append("元");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localLinearLayout.setVisibility(0);
    }
    if (this.a == 1)
    {
      ((Button)localObject1).setVisibility(8);
      ((TextView)findViewById(2131099908)).setVisibility(0);
    }
    if (i <= 0) {
      bool = false;
    }
    this.e.setOnClickListener(new b(bool));
    ((Button)localObject1).setOnClickListener(new c());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165205);
      g();
      a.r().f = true;
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements h5
  {
    public a() {}
    
    public void a()
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).d();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
    
    public void a(int paramInt)
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).d();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).d();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b(boolean paramBoolean) {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.pcard.interal.back", APMCardAccountSaveSuccActivity.c(APMCardAccountSaveSuccActivity.this));
      if ((!bool) && (APMCardAccountSaveSuccActivity.d(APMCardAccountSaveSuccActivity.this) != 1))
      {
        APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(8);
        APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(0);
        APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).c();
        APMCardAccountSaveSuccActivity.this.f();
        return;
      }
      APUICommonMethod.f();
      z5.a(2, "");
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.pcard.interal.recharge", APMCardAccountSaveSuccActivity.e(APMCardAccountSaveSuccActivity.this));
      paramView = new Intent();
      paramView.setClass(APMCardAccountSaveSuccActivity.this, APMCardAccountSaveActivity.class);
      APMCardAccountSaveSuccActivity.this.startActivity(paramView);
      APMCardAccountSaveSuccActivity.this.finish();
      APUICommonMethod.a(APMCardAccountSaveSuccActivity.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardAccountSaveSuccActivity
 * JD-Core Version:    0.7.0.1
 */