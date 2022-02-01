package com.pay.ui.common;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.Timer;
import java.util.TimerTask;
import midas.x.a;
import midas.x.ec;
import midas.x.ed;
import midas.x.fp;
import midas.x.gj;

public class APActivity
  extends APPluginActivity
{
  private String a = "Q点";
  private String b = "Q币";
  private String c = "1元=1Q币";
  private String d = "1元=10Q点";
  private boolean e = false;
  public int f;
  protected int g = 200;
  protected RelativeLayout h = null;
  protected String i = null;
  protected boolean j = false;
  protected boolean k = true;
  protected boolean l = true;
  protected int m = -1;
  protected int n = 0;
  public gj o;
  public ec p;
  
  private void a() {}
  
  public void a(int paramInt)
  {
    findViewById(paramInt).setBackgroundDrawable(getResources().getDrawable(2131034174));
  }
  
  public void a(final View paramView, int paramInt)
  {
    final InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        localInputMethodManager.showSoftInput(paramView, 1);
      }
    }, paramInt);
  }
  
  public void b(int paramInt)
  {
    findViewById(paramInt).setBackgroundDrawable(getResources().getDrawable(2131034173));
  }
  
  protected void e() {}
  
  protected gj f()
  {
    gj localgj = new gj(this);
    localgj.setMessage("请稍候...");
    return localgj;
  }
  
  public void g()
  {
    try
    {
      if (getWindow().getAttributes().softInputMode == 5)
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null)
        {
          localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 1);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismissInput");
      localStringBuilder.append(localException.getMessage());
      APLog.w("APActivity", localStringBuilder.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      APUICommonMethod.pushActivity(this);
      this.p = ed.b().n();
      this.f = this.p.a.saveType;
      this.o = f();
      return;
    }
    APLog.e("APActivity", "data is null");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.o != null) {
      this.o.dismiss();
    }
    e();
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(View.inflate(this, paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APActivity
 * JD-Core Version:    0.7.0.1
 */