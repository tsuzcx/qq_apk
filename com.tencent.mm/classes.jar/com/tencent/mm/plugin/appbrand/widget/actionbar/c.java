package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.annotation.SuppressLint;
import android.support.v4.view.q;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.l.a.c;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.c.a;

@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements d, c.a
{
  private AppBrandCapsuleHomeButton hoA;
  private LinearLayout hoB;
  private ImageView hoC;
  private int hoD;
  private int hoE;
  private double hoF;
  private boolean hoI;
  private b hoJ;
  private AppBrandCapsuleOptionButton hoO;
  
  private void aqX()
  {
    if (!q.al(this))
    {
      post(new c.1(this));
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
      setPadding(0, Math.max(a.ae(l.cx(getContext())), 0), 0, 0);
    }
  }
  
  private void aqY()
  {
    if (this.hoD == -1)
    {
      this.hoO.setColor(-1);
      this.hoA.setColor(-1);
    }
    while (this.hoD == -1)
    {
      this.hoC.setImageResource(com.tencent.luggage.l.a.a.app_brand_capsule_divider_dark);
      this.hoB.setBackgroundResource(a.c.app_brand_game_capsule_dark_background);
      return;
      this.hoO.setColor(-16777216);
      this.hoA.setColor(-16777216);
    }
    this.hoC.setImageResource(com.tencent.luggage.l.a.a.app_brand_capsule_divider_light);
    this.hoB.setBackgroundResource(a.c.app_brand_game_capsule_light_background);
  }
  
  public final void arb()
  {
    this.hoI = true;
    aqX();
  }
  
  public final void dO(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.hoB.setVisibility(0);
      if (!paramBoolean) {
        break label49;
      }
      this.hoO.setVisibility(0);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label61;
      }
      this.hoA.setVisibility(0);
      return;
      this.hoB.setVisibility(8);
      break;
      label49:
      this.hoO.setVisibility(8);
    }
    label61:
    this.hoA.setVisibility(8);
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
    return null;
  }
  
  public final void ml(int paramInt)
  {
    aqX();
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.ui.statusbar.c.af(l.cx(getContext())).a(this);
    aqX();
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hoJ.a(paramOnClickListener);
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt) {}
  
  public final void setBackgroundColor(String paramString) {}
  
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
  
  public final void setLoadingIconVisibility(boolean paramBoolean) {}
  
  public final void setMainTitle(String paramString) {}
  
  public final void setNavBackOrClose(boolean paramBoolean) {}
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionBtnStatus(com.tencent.mm.plugin.appbrand.page.a.a parama)
  {
    this.hoO.a(parama, this.hoD);
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hoO.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSubTitle(String paramString) {}
  
  public final void setTitleAreaOnDoubleClickListener(View.OnClickListener paramOnClickListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.c
 * JD-Core Version:    0.7.0.1
 */