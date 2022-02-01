package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.f;
import android.support.v4.content.a.f.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class az
{
  private TypedValue akD;
  public final TypedArray ayy;
  private final Context mContext;
  
  private az(Context paramContext, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.ayy = paramTypedArray;
  }
  
  public static az a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    return new az(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
  }
  
  public static az a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new az(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static az a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new az(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public final Typeface a(int paramInt1, int paramInt2, f.a parama)
  {
    paramInt1 = this.ayy.getResourceId(paramInt1, 0);
    if (paramInt1 == 0) {
      return null;
    }
    if (this.akD == null) {
      this.akD = new TypedValue();
    }
    return f.a(this.mContext, paramInt1, this.akD, paramInt2, parama);
  }
  
  public final Drawable cU(int paramInt)
  {
    if (this.ayy.hasValue(paramInt))
    {
      paramInt = this.ayy.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return g.jk().b(this.mContext, paramInt, true);
      }
    }
    return null;
  }
  
  public final float cV(int paramInt)
  {
    return this.ayy.getDimension(paramInt, 0.0F);
  }
  
  public final boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    return this.ayy.getBoolean(paramInt, paramBoolean);
  }
  
  public final int getColor(int paramInt1, int paramInt2)
  {
    return this.ayy.getColor(paramInt1, paramInt2);
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    if (this.ayy.hasValue(paramInt))
    {
      int i = this.ayy.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = a.m(this.mContext, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return this.ayy.getColorStateList(paramInt);
  }
  
  public final int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    return this.ayy.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    return this.ayy.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    if (this.ayy.hasValue(paramInt))
    {
      int i = this.ayy.getResourceId(paramInt, 0);
      if (i != 0) {
        return a.l(this.mContext, i);
      }
    }
    return this.ayy.getDrawable(paramInt);
  }
  
  public final float getFloat(int paramInt, float paramFloat)
  {
    return this.ayy.getFloat(paramInt, paramFloat);
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    return this.ayy.getInt(paramInt1, paramInt2);
  }
  
  public final int getInteger(int paramInt1, int paramInt2)
  {
    return this.ayy.getInteger(paramInt1, paramInt2);
  }
  
  public final int getLayoutDimension(int paramInt1, int paramInt2)
  {
    return this.ayy.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int getResourceId(int paramInt1, int paramInt2)
  {
    return this.ayy.getResourceId(paramInt1, paramInt2);
  }
  
  public final String getString(int paramInt)
  {
    return this.ayy.getString(paramInt);
  }
  
  public final CharSequence getText(int paramInt)
  {
    return this.ayy.getText(paramInt);
  }
  
  public final boolean hasValue(int paramInt)
  {
    return this.ayy.hasValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.az
 * JD-Core Version:    0.7.0.1
 */