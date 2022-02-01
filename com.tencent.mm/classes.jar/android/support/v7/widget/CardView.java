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
  private static final int[] alJ = { 16842801 };
  private static final r alK;
  private boolean alL;
  private boolean alM;
  int alN;
  int alO;
  final Rect alP = new Rect();
  final Rect alQ = new Rect();
  private final q alR = new q()
  {
    private Drawable alS;
    
    public final void R(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.alN) {
        CardView.a(CardView.this, paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.alO) {
        CardView.b(CardView.this, paramAnonymousInt2);
      }
    }
    
    public final void e(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.alQ.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView localCardView = CardView.this;
      CardView.a(localCardView, localCardView.alP.left + paramAnonymousInt1, CardView.this.alP.top + paramAnonymousInt2, CardView.this.alP.right + paramAnonymousInt3, CardView.this.alP.bottom + paramAnonymousInt4);
    }
    
    public final boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public final boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public final Drawable jy()
    {
      return this.alS;
    }
    
    public final View jz()
    {
      return CardView.this;
    }
    
    public final void q(Drawable paramAnonymousDrawable)
    {
      this.alS = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
  };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      alK = new o();
    }
    for (;;)
    {
      alK.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        alK = new n();
      } else {
        alK = new p();
      }
    }
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968747);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CardView, paramInt, 2131820809);
    if (localTypedArray.hasValue(2))
    {
      paramAttributeSet = localTypedArray.getColorStateList(2);
      float f4 = localTypedArray.getDimension(3, 0.0F);
      float f2 = localTypedArray.getDimension(4, 0.0F);
      float f3 = localTypedArray.getDimension(5, 0.0F);
      this.alL = localTypedArray.getBoolean(7, false);
      this.alM = localTypedArray.getBoolean(6, true);
      paramInt = localTypedArray.getDimensionPixelSize(8, 0);
      this.alP.left = localTypedArray.getDimensionPixelSize(10, paramInt);
      this.alP.top = localTypedArray.getDimensionPixelSize(12, paramInt);
      this.alP.right = localTypedArray.getDimensionPixelSize(11, paramInt);
      this.alP.bottom = localTypedArray.getDimensionPixelSize(9, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.alN = localTypedArray.getDimensionPixelSize(0, 0);
      this.alO = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      alK.a(this.alR, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(alJ);
    paramInt = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
    paramAttributeSet = new float[3];
    Color.colorToHSV(paramInt, paramAttributeSet);
    if (paramAttributeSet[2] > 0.5F) {}
    for (paramInt = getResources().getColor(2131100150);; paramInt = getResources().getColor(2131100149))
    {
      paramAttributeSet = ColorStateList.valueOf(paramInt);
      break;
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return alK.i(this.alR);
  }
  
  public float getCardElevation()
  {
    return alK.e(this.alR);
  }
  
  public int getContentPaddingBottom()
  {
    return this.alP.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.alP.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.alP.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.alP.top;
  }
  
  public float getMaxCardElevation()
  {
    return alK.a(this.alR);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.alM;
  }
  
  public float getRadius()
  {
    return alK.d(this.alR);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.alL;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(alK instanceof o))
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
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(alK.b(this.alR)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(alK.c(this.alR)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    alK.a(this.alR, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    alK.a(this.alR, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    alK.c(this.alR, paramFloat);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.alP.set(paramInt1, paramInt2, paramInt3, paramInt4);
    alK.f(this.alR);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    alK.b(this.alR, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.alO = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.alN = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.alM)
    {
      this.alM = paramBoolean;
      alK.h(this.alR);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    alK.a(this.alR, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.alL != paramBoolean)
    {
      this.alL = paramBoolean;
      alK.g(this.alR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */