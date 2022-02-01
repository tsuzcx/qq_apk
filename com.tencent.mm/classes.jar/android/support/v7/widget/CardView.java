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
  private static final int[] aiL = { 16842801 };
  private static final r aiM;
  private boolean aiN;
  private boolean aiO;
  int aiP;
  int aiQ;
  final Rect aiR = new Rect();
  final Rect aiS = new Rect();
  private final q aiT = new q()
  {
    private Drawable aiU;
    
    public final void Q(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.aiP) {
        CardView.a(CardView.this, paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.aiQ) {
        CardView.b(CardView.this, paramAnonymousInt2);
      }
    }
    
    public final void e(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.aiS.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView localCardView = CardView.this;
      CardView.a(localCardView, localCardView.aiR.left + paramAnonymousInt1, CardView.this.aiR.top + paramAnonymousInt2, CardView.this.aiR.right + paramAnonymousInt3, CardView.this.aiR.bottom + paramAnonymousInt4);
    }
    
    public final boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public final boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public final Drawable iR()
    {
      return this.aiU;
    }
    
    public final View iS()
    {
      return CardView.this;
    }
    
    public final void q(Drawable paramAnonymousDrawable)
    {
      this.aiU = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
  };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      aiM = new o();
    }
    for (;;)
    {
      aiM.initStatic();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        aiM = new n();
      } else {
        aiM = new p();
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
      this.aiN = localTypedArray.getBoolean(7, false);
      this.aiO = localTypedArray.getBoolean(6, true);
      paramInt = localTypedArray.getDimensionPixelSize(8, 0);
      this.aiR.left = localTypedArray.getDimensionPixelSize(10, paramInt);
      this.aiR.top = localTypedArray.getDimensionPixelSize(12, paramInt);
      this.aiR.right = localTypedArray.getDimensionPixelSize(11, paramInt);
      this.aiR.bottom = localTypedArray.getDimensionPixelSize(9, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.aiP = localTypedArray.getDimensionPixelSize(0, 0);
      this.aiQ = localTypedArray.getDimensionPixelSize(1, 0);
      localTypedArray.recycle();
      aiM.a(this.aiT, paramContext, paramAttributeSet, f4, f2, f1);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(aiL);
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
    return aiM.i(this.aiT);
  }
  
  public float getCardElevation()
  {
    return aiM.e(this.aiT);
  }
  
  public int getContentPaddingBottom()
  {
    return this.aiR.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.aiR.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.aiR.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.aiR.top;
  }
  
  public float getMaxCardElevation()
  {
    return aiM.a(this.aiT);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.aiO;
  }
  
  public float getRadius()
  {
    return aiM.d(this.aiT);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.aiN;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(aiM instanceof o))
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
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(aiM.b(this.aiT)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(aiM.c(this.aiT)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    aiM.a(this.aiT, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    aiM.a(this.aiT, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    aiM.c(this.aiT, paramFloat);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aiR.set(paramInt1, paramInt2, paramInt3, paramInt4);
    aiM.f(this.aiT);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    aiM.b(this.aiT, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.aiQ = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.aiP = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.aiO)
    {
      this.aiO = paramBoolean;
      aiM.h(this.aiT);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    aiM.a(this.aiT, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.aiN != paramBoolean)
    {
      this.aiN = paramBoolean;
      aiM.g(this.aiT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.CardView
 * JD-Core Version:    0.7.0.1
 */