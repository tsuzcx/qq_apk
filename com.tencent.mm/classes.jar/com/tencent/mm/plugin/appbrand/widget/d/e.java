package com.tencent.mm.plugin.appbrand.widget.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class e
  extends FrameLayout
{
  public static final int hzA = Color.parseColor("#000000");
  public static final int hzp = Color.parseColor("#000000");
  public static final int hzq = Color.parseColor("#000000");
  private float aWt = 0.0F;
  private float aWu = 0.0F;
  private int hzB;
  private int hzC;
  private int hzD;
  private int hzE;
  private TextView hzz;
  public int x = 0;
  public int y = 0;
  
  public e(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.hzz = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.hzz.setLayoutParams(paramContext);
    addView(this.hzz);
  }
  
  public final float getAnchorX()
  {
    return this.aWt;
  }
  
  public final float getAnchorY()
  {
    return this.aWu;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getChildAt(0).getLayoutParams();
    if ((this.x >= 0) && (this.y >= 0)) {
      localLayoutParams.gravity = 85;
    }
    for (;;)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      if ((this.x >= 0) && (this.y <= 0)) {
        localLayoutParams.gravity = 53;
      } else if ((this.x <= 0) && (this.y >= 0)) {
        localLayoutParams.gravity = 83;
      } else if ((this.x <= 0) && (this.y <= 0)) {
        localLayoutParams.gravity = 51;
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.hzB = getMeasuredWidth();
    this.hzC = getMeasuredHeight();
    if ((-this.hzB < this.x) && (this.x < 0))
    {
      this.hzD = this.hzB;
      this.aWt = (Math.abs(this.x) / (this.hzB * 1.0F));
      if ((-this.hzC >= this.y) || (this.y >= 0)) {
        break label179;
      }
      this.hzE = this.hzC;
      this.aWu = (Math.abs(this.y) / (this.hzC * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.hzD, this.hzE);
      return;
      if (this.x >= 0)
      {
        this.hzD = (this.hzB + Math.abs(this.x));
        this.aWt = 0.0F;
        break;
      }
      this.hzD = Math.abs(this.x);
      this.aWt = 1.0F;
      break;
      label179:
      if (this.y >= 0)
      {
        this.hzE = (this.hzC + Math.abs(this.y));
        this.aWu = 0.0F;
      }
      else
      {
        this.hzE = Math.abs(this.y);
        this.aWu = 1.0F;
      }
    }
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setColor(paramInt4);
    this.hzz.setBackgroundDrawable(localGradientDrawable);
  }
  
  public final void setGravity(String paramString)
  {
    if (paramString.equals("left"))
    {
      this.hzz.setGravity(3);
      return;
    }
    if (paramString.equals("right"))
    {
      this.hzz.setGravity(5);
      return;
    }
    paramString.equals("center");
    this.hzz.setGravity(17);
  }
  
  public final void setText(String paramString)
  {
    this.hzz.setText(paramString);
  }
  
  public final void setTextColor(int paramInt)
  {
    this.hzz.setTextColor(paramInt);
  }
  
  public final void setTextPadding(int paramInt)
  {
    this.hzz.setPadding(paramInt, paramInt, paramInt, paramInt);
  }
  
  public final void setTextSize(int paramInt)
  {
    this.hzz.setTextSize(paramInt);
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.e
 * JD-Core Version:    0.7.0.1
 */