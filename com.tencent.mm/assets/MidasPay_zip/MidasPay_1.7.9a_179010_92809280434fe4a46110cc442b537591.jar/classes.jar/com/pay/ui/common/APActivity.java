package com.pay.ui.common;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.Timer;
import java.util.TimerTask;
import midas.x.a;
import midas.x.c6;
import midas.x.o4;
import midas.x.p4;
import midas.x.y6;

public class APActivity
  extends APPluginActivity
{
  public int a;
  public y6 b;
  public o4 c;
  
  public void a(int paramInt)
  {
    findViewById(paramInt).setBackgroundDrawable(getResources().getDrawable(2131034174));
  }
  
  public void a(final View paramView, int paramInt)
  {
    final InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    new Timer().schedule(new a(localInputMethodManager, paramView), paramInt);
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    findViewById(paramInt).setBackgroundDrawable(getResources().getDrawable(2131034173));
  }
  
  public final void c() {}
  
  public y6 d()
  {
    y6 localy6 = new y6(this);
    localy6.setMessage("请稍候...");
    return localy6;
  }
  
  public void e()
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
    if ((c6.s0().i()) && (a.r().d != null))
    {
      APUICommonMethod.pushActivity(this);
      this.c = p4.p().e();
      this.a = this.c.b.saveType;
      this.b = d();
      return;
    }
    APLog.e("APActivity", "data is null");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y6 localy6 = this.b;
    if (localy6 != null) {
      localy6.dismiss();
    }
    b();
    c();
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
  
  public class a
    extends TimerTask
  {
    public a(InputMethodManager paramInputMethodManager, View paramView) {}
    
    public void run()
    {
      localInputMethodManager.showSoftInput(paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APActivity
 * JD-Core Version:    0.7.0.1
 */