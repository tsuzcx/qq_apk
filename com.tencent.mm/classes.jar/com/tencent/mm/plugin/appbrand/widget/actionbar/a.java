package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;
import java.util.ArrayList;

public final class a
  extends LinearLayout
  implements d, c.a
{
  public AppBrandCapsuleHomeButton hoA;
  private LinearLayout hoB;
  private ImageView hoC;
  private int hoD;
  private int hoE;
  private double hoF;
  private boolean hoG;
  private boolean hoH;
  private boolean hoI;
  private b hoJ = new b();
  private long hoK = 0L;
  private ImageView hos;
  private View hot;
  private View hou;
  private TextView hov;
  private TextView how;
  private ProgressBar hox;
  private CircleProgressDrawable hoy;
  public AppBrandOptionButton hoz;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.hoI = paramBoolean;
    this.hoG = false;
    this.hoH = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(com.tencent.luggage.l.a.a.action_bar_color);
    addView(((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(a.e.app_brand_action_bar, this, false));
    this.hoD = -1;
    this.hoE = getResources().getColor(com.tencent.luggage.l.a.a.action_bar_color);
    this.hoF = 1.0D;
    this.hos = ((ImageView)findViewById(a.d.actionbar_nav_btn));
    this.hot = findViewById(a.d.actionbar_nav_area);
    this.hou = findViewById(a.d.actionbar_title_area);
    this.hov = ((TextView)findViewById(a.d.actionbar_title_main));
    this.how = ((TextView)findViewById(a.d.actionbar_title_sub));
    this.hox = ((ProgressBar)findViewById(a.d.actionbar_loading_icon));
    this.hoy = new CircleProgressDrawable();
    this.hoz = ((AppBrandOptionButton)findViewById(a.d.actionbar_capsule_option_btn));
    this.hoA = ((AppBrandCapsuleHomeButton)findViewById(a.d.actionbar_capsule_home_btn));
    this.hoB = ((LinearLayout)findViewById(a.d.actionbar_capsule_area));
    this.hoC = ((ImageView)findViewById(a.d.actionbar_capsule_divider));
    this.hot.setOnClickListener(new a.1(this));
    this.hoA.setOnClickListener(new a.2(this));
  }
  
  private void aqX()
  {
    if (!q.al(this))
    {
      post(new a.3(this));
      return;
    }
    if (this.hoI) {
      setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      forceLayout();
      invalidate();
      return;
      setPadding(0, Math.max(com.tencent.mm.ui.statusbar.a.ae(l.cx(getContext())), 0), 0, 0);
    }
  }
  
  private void aqY()
  {
    this.hos.setImageResource(a.c.actionbar_icon_dark_back);
    this.hos.setColorFilter(this.hoD, PorterDuff.Mode.SRC_ATOP);
    this.hov.setTextColor(this.hoD);
    this.how.setTextColor(this.hoD);
    CircleProgressDrawable localCircleProgressDrawable = this.hoy;
    localCircleProgressDrawable.mZ = this.hoD;
    localCircleProgressDrawable.invalidateSelf();
    this.hox.setLayerType(1, null);
    this.hox.setIndeterminateDrawable(this.hoy);
    aqZ();
    if (this.hoD == -1)
    {
      this.hoC.setImageResource(com.tencent.luggage.l.a.a.app_brand_capsule_divider_dark);
      this.hoB.setBackgroundResource(a.c.app_brand_game_capsule_dark_background);
      return;
    }
    this.hoC.setImageResource(com.tencent.luggage.l.a.a.app_brand_capsule_divider_light);
    this.hoB.setBackgroundResource(a.c.app_brand_game_capsule_light_background);
  }
  
  private void ara()
  {
    View localView = this.hot;
    if ((this.hoH) || (this.hoG)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      return;
    }
  }
  
  public final void aqZ()
  {
    if (this.hoD == -1)
    {
      this.hoz.setColor(-1);
      this.hoA.setColor(-1);
      return;
    }
    this.hoz.setColor(-16777216);
    this.hoA.setColor(-16777216);
  }
  
  public final void dN(boolean paramBoolean)
  {
    this.hoI = paramBoolean;
    aqX();
  }
  
  public final void dO(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.hoB.setVisibility(0);
      return;
    }
    this.hoB.setVisibility(8);
  }
  
  public final View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.hoF;
  }
  
  public final int getBackgroundColor()
  {
    return this.hoE;
  }
  
  public final int getForegroundColor()
  {
    return this.hoD;
  }
  
  public final CharSequence getMainTitle()
  {
    return this.hov.getText();
  }
  
  public final void ml(int paramInt)
  {
    aqX();
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c.af(l.cx(getContext())).a(this);
    aqX();
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hoJ.a(paramOnClickListener);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    this.hoF = paramDouble;
    if (!this.hoH) {
      super.getBackground().setAlpha((int)(255.0D * paramDouble));
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.hoE = paramInt;
    if (!this.hoH) {
      super.setBackgroundColor(paramInt);
    }
    setBackgroundAlpha(this.hoF);
  }
  
  public final void setBackgroundColor(String paramString)
  {
    this.hoE = l.bb(paramString, this.hoE);
    setBackgroundColor(this.hoE);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.hoA.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hoJ.b(paramOnClickListener);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    this.hoD = paramInt;
    aqY();
  }
  
  public final void setForegroundStyle(String paramString)
  {
    if ("white".equals(paramString)) {
      this.hoD = -1;
    }
    for (;;)
    {
      aqY();
      return;
      if ("black".equals(paramString)) {
        this.hoD = -16777216;
      }
    }
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    this.hoH = paramBoolean;
    ara();
    if (paramBoolean)
    {
      this.hou.setVisibility(4);
      super.setBackgroundColor(0);
      return;
    }
    this.hou.setVisibility(0);
    setBackgroundColor(this.hoE);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    Object localObject1 = this.hox;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ProgressBar)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject1 = this.hoy;
      ((CircleProgressDrawable)localObject1).mG.clear();
      ArrayList localArrayList = ((CircleProgressDrawable)localObject1).mG;
      Object localObject2 = ((CircleProgressDrawable)localObject1).hod;
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject2, "trimPathStart", new float[] { 0.0F, 0.75F });
      localObjectAnimator1.setDuration(1333L);
      localObjectAnimator1.setInterpolator(CircleProgressDrawable.c.hof);
      localObjectAnimator1.setRepeatCount(-1);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject2, "trimPathEnd", new float[] { 0.0F, 0.75F });
      localObjectAnimator2.setDuration(1333L);
      localObjectAnimator2.setInterpolator(CircleProgressDrawable.b.hof);
      localObjectAnimator2.setRepeatCount(-1);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "trimPathOffset", new float[] { 0.0F, 0.25F });
      ((ObjectAnimator)localObject2).setDuration(1333L);
      ((ObjectAnimator)localObject2).setInterpolator(CircleProgressDrawable.a.hof);
      ((ObjectAnimator)localObject2).setRepeatCount(-1);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObject2 });
      localArrayList.add(localAnimatorSet);
      localArrayList = ((CircleProgressDrawable)localObject1).mG;
      localObject1 = ObjectAnimator.ofFloat(((CircleProgressDrawable)localObject1).hoe, "rotation", new float[] { 0.0F, 720.0F });
      ((ObjectAnimator)localObject1).setDuration(6665L);
      ((ObjectAnimator)localObject1).setInterpolator(CircleProgressDrawable.a.hof);
      ((ObjectAnimator)localObject1).setRepeatCount(-1);
      localArrayList.add(localObject1);
      this.hoy.start();
      return;
    }
    this.hoy.stop();
  }
  
  public final void setMainTitle(String paramString)
  {
    boolean bool = isLayoutRequested();
    this.hov.setText(paramString);
    if (bool) {
      requestLayout();
    }
  }
  
  public final void setNavBackOrClose(boolean paramBoolean)
  {
    aqY();
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    this.hoG = paramBoolean;
    ara();
  }
  
  public final void setOptionBtnStatus(com.tencent.mm.plugin.appbrand.page.a.a parama)
  {
    this.hoz.a(parama, this.hoD);
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hoz.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSubTitle(String paramString)
  {
    if (bk.bl(paramString)) {
      this.how.setVisibility(8);
    }
    for (;;)
    {
      this.how.clearAnimation();
      return;
      this.how.setVisibility(0);
      this.how.setText(paramString);
    }
  }
  
  public final void setTitleAreaOnDoubleClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hou.setOnClickListener(new a.4(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.a
 * JD-Core Version:    0.7.0.1
 */