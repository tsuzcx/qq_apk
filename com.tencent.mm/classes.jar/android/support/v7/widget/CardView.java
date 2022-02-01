package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] alw = { 16842801 };
  private static final r alx;
  int alA;
  int alB;
  final Rect alC = new Rect();
  final Rect alD = new Rect();
  private final q alE = new q()
  {
    private Drawable alF;
    
    public final void R(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.alA) {
        CardView.a(CardView.this, paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.alB) {
        CardView.b(CardView.this, paramAnonymousInt2);
      }
    }
    
    public final void e(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.alD.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView localCardView = CardView.this;
      CardView.a(localCardView, localCardView.alC.left + paramAnonymousInt1, CardView.this.alC.top + paramAnonymousInt2, CardView.this.alC.right + paramAnonymousInt3, CardView.this.alC.bottom + paramAnonymousInt4);
    }
    
    public final boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public final boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public final Drawable jp()
    {
      return this.alF;
    }
    
    public final View jq()
    {
      return CardView.this;
    }
    
    public final void q(Drawable paramAnonymousDrawable)
    {
      this.alF = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
  };
  private boolean aly;
  private boolean alz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      alx = new o();
    }
    for (;;)
    {
      alx.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        alx = new n();
      } else {
        alx = new p();
      }
    }
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968733);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CardView, paramInt, 2131820805);
    if (localTypedArray.hasValue(2))
    {
      paramAttributeSet = localTypedArray.getColorStateList(2);
      float f4 = localTypedArray.getDimension(3, 0.0F);
      float f2 = localTypedArray.getDimension(4, 0.0F);
      float f3 = localTypedArray.getDimension(5, 0.0F);
      this.aly = localTypedArray.getBoolean(7, false);
      this.alz = localTypedArray.getBoolean(6, true);
      paramInt = localTypedArray.getDimensionPixelSize(8, 0);
      this.alC.left = localTypedArray.getDimensionPixelSize(10, paramInt);
      this.alC.top = localTypedArray.getDimensionPixelSize(12, paramInt);
      this.alC.right = localTypedArray.getDimensionPixelSize(11, paramInt);
      this.alC.bottom = localTypedArray.getDimensionPixelSize(9, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.alA = localTypedArray.getDimensionPixelSize(0, 0);
      this.alB = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      alx.a(this.alE, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(alw);
    paramInt = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = new float[3];
    Color.colorToHSV(paramInt, paramAttributeSet);
    if (paramAttributeSet[2] > 0.5F) {}
    for (paramInt = getResources().getColor(2131100119);; paramInt = getResources().getColor(2131100118))
    {
      paramAttributeSet = ColorStateList.valueOf(paramInt);
      break;
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return alx.i(this.alE);
  }
  
  public float getCardElevation()
  {
    return alx.e(this.alE);
  }
  
  public int getContentPaddingBottom()
  {
    return this.alC.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.alC.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.alC.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.alC.top;
  }
  
  public float getMaxCardElevation()
  {
    return alx.a(this.alE);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.alz;
  }
  
  public float getRadius()
  {
    return alx.d(this.alE);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.aly;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(alx instanceof o))
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
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(alx.b(this.alE)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(alx.c(this.alE)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    alx.a(this.alE, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    alx.a(this.alE, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    alx.c(this.alE, paramFloat);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.alC.set(paramInt1, paramInt2, paramInt3, paramInt4);
    alx.f(this.alE);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    alx.b(this.alE, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.alB = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.alA = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.alz)
    {
      this.alz = paramBoolean;
      alx.h(this.alE);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    alx.a(this.alE, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.aly != paramBoolean)
    {
      this.aly = paramBoolean;
      alx.g(this.alE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */