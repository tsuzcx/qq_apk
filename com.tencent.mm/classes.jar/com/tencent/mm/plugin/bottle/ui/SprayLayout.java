package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.ah;

public class SprayLayout
  extends FrameLayout
{
  private ah handler;
  private ImageView iaH;
  private ImageView iaI;
  private ImageView iaJ;
  Animation iaK = new ScaleAnimation(0.6F, 0.8F, 0.6F, 0.8F, 1, 0.5F, 1, 1.0F);
  Animation iaL = new AlphaAnimation(0.2F, 1.0F);
  Animation iaM = new ScaleAnimation(0.8F, 1.27F, 0.8F, 1.27F, 1, 0.5F, 1, 1.0F);
  Animation iaN = new AlphaAnimation(1.0F, 0.5F);
  Animation iaO = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 1.0F);
  AnimationSet iaP = new AnimationSet(true);
  AnimationSet iaQ = new AnimationSet(true);
  AnimationSet iaR = new AnimationSet(true);
  private int iaS;
  private int iaT;
  private int iaU;
  private int iaV;
  private int iaW;
  private int iaX;
  private Runnable iaY;
  private int repeatCount;
  
  public SprayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SprayLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.iaK.setDuration(280L);
    this.iaL.setDuration(280L);
    this.iaM.setDuration(280L);
    this.iaN.setDuration(280L);
    this.iaP.addAnimation(this.iaK);
    this.iaP.addAnimation(this.iaL);
    this.iaP.setRepeatCount(1);
    this.iaP.setDuration(280L);
    this.iaQ.addAnimation(this.iaM);
    this.iaQ.setRepeatCount(1);
    this.iaQ.setDuration(280L);
    this.iaR.addAnimation(this.iaO);
    this.iaR.setRepeatCount(1);
    this.iaR.setDuration(280L);
    this.iaS = 0;
    this.repeatCount = 1;
    this.iaU = -1;
    this.iaV = -1;
    this.handler = new ah();
    this.iaY = new SprayLayout.1(this);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3)
  {
    this.iaS = 0;
    this.repeatCount = paramInt1;
    this.iaT = 0;
    this.iaU = paramInt2;
    this.iaV = paramInt3;
    if (this.iaH == null)
    {
      this.iaH = ((ImageView)findViewById(R.h.bottle_spray_one_iv));
      this.iaI = ((ImageView)findViewById(R.h.bottle_spray_two_iv));
      this.iaJ = ((ImageView)findViewById(R.h.bottle_spray_three_iv));
      DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
      this.iaW = (localDisplayMetrics.widthPixels * 35 / 96);
      this.iaX = (localDisplayMetrics.heightPixels / 16);
    }
    this.iaH.setVisibility(8);
    this.iaI.setVisibility(8);
    this.iaJ.setVisibility(8);
    setVisibility(0);
    this.handler.removeCallbacks(this.iaY);
    this.handler.postDelayed(this.iaY, 0L);
  }
  
  public final void stop()
  {
    this.handler.removeCallbacks(this.iaY);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.SprayLayout
 * JD-Core Version:    0.7.0.1
 */