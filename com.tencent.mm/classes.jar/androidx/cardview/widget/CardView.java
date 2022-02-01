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
  private static final int[] yF;
  private static final e yG;
  private boolean yH;
  private boolean yI;
  int yJ;
  int yK;
  final Rect yL;
  final Rect yM;
  private final d yN;
  
  static
  {
    AppMethodBeat.i(188114);
    yF = new int[] { 16842801 };
    if (Build.VERSION.SDK_INT >= 21) {
      yG = new b();
    }
    for (;;)
    {
      yG.initStatic();
      AppMethodBeat.o(188114);
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        yG = new a();
      } else {
        yG = new c();
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
    AppMethodBeat.i(188027);
    this.yL = new Rect();
    this.yM = new Rect();
    this.yN = new d()
    {
      private Drawable yO;
      
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(188015);
        CardView.this.yM.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        CardView localCardView = CardView.this;
        CardView.a(localCardView, localCardView.yL.left + paramAnonymousInt1, CardView.this.yL.top + paramAnonymousInt2, CardView.this.yL.right + paramAnonymousInt3, CardView.this.yL.bottom + paramAnonymousInt4);
        AppMethodBeat.o(188015);
      }
      
      public final Drawable eV()
      {
        return this.yO;
      }
      
      public final View eW()
      {
        return CardView.this;
      }
      
      public final boolean getPreventCornerOverlap()
      {
        AppMethodBeat.i(188013);
        boolean bool = CardView.this.getPreventCornerOverlap();
        AppMethodBeat.o(188013);
        return bool;
      }
      
      public final boolean getUseCompatPadding()
      {
        AppMethodBeat.i(188008);
        boolean bool = CardView.this.getUseCompatPadding();
        AppMethodBeat.o(188008);
        return bool;
      }
      
      public final void j(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(188005);
        this.yO = paramAnonymousDrawable;
        CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
        AppMethodBeat.o(188005);
      }
      
      public final void s(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(188016);
        if (paramAnonymousInt1 > CardView.this.yJ) {
          CardView.a(CardView.this, paramAnonymousInt1);
        }
        if (paramAnonymousInt2 > CardView.this.yK) {
          CardView.b(CardView.this, paramAnonymousInt2);
        }
        AppMethodBeat.o(188016);
      }
    };
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.e.CardView, paramInt, a.d.CardView);
    if (localTypedArray.hasValue(a.e.CardView_cardBackgroundColor))
    {
      paramAttributeSet = localTypedArray.getColorStateList(a.e.CardView_cardBackgroundColor);
      float f4 = localTypedArray.getDimension(a.e.CardView_cardCornerRadius, 0.0F);
      float f2 = localTypedArray.getDimension(a.e.CardView_cardElevation, 0.0F);
      float f3 = localTypedArray.getDimension(a.e.CardView_cardMaxElevation, 0.0F);
      this.yH = localTypedArray.getBoolean(a.e.CardView_cardUseCompatPadding, false);
      this.yI = localTypedArray.getBoolean(a.e.CardView_cardPreventCornerOverlap, true);
      paramInt = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPadding, 0);
      this.yL.left = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingLeft, paramInt);
      this.yL.top = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingTop, paramInt);
      this.yL.right = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingRight, paramInt);
      this.yL.bottom = localTypedArray.getDimensionPixelSize(a.e.CardView_contentPaddingBottom, paramInt);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.yJ = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minWidth, 0);
      this.yK = localTypedArray.getDimensionPixelSize(a.e.CardView_android_minHeight, 0);
      localTypedArray.recycle();
      yG.a(this.yN, paramContext, paramAttributeSet, f4, f2, f1);
      AppMethodBeat.o(188027);
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(yF);
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
    AppMethodBeat.i(188072);
    ColorStateList localColorStateList = yG.i(this.yN);
    AppMethodBeat.o(188072);
    return localColorStateList;
  }
  
  public float getCardElevation()
  {
    AppMethodBeat.i(188096);
    float f = yG.e(this.yN);
    AppMethodBeat.o(188096);
    return f;
  }
  
  public int getContentPaddingBottom()
  {
    return this.yL.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.yL.left;
  }
  
  public int getContentPaddingRight()
  {
    return this.yL.right;
  }
  
  public int getContentPaddingTop()
  {
    return this.yL.top;
  }
  
  public float getMaxCardElevation()
  {
    AppMethodBeat.i(188102);
    float f = yG.a(this.yN);
    AppMethodBeat.o(188102);
    return f;
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.yI;
  }
  
  public float getRadius()
  {
    AppMethodBeat.i(188084);
    float f = yG.d(this.yN);
    AppMethodBeat.o(188084);
    return f;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.yH;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188044);
    if (!(yG instanceof b))
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
        AppMethodBeat.o(188044);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(yG.b(this.yN)), View.MeasureSpec.getSize(paramInt1)), i);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(yG.c(this.yN)), View.MeasureSpec.getSize(paramInt2)), i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(188044);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(188064);
    yG.a(this.yN, ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(188064);
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188067);
    yG.a(this.yN, paramColorStateList);
    AppMethodBeat.o(188067);
  }
  
  public void setCardElevation(float paramFloat)
  {
    AppMethodBeat.i(188088);
    yG.c(this.yN, paramFloat);
    AppMethodBeat.o(188088);
  }
  
  public final void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(188038);
    this.yL.set(paramInt1, paramInt2, paramInt3, paramInt4);
    yG.f(this.yN);
    AppMethodBeat.o(188038);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    AppMethodBeat.i(188099);
    yG.b(this.yN, paramFloat);
    AppMethodBeat.o(188099);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    AppMethodBeat.i(188062);
    this.yK = paramInt;
    super.setMinimumHeight(paramInt);
    AppMethodBeat.o(188062);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(188056);
    this.yJ = paramInt;
    super.setMinimumWidth(paramInt);
    AppMethodBeat.o(188056);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    AppMethodBeat.i(188106);
    if (paramBoolean != this.yI)
    {
      this.yI = paramBoolean;
      yG.h(this.yN);
    }
    AppMethodBeat.o(188106);
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(188082);
    yG.a(this.yN, paramFloat);
    AppMethodBeat.o(188082);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(188031);
    if (this.yH != paramBoolean)
    {
      this.yH = paramBoolean;
      yG.g(this.yN);
    }
    AppMethodBeat.o(188031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.CardView
 * JD-Core Version:    0.7.0.1
 */