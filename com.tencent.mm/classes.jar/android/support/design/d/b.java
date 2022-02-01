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
  public final String fontFamily;
  private final int lA;
  boolean lB = false;
  Typeface lC;
  public final ColorStateList ld;
  public final ColorStateList lu;
  public final ColorStateList lv;
  public final boolean lw;
  public final ColorStateList lx;
  public final float ly;
  public final float lz;
  public final float shadowRadius;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.a.TextAppearance);
    this.textSize = localTypedArray.getDimension(0, 0.0F);
    this.ld = a.b(paramContext, localTypedArray, 3);
    this.lu = a.b(paramContext, localTypedArray, 4);
    this.lv = a.b(paramContext, localTypedArray, 5);
    this.textStyle = localTypedArray.getInt(2, 0);
    this.typeface = localTypedArray.getInt(1, 1);
    if (localTypedArray.hasValue(11)) {}
    for (paramInt = i;; paramInt = 10)
    {
      this.lA = localTypedArray.getResourceId(paramInt, 0);
      this.fontFamily = localTypedArray.getString(paramInt);
      this.lw = localTypedArray.getBoolean(12, false);
      this.lx = a.b(paramContext, localTypedArray, 6);
      this.ly = localTypedArray.getFloat(7, 0.0F);
      this.lz = localTypedArray.getFloat(8, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(9, 0.0F);
      localTypedArray.recycle();
      return;
    }
  }
  
  private Typeface I(Context paramContext)
  {
    Object localObject = null;
    if (this.lB) {
      return this.lC;
    }
    if (!paramContext.isRestricted()) {}
    for (;;)
    {
      try
      {
        i = this.lA;
        if (!paramContext.isRestricted()) {
          continue;
        }
        paramContext = localObject;
        this.lC = paramContext;
        if (this.lC != null) {
          this.lC = Typeface.create(this.lC, this.textStyle);
        }
      }
      catch (Exception paramContext)
      {
        int i;
        new StringBuilder("Error loading font ").append(this.fontFamily);
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
      bI();
      this.lB = true;
      return this.lC;
      paramContext = f.a(paramContext, i, new TypedValue(), 0, null, false);
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.a parama)
  {
    if (this.lB)
    {
      a(paramTextPaint, this.lC);
      return;
    }
    bI();
    if (paramContext.isRestricted())
    {
      this.lB = true;
      a(paramTextPaint, this.lC);
      return;
    }
    try
    {
      int i = this.lA;
      paramTextPaint = new f.a()
      {
        public final void D(int paramAnonymousInt)
        {
          b.this.bI();
          b.this.lB = true;
          parama.D(paramAnonymousInt);
        }
        
        public final void a(Typeface paramAnonymousTypeface)
        {
          b.this.lC = Typeface.create(paramAnonymousTypeface, b.this.textStyle);
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.this.lB = true;
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
      new StringBuilder("Error loading font ").append(this.fontFamily);
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
    if (this.ld != null)
    {
      i = this.ld.getColorForState(paramTextPaint.drawableState, this.ld.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.ly;
      f3 = this.lz;
      if (this.lx == null) {
        break label105;
      }
    }
    label105:
    for (int i = this.lx.getColorForState(paramTextPaint.drawableState, this.lx.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      return;
      i = -16777216;
      break;
    }
  }
  
  final void bI()
  {
    if (this.lC == null) {
      this.lC = Typeface.create(this.fontFamily, this.textStyle);
    }
    if (this.lC == null) {
      switch (this.typeface)
      {
      default: 
        this.lC = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.lC != null) {
        this.lC = Typeface.create(this.lC, this.textStyle);
      }
      return;
      this.lC = Typeface.SANS_SERIF;
      continue;
      this.lC = Typeface.SERIF;
      continue;
      this.lC = Typeface.MONOSPACE;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    if (c.lG) {
      a(paramTextPaint, I(paramContext));
    }
    do
    {
      return;
      a(paramContext, paramTextPaint, parama);
    } while (this.lB);
    a(paramTextPaint, this.lC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.d.b
 * JD-Core Version:    0.7.0.1
 */