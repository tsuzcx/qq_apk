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
  private static final int[] ajF = { 16842801 };
  private static final r ajG;
  private boolean ajH;
  private boolean ajI;
  int ajJ;
  int ajK;
  final Rect ajL = new Rect();
  final Rect ajM = new Rect();
  private final q ajN = new q()
  {
    private Drawable ajO;
    
    public final void Q(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.ajJ) {
        CardView.a(CardView.this, paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.ajK) {
        CardView.b(CardView.this, paramAnonymousInt2);
      }
    }
    
    public final void e(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.ajM.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView localCardView = CardView.this;
      CardView.a(localCardView, localCardView.ajL.left + paramAnonymousInt1, CardView.this.ajL.top + paramAnonymousInt2, CardView.this.ajL.right + paramAnonymousInt3, CardView.this.ajL.bottom + paramAnonymousInt4);
    }
    
    public final boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public final boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public final Drawable iZ()
    {
      return this.ajO;
    }
    
    public final View ja()
    {
      return CardView.this;
    }
    
    public final void q(Drawable paramAnonymousDrawable)
    {
      this.ajO = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
  };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ajG = new o();
    }
    for (;;)
    {
      ajG.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        ajG = new n();
      } else {
        ajG = new p();
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
      this.ajH = localTypedArray.getBoolean(7, false);
      this.ajI = localTypedArray.getBoolean(6, true);
      paramInt = localTypedArray.getDimensionPixelSize(8, 0);
      this.ajL.left = localTypedArray.getDimensionPixelSize(10, paramInt);
      this.ajL.top = localTypedArray.getDimensionPixelSize(12, paramInt);
      this.ajL.right = localTypedArray.getDimensionPixelSize(11, paramInt);
      this.ajL.bottom = localTypedArray.getDimensionPixelSize(9, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.ajJ = localTypedArray.getDimensionPixelSize(0, 0);
      this.ajK = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      ajG.a(this.ajN, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(ajF);
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
    return ajG.i(this.ajN);
  }
  
  public float getCardElevation()
  {
    return ajG.e(this.ajN);
  }
  
  public int getContentPaddingBottom()
  {
    return this.ajL.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.ajL.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.ajL.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.ajL.top;
  }
  
  public float getMaxCardElevation()
  {
    return ajG.a(this.ajN);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.ajI;
  }
  
  public float getRadius()
  {
    return ajG.d(this.ajN);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.ajH;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(ajG instanceof o))
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
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(ajG.b(this.ajN)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(ajG.c(this.ajN)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    ajG.a(this.ajN, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    ajG.a(this.ajN, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    ajG.c(this.ajN, paramFloat);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ajL.set(paramInt1, paramInt2, paramInt3, paramInt4);
    ajG.f(this.ajN);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    ajG.b(this.ajN, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.ajK = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.ajJ = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.ajI)
    {
      this.ajI = paramBoolean;
      ajG.h(this.ajN);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    ajG.a(this.ajN, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.ajH != paramBoolean)
    {
      this.ajH = paramBoolean;
      ajG.g(this.ajN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */