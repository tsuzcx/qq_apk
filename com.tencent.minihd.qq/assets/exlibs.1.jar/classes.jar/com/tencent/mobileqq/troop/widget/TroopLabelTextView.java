package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TroopLabelTextView
  extends TextView
{
  protected static final int a = 2;
  protected static final int c = 12;
  protected static final int d = 12;
  protected static final int e = 1;
  protected static final int f = 1;
  protected static final int g = 4;
  protected int b;
  
  public TroopLabelTextView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.b = paramInt1;
    setMaxLines(1);
    setTextSize(12.0F);
    setTextColor(paramInt2);
    setGravity(1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.rightMargin = 4;
    setLayoutParams(paramContext);
    setPadding(12, 1, 12, 1);
  }
  
  public float a()
  {
    return 28.0F;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3 + (getPaddingLeft() + getPaddingRight()), paramInt4);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(2, this.b);
    localGradientDrawable.setCornerRadius(getHeight() / 2);
    setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelTextView
 * JD-Core Version:    0.7.0.1
 */