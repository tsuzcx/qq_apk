package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.cardview.a.a;
import androidx.cardview.a.b;
import androidx.cardview.a.d;
import androidx.cardview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardView
  extends FrameLayout
{
  private static final int[] QU;
  private static final e QV;
  private boolean QW;
  private boolean QX;
  int QY;
  int QZ;
  final Rect Ra;
  final Rect Rb;
  private final d Rc;
  
  static
  {
    AppMethodBeat.i(192451);
    QU = new int[] { 16842801 };
    if (Build.VERSION.SDK_INT >= 21) {
      QV = new b();
    }
    for (;;)
    {
      QV.initStatic();
      AppMethodBeat.o(192451);
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        QV = new a();
      } else {
        QV = new c();
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
    AppMethodBeat.i(192413);
    this.Ra = new Rect();
    this.Rb = new Rect();
    this.Rc = new d()
    {
      private Drawable Rd;
      
      public final void A(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(192446);
        if (paramAnonymousInt1 > CardView.this.QY) {
          CardView.a(CardView.this, paramAnonymousInt1);
        }
        if (paramAnonymousInt2 > CardView.this.QZ) {
          CardView.b(CardView.this, paramAnonymousInt2);
        }
        AppMethodBeat.o(192446);
      }
      
      public final void e(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(192438);
        CardView.this.Rb.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        CardView localCardView = CardView.this;
        CardView.a(localCardView, localCardView.Ra.left + paramAnonymousInt1, CardView.this.Ra.top + paramAnonymousInt2, CardView.this.Ra.right + paramAnonymousInt3, CardView.this.Ra.bottom + paramAnonymousInt4);
        AppMethodBeat.o(192438);
      }
      
      public final boolean getPreventCornerOverlap()
      {
        AppMethodBeat.i(192428);
        boolean bool = CardView.this.getPreventCornerOverlap();
        AppMethodBeat.o(192428);
        return bool;
      }
      
      public final boolean getUseCompatPadding()
      {
        AppMethodBeat.i(192419);
        boolean bool = CardView.this.getUseCompatPadding();
        AppMethodBeat.o(192419);
        return bool;
      }
      
      public final void k(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(192412);
        this.Rd = paramAnonymousDrawable;
        CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
        AppMethodBeat.o(192412);
      }
      
      public final Drawable le()
      {
        return this.Rd;
      }
      
      public final View lf()
      {
        return CardView.this;
      }
    };
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.e.CardView, paramInt, a.d.CardView);
    if (localTypedArray.hasValue(a.e.CardView_cardBackgroundColor))
    {
      paramAttributeSet = localTypedArray.getColorStateList(a.e.CardView_cardBackgroundColor);
      float f4 = localTypedArray.getDimension(a.e.CardView_cardCornerRadius, 0.0F);
      float f2 = localTypedArray.getDimension(a.e.CardView_cardElevation, 0.0F);
      float f3 = localTypedArray.getDimension(a.e.CardView_cardMaxElevation, 0.0F);
      this.QW = localTypedArray.getBoolean(a.e.CardView_cardUseCompatPadding, false);
      this.QX = localTypedArray.getBoolean(a.e.CardView_cardPreventCornerOverlap, true);
      paramInt = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPadding, 0);
      this.Ra.left = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingLeft, paramInt);
      this.Ra.top = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingTop, paramInt);
      this.Ra.right = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingRight, paramInt);
      this.Ra.bottom = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingBottom, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.QY = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minWidth, 0);
      this.QZ = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minHeight, 0);
      localTypedArray.recycle();
      QV.a(this.Rc, paramContext, paramAttributeSet, f4, f2, f1);
      AppMethodBeat.o(192413);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(QU);
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
    AppMethodBeat.i(192580);
    ColorStateList localColorStateList = QV.i(this.Rc);
    AppMethodBeat.o(192580);
    return localColorStateList;
  }
  
  public float getCardElevation()
  {
    AppMethodBeat.i(192652);
    float f = QV.e(this.Rc);
    AppMethodBeat.o(192652);
    return f;
  }
  
  public int getContentPaddingBottom()
  {
    return this.Ra.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.Ra.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.Ra.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.Ra.top;
  }
  
  public float getMaxCardElevation()
  {
    AppMethodBeat.i(192669);
    float f = QV.a(this.Rc);
    AppMethodBeat.o(192669);
    return f;
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.QX;
  }
  
  public float getRadius()
  {
    AppMethodBeat.i(192626);
    float f = QV.d(this.Rc);
    AppMethodBeat.o(192626);
    return f;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.QW;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192513);
    if (!(QV instanceof b))
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
        AppMethodBeat.o(192513);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(QV.b(this.Rc)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(QV.c(this.Rc)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(192513);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(192551);
    QV.a(this.Rc, ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(192551);
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192564);
    QV.a(this.Rc, paramColorStateList);
    AppMethodBeat.o(192564);
  }
  
  public void setCardElevation(float paramFloat)
  {
    AppMethodBeat.i(192642);
    QV.c(this.Rc, paramFloat);
    AppMethodBeat.o(192642);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192500);
    this.Ra.set(paramInt1, paramInt2, paramInt3, paramInt4);
    QV.f(this.Rc);
    AppMethodBeat.o(192500);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    AppMethodBeat.i(192660);
    QV.b(this.Rc, paramFloat);
    AppMethodBeat.o(192660);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    AppMethodBeat.i(192540);
    this.QZ = paramInt;
    super.setMinimumHeight(paramInt);
    AppMethodBeat.o(192540);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(192526);
    this.QY = paramInt;
    super.setMinimumWidth(paramInt);
    AppMethodBeat.o(192526);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(192689);
    if (paramBoolean != this.QX)
    {
      this.QX = paramBoolean;
      QV.h(this.Rc);
    }
    AppMethodBeat.o(192689);
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(192616);
    QV.a(this.Rc, paramFloat);
    AppMethodBeat.o(192616);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(192487);
    if (this.QW != paramBoolean)
    {
      this.QW = paramBoolean;
      QV.g(this.Rc);
    }
    AppMethodBeat.o(192487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.CardView
 * JD-Core Version:    0.7.0.1
 */