package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class ax
{
  TypedValue ZQ;
  public final TypedArray alZ;
  final Context mContext;
  
  private ax(Context paramContext, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.alZ = paramTypedArray;
  }
  
  public static ax a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    return new ax(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
  }
  
  public static ax a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new ax(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static ax a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new ax(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
  }
  
  public final Drawable cr(int paramInt)
  {
    if (this.alZ.hasValue(paramInt))
    {
      paramInt = this.alZ.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return h.gi().a(this.mContext, paramInt, true);
      }
    }
    return null;
  }
  
  public final boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    return this.alZ.getBoolean(paramInt, paramBoolean);
  }
  
  public final int getColor(int paramInt1, int paramInt2)
  {
    return this.alZ.getColor(paramInt1, paramInt2);
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    if (this.alZ.hasValue(paramInt))
    {
      int i = this.alZ.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = b.h(this.mContext, i);
        if (localColorStateList != null) {
          return localColorStateList;
        }
      }
    }
    return this.alZ.getColorStateList(paramInt);
  }
  
  public final int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    return this.alZ.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    return this.alZ.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    if (this.alZ.hasValue(paramInt))
    {
      int i = this.alZ.getResourceId(paramInt, 0);
      if (i != 0) {
        return b.g(this.mContext, i);
      }
    }
    return this.alZ.getDrawable(paramInt);
  }
  
  public final float getFloat(int paramInt, float paramFloat)
  {
    return this.alZ.getFloat(paramInt, paramFloat);
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    return this.alZ.getInt(paramInt1, paramInt2);
  }
  
  public final int getInteger(int paramInt1, int paramInt2)
  {
    return this.alZ.getInteger(paramInt1, paramInt2);
  }
  
  public final int getLayoutDimension(int paramInt1, int paramInt2)
  {
    return this.alZ.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int getResourceId(int paramInt1, int paramInt2)
  {
    return this.alZ.getResourceId(paramInt1, paramInt2);
  }
  
  public final String getString(int paramInt)
  {
    return this.alZ.getString(paramInt);
  }
  
  public final CharSequence getText(int paramInt)
  {
    return this.alZ.getText(paramInt);
  }
  
  public final boolean hasValue(int paramInt)
  {
    return this.alZ.hasValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ax
 * JD-Core Version:    0.7.0.1
 */