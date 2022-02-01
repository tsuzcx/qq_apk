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
  Typeface lA;
  public final ColorStateList lb;
  public final ColorStateList ls;
  public final ColorStateList lt;
  public final boolean lu;
  public final ColorStateList lv;
  public final float lw;
  public final float lx;
  private final int ly;
  boolean lz = false;
  public final float shadowRadius;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.a.TextAppearance);
    this.textSize = localTypedArray.getDimension(0, 0.0F);
    this.lb = a.b(paramContext, localTypedArray, 3);
    this.ls = a.b(paramContext, localTypedArray, 4);
    this.lt = a.b(paramContext, localTypedArray, 5);
    this.textStyle = localTypedArray.getInt(2, 0);
    this.typeface = localTypedArray.getInt(1, 1);
    if (localTypedArray.hasValue(11)) {}
    for (paramInt = i;; paramInt = 10)
    {
      this.ly = localTypedArray.getResourceId(paramInt, 0);
      this.fontFamily = localTypedArray.getString(paramInt);
      this.lu = localTypedArray.getBoolean(12, false);
      this.lv = a.b(paramContext, localTypedArray, 6);
      this.lw = localTypedArray.getFloat(7, 0.0F);
      this.lx = localTypedArray.getFloat(8, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(9, 0.0F);
      localTypedArray.recycle();
      return;
    }
  }
  
  private Typeface H(Context paramContext)
  {
    Object localObject = null;
    if (this.lz) {
      return this.lA;
    }
    if (!paramContext.isRestricted()) {}
    for (;;)
    {
      try
      {
        i = this.ly;
        if (!paramContext.isRestricted()) {
          continue;
        }
        paramContext = localObject;
        this.lA = paramContext;
        if (this.lA != null) {
          this.lA = Typeface.create(this.lA, this.textStyle);
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
      bG();
      this.lz = true;
      return this.lA;
      paramContext = f.a(paramContext, i, new TypedValue(), 0, null, false);
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.a parama)
  {
    if (this.lz)
    {
      a(paramTextPaint, this.lA);
      return;
    }
    bG();
    if (paramContext.isRestricted())
    {
      this.lz = true;
      a(paramTextPaint, this.lA);
      return;
    }
    try
    {
      int i = this.ly;
      paramTextPaint = new f.a()
      {
        public final void D(int paramAnonymousInt)
        {
          b.this.bG();
          b.this.lz = true;
          parama.D(paramAnonymousInt);
        }
        
        public final void a(Typeface paramAnonymousTypeface)
        {
          b.this.lA = Typeface.create(paramAnonymousTypeface, b.this.textStyle);
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.this.lz = true;
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
    if (this.lb != null)
    {
      i = this.lb.getColorForState(paramTextPaint.drawableState, this.lb.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.lw;
      f3 = this.lx;
      if (this.lv == null) {
        break label105;
      }
    }
    label105:
    for (int i = this.lv.getColorForState(paramTextPaint.drawableState, this.lv.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      return;
      i = -16777216;
      break;
    }
  }
  
  final void bG()
  {
    if (this.lA == null) {
      this.lA = Typeface.create(this.fontFamily, this.textStyle);
    }
    if (this.lA == null) {
      switch (this.typeface)
      {
      default: 
        this.lA = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.lA != null) {
        this.lA = Typeface.create(this.lA, this.textStyle);
      }
      return;
      this.lA = Typeface.SANS_SERIF;
      continue;
      this.lA = Typeface.SERIF;
      continue;
      this.lA = Typeface.MONOSPACE;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    if (c.lE) {
      a(paramTextPaint, H(paramContext));
    }
    do
    {
      return;
      a(paramContext, paramTextPaint, parama);
    } while (this.lz);
    a(paramTextPaint, this.lA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.d.b
 * JD-Core Version:    0.7.0.1
 */