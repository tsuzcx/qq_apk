package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] abF = { 16842801 };
  private static final r abG;
  private boolean abH;
  int abI;
  int abJ;
  final Rect abK = new Rect();
  final Rect abL = new Rect();
  private final q abM = new CardView.1(this);
  private boolean jm;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      abG = new o();
    }
    for (;;)
    {
      abG.hw();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        abG = new n();
      } else {
        abG = new p();
      }
    }
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771975);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CardView, paramInt, 2131493014);
    if (localTypedArray.hasValue(2))
    {
      paramAttributeSet = localTypedArray.getColorStateList(2);
      float f4 = localTypedArray.getDimension(3, 0.0F);
      float f2 = localTypedArray.getDimension(4, 0.0F);
      float f3 = localTypedArray.getDimension(5, 0.0F);
      this.jm = localTypedArray.getBoolean(6, false);
      this.abH = localTypedArray.getBoolean(7, true);
      paramInt = localTypedArray.getDimensionPixelSize(8, 0);
      this.abK.left = localTypedArray.getDimensionPixelSize(9, paramInt);
      this.abK.top = localTypedArray.getDimensionPixelSize(11, paramInt);
      this.abK.right = localTypedArray.getDimensionPixelSize(10, paramInt);
      this.abK.bottom = localTypedArray.getDimensionPixelSize(12, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.abI = localTypedArray.getDimensionPixelSize(0, 0);
      this.abJ = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      abG.a(this.abM, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(abF);
    paramInt = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = new float[3];
    Color.colorToHSV(paramInt, paramAttributeSet);
    if (paramAttributeSet[2] > 0.5F) {}
    for (paramInt = getResources().getColor(2131689858);; paramInt = getResources().getColor(2131689857))
    {
      paramAttributeSet = ColorStateList.valueOf(paramInt);
      break;
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return abG.i(this.abM);
  }
  
  public float getCardElevation()
  {
    return abG.e(this.abM);
  }
  
  public int getContentPaddingBottom()
  {
    return this.abK.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.abK.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.abK.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.abK.top;
  }
  
  public float getMaxCardElevation()
  {
    return abG.a(this.abM);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.abH;
  }
  
  public float getRadius()
  {
    return abG.d(this.abM);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.jm;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(abG instanceof o))
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
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(abG.b(this.abM)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(abG.c(this.abM)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    abG.a(this.abM, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    abG.a(this.abM, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    abG.c(this.abM, paramFloat);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    abG.b(this.abM, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.abJ = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.abI = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.abH)
    {
      this.abH = paramBoolean;
      abG.h(this.abM);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    abG.a(this.abM, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.jm != paramBoolean)
    {
      this.jm = paramBoolean;
      abG.g(this.abM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */