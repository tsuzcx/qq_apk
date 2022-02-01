package com.pay.ui.channel;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ez;
import midas.x.fa;
import midas.x.fb;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;

public class APMCardAccountSaveSuccActivity
  extends APActivity
{
  fe a = new fe()
  {
    public void a()
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).a();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
    
    public void a(int paramAnonymousInt)
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).a();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).a();
      APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(8);
      APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(0);
    }
  };
  private AP3PointsLoading b;
  private Button c;
  
  protected void a()
  {
    Object localObject1 = em.b().n();
    Object localObject2 = getIntent().getExtras();
    int k = ((Bundle)localObject2).getInt("mcardAmt");
    int m = ((Bundle)localObject2).getInt("mcardAccountBalance");
    int j = ((Bundle)localObject2).getInt("mcardNeedDeposit");
    int i = j;
    if (j < 0) {
      i = APTools.g(((el)localObject1).b.a(((el)localObject1).e.g)) - ((el)localObject1).d.h;
    }
    this.b = ((AP3PointsLoading)findViewById(2131099895));
    this.c = ((Button)findViewById(2131099773));
    localObject1 = (Button)findViewById(2131099774);
    Object localObject4 = (TextView)findViewById(2131099904);
    localObject2 = (TextView)findViewById(2131099906);
    Object localObject3 = (TextView)findViewById(2131099907);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099818);
    Object localObject5;
    if (m >= 0)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(APTools.a(m));
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
      ((StringBuilder)localObject4).append(APTools.a(i));
      ((StringBuilder)localObject4).append("元");
      ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
    }
    else
    {
      ((TextView)localObject3).setText("充值成功");
      if (this.f != 1)
      {
        ((Button)localObject1).setVisibility(8);
        this.c.setText(getString(2131230806));
      }
    }
    if (k <= 0)
    {
      localLinearLayout.setVisibility(8);
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(APTools.a(k));
      ((StringBuilder)localObject3).append("元");
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
      localLinearLayout.setVisibility(0);
    }
    if (this.f == 1)
    {
      ((Button)localObject1).setVisibility(8);
      ((TextView)findViewById(2131099908)).setVisibility(0);
    }
    if (i <= 0) {
      bool = false;
    }
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.pcard.interal.back", APMCardAccountSaveSuccActivity.c(APMCardAccountSaveSuccActivity.this));
        if ((!bool) && (APMCardAccountSaveSuccActivity.d(APMCardAccountSaveSuccActivity.this) != 1))
        {
          APMCardAccountSaveSuccActivity.b(APMCardAccountSaveSuccActivity.this).setVisibility(8);
          APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).setVisibility(0);
          APMCardAccountSaveSuccActivity.a(APMCardAccountSaveSuccActivity.this).b();
          APMCardAccountSaveSuccActivity.this.b();
          return;
        }
        APUICommonMethod.b();
        fv.a(2, "");
      }
    });
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.pcard.interal.recharge", APMCardAccountSaveSuccActivity.e(APMCardAccountSaveSuccActivity.this));
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(APMCardAccountSaveSuccActivity.this, APMCardAccountSaveActivity.class);
        APMCardAccountSaveSuccActivity.this.startActivity(paramAnonymousView);
        APMCardAccountSaveSuccActivity.this.finish();
        APUICommonMethod.b(APMCardAccountSaveSuccActivity.this);
      }
    });
  }
  
  protected void b()
  {
    String str = em.b().n().e.f;
    fb.a().a(this, str, this.a, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165205);
      a();
      a.a().f = true;
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APUICommonMethod.b();
      fv.a(2, "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardAccountSaveSuccActivity
 * JD-Core Version:    0.7.0.1
 */