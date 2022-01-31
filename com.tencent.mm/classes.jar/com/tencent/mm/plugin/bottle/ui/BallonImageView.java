package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView
  extends ImageView
{
  private Animation hYw = new BallonImageView.1(this);
  
  public BallonImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hYw.setRepeatCount(-1);
    this.hYw.setDuration(15000L);
    this.hYw.setFillAfter(true);
  }
  
  public BallonImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.hYw.setRepeatCount(-1);
    this.hYw.setDuration(15000L);
    this.hYw.setFillAfter(true);
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {
      setAnimation(this.hYw);
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      BackwardSupportUtil.a.a(this, this.hYw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BallonImageView
 * JD-Core Version:    0.7.0.1
 */