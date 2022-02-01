package android.support.design.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.a.a;
import android.support.v4.content.a.f;
import android.support.v4.content.a.f.a;
import android.support.v4.e.m;
import android.text.TextPaint;
import android.util.TypedValue;

public final class b
{
  public final ColorStateList jB;
  public final ColorStateList jC;
  public final String jD;
  public final boolean jE;
  public final ColorStateList jF;
  public final float jG;
  public final float jH;
  private final int jI;
  boolean jJ = false;
  Typeface jK;
  public final ColorStateList jk;
  public final float shadowRadius;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.a.TextAppearance);
    this.textSize = localTypedArray.getDimension(0, 0.0F);
    this.jk = a.b(paramContext, localTypedArray, 3);
    this.jB = a.b(paramContext, localTypedArray, 4);
    this.jC = a.b(paramContext, localTypedArray, 5);
    this.textStyle = localTypedArray.getInt(2, 0);
    this.typeface = localTypedArray.getInt(1, 1);
    if (localTypedArray.hasValue(11)) {}
    for (paramInt = i;; paramInt = 10)
    {
      this.jI = localTypedArray.getResourceId(paramInt, 0);
      this.jD = localTypedArray.getString(paramInt);
      this.jE = localTypedArray.getBoolean(12, false);
      this.jF = a.b(paramContext, localTypedArray, 6);
      this.jG = localTypedArray.getFloat(7, 0.0F);
      this.jH = localTypedArray.getFloat(8, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(9, 0.0F);
      localTypedArray.recycle();
      return;
    }
  }
  
  private Typeface H(Context paramContext)
  {
    Object localObject = null;
    if (this.jJ) {
      return this.jK;
    }
    if (!paramContext.isRestricted()) {}
    for (;;)
    {
      try
      {
        i = this.jI;
        if (!paramContext.isRestricted()) {
          continue;
        }
        paramContext = localObject;
        this.jK = paramContext;
        if (this.jK != null) {
          this.jK = Typeface.create(this.jK, this.textStyle);
        }
      }
      catch (Exception paramContext)
      {
        int i;
        new StringBuilder("Error loading font ").append(this.jD);
        continue;
      }
      catch (UnsupportedOperationException paramContext)
      {
        continue;
      }
      catch (Resources.NotFoundException paramContext)
      {
        continue;
      }
      br();
      this.jJ = true;
      return this.jK;
      paramContext = f.a(paramContext, i, new TypedValue(), 0, null, false);
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.a parama)
  {
    if (this.jJ)
    {
      a(paramTextPaint, this.jK);
      return;
    }
    br();
    if (paramContext.isRestricted())
    {
      this.jJ = true;
      a(paramTextPaint, this.jK);
      return;
    }
    try
    {
      int i = this.jI;
      paramTextPaint = new f.a()
      {
        public final void D(int paramAnonymousInt)
        {
          b.this.br();
          b.this.jJ = true;
          parama.D(paramAnonymousInt);
        }
        
        public final void a(Typeface paramAnonymousTypeface)
        {
          b.this.jK = Typeface.create(paramAnonymousTypeface, b.this.textStyle);
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.this.jJ = true;
          parama.a(paramAnonymousTypeface);
        }
      };
      m.checkNotNull(paramTextPaint);
      if (paramContext.isRestricted())
      {
        paramTextPaint.a(-4, null);
        return;
      }
      f.a(paramContext, i, new TypedValue(), 0, paramTextPaint, false);
      return;
    }
    catch (Resources.NotFoundException paramContext) {}catch (Exception paramContext)
    {
      new StringBuilder("Error loading font ").append(this.jD);
      return;
    }
    catch (UnsupportedOperationException paramContext) {}
  }
  
  public final void a(TextPaint paramTextPaint, Typeface paramTypeface)
  {
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.textStyle;
    i = (paramTypeface.getStyle() ^ 0xFFFFFFFF) & i;
    boolean bool;
    if ((i & 0x1) != 0)
    {
      bool = true;
      paramTextPaint.setFakeBoldText(bool);
      if ((i & 0x2) == 0) {
        break label69;
      }
    }
    label69:
    for (float f = -0.25F;; f = 0.0F)
    {
      paramTextPaint.setTextSkewX(f);
      paramTextPaint.setTextSize(this.textSize);
      return;
      bool = false;
      break;
    }
  }
  
  public final void b(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    c(paramContext, paramTextPaint, parama);
    float f1;
    float f2;
    float f3;
    if (this.jk != null)
    {
      i = this.jk.getColorForState(paramTextPaint.drawableState, this.jk.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.jG;
      f3 = this.jH;
      if (this.jF == null) {
        break label105;
      }
    }
    label105:
    for (int i = this.jF.getColorForState(paramTextPaint.drawableState, this.jF.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      return;
      i = -16777216;
      break;
    }
  }
  
  final void br()
  {
    if (this.jK == null) {
      this.jK = Typeface.create(this.jD, this.textStyle);
    }
    if (this.jK == null) {
      switch (this.typeface)
      {
      default: 
        this.jK = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.jK != null) {
        this.jK = Typeface.create(this.jK, this.textStyle);
      }
      return;
      this.jK = Typeface.SANS_SERIF;
      continue;
      this.jK = Typeface.SERIF;
      continue;
      this.jK = Typeface.MONOSPACE;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    if (c.jO) {
      a(paramTextPaint, H(paramContext));
    }
    do
    {
      return;
      a(paramContext, paramTextPaint, parama);
    } while (this.jJ);
    a(paramTextPaint, this.jK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.d.b
 * JD-Core Version:    0.7.0.1
 */