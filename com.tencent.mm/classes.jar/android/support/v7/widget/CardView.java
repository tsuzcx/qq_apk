package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.support.v7.b.a.b;
import android.support.v7.b.a.d;
import android.support.v7.b.a.e;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] aaU = { 16842801 };
  private static final t aaV;
  private boolean aaW;
  int aaX;
  int aaY;
  final Rect aaZ = new Rect();
  final Rect aba = new Rect();
  private final s abb = new CardView.1(this);
  private boolean is;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      aaV = new q();
    }
    for (;;)
    {
      aaV.gw();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        aaV = new p();
      } else {
        aaV = new r();
      }
    }
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.cardViewStyle);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.e.CardView, paramInt, a.d.CardView);
    if (localTypedArray.hasValue(a.e.CardView_cardBackgroundColor))
    {
      paramAttributeSet = localTypedArray.getColorStateList(a.e.CardView_cardBackgroundColor);
      float f4 = localTypedArray.getDimension(a.e.CardView_cardCornerRadius, 0.0F);
      float f2 = localTypedArray.getDimension(a.e.CardView_cardElevation, 0.0F);
      float f3 = localTypedArray.getDimension(a.e.CardView_cardMaxElevation, 0.0F);
      this.is = localTypedArray.getBoolean(a.e.CardView_cardUseCompatPadding, false);
      this.aaW = localTypedArray.getBoolean(a.e.CardView_cardPreventCornerOverlap, true);
      paramInt = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPadding, 0);
      this.aaZ.left = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingLeft, paramInt);
      this.aaZ.top = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingTop, paramInt);
      this.aaZ.right = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingRight, paramInt);
      this.aaZ.bottom = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingBottom, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.aaX = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minWidth, 0);
      this.aaY = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minHeight, 0);
      localTypedArray.recycle();
      aaV.a(this.abb, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(aaU);
    paramInt = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = new float[3];
    Color.colorToHSV(paramInt, paramAttributeSet);
    if (paramAttributeSet[2] > 0.5F) {}
    for (paramInt = getResources().getColor(a.b.cardview_light_background);; paramInt = getResources().getColor(a.b.cardview_dark_background))
    {
      paramAttributeSet = ColorStateList.valueOf(paramInt);
      break;
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return aaV.h(this.abb);
  }
  
  public float getCardElevation()
  {
    return aaV.e(this.abb);
  }
  
  public int getContentPaddingBottom()
  {
    return this.aaZ.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.aaZ.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.aaZ.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.aaZ.top;
  }
  
  public float getMaxCardElevation()
  {
    return aaV.a(this.abb);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.aaW;
  }
  
  public float getRadius()
  {
    return aaV.d(this.abb);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.is;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(aaV instanceof q))
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      switch (i)
      {
      default: 
        i = View.MeasureSpec.getMode(paramInt2);
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(aaV.b(this.abb)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(aaV.c(this.abb)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    aaV.a(this.abb, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    aaV.a(this.abb, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    aaV.c(this.abb, paramFloat);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    aaV.b(this.abb, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.aaY = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.aaX = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.aaW)
    {
      this.aaW = paramBoolean;
      aaV.g(this.abb);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    aaV.a(this.abb, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.is != paramBoolean)
    {
      this.is = paramBoolean;
      aaV.f(this.abb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */