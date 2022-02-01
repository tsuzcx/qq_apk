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
import java.util.ArrayList;
import java.util.List;
import midas.x.a;
import midas.x.el;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.ex;
import midas.x.ey;
import midas.x.fv;
import midas.x.fw;
import midas.x.fy;
import midas.x.gc;
import midas.x.hf;
import midas.x.ho;
import midas.x.hp;
import midas.x.hq;
import midas.x.hr;
import midas.x.o;

public class APPayStoreActivity
  extends APActivity
{
  private APViewPager a = null;
  private List<Button> b = null;
  private int c = 1000;
  private ho d = null;
  private View.OnClickListener e = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      APPayStoreActivity.a(APPayStoreActivity.this, paramAnonymousView.getId());
      APPayStoreActivity.a(APPayStoreActivity.this).setCurrentItem(APPayStoreActivity.b(APPayStoreActivity.this, paramAnonymousView.getId()));
    }
  };
  
  private void a(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.c);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private boolean a()
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    return localDisplayMetrics.heightPixels >= i;
  }
  
  private void b()
  {
    this.a = ((APViewPager)findViewById(2131099756));
    this.b = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    View localView;
    if (fy.a().g() == "APPayGameInputNumActivity")
    {
      this.d = new hq(this, this.p);
      localView = this.d.a();
      localArrayList.add(localView);
    }
    else
    {
      this.d = new hr(this, this.p);
      localView = this.d.a();
      localArrayList.add(localView);
    }
    new hp(this, this.p);
    Button localButton = (Button)findViewById(2131099968);
    Object localObject;
    if (this.p.a.saveType == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("充值");
      ((StringBuilder)localObject).append(((eu)this.p.b).b);
      localButton.setText(((StringBuilder)localObject).toString());
    }
    else if (this.p.a.saveType == 4)
    {
      localObject = "开通";
      int i = ((ew)this.p.b).l;
      if (i == 3)
      {
        localObject = "升级为";
        ((ew)this.p.b).e = gc.a().c();
      }
      else if (i == 1)
      {
        localObject = "开通";
      }
      else if (i == 2)
      {
        localObject = "续费";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(((APMonthRequest)this.p.a).serviceName);
      localButton.setText(localStringBuilder.toString());
    }
    else if (this.p.a.saveType == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("购买");
      ((StringBuilder)localObject).append(((ev)this.p.b).b);
      localButton.setText(((StringBuilder)localObject).toString());
    }
    else if (this.p.a.saveType == 5)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("购买");
      ((StringBuilder)localObject).append(((ew)this.p.b).b);
      localButton.setText(((StringBuilder)localObject).toString());
    }
    else if (this.p.a.saveType == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("购买");
      ((StringBuilder)localObject).append(((ey)this.p.b).b);
      localButton.setText(((StringBuilder)localObject).toString());
    }
    else if (this.p.a.saveType == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("购买");
      ((StringBuilder)localObject).append(((ex)this.p.b).b);
      localButton.setText(((StringBuilder)localObject).toString());
    }
    this.a.setAdapter(new hf(localArrayList));
    this.a.setOnPageChangeListener(new APViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        APPayStoreActivity.a(APPayStoreActivity.this, ((Button)APPayStoreActivity.b(APPayStoreActivity.this).get(paramAnonymousInt)).getId());
      }
    });
    c();
    ((ImageButton)findViewById(2131099849)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APPayStoreActivity.c(APPayStoreActivity.this) != null) {
          APPayStoreActivity.c(APPayStoreActivity.this).b();
        }
        APUICommonMethod.b();
        fv.a(2, "");
        fw.b();
      }
    });
    a(findViewById(2131099989));
    b(localView);
  }
  
  private void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.c);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.b.size())
    {
      ((Button)this.b.get(i)).setOnClickListener(this.e);
      i += 1;
    }
  }
  
  private void c(int paramInt)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (paramInt == ((Button)this.b.get(i)).getId())
      {
        ((Button)this.b.get(i)).setBackgroundResource(2131034188);
        ((Button)this.b.get(i)).setTextColor(-1);
      }
      else
      {
        ((Button)this.b.get(i)).setBackgroundResource(0);
        ((Button)this.b.get(i)).setTextColor(-8617601);
      }
      i += 1;
    }
  }
  
  private int d(int paramInt)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((Button)this.b.get(i)).getId() == paramInt) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      if (a()) {
        setContentView(2131165221);
      } else {
        setContentView(2131165220);
      }
      a.a().f = true;
      b();
      getWindow().getDecorView().setVisibility(4);
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d != null) {
        this.d.a(this, paramInt, paramKeyEvent);
      }
      APUICommonMethod.b();
      fv.a(2, "");
      fw.b();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    o.a().a(false);
    o.a().f();
    if (this.d != null) {
      this.d.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payCenter.APPayStoreActivity
 * JD-Core Version:    0.7.0.1
 */