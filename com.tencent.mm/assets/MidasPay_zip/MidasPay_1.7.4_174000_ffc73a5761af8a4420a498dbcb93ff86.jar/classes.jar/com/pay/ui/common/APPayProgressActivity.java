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
import midas.x.a;
import midas.x.by;
import midas.x.cg;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fb;
import midas.x.ff;
import midas.x.fl;
import midas.x.fm;
import midas.x.fv;
import midas.x.fy;
import midas.x.gy;
import midas.x.lh;
import midas.x.lw;

public class APPayProgressActivity
  extends APActivity
{
  Runnable a = new Runnable()
  {
    public void run()
    {
      APPayProgressActivity.a(APPayProgressActivity.this);
      if (APPayProgressActivity.b(APPayProgressActivity.this) == 60)
      {
        APPayProgressActivity.c(APPayProgressActivity.this).clearAnimation();
        APPayProgressActivity.a(APPayProgressActivity.this, true);
        APPayProgressActivity.d(APPayProgressActivity.this);
        APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacksAndMessages(null);
        return;
      }
      if ((APPayProgressActivity.b(APPayProgressActivity.this) % 10 == 0) && (APPayProgressActivity.f(APPayProgressActivity.this)))
      {
        APPayProgressActivity.b(APPayProgressActivity.this, false);
        APPayProgressActivity.g(APPayProgressActivity.this);
      }
      APPayProgressActivity.h(APPayProgressActivity.this).setText(String.valueOf(60 - APPayProgressActivity.b(APPayProgressActivity.this)));
      APPayProgressActivity.e(APPayProgressActivity.this).postDelayed(APPayProgressActivity.this.a, 1000L);
    }
  };
  private final int b = 1000;
  private final int c = 60;
  private boolean d = false;
  private boolean e = false;
  private int q;
  private Button r;
  private a s = new a();
  private int t = 0;
  private TextView u;
  private TextView v;
  private ImageView w;
  private int x;
  private String y;
  private View.OnClickListener z = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      APPayProgressActivity.i(APPayProgressActivity.this);
    }
  };
  
  private void a()
  {
    this.r = ((Button)findViewById(2131099773));
    this.r.setOnClickListener(this.z);
    this.u = ((TextView)findViewById(2131099996));
    this.w = ((ImageView)findViewById(2131099966));
    this.v = ((TextView)findViewById(2131099915));
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771973);
    localAnimation.setInterpolator(new LinearInterpolator());
    this.w.startAnimation(localAnimation);
  }
  
  private void b()
  {
    if (this.q == 5)
    {
      this.u.setText(getString(2131230814));
      return;
    }
    if (this.q == 9)
    {
      this.u.setText(getString(2131230797));
      return;
    }
    if (this.q == 8) {
      this.u.setText(getString(2131230932));
    }
  }
  
  private void c()
  {
    Object localObject = APDataReportManager.getInstance();
    int i = this.x;
    String str = this.y;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("&countdown=0");
    ((APDataReportManager)localObject).insertData("sdk.result.inner.query.timeout", i, str, "", localStringBuilder.toString());
    if (this.q == 5)
    {
      by.a("mcardstatus");
      localObject = fb.a("mcard");
      if ((localObject instanceof APMcardChannel)) {
        ((APMcardChannel)localObject).a(this);
      }
    }
    else if (this.q == 9)
    {
      by.a("hfstatus");
      localObject = fb.a("hfpay");
      if ((localObject instanceof APHFChannel)) {
        ((APHFChannel)localObject).a(this);
      }
    }
    else if (this.q == 8)
    {
      by.a("querywxresult");
      a("查询失败", true);
    }
  }
  
  private void d()
  {
    if (this.q == 5)
    {
      i();
      return;
    }
    if (this.q == 9)
    {
      j();
      return;
    }
    if (this.q == 8) {
      h();
    }
  }
  
  private void h()
  {
    et localet = em.b().n().b;
    by.a().b(localet.g(), "3", new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramAnonymouslh = (cg)paramAnonymouslh;
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        int i = APPayProgressActivity.j(APPayProgressActivity.this);
        String str = APPayProgressActivity.k(APPayProgressActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(APPayProgressActivity.l(APPayProgressActivity.this));
        localStringBuilder.append("&countdown=");
        localStringBuilder.append(60 - APPayProgressActivity.b(APPayProgressActivity.this));
        localAPDataReportManager.insertData("sdk.result.inner.query.over", i, str, "", localStringBuilder.toString());
        if (paramAnonymouslh.T() == 0)
        {
          if ((paramAnonymouslh.a() != 2) && (paramAnonymouslh.a() != 3) && (paramAnonymouslh.a() != 4) && (paramAnonymouslh.a() != 5))
          {
            if (!TextUtils.isEmpty(paramAnonymouslh.U()))
            {
              APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.a);
              APPayProgressActivity.this.a(paramAnonymouslh.U(), true);
              return;
            }
            APPayProgressActivity.b(APPayProgressActivity.this, true);
            return;
          }
          APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.a);
          fb.a();
          fb.a("wechat").a(null);
          return;
        }
        APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.a);
        if (!TextUtils.isEmpty(paramAnonymouslh.U()))
        {
          APPayProgressActivity.this.a(paramAnonymouslh.U(), true);
          return;
        }
        APPayProgressActivity.this.a("查询失败", true);
      }
      
      public void b(lh paramAnonymouslh)
      {
        APPayProgressActivity.b(APPayProgressActivity.this, true);
      }
      
      public void c(lh paramAnonymouslh)
      {
        paramAnonymouslh = APDataReportManager.getInstance();
        int i = APPayProgressActivity.j(APPayProgressActivity.this);
        String str = APPayProgressActivity.k(APPayProgressActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(APPayProgressActivity.l(APPayProgressActivity.this));
        localStringBuilder.append("&countdown=");
        localStringBuilder.append(60 - APPayProgressActivity.b(APPayProgressActivity.this));
        paramAnonymouslh.insertData("sdk.result.inner.query.over", i, str, "", localStringBuilder.toString());
        APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacks(APPayProgressActivity.this.a);
        APPayProgressActivity.this.a("查询失败", true);
      }
    });
  }
  
  private void i()
  {
    fb.a().a(this, new fm()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBundle = APDataReportManager.getInstance();
          paramAnonymousInt = APPayProgressActivity.j(APPayProgressActivity.this);
          String str = APPayProgressActivity.k(APPayProgressActivity.this);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("channel=");
          localStringBuilder.append(APPayProgressActivity.l(APPayProgressActivity.this));
          localStringBuilder.append("&countdown=");
          localStringBuilder.append(60 - APPayProgressActivity.b(APPayProgressActivity.this));
          paramAnonymousBundle.insertData("sdk.result.inner.query.over", paramAnonymousInt, str, "", localStringBuilder.toString());
          APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacksAndMessages(null);
          return;
        }
        APPayProgressActivity.b(APPayProgressActivity.this, true);
      }
    });
  }
  
  private void j()
  {
    fb.a().a(this, new fl()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt == 0)
        {
          paramAnonymousBundle = APDataReportManager.getInstance();
          paramAnonymousInt = APPayProgressActivity.j(APPayProgressActivity.this);
          String str = APPayProgressActivity.k(APPayProgressActivity.this);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("channel=");
          localStringBuilder.append(APPayProgressActivity.l(APPayProgressActivity.this));
          localStringBuilder.append("&countdown=");
          localStringBuilder.append(60 - APPayProgressActivity.b(APPayProgressActivity.this));
          paramAnonymousBundle.insertData("sdk.result.inner.query.over", paramAnonymousInt, str, "", localStringBuilder.toString());
          APPayProgressActivity.e(APPayProgressActivity.this).removeCallbacksAndMessages(null);
          return;
        }
        APPayProgressActivity.b(APPayProgressActivity.this, true);
      }
    });
  }
  
  private void k()
  {
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = this.x;
    String str = this.y;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("&countdown=");
    localStringBuilder.append(60 - this.t);
    localAPDataReportManager.insertData("sdk.result.inner.back", i, str, "", localStringBuilder.toString());
    this.w.clearAnimation();
    APUICommonMethod.b();
    if (this.q == 5)
    {
      fv.a(5, -1, -1);
      return;
    }
    if (this.q == 9)
    {
      fv.a(9, -1, -1);
      return;
    }
    if (this.q == 8) {
      fv.a(8, -1, -1);
    }
  }
  
  public void a(String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("contextRef:");
    ((StringBuilder)localObject).append(this);
    APLog.e("APPayProgressActivity showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.a(this);
    ((APAlertDialog.a)localObject).a(paramString);
    ((APAlertDialog.a)localObject).a("我知道了", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((!paramBoolean) && (a.a().f))
        {
          paramAnonymousAPAlertDialog.a();
          return;
        }
        paramAnonymousAPAlertDialog.a();
        APUICommonMethod.b();
        fv.a(-1, "");
      }
    });
    ((APAlertDialog.a)localObject).b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.a().f)))
        {
          APUICommonMethod.b();
          fv.a(-1, "");
        }
      }
    });
    try
    {
      ((APAlertDialog.a)localObject).c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165207);
      this.q = getIntent().getExtras().getInt("channel");
      this.x = em.b().n().a.saveType;
      this.y = em.b().n().e.m;
      a();
      b();
      d();
      this.s.postDelayed(this.a, 1000L);
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e = false;
    this.s.removeCallbacks(this.a);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      k();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public static class a
    extends Handler
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APPayProgressActivity
 * JD-Core Version:    0.7.0.1
 */