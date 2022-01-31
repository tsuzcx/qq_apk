package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;

public class PickBottleUI
  extends FrameLayout
  implements View.OnClickListener, View.OnTouchListener
{
  private float density;
  float fSy;
  float fSz;
  BottleBeachUI hZZ;
  ah handler = new ah();
  private boolean hasInit = false;
  SprayLayout iau;
  PickedBottleImageView iav;
  ImageView iaw;
  private h.b iax;
  Runnable iay = new PickBottleUI.1(this);
  Runnable iaz = new PickBottleUI.2(this);
  
  public PickBottleUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hZZ = ((BottleBeachUI)paramContext);
  }
  
  public PickBottleUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.hZZ = ((BottleBeachUI)paramContext);
  }
  
  private boolean M(float paramFloat1, float paramFloat2)
  {
    int k = getHeight();
    int m = getWidth();
    int i = m * 180 / 480;
    int j = k * 75 / 800;
    m = m * 240 / 480;
    k = k * 495 / 800;
    paramFloat1 -= m;
    paramFloat2 -= k;
    paramFloat1 = paramFloat1 * paramFloat1 / (i * i);
    return paramFloat2 * paramFloat2 / (j * j) + paramFloat1 <= 1.0F;
  }
  
  public final void initView()
  {
    if (!this.hasInit)
    {
      this.iav = ((PickedBottleImageView)findViewById(R.h.bottle_picked_result_img));
      this.iau = ((SprayLayout)this.hZZ.findViewById(R.h.bottle_spray_fl));
      this.iaw = ((ImageView)this.hZZ.findViewById(R.h.bottle_close_frame_btn));
      this.iav.setOnClickListener(this);
      if (!bk.crU()) {
        setBackgroundResource(R.g.bottle_pick_bg_spotlight_night);
      }
      setOnClickListener(this);
      setOnTouchListener(this);
      this.hasInit = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (R.h.bottle_picked_result_img == paramView.getId())
    {
      if (this.iav.getBottleTalker() != null)
      {
        au.Hx();
        c.FB().abx(this.iav.getBottleTalker());
        au.Hx();
        ak localak = c.FB().abv("floatbottle");
        if ((localak != null) && (!bk.bl(localak.field_username)))
        {
          localak.fy(k.Gf());
          au.Hx();
          c.FB().a(localak, localak.field_username);
        }
      }
      this.hZZ.onClick(paramView);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    initView();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.fSy = paramMotionEvent.getX();
      this.fSz = paramMotionEvent.getY();
    }
    float f1;
    float f2;
    label275:
    do
    {
      do
      {
        do
        {
          return true;
        } while (i != 1);
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        int j = getHeight();
        i = getWidth();
        j = j * 550 / 800;
        int k = (i - i * 120 / 480) / 2;
        if (f2 > j) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label275;
          }
          if (this.iav.isShown()) {
            break;
          }
          if (this.iax != null)
          {
            paramView = this.iax;
            au.Dk().b(155, paramView);
            au.Dk().b(156, paramView);
            au.Dk().c(paramView.hYs);
            this.iax = null;
          }
          this.handler.removeCallbacks(this.iay);
          this.handler.removeCallbacks(this.iaz);
          this.hZZ.ol(0);
          return true;
          if (f1 < k - k * f2 / j)
          {
            i = 1;
          }
          else
          {
            float f3 = i - k;
            if (f1 > k * f2 / j + f3) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
      } while (this.iav.getBottleTalker() != null);
      this.hZZ.ol(0);
      return true;
    } while ((!M(f1, f2)) || (!M(this.fSy, this.fSz)));
    if (this.iav.getBottleTalker() != null)
    {
      au.Hx();
      c.FB().abx(this.iav.getBottleTalker());
      au.Hx();
      paramView = c.FB().abv("floatbottle");
      if ((paramView != null) && (!bk.bl(paramView.field_username)))
      {
        paramView.fy(k.Gf());
        au.Hx();
        c.FB().a(paramView, paramView.field_username);
      }
    }
    this.hZZ.onClick(this.iav);
    return true;
  }
  
  public void setDensity(float paramFloat)
  {
    this.density = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    this.iau.setVisibility(paramInt);
    this.iav.setVisibility(8);
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.PickBottleUI
 * JD-Core Version:    0.7.0.1
 */