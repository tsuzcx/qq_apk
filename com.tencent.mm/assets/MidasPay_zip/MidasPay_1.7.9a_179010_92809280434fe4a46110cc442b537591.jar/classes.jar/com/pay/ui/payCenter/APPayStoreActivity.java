package com.pay.ui.payCenter;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.v4.view.APViewPager;
import com.pay.v4.view.APViewPager.OnPageChangeListener;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.List;
import midas.x.a;
import midas.x.a5;
import midas.x.a6;
import midas.x.b5;
import midas.x.c6;
import midas.x.g6;
import midas.x.j7;
import midas.x.o4;
import midas.x.p;
import midas.x.s7;
import midas.x.t7;
import midas.x.u7;
import midas.x.v7;
import midas.x.w4;
import midas.x.x4;
import midas.x.y4;
import midas.x.z4;
import midas.x.z5;

public class APPayStoreActivity
  extends APActivity
{
  public APViewPager d = null;
  public List<Button> e = null;
  public int f = 1000;
  public s7 g = null;
  public View.OnClickListener h = new a();
  
  public final void a(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.f);
    localTranslateAnimation.setAnimationListener(new e());
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public final void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.f);
    localTranslateAnimation.setAnimationListener(new d());
    paramView.startAnimation(localTranslateAnimation);
  }
  
  public final int c(int paramInt)
  {
    int i = 0;
    while (i < this.e.size())
    {
      if (((Button)this.e.get(i)).getId() == paramInt) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public final void d(int paramInt)
  {
    int i = 0;
    while (i < this.e.size())
    {
      if (paramInt == ((Button)this.e.get(i)).getId())
      {
        ((Button)this.e.get(i)).setBackgroundResource(2131034188);
        ((Button)this.e.get(i)).setTextColor(-1);
      }
      else
      {
        ((Button)this.e.get(i)).setBackgroundResource(0);
        ((Button)this.e.get(i)).setTextColor(-8617601);
      }
      i += 1;
    }
  }
  
  public final void f()
  {
    this.d = ((APViewPager)findViewById(2131099756));
    this.e = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    View localView;
    if (c6.s0().Q() == "APPayGameInputNumActivity")
    {
      this.g = new u7(this, this.c);
      localView = this.g.b();
      localArrayList.add(localView);
    }
    else
    {
      this.g = new v7(this, this.c);
      localView = this.g.b();
      localArrayList.add(localView);
    }
    new t7(this, this.c);
    Button localButton = (Button)findViewById(2131099968);
    Object localObject1 = this.c;
    int i = ((o4)localObject1).b.saveType;
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("充值");
      ((StringBuilder)localObject1).append(((x4)this.c.c).b);
      localButton.setText(((StringBuilder)localObject1).toString());
    }
    else if (i == 4)
    {
      Object localObject2 = ((o4)localObject1).c;
      i = ((z4)localObject2).l;
      localObject1 = "开通";
      if (i == 3)
      {
        ((z4)localObject2).c = g6.k().h();
        localObject1 = "升级为";
      }
      else if ((i != 1) && (i == 2))
      {
        localObject1 = "续费";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(((APMonthRequest)this.c.b).serviceName);
      localButton.setText(((StringBuilder)localObject2).toString());
    }
    else if (i == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("购买");
      ((StringBuilder)localObject1).append(((y4)this.c.c).b);
      localButton.setText(((StringBuilder)localObject1).toString());
    }
    else if (i == 5)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("购买");
      ((StringBuilder)localObject1).append(((z4)this.c.c).b);
      localButton.setText(((StringBuilder)localObject1).toString());
    }
    else if (i == 2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("购买");
      ((StringBuilder)localObject1).append(((b5)this.c.c).b);
      localButton.setText(((StringBuilder)localObject1).toString());
    }
    else if (i == 3)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("购买");
      ((StringBuilder)localObject1).append(((a5)this.c.c).b);
      localButton.setText(((StringBuilder)localObject1).toString());
    }
    this.d.setAdapter(new j7(localArrayList));
    this.d.setOnPageChangeListener(new b());
    h();
    ((ImageButton)findViewById(2131099849)).setOnClickListener(new c());
    b(findViewById(2131099989));
    a(localView);
  }
  
  public final boolean g()
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    return localDisplayMetrics.heightPixels >= i;
  }
  
  public final void h()
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((Button)this.e.get(i)).setOnClickListener(this.h);
      i += 1;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      if (g()) {
        setContentView(2131165221);
      } else {
        setContentView(2131165220);
      }
      a.r().f = true;
      f();
      getWindow().getDecorView().setVisibility(4);
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      s7 locals7 = this.g;
      if (locals7 != null) {
        locals7.a(this, paramInt, paramKeyEvent);
      }
      APUICommonMethod.f();
      z5.a(2, "");
      a6.c();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    p.o().a(false);
    p.o().k();
    s7 locals7 = this.g;
    if (locals7 != null) {
      locals7.c();
    }
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APPayStoreActivity.a(APPayStoreActivity.this, paramView.getId());
      APPayStoreActivity.a(APPayStoreActivity.this).setCurrentItem(APPayStoreActivity.b(APPayStoreActivity.this, paramView.getId()));
    }
  }
  
  public class b
    implements APViewPager.OnPageChangeListener
  {
    public b() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      APPayStoreActivity localAPPayStoreActivity = APPayStoreActivity.this;
      APPayStoreActivity.a(localAPPayStoreActivity, ((Button)APPayStoreActivity.b(localAPPayStoreActivity).get(paramInt)).getId());
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      if (APPayStoreActivity.c(APPayStoreActivity.this) != null) {
        APPayStoreActivity.c(APPayStoreActivity.this).a();
      }
      APUICommonMethod.f();
      z5.a(2, "");
      a6.c();
    }
  }
  
  public class d
    implements Animation.AnimationListener
  {
    public d() {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public class e
    implements Animation.AnimationListener
  {
    public e() {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payCenter.APPayStoreActivity
 * JD-Core Version:    0.7.0.1
 */