package midas.x;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.midas.comm.APLog;

public class x6
{
  public PopupWindow a;
  public Handler b;
  public Context c;
  public View d;
  public View e;
  public ImageView f;
  public int g;
  public boolean h;
  public boolean i;
  public ViewTreeObserver.OnGlobalLayoutListener j = new a();
  
  public x6(Context paramContext, View paramView)
  {
    this.c = paramContext;
    this.d = paramView;
    this.b = new Handler();
    this.g = 0;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.g = paramInt2;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
      this.e = ((Activity)this.c).getLayoutInflater().inflate(2131165260, null);
      ImageView localImageView = (ImageView)this.e.findViewById(2131099998);
      localObject = (ImageView)this.e.findViewById(2131099997);
      if (paramBoolean2)
      {
        ((ImageView)localObject).setVisibility(8);
        localImageView.setVisibility(0);
        this.f = localImageView;
      }
      else
      {
        localImageView.setVisibility(8);
        ((ImageView)localObject).setVisibility(0);
        this.f = ((ImageView)localObject);
      }
      this.a = new PopupWindow(this.e, -2, -2);
      this.a.setAnimationStyle(0);
      this.a.setFocusable(false);
      this.a.setTouchable(false);
      this.a.setOutsideTouchable(false);
      this.a.setInputMethodMode(1);
      this.b.postDelayed(new c(null), paramInt1);
      return;
    }
    catch (Exception localException)
    {
      a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Show crash:");
      ((StringBuilder)localObject).append(localException.toString());
      APLog.e("APPopupBubble", ((StringBuilder)localObject).toString());
    }
  }
  
  public final void b()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        if ((this.d != null) && (this.j != null)) {
          if (Build.VERSION.SDK_INT < 16) {
            this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
          } else {
            this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this.j);
          }
        }
        this.a.dismiss();
      }
      this.a = null;
      this.d = null;
      this.b = null;
      this.e = null;
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismissPopupWindow crash:");
      localStringBuilder.append(localException.toString());
      APLog.e("APPopupBubble", localStringBuilder.toString());
    }
  }
  
  public final int c()
  {
    if (!this.h)
    {
      float f1 = this.d.getMeasuredWidth();
      return (int)(-this.a.getContentView().getMeasuredWidth() + f1);
    }
    return 0;
  }
  
  public final int d()
  {
    if (!this.i)
    {
      float f1 = this.d.getMeasuredHeight();
      float f2 = this.a.getContentView().getMeasuredHeight();
      float f3 = this.f.getMeasuredHeight();
      return (int)(-f1 - f2 - f3);
    }
    return 0;
  }
  
  public final void e()
  {
    try
    {
      float f2 = this.d.getMeasuredWidth();
      float f1 = ((CheckBox)this.d).getTotalPaddingLeft();
      f2 -= f1;
      float f3 = this.f.getMeasuredWidth();
      float f4 = this.a.getContentView().getMeasuredWidth();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      boolean bool = this.h;
      double d1;
      int k;
      if (bool)
      {
        d1 = f1 + f2 / 2.0F - f3 / 2.0F;
        Double.isNaN(d1);
        k = (int)(d1 + 0.5D);
        localLayoutParams.setMargins(k, 0, 0, -1);
      }
      else
      {
        d1 = f4 - f2 / 2.0F - f3 / 2.0F;
        Double.isNaN(d1);
        k = (int)(d1 + 0.5D);
        localLayoutParams.setMargins(k, 0, 0, -1);
      }
      this.f.setLayoutParams(localLayoutParams);
      return;
    }
    catch (Exception localException)
    {
      a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateIndicator crash:");
      localStringBuilder.append(localException.toString());
      APLog.e("APPopupBubble", localStringBuilder.toString());
    }
  }
  
  public final void f()
  {
    try
    {
      if (this.a != null)
      {
        e();
        this.a.update(this.d, c(), d(), this.a.getWidth(), this.a.getHeight());
        return;
      }
    }
    catch (Exception localException)
    {
      a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePopupWindow crash:");
      localStringBuilder.append(localException.toString());
      APLog.e("APPopupBubble", localStringBuilder.toString());
    }
  }
  
  public class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public a() {}
    
    public void onGlobalLayout()
    {
      x6.a(x6.this);
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      x6.c(x6.this);
    }
  }
  
  public class c
    implements Runnable
  {
    public c() {}
    
    public void run()
    {
      try
      {
        if (x6.d(x6.this) != null)
        {
          x6.d(x6.this).getContentView().measure(-2, -2);
          x6.e(x6.this);
          x6.d(x6.this).showAsDropDown(x6.f(x6.this), x6.g(x6.this), x6.h(x6.this));
          x6.f(x6.this).getViewTreeObserver().addOnGlobalLayoutListener(x6.i(x6.this));
          x6.b(x6.this).postDelayed(new x6.b(x6.this, null), x6.j(x6.this));
          return;
        }
      }
      catch (Exception localException)
      {
        x6.this.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PopShowRunnable crash:");
        localStringBuilder.append(localException.toString());
        APLog.e("APPopupBubble", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x6
 * JD-Core Version:    0.7.0.1
 */