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
  public final ColorStateList iC;
  public final ColorStateList iD;
  public final String iE;
  public final boolean iF;
  public final ColorStateList iG;
  public final float iH;
  public final float iI;
  private final int iJ;
  boolean iK = false;
  Typeface iL;
  public final ColorStateList ii;
  public final float shadowRadius;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.a.TextAppearance);
    this.textSize = localTypedArray.getDimension(0, 0.0F);
    this.ii = a.b(paramContext, localTypedArray, 3);
    this.iC = a.b(paramContext, localTypedArray, 4);
    this.iD = a.b(paramContext, localTypedArray, 5);
    this.textStyle = localTypedArray.getInt(2, 0);
    this.typeface = localTypedArray.getInt(1, 1);
    if (localTypedArray.hasValue(11)) {}
    for (paramInt = i;; paramInt = 10)
    {
      this.iJ = localTypedArray.getResourceId(paramInt, 0);
      this.iE = localTypedArray.getString(paramInt);
      this.iF = localTypedArray.getBoolean(12, false);
      this.iG = a.b(paramContext, localTypedArray, 6);
      this.iH = localTypedArray.getFloat(7, 0.0F);
      this.iI = localTypedArray.getFloat(8, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(9, 0.0F);
      localTypedArray.recycle();
      return;
    }
  }
  
  private Typeface H(Context paramContext)
  {
    Object localObject = null;
    if (this.iK) {
      return this.iL;
    }
    if (!paramContext.isRestricted()) {}
    for (;;)
    {
      try
      {
        i = this.iJ;
        if (!paramContext.isRestricted()) {
          continue;
        }
        paramContext = localObject;
        this.iL = paramContext;
        if (this.iL != null) {
          this.iL = Typeface.create(this.iL, this.textStyle);
        }
      }
      catch (Exception paramContext)
      {
        int i;
        new StringBuilder("Error loading font ").append(this.iE);
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
      bk();
      this.iK = true;
      return this.iL;
      paramContext = f.a(paramContext, i, new TypedValue(), 0, null, false);
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.a parama)
  {
    if (this.iK)
    {
      a(paramTextPaint, this.iL);
      return;
    }
    bk();
    if (paramContext.isRestricted())
    {
      this.iK = true;
      a(paramTextPaint, this.iL);
      return;
    }
    try
    {
      int i = this.iJ;
      paramTextPaint = new f.a()
      {
        public final void D(int paramAnonymousInt)
        {
          b.this.bk();
          b.this.iK = true;
          parama.D(paramAnonymousInt);
        }
        
        public final void a(Typeface paramAnonymousTypeface)
        {
          b.this.iL = Typeface.create(paramAnonymousTypeface, b.this.textStyle);
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.this.iK = true;
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
      new StringBuilder("Error loading font ").append(this.iE);
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
    if (this.ii != null)
    {
      i = this.ii.getColorForState(paramTextPaint.drawableState, this.ii.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.iH;
      f3 = this.iI;
      if (this.iG == null) {
        break label105;
      }
    }
    label105:
    for (int i = this.iG.getColorForState(paramTextPaint.drawableState, this.iG.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      return;
      i = -16777216;
      break;
    }
  }
  
  final void bk()
  {
    if (this.iL == null) {
      this.iL = Typeface.create(this.iE, this.textStyle);
    }
    if (this.iL == null) {
      switch (this.typeface)
      {
      default: 
        this.iL = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.iL != null) {
        this.iL = Typeface.create(this.iL, this.textStyle);
      }
      return;
      this.iL = Typeface.SANS_SERIF;
      continue;
      this.iL = Typeface.SERIF;
      continue;
      this.iL = Typeface.MONOSPACE;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    if (c.iP) {
      a(paramTextPaint, H(paramContext));
    }
    do
    {
      return;
      a(paramContext, paramTextPaint, parama);
    } while (this.iK);
    a(paramTextPaint, this.iL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.d.b
 * JD-Core Version:    0.7.0.1
 */