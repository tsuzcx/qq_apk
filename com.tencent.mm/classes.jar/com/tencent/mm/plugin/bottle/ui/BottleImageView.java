package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;

public class BottleImageView
  extends ImageView
{
  int abU;
  int abV;
  int abW;
  int abX;
  Context context;
  private int hZw;
  private int hZx;
  Animation hZy = new BottleImageView.1(this);
  
  public BottleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    awS();
  }
  
  public BottleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    awS();
  }
  
  private void awS()
  {
    Drawable localDrawable = getBackground();
    if (localDrawable != null)
    {
      this.hZw = localDrawable.getIntrinsicWidth();
      this.hZx = localDrawable.getIntrinsicHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleImageView
 * JD-Core Version:    0.7.0.1
 */