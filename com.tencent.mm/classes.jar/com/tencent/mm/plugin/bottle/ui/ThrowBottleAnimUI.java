package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI
  extends FrameLayout
{
  int abU;
  int abV;
  private int gHR;
  private int gHS;
  BottleBeachUI hZZ;
  private SprayLayout iba;
  private BottleImageView ibb;
  private TextView ibc;
  private AnimationSet ibd;
  private int ibe;
  private int ibf;
  int ibg;
  private ThrowBottleAnimUI.a ibh;
  boolean ibi;
  private ah ibj = new ThrowBottleAnimUI.4(this);
  
  public ThrowBottleAnimUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hZZ = ((BottleBeachUI)paramContext);
    initView();
  }
  
  public ThrowBottleAnimUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.hZZ = ((BottleBeachUI)paramContext);
    initView();
  }
  
  private int getUIHeight()
  {
    int j = Math.abs(getHeight());
    int i = j;
    if (j <= 0) {
      i = this.gHS;
    }
    return i;
  }
  
  private int getUIWidth()
  {
    int j = Math.abs(getWidth());
    int i = j;
    if (j <= 0) {
      i = this.gHR;
    }
    return i;
  }
  
  private void initView()
  {
    inflate(this.hZZ, R.i.bottle_throw_anim, this);
    this.ibb = ((BottleImageView)findViewById(R.h.bottle_throw_bottle_iv));
    this.ibc = ((TextView)findViewById(R.h.bottle_throw_content_scale));
    DisplayMetrics localDisplayMetrics = this.hZZ.getResources().getDisplayMetrics();
    this.gHR = localDisplayMetrics.widthPixels;
    this.gHS = localDisplayMetrics.heightPixels;
  }
  
  final void axe()
  {
    this.ibb.setImageDrawable(null);
    int i = this.ibb.getBackground().getIntrinsicWidth();
    int j = this.ibb.getBackground().getIntrinsicHeight();
    this.ibb.setVisibility(0);
    int k = BackwardSupportUtil.b.b(this.hZZ, 40.0F);
    this.ibb.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, getUIWidth() - (i + k), getUIHeight() - (j + k)));
  }
  
  final void axf()
  {
    int j = this.ibb.getBackground().getIntrinsicWidth();
    int k = this.ibb.getBackground().getIntrinsicHeight();
    this.ibb.setVisibility(0);
    int m = BackwardSupportUtil.b.b(this.hZZ, 40.0F);
    Object localObject = this.hZZ;
    int i;
    if (bk.crU())
    {
      i = R.g.bottle_pick_bg_spotlight_day;
      setBackgroundDrawable(a.g((Context)localObject, i));
      if (!this.ibi) {
        break label277;
      }
      this.ibb.setImageDrawable(a.g(this.hZZ, R.g.bottle_type_voice));
    }
    for (;;)
    {
      this.ibb.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, 0, 0));
      localObject = this.ibb;
      i = getUIWidth();
      int n = this.ibe;
      int i1 = j / 2;
      int i2 = getUIHeight();
      int i3 = this.ibf;
      int i4 = k / 2;
      ThrowBottleAnimUI.3 local3 = new ThrowBottleAnimUI.3(this);
      ((BottleImageView)localObject).abU = (i - (j + m));
      ((BottleImageView)localObject).abW = (n - i1);
      ((BottleImageView)localObject).abV = (i2 - (m + k));
      ((BottleImageView)localObject).abX = (i3 - i4);
      ((BottleImageView)localObject).hZy.setAnimationListener(local3);
      ((BottleImageView)localObject).hZy.setDuration(2000L);
      ((BottleImageView)localObject).hZy.setRepeatCount(0);
      ((BottleImageView)localObject).hZy.setStartOffset(500L);
      ((BottleImageView)localObject).hZy.setInterpolator(((BottleImageView)localObject).context, 17432582);
      ((BottleImageView)localObject).startAnimation(((BottleImageView)localObject).hZy);
      return;
      i = R.g.bottle_pick_bg_spotlight_night;
      break;
      label277:
      this.ibb.setImageDrawable(a.g(this.hZZ, R.g.bottle_type_text));
    }
  }
  
  final void axg()
  {
    this.ibe = (getUIWidth() / 2);
    this.ibf = (getUIHeight() * 460 / 800);
    y.v("MicroMsg.ThrowBottleAnimView", "to (" + this.ibe + "," + this.ibf + ")  bottle (" + this.ibb.getDrawable().getIntrinsicWidth() + "," + this.ibb.getDrawable().getIntrinsicHeight() + ")");
  }
  
  public boolean isInEditMode()
  {
    return false;
  }
  
  public final void release()
  {
    this.hZZ = null;
    this.ibd = null;
    this.iba = null;
    if (this.ibb != null)
    {
      BottleImageView localBottleImageView = this.ibb;
      localBottleImageView.context = null;
      localBottleImageView.hZy = null;
    }
    this.ibb = null;
    this.ibh = null;
  }
  
  public void setOnThrowEndListener(ThrowBottleAnimUI.a parama)
  {
    this.ibh = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI
 * JD-Core Version:    0.7.0.1
 */