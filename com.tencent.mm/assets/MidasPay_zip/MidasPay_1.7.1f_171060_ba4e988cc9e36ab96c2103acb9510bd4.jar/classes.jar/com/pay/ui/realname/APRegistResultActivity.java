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
import java.lang.ref.WeakReference;
import midas.x.a;
import midas.x.ec;
import midas.x.ed;
import midas.x.er;
import midas.x.fm;
import midas.x.fp;

public class APRegistResultActivity
  extends APActivity
{
  private Button a;
  private Button b;
  private TextView c;
  private TextView d;
  private int e = -1;
  
  protected void a()
  {
    this.c = ((TextView)findViewById(2131100046));
    this.d = ((TextView)findViewById(2131100045));
    this.a = ((Button)findViewById(2131099706));
    this.b = ((Button)findViewById(2131099701));
    Object localObject = getIntent().getExtras();
    if (((Bundle)localObject).containsKey("ret")) {
      this.e = ((Bundle)localObject).getInt("ret");
    }
    if (((Bundle)localObject).containsKey("msg")) {
      localObject = ((Bundle)localObject).getString("msg");
    } else {
      localObject = null;
    }
    if (this.e == 0)
    {
      this.c.setText("认证成功");
      this.a.setText("去支付");
      this.b.setVisibility(8);
    }
    else
    {
      this.c.setText("认证失败");
      this.a.setText("重新验证");
      this.b.setVisibility(0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.d.setText((CharSequence)localObject);
      }
    }
    this.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APRegistResultActivity.a(APRegistResultActivity.this) == 0)
        {
          if (a.a().c.get() != null)
          {
            APRegistResultActivity.this.finish();
            APUICommonMethod.b(APRegistResultActivity.this);
            a.a().a((Activity)a.a().c.get(), ed.b().n().a, a.a().a);
          }
          else
          {
            APUICommonMethod.b();
            fm.a(13, "");
          }
        }
        else
        {
          APRegistResultActivity.this.finish();
          APUICommonMethod.b(APRegistResultActivity.this);
        }
        APDataReportManager.getInstance().insertData("sdk.qcard.pay", APRegistResultActivity.b(APRegistResultActivity.this), ed.b().n().e.l, String.valueOf(4), null);
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APUICommonMethod.b();
        fm.a(13, "");
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      setContentView(2131165248);
      a();
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData("sdk.realname.back", this.f, ed.b().n().e.l, String.valueOf(4), null);
      APUICommonMethod.b();
      fm.a(13, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.qcard.show", this.f, ed.b().n().e.l, String.valueOf(4), null);
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.realname.APRegistResultActivity
 * JD-Core Version:    0.7.0.1
 */