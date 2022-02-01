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
  private TypedValue ahF;
  public final TypedArray avP;
  private final Context mContext;
  
  private az(Context paramContext, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.avP = paramTypedArray;
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
    paramInt1 = this.avP.getResourceId(paramInt1, 0);
    if (paramInt1 == 0) {
      return null;
    }
    if (this.ahF == null) {
      this.ahF = new TypedValue();
    }
    return f.a(this.mContext, paramInt1, this.ahF, paramInt2, parama);
  }
  
  public final Drawable db(int paramInt)
  {
    if (this.avP.hasValue(paramInt))
    {
      paramInt = this.avP.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return g.iD().b(this.mContext, paramInt, true);
      }
    }
    return null;
  }
  
  public final float dc(int paramInt)
  {
    return this.avP.getDimension(paramInt, 0.0F);
  }
  
  public final boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    return this.avP.getBoolean(paramInt, paramBoolean);
  }
  
  public final int getColor(int paramInt1, int paramInt2)
  {
    return this.avP.getColor(paramInt1, paramInt2);
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    if (this.avP.hasValue(paramInt))
    {
      int i = this.avP.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = a.m(this.mContext, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return this.avP.getColorStateList(paramInt);
  }
  
  public final int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    return this.avP.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    return this.avP.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    if (this.avP.hasValue(paramInt))
    {
      int i = this.avP.getResourceId(paramInt, 0);
      if (i != 0) {
        return a.l(this.mContext, i);
      }
    }
    return this.avP.getDrawable(paramInt);
  }
  
  public final float getFloat(int paramInt, float paramFloat)
  {
    return this.avP.getFloat(paramInt, paramFloat);
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    return this.avP.getInt(paramInt1, paramInt2);
  }
  
  public final int getInteger(int paramInt1, int paramInt2)
  {
    return this.avP.getInteger(paramInt1, paramInt2);
  }
  
  public final int getLayoutDimension(int paramInt1, int paramInt2)
  {
    return this.avP.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int getResourceId(int paramInt1, int paramInt2)
  {
    return this.avP.getResourceId(paramInt1, paramInt2);
  }
  
  public final String getString(int paramInt)
  {
    return this.avP.getString(paramInt);
  }
  
  public final CharSequence getText(int paramInt)
  {
    return this.avP.getText(paramInt);
  }
  
  public final boolean hasValue(int paramInt)
  {
    return this.avP.hasValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.az
 * JD-Core Version:    0.7.0.1
 */