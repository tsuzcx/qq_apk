package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.luggage.l.a.b;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.sdk.platformtools.y;

public class AppBrandOptionButton
  extends FrameLayout
{
  private int hoQ = a.c.app_brand_actionbar_option_light;
  private ObjectAnimator hoR;
  public boolean hoS = true;
  private View hoT;
  private View hoU;
  private TextView hoV;
  ImageButton hoW;
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private int getActionBarHeight()
  {
    return getResources().getDimensionPixelSize(a.b.DefaultActionbarHeight);
  }
  
  private void init(Context paramContext)
  {
    this.hoT = LayoutInflater.from(paramContext).inflate(a.e.app_brand_action_option_view, this, false);
    this.hoU = this.hoT.findViewById(a.d.divider);
    this.hoV = ((TextView)this.hoT.findViewById(a.d.action_option_button));
    this.hoV.setMaxLines(1);
    this.hoV.setClickable(false);
    this.hoV.setBackground(null);
    addView(this.hoT, new FrameLayout.LayoutParams(-2, -1, 17));
    this.hoT.setVisibility(8);
    this.hoW = new ImageButton(paramContext);
    this.hoW.setClickable(false);
    this.hoW.setBackground(null);
    addView(this.hoW, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    this.hoR = ObjectAnimator.ofFloat(this.hoW, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    this.hoR.setDuration(2000L);
    this.hoR.setInterpolator(new AccelerateInterpolator());
    this.hoR.setRepeatCount(-1);
    this.hoR.setRepeatMode(1);
  }
  
  protected final void a(a.a parama, int paramInt)
  {
    y.i("MicroMsg.AppBrandOptionButton", "setImageButtonStatus status %s", new Object[] { parama });
    switch (AppBrandOptionButton.3.gSb[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.hoS = true;
      this.hoT.setVisibility(8);
      this.hoW.setVisibility(0);
      this.hoW.setImageResource(getImageButtonResource());
      this.hoW.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      if (this.hoQ != a.c.app_brand_actionbar_option_dark) {
        break;
      }
      post(new AppBrandOptionButton.2(this));
      return;
      this.hoQ = a.c.app_brand_actionbar_capsule_lbs_dark;
      continue;
      this.hoQ = a.c.app_brand_actionbar_capsule_video_dark;
      continue;
      this.hoQ = a.c.app_brand_actionbar_capsule_voice_dark;
      continue;
      this.hoQ = a.c.app_brand_actionbar_option_dark;
    }
    post(new AppBrandOptionButton.1(this));
  }
  
  protected int getImageButtonResource()
  {
    return this.hoQ;
  }
  
  public final void reset()
  {
    this.hoS = true;
    this.hoT.setVisibility(8);
    this.hoW.setVisibility(0);
    this.hoW.setImageResource(getImageButtonResource());
  }
  
  public void setColor(int paramInt)
  {
    this.hoV.setTextColor(paramInt);
    this.hoW.setImageResource(getImageButtonResource());
    this.hoW.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.hoW.setBackground(getBackground());
    if (this.hoW.getBackground() != null) {
      this.hoW.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    this.hoS = false;
    this.hoW.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.hoW.setVisibility(0);
    this.hoT.setVisibility(8);
  }
  
  public void setText(String paramString)
  {
    this.hoS = false;
    this.hoV.setText(paramString);
    this.hoT.setVisibility(0);
    this.hoW.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */